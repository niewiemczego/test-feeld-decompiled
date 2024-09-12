package com.facebook.appevents;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import com.facebook.FacebookSdk;
import com.facebook.appevents.aam.MetadataRule;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0007J\b\u0010\"\u001a\u00020\u0004H\u0007J\r\u0010#\u001a\u00020\u0004H\u0001¢\u0006\u0002\b$J\b\u0010%\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020!H\u0007J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0004H\u0002J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0002J\u001c\u0010,\u001a\u00020!2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0016H\u0007J\u0012\u0010.\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010/H\u0007Jl\u0010.\u001a\u00020!2\b\u00100\u001a\u0004\u0018\u00010\u00042\b\u00101\u001a\u0004\u0018\u00010\u00042\b\u00102\u001a\u0004\u0018\u00010\u00042\b\u00103\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u00010\u00042\b\u00106\u001a\u0004\u0018\u00010\u00042\b\u00107\u001a\u0004\u0018\u00010\u00042\b\u00108\u001a\u0004\u0018\u00010\u00042\b\u00109\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010:\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010/H\u0002J\u0018\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0012*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/facebook/appevents/UserDataStore;", "", "()V", "CITY", "", "COUNTRY", "DATA_SEPARATOR", "DATE_OF_BIRTH", "EMAIL", "FIRST_NAME", "GENDER", "INTERNAL_USER_DATA_KEY", "LAST_NAME", "MAX_NUM", "", "PHONE", "STATE", "TAG", "kotlin.jvm.PlatformType", "USER_DATA_KEY", "ZIP", "enabledInternalUserData", "", "getEnabledInternalUserData", "()Ljava/util/Map;", "externalHashedUserData", "Ljava/util/concurrent/ConcurrentHashMap;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "internalHashedUserData", "sharedPreferences", "Landroid/content/SharedPreferences;", "clear", "", "getAllHashedUserData", "getHashedUserData", "getHashedUserData$facebook_core_release", "initAndWait", "initStore", "maybeSHA256Hashed", "", "data", "normalizeData", "type", "setInternalUd", "ud", "setUserDataAndHash", "Landroid/os/Bundle;", "email", "firstName", "lastName", "phone", "dateOfBirth", "gender", "city", "state", "zip", "country", "updateHashUserData", "writeDataIntoCache", "key", "value", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: UserDataStore.kt */
public final class UserDataStore {
    public static final String CITY = "ct";
    public static final String COUNTRY = "country";
    private static final String DATA_SEPARATOR = ",";
    public static final String DATE_OF_BIRTH = "db";
    public static final String EMAIL = "em";
    public static final String FIRST_NAME = "fn";
    public static final String GENDER = "ge";
    public static final UserDataStore INSTANCE = new UserDataStore();
    private static final String INTERNAL_USER_DATA_KEY = "com.facebook.appevents.UserDataStore.internalUserData";
    public static final String LAST_NAME = "ln";
    private static final int MAX_NUM = 5;
    public static final String PHONE = "ph";
    public static final String STATE = "st";
    private static final String TAG = "UserDataStore";
    private static final String USER_DATA_KEY = "com.facebook.appevents.UserDataStore.userData";
    public static final String ZIP = "zp";
    private static final ConcurrentHashMap<String, String> externalHashedUserData = new ConcurrentHashMap<>();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static final ConcurrentHashMap<String, String> internalHashedUserData = new ConcurrentHashMap<>();
    private static SharedPreferences sharedPreferences;

    private UserDataStore() {
    }

