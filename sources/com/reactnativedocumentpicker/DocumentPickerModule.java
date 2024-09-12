package com.reactnativedocumentpicker;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Log;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.GuardedResultAsyncTask;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ReactModule(name = "RNDocumentPicker")
public class DocumentPickerModule extends ReactContextBaseJavaModule {
    private static final String E_ACTIVITY_DOES_NOT_EXIST = "ACTIVITY_DOES_NOT_EXIST";
    private static final String E_DOCUMENT_PICKER_CANCELED = "DOCUMENT_PICKER_CANCELED";
    private static final String E_FAILED_TO_SHOW_PICKER = "FAILED_TO_SHOW_PICKER";
    private static final String E_INVALID_DATA_RETURNED = "INVALID_DATA_RETURNED";
    private static final String E_UNABLE_TO_OPEN_FILE_TYPE = "UNABLE_TO_OPEN_FILE_TYPE";
    private static final String E_UNEXPECTED_EXCEPTION = "UNEXPECTED_EXCEPTION";
    private static final String E_UNKNOWN_ACTIVITY_RESULT = "UNKNOWN_ACTIVITY_RESULT";
    private static final String FIELD_COPY_ERROR = "copyError";
    private static final String FIELD_FILE_COPY_URI = "fileCopyUri";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_SIZE = "size";
    private static final String FIELD_TYPE = "type";
    private static final String FIELD_URI = "uri";
    public static final String NAME = "RNDocumentPicker";
    private static final String OPTION_COPY_TO = "copyTo";
    private static final String OPTION_MULTIPLE = "allowMultiSelection";
    private static final String OPTION_TYPE = "type";
    private static final int PICK_DIR_REQUEST_CODE = 42;
    private static final int READ_REQUEST_CODE = 41;
    private final ActivityEventListener activityEventListener;
    private String copyTo;
    /* access modifiers changed from: private */
    public Promise promise;

    public String getName() {
        return NAME;
    }

