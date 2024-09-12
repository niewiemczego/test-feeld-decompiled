package com.facebook.react.defaults;

import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR$\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/facebook/react/defaults/DefaultNewArchitectureEntryPoint;", "", "()V", "concurrentReactEnabled", "", "getConcurrentReactEnabled$annotations", "getConcurrentReactEnabled", "()Z", "setConcurrentReactEnabled", "(Z)V", "fabricEnabled", "getFabricEnabled$annotations", "getFabricEnabled", "setFabricEnabled", "turboModulesEnabled", "getTurboModulesEnabled$annotations", "getTurboModulesEnabled", "setTurboModulesEnabled", "load", "", "dynamicLibraryName", "", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultNewArchitectureEntryPoint.kt */
public final class DefaultNewArchitectureEntryPoint {
    public static final DefaultNewArchitectureEntryPoint INSTANCE = new DefaultNewArchitectureEntryPoint();
    private static boolean concurrentReactEnabled;
    private static boolean fabricEnabled;
    private static boolean turboModulesEnabled;

    @JvmStatic
    public static /* synthetic */ void getConcurrentReactEnabled$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getFabricEnabled$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getTurboModulesEnabled$annotations() {
    }

    @JvmStatic
    public static final void load() {
        load$default(false, false, false, (String) null, 15, (Object) null);
    }

    @JvmStatic
    public static final void load(boolean z) {
        load$default(z, false, false, (String) null, 14, (Object) null);
    }

    @JvmStatic
    public static final void load(boolean z, boolean z2) {
        load$default(z, z2, false, (String) null, 12, (Object) null);
    }

    @JvmStatic
    public static final void load(boolean z, boolean z2, boolean z3) {
        load$default(z, z2, z3, (String) null, 8, (Object) null);
    }

    private DefaultNewArchitectureEntryPoint() {
    }

    public static /* synthetic */ void load$default(boolean z, boolean z2, boolean z3, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            z3 = true;
        }
        if ((i & 8) != 0) {
            str = "appmodules";
        }
        load(z, z2, z3, str);
    }

    @JvmStatic
    public static final void load(boolean z, boolean z2, boolean z3, String str) {
        Intrinsics.checkNotNullParameter(str, "dynamicLibraryName");
        ReactFeatureFlags.useTurboModules = z;
        ReactFeatureFlags.enableFabricRenderer = z2;
        fabricEnabled = z2;
        turboModulesEnabled = z;
        concurrentReactEnabled = z3;
        SoLoader.loadLibrary("react_newarchdefaults");
        SoLoader.loadLibrary(str);
    }

    public static final boolean getFabricEnabled() {
        return fabricEnabled;
    }

    public static final void setFabricEnabled(boolean z) {
        fabricEnabled = z;
    }

    public static final boolean getTurboModulesEnabled() {
        return turboModulesEnabled;
    }

    public static final void setTurboModulesEnabled(boolean z) {
        turboModulesEnabled = z;
    }

    public static final boolean getConcurrentReactEnabled() {
        return concurrentReactEnabled;
    }

    public static final void setConcurrentReactEnabled(boolean z) {
        concurrentReactEnabled = z;
    }
}
