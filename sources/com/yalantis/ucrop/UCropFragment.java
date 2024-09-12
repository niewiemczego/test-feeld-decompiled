package com.yalantis.ucrop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.util.SelectedStateListDrawable;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class UCropFragment extends Fragment {
    public static final int ALL = 3;
    private static final long CONTROLS_ANIMATION_DURATION = 50;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
    public static final int DEFAULT_COMPRESS_QUALITY = 90;
    public static final int NONE = 0;
    public static final int ROTATE = 2;
    private static final int ROTATE_WIDGET_SENSITIVITY_COEFFICIENT = 42;
    public static final int SCALE = 1;
    private static final int SCALE_WIDGET_SENSITIVITY_COEFFICIENT = 15000;
    private static final int TABS_COUNT = 3;
    public static final String TAG = "UCropFragment";
    /* access modifiers changed from: private */
    public UCropFragmentCallback callback;
    private int mActiveControlsWidgetColor;
    private int[] mAllowedGestures = {1, 2, 3};
    /* access modifiers changed from: private */
    public View mBlockingView;
    private Bitmap.CompressFormat mCompressFormat = DEFAULT_COMPRESS_FORMAT;
    private int mCompressQuality = 90;
    private Transition mControlsTransition;
    /* access modifiers changed from: private */
    public List<ViewGroup> mCropAspectRatioViews = new ArrayList();
    /* access modifiers changed from: private */
    public GestureCropImageView mGestureCropImageView;
    private TransformImageView.TransformImageListener mImageListener = new TransformImageView.TransformImageListener() {
        public void onRotate(float f) {
            UCropFragment.this.setAngleText(f);
        }

        public void onScale(float f) {
            UCropFragment.this.setScaleText(f);
        }

        public void onLoadComplete() {
            UCropFragment.this.mUCropView.animate().alpha(1.0f).setDuration(300).setInterpolator(new AccelerateInterpolator());
            UCropFragment.this.mBlockingView.setClickable(false);
            UCropFragment.this.callback.loadingProgress(false);
        }

        public void onLoadFailure(Exception exc) {
            UCropFragment.this.callback.onCropFinish(UCropFragment.this.getError(exc));
        }
    };
    private ViewGroup mLayoutAspectRatio;
    private ViewGroup mLayoutRotate;
    private ViewGroup mLayoutScale;
    private int mLogoColor;
    private OverlayView mOverlayView;
    private int mRootViewBackgroundColor;
    private boolean mShowBottomControls;
    private final View.OnClickListener mStateClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            if (!view.isSelected()) {
                UCropFragment.this.setWidgetState(view.getId());
            }
        }
    };
    private TextView mTextViewRotateAngle;
    private TextView mTextViewScalePercent;
    /* access modifiers changed from: private */
    public UCropView mUCropView;
    private ViewGroup mWrapperStateAspectRatio;
    private ViewGroup mWrapperStateRotate;
    private ViewGroup mWrapperStateScale;

    @Retention(RetentionPolicy.SOURCE)
    public @interface GestureTypes {
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public static UCropFragment newInstance(Bundle bundle) {
        UCropFragment uCropFragment = new UCropFragment();
        uCropFragment.setArguments(bundle);
        return uCropFragment;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() instanceof UCropFragmentCallback) {
            this.callback = (UCropFragmentCallback) getParentFragment();
        } else if (context instanceof UCropFragmentCallback) {
            this.callback = (UCropFragmentCallback) context;
        } else {
            throw new IllegalArgumentException(context.toString() + " must implement UCropFragmentCallback");
        }
    }

    public void setCallback(UCropFragmentCallback uCropFragmentCallback) {
        this.callback = uCropFragmentCallback;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ucrop_fragment_photobox, viewGroup, false);
        Bundle arguments = getArguments();
        setupViews(inflate, arguments);
        setImageData(arguments);
        setInitialState();
        addBlockingView(inflate);
        return inflate;
    }

    public void setupViews(View view, Bundle bundle) {
        this.mActiveControlsWidgetColor = bundle.getInt(UCrop.Options.EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE, ContextCompat.getColor(getContext(), R.color.ucrop_color_widget_active));
        this.mLogoColor = bundle.getInt(UCrop.Options.EXTRA_UCROP_LOGO_COLOR, ContextCompat.getColor(getContext(), R.color.ucrop_color_default_logo));
        this.mShowBottomControls = !bundle.getBoolean(UCrop.Options.EXTRA_HIDE_BOTTOM_CONTROLS, false);
        this.mRootViewBackgroundColor = bundle.getInt(UCrop.Options.EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR, ContextCompat.getColor(getContext(), R.color.ucrop_color_crop_background));
        initiateRootViews(view);
        this.callback.loadingProgress(true);
        if (this.mShowBottomControls) {
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.controls_wrapper);
            viewGroup.setVisibility(0);
            LayoutInflater.from(getContext()).inflate(R.layout.ucrop_controls, viewGroup, true);
            AutoTransition autoTransition = new AutoTransition();
            this.mControlsTransition = autoTransition;
            autoTransition.setDuration(CONTROLS_ANIMATION_DURATION);
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.state_aspect_ratio);
            this.mWrapperStateAspectRatio = viewGroup2;
            viewGroup2.setOnClickListener(this.mStateClickListener);
            ViewGroup viewGroup3 = (ViewGroup) view.findViewById(R.id.state_rotate);
            this.mWrapperStateRotate = viewGroup3;
            viewGroup3.setOnClickListener(this.mStateClickListener);
            ViewGroup viewGroup4 = (ViewGroup) view.findViewById(R.id.state_scale);
            this.mWrapperStateScale = viewGroup4;
            viewGroup4.setOnClickListener(this.mStateClickListener);
            this.mLayoutAspectRatio = (ViewGroup) view.findViewById(R.id.layout_aspect_ratio);
            this.mLayoutRotate = (ViewGroup) view.findViewById(R.id.layout_rotate_wheel);
            this.mLayoutScale = (ViewGroup) view.findViewById(R.id.layout_scale_wheel);
            setupAspectRatioWidget(bundle, view);
            setupRotateWidget(view);
            setupScaleWidget(view);
            setupStatesWrapper(view);
            return;
        }
        ((RelativeLayout.LayoutParams) view.findViewById(R.id.ucrop_frame).getLayoutParams()).bottomMargin = 0;
        view.findViewById(R.id.ucrop_frame).requestLayout();
    }

    private void setImageData(Bundle bundle) {
        Uri uri = (Uri) bundle.getParcelable(UCrop.EXTRA_INPUT_URI);
        Uri uri2 = (Uri) bundle.getParcelable(UCrop.EXTRA_OUTPUT_URI);
        processOptions(bundle);
        if (uri == null || uri2 == null) {
            this.callback.onCropFinish(getError(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent))));
            return;
        }
        try {
            this.mGestureCropImageView.setImageUri(uri, uri2);
        } catch (Exception e) {
            this.callback.onCropFinish(getError(e));
        }
    }

    private void processOptions(Bundle bundle) {
        String string = bundle.getString(UCrop.Options.EXTRA_COMPRESSION_FORMAT_NAME);
        Bitmap.CompressFormat valueOf = !TextUtils.isEmpty(string) ? Bitmap.CompressFormat.valueOf(string) : null;
        if (valueOf == null) {
            valueOf = DEFAULT_COMPRESS_FORMAT;
        }
        this.mCompressFormat = valueOf;
        this.mCompressQuality = bundle.getInt(UCrop.Options.EXTRA_COMPRESSION_QUALITY, 90);
        int[] intArray = bundle.getIntArray(UCrop.Options.EXTRA_ALLOWED_GESTURES);
        if (intArray != null && intArray.length == 3) {
            this.mAllowedGestures = intArray;
        }
        this.mGestureCropImageView.setMaxBitmapSize(bundle.getInt(UCrop.Options.EXTRA_MAX_BITMAP_SIZE, 0));
        this.mGestureCropImageView.setMaxScaleMultiplier(bundle.getFloat(UCrop.Options.EXTRA_MAX_SCALE_MULTIPLIER, 10.0f));
        this.mGestureCropImageView.setImageToWrapCropBoundsAnimDuration((long) bundle.getInt(UCrop.Options.EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, 500));
        this.mOverlayView.setFreestyleCropEnabled(bundle.getBoolean(UCrop.Options.EXTRA_FREE_STYLE_CROP, false));
        this.mOverlayView.setDimmedColor(bundle.getInt(UCrop.Options.EXTRA_DIMMED_LAYER_COLOR, getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.mOverlayView.setCircleDimmedLayer(bundle.getBoolean(UCrop.Options.EXTRA_CIRCLE_DIMMED_LAYER, false));
        this.mOverlayView.setShowCropFrame(bundle.getBoolean(UCrop.Options.EXTRA_SHOW_CROP_FRAME, true));
        this.mOverlayView.setCropFrameColor(bundle.getInt(UCrop.Options.EXTRA_CROP_FRAME_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.mOverlayView.setCropFrameStrokeWidth(bundle.getInt(UCrop.Options.EXTRA_CROP_FRAME_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.mOverlayView.setShowCropGrid(bundle.getBoolean(UCrop.Options.EXTRA_SHOW_CROP_GRID, true));
        this.mOverlayView.setCropGridRowCount(bundle.getInt(UCrop.Options.EXTRA_CROP_GRID_ROW_COUNT, 2));
        this.mOverlayView.setCropGridColumnCount(bundle.getInt(UCrop.Options.EXTRA_CROP_GRID_COLUMN_COUNT, 2));
        this.mOverlayView.setCropGridColor(bundle.getInt(UCrop.Options.EXTRA_CROP_GRID_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.mOverlayView.setCropGridStrokeWidth(bundle.getInt(UCrop.Options.EXTRA_CROP_GRID_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float f = bundle.getFloat(UCrop.EXTRA_ASPECT_RATIO_X, 0.0f);
        float f2 = bundle.getFloat(UCrop.EXTRA_ASPECT_RATIO_Y, 0.0f);
        int i = bundle.getInt(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (f > 0.0f && f2 > 0.0f) {
            ViewGroup viewGroup = this.mWrapperStateAspectRatio;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.mGestureCropImageView.setTargetAspectRatio(f / f2);
        } else if (parcelableArrayList == null || i >= parcelableArrayList.size()) {
            this.mGestureCropImageView.setTargetAspectRatio(0.0f);
        } else {
            this.mGestureCropImageView.setTargetAspectRatio(((AspectRatio) parcelableArrayList.get(i)).getAspectRatioX() / ((AspectRatio) parcelableArrayList.get(i)).getAspectRatioY());
        }
        int i2 = bundle.getInt(UCrop.EXTRA_MAX_SIZE_X, 0);
        int i3 = bundle.getInt(UCrop.EXTRA_MAX_SIZE_Y, 0);
        if (i2 > 0 && i3 > 0) {
            this.mGestureCropImageView.setMaxResultImageSizeX(i2);
            this.mGestureCropImageView.setMaxResultImageSizeY(i3);
        }
    }

    private void initiateRootViews(View view) {
        UCropView uCropView = (UCropView) view.findViewById(R.id.ucrop);
        this.mUCropView = uCropView;
        this.mGestureCropImageView = uCropView.getCropImageView();
        this.mOverlayView = this.mUCropView.getOverlayView();
        this.mGestureCropImageView.setTransformImageListener(this.mImageListener);
        ((ImageView) view.findViewById(R.id.image_view_logo)).setColorFilter(this.mLogoColor, PorterDuff.Mode.SRC_ATOP);
        view.findViewById(R.id.ucrop_frame).setBackgroundColor(this.mRootViewBackgroundColor);
    }

    private void setupStatesWrapper(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new SelectedStateListDrawable(imageView.getDrawable(), this.mActiveControlsWidgetColor));
        imageView2.setImageDrawable(new SelectedStateListDrawable(imageView2.getDrawable(), this.mActiveControlsWidgetColor));
        imageView3.setImageDrawable(new SelectedStateListDrawable(imageView3.getDrawable(), this.mActiveControlsWidgetColor));
    }

    private void setupAspectRatioWidget(Bundle bundle, View view) {
        int i = bundle.getInt(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            i = 2;
            parcelableArrayList = new ArrayList();
            parcelableArrayList.add(new AspectRatio((String) null, 1.0f, 1.0f));
            parcelableArrayList.add(new AspectRatio((String) null, 3.0f, 4.0f));
            parcelableArrayList.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayList.add(new AspectRatio((String) null, 3.0f, 2.0f));
            parcelableArrayList.add(new AspectRatio((String) null, 16.0f, 9.0f));
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.mActiveControlsWidgetColor);
            aspectRatioTextView.setAspectRatio((AspectRatio) it.next());
            linearLayout.addView(frameLayout);
            this.mCropAspectRatioViews.add(frameLayout);
        }
        this.mCropAspectRatioViews.get(i).setSelected(true);
        for (ViewGroup onClickListener : this.mCropAspectRatioViews) {
            onClickListener.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    UCropFragment.this.mGestureCropImageView.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).getAspectRatio(view.isSelected()));
                    UCropFragment.this.mGestureCropImageView.setImageToWrapCropBounds();
                    if (!view.isSelected()) {
                        for (ViewGroup viewGroup : UCropFragment.this.mCropAspectRatioViews) {
                            viewGroup.setSelected(viewGroup == view);
                        }
                    }
                }
            });
        }
    }

    private void setupRotateWidget(View view) {
        this.mTextViewRotateAngle = (TextView) view.findViewById(R.id.text_view_rotate);
        ((HorizontalProgressWheelView) view.findViewById(R.id.rotate_scroll_wheel)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() {
            public void onScroll(float f, float f2) {
                UCropFragment.this.mGestureCropImageView.postRotate(f / 42.0f);
            }

            public void onScrollEnd() {
                UCropFragment.this.mGestureCropImageView.setImageToWrapCropBounds();
            }

            public void onScrollStart() {
                UCropFragment.this.mGestureCropImageView.cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView) view.findViewById(R.id.rotate_scroll_wheel)).setMiddleLineColor(this.mActiveControlsWidgetColor);
        view.findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UCropFragment.this.resetRotation();
            }
        });
        view.findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UCropFragment.this.rotateByAngle(90);
            }
        });
        setAngleTextColor(this.mActiveControlsWidgetColor);
    }

    private void setupScaleWidget(View view) {
        this.mTextViewScalePercent = (TextView) view.findViewById(R.id.text_view_scale);
        ((HorizontalProgressWheelView) view.findViewById(R.id.scale_scroll_wheel)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() {
            public void onScroll(float f, float f2) {
                if (f > 0.0f) {
                    UCropFragment.this.mGestureCropImageView.zoomInImage(UCropFragment.this.mGestureCropImageView.getCurrentScale() + (f * ((UCropFragment.this.mGestureCropImageView.getMaxScale() - UCropFragment.this.mGestureCropImageView.getMinScale()) / 15000.0f)));
                } else {
                    UCropFragment.this.mGestureCropImageView.zoomOutImage(UCropFragment.this.mGestureCropImageView.getCurrentScale() + (f * ((UCropFragment.this.mGestureCropImageView.getMaxScale() - UCropFragment.this.mGestureCropImageView.getMinScale()) / 15000.0f)));
                }
            }

            public void onScrollEnd() {
                UCropFragment.this.mGestureCropImageView.setImageToWrapCropBounds();
            }

            public void onScrollStart() {
                UCropFragment.this.mGestureCropImageView.cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView) view.findViewById(R.id.scale_scroll_wheel)).setMiddleLineColor(this.mActiveControlsWidgetColor);
        setScaleTextColor(this.mActiveControlsWidgetColor);
    }

    /* access modifiers changed from: private */
    public void setAngleText(float f) {
        TextView textView = this.mTextViewRotateAngle;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", new Object[]{Float.valueOf(f)}));
        }
    }

    private void setAngleTextColor(int i) {
        TextView textView = this.mTextViewRotateAngle;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    /* access modifiers changed from: private */
    public void setScaleText(float f) {
        TextView textView = this.mTextViewScalePercent;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", new Object[]{Integer.valueOf((int) (f * 100.0f))}));
        }
    }

    private void setScaleTextColor(int i) {
        TextView textView = this.mTextViewScalePercent;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    /* access modifiers changed from: private */
    public void resetRotation() {
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        gestureCropImageView.postRotate(-gestureCropImageView.getCurrentAngle());
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    /* access modifiers changed from: private */
    public void rotateByAngle(int i) {
        this.mGestureCropImageView.postRotate((float) i);
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    private void setInitialState() {
        if (!this.mShowBottomControls) {
            setAllowedGestures(0);
        } else if (this.mWrapperStateAspectRatio.getVisibility() == 0) {
            setWidgetState(R.id.state_aspect_ratio);
        } else {
            setWidgetState(R.id.state_scale);
        }
    }

    /* access modifiers changed from: private */
    public void setWidgetState(int i) {
        if (this.mShowBottomControls) {
            this.mWrapperStateAspectRatio.setSelected(i == R.id.state_aspect_ratio);
            this.mWrapperStateRotate.setSelected(i == R.id.state_rotate);
            this.mWrapperStateScale.setSelected(i == R.id.state_scale);
            int i2 = 8;
            this.mLayoutAspectRatio.setVisibility(i == R.id.state_aspect_ratio ? 0 : 8);
            this.mLayoutRotate.setVisibility(i == R.id.state_rotate ? 0 : 8);
            ViewGroup viewGroup = this.mLayoutScale;
            if (i == R.id.state_scale) {
                i2 = 0;
            }
            viewGroup.setVisibility(i2);
            changeSelectedTab(i);
            if (i == R.id.state_scale) {
                setAllowedGestures(0);
            } else if (i == R.id.state_rotate) {
                setAllowedGestures(1);
            } else {
                setAllowedGestures(2);
            }
        }
    }

    private void changeSelectedTab(int i) {
        if (getView() != null) {
            TransitionManager.beginDelayedTransition((ViewGroup) getView().findViewById(R.id.ucrop_photobox), this.mControlsTransition);
        }
        int i2 = 0;
        this.mWrapperStateScale.findViewById(R.id.text_view_scale).setVisibility(i == R.id.state_scale ? 0 : 8);
        this.mWrapperStateAspectRatio.findViewById(R.id.text_view_crop).setVisibility(i == R.id.state_aspect_ratio ? 0 : 8);
        View findViewById = this.mWrapperStateRotate.findViewById(R.id.text_view_rotate);
        if (i != R.id.state_rotate) {
            i2 = 8;
        }
        findViewById.setVisibility(i2);
    }

    private void setAllowedGestures(int i) {
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        int i2 = this.mAllowedGestures[i];
        boolean z = false;
        gestureCropImageView.setScaleEnabled(i2 == 3 || i2 == 1);
        GestureCropImageView gestureCropImageView2 = this.mGestureCropImageView;
        int i3 = this.mAllowedGestures[i];
        if (i3 == 3 || i3 == 2) {
            z = true;
        }
        gestureCropImageView2.setRotateEnabled(z);
    }

    private void addBlockingView(View view) {
        if (this.mBlockingView == null) {
            this.mBlockingView = new View(getContext());
            this.mBlockingView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.mBlockingView.setClickable(true);
        }
        ((RelativeLayout) view.findViewById(R.id.ucrop_photobox)).addView(this.mBlockingView);
    }

    public void cropAndSaveImage() {
        this.mBlockingView.setClickable(true);
        this.callback.loadingProgress(true);
        this.mGestureCropImageView.cropAndSaveImage(this.mCompressFormat, this.mCompressQuality, new BitmapCropCallback() {
            public void onBitmapCropped(Uri uri, int i, int i2, int i3, int i4) {
                UCropFragmentCallback access$400 = UCropFragment.this.callback;
                UCropFragment uCropFragment = UCropFragment.this;
                access$400.onCropFinish(uCropFragment.getResult(uri, uCropFragment.mGestureCropImageView.getTargetAspectRatio(), i, i2, i3, i4));
                UCropFragment.this.callback.loadingProgress(false);
            }

            public void onCropFailure(Throwable th) {
                UCropFragment.this.callback.onCropFinish(UCropFragment.this.getError(th));
            }
        });
    }

    /* access modifiers changed from: protected */
    public UCropResult getResult(Uri uri, float f, int i, int i2, int i3, int i4) {
        return new UCropResult(-1, new Intent().putExtra(UCrop.EXTRA_OUTPUT_URI, uri).putExtra(UCrop.EXTRA_OUTPUT_CROP_ASPECT_RATIO, f).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, i3).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, i4).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_X, i).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_Y, i2));
    }

    /* access modifiers changed from: protected */
    public UCropResult getError(Throwable th) {
        return new UCropResult(96, new Intent().putExtra(UCrop.EXTRA_ERROR, th));
    }

    public class UCropResult {
        public int mResultCode;
        public Intent mResultData;

        public UCropResult(int i, Intent intent) {
            this.mResultCode = i;
            this.mResultData = intent;
        }
    }
}
