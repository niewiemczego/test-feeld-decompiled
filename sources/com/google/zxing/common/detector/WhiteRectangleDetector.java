package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 10;
    private final int downInit;
    private final int height;
    private final BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;

    public WhiteRectangleDetector(BitMatrix bitMatrix) throws NotFoundException {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i, int i2, int i3) throws NotFoundException {
        this.image = bitMatrix;
        int height2 = bitMatrix.getHeight();
        this.height = height2;
        int width2 = bitMatrix.getWidth();
        this.width = width2;
        int i4 = i / 2;
        int i5 = i2 - i4;
        this.leftInit = i5;
        int i6 = i2 + i4;
        this.rightInit = i6;
        int i7 = i3 - i4;
        this.upInit = i7;
        int i8 = i3 + i4;
        this.downInit = i8;
        if (i7 < 0 || i5 < 0 || i8 >= height2 || i6 >= width2) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public ResultPoint[] detect() throws NotFoundException {
        int i = this.leftInit;
        int i2 = this.rightInit;
        int i3 = this.upInit;
        int i4 = this.downInit;
        boolean z = false;
        int i5 = 1;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = true;
        while (true) {
            if (!z7) {
                break;
            }
            boolean z8 = false;
            boolean z9 = true;
            while (true) {
                if ((z9 || !z2) && i2 < this.width) {
                    z9 = containsBlackPoint(i3, i4, i2, false);
                    if (z9) {
                        i2++;
                        z2 = true;
                        z8 = true;
                    } else if (!z2) {
                        i2++;
                    }
                }
            }
            if (i2 >= this.width) {
                break;
            }
            boolean z10 = true;
            while (true) {
                if ((z10 || !z3) && i4 < this.height) {
                    z10 = containsBlackPoint(i, i2, i4, true);
                    if (z10) {
                        i4++;
                        z3 = true;
                        z8 = true;
                    } else if (!z3) {
                        i4++;
                    }
                }
            }
            if (i4 >= this.height) {
                break;
            }
            boolean z11 = true;
            while (true) {
                if ((z11 || !z4) && i >= 0) {
                    z11 = containsBlackPoint(i3, i4, i, false);
                    if (z11) {
                        i--;
                        z4 = true;
                        z8 = true;
                    } else if (!z4) {
                        i--;
                    }
                }
            }
            if (i < 0) {
                break;
            }
            z7 = z8;
            boolean z12 = true;
            while (true) {
                if ((z12 || !z6) && i3 >= 0) {
                    z12 = containsBlackPoint(i, i2, i3, true);
                    if (z12) {
                        i3--;
                        z7 = true;
                        z6 = true;
                    } else if (!z6) {
                        i3--;
                    }
                }
            }
            if (i3 < 0) {
                break;
            } else if (z7) {
                z5 = true;
            }
        }
        z = true;
        if (z || !z5) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i6 = i2 - i;
        ResultPoint resultPoint = null;
        int i7 = 1;
        ResultPoint resultPoint2 = null;
        while (resultPoint2 == null && i7 < i6) {
            resultPoint2 = getBlackPointOnSegment((float) i, (float) (i4 - i7), (float) (i + i7), (float) i4);
            i7++;
        }
        if (resultPoint2 != null) {
            int i8 = 1;
            ResultPoint resultPoint3 = null;
            while (resultPoint3 == null && i8 < i6) {
                resultPoint3 = getBlackPointOnSegment((float) i, (float) (i3 + i8), (float) (i + i8), (float) i3);
                i8++;
            }
            if (resultPoint3 != null) {
                int i9 = 1;
                ResultPoint resultPoint4 = null;
                while (resultPoint4 == null && i9 < i6) {
                    resultPoint4 = getBlackPointOnSegment((float) i2, (float) (i3 + i9), (float) (i2 - i9), (float) i3);
                    i9++;
                }
                if (resultPoint4 != null) {
                    while (resultPoint == null && i5 < i6) {
                        resultPoint = getBlackPointOnSegment((float) i2, (float) (i4 - i5), (float) (i2 - i5), (float) i4);
                        i5++;
                    }
                    if (resultPoint != null) {
                        return centerEdges(resultPoint, resultPoint2, resultPoint4, resultPoint3);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private ResultPoint getBlackPointOnSegment(float f, float f2, float f3, float f4) {
        int round = MathUtils.round(MathUtils.distance(f, f2, f3, f4));
        float f5 = (float) round;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i = 0; i < round; i++) {
            float f8 = (float) i;
            int round2 = MathUtils.round((f8 * f6) + f);
            int round3 = MathUtils.round((f8 * f7) + f2);
            if (this.image.get(round2, round3)) {
                return new ResultPoint((float) round2, (float) round3);
            }
        }
        return null;
    }

    private ResultPoint[] centerEdges(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        float x2 = resultPoint2.getX();
        float y2 = resultPoint2.getY();
        float x3 = resultPoint3.getX();
        float y3 = resultPoint3.getY();
        float x4 = resultPoint4.getX();
        float y4 = resultPoint4.getY();
        if (x < ((float) this.width) / 2.0f) {
            return new ResultPoint[]{new ResultPoint(x4 - 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 + 1.0f), new ResultPoint(x3 - 1.0f, y3 - 1.0f), new ResultPoint(x + 1.0f, y - 1.0f)};
        }
        return new ResultPoint[]{new ResultPoint(x4 + 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 - 1.0f), new ResultPoint(x3 - 1.0f, y3 + 1.0f), new ResultPoint(x - 1.0f, y - 1.0f)};
    }

    private boolean containsBlackPoint(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.image.get(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.image.get(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }
}
