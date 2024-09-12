package io.sentry.android.core.internal.threaddump;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public final class Lines {
    private final ArrayList<? extends Line> mList;
    private final int mMax;
    private final int mMin = 0;
    public int pos;

    public static Lines readLines(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        try {
            Lines readLines = readLines(bufferedReader);
            bufferedReader.close();
            return readLines;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static Lines readLines(BufferedReader bufferedReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return new Lines(arrayList);
            }
            i++;
            arrayList.add(new Line(i, readLine));
        }
    }

    public Lines(ArrayList<? extends Line> arrayList) {
        this.mList = arrayList;
        this.mMax = arrayList.size();
    }

    public boolean hasNext() {
        return this.pos < this.mMax;
    }

    public Line next() {
        int i = this.pos;
        if (i < this.mMin || i >= this.mMax) {
            return null;
        }
        ArrayList<? extends Line> arrayList = this.mList;
        this.pos = i + 1;
        return (Line) arrayList.get(i);
    }

    public void rewind() {
        this.pos--;
    }
}
