package com.launchdarkly.logging;

import com.launchdarkly.logging.LDLogAdapter;
import com.launchdarkly.logging.SimpleLogging;
import java.io.PrintStream;

public abstract class Logs {
    private Logs() {
    }

    public static LDLogAdapter none() {
        return NullLogging.INSTANCE;
    }

    public static LDLogAdapter level(LDLogAdapter lDLogAdapter, LDLogLevel lDLogLevel) {
        if (lDLogAdapter instanceof LDLogAdapter.IsConfiguredExternally) {
            return lDLogAdapter;
        }
        return new LevelFilter(lDLogAdapter, lDLogLevel);
    }

    public static LDLogAdapter basic() {
        return level(toConsole(), LDLogLevel.INFO);
    }

    public static LogCapture capture() {
        return new LogCapture();
    }

    public static SimpleLogging toConsole() {
        return toStream(System.err);
    }

    public static SimpleLogging toStream(PrintStream printStream) {
        return toMethod(new StreamLineWriter(printStream));
    }

    public static SimpleLogging toMethod(SimpleLogging.LineWriter lineWriter) {
        return new SimpleLogging(lineWriter, (String) null, SimpleLogging.getDefaultTimestampFormat());
    }

    public static LDLogAdapter toJavaUtilLogging() {
        return LDJavaUtilLogging.INSTANCE;
    }

    public static LDLogAdapter toMultiple(LDLogAdapter... lDLogAdapterArr) {
        return (lDLogAdapterArr == null || lDLogAdapterArr.length == 0) ? none() : new MultiLogging(lDLogAdapterArr);
    }

    static final class StreamLineWriter implements SimpleLogging.LineWriter {
        final PrintStream stream;

        StreamLineWriter(PrintStream printStream) {
            this.stream = printStream;
        }

        public void writeLine(String str) {
            this.stream.println(str);
        }
    }
}
