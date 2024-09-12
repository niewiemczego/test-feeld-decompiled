package com.facebook.appevents.aam;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB%\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058F¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/aam/MetadataRule;", "", "name", "", "keyRules", "", "valRule", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getKeyRules", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getValRule", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: MetadataRule.kt */
public final class MetadataRule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FIELD_K = "k";
    private static final String FIELD_K_DELIMITER = ",";
    private static final String FIELD_V = "v";
    private static final Set<MetadataRule> rules = new CopyOnWriteArraySet();
    private final List<String> keyRules;
    private final String name;
    private final String valRule;

    public /* synthetic */ MetadataRule(String str, List list, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, str2);
    }

    @JvmStatic
    public static final Set<String> getEnabledRuleNames() {
        Class<MetadataRule> cls = MetadataRule.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Companion.getEnabledRuleNames();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final Set<MetadataRule> getRules() {
        Class<MetadataRule> cls = MetadataRule.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Companion.getRules();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final void updateRules(String str) {
        Class<MetadataRule> cls = MetadataRule.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Companion.updateRules(str);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private MetadataRule(String str, List<String> list, String str2) {
        this.name = str;
        this.valRule = str2;
        this.keyRules = list;
    }

    public static final /* synthetic */ Set access$getRules$cp() {
        Class<MetadataRule> cls = MetadataRule.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return rules;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public final String getName() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.name;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final String getValRule() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.valRule;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0007J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u0007J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/aam/MetadataRule$Companion;", "", "()V", "FIELD_K", "", "FIELD_K_DELIMITER", "FIELD_V", "rules", "", "Lcom/facebook/appevents/aam/MetadataRule;", "constructRules", "", "jsonObject", "Lorg/json/JSONObject;", "getEnabledRuleNames", "", "getRules", "updateRules", "rulesFromServer", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: MetadataRule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Set<MetadataRule> getRules() {
            return new HashSet<>(MetadataRule.access$getRules$cp());
        }

        @JvmStatic
        public final void updateRules(String str) {
            Intrinsics.checkNotNullParameter(str, "rulesFromServer");
            try {
                MetadataRule.access$getRules$cp().clear();
                constructRules(new JSONObject(str));
            } catch (JSONException unused) {
            }
        }

        @JvmStatic
        public final Set<String> getEnabledRuleNames() {
            Set<String> hashSet = new HashSet<>();
            for (MetadataRule name : MetadataRule.access$getRules$cp()) {
                hashSet.add(name.getName());
            }
            return hashSet;
        }

        private final void constructRules(JSONObject jSONObject) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(MetadataRule.FIELD_K);
                    String optString2 = optJSONObject.optString(MetadataRule.FIELD_V);
                    Intrinsics.checkNotNullExpressionValue(optString, MetadataRule.FIELD_K);
                    CharSequence charSequence = optString;
                    if (!(charSequence.length() == 0)) {
                        Set access$getRules$cp = MetadataRule.access$getRules$cp();
                        Intrinsics.checkNotNullExpressionValue(next, "key");
                        List split$default = StringsKt.split$default(charSequence, new String[]{MetadataRule.FIELD_K_DELIMITER}, false, 0, 6, (Object) null);
                        Intrinsics.checkNotNullExpressionValue(optString2, MetadataRule.FIELD_V);
                        access$getRules$cp.add(new MetadataRule(next, split$default, optString2, (DefaultConstructorMarker) null));
                    }
                }
            }
        }
    }

    public final List<String> getKeyRules() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return new ArrayList<>(this.keyRules);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
