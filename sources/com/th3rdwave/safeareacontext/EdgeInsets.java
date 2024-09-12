package com.th3rdwave.safeareacontext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/th3rdwave/safeareacontext/EdgeInsets;", "", "top", "", "right", "bottom", "left", "(FFFF)V", "getBottom", "()F", "getLeft", "getRight", "getTop", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "react-native-safe-area-context_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: EdgeInsets.kt */
public final class EdgeInsets {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    public static /* synthetic */ EdgeInsets copy$default(EdgeInsets edgeInsets, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = edgeInsets.top;
        }
        if ((i & 2) != 0) {
            f2 = edgeInsets.right;
        }
        if ((i & 4) != 0) {
            f3 = edgeInsets.bottom;
        }
        if ((i & 8) != 0) {
            f4 = edgeInsets.left;
        }
        return edgeInsets.copy(f, f2, f3, f4);
    }

    public final float component1() {
        return this.top;
    }

    public final float component2() {
        return this.right;
    }

    public final float component3() {
        return this.bottom;
    }

    public final float component4() {
        return this.left;
    }

    public final EdgeInsets copy(float f, float f2, float f3, float f4) {
        return new EdgeInsets(f, f2, f3, f4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EdgeInsets)) {
            return false;
        }
        EdgeInsets edgeInsets = (EdgeInsets) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.top), (Object) Float.valueOf(edgeInsets.top)) && Intrinsics.areEqual((Object) Float.valueOf(this.right), (Object) Float.valueOf(edgeInsets.right)) && Intrinsics.areEqual((Object) Float.valueOf(this.bottom), (Object) Float.valueOf(edgeInsets.bottom)) && Intrinsics.areEqual((Object) Float.valueOf(this.left), (Object) Float.valueOf(edgeInsets.left));
    }

    public int hashCode() {
        return (((((Float.hashCode(this.top) * 31) + Float.hashCode(this.right)) * 31) + Float.hashCode(this.bottom)) * 31) + Float.hashCode(this.left);
    }

    public String toString() {
        return "EdgeInsets(top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", left=" + this.left + ')';
    }

    public EdgeInsets(float f, float f2, float f3, float f4) {
        this.top = f;
        this.right = f2;
        this.bottom = f3;
        this.left = f4;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }
}
