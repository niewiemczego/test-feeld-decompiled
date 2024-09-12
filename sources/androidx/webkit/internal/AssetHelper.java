package androidx.webkit.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

public class AssetHelper {
    public static final String DEFAULT_MIME_TYPE = "text/plain";
    private static final String TAG = "AssetHelper";
    private Context mContext;

    public AssetHelper(Context context) {
        this.mContext = context;
    }

    private static InputStream handleSvgzStream(String str, InputStream inputStream) throws IOException {
        return str.endsWith(".svgz") ? new GZIPInputStream(inputStream) : inputStream;
    }

    private static String removeLeadingSlash(String str) {
        return (str.length() <= 1 || str.charAt(0) != '/') ? str : str.substring(1);
    }

    private int getFieldId(String str, String str2) {
        return this.mContext.getResources().getIdentifier(str2, str, this.mContext.getPackageName());
    }

    private int getValueType(int i) {
        TypedValue typedValue = new TypedValue();
        this.mContext.getResources().getValue(i, typedValue, true);
        return typedValue.type;
    }

    public InputStream openResource(String str) throws Resources.NotFoundException, IOException {
        String removeLeadingSlash = removeLeadingSlash(str);
        String[] split = removeLeadingSlash.split("/", -1);
        if (split.length == 2) {
            String str2 = split[0];
            String str3 = split[1];
            int lastIndexOf = str3.lastIndexOf(46);
            if (lastIndexOf != -1) {
                str3 = str3.substring(0, lastIndexOf);
            }
            int fieldId = getFieldId(str2, str3);
            int valueType = getValueType(fieldId);
            if (valueType == 3) {
                return handleSvgzStream(removeLeadingSlash, this.mContext.getResources().openRawResource(fieldId));
            }
            throw new IOException(String.format("Expected %s resource to be of TYPE_STRING but was %d", new Object[]{removeLeadingSlash, Integer.valueOf(valueType)}));
        }
        throw new IllegalArgumentException("Incorrect resource path: " + removeLeadingSlash);
    }

    public InputStream openAsset(String str) throws IOException {
        String removeLeadingSlash = removeLeadingSlash(str);
        return handleSvgzStream(removeLeadingSlash, this.mContext.getAssets().open(removeLeadingSlash, 2));
    }

    public static InputStream openFile(File file) throws FileNotFoundException, IOException {
        return handleSvgzStream(file.getPath(), new FileInputStream(file));
    }

    public static File getCanonicalFileIfChild(File file, String str) throws IOException {
        String canonicalDirPath = getCanonicalDirPath(file);
        String canonicalPath = new File(file, str).getCanonicalPath();
        if (canonicalPath.startsWith(canonicalDirPath)) {
            return new File(canonicalPath);
        }
        return null;
    }

    public static String getCanonicalDirPath(File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        return !canonicalPath.endsWith("/") ? canonicalPath + "/" : canonicalPath;
    }

    public static File getDataDir(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.getDataDir();
        }
        return context.getCacheDir().getParentFile();
    }

    public static String guessMimeType(String str) {
        String guessContentTypeFromName = URLConnection.guessContentTypeFromName(str);
        return guessContentTypeFromName == null ? DEFAULT_MIME_TYPE : guessContentTypeFromName;
    }
}
