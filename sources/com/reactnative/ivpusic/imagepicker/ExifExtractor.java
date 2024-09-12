package com.reactnative.ivpusic.imagepicker;

import android.media.ExifInterface;
import android.os.Build;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ExifExtractor {
    ExifExtractor() {
    }

    static WritableMap extract(String str) throws IOException {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        List<String> basicAttributes = getBasicAttributes();
        if (Build.VERSION.SDK_INT >= 23) {
            basicAttributes.addAll(getLevel23Attributes());
        }
        ExifInterface exifInterface = new ExifInterface(str);
        try {
            GeoDegree geoDegree = new GeoDegree(exifInterface);
            if (!(geoDegree.getLatitude() == null || geoDegree.getLongitude() == null)) {
                writableNativeMap.putDouble("Latitude", (double) geoDegree.getLatitude().floatValue());
                writableNativeMap.putDouble("Longitude", (double) geoDegree.getLongitude().floatValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String next : basicAttributes) {
            writableNativeMap.putString(next, exifInterface.getAttribute(next));
        }
        return writableNativeMap;
    }

    private static List<String> getBasicAttributes() {
        return new ArrayList(Arrays.asList(new String[]{androidx.exifinterface.media.ExifInterface.TAG_F_NUMBER, androidx.exifinterface.media.ExifInterface.TAG_DATETIME, androidx.exifinterface.media.ExifInterface.TAG_EXPOSURE_TIME, androidx.exifinterface.media.ExifInterface.TAG_FLASH, androidx.exifinterface.media.ExifInterface.TAG_FOCAL_LENGTH, androidx.exifinterface.media.ExifInterface.TAG_GPS_ALTITUDE, androidx.exifinterface.media.ExifInterface.TAG_GPS_ALTITUDE_REF, androidx.exifinterface.media.ExifInterface.TAG_GPS_DATESTAMP, androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE, androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE_REF, androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE, androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE_REF, androidx.exifinterface.media.ExifInterface.TAG_GPS_PROCESSING_METHOD, androidx.exifinterface.media.ExifInterface.TAG_GPS_TIMESTAMP, androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, androidx.exifinterface.media.ExifInterface.TAG_ISO_SPEED_RATINGS, androidx.exifinterface.media.ExifInterface.TAG_MAKE, androidx.exifinterface.media.ExifInterface.TAG_MODEL, androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, androidx.exifinterface.media.ExifInterface.TAG_WHITE_BALANCE}));
    }

    private static List<String> getLevel23Attributes() {
        return new ArrayList(Arrays.asList(new String[]{androidx.exifinterface.media.ExifInterface.TAG_DATETIME_DIGITIZED, androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME, androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME_ORIGINAL}));
    }
}
