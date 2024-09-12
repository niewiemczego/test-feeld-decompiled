package com.reactcommunity.rndatetimepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class RNDatePickerDialogFragment extends DialogFragment {
    private DatePickerDialog instance;
    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private DialogInterface.OnClickListener mOnNeutralButtonActionListener;

    public Dialog onCreateDialog(Bundle bundle) {
        DatePickerDialog createDialog = createDialog(getArguments());
        this.instance = createDialog;
        return createDialog;
    }

    public void update(Bundle bundle) {
        RNDate rNDate = new RNDate(bundle);
        this.instance.updateDate(rNDate.year(), rNDate.month(), rNDate.day());
    }

    static DatePickerDialog getDialog(Bundle bundle, Context context, DatePickerDialog.OnDateSetListener onDateSetListener) {
        RNDate rNDate = new RNDate(bundle);
        int year = rNDate.year();
        int month = rNDate.month();
        int day = rNDate.day();
        RNDatePickerDisplay displayDate = (bundle == null || bundle.getString("display", (String) null) == null) ? Common.getDisplayDate(bundle) : RNDatePickerDisplay.valueOf(bundle.getString("display").toUpperCase(Locale.US));
        if (displayDate != RNDatePickerDisplay.SPINNER) {
            return new RNDismissableDatePickerDialog(context, onDateSetListener, year, month, day, displayDate);
        }
        return new RNDismissableDatePickerDialog(context, R.style.SpinnerDatePickerDialog, onDateSetListener, year, month, day, displayDate);
    }

    private DatePickerDialog createDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        Calendar instance2 = Calendar.getInstance();
        DatePickerDialog dialog = getDialog(bundle, activity, this.mOnDateSetListener);
        if (bundle != null) {
            Common.setButtonTitles(bundle, dialog, this.mOnNeutralButtonActionListener);
            if (activity != null) {
                dialog.setOnShowListener(Common.setButtonTextColor(activity, dialog, bundle, Common.getDisplayDate(bundle) == RNDatePickerDisplay.SPINNER));
            }
        }
        DatePicker datePicker = dialog.getDatePicker();
        Integer timeZoneOffset = getTimeZoneOffset(bundle);
        if (timeZoneOffset != null) {
            instance2.setTimeZone(TimeZone.getTimeZone("GMT"));
        }
        if (bundle == null || !bundle.containsKey(RNConstants.ARG_MINDATE)) {
            datePicker.setMinDate(RNConstants.DEFAULT_MIN_DATE);
        } else {
            instance2.setTimeInMillis(bundle.getLong(RNConstants.ARG_MINDATE));
            instance2.set(11, 0);
            instance2.set(12, 0);
            instance2.set(13, 0);
            instance2.set(14, 0);
            datePicker.setMinDate(instance2.getTimeInMillis() - ((long) getOffset(instance2, timeZoneOffset)));
        }
        if (bundle != null && bundle.containsKey(RNConstants.ARG_MAXDATE)) {
            instance2.setTimeInMillis(bundle.getLong(RNConstants.ARG_MAXDATE));
            instance2.set(11, 23);
            instance2.set(12, 59);
            instance2.set(13, 59);
            instance2.set(14, 999);
            datePicker.setMaxDate(instance2.getTimeInMillis() - ((long) getOffset(instance2, timeZoneOffset)));
        }
        if (bundle != null && Build.VERSION.SDK_INT >= 26 && (bundle.containsKey(RNConstants.ARG_MAXDATE) || bundle.containsKey(RNConstants.ARG_MINDATE))) {
            datePicker.setOnDateChangedListener(new KeepDateInRangeListener(bundle));
        }
        return dialog;
    }

    private static Integer getTimeZoneOffset(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(RNConstants.ARG_TZOFFSET_MINS)) {
            return null;
        }
        return Integer.valueOf(bundle.getInt(RNConstants.ARG_TZOFFSET_MINS, (int) bundle.getLong(RNConstants.ARG_TZOFFSET_MINS)) * 60000);
    }

    private static int getOffset(Calendar calendar, Integer num) {
        if (num != null) {
            return TimeZone.getDefault().getOffset(calendar.getTimeInMillis()) - num.intValue();
        }
        return 0;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnDateSetListener(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.mOnDateSetListener = onDateSetListener;
    }

    /* access modifiers changed from: package-private */
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    /* access modifiers changed from: package-private */
    public void setOnNeutralButtonActionListener(DialogInterface.OnClickListener onClickListener) {
        this.mOnNeutralButtonActionListener = onClickListener;
    }
}
