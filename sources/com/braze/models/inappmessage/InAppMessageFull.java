package com.braze.models.inappmessage;

import bo.app.z1;
import com.braze.enums.inappmessage.CropType;
import com.braze.enums.inappmessage.MessageType;
import com.braze.support.c;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/braze/models/inappmessage/InAppMessageFull;", "Lcom/braze/models/inappmessage/InAppMessageImmersiveBase;", "Lorg/json/JSONObject;", "forJsonPut", "Lcom/braze/enums/inappmessage/MessageType;", "getMessageType", "()Lcom/braze/enums/inappmessage/MessageType;", "messageType", "<init>", "()V", "jsonObject", "Lbo/app/z1;", "brazeManager", "(Lorg/json/JSONObject;Lbo/app/z1;)V", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public class InAppMessageFull extends InAppMessageImmersiveBase {
    public InAppMessageFull() {
        setCropType(CropType.CENTER_CROP);
    }

    public MessageType getMessageType() {
        return MessageType.FULL;
    }

    public JSONObject forJsonPut() {
        JSONObject jsonObject = getJsonObject();
        if (jsonObject != null) {
            return jsonObject;
        }
        JSONObject forJsonPut = super.forJsonPut();
        try {
            forJsonPut.put("type", (Object) getMessageType().name());
        } catch (JSONException unused) {
        }
        return forJsonPut;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InAppMessageFull(JSONObject jSONObject, z1 z1Var) {
        super(jSONObject, z1Var);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        CropType cropType = CropType.CENTER_CROP;
        try {
            c cVar = c.a;
            String string = jSONObject.getString(InAppMessageBase.CROP_TYPE);
            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            String upperCase = string.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            for (CropType cropType2 : CropType.values()) {
                if (Intrinsics.areEqual((Object) cropType2.name(), (Object) upperCase)) {
                    if (cropType2 != null) {
                        cropType = cropType2;
                    }
                    setCropType(cropType);
                    return;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (Exception unused) {
        }
    }
}
