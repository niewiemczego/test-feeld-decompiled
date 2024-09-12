package zendesk.storage.android.internal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.logger.Logger;
import zendesk.storage.android.Serializer;
import zendesk.storage.android.Storage;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J+\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u001aJ\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J3\u0010\u001c\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u0001H\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lzendesk/storage/android/internal/ComplexStorage;", "Lzendesk/storage/android/Storage;", "namespace", "", "directory", "Ljava/io/File;", "serializer", "Lzendesk/storage/android/Serializer;", "fileOperators", "Lzendesk/storage/android/internal/FileOperators;", "(Ljava/lang/String;Ljava/io/File;Lzendesk/storage/android/Serializer;Lzendesk/storage/android/internal/FileOperators;)V", "getNamespace", "()Ljava/lang/String;", "clear", "", "get", "T", "key", "type", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "getFile", "name", "getFile$zendesk_storage_storage_android", "recursiveClear", "file", "recursiveClear$zendesk_storage_storage_android", "remove", "set", "value", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Class;)V", "Companion", "zendesk.storage_storage-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComplexStorage.kt */
public final class ComplexStorage implements Storage {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "ComplexStorage";
    private final File directory;
    private final FileOperators fileOperators;
    private final String namespace;
    /* access modifiers changed from: private */
    public final Serializer serializer;

    public ComplexStorage(String str, File file, Serializer serializer2, FileOperators fileOperators2) {
        Intrinsics.checkNotNullParameter(str, "namespace");
        Intrinsics.checkNotNullParameter(file, "directory");
        Intrinsics.checkNotNullParameter(serializer2, "serializer");
        Intrinsics.checkNotNullParameter(fileOperators2, "fileOperators");
        this.namespace = str;
        this.directory = file;
        this.serializer = serializer2;
        this.fileOperators = fileOperators2;
        if (!file.isDirectory()) {
            file.mkdirs();
        }
    }

    public String getNamespace() {
        return this.namespace;
    }

    public <T> T get(String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cls, "type");
        File file$zendesk_storage_storage_android = getFile$zendesk_storage_storage_android(str);
        if (!file$zendesk_storage_storage_android.exists()) {
            Logger.w(LOG_TAG, "There is no stored data for the given key", new Object[0]);
            return null;
        }
        try {
            return this.serializer.deserialize(this.fileOperators.reader(file$zendesk_storage_storage_android, ComplexStorage$get$text$1.INSTANCE), cls);
        } catch (FileNotFoundException e) {
            Logger.w(LOG_TAG, String.valueOf(e.getMessage()), e, new Object[0]);
            return null;
        }
    }

    public <T> void set(String str, T t, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cls, "type");
        if (t == null) {
            getFile$zendesk_storage_storage_android(str).delete();
            return;
        }
        try {
            this.fileOperators.writer(getFile$zendesk_storage_storage_android(str), new ComplexStorage$set$1(this, t, cls));
        } catch (IOException e) {
            Logger.w(LOG_TAG, String.valueOf(e.getMessage()), e, new Object[0]);
        }
    }

    public void remove(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        File file$zendesk_storage_storage_android = getFile$zendesk_storage_storage_android(str);
        if (file$zendesk_storage_storage_android.exists()) {
            file$zendesk_storage_storage_android.delete();
        }
    }

    public void clear() {
        recursiveClear$zendesk_storage_storage_android(this.directory);
    }

    public final void recursiveClear$zendesk_storage_storage_android(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!file.isDirectory()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File recursiveClear$zendesk_storage_storage_android : listFiles) {
                recursiveClear$zendesk_storage_storage_android(recursiveClear$zendesk_storage_storage_android);
            }
        }
        file.delete();
    }

    public final File getFile$zendesk_storage_storage_android(String str) {
        File file;
        Intrinsics.checkNotNullParameter(str, "name");
        if (!this.directory.isDirectory()) {
            this.directory.mkdirs();
            return new File(this.directory.getPath(), str);
        }
        File[] listFiles = this.directory.listFiles();
        if (listFiles != null) {
            int i = 0;
            int length = listFiles.length;
            while (true) {
                if (i >= length) {
                    file = null;
                    break;
                }
                file = listFiles[i];
                if (Intrinsics.areEqual((Object) file.getName(), (Object) str)) {
                    break;
                }
                i++;
            }
            if (file != null) {
                return file;
            }
        }
        return new File(this.directory.getPath(), str);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/storage/android/internal/ComplexStorage$Companion;", "", "()V", "LOG_TAG", "", "zendesk.storage_storage-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ComplexStorage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
