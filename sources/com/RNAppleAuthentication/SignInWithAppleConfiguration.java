package com.RNAppleAuthentication;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.faye.internal.Bayeux;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0003!\"#B?\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006$"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;", "", "clientId", "", "redirectUri", "scope", "responseType", "state", "rawNonce", "nonce", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getNonce", "getRawNonce", "getRedirectUri", "getResponseType", "getScope", "getState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "Builder", "ResponseType", "Scope", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SignInWithAppleConfiguration.kt */
public final class SignInWithAppleConfiguration {
    private final String clientId;
    private final String nonce;
    private final String rawNonce;
    private final String redirectUri;
    private final String responseType;
    private final String scope;
    private final String state;

    public /* synthetic */ SignInWithAppleConfiguration(String str, String str2, String str3, String str4, String str5, String str6, String str7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7);
    }

    public static /* synthetic */ SignInWithAppleConfiguration copy$default(SignInWithAppleConfiguration signInWithAppleConfiguration, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = signInWithAppleConfiguration.clientId;
        }
        if ((i & 2) != 0) {
            str2 = signInWithAppleConfiguration.redirectUri;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = signInWithAppleConfiguration.scope;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = signInWithAppleConfiguration.responseType;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = signInWithAppleConfiguration.state;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = signInWithAppleConfiguration.rawNonce;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = signInWithAppleConfiguration.nonce;
        }
        return signInWithAppleConfiguration.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.clientId;
    }

    public final String component2() {
        return this.redirectUri;
    }

    public final String component3() {
        return this.scope;
    }

    public final String component4() {
        return this.responseType;
    }

    public final String component5() {
        return this.state;
    }

    public final String component6() {
        return this.rawNonce;
    }

    public final String component7() {
        return this.nonce;
    }

    public final SignInWithAppleConfiguration copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, Bayeux.KEY_CLIENT_ID);
        Intrinsics.checkNotNullParameter(str2, "redirectUri");
        Intrinsics.checkNotNullParameter(str3, "scope");
        Intrinsics.checkNotNullParameter(str4, "responseType");
        Intrinsics.checkNotNullParameter(str5, "state");
        Intrinsics.checkNotNullParameter(str6, "rawNonce");
        String str8 = str7;
        Intrinsics.checkNotNullParameter(str8, "nonce");
        return new SignInWithAppleConfiguration(str, str2, str3, str4, str5, str6, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignInWithAppleConfiguration)) {
            return false;
        }
        SignInWithAppleConfiguration signInWithAppleConfiguration = (SignInWithAppleConfiguration) obj;
        return Intrinsics.areEqual((Object) this.clientId, (Object) signInWithAppleConfiguration.clientId) && Intrinsics.areEqual((Object) this.redirectUri, (Object) signInWithAppleConfiguration.redirectUri) && Intrinsics.areEqual((Object) this.scope, (Object) signInWithAppleConfiguration.scope) && Intrinsics.areEqual((Object) this.responseType, (Object) signInWithAppleConfiguration.responseType) && Intrinsics.areEqual((Object) this.state, (Object) signInWithAppleConfiguration.state) && Intrinsics.areEqual((Object) this.rawNonce, (Object) signInWithAppleConfiguration.rawNonce) && Intrinsics.areEqual((Object) this.nonce, (Object) signInWithAppleConfiguration.nonce);
    }

    public int hashCode() {
        return (((((((((((this.clientId.hashCode() * 31) + this.redirectUri.hashCode()) * 31) + this.scope.hashCode()) * 31) + this.responseType.hashCode()) * 31) + this.state.hashCode()) * 31) + this.rawNonce.hashCode()) * 31) + this.nonce.hashCode();
    }

    public String toString() {
        return "SignInWithAppleConfiguration(clientId=" + this.clientId + ", redirectUri=" + this.redirectUri + ", scope=" + this.scope + ", responseType=" + this.responseType + ", state=" + this.state + ", rawNonce=" + this.rawNonce + ", nonce=" + this.nonce + ')';
    }

    private SignInWithAppleConfiguration(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.clientId = str;
        this.redirectUri = str2;
        this.scope = str3;
        this.responseType = str4;
        this.state = str5;
        this.rawNonce = str6;
        this.nonce = str7;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getRedirectUri() {
        return this.redirectUri;
    }

    public final String getScope() {
        return this.scope;
    }

    public final String getResponseType() {
        return this.responseType;
    }

    public final String getState() {
        return this.state;
    }

    public final String getRawNonce() {
        return this.rawNonce;
    }

    public final String getNonce() {
        return this.nonce;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000fJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Builder;", "", "()V", "clientId", "", "nonce", "rawNonce", "redirectUri", "responseType", "scope", "state", "build", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;", "type", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SignInWithAppleConfiguration.kt */
    public static final class Builder {
        private String clientId;
        private String nonce;
        private String rawNonce;
        private String redirectUri;
        private String responseType;
        private String scope;
        private String state;

        public final Builder clientId(String str) {
            Intrinsics.checkNotNullParameter(str, Bayeux.KEY_CLIENT_ID);
            Builder builder = this;
            this.clientId = str;
            return this;
        }

        public final Builder redirectUri(String str) {
            Intrinsics.checkNotNullParameter(str, "redirectUri");
            Builder builder = this;
            this.redirectUri = str;
            return this;
        }

        public final Builder scope(Scope scope2) {
            Intrinsics.checkNotNullParameter(scope2, "scope");
            Builder builder = this;
            this.scope = scope2.signal();
            return this;
        }

        public final Builder responseType(ResponseType responseType2) {
            Intrinsics.checkNotNullParameter(responseType2, "type");
            Builder builder = this;
            this.responseType = responseType2.signal();
            return this;
        }

        public final Builder state(String str) {
            Intrinsics.checkNotNullParameter(str, "state");
            Builder builder = this;
            this.state = str;
            return this;
        }

        public final Builder rawNonce(String str) {
            Intrinsics.checkNotNullParameter(str, "rawNonce");
            Builder builder = this;
            this.rawNonce = str;
            return this;
        }

        public final Builder nonce(String str) {
            Intrinsics.checkNotNullParameter(str, "nonce");
            Builder builder = this;
            this.nonce = str;
            return this;
        }

        public final SignInWithAppleConfiguration build() {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8 = this.clientId;
            if (str8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Bayeux.KEY_CLIENT_ID);
                str = null;
            } else {
                str = str8;
            }
            String str9 = this.redirectUri;
            if (str9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("redirectUri");
                str2 = null;
            } else {
                str2 = str9;
            }
            String str10 = this.scope;
            if (str10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scope");
                str3 = null;
            } else {
                str3 = str10;
            }
            String str11 = this.responseType;
            if (str11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("responseType");
                str4 = null;
            } else {
                str4 = str11;
            }
            String str12 = this.state;
            if (str12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("state");
                str5 = null;
            } else {
                str5 = str12;
            }
            String str13 = this.rawNonce;
            if (str13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rawNonce");
                str6 = null;
            } else {
                str6 = str13;
            }
            String str14 = this.nonce;
            if (str14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nonce");
                str7 = null;
            } else {
                str7 = str14;
            }
            return new SignInWithAppleConfiguration(str, str2, str3, str4, str5, str6, str7, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "", "(Ljava/lang/String;I)V", "signal", "", "CODE", "ID_TOKEN", "ALL", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SignInWithAppleConfiguration.kt */
    public enum ResponseType {
        ;

        public abstract String signal();

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType$CODE;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: SignInWithAppleConfiguration.kt */
        static final class CODE extends ResponseType {
            public String signal() {
                return "code";
            }

            CODE(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType$ID_TOKEN;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: SignInWithAppleConfiguration.kt */
        static final class ID_TOKEN extends ResponseType {
            public String signal() {
                return "id_token";
            }

            ID_TOKEN(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType$ALL;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: SignInWithAppleConfiguration.kt */
        static final class ALL extends ResponseType {
            public String signal() {
                return "code id_token";
            }

            ALL(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "", "(Ljava/lang/String;I)V", "signal", "", "NAME", "EMAIL", "ALL", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SignInWithAppleConfiguration.kt */
    public enum Scope {
        ;

        public abstract String signal();

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope$NAME;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: SignInWithAppleConfiguration.kt */
        static final class NAME extends Scope {
            public String signal() {
                return "name";
            }

            NAME(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope$EMAIL;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: SignInWithAppleConfiguration.kt */
        static final class EMAIL extends Scope {
            public String signal() {
                return "email";
            }

            EMAIL(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope$ALL;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: SignInWithAppleConfiguration.kt */
        static final class ALL extends Scope {
            public String signal() {
                return "name email";
            }

            ALL(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }
        }
    }
}
