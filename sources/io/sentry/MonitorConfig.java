package io.sentry;

import io.sentry.MonitorSchedule;
import io.sentry.SentryOptions;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class MonitorConfig implements JsonUnknown, JsonSerializable {
    private Long checkinMargin;
    private Long failureIssueThreshold;
    private Long maxRuntime;
    private Long recoveryThreshold;
    private MonitorSchedule schedule;
    private String timezone;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String CHECKIN_MARGIN = "checkin_margin";
        public static final String FAILURE_ISSUE_THRESHOLD = "failure_issue_threshold";
        public static final String MAX_RUNTIME = "max_runtime";
        public static final String RECOVERY_THRESHOLD = "recovery_threshold";
        public static final String SCHEDULE = "schedule";
        public static final String TIMEZONE = "timezone";
    }

    public MonitorConfig(MonitorSchedule monitorSchedule) {
        this.schedule = monitorSchedule;
        SentryOptions.Cron cron = HubAdapter.getInstance().getOptions().getCron();
        if (cron != null) {
            this.checkinMargin = cron.getDefaultCheckinMargin();
            this.maxRuntime = cron.getDefaultMaxRuntime();
            this.timezone = cron.getDefaultTimezone();
            this.failureIssueThreshold = cron.getDefaultFailureIssueThreshold();
            this.recoveryThreshold = cron.getDefaultRecoveryThreshold();
        }
    }

    public MonitorSchedule getSchedule() {
        return this.schedule;
    }

    public void setSchedule(MonitorSchedule monitorSchedule) {
        this.schedule = monitorSchedule;
    }

    public Long getCheckinMargin() {
        return this.checkinMargin;
    }

    public void setCheckinMargin(Long l) {
        this.checkinMargin = l;
    }

    public Long getMaxRuntime() {
        return this.maxRuntime;
    }

    public void setMaxRuntime(Long l) {
        this.maxRuntime = l;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public void setTimezone(String str) {
        this.timezone = str;
    }

    public Long getFailureIssueThreshold() {
        return this.failureIssueThreshold;
    }

    public void setFailureIssueThreshold(Long l) {
        this.failureIssueThreshold = l;
    }

    public Long getRecoveryThreshold() {
        return this.recoveryThreshold;
    }

    public void setRecoveryThreshold(Long l) {
        this.recoveryThreshold = l;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name(JsonKeys.SCHEDULE);
        this.schedule.serialize(objectWriter, iLogger);
        if (this.checkinMargin != null) {
            objectWriter.name(JsonKeys.CHECKIN_MARGIN).value((Number) this.checkinMargin);
        }
        if (this.maxRuntime != null) {
            objectWriter.name(JsonKeys.MAX_RUNTIME).value((Number) this.maxRuntime);
        }
        if (this.timezone != null) {
            objectWriter.name("timezone").value(this.timezone);
        }
        if (this.failureIssueThreshold != null) {
            objectWriter.name(JsonKeys.FAILURE_ISSUE_THRESHOLD).value((Number) this.failureIssueThreshold);
        }
        if (this.recoveryThreshold != null) {
            objectWriter.name(JsonKeys.RECOVERY_THRESHOLD).value((Number) this.recoveryThreshold);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String next : map.keySet()) {
                objectWriter.name(next).value(iLogger, this.unknown.get(next));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<MonitorConfig> {
        public MonitorConfig deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            MonitorSchedule monitorSchedule = null;
            Long l = null;
            Long l2 = null;
            String str = null;
            Long l3 = null;
            Long l4 = null;
            HashMap hashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -2076227591:
                        if (nextName.equals("timezone")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -905406976:
                        if (nextName.equals(JsonKeys.CHECKIN_MARGIN)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -697920873:
                        if (nextName.equals(JsonKeys.SCHEDULE)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -607475647:
                        if (nextName.equals(JsonKeys.RECOVERY_THRESHOLD)) {
                            c = 3;
                            break;
                        }
                        break;
                    case 1581873149:
                        if (nextName.equals(JsonKeys.MAX_RUNTIME)) {
                            c = 4;
                            break;
                        }
                        break;
                    case 2138521552:
                        if (nextName.equals(JsonKeys.FAILURE_ISSUE_THRESHOLD)) {
                            c = 5;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        str = jsonObjectReader.nextStringOrNull();
                        break;
                    case 1:
                        l = jsonObjectReader.nextLongOrNull();
                        break;
                    case 2:
                        monitorSchedule = new MonitorSchedule.Deserializer().deserialize(jsonObjectReader, iLogger);
                        break;
                    case 3:
                        l4 = jsonObjectReader.nextLongOrNull();
                        break;
                    case 4:
                        l2 = jsonObjectReader.nextLongOrNull();
                        break;
                    case 5:
                        l3 = jsonObjectReader.nextLongOrNull();
                        break;
                    default:
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        jsonObjectReader.nextUnknown(iLogger, hashMap, nextName);
                        break;
                }
            }
            jsonObjectReader.endObject();
            if (monitorSchedule != null) {
                MonitorConfig monitorConfig = new MonitorConfig(monitorSchedule);
                monitorConfig.setCheckinMargin(l);
                monitorConfig.setMaxRuntime(l2);
                monitorConfig.setTimezone(str);
                monitorConfig.setFailureIssueThreshold(l3);
                monitorConfig.setRecoveryThreshold(l4);
                monitorConfig.setUnknown(hashMap);
                return monitorConfig;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"schedule\"");
            iLogger.log(SentryLevel.ERROR, "Missing required field \"schedule\"", (Throwable) illegalStateException);
            throw illegalStateException;
        }
    }
}
