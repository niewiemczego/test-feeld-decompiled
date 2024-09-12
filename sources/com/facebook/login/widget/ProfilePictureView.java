package com.facebook.login.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.R;
import io.sentry.Session;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 T2\u00020\u0001:\u0002TUB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\u0011H\u0003J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020#H\u0002J\b\u00105\u001a\u000206H\u0003J\b\u00107\u001a\u00020\u0011H\u0002J\b\u00108\u001a\u000206H\u0014J0\u00109\u001a\u0002062\u0006\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\tH\u0014J\u0018\u0010?\u001a\u0002062\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\tH\u0014J\u0010\u0010B\u001a\u0002062\u0006\u0010C\u001a\u00020DH\u0014J\b\u0010E\u001a\u00020DH\u0014J\u0010\u0010F\u001a\u0002062\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J\u0012\u0010G\u001a\u0002062\b\u0010H\u001a\u0004\u0018\u00010IH\u0003J\u0010\u0010J\u001a\u0002062\u0006\u0010K\u001a\u00020\u0011H\u0003J\u0010\u0010L\u001a\u0002062\u0006\u0010M\u001a\u00020\u0011H\u0003J\b\u0010N\u001a\u000206H\u0003J\u0010\u0010O\u001a\u0002062\b\u0010P\u001a\u0004\u0018\u00010\fJ\u0012\u0010Q\u001a\u0002062\b\u0010R\u001a\u0004\u0018\u00010\fH\u0003J\b\u0010S\u001a\u00020\u0011H\u0003R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0010\u001a\u0004\u0018\u00010#@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R$\u0010-\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015¨\u0006V"}, d2 = {"Lcom/facebook/login/widget/ProfilePictureView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "customizedDefaultProfilePicture", "Landroid/graphics/Bitmap;", "image", "Landroid/widget/ImageView;", "imageContents", "value", "", "isCropped", "()Z", "setCropped", "(Z)V", "lastRequest", "Lcom/facebook/internal/ImageRequest;", "onErrorListener", "Lcom/facebook/login/widget/ProfilePictureView$OnErrorListener;", "getOnErrorListener", "()Lcom/facebook/login/widget/ProfilePictureView$OnErrorListener;", "setOnErrorListener", "(Lcom/facebook/login/widget/ProfilePictureView$OnErrorListener;)V", "presetSize", "getPresetSize", "()I", "setPresetSize", "(I)V", "", "profileId", "getProfileId", "()Ljava/lang/String;", "setProfileId", "(Ljava/lang/String;)V", "profileTracker", "Lcom/facebook/ProfileTracker;", "queryHeight", "queryWidth", "shouldUpdateOnProfileChange", "getShouldUpdateOnProfileChange", "setShouldUpdateOnProfileChange", "getPresetSizeInPixels", "forcePreset", "getProfilePictureUri", "Landroid/net/Uri;", "accessToken", "initialize", "", "isUnspecifiedDimensions", "onDetachedFromWindow", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "parseAttributes", "processResponse", "response", "Lcom/facebook/internal/ImageResponse;", "refreshImage", "force", "sendImageRequest", "allowCachedResponse", "setBlankProfilePicture", "setDefaultProfilePicture", "inputBitmap", "setImageBitmap", "imageBitmap", "updateImageQueryParameters", "Companion", "OnErrorListener", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ProfilePictureView.kt */
public final class ProfilePictureView extends FrameLayout {
    private static final String BITMAP_HEIGHT_KEY = "ProfilePictureView_height";
    private static final String BITMAP_KEY = "ProfilePictureView_bitmap";
    private static final String BITMAP_WIDTH_KEY = "ProfilePictureView_width";
    public static final int CUSTOM = -1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final boolean IS_CROPPED_DEFAULT_VALUE = true;
    private static final String IS_CROPPED_KEY = "ProfilePictureView_isCropped";
    public static final int LARGE = -4;
    private static final int MIN_SIZE = 1;
    public static final int NORMAL = -3;
    private static final String PENDING_REFRESH_KEY = "ProfilePictureView_refresh";
    private static final String PRESET_SIZE_KEY = "ProfilePictureView_presetSize";
    private static final String PROFILE_ID_KEY = "ProfilePictureView_profileId";
    public static final int SMALL = -2;
    private static final String SUPER_STATE_KEY = "ProfilePictureView_superState";
    /* access modifiers changed from: private */
    public static final String TAG = "ProfilePictureView";
    private Bitmap customizedDefaultProfilePicture;
    private final ImageView image = new ImageView(getContext());
    private Bitmap imageContents;
    private boolean isCropped = true;
    private ImageRequest lastRequest;
    private OnErrorListener onErrorListener;
    private int presetSize = -1;
    private String profileId;
    private ProfileTracker profileTracker;
    private int queryHeight;
    private int queryWidth;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/widget/ProfilePictureView$OnErrorListener;", "", "onError", "", "error", "Lcom/facebook/FacebookException;", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ProfilePictureView.kt */
    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final void setProfileId(String str) {
        CharSequence charSequence = this.profileId;
        boolean z = false;
        if ((charSequence == null || charSequence.length() == 0) || !StringsKt.equals(this.profileId, str, true)) {
            setBlankProfilePicture();
            z = true;
        }
        this.profileId = str;
        refreshImage(z);
    }

