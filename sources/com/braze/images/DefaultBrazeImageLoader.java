package com.braze.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Bundle;
import android.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import com.braze.Constants;
import com.braze.R;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.enums.BrazeViewBounds;
import com.braze.models.cards.Card;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeImageUtils;
import com.braze.support.BrazeLogger;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001;B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b8\u00109J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J \u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\r0\r2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J2\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J2\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J.\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J,\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J$\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J&\u0010#\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010$\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0012\u0010%\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0012\u0010&\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0004H\u0007J \u0010(\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u001dH\u0007R\u0014\u0010*\u001a\u00020)8\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R#\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0,8G¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X.¢\u0006\u0006\n\u0004\b2\u00103R$\u00105\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\u001d8G@BX\u000e¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b5\u00107R\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u00106¨\u0006<"}, d2 = {"Lcom/braze/images/DefaultBrazeImageLoader;", "Lcom/braze/images/IBrazeImageLoader;", "Landroid/content/Context;", "context", "", "imageUrl", "Landroid/widget/ImageView;", "imageView", "Lcom/braze/enums/BrazeViewBounds;", "viewBounds", "", "renderUrlIntoView", "key", "Landroid/graphics/Bitmap;", "bitmap", "kotlin.jvm.PlatformType", "putBitmapIntoMemCache", "initDiskCacheTask", "renderUrlIntoViewTask", "Lcom/braze/models/cards/Card;", "card", "renderUrlIntoCardView", "Lcom/braze/models/inappmessage/IInAppMessage;", "inAppMessage", "renderUrlIntoInAppMessageView", "Landroid/os/Bundle;", "extras", "getPushBitmapFromUrl", "getInAppMessageBitmapFromUrl", "", "isOffline", "setOffline", "getBitmapFromUrl", "Landroid/net/Uri;", "imageUri", "downloadBitmapFromUrl", "getBitmapFromCache", "getBitmapFromMemCache", "getBitmapFromDiskCache", "skipDiskCache", "putBitmapIntoCache", "Ljava/util/concurrent/locks/ReentrantLock;", "diskCacheLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroid/util/LruCache;", "memoryCache", "Landroid/util/LruCache;", "getMemoryCache", "()Landroid/util/LruCache;", "Lbo/app/h;", "diskLruCache", "Lbo/app/h;", "<set-?>", "isDiskCacheStarting", "Z", "()Z", "<init>", "(Landroid/content/Context;)V", "Companion", "b", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public final class DefaultBrazeImageLoader implements IBrazeImageLoader {
    public static final String BRAZE_LRU_CACHE_FOLDER = "appboy.imageloader.lru.cache";
    public static final b Companion = new b((DefaultConstructorMarker) null);
    private static final int DISK_CACHE_SIZE = 52428800;
    /* access modifiers changed from: private */
    public static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) DefaultBrazeImageLoader.class);
    /* access modifiers changed from: private */
    public final ReentrantLock diskCacheLock = new ReentrantLock();
    /* access modifiers changed from: private */
    public bo.app.h diskLruCache;
    /* access modifiers changed from: private */
    public boolean isDiskCacheStarting = true;
    private boolean isOffline;
    private final LruCache<String, Bitmap> memoryCache = new a(BrazeImageUtils.getImageLoaderCacheSize());

    public static final class a extends LruCache {
        a(int i) {
            super(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(bitmap, "image");
            return bitmap.getByteCount();
        }
    }

    public static final class b {

        static final class a extends Lambda implements Function0 {
            final /* synthetic */ File b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(File file) {
                super(0);
                this.b = file;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Deleting lru image cache directory at: " + this.b.getAbsolutePath();
            }
        }

        /* renamed from: com.braze.images.DefaultBrazeImageLoader$b$b  reason: collision with other inner class name */
        static final class C0029b extends Lambda implements Function0 {
            public static final C0029b b = new C0029b();

            C0029b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to delete stored data in image loader";
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                File file = new File(context.getCacheDir(), DefaultBrazeImageLoader.BRAZE_LRU_CACHE_FOLDER);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new a(file), 2, (Object) null);
                BrazeFileUtils.deleteFileOrDirectory(file);
            } catch (Exception e) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) C0029b.b);
            }
        }

        private b() {
        }

        public final File a(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "uniqueName");
            return new File(context.getCacheDir().getPath() + File.separator + str);
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ DefaultBrazeImageLoader c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, DefaultBrazeImageLoader defaultBrazeImageLoader) {
            super(0);
            this.b = str;
            this.c = defaultBrazeImageLoader;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Got bitmap from mem cache for key " + this.b + "\nMemory cache stats: " + this.c.getMemoryCache();
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Got bitmap from disk cache for key " + this.b;
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "No cache hit for bitmap: " + this.b;
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Disk cache still starting. Cannot retrieve key from disk cache: " + this.b;
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Getting bitmap from disk cache for key: " + this.b;
        }
    }

    static final class h extends Lambda implements Function0 {
        public static final h b = new h();

        h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot retrieve bitmap with blank image url";
        }
    }

    static final class i extends Lambda implements Function0 {
        public static final i b = new i();

        i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cache is currently in offline mode. Not downloading bitmap.";
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get bitmap from url. Url: " + this.b;
        }
    }

    static final class k extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ Context c;
        final /* synthetic */ DefaultBrazeImageLoader d;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Initializing disk cache";
            }
        }

        static final class b extends Lambda implements Function0 {
            public static final b b = new b();

            b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Disk cache initialized";
            }
        }

        static final class c extends Lambda implements Function0 {
            public static final c b = new c();

            c() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Caught exception creating new disk cache. Unable to create new disk cache";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(Context context, DefaultBrazeImageLoader defaultBrazeImageLoader, Continuation continuation) {
            super(2, continuation);
            this.c = context;
            this.d = defaultBrazeImageLoader;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((k) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new k(this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                File a2 = DefaultBrazeImageLoader.Companion.a(this.c, DefaultBrazeImageLoader.BRAZE_LRU_CACHE_FOLDER);
                ReentrantLock access$getDiskCacheLock$p = this.d.diskCacheLock;
                DefaultBrazeImageLoader defaultBrazeImageLoader = this.d;
                access$getDiskCacheLock$p.lock();
                try {
                    BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                    BrazeLogger.brazelog$default(brazeLogger, DefaultBrazeImageLoader.TAG, (BrazeLogger.Priority) null, (Throwable) null, (Function0) a.b, 6, (Object) null);
                    defaultBrazeImageLoader.diskLruCache = new bo.app.h(a2, 1, 1, 52428800);
                    BrazeLogger.brazelog$default(brazeLogger, DefaultBrazeImageLoader.TAG, (BrazeLogger.Priority) null, (Throwable) null, (Function0) b.b, 6, (Object) null);
                    defaultBrazeImageLoader.isDiskCacheStarting = false;
                } catch (Exception e) {
                    BrazeLogger.INSTANCE.brazelog(DefaultBrazeImageLoader.TAG, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) c.b);
                } catch (Throwable th) {
                    access$getDiskCacheLock$p.unlock();
                    throw th;
                }
                Unit unit = Unit.INSTANCE;
                access$getDiskCacheLock$p.unlock();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class l extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Adding bitmap to mem cache for key " + this.b;
        }
    }

    static final class m extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Skipping disk cache for key: " + this.b;
        }
    }

    static final class n extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Adding bitmap to disk cache for key " + this.b;
        }
    }

    static final class o extends Lambda implements Function0 {
        public static final o b = new o();

        o() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot retrieve bitmap with a blank image url";
        }
    }

    static final class p extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to render url into view. Url: " + this.b;
        }
    }

    static final class q extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ DefaultBrazeImageLoader c;
        final /* synthetic */ Context d;
        final /* synthetic */ String e;
        final /* synthetic */ BrazeViewBounds f;
        final /* synthetic */ ImageView g;

        static final class a extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to retrieve bitmap from url: " + this.b;
            }
        }

        public static final class b implements View.OnLayoutChangeListener {
            final /* synthetic */ BrazeViewBounds a;
            final /* synthetic */ Bitmap b;
            final /* synthetic */ ImageView c;

            static final class a extends Lambda implements Function0 {
                final /* synthetic */ View b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                a(View view) {
                    super(0);
                    this.b = view;
                }

                /* renamed from: a */
                public final String invoke() {
                    return "THING Applying bitmap " + this.b;
                }
            }

            b(BrazeViewBounds brazeViewBounds, Bitmap bitmap, ImageView imageView) {
                this.a = brazeViewBounds;
                this.b = bitmap;
                this.c = imageView;
            }

            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                Intrinsics.checkNotNullParameter(view, "v");
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new a(view), 3, (Object) null);
                if (this.a == BrazeViewBounds.BASE_CARD_VIEW) {
                    BrazeImageUtils.resizeImageViewToBitmapDimensions(this.b, this.c);
                }
                view.removeOnLayoutChangeListener(this);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(DefaultBrazeImageLoader defaultBrazeImageLoader, Context context, String str, BrazeViewBounds brazeViewBounds, ImageView imageView, Continuation continuation) {
            super(2, continuation);
            this.c = defaultBrazeImageLoader;
            this.d = context;
            this.e = str;
            this.f = brazeViewBounds;
            this.g = imageView;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((q) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new q(this.c, this.d, this.e, this.f, this.g, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                TrafficStats.setThreadStatsTag(Constants.TRAFFIC_STATS_THREAD_TAG);
                Bitmap bitmapFromUrl = this.c.getBitmapFromUrl(this.d, this.e, this.f);
                if (bitmapFromUrl == null) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, DefaultBrazeImageLoader.TAG, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new a(this.e), 6, (Object) null);
                } else {
                    String str = this.e;
                    Object tag = this.g.getTag(R.string.com_braze_image_lru_cache_image_url_key);
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
                    if (Intrinsics.areEqual((Object) str, (Object) (String) tag)) {
                        this.g.setImageBitmap(bitmapFromUrl);
                        this.g.addOnLayoutChangeListener(new b(this.f, bitmapFromUrl, this.g));
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class r extends Lambda implements Function0 {
        final /* synthetic */ boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(boolean z) {
            super(0);
            this.b = z;
        }

        /* renamed from: a */
        public final String invoke() {
            return "DefaultBrazeImageLoader outbound network requests are now " + (this.b ? "disabled" : "enabled");
        }
    }

    public DefaultBrazeImageLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        initDiskCacheTask(context);
    }

    @JvmStatic
    public static final void deleteStoredData(Context context) {
        Companion.a(context);
    }

    public static /* synthetic */ Bitmap downloadBitmapFromUrl$default(DefaultBrazeImageLoader defaultBrazeImageLoader, Context context, Uri uri, BrazeViewBounds brazeViewBounds, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            brazeViewBounds = BrazeViewBounds.NO_BOUNDS;
        }
        return defaultBrazeImageLoader.downloadBitmapFromUrl(context, uri, brazeViewBounds);
    }

    @JvmStatic
    public static final File getDiskCacheDir(Context context, String str) {
        return Companion.a(context, str);
    }

    private final void initDiskCacheTask(Context context) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new k(context, this, (Continuation) null), 3, (Object) null);
    }

    private final Bitmap putBitmapIntoMemCache(String str, Bitmap bitmap) {
        return this.memoryCache.put(str, bitmap);
    }

    private final void renderUrlIntoView(Context context, String str, ImageView imageView, BrazeViewBounds brazeViewBounds) {
        if (StringsKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) o.b, 3, (Object) null);
            return;
        }
        try {
            renderUrlIntoViewTask(context, imageView, brazeViewBounds, str);
        } catch (Throwable th) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, th, (Function0<String>) new p(str));
        }
    }

    private final void renderUrlIntoViewTask(Context context, ImageView imageView, BrazeViewBounds brazeViewBounds, String str) {
        imageView.setTag(R.string.com_braze_image_lru_cache_image_url_key, str);
        Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new q(this, context, str, brazeViewBounds, imageView, (Continuation) null), 3, (Object) null);
    }

    public final Bitmap downloadBitmapFromUrl(Context context, Uri uri, BrazeViewBounds brazeViewBounds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "imageUri");
        if (brazeViewBounds == null) {
            brazeViewBounds = BrazeViewBounds.NO_BOUNDS;
        }
        return BrazeImageUtils.getBitmap(context, uri, brazeViewBounds);
    }

    public final Bitmap getBitmapFromCache(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Bitmap bitmap = this.memoryCache.get(str);
        if (bitmap != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new c(str, this), 2, (Object) null);
            return bitmap;
        }
        Bitmap bitmapFromDiskCache = getBitmapFromDiskCache(str);
        if (bitmapFromDiskCache != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new d(str), 2, (Object) null);
            putBitmapIntoMemCache(str, bitmapFromDiskCache);
            return bitmapFromDiskCache;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new e(str), 3, (Object) null);
        return null;
    }

    public final Bitmap getBitmapFromDiskCache(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        ReentrantLock reentrantLock = this.diskCacheLock;
        reentrantLock.lock();
        try {
            bo.app.h hVar = null;
            if (this.isDiskCacheStarting) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new f(str), 2, (Object) null);
            } else {
                bo.app.h hVar2 = this.diskLruCache;
                if (hVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("diskLruCache");
                    hVar2 = null;
                }
                if (hVar2.a(str)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new g(str), 2, (Object) null);
                    bo.app.h hVar3 = this.diskLruCache;
                    if (hVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("diskLruCache");
                    } else {
                        hVar = hVar3;
                    }
                    Bitmap b2 = hVar.b(str);
                    reentrantLock.unlock();
                    return b2;
                }
            }
            Unit unit = Unit.INSTANCE;
            return null;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final Bitmap getBitmapFromMemCache(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.memoryCache.get(str);
    }

    public final Bitmap getBitmapFromUrl(Context context, String str, BrazeViewBounds brazeViewBounds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        if (StringsKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) h.b, 3, (Object) null);
            return null;
        }
        try {
            Bitmap bitmapFromCache = getBitmapFromCache(str);
            if (bitmapFromCache != null) {
                return bitmapFromCache;
            }
            if (this.isOffline) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) i.b, 3, (Object) null);
            } else {
                Uri parse = Uri.parse(str);
                Intrinsics.checkNotNullExpressionValue(parse, "imageUri");
                Bitmap downloadBitmapFromUrl = downloadBitmapFromUrl(context, parse, brazeViewBounds);
                if (downloadBitmapFromUrl != null) {
                    putBitmapIntoCache(str, downloadBitmapFromUrl, BrazeFileUtils.isLocalUri(parse));
                    return downloadBitmapFromUrl;
                }
            }
            return null;
        } catch (Throwable th) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, th, (Function0<String>) new j(str));
        }
    }

    public Bitmap getInAppMessageBitmapFromUrl(Context context, IInAppMessage iInAppMessage, String str, BrazeViewBounds brazeViewBounds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        return getBitmapFromUrl(context, str, brazeViewBounds);
    }

    public final LruCache<String, Bitmap> getMemoryCache() {
        return this.memoryCache;
    }

    public Bitmap getPushBitmapFromUrl(Context context, Bundle bundle, String str, BrazeViewBounds brazeViewBounds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        return getBitmapFromUrl(context, str, brazeViewBounds);
    }

    public final boolean isDiskCacheStarting() {
        return this.isDiskCacheStarting;
    }

    public final void putBitmapIntoCache(String str, Bitmap bitmap, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (getBitmapFromMemCache(str) == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new l(str), 3, (Object) null);
            this.memoryCache.put(str, bitmap);
        }
        if (z) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new m(str), 3, (Object) null);
            return;
        }
        ReentrantLock reentrantLock = this.diskCacheLock;
        reentrantLock.lock();
        try {
            if (!this.isDiskCacheStarting) {
                bo.app.h hVar = this.diskLruCache;
                bo.app.h hVar2 = null;
                if (hVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("diskLruCache");
                    hVar = null;
                }
                if (!hVar.a(str)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new n(str), 3, (Object) null);
                    bo.app.h hVar3 = this.diskLruCache;
                    if (hVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("diskLruCache");
                    } else {
                        hVar2 = hVar3;
                    }
                    hVar2.a(str, bitmap);
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void renderUrlIntoCardView(Context context, Card card, String str, ImageView imageView, BrazeViewBounds brazeViewBounds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        renderUrlIntoView(context, str, imageView, brazeViewBounds);
    }

    public void renderUrlIntoInAppMessageView(Context context, IInAppMessage iInAppMessage, String str, ImageView imageView, BrazeViewBounds brazeViewBounds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        renderUrlIntoView(context, str, imageView, brazeViewBounds);
    }

    public void setOffline(boolean z) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new r(z), 2, (Object) null);
        this.isOffline = z;
    }
}
