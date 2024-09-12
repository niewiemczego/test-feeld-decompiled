package com.google.android.exoplayer2.offline;

import java.io.Closeable;

public interface DownloadCursor extends Closeable {
    void close();

    int getCount();

    Download getDownload();

    int getPosition();

    boolean isClosed();

    boolean moveToPosition(int i);

    boolean moveToFirst() {
        return moveToPosition(0);
    }

    boolean moveToLast() {
        return moveToPosition(getCount() - 1);
    }

    boolean moveToNext() {
        return moveToPosition(getPosition() + 1);
    }

    boolean moveToPrevious() {
        return moveToPosition(getPosition() - 1);
    }

    boolean isFirst() {
        return getPosition() == 0 && getCount() != 0;
    }

    boolean isLast() {
        int count = getCount();
        return getPosition() == count + -1 && count != 0;
    }

    boolean isBeforeFirst() {
        if (getCount() == 0 || getPosition() == -1) {
            return true;
        }
        return false;
    }

    boolean isAfterLast() {
        if (getCount() == 0 || getPosition() == getCount()) {
            return true;
        }
        return false;
    }
}
