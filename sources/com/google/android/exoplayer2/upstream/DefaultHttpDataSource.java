package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Predicate;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

public class DefaultHttpDataSource extends BaseDataSource implements HttpDataSource {
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
    private static final int HTTP_STATUS_PERMANENT_REDIRECT = 308;
    private static final int HTTP_STATUS_TEMPORARY_REDIRECT = 307;
    private static final long MAX_BYTES_TO_DRAIN = 2048;
    private static final int MAX_REDIRECTS = 20;
    private static final String TAG = "DefaultHttpDataSource";
    private final boolean allowCrossProtocolRedirects;
    private long bytesRead;
    private long bytesToRead;
    private final int connectTimeoutMillis;
    private HttpURLConnection connection;
    private Predicate<String> contentTypePredicate;
    private DataSpec dataSpec;
    private final HttpDataSource.RequestProperties defaultRequestProperties;
    private InputStream inputStream;
    private final boolean keepPostFor302Redirects;
    private boolean opened;
    private final int readTimeoutMillis;
    private final HttpDataSource.RequestProperties requestProperties;
    private int responseCode;
    private final String userAgent;

    public static final class Factory implements HttpDataSource.Factory {
        private boolean allowCrossProtocolRedirects;
        private int connectTimeoutMs = 8000;
        private Predicate<String> contentTypePredicate;
        private final HttpDataSource.RequestProperties defaultRequestProperties = new HttpDataSource.RequestProperties();
        private boolean keepPostFor302Redirects;
        private int readTimeoutMs = 8000;
        private TransferListener transferListener;
        private String userAgent;

        public final Factory setDefaultRequestProperties(Map<String, String> map) {
            this.defaultRequestProperties.clearAndSet(map);
            return this;
        }

        public Factory setUserAgent(String str) {
            this.userAgent = str;
            return this;
        }

        public Factory setConnectTimeoutMs(int i) {
            this.connectTimeoutMs = i;
            return this;
        }

        public Factory setReadTimeoutMs(int i) {
            this.readTimeoutMs = i;
            return this;
        }

        public Factory setAllowCrossProtocolRedirects(boolean z) {
            this.allowCrossProtocolRedirects = z;
            return this;
        }

        public Factory setContentTypePredicate(Predicate<String> predicate) {
            this.contentTypePredicate = predicate;
            return this;
        }

        public Factory setTransferListener(TransferListener transferListener2) {
            this.transferListener = transferListener2;
            return this;
        }

        public Factory setKeepPostFor302Redirects(boolean z) {
            this.keepPostFor302Redirects = z;
            return this;
        }

        public DefaultHttpDataSource createDataSource() {
            DefaultHttpDataSource defaultHttpDataSource = new DefaultHttpDataSource(this.userAgent, this.connectTimeoutMs, this.readTimeoutMs, this.allowCrossProtocolRedirects, this.defaultRequestProperties, this.contentTypePredicate, this.keepPostFor302Redirects);
            TransferListener transferListener2 = this.transferListener;
            if (transferListener2 != null) {
                defaultHttpDataSource.addTransferListener(transferListener2);
            }
            return defaultHttpDataSource;
        }
    }

    @Deprecated
    public DefaultHttpDataSource() {
        this((String) null, 8000, 8000);
    }

    @Deprecated
    public DefaultHttpDataSource(String str) {
        this(str, 8000, 8000);
    }

    @Deprecated
    public DefaultHttpDataSource(String str, int i, int i2) {
        this(str, i, i2, false, (HttpDataSource.RequestProperties) null);
    }

    @Deprecated
    public DefaultHttpDataSource(String str, int i, int i2, boolean z, HttpDataSource.RequestProperties requestProperties2) {
        this(str, i, i2, z, requestProperties2, (Predicate<String>) null, false);
    }

    private DefaultHttpDataSource(String str, int i, int i2, boolean z, HttpDataSource.RequestProperties requestProperties2, Predicate<String> predicate, boolean z2) {
        super(true);
        this.userAgent = str;
        this.connectTimeoutMillis = i;
        this.readTimeoutMillis = i2;
        this.allowCrossProtocolRedirects = z;
        this.defaultRequestProperties = requestProperties2;
        this.contentTypePredicate = predicate;
        this.requestProperties = new HttpDataSource.RequestProperties();
        this.keepPostFor302Redirects = z2;
    }

    @Deprecated
    public void setContentTypePredicate(Predicate<String> predicate) {
        this.contentTypePredicate = predicate;
    }

    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public int getResponseCode() {
        int i;
        if (this.connection == null || (i = this.responseCode) <= 0) {
            return -1;
        }
        return i;
    }

