package com.facebook.react.modules.image;

import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.fresco.ReactNetworkImageRequest;
import com.facebook.react.views.image.ReactCallerContextFactory;
import com.facebook.react.views.imagehelper.ImageSource;

@ReactModule(name = "ImageLoader")
public class ImageLoaderModule extends NativeImageLoaderAndroidSpec implements LifecycleEventListener {
    private static final String ERROR_GET_SIZE_FAILURE = "E_GET_SIZE_FAILURE";
    private static final String ERROR_INVALID_URI = "E_INVALID_URI";
    private static final String ERROR_PREFETCH_FAILURE = "E_PREFETCH_FAILURE";
    public static final String NAME = "ImageLoader";
    private final Object mCallerContext;
    private ReactCallerContextFactory mCallerContextFactory;
    private final Object mEnqueuedRequestMonitor;
    private final SparseArray<DataSource<Void>> mEnqueuedRequests;
    private ImagePipeline mImagePipeline;

    public String getName() {
        return NAME;
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    public ImageLoaderModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mEnqueuedRequestMonitor = new Object();
        this.mEnqueuedRequests = new SparseArray<>();
        this.mImagePipeline = null;
        this.mCallerContext = this;
    }

    public ImageLoaderModule(ReactApplicationContext reactApplicationContext, Object obj) {
        super(reactApplicationContext);
        this.mEnqueuedRequestMonitor = new Object();
        this.mEnqueuedRequests = new SparseArray<>();
        this.mImagePipeline = null;
        this.mCallerContext = obj;
    }

    public ImageLoaderModule(ReactApplicationContext reactApplicationContext, ImagePipeline imagePipeline, ReactCallerContextFactory reactCallerContextFactory) {
        super(reactApplicationContext);
        this.mEnqueuedRequestMonitor = new Object();
        this.mEnqueuedRequests = new SparseArray<>();
        this.mCallerContextFactory = reactCallerContextFactory;
        this.mImagePipeline = imagePipeline;
        this.mCallerContext = null;
    }

    private Object getCallerContext() {
        ReactCallerContextFactory reactCallerContextFactory = this.mCallerContextFactory;
        if (reactCallerContextFactory != null) {
            return reactCallerContextFactory.getOrCreateCallerContext("", "");
        }
        return this.mCallerContext;
    }

    /* access modifiers changed from: private */
    public ImagePipeline getImagePipeline() {
        ImagePipeline imagePipeline = this.mImagePipeline;
        return imagePipeline != null ? imagePipeline : Fresco.getImagePipeline();
    }

