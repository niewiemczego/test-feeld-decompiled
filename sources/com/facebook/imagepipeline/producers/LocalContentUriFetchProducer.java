package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.ContactsContract;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class LocalContentUriFetchProducer extends LocalFetchProducer {
    public static final String PRODUCER_NAME = "LocalContentUriFetchProducer";
    private static final String[] PROJECTION = {"_id", "_data"};
    private final ContentResolver mContentResolver;

    /* access modifiers changed from: protected */
    public String getProducerName() {
        return PRODUCER_NAME;
    }

    public LocalContentUriFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.mContentResolver = contentResolver;
    }

    /* access modifiers changed from: protected */
    public EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        EncodedImage cameraImage;
        InputStream inputStream;
        Uri sourceUri = imageRequest.getSourceUri();
        if (UriUtil.isLocalContactUri(sourceUri)) {
            if (sourceUri.toString().endsWith("/photo")) {
                inputStream = this.mContentResolver.openInputStream(sourceUri);
            } else if (sourceUri.toString().endsWith("/display_photo")) {
                try {
                    inputStream = this.mContentResolver.openAssetFileDescriptor(sourceUri, "r").createInputStream();
                } catch (IOException unused) {
                    throw new IOException("Contact photo does not exist: " + sourceUri);
                }
            } else {
                InputStream openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.mContentResolver, sourceUri);
                if (openContactPhotoInputStream != null) {
                    inputStream = openContactPhotoInputStream;
                } else {
                    throw new IOException("Contact photo does not exist: " + sourceUri);
                }
            }
            return getEncodedImage(inputStream, -1);
        } else if (!UriUtil.isLocalCameraUri(sourceUri) || (cameraImage = getCameraImage(sourceUri)) == null) {
            return getEncodedImage(this.mContentResolver.openInputStream(sourceUri), -1);
        } else {
            return cameraImage;
        }
    }

    @Nullable
    private EncodedImage getCameraImage(Uri uri) throws IOException {
        try {
            ParcelFileDescriptor openFileDescriptor = this.mContentResolver.openFileDescriptor(uri, "r");
            return getEncodedImage(new FileInputStream(openFileDescriptor.getFileDescriptor()), (int) openFileDescriptor.getStatSize());
        } catch (FileNotFoundException unused) {
            return null;
        }
    }
}
