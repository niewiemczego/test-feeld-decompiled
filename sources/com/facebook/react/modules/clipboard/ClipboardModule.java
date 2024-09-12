package com.facebook.react.modules.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.facebook.fbreact.specs.NativeClipboardSpec;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "Clipboard")
public class ClipboardModule extends NativeClipboardSpec {
    public static final String NAME = "Clipboard";

    public String getName() {
        return NAME;
    }

    public ClipboardModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private ClipboardManager getClipboardService() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        getReactApplicationContext();
        return (ClipboardManager) reactApplicationContext.getSystemService("clipboard");
    }

    public void getString(Promise promise) {
        try {
            ClipboardManager clipboardService = getClipboardService();
            ClipData primaryClip = clipboardService.getPrimaryClip();
            if (primaryClip != null) {
                if (primaryClip.getItemCount() >= 1) {
                    promise.resolve("" + clipboardService.getPrimaryClip().getItemAt(0).getText());
                    return;
                }
            }
            promise.resolve("");
        } catch (Exception e) {
            promise.reject((Throwable) e);
        }
    }

    public void setString(String str) {
        getClipboardService().setPrimaryClip(ClipData.newPlainText((CharSequence) null, str));
    }
}
