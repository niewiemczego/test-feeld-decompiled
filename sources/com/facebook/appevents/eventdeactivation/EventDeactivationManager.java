package com.facebook.appevents.eventdeactivation;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0002J&\u0010\u000e\u001a\u00020\f2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J\u0016\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/appevents/eventdeactivation/EventDeactivationManager;", "", "()V", "deprecatedEvents", "", "", "deprecatedParamFilters", "", "Lcom/facebook/appevents/eventdeactivation/EventDeactivationManager$DeprecatedParamFilter;", "enabled", "", "enable", "", "initialize", "processDeprecatedParameters", "parameters", "", "eventName", "processEvents", "events", "Lcom/facebook/appevents/AppEvent;", "DeprecatedParamFilter", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: EventDeactivationManager.kt */
public final class EventDeactivationManager {
    public static final EventDeactivationManager INSTANCE = new EventDeactivationManager();
    private static final Set<String> deprecatedEvents = new HashSet();
    private static final List<DeprecatedParamFilter> deprecatedParamFilters = new ArrayList();
    private static boolean enabled;

    private EventDeactivationManager() {
    }

    @JvmStatic
    public static final void enable() {
        Class<EventDeactivationManager> cls = EventDeactivationManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                EventDeactivationManager eventDeactivationManager = INSTANCE;
                enabled = true;
                eventDeactivationManager.initialize();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final synchronized void initialize() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                boolean z = false;
                FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if (queryAppSettings != null) {
                    String restrictiveDataSetting = queryAppSettings.getRestrictiveDataSetting();
                    if (restrictiveDataSetting != null) {
                        if (restrictiveDataSetting.length() > 0) {
                            z = true;
                        }
                        if (z) {
                            JSONObject jSONObject = new JSONObject(restrictiveDataSetting);
                            deprecatedParamFilters.clear();
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                                if (jSONObject2 != null) {
                                    if (jSONObject2.optBoolean("is_deprecated_event")) {
                                        Set<String> set = deprecatedEvents;
                                        Intrinsics.checkNotNullExpressionValue(next, "key");
                                        set.add(next);
                                    } else {
                                        JSONArray optJSONArray = jSONObject2.optJSONArray("deprecated_param");
                                        Intrinsics.checkNotNullExpressionValue(next, "key");
                                        DeprecatedParamFilter deprecatedParamFilter = new DeprecatedParamFilter(next, new ArrayList());
                                        if (optJSONArray != null) {
                                            Utility utility = Utility.INSTANCE;
                                            deprecatedParamFilter.setDeprecateParams(Utility.convertJSONArrayToList(optJSONArray));
                                        }
                                        deprecatedParamFilters.add(deprecatedParamFilter);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    @JvmStatic
    public static final void processEvents(List<AppEvent> list) {
        Class<EventDeactivationManager> cls = EventDeactivationManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(list, "events");
                if (enabled) {
                    Iterator<AppEvent> it = list.iterator();
                    while (it.hasNext()) {
                        if (deprecatedEvents.contains(it.next().getName())) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final void processDeprecatedParameters(Map<String, String> map, String str) {
        Class<EventDeactivationManager> cls = EventDeactivationManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(map, DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
                Intrinsics.checkNotNullParameter(str, "eventName");
                if (enabled) {
                    List<String> arrayList = new ArrayList<>(map.keySet());
                    for (DeprecatedParamFilter deprecatedParamFilter : new ArrayList(deprecatedParamFilters)) {
                        if (Intrinsics.areEqual((Object) deprecatedParamFilter.getEventName(), (Object) str)) {
                            for (String str2 : arrayList) {
                                if (deprecatedParamFilter.getDeprecateParams().contains(str2)) {
                                    map.remove(str2);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/facebook/appevents/eventdeactivation/EventDeactivationManager$DeprecatedParamFilter;", "", "eventName", "", "deprecateParams", "", "(Ljava/lang/String;Ljava/util/List;)V", "getDeprecateParams", "()Ljava/util/List;", "setDeprecateParams", "(Ljava/util/List;)V", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: EventDeactivationManager.kt */
    public static final class DeprecatedParamFilter {
        private List<String> deprecateParams;
        private String eventName;

        public DeprecatedParamFilter(String str, List<String> list) {
            Intrinsics.checkNotNullParameter(str, "eventName");
            Intrinsics.checkNotNullParameter(list, "deprecateParams");
            this.eventName = str;
            this.deprecateParams = list;
        }

        public final List<String> getDeprecateParams() {
            return this.deprecateParams;
        }

        public final String getEventName() {
            return this.eventName;
        }

        public final void setDeprecateParams(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.deprecateParams = list;
        }

        public final void setEventName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.eventName = str;
        }
    }
}
