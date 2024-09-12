package expo.modules.image.thumbhash;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.google.common.base.Ascii;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0012\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0004¨\u0006\u0015"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashDecoder;", "", "()V", "rgbaToThumbHash", "", "w", "", "h", "rgba", "thumbHashToApproximateAspectRatio", "", "hash", "thumbHashToAverageRGBA", "Lexpo/modules/image/thumbhash/ThumbhashDecoder$RGBA;", "thumbHashToBitmap", "Landroid/graphics/Bitmap;", "thumbHashToRGBA", "Lexpo/modules/image/thumbhash/ThumbhashDecoder$Image;", "Channel", "Image", "RGBA", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ThumbhashDecoder.kt */
public final class ThumbhashDecoder {
    public static final ThumbhashDecoder INSTANCE = new ThumbhashDecoder();

    private ThumbhashDecoder() {
    }

    public final byte[] rgbaToThumbHash(int i, int i2, byte[] bArr) {
        int i3;
        int i4;
        int i5 = i;
        int i6 = i2;
        byte[] bArr2 = bArr;
        Intrinsics.checkNotNullParameter(bArr2, "rgba");
        if (i5 <= 100 && i6 <= 100) {
            float f = 0.0f;
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                i3 = i5 * i6;
                if (i7 >= i3) {
                    break;
                }
                float f5 = ((float) (bArr2[i8 + 3] & 255)) / 255.0f;
                float f6 = f5 / 255.0f;
                f2 += ((float) (bArr2[i8] & 255)) * f6;
                f3 += ((float) (bArr2[i8 + 1] & 255)) * f6;
                f4 += f6 * ((float) (bArr2[i8 + 2] & 255));
                f += f5;
                i7++;
                i8 += 4;
            }
            if (f > 0.0f) {
                f2 /= f;
                f3 /= f;
                f4 /= f;
            }
            boolean z = f < ((float) i3);
            int i9 = z ? 5 : 7;
            int max = Math.max(1, Math.round(((float) (i9 * i5)) / ((float) Math.max(i, i2))));
            int max2 = Math.max(1, Math.round(((float) (i9 * i6)) / ((float) Math.max(i, i2))));
            float[] fArr = new float[i3];
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            int i10 = 0;
            int i11 = 0;
            while (i10 < i3) {
                float f7 = ((float) (bArr2[i11 + 3] & 255)) / 255.0f;
                float f8 = 1.0f - f7;
                float f9 = f7 / 255.0f;
                float f10 = f2;
                float f11 = (f2 * f8) + (((float) (bArr2[i11] & 255)) * f9);
                float f12 = f3;
                float f13 = (f3 * f8) + (((float) (bArr2[i11 + 1] & 255)) * f9);
                float f14 = (f8 * f4) + (f9 * ((float) (bArr2[i11 + 2] & 255)));
                float f15 = f11 + f13;
                fArr[i10] = (f15 + f14) / 3.0f;
                fArr2[i10] = (f15 / 2.0f) - f14;
                fArr3[i10] = f11 - f13;
                fArr4[i10] = f7;
                i10++;
                i11 += 4;
                f2 = f10;
                f3 = f12;
            }
            Channel encode = new Channel(Math.max(3, max), Math.max(3, max2)).encode(i5, i6, fArr);
            Channel encode2 = new Channel(3, 3).encode(i5, i6, fArr2);
            Channel encode3 = new Channel(3, 3).encode(i5, i6, fArr3);
            Channel encode4 = z ? new Channel(5, 5).encode(i5, i6, fArr4) : null;
            boolean z2 = i5 > i6;
            int round = Math.round(encode.getDc() * 63.0f) | (Math.round((encode2.getDc() * 31.5f) + 31.5f) << 6) | (Math.round((encode3.getDc() * 31.5f) + 31.5f) << 12) | (Math.round(encode.getScale() * 31.0f) << 18) | (z ? 8388608 : 0);
            if (z2) {
                max = max2;
            }
            int round2 = (z2 ? 32768 : 0) | (Math.round(encode2.getScale() * 63.0f) << 3) | max | (Math.round(encode3.getScale() * 63.0f) << 9);
            int i12 = z ? 6 : 5;
            int length = encode.getAc().length + encode2.getAc().length + encode3.getAc().length;
            if (z) {
                Intrinsics.checkNotNull(encode4);
                i4 = encode4.getAc().length;
            } else {
                i4 = 0;
            }
            byte[] bArr3 = new byte[((((length + i4) + 1) / 2) + i12)];
            bArr3[0] = (byte) round;
            bArr3[1] = (byte) (round >> 8);
            bArr3[2] = (byte) (round >> 16);
            bArr3[3] = (byte) round2;
            bArr3[4] = (byte) (round2 >> 8);
            if (z) {
                Intrinsics.checkNotNull(encode4);
                bArr3[5] = (byte) (Math.round(encode4.getDc() * 15.0f) | (Math.round(encode4.getScale() * 15.0f) << 4));
            }
            int writeTo = encode3.writeTo(bArr3, i12, encode2.writeTo(bArr3, i12, encode.writeTo(bArr3, i12, 0)));
            if (z) {
                Intrinsics.checkNotNull(encode4);
                encode4.writeTo(bArr3, i12, writeTo);
            }
            return bArr3;
        }
        throw new IllegalArgumentException((i5 + ViewHierarchyNode.JsonKeys.X + i6 + " doesn't fit in 100x100").toString());
    }

    public final Image thumbHashToRGBA(byte[] bArr) {
        Channel channel;
        float f;
        float[] fArr;
        float f2;
        float[] fArr2;
        int i;
        byte[] bArr2 = bArr;
        Intrinsics.checkNotNullParameter(bArr2, "hash");
        byte b = (bArr2[0] & 255) | ((bArr2[1] & 255) << 8) | ((bArr2[2] & 255) << Ascii.DLE);
        byte b2 = (bArr2[3] & 255) | ((bArr2[4] & 255) << 8);
        float f3 = ((float) (b & Utf8.REPLACEMENT_BYTE)) / 63.0f;
        float f4 = (((float) ((b >> 6) & 63)) / 31.5f) - 1.0f;
        float f5 = (((float) ((b >> Ascii.FF) & 63)) / 31.5f) - 1.0f;
        float f6 = ((float) ((b >> Ascii.DC2) & 31)) / 31.0f;
        boolean z = (b >> Ascii.ETB) != 0;
        float f7 = ((float) ((b2 >> 3) & 63)) / 63.0f;
        float f8 = ((float) ((b2 >> 9) & 63)) / 63.0f;
        boolean z2 = (b2 >> Ascii.SI) != 0;
        byte b3 = 7;
        int max = Math.max(3, z2 ? z ? (byte) 5 : 7 : b2 & 7);
        if (z2) {
            b3 = 7 & b2;
        } else if (z) {
            b3 = 5;
        }
        int max2 = Math.max(3, b3);
        float f9 = z ? ((float) (bArr2[5] & Ascii.SI)) / 15.0f : 1.0f;
        float f10 = ((float) ((bArr2[5] >> 4) & 15)) / 15.0f;
        int i2 = z ? 6 : 5;
        Channel channel2 = new Channel(max, max2);
        Channel channel3 = new Channel(3, 3);
        float f11 = f3;
        Channel channel4 = new Channel(3, 3);
        int decode = channel4.decode(bArr2, i2, channel3.decode(bArr2, i2, channel2.decode(bArr2, i2, 0, f6), f7 * 1.25f), f8 * 1.25f);
        float[] fArr3 = null;
        if (z) {
            channel = new Channel(5, 5);
            channel.decode(bArr2, i2, decode, f10);
        } else {
            channel = null;
        }
        float[] ac = channel2.getAc();
        float[] ac2 = channel3.getAc();
        float[] ac3 = channel4.getAc();
        if (z) {
            Intrinsics.checkNotNull(channel);
            fArr3 = channel.getAc();
        }
        float thumbHashToApproximateAspectRatio = thumbHashToApproximateAspectRatio(bArr);
        int i3 = (thumbHashToApproximateAspectRatio > 1.0f ? 1 : (thumbHashToApproximateAspectRatio == 1.0f ? 0 : -1));
        float f12 = 32.0f;
        int round = Math.round(i3 > 0 ? 32.0f : thumbHashToApproximateAspectRatio * 32.0f);
        if (i3 > 0) {
            f12 = 32.0f / thumbHashToApproximateAspectRatio;
        }
        int round2 = Math.round(f12);
        byte[] bArr3 = new byte[(round * round2 * 4)];
        int max3 = Math.max(max, z ? 5 : 3);
        int max4 = Math.max(max2, z ? 5 : 3);
        float[] fArr4 = new float[max3];
        float f13 = f4;
        float[] fArr5 = new float[max4];
        float f14 = f5;
        int i4 = 0;
        int i5 = 0;
        while (i4 < round2) {
            float f15 = f9;
            int i6 = 0;
            while (i6 < round) {
                byte[] bArr4 = bArr3;
                int i7 = 0;
                while (i7 < max3) {
                    fArr4[i7] = (float) Math.cos((3.141592653589793d / ((double) round)) * ((double) (((float) i6) + 0.5f)) * ((double) i7));
                    i7++;
                    z = z;
                    ac2 = ac2;
                }
                float[] fArr6 = ac2;
                boolean z3 = z;
                int i8 = 0;
                while (i8 < max4) {
                    fArr5[i8] = (float) Math.cos((3.141592653589793d / ((double) round2)) * ((double) (((float) i4) + 0.5f)) * ((double) i8));
                    i8++;
                    max3 = max3;
                    max4 = max4;
                    i4 = i4;
                }
                int i9 = max3;
                int i10 = i4;
                int i11 = max4;
                ThumbhashDecoder thumbhashDecoder = this;
                float f16 = f11;
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    f = 2.0f;
                    if (i12 >= max2) {
                        break;
                    }
                    float f17 = fArr5[i12] * 2.0f;
                    int i14 = i12 > 0 ? 0 : 1;
                    while (true) {
                        i = max2;
                        if (i14 * max2 >= max * (max2 - i12)) {
                            break;
                        }
                        f16 += ac[i13] * fArr4[i14] * f17;
                        i14++;
                        i13++;
                        max2 = i;
                    }
                    i12++;
                    max2 = i;
                }
                int i15 = max2;
                float f18 = f13;
                float f19 = f14;
                int i16 = 0;
                int i17 = 0;
                while (i16 < 3) {
                    float f20 = fArr5[i16] * f;
                    int i18 = i16 > 0 ? 0 : 1;
                    while (i18 < 3 - i16) {
                        float f21 = fArr4[i18] * f20;
                        f18 += fArr6[i17] * f21;
                        f19 += ac3[i17] * f21;
                        i18++;
                        i17++;
                    }
                    i16++;
                    f = 2.0f;
                }
                if (z3) {
                    f2 = f15;
                    int i19 = 0;
                    int i20 = 0;
                    while (i19 < 5) {
                        float f22 = fArr5[i19] * 2.0f;
                        int i21 = i19 > 0 ? 0 : 1;
                        while (true) {
                            fArr2 = ac;
                            if (i21 >= 5 - i19) {
                                break;
                            }
                            Intrinsics.checkNotNull(fArr3);
                            f2 += fArr3[i20] * fArr4[i21] * f22;
                            i21++;
                            i20++;
                            ac = fArr2;
                        }
                        i19++;
                        ac = fArr2;
                    }
                    fArr = ac;
                } else {
                    fArr = ac;
                    f2 = f15;
                }
                float f23 = f16 - (f18 * 0.6666667f);
                float f24 = (((f16 * 3.0f) - f23) + f19) / 2.0f;
                bArr4[i5] = (byte) Math.max(0, Math.round(Math.min(1.0f, f24) * 255.0f));
                bArr4[i5 + 1] = (byte) Math.max(0, Math.round(Math.min(1.0f, f24 - f19) * 255.0f));
                bArr4[i5 + 2] = (byte) Math.max(0, Math.round(Math.min(1.0f, f23) * 255.0f));
                bArr4[i5 + 3] = (byte) Math.max(0, Math.round(Math.min(1.0f, f2) * 255.0f));
                i6++;
                i5 += 4;
                bArr3 = bArr4;
                max2 = i15;
                z = z3;
                ac2 = fArr6;
                max3 = i9;
                max4 = i11;
                i4 = i10;
                ac = fArr;
            }
            boolean z4 = z;
            int i22 = max2;
            byte[] bArr5 = bArr3;
            int i23 = max3;
            int i24 = max4;
            i4++;
            f9 = f15;
            ac2 = ac2;
            ac = ac;
        }
        return new Image(round, round2, bArr3);
    }

    public final Bitmap thumbHashToBitmap(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "hash");
        Image thumbHashToRGBA = thumbHashToRGBA(bArr);
        int[] iArr = new int[(thumbHashToRGBA.getWidth() * thumbHashToRGBA.getHeight())];
        byte[] rgba = thumbHashToRGBA.getRgba();
        Collection arrayList = new ArrayList(rgba.length);
        int i = 0;
        for (byte r6 : rgba) {
            arrayList.add(Integer.valueOf(UByte.m1001constructorimpl(r6) & 255));
        }
        List list = (List) arrayList;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, list.size() - 1, 4);
        if (progressionLastElement >= 0) {
            while (true) {
                iArr[i / 4] = Color.argb(((Number) list.get(i + 3)).intValue(), ((Number) list.get(i)).intValue(), ((Number) list.get(i + 1)).intValue(), ((Number) list.get(i + 2)).intValue());
                if (i == progressionLastElement) {
                    break;
                }
                i += 4;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, thumbHashToRGBA.getWidth(), thumbHashToRGBA.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(imageArray,… Bitmap.Config.ARGB_8888)");
        return createBitmap;
    }

    public final RGBA thumbHashToAverageRGBA(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "hash");
        boolean z = false;
        byte b = (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << Ascii.DLE);
        float f = ((float) (b & Utf8.REPLACEMENT_BYTE)) / 63.0f;
        float f2 = (((float) ((b >> 6) & 63)) / 31.5f) - 1.0f;
        float f3 = (((float) ((b >> Ascii.FF) & 63)) / 31.5f) - 1.0f;
        if ((b >> Ascii.ETB) != 0) {
            z = true;
        }
        float f4 = z ? ((float) (bArr[5] & Ascii.SI)) / 15.0f : 1.0f;
        float f5 = f - (f2 * 0.6666667f);
        float f6 = (((f * 3.0f) - f5) + f3) / 2.0f;
        return new RGBA(Math.max(0.0f, Math.min(1.0f, f6)), Math.max(0.0f, Math.min(1.0f, f6 - f3)), Math.max(0.0f, Math.min(1.0f, f5)), f4);
    }

    public final float thumbHashToApproximateAspectRatio(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "hash");
        byte b = bArr[3];
        boolean z = true;
        boolean z2 = (bArr[2] & 128) != 0;
        if ((bArr[4] & 128) == 0) {
            z = false;
        }
        byte b2 = 5;
        byte b3 = z ? z2 ? (byte) 5 : 7 : b & 7;
        if (z) {
            b2 = b & 7;
        } else if (!z2) {
            b2 = 7;
        }
        return ((float) b3) / ((float) b2);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashDecoder$Image;", "", "width", "", "height", "rgba", "", "(II[B)V", "getHeight", "()I", "setHeight", "(I)V", "getRgba", "()[B", "setRgba", "([B)V", "getWidth", "setWidth", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ThumbhashDecoder.kt */
    public static final class Image {
        private int height;
        private byte[] rgba;
        private int width;

        public Image(int i, int i2, byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "rgba");
            this.width = i;
            this.height = i2;
            this.rgba = bArr;
        }

        public final int getHeight() {
            return this.height;
        }

        public final byte[] getRgba() {
            return this.rgba;
        }

        public final int getWidth() {
            return this.width;
        }

        public final void setHeight(int i) {
            this.height = i;
        }

        public final void setRgba(byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "<set-?>");
            this.rgba = bArr;
        }

        public final void setWidth(int i) {
            this.width = i;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashDecoder$RGBA;", "", "r", "", "g", "b", "a", "(FFFF)V", "getA", "()F", "setA", "(F)V", "getB", "setB", "getG", "setG", "getR", "setR", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ThumbhashDecoder.kt */
    public static final class RGBA {
        private float a;
        private float b;
        private float g;
        private float r;

        public RGBA(float f, float f2, float f3, float f4) {
            this.r = f;
            this.g = f2;
            this.b = f3;
            this.a = f4;
        }

        public final float getA() {
            return this.a;
        }

        public final float getB() {
            return this.b;
        }

        public final float getG() {
            return this.g;
        }

        public final float getR() {
            return this.r;
        }

        public final void setA(float f) {
            this.a = f;
        }

        public final void setB(float f) {
            this.b = f;
        }

        public final void setG(float f) {
            this.g = f;
        }

        public final void setR(float f) {
            this.r = f;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u0012\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J&\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\rJ\u001e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0007J\u001e\u0010$\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011¨\u0006%"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashDecoder$Channel;", "", "nx", "", "ny", "(II)V", "ac", "", "getAc", "()[F", "setAc", "([F)V", "dc", "", "getDc", "()F", "setDc", "(F)V", "getNx", "()I", "setNx", "(I)V", "getNy", "setNy", "scale", "getScale", "setScale", "decode", "hash", "", "start", "index", "encode", "w", "h", "channel", "writeTo", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ThumbhashDecoder.kt */
    private static final class Channel {
        private float[] ac;
        private float dc;
        private int nx;
        private int ny;
        private float scale;

        public Channel(int i, int i2) {
            this.nx = i;
            this.ny = i2;
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i3 > 0 ? 0 : 1;
                while (true) {
                    int i6 = this.ny;
                    if (i5 * i6 >= this.nx * (i6 - i3)) {
                        break;
                    }
                    i4++;
                    i5++;
                }
                i3++;
            }
            this.ac = new float[i4];
        }

        public final int getNx() {
            return this.nx;
        }

        public final int getNy() {
            return this.ny;
        }

        public final void setNx(int i) {
            this.nx = i;
        }

        public final void setNy(int i) {
            this.ny = i;
        }

        public final float getDc() {
            return this.dc;
        }

        public final void setDc(float f) {
            this.dc = f;
        }

        public final float[] getAc() {
            return this.ac;
        }

        public final void setAc(float[] fArr) {
            Intrinsics.checkNotNullParameter(fArr, "<set-?>");
            this.ac = fArr;
        }

        public final float getScale() {
            return this.scale;
        }

        public final void setScale(float f) {
            this.scale = f;
        }

        public final Channel encode(int i, int i2, float[] fArr) {
            double d;
            int i3 = i;
            int i4 = i2;
            float[] fArr2 = fArr;
            Intrinsics.checkNotNullParameter(fArr2, "channel");
            float[] fArr3 = new float[i3];
            int i5 = this.ny;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                float f = 0.5f;
                if (i6 >= i5) {
                    break;
                }
                int i8 = 0;
                while (true) {
                    int i9 = this.ny;
                    if (i8 * i9 >= this.nx * (i9 - i6)) {
                        break;
                    }
                    int i10 = 0;
                    while (true) {
                        d = 3.141592653589793d;
                        if (i10 >= i3) {
                            break;
                        }
                        fArr3[i10] = (float) Math.cos((3.141592653589793d / ((double) i3)) * ((double) i8) * ((double) (((float) i10) + f)));
                        i10++;
                        i6 = i6;
                    }
                    int i11 = i6;
                    int i12 = 0;
                    float f2 = 0.0f;
                    while (i12 < i4) {
                        int i13 = i11;
                        float cos = (float) Math.cos((d / ((double) i4)) * ((double) i13) * ((double) (((float) i12) + 0.5f)));
                        for (int i14 = 0; i14 < i3; i14++) {
                            f2 += fArr2[(i12 * i3) + i14] * fArr3[i14] * cos;
                        }
                        i12++;
                        i11 = i13;
                        d = 3.141592653589793d;
                    }
                    int i15 = i11;
                    float f3 = f2 / ((float) (i3 * i4));
                    if (i8 > 0 || i15 > 0) {
                        this.ac[i7] = f3;
                        this.scale = Math.max(this.scale, Math.abs(f3));
                        i7++;
                    } else {
                        this.dc = f3;
                    }
                    i8++;
                    i6 = i15;
                    f = 0.5f;
                }
                i6++;
            }
            if (this.scale > 0.0f) {
                int length = this.ac.length;
                for (int i16 = 0; i16 < length; i16++) {
                    float[] fArr4 = this.ac;
                    fArr4[i16] = ((0.5f / this.scale) * fArr4[i16]) + 0.5f;
                }
            }
            return this;
        }

        public final int decode(byte[] bArr, int i, int i2, float f) {
            Intrinsics.checkNotNullParameter(bArr, "hash");
            int length = this.ac.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.ac[i3] = ((((float) ((bArr[(i2 >> 1) + i] >> ((i2 & 1) << 2)) & 15)) / 7.5f) - 1.0f) * f;
                i2++;
            }
            return i2;
        }

        public final int writeTo(byte[] bArr, int i, int i2) {
            Intrinsics.checkNotNullParameter(bArr, "hash");
            for (float f : this.ac) {
                int i3 = (i2 >> 1) + i;
                bArr[i3] = (byte) ((Math.round(f * 15.0f) << ((i2 & 1) << 2)) | bArr[i3]);
                i2++;
            }
            return i2;
        }
    }
}
