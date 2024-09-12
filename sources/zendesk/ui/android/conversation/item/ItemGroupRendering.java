package zendesk.ui.android.conversation.item;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0011\u001a\u00020\u0004R0\u0010\u0006\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\b\u0012\u0002\b\u0003\u0018\u0001`\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lzendesk/ui/android/conversation/item/ItemGroupRendering;", "", "()V", "builder", "Lzendesk/ui/android/conversation/item/ItemGroupRendering$Builder;", "(Lzendesk/ui/android/conversation/item/ItemGroupRendering$Builder;)V", "onItemClicked", "Lkotlin/Function1;", "Lzendesk/ui/android/conversation/item/Item;", "", "Lzendesk/ui/android/conversation/item/OnClickLambda;", "getOnItemClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function1;", "state", "Lzendesk/ui/android/conversation/item/ItemGroupState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/item/ItemGroupState;", "toBuilder", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ItemGroupRendering.kt */
public final class ItemGroupRendering {
    private final Function1<Item<?>, Unit> onItemClicked;
    private final ItemGroupState state;

    public ItemGroupRendering(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.onItemClicked = builder.getOnItemClicked$zendesk_ui_ui_android();
        this.state = builder.getState$zendesk_ui_ui_android();
    }

    public final Function1<Item<?>, Unit> getOnItemClicked$zendesk_ui_ui_android() {
        return this.onItemClicked;
    }

    public final ItemGroupState getState$zendesk_ui_ui_android() {
        return this.state;
    }

    public ItemGroupRendering() {
        this(new Builder());
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0003J4\u0010\u0006\u001a\u00020\u0000\"\b\b\u0000\u0010\u0016*\u00020\u00012\"\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\b\u0012\u0004\u0012\u00020\t0\u0007j\b\u0012\u0004\u0012\u0002H\u0016`\nJ\u001a\u0010\u000f\u001a\u00020\u00002\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0007R6\u0010\u0006\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\b\u0012\u0002\b\u0003\u0018\u0001`\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lzendesk/ui/android/conversation/item/ItemGroupRendering$Builder;", "", "rendering", "Lzendesk/ui/android/conversation/item/ItemGroupRendering;", "(Lzendesk/ui/android/conversation/item/ItemGroupRendering;)V", "()V", "onItemClicked", "Lkotlin/Function1;", "Lzendesk/ui/android/conversation/item/Item;", "", "Lzendesk/ui/android/conversation/item/OnClickLambda;", "getOnItemClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function1;", "setOnItemClicked$zendesk_ui_ui_android", "(Lkotlin/jvm/functions/Function1;)V", "state", "Lzendesk/ui/android/conversation/item/ItemGroupState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/item/ItemGroupState;", "setState$zendesk_ui_ui_android", "(Lzendesk/ui/android/conversation/item/ItemGroupState;)V", "build", "T", "stateUpdate", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ItemGroupRendering.kt */
    public static final class Builder {
        private Function1<? super Item<?>, Unit> onItemClicked;
        private ItemGroupState state;

        public Builder() {
            this.state = new ItemGroupState((List) null, (Integer) null, (Integer) null, 7, (DefaultConstructorMarker) null);
        }

        public final Function1<Item<?>, Unit> getOnItemClicked$zendesk_ui_ui_android() {
            return this.onItemClicked;
        }

        public final void setOnItemClicked$zendesk_ui_ui_android(Function1<? super Item<?>, Unit> function1) {
            this.onItemClicked = function1;
        }

        public final ItemGroupState getState$zendesk_ui_ui_android() {
            return this.state;
        }

        public final void setState$zendesk_ui_ui_android(ItemGroupState itemGroupState) {
            Intrinsics.checkNotNullParameter(itemGroupState, "<set-?>");
            this.state = itemGroupState;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(ItemGroupRendering itemGroupRendering) {
            this();
            Intrinsics.checkNotNullParameter(itemGroupRendering, "rendering");
            this.onItemClicked = itemGroupRendering.getOnItemClicked$zendesk_ui_ui_android();
            this.state = itemGroupRendering.getState$zendesk_ui_ui_android();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(ItemGroupRendering itemGroupRendering, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ItemGroupRendering() : itemGroupRendering);
        }

        public final <T> Builder onItemClicked(Function1<? super Item<T>, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onItemClicked");
            Builder builder = this;
            this.onItemClicked = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1);
            return this;
        }

        public final Builder state(Function1<? super ItemGroupState, ItemGroupState> function1) {
            Intrinsics.checkNotNullParameter(function1, "stateUpdate");
            Builder builder = this;
            this.state = function1.invoke(this.state);
            return this;
        }

        public final ItemGroupRendering build() {
            return new ItemGroupRendering(this);
        }
    }
}
