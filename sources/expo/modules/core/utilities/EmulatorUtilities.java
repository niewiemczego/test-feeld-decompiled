package expo.modules.core.utilities;

import android.os.Build;
import io.sentry.protocol.Device;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lexpo/modules/core/utilities/EmulatorUtilities;", "", "()V", "isRunningOnEmulator", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: EmulatorUtilities.kt */
public final class EmulatorUtilities {
    public static final EmulatorUtilities INSTANCE = new EmulatorUtilities();

    private EmulatorUtilities() {
    }

    public final boolean isRunningOnEmulator() {
        String str = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(str, "FINGERPRINT");
        if (!StringsKt.startsWith$default(str, "generic", false, 2, (Object) null)) {
            String str2 = Build.FINGERPRINT;
            Intrinsics.checkNotNullExpressionValue(str2, "FINGERPRINT");
            if (!StringsKt.startsWith$default(str2, "unknown", false, 2, (Object) null)) {
                String str3 = Build.MODEL;
                Intrinsics.checkNotNullExpressionValue(str3, "MODEL");
                if (!StringsKt.contains$default((CharSequence) str3, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                    String str4 = Build.MODEL;
                    Intrinsics.checkNotNullExpressionValue(str4, "MODEL");
                    Locale locale = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                    String lowerCase = str4.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    if (!StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "droid4x", false, 2, (Object) null)) {
                        String str5 = Build.MODEL;
                        Intrinsics.checkNotNullExpressionValue(str5, "MODEL");
                        if (!StringsKt.contains$default((CharSequence) str5, (CharSequence) "Emulator", false, 2, (Object) null)) {
                            String str6 = Build.MODEL;
                            Intrinsics.checkNotNullExpressionValue(str6, "MODEL");
                            if (!StringsKt.contains$default((CharSequence) str6, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                String str7 = Build.MANUFACTURER;
                                Intrinsics.checkNotNullExpressionValue(str7, "MANUFACTURER");
                                if (!StringsKt.contains$default((CharSequence) str7, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                    String str8 = Build.HARDWARE;
                                    Intrinsics.checkNotNullExpressionValue(str8, "HARDWARE");
                                    if (!StringsKt.contains$default((CharSequence) str8, (CharSequence) "goldfish", false, 2, (Object) null)) {
                                        String str9 = Build.HARDWARE;
                                        Intrinsics.checkNotNullExpressionValue(str9, "HARDWARE");
                                        if (!StringsKt.contains$default((CharSequence) str9, (CharSequence) "ranchu", false, 2, (Object) null)) {
                                            String str10 = Build.HARDWARE;
                                            Intrinsics.checkNotNullExpressionValue(str10, "HARDWARE");
                                            if (!StringsKt.contains$default((CharSequence) str10, (CharSequence) "vbox86", false, 2, (Object) null)) {
                                                String str11 = Build.PRODUCT;
                                                Intrinsics.checkNotNullExpressionValue(str11, "PRODUCT");
                                                if (!StringsKt.contains$default((CharSequence) str11, (CharSequence) "sdk", false, 2, (Object) null)) {
                                                    String str12 = Build.PRODUCT;
                                                    Intrinsics.checkNotNullExpressionValue(str12, "PRODUCT");
                                                    if (!StringsKt.contains$default((CharSequence) str12, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                        String str13 = Build.PRODUCT;
                                                        Intrinsics.checkNotNullExpressionValue(str13, "PRODUCT");
                                                        if (!StringsKt.contains$default((CharSequence) str13, (CharSequence) "sdk_google", false, 2, (Object) null)) {
                                                            String str14 = Build.PRODUCT;
                                                            Intrinsics.checkNotNullExpressionValue(str14, "PRODUCT");
                                                            if (!StringsKt.contains$default((CharSequence) str14, (CharSequence) "sdk_x86", false, 2, (Object) null)) {
                                                                String str15 = Build.PRODUCT;
                                                                Intrinsics.checkNotNullExpressionValue(str15, "PRODUCT");
                                                                if (!StringsKt.contains$default((CharSequence) str15, (CharSequence) "vbox86p", false, 2, (Object) null)) {
                                                                    String str16 = Build.PRODUCT;
                                                                    Intrinsics.checkNotNullExpressionValue(str16, "PRODUCT");
                                                                    if (!StringsKt.contains$default((CharSequence) str16, (CharSequence) "emulator", false, 2, (Object) null)) {
                                                                        String str17 = Build.PRODUCT;
                                                                        Intrinsics.checkNotNullExpressionValue(str17, "PRODUCT");
                                                                        if (!StringsKt.contains$default((CharSequence) str17, (CharSequence) Device.JsonKeys.SIMULATOR, false, 2, (Object) null)) {
                                                                            String str18 = Build.BOARD;
                                                                            Intrinsics.checkNotNullExpressionValue(str18, "BOARD");
                                                                            Locale locale2 = Locale.ROOT;
                                                                            Intrinsics.checkNotNullExpressionValue(locale2, "ROOT");
                                                                            String lowerCase2 = str18.toLowerCase(locale2);
                                                                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                                                                            if (!StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "nox", false, 2, (Object) null)) {
                                                                                String str19 = Build.BOOTLOADER;
                                                                                Intrinsics.checkNotNullExpressionValue(str19, "BOOTLOADER");
                                                                                Locale locale3 = Locale.ROOT;
                                                                                Intrinsics.checkNotNullExpressionValue(locale3, "ROOT");
                                                                                String lowerCase3 = str19.toLowerCase(locale3);
                                                                                Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
                                                                                if (!StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "nox", false, 2, (Object) null)) {
                                                                                    String str20 = Build.HARDWARE;
                                                                                    Intrinsics.checkNotNullExpressionValue(str20, "HARDWARE");
                                                                                    Locale locale4 = Locale.ROOT;
                                                                                    Intrinsics.checkNotNullExpressionValue(locale4, "ROOT");
                                                                                    String lowerCase4 = str20.toLowerCase(locale4);
                                                                                    Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
                                                                                    if (!StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) "nox", false, 2, (Object) null)) {
                                                                                        String str21 = Build.PRODUCT;
                                                                                        Intrinsics.checkNotNullExpressionValue(str21, "PRODUCT");
                                                                                        Locale locale5 = Locale.ROOT;
                                                                                        Intrinsics.checkNotNullExpressionValue(locale5, "ROOT");
                                                                                        String lowerCase5 = str21.toLowerCase(locale5);
                                                                                        Intrinsics.checkNotNullExpressionValue(lowerCase5, "this as java.lang.String).toLowerCase(locale)");
                                                                                        if (!StringsKt.contains$default((CharSequence) lowerCase5, (CharSequence) "nox", false, 2, (Object) null)) {
                                                                                            String str22 = Build.SERIAL;
                                                                                            Intrinsics.checkNotNullExpressionValue(str22, "SERIAL");
                                                                                            Locale locale6 = Locale.ROOT;
                                                                                            Intrinsics.checkNotNullExpressionValue(locale6, "ROOT");
                                                                                            String lowerCase6 = str22.toLowerCase(locale6);
                                                                                            Intrinsics.checkNotNullExpressionValue(lowerCase6, "this as java.lang.String).toLowerCase(locale)");
                                                                                            if (!StringsKt.contains$default((CharSequence) lowerCase6, (CharSequence) "nox", false, 2, (Object) null)) {
                                                                                                String str23 = Build.BRAND;
                                                                                                Intrinsics.checkNotNullExpressionValue(str23, "BRAND");
                                                                                                if (!StringsKt.startsWith$default(str23, "generic", false, 2, (Object) null)) {
                                                                                                    return false;
                                                                                                }
                                                                                                String str24 = Build.DEVICE;
                                                                                                Intrinsics.checkNotNullExpressionValue(str24, "DEVICE");
                                                                                                if (StringsKt.startsWith$default(str24, "generic", false, 2, (Object) null)) {
                                                                                                    return true;
                                                                                                }
                                                                                                return false;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
