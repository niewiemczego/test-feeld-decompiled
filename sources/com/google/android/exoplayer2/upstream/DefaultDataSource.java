package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DefaultDataSource implements DataSource {
    private static final String SCHEME_ANDROID_RESOURCE = "android.resource";
    private static final String SCHEME_ASSET = "asset";
    private static final String SCHEME_CONTENT = "content";
    private static final String SCHEME_DATA = "data";
    private static final String SCHEME_RAW = "rawresource";
    private static final String SCHEME_RTMP = "rtmp";
    private static final String SCHEME_UDP = "udp";
    private static final String TAG = "DefaultDataSource";
    private DataSource assetDataSource;
    private final DataSource baseDataSource;
    private DataSource contentDataSource;
    private final Context context;
    private DataSource dataSchemeDataSource;
    private DataSource dataSource;
    private DataSource fileDataSource;
    private DataSource rawResourceDataSource;
    private DataSource rtmpDataSource;
    private final List<TransferListener> transferListeners;
    private DataSource udpDataSource;

    public static final class Factory implements DataSource.Factory {
        private final DataSource.Factory baseDataSourceFactory;
        private final Context context;
        private TransferListener transferListener;

        public Factory(Context context2) {
            this(context2, new DefaultHttpDataSource.Factory());
        }

        public Factory(Context context2, DataSource.Factory factory) {
            this.context = context2.getApplicationContext();
            this.baseDataSourceFactory = factory;
        }

        public Factory setTransferListener(TransferListener transferListener2) {
            this.transferListener = transferListener2;
            return this;
        }

        public DefaultDataSource createDataSource() {
            DefaultDataSource defaultDataSource = new DefaultDataSource(this.context, this.baseDataSourceFactory.createDataSource());
            TransferListener transferListener2 = this.transferListener;
            if (transferListener2 != null) {
                defaultDataSource.addTransferListener(transferListener2);
            }
            return defaultDataSource;
        }
    }

    public DefaultDataSource(Context context2, boolean z) {
        this(context2, (String) null, 8000, 8000, z);
    }

    public DefaultDataSource(Context context2, String str, boolean z) {
        this(context2, str, 8000, 8000, z);
    }

    public DefaultDataSource(Context context2, String str, int i, int i2, boolean z) {
        this(context2, (DataSource) new DefaultHttpDataSource.Factory().setUserAgent(str).setConnectTimeoutMs(i).setReadTimeoutMs(i2).setAllowCrossProtocolRedirects(z).createDataSource());
    }

    public DefaultDataSource(Context context2, DataSource dataSource2) {
        this.context = context2.getApplicationContext();
        this.baseDataSource = (DataSource) Assertions.checkNotNull(dataSource2);
        this.transferListeners = new ArrayList();
    }

    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.baseDataSource.addTransferListener(transferListener);
        this.transferListeners.add(transferListener);
        maybeAddListenerToDataSource(this.fileDataSource, transferListener);
        maybeAddListenerToDataSource(this.assetDataSource, transferListener);
        maybeAddListenerToDataSource(this.contentDataSource, transferListener);
        maybeAddListenerToDataSource(this.rtmpDataSource, transferListener);
        maybeAddListenerToDataSource(this.udpDataSource, transferListener);
        maybeAddListenerToDataSource(this.dataSchemeDataSource, transferListener);
        maybeAddListenerToDataSource(this.rawResourceDataSource, transferListener);
    }

    public long open(DataSpec dataSpec) throws IOException {
        Assertions.checkState(this.dataSource == null);
        String scheme = dataSpec.uri.getScheme();
        if (Util.isLocalFileUri(dataSpec.uri)) {
            String path = dataSpec.uri.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.dataSource = getFileDataSource();
            } else {
                this.dataSource = getAssetDataSource();
            }
        } else if ("asset".equals(scheme)) {
            this.dataSource = getAssetDataSource();
        } else if ("content".equals(scheme)) {
            this.dataSource = getContentDataSource();
        } else if (SCHEME_RTMP.equals(scheme)) {
            this.dataSource = getRtmpDataSource();
        } else if (SCHEME_UDP.equals(scheme)) {
            this.dataSource = getUdpDataSource();
        } else if ("data".equals(scheme)) {
            this.dataSource = getDataSchemeDataSource();
        } else if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
            this.dataSource = getRawResourceDataSource();
        } else {
            this.dataSource = this.baseDataSource;
        }
        return this.dataSource.open(dataSpec);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        return ((DataSource) Assertions.checkNotNull(this.dataSource)).read(bArr, i, i2);
    }

    public Uri getUri() {
        DataSource dataSource2 = this.dataSource;
        if (dataSource2 == null) {
            return null;
        }
        return dataSource2.getUri();
    }

    public Map<String, List<String>> getResponseHeaders() {
        DataSource dataSource2 = this.dataSource;
        return dataSource2 == null ? Collections.emptyMap() : dataSource2.getResponseHeaders();
    }

    public void close() throws IOException {
        DataSource dataSource2 = this.dataSource;
        if (dataSource2 != null) {
            try {
                dataSource2.close();
            } finally {
                this.dataSource = null;
            }
        }
    }

    private DataSource getUdpDataSource() {
        if (this.udpDataSource == null) {
            UdpDataSource udpDataSource2 = new UdpDataSource();
            this.udpDataSource = udpDataSource2;
            addListenersToDataSource(udpDataSource2);
        }
        return this.udpDataSource;
    }

    private DataSource getFileDataSource() {
        if (this.fileDataSource == null) {
            FileDataSource fileDataSource2 = new FileDataSource();
            this.fileDataSource = fileDataSource2;
            addListenersToDataSource(fileDataSource2);
        }
        return this.fileDataSource;
    }

    private DataSource getAssetDataSource() {
        if (this.assetDataSource == null) {
            AssetDataSource assetDataSource2 = new AssetDataSource(this.context);
            this.assetDataSource = assetDataSource2;
            addListenersToDataSource(assetDataSource2);
        }
        return this.assetDataSource;
    }

    private DataSource getContentDataSource() {
        if (this.contentDataSource == null) {
            ContentDataSource contentDataSource2 = new ContentDataSource(this.context);
            this.contentDataSource = contentDataSource2;
            addListenersToDataSource(contentDataSource2);
        }
        return this.contentDataSource;
    }

    private DataSource getRtmpDataSource() {
        if (this.rtmpDataSource == null) {
            try {
                DataSource dataSource2 = (DataSource) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                this.rtmpDataSource = dataSource2;
                addListenersToDataSource(dataSource2);
            } catch (ClassNotFoundException unused) {
                Log.w(TAG, "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating RTMP extension", e);
            }
            if (this.rtmpDataSource == null) {
                this.rtmpDataSource = this.baseDataSource;
            }
        }
        return this.rtmpDataSource;
    }

    private DataSource getDataSchemeDataSource() {
        if (this.dataSchemeDataSource == null) {
            DataSchemeDataSource dataSchemeDataSource2 = new DataSchemeDataSource();
            this.dataSchemeDataSource = dataSchemeDataSource2;
            addListenersToDataSource(dataSchemeDataSource2);
        }
        return this.dataSchemeDataSource;
    }

    private DataSource getRawResourceDataSource() {
        if (this.rawResourceDataSource == null) {
            RawResourceDataSource rawResourceDataSource2 = new RawResourceDataSource(this.context);
            this.rawResourceDataSource = rawResourceDataSource2;
            addListenersToDataSource(rawResourceDataSource2);
        }
        return this.rawResourceDataSource;
    }

    private void addListenersToDataSource(DataSource dataSource2) {
        for (int i = 0; i < this.transferListeners.size(); i++) {
            dataSource2.addTransferListener(this.transferListeners.get(i));
        }
    }

    private void maybeAddListenerToDataSource(DataSource dataSource2, TransferListener transferListener) {
        if (dataSource2 != null) {
            dataSource2.addTransferListener(transferListener);
        }
    }
}
