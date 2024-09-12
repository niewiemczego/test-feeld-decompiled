package com.braze.reactbridge;

import com.braze.models.FeatureFlag;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"FEATURE_FLAG_PROPERTIES_TYPE", "", "FEATURE_FLAG_PROPERTIES_TYPE_BOOLEAN", "FEATURE_FLAG_PROPERTIES_TYPE_NUMBER", "FEATURE_FLAG_PROPERTIES_TYPE_STRING", "FEATURE_FLAG_PROPERTIES_VALUE", "convertFeatureFlag", "Lcom/facebook/react/bridge/WritableMap;", "ff", "Lcom/braze/models/FeatureFlag;", "braze_react-native-sdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: FeatureFlagUtil.kt */
public final class FeatureFlagUtilKt {
    private static final String FEATURE_FLAG_PROPERTIES_TYPE = "type";
    public static final String FEATURE_FLAG_PROPERTIES_TYPE_BOOLEAN = "boolean";
    public static final String FEATURE_FLAG_PROPERTIES_TYPE_NUMBER = "number";
    public static final String FEATURE_FLAG_PROPERTIES_TYPE_STRING = "string";
    private static final String FEATURE_FLAG_PROPERTIES_VALUE = "value";

    public static final WritableMap convertFeatureFlag(FeatureFlag featureFlag) {
        Intrinsics.checkNotNullParameter(featureFlag, "ff");
        WritableMap createMap = Arguments.createMap();
        createMap.putString("id", featureFlag.getId());
        createMap.putBoolean("enabled", featureFlag.getEnabled());
        WritableMap createMap2 = Arguments.createMap();
        Iterator<String> keys = featureFlag.getProperties().keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = featureFlag.getProperties().optJSONObject(next);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("type", "");
                CharSequence charSequence = optString;
                if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                    WritableMap createMap3 = Arguments.createMap();
                    createMap3.putString("type", optString);
                    Intrinsics.checkNotNullExpressionValue(optString, "type");
                    int hashCode = optString.hashCode();
                    if (hashCode != -1034364087) {
                        if (hashCode != -891985903) {
                            if (hashCode == 64711720 && optString.equals("boolean")) {
                                Intrinsics.checkNotNullExpressionValue(next, "key");
                                Boolean booleanProperty = featureFlag.getBooleanProperty(next);
                                if (booleanProperty != null) {
                                    createMap3.putBoolean("value", booleanProperty.booleanValue());
                                }
                            }
                        } else if (optString.equals("string")) {
                            Intrinsics.checkNotNullExpressionValue(next, "key");
                            createMap3.putString("value", featureFlag.getStringProperty(next));
                        }
                    } else if (optString.equals("number")) {
                        Intrinsics.checkNotNullExpressionValue(next, "key");
                        Number numberProperty = featureFlag.getNumberProperty(next);
                        if (numberProperty != null) {
                            createMap3.putDouble("value", numberProperty.doubleValue());
                        }
                    }
                    createMap2.putMap(next, createMap3);
                }
            }
        }
        createMap.putMap(FeatureFlag.PROPERTIES, createMap2);
        Intrinsics.checkNotNullExpressionValue(createMap, "mappedFF");
        return createMap;
    }
}
