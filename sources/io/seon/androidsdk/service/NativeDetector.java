package io.seon.androidsdk.service;

import android.content.Context;
import com.getkeepsafe.relinker.ReLinker;

public class NativeDetector {
    private static boolean libraryLoaded = false;

    static native String getLDPreloadString();

    static void loadLibrary(Context context) {
        if (!libraryLoaded) {
            ReLinker.loadLibrary(context, "natdet");
            libraryLoaded = true;
        }
    }
}
