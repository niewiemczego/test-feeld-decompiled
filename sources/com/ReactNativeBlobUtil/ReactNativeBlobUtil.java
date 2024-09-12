package com.ReactNativeBlobUtil;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class ReactNativeBlobUtil extends ReactContextBaseJavaModule {
    private final ReactNativeBlobUtilImpl delegate;

    @ReactMethod
    public void addListener(String str) {
    }

    public String getName() {
        return ReactNativeBlobUtilImpl.NAME;
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public ReactNativeBlobUtil(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.delegate = new ReactNativeBlobUtilImpl(reactApplicationContext);
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(ReactNativeBlobUtilFS.getSystemfolders(getReactApplicationContext()));
        hashMap.putAll(ReactNativeBlobUtilFS.getLegacySystemfolders(getReactApplicationContext()));
        return hashMap;
    }

    @ReactMethod
    public void createFile(String str, String str2, String str3, Promise promise) {
        this.delegate.createFile(str, str2, str3, promise);
    }

    @ReactMethod
    public void createFileASCII(String str, ReadableArray readableArray, Promise promise) {
        this.delegate.createFileASCII(str, readableArray, promise);
    }

    @ReactMethod
    public void actionViewIntent(String str, String str2, @Nullable String str3, Promise promise) {
        this.delegate.actionViewIntent(str, str2, str3, promise);
    }

    @ReactMethod
    public void writeArrayChunk(String str, ReadableArray readableArray, Callback callback) {
        this.delegate.writeArrayChunk(str, readableArray, callback);
    }

    @ReactMethod
    public void unlink(String str, Callback callback) {
        this.delegate.unlink(str, callback);
    }

    @ReactMethod
    public void mkdir(String str, Promise promise) {
        this.delegate.mkdir(str, promise);
    }

    @ReactMethod
    public void exists(String str, Callback callback) {
        this.delegate.exists(str, callback);
    }

    @ReactMethod
    public void cp(String str, String str2, Callback callback) {
        this.delegate.cp(str, str2, callback);
    }

    @ReactMethod
    public void mv(String str, String str2, Callback callback) {
        this.delegate.mv(str, str2, callback);
    }

    @ReactMethod
    public void ls(String str, Promise promise) {
        this.delegate.ls(str, promise);
    }

    @ReactMethod
    public void writeStream(String str, String str2, boolean z, Callback callback) {
        this.delegate.writeStream(str, str2, z, callback);
    }

    @ReactMethod
    public void writeChunk(String str, String str2, Callback callback) {
        this.delegate.writeChunk(str, str2, callback);
    }

    @ReactMethod
    public void closeStream(String str, Callback callback) {
        this.delegate.closeStream(str, callback);
    }

    @ReactMethod
    public void removeSession(ReadableArray readableArray, Callback callback) {
        this.delegate.removeSession(readableArray, callback);
    }

    @ReactMethod
    public void readFile(String str, String str2, boolean z, Promise promise) {
        this.delegate.readFile(str, str2, z, promise);
    }

    @ReactMethod
    public void writeFileArray(String str, ReadableArray readableArray, boolean z, Promise promise) {
        this.delegate.writeFileArray(str, readableArray, z, promise);
    }

    @ReactMethod
    public void writeFile(String str, String str2, String str3, boolean z, boolean z2, Promise promise) {
        this.delegate.writeFile(str, str2, str3, z, z2, promise);
    }

    @ReactMethod
    public void lstat(String str, Callback callback) {
        this.delegate.lstat(str, callback);
    }

    @ReactMethod
    public void stat(String str, Callback callback) {
        this.delegate.stat(str, callback);
    }

    @ReactMethod
    public void scanFile(ReadableArray readableArray, Callback callback) {
        this.delegate.scanFile(readableArray, callback);
    }

    @ReactMethod
    public void hash(String str, String str2, Promise promise) {
        this.delegate.hash(str, str2, promise);
    }

    @ReactMethod
    public void readStream(String str, String str2, int i, int i2, String str3) {
        this.delegate.readStream(str, str2, i, i2, str3);
    }

    @ReactMethod
    public void cancelRequest(String str, Callback callback) {
        this.delegate.cancelRequest(str, callback);
    }

    @ReactMethod
    public void slice(String str, String str2, int i, int i2, Promise promise) {
        this.delegate.slice(str, str2, i, i2, promise);
    }

    @ReactMethod
    public void enableProgressReport(String str, int i, int i2) {
        this.delegate.enableProgressReport(str, i, i2);
    }

    @ReactMethod
    public void df(Callback callback) {
        this.delegate.df(callback);
    }

    @ReactMethod
    public void enableUploadProgressReport(String str, int i, int i2) {
        this.delegate.enableUploadProgressReport(str, i, i2);
    }

    @ReactMethod
    public void fetchBlob(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, Callback callback) {
        this.delegate.fetchBlob(readableMap, str, str2, str3, readableMap2, str4, callback);
    }

    @ReactMethod
    public void fetchBlobForm(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, ReadableArray readableArray, Callback callback) {
        this.delegate.fetchBlobForm(readableMap, str, str2, str3, readableMap2, readableArray, callback);
    }

    @ReactMethod
    public void getContentIntent(String str, Promise promise) {
        this.delegate.getContentIntent(str, promise);
    }

    @ReactMethod
    public void addCompleteDownload(ReadableMap readableMap, Promise promise) {
        this.delegate.addCompleteDownload(readableMap, promise);
    }

    @ReactMethod
    public void getSDCardDir(Promise promise) {
        this.delegate.getSDCardDir(promise);
    }

    @ReactMethod
    public void getSDCardApplicationDir(Promise promise) {
        this.delegate.getSDCardApplicationDir(promise);
    }

    @ReactMethod
    public void createMediaFile(ReadableMap readableMap, String str, Promise promise) {
        this.delegate.createMediaFile(readableMap, str, promise);
    }

    @ReactMethod
    public void writeToMediaFile(String str, String str2, boolean z, Promise promise) {
        this.delegate.writeToMediaFile(str, str2, z, promise);
    }

    @ReactMethod
    public void copyToInternal(String str, String str2, Promise promise) {
        this.delegate.copyToInternal(str, str2, promise);
    }

    @ReactMethod
    public void getBlob(String str, String str2, Promise promise) {
        this.delegate.getBlob(str, str2, promise);
    }

    @ReactMethod
    public void copyToMediaStore(ReadableMap readableMap, String str, String str2, Promise promise) {
        this.delegate.copyToMediaStore(readableMap, str, str2, promise);
    }
}
