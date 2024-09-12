package expo.modules.kotlin.activityresult;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: DataPersistor.kt */
final class DataPersistor$retrievedData$2 extends Lambda implements Function0<Bundle> {
    final /* synthetic */ DataPersistor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataPersistor$retrievedData$2(DataPersistor dataPersistor) {
        super(0);
        this.this$0 = dataPersistor;
    }

    public final Bundle invoke() {
        return this.this$0.retrieveData();
    }
}
