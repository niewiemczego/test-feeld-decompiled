package com.launchdarkly.sdk;

import com.google.gson.annotations.JsonAdapter;
import com.launchdarkly.sdk.json.JsonSerializable;

@JsonAdapter(ContextKindTypeAdapter.class)
public final class ContextKind implements Comparable<ContextKind>, JsonSerializable {
    public static final ContextKind DEFAULT = new ContextKind("user");
    public static final ContextKind MULTI = new ContextKind("multi");
    private final String kindName;

    private ContextKind(String str) {
        this.kindName = str;
    }

    public static ContextKind of(String str) {
        if (str == null || str.isEmpty() || str.equals(DEFAULT.kindName)) {
            return DEFAULT;
        }
        ContextKind contextKind = MULTI;
        if (str.equals(contextKind.kindName)) {
            return contextKind;
        }
        return new ContextKind(str);
    }

    public boolean isDefault() {
        return this == DEFAULT;
    }

    public String toString() {
        return this.kindName;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ContextKind) && (this == obj || this.kindName.equals(((ContextKind) obj).kindName));
    }

    public int hashCode() {
        return this.kindName.hashCode();
    }

    /* access modifiers changed from: package-private */
    public String validateAsSingleKind() {
        if (isDefault()) {
            return null;
        }
        if (this == MULTI) {
            return "context of kind \"multi\" must be created with NewMulti or NewMultiBuilder";
        }
        if (this.kindName.equals("kind")) {
            return "\"kind\" is not a valid context kind";
        }
        for (int i = 0; i < this.kindName.length(); i++) {
            char charAt = this.kindName.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt < '0' || charAt > '9') && charAt != '.' && charAt != '_' && charAt != '-'))) {
                return "context kind contains disallowed characters";
            }
        }
        return null;
    }

    public int compareTo(ContextKind contextKind) {
        return this.kindName.compareTo(contextKind.kindName);
    }
}