    public Map<String, List<String>> getResponseHeaders() {
        if (this.connection == null) {
            return ImmutableMap.of();
        }
        return new NullFilteringHeadersMap(this.connection.getHeaderFields());
    }

    public void setRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        this.requestProperties.set(str, str2);
    }

    public void clearRequestProperty(String str) {
        Assertions.checkNotNull(str);
        this.requestProperties.remove(str);
    }

    public void clearAllRequestProperties() {
        this.requestProperties.clear();
    }

    public long open(DataSpec dataSpec2) throws HttpDataSource.HttpDataSourceException {
        byte[] bArr;
        this.dataSpec = dataSpec2;
        long j = 0;
        this.bytesRead = 0;
        this.bytesToRead = 0;
        transferInitializing(dataSpec2);
        try {
            HttpURLConnection makeConnection = makeConnection(dataSpec2);
            this.connection = makeConnection;
            this.responseCode = makeConnection.getResponseCode();
            String responseMessage = makeConnection.getResponseMessage();
            int i = this.responseCode;
            long j2 = -1;
            if (i < 200 || i > 299) {
                Map headerFields = makeConnection.getHeaderFields();
                if (this.responseCode == 416) {
                    if (dataSpec2.position == HttpUtil.getDocumentSize(makeConnection.getHeaderField(HttpHeaders.CONTENT_RANGE))) {
                        this.opened = true;
                        transferStarted(dataSpec2);
                        if (dataSpec2.length != -1) {
                            return dataSpec2.length;
                        }
                        return 0;
                    }
                }
                InputStream errorStream = makeConnection.getErrorStream();
                if (errorStream != null) {
                    try {
                        bArr = Util.toByteArray(errorStream);
                    } catch (IOException unused) {
                        bArr = Util.EMPTY_BYTE_ARRAY;
                    }
                } else {
                    bArr = Util.EMPTY_BYTE_ARRAY;
                }
                byte[] bArr2 = bArr;
                closeConnectionQuietly();
                throw new HttpDataSource.InvalidResponseCodeException(this.responseCode, responseMessage, this.responseCode == 416 ? new DataSourceException(2008) : null, headerFields, dataSpec2, bArr2);
            }
            String contentType = makeConnection.getContentType();
            Predicate<String> predicate = this.contentTypePredicate;
            if (predicate == null || predicate.apply(contentType)) {
                if (this.responseCode == 200 && dataSpec2.position != 0) {
                    j = dataSpec2.position;
                }
                boolean isCompressed = isCompressed(makeConnection);
                if (isCompressed) {
                    this.bytesToRead = dataSpec2.length;
                } else if (dataSpec2.length != -1) {
                    this.bytesToRead = dataSpec2.length;
                } else {
                    long contentLength = HttpUtil.getContentLength(makeConnection.getHeaderField("Content-Length"), makeConnection.getHeaderField(HttpHeaders.CONTENT_RANGE));
                    if (contentLength != -1) {
                        j2 = contentLength - j;
                    }
                    this.bytesToRead = j2;
                }
                try {
                    this.inputStream = makeConnection.getInputStream();
                    if (isCompressed) {
                        this.inputStream = new GZIPInputStream(this.inputStream);
                    }
                    this.opened = true;
                    transferStarted(dataSpec2);
                    try {
                        skipFully(j, dataSpec2);
                        return this.bytesToRead;
                    } catch (IOException e) {
                        closeConnectionQuietly();
                        if (e instanceof HttpDataSource.HttpDataSourceException) {
                            throw ((HttpDataSource.HttpDataSourceException) e);
                        }
                        throw new HttpDataSource.HttpDataSourceException(e, dataSpec2, 2000, 1);
                    }
                } catch (IOException e2) {
                    closeConnectionQuietly();
                    throw new HttpDataSource.HttpDataSourceException(e2, dataSpec2, 2000, 1);
                }
            } else {
                closeConnectionQuietly();
                throw new HttpDataSource.InvalidContentTypeException(contentType, dataSpec2);
            }
        } catch (IOException e3) {
            closeConnectionQuietly();
            throw HttpDataSource.HttpDataSourceException.createForIOException(e3, dataSpec2, 1);
        }
    }

    public int read(byte[] bArr, int i, int i2) throws HttpDataSource.HttpDataSourceException {
        try {
            return readInternal(bArr, i, i2);
        } catch (IOException e) {
            throw HttpDataSource.HttpDataSourceException.createForIOException(e, (DataSpec) Util.castNonNull(this.dataSpec), 2);
        }
    }

    public void close() throws HttpDataSource.HttpDataSourceException {
        try {
            InputStream inputStream2 = this.inputStream;
            if (inputStream2 != null) {
                long j = this.bytesToRead;
                long j2 = -1;
                if (j != -1) {
                    j2 = j - this.bytesRead;
                }
                maybeTerminateInputStream(this.connection, j2);
                inputStream2.close();
            }
            this.inputStream = null;
            closeConnectionQuietly();
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
        } catch (IOException e) {
            throw new HttpDataSource.HttpDataSourceException(e, (DataSpec) Util.castNonNull(this.dataSpec), 2000, 3);
        } catch (Throwable th) {
            this.inputStream = null;
            closeConnectionQuietly();
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
            throw th;
        }
    }

    private HttpURLConnection makeConnection(DataSpec dataSpec2) throws IOException {
        HttpURLConnection makeConnection;
        DataSpec dataSpec3 = dataSpec2;
        URL url = new URL(dataSpec3.uri.toString());
        int i = dataSpec3.httpMethod;
        byte[] bArr = dataSpec3.httpBody;
        long j = dataSpec3.position;
        long j2 = dataSpec3.length;
        boolean isFlagSet = dataSpec3.isFlagSet(1);
        if (!this.allowCrossProtocolRedirects && !this.keepPostFor302Redirects) {
            return makeConnection(url, i, bArr, j, j2, isFlagSet, true, dataSpec3.httpRequestHeaders);
        }
        URL url2 = url;
        int i2 = i;
        byte[] bArr2 = bArr;
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            if (i3 <= 20) {
                long j3 = j;
                long j4 = j;
                int i5 = i2;
                int i6 = i4;
                URL url3 = url2;
                long j5 = j2;
                makeConnection = makeConnection(url2, i2, bArr2, j3, j2, isFlagSet, false, dataSpec3.httpRequestHeaders);
                int responseCode2 = makeConnection.getResponseCode();
                String headerField = makeConnection.getHeaderField("Location");
                if ((i5 == 1 || i5 == 3) && (responseCode2 == 300 || responseCode2 == 301 || responseCode2 == 302 || responseCode2 == 303 || responseCode2 == 307 || responseCode2 == 308)) {
                    makeConnection.disconnect();
                    url2 = handleRedirect(url3, headerField, dataSpec3);
                    i2 = i5;
                } else if (i5 != 2 || (responseCode2 != 300 && responseCode2 != 301 && responseCode2 != 302 && responseCode2 != 303)) {
                    return makeConnection;
                } else {
                    makeConnection.disconnect();
                    if (!(this.keepPostFor302Redirects && responseCode2 == 302)) {
                        bArr2 = null;
                        i2 = 1;
                    } else {
                        i2 = i5;
                    }
                    url2 = handleRedirect(url3, headerField, dataSpec3);
                }
                i3 = i6;
                j = j4;
                j2 = j5;
            } else {
                throw new HttpDataSource.HttpDataSourceException((IOException) new NoRouteToHostException("Too many redirects: " + i4), dataSpec3, (int) PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
            }
        }
        return makeConnection;
    }

    private HttpURLConnection makeConnection(URL url, int i, byte[] bArr, long j, long j2, boolean z, boolean z2, Map<String, String> map) throws IOException {
        HttpURLConnection openConnection = openConnection(url);
        openConnection.setConnectTimeout(this.connectTimeoutMillis);
        openConnection.setReadTimeout(this.readTimeoutMillis);
        HashMap hashMap = new HashMap();
        HttpDataSource.RequestProperties requestProperties2 = this.defaultRequestProperties;
        if (requestProperties2 != null) {
            hashMap.putAll(requestProperties2.getSnapshot());
        }
        hashMap.putAll(this.requestProperties.getSnapshot());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            openConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String buildRangeRequestHeader = HttpUtil.buildRangeRequestHeader(j, j2);
        if (buildRangeRequestHeader != null) {
            openConnection.setRequestProperty("Range", buildRangeRequestHeader);
        }
        String str = this.userAgent;
        if (str != null) {
            openConnection.setRequestProperty("User-Agent", str);
        }
        openConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, z ? "gzip" : InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
        openConnection.setInstanceFollowRedirects(z2);
        openConnection.setDoOutput(bArr != null);
        openConnection.setRequestMethod(DataSpec.getStringForHttpMethod(i));
        if (bArr != null) {
            openConnection.setFixedLengthStreamingMode(bArr.length);
            openConnection.connect();
            OutputStream outputStream = openConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            openConnection.connect();
        }
        return openConnection;
    }

    /* access modifiers changed from: package-private */
    public HttpURLConnection openConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    private URL handleRedirect(URL url, String str, DataSpec dataSpec2) throws HttpDataSource.HttpDataSourceException {
        if (str != null) {
            try {
                URL url2 = new URL(url, str);
                String protocol = url2.getProtocol();
                if (!"https".equals(protocol) && !"http".equals(protocol)) {
                    throw new HttpDataSource.HttpDataSourceException("Unsupported protocol redirect: " + protocol, dataSpec2, (int) PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
                } else if (this.allowCrossProtocolRedirects || protocol.equals(url.getProtocol())) {
                    return url2;
                } else {
                    throw new HttpDataSource.HttpDataSourceException("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", dataSpec2, (int) PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
                }
            } catch (MalformedURLException e) {
                throw new HttpDataSource.HttpDataSourceException((IOException) e, dataSpec2, (int) PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
            }
        } else {
            throw new HttpDataSource.HttpDataSourceException("Null location redirect", dataSpec2, (int) PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
        }
    }

    private void skipFully(long j, DataSpec dataSpec2) throws IOException {
        if (j != 0) {
            byte[] bArr = new byte[4096];
            while (j > 0) {
                int read = ((InputStream) Util.castNonNull(this.inputStream)).read(bArr, 0, (int) Math.min(j, (long) 4096));
                if (Thread.currentThread().isInterrupted()) {
                    throw new HttpDataSource.HttpDataSourceException((IOException) new InterruptedIOException(), dataSpec2, 2000, 1);
                } else if (read != -1) {
                    j -= (long) read;
                    bytesTransferred(read);
                } else {
                    throw new HttpDataSource.HttpDataSourceException(dataSpec2, 2008, 1);
                }
            }
        }
    }

    private int readInternal(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.bytesToRead;
        if (j != -1) {
            long j2 = j - this.bytesRead;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min((long) i2, j2);
        }
        int read = ((InputStream) Util.castNonNull(this.inputStream)).read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.bytesRead += (long) read;
        bytesTransferred(read);
        return read;
    }

    private static void maybeTerminateInputStream(HttpURLConnection httpURLConnection, long j) {
        if (httpURLConnection != null && Util.SDK_INT >= 19 && Util.SDK_INT <= 20) {
            try {
                InputStream inputStream2 = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream2.read() == -1) {
                        return;
                    }
                } else if (j <= 2048) {
                    return;
                }
                String name = inputStream2.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    Method declaredMethod = ((Class) Assertions.checkNotNull(inputStream2.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream2, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void closeConnectionQuietly() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.e(TAG, "Unexpected error while disconnecting", e);
            }
            this.connection = null;
        }
    }

    private static boolean isCompressed(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    private static class NullFilteringHeadersMap extends ForwardingMap<String, List<String>> {
        private final Map<String, List<String>> headers;

        static /* synthetic */ boolean lambda$keySet$0(String str) {
            return str != null;
        }

        public NullFilteringHeadersMap(Map<String, List<String>> map) {
            this.headers = map;
        }

        /* access modifiers changed from: protected */
        public Map<String, List<String>> delegate() {
            return this.headers;
        }

        public boolean containsKey(Object obj) {
            return obj != null && super.containsKey(obj);
        }

        public List<String> get(Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }

        public Set<String> keySet() {
            return Sets.filter(super.keySet(), new DefaultHttpDataSource$NullFilteringHeadersMap$$ExternalSyntheticLambda0());
        }

        static /* synthetic */ boolean lambda$entrySet$1(Map.Entry entry) {
            return entry.getKey() != null;
        }

        public Set<Map.Entry<String, List<String>>> entrySet() {
            return Sets.filter(super.entrySet(), new DefaultHttpDataSource$NullFilteringHeadersMap$$ExternalSyntheticLambda1());
        }

        public int size() {
            return super.size() - (super.containsKey((Object) null) ? 1 : 0);
        }

        public boolean isEmpty() {
            if (!super.isEmpty()) {
                return super.size() == 1 && super.containsKey((Object) null);
            }
            return true;
        }

        public boolean containsValue(Object obj) {
            return super.standardContainsValue(obj);
        }

        public boolean equals(Object obj) {
            return obj != null && super.standardEquals(obj);
        }

        public int hashCode() {
            return super.standardHashCode();
        }
    }
}
