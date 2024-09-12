package com.reactcommunity.rndatetimepicker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.bridge.Promise;
import java.util.Locale;

public class Common {
    public static final String LABEL = "label";
    public static final String NEGATIVE = "negative";
    public static final String NEUTRAL = "neutral";
    public static final String POSITIVE = "positive";
    public static final String TEXT_COLOR = "textColor";

    public static void dismissDialog(FragmentActivity fragmentActivity, String str, Promise promise) {
        if (fragmentActivity == null) {
            promise.reject(RNConstants.ERROR_NO_ACTIVITY, "Tried to close a " + str + " dialog while not attached to an Activity");
            return;
        }
        try {
            DialogFragment dialogFragment = (DialogFragment) fragmentActivity.getSupportFragmentManager().findFragmentByTag(str);
            boolean z = dialogFragment != null;
            if (z) {
                dialogFragment.dismiss();
            }
            promise.resolve(Boolean.valueOf(z));
        } catch (Exception e) {
            promise.reject((Throwable) e);
        }
    }

    public static int getDefaultDialogButtonTextColor(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842806, typedValue, true);
        return ContextCompat.getColor(context, typedValue.resourceId != 0 ? typedValue.resourceId : typedValue.data);
    }

    public static DialogInterface.OnShowListener setButtonTextColor(final Context context, final AlertDialog alertDialog, final Bundle bundle, final boolean z) {
        return new DialogInterface.OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                Button button = alertDialog.getButton(-1);
                Button button2 = alertDialog.getButton(-2);
                Button button3 = alertDialog.getButton(-3);
                int defaultDialogButtonTextColor = Common.getDefaultDialogButtonTextColor(context);
                Common.setTextColor(button, Common.POSITIVE, bundle, z, defaultDialogButtonTextColor);
                Common.setTextColor(button2, Common.NEGATIVE, bundle, z, defaultDialogButtonTextColor);
                Common.setTextColor(button3, Common.NEUTRAL, bundle, z, defaultDialogButtonTextColor);
            }
        };
    }

    /* access modifiers changed from: private */
    public static void setTextColor(Button button, String str, Bundle bundle, boolean z, int i) {
        if (button != null) {
            Integer buttonColor = getButtonColor(bundle, str);
            if (z || buttonColor != null) {
                if (buttonColor != null) {
                    i = buttonColor.intValue();
                }
                button.setTextColor(i);
            }
        }
    }

    private static Integer getButtonColor(Bundle bundle, String str) {
        Bundle bundle2;
        int i;
        Bundle bundle3 = bundle.getBundle(RNConstants.ARG_DIALOG_BUTTONS);
        if (bundle3 == null || (bundle2 = bundle3.getBundle(str)) == null || (i = (int) bundle2.getDouble(TEXT_COLOR, 0.0d)) == 0) {
            return null;
        }
        return Integer.valueOf(i);
    }

    public static RNTimePickerDisplay getDisplayTime(Bundle bundle) {
        RNTimePickerDisplay rNTimePickerDisplay = RNTimePickerDisplay.DEFAULT;
        return (bundle == null || bundle.getString("display", (String) null) == null) ? rNTimePickerDisplay : RNTimePickerDisplay.valueOf(bundle.getString("display").toUpperCase(Locale.US));
    }

    public static RNDatePickerDisplay getDisplayDate(Bundle bundle) {
        RNDatePickerDisplay rNDatePickerDisplay = RNDatePickerDisplay.DEFAULT;
        return (bundle == null || bundle.getString("display", (String) null) == null) ? rNDatePickerDisplay : RNDatePickerDisplay.valueOf(bundle.getString("display").toUpperCase(Locale.US));
    }

    public static void setButtonTitles(Bundle bundle, AlertDialog alertDialog, DialogInterface.OnClickListener onClickListener) {
        Bundle bundle2 = bundle.getBundle(RNConstants.ARG_DIALOG_BUTTONS);
        if (bundle2 != null) {
            setButtonLabel(bundle2.getBundle(NEUTRAL), alertDialog, -3, onClickListener);
            DialogInterface.OnClickListener onClickListener2 = (DialogInterface.OnClickListener) alertDialog;
            setButtonLabel(bundle2.getBundle(POSITIVE), alertDialog, -1, onClickListener2);
            setButtonLabel(bundle2.getBundle(NEGATIVE), alertDialog, -2, onClickListener2);
        }
    }

    private static void setButtonLabel(Bundle bundle, AlertDialog alertDialog, int i, DialogInterface.OnClickListener onClickListener) {
        if (bundle != null && bundle.getString("label") != null) {
            alertDialog.setButton(i, bundle.getString("label"), onClickListener);
        }
    }
}
