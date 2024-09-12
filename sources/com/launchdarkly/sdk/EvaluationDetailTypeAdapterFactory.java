package com.launchdarkly.sdk;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import io.sentry.clientreport.DiscardedEvent;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

final class EvaluationDetailTypeAdapterFactory implements TypeAdapterFactory {
    EvaluationDetailTypeAdapterFactory() {
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        if (typeToken.getType() instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) typeToken.getType()).getActualTypeArguments();
            if (actualTypeArguments.length == 1) {
                return new EvaluationDetailTypeAdapter(gson, actualTypeArguments[0]);
            }
        }
        return new EvaluationDetailTypeAdapter(gson, LDValue.class);
    }

    static final class EvaluationDetailTypeAdapter<T> extends TypeAdapter<EvaluationDetail<T>> {
        private final Gson gson;
        private final Type valueType;

        EvaluationDetailTypeAdapter(Gson gson2, Type type) {
            this.gson = gson2;
            this.valueType = type;
        }

        public void write(JsonWriter jsonWriter, EvaluationDetail<T> evaluationDetail) throws IOException {
            jsonWriter.beginObject();
            jsonWriter.name("value");
            if (evaluationDetail.getValue() == null) {
                jsonWriter.nullValue();
            } else {
                this.gson.toJson((Object) evaluationDetail.getValue(), (Type) Object.class, jsonWriter);
            }
            if (!evaluationDetail.isDefaultValue()) {
                jsonWriter.name("variationIndex");
                jsonWriter.value((long) evaluationDetail.getVariationIndex());
            }
            jsonWriter.name(DiscardedEvent.JsonKeys.REASON);
            this.gson.toJson((Object) evaluationDetail.getReason(), (Type) EvaluationReason.class, jsonWriter);
            jsonWriter.endObject();
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.launchdarkly.sdk.EvaluationDetail<T> read(com.google.gson.stream.JsonReader r7) throws java.io.IOException {
            /*
                r6 = this;
                r7.beginObject()
                r0 = -1
                r1 = 0
                r3 = r0
                r2 = r1
            L_0x0007:
                com.google.gson.stream.JsonToken r4 = r7.peek()
                com.google.gson.stream.JsonToken r5 = com.google.gson.stream.JsonToken.END_OBJECT
                if (r4 == r5) goto L_0x0059
                java.lang.String r4 = r7.nextName()
                r4.hashCode()
                int r5 = r4.hashCode()
                switch(r5) {
                    case -934964668: goto L_0x0035;
                    case 79424127: goto L_0x002a;
                    case 111972721: goto L_0x001f;
                    default: goto L_0x001d;
                }
            L_0x001d:
                r4 = r0
                goto L_0x003f
            L_0x001f:
                java.lang.String r5 = "value"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0028
                goto L_0x001d
            L_0x0028:
                r4 = 2
                goto L_0x003f
            L_0x002a:
                java.lang.String r5 = "variationIndex"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0033
                goto L_0x001d
            L_0x0033:
                r4 = 1
                goto L_0x003f
            L_0x0035:
                java.lang.String r5 = "reason"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x003e
                goto L_0x001d
            L_0x003e:
                r4 = 0
            L_0x003f:
                switch(r4) {
                    case 0: goto L_0x0054;
                    case 1: goto L_0x004f;
                    case 2: goto L_0x0046;
                    default: goto L_0x0042;
                }
            L_0x0042:
                r7.skipValue()
                goto L_0x0007
            L_0x0046:
                com.google.gson.Gson r1 = r6.gson
                java.lang.reflect.Type r4 = r6.valueType
                java.lang.Object r1 = r1.fromJson((com.google.gson.stream.JsonReader) r7, (java.lang.reflect.Type) r4)
                goto L_0x0007
            L_0x004f:
                int r3 = r7.nextInt()
                goto L_0x0007
            L_0x0054:
                com.launchdarkly.sdk.EvaluationReason r2 = com.launchdarkly.sdk.EvaluationReasonTypeAdapter.parse(r7)
                goto L_0x0007
            L_0x0059:
                r7.endObject()
                if (r1 != 0) goto L_0x0068
                java.lang.reflect.Type r7 = r6.valueType
                java.lang.Class<com.launchdarkly.sdk.LDValue> r0 = com.launchdarkly.sdk.LDValue.class
                if (r7 != r0) goto L_0x0068
                com.launchdarkly.sdk.LDValue r1 = com.launchdarkly.sdk.LDValue.ofNull()
            L_0x0068:
                com.launchdarkly.sdk.EvaluationDetail r7 = com.launchdarkly.sdk.EvaluationDetail.fromValue(r1, r3, r2)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.EvaluationDetailTypeAdapterFactory.EvaluationDetailTypeAdapter.read(com.google.gson.stream.JsonReader):com.launchdarkly.sdk.EvaluationDetail");
        }
    }
}
