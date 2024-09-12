package com.facebook.react.modules.i18nmanager;

import android.os.Build;
import com.facebook.fbreact.specs.NativeI18nManagerSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@ReactModule(name = "I18nManager")
public class I18nManagerModule extends NativeI18nManagerSpec {
    public static final String NAME = "I18nManager";
    private final I18nUtil sharedI18nUtilInstance = I18nUtil.getInstance();

    public String getName() {
        return NAME;
    }

    public I18nManagerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getTypedExportedConstants() {
        Locale locale;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (Build.VERSION.SDK_INT >= 24) {
            locale = reactApplicationContext.getResources().getConfiguration().getLocales().get(0);
        } else {
            locale = reactApplicationContext.getResources().getConfiguration().locale;
        }
        HashMap newHashMap = MapBuilder.newHashMap();
        newHashMap.put("isRTL", Boolean.valueOf(this.sharedI18nUtilInstance.isRTL(reactApplicationContext)));
        newHashMap.put("doLeftAndRightSwapInRTL", Boolean.valueOf(this.sharedI18nUtilInstance.doLeftAndRightSwapInRTL(reactApplicationContext)));
        newHashMap.put("localeIdentifier", locale.toString());
        return newHashMap;
    }

    public void allowRTL(boolean z) {
        this.sharedI18nUtilInstance.allowRTL(getReactApplicationContext(), z);
    }

    public void forceRTL(boolean z) {
        this.sharedI18nUtilInstance.forceRTL(getReactApplicationContext(), z);
    }

    public void swapLeftAndRightInRTL(boolean z) {
        this.sharedI18nUtilInstance.swapLeftAndRightInRTL(getReactApplicationContext(), z);
    }
}
