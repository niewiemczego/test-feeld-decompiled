package com.reactcommunity.rndatetimepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.DatePicker;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RNDismissableDatePickerDialog extends DatePickerDialog {
    public RNDismissableDatePickerDialog(Context context, DatePickerDialog.OnDateSetListener onDateSetListener, int i, int i2, int i3, RNDatePickerDisplay rNDatePickerDisplay) {
        super(context, onDateSetListener, i, i2, i3);
        fixSpinner(context, i, i2, i3, rNDatePickerDisplay);
    }

    public RNDismissableDatePickerDialog(Context context, int i, DatePickerDialog.OnDateSetListener onDateSetListener, int i2, int i3, int i4, RNDatePickerDisplay rNDatePickerDisplay) {
        super(context, i, onDateSetListener, i2, i3, i4);
        fixSpinner(context, i2, i3, i4, rNDatePickerDisplay);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        if (Build.VERSION.SDK_INT > 19) {
            super.onStop();
        }
    }

    private void fixSpinner(Context context, int i, int i2, int i3, RNDatePickerDisplay rNDatePickerDisplay) {
        Context context2 = context;
        RNDatePickerDisplay rNDatePickerDisplay2 = rNDatePickerDisplay;
        if (Build.VERSION.SDK_INT == 24 && rNDatePickerDisplay2 == RNDatePickerDisplay.SPINNER) {
            try {
                context2.obtainStyledAttributes((AttributeSet) null, (int[]) Class.forName("com.android.internal.R$styleable").getField("DatePicker").get((Object) null), 16843612, 0).recycle();
                DatePicker datePicker = (DatePicker) ReflectionHelper.findField(DatePickerDialog.class, DatePicker.class, "mDatePicker").get(this);
                Field findField = ReflectionHelper.findField(DatePicker.class, Class.forName("android.widget.DatePickerSpinnerDelegate"), "mDelegate");
                Object obj = findField.get(datePicker);
                if (obj.getClass() != Class.forName("android.widget.DatePickerSpinnerDelegate")) {
                    findField.set(datePicker, (Object) null);
                    datePicker.removeAllViews();
                    Method declaredMethod = DatePicker.class.getDeclaredMethod("createSpinnerUIDelegate", new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE});
                    declaredMethod.setAccessible(true);
                    findField.set(datePicker, declaredMethod.invoke(datePicker, new Object[]{context2, null, 16843612, 0}));
                    datePicker.setCalendarViewShown(false);
                    datePicker.init(i, i2, i3, this);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (rNDatePickerDisplay2 == RNDatePickerDisplay.SPINNER && getDatePicker() != null) {
            getDatePicker().setCalendarViewShown(false);
        }
    }
}
