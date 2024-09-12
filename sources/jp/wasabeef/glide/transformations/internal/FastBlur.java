package jp.wasabeef.glide.transformations.internal;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Array;

public class FastBlur {
    public static Bitmap blur(Bitmap bitmap, int i, boolean z) {
        Bitmap bitmap2;
        int[] iArr;
        int i2 = i;
        if (z) {
            bitmap2 = bitmap;
        } else {
            bitmap2 = bitmap.copy(bitmap.getConfig(), true);
        }
        if (i2 < 1) {
            return null;
        }
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int i3 = width * height;
        int[] iArr2 = new int[i3];
        bitmap2.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i5 = height - 1;
        int i6 = i2 + i2 + 1;
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[i3];
        int[] iArr6 = new int[Math.max(width, height)];
        int i7 = (i6 + 1) >> 1;
        int i8 = i7 * i7;
        int i9 = i8 * 256;
        int[] iArr7 = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            iArr7[i10] = i10 / i8;
        }
        int[] iArr8 = new int[2];
        iArr8[1] = 3;
        iArr8[0] = i6;
        int[][] iArr9 = (int[][]) Array.newInstance(Integer.TYPE, iArr8);
        int i11 = i2 + 1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < height) {
            Bitmap bitmap3 = bitmap2;
            int i15 = height;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = -i2;
            int i25 = 0;
            while (i24 <= i2) {
                int i26 = i5;
                int[] iArr10 = iArr6;
                int i27 = iArr2[i13 + Math.min(i4, Math.max(i24, 0))];
                int[] iArr11 = iArr9[i24 + i2];
                iArr11[0] = (i27 & 16711680) >> 16;
                iArr11[1] = (i27 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr11[2] = i27 & 255;
                int abs = i11 - Math.abs(i24);
                int i28 = iArr11[0];
                i25 += i28 * abs;
                int i29 = iArr11[1];
                i16 += i29 * abs;
                int i30 = iArr11[2];
                i17 += abs * i30;
                if (i24 > 0) {
                    i21 += i28;
                    i22 += i29;
                    i23 += i30;
                } else {
                    i18 += i28;
                    i19 += i29;
                    i20 += i30;
                }
                i24++;
                i5 = i26;
                iArr6 = iArr10;
            }
            int i31 = i5;
            int[] iArr12 = iArr6;
            int i32 = i2;
            int i33 = i25;
            int i34 = 0;
            while (i34 < width) {
                iArr3[i13] = iArr7[i33];
                iArr4[i13] = iArr7[i16];
                iArr5[i13] = iArr7[i17];
                int i35 = i33 - i18;
                int i36 = i16 - i19;
                int i37 = i17 - i20;
                int[] iArr13 = iArr9[((i32 - i2) + i6) % i6];
                int i38 = i18 - iArr13[0];
                int i39 = i19 - iArr13[1];
                int i40 = i20 - iArr13[2];
                if (i12 == 0) {
                    iArr = iArr7;
                    iArr12[i34] = Math.min(i34 + i2 + 1, i4);
                } else {
                    iArr = iArr7;
                }
                int i41 = iArr2[i14 + iArr12[i34]];
                int i42 = (i41 & 16711680) >> 16;
                iArr13[0] = i42;
                int i43 = (i41 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr13[1] = i43;
                int i44 = i41 & 255;
                iArr13[2] = i44;
                int i45 = i21 + i42;
                int i46 = i22 + i43;
                int i47 = i23 + i44;
                i33 = i35 + i45;
                i16 = i36 + i46;
                i17 = i37 + i47;
                i32 = (i32 + 1) % i6;
                int[] iArr14 = iArr9[i32 % i6];
                int i48 = iArr14[0];
                i18 = i38 + i48;
                int i49 = iArr14[1];
                i19 = i39 + i49;
                int i50 = iArr14[2];
                i20 = i40 + i50;
                i21 = i45 - i48;
                i22 = i46 - i49;
                i23 = i47 - i50;
                i13++;
                i34++;
                iArr7 = iArr;
            }
            int[] iArr15 = iArr7;
            i14 += width;
            i12++;
            bitmap2 = bitmap3;
            height = i15;
            i5 = i31;
            iArr6 = iArr12;
        }
        Bitmap bitmap4 = bitmap2;
        int i51 = i5;
        int[] iArr16 = iArr6;
        int i52 = height;
        int[] iArr17 = iArr7;
        int i53 = 0;
        while (i53 < width) {
            int i54 = -i2;
            int i55 = i6;
            int[] iArr18 = iArr2;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = i54;
            int i64 = i54 * width;
            int i65 = 0;
            int i66 = 0;
            while (i63 <= i2) {
                int i67 = width;
                int max = Math.max(0, i64) + i53;
                int[] iArr19 = iArr9[i63 + i2];
                iArr19[0] = iArr3[max];
                iArr19[1] = iArr4[max];
                iArr19[2] = iArr5[max];
                int abs2 = i11 - Math.abs(i63);
                i65 += iArr3[max] * abs2;
                i66 += iArr4[max] * abs2;
                i56 += iArr5[max] * abs2;
                if (i63 > 0) {
                    i60 += iArr19[0];
                    i61 += iArr19[1];
                    i62 += iArr19[2];
                } else {
                    i57 += iArr19[0];
                    i58 += iArr19[1];
                    i59 += iArr19[2];
                }
                int i68 = i51;
                if (i63 < i68) {
                    i64 += i67;
                }
                i63++;
                i51 = i68;
                width = i67;
            }
            int i69 = width;
            int i70 = i51;
            int i71 = i2;
            int i72 = i53;
            int i73 = i66;
            int i74 = i52;
            int i75 = i65;
            int i76 = 0;
            while (i76 < i74) {
                iArr18[i72] = (iArr18[i72] & ViewCompat.MEASURED_STATE_MASK) | (iArr17[i75] << 16) | (iArr17[i73] << 8) | iArr17[i56];
                int i77 = i75 - i57;
                int i78 = i73 - i58;
                int i79 = i56 - i59;
                int[] iArr20 = iArr9[((i71 - i2) + i55) % i55];
                int i80 = i57 - iArr20[0];
                int i81 = i58 - iArr20[1];
                int i82 = i59 - iArr20[2];
                if (i53 == 0) {
                    iArr16[i76] = Math.min(i76 + i11, i70) * i69;
                }
                int i83 = iArr16[i76] + i53;
                int i84 = iArr3[i83];
                iArr20[0] = i84;
                int i85 = iArr4[i83];
                iArr20[1] = i85;
                int i86 = iArr5[i83];
                iArr20[2] = i86;
                int i87 = i60 + i84;
                int i88 = i61 + i85;
                int i89 = i62 + i86;
                i75 = i77 + i87;
                i73 = i78 + i88;
                i56 = i79 + i89;
                i71 = (i71 + 1) % i55;
                int[] iArr21 = iArr9[i71];
                int i90 = iArr21[0];
                i57 = i80 + i90;
                int i91 = iArr21[1];
                i58 = i81 + i91;
                int i92 = iArr21[2];
                i59 = i82 + i92;
                i60 = i87 - i90;
                i61 = i88 - i91;
                i62 = i89 - i92;
                i72 += i69;
                i76++;
                i2 = i;
            }
            i53++;
            i2 = i;
            i51 = i70;
            i52 = i74;
            i6 = i55;
            iArr2 = iArr18;
            width = i69;
        }
        int i93 = width;
        bitmap4.setPixels(iArr2, 0, i93, 0, 0, i93, i52);
        return bitmap4;
    }
}