    @ReactMethod
    public void getSize(String str, final Promise promise) {
        if (str == null || str.isEmpty()) {
            promise.reject(ERROR_INVALID_URI, "Cannot get the size of an image for an empty URI");
            return;
        }
        getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(new ImageSource(getReactApplicationContext(), str).getUri()).build(), getCallerContext()).subscribe(new BaseDataSubscriber<CloseableReference<CloseableImage>>() {
            /* access modifiers changed from: protected */
            public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                if (dataSource.isFinished()) {
                    CloseableReference result = dataSource.getResult();
                    if (result != null) {
                        try {
                            CloseableImage closeableImage = (CloseableImage) result.get();
                            WritableMap createMap = Arguments.createMap();
                            createMap.putInt("width", closeableImage.getWidth());
                            createMap.putInt("height", closeableImage.getHeight());
                            promise.resolve(createMap);
                        } catch (Exception e) {
                            promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, (Throwable) e);
                        } catch (Throwable th) {
                            CloseableReference.closeSafely((CloseableReference<?>) result);
                            throw th;
                        }
                        CloseableReference.closeSafely((CloseableReference<?>) result);
                        return;
                    }
                    promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE);
                }
            }

            /* access modifiers changed from: protected */
            public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, dataSource.getFailureCause());
            }
        }, CallerThreadExecutor.getInstance());
    }

    @ReactMethod
    public void getSizeWithHeaders(String str, ReadableMap readableMap, final Promise promise) {
        if (str == null || str.isEmpty()) {
            promise.reject(ERROR_INVALID_URI, "Cannot get the size of an image for an empty URI");
            return;
        }
        getImagePipeline().fetchDecodedImage(ReactNetworkImageRequest.fromBuilderWithHeaders(ImageRequestBuilder.newBuilderWithSource(new ImageSource(getReactApplicationContext(), str).getUri()), readableMap), getCallerContext()).subscribe(new BaseDataSubscriber<CloseableReference<CloseableImage>>() {
            /* access modifiers changed from: protected */
            public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                if (dataSource.isFinished()) {
                    CloseableReference result = dataSource.getResult();
                    if (result != null) {
                        try {
                            CloseableImage closeableImage = (CloseableImage) result.get();
                            WritableMap createMap = Arguments.createMap();
                            createMap.putInt("width", closeableImage.getWidth());
                            createMap.putInt("height", closeableImage.getHeight());
                            promise.resolve(createMap);
                        } catch (Exception e) {
                            promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, (Throwable) e);
                        } catch (Throwable th) {
                            CloseableReference.closeSafely((CloseableReference<?>) result);
                            throw th;
                        }
                        CloseableReference.closeSafely((CloseableReference<?>) result);
                        return;
                    }
                    promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE);
                }
            }

            /* access modifiers changed from: protected */
            public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, dataSource.getFailureCause());
            }
        }, CallerThreadExecutor.getInstance());
    }

    public void prefetchImage(String str, double d, final Promise promise) {
        final int i = (int) d;
        if (str == null || str.isEmpty()) {
            promise.reject(ERROR_INVALID_URI, "Cannot prefetch an image for an empty URI");
            return;
        }
        DataSource<Void> prefetchToDiskCache = getImagePipeline().prefetchToDiskCache(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).build(), getCallerContext());
        AnonymousClass3 r4 = new BaseDataSubscriber<Void>() {
            /* access modifiers changed from: protected */
            public void onNewResultImpl(DataSource<Void> dataSource) {
                if (dataSource.isFinished()) {
                    try {
                        DataSource unused = ImageLoaderModule.this.removeRequest(i);
                        promise.resolve(true);
                    } catch (Exception e) {
                        promise.reject(ImageLoaderModule.ERROR_PREFETCH_FAILURE, (Throwable) e);
                    } catch (Throwable th) {
                        dataSource.close();
                        throw th;
                    }
                    dataSource.close();
                }
            }

            /* access modifiers changed from: protected */
            public void onFailureImpl(DataSource<Void> dataSource) {
                try {
                    DataSource unused = ImageLoaderModule.this.removeRequest(i);
                    promise.reject(ImageLoaderModule.ERROR_PREFETCH_FAILURE, dataSource.getFailureCause());
                } finally {
                    dataSource.close();
                }
            }
        };
        registerRequest(i, prefetchToDiskCache);
        prefetchToDiskCache.subscribe(r4, CallerThreadExecutor.getInstance());
    }

    public void abortRequest(double d) {
        DataSource<Void> removeRequest = removeRequest((int) d);
        if (removeRequest != null) {
            removeRequest.close();
        }
    }

    @ReactMethod
    public void queryCache(final ReadableArray readableArray, final Promise promise) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                WritableMap createMap = Arguments.createMap();
                ImagePipeline access$100 = ImageLoaderModule.this.getImagePipeline();
                for (int i = 0; i < readableArray.size(); i++) {
                    String string = readableArray.getString(i);
                    if (!TextUtils.isEmpty(string)) {
                        Uri parse = Uri.parse(string);
                        if (access$100.isInBitmapMemoryCache(parse)) {
                            createMap.putString(string, "memory");
                        } else if (access$100.isInDiskCacheSync(parse)) {
                            createMap.putString(string, "disk");
                        }
                    }
                }
                promise.resolve(createMap);
            }
        }.executeOnExecutor(GuardedAsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private void registerRequest(int i, DataSource<Void> dataSource) {
        synchronized (this.mEnqueuedRequestMonitor) {
            this.mEnqueuedRequests.put(i, dataSource);
        }
    }

    /* access modifiers changed from: private */
    public DataSource<Void> removeRequest(int i) {
        DataSource<Void> dataSource;
        synchronized (this.mEnqueuedRequestMonitor) {
            dataSource = this.mEnqueuedRequests.get(i);
            this.mEnqueuedRequests.remove(i);
        }
        return dataSource;
    }

    public void onHostDestroy() {
        synchronized (this.mEnqueuedRequestMonitor) {
            int size = this.mEnqueuedRequests.size();
            for (int i = 0; i < size; i++) {
                DataSource valueAt = this.mEnqueuedRequests.valueAt(i);
                if (valueAt != null) {
                    valueAt.close();
                }
            }
            this.mEnqueuedRequests.clear();
        }
    }
}
