package com.launchdarkly.sdk;

import com.google.gson.annotations.JsonAdapter;
import com.launchdarkly.sdk.json.JsonSerializable;
import com.launchdarkly.sdk.json.JsonSerialization;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@JsonAdapter(LDUserTypeAdapter.class)
public class LDUser implements JsonSerializable {
    final boolean anonymous;
    final LDValue avatar;
    final LDValue country;
    final Map<UserAttribute, LDValue> custom;
    final LDValue email;
    final LDValue firstName;
    final LDValue ip;
    final LDValue key;
    final LDValue lastName;
    final LDValue name;
    Set<UserAttribute> privateAttributeNames;

    protected LDUser(Builder builder) {
        this.key = LDValue.of(builder.key);
        this.ip = LDValue.of(builder.ip);
        this.country = LDValue.of(builder.country);
        this.firstName = LDValue.of(builder.firstName);
        this.lastName = LDValue.of(builder.lastName);
        this.email = LDValue.of(builder.email);
        this.name = LDValue.of(builder.name);
        this.avatar = LDValue.of(builder.avatar);
        this.anonymous = builder.anonymous;
        Set<UserAttribute> set = null;
        this.custom = builder.custom == null ? null : Collections.unmodifiableMap(builder.custom);
        this.privateAttributeNames = builder.privateAttributes != null ? Collections.unmodifiableSet(builder.privateAttributes) : set;
    }

    public LDUser(String str) {
        this.key = LDValue.of(str);
        LDValue ofNull = LDValue.ofNull();
        this.country = ofNull;
        this.lastName = ofNull;
        this.firstName = ofNull;
        this.avatar = ofNull;
        this.name = ofNull;
        this.email = ofNull;
        this.ip = ofNull;
        this.anonymous = false;
        this.custom = null;
        this.privateAttributeNames = null;
    }

    public String getKey() {
        return this.key.stringValue();
    }

    public String getIp() {
        return this.ip.stringValue();
    }

    public String getCountry() {
        return this.country.stringValue();
    }

    public String getName() {
        return this.name.stringValue();
    }

    public String getFirstName() {
        return this.firstName.stringValue();
    }

    public String getLastName() {
        return this.lastName.stringValue();
    }

    public String getEmail() {
        return this.email.stringValue();
    }

    public String getAvatar() {
        return this.avatar.stringValue();
    }

    public boolean isAnonymous() {
        return this.anonymous;
    }

    public LDValue getAttribute(UserAttribute userAttribute) {
        if (userAttribute.isBuiltIn()) {
            return userAttribute.builtInGetter.apply(this);
        }
        Map<UserAttribute, LDValue> map = this.custom;
        return map == null ? LDValue.ofNull() : LDValue.normalize(map.get(userAttribute));
    }

    public Iterable<UserAttribute> getCustomAttributes() {
        Map<UserAttribute, LDValue> map = this.custom;
        return map == null ? Collections.emptyList() : map.keySet();
    }

    public Iterable<UserAttribute> getPrivateAttributes() {
        Set<UserAttribute> set = this.privateAttributeNames;
        return set == null ? Collections.emptyList() : set;
    }

