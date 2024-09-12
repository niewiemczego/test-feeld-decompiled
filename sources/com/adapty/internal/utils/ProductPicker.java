package com.adapty.internal.utils;

import com.adapty.internal.domain.models.BackendProduct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/utils/ProductPicker;", "", "()V", "pick", "", "Lcom/adapty/internal/domain/models/BackendProduct;", "source1", "source2", "requiredIds", "", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProductPicker.kt */
public final class ProductPicker {
    public final /* synthetic */ List pick(List list, List list2, Set set) {
        Intrinsics.checkNotNullParameter(list, "source1");
        Intrinsics.checkNotNullParameter(list2, "source2");
        Intrinsics.checkNotNullParameter(set, "requiredIds");
        Iterable iterable = list;
        Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(((BackendProduct) next).getVendorProductId(), next);
        }
        Iterable iterable2 = list2;
        Map linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable2, 10)), 16));
        for (Object next2 : iterable2) {
            linkedHashMap2.put(((BackendProduct) next2).getVendorProductId(), next2);
        }
        Collection arrayList = new ArrayList();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            BackendProduct backendProduct = (BackendProduct) linkedHashMap.get(str);
            BackendProduct backendProduct2 = (BackendProduct) linkedHashMap2.get(str);
            if (backendProduct == null && backendProduct2 == null) {
                backendProduct = null;
            } else if (backendProduct == null || (backendProduct2 != null && backendProduct.getTimestamp() < backendProduct2.getTimestamp())) {
                backendProduct = backendProduct2;
            }
            if (backendProduct != null) {
                arrayList.add(backendProduct);
            }
        }
        return (List) arrayList;
    }
}
