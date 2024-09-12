package com.launchdarkly.sdk;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonWriter;
import com.launchdarkly.sdk.json.JsonSerializable;
import com.launchdarkly.sdk.json.JsonSerialization;
import com.launchdarkly.sdk.json.SerializationException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

@JsonAdapter(LDValueTypeAdapter.class)
public abstract class LDValue implements JsonSerializable {
    static boolean isInteger(double d) {
        return d == ((double) ((int) d));
    }

    public boolean booleanValue() {
        return false;
    }

    public double doubleValue() {
        return 0.0d;
    }

    public float floatValue() {
        return 0.0f;
    }

    public abstract LDValueType getType();

    public int intValue() {
        return 0;
    }

    public boolean isInt() {
        return false;
    }

    public boolean isNull() {
        return false;
    }

    public boolean isNumber() {
        return false;
    }

    public boolean isString() {
        return false;
    }

    public long longValue() {
        return 0;
    }

    public int size() {
        return 0;
    }

    public String stringValue() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract void write(JsonWriter jsonWriter) throws IOException;

    public static LDValue normalize(LDValue lDValue) {
        return lDValue == null ? ofNull() : lDValue;
    }

    public static LDValue ofNull() {
        return LDValueNull.INSTANCE;
    }

    public static LDValue of(boolean z) {
        return LDValueBool.fromBoolean(z);
    }

    public static LDValue of(int i) {
        return LDValueNumber.fromDouble((double) i);
    }

    public static LDValue of(long j) {
        return LDValueNumber.fromDouble((double) j);
    }

    public static LDValue of(float f) {
        return LDValueNumber.fromDouble((double) f);
    }

    public static LDValue of(double d) {
        return LDValueNumber.fromDouble(d);
    }

    public static LDValue of(String str) {
        return str == null ? ofNull() : LDValueString.fromString(str);
    }

    public static ArrayBuilder buildArray() {
        return new ArrayBuilder();
    }

    public static LDValue arrayOf(LDValue... lDValueArr) {
        return LDValueArray.fromList(lDValueArr == null ? null : Arrays.asList(lDValueArr));
    }

    public static ObjectBuilder buildObject() {
        return new ObjectBuilder();
    }

    public static LDValue parse(String str) {
        try {
            return normalize((LDValue) JsonSerialization.deserialize(str, LDValue.class));
        } catch (SerializationException e) {
            throw new RuntimeException(e);
        }
    }

    public Iterable<String> keys() {
        return Collections.emptyList();
    }

    public Iterable<LDValue> values() {
        return Collections.emptyList();
    }

    public <T> Iterable<T> valuesAs(final Converter<T> converter) {
        return Helpers.transform(values(), new Function<LDValue, T>() {
            public T apply(LDValue lDValue) {
                return converter.toType(lDValue);
            }
        });
    }

    public LDValue get(int i) {
        return ofNull();
    }

    public LDValue get(String str) {
        return ofNull();
    }

    public String toJsonString() {
        return JsonSerialization.serialize(this);
    }

