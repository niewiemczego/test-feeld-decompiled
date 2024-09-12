package com.launchdarkly.sdk.android;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.launchdarkly.sdk.android.LDFailure;
import java.lang.reflect.Type;

class LDFailureSerialization implements JsonSerializer<LDFailure>, JsonDeserializer<LDFailure> {
    LDFailureSerialization() {
    }

    public LDFailure deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        LDFailure.FailureType failureType = (LDFailure.FailureType) jsonDeserializationContext.deserialize(asJsonObject.get("failureType"), LDFailure.FailureType.class);
        String asString = asJsonObject.getAsJsonPrimitive("message").getAsString();
        if (failureType == LDFailure.FailureType.UNEXPECTED_RESPONSE_CODE) {
            return new LDInvalidResponseCodeFailure(asString, asJsonObject.getAsJsonPrimitive("responseCode").getAsInt(), asJsonObject.getAsJsonPrimitive("retryable").getAsBoolean());
        }
        return new LDFailure(asString, failureType);
    }

    public JsonElement serialize(LDFailure lDFailure, Type type, JsonSerializationContext jsonSerializationContext) {
        if (lDFailure == null) {
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("failureType", jsonSerializationContext.serialize(lDFailure.getFailureType()));
        jsonObject.addProperty("message", lDFailure.getMessage());
        if (lDFailure instanceof LDInvalidResponseCodeFailure) {
            LDInvalidResponseCodeFailure lDInvalidResponseCodeFailure = (LDInvalidResponseCodeFailure) lDFailure;
            jsonObject.addProperty("responseCode", (Number) Integer.valueOf(lDInvalidResponseCodeFailure.getResponseCode()));
            jsonObject.addProperty("retryable", Boolean.valueOf(lDInvalidResponseCodeFailure.isRetryable()));
        }
        return jsonObject;
    }
}
