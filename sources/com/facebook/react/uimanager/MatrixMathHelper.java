package com.facebook.react.uimanager;

import com.facebook.infer.annotation.Assertions;
import java.lang.reflect.Array;

public class MatrixMathHelper {
    private static final double EPSILON = 1.0E-5d;

    public static double degreesToRadians(double d) {
        return (d * 3.141592653589793d) / 180.0d;
    }

    public static class MatrixDecompositionContext {
        double[] perspective = new double[4];
        double[] rotationDegrees = new double[3];
        double[] scale = new double[3];
        double[] skew = new double[3];
        double[] translation = new double[3];

        private static void resetArray(double[] dArr) {
            for (int i = 0; i < dArr.length; i++) {
                dArr[i] = 0.0d;
            }
        }

        public void reset() {
            resetArray(this.perspective);
            resetArray(this.scale);
            resetArray(this.skew);
            resetArray(this.translation);
            resetArray(this.rotationDegrees);
        }
    }

    private static boolean isZero(double d) {
        if (!Double.isNaN(d) && Math.abs(d) < 1.0E-5d) {
            return true;
        }
        return false;
    }

    public static void multiplyInto(double[] dArr, double[] dArr2, double[] dArr3) {
        double d = dArr2[0];
        double d2 = dArr2[1];
        double d3 = dArr2[2];
        double d4 = dArr2[3];
        double d5 = dArr2[4];
        double d6 = dArr2[5];
        double d7 = dArr2[6];
        double d8 = dArr2[7];
        double d9 = dArr2[8];
        double d10 = dArr2[9];
        double d11 = dArr2[10];
        double d12 = dArr2[11];
        double d13 = dArr2[12];
        double d14 = dArr2[13];
        double d15 = dArr2[14];
        double d16 = dArr2[15];
        double d17 = dArr3[0];
        double d18 = dArr3[1];
        double d19 = dArr3[2];
        double d20 = dArr3[3];
        dArr[0] = (d17 * d) + (d18 * d5) + (d19 * d9) + (d20 * d13);
        dArr[1] = (d17 * d2) + (d18 * d6) + (d19 * d10) + (d20 * d14);
        dArr[2] = (d17 * d3) + (d18 * d7) + (d19 * d11) + (d20 * d15);
        dArr[3] = (d17 * d4) + (d18 * d8) + (d19 * d12) + (d20 * d16);
        double d21 = dArr3[4];
        double d22 = dArr3[5];
        double d23 = dArr3[6];
        double d24 = dArr3[7];
        dArr[4] = (d21 * d) + (d22 * d5) + (d23 * d9) + (d24 * d13);
        dArr[5] = (d21 * d2) + (d22 * d6) + (d23 * d10) + (d24 * d14);
        dArr[6] = (d21 * d3) + (d22 * d7) + (d23 * d11) + (d24 * d15);
        dArr[7] = (d21 * d4) + (d22 * d8) + (d23 * d12) + (d24 * d16);
        double d25 = dArr3[8];
        double d26 = dArr3[9];
        double d27 = dArr3[10];
        double d28 = dArr3[11];
        dArr[8] = (d25 * d) + (d26 * d5) + (d27 * d9) + (d28 * d13);
        dArr[9] = (d25 * d2) + (d26 * d6) + (d27 * d10) + (d28 * d14);
        dArr[10] = (d25 * d3) + (d26 * d7) + (d27 * d11) + (d28 * d15);
        dArr[11] = (d25 * d4) + (d26 * d8) + (d27 * d12) + (d28 * d16);
        double d29 = dArr3[12];
        double d30 = dArr3[13];
        double d31 = dArr3[14];
        double d32 = dArr3[15];
        dArr[12] = (d * d29) + (d5 * d30) + (d9 * d31) + (d13 * d32);
        dArr[13] = (d2 * d29) + (d6 * d30) + (d10 * d31) + (d14 * d32);
        dArr[14] = (d3 * d29) + (d7 * d30) + (d11 * d31) + (d15 * d32);
        dArr[15] = (d29 * d4) + (d30 * d8) + (d31 * d12) + (d32 * d16);
    }

