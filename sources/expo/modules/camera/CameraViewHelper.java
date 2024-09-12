package expo.modules.camera;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.CamcorderProfile;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.Scopes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0007J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0007J$\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019H\u0007¨\u0006\u001b"}, d2 = {"Lexpo/modules/camera/CameraViewHelper;", "", "()V", "addExifData", "", "baseExif", "Landroidx/exifinterface/media/ExifInterface;", "additionalExif", "generateSimulatorPhoto", "", "width", "", "height", "getCamcorderProfile", "Landroid/media/CamcorderProfile;", "cameraId", "quality", "getCorrectCameraRotation", "rotation", "facing", "getExifData", "Landroid/os/Bundle;", "exifInterface", "setExifData", "exifMap", "", "", "expo-camera_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CameraViewHelper.kt */
public final class CameraViewHelper {
    public static final CameraViewHelper INSTANCE = new CameraViewHelper();

    private CameraViewHelper() {
    }

    @JvmStatic
    public static final int getCorrectCameraRotation(int i, int i2) {
        if (i2 == 1) {
            return ((i - 90) + 360) % 360;
        }
        return (((-i) + 90) + 360) % 360;
    }

    @JvmStatic
    public static final CamcorderProfile getCamcorderProfile(int i, int i2) {
        CamcorderProfile camcorderProfile = CamcorderProfile.get(i, 1);
        if (i2 == 0) {
            camcorderProfile = CamcorderProfile.get(i, 8);
        } else if (i2 == 1) {
            camcorderProfile = CamcorderProfile.get(i, 6);
        } else if (i2 == 2) {
            camcorderProfile = CamcorderProfile.get(i, 5);
        } else if (i2 == 3) {
            camcorderProfile = CamcorderProfile.get(i, 4);
        } else if (i2 == 4) {
            camcorderProfile = CamcorderProfile.get(i, 4);
            camcorderProfile.videoFrameWidth = 640;
        }
        Intrinsics.checkNotNullExpressionValue(camcorderProfile, Scopes.PROFILE);
        return camcorderProfile;
    }

    @JvmStatic
    public static final Bundle getExifData(ExifInterface exifInterface) {
        Intrinsics.checkNotNullParameter(exifInterface, "exifInterface");
        Bundle bundle = new Bundle();
        String[][] exifTags = ExifTagsKt.getExifTags();
        int length = ((Object[]) exifTags).length;
        for (int i = 0; i < length; i++) {
            String[] strArr = exifTags[i];
            String str = strArr[0];
            String str2 = strArr[1];
            if (exifInterface.getAttribute(str2) != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1325958191) {
                    if (hashCode != -891985903) {
                        if (hashCode == 104431 && str.equals("int")) {
                            bundle.putInt(str2, exifInterface.getAttributeInt(str2, 0));
                        }
                    } else if (str.equals("string")) {
                        bundle.putString(str2, exifInterface.getAttribute(str2));
                    }
                } else if (str.equals("double")) {
                    bundle.putDouble(str2, exifInterface.getAttributeDouble(str2, 0.0d));
                }
            }
        }
        double[] latLong = exifInterface.getLatLong();
        if (latLong != null) {
            bundle.putDouble(ExifInterface.TAG_GPS_LATITUDE, latLong[0]);
            bundle.putDouble(ExifInterface.TAG_GPS_LONGITUDE, latLong[1]);
            bundle.putDouble(ExifInterface.TAG_GPS_ALTITUDE, exifInterface.getAltitude(0.0d));
        }
        return bundle;
    }

    @JvmStatic
    public static final void setExifData(ExifInterface exifInterface, Map<String, ? extends Object> map) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(exifInterface, "baseExif");
        Intrinsics.checkNotNullParameter(map, "exifMap");
        String[][] exifTags = ExifTagsKt.getExifTags();
        int length = ((Object[]) exifTags).length;
        for (int i = 0; i < length; i++) {
            String str = exifTags[i][1];
            Object obj = map.get(str);
            if (obj != null) {
                if (obj instanceof String) {
                    exifInterface.setAttribute(str, (String) obj);
                } else if (obj instanceof Number) {
                    exifInterface.setAttribute(str, new BigDecimal(String.valueOf(((Number) obj).doubleValue())).toPlainString());
                } else if (obj instanceof Boolean) {
                    exifInterface.setAttribute(str, obj.toString());
                }
            }
        }
        if (map.containsKey(ExifInterface.TAG_GPS_LATITUDE) && map.containsKey(ExifInterface.TAG_GPS_LONGITUDE) && (map.get(ExifInterface.TAG_GPS_LATITUDE) instanceof Number) && (map.get(ExifInterface.TAG_GPS_LONGITUDE) instanceof Number)) {
            Object obj2 = map.get(ExifInterface.TAG_GPS_LATITUDE);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Double");
            double doubleValue = ((Double) obj2).doubleValue();
            Object obj3 = map.get(ExifInterface.TAG_GPS_LONGITUDE);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Double");
            exifInterface.setLatLong(doubleValue, ((Double) obj3).doubleValue());
        }
        if (map.containsKey(ExifInterface.TAG_GPS_ALTITUDE) && (map.get(ExifInterface.TAG_GPS_ALTITUDE) instanceof Number)) {
            Object obj4 = map.get(ExifInterface.TAG_GPS_ALTITUDE);
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Double");
            exifInterface.setAltitude(((Double) obj4).doubleValue());
        }
    }

    @JvmStatic
    public static final void addExifData(ExifInterface exifInterface, ExifInterface exifInterface2) throws IOException {
        Intrinsics.checkNotNullParameter(exifInterface, "baseExif");
        Intrinsics.checkNotNullParameter(exifInterface2, "additionalExif");
        String[][] exifTags = ExifTagsKt.getExifTags();
        int length = ((Object[]) exifTags).length;
        for (int i = 0; i < length; i++) {
            String str = exifTags[i][1];
            String attribute = exifInterface2.getAttribute(str);
            if (attribute != null) {
                exifInterface.setAttribute(str, attribute);
            }
        }
        exifInterface.saveAttributes();
    }

    public final byte[] generateSimulatorPhoto(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        float f = (float) i;
        float f2 = (float) i2;
        canvas.drawRect(0.0f, 0.0f, f, f2, paint);
        Paint paint2 = new Paint();
        paint2.setColor(InputDeviceCompat.SOURCE_ANY);
        paint2.setTextSize(35.0f);
        canvas.drawText(new SimpleDateFormat("dd.MM.yy HH:mm:ss", Locale.US).format(Calendar.getInstance().getTime()), f * 0.1f, f2 * 0.9f, paint2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "fakePhotoByteArray");
        return byteArray;
    }
}
