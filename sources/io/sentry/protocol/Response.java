package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Response implements JsonUnknown, JsonSerializable {
    public static final String TYPE = "response";
    /* access modifiers changed from: private */
    public Long bodySize;
    /* access modifiers changed from: private */
    public String cookies;
    /* access modifiers changed from: private */
    public Object data;
    /* access modifiers changed from: private */
    public Map<String, String> headers;
    /* access modifiers changed from: private */
    public Integer statusCode;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String BODY_SIZE = "body_size";
        public static final String COOKIES = "cookies";
        public static final String DATA = "data";
        public static final String HEADERS = "headers";
        public static final String STATUS_CODE = "status_code";
    }

    public Response() {
    }

    public Response(Response response) {
        this.cookies = response.cookies;
        this.headers = CollectionUtils.newConcurrentHashMap(response.headers);
        this.unknown = CollectionUtils.newConcurrentHashMap(response.unknown);
        this.statusCode = response.statusCode;
        this.bodySize = response.bodySize;
        this.data = response.data;
    }

    public String getCookies() {
        return this.cookies;
    }

    public void setCookies(String str) {
        this.cookies = str;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = CollectionUtils.newConcurrentHashMap(map);
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(Integer num) {
        this.statusCode = num;
    }

    public Long getBodySize() {
        return this.bodySize;
    }

    public void setBodySize(Long l) {
        this.bodySize = l;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.cookies != null) {
            objectWriter.name("cookies").value(this.cookies);
        }
        if (this.headers != null) {
            objectWriter.name("headers").value(iLogger, this.headers);
        }
        if (this.statusCode != null) {
            objectWriter.name(JsonKeys.STATUS_CODE).value(iLogger, this.statusCode);
        }
        if (this.bodySize != null) {
            objectWriter.name("body_size").value(iLogger, this.bodySize);
        }
        if (this.data != null) {
            objectWriter.name("data").value(iLogger, this.data);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.unknown.get(next);
                objectWriter.name(next);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<Response> {
        public Response deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            Response response = new Response();
            ConcurrentHashMap concurrentHashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -891699686:
                        if (nextName.equals(JsonKeys.STATUS_CODE)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3076010:
                        if (nextName.equals("data")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 795307910:
                        if (nextName.equals("headers")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 952189583:
                        if (nextName.equals("cookies")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 1252988030:
                        if (nextName.equals("body_size")) {
                            c = 4;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        Integer unused = response.statusCode = jsonObjectReader.nextIntegerOrNull();
                        break;
                    case 1:
                        Object unused2 = response.data = jsonObjectReader.nextObjectOrNull();
                        break;
                    case 2:
                        Map map = (Map) jsonObjectReader.nextObjectOrNull();
                        if (map == null) {
                            break;
                        } else {
                            Map unused3 = response.headers = CollectionUtils.newConcurrentHashMap(map);
                            break;
                        }
                    case 3:
                        String unused4 = response.cookies = jsonObjectReader.nextStringOrNull();
                        break;
                    case 4:
                        Long unused5 = response.bodySize = jsonObjectReader.nextLongOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        jsonObjectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                        break;
                }
            }
            response.setUnknown(concurrentHashMap);
            jsonObjectReader.endObject();
            return response;
        }
    }
}
