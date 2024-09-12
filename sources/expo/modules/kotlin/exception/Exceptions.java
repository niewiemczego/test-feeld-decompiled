package expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\n"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions;", "", "()V", "FileSystemModuleNotFound", "MissingActivity", "MissingPermissions", "PermissionsModuleNotFound", "ReactContextLost", "SimulatorNotSupported", "ViewNotFound", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CommonExceptions.kt */
public final class Exceptions {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$ViewNotFound;", "Lexpo/modules/kotlin/exception/CodedException;", "viewType", "Lkotlin/reflect/KClass;", "viewTag", "", "(Lkotlin/reflect/KClass;I)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CommonExceptions.kt */
    public static final class ViewNotFound extends CodedException {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewNotFound(KClass<?> kClass, int i) {
            super("Unable to find the " + kClass + " view with tag " + i, (Throwable) null, 2, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(kClass, "viewType");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$ReactContextLost;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CommonExceptions.kt */
    public static final class ReactContextLost extends CodedException {
        public ReactContextLost() {
            super("The react context has been lost", (Throwable) null, 2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$PermissionsModuleNotFound;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CommonExceptions.kt */
    public static final class PermissionsModuleNotFound extends CodedException {
        public PermissionsModuleNotFound() {
            super("Permissions module not found", (Throwable) null, 2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$SimulatorNotSupported;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CommonExceptions.kt */
    public static final class SimulatorNotSupported extends CodedException {
        public SimulatorNotSupported() {
            super("This operation is not supported on the simulator", (Throwable) null, 2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$FileSystemModuleNotFound;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CommonExceptions.kt */
    public static final class FileSystemModuleNotFound extends CodedException {
        public FileSystemModuleNotFound() {
            super("FileSystem module not found, make sure 'expo-file-system' is linked correctly", (Throwable) null, 2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$MissingPermissions;", "Lexpo/modules/kotlin/exception/CodedException;", "permissions", "", "", "([Ljava/lang/String;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CommonExceptions.kt */
    public static final class MissingPermissions extends CodedException {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MissingPermissions(String... strArr) {
            super("Missing permissions: " + ArraysKt.joinToString$default((Object[]) strArr, (CharSequence) ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), (Throwable) null, 2, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(strArr, "permissions");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$MissingActivity;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CommonExceptions.kt */
    public static final class MissingActivity extends CodedException {
        public MissingActivity() {
            super("The current activity is no longer available", (Throwable) null, 2, (DefaultConstructorMarker) null);
        }
    }
}
