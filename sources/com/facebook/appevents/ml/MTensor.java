package com.facebook.appevents.ml;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/facebook/appevents/ml/MTensor;", "", "shape", "", "([I)V", "capacity", "", "<set-?>", "", "data", "getData", "()[F", "shapeSize", "getShapeSize", "()I", "getShape", "i", "reshape", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: MTensor.kt */
public final class MTensor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private int capacity;
    private float[] data;
    private int[] shape;

    public MTensor(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "shape");
        this.shape = iArr;
        int access$getCapacity = Companion.getCapacity(iArr);
        this.capacity = access$getCapacity;
        this.data = new float[access$getCapacity];
    }

    public final float[] getData() {
        return this.data;
    }

    public final int getShapeSize() {
        return this.shape.length;
    }

    public final int getShape(int i) {
        return this.shape[i];
    }

    public final void reshape(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "shape");
        this.shape = iArr;
        int access$getCapacity = Companion.getCapacity(iArr);
        float[] fArr = new float[access$getCapacity];
        System.arraycopy(this.data, 0, fArr, 0, Math.min(this.capacity, access$getCapacity));
        this.data = fArr;
        this.capacity = access$getCapacity;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/ml/MTensor$Companion;", "", "()V", "getCapacity", "", "shape", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: MTensor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final int getCapacity(int[] iArr) {
            int i = 1;
            if (!(iArr.length == 0)) {
                int i2 = iArr[0];
                int lastIndex = ArraysKt.getLastIndex(iArr);
                if (1 <= lastIndex) {
                    while (true) {
                        i2 *= iArr[i];
                        if (i == lastIndex) {
                            break;
                        }
                        i++;
                    }
                }
                return i2;
            }
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
    }
}