    public static void decomposeMatrix(double[] dArr, MatrixDecompositionContext matrixDecompositionContext) {
        double[] dArr2 = dArr;
        MatrixDecompositionContext matrixDecompositionContext2 = matrixDecompositionContext;
        Assertions.assertCondition(dArr2.length == 16);
        double[] dArr3 = matrixDecompositionContext2.perspective;
        double[] dArr4 = matrixDecompositionContext2.scale;
        double[] dArr5 = matrixDecompositionContext2.skew;
        double[] dArr6 = matrixDecompositionContext2.translation;
        double[] dArr7 = matrixDecompositionContext2.rotationDegrees;
        if (!isZero(dArr2[15])) {
            double[][] dArr8 = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
            double[] dArr9 = new double[16];
            for (int i = 0; i < 4; i++) {
                for (int i2 = 0; i2 < 4; i2++) {
                    int i3 = (i * 4) + i2;
                    double d = dArr2[i3] / dArr2[15];
                    dArr8[i][i2] = d;
                    if (i2 == 3) {
                        d = 0.0d;
                    }
                    dArr9[i3] = d;
                }
            }
            dArr9[15] = 1.0d;
            if (!isZero(determinant(dArr9))) {
                if (!isZero(dArr8[0][3]) || !isZero(dArr8[1][3]) || !isZero(dArr8[2][3])) {
                    multiplyVectorByMatrix(new double[]{dArr8[0][3], dArr8[1][3], dArr8[2][3], dArr8[3][3]}, transpose(inverse(dArr9)), dArr3);
                } else {
                    dArr3[2] = 0.0d;
                    dArr3[1] = 0.0d;
                    dArr3[0] = 0.0d;
                    dArr3[3] = 1.0d;
                }
                for (int i4 = 0; i4 < 3; i4++) {
                    dArr6[i4] = dArr8[3][i4];
                }
                double[][] dArr10 = (double[][]) Array.newInstance(Double.TYPE, new int[]{3, 3});
                for (int i5 = 0; i5 < 3; i5++) {
                    double[] dArr11 = dArr10[i5];
                    double[] dArr12 = dArr8[i5];
                    dArr11[0] = dArr12[0];
                    dArr11[1] = dArr12[1];
                    dArr11[2] = dArr12[2];
                }
                double v3Length = v3Length(dArr10[0]);
                dArr4[0] = v3Length;
                double[] v3Normalize = v3Normalize(dArr10[0], v3Length);
                dArr10[0] = v3Normalize;
                double v3Dot = v3Dot(v3Normalize, dArr10[1]);
                dArr5[0] = v3Dot;
                double[] v3Combine = v3Combine(dArr10[1], dArr10[0], 1.0d, -v3Dot);
                dArr10[1] = v3Combine;
                double v3Length2 = v3Length(v3Combine);
                dArr4[1] = v3Length2;
                dArr10[1] = v3Normalize(dArr10[1], v3Length2);
                dArr5[0] = dArr5[0] / dArr4[1];
                double v3Dot2 = v3Dot(dArr10[0], dArr10[2]);
                dArr5[1] = v3Dot2;
                double[] v3Combine2 = v3Combine(dArr10[2], dArr10[0], 1.0d, -v3Dot2);
                dArr10[2] = v3Combine2;
                double v3Dot3 = v3Dot(dArr10[1], v3Combine2);
                dArr5[2] = v3Dot3;
                double[] v3Combine3 = v3Combine(dArr10[2], dArr10[1], 1.0d, -v3Dot3);
                dArr10[2] = v3Combine3;
                double v3Length3 = v3Length(v3Combine3);
                dArr4[2] = v3Length3;
                double[] v3Normalize2 = v3Normalize(dArr10[2], v3Length3);
                dArr10[2] = v3Normalize2;
                double d2 = dArr5[1];
                double d3 = dArr4[2];
                dArr5[1] = d2 / d3;
                dArr5[2] = dArr5[2] / d3;
                if (v3Dot(dArr10[0], v3Cross(dArr10[1], v3Normalize2)) < 0.0d) {
                    for (int i6 = 0; i6 < 3; i6++) {
                        dArr4[i6] = dArr4[i6] * -1.0d;
                        double[] dArr13 = dArr10[i6];
                        dArr13[0] = dArr13[0] * -1.0d;
                        dArr13[1] = dArr13[1] * -1.0d;
                        dArr13[2] = dArr13[2] * -1.0d;
                    }
                }
                double[] dArr14 = dArr10[2];
                dArr7[0] = roundTo3Places((-Math.atan2(dArr14[1], dArr14[2])) * 57.29577951308232d);
                double[] dArr15 = dArr10[2];
                double d4 = dArr15[1];
                double d5 = dArr15[2];
                dArr7[1] = roundTo3Places((-Math.atan2(-dArr15[0], Math.sqrt((d4 * d4) + (d5 * d5)))) * 57.29577951308232d);
                dArr7[2] = roundTo3Places((-Math.atan2(dArr10[1][0], dArr10[0][0])) * 57.29577951308232d);
            }
        }
    }

