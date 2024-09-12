package expo.modules.image.records;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ApplicationVersionSignature;
import com.facebook.common.util.UriUtil;
import expo.modules.image.GlideBlurhashModel;
import expo.modules.image.GlideModel;
import expo.modules.image.GlideRawModel;
import expo.modules.image.GlideThumbhashModel;
import expo.modules.image.GlideUriModel;
import expo.modules.image.GlideUrlModel;
import expo.modules.image.ResourceIdHelper;
import expo.modules.image.okhttp.GlideUrlWithCustomCacheKey;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\u0017\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001a\u0010(\u001a\u0004\u0018\u00010\u00182\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010\u00182\u0006\u0010*\u001a\u00020+H\u0002JW\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0017\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b0J\u0015\u00101\u001a\u0002022\u0006\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b3J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\b\u00108\u001a\u000209H\u0002J\t\u0010:\u001a\u00020\u0005HÖ\u0001J\u0006\u0010;\u001a\u000205J\b\u0010<\u001a\u000205H\u0002J\b\u0010=\u001a\u000205H\u0002J\b\u0010>\u001a\u000205H\u0002J\b\u0010?\u001a\u000205H\u0002J\b\u0010@\u001a\u000205H\u0002J\u0006\u0010A\u001a\u000205J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R*\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\b8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u001bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0016¨\u0006C"}, d2 = {"Lexpo/modules/image/records/SourceMap;", "Lexpo/modules/kotlin/records/Record;", "uri", "", "width", "", "height", "scale", "", "headers", "", "cacheKey", "(Ljava/lang/String;IIDLjava/util/Map;Ljava/lang/String;)V", "getCacheKey$annotations", "()V", "getCacheKey", "()Ljava/lang/String;", "getHeaders$annotations", "getHeaders", "()Ljava/util/Map;", "getHeight$annotations", "getHeight", "()I", "parsedUri", "Landroid/net/Uri;", "pixelCount", "getPixelCount$expo_image_release", "()D", "getScale$annotations", "getScale", "getUri$annotations", "getUri", "getWidth$annotations", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "computeLocalUri", "stringUri", "context", "Landroid/content/Context;", "computeUri", "copy", "createGlideModel", "Lexpo/modules/image/GlideModel;", "createGlideModel$expo_image_release", "createOptions", "Lcom/bumptech/glide/request/RequestOptions;", "createOptions$expo_image_release", "equals", "", "other", "", "getCustomHeaders", "Lcom/bumptech/glide/load/model/Headers;", "hashCode", "isBlurhash", "isContentUrl", "isDataUrl", "isLocalFileUri", "isLocalResourceUri", "isResourceUri", "isThumbhash", "toString", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SourceMap.kt */
public final class SourceMap implements Record {
    private final String cacheKey;
    private final Map<String, String> headers;
    private final int height;
    private Uri parsedUri;
    private final double scale;
    private final String uri;
    private final int width;

    public SourceMap() {
        this((String) null, 0, 0, 0.0d, (Map) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SourceMap copy$default(SourceMap sourceMap, String str, int i, int i2, double d, Map<String, String> map, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = sourceMap.uri;
        }
        if ((i3 & 2) != 0) {
            i = sourceMap.width;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = sourceMap.height;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            d = sourceMap.scale;
        }
        double d2 = d;
        if ((i3 & 16) != 0) {
            map = sourceMap.headers;
        }
        Map<String, String> map2 = map;
        if ((i3 & 32) != 0) {
            str2 = sourceMap.cacheKey;
        }
        return sourceMap.copy(str, i4, i5, d2, map2, str2);
    }

    @Field
    public static /* synthetic */ void getCacheKey$annotations() {
    }

    @Field
    public static /* synthetic */ void getHeaders$annotations() {
    }

    @Field
    public static /* synthetic */ void getHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getScale$annotations() {
    }

    @Field
    public static /* synthetic */ void getUri$annotations() {
    }

    @Field
    public static /* synthetic */ void getWidth$annotations() {
    }

    public final String component1() {
        return this.uri;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final double component4() {
        return this.scale;
    }

    public final Map<String, String> component5() {
        return this.headers;
    }

    public final String component6() {
        return this.cacheKey;
    }

    public final SourceMap copy(String str, int i, int i2, double d, Map<String, String> map, String str2) {
        return new SourceMap(str, i, i2, d, map, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceMap)) {
            return false;
        }
        SourceMap sourceMap = (SourceMap) obj;
        return Intrinsics.areEqual((Object) this.uri, (Object) sourceMap.uri) && this.width == sourceMap.width && this.height == sourceMap.height && Intrinsics.areEqual((Object) Double.valueOf(this.scale), (Object) Double.valueOf(sourceMap.scale)) && Intrinsics.areEqual((Object) this.headers, (Object) sourceMap.headers) && Intrinsics.areEqual((Object) this.cacheKey, (Object) sourceMap.cacheKey);
    }

    public int hashCode() {
        String str = this.uri;
        int i = 0;
        int hashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + Double.hashCode(this.scale)) * 31;
        Map<String, String> map = this.headers;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str2 = this.cacheKey;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        String str = this.uri;
        int i = this.width;
        int i2 = this.height;
        double d = this.scale;
        Map<String, String> map = this.headers;
        return "SourceMap(uri=" + str + ", width=" + i + ", height=" + i2 + ", scale=" + d + ", headers=" + map + ", cacheKey=" + this.cacheKey + ")";
    }

    public SourceMap(String str, int i, int i2, double d, Map<String, String> map, String str2) {
        this.uri = str;
        this.width = i;
        this.height = i2;
        this.scale = d;
        this.headers = map;
        this.cacheKey = str2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SourceMap(java.lang.String r7, int r8, int r9, double r10, java.util.Map r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            r1 = 0
            if (r7 == 0) goto L_0x000f
            r2 = r1
            goto L_0x0010
        L_0x000f:
            r2 = r8
        L_0x0010:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r1 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
        L_0x001c:
            r3 = r10
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r5 = r0
            goto L_0x0024
        L_0x0023:
            r5 = r12
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r14 = r0
            goto L_0x002b
        L_0x002a:
            r14 = r13
        L_0x002b:
            r7 = r6
            r8 = r15
            r9 = r2
            r10 = r1
            r11 = r3
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.image.records.SourceMap.<init>(java.lang.String, int, int, double, java.util.Map, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getUri() {
        return this.uri;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final double getScale() {
        return this.scale;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getCacheKey() {
        return this.cacheKey;
    }

    private final boolean isDataUrl() {
        String scheme;
        Uri uri2 = this.parsedUri;
        if (uri2 == null || (scheme = uri2.getScheme()) == null) {
            return false;
        }
        return StringsKt.startsWith$default(scheme, "data", false, 2, (Object) null);
    }

    private final boolean isContentUrl() {
        String scheme;
        Uri uri2 = this.parsedUri;
        if (uri2 == null || (scheme = uri2.getScheme()) == null) {
            return false;
        }
        return StringsKt.startsWith$default(scheme, "content", false, 2, (Object) null);
    }

    private final boolean isResourceUri() {
        String scheme;
        Uri uri2 = this.parsedUri;
        if (uri2 == null || (scheme = uri2.getScheme()) == null) {
            return false;
        }
        return StringsKt.startsWith$default(scheme, UriUtil.QUALIFIED_RESOURCE_SCHEME, false, 2, (Object) null);
    }

    private final boolean isLocalResourceUri() {
        String scheme;
        Uri uri2 = this.parsedUri;
        if (uri2 == null || (scheme = uri2.getScheme()) == null) {
            return false;
        }
        return StringsKt.startsWith$default(scheme, UriUtil.LOCAL_RESOURCE_SCHEME, false, 2, (Object) null);
    }

    private final boolean isLocalFileUri() {
        String scheme;
        Uri uri2 = this.parsedUri;
        if (uri2 == null || (scheme = uri2.getScheme()) == null) {
            return false;
        }
        return StringsKt.startsWith$default(scheme, "file", false, 2, (Object) null);
    }

    public final boolean isBlurhash() {
        String scheme;
        Uri uri2 = this.parsedUri;
        if (uri2 == null || (scheme = uri2.getScheme()) == null) {
            return false;
        }
        return StringsKt.startsWith$default(scheme, "blurhash", false, 2, (Object) null);
    }

    public final boolean isThumbhash() {
        String scheme;
        Uri uri2 = this.parsedUri;
        if (uri2 == null || (scheme = uri2.getScheme()) == null) {
            return false;
        }
        return StringsKt.startsWith$default(scheme, "thumbhash", false, 2, (Object) null);
    }

    public final GlideModel createGlideModel$expo_image_release(Context context) {
        GlideUrl glideUrl;
        Intrinsics.checkNotNullParameter(context, "context");
        CharSequence charSequence = this.uri;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        if (this.parsedUri == null) {
            this.parsedUri = computeUri(context);
        }
        if (isContentUrl() || isDataUrl()) {
            return new GlideRawModel(this.uri);
        }
        if (isBlurhash()) {
            Uri uri2 = this.parsedUri;
            Intrinsics.checkNotNull(uri2);
            return new GlideBlurhashModel(uri2, this.width, this.height);
        } else if (isThumbhash()) {
            Uri uri3 = this.parsedUri;
            Intrinsics.checkNotNull(uri3);
            return new GlideThumbhashModel(uri3);
        } else if (isResourceUri()) {
            Uri uri4 = this.parsedUri;
            Intrinsics.checkNotNull(uri4);
            return new GlideUriModel(uri4);
        } else if (isLocalResourceUri()) {
            Uri uri5 = this.parsedUri;
            Intrinsics.checkNotNull(uri5);
            String uri6 = uri5.toString();
            Intrinsics.checkNotNullExpressionValue(uri6, "parsedUri!!.toString()");
            Uri parse = Uri.parse(StringsKt.replace$default(uri6, "res:/", "android.resource://" + context.getPackageName() + "/", false, 4, (Object) null));
            Intrinsics.checkNotNullExpressionValue(parse, "parse(parsedUri!!.toStri…ntext.packageName + \"/\"))");
            return new GlideUriModel(parse);
        } else if (isLocalFileUri()) {
            Uri uri7 = this.parsedUri;
            Intrinsics.checkNotNull(uri7);
            String uri8 = uri7.toString();
            Intrinsics.checkNotNullExpressionValue(uri8, "parsedUri!!.toString()");
            return new GlideRawModel(uri8);
        } else {
            if (this.cacheKey == null) {
                glideUrl = new GlideUrl(this.uri, getCustomHeaders());
            } else {
                glideUrl = new GlideUrlWithCustomCacheKey(this.uri, getCustomHeaders(), this.cacheKey);
            }
            return new GlideUrlModel(glideUrl);
        }
    }

    public final RequestOptions createOptions$expo_image_release(Context context) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        RequestOptions requestOptions = new RequestOptions();
        if (this.parsedUri == null) {
            this.parsedUri = computeUri(context);
        }
        int i2 = this.width;
        if (!(i2 == 0 || (i = this.height) == 0)) {
            double d = this.scale;
            requestOptions.override((int) (((double) i2) * d), (int) (((double) i) * d));
        }
        if (isResourceUri()) {
            requestOptions.apply(RequestOptions.signatureOf(ApplicationVersionSignature.obtain(context)));
        }
        return requestOptions;
    }

    private final Headers getCustomHeaders() {
        if (this.headers == null) {
            Headers headers2 = LazyHeaders.DEFAULT;
            Intrinsics.checkNotNullExpressionValue(headers2, "DEFAULT");
            return headers2;
        }
        LazyHeaders.Builder builder = new LazyHeaders.Builder();
        for (Map.Entry next : this.headers.entrySet()) {
            builder.addHeader((String) next.getKey(), (String) next.getValue());
        }
        LazyHeaders build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n      .apply {… }\n      }\n      .build()");
        return build;
    }

    private final Uri computeUri(Context context) {
        String str = this.uri;
        if (str == null) {
            return null;
        }
        try {
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(stringUri)");
            if (parse.getScheme() == null) {
                return computeLocalUri(str, context);
            }
            return parse;
        } catch (Exception unused) {
            return computeLocalUri(str, context);
        }
    }

    private final Uri computeLocalUri(String str, Context context) {
        return ResourceIdHelper.INSTANCE.getResourceUri(context, str);
    }

    public final double getPixelCount$expo_image_release() {
        double d = this.scale;
        return ((double) (this.width * this.height)) * d * d;
    }
}
