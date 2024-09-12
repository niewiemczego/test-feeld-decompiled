package kotlin.reflect.jvm.internal.impl.descriptors.java;

import io.sentry.protocol.SentryStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;

/* compiled from: JavaVisibilities.kt */
public final class JavaVisibilities {
    public static final JavaVisibilities INSTANCE = new JavaVisibilities();

    /* compiled from: JavaVisibilities.kt */
    public static final class PackageVisibility extends Visibility {
        public static final PackageVisibility INSTANCE = new PackageVisibility();

        public String getInternalDisplayName() {
            return "public/*package*/";
        }

        private PackageVisibility() {
            super(SentryStackFrame.JsonKeys.PACKAGE, false);
        }

        public Integer compareTo(Visibility visibility) {
            Intrinsics.checkNotNullParameter(visibility, "visibility");
            if (this == visibility) {
                return 0;
            }
            if (Visibilities.INSTANCE.isPrivate(visibility)) {
                return 1;
            }
            return -1;
        }

        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }
    }

    private JavaVisibilities() {
    }

    /* compiled from: JavaVisibilities.kt */
    public static final class ProtectedStaticVisibility extends Visibility {
        public static final ProtectedStaticVisibility INSTANCE = new ProtectedStaticVisibility();

        public String getInternalDisplayName() {
            return "protected/*protected static*/";
        }

        private ProtectedStaticVisibility() {
            super("protected_static", true);
        }

        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }
    }

    /* compiled from: JavaVisibilities.kt */
    public static final class ProtectedAndPackage extends Visibility {
        public static final ProtectedAndPackage INSTANCE = new ProtectedAndPackage();

        public String getInternalDisplayName() {
            return "protected/*protected and package*/";
        }

        private ProtectedAndPackage() {
            super("protected_and_package", true);
        }

        public Integer compareTo(Visibility visibility) {
            Intrinsics.checkNotNullParameter(visibility, "visibility");
            if (Intrinsics.areEqual((Object) this, (Object) visibility)) {
                return 0;
            }
            if (visibility == Visibilities.Internal.INSTANCE) {
                return null;
            }
            return Integer.valueOf(Visibilities.INSTANCE.isPrivate(visibility) ? 1 : -1);
        }

        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }
    }
}
