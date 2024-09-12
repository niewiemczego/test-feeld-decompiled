package zendesk.messaging.android.internal.adapterdelegate;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u0002H\u0002*\u0004\b\u0001\u0010\u0002*\b\b\u0002\u0010\u0003*\u00020\u00042\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00060\u0005B\u0005¢\u0006\u0002\u0010\u0007J+\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\f\u001a\u00020\rH$¢\u0006\u0002\u0010\u000eJ\u001e\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J-\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00022\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0006H$¢\u0006\u0002\u0010\u0014J6\u0010\u000f\u001a\u00020\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0006H\u0016J\u0015\u0010\u0015\u001a\u00028\u00022\u0006\u0010\u0016\u001a\u00020\u0017H&¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"Lzendesk/messaging/android/internal/adapterdelegate/ListItemAdapterDelegate;", "I", "T", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lzendesk/messaging/android/internal/adapterdelegate/AdapterDelegate;", "", "()V", "isForViewType", "", "item", "items", "position", "", "(Ljava/lang/Object;Ljava/util/List;I)Z", "onBindViewHolder", "", "holder", "payloads", "", "(Ljava/lang/Object;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListItemAdapterDelegate.kt */
public abstract class ListItemAdapterDelegate<I extends T, T, VH extends RecyclerView.ViewHolder> extends AdapterDelegate<List<? extends T>> {
    /* access modifiers changed from: protected */
    public abstract boolean isForViewType(T t, List<? extends T> list, int i);

    /* access modifiers changed from: protected */
    public abstract void onBindViewHolder(I i, VH vh, List<? extends Object> list);

    public abstract VH onCreateViewHolder(ViewGroup viewGroup);

    public boolean isForViewType(List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "item");
        return isForViewType(list.get(i), list, i);
    }

    public void onBindViewHolder(List<? extends T> list, int i, RecyclerView.ViewHolder viewHolder, List<? extends Object> list2) {
        Intrinsics.checkNotNullParameter(list, "item");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(list2, "payloads");
        onBindViewHolder(list.get(i), viewHolder, list2);
    }
}
