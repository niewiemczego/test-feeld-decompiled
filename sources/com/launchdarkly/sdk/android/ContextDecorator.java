package com.launchdarkly.sdk.android;

import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.sdk.ContextKind;
import com.launchdarkly.sdk.ContextMultiBuilder;
import com.launchdarkly.sdk.LDContext;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

final class ContextDecorator {
    private static final String GENERATED_KEY_SHARED_PREFS_PREFIX = "anon-key-";
    private Map<ContextKind, String> cachedGeneratedKey = new HashMap();
    private final boolean generateAnonymousKeys;
    private Object generatedKeyLock = new Object();
    /* access modifiers changed from: private */
    public final PersistentDataStoreWrapper persistentData;

    public ContextDecorator(PersistentDataStoreWrapper persistentDataStoreWrapper, boolean z) {
        this.persistentData = persistentDataStoreWrapper;
        this.generateAnonymousKeys = z;
    }

    public LDContext decorateContext(LDContext lDContext, LDLogger lDLogger) {
        boolean z;
        if (!this.generateAnonymousKeys) {
            return lDContext;
        }
        if (!lDContext.isMultiple()) {
            return lDContext.isAnonymous() ? singleKindContextWithGeneratedKey(lDContext, lDLogger) : lDContext;
        }
        int i = 0;
        while (true) {
            if (i >= lDContext.getIndividualContextCount()) {
                z = false;
                break;
            } else if (lDContext.getIndividualContext(i).isAnonymous()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            return lDContext;
        }
        ContextMultiBuilder multiBuilder = LDContext.multiBuilder();
        for (int i2 = 0; i2 < lDContext.getIndividualContextCount(); i2++) {
            LDContext individualContext = lDContext.getIndividualContext(i2);
            if (individualContext.isAnonymous()) {
                individualContext = singleKindContextWithGeneratedKey(individualContext, lDLogger);
            }
            multiBuilder.add(individualContext);
        }
        return multiBuilder.build();
    }

    private LDContext singleKindContextWithGeneratedKey(LDContext lDContext, LDLogger lDLogger) {
        return LDContext.builderFromContext(lDContext).key(getOrCreateAutoContextKey(lDContext.getKind(), lDLogger)).build();
    }

    private String getOrCreateAutoContextKey(final ContextKind contextKind, LDLogger lDLogger) {
        synchronized (this.generatedKeyLock) {
            String str = this.cachedGeneratedKey.get(contextKind);
            if (str != null) {
                return str;
            }
            String generatedContextKey = this.persistentData.getGeneratedContextKey(contextKind);
            if (generatedContextKey != null) {
                this.cachedGeneratedKey.put(contextKind, generatedContextKey);
                return generatedContextKey;
            }
            final String uuid = UUID.randomUUID().toString();
            this.cachedGeneratedKey.put(contextKind, uuid);
            lDLogger.info("Did not find a generated anonymous key for context kind \"{}\". Generating a new one: {}", contextKind, uuid);
            new Thread(new Runnable() {
                public void run() {
                    ContextDecorator.this.persistentData.setGeneratedContextKey(contextKind, uuid);
                }
            }).run();
            return uuid;
        }
    }
}
