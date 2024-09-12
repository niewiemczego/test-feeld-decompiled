package com.launchdarkly.sdk.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class JsonSerialization {
    private static final Gson gson = new GsonBuilder().serializeNulls().create();
    static final List<Class<? extends JsonSerializable>> knownDeserializableClasses = new ArrayList();

    private JsonSerialization() {
    }

    public static <T extends JsonSerializable> String serialize(T t) {
        return serializeInternal(t);
    }

    static String serializeInternal(Object obj) {
        return gson.toJson(obj);
    }

    public static <T extends JsonSerializable> T deserialize(String str, Class<T> cls) throws SerializationException {
        return (JsonSerializable) deserializeInternal(str, cls);
    }

    static <T> T deserializeInternal(String str, Class<T> cls) throws SerializationException {
        if (str == null || str.isEmpty()) {
            throw new SerializationException("input string was null/empty");
        }
        try {
            return gson.fromJson(str, cls);
        } catch (Exception e) {
            throw new SerializationException((Throwable) e);
        }
    }

    static void serializeToGsonInternal(Object obj, Class<?> cls, GsonWriterAdapter gsonWriterAdapter) {
        gson.toJson(obj, (Type) cls, (JsonWriter) gsonWriterAdapter);
    }

    static <T> T deserializeFromGsonInternal(GsonReaderAdapter gsonReaderAdapter, Type type) {
        return gson.fromJson((JsonReader) gsonReaderAdapter, type);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(5:5|6|7|8|(2:11|9))|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x005f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.Iterable<java.lang.Class<? extends com.launchdarkly.sdk.json.JsonSerializable>> getDeserializableClasses() {
        /*
            java.util.List<java.lang.Class<? extends com.launchdarkly.sdk.json.JsonSerializable>> r0 = knownDeserializableClasses
            monitor-enter(r0)
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x0063 }
            if (r1 == 0) goto L_0x005f
            java.lang.Class<com.launchdarkly.sdk.AttributeRef> r1 = com.launchdarkly.sdk.AttributeRef.class
            r0.add(r1)     // Catch:{ all -> 0x0063 }
            java.lang.Class<com.launchdarkly.sdk.ContextKind> r1 = com.launchdarkly.sdk.ContextKind.class
            r0.add(r1)     // Catch:{ all -> 0x0063 }
            java.lang.Class<com.launchdarkly.sdk.EvaluationReason> r1 = com.launchdarkly.sdk.EvaluationReason.class
            r0.add(r1)     // Catch:{ all -> 0x0063 }
            java.lang.Class<com.launchdarkly.sdk.EvaluationDetail> r1 = com.launchdarkly.sdk.EvaluationDetail.class
            r0.add(r1)     // Catch:{ all -> 0x0063 }
            java.lang.Class<com.launchdarkly.sdk.LDContext> r1 = com.launchdarkly.sdk.LDContext.class
            r0.add(r1)     // Catch:{ all -> 0x0063 }
            java.lang.Class<com.launchdarkly.sdk.LDUser> r1 = com.launchdarkly.sdk.LDUser.class
            r0.add(r1)     // Catch:{ all -> 0x0063 }
            java.lang.Class<com.launchdarkly.sdk.LDValue> r1 = com.launchdarkly.sdk.LDValue.class
            r0.add(r1)     // Catch:{ all -> 0x0063 }
            java.lang.Class<com.launchdarkly.sdk.UserAttribute> r1 = com.launchdarkly.sdk.UserAttribute.class
            r0.add(r1)     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = "com.launchdarkly.sdk.json.SdkSerializationExtensions"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x005f }
            java.lang.String r2 = "getDeserializableClasses"
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x005f }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ Exception -> 0x005f }
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x005f }
            java.lang.Object r1 = r1.invoke(r2, r3)     // Catch:{ Exception -> 0x005f }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ Exception -> 0x005f }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x005f }
        L_0x004d:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x005f }
            if (r2 == 0) goto L_0x005f
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x005f }
            java.lang.Class r2 = (java.lang.Class) r2     // Catch:{ Exception -> 0x005f }
            java.util.List<java.lang.Class<? extends com.launchdarkly.sdk.json.JsonSerializable>> r3 = knownDeserializableClasses     // Catch:{ Exception -> 0x005f }
            r3.add(r2)     // Catch:{ Exception -> 0x005f }
            goto L_0x004d
        L_0x005f:
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            java.util.List<java.lang.Class<? extends com.launchdarkly.sdk.json.JsonSerializable>> r0 = knownDeserializableClasses
            return r0
        L_0x0063:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.json.JsonSerialization.getDeserializableClasses():java.lang.Iterable");
    }
}
