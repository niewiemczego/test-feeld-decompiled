package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*BO\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bB\u000f\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB\u000f\b\u0012\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u0016\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001cJ\b\u0010$\u001a\u00020\u001cH\u0016J\b\u0010%\u001a\u0004\u0018\u00010\rJ\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u001cH\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017¨\u0006+"}, d2 = {"Lcom/facebook/Profile;", "Landroid/os/Parcelable;", "id", "", "firstName", "middleName", "lastName", "name", "linkUri", "Landroid/net/Uri;", "pictureUri", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getFirstName", "()Ljava/lang/String;", "getId", "getLastName", "getLinkUri", "()Landroid/net/Uri;", "getMiddleName", "getName", "getPictureUri", "describeContents", "", "equals", "", "other", "", "getProfilePictureUri", "width", "height", "hashCode", "toJSONObject", "writeToParcel", "", "dest", "flags", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Profile.kt */
public final class Profile implements Parcelable {
    public static final Parcelable.Creator<Profile> CREATOR = new Profile$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FIRST_NAME_KEY = "first_name";
    private static final String ID_KEY = "id";
    private static final String LAST_NAME_KEY = "last_name";
    private static final String LINK_URI_KEY = "link_uri";
    private static final String MIDDLE_NAME_KEY = "middle_name";
    private static final String NAME_KEY = "name";
    private static final String PICTURE_URI_KEY = "picture_uri";
    /* access modifiers changed from: private */
    public static final String TAG = "Profile";
    private final String firstName;
    private final String id;
    private final String lastName;
    private final Uri linkUri;
    private final String middleName;
    private final String name;
    private final Uri pictureUri;

