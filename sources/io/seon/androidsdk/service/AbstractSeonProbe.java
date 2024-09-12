package io.seon.androidsdk.service;

import io.seon.androidsdk.logger.Logger;

abstract class AbstractSeonProbe implements SeonProbe {
    private static final Logger LOG = Logger.withClass(AbstractSeonProbe.class);

    AbstractSeonProbe() {
    }

    /* access modifiers changed from: package-private */
    public <T> T safeGet(SafeSupplier<T> safeSupplier) {
        try {
            return safeSupplier.a();
        } catch (Exception e) {
            LOG.withCause(e);
            return null;
        }
    }
}
