package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableSet;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfigInterface;
import com.facebook.imagepipeline.image.EncodedImageOrigin;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public class BaseProducerContext implements ProducerContext {
    public static final Set<String> INITIAL_KEYS = ImmutableSet.of("id", ProducerContext.ExtraKeys.SOURCE_URI);
    private static final String ORIGIN_SUBCATEGORY_DEFAULT = "default";
    private final List<ProducerContextCallbacks> mCallbacks;
    private final Object mCallerContext;
    private EncodedImageOrigin mEncodedImageOrigin;
    private final Map<String, Object> mExtras;
    private final String mId;
    private final ImagePipelineConfigInterface mImagePipelineConfig;
    private final ImageRequest mImageRequest;
    private boolean mIsCancelled;
    private boolean mIsIntermediateResultExpected;
    private boolean mIsPrefetch;
    private final ImageRequest.RequestLevel mLowestPermittedRequestLevel;
    private Priority mPriority;
    private final ProducerListener2 mProducerListener;
    @Nullable
    private final String mUiComponentId;

    public BaseProducerContext(ImageRequest imageRequest, String str, ProducerListener2 producerListener2, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority, ImagePipelineConfigInterface imagePipelineConfigInterface) {
        this(imageRequest, str, (String) null, producerListener2, obj, requestLevel, z, z2, priority, imagePipelineConfigInterface);
    }

    public BaseProducerContext(ImageRequest imageRequest, String str, @Nullable String str2, ProducerListener2 producerListener2, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority, ImagePipelineConfigInterface imagePipelineConfigInterface) {
        Object obj2;
        this.mEncodedImageOrigin = EncodedImageOrigin.NOT_SET;
        this.mImageRequest = imageRequest;
        this.mId = str;
        HashMap hashMap = new HashMap();
        this.mExtras = hashMap;
        hashMap.put("id", str);
        if (imageRequest == null) {
            obj2 = "null-request";
        } else {
            obj2 = imageRequest.getSourceUri();
        }
        hashMap.put(ProducerContext.ExtraKeys.SOURCE_URI, obj2);
        this.mUiComponentId = str2;
        this.mProducerListener = producerListener2;
        this.mCallerContext = obj;
        this.mLowestPermittedRequestLevel = requestLevel;
        this.mIsPrefetch = z;
        this.mPriority = priority;
        this.mIsIntermediateResultExpected = z2;
        this.mIsCancelled = false;
        this.mCallbacks = new ArrayList();
        this.mImagePipelineConfig = imagePipelineConfigInterface;
    }

    public ImageRequest getImageRequest() {
        return this.mImageRequest;
    }

    public String getId() {
        return this.mId;
    }

    @Nullable
    public String getUiComponentId() {
        return this.mUiComponentId;
    }

    public ProducerListener2 getProducerListener() {
        return this.mProducerListener;
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
        return this.mLowestPermittedRequestLevel;
    }

    public synchronized boolean isPrefetch() {
        return this.mIsPrefetch;
    }

    public synchronized Priority getPriority() {
        return this.mPriority;
    }

    public synchronized boolean isIntermediateResultExpected() {
        return this.mIsIntermediateResultExpected;
    }

    public synchronized boolean isCancelled() {
        return this.mIsCancelled;
    }

    public void addCallbacks(ProducerContextCallbacks producerContextCallbacks) {
        boolean z;
        synchronized (this) {
            this.mCallbacks.add(producerContextCallbacks);
            z = this.mIsCancelled;
        }
        if (z) {
            producerContextCallbacks.onCancellationRequested();
        }
    }

    public ImagePipelineConfigInterface getImagePipelineConfig() {
        return this.mImagePipelineConfig;
    }

    public EncodedImageOrigin getEncodedImageOrigin() {
        return this.mEncodedImageOrigin;
    }

    public void setEncodedImageOrigin(EncodedImageOrigin encodedImageOrigin) {
        this.mEncodedImageOrigin = encodedImageOrigin;
    }

    public void cancel() {
        callOnCancellationRequested(cancelNoCallbacks());
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> setIsPrefetchNoCallbacks(boolean z) {
        if (z == this.mIsPrefetch) {
            return null;
        }
        this.mIsPrefetch = z;
        return new ArrayList(this.mCallbacks);
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> setPriorityNoCallbacks(Priority priority) {
        if (priority == this.mPriority) {
            return null;
        }
        this.mPriority = priority;
        return new ArrayList(this.mCallbacks);
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> setIsIntermediateResultExpectedNoCallbacks(boolean z) {
        if (z == this.mIsIntermediateResultExpected) {
            return null;
        }
        this.mIsIntermediateResultExpected = z;
        return new ArrayList(this.mCallbacks);
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> cancelNoCallbacks() {
        if (this.mIsCancelled) {
            return null;
        }
        this.mIsCancelled = true;
        return new ArrayList(this.mCallbacks);
    }

    public static void callOnCancellationRequested(@Nullable List<ProducerContextCallbacks> list) {
        if (list != null) {
            for (ProducerContextCallbacks onCancellationRequested : list) {
                onCancellationRequested.onCancellationRequested();
            }
        }
    }

    public static void callOnIsPrefetchChanged(@Nullable List<ProducerContextCallbacks> list) {
        if (list != null) {
            for (ProducerContextCallbacks onIsPrefetchChanged : list) {
                onIsPrefetchChanged.onIsPrefetchChanged();
            }
        }
    }

    public static void callOnIsIntermediateResultExpectedChanged(@Nullable List<ProducerContextCallbacks> list) {
        if (list != null) {
            for (ProducerContextCallbacks onIsIntermediateResultExpectedChanged : list) {
                onIsIntermediateResultExpectedChanged.onIsIntermediateResultExpectedChanged();
            }
        }
    }

    public static void callOnPriorityChanged(@Nullable List<ProducerContextCallbacks> list) {
        if (list != null) {
            for (ProducerContextCallbacks onPriorityChanged : list) {
                onPriorityChanged.onPriorityChanged();
            }
        }
    }

    public void setExtra(String str, @Nullable Object obj) {
        if (!INITIAL_KEYS.contains(str)) {
            this.mExtras.put(str, obj);
        }
    }

    public void putExtras(@Nullable Map<String, ?> map) {
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                setExtra((String) next.getKey(), next.getValue());
            }
        }
    }

    @Nullable
    public <T> T getExtra(String str) {
        return this.mExtras.get(str);
    }

    @Nullable
    public <E> E getExtra(String str, @Nullable E e) {
        E e2 = this.mExtras.get(str);
        return e2 == null ? e : e2;
    }

    public Map<String, Object> getExtras() {
        return this.mExtras;
    }

    public void putOriginExtra(@Nullable String str, @Nullable String str2) {
        this.mExtras.put("origin", str);
        this.mExtras.put(ProducerContext.ExtraKeys.ORIGIN_SUBCATEGORY, str2);
    }

    public void putOriginExtra(@Nullable String str) {
        putOriginExtra(str, "default");
    }
}
