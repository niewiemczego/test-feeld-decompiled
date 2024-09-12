package androidx.biometric;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class FingerprintDialogFragment extends DialogFragment {
    private static final int MESSAGE_DISPLAY_TIME_MS = 2000;
    static final int STATE_FINGERPRINT = 1;
    static final int STATE_FINGERPRINT_AUTHENTICATED = 3;
    static final int STATE_FINGERPRINT_ERROR = 2;
    static final int STATE_NONE = 0;
    private static final String TAG = "FingerprintFragment";
    private int mErrorTextColor;
    private ImageView mFingerprintIcon;
    final Handler mHandler = new Handler(Looper.getMainLooper());
    TextView mHelpMessageView;
    private int mNormalTextColor;
    final Runnable mResetDialogRunnable = new Runnable() {
        public void run() {
            FingerprintDialogFragment.this.resetDialog();
        }
    };
    BiometricViewModel mViewModel;

    private boolean shouldAnimateForTransition(int i, int i2) {
        if (i == 0 && i2 == 1) {
            return false;
        }
        if (i == 1 && i2 == 2) {
            return true;
        }
        return i == 2 && i2 == 1;
    }

    static FingerprintDialogFragment newInstance() {
        return new FingerprintDialogFragment();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        connectViewModel();
        if (Build.VERSION.SDK_INT >= 26) {
            this.mErrorTextColor = getThemedColorFor(Api26Impl.getColorErrorAttr());
        } else {
            Context context = getContext();
            this.mErrorTextColor = context != null ? ContextCompat.getColor(context, R.color.biometric_error_color) : 0;
        }
        this.mNormalTextColor = getThemedColorFor(16842808);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        CharSequence charSequence;
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle(this.mViewModel.getTitle());
        View inflate = LayoutInflater.from(builder.getContext()).inflate(R.layout.fingerprint_dialog_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.fingerprint_subtitle);
        if (textView != null) {
            CharSequence subtitle = this.mViewModel.getSubtitle();
            if (TextUtils.isEmpty(subtitle)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(subtitle);
            }
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.fingerprint_description);
        if (textView2 != null) {
            CharSequence description = this.mViewModel.getDescription();
            if (TextUtils.isEmpty(description)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(description);
            }
        }
        this.mFingerprintIcon = (ImageView) inflate.findViewById(R.id.fingerprint_icon);
        this.mHelpMessageView = (TextView) inflate.findViewById(R.id.fingerprint_error);
        if (AuthenticatorUtils.isDeviceCredentialAllowed(this.mViewModel.getAllowedAuthenticators())) {
            charSequence = getString(R.string.confirm_device_credential_password);
        } else {
            charSequence = this.mViewModel.getNegativeButtonText();
        }
        builder.setNegativeButton(charSequence, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                FingerprintDialogFragment.this.mViewModel.setNegativeButtonPressPending(true);
            }
        });
        builder.setView(inflate);
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        return create;
    }

    public void onResume() {
        super.onResume();
        this.mViewModel.setFingerprintDialogPreviousState(0);
        this.mViewModel.setFingerprintDialogState(1);
        this.mViewModel.setFingerprintDialogHelpMessage(getString(R.string.fingerprint_dialog_touch_sensor));
    }

    public void onPause() {
        super.onPause();
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        this.mViewModel.setFingerprintDialogCancelPending(true);
    }

    private void connectViewModel() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            BiometricViewModel biometricViewModel = (BiometricViewModel) new ViewModelProvider(activity).get(BiometricViewModel.class);
            this.mViewModel = biometricViewModel;
            biometricViewModel.getFingerprintDialogState().observe(this, new Observer<Integer>() {
                public void onChanged(Integer num) {
                    FingerprintDialogFragment.this.mHandler.removeCallbacks(FingerprintDialogFragment.this.mResetDialogRunnable);
                    FingerprintDialogFragment.this.updateFingerprintIcon(num.intValue());
                    FingerprintDialogFragment.this.updateHelpMessageColor(num.intValue());
                    FingerprintDialogFragment.this.mHandler.postDelayed(FingerprintDialogFragment.this.mResetDialogRunnable, 2000);
                }
            });
            this.mViewModel.getFingerprintDialogHelpMessage().observe(this, new Observer<CharSequence>() {
                public void onChanged(CharSequence charSequence) {
                    FingerprintDialogFragment.this.mHandler.removeCallbacks(FingerprintDialogFragment.this.mResetDialogRunnable);
                    FingerprintDialogFragment.this.updateHelpMessageText(charSequence);
                    FingerprintDialogFragment.this.mHandler.postDelayed(FingerprintDialogFragment.this.mResetDialogRunnable, 2000);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000b, code lost:
        r0 = r3.mViewModel.getFingerprintDialogPreviousState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateFingerprintIcon(int r4) {
        /*
            r3 = this;
            android.widget.ImageView r0 = r3.mFingerprintIcon
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 < r1) goto L_0x002b
            androidx.biometric.BiometricViewModel r0 = r3.mViewModel
            int r0 = r0.getFingerprintDialogPreviousState()
            android.graphics.drawable.Drawable r1 = r3.getAssetForTransition(r0, r4)
            if (r1 != 0) goto L_0x0018
            return
        L_0x0018:
            android.widget.ImageView r2 = r3.mFingerprintIcon
            r2.setImageDrawable(r1)
            boolean r0 = r3.shouldAnimateForTransition(r0, r4)
            if (r0 == 0) goto L_0x0026
            androidx.biometric.FingerprintDialogFragment.Api21Impl.startAnimation(r1)
        L_0x0026:
            androidx.biometric.BiometricViewModel r0 = r3.mViewModel
            r0.setFingerprintDialogPreviousState(r4)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.biometric.FingerprintDialogFragment.updateFingerprintIcon(int):void");
    }

    /* access modifiers changed from: package-private */
    public void updateHelpMessageColor(int i) {
        TextView textView = this.mHelpMessageView;
        if (textView != null) {
            textView.setTextColor(i == 2 ? this.mErrorTextColor : this.mNormalTextColor);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateHelpMessageText(CharSequence charSequence) {
        TextView textView = this.mHelpMessageView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    public void resetDialog() {
        Context context = getContext();
        if (context == null) {
            Log.w(TAG, "Not resetting the dialog. Context is null.");
            return;
        }
        this.mViewModel.setFingerprintDialogState(1);
        this.mViewModel.setFingerprintDialogHelpMessage(context.getString(R.string.fingerprint_dialog_touch_sensor));
    }

    private int getThemedColorFor(int i) {
        Context context = getContext();
        FragmentActivity activity = getActivity();
        if (context == null || activity == null) {
            Log.w(TAG, "Unable to get themed color. Context or activity is null.");
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(typedValue.data, new int[]{i});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    private Drawable getAssetForTransition(int i, int i2) {
        int i3;
        Context context = getContext();
        if (context == null) {
            Log.w(TAG, "Unable to get asset. Context is null.");
            return null;
        }
        if (i == 0 && i2 == 1) {
            i3 = R.drawable.fingerprint_dialog_fp_icon;
        } else if (i == 1 && i2 == 2) {
            i3 = R.drawable.fingerprint_dialog_error;
        } else if (i == 2 && i2 == 1) {
            i3 = R.drawable.fingerprint_dialog_fp_icon;
        } else if (i != 1 || i2 != 3) {
            return null;
        } else {
            i3 = R.drawable.fingerprint_dialog_fp_icon;
        }
        return ContextCompat.getDrawable(context, i3);
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        static int getColorErrorAttr() {
            return R.attr.colorError;
        }
    }

    private static class Api21Impl {
        private Api21Impl() {
        }

        static void startAnimation(Drawable drawable) {
            if (drawable instanceof AnimatedVectorDrawable) {
                ((AnimatedVectorDrawable) drawable).start();
            }
        }
    }
}
