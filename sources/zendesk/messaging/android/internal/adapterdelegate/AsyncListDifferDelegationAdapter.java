package zendesk.messaging.android.internal.adapterdelegate;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rH\u0016R \u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lzendesk/messaging/android/internal/adapterdelegate/AsyncListDifferDelegationAdapter;", "T", "Landroidx/recyclerview/widget/ListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "delegatesManager", "Lzendesk/messaging/android/internal/adapterdelegate/AdapterDelegatesManager;", "", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lzendesk/messaging/android/internal/adapterdelegate/AdapterDelegatesManager;)V", "getDelegatesManager", "()Lzendesk/messaging/android/internal/adapterdelegate/AdapterDelegatesManager;", "getItemViewType", "", "position", "onBindViewHolder", "", "holder", "payloads", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AsyncListDifferDelegationAdapter.kt */
public class AsyncListDifferDelegationAdapter<T> extends ListAdapter<T, RecyclerView.ViewHolder> {
    private final AdapterDelegatesManager<List<T>> delegatesManager;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AsyncListDifferDelegationAdapter(DiffUtil.ItemCallback itemCallback, AdapterDelegatesManager adapterDelegatesManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemCallback, (i & 2) != 0 ? new AdapterDelegatesManager(new AdapterDelegate[0]) : adapterDelegatesManager);
    }

    /* access modifiers changed from: protected */
    public final AdapterDelegatesManager<List<T>> getDelegatesManager() {
        return this.delegatesManager;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AsyncListDifferDelegationAdapter(DiffUtil.ItemCallback<T> itemCallback, AdapterDelegatesManager<List<T>> adapterDelegatesManager) {
        super(itemCallback);
        Intrinsics.checkNotNullParameter(itemCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(adapterDelegatesManager, "delegatesManager");
        this.delegatesManager = adapterDelegatesManager;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return this.delegatesManager.onCreateViewHolder(viewGroup, i);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        AdapterDelegatesManager<List<T>> adapterDelegatesManager = this.delegatesManager;
        List currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "currentList");
        adapterDelegatesManager.onBindViewHolder(currentList, i, viewHolder, (List<? extends Object>) null);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        AdapterDelegatesManager<List<T>> adapterDelegatesManager = this.delegatesManager;
        List currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "currentList");
        adapterDelegatesManager.onBindViewHolder(currentList, i, viewHolder, list);
    }

    public int getItemViewType(int i) {
        AdapterDelegatesManager<List<T>> adapterDelegatesManager = this.delegatesManager;
        List currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "currentList");
        return adapterDelegatesManager.getItemViewType(currentList, i);
    }
}
