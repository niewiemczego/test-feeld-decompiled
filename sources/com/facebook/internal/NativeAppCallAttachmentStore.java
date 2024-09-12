package com.facebook.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookContentProvider;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001&B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007J\b\u0010\u000e\u001a\u00020\nH\u0007J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\n\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0007J$\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\n\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0007J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001bH\u0007J\u001e\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\bH\u0002J \u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/facebook/internal/NativeAppCallAttachmentStore;", "", "()V", "ATTACHMENTS_DIR_NAME", "", "TAG", "kotlin.jvm.PlatformType", "attachmentsDirectory", "Ljava/io/File;", "addAttachments", "", "attachments", "", "Lcom/facebook/internal/NativeAppCallAttachmentStore$Attachment;", "cleanupAllAttachments", "cleanupAttachmentsForCall", "callId", "Ljava/util/UUID;", "createAttachment", "attachmentBitmap", "Landroid/graphics/Bitmap;", "attachmentUri", "Landroid/net/Uri;", "ensureAttachmentsDirectoryExists", "getAttachmentFile", "attachmentName", "createDirs", "", "getAttachmentsDirectory", "getAttachmentsDirectoryForCall", "create", "openAttachment", "processAttachmentBitmap", "bitmap", "outputFile", "processAttachmentFile", "imageUri", "isContentUri", "Attachment", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: NativeAppCallAttachmentStore.kt */
public final class NativeAppCallAttachmentStore {
    public static final String ATTACHMENTS_DIR_NAME = "com.facebook.NativeAppCallAttachmentStore.files";
    public static final NativeAppCallAttachmentStore INSTANCE = new NativeAppCallAttachmentStore();
    private static final String TAG = NativeAppCallAttachmentStore.class.getName();
    private static File attachmentsDirectory;

    private NativeAppCallAttachmentStore() {
    }

    @JvmStatic
    public static final Attachment createAttachment(UUID uuid, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(uuid, "callId");
        Intrinsics.checkNotNullParameter(bitmap, "attachmentBitmap");
        return new Attachment(uuid, bitmap, (Uri) null);
    }

    @JvmStatic
    public static final Attachment createAttachment(UUID uuid, Uri uri) {
        Intrinsics.checkNotNullParameter(uuid, "callId");
        Intrinsics.checkNotNullParameter(uri, "attachmentUri");
        return new Attachment(uuid, (Bitmap) null, uri);
    }

