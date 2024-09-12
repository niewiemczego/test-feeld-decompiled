package com.launchdarkly.sdk;

import com.facebook.internal.security.CertificateUtil;
import com.google.gson.annotations.JsonAdapter;
import com.launchdarkly.sdk.json.JsonSerializable;
import com.launchdarkly.sdk.json.JsonSerialization;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonAdapter(LDContextTypeAdapter.class)
public final class LDContext implements JsonSerializable {
    static final String ATTR_ANONYMOUS = "anonymous";
    static final String ATTR_KEY = "key";
    static final String ATTR_KIND = "kind";
    static final String ATTR_NAME = "name";
    final boolean anonymous;
    final Map<String, LDValue> attributes;
    final String error;
    final String fullyQualifiedKey;
    final String key;
    final ContextKind kind;
    final LDContext[] multiContexts;
    final String name;
    final List<AttributeRef> privateAttributes;

    private LDContext(ContextKind contextKind, LDContext[] lDContextArr, String str, String str2, String str3, Map<String, LDValue> map, boolean z, List<AttributeRef> list) {
        this.error = null;
        this.kind = contextKind == null ? ContextKind.DEFAULT : contextKind;
        this.multiContexts = lDContextArr;
        this.key = str;
        this.fullyQualifiedKey = str2;
        this.name = str3;
        this.attributes = map;
        this.anonymous = z;
        this.privateAttributes = list;
    }

    private LDContext(String str) {
        this.error = str;
        this.kind = null;
        this.multiContexts = null;
        this.key = "";
        this.fullyQualifiedKey = "";
        this.name = null;
        this.attributes = null;
        this.anonymous = false;
        this.privateAttributes = null;
    }

    static LDContext createSingle(ContextKind contextKind, String str, String str2, Map<String, LDValue> map, boolean z, List<AttributeRef> list, boolean z2) {
        String str3;
        String validateAsSingleKind;
        if (contextKind != null && (validateAsSingleKind = contextKind.validateAsSingleKind()) != null) {
            return failed(validateAsSingleKind);
        }
        if (str == null || (str.isEmpty() && !z2)) {
            return failed("context key must not be null or empty");
        }
        if (contextKind.isDefault()) {
            str3 = str;
        } else {
            str3 = contextKind.toString() + CertificateUtil.DELIMITER + escapeKeyForFullyQualifiedKey(str);
        }
        return new LDContext(contextKind, (LDContext[]) null, str, str3, str2, map, z, list);
    }

    static LDContext createMultiInternal(LDContext[] lDContextArr) {
        ArrayList<String> arrayList = null;
        boolean z = false;
        for (int i = 0; i < lDContextArr.length; i++) {
            LDContext lDContext = lDContextArr[i];
            if (!lDContext.isValid()) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(lDContext.getError());
            } else {
                int i2 = 0;
                while (true) {
                    if (i2 >= i) {
                        break;
                    } else if (Objects.equals(lDContextArr[i2].getKind(), lDContext.getKind())) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (z) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add("multi-kind context cannot have same kind more than once");
        }
        if (arrayList != null) {
            StringBuilder sb = new StringBuilder();
            for (String str : arrayList) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(str);
            }
            return failed(sb.toString());
        }
        Arrays.sort(lDContextArr, ByKindComparator.INSTANCE);
        StringBuilder sb2 = new StringBuilder();
        for (LDContext lDContext2 : lDContextArr) {
            if (sb2.length() != 0) {
                sb2.append(':');
            }
            sb2.append(lDContext2.getKind().toString()).append(':').append(escapeKeyForFullyQualifiedKey(lDContext2.getKey()));
        }
        return new LDContext(ContextKind.MULTI, lDContextArr, "", sb2.toString(), (String) null, (Map<String, LDValue>) null, false, (List<AttributeRef>) null);
    }

    static LDContext failed(String str) {
        return new LDContext(str);
    }

    public static LDContext create(String str) {
        return create(ContextKind.DEFAULT, str);
    }

    public static LDContext create(ContextKind contextKind, String str) {
        return createSingle(contextKind, str, (String) null, (Map<String, LDValue>) null, false, (List<AttributeRef>) null, false);
    }

    public static LDContext createMulti(LDContext... lDContextArr) {
        if (lDContextArr == null || lDContextArr.length == 0) {
            return failed("multi-kind context must contain at least one kind");
        }
        if (lDContextArr.length == 1) {
            return lDContextArr[0];
        }
        for (LDContext isMultiple : lDContextArr) {
            if (isMultiple.isMultiple()) {
                ContextMultiBuilder multiBuilder = multiBuilder();
                for (LDContext add : lDContextArr) {
                    multiBuilder.add(add);
                }
                return multiBuilder.build();
            }
        }
        return createMultiInternal((LDContext[]) Arrays.copyOf(lDContextArr, lDContextArr.length));
    }

