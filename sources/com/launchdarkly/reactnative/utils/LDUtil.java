package com.launchdarkly.reactnative.utils;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.launchdarkly.sdk.ArrayBuilder;
import com.launchdarkly.sdk.ContextBuilder;
import com.launchdarkly.sdk.ContextKind;
import com.launchdarkly.sdk.ContextMultiBuilder;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.LDValue;
import com.launchdarkly.sdk.ObjectBuilder;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class LDUtil {
    public static boolean validateConfig(String str, ReadableMap readableMap, ReadableType readableType) {
        return readableMap.hasKey(str) && readableMap.getType(str) == readableType;
    }

    public static LDContext configureContext(ReadableMap readableMap) {
        String string = validateConfig("kind", readableMap, ReadableType.String) ? readableMap.getString("kind") : null;
        if (!string.equals("multi")) {
            return createSingleContext(readableMap, string);
        }
        ContextMultiBuilder multiBuilder = LDContext.multiBuilder();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            if (!nextKey.equals("kind")) {
                multiBuilder.add(createSingleContext(readableMap.getMap(nextKey), nextKey));
            }
        }
        return multiBuilder.build();
    }

    public static LDContext createSingleContext(ReadableMap readableMap, String str) {
        String str2 = null;
        Boolean valueOf = validateConfig("anonymous", readableMap, ReadableType.Boolean) ? Boolean.valueOf(readableMap.getBoolean("anonymous")) : null;
        if (validateConfig("key", readableMap, ReadableType.String)) {
            str2 = readableMap.getString("key");
        }
        if (valueOf != null && valueOf.booleanValue() && str2 == null) {
            str2 = "__LD_PLACEHOLDER_KEY__";
        }
        ContextBuilder builder = LDContext.builder(ContextKind.of(str), str2);
        if (valueOf != null) {
            builder.anonymous(valueOf.booleanValue());
        }
        if (validateConfig("name", readableMap, ReadableType.String)) {
            builder.name(readableMap.getString("name"));
        }
        if (validateConfig("_meta", readableMap, ReadableType.Map)) {
            builder.privateAttributes(getPrivateAttributesArray(readableMap.getMap("_meta")));
        }
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            if (!nextKey.equals("kind") && !nextKey.equals("key") && !nextKey.equals("name") && !nextKey.equals("anonymous") && !nextKey.equals("_meta")) {
                builder.set(nextKey, toLDValue(readableMap.getDynamic(nextKey)));
            }
        }
        return builder.build();
    }

    public static String[] getPrivateAttributesArray(ReadableMap readableMap) {
        ArrayList arrayList = new ArrayList();
        if (validateConfig("privateAttributes", readableMap, ReadableType.Array)) {
            ReadableArray array = readableMap.getArray("privateAttributes");
            for (int i = 0; i < array.size(); i++) {
                if (array.getType(i) == ReadableType.String) {
                    arrayList.add(array.getString(i));
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static LDValue toLDValue(Dynamic dynamic) {
        if (dynamic == null) {
            return LDValue.ofNull();
        }
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[dynamic.getType().ordinal()];
        if (i == 1) {
            return LDValue.of(dynamic.asBoolean());
        }
        if (i == 2) {
            return LDValue.of(dynamic.asDouble());
        }
        if (i == 3) {
            return LDValue.of(dynamic.asString());
        }
        if (i == 4) {
            return toLDValue(dynamic.asArray());
        }
        if (i != 5) {
            return LDValue.ofNull();
        }
        return toLDValue(dynamic.asMap());
    }

    public static LDValue toLDValue(ReadableArray readableArray) {
        ArrayBuilder buildArray = LDValue.buildArray();
        for (int i = 0; i < readableArray.size(); i++) {
            buildArray.add(toLDValue(readableArray.getDynamic(i)));
        }
        return buildArray.build();
    }

    public static LDValue toLDValue(ReadableMap readableMap) {
        ObjectBuilder buildObject = LDValue.buildObject();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            buildObject.put(nextKey, toLDValue(readableMap.getDynamic(nextKey)));
        }
        return buildObject.build();
    }

    /* renamed from: com.launchdarkly.reactnative.utils.LDUtil$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;
        static final /* synthetic */ int[] $SwitchMap$com$launchdarkly$sdk$LDValueType;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0078 */
        static {
            /*
                com.launchdarkly.sdk.LDValueType[] r0 = com.launchdarkly.sdk.LDValueType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$launchdarkly$sdk$LDValueType = r0
                r1 = 1
                com.launchdarkly.sdk.LDValueType r2 = com.launchdarkly.sdk.LDValueType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$launchdarkly$sdk$LDValueType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.launchdarkly.sdk.LDValueType r3 = com.launchdarkly.sdk.LDValueType.NUMBER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$launchdarkly$sdk$LDValueType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.launchdarkly.sdk.LDValueType r4 = com.launchdarkly.sdk.LDValueType.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$launchdarkly$sdk$LDValueType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.launchdarkly.sdk.LDValueType r5 = com.launchdarkly.sdk.LDValueType.ARRAY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = $SwitchMap$com$launchdarkly$sdk$LDValueType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.launchdarkly.sdk.LDValueType r6 = com.launchdarkly.sdk.LDValueType.OBJECT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r5 = $SwitchMap$com$launchdarkly$sdk$LDValueType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.launchdarkly.sdk.LDValueType r6 = com.launchdarkly.sdk.LDValueType.NULL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r7 = 6
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                com.facebook.react.bridge.ReadableType[] r5 = com.facebook.react.bridge.ReadableType.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                $SwitchMap$com$facebook$react$bridge$ReadableType = r5
                com.facebook.react.bridge.ReadableType r6 = com.facebook.react.bridge.ReadableType.Boolean     // Catch:{ NoSuchFieldError -> 0x005a }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r1 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.facebook.react.bridge.ReadableType r5 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x006e }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Array     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0082 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Map     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.reactnative.utils.LDUtil.AnonymousClass1.<clinit>():void");
        }
    }

    public static Object ldValueToBridge(LDValue lDValue) {
        int i = AnonymousClass1.$SwitchMap$com$launchdarkly$sdk$LDValueType[lDValue.getType().ordinal()];
        if (i == 1) {
            return Boolean.valueOf(lDValue.booleanValue());
        }
        if (i == 2) {
            return Double.valueOf(lDValue.doubleValue());
        }
        if (i == 3) {
            return lDValue.stringValue();
        }
        if (i == 4) {
            return ldValueToArray(lDValue);
        }
        if (i != 5) {
            return null;
        }
        return ldValueToMap(lDValue);
    }

    public static WritableArray ldValueToArray(LDValue lDValue) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (LDValue next : lDValue.values()) {
            switch (AnonymousClass1.$SwitchMap$com$launchdarkly$sdk$LDValueType[next.getType().ordinal()]) {
                case 1:
                    writableNativeArray.pushBoolean(next.booleanValue());
                    break;
                case 2:
                    writableNativeArray.pushDouble(next.doubleValue());
                    break;
                case 3:
                    writableNativeArray.pushString(next.stringValue());
                    break;
                case 4:
                    writableNativeArray.pushArray(ldValueToArray(next));
                    break;
                case 5:
                    writableNativeArray.pushMap(ldValueToMap(next));
                    break;
                case 6:
                    writableNativeArray.pushNull();
                    break;
            }
        }
        return writableNativeArray;
    }

    public static WritableMap ldValueToMap(LDValue lDValue) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        for (String next : lDValue.keys()) {
            LDValue lDValue2 = lDValue.get(next);
            switch (AnonymousClass1.$SwitchMap$com$launchdarkly$sdk$LDValueType[lDValue2.getType().ordinal()]) {
                case 1:
                    writableNativeMap.putBoolean(next, lDValue2.booleanValue());
                    break;
                case 2:
                    writableNativeMap.putDouble(next, lDValue2.doubleValue());
                    break;
                case 3:
                    writableNativeMap.putString(next, lDValue2.stringValue());
                    break;
                case 4:
                    writableNativeMap.putArray(next, ldValueToArray(lDValue2));
                    break;
                case 5:
                    writableNativeMap.putMap(next, ldValueToMap(lDValue2));
                    break;
                case 6:
                    writableNativeMap.putNull(next);
                    break;
            }
        }
        return writableNativeMap;
    }

    public static Method findSetter(Class cls, String str) {
        for (Method method : cls.getMethods()) {
            if (method.getName().equals(str) && method.getParameterTypes().length == 1) {
                return method;
            }
        }
        return null;
    }
}
