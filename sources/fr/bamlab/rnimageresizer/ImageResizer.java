package fr.bamlab.rnimageresizer;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.imagepipeline.common.RotationOptions;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

public class ImageResizer {
    private static final String[] EXIF_TO_COPY_ROTATED = {ExifInterface.TAG_APERTURE_VALUE, ExifInterface.TAG_MAX_APERTURE_VALUE, ExifInterface.TAG_METERING_MODE, ExifInterface.TAG_ARTIST, ExifInterface.TAG_BITS_PER_SAMPLE, ExifInterface.TAG_COMPRESSION, ExifInterface.TAG_BODY_SERIAL_NUMBER, ExifInterface.TAG_BRIGHTNESS_VALUE, ExifInterface.TAG_CONTRAST, "CameraOwnerName", ExifInterface.TAG_COLOR_SPACE, ExifInterface.TAG_COPYRIGHT, ExifInterface.TAG_DATETIME, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_DATETIME_ORIGINAL, ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION, ExifInterface.TAG_DIGITAL_ZOOM_RATIO, ExifInterface.TAG_EXIF_VERSION, ExifInterface.TAG_EXPOSURE_BIAS_VALUE, ExifInterface.TAG_EXPOSURE_INDEX, ExifInterface.TAG_EXPOSURE_MODE, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_EXPOSURE_PROGRAM, ExifInterface.TAG_FLASH, ExifInterface.TAG_FLASH_ENERGY, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM, ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION, ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION, ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION, ExifInterface.TAG_PLANAR_CONFIGURATION, ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_GAIN_CONTROL, ExifInterface.TAG_GAMMA, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_AREA_INFORMATION, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_DOP, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_STATUS, ExifInterface.TAG_GPS_DEST_BEARING, ExifInterface.TAG_GPS_DEST_BEARING_REF, ExifInterface.TAG_GPS_DEST_DISTANCE, ExifInterface.TAG_GPS_DEST_DISTANCE_REF, ExifInterface.TAG_GPS_DEST_LATITUDE, ExifInterface.TAG_GPS_DEST_LATITUDE_REF, ExifInterface.TAG_GPS_DEST_LONGITUDE, ExifInterface.TAG_GPS_DEST_LONGITUDE_REF, ExifInterface.TAG_GPS_DIFFERENTIAL, ExifInterface.TAG_GPS_IMG_DIRECTION, ExifInterface.TAG_GPS_IMG_DIRECTION_REF, ExifInterface.TAG_GPS_MAP_DATUM, ExifInterface.TAG_GPS_MEASURE_MODE, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_SATELLITES, ExifInterface.TAG_GPS_SPEED, ExifInterface.TAG_GPS_SPEED_REF, ExifInterface.TAG_GPS_STATUS, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_GPS_TRACK, ExifInterface.TAG_GPS_TRACK_REF, ExifInterface.TAG_GPS_VERSION_ID, ExifInterface.TAG_IMAGE_DESCRIPTION, ExifInterface.TAG_IMAGE_UNIQUE_ID, ExifInterface.TAG_ISO_SPEED, ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, ExifInterface.TAG_LENS_MAKE, ExifInterface.TAG_LENS_MODEL, ExifInterface.TAG_LENS_SERIAL_NUMBER, ExifInterface.TAG_LENS_SPECIFICATION, ExifInterface.TAG_LIGHT_SOURCE, ExifInterface.TAG_MAKE, ExifInterface.TAG_MAKER_NOTE, ExifInterface.TAG_MODEL, ExifInterface.TAG_SATURATION, ExifInterface.TAG_SHARPNESS, ExifInterface.TAG_SHUTTER_SPEED_VALUE, ExifInterface.TAG_SOFTWARE, ExifInterface.TAG_SUBJECT_DISTANCE, ExifInterface.TAG_SUBJECT_DISTANCE_RANGE, ExifInterface.TAG_SUBJECT_LOCATION, ExifInterface.TAG_USER_COMMENT, ExifInterface.TAG_WHITE_BALANCE};
    private static final String IMAGE_JPEG = "image/jpeg";
    private static final String IMAGE_PNG = "image/png";
    private static final String SCHEME_CONTENT = "content";
    private static final String SCHEME_DATA = "data";
    private static final String SCHEME_FILE = "file";
    private static final String SCHEME_HTTP = "http";
    private static final String SCHEME_HTTPS = "https";