    public static double determinant(double[] dArr) {
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        double d5 = dArr[4];
        double d6 = dArr[5];
        double d7 = dArr[6];
        double d8 = dArr[7];
        double d9 = dArr[8];
        double d10 = dArr[9];
        double d11 = dArr[10];
        double d12 = dArr[11];
        double d13 = dArr[12];
        double d14 = dArr[13];
        double d15 = dArr[14];
        double d16 = dArr[15];
        double d17 = d4 * d7;
        double d18 = d3 * d8;
        double d19 = d4 * d6;
        double d20 = d2 * d8;
        double d21 = d3 * d6;
        double d22 = d2 * d7;
        double d23 = d4 * d5;
        double d24 = d8 * d;
        double d25 = d3 * d5;
        double d26 = d7 * d;
        double d27 = d2 * d5;
        double d28 = d * d6;
        return ((((((((((((((((((((((((d17 * d10) * d13) - ((d18 * d10) * d13)) - ((d19 * d11) * d13)) + ((d20 * d11) * d13)) + ((d21 * d12) * d13)) - ((d22 * d12) * d13)) - ((d17 * d9) * d14)) + ((d18 * d9) * d14)) + ((d23 * d11) * d14)) - ((d24 * d11) * d14)) - ((d25 * d12) * d14)) + ((d26 * d12) * d14)) + ((d19 * d9) * d15)) - ((d20 * d9) * d15)) - ((d23 * d10) * d15)) + ((d24 * d10) * d15)) + ((d27 * d12) * d15)) - ((d12 * d28) * d15)) - ((d21 * d9) * d16)) + ((d22 * d9) * d16)) + ((d25 * d10) * d16)) - ((d26 * d10) * d16)) - ((d27 * d11) * d16)) + (d28 * d11 * d16);
    }

