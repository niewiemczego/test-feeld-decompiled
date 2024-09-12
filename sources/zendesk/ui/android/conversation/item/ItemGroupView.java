package zendesk.ui.android.conversation.item;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.internal.ViewKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002J\u001c\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0016H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lzendesk/ui/android/conversation/item/ItemGroupView;", "Landroid/widget/FrameLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/item/ItemGroupRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "itemContainer", "Landroid/widget/LinearLayout;", "rendering", "createItemView", "Landroid/view/View;", "item", "Lzendesk/ui/android/conversation/item/Item;", "render", "", "renderingUpdate", "Lkotlin/Function1;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ItemGroupView.kt */
public final class ItemGroupView extends FrameLayout implements Renderer<ItemGroupRendering> {
    private final LinearLayout itemContainer;
    /* access modifiers changed from: private */
    public ItemGroupRendering rendering;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ItemGroupView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ItemGroupView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ItemGroupView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemGroupView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemGroupView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new ItemGroupRendering();
        FrameLayout.inflate(context, R.layout.zuia_view_item_group, this);
        View findViewById = findViewById(R.id.zuia_item_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zuia_item_container)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.itemContainer = linearLayout;
        linearLayout.setClipToOutline(true);
        context.getTheme().resolveAttribute(R.attr.colorOnSurface, new TypedValue(), true);
        ViewKt.outlinedBoxBackground$default(linearLayout, 0, 0.0f, 0.0f, 7, (Object) null);
        render(AnonymousClass1.INSTANCE);
    }

    public void render(Function1<? super ItemGroupRendering, ItemGroupRendering> function1) {
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        this.rendering = function1.invoke(this.rendering);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.zuia_divider_size);
        Item item = (Item) CollectionsKt.lastOrNull(this.rendering.getState$zendesk_ui_ui_android().getItems$zendesk_ui_ui_android());
        this.itemContainer.removeAllViews();
        for (Item next : this.rendering.getState$zendesk_ui_ui_android().getItems$zendesk_ui_ui_android()) {
            this.itemContainer.addView(createItemView(next));
            if (!Intrinsics.areEqual((Object) next, (Object) item)) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.zuia_view_divider, this, false);
                ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = null;
                ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                if (marginLayoutParams2 != null) {
                    marginLayoutParams2.setMarginStart(dimensionPixelSize);
                    marginLayoutParams2.setMarginEnd(dimensionPixelSize);
                    marginLayoutParams = marginLayoutParams2;
                }
                inflate.setLayoutParams(marginLayoutParams);
                this.itemContainer.addView(inflate);
            } else {
                return;
            }
        }
    }

    private final View createItemView(Item<?> item) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ItemView itemView = new ItemView(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        itemView.render(new ItemGroupView$createItemView$1$1(item, this));
        return itemView;
    }
}