    private final void processAttachmentBitmap(Bitmap bitmap, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        } finally {
            Utility utility = Utility.INSTANCE;
            Utility.closeQuietly(fileOutputStream);
        }
    }

    private final void processAttachmentFile(Uri uri, boolean z, File file) throws IOException {
        InputStream inputStream;
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        if (!z) {
            try {
                inputStream = new FileInputStream(uri.getPath());
            } catch (Throwable th) {
                Utility utility = Utility.INSTANCE;
                Utility.closeQuietly(fileOutputStream);
                throw th;
            }
        } else {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            inputStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(uri);
        }
        Utility utility2 = Utility.INSTANCE;
        Utility.copyAndCloseInputStream(inputStream, fileOutputStream);
        Utility utility3 = Utility.INSTANCE;
        Utility.closeQuietly(fileOutputStream);
    }

    @JvmStatic
    public static final void addAttachments(Collection<Attachment> collection) throws FacebookException {
        if (collection != null && !collection.isEmpty()) {
            if (attachmentsDirectory == null) {
                cleanupAllAttachments();
            }
            ensureAttachmentsDirectoryExists();
            List<File> arrayList = new ArrayList<>();
            try {
                for (Attachment next : collection) {
                    if (next.getShouldCreateFile()) {
                        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = INSTANCE;
                        File attachmentFile = getAttachmentFile(next.getCallId(), next.getAttachmentName(), true);
                        if (attachmentFile != null) {
                            arrayList.add(attachmentFile);
                            if (next.getBitmap() != null) {
                                nativeAppCallAttachmentStore.processAttachmentBitmap(next.getBitmap(), attachmentFile);
                            } else if (next.getOriginalUri() != null) {
                                nativeAppCallAttachmentStore.processAttachmentFile(next.getOriginalUri(), next.isContentUri(), attachmentFile);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                Log.e(TAG, Intrinsics.stringPlus("Got unexpected exception:", e));
                for (File file : arrayList) {
                    if (file != null) {
                        try {
                            file.delete();
                        } catch (Exception unused) {
                        }
                    }
                }
                throw new FacebookException((Throwable) e);
            }
        }
    }

    @JvmStatic
    public static final void cleanupAttachmentsForCall(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "callId");
        File attachmentsDirectoryForCall = getAttachmentsDirectoryForCall(uuid, false);
        if (attachmentsDirectoryForCall != null) {
            FilesKt.deleteRecursively(attachmentsDirectoryForCall);
        }
    }

    @JvmStatic
    public static final File openAttachment(UUID uuid, String str) throws FileNotFoundException {
        Utility utility = Utility.INSTANCE;
        if (Utility.isNullOrEmpty(str) || uuid == null) {
            throw new FileNotFoundException();
        }
        try {
            return getAttachmentFile(uuid, str, false);
        } catch (IOException unused) {
            throw new FileNotFoundException();
        }
    }

    @JvmStatic
    public static final synchronized File getAttachmentsDirectory() {
        File file;
        synchronized (NativeAppCallAttachmentStore.class) {
            if (attachmentsDirectory == null) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                attachmentsDirectory = new File(FacebookSdk.getApplicationContext().getCacheDir(), ATTACHMENTS_DIR_NAME);
            }
            file = attachmentsDirectory;
        }
        return file;
    }

    @JvmStatic
    public static final File ensureAttachmentsDirectoryExists() {
        File attachmentsDirectory2 = getAttachmentsDirectory();
        if (attachmentsDirectory2 != null) {
            attachmentsDirectory2.mkdirs();
        }
        return attachmentsDirectory2;
    }

    @JvmStatic
    public static final File getAttachmentsDirectoryForCall(UUID uuid, boolean z) {
        Intrinsics.checkNotNullParameter(uuid, "callId");
        if (attachmentsDirectory == null) {
            return null;
        }
        File file = new File(attachmentsDirectory, uuid.toString());
        if (z && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @JvmStatic
    public static final File getAttachmentFile(UUID uuid, String str, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(uuid, "callId");
        File attachmentsDirectoryForCall = getAttachmentsDirectoryForCall(uuid, z);
        if (attachmentsDirectoryForCall == null) {
            return null;
        }
        try {
            return new File(attachmentsDirectoryForCall, URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            File file = null;
            return null;
        }
    }

    @JvmStatic
    public static final void cleanupAllAttachments() {
        File attachmentsDirectory2 = getAttachmentsDirectory();
        if (attachmentsDirectory2 != null) {
            FilesKt.deleteRecursively(attachmentsDirectory2);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/facebook/internal/NativeAppCallAttachmentStore$Attachment;", "", "callId", "Ljava/util/UUID;", "bitmap", "Landroid/graphics/Bitmap;", "originalUri", "Landroid/net/Uri;", "(Ljava/util/UUID;Landroid/graphics/Bitmap;Landroid/net/Uri;)V", "attachmentName", "", "getAttachmentName", "()Ljava/lang/String;", "attachmentUrl", "getAttachmentUrl", "getBitmap", "()Landroid/graphics/Bitmap;", "getCallId", "()Ljava/util/UUID;", "isContentUri", "", "()Z", "setContentUri", "(Z)V", "getOriginalUri", "()Landroid/net/Uri;", "shouldCreateFile", "getShouldCreateFile", "setShouldCreateFile", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: NativeAppCallAttachmentStore.kt */
    public static final class Attachment {
        private final String attachmentName;
        private final String attachmentUrl;
        private final Bitmap bitmap;
        private final UUID callId;
        private boolean isContentUri;
        private final Uri originalUri;
        private boolean shouldCreateFile;

        public Attachment(UUID uuid, Bitmap bitmap2, Uri uri) {
            String str;
            Intrinsics.checkNotNullParameter(uuid, "callId");
            this.callId = uuid;
            this.bitmap = bitmap2;
            this.originalUri = uri;
            String str2 = null;
            boolean z = true;
            if (uri != null) {
                String scheme = uri.getScheme();
                if (StringsKt.equals("content", scheme, true)) {
                    this.isContentUri = true;
                    String authority = uri.getAuthority();
                    this.shouldCreateFile = (authority == null || StringsKt.startsWith$default(authority, "media", false, 2, (Object) null)) ? false : z;
                } else if (StringsKt.equals("file", uri.getScheme(), true)) {
                    this.shouldCreateFile = true;
                } else {
                    Utility utility = Utility.INSTANCE;
                    if (!Utility.isWebUri(uri)) {
                        throw new FacebookException(Intrinsics.stringPlus("Unsupported scheme for media Uri : ", scheme));
                    }
                }
            } else if (bitmap2 != null) {
                this.shouldCreateFile = true;
            } else {
                throw new FacebookException("Cannot share media without a bitmap or Uri set");
            }
            str2 = this.shouldCreateFile ? UUID.randomUUID().toString() : str2;
            this.attachmentName = str2;
            if (!this.shouldCreateFile) {
                str = String.valueOf(uri);
            } else {
                FacebookContentProvider.Companion companion = FacebookContentProvider.Companion;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                str = companion.getAttachmentUrl(FacebookSdk.getApplicationId(), uuid, str2);
            }
            this.attachmentUrl = str;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final UUID getCallId() {
            return this.callId;
        }

        public final Uri getOriginalUri() {
            return this.originalUri;
        }

        public final String getAttachmentUrl() {
            return this.attachmentUrl;
        }

        public final String getAttachmentName() {
            return this.attachmentName;
        }

        public final boolean isContentUri() {
            return this.isContentUri;
        }

        public final void setContentUri(boolean z) {
            this.isContentUri = z;
        }

        public final boolean getShouldCreateFile() {
            return this.shouldCreateFile;
        }

        public final void setShouldCreateFile(boolean z) {
            this.shouldCreateFile = z;
        }
    }
}
