package com.shopify.reactnative.flash_list;

import android.content.Context;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/shopify/reactnative/flash_list/CellContainerImpl;", "Lcom/facebook/react/views/view/ReactViewGroup;", "Lcom/shopify/reactnative/flash_list/CellContainer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "index", "", "getIndex", "setIndex", "", "value", "shopify_flash-list_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CellContainerImpl.kt */
public final class CellContainerImpl extends ReactViewGroup implements CellContainer {
    private int index = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CellContainerImpl(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }
}
