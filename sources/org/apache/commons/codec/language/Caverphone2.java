package org.apache.commons.codec.language;

import androidx.exifinterface.media.ExifInterface;
import com.braze.Constants;
import com.facebook.appevents.UserDataStore;
import com.google.firebase.dynamiclinks.DynamicLink;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.Locale;

public class Caverphone2 extends AbstractCaverphone {
    private static final String TEN_1 = "1111111111";

    public String encode(String str) {
        if (str == null || str.length() == 0) {
            return TEN_1;
        }
        return (str.toLowerCase(Locale.ENGLISH).replaceAll("[^a-z]", "").replaceAll("e$", "").replaceAll("^cough", "cou2f").replaceAll("^rough", "rou2f").replaceAll("^tough", "tou2f").replaceAll("^enough", "enou2f").replaceAll("^trough", "trou2f").replaceAll("^gn", "2n").replaceAll("mb$", "m2").replaceAll("cq", "2q").replaceAll("ci", DynamicLink.SocialMetaTagParameters.KEY_SOCIAL_IMAGE_LINK).replaceAll("ce", "se").replaceAll("cy", "sy").replaceAll("tch", "2ch").replaceAll("c", "k").replaceAll("q", "k").replaceAll(ViewHierarchyNode.JsonKeys.X, "k").replaceAll("v", "f").replaceAll("dg", "2g").replaceAll("tio", "sio").replaceAll("tia", "sia").replaceAll(Constants.BRAZE_PUSH_NOTIFICATION_SOUND_DEFAULT_VALUE, Constants.BRAZE_PUSH_TITLE_KEY).replaceAll(UserDataStore.PHONE, "fh").replaceAll("b", "p").replaceAll("sh", "s2").replaceAll("z", Constants.BRAZE_PUSH_SUMMARY_TEXT_KEY).replaceAll("^[aeiou]", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll("[aeiou]", ExifInterface.GPS_MEASUREMENT_3D).replaceAll("j", ViewHierarchyNode.JsonKeys.Y).replaceAll("^y3", "Y3").replaceAll("^y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll(ViewHierarchyNode.JsonKeys.Y, ExifInterface.GPS_MEASUREMENT_3D).replaceAll("3gh3", "3kh3").replaceAll("gh", "22").replaceAll("g", "k").replaceAll("s+", ExifInterface.LATITUDE_SOUTH).replaceAll("t+", ExifInterface.GPS_DIRECTION_TRUE).replaceAll("p+", "P").replaceAll("k+", "K").replaceAll("f+", "F").replaceAll("m+", "M").replaceAll("n+", "N").replaceAll("w3", "W3").replaceAll("wh3", "Wh3").replaceAll("w$", ExifInterface.GPS_MEASUREMENT_3D).replaceAll("w", ExifInterface.GPS_MEASUREMENT_2D).replaceAll("^h", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll("h", ExifInterface.GPS_MEASUREMENT_2D).replaceAll("r3", "R3").replaceAll("r$", ExifInterface.GPS_MEASUREMENT_3D).replaceAll("r", ExifInterface.GPS_MEASUREMENT_2D).replaceAll("l3", "L3").replaceAll("l$", ExifInterface.GPS_MEASUREMENT_3D).replaceAll("l", ExifInterface.GPS_MEASUREMENT_2D).replaceAll(ExifInterface.GPS_MEASUREMENT_2D, "").replaceAll("3$", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll(ExifInterface.GPS_MEASUREMENT_3D, "") + TEN_1).substring(0, 10);
    }
}
