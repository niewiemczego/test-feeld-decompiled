package com.facebook.react.views.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.facebook.common.internal.Objects;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.ForwardingControllerListener;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.fresco.ReactNetworkImageRequest;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.imagehelper.ImageSource;
import com.facebook.react.views.imagehelper.MultiSourceHelper;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.yoga.YogaConstants;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReactImageView extends GenericDraweeView {
    public static final int REMOTE_IMAGE_FADE_DURATION_MS = 300;
    private static float[] sComputedCornerRadii = new float[4];
    /* access modifiers changed from: private */
    public static final Matrix sTileMatrix = new Matrix();
    private int mBackgroundColor = 0;
    private RoundedColorDrawable mBackgroundImageDrawable;
    private int mBorderColor;
    private float[] mBorderCornerRadii;
    private float mBorderRadius = Float.NaN;
    private float mBorderWidth;
    private ImageSource mCachedImageSource;
    private Object mCallerContext;
    private ControllerListener mControllerForTesting;
    private Drawable mDefaultImageDrawable;
    private ReactImageDownloadListener mDownloadListener;
    private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    private int mFadeDurationMs = -1;
    private GlobalImageLoadListener mGlobalImageLoadListener;
    private ReadableMap mHeaders;
    /* access modifiers changed from: private */
    public ImageSource mImageSource;
    private boolean mIsDirty;
    private IterativeBoxBlurPostProcessor mIterativeBoxBlurPostProcessor;
    private Drawable mLoadingImageDrawable;
    private int mOverlayColor;
    private boolean mProgressiveRenderingEnabled;
    private ImageResizeMethod mResizeMethod = ImageResizeMethod.AUTO;
    /* access modifiers changed from: private */
    public ScalingUtils.ScaleType mScaleType = ImageResizeMode.defaultValue();
    private final List<ImageSource> mSources = new LinkedList();
    /* access modifiers changed from: private */
    public Shader.TileMode mTileMode = ImageResizeMode.defaultTileMode();
    private TilePostprocessor mTilePostprocessor;

    private void warnImageSource(String str) {
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public void updateCallerContext(Object obj) {
        if (!Objects.equal(this.mCallerContext, obj)) {
            this.mCallerContext = obj;
            this.mIsDirty = true;
        }
    }

    private class TilePostprocessor extends BasePostprocessor {
        private TilePostprocessor() {
        }

        public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
            Rect rect = new Rect(0, 0, ReactImageView.this.getWidth(), ReactImageView.this.getHeight());
            ReactImageView.this.mScaleType.getTransform(ReactImageView.sTileMatrix, rect, bitmap.getWidth(), bitmap.getHeight(), 0.0f, 0.0f);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            BitmapShader bitmapShader = new BitmapShader(bitmap, ReactImageView.this.mTileMode, ReactImageView.this.mTileMode);
            bitmapShader.setLocalMatrix(ReactImageView.sTileMatrix);
            paint.setShader(bitmapShader);
            CloseableReference<Bitmap> createBitmap = platformBitmapFactory.createBitmap(ReactImageView.this.getWidth(), ReactImageView.this.getHeight());
            try {
                new Canvas(createBitmap.get()).drawRect(rect, paint);
                return createBitmap.clone();
            } finally {
                CloseableReference.closeSafely((CloseableReference<?>) createBitmap);
            }
        }
    }

    private static GenericDraweeHierarchy buildHierarchy(Context context) {
        RoundingParams fromCornersRadius = RoundingParams.fromCornersRadius(0.0f);
        fromCornersRadius.setPaintFilterBitmap(true);
        return new GenericDraweeHierarchyBuilder(context.getResources()).setRoundingParams(fromCornersRadius).build();
    }

    public ReactImageView(Context context, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, Object obj) {
        super(context, buildHierarchy(context));
        this.mDraweeControllerBuilder = abstractDraweeControllerBuilder;
        this.mGlobalImageLoadListener = globalImageLoadListener;
        this.mCallerContext = obj;
    }

    public void setShouldNotifyLoadEvents(boolean z) {
        if (z != (this.mDownloadListener != null)) {
            if (!z) {
                this.mDownloadListener = null;
            } else {
                final EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) getContext(), getId());
                this.mDownloadListener = new ReactImageDownloadListener<ImageInfo>() {
                    public void onProgressChange(int i, int i2) {
                        eventDispatcherForReactTag.dispatchEvent(ImageLoadEvent.createProgressEvent(UIManagerHelper.getSurfaceId((View) ReactImageView.this), ReactImageView.this.getId(), ReactImageView.this.mImageSource.getSource(), i, i2));
                    }

                    public void onSubmit(String str, Object obj) {
                        eventDispatcherForReactTag.dispatchEvent(ImageLoadEvent.createLoadStartEvent(UIManagerHelper.getSurfaceId((View) ReactImageView.this), ReactImageView.this.getId()));
                    }

                    public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
                        if (imageInfo != null) {
                            eventDispatcherForReactTag.dispatchEvent(ImageLoadEvent.createLoadEvent(UIManagerHelper.getSurfaceId((View) ReactImageView.this), ReactImageView.this.getId(), ReactImageView.this.mImageSource.getSource(), imageInfo.getWidth(), imageInfo.getHeight()));
                            eventDispatcherForReactTag.dispatchEvent(ImageLoadEvent.createLoadEndEvent(UIManagerHelper.getSurfaceId((View) ReactImageView.this), ReactImageView.this.getId()));
                        }
                    }

                    public void onFailure(String str, Throwable th) {
                        eventDispatcherForReactTag.dispatchEvent(ImageLoadEvent.createErrorEvent(UIManagerHelper.getSurfaceId((View) ReactImageView.this), ReactImageView.this.getId(), th));
                    }
                };
            }
            this.mIsDirty = true;
        }
    }

    public void setBlurRadius(float f) {
        int pixelFromDIP = ((int) PixelUtil.toPixelFromDIP(f)) / 2;
        if (pixelFromDIP == 0) {
            this.mIterativeBoxBlurPostProcessor = null;
        } else {
            this.mIterativeBoxBlurPostProcessor = new IterativeBoxBlurPostProcessor(2, pixelFromDIP);
        }
        this.mIsDirty = true;
    }

    public void setBackgroundColor(int i) {
        if (this.mBackgroundColor != i) {
            this.mBackgroundColor = i;
            this.mBackgroundImageDrawable = new RoundedColorDrawable(i);
            this.mIsDirty = true;
        }
    }

    public void setBorderColor(int i) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
            this.mIsDirty = true;
        }
    }

    public void setOverlayColor(int i) {
        if (this.mOverlayColor != i) {
            this.mOverlayColor = i;
            this.mIsDirty = true;
        }
    }

    public void setBorderWidth(float f) {
        float pixelFromDIP = PixelUtil.toPixelFromDIP(f);
        if (!FloatUtil.floatsEqual(this.mBorderWidth, pixelFromDIP)) {
            this.mBorderWidth = pixelFromDIP;
            this.mIsDirty = true;
        }
    }

    public void setBorderRadius(float f) {
        if (!FloatUtil.floatsEqual(this.mBorderRadius, f)) {
            this.mBorderRadius = f;
            this.mIsDirty = true;
        }
    }

    public void setBorderRadius(float f, int i) {
        if (this.mBorderCornerRadii == null) {
            float[] fArr = new float[4];
            this.mBorderCornerRadii = fArr;
            Arrays.fill(fArr, Float.NaN);
        }
        if (!FloatUtil.floatsEqual(this.mBorderCornerRadii[i], f)) {
            this.mBorderCornerRadii[i] = f;
            this.mIsDirty = true;
        }
    }

    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        if (this.mScaleType != scaleType) {
            this.mScaleType = scaleType;
            this.mIsDirty = true;
        }
    }

    public void setTileMode(Shader.TileMode tileMode) {
        if (this.mTileMode != tileMode) {
            this.mTileMode = tileMode;
            if (isTiled()) {
                this.mTilePostprocessor = new TilePostprocessor();
            } else {
                this.mTilePostprocessor = null;
            }
            this.mIsDirty = true;
        }
    }

    public void setResizeMethod(ImageResizeMethod imageResizeMethod) {
        if (this.mResizeMethod != imageResizeMethod) {
            this.mResizeMethod = imageResizeMethod;
            this.mIsDirty = true;
        }
    }

    public void setSource(ReadableArray readableArray) {
        LinkedList<ImageSource> linkedList = new LinkedList<>();
        if (readableArray == null || readableArray.size() == 0) {
            linkedList.add(ImageSource.getTransparentBitmapImageSource(getContext()));
        } else {
            if (readableArray.size() == 1) {
                ReadableMap map = readableArray.getMap(0);
                ImageSource imageSource = new ImageSource(getContext(), map.getString("uri"));
                if (Uri.EMPTY.equals(imageSource.getUri())) {
                    warnImageSource(map.getString("uri"));
                    imageSource = ImageSource.getTransparentBitmapImageSource(getContext());
                }
                linkedList.add(imageSource);
            } else {
                for (int i = 0; i < readableArray.size(); i++) {
                    ReadableMap map2 = readableArray.getMap(i);
                    ImageSource imageSource2 = new ImageSource(getContext(), map2.getString("uri"), map2.getDouble("width"), map2.getDouble("height"));
                    if (Uri.EMPTY.equals(imageSource2.getUri())) {
                        warnImageSource(map2.getString("uri"));
                        imageSource2 = ImageSource.getTransparentBitmapImageSource(getContext());
                    }
                    linkedList.add(imageSource2);
                }
            }
        }
        if (!this.mSources.equals(linkedList)) {
            this.mSources.clear();
            for (ImageSource add : linkedList) {
                this.mSources.add(add);
            }
            this.mIsDirty = true;
        }
    }

    public void setDefaultSource(String str) {
        Drawable resourceDrawable = ResourceDrawableIdHelper.getInstance().getResourceDrawable(getContext(), str);
        if (!Objects.equal(this.mDefaultImageDrawable, resourceDrawable)) {
            this.mDefaultImageDrawable = resourceDrawable;
            this.mIsDirty = true;
        }
    }

    public void setLoadingIndicatorSource(String str) {
        Drawable resourceDrawable = ResourceDrawableIdHelper.getInstance().getResourceDrawable(getContext(), str);
        AutoRotateDrawable autoRotateDrawable = resourceDrawable != null ? new AutoRotateDrawable(resourceDrawable, 1000) : null;
        if (!Objects.equal(this.mLoadingImageDrawable, autoRotateDrawable)) {
            this.mLoadingImageDrawable = autoRotateDrawable;
            this.mIsDirty = true;
        }
    }

    public void setProgressiveRenderingEnabled(boolean z) {
        this.mProgressiveRenderingEnabled = z;
    }

    public void setFadeDuration(int i) {
        this.mFadeDurationMs = i;
    }

    private void getCornerRadii(float[] fArr) {
        float f = !YogaConstants.isUndefined(this.mBorderRadius) ? this.mBorderRadius : 0.0f;
        float[] fArr2 = this.mBorderCornerRadii;
        fArr[0] = (fArr2 == null || YogaConstants.isUndefined(fArr2[0])) ? f : this.mBorderCornerRadii[0];
        float[] fArr3 = this.mBorderCornerRadii;
        fArr[1] = (fArr3 == null || YogaConstants.isUndefined(fArr3[1])) ? f : this.mBorderCornerRadii[1];
        float[] fArr4 = this.mBorderCornerRadii;
        fArr[2] = (fArr4 == null || YogaConstants.isUndefined(fArr4[2])) ? f : this.mBorderCornerRadii[2];
        float[] fArr5 = this.mBorderCornerRadii;
        if (fArr5 != null && !YogaConstants.isUndefined(fArr5[3])) {
            f = this.mBorderCornerRadii[3];
        }
        fArr[3] = f;
    }

    public void setHeaders(ReadableMap readableMap) {
        this.mHeaders = readableMap;
    }

    public void maybeUpdateView() {
        if (this.mIsDirty) {
            if (!hasMultipleSources() || (getWidth() > 0 && getHeight() > 0)) {
                setSourceImage();
                ImageSource imageSource = this.mImageSource;
                if (imageSource != null) {
                    boolean shouldResize = shouldResize(imageSource);
                    if (shouldResize && (getWidth() <= 0 || getHeight() <= 0)) {
                        return;
                    }
                    if (!isTiled() || (getWidth() > 0 && getHeight() > 0)) {
                        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) getHierarchy();
                        genericDraweeHierarchy.setActualImageScaleType(this.mScaleType);
                        Drawable drawable = this.mDefaultImageDrawable;
                        if (drawable != null) {
                            genericDraweeHierarchy.setPlaceholderImage(drawable, this.mScaleType);
                        }
                        Drawable drawable2 = this.mLoadingImageDrawable;
                        if (drawable2 != null) {
                            genericDraweeHierarchy.setPlaceholderImage(drawable2, ScalingUtils.ScaleType.CENTER);
                        }
                        getCornerRadii(sComputedCornerRadii);
                        RoundingParams roundingParams = genericDraweeHierarchy.getRoundingParams();
                        float[] fArr = sComputedCornerRadii;
                        roundingParams.setCornersRadii(fArr[0], fArr[1], fArr[2], fArr[3]);
                        RoundedColorDrawable roundedColorDrawable = this.mBackgroundImageDrawable;
                        if (roundedColorDrawable != null) {
                            roundedColorDrawable.setBorder(this.mBorderColor, this.mBorderWidth);
                            this.mBackgroundImageDrawable.setRadii(roundingParams.getCornersRadii());
                            genericDraweeHierarchy.setBackgroundImage(this.mBackgroundImageDrawable);
                        }
                        roundingParams.setBorder(this.mBorderColor, this.mBorderWidth);
                        int i = this.mOverlayColor;
                        if (i != 0) {
                            roundingParams.setOverlayColor(i);
                        } else {
                            roundingParams.setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
                        }
                        genericDraweeHierarchy.setRoundingParams(roundingParams);
                        int i2 = this.mFadeDurationMs;
                        if (i2 < 0) {
                            i2 = this.mImageSource.isResource() ? 0 : 300;
                        }
                        genericDraweeHierarchy.setFadeDuration(i2);
                        LinkedList linkedList = new LinkedList();
                        IterativeBoxBlurPostProcessor iterativeBoxBlurPostProcessor = this.mIterativeBoxBlurPostProcessor;
                        if (iterativeBoxBlurPostProcessor != null) {
                            linkedList.add(iterativeBoxBlurPostProcessor);
                        }
                        TilePostprocessor tilePostprocessor = this.mTilePostprocessor;
                        if (tilePostprocessor != null) {
                            linkedList.add(tilePostprocessor);
                        }
                        Postprocessor from = MultiPostprocessor.from(linkedList);
                        ResizeOptions resizeOptions = shouldResize ? new ResizeOptions(getWidth(), getHeight()) : null;
                        ReactNetworkImageRequest fromBuilderWithHeaders = ReactNetworkImageRequest.fromBuilderWithHeaders(ImageRequestBuilder.newBuilderWithSource(this.mImageSource.getUri()).setPostprocessor(from).setResizeOptions(resizeOptions).setAutoRotateEnabled(true).setProgressiveRenderingEnabled(this.mProgressiveRenderingEnabled), this.mHeaders);
                        GlobalImageLoadListener globalImageLoadListener = this.mGlobalImageLoadListener;
                        if (globalImageLoadListener != null) {
                            globalImageLoadListener.onLoadAttempt(this.mImageSource.getUri());
                        }
                        this.mDraweeControllerBuilder.reset();
                        this.mDraweeControllerBuilder.setAutoPlayAnimations(true).setCallerContext(this.mCallerContext).setOldController(getController()).setImageRequest(fromBuilderWithHeaders);
                        ImageSource imageSource2 = this.mCachedImageSource;
                        if (imageSource2 != null) {
                            this.mDraweeControllerBuilder.setLowResImageRequest(ImageRequestBuilder.newBuilderWithSource(imageSource2.getUri()).setPostprocessor(from).setResizeOptions(resizeOptions).setAutoRotateEnabled(true).setProgressiveRenderingEnabled(this.mProgressiveRenderingEnabled).build());
                        }
                        ReactImageDownloadListener reactImageDownloadListener = this.mDownloadListener;
                        if (reactImageDownloadListener == null || this.mControllerForTesting == null) {
                            ControllerListener controllerListener = this.mControllerForTesting;
                            if (controllerListener != null) {
                                this.mDraweeControllerBuilder.setControllerListener(controllerListener);
                            } else if (reactImageDownloadListener != null) {
                                this.mDraweeControllerBuilder.setControllerListener(reactImageDownloadListener);
                            }
                        } else {
                            ForwardingControllerListener forwardingControllerListener = new ForwardingControllerListener();
                            forwardingControllerListener.addListener(this.mDownloadListener);
                            forwardingControllerListener.addListener(this.mControllerForTesting);
                            this.mDraweeControllerBuilder.setControllerListener(forwardingControllerListener);
                        }
                        ReactImageDownloadListener reactImageDownloadListener2 = this.mDownloadListener;
                        if (reactImageDownloadListener2 != null) {
                            genericDraweeHierarchy.setProgressBarImage((Drawable) reactImageDownloadListener2);
                        }
                        setController(this.mDraweeControllerBuilder.build());
                        this.mIsDirty = false;
                        this.mDraweeControllerBuilder.reset();
                    }
                }
            }
        }
    }

    public void setControllerListener(ControllerListener controllerListener) {
        this.mControllerForTesting = controllerListener;
        this.mIsDirty = true;
        maybeUpdateView();
    }

    public ImageSource getImageSource() {
        return this.mImageSource;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.mIsDirty = this.mIsDirty || hasMultipleSources() || isTiled();
            maybeUpdateView();
        }
    }

    private boolean hasMultipleSources() {
        return this.mSources.size() > 1;
    }

    private boolean isTiled() {
        return this.mTileMode != Shader.TileMode.CLAMP;
    }

    private void setSourceImage() {
        this.mImageSource = null;
        if (this.mSources.isEmpty()) {
            this.mSources.add(ImageSource.getTransparentBitmapImageSource(getContext()));
        } else if (hasMultipleSources()) {
            MultiSourceHelper.MultiSourceResult bestSourceForSize = MultiSourceHelper.getBestSourceForSize(getWidth(), getHeight(), this.mSources);
            this.mImageSource = bestSourceForSize.getBestResult();
            this.mCachedImageSource = bestSourceForSize.getBestResultInCache();
            return;
        }
        this.mImageSource = this.mSources.get(0);
    }

    private boolean shouldResize(ImageSource imageSource) {
        if (this.mResizeMethod != ImageResizeMethod.AUTO) {
            return this.mResizeMethod == ImageResizeMethod.RESIZE;
        }
        if (UriUtil.isLocalContentUri(imageSource.getUri()) || UriUtil.isLocalFileUri(imageSource.getUri())) {
            return true;
        }
        return false;
    }
}
