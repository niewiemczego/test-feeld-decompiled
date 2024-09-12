package expo.modules.image;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.facebook.react.uimanager.events.TouchesHelper;
import expo.modules.image.enums.ContentFit;
import expo.modules.image.enums.Priority;
import expo.modules.image.events.GlideRequestListener;
import expo.modules.image.events.OkHttpProgressListener;
import expo.modules.image.okhttp.GlideUrlWrapper;
import expo.modules.image.records.CachePolicy;
import expo.modules.image.records.ContentPosition;
import expo.modules.image.records.ImageErrorEvent;
import expo.modules.image.records.ImageLoadEvent;
import expo.modules.image.records.ImageProgressEvent;
import expo.modules.image.records.ImageTransition;
import expo.modules.image.records.SourceMap;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoView;
import java.lang.ref.WeakReference;
import java.util.List;
import jp.wasabeef.glide.transformations.BlurTransformation;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 °\u00012\u00020\u0001:\u0002°\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J.\u0010\u0001\u001a\u00020c2\u0007\u0010\u0001\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020N2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u000eH\u0002J\u0012\u0010\u0001\u001a\u00020c2\u0007\u0010\u0001\u001a\u00020\u0015H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0019\u0010+\u001a\u0004\u0018\u00010'2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020'0nH\u0002J%\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020N2\b\u0010\u0001\u001a\u00030\u00012\t\b\u0002\u0010\u0001\u001a\u00020\u000eJ-\u0010\u0001\u001a\u00020c2\u0007\u0010\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020\u001f2\u0007\u0010 \u0001\u001a\u00020\u001f2\u0007\u0010¡\u0001\u001a\u00020\u001fH\u0014J\u0007\u0010¢\u0001\u001a\u00020cJ\u001a\u0010£\u0001\u001a\u00020c2\t\b\u0002\u0010¤\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0003\b¥\u0001J\"\u0010¦\u0001\u001a\u00020c2\u0007\u0010§\u0001\u001a\u00020\u001f2\u0007\u0010¨\u0001\u001a\u0002022\u0007\u0010©\u0001\u001a\u000202J\u0019\u0010ª\u0001\u001a\u00020c2\u0007\u0010§\u0001\u001a\u00020\u001f2\u0007\u0010«\u0001\u001a\u000202J\u0019\u0010¬\u0001\u001a\u00020c2\u0007\u0010§\u0001\u001a\u00020\u001f2\u0007\u0010­\u0001\u001a\u000202J\u001b\u0010®\u0001\u001a\u00020c2\b\u0010\u0001\u001a\u00030¯\u00012\u0006\u0010\u0007\u001a\u00020\u000eH\u0002R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R*\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001f@@X\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010&\u001a\u0004\u0018\u00010'8BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0016\u0010*\u001a\u0004\u0018\u00010'8BX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010)R*\u0010,\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001f@@X\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b-\u0010\"\"\u0004\b.\u0010$R\"\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u0002020100X\u000e¢\u0006\u0004\n\u0002\u00103R\u000e\u00104\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R(\u00106\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000b\"\u0004\b8\u0010\rR\u000e\u00109\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R$\u0010B\u001a\u00020A2\u0006\u0010\u0007\u001a\u00020A@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010H\u001a\u00020G2\u0006\u0010\u0007\u001a\u00020G@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020NX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R$\u0010P\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0011\"\u0004\bR\u0010\u0013R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020VX\u0004¢\u0006\u0002\n\u0000R!\u0010W\u001a\b\u0012\u0004\u0012\u00020Y0X8@X\u0002¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\bZ\u0010[R!\u0010^\u001a\b\u0012\u0004\u0012\u00020_0X8@X\u0002¢\u0006\f\n\u0004\ba\u0010]\u001a\u0004\b`\u0010[R!\u0010b\u001a\b\u0012\u0004\u0012\u00020c0X8@X\u0002¢\u0006\f\n\u0004\be\u0010]\u001a\u0004\bd\u0010[R!\u0010f\u001a\b\u0012\u0004\u0012\u00020g0X8@X\u0002¢\u0006\f\n\u0004\bi\u0010]\u001a\u0004\bh\u0010[R$\u0010j\u001a\u00020A2\u0006\u0010\u0007\u001a\u00020A@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010D\"\u0004\bl\u0010FR \u0010m\u001a\b\u0012\u0004\u0012\u00020'0nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001a\u0010s\u001a\u00020tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u000e\u0010y\u001a\u00020zX\u0004¢\u0006\u0002\n\u0000R(\u0010{\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\u000b\"\u0004\b}\u0010\rR\u0019\u0010~\u001a\u00020X\u0004¢\u0006\r\n\u0003\b\u0001\u001a\u0006\b\u0001\u0010\u0001R\u000f\u0010\u0001\u001a\u00020NX\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R#\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020'0nX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010p\"\u0005\b\u0001\u0010rR-\u0010\u0001\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001f@@X\u000e¢\u0006\u0012\n\u0002\u0010%\u001a\u0005\b\u0001\u0010\"\"\u0005\b\u0001\u0010$R\u000f\u0010\u0001\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001¨\u0006±\u0001"}, d2 = {"Lexpo/modules/image/ExpoImageViewWrapper;", "Lexpo/modules/kotlin/views/ExpoView;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "value", "", "accessibilityLabel", "getAccessibilityLabel$expo_image_release", "()Ljava/lang/String;", "setAccessibilityLabel$expo_image_release", "(Ljava/lang/String;)V", "", "accessible", "getAccessible$expo_image_release", "()Z", "setAccessible$expo_image_release", "(Z)V", "activeView", "Lexpo/modules/image/ExpoImageView;", "getActiveView", "()Lexpo/modules/image/ExpoImageView;", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "allowDownscaling", "getAllowDownscaling$expo_image_release", "setAllowDownscaling$expo_image_release", "", "backgroundColor", "getBackgroundColor$expo_image_release", "()Ljava/lang/Integer;", "setBackgroundColor$expo_image_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "bestPlaceholder", "Lexpo/modules/image/records/SourceMap;", "getBestPlaceholder", "()Lexpo/modules/image/records/SourceMap;", "bestSource", "getBestSource", "blurRadius", "getBlurRadius$expo_image_release", "setBlurRadius$expo_image_release", "borderColor", "", "Lkotlin/Pair;", "", "[Lkotlin/Pair;", "borderRadius", "", "borderStyle", "getBorderStyle$expo_image_release", "setBorderStyle$expo_image_release", "borderWidth", "cachePolicy", "Lexpo/modules/image/records/CachePolicy;", "getCachePolicy$expo_image_release", "()Lexpo/modules/image/records/CachePolicy;", "setCachePolicy$expo_image_release", "(Lexpo/modules/image/records/CachePolicy;)V", "clearViewBeforeChangingSource", "Lexpo/modules/image/enums/ContentFit;", "contentFit", "getContentFit$expo_image_release", "()Lexpo/modules/image/enums/ContentFit;", "setContentFit$expo_image_release", "(Lexpo/modules/image/enums/ContentFit;)V", "Lexpo/modules/image/records/ContentPosition;", "contentPosition", "getContentPosition$expo_image_release", "()Lexpo/modules/image/records/ContentPosition;", "setContentPosition$expo_image_release", "(Lexpo/modules/image/records/ContentPosition;)V", "firstTarget", "Lexpo/modules/image/ImageViewWrapperTarget;", "firstView", "isFocusableProp", "isFocusableProp$expo_image_release", "setFocusableProp$expo_image_release", "loadedSource", "Lexpo/modules/image/GlideModel;", "mainHandler", "Landroid/os/Handler;", "onError", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "Lexpo/modules/image/records/ImageErrorEvent;", "getOnError$expo_image_release", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onError$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "onLoad", "Lexpo/modules/image/records/ImageLoadEvent;", "getOnLoad$expo_image_release", "onLoad$delegate", "onLoadStart", "", "getOnLoadStart$expo_image_release", "onLoadStart$delegate", "onProgress", "Lexpo/modules/image/records/ImageProgressEvent;", "getOnProgress$expo_image_release", "onProgress$delegate", "placeholderContentFit", "getPlaceholderContentFit$expo_image_release", "setPlaceholderContentFit$expo_image_release", "placeholders", "", "getPlaceholders$expo_image_release", "()Ljava/util/List;", "setPlaceholders$expo_image_release", "(Ljava/util/List;)V", "priority", "Lexpo/modules/image/enums/Priority;", "getPriority$expo_image_release", "()Lexpo/modules/image/enums/Priority;", "setPriority$expo_image_release", "(Lexpo/modules/image/enums/Priority;)V", "progressListener", "Lexpo/modules/image/events/OkHttpProgressListener;", "recyclingKey", "getRecyclingKey", "setRecyclingKey", "requestManager", "Lcom/bumptech/glide/RequestManager;", "getRequestManager$expo_image_release", "()Lcom/bumptech/glide/RequestManager;", "requestManager$1", "secondTarget", "secondView", "shouldRerender", "sources", "getSources$expo_image_release", "setSources$expo_image_release", "tintColor", "getTintColor$expo_image_release", "setTintColor$expo_image_release", "transformationMatrixChanged", "transition", "Lexpo/modules/image/records/ImageTransition;", "getTransition$expo_image_release", "()Lexpo/modules/image/records/ImageTransition;", "setTransition$expo_image_release", "(Lexpo/modules/image/records/ImageTransition;)V", "configureView", "view", "target", "resource", "Landroid/graphics/drawable/Drawable;", "isPlaceholder", "copyProps", "createPropOptions", "Lcom/bumptech/glide/request/RequestOptions;", "onResourceReady", "onSizeChanged", "w", "h", "oldw", "oldh", "onViewDestroys", "rerenderIfNeeded", "shouldRerenderBecauseOfResize", "rerenderIfNeeded$expo_image_release", "setBorderColor", "index", "rgb", "alpha", "setBorderRadius", "radius", "setBorderWidth", "width", "setIsScreenReaderFocusable", "Landroid/view/View;", "Companion", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoImageViewWrapper.kt */
public final class ExpoImageViewWrapper extends ExpoView {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static WeakReference<Activity> activityRef = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public static WeakReference<AppContext> appContextRef = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public static RequestManager requestManager;
    private String accessibilityLabel;
    private boolean accessible;
    private boolean allowDownscaling;
    private Integer backgroundColor;
    private Integer blurRadius;
    private Pair<Float, Float>[] borderColor;
    private float[] borderRadius;
    private String borderStyle;
    private float[] borderWidth;
    private CachePolicy cachePolicy;
    private boolean clearViewBeforeChangingSource;
    private ContentFit contentFit;
    private ContentPosition contentPosition;
    private ImageViewWrapperTarget firstTarget;
    private final ExpoImageView firstView = new ExpoImageView(getActivity());
    private boolean isFocusableProp;
    private GlideModel loadedSource;
    private final Handler mainHandler;
    private final ViewEventDelegate onError$delegate;
    private final ViewEventDelegate onLoad$delegate;
    private final ViewEventDelegate onLoadStart$delegate;
    private final ViewEventDelegate onProgress$delegate;
    private ContentFit placeholderContentFit;
    private List<SourceMap> placeholders;
    private Priority priority;
    private final OkHttpProgressListener progressListener = new OkHttpProgressListener(new WeakReference(this));
    private String recyclingKey;
    private final RequestManager requestManager$1;
    private ImageViewWrapperTarget secondTarget;
    private final ExpoImageView secondView = new ExpoImageView(getActivity());
    private boolean shouldRerender;
    private List<SourceMap> sources;
    private Integer tintColor;
    private boolean transformationMatrixChanged;
    private ImageTransition transition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpoImageViewWrapper(Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.requestManager$1 = Companion.getOrCreateRequestManager(appContext, getActivity());
        this.mainHandler = new Handler(context.getMainLooper());
        this.firstTarget = new ImageViewWrapperTarget(new WeakReference(this));
        this.secondTarget = new ImageViewWrapperTarget(new WeakReference(this));
        View view = this;
        this.onLoadStart$delegate = new ViewEventDelegate(Reflection.typeOf(Unit.class), view, (Function1) null);
        this.onProgress$delegate = new ViewEventDelegate(Reflection.typeOf(ImageProgressEvent.class), view, (Function1) null);
        this.onError$delegate = new ViewEventDelegate(Reflection.typeOf(ImageErrorEvent.class), view, (Function1) null);
        this.onLoad$delegate = new ViewEventDelegate(Reflection.typeOf(ImageLoadEvent.class), view, (Function1) null);
        this.sources = CollectionsKt.emptyList();
        this.placeholders = CollectionsKt.emptyList();
        this.contentFit = ContentFit.Cover;
        this.placeholderContentFit = ContentFit.ScaleDown;
        this.contentPosition = ContentPosition.Companion.getCenter();
        this.allowDownscaling = true;
        this.priority = Priority.NORMAL;
        this.cachePolicy = CachePolicy.DISK;
        float[] fArr = new float[9];
        for (int i = 0; i < 9; i++) {
            fArr[i] = Float.NaN;
        }
        this.borderRadius = fArr;
        float[] fArr2 = new float[9];
        for (int i2 = 0; i2 < 9; i2++) {
            fArr2[i2] = Float.NaN;
        }
        this.borderWidth = fArr2;
        Pair<Float, Float>[] pairArr = new Pair[9];
        for (int i3 = 0; i3 < 9; i3++) {
            pairArr[i3] = TuplesKt.to(Float.valueOf(Float.NaN), Float.valueOf(Float.NaN));
        }
        this.borderColor = pairArr;
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        setLayoutParams(layoutParams);
        this.firstView.setVisibility(0);
        this.secondView.setVisibility(0);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.addView(this.firstView, layoutParams);
        frameLayout.addView(this.secondView, layoutParams);
        addView(frameLayout, layoutParams);
    }

    private final Activity getActivity() {
        Activity currentActivity = getAppContext().getCurrentActivity();
        if (currentActivity != null) {
            return currentActivity;
        }
        throw new MissingActivity();
    }

    public final RequestManager getRequestManager$expo_image_release() {
        return this.requestManager$1;
    }

    private final ExpoImageView getActiveView() {
        if (this.secondView.getDrawable() != null) {
            return this.secondView;
        }
        return this.firstView;
    }

    static {
        Class<ExpoImageViewWrapper> cls = ExpoImageViewWrapper.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "onLoadStart", "getOnLoadStart$expo_image_release()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "onProgress", "getOnProgress$expo_image_release()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "onError", "getOnError$expo_image_release()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "onLoad", "getOnLoad$expo_image_release()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    }

    public final ViewEventCallback<Unit> getOnLoadStart$expo_image_release() {
        return this.onLoadStart$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final ViewEventCallback<ImageProgressEvent> getOnProgress$expo_image_release() {
        return this.onProgress$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final ViewEventCallback<ImageErrorEvent> getOnError$expo_image_release() {
        return this.onError$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final ViewEventCallback<ImageLoadEvent> getOnLoad$expo_image_release() {
        return this.onLoad$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final List<SourceMap> getSources$expo_image_release() {
        return this.sources;
    }

    public final void setSources$expo_image_release(List<SourceMap> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.sources = list;
    }

    private final SourceMap getBestSource() {
        return getBestSource(this.sources);
    }

    public final List<SourceMap> getPlaceholders$expo_image_release() {
        return this.placeholders;
    }

    public final void setPlaceholders$expo_image_release(List<SourceMap> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.placeholders = list;
    }

    private final SourceMap getBestPlaceholder() {
        return getBestSource(this.placeholders);
    }

    public final Integer getBlurRadius$expo_image_release() {
        return this.blurRadius;
    }

    public final void setBlurRadius$expo_image_release(Integer num) {
        if (!Intrinsics.areEqual((Object) this.blurRadius, (Object) num)) {
            this.shouldRerender = true;
        }
        this.blurRadius = num;
    }

    public final ImageTransition getTransition$expo_image_release() {
        return this.transition;
    }

    public final void setTransition$expo_image_release(ImageTransition imageTransition) {
        this.transition = imageTransition;
    }

    public final ContentFit getContentFit$expo_image_release() {
        return this.contentFit;
    }

    public final void setContentFit$expo_image_release(ContentFit contentFit2) {
        Intrinsics.checkNotNullParameter(contentFit2, "value");
        this.contentFit = contentFit2;
        getActiveView().setContentFit$expo_image_release(contentFit2);
        this.transformationMatrixChanged = true;
    }

    public final ContentFit getPlaceholderContentFit$expo_image_release() {
        return this.placeholderContentFit;
    }

    public final void setPlaceholderContentFit$expo_image_release(ContentFit contentFit2) {
        Intrinsics.checkNotNullParameter(contentFit2, "value");
        this.placeholderContentFit = contentFit2;
        getActiveView().setPlaceholderContentFit$expo_image_release(contentFit2);
        this.transformationMatrixChanged = true;
    }

    public final ContentPosition getContentPosition$expo_image_release() {
        return this.contentPosition;
    }

    public final void setContentPosition$expo_image_release(ContentPosition contentPosition2) {
        Intrinsics.checkNotNullParameter(contentPosition2, "value");
        this.contentPosition = contentPosition2;
        getActiveView().setContentPosition$expo_image_release(contentPosition2);
        this.transformationMatrixChanged = true;
    }

    public final String getBorderStyle$expo_image_release() {
        return this.borderStyle;
    }

    public final void setBorderStyle$expo_image_release(String str) {
        this.borderStyle = str;
        getActiveView().setBorderStyle$expo_image_release(str);
    }

    public final Integer getBackgroundColor$expo_image_release() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor$expo_image_release(Integer num) {
        this.backgroundColor = num;
        getActiveView().setBackgroundColor$expo_image_release(num);
    }

    public final Integer getTintColor$expo_image_release() {
        return this.tintColor;
    }

    public final void setTintColor$expo_image_release(Integer num) {
        this.tintColor = num;
        getActiveView().setTintColor$expo_image_release(num);
    }

    public final boolean isFocusableProp$expo_image_release() {
        return this.isFocusableProp;
    }

    public final void setFocusableProp$expo_image_release(boolean z) {
        this.isFocusableProp = z;
        getActiveView().setFocusable(z);
    }

    public final boolean getAccessible$expo_image_release() {
        return this.accessible;
    }

    public final void setAccessible$expo_image_release(boolean z) {
        this.accessible = z;
        setIsScreenReaderFocusable(getActiveView(), z);
    }

    public final String getAccessibilityLabel$expo_image_release() {
        return this.accessibilityLabel;
    }

    public final void setAccessibilityLabel$expo_image_release(String str) {
        this.accessibilityLabel = str;
        getActiveView().setContentDescription(this.accessibilityLabel);
    }

    public final String getRecyclingKey() {
        return this.recyclingKey;
    }

    public final void setRecyclingKey(String str) {
        String str2 = this.recyclingKey;
        this.clearViewBeforeChangingSource = (str2 == null || str == null || Intrinsics.areEqual((Object) str, (Object) str2)) ? false : true;
        this.recyclingKey = str;
    }

    public final boolean getAllowDownscaling$expo_image_release() {
        return this.allowDownscaling;
    }

    public final void setAllowDownscaling$expo_image_release(boolean z) {
        this.allowDownscaling = z;
        this.shouldRerender = true;
    }

    public final Priority getPriority$expo_image_release() {
        return this.priority;
    }

    public final void setPriority$expo_image_release(Priority priority2) {
        Intrinsics.checkNotNullParameter(priority2, "<set-?>");
        this.priority = priority2;
    }

    public final CachePolicy getCachePolicy$expo_image_release() {
        return this.cachePolicy;
    }

    public final void setCachePolicy$expo_image_release(CachePolicy cachePolicy2) {
        Intrinsics.checkNotNullParameter(cachePolicy2, "<set-?>");
        this.cachePolicy = cachePolicy2;
    }

    public final void setBorderRadius(int i, float f) {
        this.borderRadius[i] = f;
        getActiveView().setBorderRadius$expo_image_release(i, f);
    }

    public final void setBorderWidth(int i, float f) {
        this.borderWidth[i] = f;
        getActiveView().setBorderWidth$expo_image_release(i, f);
    }

    public final void setBorderColor(int i, float f, float f2) {
        this.borderColor[i] = TuplesKt.to(Float.valueOf(f), Float.valueOf(f2));
        getActiveView().setBorderColor$expo_image_release(i, f, f2);
    }

    private final void copyProps(ExpoImageView expoImageView) {
        expoImageView.setContentFit$expo_image_release(this.contentFit);
        expoImageView.setContentPosition$expo_image_release(this.contentPosition);
        expoImageView.setBorderStyle$expo_image_release(this.borderStyle);
        expoImageView.setBackgroundColor$expo_image_release(this.backgroundColor);
        expoImageView.setTintColor$expo_image_release(this.tintColor);
        expoImageView.setFocusable(this.isFocusableProp);
        expoImageView.setContentDescription(this.accessibilityLabel);
        Pair<Float, Float>[] pairArr = this.borderColor;
        int length = pairArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            Pair<Float, Float> pair = pairArr[i2];
            expoImageView.setBorderColor$expo_image_release(i3, pair.component1().floatValue(), pair.component2().floatValue());
            i2++;
            i3++;
        }
        float[] fArr = this.borderRadius;
        int length2 = fArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length2) {
            expoImageView.setBorderRadius$expo_image_release(i5, fArr[i4]);
            i4++;
            i5++;
        }
        float[] fArr2 = this.borderWidth;
        int length3 = fArr2.length;
        int i6 = 0;
        while (i < length3) {
            expoImageView.setBorderWidth$expo_image_release(i6, fArr2[i]);
            i++;
            i6++;
        }
        setIsScreenReaderFocusable(expoImageView, this.accessible);
    }

    private final void setIsScreenReaderFocusable(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            view.setScreenReaderFocusable(z);
        } else {
            ViewCompat.setAccessibilityDelegate(this, new ExpoImageViewWrapper$setIsScreenReaderFocusable$1(z));
        }
    }

    public static /* synthetic */ boolean onResourceReady$default(ExpoImageViewWrapper expoImageViewWrapper, ImageViewWrapperTarget imageViewWrapperTarget, Drawable drawable, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return expoImageViewWrapper.onResourceReady(imageViewWrapperTarget, drawable, z);
    }

    public final boolean onResourceReady(ImageViewWrapperTarget imageViewWrapperTarget, Drawable drawable, boolean z) {
        Intrinsics.checkNotNullParameter(imageViewWrapperTarget, TouchesHelper.TARGET_KEY);
        Intrinsics.checkNotNullParameter(drawable, "resource");
        return this.mainHandler.postAtFrontOfQueue(new ExpoImageViewWrapper$$ExternalSyntheticLambda1(this, z, imageViewWrapperTarget, drawable));
    }

    /* access modifiers changed from: private */
    /* renamed from: onResourceReady$lambda-8  reason: not valid java name */
    public static final void m762onResourceReady$lambda8(ExpoImageViewWrapper expoImageViewWrapper, boolean z, ImageViewWrapperTarget imageViewWrapperTarget, Drawable drawable) {
        Pair pair;
        Intrinsics.checkNotNullParameter(expoImageViewWrapper, "this$0");
        Intrinsics.checkNotNullParameter(imageViewWrapperTarget, "$target");
        Intrinsics.checkNotNullParameter(drawable, "$resource");
        ImageTransition imageTransition = expoImageViewWrapper.transition;
        long duration = (long) (imageTransition != null ? imageTransition.getDuration() : 0);
        if (!z || !imageViewWrapperTarget.getHasSource()) {
            if (expoImageViewWrapper.firstView.getDrawable() == null) {
                pair = TuplesKt.to(expoImageViewWrapper.firstView, expoImageViewWrapper.secondView);
            } else {
                pair = TuplesKt.to(expoImageViewWrapper.secondView, expoImageViewWrapper.firstView);
            }
            ExpoImageView expoImageView = (ExpoImageView) pair.component1();
            ExpoImageView expoImageView2 = (ExpoImageView) pair.component2();
            Function0 expoImageViewWrapper$onResourceReady$1$clearPreviousView$1 = new ExpoImageViewWrapper$onResourceReady$1$clearPreviousView$1(expoImageView2, imageViewWrapperTarget, expoImageViewWrapper);
            expoImageViewWrapper.configureView(expoImageView, imageViewWrapperTarget, drawable, z);
            if (duration <= 0) {
                expoImageViewWrapper$onResourceReady$1$clearPreviousView$1.invoke();
                expoImageView.setAlpha(1.0f);
                expoImageView.bringToFront();
                return;
            }
            expoImageView.bringToFront();
            expoImageView2.setAlpha(1.0f);
            expoImageView.setAlpha(0.0f);
            ViewPropertyAnimator animate = expoImageView2.animate();
            animate.setDuration(duration);
            animate.alpha(0.0f);
            animate.withEndAction(new ExpoImageViewWrapper$$ExternalSyntheticLambda0(expoImageViewWrapper$onResourceReady$1$clearPreviousView$1));
            ViewPropertyAnimator animate2 = expoImageView.animate();
            animate2.setDuration(duration);
            animate2.alpha(1.0f);
        } else if ((expoImageViewWrapper.firstView.getDrawable() == null || expoImageViewWrapper.firstView.isPlaceholder()) && expoImageViewWrapper.secondView.getDrawable() == null) {
            ImageViewWrapperTarget recycleView = expoImageViewWrapper.firstView.recycleView();
            if (recycleView != null && !Intrinsics.areEqual((Object) recycleView, (Object) imageViewWrapperTarget)) {
                recycleView.clear(expoImageViewWrapper.requestManager$1);
            }
            expoImageViewWrapper.configureView(expoImageViewWrapper.firstView, imageViewWrapperTarget, drawable, z);
            if (duration > 0) {
                expoImageViewWrapper.firstView.bringToFront();
                expoImageViewWrapper.firstView.setAlpha(0.0f);
                expoImageViewWrapper.secondView.setVisibility(8);
                ViewPropertyAnimator animate3 = expoImageViewWrapper.firstView.animate();
                animate3.setDuration(duration);
                animate3.alpha(1.0f);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onResourceReady$lambda-8$lambda-4$lambda-3  reason: not valid java name */
    public static final void m763onResourceReady$lambda8$lambda4$lambda3(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$clearPreviousView");
        function0.invoke();
    }

    private final void configureView(ExpoImageView expoImageView, ImageViewWrapperTarget imageViewWrapperTarget, Drawable drawable, boolean z) {
        expoImageView.setImageDrawable(drawable);
        expoImageView.setPlaceholder(z);
        ContentFit placeholderContentFit2 = imageViewWrapperTarget.getPlaceholderContentFit();
        if (placeholderContentFit2 == null) {
            placeholderContentFit2 = ContentFit.ScaleDown;
        }
        expoImageView.setPlaceholderContentFit$expo_image_release(placeholderContentFit2);
        copyProps(expoImageView);
        expoImageView.setVisibility(0);
        expoImageView.setCurrentTarget(imageViewWrapperTarget);
        expoImageView.layout(0, 0, getWidth(), getHeight());
        expoImageView.applyTransformationMatrix();
        imageViewWrapperTarget.setUsed(true);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

    private final SourceMap getBestSource(List<SourceMap> list) {
        SourceMap sourceMap = null;
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return (SourceMap) CollectionsKt.first(list);
        }
        int width = getWidth() * getHeight();
        if (width == 0) {
            return null;
        }
        double d = Double.MAX_VALUE;
        for (SourceMap sourceMap2 : list) {
            double abs = Math.abs(((double) 1) - (sourceMap2.getPixelCount$expo_image_release() / ((double) width)));
            if (abs < d) {
                sourceMap = sourceMap2;
                d = abs;
            }
        }
        return sourceMap;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        rerenderIfNeeded$expo_image_release((!this.allowDownscaling || this.contentFit == ContentFit.Fill || this.contentFit == ContentFit.None) ? false : true);
    }

    private final RequestOptions createPropOptions() {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.priority(this.priority.toGlidePriority$expo_image_release());
        if (!(this.cachePolicy == CachePolicy.MEMORY_AND_DISK || this.cachePolicy == CachePolicy.MEMORY)) {
            requestOptions.skipMemoryCache(true);
        }
        if (this.cachePolicy == CachePolicy.NONE || this.cachePolicy == CachePolicy.MEMORY) {
            requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE);
        }
        Integer num = this.blurRadius;
        if (num != null) {
            requestOptions.transform((Transformation<Bitmap>) new BlurTransformation(Math.min(num.intValue(), 25), 4));
        }
        return requestOptions;
    }

    public final void onViewDestroys() {
        this.firstView.setImageDrawable((Drawable) null);
        this.secondView.setImageDrawable((Drawable) null);
        this.requestManager$1.clear((Target<?>) this.firstTarget);
        this.requestManager$1.clear((Target<?>) this.secondTarget);
    }

    public static /* synthetic */ void rerenderIfNeeded$expo_image_release$default(ExpoImageViewWrapper expoImageViewWrapper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        expoImageViewWrapper.rerenderIfNeeded$expo_image_release(z);
    }

    public final void rerenderIfNeeded$expo_image_release(boolean z) {
        GlideModel glideModel;
        GlideModel glideModel2;
        RequestOptions requestOptions;
        ImageViewWrapperTarget imageViewWrapperTarget;
        ContentFit contentFit2;
        ExpoImageView expoImageView;
        SourceMap bestSource = getBestSource();
        SourceMap bestPlaceholder = getBestPlaceholder();
        Object obj = null;
        if (bestSource != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            glideModel = bestSource.createGlideModel$expo_image_release(context);
        } else {
            glideModel = null;
        }
        if (bestPlaceholder != null) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            glideModel2 = bestPlaceholder.createGlideModel$expo_image_release(context2);
        } else {
            glideModel2 = null;
        }
        if (getWidth() == 0 || getHeight() == 0 || ((bestSource == null || glideModel == null) && glideModel2 == null)) {
            this.firstView.recycleView();
            this.secondView.recycleView();
            this.requestManager$1.clear((Target<?>) this.firstTarget);
            this.requestManager$1.clear((Target<?>) this.secondTarget);
            this.shouldRerender = false;
            this.loadedSource = null;
            this.transformationMatrixChanged = false;
            this.clearViewBeforeChangingSource = false;
            return;
        }
        boolean z2 = true;
        if ((!Intrinsics.areEqual((Object) glideModel, (Object) this.loadedSource) || this.shouldRerender || (glideModel == null && glideModel2 != null)) || z) {
            if (this.clearViewBeforeChangingSource) {
                if (this.firstView.getDrawable() != null) {
                    expoImageView = this.firstView;
                } else {
                    expoImageView = this.secondView;
                }
                ImageViewWrapperTarget recycleView = expoImageView.recycleView();
                if (recycleView != null) {
                    recycleView.clear(this.requestManager$1);
                }
            }
            this.shouldRerender = false;
            this.loadedSource = glideModel;
            if (bestSource != null) {
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                requestOptions = bestSource.createOptions$expo_image_release(context3);
            } else {
                requestOptions = null;
            }
            RequestOptions createPropOptions = createPropOptions();
            if (glideModel != null) {
                obj = glideModel.getGlideData();
            }
            if (obj instanceof GlideUrlWrapper) {
                ((GlideUrlWrapper) obj).setProgressListener(this.progressListener);
            }
            getOnLoadStart$expo_image_release().invoke(Unit.INSTANCE);
            if (this.secondTarget.isUsed()) {
                imageViewWrapperTarget = this.firstTarget;
            } else {
                imageViewWrapperTarget = this.secondTarget;
            }
            if (glideModel == null) {
                z2 = false;
            }
            imageViewWrapperTarget.setHasSource(z2);
            DownsampleStrategy expoImageViewWrapper$rerenderIfNeeded$downsampleStrategy$1 = this.allowDownscaling ? new ExpoImageViewWrapper$rerenderIfNeeded$downsampleStrategy$1(imageViewWrapperTarget, this) : DownsampleStrategy.NONE;
            RequestBuilder<Drawable> load = this.requestManager$1.asDrawable().load(obj);
            if (glideModel2 != null) {
                load.thumbnail(this.requestManager$1.load(glideModel2.getGlideData()));
                if (bestPlaceholder.isBlurhash() || bestPlaceholder.isThumbhash()) {
                    contentFit2 = this.contentFit;
                } else {
                    contentFit2 = this.placeholderContentFit;
                }
                imageViewWrapperTarget.setPlaceholderContentFit(contentFit2);
            }
            if (requestOptions != null) {
                load.apply((BaseRequestOptions<?>) requestOptions);
            }
            RequestBuilder apply = ((RequestBuilder) ((RequestBuilder) load.downsample(expoImageViewWrapper$rerenderIfNeeded$downsampleStrategy$1)).addListener(new GlideRequestListener(new WeakReference(this))).encodeQuality(100)).apply((BaseRequestOptions<?>) createPropOptions);
            Intrinsics.checkNotNullExpressionValue(apply, "requestManager\n        .…      .apply(propOptions)");
            apply.into(imageViewWrapperTarget);
        } else if (this.transformationMatrixChanged) {
            getActiveView().applyTransformationMatrix();
        }
        this.transformationMatrixChanged = false;
        this.clearViewBeforeChangingSource = false;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/image/ExpoImageViewWrapper$Companion;", "", "()V", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "appContextRef", "Lexpo/modules/kotlin/AppContext;", "requestManager", "Lcom/bumptech/glide/RequestManager;", "createNewRequestManager", "activity", "getOrCreateRequestManager", "appContext", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ExpoImageViewWrapper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RequestManager getOrCreateRequestManager(AppContext appContext, Activity activity) {
            Intrinsics.checkNotNullParameter(appContext, "appContext");
            Intrinsics.checkNotNullParameter(activity, "activity");
            synchronized (ExpoImageViewWrapper.Companion) {
                RequestManager access$getRequestManager$cp = ExpoImageViewWrapper.requestManager;
                if (access$getRequestManager$cp == null) {
                    RequestManager createNewRequestManager = ExpoImageViewWrapper.Companion.createNewRequestManager(activity);
                    Companion companion = ExpoImageViewWrapper.Companion;
                    ExpoImageViewWrapper.requestManager = createNewRequestManager;
                    Companion companion2 = ExpoImageViewWrapper.Companion;
                    ExpoImageViewWrapper.appContextRef = new WeakReference(appContext);
                    Companion companion3 = ExpoImageViewWrapper.Companion;
                    ExpoImageViewWrapper.activityRef = new WeakReference(activity);
                    return createNewRequestManager;
                } else if (Intrinsics.areEqual(ExpoImageViewWrapper.appContextRef.get(), (Object) appContext) && Intrinsics.areEqual(ExpoImageViewWrapper.activityRef.get(), (Object) activity)) {
                    return access$getRequestManager$cp;
                } else {
                    RequestManager createNewRequestManager2 = ExpoImageViewWrapper.Companion.createNewRequestManager(activity);
                    Companion companion4 = ExpoImageViewWrapper.Companion;
                    ExpoImageViewWrapper.requestManager = createNewRequestManager2;
                    Companion companion5 = ExpoImageViewWrapper.Companion;
                    ExpoImageViewWrapper.appContextRef = new WeakReference(appContext);
                    Companion companion6 = ExpoImageViewWrapper.Companion;
                    ExpoImageViewWrapper.activityRef = new WeakReference(activity);
                    return createNewRequestManager2;
                }
            }
        }

        private final RequestManager createNewRequestManager(Activity activity) {
            RequestManager with = Glide.with(activity);
            Intrinsics.checkNotNullExpressionValue(with, "with(activity)");
            return with;
        }
    }
}
