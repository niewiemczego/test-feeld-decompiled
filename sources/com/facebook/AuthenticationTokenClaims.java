package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 L2\u00020\u0001:\u0001LB\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0002\b\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001eB\u000f\b\u0010\u0012\u0006\u0010\u001f\u001a\u00020 ¢\u0006\u0002\u0010!J\b\u0010;\u001a\u00020\u0019H\u0016J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\b\u0010@\u001a\u00020\u0019H\u0016J\u0018\u0010A\u001a\u00020=2\u0006\u0010B\u001a\u00020C2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010D\u001a\u00020\u0003H\u0007J\r\u0010E\u001a\u00020CH\u0001¢\u0006\u0002\bFJ\b\u0010G\u001a\u00020\u0003H\u0016J\u0018\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020 2\u0006\u0010K\u001a\u00020\u0019H\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010#R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010#R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010#R\u001f\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010#R\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u000104¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010#R\u001f\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b8\u00102R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010#R\u001f\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b:\u00102¨\u0006M"}, d2 = {"Lcom/facebook/AuthenticationTokenClaims;", "Landroid/os/Parcelable;", "encodedClaims", "", "expectedNonce", "(Ljava/lang/String;Ljava/lang/String;)V", "jti", "iss", "aud", "nonce", "exp", "", "iat", "sub", "name", "givenName", "middleName", "familyName", "email", "picture", "userFriends", "", "userBirthday", "userAgeRange", "", "", "userHometown", "userLocation", "userGender", "userLink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAud", "()Ljava/lang/String;", "getEmail", "getExp", "()J", "getFamilyName", "getGivenName", "getIat", "getIss", "getJti", "getMiddleName", "getName", "getNonce", "getPicture", "getSub", "getUserAgeRange", "()Ljava/util/Map;", "getUserBirthday", "", "getUserFriends", "()Ljava/util/Set;", "getUserGender", "getUserHometown", "getUserLink", "getUserLocation", "describeContents", "equals", "", "other", "", "hashCode", "isValidClaims", "claimsJson", "Lorg/json/JSONObject;", "toEnCodedString", "toJSONObject", "toJSONObject$facebook_core_release", "toString", "writeToParcel", "", "dest", "flags", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AuthenticationTokenClaims.kt */
public final class AuthenticationTokenClaims implements Parcelable {
    public static final Parcelable.Creator<AuthenticationTokenClaims> CREATOR = new AuthenticationTokenClaims$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String JSON_KEY_AUD = "aud";
    public static final String JSON_KEY_EMAIL = "email";
    public static final String JSON_KEY_EXP = "exp";
    public static final String JSON_KEY_FAMILY_NAME = "family_name";
    public static final String JSON_KEY_GIVEN_NAME = "given_name";
    public static final String JSON_KEY_IAT = "iat";
    public static final String JSON_KEY_ISS = "iss";
    public static final String JSON_KEY_JIT = "jti";
    public static final String JSON_KEY_MIDDLE_NAME = "middle_name";
    public static final String JSON_KEY_NAME = "name";
    public static final String JSON_KEY_NONCE = "nonce";
    public static final String JSON_KEY_PICTURE = "picture";
    public static final String JSON_KEY_SUB = "sub";
    public static final String JSON_KEY_USER_AGE_RANGE = "user_age_range";
    public static final String JSON_KEY_USER_BIRTHDAY = "user_birthday";
    public static final String JSON_KEY_USER_FRIENDS = "user_friends";
    public static final String JSON_KEY_USER_GENDER = "user_gender";
    public static final String JSON_KEY_USER_HOMETOWN = "user_hometown";
    public static final String JSON_KEY_USER_LINK = "user_link";
    public static final String JSON_KEY_USER_LOCATION = "user_location";
    public static final long MAX_TIME_SINCE_TOKEN_ISSUED = 600000;
    private final String aud;
    private final String email;
    private final long exp;
    private final String familyName;
    private final String givenName;
    private final long iat;
    private final String iss;
    private final String jti;
    private final String middleName;
    private final String name;
    private final String nonce;
    private final String picture;
    private final String sub;
    private final Map<String, Integer> userAgeRange;
    private final String userBirthday;
    private final Set<String> userFriends;
    private final String userGender;
    private final Map<String, String> userHometown;
    private final String userLink;
    private final Map<String, String> userLocation;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5) {
        this(str, str2, str3, str4, j, j2, str5, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Collection) null, (String) null, (Map) null, (Map) null, (Map) null, (String) null, (String) null, 1048448, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, JSON_KEY_JIT);
        Intrinsics.checkNotNullParameter(str2, JSON_KEY_ISS);
        Intrinsics.checkNotNullParameter(str3, JSON_KEY_AUD);
        Intrinsics.checkNotNullParameter(str4, "nonce");
        Intrinsics.checkNotNullParameter(str5, JSON_KEY_SUB);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6) {
        this(str, str2, str3, str4, j, j2, str5, str6, (String) null, (String) null, (String) null, (String) null, (String) null, (Collection) null, (String) null, (Map) null, (Map) null, (Map) null, (String) null, (String) null, 1048320, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, JSON_KEY_JIT);
        Intrinsics.checkNotNullParameter(str2, JSON_KEY_ISS);
        Intrinsics.checkNotNullParameter(str3, JSON_KEY_AUD);
        Intrinsics.checkNotNullParameter(str4, "nonce");
        Intrinsics.checkNotNullParameter(str5, JSON_KEY_SUB);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, String str7) {
        this(str, str2, str3, str4, j, j2, str5, str6, str7, (String) null, (String) null, (String) null, (String) null, (Collection) null, (String) null, (Map) null, (Map) null, (Map) null, (String) null, (String) null, 1048064, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, JSON_KEY_JIT);
        Intrinsics.checkNotNullParameter(str2, JSON_KEY_ISS);
        Intrinsics.checkNotNullParameter(str3, JSON_KEY_AUD);
        Intrinsics.checkNotNullParameter(str4, "nonce");
        Intrinsics.checkNotNullParameter(str5, JSON_KEY_SUB);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, String str7, String str8) {
        this(str, str2, str3, str4, j, j2, str5, str6, str7, str8, (String) null, (String) null, (String) null, (Collection) null, (String) null, (Map) null, (Map) null, (Map) null, (String) null, (String) null, 1047552, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, JSON_KEY_JIT);
        Intrinsics.checkNotNullParameter(str2, JSON_KEY_ISS);
        Intrinsics.checkNotNullParameter(str3, JSON_KEY_AUD);
        Intrinsics.checkNotNullParameter(str4, "nonce");
        Intrinsics.checkNotNullParameter(str5, JSON_KEY_SUB);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, String str7, String str8, String str9) {
        this(str, str2, str3, str4, j, j2, str5, str6, str7, str8, str9, (String) null, (String) null, (Collection) null, (String) null, (Map) null, (Map) null, (Map) null, (String) null, (String) null, 1046528, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, JSON_KEY_JIT);
        Intrinsics.checkNotNullParameter(str2, JSON_KEY_ISS);
        Intrinsics.checkNotNullParameter(str3, JSON_KEY_AUD);
        Intrinsics.checkNotNullParameter(str4, "nonce");
        Intrinsics.checkNotNullParameter(str5, JSON_KEY_SUB);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, String str7, String str8, String str9, String str10) {
        this(str, str2, str3, str4, j, j2, str5, str6, str7, str8, str9, str10, (String) null, (Collection) null, (String) null, (Map) null, (Map) null, (Map) null, (String) null, (String) null, 1044480, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, JSON_KEY_JIT);
        Intrinsics.checkNotNullParameter(str2, JSON_KEY_ISS);
        Intrinsics.checkNotNullParameter(str3, JSON_KEY_AUD);
        Intrinsics.checkNotNullParameter(str4, "nonce");
        Intrinsics.checkNotNullParameter(str5, JSON_KEY_SUB);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthenticationTokenClaims(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, long r32, long r34, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r32
            r7 = r34
            r9 = r36
            r10 = r37
            r11 = r38
            r12 = r39
            r13 = r40
            r14 = r41
            r15 = r42
            r25 = r0
            java.lang.String r0 = "jti"
            r26 = r1
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "iss"
            r1 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "aud"
            r1 = r30
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "nonce"
            r1 = r31
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "sub"
            r1 = r36
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 1040384(0xfe000, float:1.457889E-39)
            r24 = 0
            r0 = r25
            r1 = r26
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthenticationTokenClaims(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, long r32, long r34, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.util.Collection<java.lang.String> r43) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r32
            r7 = r34
            r9 = r36
            r10 = r37
            r11 = r38
            r12 = r39
            r13 = r40
            r14 = r41
            r15 = r42
            r16 = r43
            r25 = r0
            java.lang.String r0 = "jti"
            r26 = r1
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "iss"
            r1 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "aud"
            r1 = r30
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "nonce"
            r1 = r31
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "sub"
            r1 = r36
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 1032192(0xfc000, float:1.446409E-39)
            r24 = 0
            r0 = r25
            r1 = r26
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Collection):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthenticationTokenClaims(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, long r32, long r34, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.util.Collection<java.lang.String> r43, java.lang.String r44) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r32
            r7 = r34
            r9 = r36
            r10 = r37
            r11 = r38
            r12 = r39
            r13 = r40
            r14 = r41
            r15 = r42
            r16 = r43
            r17 = r44
            r25 = r0
            java.lang.String r0 = "jti"
            r26 = r1
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "iss"
            r1 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "aud"
            r1 = r30
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "nonce"
            r1 = r31
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "sub"
            r1 = r36
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 1015808(0xf8000, float:1.42345E-39)
            r24 = 0
            r0 = r25
            r1 = r26
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Collection, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthenticationTokenClaims(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, long r32, long r34, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.util.Collection<java.lang.String> r43, java.lang.String r44, java.util.Map<java.lang.String, java.lang.Integer> r45) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r32
            r7 = r34
            r9 = r36
            r10 = r37
            r11 = r38
            r12 = r39
            r13 = r40
            r14 = r41
            r15 = r42
            r16 = r43
            r17 = r44
            r18 = r45
            r25 = r0
            java.lang.String r0 = "jti"
            r26 = r1
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "iss"
            r1 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "aud"
            r1 = r30
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "nonce"
            r1 = r31
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "sub"
            r1 = r36
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 983040(0xf0000, float:1.377532E-39)
            r24 = 0
            r0 = r25
            r1 = r26
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Collection, java.lang.String, java.util.Map):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthenticationTokenClaims(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, long r32, long r34, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.util.Collection<java.lang.String> r43, java.lang.String r44, java.util.Map<java.lang.String, java.lang.Integer> r45, java.util.Map<java.lang.String, java.lang.String> r46) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r32
            r7 = r34
            r9 = r36
            r10 = r37
            r11 = r38
            r12 = r39
            r13 = r40
            r14 = r41
            r15 = r42
            r16 = r43
            r17 = r44
            r18 = r45
            r19 = r46
            r25 = r0
            java.lang.String r0 = "jti"
            r26 = r1
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "iss"
            r1 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "aud"
            r1 = r30
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "nonce"
            r1 = r31
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "sub"
            r1 = r36
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 917504(0xe0000, float:1.285697E-39)
            r24 = 0
            r0 = r25
            r1 = r26
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Collection, java.lang.String, java.util.Map, java.util.Map):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthenticationTokenClaims(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, long r32, long r34, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.util.Collection<java.lang.String> r43, java.lang.String r44, java.util.Map<java.lang.String, java.lang.Integer> r45, java.util.Map<java.lang.String, java.lang.String> r46, java.util.Map<java.lang.String, java.lang.String> r47) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r32
            r7 = r34
            r9 = r36
            r10 = r37
            r11 = r38
            r12 = r39
            r13 = r40
            r14 = r41
            r15 = r42
            r16 = r43
            r17 = r44
            r18 = r45
            r19 = r46
            r20 = r47
            r25 = r0
            java.lang.String r0 = "jti"
            r26 = r1
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "iss"
            r1 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "aud"
            r1 = r30
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "nonce"
            r1 = r31
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "sub"
            r1 = r36
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r21 = 0
            r22 = 0
            r23 = 786432(0xc0000, float:1.102026E-39)
            r24 = 0
            r0 = r25
            r1 = r26
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Collection, java.lang.String, java.util.Map, java.util.Map, java.util.Map):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthenticationTokenClaims(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, long r32, long r34, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.util.Collection<java.lang.String> r43, java.lang.String r44, java.util.Map<java.lang.String, java.lang.Integer> r45, java.util.Map<java.lang.String, java.lang.String> r46, java.util.Map<java.lang.String, java.lang.String> r47, java.lang.String r48) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r32
            r7 = r34
            r9 = r36
            r10 = r37
            r11 = r38
            r12 = r39
            r13 = r40
            r14 = r41
            r15 = r42
            r16 = r43
            r17 = r44
            r18 = r45
            r19 = r46
            r20 = r47
            r21 = r48
            r25 = r0
            java.lang.String r0 = "jti"
            r26 = r1
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "iss"
            r1 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "aud"
            r1 = r30
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "nonce"
            r1 = r31
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "sub"
            r1 = r36
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r22 = 0
            r23 = 524288(0x80000, float:7.34684E-40)
            r24 = 0
            r0 = r25
            r1 = r26
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Collection, java.lang.String, java.util.Map, java.util.Map, java.util.Map, java.lang.String):void");
    }

    @JvmStatic
    public static final AuthenticationTokenClaims createFromJSONObject$facebook_core_release(JSONObject jSONObject) throws JSONException {
        return Companion.createFromJSONObject$facebook_core_release(jSONObject);
    }

    public int describeContents() {
        return 0;
    }

    public final String getJti() {
        return this.jti;
    }

    public final String getIss() {
        return this.iss;
    }

    public final String getAud() {
        return this.aud;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final long getExp() {
        return this.exp;
    }

    public final long getIat() {
        return this.iat;
    }

    public final String getSub() {
        return this.sub;
    }

    public final String getName() {
        return this.name;
    }

    public final String getGivenName() {
        return this.givenName;
    }

    public final String getMiddleName() {
        return this.middleName;
    }

    public final String getFamilyName() {
        return this.familyName;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final Set<String> getUserFriends() {
        return this.userFriends;
    }

    public final String getUserBirthday() {
        return this.userBirthday;
    }

    public final Map<String, Integer> getUserAgeRange() {
        return this.userAgeRange;
    }

    public final Map<String, String> getUserHometown() {
        return this.userHometown;
    }

    public final Map<String, String> getUserLocation() {
        return this.userLocation;
    }

    public final String getUserGender() {
        return this.userGender;
    }

    public final String getUserLink() {
        return this.userLink;
    }

    public AuthenticationTokenClaims(String str, String str2) {
        Set<String> set;
        Map<String, Integer> map;
        Map<String, String> map2;
        Intrinsics.checkNotNullParameter(str, "encodedClaims");
        Intrinsics.checkNotNullParameter(str2, "expectedNonce");
        Validate validate = Validate.INSTANCE;
        Validate.notEmpty(str, "encodedClaims");
        byte[] decode = Base64.decode(str, 8);
        Intrinsics.checkNotNullExpressionValue(decode, "decodedBytes");
        JSONObject jSONObject = new JSONObject(new String(decode, Charsets.UTF_8));
        if (isValidClaims(jSONObject, str2)) {
            String string = jSONObject.getString(JSON_KEY_JIT);
            Intrinsics.checkNotNullExpressionValue(string, "jsonObj.getString(JSON_KEY_JIT)");
            this.jti = string;
            String string2 = jSONObject.getString(JSON_KEY_ISS);
            Intrinsics.checkNotNullExpressionValue(string2, "jsonObj.getString(JSON_KEY_ISS)");
            this.iss = string2;
            String string3 = jSONObject.getString(JSON_KEY_AUD);
            Intrinsics.checkNotNullExpressionValue(string3, "jsonObj.getString(JSON_KEY_AUD)");
            this.aud = string3;
            String string4 = jSONObject.getString("nonce");
            Intrinsics.checkNotNullExpressionValue(string4, "jsonObj.getString(JSON_KEY_NONCE)");
            this.nonce = string4;
            this.exp = jSONObject.getLong(JSON_KEY_EXP);
            this.iat = jSONObject.getLong(JSON_KEY_IAT);
            String string5 = jSONObject.getString(JSON_KEY_SUB);
            Intrinsics.checkNotNullExpressionValue(string5, "jsonObj.getString(JSON_KEY_SUB)");
            this.sub = string5;
            Companion companion = Companion;
            this.name = companion.getNullableString$facebook_core_release(jSONObject, "name");
            this.givenName = companion.getNullableString$facebook_core_release(jSONObject, JSON_KEY_GIVEN_NAME);
            this.middleName = companion.getNullableString$facebook_core_release(jSONObject, JSON_KEY_MIDDLE_NAME);
            this.familyName = companion.getNullableString$facebook_core_release(jSONObject, JSON_KEY_FAMILY_NAME);
            this.email = companion.getNullableString$facebook_core_release(jSONObject, "email");
            this.picture = companion.getNullableString$facebook_core_release(jSONObject, "picture");
            JSONArray optJSONArray = jSONObject.optJSONArray(JSON_KEY_USER_FRIENDS);
            Map<String, String> map3 = null;
            if (optJSONArray == null) {
                set = null;
            } else {
                Utility utility = Utility.INSTANCE;
                set = Collections.unmodifiableSet(Utility.jsonArrayToSet(optJSONArray));
            }
            this.userFriends = set;
            this.userBirthday = companion.getNullableString$facebook_core_release(jSONObject, JSON_KEY_USER_BIRTHDAY);
            JSONObject optJSONObject = jSONObject.optJSONObject(JSON_KEY_USER_AGE_RANGE);
            if (optJSONObject == null) {
                map = null;
            } else {
                Utility utility2 = Utility.INSTANCE;
                map = Collections.unmodifiableMap(Utility.convertJSONObjectToHashMap(optJSONObject));
            }
            this.userAgeRange = map;
            JSONObject optJSONObject2 = jSONObject.optJSONObject(JSON_KEY_USER_HOMETOWN);
            if (optJSONObject2 == null) {
                map2 = null;
            } else {
                Utility utility3 = Utility.INSTANCE;
                map2 = Collections.unmodifiableMap(Utility.convertJSONObjectToStringMap(optJSONObject2));
            }
            this.userHometown = map2;
            JSONObject optJSONObject3 = jSONObject.optJSONObject(JSON_KEY_USER_LOCATION);
            if (optJSONObject3 != null) {
                Utility utility4 = Utility.INSTANCE;
                map3 = Collections.unmodifiableMap(Utility.convertJSONObjectToStringMap(optJSONObject3));
            }
            this.userLocation = map3;
            this.userGender = companion.getNullableString$facebook_core_release(jSONObject, JSON_KEY_USER_GENDER);
            this.userLink = companion.getNullableString$facebook_core_release(jSONObject, JSON_KEY_USER_LINK);
            return;
        }
        throw new IllegalArgumentException("Invalid claims".toString());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AuthenticationTokenClaims(java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, long r31, long r33, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.util.Collection r42, java.lang.String r43, java.util.Map r44, java.util.Map r45, java.util.Map r46, java.lang.String r47, java.lang.String r48, int r49, kotlin.jvm.internal.DefaultConstructorMarker r50) {
        /*
            r26 = this;
            r0 = r49
            r1 = r0 & 128(0x80, float:1.794E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r13 = r2
            goto L_0x000b
        L_0x0009:
            r13 = r36
        L_0x000b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0011
            r14 = r2
            goto L_0x0013
        L_0x0011:
            r14 = r37
        L_0x0013:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0019
            r15 = r2
            goto L_0x001b
        L_0x0019:
            r15 = r38
        L_0x001b:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0022
            r16 = r2
            goto L_0x0024
        L_0x0022:
            r16 = r39
        L_0x0024:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x002b
            r17 = r2
            goto L_0x002d
        L_0x002b:
            r17 = r40
        L_0x002d:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0034
            r18 = r2
            goto L_0x0036
        L_0x0034:
            r18 = r41
        L_0x0036:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x003d
            r19 = r2
            goto L_0x003f
        L_0x003d:
            r19 = r42
        L_0x003f:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0046
            r20 = r2
            goto L_0x0048
        L_0x0046:
            r20 = r43
        L_0x0048:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0051
            r21 = r2
            goto L_0x0053
        L_0x0051:
            r21 = r44
        L_0x0053:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x005b
            r22 = r2
            goto L_0x005d
        L_0x005b:
            r22 = r45
        L_0x005d:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0065
            r23 = r2
            goto L_0x0067
        L_0x0065:
            r23 = r46
        L_0x0067:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x006f
            r24 = r2
            goto L_0x0071
        L_0x006f:
            r24 = r47
        L_0x0071:
            r1 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0079
            r25 = r2
            goto L_0x007b
        L_0x0079:
            r25 = r48
        L_0x007b:
            r3 = r26
            r4 = r27
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r31
            r10 = r33
            r12 = r35
            r3.<init>(r4, r5, r6, r7, r8, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Collection, java.lang.String, java.util.Map, java.util.Map, java.util.Map, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Collection<String> collection, String str12, Map<String, Integer> map, Map<String, String> map2, Map<String, String> map3, String str13, String str14) {
        String str15 = str;
        String str16 = str2;
        String str17 = str3;
        String str18 = str4;
        String str19 = str5;
        Collection<String> collection2 = collection;
        Map<String, Integer> map4 = map;
        Map<String, String> map5 = map2;
        Map<String, String> map6 = map3;
        Intrinsics.checkNotNullParameter(str15, JSON_KEY_JIT);
        Intrinsics.checkNotNullParameter(str16, JSON_KEY_ISS);
        Intrinsics.checkNotNullParameter(str17, JSON_KEY_AUD);
        Intrinsics.checkNotNullParameter(str18, "nonce");
        Intrinsics.checkNotNullParameter(str19, JSON_KEY_SUB);
        Validate validate = Validate.INSTANCE;
        Validate.notEmpty(str15, JSON_KEY_JIT);
        Validate validate2 = Validate.INSTANCE;
        Validate.notEmpty(str16, JSON_KEY_ISS);
        Validate validate3 = Validate.INSTANCE;
        Validate.notEmpty(str17, JSON_KEY_AUD);
        Validate validate4 = Validate.INSTANCE;
        Validate.notEmpty(str18, "nonce");
        Validate validate5 = Validate.INSTANCE;
        Validate.notEmpty(str19, JSON_KEY_SUB);
        this.jti = str15;
        this.iss = str16;
        this.aud = str17;
        this.nonce = str18;
        this.exp = j;
        this.iat = j2;
        this.sub = str19;
        this.name = str6;
        this.givenName = str7;
        this.middleName = str8;
        this.familyName = str9;
        this.email = str10;
        this.picture = str11;
        Map<String, String> map7 = null;
        this.userFriends = collection2 != null ? Collections.unmodifiableSet(new HashSet(collection2)) : null;
        this.userBirthday = str12;
        this.userAgeRange = map4 != null ? Collections.unmodifiableMap(new HashMap(map4)) : null;
        this.userHometown = map5 != null ? Collections.unmodifiableMap(new HashMap(map5)) : null;
        this.userLocation = map6 != null ? Collections.unmodifiableMap(new HashMap(map6)) : map7;
        this.userGender = str13;
        this.userLink = str14;
    }

    public AuthenticationTokenClaims(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Validate validate = Validate.INSTANCE;
        this.jti = Validate.notNullOrEmpty(readString, JSON_KEY_JIT);
        String readString2 = parcel.readString();
        Validate validate2 = Validate.INSTANCE;
        this.iss = Validate.notNullOrEmpty(readString2, JSON_KEY_ISS);
        String readString3 = parcel.readString();
        Validate validate3 = Validate.INSTANCE;
        this.aud = Validate.notNullOrEmpty(readString3, JSON_KEY_AUD);
        String readString4 = parcel.readString();
        Validate validate4 = Validate.INSTANCE;
        this.nonce = Validate.notNullOrEmpty(readString4, "nonce");
        this.exp = parcel.readLong();
        this.iat = parcel.readLong();
        String readString5 = parcel.readString();
        Validate validate5 = Validate.INSTANCE;
        this.sub = Validate.notNullOrEmpty(readString5, JSON_KEY_SUB);
        this.name = parcel.readString();
        this.givenName = parcel.readString();
        this.middleName = parcel.readString();
        this.familyName = parcel.readString();
        this.email = parcel.readString();
        this.picture = parcel.readString();
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        Map<String, String> map = null;
        this.userFriends = createStringArrayList != null ? Collections.unmodifiableSet(new HashSet(createStringArrayList)) : null;
        this.userBirthday = parcel.readString();
        HashMap readHashMap = parcel.readHashMap(IntCompanionObject.INSTANCE.getClass().getClassLoader());
        readHashMap = !(readHashMap instanceof HashMap) ? null : readHashMap;
        this.userAgeRange = readHashMap != null ? Collections.unmodifiableMap(readHashMap) : null;
        HashMap readHashMap2 = parcel.readHashMap(StringCompanionObject.INSTANCE.getClass().getClassLoader());
        readHashMap2 = !(readHashMap2 instanceof HashMap) ? null : readHashMap2;
        this.userHometown = readHashMap2 != null ? Collections.unmodifiableMap(readHashMap2) : null;
        HashMap readHashMap3 = parcel.readHashMap(StringCompanionObject.INSTANCE.getClass().getClassLoader());
        readHashMap3 = !(readHashMap3 instanceof HashMap) ? null : readHashMap3;
        this.userLocation = readHashMap3 != null ? Collections.unmodifiableMap(readHashMap3) : map;
        this.userGender = parcel.readString();
        this.userLink = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.jti);
        parcel.writeString(this.iss);
        parcel.writeString(this.aud);
        parcel.writeString(this.nonce);
        parcel.writeLong(this.exp);
        parcel.writeLong(this.iat);
        parcel.writeString(this.sub);
        parcel.writeString(this.name);
        parcel.writeString(this.givenName);
        parcel.writeString(this.middleName);
        parcel.writeString(this.familyName);
        parcel.writeString(this.email);
        parcel.writeString(this.picture);
        if (this.userFriends == null) {
            parcel.writeStringList((List) null);
        } else {
            parcel.writeStringList(new ArrayList(this.userFriends));
        }
        parcel.writeString(this.userBirthday);
        parcel.writeMap(this.userAgeRange);
        parcel.writeMap(this.userHometown);
        parcel.writeMap(this.userLocation);
        parcel.writeString(this.userGender);
        parcel.writeString(this.userLink);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationTokenClaims)) {
            return false;
        }
        AuthenticationTokenClaims authenticationTokenClaims = (AuthenticationTokenClaims) obj;
        if (!Intrinsics.areEqual((Object) this.jti, (Object) authenticationTokenClaims.jti) || !Intrinsics.areEqual((Object) this.iss, (Object) authenticationTokenClaims.iss) || !Intrinsics.areEqual((Object) this.aud, (Object) authenticationTokenClaims.aud) || !Intrinsics.areEqual((Object) this.nonce, (Object) authenticationTokenClaims.nonce) || this.exp != authenticationTokenClaims.exp || this.iat != authenticationTokenClaims.iat || !Intrinsics.areEqual((Object) this.sub, (Object) authenticationTokenClaims.sub) || !Intrinsics.areEqual((Object) this.name, (Object) authenticationTokenClaims.name) || !Intrinsics.areEqual((Object) this.givenName, (Object) authenticationTokenClaims.givenName) || !Intrinsics.areEqual((Object) this.middleName, (Object) authenticationTokenClaims.middleName) || !Intrinsics.areEqual((Object) this.familyName, (Object) authenticationTokenClaims.familyName) || !Intrinsics.areEqual((Object) this.email, (Object) authenticationTokenClaims.email) || !Intrinsics.areEqual((Object) this.picture, (Object) authenticationTokenClaims.picture) || !Intrinsics.areEqual((Object) this.userFriends, (Object) authenticationTokenClaims.userFriends) || !Intrinsics.areEqual((Object) this.userBirthday, (Object) authenticationTokenClaims.userBirthday) || !Intrinsics.areEqual((Object) this.userAgeRange, (Object) authenticationTokenClaims.userAgeRange) || !Intrinsics.areEqual((Object) this.userHometown, (Object) authenticationTokenClaims.userHometown) || !Intrinsics.areEqual((Object) this.userLocation, (Object) authenticationTokenClaims.userLocation) || !Intrinsics.areEqual((Object) this.userGender, (Object) authenticationTokenClaims.userGender) || !Intrinsics.areEqual((Object) this.userLink, (Object) authenticationTokenClaims.userLink)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((((((((((527 + this.jti.hashCode()) * 31) + this.iss.hashCode()) * 31) + this.aud.hashCode()) * 31) + this.nonce.hashCode()) * 31) + Long.hashCode(this.exp)) * 31) + Long.hashCode(this.iat)) * 31) + this.sub.hashCode()) * 31;
        String str = this.name;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.givenName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.middleName;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.familyName;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.email;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.picture;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Set<String> set = this.userFriends;
        int hashCode8 = (hashCode7 + (set == null ? 0 : set.hashCode())) * 31;
        String str7 = this.userBirthday;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Map<String, Integer> map = this.userAgeRange;
        int hashCode10 = (hashCode9 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, String> map2 = this.userHometown;
        int hashCode11 = (hashCode10 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, String> map3 = this.userLocation;
        int hashCode12 = (hashCode11 + (map3 == null ? 0 : map3.hashCode())) * 31;
        String str8 = this.userGender;
        int hashCode13 = (hashCode12 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.userLink;
        if (str9 != null) {
            i = str9.hashCode();
        }
        return hashCode13 + i;
    }

    public String toString() {
        String jSONObject = toJSONObject$facebook_core_release().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "claimsJsonObject.toString()");
        return jSONObject;
    }

    private final boolean isValidClaims(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString(JSON_KEY_JIT);
        Intrinsics.checkNotNullExpressionValue(optString, JSON_KEY_JIT);
        if (optString.length() == 0) {
            return false;
        }
        try {
            String optString2 = jSONObject.optString(JSON_KEY_ISS);
            Intrinsics.checkNotNullExpressionValue(optString2, JSON_KEY_ISS);
            if (!(optString2.length() == 0) && (Intrinsics.areEqual((Object) new URL(optString2).getHost(), (Object) "facebook.com") || Intrinsics.areEqual((Object) new URL(optString2).getHost(), (Object) "www.facebook.com"))) {
                String optString3 = jSONObject.optString(JSON_KEY_AUD);
                Intrinsics.checkNotNullExpressionValue(optString3, JSON_KEY_AUD);
                if (!(optString3.length() == 0)) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    if (Intrinsics.areEqual((Object) optString3, (Object) FacebookSdk.getApplicationId())) {
                        long j = (long) 1000;
                        if (new Date().after(new Date(jSONObject.optLong(JSON_KEY_EXP) * j))) {
                            return false;
                        }
                        if (new Date().after(new Date((jSONObject.optLong(JSON_KEY_IAT) * j) + MAX_TIME_SINCE_TOKEN_ISSUED))) {
                            return false;
                        }
                        String optString4 = jSONObject.optString(JSON_KEY_SUB);
                        Intrinsics.checkNotNullExpressionValue(optString4, JSON_KEY_SUB);
                        if (optString4.length() == 0) {
                            return false;
                        }
                        String optString5 = jSONObject.optString("nonce");
                        Intrinsics.checkNotNullExpressionValue(optString5, "nonce");
                        if ((optString5.length() == 0) || !Intrinsics.areEqual((Object) optString5, (Object) str)) {
                            return false;
                        }
                        return true;
                    }
                }
            }
        } catch (MalformedURLException unused) {
        }
        return false;
    }

    public final String toEnCodedString() {
        String authenticationTokenClaims = toString();
        Charset charset = Charsets.UTF_8;
        if (authenticationTokenClaims != null) {
            byte[] bytes = authenticationTokenClaims.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes, 8);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(claimsJsonString.toByteArray(), Base64.URL_SAFE)");
            return encodeToString;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final JSONObject toJSONObject$facebook_core_release() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JSON_KEY_JIT, (Object) this.jti);
        jSONObject.put(JSON_KEY_ISS, (Object) this.iss);
        jSONObject.put(JSON_KEY_AUD, (Object) this.aud);
        jSONObject.put("nonce", (Object) this.nonce);
        jSONObject.put(JSON_KEY_EXP, this.exp);
        jSONObject.put(JSON_KEY_IAT, this.iat);
        String str = this.sub;
        if (str != null) {
            jSONObject.put(JSON_KEY_SUB, (Object) str);
        }
        String str2 = this.name;
        if (str2 != null) {
            jSONObject.put("name", (Object) str2);
        }
        String str3 = this.givenName;
        if (str3 != null) {
            jSONObject.put(JSON_KEY_GIVEN_NAME, (Object) str3);
        }
        String str4 = this.middleName;
        if (str4 != null) {
            jSONObject.put(JSON_KEY_MIDDLE_NAME, (Object) str4);
        }
        String str5 = this.familyName;
        if (str5 != null) {
            jSONObject.put(JSON_KEY_FAMILY_NAME, (Object) str5);
        }
        String str6 = this.email;
        if (str6 != null) {
            jSONObject.put("email", (Object) str6);
        }
        String str7 = this.picture;
        if (str7 != null) {
            jSONObject.put("picture", (Object) str7);
        }
        if (this.userFriends != null) {
            jSONObject.put(JSON_KEY_USER_FRIENDS, (Object) new JSONArray((Collection<?>) this.userFriends));
        }
        String str8 = this.userBirthday;
        if (str8 != null) {
            jSONObject.put(JSON_KEY_USER_BIRTHDAY, (Object) str8);
        }
        if (this.userAgeRange != null) {
            jSONObject.put(JSON_KEY_USER_AGE_RANGE, (Object) new JSONObject((Map<?, ?>) this.userAgeRange));
        }
        if (this.userHometown != null) {
            jSONObject.put(JSON_KEY_USER_HOMETOWN, (Object) new JSONObject((Map<?, ?>) this.userHometown));
        }
        if (this.userLocation != null) {
            jSONObject.put(JSON_KEY_USER_LOCATION, (Object) new JSONObject((Map<?, ?>) this.userLocation));
        }
        String str9 = this.userGender;
        if (str9 != null) {
            jSONObject.put(JSON_KEY_USER_GENDER, (Object) str9);
        }
        String str10 = this.userLink;
        if (str10 != null) {
            jSONObject.put(JSON_KEY_USER_LINK, (Object) str10);
        }
        return jSONObject;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b J\u001b\u0010!\u001a\u0004\u0018\u00010\u0007*\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0007H\u0000¢\u0006\u0002\b#R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/facebook/AuthenticationTokenClaims$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/AuthenticationTokenClaims;", "JSON_KEY_AUD", "", "JSON_KEY_EMAIL", "JSON_KEY_EXP", "JSON_KEY_FAMILY_NAME", "JSON_KEY_GIVEN_NAME", "JSON_KEY_IAT", "JSON_KEY_ISS", "JSON_KEY_JIT", "JSON_KEY_MIDDLE_NAME", "JSON_KEY_NAME", "JSON_KEY_NONCE", "JSON_KEY_PICTURE", "JSON_KEY_SUB", "JSON_KEY_USER_AGE_RANGE", "JSON_KEY_USER_BIRTHDAY", "JSON_KEY_USER_FRIENDS", "JSON_KEY_USER_GENDER", "JSON_KEY_USER_HOMETOWN", "JSON_KEY_USER_LINK", "JSON_KEY_USER_LOCATION", "MAX_TIME_SINCE_TOKEN_ISSUED", "", "createFromJSONObject", "jsonObject", "Lorg/json/JSONObject;", "createFromJSONObject$facebook_core_release", "getNullableString", "name", "getNullableString$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AuthenticationTokenClaims.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getNullableString$facebook_core_release(JSONObject jSONObject, String str) {
            Intrinsics.checkNotNullParameter(jSONObject, "<this>");
            Intrinsics.checkNotNullParameter(str, "name");
            if (jSONObject.has(str)) {
                return jSONObject.getString(str);
            }
            return null;
        }

        @JvmStatic
        public final AuthenticationTokenClaims createFromJSONObject$facebook_core_release(JSONObject jSONObject) throws JSONException {
            List<String> list;
            Map<String, Object> map;
            Map<String, String> map2;
            JSONObject jSONObject2 = jSONObject;
            Intrinsics.checkNotNullParameter(jSONObject2, "jsonObject");
            String string = jSONObject2.getString(AuthenticationTokenClaims.JSON_KEY_JIT);
            String string2 = jSONObject2.getString(AuthenticationTokenClaims.JSON_KEY_ISS);
            String string3 = jSONObject2.getString(AuthenticationTokenClaims.JSON_KEY_AUD);
            String string4 = jSONObject2.getString("nonce");
            long j = jSONObject2.getLong(AuthenticationTokenClaims.JSON_KEY_EXP);
            long j2 = jSONObject2.getLong(AuthenticationTokenClaims.JSON_KEY_IAT);
            String string5 = jSONObject2.getString(AuthenticationTokenClaims.JSON_KEY_SUB);
            long j3 = j2;
            String nullableString$facebook_core_release = getNullableString$facebook_core_release(jSONObject2, "name");
            String nullableString$facebook_core_release2 = getNullableString$facebook_core_release(jSONObject2, AuthenticationTokenClaims.JSON_KEY_GIVEN_NAME);
            String nullableString$facebook_core_release3 = getNullableString$facebook_core_release(jSONObject2, AuthenticationTokenClaims.JSON_KEY_MIDDLE_NAME);
            String nullableString$facebook_core_release4 = getNullableString$facebook_core_release(jSONObject2, AuthenticationTokenClaims.JSON_KEY_FAMILY_NAME);
            String nullableString$facebook_core_release5 = getNullableString$facebook_core_release(jSONObject2, "email");
            String nullableString$facebook_core_release6 = getNullableString$facebook_core_release(jSONObject2, "picture");
            JSONArray optJSONArray = jSONObject2.optJSONArray(AuthenticationTokenClaims.JSON_KEY_USER_FRIENDS);
            String str = nullableString$facebook_core_release;
            String nullableString$facebook_core_release7 = getNullableString$facebook_core_release(jSONObject2, AuthenticationTokenClaims.JSON_KEY_USER_BIRTHDAY);
            JSONObject optJSONObject = jSONObject2.optJSONObject(AuthenticationTokenClaims.JSON_KEY_USER_AGE_RANGE);
            long j4 = j;
            JSONObject optJSONObject2 = jSONObject2.optJSONObject(AuthenticationTokenClaims.JSON_KEY_USER_HOMETOWN);
            JSONObject optJSONObject3 = jSONObject2.optJSONObject(AuthenticationTokenClaims.JSON_KEY_USER_LOCATION);
            String nullableString$facebook_core_release8 = getNullableString$facebook_core_release(jSONObject2, AuthenticationTokenClaims.JSON_KEY_USER_GENDER);
            String nullableString$facebook_core_release9 = getNullableString$facebook_core_release(jSONObject2, AuthenticationTokenClaims.JSON_KEY_USER_LINK);
            Intrinsics.checkNotNullExpressionValue(string, AuthenticationTokenClaims.JSON_KEY_JIT);
            Intrinsics.checkNotNullExpressionValue(string2, AuthenticationTokenClaims.JSON_KEY_ISS);
            Intrinsics.checkNotNullExpressionValue(string3, AuthenticationTokenClaims.JSON_KEY_AUD);
            Intrinsics.checkNotNullExpressionValue(string4, "nonce");
            Intrinsics.checkNotNullExpressionValue(string5, AuthenticationTokenClaims.JSON_KEY_SUB);
            Map<String, String> map3 = null;
            if (optJSONArray == null) {
                list = null;
            } else {
                Utility utility = Utility.INSTANCE;
                list = Utility.jsonArrayToStringList(optJSONArray);
            }
            Collection collection = list;
            if (optJSONObject == null) {
                map = null;
            } else {
                Utility utility2 = Utility.INSTANCE;
                map = Utility.convertJSONObjectToHashMap(optJSONObject);
            }
            if (optJSONObject2 == null) {
                map2 = null;
            } else {
                Utility utility3 = Utility.INSTANCE;
                map2 = Utility.convertJSONObjectToStringMap(optJSONObject2);
            }
            if (optJSONObject3 != null) {
                Utility utility4 = Utility.INSTANCE;
                map3 = Utility.convertJSONObjectToStringMap(optJSONObject3);
            }
            return new AuthenticationTokenClaims(string, string2, string3, string4, j4, j3, string5, str, nullableString$facebook_core_release2, nullableString$facebook_core_release3, nullableString$facebook_core_release4, nullableString$facebook_core_release5, nullableString$facebook_core_release6, collection, nullableString$facebook_core_release7, map, map2, map3, nullableString$facebook_core_release8, nullableString$facebook_core_release9);
        }
    }
}
