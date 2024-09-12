package zendesk.ui.android.conversation.carousel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lzendesk/ui/android/conversation/carousel/CarouselCellAction;", "", "id", "", "text", "clickListener", "Lkotlin/Function1;", "", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "getId", "()Ljava/lang/String;", "getText", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CarouselCellState.kt */
public final class CarouselCellAction {
    private final Function1<CarouselCellAction, Unit> clickListener;
    private final String id;
    private final String text;

    public static /* synthetic */ CarouselCellAction copy$default(CarouselCellAction carouselCellAction, String str, String str2, Function1<CarouselCellAction, Unit> function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = carouselCellAction.id;
        }
        if ((i & 2) != 0) {
            str2 = carouselCellAction.text;
        }
        if ((i & 4) != 0) {
            function1 = carouselCellAction.clickListener;
        }
        return carouselCellAction.copy(str, str2, function1);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.text;
    }

    public final Function1<CarouselCellAction, Unit> component3() {
        return this.clickListener;
    }

    public final CarouselCellAction copy(String str, String str2, Function1<? super CarouselCellAction, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(function1, "clickListener");
        return new CarouselCellAction(str, str2, function1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CarouselCellAction)) {
            return false;
        }
        CarouselCellAction carouselCellAction = (CarouselCellAction) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) carouselCellAction.id) && Intrinsics.areEqual((Object) this.text, (Object) carouselCellAction.text) && Intrinsics.areEqual((Object) this.clickListener, (Object) carouselCellAction.clickListener);
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.text.hashCode()) * 31) + this.clickListener.hashCode();
    }

    public String toString() {
        return "CarouselCellAction(id=" + this.id + ", text=" + this.text + ", clickListener=" + this.clickListener + ')';
    }

    public CarouselCellAction(String str, String str2, Function1<? super CarouselCellAction, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(function1, "clickListener");
        this.id = str;
        this.text = str2;
        this.clickListener = function1;
    }

    public final String getId() {
        return this.id;
    }

    public final String getText() {
        return this.text;
    }

    public final Function1<CarouselCellAction, Unit> getClickListener() {
        return this.clickListener;
    }
}
