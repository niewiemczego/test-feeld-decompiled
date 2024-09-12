package com.reactcommunity.rndatetimepicker;

import android.os.Bundle;
import android.widget.DatePicker;
import java.util.Calendar;

public class KeepDateInRangeListener implements DatePicker.OnDateChangedListener {
    private final Bundle args;

    public KeepDateInRangeListener(Bundle bundle) {
        this.args = bundle;
    }

    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        fixPotentialMaxDateBug(datePicker, i, i2, i3);
        fixPotentialMinDateBug(datePicker, i, i2, i3);
    }

    private void fixPotentialMaxDateBug(DatePicker datePicker, int i, int i2, int i3) {
        if (isDateAfterMaxDate(this.args, i, i2, i3)) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.args.getLong(RNConstants.ARG_MAXDATE));
            datePicker.updateDate(instance.get(1), instance.get(2), instance.get(5));
        }
    }

    private void fixPotentialMinDateBug(DatePicker datePicker, int i, int i2, int i3) {
        if (isDateBeforeMinDate(this.args, i, i2, i3)) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.args.getLong(RNConstants.ARG_MINDATE));
            datePicker.updateDate(instance.get(1), instance.get(2), instance.get(5));
        }
    }

    public static boolean isDateAfterMaxDate(Bundle bundle, int i, int i2, int i3) {
        if (!bundle.containsKey(RNConstants.ARG_MAXDATE)) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(bundle.getLong(RNConstants.ARG_MAXDATE));
        if (i > instance.get(1) || ((i == instance.get(1) && i2 > instance.get(2)) || (i == instance.get(1) && i2 == instance.get(2) && i3 > instance.get(5)))) {
            return true;
        }
        return false;
    }

    public static boolean isDateBeforeMinDate(Bundle bundle, int i, int i2, int i3) {
        if (!bundle.containsKey(RNConstants.ARG_MINDATE)) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(bundle.getLong(RNConstants.ARG_MINDATE));
        if (i < instance.get(1) || ((i == instance.get(1) && i2 < instance.get(2)) || (i == instance.get(1) && i2 == instance.get(2) && i3 < instance.get(5)))) {
            return true;
        }
        return false;
    }
}
