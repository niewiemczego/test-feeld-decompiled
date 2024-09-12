package expo.modules.image.blurhash;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJC\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010\u0019J6\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0017\u001a\u00020\u0018J$\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u0005H\u0002J\u0018\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u001eH\u0002J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0005H\u0002J \u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J \u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u001eH\u0002J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001eH\u0002J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0005H\u0002J4\u0010.\u001a\u00020/*\u00020\u00062\u0006\u0010)\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005H\u0002R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nX\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lexpo/modules/image/blurhash/BlurhashDecoder;", "", "()V", "cacheCosinesX", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "cacheCosinesY", "charMap", "", "", "clearCache", "", "composeBitmap", "Landroid/graphics/Bitmap;", "width", "height", "numCompX", "numCompY", "colors", "", "", "useCache", "", "(IIII[[FZ)Landroid/graphics/Bitmap;", "decode", "blurHash", "", "punch", "", "decode83", "str", "from", "to", "decodeAc", "value", "maxAc", "decodeDc", "colorEnc", "getArrayForCosinesX", "calculate", "getArrayForCosinesY", "linearToSrgb", "signedPow2", "srgbToLinear", "getCos", "", "x", "numComp", "y", "size", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BlurhashDecoder.kt */
public final class BlurhashDecoder {
    public static final BlurhashDecoder INSTANCE = new BlurhashDecoder();
    private static final HashMap<Integer, double[]> cacheCosinesX = new HashMap<>();
    private static final HashMap<Integer, double[]> cacheCosinesY = new HashMap<>();
    private static final Map<Character, Integer> charMap;

    private BlurhashDecoder() {
    }

