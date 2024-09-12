package com.facebook.react.views.imagehelper;

import android.content.Context;
import android.net.Uri;
import java.util.Objects;

public class ImageSource {
    private static final String TRANSPARENT_BITMAP_URI = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII=";
    private boolean isResource;
    private double mSize;
    private String mSource;
    private Uri mUri;

    public ImageSource(Context context, String str, double d, double d2) {
        this.mSource = str;
        this.mSize = d * d2;
        this.mUri = computeUri(context);
    }

    public static ImageSource getTransparentBitmapImageSource(Context context) {
        return new ImageSource(context, TRANSPARENT_BITMAP_URI);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ImageSource imageSource = (ImageSource) obj;
        if (Double.compare(imageSource.mSize, this.mSize) != 0 || this.isResource != imageSource.isResource || !Objects.equals(this.mUri, imageSource.mUri) || !Objects.equals(this.mSource, imageSource.mSource)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mUri, this.mSource, Double.valueOf(this.mSize), Boolean.valueOf(this.isResource)});
    }

    public ImageSource(Context context, String str) {
        this(context, str, 0.0d, 0.0d);
    }

    public String getSource() {
        return this.mSource;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public double getSize() {
        return this.mSize;
    }

    public boolean isResource() {
        return this.isResource;
    }

    private Uri computeUri(Context context) {
        try {
            Uri parse = Uri.parse(this.mSource);
            return parse.getScheme() == null ? computeLocalUri(context) : parse;
        } catch (Exception unused) {
            return computeLocalUri(context);
        }
    }

    private Uri computeLocalUri(Context context) {
        this.isResource = true;
        return ResourceDrawableIdHelper.getInstance().getResourceDrawableUri(context, this.mSource);
    }
}
