package com.facebook.appevents.codeless.internal;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.adapty.internal.utils.AnalyticsEventTypeAdapter;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.dynamiclinks.DynamicLink;
import io.sentry.protocol.App;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 \"2\u00020\u0001:\u0003!\"#BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\n8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8F¢\u0006\u0006\u001a\u0004\b \u0010\u001e¨\u0006$"}, d2 = {"Lcom/facebook/appevents/codeless/internal/EventBinding;", "", "eventName", "", "method", "Lcom/facebook/appevents/codeless/internal/EventBinding$MappingMethod;", "type", "Lcom/facebook/appevents/codeless/internal/EventBinding$ActionType;", "appVersion", "path", "", "Lcom/facebook/appevents/codeless/internal/PathComponent;", "parameters", "Lcom/facebook/appevents/codeless/internal/ParameterComponent;", "componentId", "pathType", "activityName", "(Ljava/lang/String;Lcom/facebook/appevents/codeless/internal/EventBinding$MappingMethod;Lcom/facebook/appevents/codeless/internal/EventBinding$ActionType;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityName", "()Ljava/lang/String;", "getAppVersion", "getComponentId", "getEventName", "getMethod", "()Lcom/facebook/appevents/codeless/internal/EventBinding$MappingMethod;", "getPathType", "getType", "()Lcom/facebook/appevents/codeless/internal/EventBinding$ActionType;", "viewParameters", "getViewParameters", "()Ljava/util/List;", "viewPath", "getViewPath", "ActionType", "Companion", "MappingMethod", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: EventBinding.kt */
public final class EventBinding {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String activityName;
    private final String appVersion;
    private final String componentId;
    private final String eventName;
    private final MappingMethod method;
    private final List<ParameterComponent> parameters;
    private final List<PathComponent> path;
    private final String pathType;
    private final ActionType type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/appevents/codeless/internal/EventBinding$ActionType;", "", "(Ljava/lang/String;I)V", "CLICK", "SELECTED", "TEXT_CHANGED", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: EventBinding.kt */
    public enum ActionType {
        CLICK,
        SELECTED,
        TEXT_CHANGED
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/codeless/internal/EventBinding$MappingMethod;", "", "(Ljava/lang/String;I)V", "MANUAL", "INFERENCE", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: EventBinding.kt */
    public enum MappingMethod {
        MANUAL,
        INFERENCE
    }

    @JvmStatic
    public static final EventBinding getInstanceFromJson(JSONObject jSONObject) throws JSONException, IllegalArgumentException {
        return Companion.getInstanceFromJson(jSONObject);
    }

    @JvmStatic
    public static final List<EventBinding> parseArray(JSONArray jSONArray) {
        return Companion.parseArray(jSONArray);
    }

    public EventBinding(String str, MappingMethod mappingMethod, ActionType actionType, String str2, List<PathComponent> list, List<ParameterComponent> list2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(mappingMethod, "method");
        Intrinsics.checkNotNullParameter(actionType, "type");
        Intrinsics.checkNotNullParameter(str2, "appVersion");
        Intrinsics.checkNotNullParameter(list, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        Intrinsics.checkNotNullParameter(list2, DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
        Intrinsics.checkNotNullParameter(str3, "componentId");
        Intrinsics.checkNotNullParameter(str4, "pathType");
        Intrinsics.checkNotNullParameter(str5, "activityName");
        this.eventName = str;
        this.method = mappingMethod;
        this.type = actionType;
        this.appVersion = str2;
        this.path = list;
        this.parameters = list2;
        this.componentId = str3;
        this.pathType = str4;
        this.activityName = str5;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final MappingMethod getMethod() {
        return this.method;
    }

    public final ActionType getType() {
        return this.type;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final String getPathType() {
        return this.pathType;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final List<PathComponent> getViewPath() {
        List<PathComponent> unmodifiableList = Collections.unmodifiableList(this.path);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(path)");
        return unmodifiableList;
    }

    public final List<ParameterComponent> getViewParameters() {
        List<ParameterComponent> unmodifiableList = Collections.unmodifiableList(this.parameters);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(parameters)");
        return unmodifiableList;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/facebook/appevents/codeless/internal/EventBinding$Companion;", "", "()V", "getInstanceFromJson", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "mapping", "Lorg/json/JSONObject;", "parseArray", "", "array", "Lorg/json/JSONArray;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: EventBinding.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final List<EventBinding> parseArray(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                int i = 0;
                try {
                    int length = jSONArray.length();
                    if (length > 0) {
                        while (true) {
                            int i2 = i + 1;
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            Intrinsics.checkNotNullExpressionValue(jSONObject, "array.getJSONObject(i)");
                            arrayList.add(getInstanceFromJson(jSONObject));
                            if (i2 >= length) {
                                break;
                            }
                            i = i2;
                        }
                    }
                } catch (IllegalArgumentException | JSONException unused) {
                }
            }
            return arrayList;
        }

        @JvmStatic
        public final EventBinding getInstanceFromJson(JSONObject jSONObject) throws JSONException, IllegalArgumentException {
            int length;
            Intrinsics.checkNotNullParameter(jSONObject, "mapping");
            String string = jSONObject.getString(AnalyticsEventTypeAdapter.EVENT_NAME);
            String string2 = jSONObject.getString("method");
            Intrinsics.checkNotNullExpressionValue(string2, "mapping.getString(\"method\")");
            Locale locale = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
            String upperCase = string2.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            MappingMethod valueOf = MappingMethod.valueOf(upperCase);
            String string3 = jSONObject.getString("event_type");
            Intrinsics.checkNotNullExpressionValue(string3, "mapping.getString(\"event_type\")");
            Locale locale2 = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(locale2, ViewHierarchyConstants.ENGLISH);
            String upperCase2 = string3.toUpperCase(locale2);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "(this as java.lang.String).toUpperCase(locale)");
            ActionType valueOf2 = ActionType.valueOf(upperCase2);
            String string4 = jSONObject.getString(App.JsonKeys.APP_VERSION);
            JSONArray jSONArray = jSONObject.getJSONArray(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
            ArrayList arrayList = new ArrayList();
            int length2 = jSONArray.length();
            int i = 0;
            if (length2 > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonPath");
                    arrayList.add(new PathComponent(jSONObject2));
                    if (i3 >= length2) {
                        break;
                    }
                    i2 = i3;
                }
            }
            String optString = jSONObject.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, Constants.PATH_TYPE_ABSOLUTE);
            JSONArray optJSONArray = jSONObject.optJSONArray(DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
            ArrayList arrayList2 = new ArrayList();
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                while (true) {
                    int i4 = i + 1;
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonParameter");
                    arrayList2.add(new ParameterComponent(jSONObject3));
                    if (i4 >= length) {
                        break;
                    }
                    i = i4;
                }
            }
            String optString2 = jSONObject.optString("component_id");
            String optString3 = jSONObject.optString("activity_name");
            Intrinsics.checkNotNullExpressionValue(string, "eventName");
            Intrinsics.checkNotNullExpressionValue(string4, "appVersion");
            Intrinsics.checkNotNullExpressionValue(optString2, "componentId");
            Intrinsics.checkNotNullExpressionValue(optString, "pathType");
            Intrinsics.checkNotNullExpressionValue(optString3, "activityName");
            return new EventBinding(string, valueOf, valueOf2, string4, arrayList, arrayList2, optString2, optString, optString3);
        }
    }
}
