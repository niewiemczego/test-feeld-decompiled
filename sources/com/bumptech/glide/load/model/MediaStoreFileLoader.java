package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {
    private final Context context;

    public MediaStoreFileLoader(Context context2) {
        this.context = context2;
    }

    public ModelLoader.LoadData<File> buildLoadData(Uri uri, int i, int i2, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), new FilePathFetcher(this.context, uri));
    }

    public boolean handles(Uri uri) {
        return MediaStoreUtil.isMediaStoreUri(uri);
    }

    private static class FilePathFetcher implements DataFetcher<File> {
        private static final String[] PROJECTION = {"_data"};
        private final Context context;
        private final Uri uri;

        public void cancel() {
        }

        public void cleanup() {
        }

        FilePathFetcher(Context context2, Uri uri2) {
            this.context = context2;
            this.uri = uri2;
        }

        public void loadData(Priority priority, DataFetcher.DataCallback<? super File> dataCallback) {
            Cursor query = this.context.getContentResolver().query(this.uri, PROJECTION, (String) null, (String[]) null, (String) null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                dataCallback.onLoadFailed(new FileNotFoundException("Failed to find file path for: " + this.uri));
            } else {
                dataCallback.onDataReady(new File(str));
            }
        }

        public Class<File> getDataClass() {
            return File.class;
        }

        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    public static final class Factory implements ModelLoaderFactory<Uri, File> {
        private final Context context;

        public void teardown() {
        }

        public Factory(Context context2) {
            this.context = context2;
        }

        public ModelLoader<Uri, File> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreFileLoader(this.context);
        }
    }
}
