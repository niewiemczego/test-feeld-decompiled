package expo.modules.adapters.react.services;

import android.graphics.Typeface;
import com.facebook.react.views.text.ReactFontManager;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.interfaces.font.FontManagerInterface;
import java.util.Collections;
import java.util.List;

public class FontManagerModule implements FontManagerInterface, InternalModule {
    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(FontManagerInterface.class);
    }

    public void setTypeface(String str, int i, Typeface typeface) {
        ReactFontManager.getInstance().setTypeface(str, i, typeface);
    }
}
