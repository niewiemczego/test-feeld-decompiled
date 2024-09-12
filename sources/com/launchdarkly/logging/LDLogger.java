package com.launchdarkly.logging;

import com.launchdarkly.logging.LDLogAdapter;

public final class LDLogger {
    final LDLogAdapter adapter;
    private final LDLogAdapter.Channel channel;
    private final String name;

    LDLogger(String str, LDLogAdapter lDLogAdapter, LDLogAdapter.Channel channel2) {
        this.name = str;
        this.adapter = lDLogAdapter;
        this.channel = channel2;
    }

    public static LDLogger withAdapter(LDLogAdapter lDLogAdapter, String str) {
        return new LDLogger(str, lDLogAdapter, lDLogAdapter.newChannel(str));
    }

    public static LDLogger none() {
        return withAdapter(Logs.none(), "");
    }

    public LDLogger subLogger(String str) {
        if (str == null || str.equals("")) {
            return this;
        }
        String str2 = this.name + "." + str;
        LDLogAdapter lDLogAdapter = this.adapter;
        return new LDLogger(str2, lDLogAdapter, lDLogAdapter.newChannel(str2));
    }

    public boolean isEnabled(LDLogLevel lDLogLevel) {
        return this.channel.isEnabled(lDLogLevel);
    }

    public void debug(Object obj) {
        this.channel.log(LDLogLevel.DEBUG, obj);
    }

    public void debug(String str, Object obj) {
        this.channel.log(LDLogLevel.DEBUG, str, obj);
    }

    public void debug(String str, Object obj, Object obj2) {
        this.channel.log(LDLogLevel.DEBUG, str, obj, obj2);
    }

    public void debug(String str, Object... objArr) {
        this.channel.log(LDLogLevel.DEBUG, str, objArr);
    }

    public void info(Object obj) {
        this.channel.log(LDLogLevel.INFO, obj);
    }

    public void info(String str, Object obj) {
        this.channel.log(LDLogLevel.INFO, str, obj);
    }

    public void info(String str, Object obj, Object obj2) {
        this.channel.log(LDLogLevel.INFO, str, obj, obj2);
    }

    public void info(String str, Object... objArr) {
        this.channel.log(LDLogLevel.INFO, str, objArr);
    }

    public void warn(Object obj) {
        this.channel.log(LDLogLevel.WARN, obj);
    }

    public void warn(String str, Object obj) {
        this.channel.log(LDLogLevel.WARN, str, obj);
    }

    public void warn(String str, Object obj, Object obj2) {
        this.channel.log(LDLogLevel.WARN, str, obj, obj2);
    }

    public void warn(String str, Object... objArr) {
        this.channel.log(LDLogLevel.WARN, str, objArr);
    }

    public void error(Object obj) {
        this.channel.log(LDLogLevel.ERROR, obj);
    }

    public void error(String str, Object obj) {
        this.channel.log(LDLogLevel.ERROR, str, obj);
    }

    public void error(String str, Object obj, Object obj2) {
        this.channel.log(LDLogLevel.ERROR, str, obj, obj2);
    }

    public void error(String str, Object... objArr) {
        this.channel.log(LDLogLevel.ERROR, str, objArr);
    }
}
