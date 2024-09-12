package co.feeld;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;

public class PreventScreenshotModule extends ReactContextBaseJavaModule {
    private static final String PREVENT_SCREENSHOT_ERROR_CODE = "PREVENT_SCREENSHOT_ERROR_CODE";
    private final ReactApplicationContext reactContext;

    public String getName() {
        return "PreventScreenshotModule";
    }

    PreventScreenshotModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @ReactMethod
    public void forbid(final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    PreventScreenshotModule.this.getCurrentActivity().getWindow().addFlags(8192);
                    promise.resolve("Done. Screenshot taking locked.");
                } catch (Exception unused) {
                    promise.reject(PreventScreenshotModule.PREVENT_SCREENSHOT_ERROR_CODE, "Forbid screenshot taking failure.");
                }
            }
        });
    }

    @ReactMethod
    public void allow(final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    PreventScreenshotModule.this.getCurrentActivity().getWindow().clearFlags(8192);
                    promise.resolve("Done. Screenshot taking unlocked.");
                } catch (Exception unused) {
                    promise.reject(PreventScreenshotModule.PREVENT_SCREENSHOT_ERROR_CODE, "Allow screenshot taking failure.");
                }
            }
        });
    }
}