    public String toString() {
        return toJsonString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof LDValue) {
            if (obj == this) {
                return true;
            }
            LDValue lDValue = (LDValue) obj;
            if (getType() == lDValue.getType()) {
                int i = AnonymousClass2.$SwitchMap$com$launchdarkly$sdk$LDValueType[getType().ordinal()];
                if (i == 1) {
                    return lDValue.isNull();
                }
                if (i != 2) {
                    if (i == 4) {
                        return stringValue().equals(lDValue.stringValue());
                    }
                    if (i != 5) {
                        if (i != 6 || size() != lDValue.size()) {
                            return false;
                        }
                        for (String next : keys()) {
                            if (!get(next).equals(lDValue.get(next))) {
                                return false;
                            }
                        }
                        return true;
                    } else if (size() != lDValue.size()) {
                        return false;
                    } else {
                        for (int i2 = 0; i2 < size(); i2++) {
                            if (!get(i2).equals(lDValue.get(i2))) {
                                return false;
                            }
                        }
                        return true;
                    }
                } else if (doubleValue() == lDValue.doubleValue()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /* renamed from: com.launchdarkly.sdk.LDValue$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$launchdarkly$sdk$LDValueType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.launchdarkly.sdk.LDValueType[] r0 = com.launchdarkly.sdk.LDValueType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$launchdarkly$sdk$LDValueType = r0
                com.launchdarkly.sdk.LDValueType r1 = com.launchdarkly.sdk.LDValueType.NULL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$LDValueType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.launchdarkly.sdk.LDValueType r1 = com.launchdarkly.sdk.LDValueType.NUMBER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$LDValueType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.launchdarkly.sdk.LDValueType r1 = com.launchdarkly.sdk.LDValueType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$LDValueType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.launchdarkly.sdk.LDValueType r1 = com.launchdarkly.sdk.LDValueType.STRING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$LDValueType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.launchdarkly.sdk.LDValueType r1 = com.launchdarkly.sdk.LDValueType.ARRAY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$LDValueType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.launchdarkly.sdk.LDValueType r1 = com.launchdarkly.sdk.LDValueType.OBJECT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.LDValue.AnonymousClass2.<clinit>():void");
        }
    }

    public int hashCode() {
        int i = AnonymousClass2.$SwitchMap$com$launchdarkly$sdk$LDValueType[getType().ordinal()];
        if (i == 2) {
            return intValue();
        }
        if (i == 3) {
            return booleanValue() ? 1 : 0;
        }
        if (i == 4) {
            return stringValue().hashCode();
        }
        int i2 = 0;
        if (i == 5) {
            for (LDValue hashCode : values()) {
                i2 = (i2 * 31) + hashCode.hashCode();
            }
            return i2;
        } else if (i != 6) {
            return 0;
        } else {
            for (String next : keys()) {
                i2 = (((i2 * 31) + next.hashCode()) * 31) + get(next).hashCode();
            }
            return i2;
        }
    }

    public static abstract class Converter<T> {
        public abstract LDValue fromType(T t);

        public abstract T toType(LDValue lDValue);

        public LDValue arrayFrom(Iterable<T> iterable) {
            ArrayBuilder buildArray = LDValue.buildArray();
            for (T fromType : iterable) {
                buildArray.add(fromType(fromType));
            }
            return buildArray.build();
        }

        public LDValue arrayOf(T... tArr) {
            ArrayBuilder buildArray = LDValue.buildArray();
            for (T fromType : tArr) {
                buildArray.add(fromType(fromType));
            }
            return buildArray.build();
        }

        public LDValue objectFrom(Map<String, T> map) {
            ObjectBuilder buildObject = LDValue.buildObject();
            for (String next : map.keySet()) {
                buildObject.put(next, fromType(map.get(next)));
            }
            return buildObject.build();
        }
    }

    public static abstract class Convert {
        public static final Converter<Boolean> Boolean = new Converter<Boolean>() {
            public LDValue fromType(Boolean bool) {
                return bool == null ? LDValue.ofNull() : LDValue.of(bool.booleanValue());
            }

            public Boolean toType(LDValue lDValue) {
                return Boolean.valueOf(lDValue.booleanValue());
            }
        };
        public static final Converter<Double> Double = new Converter<Double>() {
            public LDValue fromType(Double d) {
                return d == null ? LDValue.ofNull() : LDValue.of(d.doubleValue());
            }

            public Double toType(LDValue lDValue) {
                return Double.valueOf(lDValue.doubleValue());
            }
        };
        public static final Converter<Float> Float = new Converter<Float>() {
            public LDValue fromType(Float f) {
                return f == null ? LDValue.ofNull() : LDValue.of(f.floatValue());
            }

            public Float toType(LDValue lDValue) {
                return Float.valueOf(lDValue.floatValue());
            }
        };
        public static final Converter<Integer> Integer = new Converter<Integer>() {
            public LDValue fromType(Integer num) {
                return num == null ? LDValue.ofNull() : LDValue.of(num.intValue());
            }

            public Integer toType(LDValue lDValue) {
                return Integer.valueOf(lDValue.intValue());
            }
        };
        public static final Converter<Long> Long = new Converter<Long>() {
            public LDValue fromType(Long l) {
                return l == null ? LDValue.ofNull() : LDValue.of(l.longValue());
            }

            public Long toType(LDValue lDValue) {
                return Long.valueOf(lDValue.longValue());
            }
        };
        public static final Converter<String> String = new Converter<String>() {
            public LDValue fromType(String str) {
                return LDValue.of(str);
            }

            public String toType(LDValue lDValue) {
                return lDValue.stringValue();
            }
        };

        private Convert() {
        }
    }
}
