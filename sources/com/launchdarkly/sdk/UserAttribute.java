package com.launchdarkly.sdk;

import com.facebook.appevents.UserDataStore;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.launchdarkly.sdk.json.JsonSerializable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@JsonAdapter(UserAttributeTypeAdapter.class)
public final class UserAttribute implements JsonSerializable {
    public static final UserAttribute ANONYMOUS;
    public static final UserAttribute AVATAR;
    static final Map<String, UserAttribute> BUILTINS = new HashMap();
    public static final UserAttribute COUNTRY;
    public static final UserAttribute EMAIL;
    public static final UserAttribute FIRST_NAME;
    public static final UserAttribute IP;
    public static final UserAttribute KEY;
    public static final UserAttribute LAST_NAME;
    public static final UserAttribute NAME;
    static final UserAttribute[] OPTIONAL_STRING_ATTRIBUTES = {IP, EMAIL, NAME, AVATAR, FIRST_NAME, LAST_NAME, COUNTRY};
    final Function<LDUser, LDValue> builtInGetter;
    private final String name;

    static {
        UserAttribute userAttribute = new UserAttribute("key", new Function<LDUser, LDValue>() {
            public LDValue apply(LDUser lDUser) {
                return lDUser.key;
            }
        });
        KEY = userAttribute;
        UserAttribute userAttribute2 = new UserAttribute("ip", new Function<LDUser, LDValue>() {
            public LDValue apply(LDUser lDUser) {
                return lDUser.ip;
            }
        });
        IP = userAttribute2;
        UserAttribute userAttribute3 = new UserAttribute("email", new Function<LDUser, LDValue>() {
            public LDValue apply(LDUser lDUser) {
                return lDUser.email;
            }
        });
        EMAIL = userAttribute3;
        UserAttribute userAttribute4 = new UserAttribute("name", new Function<LDUser, LDValue>() {
            public LDValue apply(LDUser lDUser) {
                return lDUser.name;
            }
        });
        NAME = userAttribute4;
        UserAttribute userAttribute5 = new UserAttribute("avatar", new Function<LDUser, LDValue>() {
            public LDValue apply(LDUser lDUser) {
                return lDUser.avatar;
            }
        });
        AVATAR = userAttribute5;
        UserAttribute userAttribute6 = new UserAttribute("firstName", new Function<LDUser, LDValue>() {
            public LDValue apply(LDUser lDUser) {
                return lDUser.firstName;
            }
        });
        FIRST_NAME = userAttribute6;
        UserAttribute userAttribute7 = new UserAttribute("lastName", new Function<LDUser, LDValue>() {
            public LDValue apply(LDUser lDUser) {
                return lDUser.lastName;
            }
        });
        LAST_NAME = userAttribute7;
        UserAttribute userAttribute8 = new UserAttribute(UserDataStore.COUNTRY, new Function<LDUser, LDValue>() {
            public LDValue apply(LDUser lDUser) {
                return lDUser.country;
            }
        });
        COUNTRY = userAttribute8;
        UserAttribute userAttribute9 = new UserAttribute("anonymous", new Function<LDUser, LDValue>() {
            public LDValue apply(LDUser lDUser) {
                return LDValue.of(lDUser.anonymous);
            }
        });
        ANONYMOUS = userAttribute9;
        UserAttribute[] userAttributeArr = {userAttribute, userAttribute2, userAttribute3, userAttribute4, userAttribute5, userAttribute6, userAttribute7, userAttribute8, userAttribute9};
        for (int i = 0; i < 9; i++) {
            UserAttribute userAttribute10 = userAttributeArr[i];
            BUILTINS.put(userAttribute10.getName(), userAttribute10);
        }
    }

    private UserAttribute(String str, Function<LDUser, LDValue> function) {
        this.name = str;
        this.builtInGetter = function;
    }

    public static UserAttribute forName(String str) {
        UserAttribute userAttribute = BUILTINS.get(str);
        return userAttribute != null ? userAttribute : new UserAttribute(str, (Function<LDUser, LDValue>) null);
    }

    public String getName() {
        return this.name;
    }

    public boolean isBuiltIn() {
        return this.builtInGetter != null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UserAttribute)) {
            return false;
        }
        UserAttribute userAttribute = (UserAttribute) obj;
        if (!isBuiltIn() && !userAttribute.isBuiltIn()) {
            return this.name.equals(userAttribute.name);
        }
        if (this == userAttribute) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return isBuiltIn() ? super.hashCode() : this.name.hashCode();
    }

    public String toString() {
        return this.name;
    }

    static final class UserAttributeTypeAdapter extends TypeAdapter<UserAttribute> {
        UserAttributeTypeAdapter() {
        }

        public UserAttribute read(JsonReader jsonReader) throws IOException {
            if (AnonymousClass10.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()] == 1) {
                return UserAttribute.forName(jsonReader.nextString());
            }
            throw new IllegalStateException("expected string for UserAttribute");
        }

        public void write(JsonWriter jsonWriter, UserAttribute userAttribute) throws IOException {
            jsonWriter.value(userAttribute.getName());
        }
    }

    /* renamed from: com.launchdarkly.sdk.UserAttribute$10  reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
