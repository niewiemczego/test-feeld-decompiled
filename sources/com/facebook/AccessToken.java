package com.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import io.sentry.protocol.SentryThread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 E2\u00020\u0001:\u0003CDEB\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011B\u000f\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0014\u0010.\u001a\u00020/2\n\u00100\u001a\u000601j\u0002`2H\u0002J\u001a\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u00105\u001a\u000206H\u0016J\u0013\u00107\u001a\u00020!2\b\u00108\u001a\u0004\u0018\u000109H\u0002J\b\u0010:\u001a\u000206H\u0016J\r\u0010;\u001a\u00020<H\u0000¢\u0006\u0002\b=J\b\u0010>\u001a\u00020\u0003H\u0016J\b\u0010?\u001a\u00020\u0003H\u0002J\u0018\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020\u00132\u0006\u0010B\u001a\u000206H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u001d\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b \u0010\"R\u0011\u0010#\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b#\u0010\"R\u0011\u0010$\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0011\u0010%\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0011\u0010(\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0016¨\u0006F"}, d2 = {"Lcom/facebook/AccessToken;", "Landroid/os/Parcelable;", "accessToken", "", "applicationId", "userId", "permissions", "", "declinedPermissions", "expiredPermissions", "accessTokenSource", "Lcom/facebook/AccessTokenSource;", "expirationTime", "Ljava/util/Date;", "lastRefreshTime", "dataAccessExpirationTime", "graphDomain", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Collection;Lcom/facebook/AccessTokenSource;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getApplicationId", "()Ljava/lang/String;", "getDataAccessExpirationTime", "()Ljava/util/Date;", "", "getDeclinedPermissions", "()Ljava/util/Set;", "getExpiredPermissions", "expires", "getExpires", "getGraphDomain", "isDataAccessExpired", "", "()Z", "isExpired", "isInstagramToken", "lastRefresh", "getLastRefresh", "getPermissions", "source", "getSource", "()Lcom/facebook/AccessTokenSource;", "token", "getToken", "getUserId", "appendPermissions", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "convertTokenSourceForGraphDomain", "tokenSource", "describeContents", "", "equals", "other", "", "hashCode", "toJSONObject", "Lorg/json/JSONObject;", "toJSONObject$facebook_core_release", "toString", "tokenToString", "writeToParcel", "dest", "flags", "AccessTokenCreationCallback", "AccessTokenRefreshCallback", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AccessToken.kt */
public final class AccessToken implements Parcelable {
    public static final String ACCESS_TOKEN_KEY = "access_token";
    private static final String APPLICATION_ID_KEY = "application_id";
    public static final Parcelable.Creator<AccessToken> CREATOR = new AccessToken$Companion$CREATOR$1();
    private static final int CURRENT_JSON_FORMAT = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DATA_ACCESS_EXPIRATION_TIME = "data_access_expiration_time";
    private static final String DECLINED_PERMISSIONS_KEY = "declined_permissions";
    private static final AccessTokenSource DEFAULT_ACCESS_TOKEN_SOURCE = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    private static final Date DEFAULT_EXPIRATION_TIME;
    public static final String DEFAULT_GRAPH_DOMAIN = "facebook";
    private static final Date DEFAULT_LAST_REFRESH_TIME = new Date();
    private static final String EXPIRED_PERMISSIONS_KEY = "expired_permissions";
    private static final String EXPIRES_AT_KEY = "expires_at";
    public static final String EXPIRES_IN_KEY = "expires_in";
    public static final String GRAPH_DOMAIN = "graph_domain";
    private static final String LAST_REFRESH_KEY = "last_refresh";
    private static final Date MAX_DATE;
    private static final String PERMISSIONS_KEY = "permissions";
    private static final String SOURCE_KEY = "source";
    private static final String TOKEN_KEY = "token";
    public static final String USER_ID_KEY = "user_id";
    private static final String VERSION_KEY = "version";
    private final String applicationId;
    private final Date dataAccessExpirationTime;
    private final Set<String> declinedPermissions;
    private final Set<String> expiredPermissions;
    private final Date expires;
    private final String graphDomain;
    private final Date lastRefresh;
    private final Set<String> permissions;
    private final AccessTokenSource source;
    private final String token;
    private final String userId;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/facebook/AccessToken$AccessTokenCreationCallback;", "", "onError", "", "error", "Lcom/facebook/FacebookException;", "onSuccess", "token", "Lcom/facebook/AccessToken;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AccessToken.kt */
    public interface AccessTokenCreationCallback {
        void onError(FacebookException facebookException);

        void onSuccess(AccessToken accessToken);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/facebook/AccessToken$AccessTokenRefreshCallback;", "", "OnTokenRefreshFailed", "", "exception", "Lcom/facebook/FacebookException;", "OnTokenRefreshed", "accessToken", "Lcom/facebook/AccessToken;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AccessToken.kt */
    public interface AccessTokenRefreshCallback {
        void OnTokenRefreshFailed(FacebookException facebookException);

        void OnTokenRefreshed(AccessToken accessToken);
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AccessToken.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AccessTokenSource.values().length];
            iArr[AccessTokenSource.FACEBOOK_APPLICATION_WEB.ordinal()] = 1;
            iArr[AccessTokenSource.CHROME_CUSTOM_TAB.ordinal()] = 2;
            iArr[AccessTokenSource.WEB_VIEW.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AccessToken(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.util.Collection<java.lang.String> r19, java.util.Collection<java.lang.String> r20, java.util.Collection<java.lang.String> r21, com.facebook.AccessTokenSource r22, java.util.Date r23, java.util.Date r24, java.util.Date r25) {
        /*
            r15 = this;
            java.lang.String r0 = "accessToken"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "applicationId"
            r3 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "userId"
            r4 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r12 = 0
            r13 = 1024(0x400, float:1.435E-42)
            r14 = 0
            r1 = r15
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r11 = r25
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AccessToken.<init>(java.lang.String, java.lang.String, java.lang.String, java.util.Collection, java.util.Collection, java.util.Collection, com.facebook.AccessTokenSource, java.util.Date, java.util.Date, java.util.Date):void");
    }

    @JvmStatic
    public static final AccessToken createFromJSONObject$facebook_core_release(JSONObject jSONObject) throws JSONException {
        return Companion.createFromJSONObject$facebook_core_release(jSONObject);
    }

    @JvmStatic
    public static final AccessToken createFromLegacyCache$facebook_core_release(Bundle bundle) {
        return Companion.createFromLegacyCache$facebook_core_release(bundle);
    }

    @JvmStatic
    public static final void createFromNativeLinkingIntent(Intent intent, String str, AccessTokenCreationCallback accessTokenCreationCallback) {
        Companion.createFromNativeLinkingIntent(intent, str, accessTokenCreationCallback);
    }

    @JvmStatic
    public static final AccessToken createFromRefresh$facebook_core_release(AccessToken accessToken, Bundle bundle) {
        return Companion.createFromRefresh$facebook_core_release(accessToken, bundle);
    }

    @JvmStatic
    public static final void expireCurrentAccessToken() {
        Companion.expireCurrentAccessToken();
    }

    @JvmStatic
    public static final AccessToken getCurrentAccessToken() {
        return Companion.getCurrentAccessToken();
    }

    @JvmStatic
    public static final List<String> getPermissionsFromBundle$facebook_core_release(Bundle bundle, String str) {
        return Companion.getPermissionsFromBundle$facebook_core_release(bundle, str);
    }

    @JvmStatic
    public static final boolean isCurrentAccessTokenActive() {
        return Companion.isCurrentAccessTokenActive();
    }

    @JvmStatic
    public static final boolean isDataAccessActive() {
        return Companion.isDataAccessActive();
    }

    @JvmStatic
    public static final boolean isLoggedInWithInstagram() {
        return Companion.isLoggedInWithInstagram();
    }

    @JvmStatic
    public static final void refreshCurrentAccessTokenAsync() {
        Companion.refreshCurrentAccessTokenAsync();
    }

    @JvmStatic
    public static final void refreshCurrentAccessTokenAsync(AccessTokenRefreshCallback accessTokenRefreshCallback) {
        Companion.refreshCurrentAccessTokenAsync(accessTokenRefreshCallback);
    }

    @JvmStatic
    public static final void setCurrentAccessToken(AccessToken accessToken) {
        Companion.setCurrentAccessToken(accessToken);
    }

    public int describeContents() {
        return 0;
    }

    public final Date getExpires() {
        return this.expires;
    }

    public final Set<String> getPermissions() {
        return this.permissions;
    }

    public final Set<String> getDeclinedPermissions() {
        return this.declinedPermissions;
    }

    public final Set<String> getExpiredPermissions() {
        return this.expiredPermissions;
    }

    public final String getToken() {
        return this.token;
    }

    public final AccessTokenSource getSource() {
        return this.source;
    }

    public final Date getLastRefresh() {
        return this.lastRefresh;
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Date getDataAccessExpirationTime() {
        return this.dataAccessExpirationTime;
    }

    public final String getGraphDomain() {
        return this.graphDomain;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccessToken(String str, String str2, String str3, Collection collection, Collection collection2, Collection collection3, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, collection, collection2, collection3, accessTokenSource, date, date2, date3, (i & 1024) != 0 ? DEFAULT_GRAPH_DOMAIN : str4);
    }

    public AccessToken(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, Collection<String> collection3, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3, String str4) {
        HashSet hashSet;
        HashSet hashSet2;
        HashSet hashSet3;
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_ACCESS_TOKEN);
        Intrinsics.checkNotNullParameter(str2, "applicationId");
        Intrinsics.checkNotNullParameter(str3, "userId");
        Validate validate = Validate.INSTANCE;
        Validate.notEmpty(str, SDKConstants.PARAM_ACCESS_TOKEN);
        Validate validate2 = Validate.INSTANCE;
        Validate.notEmpty(str2, "applicationId");
        Validate validate3 = Validate.INSTANCE;
        Validate.notEmpty(str3, "userId");
        this.expires = date == null ? DEFAULT_EXPIRATION_TIME : date;
        if (collection == null) {
            hashSet = new HashSet();
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(hashSet);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(if (permissions != null) HashSet(permissions) else HashSet())");
        this.permissions = unmodifiableSet;
        if (collection2 == null) {
            hashSet2 = new HashSet();
        }
        Set<String> unmodifiableSet2 = Collections.unmodifiableSet(hashSet2);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet2, "unmodifiableSet(\n            if (declinedPermissions != null) HashSet(declinedPermissions) else HashSet())");
        this.declinedPermissions = unmodifiableSet2;
        if (collection3 == null) {
            hashSet3 = new HashSet();
        }
        Set<String> unmodifiableSet3 = Collections.unmodifiableSet(hashSet3);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet3, "unmodifiableSet(\n            if (expiredPermissions != null) HashSet(expiredPermissions) else HashSet())");
        this.expiredPermissions = unmodifiableSet3;
        this.token = str;
        this.source = convertTokenSourceForGraphDomain(accessTokenSource == null ? DEFAULT_ACCESS_TOKEN_SOURCE : accessTokenSource, str4);
        this.lastRefresh = date2 == null ? DEFAULT_LAST_REFRESH_TIME : date2;
        this.applicationId = str2;
        this.userId = str3;
        this.dataAccessExpirationTime = (date3 == null || date3.getTime() == 0) ? DEFAULT_EXPIRATION_TIME : date3;
        this.graphDomain = str4 == null ? DEFAULT_GRAPH_DOMAIN : str4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{AccessToken");
        sb.append(" token:").append(tokenToString());
        appendPermissions(sb);
        sb.append("}");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessToken)) {
            return false;
        }
        AccessToken accessToken = (AccessToken) obj;
        if (Intrinsics.areEqual((Object) this.expires, (Object) accessToken.expires) && Intrinsics.areEqual((Object) this.permissions, (Object) accessToken.permissions) && Intrinsics.areEqual((Object) this.declinedPermissions, (Object) accessToken.declinedPermissions) && Intrinsics.areEqual((Object) this.expiredPermissions, (Object) accessToken.expiredPermissions) && Intrinsics.areEqual((Object) this.token, (Object) accessToken.token) && this.source == accessToken.source && Intrinsics.areEqual((Object) this.lastRefresh, (Object) accessToken.lastRefresh) && Intrinsics.areEqual((Object) this.applicationId, (Object) accessToken.applicationId) && Intrinsics.areEqual((Object) this.userId, (Object) accessToken.userId) && Intrinsics.areEqual((Object) this.dataAccessExpirationTime, (Object) accessToken.dataAccessExpirationTime)) {
            String str = this.graphDomain;
            String str2 = accessToken.graphDomain;
            if (str == null ? str2 == null : Intrinsics.areEqual((Object) str, (Object) str2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((((((((((((((((527 + this.expires.hashCode()) * 31) + this.permissions.hashCode()) * 31) + this.declinedPermissions.hashCode()) * 31) + this.expiredPermissions.hashCode()) * 31) + this.token.hashCode()) * 31) + this.source.hashCode()) * 31) + this.lastRefresh.hashCode()) * 31) + this.applicationId.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.dataAccessExpirationTime.hashCode()) * 31;
        String str = this.graphDomain;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean isExpired() {
        return new Date().after(this.expires);
    }

    public final boolean isDataAccessExpired() {
        return new Date().after(this.dataAccessExpirationTime);
    }

    public final boolean isInstagramToken() {
        String str = this.graphDomain;
        return str != null && str.equals(FacebookSdk.INSTAGRAM);
    }

    public final JSONObject toJSONObject$facebook_core_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put(TOKEN_KEY, (Object) this.token);
        jSONObject.put(EXPIRES_AT_KEY, this.expires.getTime());
        jSONObject.put("permissions", (Object) new JSONArray((Collection<?>) this.permissions));
        jSONObject.put(DECLINED_PERMISSIONS_KEY, (Object) new JSONArray((Collection<?>) this.declinedPermissions));
        jSONObject.put(EXPIRED_PERMISSIONS_KEY, (Object) new JSONArray((Collection<?>) this.expiredPermissions));
        jSONObject.put(LAST_REFRESH_KEY, this.lastRefresh.getTime());
        jSONObject.put("source", (Object) this.source.name());
        jSONObject.put(APPLICATION_ID_KEY, (Object) this.applicationId);
        jSONObject.put("user_id", (Object) this.userId);
        jSONObject.put(DATA_ACCESS_EXPIRATION_TIME, this.dataAccessExpirationTime.getTime());
        String str = this.graphDomain;
        if (str != null) {
            jSONObject.put("graph_domain", (Object) str);
        }
        return jSONObject;
    }

    private final String tokenToString() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS) ? this.token : "ACCESS_TOKEN_REMOVED";
    }

    private final void appendPermissions(StringBuilder sb) {
        sb.append(" permissions:");
        sb.append("[");
        sb.append(TextUtils.join(", ", this.permissions));
        sb.append("]");
    }

    private final AccessTokenSource convertTokenSourceForGraphDomain(AccessTokenSource accessTokenSource, String str) {
        if (str == null || !str.equals(FacebookSdk.INSTAGRAM)) {
            return accessTokenSource;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[accessTokenSource.ordinal()];
        if (i == 1) {
            return AccessTokenSource.INSTAGRAM_APPLICATION_WEB;
        }
        if (i == 2) {
            return AccessTokenSource.INSTAGRAM_CUSTOM_CHROME_TAB;
        }
        if (i != 3) {
            return accessTokenSource;
        }
        return AccessTokenSource.INSTAGRAM_WEB_VIEW;
    }

    public AccessToken(Parcel parcel) {
        AccessTokenSource accessTokenSource;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.expires = new Date(parcel.readLong());
        ArrayList arrayList = new ArrayList();
        List list = arrayList;
        parcel.readStringList(list);
        Collection collection = arrayList;
        Set<String> unmodifiableSet = Collections.unmodifiableSet(new HashSet(collection));
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(HashSet(permissionsList))");
        this.permissions = unmodifiableSet;
        arrayList.clear();
        parcel.readStringList(list);
        Set<String> unmodifiableSet2 = Collections.unmodifiableSet(new HashSet(collection));
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet2, "unmodifiableSet(HashSet(permissionsList))");
        this.declinedPermissions = unmodifiableSet2;
        arrayList.clear();
        parcel.readStringList(list);
        Set<String> unmodifiableSet3 = Collections.unmodifiableSet(new HashSet(collection));
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet3, "unmodifiableSet(HashSet(permissionsList))");
        this.expiredPermissions = unmodifiableSet3;
        String readString = parcel.readString();
        Validate validate = Validate.INSTANCE;
        this.token = Validate.notNullOrEmpty(readString, TOKEN_KEY);
        String readString2 = parcel.readString();
        if (readString2 != null) {
            accessTokenSource = AccessTokenSource.valueOf(readString2);
        } else {
            accessTokenSource = DEFAULT_ACCESS_TOKEN_SOURCE;
        }
        this.source = accessTokenSource;
        this.lastRefresh = new Date(parcel.readLong());
        String readString3 = parcel.readString();
        Validate validate2 = Validate.INSTANCE;
        this.applicationId = Validate.notNullOrEmpty(readString3, "applicationId");
        String readString4 = parcel.readString();
        Validate validate3 = Validate.INSTANCE;
        this.userId = Validate.notNullOrEmpty(readString4, "userId");
        this.dataAccessExpirationTime = new Date(parcel.readLong());
        this.graphDomain = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(this.expires.getTime());
        parcel.writeStringList(new ArrayList(this.permissions));
        parcel.writeStringList(new ArrayList(this.declinedPermissions));
        parcel.writeStringList(new ArrayList(this.expiredPermissions));
        parcel.writeString(this.token);
        parcel.writeString(this.source.name());
        parcel.writeLong(this.lastRefresh.getTime());
        parcel.writeString(this.applicationId);
        parcel.writeString(this.userId);
        parcel.writeLong(this.dataAccessExpirationTime.getTime());
        parcel.writeString(this.graphDomain);
    }

    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0000¢\u0006\u0002\b J<\u0010!\u001a\u0004\u0018\u00010\b2\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0004H\u0002J\u0015\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,J\u0017\u0010-\u001a\u0004\u0018\u00010\b2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b.J \u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u0010(\u001a\u00020\u00042\u0006\u00103\u001a\u000204H\u0007J\u001f\u00105\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b6J\b\u00107\u001a\u000200H\u0007J\n\u00108\u001a\u0004\u0018\u00010\bH\u0007J'\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040#2\u0006\u0010$\u001a\u00020%2\b\u0010:\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0002\b;J\b\u0010<\u001a\u00020=H\u0007J\b\u0010>\u001a\u00020=H\u0007J\b\u0010?\u001a\u00020=H\u0007J\b\u0010@\u001a\u000200H\u0007J\u0012\u0010@\u001a\u0002002\b\u0010A\u001a\u0004\u0018\u00010BH\u0007J\u0012\u0010C\u001a\u0002002\b\u0010D\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/facebook/AccessToken$Companion;", "", "()V", "ACCESS_TOKEN_KEY", "", "APPLICATION_ID_KEY", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/AccessToken;", "CURRENT_JSON_FORMAT", "", "DATA_ACCESS_EXPIRATION_TIME", "DECLINED_PERMISSIONS_KEY", "DEFAULT_ACCESS_TOKEN_SOURCE", "Lcom/facebook/AccessTokenSource;", "DEFAULT_EXPIRATION_TIME", "Ljava/util/Date;", "DEFAULT_GRAPH_DOMAIN", "DEFAULT_LAST_REFRESH_TIME", "EXPIRED_PERMISSIONS_KEY", "EXPIRES_AT_KEY", "EXPIRES_IN_KEY", "GRAPH_DOMAIN", "LAST_REFRESH_KEY", "MAX_DATE", "PERMISSIONS_KEY", "SOURCE_KEY", "TOKEN_KEY", "USER_ID_KEY", "VERSION_KEY", "createExpired", "current", "createExpired$facebook_core_release", "createFromBundle", "requestedPermissions", "", "bundle", "Landroid/os/Bundle;", "source", "expirationBase", "applicationId", "createFromJSONObject", "jsonObject", "Lorg/json/JSONObject;", "createFromJSONObject$facebook_core_release", "createFromLegacyCache", "createFromLegacyCache$facebook_core_release", "createFromNativeLinkingIntent", "", "intent", "Landroid/content/Intent;", "accessTokenCallback", "Lcom/facebook/AccessToken$AccessTokenCreationCallback;", "createFromRefresh", "createFromRefresh$facebook_core_release", "expireCurrentAccessToken", "getCurrentAccessToken", "getPermissionsFromBundle", "key", "getPermissionsFromBundle$facebook_core_release", "isCurrentAccessTokenActive", "", "isDataAccessActive", "isLoggedInWithInstagram", "refreshCurrentAccessTokenAsync", "callback", "Lcom/facebook/AccessToken$AccessTokenRefreshCallback;", "setCurrentAccessToken", "accessToken", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AccessToken.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AccessToken getCurrentAccessToken() {
            return AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
        }

        @JvmStatic
        public final void setCurrentAccessToken(AccessToken accessToken) {
            AccessTokenManager.Companion.getInstance().setCurrentAccessToken(accessToken);
        }

        @JvmStatic
        public final boolean isCurrentAccessTokenActive() {
            AccessToken currentAccessToken = AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
            return currentAccessToken != null && !currentAccessToken.isExpired();
        }

        @JvmStatic
        public final boolean isDataAccessActive() {
            AccessToken currentAccessToken = AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
            return currentAccessToken != null && !currentAccessToken.isDataAccessExpired();
        }

        @JvmStatic
        public final boolean isLoggedInWithInstagram() {
            AccessToken currentAccessToken = AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
            return currentAccessToken != null && !currentAccessToken.isExpired() && currentAccessToken.isInstagramToken();
        }

        @JvmStatic
        public final void expireCurrentAccessToken() {
            AccessToken currentAccessToken = AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
            if (currentAccessToken != null) {
                setCurrentAccessToken(createExpired$facebook_core_release(currentAccessToken));
            }
        }

        @JvmStatic
        public final void refreshCurrentAccessTokenAsync() {
            AccessTokenManager.Companion.getInstance().refreshCurrentAccessToken((AccessTokenRefreshCallback) null);
        }

        @JvmStatic
        public final void refreshCurrentAccessTokenAsync(AccessTokenRefreshCallback accessTokenRefreshCallback) {
            AccessTokenManager.Companion.getInstance().refreshCurrentAccessToken(accessTokenRefreshCallback);
        }

        @JvmStatic
        public final void createFromNativeLinkingIntent(Intent intent, String str, AccessTokenCreationCallback accessTokenCreationCallback) {
            Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
            Intrinsics.checkNotNullParameter(str, "applicationId");
            Intrinsics.checkNotNullParameter(accessTokenCreationCallback, "accessTokenCallback");
            if (intent.getExtras() == null) {
                accessTokenCreationCallback.onError(new FacebookException("No extras found on intent"));
                return;
            }
            Bundle bundle = new Bundle(intent.getExtras());
            String string = bundle.getString("access_token");
            if (string != null) {
                boolean z = true;
                if (!(string.length() == 0)) {
                    String string2 = bundle.getString("user_id");
                    if (string2 != null) {
                        if (string2.length() != 0) {
                            z = false;
                        }
                        if (!z) {
                            accessTokenCreationCallback.onSuccess(createFromBundle((List<String>) null, bundle, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), str));
                            return;
                        }
                    }
                    Utility utility = Utility.INSTANCE;
                    Utility.getGraphMeRequestWithCacheAsync(string, new AccessToken$Companion$createFromNativeLinkingIntent$1(bundle, accessTokenCreationCallback, str));
                    return;
                }
            }
            accessTokenCreationCallback.onError(new FacebookException("No access token found on intent"));
        }

        @JvmStatic
        public final AccessToken createFromRefresh$facebook_core_release(AccessToken accessToken, Bundle bundle) {
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(accessToken, SentryThread.JsonKeys.CURRENT);
            Intrinsics.checkNotNullParameter(bundle2, "bundle");
            if (accessToken.getSource() == AccessTokenSource.FACEBOOK_APPLICATION_WEB || accessToken.getSource() == AccessTokenSource.FACEBOOK_APPLICATION_NATIVE || accessToken.getSource() == AccessTokenSource.FACEBOOK_APPLICATION_SERVICE) {
                Utility utility = Utility.INSTANCE;
                Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle2, AccessToken.EXPIRES_IN_KEY, new Date(0));
                String string = bundle2.getString("access_token");
                if (string == null) {
                    return null;
                }
                String string2 = bundle2.getString("graph_domain");
                Utility utility2 = Utility.INSTANCE;
                Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle2, AccessToken.DATA_ACCESS_EXPIRATION_TIME, new Date(0));
                Utility utility3 = Utility.INSTANCE;
                if (!Utility.isNullOrEmpty(string)) {
                    return new AccessToken(string, accessToken.getApplicationId(), accessToken.getUserId(), accessToken.getPermissions(), accessToken.getDeclinedPermissions(), accessToken.getExpiredPermissions(), accessToken.getSource(), bundleLongAsDate, new Date(), bundleLongAsDate2, string2);
                }
                AccessToken accessToken2 = null;
                return null;
            }
            throw new FacebookException(Intrinsics.stringPlus("Invalid token source: ", accessToken.getSource()));
        }

        public final AccessToken createExpired$facebook_core_release(AccessToken accessToken) {
            Intrinsics.checkNotNullParameter(accessToken, SentryThread.JsonKeys.CURRENT);
            return new AccessToken(accessToken.getToken(), accessToken.getApplicationId(), accessToken.getUserId(), accessToken.getPermissions(), accessToken.getDeclinedPermissions(), accessToken.getExpiredPermissions(), accessToken.getSource(), new Date(), new Date(), accessToken.getDataAccessExpirationTime(), (String) null, 1024, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final AccessToken createFromLegacyCache$facebook_core_release(Bundle bundle) {
            String str;
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(bundle2, "bundle");
            List<String> permissionsFromBundle$facebook_core_release = getPermissionsFromBundle$facebook_core_release(bundle2, LegacyTokenHelper.PERMISSIONS_KEY);
            List<String> permissionsFromBundle$facebook_core_release2 = getPermissionsFromBundle$facebook_core_release(bundle2, LegacyTokenHelper.DECLINED_PERMISSIONS_KEY);
            List<String> permissionsFromBundle$facebook_core_release3 = getPermissionsFromBundle$facebook_core_release(bundle2, LegacyTokenHelper.EXPIRED_PERMISSIONS_KEY);
            String applicationId = LegacyTokenHelper.Companion.getApplicationId(bundle2);
            Utility utility = Utility.INSTANCE;
            if (Utility.isNullOrEmpty(applicationId)) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                applicationId = FacebookSdk.getApplicationId();
            }
            String str2 = applicationId;
            String token = LegacyTokenHelper.Companion.getToken(bundle2);
            if (token == null) {
                return null;
            }
            Utility utility2 = Utility.INSTANCE;
            JSONObject awaitGetGraphMeRequestWithCache = Utility.awaitGetGraphMeRequestWithCache(token);
            if (awaitGetGraphMeRequestWithCache == null) {
                str = null;
            } else {
                try {
                    str = awaitGetGraphMeRequestWithCache.getString("id");
                } catch (JSONException unused) {
                    return null;
                }
            }
            if (str2 == null || str == null) {
                return null;
            }
            return new AccessToken(token, str2, str, permissionsFromBundle$facebook_core_release, permissionsFromBundle$facebook_core_release2, permissionsFromBundle$facebook_core_release3, LegacyTokenHelper.Companion.getSource(bundle2), LegacyTokenHelper.Companion.getExpirationDate(bundle2), LegacyTokenHelper.Companion.getLastRefreshDate(bundle2), (Date) null, (String) null, 1024, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final List<String> getPermissionsFromBundle$facebook_core_release(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            List stringArrayList = bundle.getStringArrayList(str);
            if (stringArrayList == null) {
                return CollectionsKt.emptyList();
            }
            List<String> unmodifiableList = Collections.unmodifiableList(new ArrayList(stringArrayList));
            Intrinsics.checkNotNullExpressionValue(unmodifiableList, "{\n            Collections.unmodifiableList(ArrayList(originalPermissions))\n          }");
            return unmodifiableList;
        }

        @JvmStatic
        public final AccessToken createFromJSONObject$facebook_core_release(JSONObject jSONObject) throws JSONException {
            List<String> list;
            Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
            if (jSONObject.getInt("version") <= 1) {
                String string = jSONObject.getString(AccessToken.TOKEN_KEY);
                Date date = new Date(jSONObject.getLong(AccessToken.EXPIRES_AT_KEY));
                JSONArray jSONArray = jSONObject.getJSONArray("permissions");
                JSONArray jSONArray2 = jSONObject.getJSONArray(AccessToken.DECLINED_PERMISSIONS_KEY);
                JSONArray optJSONArray = jSONObject.optJSONArray(AccessToken.EXPIRED_PERMISSIONS_KEY);
                Date date2 = new Date(jSONObject.getLong(AccessToken.LAST_REFRESH_KEY));
                String string2 = jSONObject.getString("source");
                Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(SOURCE_KEY)");
                AccessTokenSource valueOf = AccessTokenSource.valueOf(string2);
                String string3 = jSONObject.getString(AccessToken.APPLICATION_ID_KEY);
                String string4 = jSONObject.getString("user_id");
                Date date3 = new Date(jSONObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME, 0));
                String optString = jSONObject.optString("graph_domain", (String) null);
                Intrinsics.checkNotNullExpressionValue(string, AccessToken.TOKEN_KEY);
                Intrinsics.checkNotNullExpressionValue(string3, "applicationId");
                Intrinsics.checkNotNullExpressionValue(string4, "userId");
                Utility utility = Utility.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(jSONArray, "permissionsArray");
                Collection jsonArrayToStringList = Utility.jsonArrayToStringList(jSONArray);
                Utility utility2 = Utility.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(jSONArray2, "declinedPermissionsArray");
                Collection jsonArrayToStringList2 = Utility.jsonArrayToStringList(jSONArray2);
                if (optJSONArray == null) {
                    list = new ArrayList<>();
                } else {
                    Utility utility3 = Utility.INSTANCE;
                    list = Utility.jsonArrayToStringList(optJSONArray);
                }
                return new AccessToken(string, string3, string4, jsonArrayToStringList, jsonArrayToStringList2, list, valueOf, date, date2, date3, optString);
            }
            throw new FacebookException("Unknown AccessToken serialization format.");
        }

        /* access modifiers changed from: private */
        public final AccessToken createFromBundle(List<String> list, Bundle bundle, AccessTokenSource accessTokenSource, Date date, String str) {
            String string;
            Bundle bundle2 = bundle;
            String string2 = bundle2.getString("access_token");
            if (string2 == null) {
                return null;
            }
            Utility utility = Utility.INSTANCE;
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle2, AccessToken.EXPIRES_IN_KEY, date);
            if (bundleLongAsDate == null || (string = bundle2.getString("user_id")) == null) {
                return null;
            }
            Utility utility2 = Utility.INSTANCE;
            return new AccessToken(string2, str, string, list, (Collection) null, (Collection) null, accessTokenSource, bundleLongAsDate, new Date(), Utility.getBundleLongAsDate(bundle2, AccessToken.DATA_ACCESS_EXPIRATION_TIME, new Date(0)), (String) null, 1024, (DefaultConstructorMarker) null);
        }
    }

    static {
        Date date = new Date(Long.MAX_VALUE);
        MAX_DATE = date;
        DEFAULT_EXPIRATION_TIME = date;
    }
}
