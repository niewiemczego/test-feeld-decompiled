package io.sentry.android.core.internal.threaddump;

public final class Line {
    public int lineno;
    public String text;

    public Line(int i, String str) {
        this.lineno = i;
        this.text = str;
    }
}
