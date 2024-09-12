package com.adapty.internal.data.cloud;

import com.adapty.internal.data.models.PurchaseRecordModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/adapty/internal/data/models/PurchaseRecordModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: StoreManager.kt */
final class StoreManager$getPurchaseHistoryDataToRestoreForType$1 extends Lambda implements Function0<Flow<? extends List<? extends PurchaseRecordModel>>> {
    final /* synthetic */ String $type;
    final /* synthetic */ StoreManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StoreManager$getPurchaseHistoryDataToRestoreForType$1(StoreManager storeManager, String str) {
        super(0);
        this.this$0 = storeManager;
        this.$type = str;
    }

    public final Flow<List<PurchaseRecordModel>> invoke() {
        return new StoreManager$getPurchaseHistoryDataToRestoreForType$1$invoke$$inlined$map$1(this.this$0.storeHelper.queryAllPurchasesForType(this.$type), this.$type);
    }
}
