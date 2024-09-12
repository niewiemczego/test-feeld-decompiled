package com.facebook.share;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.Mutable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.Sharer;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.VideoUploader;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShareApi {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String DEFAULT_GRAPH_NODE = "me";
    private static final String GRAPH_PATH_FORMAT = "%s/%s";
    private static final String PHOTOS_EDGE = "photos";
    private static final String TAG = "ShareApi";
    private String graphNode = "me";
    private String message;
    private final ShareContent shareContent;

    static /* synthetic */ void access$000(ShareApi shareApi, ArrayList arrayList, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        Class<ShareApi> cls = ShareApi.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                shareApi.stageArrayList(arrayList, onMapValueCompleteListener);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    static /* synthetic */ void access$100(ShareApi shareApi, SharePhoto sharePhoto, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        Class<ShareApi> cls = ShareApi.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                shareApi.stagePhoto(sharePhoto, onMapValueCompleteListener);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static void share(ShareContent shareContent2, FacebookCallback<Sharer.Result> facebookCallback) {
        Class<ShareApi> cls = ShareApi.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                new ShareApi(shareContent2).share(facebookCallback);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public ShareApi(ShareContent shareContent2) {
        this.shareContent = shareContent2;
    }

    public String getMessage() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.message;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public void setMessage(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.message = str;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public String getGraphNode() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.graphNode;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public void setGraphNode(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.graphNode = str;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public ShareContent getShareContent() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.shareContent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public boolean canShare() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (getShareContent() == null) {
                return false;
            }
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (!AccessToken.isCurrentAccessTokenActive()) {
                return false;
            }
            Set<String> permissions = currentAccessToken.getPermissions();
            if (permissions != null && permissions.contains("publish_actions")) {
                return true;
            }
            Log.w(TAG, "The publish_actions permissions are missing, the share will fail unless this app was authorized to publish in another installation.");
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void share(com.facebook.FacebookCallback<com.facebook.share.Sharer.Result> r3) {
        /*
            r2 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r2)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = r2.canShare()     // Catch:{ all -> 0x003d }
            if (r0 != 0) goto L_0x0013
            java.lang.String r0 = "Insufficient permissions for sharing content via Api."
            com.facebook.share.internal.ShareInternalUtility.invokeCallbackWithError(r3, r0)     // Catch:{ all -> 0x003d }
            return
        L_0x0013:
            com.facebook.share.model.ShareContent r0 = r2.getShareContent()     // Catch:{ all -> 0x003d }
            com.facebook.share.internal.ShareContentValidation.validateForApiShare(r0)     // Catch:{ FacebookException -> 0x0038 }
            boolean r1 = r0 instanceof com.facebook.share.model.ShareLinkContent     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x0024
            com.facebook.share.model.ShareLinkContent r0 = (com.facebook.share.model.ShareLinkContent) r0     // Catch:{ all -> 0x003d }
            r2.shareLinkContent(r0, r3)     // Catch:{ all -> 0x003d }
            goto L_0x0037
        L_0x0024:
            boolean r1 = r0 instanceof com.facebook.share.model.SharePhotoContent     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x002e
            com.facebook.share.model.SharePhotoContent r0 = (com.facebook.share.model.SharePhotoContent) r0     // Catch:{ all -> 0x003d }
            r2.sharePhotoContent(r0, r3)     // Catch:{ all -> 0x003d }
            goto L_0x0037
        L_0x002e:
            boolean r1 = r0 instanceof com.facebook.share.model.ShareVideoContent     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x0037
            com.facebook.share.model.ShareVideoContent r0 = (com.facebook.share.model.ShareVideoContent) r0     // Catch:{ all -> 0x003d }
            r2.shareVideoContent(r0, r3)     // Catch:{ all -> 0x003d }
        L_0x0037:
            return
        L_0x0038:
            r0 = move-exception
            com.facebook.share.internal.ShareInternalUtility.invokeCallbackWithException(r3, r0)     // Catch:{ all -> 0x003d }
            return
        L_0x003d:
            r3 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.ShareApi.share(com.facebook.FacebookCallback):void");
    }

    private String getGraphPath(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return String.format(Locale.ROOT, GRAPH_PATH_FORMAT, new Object[]{URLEncoder.encode(getGraphNode(), "UTF-8"), str});
        } catch (UnsupportedEncodingException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private void addCommonParameters(Bundle bundle, ShareContent shareContent2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                List<String> peopleIds = shareContent2.getPeopleIds();
                if (!Utility.isNullOrEmpty((Collection<?>) peopleIds)) {
                    bundle.putString("tags", TextUtils.join(", ", peopleIds));
                }
                if (!Utility.isNullOrEmpty(shareContent2.getPlaceId())) {
                    bundle.putString("place", shareContent2.getPlaceId());
                }
                if (!Utility.isNullOrEmpty(shareContent2.getPageId())) {
                    bundle.putString("page", shareContent2.getPageId());
                }
                if (!Utility.isNullOrEmpty(shareContent2.getRef())) {
                    bundle.putString("ref", shareContent2.getRef());
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        putImageInBundleWithArrayFormat(r11, 0, new org.json.JSONObject(r2));
        r11.remove("image");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0047 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void handleImagesOnAction(android.os.Bundle r11) {
        /*
            java.lang.Class<com.facebook.share.ShareApi> r0 = com.facebook.share.ShareApi.class
            java.lang.String r1 = "image"
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            if (r2 == 0) goto L_0x000b
            return
        L_0x000b:
            java.lang.String r2 = r11.getString(r1)     // Catch:{ all -> 0x0053 }
            if (r2 == 0) goto L_0x0052
            r3 = 0
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0047 }
            r4.<init>((java.lang.String) r2)     // Catch:{ JSONException -> 0x0047 }
            r5 = r3
        L_0x0018:
            int r6 = r4.length()     // Catch:{ JSONException -> 0x0047 }
            if (r5 >= r6) goto L_0x0043
            org.json.JSONObject r6 = r4.optJSONObject(r5)     // Catch:{ JSONException -> 0x0047 }
            if (r6 == 0) goto L_0x0028
            putImageInBundleWithArrayFormat(r11, r5, r6)     // Catch:{ JSONException -> 0x0047 }
            goto L_0x0040
        L_0x0028:
            java.lang.String r6 = r4.getString(r5)     // Catch:{ JSONException -> 0x0047 }
            java.util.Locale r7 = java.util.Locale.ROOT     // Catch:{ JSONException -> 0x0047 }
            java.lang.String r8 = "image[%d][url]"
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ JSONException -> 0x0047 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r5)     // Catch:{ JSONException -> 0x0047 }
            r9[r3] = r10     // Catch:{ JSONException -> 0x0047 }
            java.lang.String r7 = java.lang.String.format(r7, r8, r9)     // Catch:{ JSONException -> 0x0047 }
            r11.putString(r7, r6)     // Catch:{ JSONException -> 0x0047 }
        L_0x0040:
            int r5 = r5 + 1
            goto L_0x0018
        L_0x0043:
            r11.remove(r1)     // Catch:{ JSONException -> 0x0047 }
            return
        L_0x0047:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0052 }
            r4.<init>((java.lang.String) r2)     // Catch:{ JSONException -> 0x0052 }
            putImageInBundleWithArrayFormat(r11, r3, r4)     // Catch:{ JSONException -> 0x0052 }
            r11.remove(r1)     // Catch:{ JSONException -> 0x0052 }
        L_0x0052:
            return
        L_0x0053:
            r11 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r11, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.ShareApi.handleImagesOnAction(android.os.Bundle):void");
    }

    private static void putImageInBundleWithArrayFormat(Bundle bundle, int i, JSONObject jSONObject) throws JSONException {
        Class<ShareApi> cls = ShareApi.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle.putString(String.format(Locale.ROOT, "image[%d][%s]", new Object[]{Integer.valueOf(i), next}), jSONObject.get(next).toString());
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private void sharePhotoContent(SharePhotoContent sharePhotoContent, FacebookCallback<Sharer.Result> facebookCallback) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Mutable mutable = new Mutable(0);
                AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                ArrayList arrayList = new ArrayList();
                final ArrayList arrayList2 = new ArrayList();
                final ArrayList arrayList3 = new ArrayList();
                final Mutable mutable2 = mutable;
                final FacebookCallback<Sharer.Result> facebookCallback2 = facebookCallback;
                AnonymousClass1 r1 = new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse graphResponse) {
                        JSONObject jSONObject = graphResponse.getJSONObject();
                        if (jSONObject != null) {
                            arrayList2.add(jSONObject);
                        }
                        if (graphResponse.getError() != null) {
                            arrayList3.add(graphResponse);
                        }
                        Mutable mutable = mutable2;
                        mutable.value = Integer.valueOf(((Integer) mutable.value).intValue() - 1);
                        if (((Integer) mutable2.value).intValue() != 0) {
                            return;
                        }
                        if (!arrayList3.isEmpty()) {
                            ShareInternalUtility.invokeCallbackWithResults(facebookCallback2, (String) null, (GraphResponse) arrayList3.get(0));
                        } else if (!arrayList2.isEmpty()) {
                            ShareInternalUtility.invokeCallbackWithResults(facebookCallback2, ((JSONObject) arrayList2.get(0)).optString("id"), graphResponse);
                        }
                    }
                };
                for (SharePhoto next : sharePhotoContent.getPhotos()) {
                    try {
                        Bundle sharePhotoCommonParameters = getSharePhotoCommonParameters(next, sharePhotoContent);
                        Bitmap bitmap = next.getBitmap();
                        Uri imageUrl = next.getImageUrl();
                        String caption = next.getCaption();
                        if (caption == null) {
                            caption = getMessage();
                        }
                        String str = caption;
                        if (bitmap != null) {
                            arrayList.add(GraphRequest.newUploadPhotoRequest(currentAccessToken, getGraphPath(PHOTOS_EDGE), bitmap, str, sharePhotoCommonParameters, (GraphRequest.Callback) r1));
                        } else if (imageUrl != null) {
                            arrayList.add(GraphRequest.newUploadPhotoRequest(currentAccessToken, getGraphPath(PHOTOS_EDGE), imageUrl, str, sharePhotoCommonParameters, (GraphRequest.Callback) r1));
                        }
                    } catch (JSONException e) {
                        ShareInternalUtility.invokeCallbackWithException(facebookCallback, e);
                        return;
                    }
                }
                mutable.value = Integer.valueOf(((Integer) mutable.value).intValue() + arrayList.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((GraphRequest) it.next()).executeAsync();
                }
            } catch (FileNotFoundException e2) {
                ShareInternalUtility.invokeCallbackWithException(facebookCallback, e2);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private void shareLinkContent(ShareLinkContent shareLinkContent, final FacebookCallback<Sharer.Result> facebookCallback) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                AnonymousClass2 r6 = new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse graphResponse) {
                        String str;
                        JSONObject jSONObject = graphResponse.getJSONObject();
                        if (jSONObject == null) {
                            str = null;
                        } else {
                            str = jSONObject.optString("id");
                        }
                        ShareInternalUtility.invokeCallbackWithResults(facebookCallback, str, graphResponse);
                    }
                };
                Bundle bundle = new Bundle();
                addCommonParameters(bundle, shareLinkContent);
                bundle.putString("message", getMessage());
                bundle.putString("link", Utility.getUriString(shareLinkContent.getContentUrl()));
                bundle.putString("ref", shareLinkContent.getRef());
                new GraphRequest(AccessToken.getCurrentAccessToken(), getGraphPath("feed"), bundle, HttpMethod.POST, r6).executeAsync();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private void shareVideoContent(ShareVideoContent shareVideoContent, FacebookCallback<Sharer.Result> facebookCallback) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                VideoUploader.uploadAsync(shareVideoContent, getGraphNode(), facebookCallback);
            } catch (FileNotFoundException e) {
                ShareInternalUtility.invokeCallbackWithException(facebookCallback, e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private Bundle getSharePhotoCommonParameters(SharePhoto sharePhoto, SharePhotoContent sharePhotoContent) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Bundle parameters = sharePhoto.getParameters();
            if (!parameters.containsKey("place") && !Utility.isNullOrEmpty(sharePhotoContent.getPlaceId())) {
                parameters.putString("place", sharePhotoContent.getPlaceId());
            }
            if (!parameters.containsKey("tags") && !Utility.isNullOrEmpty((Collection<?>) sharePhotoContent.getPeopleIds())) {
                List<String> peopleIds = sharePhotoContent.getPeopleIds();
                if (!Utility.isNullOrEmpty((Collection<?>) peopleIds)) {
                    JSONArray jSONArray = new JSONArray();
                    for (String put : peopleIds) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("tag_uid", (Object) put);
                        jSONArray.put((Object) jSONObject);
                    }
                    parameters.putString("tags", jSONArray.toString());
                }
            }
            if (!parameters.containsKey("ref") && !Utility.isNullOrEmpty(sharePhotoContent.getRef())) {
                parameters.putString("ref", sharePhotoContent.getRef());
            }
            return parameters;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private void stageArrayList(final ArrayList arrayList, final CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                final JSONArray jSONArray = new JSONArray();
                stageCollectionValues(new CollectionMapper.Collection<Integer>() {
                    public Iterator<Integer> keyIterator() {
                        final int size = arrayList.size();
                        final Mutable mutable = new Mutable(0);
                        return new Iterator<Integer>() {
                            public void remove() {
                            }

                            public boolean hasNext() {
                                return ((Integer) mutable.value).intValue() < size;
                            }

                            public Integer next() {
                                Integer num = (Integer) mutable.value;
                                Mutable mutable = mutable;
                                mutable.value = Integer.valueOf(((Integer) mutable.value).intValue() + 1);
                                return num;
                            }
                        };
                    }

                    public Object get(Integer num) {
                        return arrayList.get(num.intValue());
                    }

                    public void set(Integer num, Object obj, CollectionMapper.OnErrorListener onErrorListener) {
                        try {
                            jSONArray.put(num.intValue(), obj);
                        } catch (JSONException e) {
                            String localizedMessage = e.getLocalizedMessage();
                            if (localizedMessage == null) {
                                localizedMessage = "Error staging object.";
                            }
                            onErrorListener.onError(new FacebookException(localizedMessage));
                        }
                    }
                }, new CollectionMapper.OnMapperCompleteListener() {
                    public void onComplete() {
                        onMapValueCompleteListener.onComplete(jSONArray);
                    }

                    public void onError(FacebookException facebookException) {
                        onMapValueCompleteListener.onError(facebookException);
                    }
                });
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private <T> void stageCollectionValues(CollectionMapper.Collection<T> collection, CollectionMapper.OnMapperCompleteListener onMapperCompleteListener) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                CollectionMapper.iterate(collection, new CollectionMapper.ValueMapper() {
                    public void mapValue(Object obj, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
                        if (obj instanceof ArrayList) {
                            ShareApi.access$000(ShareApi.this, (ArrayList) obj, onMapValueCompleteListener);
                        } else if (obj instanceof SharePhoto) {
                            ShareApi.access$100(ShareApi.this, (SharePhoto) obj, onMapValueCompleteListener);
                        } else {
                            onMapValueCompleteListener.onComplete(obj);
                        }
                    }
                }, onMapperCompleteListener);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private void stagePhoto(final SharePhoto sharePhoto, final CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bitmap bitmap = sharePhoto.getBitmap();
                Uri imageUrl = sharePhoto.getImageUrl();
                if (bitmap == null) {
                    if (imageUrl == null) {
                        onMapValueCompleteListener.onError(new FacebookException("Photos must have an imageURL or bitmap."));
                        return;
                    }
                }
                AnonymousClass6 r2 = new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse graphResponse) {
                        FacebookRequestError error = graphResponse.getError();
                        String str = "Error staging photo.";
                        if (error != null) {
                            String errorMessage = error.getErrorMessage();
                            if (errorMessage != null) {
                                str = errorMessage;
                            }
                            onMapValueCompleteListener.onError(new FacebookGraphResponseException(graphResponse, str));
                            return;
                        }
                        JSONObject jSONObject = graphResponse.getJSONObject();
                        if (jSONObject == null) {
                            onMapValueCompleteListener.onError(new FacebookException(str));
                            return;
                        }
                        String optString = jSONObject.optString("uri");
                        if (optString == null) {
                            onMapValueCompleteListener.onError(new FacebookException(str));
                            return;
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("url", (Object) optString);
                            jSONObject2.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, sharePhoto.getUserGenerated());
                            onMapValueCompleteListener.onComplete(jSONObject2);
                        } catch (JSONException e) {
                            String localizedMessage = e.getLocalizedMessage();
                            if (localizedMessage != null) {
                                str = localizedMessage;
                            }
                            onMapValueCompleteListener.onError(new FacebookException(str));
                        }
                    }
                };
                if (bitmap != null) {
                    ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), bitmap, (GraphRequest.Callback) r2).executeAsync();
                } else {
                    ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), imageUrl, (GraphRequest.Callback) r2).executeAsync();
                }
            } catch (FileNotFoundException e) {
                String localizedMessage = e.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "Error staging photo.";
                }
                onMapValueCompleteListener.onError(new FacebookException(localizedMessage));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