    public static double[] inverse(double[] dArr) {
        double determinant = determinant(dArr);
        if (isZero(determinant)) {
            return dArr;
        }
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        double d5 = dArr[4];
        double d6 = dArr[5];
        double d7 = dArr[6];
        double d8 = dArr[7];
        double d9 = dArr[8];
        double d10 = dArr[9];
        double d11 = dArr[10];
        double d12 = dArr[11];
        double d13 = dArr[12];
        double d14 = dArr[13];
        double d15 = dArr[14];
        double d16 = dArr[15];
        double d17 = d7 * d12;
        double d18 = d8 * d11;
        double d19 = d8 * d10;
        double d20 = d6 * d12;
        double d21 = d7 * d10;
        double d22 = ((((d17 * d14) - (d18 * d14)) + (d19 * d15)) - (d20 * d15)) - (d21 * d16);
        double d23 = d6 * d11;
        double d24 = d4 * d11;
        double d25 = d3 * d12;
        double d26 = d4 * d10;
        double d27 = d2 * d12;
        double d28 = d3 * d10;
        double d29 = (((d24 * d14) - (d25 * d14)) - (d26 * d15)) + (d27 * d15) + (d28 * d16);
        double d30 = d2 * d11;
        double d31 = d3 * d8;
        double d32 = d4 * d7;
        double d33 = d4 * d6;
        double d34 = d2 * d8;
        double d35 = d3 * d6;
        double d36 = ((((d31 * d14) - (d32 * d14)) + (d33 * d15)) - (d34 * d15)) - (d35 * d16);
        double d37 = d2 * d7;
        double d38 = (d18 * d13) - (d17 * d13);
        double d39 = d8 * d9;
        double d40 = d5 * d12;
        double d41 = d7 * d9;
        double d42 = (d38 - (d39 * d15)) + (d40 * d15) + (d41 * d16);
        double d43 = d5 * d11;
        double d44 = (d25 * d13) - (d24 * d13);
        double d45 = d4 * d9;
        double d46 = d * d12;
        double d47 = d3 * d9;
        double d48 = d * d11;
        double d49 = d4 * d5;
        double d50 = d8 * d;
        double d51 = d3 * d5;
        double d52 = d7 * d;
        double d53 = d6 * d9;
        double d54 = ((((d20 * d13) - (d19 * d13)) + (d39 * d14)) - (d40 * d14)) - (d53 * d16);
        double d55 = d5 * d10;
        double d56 = d2 * d9;
        double d57 = d * d10;
        double d58 = d2 * d5;
        double d59 = d * d6;
        return new double[]{(d22 + (d23 * d16)) / determinant, (d29 - (d30 * d16)) / determinant, (d36 + (d37 * d16)) / determinant, ((((((d32 * d10) - (d31 * d10)) - (d33 * d11)) + (d34 * d11)) + (d35 * d12)) - (d37 * d12)) / determinant, (d42 - (d43 * d16)) / determinant, ((((d44 + (d45 * d15)) - (d46 * d15)) - (d47 * d16)) + (d48 * d16)) / determinant, ((((((d32 * d13) - (d31 * d13)) - (d49 * d15)) + (d50 * d15)) + (d51 * d16)) - (d52 * d16)) / determinant, ((((((d31 * d9) - (d32 * d9)) + (d49 * d11)) - (d50 * d11)) - (d51 * d12)) + (d52 * d12)) / determinant, (d54 + (d55 * d16)) / determinant, ((((((d26 * d13) - (d27 * d13)) - (d45 * d14)) + (d46 * d14)) + (d56 * d16)) - (d57 * d16)) / determinant, ((((((d34 * d13) - (d33 * d13)) + (d49 * d14)) - (d50 * d14)) - (d58 * d16)) + (d16 * d59)) / determinant, ((((((d33 * d9) - (d34 * d9)) - (d49 * d10)) + (d50 * d10)) + (d58 * d12)) - (d12 * d59)) / determinant, ((((((d21 * d13) - (d23 * d13)) - (d41 * d14)) + (d43 * d14)) + (d53 * d15)) - (d55 * d15)) / determinant, ((((((d30 * d13) - (d28 * d13)) + (d47 * d14)) - (d48 * d14)) - (d56 * d15)) + (d57 * d15)) / determinant, ((((((d35 * d13) - (d13 * d37)) - (d51 * d14)) + (d14 * d52)) + (d58 * d15)) - (d15 * d59)) / determinant, ((((((d37 * d9) - (d35 * d9)) + (d51 * d10)) - (d52 * d10)) - (d58 * d11)) + (d59 * d11)) / determinant};
    }

    public static double[] transpose(double[] dArr) {
        return new double[]{dArr[0], dArr[4], dArr[8], dArr[12], dArr[1], dArr[5], dArr[9], dArr[13], dArr[2], dArr[6], dArr[10], dArr[14], dArr[3], dArr[7], dArr[11], dArr[15]};
    }

    public static void multiplyVectorByMatrix(double[] dArr, double[] dArr2, double[] dArr3) {
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        dArr3[0] = (dArr2[0] * d) + (dArr2[4] * d2) + (dArr2[8] * d3) + (dArr2[12] * d4);
        dArr3[1] = (dArr2[1] * d) + (dArr2[5] * d2) + (dArr2[9] * d3) + (dArr2[13] * d4);
        dArr3[2] = (dArr2[2] * d) + (dArr2[6] * d2) + (dArr2[10] * d3) + (dArr2[14] * d4);
        dArr3[3] = (d * dArr2[3]) + (d2 * dArr2[7]) + (d3 * dArr2[11]) + (d4 * dArr2[15]);
    }

