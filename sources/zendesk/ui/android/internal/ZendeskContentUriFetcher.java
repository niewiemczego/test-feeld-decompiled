package zendesk.ui.android.internal;

import android.content.Context;
import android.net.Uri;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.ImageSources;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.fetch.SourceResult;
import coil.request.Options;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\nB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lzendesk/ui/android/internal/ZendeskContentUriFetcher;", "Lcoil/fetch/Fetcher;", "context", "Landroid/content/Context;", "data", "Landroid/net/Uri;", "(Landroid/content/Context;Landroid/net/Uri;)V", "fetch", "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ZendeskContentUriFetcher.kt */
public final class ZendeskContentUriFetcher implements Fetcher {
    private final Context context;
    private final Uri data;

    public /* synthetic */ ZendeskContentUriFetcher(Context context2, Uri uri, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, uri);
    }

    private ZendeskContentUriFetcher(Context context2, Uri uri) {
        this.context = context2;
        this.data = uri;
    }

    public Object fetch(Continuation<? super FetchResult> continuation) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            ZendeskContentUriFetcher zendeskContentUriFetcher = this;
            obj = Result.m983constructorimpl(this.context.getContentResolver().openInputStream(this.data));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m983constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m989isFailureimpl(obj)) {
            obj = null;
        }
        InputStream inputStream = (InputStream) obj;
        if (inputStream != null) {
            return new SourceResult(ImageSources.create(Okio.buffer(Okio.source(inputStream)), this.context), this.context.getContentResolver().getType(this.data), DataSource.DISK);
        }
        throw new IllegalStateException(("Unable to open '" + this.data + "'.").toString());
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lzendesk/ui/android/internal/ZendeskContentUriFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "create", "Lcoil/fetch/Fetcher;", "data", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ZendeskContentUriFetcher.kt */
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final Context context;

        public Factory(Context context2) {
            Intrinsics.checkNotNullParameter(context2, "context");
            this.context = context2;
        }

        public Fetcher create(Uri uri, Options options, ImageLoader imageLoader) {
            Intrinsics.checkNotNullParameter(uri, "data");
            Intrinsics.checkNotNullParameter(options, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
            Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
            if (Intrinsics.areEqual((Object) uri.getScheme(), (Object) "content")) {
                return new ZendeskContentUriFetcher(this.context, uri, (DefaultConstructorMarker) null);
            }
            Fetcher fetcher = null;
            return null;
        }
    }
}
