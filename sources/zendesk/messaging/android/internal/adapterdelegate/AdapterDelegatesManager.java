package zendesk.messaging.android.internal.adapterdelegate;

import android.view.View;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001b*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u001b\u001cB%\u0012\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\"\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001b\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0002\u0010\u0010J5\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lzendesk/messaging/android/internal/adapterdelegate/AdapterDelegatesManager;", "T", "", "delegates", "", "Lzendesk/messaging/android/internal/adapterdelegate/AdapterDelegate;", "([Lzendesk/messaging/android/internal/adapterdelegate/AdapterDelegate;)V", "Landroidx/collection/SparseArrayCompat;", "addDelegate", "delegate", "getDelegateForViewType", "viewType", "", "getItemViewType", "items", "position", "(Ljava/lang/Object;I)I", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "payloads", "", "(Ljava/lang/Object;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "Companion", "DefaultViewHolder", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdapterDelegatesManager.kt */
public final class AdapterDelegatesManager<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "AdapterDelegatesManager";
    private static final List<Object> PAYLOADS_EMPTY_LIST = CollectionsKt.emptyList();
    private SparseArrayCompat<AdapterDelegate<T>> delegates = new SparseArrayCompat<>();

    public AdapterDelegatesManager(AdapterDelegate<T>... adapterDelegateArr) {
        Intrinsics.checkNotNullParameter(adapterDelegateArr, "delegates");
        for (AdapterDelegate<T> addDelegate : adapterDelegateArr) {
            addDelegate(addDelegate);
        }
    }

    private final AdapterDelegatesManager<T> addDelegate(AdapterDelegate<T> adapterDelegate) {
        int size = this.delegates.size();
        while (this.delegates.get(size) != null) {
            size++;
        }
        this.delegates.put(size, adapterDelegate);
        return this;
    }

    public final int getItemViewType(T t, int i) {
        String str;
        if (t == null) {
            Logger.e(LOG_TAG, "Items data source is null!", new Object[0]);
        }
        int size = this.delegates.size();
        for (int i2 = 0; i2 < size; i2++) {
            AdapterDelegate valueAt = this.delegates.valueAt(i2);
            boolean z = true;
            if (valueAt == null || !valueAt.isForViewType(t, i)) {
                z = false;
            }
            if (z) {
                return this.delegates.keyAt(i2);
            }
        }
        if (t instanceof List) {
            str = "No AdapterDelegate added that matches item=" + String.valueOf(((List) t).get(i)) + " at position=" + i + " in data source";
        } else {
            str = "No AdapterDelegate added for item at position=" + i + ". items=" + t;
        }
        Logger.e(LOG_TAG, str, new Object[0]);
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r3 = r3.onCreateViewHolder(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup r2, int r3) {
        /*
            r1 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            zendesk.messaging.android.internal.adapterdelegate.AdapterDelegate r3 = r1.getDelegateForViewType(r3)
            if (r3 == 0) goto L_0x0011
            androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = r3.onCreateViewHolder(r2)
            if (r3 != 0) goto L_0x001a
        L_0x0011:
            zendesk.messaging.android.internal.adapterdelegate.AdapterDelegatesManager$DefaultViewHolder r3 = new zendesk.messaging.android.internal.adapterdelegate.AdapterDelegatesManager$DefaultViewHolder
            android.view.View r2 = (android.view.View) r2
            r3.<init>(r2)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r3
        L_0x001a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.adapterdelegate.AdapterDelegatesManager.onCreateViewHolder(android.view.ViewGroup, int):androidx.recyclerview.widget.RecyclerView$ViewHolder");
    }

    public static /* synthetic */ void onBindViewHolder$default(AdapterDelegatesManager adapterDelegatesManager, Object obj, int i, RecyclerView.ViewHolder viewHolder, List<Object> list, int i2, Object obj2) {
        if ((i2 & 8) != 0) {
            list = PAYLOADS_EMPTY_LIST;
        }
        adapterDelegatesManager.onBindViewHolder(obj, i, viewHolder, list);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        r2 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(T r2, int r3, androidx.recyclerview.widget.RecyclerView.ViewHolder r4, java.util.List<? extends java.lang.Object> r5) {
        /*
            r1 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            int r0 = r4.getItemViewType()
            zendesk.messaging.android.internal.adapterdelegate.AdapterDelegate r0 = r1.getDelegateForViewType(r0)
            if (r0 == 0) goto L_0x0019
            if (r5 != 0) goto L_0x0013
            java.util.List<java.lang.Object> r5 = PAYLOADS_EMPTY_LIST
        L_0x0013:
            r0.onBindViewHolder(r2, r3, r4, r5)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L_0x001a
        L_0x0019:
            r2 = 0
        L_0x001a:
            if (r2 != 0) goto L_0x0045
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "No delegate found for item at position = "
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " for viewType = "
            java.lang.StringBuilder r2 = r2.append(r3)
            int r3 = r4.getItemViewType()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "AdapterDelegatesManager"
            zendesk.logger.Logger.e(r4, r2, r3)
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.adapterdelegate.AdapterDelegatesManager.onBindViewHolder(java.lang.Object, int, androidx.recyclerview.widget.RecyclerView$ViewHolder, java.util.List):void");
    }

    private final AdapterDelegate<T> getDelegateForViewType(int i) {
        return this.delegates.get(i);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lzendesk/messaging/android/internal/adapterdelegate/AdapterDelegatesManager$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AdapterDelegatesManager.kt */
    public static final class DefaultViewHolder extends RecyclerView.ViewHolder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DefaultViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lzendesk/messaging/android/internal/adapterdelegate/AdapterDelegatesManager$Companion;", "", "()V", "LOG_TAG", "", "PAYLOADS_EMPTY_LIST", "", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AdapterDelegatesManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
