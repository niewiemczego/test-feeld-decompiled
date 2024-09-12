package com.reactcommunity.rndatetimepicker;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import java.util.Calendar;

@ReactModule(name = "RNDatePickerAndroid")
public class RNDatePickerDialogModule extends ReactContextBaseJavaModule {
    public static final String FRAGMENT_TAG = "RNDatePickerAndroid";

    public String getName() {
        return FRAGMENT_TAG;
    }

    public RNDatePickerDialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private class DatePickerDialogListener implements DatePickerDialog.OnDateSetListener, DialogInterface.OnDismissListener, DialogInterface.OnClickListener {
        private final Bundle mArgs;
        private final Promise mPromise;
        private boolean mPromiseResolved = false;

        public DatePickerDialogListener(Promise promise, Bundle bundle) {
            this.mPromise = promise;
            this.mArgs = bundle;
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            if (!this.mPromiseResolved && RNDatePickerDialogModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", RNConstants.ACTION_DATE_SET);
                writableNativeMap.putInt("year", i);
                writableNativeMap.putInt("month", i2);
                writableNativeMap.putInt("day", i3);
                if (KeepDateInRangeListener.isDateAfterMaxDate(this.mArgs, i, i2, i3)) {
                    Calendar instance = Calendar.getInstance();
                    instance.setTimeInMillis(this.mArgs.getLong(RNConstants.ARG_MAXDATE));
                    writableNativeMap.putInt("year", instance.get(1));
                    writableNativeMap.putInt("month", instance.get(2));
                    writableNativeMap.putInt("day", instance.get(5));
                }
                if (KeepDateInRangeListener.isDateBeforeMinDate(this.mArgs, i, i2, i3)) {
                    Calendar instance2 = Calendar.getInstance();
                    instance2.setTimeInMillis(this.mArgs.getLong(RNConstants.ARG_MINDATE));
                    writableNativeMap.putInt("year", instance2.get(1));
                    writableNativeMap.putInt("month", instance2.get(2));
                    writableNativeMap.putInt("day", instance2.get(5));
                }
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (!this.mPromiseResolved && RNDatePickerDialogModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", RNConstants.ACTION_DISMISSED);
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (!this.mPromiseResolved && RNDatePickerDialogModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", RNConstants.ACTION_NEUTRAL_BUTTON);
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }
    }

    @ReactMethod
    public void dismiss(Promise promise) {
        Common.dismissDialog((FragmentActivity) getCurrentActivity(), FRAGMENT_TAG, promise);
    }

    @ReactMethod
    public void open(final ReadableMap readableMap, final Promise promise) {
        FragmentActivity fragmentActivity = (FragmentActivity) getCurrentActivity();
        if (fragmentActivity == null) {
            promise.reject(RNConstants.ERROR_NO_ACTIVITY, "Tried to open a DatePicker dialog while not attached to an Activity");
            return;
        }
        final FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                RNDatePickerDialogFragment rNDatePickerDialogFragment = (RNDatePickerDialogFragment) supportFragmentManager.findFragmentByTag(RNDatePickerDialogModule.FRAGMENT_TAG);
                if (rNDatePickerDialogFragment != null) {
                    rNDatePickerDialogFragment.update(RNDatePickerDialogModule.this.createFragmentArguments(readableMap));
                    return;
                }
                RNDatePickerDialogFragment rNDatePickerDialogFragment2 = new RNDatePickerDialogFragment();
                rNDatePickerDialogFragment2.setArguments(RNDatePickerDialogModule.this.createFragmentArguments(readableMap));
                RNDatePickerDialogModule rNDatePickerDialogModule = RNDatePickerDialogModule.this;
                DatePickerDialogListener datePickerDialogListener = new DatePickerDialogListener(promise, rNDatePickerDialogModule.createFragmentArguments(readableMap));
                rNDatePickerDialogFragment2.setOnDismissListener(datePickerDialogListener);
                rNDatePickerDialogFragment2.setOnDateSetListener(datePickerDialogListener);
                rNDatePickerDialogFragment2.setOnNeutralButtonActionListener(datePickerDialogListener);
                rNDatePickerDialogFragment2.show(supportFragmentManager, RNDatePickerDialogModule.FRAGMENT_TAG);
            }
        });
    }

    /* access modifiers changed from: private */
    public Bundle createFragmentArguments(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        if (readableMap.hasKey("value") && !readableMap.isNull("value")) {
            bundle.putLong("value", (long) readableMap.getDouble("value"));
        }
        if (readableMap.hasKey(RNConstants.ARG_MINDATE) && !readableMap.isNull(RNConstants.ARG_MINDATE)) {
            bundle.putLong(RNConstants.ARG_MINDATE, (long) readableMap.getDouble(RNConstants.ARG_MINDATE));
        }
        if (readableMap.hasKey(RNConstants.ARG_MAXDATE) && !readableMap.isNull(RNConstants.ARG_MAXDATE)) {
            bundle.putLong(RNConstants.ARG_MAXDATE, (long) readableMap.getDouble(RNConstants.ARG_MAXDATE));
        }
        if (readableMap.hasKey("display") && !readableMap.isNull("display")) {
            bundle.putString("display", readableMap.getString("display"));
        }
        if (readableMap.hasKey(RNConstants.ARG_DIALOG_BUTTONS) && !readableMap.isNull(RNConstants.ARG_DIALOG_BUTTONS)) {
            bundle.putBundle(RNConstants.ARG_DIALOG_BUTTONS, Arguments.toBundle(readableMap.getMap(RNConstants.ARG_DIALOG_BUTTONS)));
        }
        if (readableMap.hasKey(RNConstants.ARG_TZOFFSET_MINS) && !readableMap.isNull(RNConstants.ARG_TZOFFSET_MINS)) {
            bundle.putLong(RNConstants.ARG_TZOFFSET_MINS, (long) readableMap.getDouble(RNConstants.ARG_TZOFFSET_MINS));
        }
        return bundle;
    }
}