    public static double v3Length(double[] dArr) {
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = (d * d) + (d2 * d2);
        double d4 = dArr[2];
        return Math.sqrt(d3 + (d4 * d4));
    }

    public static double[] v3Normalize(double[] dArr, double d) {
        if (isZero(d)) {
            d = v3Length(dArr);
        }
        double d2 = 1.0d / d;
        return new double[]{dArr[0] * d2, dArr[1] * d2, dArr[2] * d2};
    }

    public static double v3Dot(double[] dArr, double[] dArr2) {
        return (dArr[0] * dArr2[0]) + (dArr[1] * dArr2[1]) + (dArr[2] * dArr2[2]);
    }

    public static double[] v3Combine(double[] dArr, double[] dArr2, double d, double d2) {
        return new double[]{(dArr[0] * d) + (dArr2[0] * d2), (dArr[1] * d) + (dArr2[1] * d2), (d * dArr[2]) + (d2 * dArr2[2])};
    }

    public static double[] v3Cross(double[] dArr, double[] dArr2) {
        double d = dArr[1];
        double d2 = dArr2[2];
        double d3 = dArr[2];
        double d4 = dArr2[0];
        double d5 = dArr[0];
        return new double[]{(d * d2) - (dArr2[1] * d3), (d3 * d4) - (d2 * d5), (d5 * dArr2[1]) - (dArr[1] * d4)};
    }

    public static double roundTo3Places(double d) {
        return ((double) Math.round(d * 1000.0d)) * 0.001d;
    }

    public static double[] createIdentityMatrix() {
        double[] dArr = new double[16];
        resetIdentityMatrix(dArr);
        return dArr;
    }

    public static void resetIdentityMatrix(double[] dArr) {
        dArr[14] = 0.0d;
        dArr[13] = 0.0d;
        dArr[12] = 0.0d;
        dArr[11] = 0.0d;
        dArr[9] = 0.0d;
        dArr[8] = 0.0d;
        dArr[7] = 0.0d;
        dArr[6] = 0.0d;
        dArr[4] = 0.0d;
        dArr[3] = 0.0d;
        dArr[2] = 0.0d;
        dArr[1] = 0.0d;
        dArr[15] = 1.0d;
        dArr[10] = 1.0d;
        dArr[5] = 1.0d;
        dArr[0] = 1.0d;
    }

    public static void applyPerspective(double[] dArr, double d) {
        dArr[11] = -1.0d / d;
    }

    public static void applyScaleX(double[] dArr, double d) {
        dArr[0] = d;
    }

    public static void applyScaleY(double[] dArr, double d) {
        dArr[5] = d;
    }

    public static void applyScaleZ(double[] dArr, double d) {
        dArr[10] = d;
    }

    public static void applyTranslate2D(double[] dArr, double d, double d2) {
        dArr[12] = d;
        dArr[13] = d2;
    }

    public static void applyTranslate3D(double[] dArr, double d, double d2, double d3) {
        dArr[12] = d;
        dArr[13] = d2;
        dArr[14] = d3;
    }

    public static void applySkewX(double[] dArr, double d) {
        dArr[4] = Math.tan(d);
    }

    public static void applySkewY(double[] dArr, double d) {
        dArr[1] = Math.tan(d);
    }

    public static void applyRotateX(double[] dArr, double d) {
        dArr[5] = Math.cos(d);
        dArr[6] = Math.sin(d);
        dArr[9] = -Math.sin(d);
        dArr[10] = Math.cos(d);
    }

    public static void applyRotateY(double[] dArr, double d) {
        dArr[0] = Math.cos(d);
        dArr[2] = -Math.sin(d);
        dArr[8] = Math.sin(d);
        dArr[10] = Math.cos(d);
    }

    public static void applyRotateZ(double[] dArr, double d) {
        dArr[0] = Math.cos(d);
        dArr[1] = Math.sin(d);
        dArr[4] = -Math.sin(d);
        dArr[5] = Math.cos(d);
    }
}
