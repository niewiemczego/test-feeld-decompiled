package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Map;

@ElementTypesAreNonnullByDefault
public final class ArrayBasedEscaperMap {
    private static final char[][] EMPTY_REPLACEMENT_ARRAY = ((char[][]) Array.newInstance(Character.TYPE, new int[]{0, 0}));
    private final char[][] replacementArray;

    public static ArrayBasedEscaperMap create(Map<Character, String> map) {
        return new ArrayBasedEscaperMap(createReplacementArray(map));
    }

    private ArrayBasedEscaperMap(char[][] cArr) {
        this.replacementArray = cArr;
    }

    /* access modifiers changed from: package-private */
    public char[][] getReplacementArray() {
        return this.replacementArray;
    }

    static char[][] createReplacementArray(Map<Character, String> map) {
        Preconditions.checkNotNull(map);
        if (map.isEmpty()) {
            return EMPTY_REPLACEMENT_ARRAY;
        }
        char[][] cArr = new char[(((Character) Collections.max(map.keySet())).charValue() + 1)][];
        for (Character next : map.keySet()) {
            cArr[next.charValue()] = map.get(next).toCharArray();
        }
        return cArr;
    }
}
