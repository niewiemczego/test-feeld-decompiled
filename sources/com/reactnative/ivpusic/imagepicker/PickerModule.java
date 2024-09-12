package com.reactnative.ivpusic.imagepicker;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.reactnativecommunity.clipboard.ClipboardModule;
import com.yalantis.ucrop.UCrop;
import io.sentry.protocol.ViewHierarchyNode;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.apache.commons.codec.language.bm.Languages;

class PickerModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    private static final int CAMERA_PICKER_REQUEST = 61111;
    private static final String E_ACTIVITY_DOES_NOT_EXIST = "E_ACTIVITY_DOES_NOT_EXIST";
    private static final String E_CALLBACK_ERROR = "E_CALLBACK_ERROR";
    private static final String E_CAMERA_IS_NOT_AVAILABLE = "E_CAMERA_IS_NOT_AVAILABLE";
    private static final String E_CANNOT_LAUNCH_CAMERA = "E_CANNOT_LAUNCH_CAMERA";
    private static final String E_ERROR_WHILE_CLEANING_FILES = "E_ERROR_WHILE_CLEANING_FILES";
    private static final String E_FAILED_TO_OPEN_CAMERA = "E_FAILED_TO_OPEN_CAMERA";
    private static final String E_FAILED_TO_SHOW_PICKER = "E_FAILED_TO_SHOW_PICKER";
    private static final String E_NO_CAMERA_PERMISSION_KEY = "E_NO_CAMERA_PERMISSION";
    private static final String E_NO_CAMERA_PERMISSION_MSG = "User did not grant camera permission.";
    private static final String E_NO_IMAGE_DATA_FOUND = "E_NO_IMAGE_DATA_FOUND";
    private static final String E_NO_LIBRARY_PERMISSION_KEY = "E_NO_LIBRARY_PERMISSION";
    private static final String E_NO_LIBRARY_PERMISSION_MSG = "User did not grant library permission.";
    private static final String E_PICKER_CANCELLED_KEY = "E_PICKER_CANCELLED";
    private static final String E_PICKER_CANCELLED_MSG = "User cancelled image selection";
    private static final int IMAGE_PICKER_REQUEST = 61110;
    /* access modifiers changed from: private */
    public Compression compression = new Compression();
    private String cropperActiveWidgetColor = null;
    private boolean cropperCircleOverlay = false;
    private String cropperStatusBarColor = null;
    private String cropperToolbarColor = null;
    private String cropperToolbarTitle = null;
    private String cropperToolbarWidgetColor = null;
    private boolean cropping = false;
    private boolean disableCropperColorSetters = false;
    private boolean enableRotationGesture = false;
    private boolean freeStyleCropEnabled = false;
    private int height = 0;
    private boolean hideBottomControls = false;
    private boolean includeBase64 = false;
    private boolean includeExif = false;
    private Uri mCameraCaptureURI;
    private String mCurrentMediaPath;
    private String mediaType = Languages.ANY;
    private boolean multiple = false;
    /* access modifiers changed from: private */
    public ReadableMap options;
    private ReactApplicationContext reactContext;
    /* access modifiers changed from: private */
    public ResultCollector resultCollector = new ResultCollector();
    private boolean showCropFrame = true;
    private boolean showCropGuidelines = true;
    private boolean useFrontCamera = false;
    private int width = 0;

    public String getName() {
        return "ImageCropPicker";
    }

    public void onNewIntent(Intent intent) {
    }

    PickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
        this.reactContext = reactApplicationContext;
    }

    /* access modifiers changed from: private */
    public String getTmpDir(Activity activity) {
        String str = activity.getCacheDir() + "/react-native-image-crop-picker";
        new File(str).mkdir();
        return str;
    }

    private void setConfiguration(ReadableMap readableMap) {
        this.mediaType = readableMap.hasKey("mediaType") ? readableMap.getString("mediaType") : Languages.ANY;
        boolean z = true;
        this.multiple = readableMap.hasKey("multiple") && readableMap.getBoolean("multiple");
        this.includeBase64 = readableMap.hasKey("includeBase64") && readableMap.getBoolean("includeBase64");
        this.includeExif = readableMap.hasKey("includeExif") && readableMap.getBoolean("includeExif");
        this.width = readableMap.hasKey("width") ? readableMap.getInt("width") : 0;
        this.height = readableMap.hasKey("height") ? readableMap.getInt("height") : 0;
        this.cropping = readableMap.hasKey("cropping") && readableMap.getBoolean("cropping");
        String str = null;
        this.cropperActiveWidgetColor = readableMap.hasKey("cropperActiveWidgetColor") ? readableMap.getString("cropperActiveWidgetColor") : null;
        this.cropperStatusBarColor = readableMap.hasKey("cropperStatusBarColor") ? readableMap.getString("cropperStatusBarColor") : null;
        this.cropperToolbarColor = readableMap.hasKey("cropperToolbarColor") ? readableMap.getString("cropperToolbarColor") : null;
        this.cropperToolbarTitle = readableMap.hasKey("cropperToolbarTitle") ? readableMap.getString("cropperToolbarTitle") : null;
        if (readableMap.hasKey("cropperToolbarWidgetColor")) {
            str = readableMap.getString("cropperToolbarWidgetColor");
        }
        this.cropperToolbarWidgetColor = str;
        this.cropperCircleOverlay = readableMap.hasKey("cropperCircleOverlay") && readableMap.getBoolean("cropperCircleOverlay");
        this.freeStyleCropEnabled = readableMap.hasKey("freeStyleCropEnabled") && readableMap.getBoolean("freeStyleCropEnabled");
        this.showCropGuidelines = !readableMap.hasKey("showCropGuidelines") || readableMap.getBoolean("showCropGuidelines");
        this.showCropFrame = !readableMap.hasKey("showCropFrame") || readableMap.getBoolean("showCropFrame");
        this.hideBottomControls = readableMap.hasKey("hideBottomControls") && readableMap.getBoolean("hideBottomControls");
        this.enableRotationGesture = readableMap.hasKey("enableRotationGesture") && readableMap.getBoolean("enableRotationGesture");
        this.disableCropperColorSetters = readableMap.hasKey("disableCropperColorSetters") && readableMap.getBoolean("disableCropperColorSetters");
        if (!readableMap.hasKey("useFrontCamera") || !readableMap.getBoolean("useFrontCamera")) {
            z = false;
        }
        this.useFrontCamera = z;
        this.options = readableMap;
    }

    /* access modifiers changed from: private */
    public void deleteRecursive(File file) {
        if (file.isDirectory()) {
            for (File deleteRecursive : file.listFiles()) {
                deleteRecursive(deleteRecursive);
            }
        }
        file.delete();
    }

    @ReactMethod
    public void clean(final Promise promise) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(E_ACTIVITY_DOES_NOT_EXIST, "Activity doesn't exist");
        } else {
            permissionsCheck(currentActivity, promise, Collections.singletonList("android.permission.WRITE_EXTERNAL_STORAGE"), new Callable<Void>() {
                public Void call() {
                    try {
                        File file = new File(this.getTmpDir(currentActivity));
                        if (file.exists()) {
                            this.deleteRecursive(file);
                            promise.resolve((Object) null);
                            return null;
                        }
                        throw new Exception("File does not exist");
                    } catch (Exception e) {
                        e.printStackTrace();
                        promise.reject(PickerModule.E_ERROR_WHILE_CLEANING_FILES, e.getMessage());
                    }
                }
            });
        }
    }

    @ReactMethod
    public void cleanSingle(final String str, final Promise promise) {
        if (str == null) {
            promise.reject(E_ERROR_WHILE_CLEANING_FILES, "Cannot cleanup empty path");
            return;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(E_ACTIVITY_DOES_NOT_EXIST, "Activity doesn't exist");
        } else {
            permissionsCheck(currentActivity, promise, Collections.singletonList("android.permission.WRITE_EXTERNAL_STORAGE"), new Callable<Void>() {
                public Void call() throws Exception {
                    try {
                        String str = str;
                        if (str.startsWith("file://")) {
                            str = str.substring(7);
                        }
                        File file = new File(str);
                        if (file.exists()) {
                            this.deleteRecursive(file);
                            promise.resolve((Object) null);
                            return null;
                        }
                        throw new Exception("File does not exist. Path: " + str);
                    } catch (Exception e) {
                        e.printStackTrace();
                        promise.reject(PickerModule.E_ERROR_WHILE_CLEANING_FILES, e.getMessage());
                    }
                }
            });
        }
    }

    private void permissionsCheck(Activity activity, final Promise promise, List<String> list, final Callable<Void> callable) {
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList<>(list);
        if (Build.VERSION.SDK_INT > 29) {
            arrayList2.remove("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        for (String str : arrayList2) {
            if (ActivityCompat.checkSelfPermission(activity, str) != 0) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            ((PermissionAwareActivity) activity).requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 1, new PermissionListener() {
                public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    if (i == 1) {
                        for (int i2 = 0; i2 < strArr.length; i2++) {
                            String str = strArr[i2];
                            if (iArr[i2] == -1) {
                                if (str.equals("android.permission.CAMERA")) {
                                    promise.reject(PickerModule.E_NO_CAMERA_PERMISSION_KEY, PickerModule.E_NO_CAMERA_PERMISSION_MSG);
                                } else if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                                    promise.reject(PickerModule.E_NO_LIBRARY_PERMISSION_KEY, PickerModule.E_NO_LIBRARY_PERMISSION_MSG);
                                } else {
                                    promise.reject(PickerModule.E_NO_LIBRARY_PERMISSION_KEY, "Required permission missing");
                                }
                                return true;
                            }
                        }
                        try {
                            callable.call();
                        } catch (Exception e) {
                            promise.reject(PickerModule.E_CALLBACK_ERROR, "Unknown error", (Throwable) e);
                        }
                    }
                    return true;
                }
            });
            return;
        }
        try {
            callable.call();
        } catch (Exception e) {
            promise.reject(E_CALLBACK_ERROR, "Unknown error", (Throwable) e);
        }
    }

    @ReactMethod
    public void openCamera(ReadableMap readableMap, Promise promise) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(E_ACTIVITY_DOES_NOT_EXIST, "Activity doesn't exist");
        } else if (!isCameraAvailable(currentActivity)) {
            promise.reject(E_CAMERA_IS_NOT_AVAILABLE, "Camera not available");
        } else {
            setConfiguration(readableMap);
            this.resultCollector.setup(promise, false);
            permissionsCheck(currentActivity, promise, Arrays.asList(new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"}), new Callable<Void>() {
                public Void call() {
                    PickerModule.this.initiateCamera(currentActivity);
                    return null;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void initiateCamera(Activity activity) {
        File file;
        String str;
        try {
            if (this.mediaType.equals("video")) {
                str = "android.media.action.VIDEO_CAPTURE";
                file = createVideoFile();
            } else {
                str = "android.media.action.IMAGE_CAPTURE";
                file = createImageFile();
            }
            Intent intent = new Intent(str);
            if (Build.VERSION.SDK_INT < 21) {
                this.mCameraCaptureURI = Uri.fromFile(file);
            } else {
                this.mCameraCaptureURI = FileProvider.getUriForFile(activity, activity.getApplicationContext().getPackageName() + ".provider", file);
            }
            intent.putExtra("output", this.mCameraCaptureURI);
            if (this.useFrontCamera) {
                intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                intent.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
                intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
            }
            if (intent.resolveActivity(activity.getPackageManager()) == null) {
                this.resultCollector.notifyProblem(E_CANNOT_LAUNCH_CAMERA, "Cannot launch camera");
            } else {
                activity.startActivityForResult(intent, CAMERA_PICKER_REQUEST);
            }
        } catch (Exception e) {
            this.resultCollector.notifyProblem(E_FAILED_TO_OPEN_CAMERA, (Throwable) e);
        }
    }

    /* access modifiers changed from: private */
    public void initiatePicker(Activity activity) {
        try {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            if (!this.cropping) {
                if (!this.mediaType.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO)) {
                    if (this.mediaType.equals("video")) {
                        intent.setType("video/*");
                    } else {
                        intent.setType("*/*");
                        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                    }
                    intent.setFlags(67108864);
                    intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", this.multiple);
                    intent.addCategory("android.intent.category.OPENABLE");
                    activity.startActivityForResult(Intent.createChooser(intent, "Pick an image"), IMAGE_PICKER_REQUEST);
                }
            }
            intent.setType("image/*");
            if (this.cropping) {
                intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/jpeg", ClipboardModule.MIMETYPE_PNG});
            }
            intent.setFlags(67108864);
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", this.multiple);
            intent.addCategory("android.intent.category.OPENABLE");
            activity.startActivityForResult(Intent.createChooser(intent, "Pick an image"), IMAGE_PICKER_REQUEST);
        } catch (Exception e) {
            this.resultCollector.notifyProblem(E_FAILED_TO_SHOW_PICKER, (Throwable) e);
        }
    }

    @ReactMethod
    public void openPicker(ReadableMap readableMap, Promise promise) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(E_ACTIVITY_DOES_NOT_EXIST, "Activity doesn't exist");
            return;
        }
        setConfiguration(readableMap);
        this.resultCollector.setup(promise, this.multiple);
        permissionsCheck(currentActivity, promise, Collections.singletonList(Build.VERSION.SDK_INT < 33 ? "android.permission.WRITE_EXTERNAL_STORAGE" : "android.permission.READ_MEDIA_IMAGES"), new Callable<Void>() {
            public Void call() {
                PickerModule.this.initiatePicker(currentActivity);
                return null;
            }
        });
    }

    @ReactMethod
    public void openCropper(ReadableMap readableMap, Promise promise) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(E_ACTIVITY_DOES_NOT_EXIST, "Activity doesn't exist");
            return;
        }
        setConfiguration(readableMap);
        this.resultCollector.setup(promise, false);
        final Uri parse = Uri.parse(readableMap.getString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH));
        permissionsCheck(currentActivity, promise, Collections.singletonList("android.permission.WRITE_EXTERNAL_STORAGE"), new Callable<Void>() {
            public Void call() {
                PickerModule.this.startCropping(currentActivity, parse);
                return null;
            }
        });
    }

    private String getBase64StringFromFile(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            byte[] bArr = new byte[8192];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private String getMimeType(String str) {
        Uri fromFile = Uri.fromFile(new File(str));
        if (fromFile.getScheme().equals("content")) {
            return this.reactContext.getContentResolver().getType(fromFile);
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(fromFile.toString());
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase());
        }
        return null;
    }

    private WritableMap getSelection(Activity activity, Uri uri, boolean z) throws Exception {
        String resolveRealPath = resolveRealPath(activity, uri, z);
        if (resolveRealPath == null || resolveRealPath.isEmpty()) {
            throw new Exception("Cannot resolve asset path.");
        }
        String mimeType = getMimeType(resolveRealPath);
        if (mimeType == null || !mimeType.startsWith("video/")) {
            return getImage(activity, resolveRealPath);
        }
        getVideo(activity, resolveRealPath, mimeType);
        return null;
    }

    private void getAsyncSelection(Activity activity, Uri uri, boolean z) throws Exception {
        String resolveRealPath = resolveRealPath(activity, uri, z);
        if (resolveRealPath == null || resolveRealPath.isEmpty()) {
            this.resultCollector.notifyProblem(E_NO_IMAGE_DATA_FOUND, "Cannot resolve asset path.");
            return;
        }
        String mimeType = getMimeType(resolveRealPath);
        if (mimeType == null || !mimeType.startsWith("video/")) {
            this.resultCollector.notifySuccess(getImage(activity, resolveRealPath));
        } else {
            getVideo(activity, resolveRealPath, mimeType);
        }
    }

    /* access modifiers changed from: private */
    public Bitmap validateVideo(String str) throws Exception {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
        if (frameAtTime != null) {
            return frameAtTime;
        }
        throw new Exception("Cannot retrieve video data");
    }

    /* access modifiers changed from: private */
    public static Long getVideoDuration(String str) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            return Long.valueOf(Long.parseLong(mediaMetadataRetriever.extractMetadata(9)));
        } catch (Exception unused) {
            return -1L;
        }
    }

    private void getVideo(Activity activity, String str, String str2) throws Exception {
        validateVideo(str);
        final String str3 = getTmpDir(activity) + "/" + UUID.randomUUID().toString() + ".mp4";
        final Activity activity2 = activity;
        final String str4 = str;
        final String str5 = str2;
        new Thread(new Runnable() {
            public void run() {
                PickerModule.this.compression.compressVideo(activity2, PickerModule.this.options, str4, str3, new PromiseImpl(new Callback() {
                    public void invoke(Object... objArr) {
                        String str = objArr[0];
                        try {
                            Bitmap access$600 = PickerModule.this.validateVideo(str);
                            long lastModified = new File(str).lastModified();
                            long longValue = PickerModule.getVideoDuration(str).longValue();
                            WritableNativeMap writableNativeMap = new WritableNativeMap();
                            writableNativeMap.putInt("width", access$600.getWidth());
                            writableNativeMap.putInt("height", access$600.getHeight());
                            writableNativeMap.putString("mime", str5);
                            writableNativeMap.putInt("size", (int) new File(str).length());
                            writableNativeMap.putInt("duration", (int) longValue);
                            writableNativeMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, "file://" + str);
                            writableNativeMap.putString("modificationDate", String.valueOf(lastModified));
                            PickerModule.this.resultCollector.notifySuccess(writableNativeMap);
                        } catch (Exception e) {
                            PickerModule.this.resultCollector.notifyProblem(PickerModule.E_NO_IMAGE_DATA_FOUND, (Throwable) e);
                        }
                    }
                }, new Callback() {
                    public void invoke(Object... objArr) {
                        WritableNativeMap writableNativeMap = objArr[0];
                        PickerModule.this.resultCollector.notifyProblem(writableNativeMap.getString("code"), writableNativeMap.getString("message"));
                    }
                }));
            }
        }).run();
    }

    private String resolveRealPath(Activity activity, Uri uri, boolean z) throws IOException {
        String str;
        if (Build.VERSION.SDK_INT < 21) {
            str = RealPathUtil.getRealPathFromURI(activity, uri);
        } else if (z) {
            str = Uri.parse(this.mCurrentMediaPath).getPath();
        } else {
            str = RealPathUtil.getRealPathFromURI(activity, uri);
        }
        if (Build.VERSION.SDK_INT < 29) {
            return str;
        }
        return (str.startsWith(Uri.fromFile(activity.getExternalCacheDir()).getPath()) || str.startsWith(Uri.fromFile(activity.getExternalFilesDir((String) null)).getPath()) || str.startsWith(Uri.fromFile(activity.getCacheDir()).getPath()) || str.startsWith(Uri.fromFile(activity.getFilesDir()).getPath())) ? str : RealPathUtil.getRealPathFromURI(activity, Uri.fromFile(createExternalStoragePrivateFile(activity, uri)));
    }

    private File createExternalStoragePrivateFile(Context context, Uri uri) throws FileNotFoundException {
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        File file = new File(context.getExternalCacheDir(), "/temp/" + System.currentTimeMillis() + "." + getExtension(context, uri));
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[openInputStream.available()];
            openInputStream.read(bArr);
            fileOutputStream.write(bArr);
            openInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            Log.w("image-crop-picker", "Error writing " + file, e);
        }
        return file;
    }

    public String getExtension(Context context, Uri uri) {
        if (uri.getScheme().equals("content")) {
            return MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
        }
        return MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
    }

    private BitmapFactory.Options validateImage(String str) throws Exception {
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        options2.inPreferredConfig = Bitmap.Config.RGB_565;
        options2.inDither = true;
        BitmapFactory.decodeFile(str, options2);
        if (options2.outMimeType != null && options2.outWidth != 0 && options2.outHeight != 0) {
            return options2;
        }
        throw new Exception("Invalid image selected");
    }

    private WritableMap getImage(Activity activity, String str) throws Exception {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (str.startsWith("http://") || str.startsWith("https://")) {
            throw new Exception("Cannot select remote files");
        }
        String path = this.compression.compressImage(this.reactContext, this.options, str, validateImage(str)).getPath();
        BitmapFactory.Options validateImage = validateImage(path);
        long lastModified = new File(str).lastModified();
        writableNativeMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, "file://" + path);
        writableNativeMap.putInt("width", validateImage.outWidth);
        writableNativeMap.putInt("height", validateImage.outHeight);
        writableNativeMap.putString("mime", validateImage.outMimeType);
        writableNativeMap.putInt("size", (int) new File(path).length());
        writableNativeMap.putString("modificationDate", String.valueOf(lastModified));
        if (this.includeBase64) {
            writableNativeMap.putString("data", getBase64StringFromFile(path));
        }
        if (this.includeExif) {
            try {
                writableNativeMap.putMap("exif", ExifExtractor.extract(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return writableNativeMap;
    }

    private void configureCropperColors(UCrop.Options options2) {
        String str = this.cropperActiveWidgetColor;
        if (str != null) {
            options2.setActiveControlsWidgetColor(Color.parseColor(str));
        }
        String str2 = this.cropperToolbarColor;
        if (str2 != null) {
            options2.setToolbarColor(Color.parseColor(str2));
        }
        String str3 = this.cropperStatusBarColor;
        if (str3 != null) {
            options2.setStatusBarColor(Color.parseColor(str3));
        }
        String str4 = this.cropperToolbarWidgetColor;
        if (str4 != null) {
            options2.setToolbarWidgetColor(Color.parseColor(str4));
        }
    }

    /* access modifiers changed from: private */
    public void startCropping(Activity activity, Uri uri) {
        int i;
        UCrop.Options options2 = new UCrop.Options();
        options2.setCompressionFormat(Bitmap.CompressFormat.JPEG);
        options2.setCompressionQuality(100);
        options2.setCircleDimmedLayer(this.cropperCircleOverlay);
        options2.setFreeStyleCropEnabled(this.freeStyleCropEnabled);
        options2.setShowCropGrid(this.showCropGuidelines);
        options2.setShowCropFrame(this.showCropFrame);
        options2.setHideBottomControls(this.hideBottomControls);
        String str = this.cropperToolbarTitle;
        if (str != null) {
            options2.setToolbarTitle(str);
        }
        if (this.enableRotationGesture) {
            options2.setAllowedGestures(3, 3, 3);
        }
        if (!this.disableCropperColorSetters) {
            configureCropperColors(options2);
        }
        UCrop withOptions = UCrop.of(uri, Uri.fromFile(new File(getTmpDir(activity), UUID.randomUUID().toString() + ".jpg"))).withOptions(options2);
        int i2 = this.width;
        if (i2 > 0 && (i = this.height) > 0) {
            withOptions.withAspectRatio((float) i2, (float) i);
        }
        withOptions.start(activity);
    }

    private void imagePickerResult(Activity activity, int i, int i2, Intent intent) {
        if (i2 == 0) {
            this.resultCollector.notifyProblem(E_PICKER_CANCELLED_KEY, E_PICKER_CANCELLED_MSG);
        } else if (i2 != -1) {
        } else {
            if (this.multiple) {
                ClipData clipData = intent.getClipData();
                if (clipData == null) {
                    try {
                        this.resultCollector.setWaitCount(1);
                        getAsyncSelection(activity, intent.getData(), false);
                    } catch (Exception e) {
                        this.resultCollector.notifyProblem(E_NO_IMAGE_DATA_FOUND, e.getMessage());
                    }
                } else {
                    this.resultCollector.setWaitCount(clipData.getItemCount());
                    for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                        getAsyncSelection(activity, clipData.getItemAt(i3).getUri(), false);
                    }
                }
            } else {
                Uri data = intent.getData();
                if (data == null) {
                    this.resultCollector.notifyProblem(E_NO_IMAGE_DATA_FOUND, "Cannot resolve image url");
                } else if (this.cropping) {
                    startCropping(activity, data);
                } else {
                    try {
                        getAsyncSelection(activity, data, false);
                    } catch (Exception e2) {
                        this.resultCollector.notifyProblem(E_NO_IMAGE_DATA_FOUND, e2.getMessage());
                    }
                }
            }
        }
    }

    private void cameraPickerResult(Activity activity, int i, int i2, Intent intent) {
        if (i2 == 0) {
            this.resultCollector.notifyProblem(E_PICKER_CANCELLED_KEY, E_PICKER_CANCELLED_MSG);
        } else if (i2 == -1) {
            Uri uri = this.mCameraCaptureURI;
            if (uri == null) {
                this.resultCollector.notifyProblem(E_NO_IMAGE_DATA_FOUND, "Cannot resolve image url");
            } else if (this.cropping) {
                new UCrop.Options().setCompressionFormat(Bitmap.CompressFormat.JPEG);
                startCropping(activity, uri);
            } else {
                try {
                    this.resultCollector.setWaitCount(1);
                    WritableMap selection = getSelection(activity, uri, true);
                    if (selection != null) {
                        this.resultCollector.notifySuccess(selection);
                    }
                } catch (Exception e) {
                    this.resultCollector.notifyProblem(E_NO_IMAGE_DATA_FOUND, e.getMessage());
                }
            }
        }
    }

    private void croppingResult(Activity activity, int i, int i2, Intent intent) {
        if (intent != null) {
            Uri output = UCrop.getOutput(intent);
            if (output != null) {
                try {
                    if (this.width > 0 && this.height > 0) {
                        Compression compression2 = this.compression;
                        ReactApplicationContext reactApplicationContext = this.reactContext;
                        String path = output.getPath();
                        int i3 = this.width;
                        int i4 = this.height;
                        output = Uri.fromFile(compression2.resize(reactApplicationContext, path, i3, i4, i3, i4, 100));
                    }
                    WritableMap selection = getSelection(activity, output, false);
                    if (selection != null) {
                        selection.putMap("cropRect", getCroppedRectMap(intent));
                        this.resultCollector.setWaitCount(1);
                        this.resultCollector.notifySuccess(selection);
                        return;
                    }
                    throw new Exception("Cannot crop video files");
                } catch (Exception e) {
                    this.resultCollector.notifyProblem(E_NO_IMAGE_DATA_FOUND, e.getMessage());
                }
            } else {
                this.resultCollector.notifyProblem(E_NO_IMAGE_DATA_FOUND, "Cannot find image data");
            }
        } else {
            this.resultCollector.notifyProblem(E_PICKER_CANCELLED_KEY, E_PICKER_CANCELLED_MSG);
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (i == IMAGE_PICKER_REQUEST) {
            imagePickerResult(activity, i, i2, intent);
        } else if (i == CAMERA_PICKER_REQUEST) {
            cameraPickerResult(activity, i, i2, intent);
        } else if (i == 69) {
            croppingResult(activity, i, i2, intent);
        }
    }

    private boolean isCameraAvailable(Activity activity) {
        return activity.getPackageManager().hasSystemFeature("android.hardware.camera") || activity.getPackageManager().hasSystemFeature("android.hardware.camera.any");
    }

    private File createImageFile() throws IOException {
        String str = "image-" + UUID.randomUUID().toString();
        File externalFilesDir = this.reactContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (!externalFilesDir.exists() && !externalFilesDir.isDirectory()) {
            externalFilesDir.mkdirs();
        }
        File createTempFile = File.createTempFile(str, ".jpg", externalFilesDir);
        this.mCurrentMediaPath = "file:" + createTempFile.getAbsolutePath();
        return createTempFile;
    }

    private File createVideoFile() throws IOException {
        String str = "video-" + UUID.randomUUID().toString();
        File externalFilesDir = this.reactContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (!externalFilesDir.exists() && !externalFilesDir.isDirectory()) {
            externalFilesDir.mkdirs();
        }
        File createTempFile = File.createTempFile(str, ".mp4", externalFilesDir);
        this.mCurrentMediaPath = "file:" + createTempFile.getAbsolutePath();
        return createTempFile;
    }

    private static WritableMap getCroppedRectMap(Intent intent) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt(ViewHierarchyNode.JsonKeys.X, intent.getIntExtra(UCrop.EXTRA_OUTPUT_OFFSET_X, -1));
        writableNativeMap.putInt(ViewHierarchyNode.JsonKeys.Y, intent.getIntExtra(UCrop.EXTRA_OUTPUT_OFFSET_Y, -1));
        writableNativeMap.putInt("width", intent.getIntExtra(UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, -1));
        writableNativeMap.putInt("height", intent.getIntExtra(UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, -1));
        return writableNativeMap;
    }
}
