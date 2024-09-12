package zendesk.ui.android.conversation.item;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.ui.android.conversation.item.ItemRendering;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/item/ItemRendering;", "itemRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ItemGroupView.kt */
final class ItemGroupView$createItemView$1$1 extends Lambda implements Function1<ItemRendering, ItemRendering> {
    final /* synthetic */ Item<?> $item;
    final /* synthetic */ ItemGroupView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ItemGroupView$createItemView$1$1(Item<?> item, ItemGroupView itemGroupView) {
        super(1);
        this.$item = item;
        this.this$0 = itemGroupView;
    }

    public final ItemRendering invoke(ItemRendering itemRendering) {
        Intrinsics.checkNotNullParameter(itemRendering, "itemRendering");
        ItemRendering.Builder builder = itemRendering.toBuilder();
        final Item<?> item = this.$item;
        final ItemGroupView itemGroupView = this.this$0;
        ItemRendering.Builder state = builder.state(new Function1<ItemState, ItemState>() {
            public final ItemState invoke(ItemState itemState) {
                Intrinsics.checkNotNullParameter(itemState, "state");
                return itemState.copy(item, itemGroupView.rendering.getState$zendesk_ui_ui_android().getTitleColor$zendesk_ui_ui_android(), itemGroupView.rendering.getState$zendesk_ui_ui_android().getPressedColor$zendesk_ui_ui_android());
            }
        });
        Function1<Item<?>, Unit> onItemClicked$zendesk_ui_ui_android = this.this$0.rendering.getOnItemClicked$zendesk_ui_ui_android();
        if (onItemClicked$zendesk_ui_ui_android != null) {
            state.onItemClicked(onItemClicked$zendesk_ui_ui_android);
        }
        return state.build();
    }
}
