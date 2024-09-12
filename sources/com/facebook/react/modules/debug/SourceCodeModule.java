package com.facebook.react.modules.debug;

import com.facebook.fbreact.specs.NativeSourceCodeSpec;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "SourceCode")
public class SourceCodeModule extends NativeSourceCodeSpec {
    public static final String NAME = "SourceCode";

    public String getName() {
        return NAME;
    }

    public SourceCodeModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getTypedExportedConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("scriptURL", (String) Assertions.assertNotNull(getReactApplicationContext().getSourceURL(), "No source URL loaded, have you initialised the instance?"));
        return hashMap;
    }
}
