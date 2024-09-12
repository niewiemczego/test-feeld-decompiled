package com.launchdarkly.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ContextBuilder {
    private boolean allowEmptyKey;
    private boolean anonymous;
    private Map<String, LDValue> attributes;
    private boolean copyOnWriteAttributes;
    private boolean copyOnWritePrivateAttributes;
    private String key;
    private ContextKind kind;
    private String name;
    private List<AttributeRef> privateAttributes;

    ContextBuilder() {
    }

    ContextBuilder(ContextKind contextKind, String str) {
        this.kind = contextKind;
        this.key = str;
    }

    public LDContext build() {
        Map<String, LDValue> map = this.attributes;
        boolean z = true;
        this.copyOnWriteAttributes = map != null;
        List<AttributeRef> list = this.privateAttributes;
        if (list == null) {
            z = false;
        }
        this.copyOnWritePrivateAttributes = z;
        return LDContext.createSingle(this.kind, this.key, this.name, map, this.anonymous, list, this.allowEmptyKey);
    }

    public ContextBuilder kind(ContextKind contextKind) {
        this.kind = contextKind;
        return this;
    }

    public ContextBuilder kind(String str) {
        return kind(ContextKind.of(str));
    }

    public ContextBuilder key(String str) {
        this.key = str;
        return this;
    }

    public ContextBuilder name(String str) {
        this.name = str;
        return this;
    }

    public ContextBuilder anonymous(boolean z) {
        this.anonymous = z;
        return this;
    }

    public ContextBuilder set(String str, LDValue lDValue) {
        trySet(str, lDValue);
        return this;
    }

    public ContextBuilder set(String str, boolean z) {
        return set(str, LDValue.of(z));
    }

    public ContextBuilder set(String str, int i) {
        return set(str, LDValue.of(i));
    }

    public ContextBuilder set(String str, double d) {
        return set(str, LDValue.of(d));
    }

    public ContextBuilder set(String str, String str2) {
        return set(str, LDValue.of(str2));
    }

    public boolean trySet(String str, LDValue lDValue) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2095811475:
                if (str.equals("anonymous")) {
                    c = 0;
                    break;
                }
                break;
            case 106079:
                if (str.equals("key")) {
                    c = 1;
                    break;
                }
                break;
            case 3292052:
                if (str.equals("kind")) {
                    c = 2;
                    break;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    c = 3;
                    break;
                }
                break;
            case 91082468:
                if (str.equals("_meta")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (lDValue.getType() == LDValueType.BOOLEAN) {
                    this.anonymous = lDValue.booleanValue();
                    break;
                } else {
                    return false;
                }
            case 1:
                if (lDValue.isString()) {
                    this.key = lDValue.stringValue();
                    break;
                } else {
                    return false;
                }
            case 2:
                if (lDValue.isString()) {
                    this.kind = ContextKind.of(lDValue.stringValue());
                    break;
                } else {
                    return false;
                }
            case 3:
                if (lDValue.isString() || lDValue.isNull()) {
                    this.name = lDValue.stringValue();
                    break;
                } else {
                    return false;
                }
            case 4:
                return false;
            default:
                if (this.copyOnWriteAttributes) {
                    this.attributes = new HashMap(this.attributes);
                    this.copyOnWriteAttributes = false;
                }
                if (lDValue != null && !lDValue.isNull()) {
                    if (this.attributes == null) {
                        this.attributes = new HashMap();
                    }
                    this.attributes.put(str, lDValue);
                    break;
                } else {
                    Map<String, LDValue> map = this.attributes;
                    if (map != null) {
                        map.remove(str);
                        break;
                    }
                }
                break;
        }
        return true;
    }

    public ContextBuilder privateAttributes(String... strArr) {
        if (!(strArr == null || strArr.length == 0)) {
            prepareToChangePrivate();
            for (String fromPath : strArr) {
                this.privateAttributes.add(AttributeRef.fromPath(fromPath));
            }
        }
        return this;
    }

    public ContextBuilder privateAttributes(AttributeRef... attributeRefArr) {
        if (!(attributeRefArr == null || attributeRefArr.length == 0)) {
            prepareToChangePrivate();
            for (AttributeRef add : attributeRefArr) {
                this.privateAttributes.add(add);
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public void setAllowEmptyKey(boolean z) {
        this.allowEmptyKey = z;
    }

    /* access modifiers changed from: package-private */
    public ContextBuilder copyFrom(LDContext lDContext) {
        this.kind = lDContext.getKind();
        this.key = lDContext.getKey();
        this.name = lDContext.getName();
        this.anonymous = lDContext.isAnonymous();
        this.attributes = lDContext.attributes;
        this.privateAttributes = lDContext.privateAttributes;
        this.copyOnWriteAttributes = true;
        this.copyOnWritePrivateAttributes = true;
        return this;
    }

    private void prepareToChangePrivate() {
        if (this.copyOnWritePrivateAttributes) {
            this.privateAttributes = new ArrayList(this.privateAttributes);
            this.copyOnWritePrivateAttributes = false;
        } else if (this.privateAttributes == null) {
            this.privateAttributes = new ArrayList();
        }
    }
}
