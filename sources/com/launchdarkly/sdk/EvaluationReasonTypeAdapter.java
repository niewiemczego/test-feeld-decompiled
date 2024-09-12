package com.launchdarkly.sdk;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class EvaluationReasonTypeAdapter extends TypeAdapter<EvaluationReason> {
    EvaluationReasonTypeAdapter() {
    }

    public EvaluationReason read(JsonReader jsonReader) throws IOException {
        return parse(jsonReader);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.launchdarkly.sdk.EvaluationReason parse(com.google.gson.stream.JsonReader r12) throws java.io.IOException {
        /*
            r12.beginObject()
            r0 = 0
            r1 = -1
            r2 = 0
            r4 = r0
            r5 = r1
            r3 = r2
            r6 = r3
            r7 = r6
            r8 = r7
            r9 = r8
        L_0x000d:
            com.google.gson.stream.JsonToken r10 = r12.peek()
            com.google.gson.stream.JsonToken r11 = com.google.gson.stream.JsonToken.END_OBJECT
            if (r10 == r11) goto L_0x00ac
            java.lang.String r10 = r12.nextName()
            r10.hashCode()
            int r11 = r10.hashCode()
            switch(r11) {
                case -2112512202: goto L_0x0067;
                case -1814209790: goto L_0x005c;
                case -919875273: goto L_0x0051;
                case -637386807: goto L_0x0046;
                case -543206190: goto L_0x003b;
                case 3292052: goto L_0x0030;
                case 329268668: goto L_0x0025;
                default: goto L_0x0023;
            }
        L_0x0023:
            r10 = r1
            goto L_0x0071
        L_0x0025:
            java.lang.String r11 = "errorKind"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x002e
            goto L_0x0023
        L_0x002e:
            r10 = 6
            goto L_0x0071
        L_0x0030:
            java.lang.String r11 = "kind"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x0039
            goto L_0x0023
        L_0x0039:
            r10 = 5
            goto L_0x0071
        L_0x003b:
            java.lang.String r11 = "bigSegmentsStatus"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x0044
            goto L_0x0023
        L_0x0044:
            r10 = 4
            goto L_0x0071
        L_0x0046:
            java.lang.String r11 = "prerequisiteKey"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x004f
            goto L_0x0023
        L_0x004f:
            r10 = 3
            goto L_0x0071
        L_0x0051:
            java.lang.String r11 = "ruleId"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x005a
            goto L_0x0023
        L_0x005a:
            r10 = 2
            goto L_0x0071
        L_0x005c:
            java.lang.String r11 = "inExperiment"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x0065
            goto L_0x0023
        L_0x0065:
            r10 = 1
            goto L_0x0071
        L_0x0067:
            java.lang.String r11 = "ruleIndex"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x0070
            goto L_0x0023
        L_0x0070:
            r10 = r0
        L_0x0071:
            switch(r10) {
                case 0: goto L_0x00a6;
                case 1: goto L_0x00a0;
                case 2: goto L_0x009a;
                case 3: goto L_0x0094;
                case 4: goto L_0x008a;
                case 5: goto L_0x0081;
                case 6: goto L_0x0078;
                default: goto L_0x0074;
            }
        L_0x0074:
            r12.skipValue()
            goto L_0x000d
        L_0x0078:
            java.lang.Class<com.launchdarkly.sdk.EvaluationReason$ErrorKind> r8 = com.launchdarkly.sdk.EvaluationReason.ErrorKind.class
            java.lang.Enum r8 = com.launchdarkly.sdk.Helpers.readEnum(r8, r12)
            com.launchdarkly.sdk.EvaluationReason$ErrorKind r8 = (com.launchdarkly.sdk.EvaluationReason.ErrorKind) r8
            goto L_0x000d
        L_0x0081:
            java.lang.Class<com.launchdarkly.sdk.EvaluationReason$Kind> r3 = com.launchdarkly.sdk.EvaluationReason.Kind.class
            java.lang.Enum r3 = com.launchdarkly.sdk.Helpers.readEnum(r3, r12)
            com.launchdarkly.sdk.EvaluationReason$Kind r3 = (com.launchdarkly.sdk.EvaluationReason.Kind) r3
            goto L_0x000d
        L_0x008a:
            java.lang.Class<com.launchdarkly.sdk.EvaluationReason$BigSegmentsStatus> r9 = com.launchdarkly.sdk.EvaluationReason.BigSegmentsStatus.class
            java.lang.Enum r9 = com.launchdarkly.sdk.Helpers.readEnum(r9, r12)
            com.launchdarkly.sdk.EvaluationReason$BigSegmentsStatus r9 = (com.launchdarkly.sdk.EvaluationReason.BigSegmentsStatus) r9
            goto L_0x000d
        L_0x0094:
            java.lang.String r7 = r12.nextString()
            goto L_0x000d
        L_0x009a:
            java.lang.String r6 = com.launchdarkly.sdk.Helpers.readNullableString(r12)
            goto L_0x000d
        L_0x00a0:
            boolean r4 = r12.nextBoolean()
            goto L_0x000d
        L_0x00a6:
            int r5 = r12.nextInt()
            goto L_0x000d
        L_0x00ac:
            r12.endObject()
            if (r3 == 0) goto L_0x00e1
            int[] r12 = com.launchdarkly.sdk.EvaluationReasonTypeAdapter.AnonymousClass1.$SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind
            int r0 = r3.ordinal()
            r12 = r12[r0]
            switch(r12) {
                case 1: goto L_0x00d6;
                case 2: goto L_0x00d1;
                case 3: goto L_0x00cc;
                case 4: goto L_0x00c7;
                case 5: goto L_0x00c2;
                case 6: goto L_0x00bd;
                default: goto L_0x00bc;
            }
        L_0x00bc:
            return r2
        L_0x00bd:
            com.launchdarkly.sdk.EvaluationReason r12 = com.launchdarkly.sdk.EvaluationReason.error(r8)
            goto L_0x00da
        L_0x00c2:
            com.launchdarkly.sdk.EvaluationReason r12 = com.launchdarkly.sdk.EvaluationReason.prerequisiteFailed(r7)
            goto L_0x00da
        L_0x00c7:
            com.launchdarkly.sdk.EvaluationReason r12 = com.launchdarkly.sdk.EvaluationReason.ruleMatch(r5, r6, r4)
            goto L_0x00da
        L_0x00cc:
            com.launchdarkly.sdk.EvaluationReason r12 = com.launchdarkly.sdk.EvaluationReason.targetMatch()
            goto L_0x00da
        L_0x00d1:
            com.launchdarkly.sdk.EvaluationReason r12 = com.launchdarkly.sdk.EvaluationReason.fallthrough(r4)
            goto L_0x00da
        L_0x00d6:
            com.launchdarkly.sdk.EvaluationReason r12 = com.launchdarkly.sdk.EvaluationReason.off()
        L_0x00da:
            if (r9 == 0) goto L_0x00e0
            com.launchdarkly.sdk.EvaluationReason r12 = r12.withBigSegmentsStatus(r9)
        L_0x00e0:
            return r12
        L_0x00e1:
            com.google.gson.JsonParseException r12 = new com.google.gson.JsonParseException
            java.lang.String r0 = "EvaluationReason missing required property \"kind\""
            r12.<init>((java.lang.String) r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.EvaluationReasonTypeAdapter.parse(com.google.gson.stream.JsonReader):com.launchdarkly.sdk.EvaluationReason");
    }

    /* renamed from: com.launchdarkly.sdk.EvaluationReasonTypeAdapter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.launchdarkly.sdk.EvaluationReason$Kind[] r0 = com.launchdarkly.sdk.EvaluationReason.Kind.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind = r0
                com.launchdarkly.sdk.EvaluationReason$Kind r1 = com.launchdarkly.sdk.EvaluationReason.Kind.OFF     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind     // Catch:{ NoSuchFieldError -> 0x001d }
                com.launchdarkly.sdk.EvaluationReason$Kind r1 = com.launchdarkly.sdk.EvaluationReason.Kind.FALLTHROUGH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.launchdarkly.sdk.EvaluationReason$Kind r1 = com.launchdarkly.sdk.EvaluationReason.Kind.TARGET_MATCH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.launchdarkly.sdk.EvaluationReason$Kind r1 = com.launchdarkly.sdk.EvaluationReason.Kind.RULE_MATCH     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind     // Catch:{ NoSuchFieldError -> 0x003e }
                com.launchdarkly.sdk.EvaluationReason$Kind r1 = com.launchdarkly.sdk.EvaluationReason.Kind.PREREQUISITE_FAILED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.launchdarkly.sdk.EvaluationReason$Kind r1 = com.launchdarkly.sdk.EvaluationReason.Kind.ERROR     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.EvaluationReasonTypeAdapter.AnonymousClass1.<clinit>():void");
        }
    }

    public void write(JsonWriter jsonWriter, EvaluationReason evaluationReason) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("kind");
        jsonWriter.value(evaluationReason.getKind().name());
        int i = AnonymousClass1.$SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind[evaluationReason.getKind().ordinal()];
        if (i != 2) {
            if (i == 4) {
                jsonWriter.name("ruleIndex");
                jsonWriter.value((long) evaluationReason.getRuleIndex());
                if (evaluationReason.getRuleId() != null) {
                    jsonWriter.name("ruleId");
                    jsonWriter.value(evaluationReason.getRuleId());
                }
                if (evaluationReason.isInExperiment()) {
                    jsonWriter.name("inExperiment");
                    jsonWriter.value(evaluationReason.isInExperiment());
                }
            } else if (i == 5) {
                jsonWriter.name("prerequisiteKey");
                jsonWriter.value(evaluationReason.getPrerequisiteKey());
            } else if (i == 6) {
                jsonWriter.name("errorKind");
                jsonWriter.value(evaluationReason.getErrorKind().name());
            }
        } else if (evaluationReason.isInExperiment()) {
            jsonWriter.name("inExperiment");
            jsonWriter.value(evaluationReason.isInExperiment());
        }
        if (evaluationReason.getBigSegmentsStatus() != null) {
            jsonWriter.name("bigSegmentsStatus");
            jsonWriter.value(evaluationReason.getBigSegmentsStatus().name());
        }
        jsonWriter.endObject();
    }
}
