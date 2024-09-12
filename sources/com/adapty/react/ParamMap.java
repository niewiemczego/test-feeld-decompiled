package com.adapty.react;

import androidx.exifinterface.media.ExifInterface;
import com.adapty.react.BridgeError;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\b¢\u0006\u0002\u0010\u000bJ\"\u0010\f\u001a\u0002H\b\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\b¢\u0006\u0002\u0010\u000bJL\u0010\f\u001a\u0002H\b\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2%\u0010\r\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u0001H\b0\u000eH\bø\u0001\u0000¢\u0006\u0002\u0010\u0013J \u0010\u0014\u001a\u0004\u0018\u0001H\b\"\u0006\b\u0000\u0010\b\u0018\u00012\u0006\u0010\t\u001a\u00020\nH\b¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u0015\u001a\u0002H\b\"\u0006\b\u0000\u0010\b\u0018\u00012\u0006\u0010\t\u001a\u00020\nH\b¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0016"}, d2 = {"Lcom/adapty/react/ParamMap;", "", "dict", "Lcom/facebook/react/bridge/ReadableMap;", "(Lcom/facebook/react/bridge/ReadableMap;)V", "getDict", "()Lcom/facebook/react/bridge/ReadableMap;", "getDecodedOptionalValue", "T", "key", "Lcom/adapty/react/ParamKey;", "(Lcom/adapty/react/ParamKey;)Ljava/lang/Object;", "getDecodedValue", "decoder", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "str", "(Lcom/adapty/react/ParamKey;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOptionalValue", "getRequiredValue", "react-native-adapty_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdaptyParamMap.kt */
public final class ParamMap {
    private final ReadableMap dict;

    public ParamMap(ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(readableMap, "dict");
        this.dict = readableMap;
    }

    public final ReadableMap getDict() {
        return this.dict;
    }

    public final /* synthetic */ <T> T getRequiredValue(ParamKey paramKey) {
        T t;
        Intrinsics.checkNotNullParameter(paramKey, "key");
        if (getDict().hasKey(paramKey.getValue())) {
            String value = paramKey.getValue();
            T t2 = null;
            if (getDict().hasKey(value)) {
                Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    T valueOf = Boolean.valueOf(getDict().getBoolean(value));
                    Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
                    t = (Object) valueOf;
                } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(String.class))) {
                    T string = getDict().getString(value);
                    Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
                    t = (Object) string;
                } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    T valueOf2 = Integer.valueOf(getDict().getInt(value));
                    Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                    t = (Object) valueOf2;
                } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    T valueOf3 = Double.valueOf(getDict().getDouble(value));
                    Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                    t = (Object) valueOf3;
                }
                t2 = t;
            }
            if (t2 != null) {
                return t2;
            }
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            String simpleName = Reflection.getOrCreateKotlinClass(Object.class).getSimpleName();
            if (simpleName == null) {
                simpleName = "UnknownType";
            }
            throw new BridgeError.TypeMismatch(paramKey, simpleName);
        }
        throw new BridgeError.MissingRequiredArgument(paramKey);
    }

    public final /* synthetic */ <T> T getOptionalValue(ParamKey paramKey) {
        Intrinsics.checkNotNullParameter(paramKey, "key");
        String value = paramKey.getValue();
        if (!getDict().hasKey(value)) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            T valueOf = Boolean.valueOf(getDict().getBoolean(value));
            Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
            return (Object) valueOf;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(String.class))) {
            T string = getDict().getString(value);
            Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
            return (Object) string;
        } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            T valueOf2 = Integer.valueOf(getDict().getInt(value));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (Object) valueOf2;
        } else if (!Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            return null;
        } else {
            T valueOf3 = Double.valueOf(getDict().getDouble(value));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (Object) valueOf3;
        }
    }

    /* JADX WARNING: type inference failed for: r1v23, types: [java.lang.Boolean] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ <T> T getDecodedValue(com.adapty.react.ParamKey r7) {
        /*
            r6 = this;
            java.lang.String r0 = "T"
            java.lang.String r1 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            com.facebook.react.bridge.ReadableMap r1 = r6.getDict()
            java.lang.String r2 = r7.getValue()
            boolean r1 = r1.hasKey(r2)
            if (r1 == 0) goto L_0x00fa
            java.lang.String r1 = r7.getValue()
            com.facebook.react.bridge.ReadableMap r2 = r6.getDict()
            boolean r2 = r2.hasKey(r1)
            r3 = 0
            if (r2 != 0) goto L_0x0026
            goto L_0x00a2
        L_0x0026:
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            java.lang.Class r4 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x004d
            com.facebook.react.bridge.ReadableMap r2 = r6.getDict()
            boolean r1 = r2.getBoolean(r1)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 != 0) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r3 = r1
        L_0x004a:
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x00a2
        L_0x004d:
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x006b
            com.facebook.react.bridge.ReadableMap r2 = r6.getDict()
            java.lang.String r1 = r2.getString(r1)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 != 0) goto L_0x0066
            goto L_0x0067
        L_0x0066:
            r3 = r1
        L_0x0067:
            r1 = r3
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x00a2
        L_0x006b:
            java.lang.Class r4 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0087
            com.facebook.react.bridge.ReadableMap r2 = r6.getDict()
            int r1 = r2.getInt(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r1 = (java.lang.String) r1
        L_0x0085:
            r3 = r1
            goto L_0x00a2
        L_0x0087:
            java.lang.Class r4 = java.lang.Double.TYPE
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r2 == 0) goto L_0x00a2
            com.facebook.react.bridge.ReadableMap r2 = r6.getDict()
            double r1 = r2.getDouble(r1)
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0085
        L_0x00a2:
            if (r3 != 0) goto L_0x00b8
            com.adapty.react.BridgeError$TypeMismatch r0 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            java.lang.String r1 = r1.getSimpleName()
            if (r1 != 0) goto L_0x00b4
            java.lang.String r1 = "UnknownType"
        L_0x00b4:
            r0.<init>(r7, r1)
            throw r0
        L_0x00b8:
            r1 = r3
            java.lang.String r1 = (java.lang.String) r1
            r1 = 4
            com.adapty.internal.crossplatform.CrossplatformHelper$Companion r2 = com.adapty.internal.crossplatform.CrossplatformHelper.Companion     // Catch:{ Error -> 0x00d4 }
            com.adapty.internal.crossplatform.CrossplatformHelper r2 = r2.getShared()     // Catch:{ Error -> 0x00d4 }
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r1, r0)     // Catch:{ Error -> 0x00d4 }
            java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
            r5 = r4
            java.lang.Class r5 = (java.lang.Class) r5     // Catch:{ Error -> 0x00d4 }
            java.lang.Object r2 = r2.fromJson(r3, r4)     // Catch:{ Error -> 0x00d4 }
            java.lang.String r3 = "CrossplatformHelper.shar…n(jsonStr, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ Error -> 0x00d4 }
            return r2
        L_0x00d4:
            com.adapty.react.BridgeError$TypeMismatch r2 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "JSON-encoded "
            java.lang.StringBuilder r3 = r3.append(r4)
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r1, r0)
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r0 = r0.toString()
            r2.<init>(r7, r0)
            throw r2
        L_0x00fa:
            com.adapty.react.BridgeError$MissingRequiredArgument r0 = new com.adapty.react.BridgeError$MissingRequiredArgument
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.ParamMap.getDecodedValue(com.adapty.react.ParamKey):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0096 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ <T> T getDecodedOptionalValue(com.adapty.react.ParamKey r7) {
        /*
            r6 = this;
            java.lang.String r0 = "T"
            java.lang.String r1 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.String r1 = r7.getValue()
            com.facebook.react.bridge.ReadableMap r2 = r6.getDict()
            boolean r2 = r2.hasKey(r1)
            r3 = 0
            if (r2 != 0) goto L_0x0019
        L_0x0016:
            r1 = r3
            goto L_0x0091
        L_0x0019:
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            java.lang.Class r4 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x003f
            com.facebook.react.bridge.ReadableMap r2 = r6.getDict()
            boolean r1 = r2.getBoolean(r1)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 != 0) goto L_0x003c
            r1 = r3
        L_0x003c:
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0091
        L_0x003f:
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x005c
            com.facebook.react.bridge.ReadableMap r2 = r6.getDict()
            java.lang.String r1 = r2.getString(r1)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 != 0) goto L_0x0058
            r1 = r3
        L_0x0058:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x0091
        L_0x005c:
            java.lang.Class r4 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0077
            com.facebook.react.bridge.ReadableMap r2 = r6.getDict()
            int r1 = r2.getInt(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0091
        L_0x0077:
            java.lang.Class r4 = java.lang.Double.TYPE
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r2 == 0) goto L_0x0016
            com.facebook.react.bridge.ReadableMap r2 = r6.getDict()
            double r1 = r2.getDouble(r1)
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            java.lang.String r1 = (java.lang.String) r1
        L_0x0091:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2
            if (r1 != 0) goto L_0x0097
            return r3
        L_0x0097:
            r2 = 4
            com.adapty.internal.crossplatform.CrossplatformHelper$Companion r3 = com.adapty.internal.crossplatform.CrossplatformHelper.Companion     // Catch:{ Error -> 0x00ab }
            com.adapty.internal.crossplatform.CrossplatformHelper r3 = r3.getShared()     // Catch:{ Error -> 0x00ab }
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r2, r0)     // Catch:{ Error -> 0x00ab }
            java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
            r5 = r4
            java.lang.Class r5 = (java.lang.Class) r5     // Catch:{ Error -> 0x00ab }
            java.lang.Object r7 = r3.fromJson(r1, r4)     // Catch:{ Error -> 0x00ab }
            return r7
        L_0x00ab:
            com.adapty.react.BridgeError$TypeMismatch r1 = new com.adapty.react.BridgeError$TypeMismatch
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "JSON-encoded "
            java.lang.StringBuilder r3 = r3.append(r4)
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r2, r0)
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r0 = r0.toString()
            r1.<init>(r7, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.react.ParamMap.getDecodedOptionalValue(com.adapty.react.ParamKey):java.lang.Object");
    }

    public final /* synthetic */ <T> T getDecodedValue(ParamKey paramKey, Function1<? super String, ? extends T> function1) {
        Object obj;
        Intrinsics.checkNotNullParameter(paramKey, "key");
        Intrinsics.checkNotNullParameter(function1, "decoder");
        if (getDict().hasKey(paramKey.getValue())) {
            String value = paramKey.getValue();
            Object obj2 = null;
            if (getDict().hasKey(value)) {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    Object valueOf = Boolean.valueOf(getDict().getBoolean(value));
                    if (valueOf instanceof String) {
                        obj2 = valueOf;
                    }
                    obj2 = (String) obj2;
                } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(String.class))) {
                    Object string = getDict().getString(value);
                    if (string instanceof String) {
                        obj2 = string;
                    }
                    String str = (String) obj2;
                } else {
                    if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        obj = (String) Integer.valueOf(getDict().getInt(value));
                    } else if (Intrinsics.areEqual((Object) orCreateKotlinClass, (Object) Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        obj = (String) Double.valueOf(getDict().getDouble(value));
                    }
                    obj2 = obj;
                }
            }
            if (obj2 == null) {
                String simpleName = Reflection.getOrCreateKotlinClass(String.class).getSimpleName();
                if (simpleName == null) {
                    simpleName = "UnknownType";
                }
                throw new BridgeError.TypeMismatch(paramKey, simpleName);
            }
            String str2 = (String) obj2;
            T invoke = function1.invoke(obj2);
            if (invoke != null) {
                return invoke;
            }
            StringBuilder append = new StringBuilder().append("JSON-encoded ");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            throw new BridgeError.TypeMismatch(paramKey, append.append(Reflection.getOrCreateKotlinClass(Object.class).getSimpleName()).toString());
        }
        throw new BridgeError.MissingRequiredArgument(paramKey);
    }
}
