package com.braze.support;

import com.braze.support.BrazeLogger;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;

public final class i {
    public static final i a = new i();

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception while trying to read BrazeLogger tag from system properties.";
        }
    }

    private i() {
    }

    public static final String a(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            InputStream inputStream = Runtime.getRuntime().exec(new String[]{"/system/bin/getprop", str}).getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "getRuntime()\n           …             .inputStream");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            String readLine = (inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192)).readLine();
            Intrinsics.checkNotNullExpressionValue(readLine, "{\n            Runtime.ge…er().readLine()\n        }");
            return readLine;
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) a, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) a.b);
            return "";
        }
    }
}
