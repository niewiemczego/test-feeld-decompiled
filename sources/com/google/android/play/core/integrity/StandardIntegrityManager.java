package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
public interface StandardIntegrityManager {

    /* compiled from: com.google.android.play:integrity@@1.2.0 */
    public static abstract class PrepareIntegrityTokenRequest {

        /* compiled from: com.google.android.play:integrity@@1.2.0 */
        public static abstract class Builder {
            public abstract PrepareIntegrityTokenRequest build();

            public abstract Builder setCloudProjectNumber(long j);
        }

        public static Builder builder() {
            return new f();
        }

        public abstract long a();
    }

    /* compiled from: com.google.android.play:integrity@@1.2.0 */
    public static abstract class StandardIntegrityToken {
        public abstract String token();
    }

    /* compiled from: com.google.android.play:integrity@@1.2.0 */
    public interface StandardIntegrityTokenProvider {
        Task<StandardIntegrityToken> request(StandardIntegrityTokenRequest standardIntegrityTokenRequest);
    }

    /* compiled from: com.google.android.play:integrity@@1.2.0 */
    public static abstract class StandardIntegrityTokenRequest {

        /* compiled from: com.google.android.play:integrity@@1.2.0 */
        public static abstract class Builder {
            public abstract StandardIntegrityTokenRequest build();

            public abstract Builder setRequestHash(String str);
        }

        public static Builder builder() {
            return new i();
        }

        public abstract String a();
    }

    Task<StandardIntegrityTokenProvider> prepareIntegrityToken(PrepareIntegrityTokenRequest prepareIntegrityTokenRequest);
}
