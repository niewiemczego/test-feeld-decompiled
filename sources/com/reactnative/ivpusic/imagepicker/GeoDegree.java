package com.reactnative.ivpusic.imagepicker;

import android.media.ExifInterface;

public class GeoDegree {
    Float latitude;
    Float longitude;

    public GeoDegree(ExifInterface exifInterface) {
        String attribute = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE);
        String attribute2 = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE_REF);
        String attribute3 = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE);
        String attribute4 = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE_REF);
        if (attribute != null && attribute2 != null && attribute3 != null && attribute4 != null) {
            if (attribute2.equals("N")) {
                this.latitude = convertToDegree(attribute);
            } else {
                this.latitude = Float.valueOf(0.0f - convertToDegree(attribute).floatValue());
            }
            if (attribute4.equals(androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST)) {
                this.longitude = convertToDegree(attribute3);
            } else {
                this.longitude = Float.valueOf(0.0f - convertToDegree(attribute3).floatValue());
            }
        }
    }

    private Float convertToDegree(String str) {
        String[] split = str.split(",", 3);
        String[] split2 = split[0].split("/", 2);
        Double valueOf = Double.valueOf(split2[0]);
        Double valueOf2 = Double.valueOf(split2[1]);
        String[] split3 = split[1].split("/", 2);
        Double valueOf3 = Double.valueOf(split3[0]);
        Double valueOf4 = Double.valueOf(split3[1]);
        String[] split4 = split[2].split("/", 2);
        return Float.valueOf((float) ((valueOf.doubleValue() / valueOf2.doubleValue()) + ((valueOf3.doubleValue() / valueOf4.doubleValue()) / 60.0d) + ((Double.valueOf(split4[0]).doubleValue() / Double.valueOf(split4[1]).doubleValue()) / 3600.0d)));
    }

    public Float getLatitude() {
        return this.latitude;
    }

    public Float getLongitude() {
        return this.longitude;
    }
}