    private String[] readableArrayToStringArray(ReadableArray readableArray) {
        int size = readableArray.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = readableArray.getString(i);
        }
        return strArr;
    }

    public DocumentPickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        AnonymousClass1 r0 = new BaseActivityEventListener() {
            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                Promise access$000 = DocumentPickerModule.this.promise;
                if (access$000 == null) {
                    Log.e(DocumentPickerModule.NAME, "promise was null in onActivityResult");
                } else if (i == 41) {
                    DocumentPickerModule.this.onShowActivityResult(i2, intent, access$000);
                } else if (i == 42) {
                    DocumentPickerModule.this.onPickDirectoryResult(i2, intent);
                }
            }
        };
        this.activityEventListener = r0;
        reactApplicationContext.addActivityEventListener(r0);
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        getReactApplicationContext().removeActivityEventListener(this.activityEventListener);
    }

    @ReactMethod
    public void pick(ReadableMap readableMap, Promise promise2) {
        ReadableArray array;
        Activity currentActivity = getCurrentActivity();
        this.promise = promise2;
        this.copyTo = readableMap.hasKey(OPTION_COPY_TO) ? readableMap.getString(OPTION_COPY_TO) : null;
        if (currentActivity == null) {
            sendError(E_ACTIVITY_DOES_NOT_EXIST, "Current activity does not exist");
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            boolean z = false;
            if (!readableMap.isNull("type") && (array = readableMap.getArray("type")) != null) {
                if (array.size() > 1) {
                    String[] readableArrayToStringArray = readableArrayToStringArray(array);
                    intent.putExtra("android.intent.extra.MIME_TYPES", readableArrayToStringArray);
                    intent.setType(String.join("|", readableArrayToStringArray));
                } else if (array.size() == 1) {
                    intent.setType(array.getString(0));
                }
            }
            if (!readableMap.isNull(OPTION_MULTIPLE) && readableMap.getBoolean(OPTION_MULTIPLE)) {
                z = true;
            }
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", z);
            currentActivity.startActivityForResult(intent, 41, Bundle.EMPTY);
        } catch (ActivityNotFoundException e) {
            sendError(E_UNABLE_TO_OPEN_FILE_TYPE, e.getLocalizedMessage());
        } catch (Exception e2) {
            e2.printStackTrace();
            sendError(E_FAILED_TO_SHOW_PICKER, e2.getLocalizedMessage());
        }
    }

    @ReactMethod
    public void pickDirectory(Promise promise2) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise2.reject(E_ACTIVITY_DOES_NOT_EXIST, "Current activity does not exist");
            return;
        }
        this.promise = promise2;
        try {
            currentActivity.startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), 42, (Bundle) null);
        } catch (Exception e) {
            sendError(E_FAILED_TO_SHOW_PICKER, "Failed to create directory picker", e);
        }
    }

    /* access modifiers changed from: private */
    public void onPickDirectoryResult(int i, Intent intent) {
        if (i == 0) {
            sendError(E_DOCUMENT_PICKER_CANCELED, "User canceled directory picker");
        } else if (i != -1) {
            sendError(E_UNKNOWN_ACTIVITY_RESULT, "Unknown activity result: " + i);
        } else if (intent == null || intent.getData() == null) {
            sendError(E_INVALID_DATA_RETURNED, "Invalid data returned by intent");
        } else {
            Uri data = intent.getData();
            WritableMap createMap = Arguments.createMap();
            createMap.putString("uri", data.toString());
            this.promise.resolve(createMap);
        }
    }

    public void onShowActivityResult(int i, Intent intent, Promise promise2) {
        Uri uri;
        if (i == 0) {
            sendError(E_DOCUMENT_PICKER_CANCELED, "User canceled document picker");
        } else if (i == -1) {
            ClipData clipData = null;
            if (intent != null) {
                Uri data = intent.getData();
                ClipData clipData2 = intent.getClipData();
                uri = data;
                clipData = clipData2;
            } else {
                uri = null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                if (clipData != null && clipData.getItemCount() > 0) {
                    int itemCount = clipData.getItemCount();
                    for (int i2 = 0; i2 < itemCount; i2++) {
                        arrayList.add(clipData.getItemAt(i2).getUri());
                    }
                } else if (uri != null) {
                    arrayList.add(uri);
                } else {
                    sendError(E_INVALID_DATA_RETURNED, "Invalid data returned by intent");
                    return;
                }
                new ProcessDataTask(getReactApplicationContext(), arrayList, this.copyTo, promise2).execute(new Void[0]);
            } catch (Exception e) {
                sendError(E_UNEXPECTED_EXCEPTION, e.getLocalizedMessage(), e);
            }
        } else {
            sendError(E_UNKNOWN_ACTIVITY_RESULT, "Unknown activity result: " + i);
        }
    }

    private static class ProcessDataTask extends GuardedResultAsyncTask<ReadableArray> {
        private final String copyTo;
        private final Promise promise;
        private final List<Uri> uris;
        private final WeakReference<Context> weakContext;

        protected ProcessDataTask(ReactContext reactContext, List<Uri> list, String str, Promise promise2) {
            super(reactContext.getExceptionHandler());
            this.weakContext = new WeakReference<>(reactContext.getApplicationContext());
            this.uris = list;
            this.copyTo = str;
            this.promise = promise2;
        }

        /* access modifiers changed from: protected */
        public ReadableArray doInBackgroundGuarded() {
            WritableArray createArray = Arguments.createArray();
            for (Uri metadata : this.uris) {
                createArray.pushMap(getMetadata(metadata));
            }
            return createArray;
        }

        /* access modifiers changed from: protected */
        public void onPostExecuteGuarded(ReadableArray readableArray) {
            this.promise.resolve(readableArray);
        }

        private WritableMap getMetadata(Uri uri) {
            Context context = (Context) this.weakContext.get();
            if (context == null) {
                return Arguments.createMap();
            }
            ContentResolver contentResolver = context.getContentResolver();
            WritableMap createMap = Arguments.createMap();
            createMap.putString("uri", uri.toString());
            createMap.putString("type", contentResolver.getType(uri));
            Cursor query = contentResolver.query(uri, (String[]) null, (String) null, (String[]) null, (String) null, (CancellationSignal) null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int columnIndex = query.getColumnIndex("_display_name");
                        if (!query.isNull(columnIndex)) {
                            createMap.putString("name", query.getString(columnIndex));
                        } else {
                            createMap.putNull("name");
                        }
                        int columnIndex2 = query.getColumnIndex("mime_type");
                        if (!query.isNull(columnIndex2)) {
                            createMap.putString("type", query.getString(columnIndex2));
                        }
                        int columnIndex3 = query.getColumnIndex("_size");
                        if (query.isNull(columnIndex3)) {
                            createMap.putNull(DocumentPickerModule.FIELD_SIZE);
                        } else {
                            createMap.putDouble(DocumentPickerModule.FIELD_SIZE, (double) query.getLong(columnIndex3));
                        }
                    }
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            }
            if (query != null) {
                query.close();
            }
            prepareFileUri(context, createMap, uri);
            return createMap;
            throw th;
        }

        private void prepareFileUri(Context context, WritableMap writableMap, Uri uri) {
            if (this.copyTo == null) {
                writableMap.putNull(DocumentPickerModule.FIELD_FILE_COPY_URI);
            } else {
                copyFileToLocalStorage(context, writableMap, uri);
            }
        }

        private void copyFileToLocalStorage(Context context, WritableMap writableMap, Uri uri) {
            File cacheDir = context.getCacheDir();
            if (this.copyTo.equals("documentDirectory")) {
                cacheDir = context.getFilesDir();
            }
            File file = new File(cacheDir, UUID.randomUUID().toString());
            try {
                if (file.mkdir()) {
                    String string = writableMap.getString("name");
                    if (string == null) {
                        string = String.valueOf(System.currentTimeMillis());
                    }
                    writableMap.putString(DocumentPickerModule.FIELD_FILE_COPY_URI, copyFile(context, uri, new File(file, string)).toString());
                    return;
                }
                throw new IOException("failed to create directory at " + file.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
                writableMap.putNull(DocumentPickerModule.FIELD_FILE_COPY_URI);
                writableMap.putString(DocumentPickerModule.FIELD_COPY_ERROR, e.getLocalizedMessage());
            }
        }

        public static Uri copyFile(Context context, Uri uri, File file) throws IOException {
            FileOutputStream fileOutputStream;
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            try {
                fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = openInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                Uri fromFile = Uri.fromFile(file);
                fileOutputStream.close();
                if (openInputStream != null) {
                    openInputStream.close();
                }
                return fromFile;
            } catch (Throwable th) {
                if (openInputStream != null) {
                    try {
                        openInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
            throw th;
        }
    }

    private void sendError(String str, String str2) {
        sendError(str, str2, (Exception) null);
    }

    private void sendError(String str, String str2, Exception exc) {
        Promise promise2 = this.promise;
        if (promise2 != null) {
            this.promise = null;
            promise2.reject(str, str2, (Throwable) exc);
        }
    }
}
