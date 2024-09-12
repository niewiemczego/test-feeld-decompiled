package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Iterables;
import java.util.List;
import java.util.Map;

final class RtspHeaders {
    public static final String ACCEPT = "Accept";
    public static final String ALLOW = "Allow";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BANDWIDTH = "Bandwidth";
    public static final String BLOCKSIZE = "Blocksize";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CONNECTION = "Connection";
    public static final String CONTENT_BASE = "Content-Base";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_LANGUAGE = "Content-Language";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_LOCATION = "Content-Location";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CSEQ = "CSeq";
    public static final String DATE = "Date";
    public static final RtspHeaders EMPTY = new Builder().build();
    public static final String EXPIRES = "Expires";
    public static final String LOCATION = "Location";
    public static final String PROXY_AUTHENTICATE = "Proxy-Authenticate";
    public static final String PROXY_REQUIRE = "Proxy-Require";
    public static final String PUBLIC = "Public";
    public static final String RANGE = "Range";
    public static final String RTCP_INTERVAL = "RTCP-Interval";
    public static final String RTP_INFO = "RTP-Info";
    public static final String SCALE = "Scale";
    public static final String SESSION = "Session";
    public static final String SPEED = "Speed";
    public static final String SUPPORTED = "Supported";
    public static final String TIMESTAMP = "Timestamp";
    public static final String TRANSPORT = "Transport";
    public static final String USER_AGENT = "User-Agent";
    public static final String VIA = "Via";
    public static final String WWW_AUTHENTICATE = "WWW-Authenticate";
    private final ImmutableListMultimap<String, String> namesAndValues;

    public static final class Builder {
        /* access modifiers changed from: private */
        public final ImmutableListMultimap.Builder<String, String> namesAndValuesBuilder;

        public Builder() {
            this.namesAndValuesBuilder = new ImmutableListMultimap.Builder<>();
        }

        public Builder(String str, String str2, int i) {
            this();
            add("User-Agent", str);
            add(RtspHeaders.CSEQ, String.valueOf(i));
            if (str2 != null) {
                add(RtspHeaders.SESSION, str2);
            }
        }

        private Builder(ImmutableListMultimap.Builder<String, String> builder) {
            this.namesAndValuesBuilder = builder;
        }

        public Builder add(String str, String str2) {
            this.namesAndValuesBuilder.put(RtspHeaders.convertToStandardHeaderName(str.trim()), str2.trim());
            return this;
        }

        public Builder addAll(List<String> list) {
            for (int i = 0; i < list.size(); i++) {
                String[] splitAtFirst = Util.splitAtFirst(list.get(i), ":\\s?");
                if (splitAtFirst.length == 2) {
                    add(splitAtFirst[0], splitAtFirst[1]);
                }
            }
            return this;
        }

        public Builder addAll(Map<String, String> map) {
            for (Map.Entry next : map.entrySet()) {
                add((String) next.getKey(), (String) next.getValue());
            }
            return this;
        }

        public RtspHeaders build() {
            return new RtspHeaders(this);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RtspHeaders)) {
            return false;
        }
        return this.namesAndValues.equals(((RtspHeaders) obj).namesAndValues);
    }

    public int hashCode() {
        return this.namesAndValues.hashCode();
    }

    public Builder buildUpon() {
        ImmutableListMultimap.Builder builder = new ImmutableListMultimap.Builder();
        builder.putAll(this.namesAndValues);
        return new Builder(builder);
    }

    public ImmutableListMultimap<String, String> asMultiMap() {
        return this.namesAndValues;
    }

    public String get(String str) {
        ImmutableList<String> values = values(str);
        if (values.isEmpty()) {
            return null;
        }
        return (String) Iterables.getLast(values);
    }

    public ImmutableList<String> values(String str) {
        return this.namesAndValues.get((Object) convertToStandardHeaderName(str));
    }

    private RtspHeaders(Builder builder) {
        this.namesAndValues = builder.namesAndValuesBuilder.build();
    }

    /* access modifiers changed from: private */
    public static String convertToStandardHeaderName(String str) {
        if (Ascii.equalsIgnoreCase(str, "Accept")) {
            return "Accept";
        }
        if (Ascii.equalsIgnoreCase(str, "Allow")) {
            return "Allow";
        }
        if (Ascii.equalsIgnoreCase(str, "Authorization")) {
            return "Authorization";
        }
        if (Ascii.equalsIgnoreCase(str, BANDWIDTH)) {
            return BANDWIDTH;
        }
        if (Ascii.equalsIgnoreCase(str, BLOCKSIZE)) {
            return BLOCKSIZE;
        }
        if (Ascii.equalsIgnoreCase(str, "Cache-Control")) {
            return "Cache-Control";
        }
        if (Ascii.equalsIgnoreCase(str, "Connection")) {
            return "Connection";
        }
        if (Ascii.equalsIgnoreCase(str, CONTENT_BASE)) {
            return CONTENT_BASE;
        }
        if (Ascii.equalsIgnoreCase(str, "Content-Encoding")) {
            return "Content-Encoding";
        }
        if (Ascii.equalsIgnoreCase(str, "Content-Language")) {
            return "Content-Language";
        }
        if (Ascii.equalsIgnoreCase(str, "Content-Length")) {
            return "Content-Length";
        }
        if (Ascii.equalsIgnoreCase(str, "Content-Location")) {
            return "Content-Location";
        }
        if (Ascii.equalsIgnoreCase(str, "Content-Type")) {
            return "Content-Type";
        }
        if (Ascii.equalsIgnoreCase(str, CSEQ)) {
            return CSEQ;
        }
        if (Ascii.equalsIgnoreCase(str, "Date")) {
            return "Date";
        }
        if (Ascii.equalsIgnoreCase(str, "Expires")) {
            return "Expires";
        }
        if (Ascii.equalsIgnoreCase(str, "Location")) {
            return "Location";
        }
        if (Ascii.equalsIgnoreCase(str, "Proxy-Authenticate")) {
            return "Proxy-Authenticate";
        }
        if (Ascii.equalsIgnoreCase(str, PROXY_REQUIRE)) {
            return PROXY_REQUIRE;
        }
        if (Ascii.equalsIgnoreCase(str, PUBLIC)) {
            return PUBLIC;
        }
        if (Ascii.equalsIgnoreCase(str, "Range")) {
            return "Range";
        }
        if (Ascii.equalsIgnoreCase(str, RTP_INFO)) {
            return RTP_INFO;
        }
        if (Ascii.equalsIgnoreCase(str, RTCP_INTERVAL)) {
            return RTCP_INTERVAL;
        }
        if (Ascii.equalsIgnoreCase(str, SCALE)) {
            return SCALE;
        }
        if (Ascii.equalsIgnoreCase(str, SESSION)) {
            return SESSION;
        }
        if (Ascii.equalsIgnoreCase(str, SPEED)) {
            return SPEED;
        }
        if (Ascii.equalsIgnoreCase(str, SUPPORTED)) {
            return SUPPORTED;
        }
        if (Ascii.equalsIgnoreCase(str, TIMESTAMP)) {
            return TIMESTAMP;
        }
        if (Ascii.equalsIgnoreCase(str, TRANSPORT)) {
            return TRANSPORT;
        }
        if (Ascii.equalsIgnoreCase(str, "User-Agent")) {
            return "User-Agent";
        }
        if (Ascii.equalsIgnoreCase(str, "Via")) {
            return "Via";
        }
        return Ascii.equalsIgnoreCase(str, "WWW-Authenticate") ? "WWW-Authenticate" : str;
    }
}
