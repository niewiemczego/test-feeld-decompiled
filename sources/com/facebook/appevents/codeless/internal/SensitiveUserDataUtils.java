package com.facebook.appevents.codeless.internal;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.CharsKt;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\rH\u0007¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/codeless/internal/SensitiveUserDataUtils;", "", "()V", "isCreditCard", "", "view", "Landroid/widget/TextView;", "isEmail", "isPassword", "isPersonName", "isPhoneNumber", "isPostalAddress", "isSensitiveUserData", "Landroid/view/View;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SensitiveUserDataUtils.kt */
public final class SensitiveUserDataUtils {
    public static final SensitiveUserDataUtils INSTANCE = new SensitiveUserDataUtils();

    private SensitiveUserDataUtils() {
    }

    @JvmStatic
    public static final boolean isSensitiveUserData(View view) {
        Class<SensitiveUserDataUtils> cls = SensitiveUserDataUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            if (!(view instanceof TextView)) {
                return false;
            }
            SensitiveUserDataUtils sensitiveUserDataUtils = INSTANCE;
            if (sensitiveUserDataUtils.isPassword((TextView) view) || sensitiveUserDataUtils.isCreditCard((TextView) view) || sensitiveUserDataUtils.isPersonName((TextView) view) || sensitiveUserDataUtils.isPostalAddress((TextView) view) || sensitiveUserDataUtils.isPhoneNumber((TextView) view) || sensitiveUserDataUtils.isEmail((TextView) view)) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    private final boolean isPassword(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (textView.getInputType() == 128) {
                return true;
            }
            return textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final boolean isEmail(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            boolean z = true;
            if (textView.getInputType() == 32) {
                return true;
            }
            ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
            String textOfView = ViewHierarchy.getTextOfView(textView);
            if (textOfView == null) {
                return false;
            }
            if (textOfView.length() != 0) {
                z = false;
            }
            if (z) {
                return false;
            }
            return Patterns.EMAIL_ADDRESS.matcher(textOfView).matches();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final boolean isPersonName(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return textView.getInputType() == 96;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final boolean isPostalAddress(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return textView.getInputType() == 112;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final boolean isPhoneNumber(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return textView.getInputType() == 3;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final boolean isCreditCard(TextView textView) {
        int i;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
            String replace = new Regex("\\s").replace((CharSequence) ViewHierarchy.getTextOfView(textView), "");
            int length = replace.length();
            if (length < 12) {
                return false;
            }
            if (length > 19) {
                return false;
            }
            int i2 = length - 1;
            if (i2 >= 0) {
                boolean z = false;
                i = 0;
                while (true) {
                    int i3 = i2 - 1;
                    char charAt = replace.charAt(i2);
                    if (!Character.isDigit(charAt)) {
                        return false;
                    }
                    int digitToInt = CharsKt.digitToInt(charAt);
                    if (z && (digitToInt = digitToInt * 2) > 9) {
                        digitToInt = (digitToInt % 10) + 1;
                    }
                    i += digitToInt;
                    z = !z;
                    if (i3 < 0) {
                        break;
                    }
                    i2 = i3;
                }
            } else {
                i = 0;
            }
            if (i % 10 == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
