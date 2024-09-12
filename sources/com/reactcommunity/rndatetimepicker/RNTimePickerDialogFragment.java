package com.reactcommunity.rndatetimepicker;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.DateFormat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

public class RNTimePickerDialogFragment extends DialogFragment {
    private TimePickerDialog instance;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private DialogInterface.OnClickListener mOnNeutralButtonActionListener;
    private TimePickerDialog.OnTimeSetListener mOnTimeSetListener;

    public Dialog onCreateDialog(Bundle bundle) {
        TimePickerDialog createDialog = createDialog(getArguments());
        this.instance = createDialog;
        return createDialog;
    }

    public void update(Bundle bundle) {
        RNDate rNDate = new RNDate(bundle);
        this.instance.updateTime(rNDate.hour(), rNDate.minute());
    }

    static TimePickerDialog getDialog(Bundle bundle, Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener) {
        RNDate rNDate = new RNDate(bundle);
        int hour = rNDate.hour();
        int minute = rNDate.minute();
        boolean is24HourFormat = DateFormat.is24HourFormat(context);
        if (bundle != null) {
            is24HourFormat = bundle.getBoolean(RNConstants.ARG_IS24HOUR, DateFormat.is24HourFormat(context));
        }
        boolean z = is24HourFormat;
        int i = 1;
        if (bundle != null && MinuteIntervalSnappableTimePickerDialog.isValidMinuteInterval(bundle.getInt(RNConstants.ARG_INTERVAL))) {
            i = bundle.getInt(RNConstants.ARG_INTERVAL);
        }
        int i2 = i;
        RNTimePickerDisplay displayTime = Common.getDisplayTime(bundle);
        if (displayTime != RNTimePickerDisplay.SPINNER) {
            return new RNDismissableTimePickerDialog(context, onTimeSetListener, hour, minute, i2, z, displayTime);
        }
        return new RNDismissableTimePickerDialog(context, R.style.SpinnerTimePickerDialog, onTimeSetListener, hour, minute, i2, z, displayTime);
    }

    private TimePickerDialog createDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        TimePickerDialog dialog = getDialog(bundle, activity, this.mOnTimeSetListener);
        if (bundle != null) {
            Common.setButtonTitles(bundle, dialog, this.mOnNeutralButtonActionListener);
            if (activity != null) {
                dialog.setOnShowListener(Common.setButtonTextColor(activity, dialog, bundle, Common.getDisplayTime(bundle) == RNTimePickerDisplay.SPINNER));
            }
        }
        return dialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setOnTimeSetListener(TimePickerDialog.OnTimeSetListener onTimeSetListener) {
        this.mOnTimeSetListener = onTimeSetListener;
    }

    /* access modifiers changed from: package-private */
    public void setOnNeutralButtonActionListener(DialogInterface.OnClickListener onClickListener) {
        this.mOnNeutralButtonActionListener = onClickListener;
    }
}
