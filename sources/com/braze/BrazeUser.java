package com.braze;

import androidx.autofill.HintConstants;
import bo.app.k2;
import bo.app.l5;
import bo.app.w6;
import bo.app.x1;
import bo.app.y5;
import bo.app.z1;
import com.braze.enums.BrazeDateFormat;
import com.braze.enums.Gender;
import com.braze.enums.Month;
import com.braze.enums.NotificationSubscriptionType;
import com.braze.models.outgoing.AttributionData;
import com.braze.models.outgoing.BrazeLocation;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.JsonUtils;
import com.braze.support.ValidationUtils;
import java.util.TimeZone;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B1\b\u0000\u0012\u0006\u0010K\u001a\u00020J\u0012\u0006\u0010N\u001a\u00020M\u0012\u0006\u0010P\u001a\u00020\u0002\u0012\u0006\u0010S\u001a\u00020R\u0012\u0006\u0010V\u001a\u00020U¢\u0006\u0004\b`\u0010aJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u001e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0010J\u0010\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001cJ\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0002J\u000e\u0010#\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0002J\u0010\u0010%\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0002J\u0016\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0005J\u0016\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0010J\u0016\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020)J\u0016\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020*J\u0016\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0002J\u0016\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020+J\"\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u0005H\u0007J\u0016\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020.J\u0016\u0010/\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0002J\u0016\u00100\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0002J%\u00103\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u000e\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000201¢\u0006\u0004\b3\u00104J\u000e\u00105\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0002J\u0016\u00107\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u00106\u001a\u00020*J\u001a\u00109\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\b\b\u0002\u00108\u001a\u00020\u0010H\u0007J\u000e\u0010:\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0002J\u0010\u0010=\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010;JC\u0010D\u001a\u00020C2\u0006\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020+2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010+H\u0007¢\u0006\u0004\bD\u0010EJ\u001e\u0010F\u001a\u00020C2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020+J\u000e\u0010G\u001a\u00020C2\u0006\u0010&\u001a\u00020\u0002J\"\u0010H\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010-\u001a\u00020\u0005H\u0007J\u0016\u0010I\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u00106\u001a\u00020*R\u0014\u0010K\u001a\u00020J8\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020U8\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010Y\u001a\u00020X8\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR$\u0010[\u001a\u00020\u00022\u0006\u0010[\u001a\u00020\u00028F@FX\u000e¢\u0006\f\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_¨\u0006b"}, d2 = {"Lcom/braze/BrazeUser;", "", "", "alias", "label", "", "addAlias", "firstName", "setFirstName", "lastName", "setLastName", "email", "setEmail", "Lcom/braze/enums/Gender;", "gender", "setGender", "", "year", "Lcom/braze/enums/Month;", "month", "day", "setDateOfBirth", "country", "setCountry", "homeCity", "setHomeCity", "language", "setLanguage", "Lcom/braze/enums/NotificationSubscriptionType;", "emailNotificationSubscriptionType", "setEmailNotificationSubscriptionType", "pushNotificationSubscriptionType", "setPushNotificationSubscriptionType", "subscriptionGroupId", "addToSubscriptionGroup", "removeFromSubscriptionGroup", "phoneNumber", "setPhoneNumber", "key", "value", "setCustomUserAttribute", "", "", "", "Lorg/json/JSONObject;", "merge", "Lorg/json/JSONArray;", "addToCustomAttributeArray", "removeFromCustomAttributeArray", "", "values", "setCustomAttributeArray", "(Ljava/lang/String;[Ljava/lang/String;)Z", "setCustomUserAttributeToNow", "secondsFromEpoch", "setCustomUserAttributeToSecondsFromEpoch", "incrementValue", "incrementCustomUserAttribute", "unsetCustomUserAttribute", "Lcom/braze/models/outgoing/AttributionData;", "attributionData", "setAttributionData", "latitude", "longitude", "altitude", "accuracy", "verticalAccuracy", "", "setLastKnownLocation", "(DDLjava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "setLocationCustomAttribute", "unsetLocationCustomAttribute", "setCustomAttribute", "setCustomAttributeToSecondsFromEpoch", "Lbo/app/w6;", "userCache", "Lbo/app/w6;", "Lbo/app/z1;", "brazeManager", "Lbo/app/z1;", "internalUserId", "Ljava/lang/String;", "Lbo/app/k2;", "locationManager", "Lbo/app/k2;", "Lbo/app/l5;", "serverConfigStorageProvider", "Lbo/app/l5;", "Ljava/util/concurrent/locks/ReentrantLock;", "userIdLock", "Ljava/util/concurrent/locks/ReentrantLock;", "userId", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "<init>", "(Lbo/app/w6;Lbo/app/z1;Ljava/lang/String;Lbo/app/k2;Lbo/app/l5;)V", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public final class BrazeUser {
    private final z1 brazeManager;
    private volatile String internalUserId;
    private final k2 locationManager;
    private final l5 serverConfigStorageProvider;
    private final w6 userCache;
    private final ReentrantLock userIdLock = new ReentrantLock();

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid alias parameter: alias is required to be non-null and non-empty. Not adding alias.";
        }
    }

    static final class a0 extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ JSONArray c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a0(String str, JSONArray jSONArray) {
            super(0);
            this.b = str;
            this.c = jSONArray;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom json attribute " + this.b + " with value \n" + JsonUtils.getPrettyPrintedString(this.c) + '.';
        }
    }

    static final class a1 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a1(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to unset custom attribute " + this.b + '.';
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid label parameter: label is required to be non-null and non-empty. Not adding alias.";
        }
    }

    static final class b0 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b0(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom attribute " + this.b + " to now.";
        }
    }

    static final class b1 extends Lambda implements Function0 {
        public static final b1 b = new b1();

        b1() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Custom location attribute key was invalid. Not setting attribute.";
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set alias: " + this.b;
        }
    }

    static final class c0 extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ long c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c0(String str, long j) {
            super(0);
            this.b = str;
            this.c = j;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom attribute " + this.b + " to " + this.c + " seconds from epoch.";
        }
    }

    static final class c1 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c1(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to unset custom location attribute with key '" + this.b + '\'';
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Custom attribute key was invalid. Not adding to attribute array.";
        }
    }

    static final class d0 extends Lambda implements Function0 {
        final /* synthetic */ int b;
        final /* synthetic */ Month c;
        final /* synthetic */ int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d0(int i, Month month, int i2) {
            super(0);
            this.b = i;
            this.c = month;
            this.d = i2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set date of birth to: " + this.b + '-' + this.c.getValue() + '-' + this.d;
        }
    }

    static final class d1 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d1(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "User object user id set to: " + this.b;
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add custom attribute with key '" + this.b + "'.";
        }
    }

    static final class e0 extends Lambda implements Function0 {
        public static final e0 b = new e0();

        e0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid email parameter: email is required to be non-empty. Not setting email.";
        }
    }

    static final class f extends Lambda implements Function0 {
        public static final f b = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid subscription group ID: subscription group ID is required to be non-null and non-empty. Not adding user to subscription group.";
        }
    }

    static final class f0 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f0(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Email address is not valid: " + this.b;
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add user to subscription group " + this.b;
        }
    }

    static final class g0 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g0(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set email to: " + this.b;
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(String str, int i) {
            super(0);
            this.b = str;
            this.c = i;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to increment custom attribute " + this.b + " by " + this.c + '.';
        }
    }

    static final class h0 extends Lambda implements Function0 {
        final /* synthetic */ NotificationSubscriptionType b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h0(NotificationSubscriptionType notificationSubscriptionType) {
            super(0);
            this.b = notificationSubscriptionType;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set email notification subscription to: " + this.b;
        }
    }

    static final class i extends Lambda implements Function0 {
        public static final i b = new i();

        i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Custom attribute key was invalid. Not removing from attribute array.";
        }
    }

    static final class i0 extends Lambda implements Function0 {
        public static final i0 b = new i0();

        i0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid first name parameter: first name is required to be non-empty. Not setting first name.";
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to remove custom attribute with key '" + this.b + "'.";
        }
    }

    static final class j0 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j0(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set first name to: " + this.b;
        }
    }

    static final class k extends Lambda implements Function0 {
        public static final k b = new k();

        k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid subscription group ID: subscription group ID is required to be non-null and non-empty. Not removing user from subscription group.";
        }
    }

    static final class k0 extends Lambda implements Function0 {
        final /* synthetic */ Gender b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k0(Gender gender) {
            super(0);
            this.b = gender;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set gender to: " + this.b;
        }
    }

    static final class l extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to remove user from subscription group " + this.b;
        }
    }

    static final class l0 extends Lambda implements Function0 {
        public static final l0 b = new l0();

        l0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid home city parameter: home city is required to be non-blank. Not setting home city.";
        }
    }

    static final class m extends Lambda implements Function0 {
        public static final m b = new m();

        m() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set attribution data.";
        }
    }

    static final class m0 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m0(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set home city to: " + this.b;
        }
    }

    static final class n extends Lambda implements Function0 {
        public static final n b = new n();

        n() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid country parameter: country is required to be non-blank. Not setting country.";
        }
    }

    static final class n0 extends Lambda implements Function0 {
        public static final n0 b = new n0();

        n0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid language parameter: language is required to be non-empty. Not setting language.";
        }
    }

    static final class o extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set country to: " + this.b;
        }
    }

    static final class o0 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o0(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set language to: " + this.b;
        }
    }

    static final class p extends Lambda implements Function0 {
        public static final p b = new p();

        p() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Custom attribute key cannot be null.";
        }
    }

    static final class p0 extends Lambda implements Function0 {
        public static final p0 b = new p0();

        p0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to manually set location.";
        }
    }

    static final class q extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(String str, Object obj) {
            super(0);
            this.b = str;
            this.c = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not add unsupported custom attribute value with key: " + this.b + " and value: " + this.c;
        }
    }

    static final class q0 extends Lambda implements Function0 {
        public static final q0 b = new q0();

        q0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid last name parameter: last name is required to be non-empty. Not setting last name.";
        }
    }

    static final class r extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(String str, Object obj) {
            super(0);
            this.b = str;
            this.c = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not build NestedCustomAttributeEvent for key " + this.b + " and " + this.c;
        }
    }

    static final class r0 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r0(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set last name to: " + this.b;
        }
    }

    static final class s extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom attribute array with key: '" + this.b + "'.";
        }
    }

    static final class s0 extends Lambda implements Function0 {
        public static final s0 b = new s0();

        s0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Custom location attribute key was invalid. Not setting attribute.";
        }
    }

    static final class t extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom boolean attribute " + this.b + '.';
        }
    }

    static final class t0 extends Lambda implements Function0 {
        final /* synthetic */ double b;
        final /* synthetic */ double c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t0(double d, double d2) {
            super(0);
            this.b = d;
            this.c = d2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot set custom location attribute due with invalid latitude '" + this.b + " and longitude '" + this.c + '\'';
        }
    }

    static final class u extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom integer attribute " + this.b + '.';
        }
    }

    static final class u0 extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ double c;
        final /* synthetic */ double d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u0(String str, double d2, double d3) {
            super(0);
            this.b = str;
            this.c = d2;
            this.d = d3;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom location attribute with key '" + this.b + "' and latitude '" + this.c + "' and longitude '" + this.d + '\'';
        }
    }

    static final class v extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom float attribute " + this.b + '.';
        }
    }

    static final class v0 extends Lambda implements Function0 {
        public static final v0 b = new v0();

        v0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid phone number parameter: phone number is required to be non-empty. Not setting phone number.";
        }
    }

    static final class w extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom long attribute " + this.b + '.';
        }
    }

    static final class w0 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w0(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Phone number contains invalid characters (allowed are digits, spaces, or any of the following +.-()): " + this.b;
        }
    }

    static final class x extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom string attribute " + this.b + '.';
        }
    }

    static final class x0 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x0(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set phone number to: " + this.b;
        }
    }

    static final class y extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom double attribute " + this.b + '.';
        }
    }

    static final class y0 extends Lambda implements Function0 {
        final /* synthetic */ NotificationSubscriptionType b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y0(NotificationSubscriptionType notificationSubscriptionType) {
            super(0);
            this.b = notificationSubscriptionType;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set push notification subscription to: " + this.b;
        }
    }

    static final class z extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ JSONObject c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z(String str, JSONObject jSONObject) {
            super(0);
            this.b = str;
            this.c = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom json attribute " + this.b + " with value \n" + JsonUtils.getPrettyPrintedString(this.c) + '.';
        }
    }

    static final class z0 extends Lambda implements Function0 {
        public static final z0 b = new z0();

        z0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Custom attribute key cannot be null.";
        }
    }

    public BrazeUser(w6 w6Var, z1 z1Var, String str, k2 k2Var, l5 l5Var) {
        Intrinsics.checkNotNullParameter(w6Var, "userCache");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        Intrinsics.checkNotNullParameter(str, "internalUserId");
        Intrinsics.checkNotNullParameter(k2Var, "locationManager");
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        this.userCache = w6Var;
        this.brazeManager = z1Var;
        this.internalUserId = str;
        this.locationManager = k2Var;
        this.serverConfigStorageProvider = l5Var;
    }

    public static /* synthetic */ boolean incrementCustomUserAttribute$default(BrazeUser brazeUser, String str, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        return brazeUser.incrementCustomUserAttribute(str, i2);
    }

    public static /* synthetic */ boolean setCustomAttribute$default(BrazeUser brazeUser, String str, Object obj, boolean z2, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return brazeUser.setCustomAttribute(str, obj, z2);
    }

    public static /* synthetic */ boolean setCustomUserAttribute$default(BrazeUser brazeUser, String str, JSONObject jSONObject, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return brazeUser.setCustomUserAttribute(str, jSONObject, z2);
    }

    public static /* synthetic */ void setLastKnownLocation$default(BrazeUser brazeUser, double d2, double d3, Double d4, Double d5, Double d6, int i2, Object obj) {
        brazeUser.setLastKnownLocation(d2, d3, (i2 & 4) != 0 ? null : d4, (i2 & 8) != 0 ? null : d5, (i2 & 16) != 0 ? null : d6);
    }

    public final boolean addAlias(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "alias");
        Intrinsics.checkNotNullParameter(str2, "label");
        if (StringsKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) a.b, 2, (Object) null);
            return false;
        } else if (StringsKt.isBlank(str2)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) b.b, 2, (Object) null);
            return false;
        } else {
            try {
                x1 g2 = bo.app.j.h.g(str, str2);
                if (g2 != null) {
                    return this.brazeManager.a(g2);
                }
                return false;
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new c(str));
                return false;
            }
        }
    }

    public final boolean addToCustomAttributeArray(String str, String str2) {
        x1 a2;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        try {
            if (!com.braze.support.b.a(str, this.serverConfigStorageProvider.d())) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) d.b, 2, (Object) null);
                return false;
            } else if (com.braze.support.b.b(str2) && (a2 = bo.app.j.h.a(ValidationUtils.ensureBrazeFieldLength(str), ValidationUtils.ensureBrazeFieldLength(str2))) != null) {
                return this.brazeManager.a(a2);
            } else {
                return false;
            }
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new e(str));
            return false;
        }
    }

    public final boolean addToSubscriptionGroup(String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionGroupId");
        try {
            if (StringsKt.isBlank(str)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) f.b, 2, (Object) null);
                return false;
            }
            x1 a2 = bo.app.j.h.a(str, y5.SUBSCRIBED);
            if (a2 == null) {
                return true;
            }
            this.brazeManager.a(a2);
            return true;
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new g(str));
            return false;
        }
    }

    public final String getUserId() {
        ReentrantLock reentrantLock = this.userIdLock;
        reentrantLock.lock();
        try {
            return this.internalUserId;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean incrementCustomUserAttribute(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return incrementCustomUserAttribute$default(this, str, 0, 2, (Object) null);
    }

    public final boolean removeFromCustomAttributeArray(String str, String str2) {
        x1 f2;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        try {
            if (!com.braze.support.b.a(str, this.serverConfigStorageProvider.d())) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) i.b, 2, (Object) null);
                return false;
            } else if (com.braze.support.b.b(str2) && (f2 = bo.app.j.h.f(ValidationUtils.ensureBrazeFieldLength(str), ValidationUtils.ensureBrazeFieldLength(str2))) != null) {
                return this.brazeManager.a(f2);
            } else {
                return false;
            }
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new j(str));
            return false;
        }
    }

    public final boolean removeFromSubscriptionGroup(String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionGroupId");
        try {
            if (StringsKt.isBlank(str)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) k.b, 2, (Object) null);
                return false;
            }
            x1 a2 = bo.app.j.h.a(str, y5.UNSUBSCRIBED);
            if (a2 == null) {
                return true;
            }
            this.brazeManager.a(a2);
            return true;
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new l(str));
            return false;
        }
    }

    public final boolean setAttributionData(AttributionData attributionData) {
        try {
            this.userCache.a(attributionData);
            return true;
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) m.b);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0011 A[Catch:{ Exception -> 0x000c }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f A[Catch:{ Exception -> 0x000c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean setCountry(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 1
            r1 = 0
            if (r11 == 0) goto L_0x000e
            boolean r2 = kotlin.text.StringsKt.isBlank(r11)     // Catch:{ Exception -> 0x000c }
            if (r2 != r0) goto L_0x000e
            r2 = r0
            goto L_0x000f
        L_0x000c:
            r0 = move-exception
            goto L_0x0025
        L_0x000e:
            r2 = r1
        L_0x000f:
            if (r2 == 0) goto L_0x001f
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x000c }
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x000c }
            r6 = 0
            com.braze.BrazeUser$n r7 = com.braze.BrazeUser.n.b     // Catch:{ Exception -> 0x000c }
            r8 = 2
            r9 = 0
            r4 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x000c }
            return r1
        L_0x001f:
            bo.app.w6 r2 = r10.userCache     // Catch:{ Exception -> 0x000c }
            r2.a((java.lang.String) r11)     // Catch:{ Exception -> 0x000c }
            return r0
        L_0x0025:
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.W
            com.braze.BrazeUser$o r4 = new com.braze.BrazeUser$o
            r4.<init>(r11)
            r2.brazelog((java.lang.Object) r10, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r0, (kotlin.jvm.functions.Function0<java.lang.String>) r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.BrazeUser.setCountry(java.lang.String):boolean");
    }

    public final boolean setCustomAttribute(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        return setCustomAttribute$default(this, str, obj, false, 4, (Object) null);
    }

    public final boolean setCustomAttributeArray(String str, String[] strArr) {
        x1 a2;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(strArr, "values");
        try {
            if (com.braze.support.b.a(str, this.serverConfigStorageProvider.d()) && (a2 = bo.app.j.h.a(ValidationUtils.ensureBrazeFieldLength(str), com.braze.support.b.a(strArr))) != null) {
                return this.brazeManager.a(a2);
            }
            return false;
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new s(str));
            return false;
        }
    }

    public final boolean setCustomAttributeToSecondsFromEpoch(String str, long j2) {
        Intrinsics.checkNotNullParameter(str, "key");
        return setCustomAttribute$default(this, str, DateTimeUtils.createDate(j2), false, 4, (Object) null);
    }

    public final boolean setCustomUserAttribute(String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(jSONObject, "value");
        return setCustomUserAttribute$default(this, str, jSONObject, false, 4, (Object) null);
    }

    public final boolean setCustomUserAttributeToNow(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return setCustomAttributeToSecondsFromEpoch(str, DateTimeUtils.nowInSeconds());
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new b0(str));
            return false;
        }
    }

    public final boolean setCustomUserAttributeToSecondsFromEpoch(String str, long j2) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return setCustomAttributeToSecondsFromEpoch(str, j2);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new c0(str, j2));
            return false;
        }
    }

    public final boolean setDateOfBirth(int i2, Month month, int i3) {
        Intrinsics.checkNotNullParameter(month, "month");
        try {
            return this.userCache.b(DateTimeUtils.formatDate$default(DateTimeUtils.createDate$default(i2, month.getValue(), i3, 0, 0, 0, 56, (Object) null), BrazeDateFormat.SHORT, (TimeZone) null, 2, (Object) null));
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new d0(i2, month, i3));
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0012 A[Catch:{ Exception -> 0x000c }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0020 A[Catch:{ Exception -> 0x000c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean setEmail(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 1
            r1 = 0
            if (r11 == 0) goto L_0x000f
            boolean r2 = kotlin.text.StringsKt.isBlank(r11)     // Catch:{ Exception -> 0x000c }
            if (r2 != r0) goto L_0x000f
            r2 = r0
            goto L_0x0010
        L_0x000c:
            r0 = move-exception
            goto L_0x0079
        L_0x000f:
            r2 = r1
        L_0x0010:
            if (r2 == 0) goto L_0x0020
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x000c }
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x000c }
            r6 = 0
            com.braze.BrazeUser$e0 r7 = com.braze.BrazeUser.e0.b     // Catch:{ Exception -> 0x000c }
            r8 = 2
            r9 = 0
            r4 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x000c }
            return r1
        L_0x0020:
            if (r11 == 0) goto L_0x0058
            int r2 = r11.length()     // Catch:{ Exception -> 0x000c }
            int r2 = r2 - r0
            r3 = r1
            r4 = r3
        L_0x0029:
            if (r3 > r2) goto L_0x004e
            if (r4 != 0) goto L_0x002f
            r5 = r3
            goto L_0x0030
        L_0x002f:
            r5 = r2
        L_0x0030:
            char r5 = r11.charAt(r5)     // Catch:{ Exception -> 0x000c }
            r6 = 32
            int r5 = kotlin.jvm.internal.Intrinsics.compare((int) r5, (int) r6)     // Catch:{ Exception -> 0x000c }
            if (r5 > 0) goto L_0x003e
            r5 = r0
            goto L_0x003f
        L_0x003e:
            r5 = r1
        L_0x003f:
            if (r4 != 0) goto L_0x0048
            if (r5 != 0) goto L_0x0045
            r4 = r0
            goto L_0x0029
        L_0x0045:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x0048:
            if (r5 != 0) goto L_0x004b
            goto L_0x004e
        L_0x004b:
            int r2 = r2 + -1
            goto L_0x0029
        L_0x004e:
            int r2 = r2 + r0
            java.lang.CharSequence r0 = r11.subSequence(r3, r2)     // Catch:{ Exception -> 0x000c }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x000c }
            goto L_0x0059
        L_0x0058:
            r0 = 0
        L_0x0059:
            if (r0 == 0) goto L_0x0072
            boolean r2 = com.braze.support.ValidationUtils.isValidEmailAddress(r0)     // Catch:{ Exception -> 0x000c }
            if (r2 == 0) goto L_0x0062
            goto L_0x0072
        L_0x0062:
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x000c }
            r5 = 0
            r6 = 0
            com.braze.BrazeUser$f0 r7 = new com.braze.BrazeUser$f0     // Catch:{ Exception -> 0x000c }
            r7.<init>(r11)     // Catch:{ Exception -> 0x000c }
            r8 = 3
            r9 = 0
            r4 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x000c }
            goto L_0x0078
        L_0x0072:
            bo.app.w6 r2 = r10.userCache     // Catch:{ Exception -> 0x000c }
            boolean r1 = r2.c(r0)     // Catch:{ Exception -> 0x000c }
        L_0x0078:
            return r1
        L_0x0079:
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.W
            com.braze.BrazeUser$g0 r4 = new com.braze.BrazeUser$g0
            r4.<init>(r11)
            r2.brazelog((java.lang.Object) r10, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r0, (kotlin.jvm.functions.Function0<java.lang.String>) r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.BrazeUser.setEmail(java.lang.String):boolean");
    }

    public final boolean setEmailNotificationSubscriptionType(NotificationSubscriptionType notificationSubscriptionType) {
        Intrinsics.checkNotNullParameter(notificationSubscriptionType, "emailNotificationSubscriptionType");
        try {
            this.userCache.a(notificationSubscriptionType);
            return true;
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new h0(notificationSubscriptionType));
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0011 A[Catch:{ Exception -> 0x000c }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f A[Catch:{ Exception -> 0x000c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean setFirstName(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 1
            r1 = 0
            if (r11 == 0) goto L_0x000e
            boolean r2 = kotlin.text.StringsKt.isBlank(r11)     // Catch:{ Exception -> 0x000c }
            if (r2 != r0) goto L_0x000e
            r2 = r0
            goto L_0x000f
        L_0x000c:
            r0 = move-exception
            goto L_0x0025
        L_0x000e:
            r2 = r1
        L_0x000f:
            if (r2 == 0) goto L_0x001f
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x000c }
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x000c }
            r6 = 0
            com.braze.BrazeUser$i0 r7 = com.braze.BrazeUser.i0.b     // Catch:{ Exception -> 0x000c }
            r8 = 2
            r9 = 0
            r4 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x000c }
            return r1
        L_0x001f:
            bo.app.w6 r2 = r10.userCache     // Catch:{ Exception -> 0x000c }
            r2.d(r11)     // Catch:{ Exception -> 0x000c }
            return r0
        L_0x0025:
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.W
            com.braze.BrazeUser$j0 r4 = new com.braze.BrazeUser$j0
            r4.<init>(r11)
            r2.brazelog((java.lang.Object) r10, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r0, (kotlin.jvm.functions.Function0<java.lang.String>) r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.BrazeUser.setFirstName(java.lang.String):boolean");
    }

    public final boolean setGender(Gender gender) {
        Intrinsics.checkNotNullParameter(gender, HintConstants.AUTOFILL_HINT_GENDER);
        try {
            this.userCache.a(gender);
            return true;
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new k0(gender));
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0011 A[Catch:{ Exception -> 0x000c }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f A[Catch:{ Exception -> 0x000c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean setHomeCity(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 1
            r1 = 0
            if (r11 == 0) goto L_0x000e
            boolean r2 = kotlin.text.StringsKt.isBlank(r11)     // Catch:{ Exception -> 0x000c }
            if (r2 != r0) goto L_0x000e
            r2 = r0
            goto L_0x000f
        L_0x000c:
            r0 = move-exception
            goto L_0x0025
        L_0x000e:
            r2 = r1
        L_0x000f:
            if (r2 == 0) goto L_0x001f
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x000c }
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x000c }
            r6 = 0
            com.braze.BrazeUser$l0 r7 = com.braze.BrazeUser.l0.b     // Catch:{ Exception -> 0x000c }
            r8 = 2
            r9 = 0
            r4 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x000c }
            return r1
        L_0x001f:
            bo.app.w6 r2 = r10.userCache     // Catch:{ Exception -> 0x000c }
            r2.e(r11)     // Catch:{ Exception -> 0x000c }
            return r0
        L_0x0025:
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.W
            com.braze.BrazeUser$m0 r4 = new com.braze.BrazeUser$m0
            r4.<init>(r11)
            r2.brazelog((java.lang.Object) r10, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r0, (kotlin.jvm.functions.Function0<java.lang.String>) r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.BrazeUser.setHomeCity(java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0011 A[Catch:{ Exception -> 0x000c }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f A[Catch:{ Exception -> 0x000c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean setLanguage(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 1
            r1 = 0
            if (r11 == 0) goto L_0x000e
            boolean r2 = kotlin.text.StringsKt.isBlank(r11)     // Catch:{ Exception -> 0x000c }
            if (r2 != r0) goto L_0x000e
            r2 = r0
            goto L_0x000f
        L_0x000c:
            r0 = move-exception
            goto L_0x0025
        L_0x000e:
            r2 = r1
        L_0x000f:
            if (r2 == 0) goto L_0x001f
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x000c }
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x000c }
            r6 = 0
            com.braze.BrazeUser$n0 r7 = com.braze.BrazeUser.n0.b     // Catch:{ Exception -> 0x000c }
            r8 = 2
            r9 = 0
            r4 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x000c }
            return r1
        L_0x001f:
            bo.app.w6 r2 = r10.userCache     // Catch:{ Exception -> 0x000c }
            r2.f(r11)     // Catch:{ Exception -> 0x000c }
            return r0
        L_0x0025:
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.W
            com.braze.BrazeUser$o0 r4 = new com.braze.BrazeUser$o0
            r4.<init>(r11)
            r2.brazelog((java.lang.Object) r10, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r0, (kotlin.jvm.functions.Function0<java.lang.String>) r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.BrazeUser.setLanguage(java.lang.String):boolean");
    }

    public final void setLastKnownLocation(double d2, double d3) {
        setLastKnownLocation$default(this, d2, d3, (Double) null, (Double) null, (Double) null, 28, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0011 A[Catch:{ Exception -> 0x000c }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f A[Catch:{ Exception -> 0x000c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean setLastName(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 1
            r1 = 0
            if (r11 == 0) goto L_0x000e
            boolean r2 = kotlin.text.StringsKt.isBlank(r11)     // Catch:{ Exception -> 0x000c }
            if (r2 != r0) goto L_0x000e
            r2 = r0
            goto L_0x000f
        L_0x000c:
            r0 = move-exception
            goto L_0x0025
        L_0x000e:
            r2 = r1
        L_0x000f:
            if (r2 == 0) goto L_0x001f
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x000c }
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x000c }
            r6 = 0
            com.braze.BrazeUser$q0 r7 = com.braze.BrazeUser.q0.b     // Catch:{ Exception -> 0x000c }
            r8 = 2
            r9 = 0
            r4 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x000c }
            return r1
        L_0x001f:
            bo.app.w6 r2 = r10.userCache     // Catch:{ Exception -> 0x000c }
            r2.g(r11)     // Catch:{ Exception -> 0x000c }
            return r0
        L_0x0025:
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.W
            com.braze.BrazeUser$r0 r4 = new com.braze.BrazeUser$r0
            r4.<init>(r11)
            r2.brazelog((java.lang.Object) r10, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r0, (kotlin.jvm.functions.Function0<java.lang.String>) r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.BrazeUser.setLastName(java.lang.String):boolean");
    }

    public final void setLocationCustomAttribute(String str, double d2, double d3) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            if (!com.braze.support.b.a(str, this.serverConfigStorageProvider.d())) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) s0.b, 2, (Object) null);
            } else if (!ValidationUtils.isValidLocation(d2, d3)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new t0(d2, d3), 2, (Object) null);
            } else {
                x1 a2 = bo.app.j.h.a(ValidationUtils.ensureBrazeFieldLength(str), d2, d3);
                if (a2 != null) {
                    this.brazeManager.a(a2);
                }
            }
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new u0(str, d2, d3));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0012 A[Catch:{ Exception -> 0x000c }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0020 A[Catch:{ Exception -> 0x000c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean setPhoneNumber(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 1
            r1 = 0
            if (r11 == 0) goto L_0x000f
            boolean r2 = kotlin.text.StringsKt.isBlank(r11)     // Catch:{ Exception -> 0x000c }
            if (r2 != r0) goto L_0x000f
            r2 = r0
            goto L_0x0010
        L_0x000c:
            r0 = move-exception
            goto L_0x007a
        L_0x000f:
            r2 = r1
        L_0x0010:
            if (r2 == 0) goto L_0x0020
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x000c }
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x000c }
            r6 = 0
            com.braze.BrazeUser$v0 r7 = com.braze.BrazeUser.v0.b     // Catch:{ Exception -> 0x000c }
            r8 = 2
            r9 = 0
            r4 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x000c }
            return r1
        L_0x0020:
            if (r11 == 0) goto L_0x0058
            int r2 = r11.length()     // Catch:{ Exception -> 0x000c }
            int r2 = r2 - r0
            r3 = r1
            r4 = r3
        L_0x0029:
            if (r3 > r2) goto L_0x004e
            if (r4 != 0) goto L_0x002f
            r5 = r3
            goto L_0x0030
        L_0x002f:
            r5 = r2
        L_0x0030:
            char r5 = r11.charAt(r5)     // Catch:{ Exception -> 0x000c }
            r6 = 32
            int r5 = kotlin.jvm.internal.Intrinsics.compare((int) r5, (int) r6)     // Catch:{ Exception -> 0x000c }
            if (r5 > 0) goto L_0x003e
            r5 = r0
            goto L_0x003f
        L_0x003e:
            r5 = r1
        L_0x003f:
            if (r4 != 0) goto L_0x0048
            if (r5 != 0) goto L_0x0045
            r4 = r0
            goto L_0x0029
        L_0x0045:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x0048:
            if (r5 != 0) goto L_0x004b
            goto L_0x004e
        L_0x004b:
            int r2 = r2 + -1
            goto L_0x0029
        L_0x004e:
            int r2 = r2 + r0
            java.lang.CharSequence r0 = r11.subSequence(r3, r2)     // Catch:{ Exception -> 0x000c }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x000c }
            goto L_0x0059
        L_0x0058:
            r0 = 0
        L_0x0059:
            if (r0 == 0) goto L_0x0073
            boolean r2 = com.braze.support.ValidationUtils.isValidPhoneNumber(r0)     // Catch:{ Exception -> 0x000c }
            if (r2 == 0) goto L_0x0062
            goto L_0x0073
        L_0x0062:
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x000c }
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x000c }
            r6 = 0
            com.braze.BrazeUser$w0 r7 = new com.braze.BrazeUser$w0     // Catch:{ Exception -> 0x000c }
            r7.<init>(r0)     // Catch:{ Exception -> 0x000c }
            r8 = 2
            r9 = 0
            r4 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x000c }
            return r1
        L_0x0073:
            bo.app.w6 r2 = r10.userCache     // Catch:{ Exception -> 0x000c }
            boolean r11 = r2.h(r0)     // Catch:{ Exception -> 0x000c }
            return r11
        L_0x007a:
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.W
            com.braze.BrazeUser$x0 r4 = new com.braze.BrazeUser$x0
            r4.<init>(r11)
            r2.brazelog((java.lang.Object) r10, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r0, (kotlin.jvm.functions.Function0<java.lang.String>) r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.BrazeUser.setPhoneNumber(java.lang.String):boolean");
    }

    public final boolean setPushNotificationSubscriptionType(NotificationSubscriptionType notificationSubscriptionType) {
        Intrinsics.checkNotNullParameter(notificationSubscriptionType, "pushNotificationSubscriptionType");
        try {
            this.userCache.b(notificationSubscriptionType);
            return true;
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new y0(notificationSubscriptionType));
            return false;
        }
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new d1(str), 2, (Object) null);
        ReentrantLock reentrantLock = this.userIdLock;
        reentrantLock.lock();
        try {
            if (!Intrinsics.areEqual((Object) this.internalUserId, (Object) "")) {
                if (!Intrinsics.areEqual((Object) this.internalUserId, (Object) str)) {
                    throw new IllegalArgumentException("setExternalId can not be used to change the external ID of a UserCache from a non-empty value to a new value. Was: [" + this.internalUserId + "], tried to change to: [" + str + ']');
                }
            }
            this.internalUserId = str;
            this.userCache.i(str);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean unsetCustomUserAttribute(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            if (com.braze.support.b.a(str, this.serverConfigStorageProvider.d())) {
                return this.userCache.j(str);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) z0.b, 2, (Object) null);
            return false;
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new a1(str));
            return false;
        }
    }

    public final void unsetLocationCustomAttribute(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            if (!com.braze.support.b.a(str, this.serverConfigStorageProvider.d())) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) b1.b, 2, (Object) null);
                return;
            }
            x1 k2 = bo.app.j.h.k(ValidationUtils.ensureBrazeFieldLength(str));
            if (k2 != null) {
                this.brazeManager.a(k2);
            }
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new c1(str));
        }
    }

    public final boolean incrementCustomUserAttribute(String str, int i2) {
        x1 a2;
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            if (com.braze.support.b.a(str, this.serverConfigStorageProvider.d()) && (a2 = bo.app.j.h.a(ValidationUtils.ensureBrazeFieldLength(str), i2)) != null) {
                return this.brazeManager.a(a2);
            }
            return false;
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new h(str, i2));
            return false;
        }
    }

    public final boolean setCustomAttribute(String str, Object obj, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        if (!com.braze.support.b.a(str, this.serverConfigStorageProvider.d())) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) p.b, 2, (Object) null);
            return false;
        }
        String ensureBrazeFieldLength = ValidationUtils.ensureBrazeFieldLength(str);
        Object a2 = com.braze.support.b.a(com.braze.support.b.a, obj, 0, 2, (Object) null);
        if (a2 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new q(str, obj), 2, (Object) null);
            return false;
        } else if (!(a2 instanceof JSONObject) || !z2) {
            return this.userCache.a(ensureBrazeFieldLength, a2);
        } else {
            x1 a3 = bo.app.j.h.a(ensureBrazeFieldLength, (JSONObject) a2);
            if (a3 != null) {
                return this.brazeManager.a(a3);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new r(ensureBrazeFieldLength, a2), 2, (Object) null);
            return false;
        }
    }

    public final boolean setCustomUserAttribute(String str, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return setCustomAttribute$default(this, str, Boolean.valueOf(z2), false, 4, (Object) null);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new t(str));
            return false;
        }
    }

    public final void setLastKnownLocation(double d2, double d3, Double d4) {
        setLastKnownLocation$default(this, d2, d3, d4, (Double) null, (Double) null, 24, (Object) null);
    }

    public final void setLastKnownLocation(double d2, double d3, Double d4, Double d5) {
        setLastKnownLocation$default(this, d2, d3, d4, d5, (Double) null, 16, (Object) null);
    }

    public final void setLastKnownLocation(double d2, double d3, Double d4, Double d5, Double d6) {
        try {
            this.locationManager.a(new BrazeLocation(d2, d3, d4, d5, d6));
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) p0.b);
        }
    }

    public final boolean setCustomUserAttribute(String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return setCustomAttribute$default(this, str, Integer.valueOf(i2), false, 4, (Object) null);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new u(str));
            return false;
        }
    }

    public final boolean setCustomUserAttribute(String str, float f2) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return setCustomAttribute$default(this, str, Float.valueOf(f2), false, 4, (Object) null);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new v(str));
            return false;
        }
    }

    public final boolean setCustomUserAttribute(String str, long j2) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return setCustomAttribute$default(this, str, Long.valueOf(j2), false, 4, (Object) null);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new w(str));
            return false;
        }
    }

    public final boolean setCustomUserAttribute(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        try {
            return setCustomAttribute$default(this, str, str2, false, 4, (Object) null);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new x(str));
            return false;
        }
    }

    public final boolean setCustomUserAttribute(String str, double d2) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return setCustomAttribute$default(this, str, Double.valueOf(d2), false, 4, (Object) null);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new y(str));
            return false;
        }
    }

    public final boolean setCustomUserAttribute(String str, JSONObject jSONObject, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(jSONObject, "value");
        try {
            return setCustomAttribute(str, jSONObject, z2);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new z(str, jSONObject));
            return false;
        }
    }

    public final boolean setCustomUserAttribute(String str, JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(jSONArray, "value");
        try {
            return setCustomAttribute$default(this, str, jSONArray, false, 4, (Object) null);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) new a0(str, jSONArray));
            return false;
        }
    }
}