    public boolean isAttributePrivate(UserAttribute userAttribute) {
        Set<UserAttribute> set = this.privateAttributeNames;
        return set != null && set.contains(userAttribute);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LDUser)) {
            return false;
        }
        LDUser lDUser = (LDUser) obj;
        if (!Objects.equals(this.key, lDUser.key) || !Objects.equals(this.ip, lDUser.ip) || !Objects.equals(this.email, lDUser.email) || !Objects.equals(this.name, lDUser.name) || !Objects.equals(this.avatar, lDUser.avatar) || !Objects.equals(this.firstName, lDUser.firstName) || !Objects.equals(this.lastName, lDUser.lastName) || !Objects.equals(this.country, lDUser.country) || this.anonymous != lDUser.anonymous || !Objects.equals(this.custom, lDUser.custom) || !Objects.equals(this.privateAttributeNames, lDUser.privateAttributeNames)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.key, this.ip, this.email, this.name, this.avatar, this.firstName, this.lastName, Boolean.valueOf(this.anonymous), this.country, this.custom, this.privateAttributeNames});
    }

    public String toString() {
        return "LDUser(" + JsonSerialization.serialize(this) + ")";
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean anonymous = false;
        /* access modifiers changed from: private */
        public String avatar;
        /* access modifiers changed from: private */
        public String country;
        /* access modifiers changed from: private */
        public Map<UserAttribute, LDValue> custom;
        /* access modifiers changed from: private */
        public String email;
        /* access modifiers changed from: private */
        public String firstName;
        /* access modifiers changed from: private */
        public String ip;
        /* access modifiers changed from: private */
        public String key;
        /* access modifiers changed from: private */
        public String lastName;
        /* access modifiers changed from: private */
        public String name;
        /* access modifiers changed from: private */
        public Set<UserAttribute> privateAttributes;

        public Builder(String str) {
            this.key = str;
        }

        public Builder(LDUser lDUser) {
            this.key = lDUser.key.stringValue();
            this.ip = lDUser.ip.stringValue();
            this.firstName = lDUser.firstName.stringValue();
            this.lastName = lDUser.lastName.stringValue();
            this.email = lDUser.email.stringValue();
            this.name = lDUser.name.stringValue();
            this.avatar = lDUser.avatar.stringValue();
            this.anonymous = lDUser.anonymous;
            this.country = lDUser.country.stringValue();
            HashSet hashSet = null;
            this.custom = lDUser.custom == null ? null : new HashMap(lDUser.custom);
            this.privateAttributes = lDUser.privateAttributeNames != null ? new HashSet(lDUser.privateAttributeNames) : hashSet;
        }

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder ip(String str) {
            this.ip = str;
            return this;
        }

        public Builder privateIp(String str) {
            addPrivate(UserAttribute.IP);
            return ip(str);
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder privateCountry(String str) {
            addPrivate(UserAttribute.COUNTRY);
            return country(str);
        }

        public Builder firstName(String str) {
            this.firstName = str;
            return this;
        }

        public Builder privateFirstName(String str) {
            addPrivate(UserAttribute.FIRST_NAME);
            return firstName(str);
        }

        public Builder anonymous(boolean z) {
            this.anonymous = z;
            return this;
        }

        public Builder lastName(String str) {
            this.lastName = str;
            return this;
        }

        public Builder privateLastName(String str) {
            addPrivate(UserAttribute.LAST_NAME);
            return lastName(str);
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder privateName(String str) {
            addPrivate(UserAttribute.NAME);
            return name(str);
        }

        public Builder avatar(String str) {
            this.avatar = str;
            return this;
        }

        public Builder privateAvatar(String str) {
            addPrivate(UserAttribute.AVATAR);
            return avatar(str);
        }

        public Builder email(String str) {
            this.email = str;
            return this;
        }

        public Builder privateEmail(String str) {
            addPrivate(UserAttribute.EMAIL);
            return email(str);
        }

        public Builder custom(String str, String str2) {
            return custom(str, LDValue.of(str2));
        }

        public Builder custom(String str, int i) {
            return custom(str, LDValue.of(i));
        }

        public Builder custom(String str, double d) {
            return custom(str, LDValue.of(d));
        }

        public Builder custom(String str, boolean z) {
            return custom(str, LDValue.of(z));
        }

        public Builder custom(String str, LDValue lDValue) {
            return str != null ? customInternal(UserAttribute.forName(str), lDValue) : this;
        }

        private Builder customInternal(UserAttribute userAttribute, LDValue lDValue) {
            if (this.custom == null) {
                this.custom = new HashMap();
            }
            this.custom.put(userAttribute, LDValue.normalize(lDValue));
            return this;
        }

        public Builder privateCustom(String str, String str2) {
            return privateCustom(str, LDValue.of(str2));
        }

        public Builder privateCustom(String str, int i) {
            return privateCustom(str, LDValue.of(i));
        }

        public Builder privateCustom(String str, double d) {
            return privateCustom(str, LDValue.of(d));
        }

        public Builder privateCustom(String str, boolean z) {
            return privateCustom(str, LDValue.of(z));
        }

        public Builder privateCustom(String str, LDValue lDValue) {
            if (str == null) {
                return this;
            }
            UserAttribute forName = UserAttribute.forName(str);
            addPrivate(forName);
            return customInternal(forName, lDValue);
        }

        /* access modifiers changed from: package-private */
        public void addPrivate(UserAttribute userAttribute) {
            if (this.privateAttributes == null) {
                this.privateAttributes = new LinkedHashSet();
            }
            this.privateAttributes.add(userAttribute);
        }

        public LDUser build() {
            return new LDUser(this);
        }
    }
}