    @JvmStatic
    public static final void initStore() {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!initialized.get()) {
                    INSTANCE.initAndWait();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final void writeDataIntoCache(String str, String str2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute(new UserDataStore$$ExternalSyntheticLambda2(str, str2));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: writeDataIntoCache$lambda-0  reason: not valid java name */
    public static final void m244writeDataIntoCache$lambda0(String str, String str2) {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(str, "$key");
                Intrinsics.checkNotNullParameter(str2, "$value");
                if (!initialized.get()) {
                    INSTANCE.initAndWait();
                }
                SharedPreferences sharedPreferences2 = sharedPreferences;
                if (sharedPreferences2 != null) {
                    sharedPreferences2.edit().putString(str, str2).apply();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    throw null;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final void setUserDataAndHash(Bundle bundle) {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new UserDataStore$$ExternalSyntheticLambda0(bundle));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setUserDataAndHash$lambda-1  reason: not valid java name */
    public static final void m243setUserDataAndHash$lambda1(Bundle bundle) {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!initialized.get()) {
                    Log.w(TAG, "initStore should have been called before calling setUserData");
                    INSTANCE.initAndWait();
                }
                UserDataStore userDataStore = INSTANCE;
                userDataStore.updateHashUserData(bundle);
                Utility utility = Utility.INSTANCE;
                userDataStore.writeDataIntoCache(USER_DATA_KEY, Utility.mapToJsonStr(externalHashedUserData));
                Utility utility2 = Utility.INSTANCE;
                userDataStore.writeDataIntoCache(INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(internalHashedUserData));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final void setUserDataAndHash(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Bundle bundle = new Bundle();
                if (str != null) {
                    bundle.putString(EMAIL, str);
                }
                if (str2 != null) {
                    bundle.putString(FIRST_NAME, str2);
                }
                if (str3 != null) {
                    bundle.putString(LAST_NAME, str3);
                }
                if (str4 != null) {
                    bundle.putString(PHONE, str4);
                }
                if (str5 != null) {
                    bundle.putString(DATE_OF_BIRTH, str5);
                }
                if (str6 != null) {
                    bundle.putString(GENDER, str6);
                }
                if (str7 != null) {
                    bundle.putString("ct", str7);
                }
                if (str8 != null) {
                    bundle.putString("st", str8);
                }
                if (str9 != null) {
                    bundle.putString(ZIP, str9);
                }
                if (str10 != null) {
                    bundle.putString(COUNTRY, str10);
                }
                setUserDataAndHash(bundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final void clear() {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new UserDataStore$$ExternalSyntheticLambda1());
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: clear$lambda-2  reason: not valid java name */
    public static final void m242clear$lambda2() {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!initialized.get()) {
                    Log.w(TAG, "initStore should have been called before calling setUserData");
                    INSTANCE.initAndWait();
                }
                externalHashedUserData.clear();
                SharedPreferences sharedPreferences2 = sharedPreferences;
                if (sharedPreferences2 != null) {
                    sharedPreferences2.edit().putString(USER_DATA_KEY, (String) null).apply();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    throw null;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final String getHashedUserData$facebook_core_release() {
        Class<UserDataStore> cls = UserDataStore.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (!initialized.get()) {
                Log.w(TAG, "initStore should have been called before calling setUserID");
                INSTANCE.initAndWait();
            }
            Utility utility = Utility.INSTANCE;
            return Utility.mapToJsonStr(externalHashedUserData);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final String getAllHashedUserData() {
        Class<UserDataStore> cls = UserDataStore.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (!initialized.get()) {
                INSTANCE.initAndWait();
            }
            Map hashMap = new HashMap();
            hashMap.putAll(externalHashedUserData);
            hashMap.putAll(INSTANCE.getEnabledInternalUserData());
            Utility utility = Utility.INSTANCE;
            return Utility.mapToJsonStr(hashMap);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private final Map<String, String> getEnabledInternalUserData() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Map<String, String> hashMap = new HashMap<>();
            Set<String> enabledRuleNames = MetadataRule.Companion.getEnabledRuleNames();
            for (String next : internalHashedUserData.keySet()) {
                if (enabledRuleNames.contains(next)) {
                    hashMap.put(next, internalHashedUserData.get(next));
                }
            }
            return hashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final synchronized void initAndWait() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                AtomicBoolean atomicBoolean = initialized;
                if (!atomicBoolean.get()) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
                    Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(FacebookSdk.getApplicationContext())");
                    sharedPreferences = defaultSharedPreferences;
                    if (defaultSharedPreferences != null) {
                        String string = defaultSharedPreferences.getString(USER_DATA_KEY, "");
                        if (string == null) {
                            string = "";
                        }
                        SharedPreferences sharedPreferences2 = sharedPreferences;
                        if (sharedPreferences2 != null) {
                            String string2 = sharedPreferences2.getString(INTERNAL_USER_DATA_KEY, "");
                            if (string2 == null) {
                                string2 = "";
                            }
                            ConcurrentHashMap<String, String> concurrentHashMap = externalHashedUserData;
                            Utility utility = Utility.INSTANCE;
                            concurrentHashMap.putAll(Utility.jsonStrToMap(string));
                            ConcurrentHashMap<String, String> concurrentHashMap2 = internalHashedUserData;
                            Utility utility2 = Utility.INSTANCE;
                            concurrentHashMap2.putAll(Utility.jsonStrToMap(string2));
                            atomicBoolean.set(true);
                            return;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    throw null;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void updateHashUserData(Bundle bundle) {
        if (!CrashShieldHandler.isObjectCrashing(this) && bundle != null) {
            try {
                for (String str : bundle.keySet()) {
                    Object obj = bundle.get(str);
                    if (obj != null) {
                        String obj2 = obj.toString();
                        if (maybeSHA256Hashed(obj2)) {
                            Map map = externalHashedUserData;
                            if (obj2 != null) {
                                String lowerCase = obj2.toLowerCase();
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                                map.put(str, lowerCase);
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            Utility utility = Utility.INSTANCE;
                            Intrinsics.checkNotNullExpressionValue(str, "key");
                            String sha256hash = Utility.sha256hash(normalizeData(str, obj2));
                            if (sha256hash != null) {
                                externalHashedUserData.put(str, sha256hash);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    @JvmStatic
    public static final void setInternalUd(Map<String, String> map) {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(map, "ud");
                if (!initialized.get()) {
                    INSTANCE.initAndWait();
                }
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    Utility utility = Utility.INSTANCE;
                    UserDataStore userDataStore = INSTANCE;
                    CharSequence charSequence = (String) next.getValue();
                    int i = 1;
                    int length = charSequence.length() - 1;
                    int i2 = 0;
                    boolean z = false;
                    while (true) {
                        if (i2 > length) {
                            break;
                        }
                        boolean z2 = Intrinsics.compare((int) charSequence.charAt(!z ? i2 : length), 32) <= 0;
                        if (!z) {
                            if (!z2) {
                                z = true;
                            } else {
                                i2++;
                            }
                        } else if (!z2) {
                            break;
                        } else {
                            length--;
                        }
                    }
                    String sha256hash = Utility.sha256hash(userDataStore.normalizeData(str, charSequence.subSequence(i2, length + 1).toString()));
                    ConcurrentHashMap<String, String> concurrentHashMap = internalHashedUserData;
                    if (concurrentHashMap.containsKey(str)) {
                        String str2 = concurrentHashMap.get(str);
                        String[] strArr = null;
                        if (str2 != null) {
                            List<String> split = new Regex(DATA_SEPARATOR).split(str2, 0);
                            if (split != null) {
                                Object[] array = split.toArray(new String[0]);
                                if (array != null) {
                                    strArr = (String[]) array;
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                            }
                        }
                        if (strArr == null) {
                            strArr = new String[0];
                        }
                        Set mutableSetOf = SetsKt.mutableSetOf(Arrays.copyOf(strArr, strArr.length));
                        if (!mutableSetOf.contains(sha256hash)) {
                            StringBuilder sb = new StringBuilder();
                            if (strArr.length == 0) {
                                sb.append(sha256hash);
                            } else if (strArr.length < 5) {
                                sb.append(str2).append(DATA_SEPARATOR).append(sha256hash);
                            } else {
                                while (true) {
                                    int i3 = i + 1;
                                    sb.append(strArr[i]).append(DATA_SEPARATOR);
                                    if (i3 >= 5) {
                                        break;
                                    }
                                    i = i3;
                                }
                                sb.append(sha256hash);
                                mutableSetOf.remove(strArr[0]);
                            }
                            internalHashedUserData.put(str, sb.toString());
                        } else {
                            return;
                        }
                    } else {
                        concurrentHashMap.put(str, sha256hash);
                    }
                }
                UserDataStore userDataStore2 = INSTANCE;
                Utility utility2 = Utility.INSTANCE;
                userDataStore2.writeDataIntoCache(INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(internalHashedUserData));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final boolean maybeSHA256Hashed(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return new Regex("[A-Fa-f0-9]{64}").matches(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final String normalizeData(String str, String str2) {
        String str3;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            CharSequence charSequence = str2;
            int length = charSequence.length() - 1;
            int i = 0;
            boolean z = false;
            while (true) {
                if (i > length) {
                    break;
                }
                boolean z2 = Intrinsics.compare((int) charSequence.charAt(!z ? i : length), 32) <= 0;
                if (!z) {
                    if (!z2) {
                        z = true;
                    } else {
                        i++;
                    }
                } else if (!z2) {
                    break;
                } else {
                    length--;
                }
            }
            String obj = charSequence.subSequence(i, length + 1).toString();
            if (obj != null) {
                String lowerCase = obj.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                if (Intrinsics.areEqual((Object) EMAIL, (Object) str)) {
                    if (Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                        return lowerCase;
                    }
                    Log.e(TAG, "Setting email failure: this is not a valid email address");
                    return "";
                } else if (Intrinsics.areEqual((Object) PHONE, (Object) str)) {
                    return new Regex("[^0-9]").replace((CharSequence) lowerCase, "");
                } else if (!Intrinsics.areEqual((Object) GENDER, (Object) str)) {
                    return lowerCase;
                } else {
                    if (!(lowerCase.length() > 0)) {
                        str3 = "";
                    } else if (lowerCase != null) {
                        str3 = lowerCase.substring(0, 1);
                        Intrinsics.checkNotNullExpressionValue(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    if (!Intrinsics.areEqual((Object) "f", (Object) str3)) {
                        if (!Intrinsics.areEqual((Object) "m", (Object) str3)) {
                            Log.e(TAG, "Setting gender failure: the supported value for gender is f or m");
                            return "";
                        }
                    }
                    return str3;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
