package okhttp3.logging;

import io.sentry.SentryEvent;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\r\u0010\u000b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\n\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/Interceptor;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "headersToRedact", "", "", "<set-?>", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "level", "getLevel", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", "bodyHasUnknownEncoding", "", "headers", "Lokhttp3/Headers;", "-deprecated_level", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "logHeader", "", "i", "", "redactHeader", "name", "setLevel", "Level", "Logger", "okhttp-logging-interceptor"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpLoggingInterceptor.kt */
public final class HttpLoggingInterceptor implements Interceptor {
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Level;", "", "(Ljava/lang/String;I)V", "NONE", "BASIC", "HEADERS", "BODY", "okhttp-logging-interceptor"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpLoggingInterceptor.kt */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public HttpLoggingInterceptor() {
        this((Logger) null, 1, (DefaultConstructorMarker) null);
    }

    public HttpLoggingInterceptor(Logger logger2) {
        Intrinsics.checkNotNullParameter(logger2, SentryEvent.JsonKeys.LOGGER);
        this.logger = logger2;
        this.headersToRedact = SetsKt.emptySet();
        this.level = Level.NONE;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HttpLoggingInterceptor(Logger logger2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Logger.DEFAULT : logger2);
    }

    public final Level getLevel() {
        return this.level;
    }

    public final void level(Level level2) {
        Intrinsics.checkNotNullParameter(level2, "<set-?>");
        this.level = level2;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bæ\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "log", "", "message", "", "Companion", "okhttp-logging-interceptor"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpLoggingInterceptor.kt */
    public interface Logger {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final Logger DEFAULT = new Companion.DefaultLogger();

        void log(String str);

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion;", "", "()V", "DEFAULT", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "DefaultLogger", "okhttp-logging-interceptor"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: HttpLoggingInterceptor.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion$DefaultLogger;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "()V", "log", "", "message", "", "okhttp-logging-interceptor"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: HttpLoggingInterceptor.kt */
            private static final class DefaultLogger implements Logger {
                public void log(String str) {
                    Intrinsics.checkNotNullParameter(str, "message");
                    Platform.log$default(Platform.Companion.get(), str, 0, (Throwable) null, 6, (Object) null);
                }
            }
        }
    }

    public final void redactHeader(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        TreeSet treeSet = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        Collection collection = treeSet;
        CollectionsKt.addAll(collection, this.headersToRedact);
        collection.add(str);
        this.headersToRedact = treeSet;
    }

    public final HttpLoggingInterceptor setLevel(Level level2) {
        Intrinsics.checkNotNullParameter(level2, "level");
        HttpLoggingInterceptor httpLoggingInterceptor = this;
        level(level2);
        return this;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = "level", imports = {}))
    /* renamed from: -deprecated_level  reason: not valid java name */
    public final Level m2721deprecated_level() {
        return this.level;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        String str2;
        char c;
        String str3;
        Charset charset;
        Long l;
        Charset charset2;
        Throwable th;
        Charset charset3;
        Interceptor.Chain chain2 = chain;
        Intrinsics.checkNotNullParameter(chain2, "chain");
        Level level2 = this.level;
        Request request = chain.request();
        if (level2 == Level.NONE) {
            return chain2.proceed(request);
        }
        boolean z = level2 == Level.BODY;
        boolean z2 = z || level2 == Level.HEADERS;
        RequestBody body = request.body();
        Connection connection = chain.connection();
        String str4 = "--> " + request.method() + ' ' + request.url() + (connection != null ? Intrinsics.stringPlus(" ", connection.protocol()) : "");
        if (!z2 && body != null) {
            str4 = str4 + " (" + body.contentLength() + "-byte body)";
        }
        this.logger.log(str4);
        if (z2) {
            Headers headers = request.headers();
            if (body != null) {
                MediaType contentType = body.contentType();
                if (contentType != null && headers.get("Content-Type") == null) {
                    this.logger.log(Intrinsics.stringPlus("Content-Type: ", contentType));
                }
                if (body.contentLength() != -1 && headers.get("Content-Length") == null) {
                    this.logger.log(Intrinsics.stringPlus("Content-Length: ", Long.valueOf(body.contentLength())));
                }
            }
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                logHeader(headers, i);
            }
            if (!z || body == null) {
                this.logger.log(Intrinsics.stringPlus("--> END ", request.method()));
            } else if (bodyHasUnknownEncoding(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
            } else if (body.isDuplex()) {
                this.logger.log("--> END " + request.method() + " (duplex request body omitted)");
            } else if (body.isOneShot()) {
                this.logger.log("--> END " + request.method() + " (one-shot body omitted)");
            } else {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                MediaType contentType2 = body.contentType();
                if (contentType2 == null) {
                    charset3 = null;
                } else {
                    charset3 = contentType2.charset(StandardCharsets.UTF_8);
                }
                if (charset3 == null) {
                    charset3 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(charset3, "UTF_8");
                }
                this.logger.log("");
                if (Utf8Kt.isProbablyUtf8(buffer)) {
                    this.logger.log(buffer.readString(charset3));
                    this.logger.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                } else {
                    this.logger.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                }
            }
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain2.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            Intrinsics.checkNotNull(body2);
            long contentLength = body2.contentLength();
            String str5 = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
            Logger logger2 = this.logger;
            String str6 = "-byte body)";
            long j = contentLength;
            StringBuilder append = new StringBuilder().append("<-- ").append(proceed.code());
            if (proceed.message().length() == 0) {
                str = "-byte body omitted)";
                str2 = "";
                c = ' ';
            } else {
                str = "-byte body omitted)";
                c = ' ';
                str2 = ' ' + proceed.message();
            }
            StringBuilder append2 = append.append(str2).append(c).append(proceed.request().url()).append(" (").append(millis).append("ms");
            if (!z2) {
                str3 = ", " + str5 + " body";
            } else {
                str3 = "";
            }
            logger2.log(append2.append(str3).append(')').toString());
            if (z2) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    logHeader(headers2, i2);
                }
                if (!z || !HttpHeaders.promisesBody(proceed)) {
                    this.logger.log("<-- END HTTP");
                } else if (bodyHasUnknownEncoding(proceed.headers())) {
                    this.logger.log("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource source = body2.source();
                    source.request(Long.MAX_VALUE);
                    Buffer buffer2 = source.getBuffer();
                    if (StringsKt.equals("gzip", headers2.get("Content-Encoding"), true)) {
                        l = Long.valueOf(buffer2.size());
                        Closeable gzipSource = new GzipSource(buffer2.clone());
                        try {
                            Buffer buffer3 = new Buffer();
                            buffer3.writeAll((GzipSource) gzipSource);
                            charset = null;
                            CloseableKt.closeFinally(gzipSource, (Throwable) null);
                            buffer2 = buffer3;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            CloseableKt.closeFinally(gzipSource, th);
                            throw th3;
                        }
                    } else {
                        charset = null;
                        l = null;
                    }
                    MediaType contentType3 = body2.contentType();
                    if (contentType3 == null) {
                        charset2 = charset;
                    } else {
                        charset2 = contentType3.charset(StandardCharsets.UTF_8);
                    }
                    if (charset2 == null) {
                        charset2 = StandardCharsets.UTF_8;
                        Intrinsics.checkNotNullExpressionValue(charset2, "UTF_8");
                    }
                    if (!Utf8Kt.isProbablyUtf8(buffer2)) {
                        this.logger.log("");
                        this.logger.log("<-- END HTTP (binary " + buffer2.size() + str);
                        return proceed;
                    }
                    if (j != 0) {
                        this.logger.log("");
                        this.logger.log(buffer2.clone().readString(charset2));
                    }
                    if (l != null) {
                        this.logger.log("<-- END HTTP (" + buffer2.size() + "-byte, " + l + "-gzipped-byte body)");
                    } else {
                        this.logger.log("<-- END HTTP (" + buffer2.size() + str6);
                    }
                }
            }
            return proceed;
        } catch (Exception e) {
            Exception exc = e;
            this.logger.log(Intrinsics.stringPlus("<-- HTTP FAILED: ", exc));
            throw exc;
        }
    }

    private final void logHeader(Headers headers, int i) {
        this.logger.log(headers.name(i) + ": " + (this.headersToRedact.contains(headers.name(i)) ? "██" : headers.value(i)));
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        if (str != null && !StringsKt.equals(str, InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY, true) && !StringsKt.equals(str, "gzip", true)) {
            return true;
        }
        return false;
    }
}
