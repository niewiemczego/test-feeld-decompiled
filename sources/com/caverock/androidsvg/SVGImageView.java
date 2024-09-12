package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class SVGImageView extends ImageView {
    private static Method setLayerTypeMethod;
    private RenderOptions renderOptions = new RenderOptions();
    /* access modifiers changed from: private */
    public SVG svg = null;

    static {
        Class<View> cls = View.class;
        try {
            setLayerTypeMethod = cls.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class});
        } catch (NoSuchMethodException unused) {
        }
    }

    public SVGImageView(Context context) {
        super(context);
    }

    public SVGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        init(attributeSet, 0);
    }

    public SVGImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i);
    }

    private void init(AttributeSet attributeSet, int i) {
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGImageView, i, 0);
            try {
                String string = obtainStyledAttributes.getString(R.styleable.SVGImageView_css);
                if (string != null) {
                    this.renderOptions.css(string);
                }
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SVGImageView_svg, -1);
                if (resourceId != -1) {
                    setImageResource(resourceId);
                    return;
                }
                String string2 = obtainStyledAttributes.getString(R.styleable.SVGImageView_svg);
                if (string2 != null) {
                    if (internalSetImageURI(Uri.parse(string2))) {
                        obtainStyledAttributes.recycle();
                        return;
                    } else if (internalSetImageAsset(string2)) {
                        obtainStyledAttributes.recycle();
                        return;
                    } else {
                        setFromString(string2);
                    }
                }
                obtainStyledAttributes.recycle();
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setSVG(SVG svg2) {
        if (svg2 != null) {
            this.svg = svg2;
            doRender();
            return;
        }
        throw new IllegalArgumentException("Null value passed to setSVG()");
    }

    public void setSVG(SVG svg2, String str) {
        if (svg2 != null) {
            this.svg = svg2;
            this.renderOptions.css(str);
            doRender();
            return;
        }
        throw new IllegalArgumentException("Null value passed to setSVG()");
    }

    public void setCSS(String str) {
        this.renderOptions.css(str);
        doRender();
    }

    public void setImageResource(int i) {
        new LoadResourceTask(getContext(), i).execute(new Integer[0]);
    }

    public void setImageURI(Uri uri) {
        if (!internalSetImageURI(uri)) {
            Log.e("SVGImageView", "File not found: " + uri);
        }
    }

    public void setImageAsset(String str) {
        if (!internalSetImageAsset(str)) {
            Log.e("SVGImageView", "File not found: " + str);
        }
    }

    private boolean internalSetImageURI(Uri uri) {
        try {
            InputStream openInputStream = getContext().getContentResolver().openInputStream(uri);
            new LoadURITask().execute(new InputStream[]{openInputStream});
            return true;
        } catch (FileNotFoundException unused) {
            return false;
        }
    }

    private boolean internalSetImageAsset(String str) {
        try {
            InputStream open = getContext().getAssets().open(str);
            new LoadURITask().execute(new InputStream[]{open});
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private void setFromString(String str) {
        try {
            this.svg = SVG.getFromString(str);
            doRender();
        } catch (SVGParseException unused) {
            Log.e("SVGImageView", "Could not find SVG at: " + str);
        }
    }

    private class LoadResourceTask extends AsyncTask<Integer, Integer, SVG> {
        private Context context;
        private int resourceId;

        LoadResourceTask(Context context2, int i) {
            this.context = context2;
            this.resourceId = i;
        }

        /* access modifiers changed from: protected */
        public SVG doInBackground(Integer... numArr) {
            try {
                return SVG.getFromResource(this.context, this.resourceId);
            } catch (SVGParseException e) {
                Log.e("SVGImageView", String.format("Error loading resource 0x%x: %s", new Object[]{Integer.valueOf(this.resourceId), e.getMessage()}));
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(SVG svg) {
            SVG unused = SVGImageView.this.svg = svg;
            SVGImageView.this.doRender();
        }
    }

    private class LoadURITask extends AsyncTask<InputStream, Integer, SVG> {
        private LoadURITask() {
        }

        /* access modifiers changed from: protected */
        public SVG doInBackground(InputStream... inputStreamArr) {
            try {
                SVG fromInputStream = SVG.getFromInputStream(inputStreamArr[0]);
                try {
                    inputStreamArr[0].close();
                } catch (IOException unused) {
                }
                return fromInputStream;
            } catch (SVGParseException e) {
                Log.e("SVGImageView", "Parse error loading URI: " + e.getMessage());
                try {
                    inputStreamArr[0].close();
                    return null;
                } catch (IOException unused2) {
                    return null;
                }
            } catch (Throwable th) {
                try {
                    inputStreamArr[0].close();
                } catch (IOException unused3) {
                }
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(SVG svg) {
            SVG unused = SVGImageView.this.svg = svg;
            SVGImageView.this.doRender();
        }
    }

    private void setSoftwareLayerType() {
        if (setLayerTypeMethod != null) {
            try {
                int i = View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()));
                setLayerTypeMethod.invoke(this, new Object[]{Integer.valueOf(i), null});
            } catch (Exception e) {
                Log.w("SVGImageView", "Unexpected failure calling setLayerType", e);
            }
        }
    }

    /* access modifiers changed from: private */
    public void doRender() {
        SVG svg2 = this.svg;
        if (svg2 != null) {
            Picture renderToPicture = svg2.renderToPicture(this.renderOptions);
            setSoftwareLayerType();
            setImageDrawable(new PictureDrawable(renderToPicture));
        }
    }
}
