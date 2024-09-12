package zendesk.ui.android.conversation.imagecell;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0012B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0013"}, d2 = {"Lzendesk/ui/android/conversation/imagecell/ImageRoundedCorner;", "", "topLeft", "", "topRight", "bottomRight", "bottomLeft", "(FFFF)V", "getBottomLeft", "()F", "setBottomLeft", "(F)V", "getBottomRight", "setBottomRight", "getTopLeft", "setTopLeft", "getTopRight", "setTopRight", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageRoundedCorner.kt */
public final class ImageRoundedCorner {
    private float bottomLeft;
    private float bottomRight;
    private float topLeft;
    private float topRight;

    public /* synthetic */ ImageRoundedCorner(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    private ImageRoundedCorner(float f, float f2, float f3, float f4) {
        this.topLeft = f;
        this.topRight = f2;
        this.bottomRight = f3;
        this.bottomLeft = f4;
    }

    public final float getTopLeft() {
        return this.topLeft;
    }

    public final void setTopLeft(float f) {
        this.topLeft = f;
    }

    public final float getTopRight() {
        return this.topRight;
    }

    public final void setTopRight(float f) {
        this.topRight = f;
    }

    public final float getBottomRight() {
        return this.bottomRight;
    }

    public final void setBottomRight(float f) {
        this.bottomRight = f;
    }

    public final float getBottomLeft() {
        return this.bottomLeft;
    }

    public final void setBottomLeft(float f) {
        this.bottomLeft = f;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0012\u001a\u00020\u000fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0002J\b\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0002J\b\u0010 \u001a\u00020\u000fH\u0002J\b\u0010!\u001a\u00020\u000fH\u0002J\b\u0010\"\u001a\u00020\u000fH\u0002J\b\u0010#\u001a\u00020\u000fH\u0002J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006&"}, d2 = {"Lzendesk/ui/android/conversation/imagecell/ImageRoundedCorner$Builder;", "", "cellRadius", "", "smallCellRadius", "direction", "Lzendesk/ui/android/conversation/imagecell/ImageCellDirection;", "isLayoutDirectionLTR", "", "(FFLzendesk/ui/android/conversation/imagecell/ImageCellDirection;Z)V", "getCellRadius", "()F", "getDirection", "()Lzendesk/ui/android/conversation/imagecell/ImageCellDirection;", "imageRoundedCorner", "Lzendesk/ui/android/conversation/imagecell/ImageRoundedCorner;", "()Z", "getSmallCellRadius", "build", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "inboundBottom", "inboundMiddle", "inboundSingle", "inboundTop", "outboundBottom", "outboundMiddle", "outboundSingle", "outboundTop", "toString", "", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageRoundedCorner.kt */
    public static final class Builder {
        private final float cellRadius;
        private final ImageCellDirection direction;
        private final ImageRoundedCorner imageRoundedCorner;
        private final boolean isLayoutDirectionLTR;
        private final float smallCellRadius;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ImageRoundedCorner.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ImageCellDirection.values().length];
                iArr[ImageCellDirection.INBOUND_SINGLE.ordinal()] = 1;
                iArr[ImageCellDirection.INBOUND_TOP.ordinal()] = 2;
                iArr[ImageCellDirection.INBOUND_MIDDLE.ordinal()] = 3;
                iArr[ImageCellDirection.INBOUND_BOTTOM.ordinal()] = 4;
                iArr[ImageCellDirection.OUTBOUND_SINGLE.ordinal()] = 5;
                iArr[ImageCellDirection.OUTBOUND_TOP.ordinal()] = 6;
                iArr[ImageCellDirection.OUTBOUND_MIDDLE.ordinal()] = 7;
                iArr[ImageCellDirection.OUTBOUND_BOTTOM.ordinal()] = 8;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public static /* synthetic */ Builder copy$default(Builder builder, float f, float f2, ImageCellDirection imageCellDirection, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                f = builder.cellRadius;
            }
            if ((i & 2) != 0) {
                f2 = builder.smallCellRadius;
            }
            if ((i & 4) != 0) {
                imageCellDirection = builder.direction;
            }
            if ((i & 8) != 0) {
                z = builder.isLayoutDirectionLTR;
            }
            return builder.copy(f, f2, imageCellDirection, z);
        }

        public final float component1() {
            return this.cellRadius;
        }

        public final float component2() {
            return this.smallCellRadius;
        }

        public final ImageCellDirection component3() {
            return this.direction;
        }

        public final boolean component4() {
            return this.isLayoutDirectionLTR;
        }

        public final Builder copy(float f, float f2, ImageCellDirection imageCellDirection, boolean z) {
            Intrinsics.checkNotNullParameter(imageCellDirection, "direction");
            return new Builder(f, f2, imageCellDirection, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.cellRadius), (Object) Float.valueOf(builder.cellRadius)) && Intrinsics.areEqual((Object) Float.valueOf(this.smallCellRadius), (Object) Float.valueOf(builder.smallCellRadius)) && this.direction == builder.direction && this.isLayoutDirectionLTR == builder.isLayoutDirectionLTR;
        }

