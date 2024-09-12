package com.reactcommunity.rndatetimepicker;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TimePicker;
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

@ReactModule(name = "RNTimePickerAndroid")
public class RNTimePickerDialogModule extends ReactContextBaseJavaModule {
    public static final String FRAGMENT_TAG = "RNTimePickerAndroid";

    public String getName() {
        return FRAGMENT_TAG;
    }

    public RNTimePickerDialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private class TimePickerDialogListener implements TimePickerDialog.OnTimeSetListener, DialogInterface.OnDismissListener, DialogInterface.OnClickListener {
        private final Promise mPromise;
        private boolean mPromiseResolved = false;

        public TimePickerDialogListener(Promise promise) {
            this.mPromise = promise;
        }

        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            if (!this.mPromiseResolved && RNTimePickerDialogModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", RNConstants.ACTION_TIME_SET);
                writableNativeMap.putInt("hour", i);
                writableNativeMap.putInt("minute", i2);
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (!this.mPromiseResolved && RNTimePickerDialogModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", RNConstants.ACTION_DISMISSED);
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (!this.mPromiseResolved && RNTimePickerDialogModule.this.getReactApplicationContext().hasActiveReactInstance()) {
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
            promise.reject(RNConstants.ERROR_NO_ACTIVITY, "Tried to open a TimePicker dialog while not attached to an Activity");
            return;
        }
        final FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                RNTimePickerDialogFragment rNTimePickerDialogFragment = (RNTimePickerDialogFragment) supportFragmentManager.findFragmentByTag(RNTimePickerDialogModule.FRAGMENT_TAG);
                if (rNTimePickerDialogFragment != null) {
                    rNTimePickerDialogFragment.update(RNTimePickerDialogModule.this.createFragmentArguments(readableMap));
                    return;
                }
                RNTimePickerDialogFragment rNTimePickerDialogFragment2 = new RNTimePickerDialogFragment();
                rNTimePickerDialogFragment2.setArguments(RNTimePickerDialogModule.this.createFragmentArguments(readableMap));
                TimePickerDialogListener timePickerDialogListener = new TimePickerDialogListener(promise);
                rNTimePickerDialogFragment2.setOnDismissListener(timePickerDialogListener);
                rNTimePickerDialogFragment2.setOnTimeSetListener(timePickerDialogListener);
                rNTimePickerDialogFragment2.setOnNeutralButtonActionListener(timePickerDialogListener);
                rNTimePickerDialogFragment2.show(supportFragmentManager, RNTimePickerDialogModule.FRAGMENT_TAG);
            }
        });
    }

    /* access modifiers changed from: private */
    public Bundle createFragmentArguments(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        if (readableMap.hasKey("value") && !readableMap.isNull("value")) {
            bundle.putLong("value", (long) readableMap.getDouble("value"));
        }
        if (readableMap.hasKey(RNConstants.ARG_IS24HOUR) && !readableMap.isNull(RNConstants.ARG_IS24HOUR)) {
            bundle.putBoolean(RNConstants.ARG_IS24HOUR, readableMap.getBoolean(RNConstants.ARG_IS24HOUR));
        }
        if (readableMap.hasKey("display") && !readableMap.isNull("display")) {
            bundle.putString("display", readableMap.getString("display"));
        }
        if (readableMap.hasKey(RNConstants.ARG_DIALOG_BUTTONS) && !readableMap.isNull(RNConstants.ARG_DIALOG_BUTTONS)) {
            bundle.putBundle(RNConstants.ARG_DIALOG_BUTTONS, Arguments.toBundle(readableMap.getMap(RNConstants.ARG_DIALOG_BUTTONS)));
        }
        if (readableMap.hasKey(RNConstants.ARG_INTERVAL) && !readableMap.isNull(RNConstants.ARG_INTERVAL)) {
            bundle.putInt(RNConstants.ARG_INTERVAL, readableMap.getInt(RNConstants.ARG_INTERVAL));
        }
        if (readableMap.hasKey(RNConstants.ARG_TZOFFSET_MINS) && !readableMap.isNull(RNConstants.ARG_TZOFFSET_MINS)) {
            bundle.putInt(RNConstants.ARG_TZOFFSET_MINS, readableMap.getInt(RNConstants.ARG_TZOFFSET_MINS));
        }
        return bundle;
    }
}