    public static LDContext fromUser(LDUser lDUser) {
        ArrayList arrayList;
        if (lDUser == null) {
            return failed("tried to use a null LDUser reference");
        }
        String key2 = lDUser.getKey();
        if (key2 == null) {
            if (!lDUser.isAnonymous()) {
                return failed("context key must not be null or empty");
            }
            key2 = "";
        }
        String str = key2;
        HashMap hashMap = null;
        for (UserAttribute userAttribute : UserAttribute.OPTIONAL_STRING_ATTRIBUTES) {
            if (userAttribute != UserAttribute.NAME) {
                LDValue attribute = lDUser.getAttribute(userAttribute);
                if (!attribute.isNull()) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(userAttribute.getName(), attribute);
                }
            }
        }
        if (lDUser.custom != null && !lDUser.custom.isEmpty()) {
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            for (Map.Entry next : lDUser.custom.entrySet()) {
                hashMap.put(((UserAttribute) next.getKey()).getName(), next.getValue());
            }
        }
        HashMap hashMap2 = hashMap;
        if (lDUser.privateAttributeNames == null || lDUser.privateAttributeNames.isEmpty()) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (UserAttribute name2 : lDUser.privateAttributeNames) {
                arrayList2.add(AttributeRef.fromLiteral(name2.getName()));
            }
            arrayList = arrayList2;
        }
        return new LDContext(ContextKind.DEFAULT, (LDContext[]) null, str, str, lDUser.getName(), hashMap2, lDUser.isAnonymous(), arrayList);
    }

    public static ContextBuilder builder(String str) {
        return builder(ContextKind.DEFAULT, str);
    }

    public static ContextBuilder builder(ContextKind contextKind, String str) {
        return new ContextBuilder(contextKind, str);
    }

    public static ContextBuilder builderFromContext(LDContext lDContext) {
        return new ContextBuilder().copyFrom(lDContext);
    }

    public static ContextMultiBuilder multiBuilder() {
        return new ContextMultiBuilder();
    }

    public boolean isValid() {
        return this.error == null;
    }

    public String getError() {
        return this.error;
    }

    public ContextKind getKind() {
        return this.kind;
    }

    public boolean isMultiple() {
        return this.multiContexts != null;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAnonymous() {
        return this.anonymous;
    }

    public LDValue getValue(String str) {
        return getTopLevelAttribute(str);
    }

    public LDValue getValue(AttributeRef attributeRef) {
        if (attributeRef == null || !attributeRef.isValid()) {
            return LDValue.ofNull();
        }
        String component = attributeRef.getComponent(0);
        if (!isMultiple()) {
            LDValue topLevelAttribute = getTopLevelAttribute(component);
            if (topLevelAttribute.isNull()) {
                return topLevelAttribute;
            }
            for (int i = 1; i < attributeRef.getDepth(); i++) {
                topLevelAttribute = topLevelAttribute.get(attributeRef.getComponent(i));
                if (topLevelAttribute.isNull()) {
                    break;
                }
            }
            return topLevelAttribute;
        } else if (attributeRef.getDepth() != 1 || !component.equals(ATTR_KIND)) {
            return LDValue.ofNull();
        } else {
            return LDValue.of(this.kind.toString());
        }
    }

    public Iterable<String> getCustomAttributeNames() {
        Map<String, LDValue> map = this.attributes;
        return map == null ? Collections.emptyList() : map.keySet();
    }

    public int getIndividualContextCount() {
        if (this.error != null) {
            return 0;
        }
        LDContext[] lDContextArr = this.multiContexts;
        if (lDContextArr == null) {
            return 1;
        }
        return lDContextArr.length;
    }

    public LDContext getIndividualContext(int i) {
        LDContext[] lDContextArr = this.multiContexts;
        if (lDContextArr == null) {
            if (i == 0) {
                return this;
            }
            return null;
        } else if (i < 0 || i >= lDContextArr.length) {
            return null;
        } else {
            return lDContextArr[i];
        }
    }

    public LDContext getIndividualContext(ContextKind contextKind) {
        if (contextKind == null) {
            contextKind = ContextKind.DEFAULT;
        }
        LDContext[] lDContextArr = this.multiContexts;
        if (lDContextArr != null) {
            for (LDContext lDContext : lDContextArr) {
                if (contextKind.equals(lDContext.kind)) {
                    return lDContext;
                }
            }
            return null;
        } else if (contextKind.equals(this.kind)) {
            return this;
        } else {
            return null;
        }
    }

    public LDContext getIndividualContext(String str) {
        if (str == null || str.isEmpty()) {
            return getIndividualContext(ContextKind.DEFAULT);
        }
        LDContext[] lDContextArr = this.multiContexts;
        if (lDContextArr != null) {
            for (LDContext lDContext : lDContextArr) {
                if (str.equals(lDContext.kind.toString())) {
                    return lDContext;
                }
            }
            return null;
        } else if (str.equals(this.kind.toString())) {
            return this;
        } else {
            return null;
        }
    }

    public int getPrivateAttributeCount() {
        List<AttributeRef> list = this.privateAttributes;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public AttributeRef getPrivateAttribute(int i) {
        List<AttributeRef> list = this.privateAttributes;
        if (list != null && i >= 0 && i < list.size()) {
            return this.privateAttributes.get(i);
        }
        return null;
    }

    public String getFullyQualifiedKey() {
        return this.fullyQualifiedKey;
    }

    public String toString() {
        if (!isValid()) {
            return "(invalid LDContext: " + getError() + ")";
        }
        return JsonSerialization.serialize(this);
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LDContext)) {
            return false;
        }
        LDContext lDContext = (LDContext) obj;
        if (!Objects.equals(this.error, lDContext.error)) {
            return false;
        }
        if (this.error != null) {
            return true;
        }
        if (!Objects.equals(this.kind, lDContext.kind)) {
            return false;
        }
        if (isMultiple()) {
            if (this.multiContexts.length != lDContext.multiContexts.length) {
                return false;
            }
            int i = 0;
            while (true) {
                LDContext[] lDContextArr = this.multiContexts;
                if (i >= lDContextArr.length) {
                    return true;
                }
                if (!Objects.equals(lDContextArr[i], lDContext.multiContexts[i])) {
                    return false;
                }
                i++;
            }
        } else if (!Objects.equals(this.key, lDContext.key) || !Objects.equals(this.name, lDContext.name) || this.anonymous != lDContext.anonymous) {
            return false;
        } else {
            Map<String, LDValue> map = this.attributes;
            int size = map == null ? 0 : map.size();
            Map<String, LDValue> map2 = lDContext.attributes;
            if (size != (map2 == null ? 0 : map2.size())) {
                return false;
            }
            Map<String, LDValue> map3 = this.attributes;
            if (map3 != null) {
                for (Map.Entry next : map3.entrySet()) {
                    if (!Objects.equals(lDContext.attributes.get(next.getKey()), next.getValue())) {
                        return false;
                    }
                }
            }
            if (getPrivateAttributeCount() != lDContext.getPrivateAttributeCount()) {
                return false;
            }
            List<AttributeRef> list = this.privateAttributes;
            if (list != null) {
                for (AttributeRef next2 : list) {
                    Iterator<AttributeRef> it = lDContext.privateAttributes.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().equals(next2)) {
                                z = true;
                                continue;
                                break;
                            }
                        } else {
                            z = false;
                            continue;
                            break;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public int hashCode() {
        int hash = Objects.hash(new Object[]{this.error, this.kind, this.key, this.name, Boolean.valueOf(this.anonymous)});
        LDContext[] lDContextArr = this.multiContexts;
        if (lDContextArr != null) {
            for (LDContext hashCode : lDContextArr) {
                hash = (hash * 17) + hashCode.hashCode();
            }
        }
        Map<String, LDValue> map = this.attributes;
        if (map != null) {
            String[] strArr = (String[]) map.keySet().toArray(new String[this.attributes.size()]);
            Arrays.sort(strArr);
            for (String str : strArr) {
                hash = (((hash * 17) + str.hashCode()) * 17) + this.attributes.get(str).hashCode();
            }
        }
        List<AttributeRef> list = this.privateAttributes;
        if (list != null) {
            AttributeRef[] attributeRefArr = (AttributeRef[]) list.toArray(new AttributeRef[list.size()]);
            Arrays.sort(attributeRefArr);
            for (AttributeRef hashCode2 : attributeRefArr) {
                hash = (hash * 17) + hashCode2.hashCode();
            }
        }
        return hash;
    }

    private LDValue getTopLevelAttribute(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2095811475:
                if (str.equals(ATTR_ANONYMOUS)) {
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
                if (str.equals(ATTR_KIND)) {
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
        }
        switch (c) {
            case 0:
                return LDValue.of(this.anonymous);
            case 1:
                return this.multiContexts == null ? LDValue.of(this.key) : LDValue.ofNull();
            case 2:
                return LDValue.of(this.kind.toString());
            case 3:
                return LDValue.of(this.name);
            default:
                Map<String, LDValue> map = this.attributes;
                if (map == null) {
                    return LDValue.ofNull();
                }
                LDValue lDValue = map.get(str);
                if (lDValue == null) {
                    return LDValue.ofNull();
                }
                return lDValue;
        }
    }

    private static String escapeKeyForFullyQualifiedKey(String str) {
        return str.replace("%", "%25").replace(CertificateUtil.DELIMITER, "%3A");
    }

    private static class ByKindComparator implements Comparator<LDContext> {
        static final ByKindComparator INSTANCE = new ByKindComparator();

        private ByKindComparator() {
        }

        public int compare(LDContext lDContext, LDContext lDContext2) {
            return lDContext.getKind().compareTo(lDContext2.getKind());
        }
    }
}
