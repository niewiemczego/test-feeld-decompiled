package com.shopify.reactnative.flash_list;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\u0002\u0010(J\u001e\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004J\u0010\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020'H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u000e\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001a\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001a\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001a\u0010 \u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006/"}, d2 = {"Lcom/shopify/reactnative/flash_list/AutoLayoutShadow;", "", "()V", "blankOffsetAtEnd", "", "getBlankOffsetAtEnd", "()I", "setBlankOffsetAtEnd", "(I)V", "blankOffsetAtStart", "getBlankOffsetAtStart", "setBlankOffsetAtStart", "horizontal", "", "getHorizontal", "()Z", "setHorizontal", "(Z)V", "lastMaxBound", "lastMaxBoundOverall", "getLastMaxBoundOverall", "setLastMaxBoundOverall", "lastMinBound", "offsetFromStart", "getOffsetFromStart", "setOffsetFromStart", "renderOffset", "getRenderOffset", "setRenderOffset", "scrollOffset", "getScrollOffset", "setScrollOffset", "windowSize", "getWindowSize", "setWindowSize", "clearGapsAndOverlaps", "", "sortedItems", "", "Lcom/shopify/reactnative/flash_list/CellContainer;", "([Lcom/shopify/reactnative/flash_list/CellContainer;)V", "computeBlankFromGivenOffset", "actualScrollOffset", "distanceFromWindowStart", "distanceFromWindowEnd", "isWithinBounds", "cell", "shopify_flash-list_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AutoLayoutShadow.kt */
public final class AutoLayoutShadow {
    private int blankOffsetAtEnd;
    private int blankOffsetAtStart;
    private boolean horizontal;
    private int lastMaxBound;
    private int lastMaxBoundOverall;
    private int lastMinBound;
    private int offsetFromStart;
    private int renderOffset;
    private int scrollOffset;
    private int windowSize;

    public final boolean getHorizontal() {
        return this.horizontal;
    }

    public final void setHorizontal(boolean z) {
        this.horizontal = z;
    }

    public final int getScrollOffset() {
        return this.scrollOffset;
    }

    public final void setScrollOffset(int i) {
        this.scrollOffset = i;
    }

    public final int getOffsetFromStart() {
        return this.offsetFromStart;
    }

    public final void setOffsetFromStart(int i) {
        this.offsetFromStart = i;
    }

    public final int getWindowSize() {
        return this.windowSize;
    }

    public final void setWindowSize(int i) {
        this.windowSize = i;
    }

    public final int getRenderOffset() {
        return this.renderOffset;
    }

    public final void setRenderOffset(int i) {
        this.renderOffset = i;
    }

    public final int getBlankOffsetAtStart() {
        return this.blankOffsetAtStart;
    }

    public final void setBlankOffsetAtStart(int i) {
        this.blankOffsetAtStart = i;
    }

    public final int getBlankOffsetAtEnd() {
        return this.blankOffsetAtEnd;
    }

    public final void setBlankOffsetAtEnd(int i) {
        this.blankOffsetAtEnd = i;
    }

    public final int getLastMaxBoundOverall() {
        return this.lastMaxBoundOverall;
    }

    public final void setLastMaxBoundOverall(int i) {
        this.lastMaxBoundOverall = i;
    }

    public final void clearGapsAndOverlaps(CellContainer[] cellContainerArr) {
        int i;
        Intrinsics.checkNotNullParameter(cellContainerArr, "sortedItems");
        this.lastMaxBoundOverall = 0;
        int length = cellContainerArr.length - 1;
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < length) {
            CellContainer cellContainer = cellContainerArr[i3];
            i3++;
            CellContainer cellContainer2 = cellContainerArr[i3];
            boolean z = cellContainer2.getIndex() == cellContainer.getIndex() + 1;
            if (isWithinBounds(cellContainer)) {
                if (!this.horizontal) {
                    i4 = Math.max(i5, cellContainer.getBottom());
                    i2 = Math.min(i2, cellContainer.getTop());
                    if (z) {
                        if (cellContainer.getLeft() < cellContainer2.getLeft()) {
                            if (cellContainer.getRight() != cellContainer2.getLeft()) {
                                cellContainer2.setRight(cellContainer.getRight() + cellContainer2.getWidth());
                                cellContainer2.setLeft(cellContainer.getRight());
                            }
                            if (cellContainer.getTop() != cellContainer2.getTop()) {
                                cellContainer2.setBottom(cellContainer.getTop() + cellContainer2.getHeight());
                                cellContainer2.setTop(cellContainer.getTop());
                            }
                        } else {
                            cellContainer2.setBottom(cellContainer2.getHeight() + i4);
                            cellContainer2.setTop(i4);
                        }
                    }
                    if (isWithinBounds(cellContainer2)) {
                        i = Math.max(i4, cellContainer2.getBottom());
                    }
                    i5 = i4;
                } else {
                    i4 = Math.max(i5, cellContainer.getRight());
                    i2 = Math.min(i2, cellContainer.getLeft());
                    if (z) {
                        if (cellContainer.getTop() < cellContainer2.getTop()) {
                            if (cellContainer.getBottom() != cellContainer2.getTop()) {
                                cellContainer2.setBottom(cellContainer.getBottom() + cellContainer2.getHeight());
                                cellContainer2.setTop(cellContainer.getBottom());
                            }
                            if (cellContainer.getLeft() != cellContainer2.getLeft()) {
                                cellContainer2.setRight(cellContainer.getLeft() + cellContainer2.getWidth());
                                cellContainer2.setLeft(cellContainer.getLeft());
                            }
                        } else {
                            cellContainer2.setRight(cellContainer2.getWidth() + i4);
                            cellContainer2.setLeft(i4);
                        }
                    }
                    if (isWithinBounds(cellContainer2)) {
                        i = Math.max(i4, cellContainer2.getRight());
                    }
                    i5 = i4;
                }
                int i6 = i;
                i5 = i4;
                i4 = i6;
            }
            int max = Math.max(this.lastMaxBoundOverall, this.horizontal ? cellContainer.getRight() : cellContainer.getBottom());
            this.lastMaxBoundOverall = max;
            this.lastMaxBoundOverall = Math.max(max, this.horizontal ? cellContainer2.getRight() : cellContainer2.getBottom());
        }
        this.lastMaxBound = i4;
        this.lastMinBound = i2;
    }

    public final int computeBlankFromGivenOffset(int i, int i2, int i3) {
        int i4 = i - this.offsetFromStart;
        int i5 = (this.lastMinBound - i4) - i2;
        this.blankOffsetAtStart = i5;
        int i6 = (((i4 + this.windowSize) - this.renderOffset) - this.lastMaxBound) - i3;
        this.blankOffsetAtEnd = i6;
        return Math.max(i5, i6);
    }

    private final boolean isWithinBounds(CellContainer cellContainer) {
        int i = this.scrollOffset - this.offsetFromStart;
        if (!this.horizontal) {
            if (cellContainer.getTop() < i - this.renderOffset && cellContainer.getBottom() < i - this.renderOffset) {
                return false;
            }
            if (cellContainer.getTop() > this.windowSize + i && cellContainer.getBottom() > i + this.windowSize) {
                return false;
            }
        } else if (cellContainer.getLeft() < i - this.renderOffset && cellContainer.getRight() < i - this.renderOffset) {
            return false;
        } else {
            if (cellContainer.getLeft() > this.windowSize + i && cellContainer.getRight() > i + this.windowSize) {
                return false;
            }
        }
        return true;
    }
}