    public /* synthetic */ Profile(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri) {
        this(str, str2, str3, str4, str5, uri, (Uri) null, 64, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final void fetchProfileForCurrentAccessToken() {
        Companion.fetchProfileForCurrentAccessToken();
    }

    @JvmStatic
    public static final Profile getCurrentProfile() {
        return Companion.getCurrentProfile();
    }

    @JvmStatic
    public static final void setCurrentProfile(Profile profile) {
        Companion.setCurrentProfile(profile);
    }

    public int describeContents() {
        return 0;
    }

    public final String getId() {
        return this.id;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getMiddleName() {
        return this.middleName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getName() {
        return this.name;
    }

    public final Uri getLinkUri() {
        return this.linkUri;
    }

    public final Uri getPictureUri() {
        return this.pictureUri;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Profile(String str, String str2, String str3, String str4, String str5, Uri uri, Uri uri2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, uri, (i & 64) != 0 ? null : uri2);
    }

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri, Uri uri2) {
        Validate validate = Validate.INSTANCE;
        Validate.notNullOrEmpty(str, "id");
        this.id = str;
        this.firstName = str2;
        this.middleName = str3;
        this.lastName = str4;
        this.name = str5;
        this.linkUri = uri;
        this.pictureUri = uri2;
    }

    public final Uri getProfilePictureUri(int i, int i2) {
        String str;
        Uri uri = this.pictureUri;
        if (uri != null) {
            return uri;
        }
        if (AccessToken.Companion.isCurrentAccessTokenActive()) {
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            str = currentAccessToken == null ? null : currentAccessToken.getToken();
        } else {
            str = "";
        }
        return ImageRequest.Companion.getProfilePictureUri(this.id, i, i2, str);
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        Uri uri;
        Uri uri2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        String str5 = this.id;
        if (((str5 != null || ((Profile) obj).id != null) && !Intrinsics.areEqual((Object) str5, (Object) ((Profile) obj).id)) || ((((str = this.firstName) != null || ((Profile) obj).firstName != null) && !Intrinsics.areEqual((Object) str, (Object) ((Profile) obj).firstName)) || ((((str2 = this.middleName) != null || ((Profile) obj).middleName != null) && !Intrinsics.areEqual((Object) str2, (Object) ((Profile) obj).middleName)) || ((((str3 = this.lastName) != null || ((Profile) obj).lastName != null) && !Intrinsics.areEqual((Object) str3, (Object) ((Profile) obj).lastName)) || ((((str4 = this.name) != null || ((Profile) obj).name != null) && !Intrinsics.areEqual((Object) str4, (Object) ((Profile) obj).name)) || ((((uri = this.linkUri) != null || ((Profile) obj).linkUri != null) && !Intrinsics.areEqual((Object) uri, (Object) ((Profile) obj).linkUri)) || (((uri2 = this.pictureUri) != null || ((Profile) obj).pictureUri != null) && !Intrinsics.areEqual((Object) uri2, (Object) ((Profile) obj).pictureUri)))))))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = 527 + (str != null ? str.hashCode() : 0);
        String str2 = this.firstName;
        if (str2 != null) {
            hashCode = (hashCode * 31) + str2.hashCode();
        }
        String str3 = this.middleName;
        if (str3 != null) {
            hashCode = (hashCode * 31) + str3.hashCode();
        }
        String str4 = this.lastName;
        if (str4 != null) {
            hashCode = (hashCode * 31) + str4.hashCode();
        }
        String str5 = this.name;
        if (str5 != null) {
            hashCode = (hashCode * 31) + str5.hashCode();
        }
        Uri uri = this.linkUri;
        if (uri != null) {
            hashCode = (hashCode * 31) + uri.hashCode();
        }
        Uri uri2 = this.pictureUri;
        return uri2 != null ? (hashCode * 31) + uri2.hashCode() : hashCode;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", (Object) this.id);
            jSONObject.put(FIRST_NAME_KEY, (Object) this.firstName);
            jSONObject.put("middle_name", (Object) this.middleName);
            jSONObject.put(LAST_NAME_KEY, (Object) this.lastName);
            jSONObject.put("name", (Object) this.name);
            Uri uri = this.linkUri;
            if (uri != null) {
                jSONObject.put(LINK_URI_KEY, (Object) uri.toString());
            }
            Uri uri2 = this.pictureUri;
            if (uri2 != null) {
                jSONObject.put(PICTURE_URI_KEY, (Object) uri2.toString());
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public Profile(JSONObject jSONObject) {
        Uri uri;
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Uri uri2 = null;
        this.id = jSONObject.optString("id", (String) null);
        this.firstName = jSONObject.optString(FIRST_NAME_KEY, (String) null);
        this.middleName = jSONObject.optString("middle_name", (String) null);
        this.lastName = jSONObject.optString(LAST_NAME_KEY, (String) null);
        this.name = jSONObject.optString("name", (String) null);
        String optString = jSONObject.optString(LINK_URI_KEY, (String) null);
        if (optString == null) {
            uri = null;
        } else {
            uri = Uri.parse(optString);
        }
        this.linkUri = uri;
        String optString2 = jSONObject.optString(PICTURE_URI_KEY, (String) null);
        this.pictureUri = optString2 != null ? Uri.parse(optString2) : uri2;
    }

    private Profile(Parcel parcel) {
        Uri uri;
        this.id = parcel.readString();
        this.firstName = parcel.readString();
        this.middleName = parcel.readString();
        this.lastName = parcel.readString();
        this.name = parcel.readString();
        String readString = parcel.readString();
        Uri uri2 = null;
        if (readString == null) {
            uri = null;
        } else {
            uri = Uri.parse(readString);
        }
        this.linkUri = uri;
        String readString2 = parcel.readString();
        this.pictureUri = readString2 != null ? Uri.parse(readString2) : uri2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.id);
        parcel.writeString(this.firstName);
        parcel.writeString(this.middleName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.name);
        Uri uri = this.linkUri;
        String str = null;
        parcel.writeString(uri == null ? null : uri.toString());
        Uri uri2 = this.pictureUri;
        if (uri2 != null) {
            str = uri2.toString();
        }
        parcel.writeString(str);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u000f*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/Profile$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/Profile;", "FIRST_NAME_KEY", "", "ID_KEY", "LAST_NAME_KEY", "LINK_URI_KEY", "MIDDLE_NAME_KEY", "NAME_KEY", "PICTURE_URI_KEY", "TAG", "kotlin.jvm.PlatformType", "fetchProfileForCurrentAccessToken", "", "getCurrentProfile", "setCurrentProfile", "profile", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Profile.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Profile getCurrentProfile() {
            return ProfileManager.Companion.getInstance().getCurrentProfile();
        }

        @JvmStatic
        public final void setCurrentProfile(Profile profile) {
            ProfileManager.Companion.getInstance().setCurrentProfile(profile);
        }

        @JvmStatic
        public final void fetchProfileForCurrentAccessToken() {
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            if (currentAccessToken != null) {
                if (!AccessToken.Companion.isCurrentAccessTokenActive()) {
                    setCurrentProfile((Profile) null);
                    return;
                }
                Utility utility = Utility.INSTANCE;
                Utility.getGraphMeRequestWithCacheAsync(currentAccessToken.getToken(), new Profile$Companion$fetchProfileForCurrentAccessToken$1());
            }
        }
    }
}
