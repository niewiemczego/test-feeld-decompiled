package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
final class zzaa implements Continuation {
    final /* synthetic */ Collection zza;

    zzaa(Collection collection) {
        this.zza = collection;
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (Task result : this.zza) {
            arrayList.add(result.getResult());
        }
        return arrayList;
    }
}
