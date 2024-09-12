package coil.util;

import android.os.SystemClock;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcoil/util/FileDescriptorCounter;", "", "()V", "FILE_DESCRIPTOR_CHECK_INTERVAL_DECODES", "", "FILE_DESCRIPTOR_CHECK_INTERVAL_MILLIS", "FILE_DESCRIPTOR_LIMIT", "TAG", "", "decodesSinceLastFileDescriptorCheck", "fileDescriptorList", "Ljava/io/File;", "hasAvailableFileDescriptors", "", "lastFileDescriptorCheckTimestamp", "", "checkFileDescriptors", "logger", "Lcoil/util/Logger;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HardwareBitmaps.kt */
final class FileDescriptorCounter {
    private static final int FILE_DESCRIPTOR_CHECK_INTERVAL_DECODES = 30;
    private static final int FILE_DESCRIPTOR_CHECK_INTERVAL_MILLIS = 30000;
    private static final int FILE_DESCRIPTOR_LIMIT = 800;
    public static final FileDescriptorCounter INSTANCE = new FileDescriptorCounter();
    private static final String TAG = "FileDescriptorCounter";
    private static int decodesSinceLastFileDescriptorCheck = 30;
    private static final File fileDescriptorList = new File("/proc/self/fd");
    private static boolean hasAvailableFileDescriptors = true;
    private static long lastFileDescriptorCheckTimestamp = SystemClock.uptimeMillis();

    private FileDescriptorCounter() {
    }

    public final synchronized boolean hasAvailableFileDescriptors(Logger logger) {
        if (checkFileDescriptors()) {
            boolean z = false;
            decodesSinceLastFileDescriptorCheck = 0;
            lastFileDescriptorCheckTimestamp = SystemClock.uptimeMillis();
            Object[] list = fileDescriptorList.list();
            if (list == null) {
                list = (Object[]) new String[0];
            }
            int length = list.length;
            if (length < FILE_DESCRIPTOR_LIMIT) {
                z = true;
            }
            hasAvailableFileDescriptors = z;
            if (!z && logger != null && logger.getLevel() <= 5) {
                logger.log(TAG, 5, "Unable to allocate more hardware bitmaps. Number of used file descriptors: " + length, (Throwable) null);
            }
        }
        return hasAvailableFileDescriptors;
    }

    private final boolean checkFileDescriptors() {
        int i = decodesSinceLastFileDescriptorCheck;
        decodesSinceLastFileDescriptorCheck = i + 1;
        return i >= 30 || SystemClock.uptimeMillis() > lastFileDescriptorCheckTimestamp + ((long) 30000);
    }
}
