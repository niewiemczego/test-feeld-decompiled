package com.reactnativecommunity.slider;

import android.animation.StateListAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import java.net.URL;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;

public class ReactSlider extends AppCompatSeekBar {
    private static int DEFAULT_TOTAL_STEPS = 128;
    private boolean isSliding = false;
    private List<String> mAccessibilityIncrements;
    private String mAccessibilityUnits;
    private int mLowerLimit;
    private double mMaxValue = 0.0d;
    private double mMinValue = 0.0d;
    private double mRealLowerLimit = -9.223372036854776E18d;
    private double mRealUpperLimit = 9.223372036854776E18d;
    private double mStep = 0.0d;
    private double mStepCalculated = 0.0d;
    private int mUpperLimit;
    private double mValue = 0.0d;

    public ReactSlider(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setLayoutDirection(I18nUtil.getInstance().isRTL(context) ? 1 : 0);
        disableStateListAnimatorIfNeeded();
    }

    private void disableStateListAnimatorIfNeeded() {
        if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT < 26) {
            super.setStateListAnimator((StateListAnimator) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void setMaxValue(double d) {
        this.mMaxValue = d;
        updateAll();
    }

    /* access modifiers changed from: package-private */
    public void setMinValue(double d) {
        this.mMinValue = d;
        updateAll();
    }

    /* access modifiers changed from: package-private */
    public void setValue(double d) {
        this.mValue = d;
        updateValue();
    }

    /* access modifiers changed from: package-private */
    public void setStep(double d) {
        this.mStep = d;
        updateAll();
    }

    /* access modifiers changed from: package-private */
    public void setLowerLimit(double d) {
        this.mRealLowerLimit = d;
        updateLowerLimit();
    }

    /* access modifiers changed from: package-private */
    public void setUpperLimit(double d) {
        this.mRealUpperLimit = d;
        updateUpperLimit();
    }

    /* access modifiers changed from: package-private */
    public int getLowerLimit() {
        return this.mLowerLimit;
    }

    /* access modifiers changed from: package-private */
    public int getUpperLimit() {
        return this.mUpperLimit;
    }

    /* access modifiers changed from: package-private */
    public boolean isSliding() {
        return this.isSliding;
    }

    /* access modifiers changed from: package-private */
    public void isSliding(boolean z) {
        this.isSliding = z;
    }

    /* access modifiers changed from: package-private */
    public void setAccessibilityUnits(String str) {
        this.mAccessibilityUnits = str;
    }

    /* access modifiers changed from: package-private */
    public void setAccessibilityIncrements(List<String> list) {
        this.mAccessibilityIncrements = list;
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32768 || (accessibilityEvent.getEventType() == 4 && isAccessibilityFocused())) {
            setupAccessibility((int) this.mValue);
        }
    }

    public void announceForAccessibility(CharSequence charSequence) {
        Context context = getContext();
        final AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            final AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(16384);
            obtain.setClassName(getClass().getName());
            obtain.setPackageName(context.getPackageName());
            obtain.getText().add(charSequence);
            new Timer().schedule(new TimerTask() {
                public void run() {
                    accessibilityManager.sendAccessibilityEvent(obtain);
                }
            }, 1000);
        }
    }

    public void setupAccessibility(int i) {
        List<String> list;
        if (this.mAccessibilityUnits != null && (list = this.mAccessibilityIncrements) != null && list.size() - 1 == ((int) this.mMaxValue)) {
            String str = this.mAccessibilityIncrements.get(i);
            int length = this.mAccessibilityUnits.length();
            String str2 = this.mAccessibilityUnits;
            if (str != null && Integer.parseInt(str) == 1) {
                str2 = str2.substring(0, length - 1);
            }
            announceForAccessibility(String.format("%s %s", new Object[]{str, str2}));
        }
    }

    public double toRealProgress(int i) {
        if (i == getMax()) {
            return this.mMaxValue;
        }
        return (((double) i) * getStepValue()) + this.mMinValue;
    }

    private void updateAll() {
        if (this.mStep == 0.0d) {
            this.mStepCalculated = (this.mMaxValue - this.mMinValue) / ((double) DEFAULT_TOTAL_STEPS);
        }
        setMax(getTotalSteps());
        updateLowerLimit();
        updateUpperLimit();
        updateValue();
    }

    private void updateLowerLimit() {
        double max = Math.max(this.mRealLowerLimit, this.mMinValue);
        double d = this.mMinValue;
        this.mLowerLimit = (int) Math.round(((max - d) / (this.mMaxValue - d)) * ((double) getTotalSteps()));
    }

    private void updateUpperLimit() {
        double min = Math.min(this.mRealUpperLimit, this.mMaxValue);
        double d = this.mMinValue;
        this.mUpperLimit = (int) Math.round(((min - d) / (this.mMaxValue - d)) * ((double) getTotalSteps()));
    }

    private void updateValue() {
        double d = this.mValue;
        double d2 = this.mMinValue;
        setProgress((int) Math.round(((d - d2) / (this.mMaxValue - d2)) * ((double) getTotalSteps())));
    }

    private int getTotalSteps() {
        return (int) Math.ceil((this.mMaxValue - this.mMinValue) / getStepValue());
    }

    private double getStepValue() {
        double d = this.mStep;
        return d > 0.0d ? d : this.mStepCalculated;
    }

    private BitmapDrawable getBitmapDrawable(final String str) {
        try {
            return (BitmapDrawable) Executors.newSingleThreadExecutor().submit(new Callable<BitmapDrawable>() {
                public BitmapDrawable call() {
                    Bitmap bitmap;
                    try {
                        if (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("file://") && !str.startsWith("asset://")) {
                            if (!str.startsWith("data:")) {
                                bitmap = BitmapFactory.decodeResource(ReactSlider.this.getResources(), ReactSlider.this.getResources().getIdentifier(str, "drawable", ReactSlider.this.getContext().getPackageName()));
                                return new BitmapDrawable(ReactSlider.this.getResources(), bitmap);
                            }
                        }
                        bitmap = BitmapFactory.decodeStream(new URL(str).openStream());
                        return new BitmapDrawable(ReactSlider.this.getResources(), bitmap);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setThumbImage(String str) {
        if (str != null) {
            setThumb(getBitmapDrawable(str));
            if (Build.VERSION.SDK_INT >= 21) {
                setSplitTrack(false);
                return;
            }
            return;
        }
        setThumb(getThumb());
    }
}
