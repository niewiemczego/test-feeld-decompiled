package zendesk.ui.android.conversation.carousel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J8\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lzendesk/ui/android/conversation/carousel/CarouselRendering;", "", "textColor", "", "margin", "actionColor", "showAvatar", "", "(IILjava/lang/Integer;Z)V", "getActionColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMargin", "()I", "getShowAvatar", "()Z", "getTextColor", "component1", "component2", "component3", "component4", "copy", "(IILjava/lang/Integer;Z)Lzendesk/ui/android/conversation/carousel/CarouselRendering;", "equals", "other", "hashCode", "toString", "", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CarouselCellState.kt */
public final class CarouselRendering {
    private final Integer actionColor;
    private final int margin;
    private final boolean showAvatar;
    private final int textColor;

    public CarouselRendering() {
        this(0, 0, (Integer) null, false, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CarouselRendering copy$default(CarouselRendering carouselRendering, int i, int i2, Integer num, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = carouselRendering.textColor;
        }
        if ((i3 & 2) != 0) {
            i2 = carouselRendering.margin;
        }
        if ((i3 & 4) != 0) {
            num = carouselRendering.actionColor;
        }
        if ((i3 & 8) != 0) {
            z = carouselRendering.showAvatar;
        }
        return carouselRendering.copy(i, i2, num, z);
    }

    public final int component1() {
        return this.textColor;
    }

    public final int component2() {
        return this.margin;
    }

    public final Integer component3() {
        return this.actionColor;
    }

    public final boolean component4() {
        return this.showAvatar;
    }

    public final CarouselRendering copy(int i, int i2, Integer num, boolean z) {
        return new CarouselRendering(i, i2, num, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CarouselRendering)) {
            return false;
        }
        CarouselRendering carouselRendering = (CarouselRendering) obj;
        return this.textColor == carouselRendering.textColor && this.margin == carouselRendering.margin && Intrinsics.areEqual((Object) this.actionColor, (Object) carouselRendering.actionColor) && this.showAvatar == carouselRendering.showAvatar;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.textColor) * 31) + Integer.hashCode(this.margin)) * 31;
        Integer num = this.actionColor;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        boolean z = this.showAvatar;
        if (z) {
            z = true;
        }
        return hashCode2 + (z ? 1 : 0);
    }

    public String toString() {
        return "CarouselRendering(textColor=" + this.textColor + ", margin=" + this.margin + ", actionColor=" + this.actionColor + ", showAvatar=" + this.showAvatar + ')';
    }

    public CarouselRendering(int i, int i2, Integer num, boolean z) {
        this.textColor = i;
        this.margin = i2;
        this.actionColor = num;
        this.showAvatar = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CarouselRendering(int i, int i2, Integer num, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? null : num, (i3 & 8) != 0 ? true : z);
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getMargin() {
        return this.margin;
    }

    public final Integer getActionColor() {
        return this.actionColor;
    }

    public final boolean getShowAvatar() {
        return this.showAvatar;
    }
}