    static {
        int i = 0;
        Iterable listOf = CollectionsKt.listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '#', '$', '%', '*', '+', ',', '-', '.', ':', ';', '=', '?', '@', '[', ']', '^', '_', '{', '|', '}', '~');
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
        for (Object next : listOf) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(TuplesKt.to(Character.valueOf(((Character) next).charValue()), Integer.valueOf(i)));
            i = i2;
        }
        charMap = MapsKt.toMap((List) arrayList);
    }

    public final void clearCache() {
        cacheCosinesX.clear();
        cacheCosinesY.clear();
    }

    public static /* synthetic */ Bitmap decode$default(BlurhashDecoder blurhashDecoder, String str, int i, int i2, float f, boolean z, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i3 & 16) != 0) {
            z = true;
        }
        return blurhashDecoder.decode(str, i, i2, f2, z);
    }

    public final Bitmap decode(String str, int i, int i2, float f, boolean z) {
        float[] fArr;
        if (str == null || str.length() < 6) {
            return null;
        }
        int decode83 = decode83(str, 0, 1);
        int i3 = (decode83 % 9) + 1;
        int i4 = (decode83 / 9) + 1;
        if (str.length() != (i3 * 2 * i4) + 4) {
            return null;
        }
        float decode832 = ((float) (decode83(str, 1, 2) + 1)) / 166.0f;
        int i5 = i3 * i4;
        float[][] fArr2 = new float[i5][];
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 == 0) {
                BlurhashDecoder blurhashDecoder = INSTANCE;
                fArr = blurhashDecoder.decodeDc(blurhashDecoder.decode83(str, 2, 6));
            } else {
                int i7 = (i6 * 2) + 4;
                BlurhashDecoder blurhashDecoder2 = INSTANCE;
                fArr = blurhashDecoder2.decodeAc(blurhashDecoder2.decode83(str, i7, i7 + 2), decode832 * f);
            }
            fArr2[i6] = fArr;
        }
        return composeBitmap(i, i2, i3, i4, fArr2, z);
    }

    static /* synthetic */ int decode83$default(BlurhashDecoder blurhashDecoder, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return blurhashDecoder.decode83(str, i, i2);
    }

    private final int decode83(String str, int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            Integer num = charMap.get(Character.valueOf(str.charAt(i)));
            int intValue = num != null ? num.intValue() : -1;
            if (intValue != -1) {
                i3 = (i3 * 83) + intValue;
            }
            i++;
        }
        return i3;
    }

    private final float[] decodeDc(int i) {
        return new float[]{srgbToLinear(i >> 16), srgbToLinear((i >> 8) & 255), srgbToLinear(i & 255)};
    }

    private final float srgbToLinear(int i) {
        float f = ((float) i) / 255.0f;
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((double) ((f + 0.055f) / 1.055f), (double) 2.4f);
    }

    private final float[] decodeAc(int i, float f) {
        return new float[]{signedPow2(((float) ((i / 361) - 9)) / 9.0f) * f, signedPow2(((float) (((i / 19) % 19) - 9)) / 9.0f) * f, signedPow2(((float) ((i % 19) - 9)) / 9.0f) * f};
    }

    private final float signedPow2(float f) {
        return Math.copySign((float) Math.pow((double) f, (double) 2.0f), f);
    }

    private final Bitmap composeBitmap(int i, int i2, int i3, int i4, float[][] fArr, boolean z) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int[] iArr = new int[(i5 * i6)];
        boolean z2 = !z || !cacheCosinesX.containsKey(Integer.valueOf(i5 * i7));
        double[] arrayForCosinesX = getArrayForCosinesX(z2, i5, i7);
        boolean z3 = !z || !cacheCosinesY.containsKey(Integer.valueOf(i6 * i8));
        double[] arrayForCosinesY = getArrayForCosinesY(z3, i6, i8);
        int i9 = 0;
        while (i9 < i6) {
            int i10 = 0;
            while (i10 < i5) {
                float f = 0.0f;
                float f2 = 0.0f;
                float f3 = 0.0f;
                int i11 = 0;
                while (i11 < i8) {
                    float f4 = f;
                    float f5 = f2;
                    float f6 = f3;
                    int i12 = 0;
                    while (i12 < i7) {
                        int i13 = i12;
                        int i14 = i11;
                        int i15 = i10;
                        boolean z4 = z3;
                        i9 = i9;
                        float cos = (float) (getCos(arrayForCosinesY, z4, i14, i4, i9, i2) * getCos(arrayForCosinesX, z2, i13, i3, i15, i));
                        float[] fArr2 = fArr[(i14 * i7) + i13];
                        f4 += fArr2[0] * cos;
                        f5 += fArr2[1] * cos;
                        f6 += fArr2[2] * cos;
                        i12 = i13 + 1;
                        i11 = i14;
                        i10 = i15;
                        z3 = z4;
                    }
                    int i16 = i10;
                    int i17 = i9;
                    boolean z5 = z3;
                    i11++;
                    f = f4;
                    f2 = f5;
                    f3 = f6;
                }
                int i18 = i10;
                boolean z6 = z3;
                iArr[i18 + (i5 * i9)] = Color.rgb(linearToSrgb(f), linearToSrgb(f2), linearToSrgb(f3));
                i10 = i18 + 1;
            }
            boolean z7 = z3;
            i9++;
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, i5, i6, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(imageArray,… Bitmap.Config.ARGB_8888)");
        return createBitmap;
    }

    private final double[] getArrayForCosinesY(boolean z, int i, int i2) {
        if (z) {
            int i3 = i * i2;
            double[] dArr = new double[i3];
            cacheCosinesY.put(Integer.valueOf(i3), dArr);
            return dArr;
        }
        double[] dArr2 = cacheCosinesY.get(Integer.valueOf(i * i2));
        Intrinsics.checkNotNull(dArr2);
        Intrinsics.checkNotNullExpressionValue(dArr2, "{\n      cacheCosinesY[height * numCompY]!!\n    }");
        return dArr2;
    }

    private final double[] getArrayForCosinesX(boolean z, int i, int i2) {
        if (z) {
            int i3 = i * i2;
            double[] dArr = new double[i3];
            cacheCosinesX.put(Integer.valueOf(i3), dArr);
            return dArr;
        }
        double[] dArr2 = cacheCosinesX.get(Integer.valueOf(i * i2));
        Intrinsics.checkNotNull(dArr2);
        return dArr2;
    }

    private final double getCos(double[] dArr, boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            dArr[(i2 * i3) + i] = Math.cos(((((double) i3) * 3.141592653589793d) * ((double) i)) / ((double) i4));
        }
        return dArr[i + (i2 * i3)];
    }

    private final int linearToSrgb(float f) {
        float f2;
        float f3;
        float coerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f);
        if (coerceIn <= 0.0031308f) {
            f2 = coerceIn * 12.92f;
            f3 = 255.0f;
        } else {
            f2 = (((float) Math.pow((double) coerceIn, (double) 0.41666666f)) * 1.055f) - 0.055f;
            f3 = (float) 255;
        }
        return (int) ((f2 * f3) + 0.5f);
    }
}