    private static Bitmap resizeImage(Bitmap bitmap, int i, int i2, String str, boolean z) {
        float f;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i2 <= 0 || i <= 0) {
            return null;
        }
        if (!str.equals("stretch")) {
            float f2 = (float) width;
            float f3 = ((float) i) / f2;
            float f4 = (float) height;
            float f5 = ((float) i2) / f4;
            if (str.equals("cover")) {
                f = Math.max(f3, f5);
            } else {
                f = Math.min(f3, f5);
            }
            if (z) {
                f = Math.min(f, 1.0f);
            }
            int round = Math.round(f2 * f);
            i2 = Math.round(f4 * f);
            i = round;
        } else if (z) {
            i = Math.min(width, i);
            i2 = Math.min(height, i2);
        }
        try {
            return Bitmap.createScaledBitmap(bitmap, i, i2, true);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static Bitmap rotateImage(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static File saveImage(Bitmap bitmap, File file, String str, Bitmap.CompressFormat compressFormat, int i) throws IOException {
        if (bitmap != null) {
            File file2 = new File(file, str + "." + compressFormat.name());
            if (file2.createNewFile()) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(compressFormat, i, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(byteArray);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file2;
            }
            throw new IOException("The file already exists");
        }
        throw new IOException("The bitmap couldn't be resized");
    }

    private static File getFileFromUri(Context context, Uri uri) {
        File file = new File(uri.getPath());
        if (file.exists()) {
            return file;
        }
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null);
            int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
            cursor.moveToFirst();
            File file2 = new File(cursor.getString(columnIndexOrThrow));
            if (cursor != null) {
                cursor.close();
            }
            return file2;
        } catch (Exception unused) {
            if (cursor == null) {
                return file;
            }
            cursor.close();
            return file;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0033 A[Catch:{ Exception -> 0x0046 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyExif(android.content.Context r6, android.net.Uri r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "ImageResizer::copyExif"
            r1 = 0
            r2 = 0
            java.io.File r6 = getFileFromUri(r6, r7)     // Catch:{ Exception -> 0x0021 }
            boolean r7 = r6.exists()     // Catch:{ Exception -> 0x0021 }
            if (r7 != 0) goto L_0x000f
            return r2
        L_0x000f:
            androidx.exifinterface.media.ExifInterface r7 = new androidx.exifinterface.media.ExifInterface     // Catch:{ Exception -> 0x0021 }
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x0021 }
            r7.<init>((java.lang.String) r6)     // Catch:{ Exception -> 0x0021 }
            androidx.exifinterface.media.ExifInterface r6 = new androidx.exifinterface.media.ExifInterface     // Catch:{ Exception -> 0x001f }
            r6.<init>((java.lang.String) r8)     // Catch:{ Exception -> 0x001f }
            r1 = r6
            goto L_0x0028
        L_0x001f:
            r6 = move-exception
            goto L_0x0023
        L_0x0021:
            r6 = move-exception
            r7 = r1
        L_0x0023:
            java.lang.String r8 = "EXIF read failed"
            android.util.Log.e(r0, r8, r6)
        L_0x0028:
            if (r7 == 0) goto L_0x004c
            if (r1 != 0) goto L_0x002d
            goto L_0x004c
        L_0x002d:
            java.lang.String[] r6 = EXIF_TO_COPY_ROTATED     // Catch:{ Exception -> 0x0046 }
            int r8 = r6.length     // Catch:{ Exception -> 0x0046 }
            r3 = r2
        L_0x0031:
            if (r3 >= r8) goto L_0x0041
            r4 = r6[r3]     // Catch:{ Exception -> 0x0046 }
            java.lang.String r5 = r7.getAttribute(r4)     // Catch:{ Exception -> 0x0046 }
            if (r5 == 0) goto L_0x003e
            r1.setAttribute(r4, r5)     // Catch:{ Exception -> 0x0046 }
        L_0x003e:
            int r3 = r3 + 1
            goto L_0x0031
        L_0x0041:
            r1.saveAttributes()     // Catch:{ Exception -> 0x0046 }
            r6 = 1
            return r6
        L_0x0046:
            r6 = move-exception
            java.lang.String r7 = "EXIF copy failed"
            android.util.Log.e(r0, r7, r6)
        L_0x004c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.bamlab.rnimageresizer.ImageResizer.copyExif(android.content.Context, android.net.Uri, java.lang.String):boolean");
    }

    public static int getOrientation(Context context, Uri uri) {
        try {
            File fileFromUri = getFileFromUri(context, uri);
            if (fileFromUri.exists()) {
                return getOrientation(new ExifInterface(fileFromUri.getAbsolutePath()));
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getOrientation(ExifInterface exifInterface) {
        int attributeInt = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 3) {
            return RotationOptions.ROTATE_180;
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? 0 : 270;
        }
        return 90;
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    private static Bitmap loadBitmap(Context context, Uri uri, BitmapFactory.Options options) throws IOException {
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.equalsIgnoreCase("content")) {
            try {
                return BitmapFactory.decodeFile(uri.getPath(), options);
            } catch (Exception e) {
                e.printStackTrace();
                throw new IOException("Error decoding image file");
            }
        } else {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return null;
            }
            Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, (Rect) null, options);
            openInputStream.close();
            return decodeStream;
        }
    }

    private static Bitmap loadBitmapFromFile(Context context, Uri uri, int i, int i2) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        loadBitmap(context, uri, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return loadBitmap(context, uri, options);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0078 A[SYNTHETIC, Splitter:B:33:0x0078] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap loadBitmapFromURL(android.net.Uri r6, int r7, int r8) throws java.io.IOException {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x006a }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x006a }
            r1.<init>(r6)     // Catch:{ Exception -> 0x006a }
            java.net.URLConnection r6 = r1.openConnection()     // Catch:{ Exception -> 0x006a }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ Exception -> 0x006a }
            r6.connect()     // Catch:{ Exception -> 0x006a }
            java.io.InputStream r6 = r6.getInputStream()     // Catch:{ Exception -> 0x006a }
            if (r6 == 0) goto L_0x005d
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            r0.<init>()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r1]     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
        L_0x0022:
            r3 = 0
            int r4 = r6.read(r2, r3, r1)     // Catch:{ all -> 0x0052 }
            r5 = -1
            if (r4 == r5) goto L_0x002e
            r0.write(r2, r3, r4)     // Catch:{ all -> 0x0052 }
            goto L_0x0022
        L_0x002e:
            r0.flush()     // Catch:{ all -> 0x0052 }
            byte[] r1 = r0.toByteArray()     // Catch:{ all -> 0x0052 }
            r0.close()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            r0.<init>()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            r2 = 1
            r0.inJustDecodeBounds = r2     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            int r2 = r1.length     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            android.graphics.BitmapFactory.decodeByteArray(r1, r3, r2, r0)     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            int r7 = calculateInSampleSize(r0, r7, r8)     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            r0.inSampleSize = r7     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            r0.inJustDecodeBounds = r3     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            int r7 = r1.length     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r1, r3, r7, r0)     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            goto L_0x005d
        L_0x0052:
            r7 = move-exception
            r0.close()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            throw r7     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
        L_0x0057:
            r7 = move-exception
            r0 = r6
            goto L_0x0076
        L_0x005a:
            r7 = move-exception
            r0 = r6
            goto L_0x006b
        L_0x005d:
            if (r6 == 0) goto L_0x0067
            r6.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0067:
            return r0
        L_0x0068:
            r7 = move-exception
            goto L_0x0076
        L_0x006a:
            r7 = move-exception
        L_0x006b:
            r7.printStackTrace()     // Catch:{ all -> 0x0068 }
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x0068 }
            java.lang.String r7 = "Error fetching remote image file."
            r6.<init>(r7)     // Catch:{ all -> 0x0068 }
            throw r6     // Catch:{ all -> 0x0068 }
        L_0x0076:
            if (r0 == 0) goto L_0x0080
            r0.close()     // Catch:{ IOException -> 0x007c }
            goto L_0x0080
        L_0x007c:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0080:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.bamlab.rnimageresizer.ImageResizer.loadBitmapFromURL(android.net.Uri, int, int):android.graphics.Bitmap");
    }

    private static Bitmap loadBitmapFromBase64(Uri uri) {
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        int indexOf = schemeSpecificPart.indexOf(44);
        if (indexOf != -1) {
            String lowerCase = schemeSpecificPart.substring(0, indexOf).replace(IOUtils.DIR_SEPARATOR_WINDOWS, IOUtils.DIR_SEPARATOR_UNIX).toLowerCase();
            boolean startsWith = lowerCase.startsWith("image/jpeg");
            boolean z = !startsWith && lowerCase.startsWith("image/png");
            if (startsWith || z) {
                byte[] decode = Base64.decode(schemeSpecificPart.substring(indexOf + 1), 0);
                return BitmapFactory.decodeByteArray(decode, 0, decode.length);
            }
        }
        return null;
    }

    public static Bitmap createResizedImage(Context context, Uri uri, int i, int i2, int i3, int i4, String str, boolean z) throws IOException {
        Bitmap bitmap;
        String scheme = uri.getScheme();
        if (scheme == null || scheme.equalsIgnoreCase("file") || scheme.equalsIgnoreCase("content")) {
            bitmap = loadBitmapFromFile(context, uri, i, i2);
        } else if (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https")) {
            bitmap = loadBitmapFromURL(uri, i, i2);
        } else {
            bitmap = scheme.equalsIgnoreCase("data") ? loadBitmapFromBase64(uri) : null;
        }
        if (bitmap != null) {
            Bitmap rotateImage = rotateImage(bitmap, (float) (getOrientation(context, uri) + i4));
            if (rotateImage != null) {
                Bitmap resizeImage = resizeImage(rotateImage, i, i2, str, z);
                if (resizeImage != null) {
                    if (resizeImage != rotateImage) {
                        rotateImage.recycle();
                    }
                    return resizeImage;
                }
                throw new IOException("Unable to resize image. Most likely due to not enough memory.");
            }
            throw new IOException("Unable to rotate image. Most likely due to not enough memory.");
        }
        throw new IOException("Unable to load source image from path");
    }
}