    public final boolean isCropped() {
        return this.isCropped;
    }

    public final void setCropped(boolean z) {
        this.isCropped = z;
        refreshImage(false);
    }

    public final OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public final void setOnErrorListener(OnErrorListener onErrorListener2) {
        this.onErrorListener = onErrorListener2;
    }

    public final int getPresetSize() {
        return this.presetSize;
    }

    public final void setPresetSize(int i) {
        if (i == -4 || i == -3 || i == -2 || i == -1) {
            this.presetSize = i;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Must use a predefined preset size");
    }

    public final boolean getShouldUpdateOnProfileChange() {
        ProfileTracker profileTracker2 = this.profileTracker;
        if (profileTracker2 == null) {
            return false;
        }
        return profileTracker2.isTracking();
    }

    public final void setShouldUpdateOnProfileChange(boolean z) {
        if (z) {
            ProfileTracker profileTracker2 = this.profileTracker;
            if (profileTracker2 != null) {
                profileTracker2.startTracking();
                return;
            }
            return;
        }
        ProfileTracker profileTracker3 = this.profileTracker;
        if (profileTracker3 != null) {
            profileTracker3.stopTracking();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProfilePictureView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initialize();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProfilePictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, Session.JsonKeys.ATTRS);
        initialize();
        parseAttributes(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProfilePictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, Session.JsonKeys.ATTRS);
        initialize();
        parseAttributes(attributeSet);
    }

    private final void initialize() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                removeAllViews();
                this.image.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                addView(this.image);
                this.profileTracker = new ProfilePictureView$initialize$1(this);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void setDefaultProfilePicture(Bitmap bitmap) {
        this.customizedDefaultProfilePicture = bitmap;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean z;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        boolean z2 = true;
        if (View.MeasureSpec.getMode(i2) == 1073741824 || layoutParams.height != -2) {
            z = false;
        } else {
            size = getPresetSizeInPixels(true);
            i2 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            z = true;
        }
        if (View.MeasureSpec.getMode(i) == 1073741824 || layoutParams.width != -2) {
            z2 = z;
        } else {
            size2 = getPresetSizeInPixels(true);
            i = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
        }
        if (z2) {
            setMeasuredDimension(size2, size);
            measureChildren(i, i2);
            return;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        refreshImage(false);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable(SUPER_STATE_KEY, onSaveInstanceState);
        bundle.putString(PROFILE_ID_KEY, this.profileId);
        bundle.putInt(PRESET_SIZE_KEY, this.presetSize);
        bundle.putBoolean(IS_CROPPED_KEY, this.isCropped);
        bundle.putInt(BITMAP_WIDTH_KEY, this.queryWidth);
        bundle.putInt(BITMAP_HEIGHT_KEY, this.queryHeight);
        bundle.putBoolean(PENDING_REFRESH_KEY, this.lastRequest != null);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "state");
        if (!Intrinsics.areEqual((Object) parcelable.getClass(), (Object) Bundle.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable(SUPER_STATE_KEY));
        setProfileId(bundle.getString(PROFILE_ID_KEY));
        setPresetSize(bundle.getInt(PRESET_SIZE_KEY));
        setCropped(bundle.getBoolean(IS_CROPPED_KEY));
        this.queryWidth = bundle.getInt(BITMAP_WIDTH_KEY);
        this.queryHeight = bundle.getInt(BITMAP_HEIGHT_KEY);
        refreshImage(true);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.lastRequest = null;
    }

    private final void parseAttributes(AttributeSet attributeSet) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.com_facebook_profile_picture_view);
                Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.com_facebook_profile_picture_view)");
                setPresetSize(obtainStyledAttributes.getInt(R.styleable.com_facebook_profile_picture_view_com_facebook_preset_size, -1));
                setCropped(obtainStyledAttributes.getBoolean(R.styleable.com_facebook_profile_picture_view_com_facebook_is_cropped, true));
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void refreshImage(boolean z) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                boolean updateImageQueryParameters = updateImageQueryParameters();
                String str = this.profileId;
                if (str != null) {
                    if (!(str.length() == 0)) {
                        if (!isUnspecifiedDimensions()) {
                            if (updateImageQueryParameters || z) {
                                sendImageRequest(true);
                                return;
                            }
                            return;
                        }
                    }
                }
                setBlankProfilePicture();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final boolean isUnspecifiedDimensions() {
        return this.queryWidth == 0 && this.queryHeight == 0;
    }

