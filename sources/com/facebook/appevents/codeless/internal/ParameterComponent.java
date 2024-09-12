package com.facebook.appevents.codeless.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/codeless/internal/ParameterComponent;", "", "component", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "name", "", "getName", "()Ljava/lang/String;", "path", "", "Lcom/facebook/appevents/codeless/internal/PathComponent;", "getPath", "()Ljava/util/List;", "pathType", "getPathType", "value", "getValue", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ParameterComponent.kt */
public final class ParameterComponent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PARAMETER_NAME_KEY = "name";
    private static final String PARAMETER_PATH_KEY = "path";
    private static final String PARAMETER_VALUE_KEY = "value";
    private final String name;
    private final List<PathComponent> path;
    private final String pathType;
    private final String value;

    public ParameterComponent(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "component");
        String string = jSONObject.getString("name");
        Intrinsics.checkNotNullExpressionValue(string, "component.getString(PARAMETER_NAME_KEY)");
        this.name = string;
        String optString = jSONObject.optString("value");
        Intrinsics.checkNotNullExpressionValue(optString, "component.optString(PARAMETER_VALUE_KEY)");
        this.value = optString;
        String optString2 = jSONObject.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, Constants.PATH_TYPE_ABSOLUTE);
        Intrinsics.checkNotNullExpressionValue(optString2, "component.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, Constants.PATH_TYPE_ABSOLUTE)");
        this.pathType = optString2;
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("path");
        if (optJSONArray != null) {
            int i = 0;
            int length = optJSONArray.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonPathArray.getJSONObject(i)");
                    arrayList.add(new PathComponent(jSONObject2));
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
        }
        this.path = arrayList;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public final List<PathComponent> getPath() {
        return this.path;
    }

    public final String getPathType() {
        return this.pathType;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/codeless/internal/ParameterComponent$Companion;", "", "()V", "PARAMETER_NAME_KEY", "", "PARAMETER_PATH_KEY", "PARAMETER_VALUE_KEY", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ParameterComponent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
