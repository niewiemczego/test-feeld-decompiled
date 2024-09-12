package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GlideException extends Exception {
    private static final StackTraceElement[] EMPTY_ELEMENTS = new StackTraceElement[0];
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;
    private Exception exception;
    private Key key;

    public Throwable fillInStackTrace() {
        return this;
    }

    public GlideException(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    public GlideException(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    public GlideException(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = list;
    }

    /* access modifiers changed from: package-private */
    public void setLoggingDetails(Key key2, DataSource dataSource2) {
        setLoggingDetails(key2, dataSource2, (Class<?>) null);
    }

    /* access modifiers changed from: package-private */
    public void setLoggingDetails(Key key2, DataSource dataSource2, Class<?> cls) {
        this.key = key2;
        this.dataSource = dataSource2;
        this.dataClass = cls;
    }

    public void setOrigin(Exception exc) {
        this.exception = exc;
    }

    public Exception getOrigin() {
        return this.exception;
    }

    public List<Throwable> getCauses() {
        return this.causes;
    }

    public List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        addRootCauses(this, arrayList);
        return arrayList;
    }

    public void logRootCauses(String str) {
        List<Throwable> rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            Log.i(str, "Root cause (" + i2 + " of " + size + ")", rootCauses.get(i));
            i = i2;
        }
    }

    private void addRootCauses(Throwable th, List<Throwable> list) {
        if (th instanceof GlideException) {
            for (Throwable addRootCauses : ((GlideException) th).getCauses()) {
                addRootCauses(addRootCauses, list);
            }
            return;
        }
        list.add(th);
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        printStackTrace((Appendable) printStream);
    }

    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace((Appendable) printWriter);
    }

    private void printStackTrace(Appendable appendable) {
        appendExceptionMessage(this, appendable);
        appendCauses(getCauses(), new IndentedAppendable(appendable));
    }

    public String getMessage() {
        String str = "";
        StringBuilder append = new StringBuilder(71).append(this.detailMessage).append(this.dataClass != null ? ", " + this.dataClass : str).append(this.dataSource != null ? ", " + this.dataSource : str);
        if (this.key != null) {
            str = ", " + this.key;
        }
        StringBuilder append2 = append.append(str);
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return append2.toString();
        }
        if (rootCauses.size() == 1) {
            append2.append("\nThere was 1 root cause:");
        } else {
            append2.append("\nThere were ").append(rootCauses.size()).append(" root causes:");
        }
        for (Throwable next : rootCauses) {
            append2.append(10).append(next.getClass().getName()).append('(').append(next.getMessage()).append(')');
        }
        append2.append("\n call GlideException#logRootCauses(String) for more detail");
        return append2.toString();
    }

    private static void appendExceptionMessage(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append(10);
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private static void appendCauses(List<Throwable> list, Appendable appendable) {
        try {
            appendCausesWrapped(list, appendable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void appendCausesWrapped(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i);
            if (th instanceof GlideException) {
                ((GlideException) th).printStackTrace(appendable);
            } else {
                appendExceptionMessage(th, appendable);
            }
            i = i2;
        }
    }

    private static final class IndentedAppendable implements Appendable {
        private static final String EMPTY_SEQUENCE = "";
        private static final String INDENT = "  ";
        private final Appendable appendable;
        private boolean printedNewLine = true;

        private CharSequence safeSequence(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        IndentedAppendable(Appendable appendable2) {
            this.appendable = appendable2;
        }

        public Appendable append(char c) throws IOException {
            boolean z = false;
            if (this.printedNewLine) {
                this.printedNewLine = false;
                this.appendable.append(INDENT);
            }
            if (c == 10) {
                z = true;
            }
            this.printedNewLine = z;
            this.appendable.append(c);
            return this;
        }

        public Appendable append(CharSequence charSequence) throws IOException {
            CharSequence safeSequence = safeSequence(charSequence);
            return append(safeSequence, 0, safeSequence.length());
        }

        public Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
            CharSequence safeSequence = safeSequence(charSequence);
            boolean z = false;
            if (this.printedNewLine) {
                this.printedNewLine = false;
                this.appendable.append(INDENT);
            }
            if (safeSequence.length() > 0 && safeSequence.charAt(i2 - 1) == 10) {
                z = true;
            }
            this.printedNewLine = z;
            this.appendable.append(safeSequence, i, i2);
            return this;
        }
    }
}
