package com.facebook.react.views.text;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.content.res.ResourcesCompat;
import java.util.HashMap;
import java.util.Map;

public class ReactFontManager {
    private static final String[] EXTENSIONS = {"", "_bold", "_italic", "_bold_italic"};
    private static final String[] FILE_EXTENSIONS = {".ttf", ".otf"};
    private static final String FONTS_ASSET_PATH = "fonts/";
    private static ReactFontManager sReactFontManagerInstance;
    private final Map<String, Typeface> mCustomTypefaceCache = new HashMap();
    private final Map<String, AssetFontFamily> mFontCache = new HashMap();

    private ReactFontManager() {
    }

    public static ReactFontManager getInstance() {
        if (sReactFontManagerInstance == null) {
            sReactFontManagerInstance = new ReactFontManager();
        }
        return sReactFontManagerInstance;
    }

    public Typeface getTypeface(String str, int i, AssetManager assetManager) {
        return getTypeface(str, new TypefaceStyle(i), assetManager);
    }

    public Typeface getTypeface(String str, int i, boolean z, AssetManager assetManager) {
        return getTypeface(str, new TypefaceStyle(i, z), assetManager);
    }

    public Typeface getTypeface(String str, int i, int i2, AssetManager assetManager) {
        return getTypeface(str, new TypefaceStyle(i, i2), assetManager);
    }

    public Typeface getTypeface(String str, TypefaceStyle typefaceStyle, AssetManager assetManager) {
        if (this.mCustomTypefaceCache.containsKey(str)) {
            return typefaceStyle.apply(this.mCustomTypefaceCache.get(str));
        }
        AssetFontFamily assetFontFamily = this.mFontCache.get(str);
        if (assetFontFamily == null) {
            assetFontFamily = new AssetFontFamily();
            this.mFontCache.put(str, assetFontFamily);
        }
        int nearestStyle = typefaceStyle.getNearestStyle();
        Typeface typefaceForStyle = assetFontFamily.getTypefaceForStyle(nearestStyle);
        if (typefaceForStyle != null) {
            return typefaceForStyle;
        }
        Typeface createAssetTypeface = createAssetTypeface(str, nearestStyle, assetManager);
        assetFontFamily.setTypefaceForStyle(nearestStyle, createAssetTypeface);
        return createAssetTypeface;
    }

    public void addCustomFont(Context context, String str, int i) {
        Typeface font = ResourcesCompat.getFont(context, i);
        if (font != null) {
            this.mCustomTypefaceCache.put(str, font);
        }
    }

    public void addCustomFont(String str, Typeface typeface) {
        if (typeface != null) {
            this.mCustomTypefaceCache.put(str, typeface);
        }
    }

    public void setTypeface(String str, int i, Typeface typeface) {
        if (typeface != null) {
            AssetFontFamily assetFontFamily = this.mFontCache.get(str);
            if (assetFontFamily == null) {
                assetFontFamily = new AssetFontFamily();
                this.mFontCache.put(str, assetFontFamily);
            }
            assetFontFamily.setTypefaceForStyle(i, typeface);
        }
    }

    private static Typeface createAssetTypeface(String str, int i, AssetManager assetManager) {
        String str2 = EXTENSIONS[i];
        String[] strArr = FILE_EXTENSIONS;
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            try {
                return Typeface.createFromAsset(assetManager, FONTS_ASSET_PATH + str + str2 + strArr[i2]);
            } catch (RuntimeException unused) {
                i2++;
            }
        }
        return Typeface.create(str, i);
    }

    private static class AssetFontFamily {
        private SparseArray<Typeface> mTypefaceSparseArray;

        private AssetFontFamily() {
            this.mTypefaceSparseArray = new SparseArray<>(4);
        }

        public Typeface getTypefaceForStyle(int i) {
            return this.mTypefaceSparseArray.get(i);
        }

        public void setTypefaceForStyle(int i, Typeface typeface) {
            this.mTypefaceSparseArray.put(i, typeface);
        }
    }
}
