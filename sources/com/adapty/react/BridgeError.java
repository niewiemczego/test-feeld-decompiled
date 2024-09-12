package com.adapty.react;

import com.adapty.internal.crossplatform.CrossplatformHelper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\n\u000b\f\r\u000e\u000fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0001\u0005\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/adapty/react/BridgeError;", "", "()V", "description", "", "getDescription", "()Ljava/lang/String;", "helper", "Lcom/adapty/internal/crossplatform/CrossplatformHelper$Companion;", "toJson", "EncodingFailed", "MethodNotImplemented", "MissingRequiredArgument", "SerializedBridgeError", "TypeMismatch", "UnexpectedError", "Lcom/adapty/react/BridgeError$EncodingFailed;", "Lcom/adapty/react/BridgeError$MethodNotImplemented;", "Lcom/adapty/react/BridgeError$MissingRequiredArgument;", "Lcom/adapty/react/BridgeError$TypeMismatch;", "Lcom/adapty/react/BridgeError$UnexpectedError;", "react-native-adapty_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BridgeError.kt */
public abstract class BridgeError extends Throwable {
    private final CrossplatformHelper.Companion helper;

    public /* synthetic */ BridgeError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getDescription();

    private BridgeError() {
        this.helper = CrossplatformHelper.Companion;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/adapty/react/BridgeError$SerializedBridgeError;", "", "errorType", "", "name", "type", "underlyingError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getErrorType", "()Ljava/lang/String;", "getName", "getType", "getUnderlyingError", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "react-native-adapty_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BridgeError.kt */
    private static final class SerializedBridgeError {
        private final String errorType;
        private final String name;
        private final String type;
        private final String underlyingError;

        public static /* synthetic */ SerializedBridgeError copy$default(SerializedBridgeError serializedBridgeError, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = serializedBridgeError.errorType;
            }
            if ((i & 2) != 0) {
                str2 = serializedBridgeError.name;
            }
            if ((i & 4) != 0) {
                str3 = serializedBridgeError.type;
            }
            if ((i & 8) != 0) {
                str4 = serializedBridgeError.underlyingError;
            }
            return serializedBridgeError.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.errorType;
        }

        public final String component2() {
            return this.name;
        }

        public final String component3() {
            return this.type;
        }

        public final String component4() {
            return this.underlyingError;
        }

        public final SerializedBridgeError copy(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "errorType");
            return new SerializedBridgeError(str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SerializedBridgeError)) {
                return false;
            }
            SerializedBridgeError serializedBridgeError = (SerializedBridgeError) obj;
            return Intrinsics.areEqual((Object) this.errorType, (Object) serializedBridgeError.errorType) && Intrinsics.areEqual((Object) this.name, (Object) serializedBridgeError.name) && Intrinsics.areEqual((Object) this.type, (Object) serializedBridgeError.type) && Intrinsics.areEqual((Object) this.underlyingError, (Object) serializedBridgeError.underlyingError);
        }

        public int hashCode() {
            int hashCode = this.errorType.hashCode() * 31;
            String str = this.name;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.type;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.underlyingError;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "SerializedBridgeError(errorType=" + this.errorType + ", name=" + this.name + ", type=" + this.type + ", underlyingError=" + this.underlyingError + ')';
        }

        public SerializedBridgeError(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "errorType");
            this.errorType = str;
            this.name = str2;
            this.type = str3;
            this.underlyingError = str4;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SerializedBridgeError(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
        }

        public final String getErrorType() {
            return this.errorType;
        }

        public final String getName() {
            return this.name;
        }

        public final String getType() {
            return this.type;
        }

        public final String getUnderlyingError() {
            return this.underlyingError;
        }
    }

    public final String toJson() {
        SerializedBridgeError serializedBridgeError;
        if (this instanceof MissingRequiredArgument) {
            serializedBridgeError = new SerializedBridgeError("missingRequiredArgument", ((MissingRequiredArgument) this).getName().getValue(), (String) null, (String) null, 12, (DefaultConstructorMarker) null);
        } else if (this instanceof TypeMismatch) {
            TypeMismatch typeMismatch = (TypeMismatch) this;
            serializedBridgeError = new SerializedBridgeError("typeMismatch", typeMismatch.getName().getValue(), typeMismatch.getType(), (String) null, 8, (DefaultConstructorMarker) null);
        } else if (this instanceof EncodingFailed) {
            serializedBridgeError = new SerializedBridgeError("encodingFailed", (String) null, (String) null, ((EncodingFailed) this).getUnderlyingError().getLocalizedMessage(), 6, (DefaultConstructorMarker) null);
        } else if (this instanceof MethodNotImplemented) {
            serializedBridgeError = new SerializedBridgeError("methodNotImplemented", (String) null, (String) null, (String) null, 14, (DefaultConstructorMarker) null);
        } else if (this instanceof UnexpectedError) {
            serializedBridgeError = new SerializedBridgeError("unexpectedError", (String) null, (String) null, ((UnexpectedError) this).getUnderlyingError().getLocalizedMessage(), 6, (DefaultConstructorMarker) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        String json = this.helper.getShared().toJson(serializedBridgeError);
        Intrinsics.checkNotNullExpressionValue(json, "helper.shared.toJson(serialized)");
        return json;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/adapty/react/BridgeError$MissingRequiredArgument;", "Lcom/adapty/react/BridgeError;", "name", "Lcom/adapty/react/ParamKey;", "(Lcom/adapty/react/ParamKey;)V", "description", "", "getDescription", "()Ljava/lang/String;", "getName", "()Lcom/adapty/react/ParamKey;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "react-native-adapty_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BridgeError.kt */
    public static final class MissingRequiredArgument extends BridgeError {
        private final ParamKey name;

        public static /* synthetic */ MissingRequiredArgument copy$default(MissingRequiredArgument missingRequiredArgument, ParamKey paramKey, int i, Object obj) {
            if ((i & 1) != 0) {
                paramKey = missingRequiredArgument.name;
            }
            return missingRequiredArgument.copy(paramKey);
        }

        public final ParamKey component1() {
            return this.name;
        }

        public final MissingRequiredArgument copy(ParamKey paramKey) {
            Intrinsics.checkNotNullParameter(paramKey, "name");
            return new MissingRequiredArgument(paramKey);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MissingRequiredArgument) && this.name == ((MissingRequiredArgument) obj).name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "MissingRequiredArgument(name=" + this.name + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MissingRequiredArgument(ParamKey paramKey) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(paramKey, "name");
            this.name = paramKey;
        }

        public final ParamKey getName() {
            return this.name;
        }

        public String getDescription() {
            return "Missing required argument: " + this.name.getValue() + '.';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/adapty/react/BridgeError$TypeMismatch;", "Lcom/adapty/react/BridgeError;", "name", "Lcom/adapty/react/ParamKey;", "type", "", "(Lcom/adapty/react/ParamKey;Ljava/lang/String;)V", "description", "getDescription", "()Ljava/lang/String;", "getName", "()Lcom/adapty/react/ParamKey;", "getType", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "react-native-adapty_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BridgeError.kt */
    public static final class TypeMismatch extends BridgeError {
        private final ParamKey name;
        private final String type;

        public static /* synthetic */ TypeMismatch copy$default(TypeMismatch typeMismatch, ParamKey paramKey, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                paramKey = typeMismatch.name;
            }
            if ((i & 2) != 0) {
                str = typeMismatch.type;
            }
            return typeMismatch.copy(paramKey, str);
        }

        public final ParamKey component1() {
            return this.name;
        }

        public final String component2() {
            return this.type;
        }

        public final TypeMismatch copy(ParamKey paramKey, String str) {
            Intrinsics.checkNotNullParameter(paramKey, "name");
            Intrinsics.checkNotNullParameter(str, "type");
            return new TypeMismatch(paramKey, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TypeMismatch)) {
                return false;
            }
            TypeMismatch typeMismatch = (TypeMismatch) obj;
            return this.name == typeMismatch.name && Intrinsics.areEqual((Object) this.type, (Object) typeMismatch.type);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.type.hashCode();
        }

        public String toString() {
            return "TypeMismatch(name=" + this.name + ", type=" + this.type + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TypeMismatch(ParamKey paramKey, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(paramKey, "name");
            Intrinsics.checkNotNullParameter(str, "type");
            this.name = paramKey;
            this.type = str;
        }

        public final ParamKey getName() {
            return this.name;
        }

        public final String getType() {
            return this.type;
        }

        public String getDescription() {
            return "Type mismatch for argument " + this.name.getValue() + ". Expected type " + this.type + '.';
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/adapty/react/BridgeError$EncodingFailed;", "Lcom/adapty/react/BridgeError;", "underlyingError", "", "(Ljava/lang/Throwable;)V", "description", "", "getDescription", "()Ljava/lang/String;", "getUnderlyingError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "react-native-adapty_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BridgeError.kt */
    public static final class EncodingFailed extends BridgeError {
        private final Throwable underlyingError;

        public static /* synthetic */ EncodingFailed copy$default(EncodingFailed encodingFailed, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = encodingFailed.underlyingError;
            }
            return encodingFailed.copy(th);
        }

        public final Throwable component1() {
            return this.underlyingError;
        }

        public final EncodingFailed copy(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "underlyingError");
            return new EncodingFailed(th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof EncodingFailed) && Intrinsics.areEqual((Object) this.underlyingError, (Object) ((EncodingFailed) obj).underlyingError);
        }

        public int hashCode() {
            return this.underlyingError.hashCode();
        }

        public String toString() {
            return "EncodingFailed(underlyingError=" + this.underlyingError + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EncodingFailed(Throwable th) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th, "underlyingError");
            this.underlyingError = th;
        }

        public final Throwable getUnderlyingError() {
            return this.underlyingError;
        }

        public String getDescription() {
            return "Failed to encode data into JSON with error: " + this.underlyingError.getLocalizedMessage() + '.';
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/react/BridgeError$MethodNotImplemented;", "Lcom/adapty/react/BridgeError;", "()V", "description", "", "getDescription", "()Ljava/lang/String;", "react-native-adapty_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BridgeError.kt */
    public static final class MethodNotImplemented extends BridgeError {
        public static final MethodNotImplemented INSTANCE = new MethodNotImplemented();

        public String getDescription() {
            return "Method not implemented.";
        }

        private MethodNotImplemented() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/adapty/react/BridgeError$UnexpectedError;", "Lcom/adapty/react/BridgeError;", "underlyingError", "", "(Ljava/lang/Throwable;)V", "description", "", "getDescription", "()Ljava/lang/String;", "getUnderlyingError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "react-native-adapty_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BridgeError.kt */
    public static final class UnexpectedError extends BridgeError {
        private final Throwable underlyingError;

        public static /* synthetic */ UnexpectedError copy$default(UnexpectedError unexpectedError, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = unexpectedError.underlyingError;
            }
            return unexpectedError.copy(th);
        }

        public final Throwable component1() {
            return this.underlyingError;
        }

        public final UnexpectedError copy(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "underlyingError");
            return new UnexpectedError(th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UnexpectedError) && Intrinsics.areEqual((Object) this.underlyingError, (Object) ((UnexpectedError) obj).underlyingError);
        }

        public int hashCode() {
            return this.underlyingError.hashCode();
        }

        public String toString() {
            return "UnexpectedError(underlyingError=" + this.underlyingError + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UnexpectedError(Throwable th) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th, "underlyingError");
            this.underlyingError = th;
        }

        public final Throwable getUnderlyingError() {
            return this.underlyingError;
        }

        public String getDescription() {
            return "Unexpected error: " + this.underlyingError.getLocalizedMessage() + '.';
        }
    }
}
