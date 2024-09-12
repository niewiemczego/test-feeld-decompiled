package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor2) {
        this.constructorConstructor = constructorConstructor2;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: com.google.gson.internal.bind.TreeTypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: com.google.gson.TypeAdapter<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: com.google.gson.TypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.gson.internal.bind.TreeTypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: com.google.gson.internal.bind.TreeTypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: com.google.gson.internal.bind.TreeTypeAdapter} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.gson.TypeAdapter<?> getTypeAdapter(com.google.gson.internal.ConstructorConstructor r8, com.google.gson.Gson r9, com.google.gson.reflect.TypeToken<?> r10, com.google.gson.annotations.JsonAdapter r11) {
        /*
            r7 = this;
            java.lang.Class r0 = r11.value()
            com.google.gson.reflect.TypeToken r0 = com.google.gson.reflect.TypeToken.get(r0)
            com.google.gson.internal.ObjectConstructor r8 = r8.get(r0)
            java.lang.Object r8 = r8.construct()
            boolean r6 = r11.nullSafe()
            boolean r11 = r8 instanceof com.google.gson.TypeAdapter
            if (r11 == 0) goto L_0x001c
            com.google.gson.TypeAdapter r8 = (com.google.gson.TypeAdapter) r8
            goto L_0x0081
        L_0x001c:
            boolean r11 = r8 instanceof com.google.gson.TypeAdapterFactory
            if (r11 == 0) goto L_0x0027
            com.google.gson.TypeAdapterFactory r8 = (com.google.gson.TypeAdapterFactory) r8
            com.google.gson.TypeAdapter r8 = r8.create(r9, r10)
            goto L_0x0081
        L_0x0027:
            boolean r11 = r8 instanceof com.google.gson.JsonSerializer
            if (r11 != 0) goto L_0x0065
            boolean r0 = r8 instanceof com.google.gson.JsonDeserializer
            if (r0 == 0) goto L_0x0030
            goto L_0x0065
        L_0x0030:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Invalid attempt to bind an instance of "
            java.lang.StringBuilder r11 = r11.append(r0)
            java.lang.Class r8 = r8.getClass()
            java.lang.String r8 = r8.getName()
            java.lang.StringBuilder r8 = r11.append(r8)
            java.lang.String r11 = " as a @JsonAdapter for "
            java.lang.StringBuilder r8 = r8.append(r11)
            java.lang.String r10 = r10.toString()
            java.lang.StringBuilder r8 = r8.append(r10)
            java.lang.String r10 = ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer."
            java.lang.StringBuilder r8 = r8.append(r10)
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        L_0x0065:
            r0 = 0
            if (r11 == 0) goto L_0x006d
            r11 = r8
            com.google.gson.JsonSerializer r11 = (com.google.gson.JsonSerializer) r11
            r1 = r11
            goto L_0x006e
        L_0x006d:
            r1 = r0
        L_0x006e:
            boolean r11 = r8 instanceof com.google.gson.JsonDeserializer
            if (r11 == 0) goto L_0x0076
            com.google.gson.JsonDeserializer r8 = (com.google.gson.JsonDeserializer) r8
            r2 = r8
            goto L_0x0077
        L_0x0076:
            r2 = r0
        L_0x0077:
            com.google.gson.internal.bind.TreeTypeAdapter r8 = new com.google.gson.internal.bind.TreeTypeAdapter
            r5 = 0
            r0 = r8
            r3 = r9
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r6 = 0
        L_0x0081:
            if (r8 == 0) goto L_0x0089
            if (r6 == 0) goto L_0x0089
            com.google.gson.TypeAdapter r8 = r8.nullSafe()
        L_0x0089:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory.getTypeAdapter(com.google.gson.internal.ConstructorConstructor, com.google.gson.Gson, com.google.gson.reflect.TypeToken, com.google.gson.annotations.JsonAdapter):com.google.gson.TypeAdapter");
    }
}
