package com.launchdarkly.sdk;

import com.adapty.internal.crossplatform.AdaptyUIActionTypeAdapterFactory;
import com.facebook.appevents.UserDataStore;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.launchdarkly.sdk.LDUser;
import java.io.IOException;

final class LDUserTypeAdapter extends TypeAdapter<LDUser> {
    static final LDUserTypeAdapter INSTANCE = new LDUserTypeAdapter();

    LDUserTypeAdapter() {
    }

    public LDUser read(JsonReader jsonReader) throws IOException {
        String str = null;
        LDUser.Builder builder = new LDUser.Builder((String) null);
        jsonReader.beginObject();
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -2095811475:
                    if (nextName.equals("anonymous")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1459599807:
                    if (nextName.equals("lastName")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1405959847:
                    if (nextName.equals("avatar")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1349088399:
                    if (nextName.equals(AdaptyUIActionTypeAdapterFactory.TYPE_CUSTOM)) {
                        c = 3;
                        break;
                    }
                    break;
                case 3367:
                    if (nextName.equals("ip")) {
                        c = 4;
                        break;
                    }
                    break;
                case 106079:
                    if (nextName.equals("key")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals("name")) {
                        c = 6;
                        break;
                    }
                    break;
                case 96619420:
                    if (nextName.equals("email")) {
                        c = 7;
                        break;
                    }
                    break;
                case 132835675:
                    if (nextName.equals("firstName")) {
                        c = 8;
                        break;
                    }
                    break;
                case 663359087:
                    if (nextName.equals("privateAttributeNames")) {
                        c = 9;
                        break;
                    }
                    break;
                case 957831062:
                    if (nextName.equals(UserDataStore.COUNTRY)) {
                        c = 10;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (jsonReader.peek() != JsonToken.NULL) {
                        builder.anonymous(jsonReader.nextBoolean());
                        break;
                    } else {
                        jsonReader.nextNull();
                        break;
                    }
                case 1:
                    builder.lastName(Helpers.readNullableString(jsonReader));
                    break;
                case 2:
                    builder.avatar(Helpers.readNullableString(jsonReader));
                    break;
                case 3:
                    if (jsonReader.peek() != JsonToken.NULL) {
                        jsonReader.beginObject();
                        while (jsonReader.peek() != JsonToken.END_OBJECT) {
                            builder.custom(jsonReader.nextName(), LDValueTypeAdapter.INSTANCE.read(jsonReader));
                        }
                        jsonReader.endObject();
                        break;
                    } else {
                        jsonReader.nextNull();
                        break;
                    }
                case 4:
                    builder.ip(Helpers.readNullableString(jsonReader));
                    break;
                case 5:
                    builder.key(Helpers.readNullableString(jsonReader));
                    break;
                case 6:
                    builder.name(Helpers.readNullableString(jsonReader));
                    break;
                case 7:
                    builder.email(Helpers.readNullableString(jsonReader));
                    break;
                case 8:
                    builder.firstName(Helpers.readNullableString(jsonReader));
                    break;
                case 9:
                    if (jsonReader.peek() != JsonToken.NULL) {
                        jsonReader.beginArray();
                        while (jsonReader.peek() != JsonToken.END_ARRAY) {
                            builder.addPrivate(UserAttribute.forName(jsonReader.nextString()));
                        }
                        jsonReader.endArray();
                        break;
                    } else {
                        jsonReader.nextNull();
                        break;
                    }
                case 10:
                    builder.country(Helpers.readNullableString(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public void write(JsonWriter jsonWriter, LDUser lDUser) throws IOException {
        jsonWriter.beginObject();
        for (UserAttribute next : UserAttribute.BUILTINS.values()) {
            if (next != UserAttribute.ANONYMOUS || lDUser.isAnonymous()) {
                LDValue attribute = lDUser.getAttribute(next);
                if (!attribute.isNull()) {
                    jsonWriter.name(next.getName());
                    LDValueTypeAdapter.INSTANCE.write(jsonWriter, attribute);
                }
            }
        }
        boolean z = false;
        boolean z2 = false;
        for (UserAttribute next2 : lDUser.getCustomAttributes()) {
            if (!z2) {
                jsonWriter.name(AdaptyUIActionTypeAdapterFactory.TYPE_CUSTOM);
                jsonWriter.beginObject();
                z2 = true;
            }
            jsonWriter.name(next2.getName());
            LDValueTypeAdapter.INSTANCE.write(jsonWriter, lDUser.getAttribute(next2));
        }
        if (z2) {
            jsonWriter.endObject();
        }
        for (UserAttribute next3 : lDUser.getPrivateAttributes()) {
            if (!z) {
                jsonWriter.name("privateAttributeNames");
                jsonWriter.beginArray();
                z = true;
            }
            jsonWriter.value(next3.getName());
        }
        if (z) {
            jsonWriter.endArray();
        }
        jsonWriter.endObject();
    }
}
