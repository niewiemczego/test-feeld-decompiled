package com.th3rdwave.safeareacontext;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/th3rdwave/safeareacontext/SafeAreaViewEdges;", "", "top", "Lcom/th3rdwave/safeareacontext/SafeAreaViewEdgeModes;", "right", "bottom", "left", "(Lcom/th3rdwave/safeareacontext/SafeAreaViewEdgeModes;Lcom/th3rdwave/safeareacontext/SafeAreaViewEdgeModes;Lcom/th3rdwave/safeareacontext/SafeAreaViewEdgeModes;Lcom/th3rdwave/safeareacontext/SafeAreaViewEdgeModes;)V", "getBottom", "()Lcom/th3rdwave/safeareacontext/SafeAreaViewEdgeModes;", "getLeft", "getRight", "getTop", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "react-native-safe-area-context_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SafeAreaViewEdges.kt */
public final class SafeAreaViewEdges {
    private final SafeAreaViewEdgeModes bottom;
    private final SafeAreaViewEdgeModes left;
    private final SafeAreaViewEdgeModes right;
    private final SafeAreaViewEdgeModes top;

    public static /* synthetic */ SafeAreaViewEdges copy$default(SafeAreaViewEdges safeAreaViewEdges, SafeAreaViewEdgeModes safeAreaViewEdgeModes, SafeAreaViewEdgeModes safeAreaViewEdgeModes2, SafeAreaViewEdgeModes safeAreaViewEdgeModes3, SafeAreaViewEdgeModes safeAreaViewEdgeModes4, int i, Object obj) {
        if ((i & 1) != 0) {
            safeAreaViewEdgeModes = safeAreaViewEdges.top;
        }
        if ((i & 2) != 0) {
            safeAreaViewEdgeModes2 = safeAreaViewEdges.right;
        }
        if ((i & 4) != 0) {
            safeAreaViewEdgeModes3 = safeAreaViewEdges.bottom;
        }
        if ((i & 8) != 0) {
            safeAreaViewEdgeModes4 = safeAreaViewEdges.left;
        }
        return safeAreaViewEdges.copy(safeAreaViewEdgeModes, safeAreaViewEdgeModes2, safeAreaViewEdgeModes3, safeAreaViewEdgeModes4);
    }

    public final SafeAreaViewEdgeModes component1() {
        return this.top;
    }

    public final SafeAreaViewEdgeModes component2() {
        return this.right;
    }

    public final SafeAreaViewEdgeModes component3() {
        return this.bottom;
    }

    public final SafeAreaViewEdgeModes component4() {
        return this.left;
    }

    public final SafeAreaViewEdges copy(SafeAreaViewEdgeModes safeAreaViewEdgeModes, SafeAreaViewEdgeModes safeAreaViewEdgeModes2, SafeAreaViewEdgeModes safeAreaViewEdgeModes3, SafeAreaViewEdgeModes safeAreaViewEdgeModes4) {
        Intrinsics.checkNotNullParameter(safeAreaViewEdgeModes, "top");
        Intrinsics.checkNotNullParameter(safeAreaViewEdgeModes2, "right");
        Intrinsics.checkNotNullParameter(safeAreaViewEdgeModes3, ViewProps.BOTTOM);
        Intrinsics.checkNotNullParameter(safeAreaViewEdgeModes4, "left");
        return new SafeAreaViewEdges(safeAreaViewEdgeModes, safeAreaViewEdgeModes2, safeAreaViewEdgeModes3, safeAreaViewEdgeModes4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SafeAreaViewEdges)) {
            return false;
        }
        SafeAreaViewEdges safeAreaViewEdges = (SafeAreaViewEdges) obj;
        return this.top == safeAreaViewEdges.top && this.right == safeAreaViewEdges.right && this.bottom == safeAreaViewEdges.bottom && this.left == safeAreaViewEdges.left;
    }

    public int hashCode() {
        return (((((this.top.hashCode() * 31) + this.right.hashCode()) * 31) + this.bottom.hashCode()) * 31) + this.left.hashCode();
    }

    public String toString() {
        return "SafeAreaViewEdges(top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", left=" + this.left + ')';
    }

    public SafeAreaViewEdges(SafeAreaViewEdgeModes safeAreaViewEdgeModes, SafeAreaViewEdgeModes safeAreaViewEdgeModes2, SafeAreaViewEdgeModes safeAreaViewEdgeModes3, SafeAreaViewEdgeModes safeAreaViewEdgeModes4) {
        Intrinsics.checkNotNullParameter(safeAreaViewEdgeModes, "top");
        Intrinsics.checkNotNullParameter(safeAreaViewEdgeModes2, "right");
        Intrinsics.checkNotNullParameter(safeAreaViewEdgeModes3, ViewProps.BOTTOM);
        Intrinsics.checkNotNullParameter(safeAreaViewEdgeModes4, "left");
        this.top = safeAreaViewEdgeModes;
        this.right = safeAreaViewEdgeModes2;
        this.bottom = safeAreaViewEdgeModes3;
        this.left = safeAreaViewEdgeModes4;
    }

    public final SafeAreaViewEdgeModes getTop() {
        return this.top;
    }

    public final SafeAreaViewEdgeModes getRight() {
        return this.right;
    }

    public final SafeAreaViewEdgeModes getBottom() {
        return this.bottom;
    }

    public final SafeAreaViewEdgeModes getLeft() {
        return this.left;
    }
}
