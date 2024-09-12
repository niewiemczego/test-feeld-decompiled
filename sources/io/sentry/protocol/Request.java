package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Request implements JsonUnknown, JsonSerializable {
    /* access modifiers changed from: private */
    public String apiTarget;
    /* access modifiers changed from: private */
    public Long bodySize;
    /* access modifiers changed from: private */
    public String cookies;
    /* access modifiers changed from: private */
    public Object data;
    /* access modifiers changed from: private */
    public Map<String, String> env;
    /* access modifiers changed from: private */
    public String fragment;
    /* access modifiers changed from: private */
    public Map<String, String> headers;
    /* access modifiers changed from: private */
    public String method;
    /* access modifiers changed from: private */
    public Map<String, String> other;
    /* access modifiers changed from: private */
    public String queryString;
    private Map<String, Object> unknown;
    /* access modifiers changed from: private */
    public String url;

    public static final class JsonKeys {
        public static final String API_TARGET = "api_target";
        public static final String BODY_SIZE = "body_size";
        public static final String COOKIES = "cookies";
        public static final String DATA = "data";
        public static final String ENV = "env";
        public static final String FRAGMENT = "fragment";
        public static final String HEADERS = "headers";
        public static final String METHOD = "method";
        public static final String OTHER = "other";
        public static final String QUERY_STRING = "query_string";
        public static final String URL = "url";
    }

    public Request() {
    }

    public Request(Request request) {
        this.url = request.url;
        this.cookies = request.cookies;
        this.method = request.method;
        this.queryString = request.queryString;
        this.headers = CollectionUtils.newConcurrentHashMap(request.headers);
        this.env = CollectionUtils.newConcurrentHashMap(request.env);
        this.other = CollectionUtils.newConcurrentHashMap(request.other);
        this.unknown = CollectionUtils.newConcurrentHashMap(request.unknown);
        this.data = request.data;
        this.fragment = request.fragment;
        this.bodySize = request.bodySize;
        this.apiTarget = request.apiTarget;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public String getQueryString() {
        return this.queryString;
    }

    public void setQueryString(String str) {
        this.queryString = str;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object obj) {
        this.data = obj;
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

    public Map<String, String> getEnvs() {
        return this.env;
    }

    public void setEnvs(Map<String, String> map) {
        this.env = CollectionUtils.newConcurrentHashMap(map);
    }

    public Map<String, String> getOthers() {
        return this.other;
    }

    public void setOthers(Map<String, String> map) {
        this.other = CollectionUtils.newConcurrentHashMap(map);
    }

    public String getFragment() {
        return this.fragment;
    }

    public void setFragment(String str) {
        this.fragment = str;
    }

    public Long getBodySize() {
        return this.bodySize;
    }

    public void setBodySize(Long l) {
        this.bodySize = l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Request request = (Request) obj;
        if (!Objects.equals(this.url, request.url) || !Objects.equals(this.method, request.method) || !Objects.equals(this.queryString, request.queryString) || !Objects.equals(this.cookies, request.cookies) || !Objects.equals(this.headers, request.headers) || !Objects.equals(this.env, request.env) || !Objects.equals(this.bodySize, request.bodySize) || !Objects.equals(this.fragment, request.fragment) || !Objects.equals(this.apiTarget, request.apiTarget)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(this.url, this.method, this.queryString, this.cookies, this.headers, this.env, this.bodySize, this.fragment, this.apiTarget);
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public String getApiTarget() {
        return this.apiTarget;
    }

    public void setApiTarget(String str) {
        this.apiTarget = str;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.url != null) {
            objectWriter.name("url").value(this.url);
        }
        if (this.method != null) {
            objectWriter.name("method").value(this.method);
        }
        if (this.queryString != null) {
            objectWriter.name(JsonKeys.QUERY_STRING).value(this.queryString);
        }
        if (this.data != null) {
            objectWriter.name("data").value(iLogger, this.data);
        }
        if (this.cookies != null) {
            objectWriter.name("cookies").value(this.cookies);
        }
        if (this.headers != null) {
            objectWriter.name("headers").value(iLogger, this.headers);
        }
        if (this.env != null) {
            objectWriter.name(JsonKeys.ENV).value(iLogger, this.env);
        }
        if (this.other != null) {
            objectWriter.name("other").value(iLogger, this.other);
        }
        if (this.fragment != null) {
            objectWriter.name(JsonKeys.FRAGMENT).value(iLogger, this.fragment);
        }
        if (this.bodySize != null) {
            objectWriter.name("body_size").value(iLogger, this.bodySize);
        }
        if (this.apiTarget != null) {
            objectWriter.name(JsonKeys.API_TARGET).value(iLogger, this.apiTarget);
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

    public static final class Deserializer implements JsonDeserializer<Request> {
        public Request deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            Request request = new Request();
            ConcurrentHashMap concurrentHashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -1650269616:
                        if (nextName.equals(JsonKeys.FRAGMENT)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1077554975:
                        if (nextName.equals("method")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 100589:
                        if (nextName.equals(JsonKeys.ENV)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 116079:
                        if (nextName.equals("url")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 3076010:
                        if (nextName.equals("data")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 106069776:
                        if (nextName.equals("other")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 795307910:
                        if (nextName.equals("headers")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 952189583:
                        if (nextName.equals("cookies")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 1252988030:
                        if (nextName.equals("body_size")) {
                            c = 8;
                            break;
                        }
                        break;
                    case 1595298664:
                        if (nextName.equals(JsonKeys.QUERY_STRING)) {
                            c = 9;
                            break;
                        }
                        break;
                    case 1980646230:
                        if (nextName.equals(JsonKeys.API_TARGET)) {
                            c = 10;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        String unused = request.fragment = jsonObjectReader.nextStringOrNull();
                        break;
                    case 1:
                        String unused2 = request.method = jsonObjectReader.nextStringOrNull();
                        break;
                    case 2:
                        Map map = (Map) jsonObjectReader.nextObjectOrNull();
                        if (map == null) {
                            break;
                        } else {
                            Map unused3 = request.env = CollectionUtils.newConcurrentHashMap(map);
                            break;
                        }
                    case 3:
                        String unused4 = request.url = jsonObjectReader.nextStringOrNull();
                        break;
                    case 4:
                        Object unused5 = request.data = jsonObjectReader.nextObjectOrNull();
                        break;
                    case 5:
                        Map map2 = (Map) jsonObjectReader.nextObjectOrNull();
                        if (map2 == null) {
                            break;
                        } else {
                            Map unused6 = request.other = CollectionUtils.newConcurrentHashMap(map2);
                            break;
                        }
                    case 6:
                        Map map3 = (Map) jsonObjectReader.nextObjectOrNull();
                        if (map3 == null) {
                            break;
                        } else {
                            Map unused7 = request.headers = CollectionUtils.newConcurrentHashMap(map3);
                            break;
                        }
                    case 7:
                        String unused8 = request.cookies = jsonObjectReader.nextStringOrNull();
                        break;
                    case 8:
                        Long unused9 = request.bodySize = jsonObjectReader.nextLongOrNull();
                        break;
                    case 9:
                        String unused10 = request.queryString = jsonObjectReader.nextStringOrNull();
                        break;
                    case 10:
                        String unused11 = request.apiTarget = jsonObjectReader.nextStringOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        jsonObjectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                        break;
                }
            }
            request.setUnknown(concurrentHashMap);
            jsonObjectReader.endObject();
            return request;
        }
    }
}
