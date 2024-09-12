package zendesk.ui.android.conversation.item;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001eB-\b\u0000\u0012\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0003HÀ\u0003¢\u0006\u0002\b\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0004\b\u0011\u0010\u000bJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0004\b\u0013\u0010\u000bJ4\u0010\u0014\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000b¨\u0006\u001f"}, d2 = {"Lzendesk/ui/android/conversation/item/ItemState;", "", "item", "Lzendesk/ui/android/conversation/item/Item;", "titleColor", "", "pressedColor", "(Lzendesk/ui/android/conversation/item/Item;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getItem$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/item/Item;", "getPressedColor$zendesk_ui_ui_android", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitleColor$zendesk_ui_ui_android", "component1", "component1$zendesk_ui_ui_android", "component2", "component2$zendesk_ui_ui_android", "component3", "component3$zendesk_ui_ui_android", "copy", "(Lzendesk/ui/android/conversation/item/Item;Ljava/lang/Integer;Ljava/lang/Integer;)Lzendesk/ui/android/conversation/item/ItemState;", "equals", "", "other", "hashCode", "toBuilder", "Lzendesk/ui/android/conversation/item/ItemState$Builder;", "toString", "", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ItemState.kt */
public final class ItemState {
    private final Item<?> item;
    private final Integer pressedColor;
    private final Integer titleColor;

    public ItemState() {
        this((Item) null, (Integer) null, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ItemState copy$default(ItemState itemState, Item<?> item2, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            item2 = itemState.item;
        }
        if ((i & 2) != 0) {
            num = itemState.titleColor;
        }
        if ((i & 4) != 0) {
            num2 = itemState.pressedColor;
        }
        return itemState.copy(item2, num, num2);
    }

    public final Item<?> component1$zendesk_ui_ui_android() {
        return this.item;
    }

    public final Integer component2$zendesk_ui_ui_android() {
        return this.titleColor;
    }

    public final Integer component3$zendesk_ui_ui_android() {
        return this.pressedColor;
    }

    public final ItemState copy(Item<?> item2, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(item2, "item");
        return new ItemState(item2, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ItemState)) {
            return false;
        }
        ItemState itemState = (ItemState) obj;
        return Intrinsics.areEqual((Object) this.item, (Object) itemState.item) && Intrinsics.areEqual((Object) this.titleColor, (Object) itemState.titleColor) && Intrinsics.areEqual((Object) this.pressedColor, (Object) itemState.pressedColor);
    }

    public int hashCode() {
        int hashCode = this.item.hashCode() * 31;
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
        return "ItemState(item=" + this.item + ", titleColor=" + this.titleColor + ", pressedColor=" + this.pressedColor + ')';
    }

    public ItemState(Item<?> item2, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(item2, "item");
        this.item = item2;
        this.titleColor = num;
        this.pressedColor = num2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemState(Item item2, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Item((String) null, (String) null, (Integer) null, (String) null, (Object) null, 31, (DefaultConstructorMarker) null) : item2, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2);
    }

    public final Item<?> getItem$zendesk_ui_ui_android() {
        return this.item;
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

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0003J\u0012\u0010\u0007\u001a\u00020\u00002\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bJ\u0010\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lzendesk/ui/android/conversation/item/ItemState$Builder;", "", "state", "Lzendesk/ui/android/conversation/item/ItemState;", "(Lzendesk/ui/android/conversation/item/ItemState;)V", "()V", "build", "item", "Lzendesk/ui/android/conversation/item/Item;", "pressedColor", "color", "", "titleColor", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ItemState.kt */
    public static final class Builder {
        private ItemState state;

        public Builder() {
            this.state = new ItemState((Item) null, (Integer) null, (Integer) null, 7, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(ItemState itemState) {
            this();
            Intrinsics.checkNotNullParameter(itemState, "state");
            this.state = itemState;
        }

        public final Builder item(Item<?> item) {
            Intrinsics.checkNotNullParameter(item, "item");
            Builder builder = this;
            this.state = ItemState.copy$default(this.state, item, (Integer) null, (Integer) null, 6, (Object) null);
            return this;
        }

        public final Builder titleColor(int i) {
            Builder builder = this;
            this.state = ItemState.copy$default(this.state, (Item) null, Integer.valueOf(i), (Integer) null, 5, (Object) null);
            return this;
        }

        public final Builder pressedColor(int i) {
            Builder builder = this;
            this.state = ItemState.copy$default(this.state, (Item) null, (Integer) null, Integer.valueOf(i), 3, (Object) null);
            return this;
        }

        public final ItemState build() {
            return this.state;
        }
    }
}
