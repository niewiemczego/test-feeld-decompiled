package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.Map;
import java.util.TreeMap;

class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    PrettyPrintTreeMap() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("( ");
        for (Map.Entry entry : entrySet()) {
            sb.append('{').append(entry.getKey()).append(':').append(entry.getValue()).append("}, ");
        }
        if (!isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        return sb.append(" )").toString();
    }
}
