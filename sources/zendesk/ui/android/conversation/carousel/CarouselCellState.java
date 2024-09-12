package zendesk.ui.android.conversation.carousel;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.conversation.avatar.AvatarImageState;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lzendesk/ui/android/conversation/carousel/CarouselCellState;", "", "cellData", "", "Lzendesk/ui/android/conversation/carousel/CarouselCellData;", "avatarImageState", "Lzendesk/ui/android/conversation/avatar/AvatarImageState;", "rendering", "Lzendesk/ui/android/conversation/carousel/CarouselRendering;", "(Ljava/util/List;Lzendesk/ui/android/conversation/avatar/AvatarImageState;Lzendesk/ui/android/conversation/carousel/CarouselRendering;)V", "getAvatarImageState", "()Lzendesk/ui/android/conversation/avatar/AvatarImageState;", "getCellData", "()Ljava/util/List;", "getRendering", "()Lzendesk/ui/android/conversation/carousel/CarouselRendering;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CarouselCellState.kt */
public final class CarouselCellState {
    private final AvatarImageState avatarImageState;
    private final List<CarouselCellData> cellData;
    private final CarouselRendering rendering;

    public CarouselCellState() {
        this((List) null, (AvatarImageState) null, (CarouselRendering) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CarouselCellState copy$default(CarouselCellState carouselCellState, List<CarouselCellData> list, AvatarImageState avatarImageState2, CarouselRendering carouselRendering, int i, Object obj) {
        if ((i & 1) != 0) {
            list = carouselCellState.cellData;
        }
        if ((i & 2) != 0) {
            avatarImageState2 = carouselCellState.avatarImageState;
        }
        if ((i & 4) != 0) {
            carouselRendering = carouselCellState.rendering;
        }
        return carouselCellState.copy(list, avatarImageState2, carouselRendering);
    }

    public final List<CarouselCellData> component1() {
        return this.cellData;
    }

    public final AvatarImageState component2() {
        return this.avatarImageState;
    }

    public final CarouselRendering component3() {
        return this.rendering;
    }

    public final CarouselCellState copy(List<? extends CarouselCellData> list, AvatarImageState avatarImageState2, CarouselRendering carouselRendering) {
        Intrinsics.checkNotNullParameter(list, "cellData");
        Intrinsics.checkNotNullParameter(carouselRendering, "rendering");
        return new CarouselCellState(list, avatarImageState2, carouselRendering);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CarouselCellState)) {
            return false;
        }
        CarouselCellState carouselCellState = (CarouselCellState) obj;
        return Intrinsics.areEqual((Object) this.cellData, (Object) carouselCellState.cellData) && Intrinsics.areEqual((Object) this.avatarImageState, (Object) carouselCellState.avatarImageState) && Intrinsics.areEqual((Object) this.rendering, (Object) carouselCellState.rendering);
    }

    public int hashCode() {
        int hashCode = this.cellData.hashCode() * 31;
        AvatarImageState avatarImageState2 = this.avatarImageState;
        return ((hashCode + (avatarImageState2 == null ? 0 : avatarImageState2.hashCode())) * 31) + this.rendering.hashCode();
    }

    public String toString() {
        return "CarouselCellState(cellData=" + this.cellData + ", avatarImageState=" + this.avatarImageState + ", rendering=" + this.rendering + ')';
    }

    public CarouselCellState(List<? extends CarouselCellData> list, AvatarImageState avatarImageState2, CarouselRendering carouselRendering) {
        Intrinsics.checkNotNullParameter(list, "cellData");
        Intrinsics.checkNotNullParameter(carouselRendering, "rendering");
        this.cellData = list;
        this.avatarImageState = avatarImageState2;
        this.rendering = carouselRendering;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CarouselCellState(List list, AvatarImageState avatarImageState2, CarouselRendering carouselRendering, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : avatarImageState2, (i & 4) != 0 ? new CarouselRendering(0, 0, (Integer) null, false, 15, (DefaultConstructorMarker) null) : carouselRendering);
    }

    public final List<CarouselCellData> getCellData() {
        return this.cellData;
    }

    public final AvatarImageState getAvatarImageState() {
        return this.avatarImageState;
    }

    public final CarouselRendering getRendering() {
        return this.rendering;
    }
}