        public int hashCode() {
            int hashCode = ((((Float.hashCode(this.cellRadius) * 31) + Float.hashCode(this.smallCellRadius)) * 31) + this.direction.hashCode()) * 31;
            boolean z = this.isLayoutDirectionLTR;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        public String toString() {
            return "Builder(cellRadius=" + this.cellRadius + ", smallCellRadius=" + this.smallCellRadius + ", direction=" + this.direction + ", isLayoutDirectionLTR=" + this.isLayoutDirectionLTR + ')';
        }

        public Builder(float f, float f2, ImageCellDirection imageCellDirection, boolean z) {
            Intrinsics.checkNotNullParameter(imageCellDirection, "direction");
            this.cellRadius = f;
            this.smallCellRadius = f2;
            this.direction = imageCellDirection;
            this.isLayoutDirectionLTR = z;
            this.imageRoundedCorner = new ImageRoundedCorner(f, f, f, f, (DefaultConstructorMarker) null);
        }

        public final float getCellRadius() {
            return this.cellRadius;
        }

        public final float getSmallCellRadius() {
            return this.smallCellRadius;
        }

        public final ImageCellDirection getDirection() {
            return this.direction;
        }

        public final boolean isLayoutDirectionLTR() {
            return this.isLayoutDirectionLTR;
        }

        private final ImageRoundedCorner inboundSingle() {
            return outboundSingle();
        }

        private final ImageRoundedCorner inboundTop() {
            ImageRoundedCorner imageRoundedCorner2 = this.imageRoundedCorner;
            if (this.isLayoutDirectionLTR) {
                imageRoundedCorner2.setBottomLeft(this.smallCellRadius);
            } else {
                imageRoundedCorner2.setBottomRight(this.smallCellRadius);
            }
            return imageRoundedCorner2;
        }

        private final ImageRoundedCorner inboundMiddle() {
            ImageRoundedCorner imageRoundedCorner2 = this.imageRoundedCorner;
            if (this.isLayoutDirectionLTR) {
                imageRoundedCorner2.setTopLeft(this.smallCellRadius);
                imageRoundedCorner2.setBottomLeft(this.smallCellRadius);
            } else {
                imageRoundedCorner2.setTopRight(this.smallCellRadius);
                imageRoundedCorner2.setBottomRight(this.smallCellRadius);
            }
            return imageRoundedCorner2;
        }

        private final ImageRoundedCorner inboundBottom() {
            ImageRoundedCorner imageRoundedCorner2 = this.imageRoundedCorner;
            if (this.isLayoutDirectionLTR) {
                imageRoundedCorner2.setTopLeft(this.smallCellRadius);
            } else {
                imageRoundedCorner2.setTopRight(this.smallCellRadius);
            }
            return imageRoundedCorner2;
        }

        private final ImageRoundedCorner outboundSingle() {
            return this.imageRoundedCorner;
        }

        private final ImageRoundedCorner outboundTop() {
            ImageRoundedCorner imageRoundedCorner2 = this.imageRoundedCorner;
            if (this.isLayoutDirectionLTR) {
                imageRoundedCorner2.setBottomRight(this.smallCellRadius);
            } else {
                imageRoundedCorner2.setBottomLeft(this.smallCellRadius);
            }
            return imageRoundedCorner2;
        }

        private final ImageRoundedCorner outboundMiddle() {
            ImageRoundedCorner imageRoundedCorner2 = this.imageRoundedCorner;
            if (this.isLayoutDirectionLTR) {
                imageRoundedCorner2.setTopRight(this.smallCellRadius);
                imageRoundedCorner2.setBottomRight(this.smallCellRadius);
            } else {
                imageRoundedCorner2.setTopLeft(this.smallCellRadius);
                imageRoundedCorner2.setBottomLeft(this.smallCellRadius);
            }
            return imageRoundedCorner2;
        }

        private final ImageRoundedCorner outboundBottom() {
            ImageRoundedCorner imageRoundedCorner2 = this.imageRoundedCorner;
            if (this.isLayoutDirectionLTR) {
                imageRoundedCorner2.setTopRight(this.smallCellRadius);
            } else {
                imageRoundedCorner2.setTopLeft(this.smallCellRadius);
            }
            return imageRoundedCorner2;
        }

        public final ImageRoundedCorner build() {
            switch (WhenMappings.$EnumSwitchMapping$0[this.direction.ordinal()]) {
                case 1:
                    return inboundSingle();
                case 2:
                    return inboundTop();
                case 3:
                    return inboundMiddle();
                case 4:
                    return inboundBottom();
                case 5:
                    return outboundSingle();
                case 6:
                    return outboundTop();
                case 7:
                    return outboundMiddle();
                case 8:
                    return outboundBottom();
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }
}
