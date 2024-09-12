package zendesk.ui.android.conversation.item;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001fB3\b\u0000\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0018\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003HÀ\u0003¢\u0006\u0002\b\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0004\b\u0012\u0010\fJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0004\b\u0014\u0010\fJ:\u0010\u0015\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001e\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006 "}, d2 = {"Lzendesk/ui/android/conversation/item/ItemGroupState;", "", "items", "", "Lzendesk/ui/android/conversation/item/Item;", "titleColor", "", "pressedColor", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getItems$zendesk_ui_ui_android", "()Ljava/util/List;", "getPressedColor$zendesk_ui_ui_android", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitleColor$zendesk_ui_ui_android", "component1", "component1$zendesk_ui_ui_android", "component2", "component2$zendesk_ui_ui_android", "component3", "component3$zendesk_ui_ui_android", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lzendesk/ui/android/conversation/item/ItemGroupState;", "equals", "", "other", "hashCode", "toBuilder", "Lzendesk/ui/android/conversation/item/ItemGroupState$Builder;", "toString", "", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ItemGroupState.kt */
public final class ItemGroupState {
    private final List<Item<?>> items;
    private final Integer pressedColor;
    private final Integer titleColor;

    public ItemGroupState() {
        this((List) null, (Integer) null, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ItemGroupState copy$default(ItemGroupState itemGroupState, List<Item<?>> list, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = itemGroupState.items;
        }
        if ((i & 2) != 0) {
            num = itemGroupState.titleColor;
        }
        if ((i & 4) != 0) {
            num2 = itemGroupState.pressedColor;
        }
        return itemGroupState.copy(list, num, num2);
    }

    public final List<Item<?>> component1$zendesk_ui_ui_android() {
        return this.items;
    }

    public final Integer component2$zendesk_ui_ui_android() {
        return this.titleColor;
    }

    public final Integer component3$zendesk_ui_ui_android() {
        return this.pressedColor;
    }

    public final ItemGroupState copy(List<? extends Item<?>> list, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        return new ItemGroupState(list, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ItemGroupState)) {
            return false;
        }
        ItemGroupState itemGroupState = (ItemGroupState) obj;
        return Intrinsics.areEqual((Object) this.items, (Object) itemGroupState.items) && Intrinsics.areEqual((Object) this.titleColor, (Object) itemGroupState.titleColor) && Intrinsics.areEqual((Object) this.pressedColor, (Object) itemGroupState.pressedColor);
    }

    public int hashCode() {
        int hashCode = this.items.hashCode() * 31;
        Integer num = this.titleColor;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.pressedColor;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ItemGroupState(items=" + this.items + ", titleColor=" + this.titleColor + ", pressedColor=" + this.pressedColor + ')';
    }

    public ItemGroupState(List<? extends Item<?>> list, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.items = list;
        this.titleColor = num;
        this.pressedColor = num2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemGroupState(List list, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2);
    }

    public final List<Item<?>> getItems$zendesk_ui_ui_android() {
        return this.items;
    }

    public final Integer getTitleColor$zendesk_ui_ui_android() {
        return this.titleColor;
    }

    public final Integer getPressedColor$zendesk_ui_ui_android() {
        return this.pressedColor;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0003J\u0018\u0010\u0007\u001a\u00020\u00002\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bJ\u0010\u0010\n\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lzendesk/ui/android/conversation/item/ItemGroupState$Builder;", "", "state", "Lzendesk/ui/android/conversation/item/ItemGroupState;", "(Lzendesk/ui/android/conversation/item/ItemGroupState;)V", "()V", "build", "items", "", "Lzendesk/ui/android/conversation/item/Item;", "pressedColor", "color", "", "titleColor", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ItemGroupState.kt */
    public static final class Builder {
        private ItemGroupState state;

        public Builder() {
            this.state = new ItemGroupState((List) null, (Integer) null, (Integer) null, 7, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(ItemGroupState itemGroupState) {
            this();
            Intrinsics.checkNotNullParameter(itemGroupState, "state");
            this.state = itemGroupState;
        }

        public final Builder items(List<? extends Item<?>> list) {
            Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
            Builder builder = this;
            this.state = ItemGroupState.copy$default(this.state, list, (Integer) null, (Integer) null, 6, (Object) null);
            return this;
        }

        public final Builder titleColor(int i) {
            Builder builder = this;
            this.state = ItemGroupState.copy$default(this.state, (List) null, Integer.valueOf(i), (Integer) null, 5, (Object) null);
            return this;
        }

        public final Builder pressedColor(int i) {
            Builder builder = this;
            this.state = ItemGroupState.copy$default(this.state, (List) null, (Integer) null, Integer.valueOf(i), 3, (Object) null);
            return this;
        }

        public final ItemGroupState build() {
            return this.state;
        }
    }
}
