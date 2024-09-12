package com.facebook.internal;

import com.facebook.internal.FileLruCache;
import java.io.File;
import java.io.FilenameFilter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FileLruCache$BufferFile$$ExternalSyntheticLambda1 implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return FileLruCache.BufferFile.m339filterExcludeNonBufferFiles$lambda1(file, str);
    }
}
