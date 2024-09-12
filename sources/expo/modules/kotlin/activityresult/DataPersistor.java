package expo.modules.kotlin.activityresult;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006J\u0016\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0013J&\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0015j\b\u0012\u0004\u0012\u00020\u0010`\u0016J\"\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00190\u0018J\"\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u0018J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u0010J\u001c\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u0010J\u001c\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lexpo/modules/kotlin/activityresult/DataPersistor;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "accumulator", "Landroid/os/Bundle;", "retrievedData", "getRetrievedData", "()Landroid/os/Bundle;", "retrievedData$delegate", "Lkotlin/Lazy;", "sharedPreferences", "Landroid/content/SharedPreferences;", "addBundle", "key", "", "value", "addSerializable", "Ljava/io/Serializable;", "addStringArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addStringToIntMap", "", "", "addStringToSerializableMap", "persist", "", "retrieveBundle", "retrieveData", "retrieveSerializable", "retrieveStringArrayList", "retrieveStringToIntMap", "retrieveStringToSerializableMap", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DataPersistor.kt */
public final class DataPersistor {
    private final Bundle accumulator = new Bundle();
    private final Lazy retrievedData$delegate = LazyKt.lazy(new DataPersistor$retrievedData$2(this));
    private final SharedPreferences sharedPreferences;

    public DataPersistor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("expo.modules.kotlin.PersistentDataManager", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "context.getSharedPrefere…r\", Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences2;
    }

    private final Bundle getRetrievedData() {
        return (Bundle) this.retrievedData$delegate.getValue();
    }

    public final DataPersistor addStringArrayList(String str, ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(arrayList, "value");
        DataPersistor dataPersistor = this;
        this.accumulator.putStringArrayList(str, arrayList);
        return this;
    }

    public final ArrayList<String> retrieveStringArrayList(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return getRetrievedData().getStringArrayList(str);
    }

    public final DataPersistor addStringToIntMap(String str, Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(map, "value");
        DataPersistor dataPersistor = this;
        Bundle bundle = this.accumulator;
        Object[] array = MapsKt.toList(map).toArray(new Pair[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Pair[] pairArr = (Pair[]) array;
        bundle.putBundle(str, BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
        return this;
    }

    public final Map<String, Integer> retrieveStringToIntMap(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Bundle bundle = getRetrievedData().getBundle(str);
        if (bundle == null) {
            return null;
        }
        Set keySet = bundle.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "keys");
        Iterable iterable = keySet;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(next, Integer.valueOf(bundle.getInt((String) next)));
        }
        return linkedHashMap;
    }

    public final DataPersistor addStringToSerializableMap(String str, Map<String, ? extends Serializable> map) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(map, "value");
        DataPersistor dataPersistor = this;
        Bundle bundle = this.accumulator;
        Object[] array = MapsKt.toList(map).toArray(new Pair[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Pair[] pairArr = (Pair[]) array;
        bundle.putBundle(str, BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
        return this;
    }

    public final Map<String, Serializable> retrieveStringToSerializableMap(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Bundle bundle = getRetrievedData().getBundle(str);
        if (bundle == null) {
            return null;
        }
        Set keySet = bundle.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "bundle\n          .keySet()");
        Iterable iterable = keySet;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            Map map = linkedHashMap;
            String str2 = (String) next;
            Serializable serializable = bundle.getSerializable(str2);
            if (serializable != null) {
                map.put(next, serializable);
            } else {
                throw new IllegalStateException("For a key '" + str2 + "' there should be a serializable class available");
            }
        }
        return linkedHashMap;
    }

    public final DataPersistor addBundle(String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(bundle, "value");
        DataPersistor dataPersistor = this;
        this.accumulator.putBundle(str, bundle);
        return this;
    }

    public final Bundle retrieveBundle(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return getRetrievedData().getBundle(str);
    }

    public final DataPersistor addSerializable(String str, Serializable serializable) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(serializable, "value");
        DataPersistor dataPersistor = this;
        this.accumulator.putSerializable(str, serializable);
        return this;
    }

    public final Serializable retrieveSerializable(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return getRetrievedData().getSerializable(str);
    }

    public final void persist() {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putString("bundle", DataPersistorKt.toBase64(this.accumulator));
        edit.putLong(DataPersistorKt.EXPIRE_KEY, new Date().getTime() + 300000);
        edit.commit();
    }

    /* access modifiers changed from: private */
    public final Bundle retrieveData() {
        String string;
        Bundle access$toBundle;
        Bundle bundle = new Bundle();
        if (!(this.sharedPreferences.getLong(DataPersistorKt.EXPIRE_KEY, 0) <= new Date().getTime() || (string = this.sharedPreferences.getString("bundle", (String) null)) == null || (access$toBundle = DataPersistorKt.toBundle(string)) == null)) {
            bundle = access$toBundle;
        }
        this.sharedPreferences.edit().clear().apply();
        return bundle;
    }
}
