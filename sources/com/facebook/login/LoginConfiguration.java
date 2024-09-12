package com.facebook.login;

import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB!\b\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006B+\b\u0016\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/facebook/login/LoginConfiguration;", "", "permissions", "", "", "nonce", "(Ljava/util/Collection;Ljava/lang/String;)V", "codeVerifier", "(Ljava/util/Collection;Ljava/lang/String;Ljava/lang/String;)V", "getCodeVerifier", "()Ljava/lang/String;", "getNonce", "", "getPermissions", "()Ljava/util/Set;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LoginConfiguration.kt */
public final class LoginConfiguration {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String OPENID = "openid";
    private final String codeVerifier;
    private final String nonce;
    private final Set<String> permissions;

    public LoginConfiguration(Collection<String> collection) {
        this(collection, (String) null, 2, (DefaultConstructorMarker) null);
    }

    public final Set<String> getPermissions() {
        return this.permissions;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final String getCodeVerifier() {
        return this.codeVerifier;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LoginConfiguration(java.util.Collection r1, java.lang.String r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0011
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "randomUUID().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
        L_0x0011:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginConfiguration.<init>(java.util.Collection, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LoginConfiguration(Collection<String> collection, String str) {
        this(collection, str, PKCEUtil.generateCodeVerifier());
        Intrinsics.checkNotNullParameter(str, "nonce");
        PKCEUtil pKCEUtil = PKCEUtil.INSTANCE;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LoginConfiguration(java.util.Collection r1, java.lang.String r2, java.lang.String r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 1
            if (r5 == 0) goto L_0x0005
            r1 = 0
        L_0x0005:
            r4 = r4 & 2
            if (r4 == 0) goto L_0x0016
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "randomUUID().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
        L_0x0016:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginConfiguration.<init>(java.util.Collection, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LoginConfiguration(java.util.Collection<java.lang.String> r2, java.lang.String r3, java.lang.String r4) {
        /*
            r1 = this;
            java.lang.String r0 = "nonce"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "codeVerifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r1.<init>()
            com.facebook.login.NonceUtil r0 = com.facebook.login.NonceUtil.INSTANCE
            boolean r0 = com.facebook.login.NonceUtil.isValidNonce(r3)
            if (r0 == 0) goto L_0x001f
            com.facebook.login.PKCEUtil r0 = com.facebook.login.PKCEUtil.INSTANCE
            boolean r0 = com.facebook.login.PKCEUtil.isValidCodeVerifier(r4)
            if (r0 == 0) goto L_0x001f
            r0 = 1
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            if (r0 == 0) goto L_0x0044
            java.util.HashSet r0 = new java.util.HashSet
            if (r2 == 0) goto L_0x002a
            r0.<init>(r2)
            goto L_0x002d
        L_0x002a:
            r0.<init>()
        L_0x002d:
            java.lang.String r2 = "openid"
            r0.add(r2)
            java.util.Set r0 = (java.util.Set) r0
            java.util.Set r2 = java.util.Collections.unmodifiableSet(r0)
            java.lang.String r0 = "unmodifiableSet(permissions)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            r1.permissions = r2
            r1.nonce = r3
            r1.codeVerifier = r4
            return
        L_0x0044:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Failed requirement."
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginConfiguration.<init>(java.util.Collection, java.lang.String, java.lang.String):void");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/login/LoginConfiguration$Companion;", "", "()V", "OPENID", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LoginConfiguration.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
