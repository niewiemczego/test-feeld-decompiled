package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;

/* compiled from: MemberSignature.kt */
public final class MemberSignature {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String signature;

    public /* synthetic */ MemberSignature(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MemberSignature) && Intrinsics.areEqual((Object) this.signature, (Object) ((MemberSignature) obj).signature);
    }

    public int hashCode() {
        return this.signature.hashCode();
    }

    public String toString() {
        return "MemberSignature(signature=" + this.signature + ')';
    }

    private MemberSignature(String str) {
        this.signature = str;
    }

    /* compiled from: MemberSignature.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MemberSignature fromMethod(NameResolver nameResolver, JvmProtoBuf.JvmMethodSignature jvmMethodSignature) {
            Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics.checkNotNullParameter(jvmMethodSignature, "signature");
            return fromMethodNameAndDesc(nameResolver.getString(jvmMethodSignature.getName()), nameResolver.getString(jvmMethodSignature.getDesc()));
        }

        @JvmStatic
        public final MemberSignature fromMethodNameAndDesc(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "desc");
            return new MemberSignature(str + str2, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final MemberSignature fromFieldNameAndDesc(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "desc");
            return new MemberSignature(str + '#' + str2, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final MemberSignature fromJvmMemberSignature(JvmMemberSignature jvmMemberSignature) {
            Intrinsics.checkNotNullParameter(jvmMemberSignature, "signature");
            if (jvmMemberSignature instanceof JvmMemberSignature.Method) {
                return fromMethodNameAndDesc(jvmMemberSignature.getName(), jvmMemberSignature.getDesc());
            }
            if (jvmMemberSignature instanceof JvmMemberSignature.Field) {
                return fromFieldNameAndDesc(jvmMemberSignature.getName(), jvmMemberSignature.getDesc());
            }
            throw new NoWhenBranchMatchedException();
        }

        @JvmStatic
        public final MemberSignature fromMethodSignatureAndParameterIndex(MemberSignature memberSignature, int i) {
            Intrinsics.checkNotNullParameter(memberSignature, "signature");
            return new MemberSignature(memberSignature.getSignature() + '@' + i, (DefaultConstructorMarker) null);
        }
    }

    public final String getSignature() {
        return this.signature;
    }
}
