package coil.request;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.os.Build;
import coil.size.Scale;
import coil.size.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0019¢\u0006\u0002\u0010\u001cJ \u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u0019J\u0013\u00108\u001a\u00020\r2\b\u00109\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010:\u001a\u00020;H\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u001a\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b,\u0010)R\u0011\u0010\u001b\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006<"}, d2 = {"Lcoil/request/Options;", "", "context", "Landroid/content/Context;", "config", "Landroid/graphics/Bitmap$Config;", "colorSpace", "Landroid/graphics/ColorSpace;", "size", "Lcoil/size/Size;", "scale", "Lcoil/size/Scale;", "allowInexactSize", "", "allowRgb565", "premultipliedAlpha", "diskCacheKey", "", "headers", "Lokhttp3/Headers;", "tags", "Lcoil/request/Tags;", "parameters", "Lcoil/request/Parameters;", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "(Landroid/content/Context;Landroid/graphics/Bitmap$Config;Landroid/graphics/ColorSpace;Lcoil/size/Size;Lcoil/size/Scale;ZZZLjava/lang/String;Lokhttp3/Headers;Lcoil/request/Tags;Lcoil/request/Parameters;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", "getAllowInexactSize", "()Z", "getAllowRgb565", "getColorSpace", "()Landroid/graphics/ColorSpace;", "getConfig", "()Landroid/graphics/Bitmap$Config;", "getContext", "()Landroid/content/Context;", "getDiskCacheKey", "()Ljava/lang/String;", "getDiskCachePolicy", "()Lcoil/request/CachePolicy;", "getHeaders", "()Lokhttp3/Headers;", "getMemoryCachePolicy", "getNetworkCachePolicy", "getParameters", "()Lcoil/request/Parameters;", "getPremultipliedAlpha", "getScale", "()Lcoil/size/Scale;", "getSize", "()Lcoil/size/Size;", "getTags", "()Lcoil/request/Tags;", "copy", "equals", "other", "hashCode", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Options.kt */
public final class Options {
    private final boolean allowInexactSize;
    private final boolean allowRgb565;
    private final ColorSpace colorSpace;
    private final Bitmap.Config config;
    private final Context context;
    private final String diskCacheKey;
    private final CachePolicy diskCachePolicy;
    private final Headers headers;
    private final CachePolicy memoryCachePolicy;
    private final CachePolicy networkCachePolicy;
    private final Parameters parameters;
    private final boolean premultipliedAlpha;
    private final Scale scale;
    private final Size size;
    private final Tags tags;

    public Options(Context context2, Bitmap.Config config2, ColorSpace colorSpace2, Size size2, Scale scale2, boolean z, boolean z2, boolean z3, String str, Headers headers2, Tags tags2, Parameters parameters2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        this.context = context2;
        this.config = config2;
        this.colorSpace = colorSpace2;
        this.size = size2;
        this.scale = scale2;
        this.allowInexactSize = z;
        this.allowRgb565 = z2;
        this.premultipliedAlpha = z3;
        this.diskCacheKey = str;
        this.headers = headers2;
        this.tags = tags2;
        this.parameters = parameters2;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Options(android.content.Context r15, android.graphics.Bitmap.Config r16, android.graphics.ColorSpace r17, coil.size.Size r18, coil.size.Scale r19, boolean r20, boolean r21, boolean r22, java.lang.String r23, okhttp3.Headers r24, coil.request.Tags r25, coil.request.Parameters r26, coil.request.CachePolicy r27, coil.request.CachePolicy r28, coil.request.CachePolicy r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r14 = this;
            r0 = r30
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0009
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888
            goto L_0x000b
        L_0x0009:
            r1 = r16
        L_0x000b:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0014
            android.graphics.ColorSpace r2 = coil.util.Utils.getNULL_COLOR_SPACE()
            goto L_0x0016
        L_0x0014:
            r2 = r17
        L_0x0016:
            r3 = r0 & 8
            if (r3 == 0) goto L_0x001d
            coil.size.Size r3 = coil.size.Size.ORIGINAL
            goto L_0x001f
        L_0x001d:
            r3 = r18
        L_0x001f:
            r4 = r0 & 16
            if (r4 == 0) goto L_0x0026
            coil.size.Scale r4 = coil.size.Scale.FIT
            goto L_0x0028
        L_0x0026:
            r4 = r19
        L_0x0028:
            r5 = r0 & 32
            r6 = 0
            if (r5 == 0) goto L_0x002f
            r5 = r6
            goto L_0x0031
        L_0x002f:
            r5 = r20
        L_0x0031:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r6 = r21
        L_0x0038:
            r7 = r0 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x003e
            r7 = 1
            goto L_0x0040
        L_0x003e:
            r7 = r22
        L_0x0040:
            r8 = r0 & 256(0x100, float:3.59E-43)
            if (r8 == 0) goto L_0x0046
            r8 = 0
            goto L_0x0048
        L_0x0046:
            r8 = r23
        L_0x0048:
            r9 = r0 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x0051
            okhttp3.Headers r9 = coil.util.Utils.getEMPTY_HEADERS()
            goto L_0x0053
        L_0x0051:
            r9 = r24
        L_0x0053:
            r10 = r0 & 1024(0x400, float:1.435E-42)
            if (r10 == 0) goto L_0x005a
            coil.request.Tags r10 = coil.request.Tags.EMPTY
            goto L_0x005c
        L_0x005a:
            r10 = r25
        L_0x005c:
            r11 = r0 & 2048(0x800, float:2.87E-42)
            if (r11 == 0) goto L_0x0063
            coil.request.Parameters r11 = coil.request.Parameters.EMPTY
            goto L_0x0065
        L_0x0063:
            r11 = r26
        L_0x0065:
            r12 = r0 & 4096(0x1000, float:5.74E-42)
            if (r12 == 0) goto L_0x006c
            coil.request.CachePolicy r12 = coil.request.CachePolicy.ENABLED
            goto L_0x006e
        L_0x006c:
            r12 = r27
        L_0x006e:
            r13 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r13 == 0) goto L_0x0075
            coil.request.CachePolicy r13 = coil.request.CachePolicy.ENABLED
            goto L_0x0077
        L_0x0075:
            r13 = r28
        L_0x0077:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x007e
            coil.request.CachePolicy r0 = coil.request.CachePolicy.ENABLED
            goto L_0x0080
        L_0x007e:
            r0 = r29
        L_0x0080:
            r16 = r14
            r17 = r15
            r18 = r1
            r19 = r2
            r20 = r3
            r21 = r4
            r22 = r5
            r23 = r6
            r24 = r7
            r25 = r8
            r26 = r9
            r27 = r10
            r28 = r11
            r29 = r12
            r30 = r13
            r31 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.request.Options.<init>(android.content.Context, android.graphics.Bitmap$Config, android.graphics.ColorSpace, coil.size.Size, coil.size.Scale, boolean, boolean, boolean, java.lang.String, okhttp3.Headers, coil.request.Tags, coil.request.Parameters, coil.request.CachePolicy, coil.request.CachePolicy, coil.request.CachePolicy, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Bitmap.Config getConfig() {
        return this.config;
    }

    public final ColorSpace getColorSpace() {
        return this.colorSpace;
    }

    public final Size getSize() {
        return this.size;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final boolean getAllowInexactSize() {
        return this.allowInexactSize;
    }

    public final boolean getAllowRgb565() {
        return this.allowRgb565;
    }

    public final boolean getPremultipliedAlpha() {
        return this.premultipliedAlpha;
    }

    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final Tags getTags() {
        return this.tags;
    }

    public final Parameters getParameters() {
        return this.parameters;
    }

    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    public static /* synthetic */ Options copy$default(Options options, Context context2, Bitmap.Config config2, ColorSpace colorSpace2, Size size2, Scale scale2, boolean z, boolean z2, boolean z3, String str, Headers headers2, Tags tags2, Parameters parameters2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, int i, Object obj) {
        CachePolicy cachePolicy4;
        Options options2 = options;
        int i2 = i;
        Context context3 = (i2 & 1) != 0 ? options2.context : context2;
        Bitmap.Config config3 = (i2 & 2) != 0 ? options2.config : config2;
        ColorSpace colorSpace3 = (i2 & 4) != 0 ? options2.colorSpace : colorSpace2;
        Size size3 = (i2 & 8) != 0 ? options2.size : size2;
        Scale scale3 = (i2 & 16) != 0 ? options2.scale : scale2;
        boolean z4 = (i2 & 32) != 0 ? options2.allowInexactSize : z;
        boolean z5 = (i2 & 64) != 0 ? options2.allowRgb565 : z2;
        boolean z6 = (i2 & 128) != 0 ? options2.premultipliedAlpha : z3;
        String str2 = (i2 & 256) != 0 ? options2.diskCacheKey : str;
        Headers headers3 = (i2 & 512) != 0 ? options2.headers : headers2;
        Tags tags3 = (i2 & 1024) != 0 ? options2.tags : tags2;
        Parameters parameters3 = (i2 & 2048) != 0 ? options2.parameters : parameters2;
        CachePolicy cachePolicy5 = (i2 & 4096) != 0 ? options2.memoryCachePolicy : cachePolicy;
        CachePolicy cachePolicy6 = (i2 & 8192) != 0 ? options2.diskCachePolicy : cachePolicy2;
        if ((i2 & 16384) != 0) {
            cachePolicy4 = options2.networkCachePolicy;
        } else {
            cachePolicy4 = cachePolicy3;
        }
        return options.copy(context3, config3, colorSpace3, size3, scale3, z4, z5, z6, str2, headers3, tags3, parameters3, cachePolicy5, cachePolicy6, cachePolicy4);
    }

    public final Options copy(Context context2, Bitmap.Config config2, ColorSpace colorSpace2, Size size2, Scale scale2, boolean z, boolean z2, boolean z3, String str, Headers headers2, Tags tags2, Parameters parameters2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        return new Options(context2, config2, colorSpace2, size2, scale2, z, z2, z3, str, headers2, tags2, parameters2, cachePolicy, cachePolicy2, cachePolicy3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Options) {
            Options options = (Options) obj;
            if (Intrinsics.areEqual((Object) this.context, (Object) options.context) && this.config == options.config && ((Build.VERSION.SDK_INT < 26 || Intrinsics.areEqual((Object) this.colorSpace, (Object) options.colorSpace)) && Intrinsics.areEqual((Object) this.size, (Object) options.size) && this.scale == options.scale && this.allowInexactSize == options.allowInexactSize && this.allowRgb565 == options.allowRgb565 && this.premultipliedAlpha == options.premultipliedAlpha && Intrinsics.areEqual((Object) this.diskCacheKey, (Object) options.diskCacheKey) && Intrinsics.areEqual((Object) this.headers, (Object) options.headers) && Intrinsics.areEqual((Object) this.tags, (Object) options.tags) && Intrinsics.areEqual((Object) this.parameters, (Object) options.parameters) && this.memoryCachePolicy == options.memoryCachePolicy && this.diskCachePolicy == options.diskCachePolicy && this.networkCachePolicy == options.networkCachePolicy)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.context.hashCode() * 31) + this.config.hashCode()) * 31;
        ColorSpace colorSpace2 = this.colorSpace;
        int i = 0;
        int hashCode2 = (((((((((((hashCode + (colorSpace2 != null ? colorSpace2.hashCode() : 0)) * 31) + this.size.hashCode()) * 31) + this.scale.hashCode()) * 31) + Boolean.hashCode(this.allowInexactSize)) * 31) + Boolean.hashCode(this.allowRgb565)) * 31) + Boolean.hashCode(this.premultipliedAlpha)) * 31;
        String str = this.diskCacheKey;
        if (str != null) {
            i = str.hashCode();
        }
        return ((((((((((((hashCode2 + i) * 31) + this.headers.hashCode()) * 31) + this.tags.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode();
    }
}
