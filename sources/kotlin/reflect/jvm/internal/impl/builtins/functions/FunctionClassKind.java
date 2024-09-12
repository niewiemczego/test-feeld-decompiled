package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;

/* compiled from: FunctionClassKind.kt */
public enum FunctionClassKind {
    Function(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, "Function", false, false),
    SuspendFunction(StandardNames.COROUTINES_PACKAGE_FQ_NAME, "SuspendFunction", true, false),
    KFunction(StandardNames.KOTLIN_REFLECT_FQ_NAME, "KFunction", false, true),
    KSuspendFunction(StandardNames.KOTLIN_REFLECT_FQ_NAME, "KSuspendFunction", true, true);
    
    public static final Companion Companion = null;
    private final String classNamePrefix;
    private final boolean isReflectType;
    private final boolean isSuspendType;
    private final FqName packageFqName;

    private FunctionClassKind(FqName fqName, String str, boolean z, boolean z2) {
        this.packageFqName = fqName;
        this.classNamePrefix = str;
        this.isSuspendType = z;
        this.isReflectType = z2;
    }

    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    public final Name numberedClassName(int i) {
        Name identifier = Name.identifier(this.classNamePrefix + i);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"$classNamePrefix$arity\")");
        return identifier;
    }

    /* compiled from: FunctionClassKind.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FunctionClassKind byClassNamePrefix(FqName fqName, String str) {
            Intrinsics.checkNotNullParameter(fqName, "packageFqName");
            Intrinsics.checkNotNullParameter(str, "className");
            for (FunctionClassKind functionClassKind : FunctionClassKind.values()) {
                if (Intrinsics.areEqual((Object) functionClassKind.getPackageFqName(), (Object) fqName) && StringsKt.startsWith$default(str, functionClassKind.getClassNamePrefix(), false, 2, (Object) null)) {
                    return functionClassKind;
                }
            }
            return null;
        }

        /* compiled from: FunctionClassKind.kt */
        public static final class KindWithArity {
            private final int arity;
            private final FunctionClassKind kind;

            public final FunctionClassKind component1() {
                return this.kind;
            }

            public final int component2() {
                return this.arity;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof KindWithArity)) {
                    return false;
                }
                KindWithArity kindWithArity = (KindWithArity) obj;
                return this.kind == kindWithArity.kind && this.arity == kindWithArity.arity;
            }

            public int hashCode() {
                return (this.kind.hashCode() * 31) + this.arity;
            }

            public String toString() {
                return "KindWithArity(kind=" + this.kind + ", arity=" + this.arity + ')';
            }

            public KindWithArity(FunctionClassKind functionClassKind, int i) {
                Intrinsics.checkNotNullParameter(functionClassKind, "kind");
                this.kind = functionClassKind;
                this.arity = i;
            }

            public final FunctionClassKind getKind() {
                return this.kind;
            }
        }

        public final KindWithArity parseClassName(String str, FqName fqName) {
            Intrinsics.checkNotNullParameter(str, "className");
            Intrinsics.checkNotNullParameter(fqName, "packageFqName");
            FunctionClassKind byClassNamePrefix = byClassNamePrefix(fqName, str);
            if (byClassNamePrefix == null) {
                return null;
            }
            String substring = str.substring(byClassNamePrefix.getClassNamePrefix().length());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            Integer num = toInt(substring);
            if (num != null) {
                return new KindWithArity(byClassNamePrefix, num.intValue());
            }
            return null;
        }

        @JvmStatic
        public final FunctionClassKind getFunctionalClassKind(String str, FqName fqName) {
            Intrinsics.checkNotNullParameter(str, "className");
            Intrinsics.checkNotNullParameter(fqName, "packageFqName");
            KindWithArity parseClassName = parseClassName(str, fqName);
            if (parseClassName != null) {
                return parseClassName.getKind();
            }
            return null;
        }

        private final Integer toInt(String str) {
            if (str.length() == 0) {
                return null;
            }
            int length = str.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                int charAt = str.charAt(i2) - '0';
                if (!(charAt >= 0 && charAt < 10)) {
                    return null;
                }
                i = (i * 10) + charAt;
            }
            return Integer.valueOf(i);
        }
    }
}