    private final void setBlankProfilePicture() {
        int i;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                ImageRequest imageRequest = this.lastRequest;
                if (imageRequest != null) {
                    ImageDownloader imageDownloader = ImageDownloader.INSTANCE;
                    ImageDownloader.cancelRequest(imageRequest);
                }
                Bitmap bitmap = this.customizedDefaultProfilePicture;
                if (bitmap == null) {
                    if (this.isCropped) {
                        i = R.drawable.com_facebook_profile_picture_blank_square;
                    } else {
                        i = R.drawable.com_facebook_profile_picture_blank_portrait;
                    }
                    setImageBitmap(BitmapFactory.decodeResource(getResources(), i));
                    return;
                }
                updateImageQueryParameters();
                setImageBitmap(Bitmap.createScaledBitmap(bitmap, this.queryWidth, this.queryHeight, false));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void setImageBitmap(Bitmap bitmap) {
        if (!CrashShieldHandler.isObjectCrashing(this) && bitmap != null) {
            try {
                this.imageContents = bitmap;
                this.image.setImageBitmap(bitmap);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void sendImageRequest(boolean z) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                String str = "";
                if (AccessToken.Companion.isCurrentAccessTokenActive()) {
                    AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
                    if (currentAccessToken != null) {
                        String token = currentAccessToken.getToken();
                        if (token != null) {
                            str = token;
                        }
                    }
                }
                Uri profilePictureUri = getProfilePictureUri(str);
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ImageRequest build = new ImageRequest.Builder(context, profilePictureUri).setAllowCachedRedirects(z).setCallerTag(this).setCallback(new ProfilePictureView$$ExternalSyntheticLambda0(this)).build();
                ImageRequest imageRequest = this.lastRequest;
                if (imageRequest != null) {
                    ImageDownloader imageDownloader = ImageDownloader.INSTANCE;
                    ImageDownloader.cancelRequest(imageRequest);
                }
                this.lastRequest = build;
                ImageDownloader imageDownloader2 = ImageDownloader.INSTANCE;
                ImageDownloader.downloadAsync(build);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sendImageRequest$lambda-2  reason: not valid java name */
    public static final void m404sendImageRequest$lambda2(ProfilePictureView profilePictureView, ImageResponse imageResponse) {
        Intrinsics.checkNotNullParameter(profilePictureView, "this$0");
        profilePictureView.processResponse(imageResponse);
    }

    private final Uri getProfilePictureUri(String str) {
        Profile currentProfile = Profile.Companion.getCurrentProfile();
        if (currentProfile == null || !AccessToken.Companion.isLoggedInWithInstagram()) {
            return ImageRequest.Companion.getProfilePictureUri(this.profileId, this.queryWidth, this.queryHeight, str);
        }
        return currentProfile.getProfilePictureUri(this.queryWidth, this.queryHeight);
    }

    private final void processResponse(ImageResponse imageResponse) {
        if (!CrashShieldHandler.isObjectCrashing(this) && imageResponse != null) {
            try {
                if (Intrinsics.areEqual((Object) imageResponse.getRequest(), (Object) this.lastRequest)) {
                    this.lastRequest = null;
                    Bitmap bitmap = imageResponse.getBitmap();
                    Exception error = imageResponse.getError();
                    if (error != null) {
                        OnErrorListener onErrorListener2 = this.onErrorListener;
                        if (onErrorListener2 != null) {
                            onErrorListener2.onError(new FacebookException(Intrinsics.stringPlus("Error in downloading profile picture for profileId: ", this.profileId), (Throwable) error));
                        } else {
                            Logger.Companion.log(LoggingBehavior.REQUESTS, 6, TAG, error.toString());
                        }
                    } else if (bitmap != null) {
                        setImageBitmap(bitmap);
                        if (imageResponse.isCachedRedirect()) {
                            sendImageRequest(false);
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final boolean updateImageQueryParameters() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            int height = getHeight();
            int width = getWidth();
            boolean z = true;
            if (width >= 1) {
                if (height >= 1) {
                    int presetSizeInPixels = getPresetSizeInPixels(false);
                    if (presetSizeInPixels != 0) {
                        height = presetSizeInPixels;
                        width = height;
                    }
                    if (width <= height) {
                        height = this.isCropped ? width : 0;
                    } else {
                        width = this.isCropped ? height : 0;
                    }
                    if (width == this.queryWidth) {
                        if (height == this.queryHeight) {
                            z = false;
                        }
                    }
                    this.queryWidth = width;
                    this.queryHeight = height;
                    return z;
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final int getPresetSizeInPixels(boolean z) {
        int i;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            int i2 = this.presetSize;
            if (i2 == -1 && !z) {
                return 0;
            }
            if (i2 == -4) {
                i = R.dimen.com_facebook_profilepictureview_preset_size_large;
            } else if (i2 == -3) {
                i = R.dimen.com_facebook_profilepictureview_preset_size_normal;
            } else if (i2 == -2) {
                i = R.dimen.com_facebook_profilepictureview_preset_size_small;
            } else if (i2 != -1) {
                return 0;
            } else {
                i = R.dimen.com_facebook_profilepictureview_preset_size_normal;
            }
            return getResources().getDimensionPixelSize(i);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/facebook/login/widget/ProfilePictureView$Companion;", "", "()V", "BITMAP_HEIGHT_KEY", "", "BITMAP_KEY", "BITMAP_WIDTH_KEY", "CUSTOM", "", "IS_CROPPED_DEFAULT_VALUE", "", "IS_CROPPED_KEY", "LARGE", "MIN_SIZE", "NORMAL", "PENDING_REFRESH_KEY", "PRESET_SIZE_KEY", "PROFILE_ID_KEY", "SMALL", "SUPER_STATE_KEY", "TAG", "getTAG", "()Ljava/lang/String;", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ProfilePictureView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return ProfilePictureView.TAG;
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("ProfilePictureView", "ProfilePictureView::class.java.simpleName");
    }
}
