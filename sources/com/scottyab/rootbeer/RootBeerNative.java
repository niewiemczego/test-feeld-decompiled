package com.scottyab.rootbeer;

import com.scottyab.rootbeer.util.QLog;

public class RootBeerNative {
    private static boolean libraryLoaded = true;

    public native int checkForRoot(Object[] objArr);

    public native int setLogDebugMessages(boolean z);

    static {
        try {
            System.loadLibrary("toolChecker");
        } catch (UnsatisfiedLinkError e) {
            QLog.e((Object) e);
        }
    }

    public boolean wasNativeLibraryLoaded() {
        return libraryLoaded;
    }
}
