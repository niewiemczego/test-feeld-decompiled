package com.braze.support;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005\u001a2\u0010\n\u001a\u0004\u0018\u0001H\u000b\"\u0010\b\u0000\u0010\u000b\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u000b0\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0001H\b¢\u0006\u0002\u0010\u000f\u001a8\u0010\n\u001a\u0002H\u000b\"\u0010\b\u0000\u0010\u000b\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u000b0\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u0002H\u000bH\b¢\u0006\u0002\u0010\u0011\u001aC\u0010\n\u001a\u0002H\u000b\"\u0010\b\u0000\u0010\u000b*\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00132\u0006\u0010\u0010\u001a\u0002H\u000b¢\u0006\u0002\u0010\u0014\u001a\u001b\u0010\u0015\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0017*\b\u0012\u0004\u0012\u0002H\u00170\u0018¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u0015\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0017*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001b0\u001a\u001a\u0018\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001d*\u0004\u0018\u00010\u0005\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001f*\u0004\u0018\u00010\u0016\u001a\n\u0010 \u001a\u00020\u0005*\u00020\u0005\u001a\u001d\u0010!\u001a\u0004\u0018\u00010\"*\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010#\u001a\u001b\u0010$\u001a\u0004\u0018\u00010%*\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010&\u001a\u0016\u0010'\u001a\u0004\u0018\u00010\u0001*\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001\u001a\f\u0010(\u001a\u00020\u0001*\u0004\u0018\u00010\u0016\u001a\f\u0010(\u001a\u00020\u0001*\u0004\u0018\u00010\u0005\u001a\u0016\u0010)\u001a\u00020\u0003*\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u001a\u001d\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00170+\"\u0006\b\u0000\u0010\u0017\u0018\u0001*\u0004\u0018\u00010\u0016H\n\u001a\u001b\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00170+\"\u0006\b\u0000\u0010\u0017\u0018\u0001*\u00020\u0005H\n\u001a\f\u0010,\u001a\u00020-*\u0004\u0018\u00010\u0001\u001a\u0015\u0010.\u001a\u00020\u0005*\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"TAG", "", "areJsonObjectsEqual", "", "target", "Lorg/json/JSONObject;", "source", "mergeJsonObjects", "oldJson", "newJson", "optEnum", "TargetEnum", "", "jsonObject", "key", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Enum;", "defaultEnum", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Enum;)Ljava/lang/Enum;", "targetEnumClass", "Ljava/lang/Class;", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Enum;)Ljava/lang/Enum;", "constructJsonArray", "Lorg/json/JSONArray;", "T", "", "([Ljava/lang/Object;)Lorg/json/JSONArray;", "", "Lcom/braze/models/IPutIntoJson;", "convertJSONObjectToMap", "", "convertStringJsonArrayToList", "", "deepcopy", "getColorIntegerOrNull", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "getDoubleOrNull", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Double;", "getOptionalString", "getPrettyPrintedString", "isEqualTo", "iterator", "", "parseJsonObjectIntoBundle", "Landroid/os/Bundle;", "plus", "otherJson", "android-sdk-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class JsonUtils {
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("JsonUtils");

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ int b;
        final /* synthetic */ JSONArray c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(int i, JSONArray jSONArray) {
            super(0);
            this.b = i;
            this.c = jSONArray;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get string for item at index: " + this.b + " and array: " + this.c;
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to retrieve color integer from JSON";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught Throwable while generating pretty printed json. Returning blank string.";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught Throwable while generating pretty printed json. Returning blank string.";
        }
    }

    public static final class e extends Lambda implements Function1 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(JSONArray jSONArray) {
            super(1);
            this.b = jSONArray;
        }

        public final Boolean a(int i) {
            Object opt = this.b.opt(i);
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            return Boolean.valueOf(opt instanceof Object);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static final class f extends Lambda implements Function1 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(JSONArray jSONArray) {
            super(1);
            this.b = jSONArray;
        }

        public final Object a(int i) {
            Object obj = this.b.get(i);
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return obj;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static final class g extends Lambda implements Function1 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(JSONObject jSONObject) {
            super(1);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final Boolean invoke(String str) {
            Object opt = this.b.opt(str);
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            return Boolean.valueOf(opt instanceof Object);
        }
    }

    public static final class h extends Lambda implements Function1 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(JSONObject jSONObject) {
            super(1);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final Object invoke(String str) {
            Object obj = this.b.get(str);
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return obj;
        }
    }

    static final class i extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception merging JSON for old key " + this.b;
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception merging JSON for new key " + this.b;
        }
    }

    static final class k extends Lambda implements Function0 {
        public static final k b = new k();

        k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unable parse JSON into a bundle.";
        }
    }

    public static final boolean areJsonObjectsEqual(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length()) {
            return false;
        }
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "target.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject2.has(next)) {
                return false;
            }
            Object opt = jSONObject.opt(next);
            Object opt2 = jSONObject2.opt(next);
            if (!(opt instanceof JSONObject) || !(opt2 instanceof JSONObject)) {
                if (!(opt == null || opt2 == null || Intrinsics.areEqual(opt, opt2))) {
                    return false;
                }
            } else if (!isEqualTo((JSONObject) opt, (JSONObject) opt2)) {
                return false;
            }
        }
        return true;
    }

    public static final <T> JSONArray constructJsonArray(Collection<? extends IPutIntoJson<T>> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        JSONArray jSONArray = new JSONArray();
        for (IPutIntoJson forJsonPut : collection) {
            jSONArray.put(forJsonPut.forJsonPut());
        }
        return jSONArray;
    }

    public static final Map<String, String> convertJSONObjectToMap(JSONObject jSONObject) {
        if (jSONObject == null) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "this.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkNotNullExpressionValue(next, "key");
            String string = jSONObject.getString(next);
            Intrinsics.checkNotNullExpressionValue(string, "this.getString(key)");
            linkedHashMap.put(next, string);
        }
        return linkedHashMap;
    }

    public static final List<String> convertStringJsonArrayToList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                String string = jSONArray.getString(i2);
                Intrinsics.checkNotNullExpressionValue(string, "this.getString(i)");
                arrayList.add(string);
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog(TAG, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new a(i2, jSONArray));
            }
        }
        return arrayList;
    }

    public static final JSONObject deepcopy(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        return new JSONObject(jSONObject.toString());
    }

    public static final Integer getColorIntegerOrNull(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (str == null || !jSONObject.has(str)) {
            return null;
        }
        try {
            return Integer.valueOf(jSONObject.getInt(str));
        } catch (Throwable th) {
            BrazeLogger.INSTANCE.brazelog(TAG, BrazeLogger.Priority.E, th, (Function0<String>) b.b);
            return null;
        }
    }

    public static final Double getDoubleOrNull(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return Double.valueOf(jSONObject.optDouble(str));
    }

    public static final String getOptionalString(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str);
    }

    public static final boolean isEqualTo(JSONObject jSONObject, JSONObject jSONObject2) {
        return areJsonObjectsEqual(jSONObject, jSONObject2);
    }

    public static final JSONObject mergeJsonObjects(JSONObject jSONObject, JSONObject jSONObject2) {
        Intrinsics.checkNotNullParameter(jSONObject, "oldJson");
        Intrinsics.checkNotNullParameter(jSONObject2, "newJson");
        JSONObject jSONObject3 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "oldJson.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject3.put(next, jSONObject.get(next));
            } catch (JSONException e2) {
                BrazeLogger.INSTANCE.brazelog(TAG, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new i(next));
            }
        }
        Iterator<String> keys2 = jSONObject2.keys();
        Intrinsics.checkNotNullExpressionValue(keys2, "newJson.keys()");
        while (keys2.hasNext()) {
            String next2 = keys2.next();
            try {
                jSONObject3.put(next2, jSONObject2.get(next2));
            } catch (JSONException e3) {
                BrazeLogger.INSTANCE.brazelog(TAG, BrazeLogger.Priority.E, (Throwable) e3, (Function0<String>) new j(next2));
            }
        }
        return jSONObject3;
    }

    public static final <TargetEnum extends Enum<TargetEnum>> TargetEnum optEnum(JSONObject jSONObject, String str, Class<TargetEnum> cls, TargetEnum targetenum) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cls, "targetEnumClass");
        try {
            String string = jSONObject.getString(str);
            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            String upperCase = string.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            TargetEnum a2 = c.a(upperCase, (Class) cls);
            return a2 == null ? targetenum : a2;
        } catch (Exception unused) {
            return targetenum;
        }
    }

    public static final Bundle parseJsonObjectIntoBundle(String str) {
        Bundle bundle = new Bundle();
        if (str == null || StringsKt.isBlank(str)) {
            return bundle;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.getString(next));
            }
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog(TAG, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) k.b);
        }
        return bundle;
    }

    public static final JSONObject plus(JSONObject jSONObject, JSONObject jSONObject2) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(jSONObject2, "otherJson");
        return mergeJsonObjects(jSONObject, jSONObject2);
    }

    public static final String getPrettyPrintedString(JSONObject jSONObject) {
        String str = "";
        if (jSONObject != null) {
            try {
                str = jSONObject.toString(2);
            } catch (Throwable th) {
                BrazeLogger.INSTANCE.brazelog(TAG, BrazeLogger.Priority.E, th, (Function0<String>) c.b);
            }
            Intrinsics.checkNotNullExpressionValue(str, "try {\n        this.toStr…ring.\" }\n        \"\"\n    }");
        }
        return str;
    }

    public static final <T> JSONArray constructJsonArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        JSONArray jSONArray = new JSONArray();
        for (T put : tArr) {
            jSONArray.put((Object) put);
        }
        return jSONArray;
    }

    public static final String getPrettyPrintedString(JSONArray jSONArray) {
        String str = "";
        if (jSONArray != null) {
            try {
                str = jSONArray.toString(2);
            } catch (Throwable th) {
                BrazeLogger.INSTANCE.brazelog(TAG, BrazeLogger.Priority.E, th, (Function0<String>) d.b);
            }
            Intrinsics.checkNotNullExpressionValue(str, "try {\n        this.toStr…ring.\" }\n        \"\"\n    }");
        }
        return str;
    }

    public static final /* synthetic */ <TargetEnum extends Enum<TargetEnum>> TargetEnum optEnum(JSONObject jSONObject, String str, TargetEnum targetenum) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(targetenum, "defaultEnum");
        try {
            c cVar = c.a;
            String string = jSONObject.getString(str);
            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
            String str2 = string;
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            Locale locale2 = locale;
            Intrinsics.checkNotNullExpressionValue(string.toUpperCase(locale), "this as java.lang.String).toUpperCase(locale)");
            Intrinsics.reifiedOperationMarker(5, "TargetEnum");
            Enum[] enumArr = new Enum[0];
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (Exception unused) {
            Enum enumR = (Enum) targetenum;
            return targetenum;
        }
    }

    public static final /* synthetic */ <TargetEnum extends Enum<TargetEnum>> TargetEnum optEnum(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            c cVar = c.a;
            String string = jSONObject.getString(str);
            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
            String str2 = string;
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            Locale locale2 = locale;
            Intrinsics.checkNotNullExpressionValue(string.toUpperCase(locale), "this as java.lang.String).toUpperCase(locale)");
            Intrinsics.reifiedOperationMarker(5, "TargetEnum");
            Enum[] enumArr = new Enum[0];
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (Exception unused) {
            Enum enumR = null;
            return null;
        }
    }

    public static final /* synthetic */ <T> Iterator<T> iterator(JSONArray jSONArray) {
        if (jSONArray == null) {
            return CollectionsKt.emptyList().iterator();
        }
        Sequence asSequence = CollectionsKt.asSequence(RangesKt.until(0, jSONArray.length()));
        Intrinsics.needClassReification();
        Sequence filter = SequencesKt.filter(asSequence, new e(jSONArray));
        Intrinsics.needClassReification();
        return SequencesKt.map(filter, new f(jSONArray)).iterator();
    }

    public static final /* synthetic */ <T> Iterator<T> iterator(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "this.keys()");
        Sequence<T> asSequence = SequencesKt.asSequence(keys);
        Intrinsics.needClassReification();
        Sequence<T> filter = SequencesKt.filter(asSequence, new g(jSONObject));
        Intrinsics.needClassReification();
        return SequencesKt.map(filter, new h(jSONObject)).iterator();
    }
}
