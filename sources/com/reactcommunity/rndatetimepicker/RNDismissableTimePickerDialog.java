package com.reactcommunity.rndatetimepicker;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TimePicker;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class RNDismissableTimePickerDialog extends MinuteIntervalSnappableTimePickerDialog {
    public /* bridge */ /* synthetic */ void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public /* bridge */ /* synthetic */ void onClick(DialogInterface dialogInterface, int i) {
        super.onClick(dialogInterface, i);
    }

    public /* bridge */ /* synthetic */ void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public /* bridge */ /* synthetic */ void onTimeChanged(TimePicker timePicker, int i, int i2) {
        super.onTimeChanged(timePicker, i, i2);
    }

    public /* bridge */ /* synthetic */ void updateTime(int i, int i2) {
        super.updateTime(i, i2);
    }

    public RNDismissableTimePickerDialog(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, int i3, boolean z, RNTimePickerDisplay rNTimePickerDisplay) {
        super(context, onTimeSetListener, i, i2, i3, z, rNTimePickerDisplay);
        fixSpinner(context, i, i2, z, rNTimePickerDisplay);
    }

    public RNDismissableTimePickerDialog(Context context, int i, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i2, int i3, int i4, boolean z, RNTimePickerDisplay rNTimePickerDisplay) {
        super(context, i, onTimeSetListener, i2, i3, i4, z, rNTimePickerDisplay);
        fixSpinner(context, i2, i3, z, rNTimePickerDisplay);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        if (Build.VERSION.SDK_INT > 19) {
            super.onStop();
        }
    }

    private void fixSpinner(Context context, int i, int i2, boolean z, RNTimePickerDisplay rNTimePickerDisplay) {
        Context context2 = context;
        if (Build.VERSION.SDK_INT == 24 && rNTimePickerDisplay == RNTimePickerDisplay.SPINNER) {
            try {
                context2.obtainStyledAttributes((AttributeSet) null, (int[]) Class.forName("com.android.internal.R$styleable").getField("TimePicker").get((Object) null), 16843933, 0).recycle();
                TimePicker timePicker = (TimePicker) ReflectionHelper.findField(TimePickerDialog.class, TimePicker.class, "mTimePicker").get(this);
                Field findField = ReflectionHelper.findField(TimePicker.class, Class.forName("android.widget.TimePicker$TimePickerDelegate"), "mDelegate");
                Object obj = findField.get(timePicker);
                Class<?> cls = Class.forName("android.widget.TimePickerSpinnerDelegate");
                if (obj.getClass() != cls) {
                    findField.set(timePicker, (Object) null);
                    timePicker.removeAllViews();
                    Constructor<?> constructor = cls.getConstructor(new Class[]{TimePicker.class, Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE});
                    constructor.setAccessible(true);
                    findField.set(timePicker, constructor.newInstance(new Object[]{timePicker, context2, null, 16843933, 0}));
                    timePicker.setIs24HourView(Boolean.valueOf(z));
                    timePicker.setCurrentHour(Integer.valueOf(i));
                    timePicker.setCurrentMinute(Integer.valueOf(i2));
                    timePicker.setOnTimeChangedListener(this);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
