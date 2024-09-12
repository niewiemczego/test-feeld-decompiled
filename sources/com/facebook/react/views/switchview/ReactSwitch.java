package com.facebook.react.views.switchview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.appcompat.widget.SwitchCompat;

class ReactSwitch extends SwitchCompat {
    private boolean mAllowChange = true;
    private Integer mTrackColorForFalse = null;
    private Integer mTrackColorForTrue = null;

    public ReactSwitch(Context context) {
        super(context);
    }

    public void setChecked(boolean z) {
        if (!this.mAllowChange || isChecked() == z) {
            super.setChecked(isChecked());
            return;
        }
        this.mAllowChange = false;
        super.setChecked(z);
        setTrackColor(z);
    }

    public void setBackgroundColor(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            setBackground(new RippleDrawable(createRippleDrawableColorStateList(Integer.valueOf(i)), new ColorDrawable(i), (Drawable) null));
        } else {
            super.setBackgroundColor(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void setColor(Drawable drawable, Integer num) {
        if (num == null) {
            drawable.clearColorFilter();
        } else {
            drawable.setColorFilter(num.intValue(), PorterDuff.Mode.MULTIPLY);
        }
    }

    public void setTrackColor(Integer num) {
        setColor(super.getTrackDrawable(), num);
    }

    public void setThumbColor(Integer num) {
        setColor(super.getThumbDrawable(), num);
        if (num != null && (super.getBackground() instanceof RippleDrawable)) {
            ((RippleDrawable) super.getBackground()).setColor(createRippleDrawableColorStateList(num));
        }
    }

    /* access modifiers changed from: package-private */
    public void setOn(boolean z) {
        if (isChecked() != z) {
            super.setChecked(z);
            setTrackColor(z);
        }
        this.mAllowChange = true;
    }

    public void setTrackColorForTrue(Integer num) {
        if (num != this.mTrackColorForTrue) {
            this.mTrackColorForTrue = num;
            if (isChecked()) {
                setTrackColor(this.mTrackColorForTrue);
            }
        }
    }

    public void setTrackColorForFalse(Integer num) {
        if (num != this.mTrackColorForFalse) {
            this.mTrackColorForFalse = num;
            if (!isChecked()) {
                setTrackColor(this.mTrackColorForFalse);
            }
        }
    }

    private void setTrackColor(boolean z) {
        Integer num = this.mTrackColorForTrue;
        if (num != null || this.mTrackColorForFalse != null) {
            if (!z) {
                num = this.mTrackColorForFalse;
            }
            setTrackColor(num);
        }
    }

    private ColorStateList createRippleDrawableColorStateList(Integer num) {
        return new ColorStateList(new int[][]{new int[]{16842919}}, new int[]{num.intValue()});
    }
}
