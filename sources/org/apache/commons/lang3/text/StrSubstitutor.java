package org.apache.commons.lang3.text;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class StrSubstitutor {
    public static final char DEFAULT_ESCAPE = '$';
    public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher("${");
    public static final StrMatcher DEFAULT_SUFFIX = StrMatcher.stringMatcher("}");
    private boolean enableSubstitutionInVariables;
    private char escapeChar;
    private StrMatcher prefixMatcher;
    private StrMatcher suffixMatcher;
    private StrLookup<?> variableResolver;

    public static <V> String replace(Object obj, Map<String, V> map) {
        return new StrSubstitutor(map).replace(obj);
    }

    public static <V> String replace(Object obj, Map<String, V> map, String str, String str2) {
        return new StrSubstitutor(map, str, str2).replace(obj);
    }

    public static String replace(Object obj, Properties properties) {
        if (properties == null) {
            return obj.toString();
        }
        HashMap hashMap = new HashMap();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            hashMap.put(str, properties.getProperty(str));
        }
        return replace(obj, hashMap);
    }

    public static String replaceSystemProperties(Object obj) {
        return new StrSubstitutor((StrLookup<?>) StrLookup.systemPropertiesLookup()).replace(obj);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StrSubstitutor() {
        this((StrLookup<?>) null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
        StrLookup strLookup = null;
    }

    public <V> StrSubstitutor(Map<String, V> map) {
        this((StrLookup<?>) StrLookup.mapLookup(map), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, '$');
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2, char c) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, c);
    }

    public StrSubstitutor(StrLookup<?> strLookup) {
        this(strLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public StrSubstitutor(StrLookup<?> strLookup, String str, String str2, char c) {
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c);
    }

    public StrSubstitutor(StrLookup<?> strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c) {
        setVariableResolver(strLookup);
        setVariablePrefixMatcher(strMatcher);
        setVariableSuffixMatcher(strMatcher2);
        setEscapeChar(c);
    }

    public String replace(String str) {
        if (str == null) {
            return null;
        }
        StrBuilder strBuilder = new StrBuilder(str);
        if (!substitute(strBuilder, 0, str.length())) {
            return str;
        }
        return strBuilder.toString();
    }

    public String replace(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(str, i, i2);
        if (!substitute(append, 0, i2)) {
            return str.substring(i, i2 + i);
        }
        return append.toString();
    }

    public String replace(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(cArr.length).append(cArr);
        substitute(append, 0, cArr.length);
        return append.toString();
    }

    public String replace(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(cArr, i, i2);
        substitute(append, 0, i2);
        return append.toString();
    }

    public String replace(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(stringBuffer.length()).append(stringBuffer);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public String replace(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(stringBuffer, i, i2);
        substitute(append, 0, i2);
        return append.toString();
    }

    public String replace(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(strBuilder.length()).append(strBuilder);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public String replace(StrBuilder strBuilder, int i, int i2) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(strBuilder, i, i2);
        substitute(append, 0, i2);
        return append.toString();
    }

    public String replace(Object obj) {
        if (obj == null) {
            return null;
        }
        StrBuilder append = new StrBuilder().append(obj);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public boolean replaceIn(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return false;
        }
        return replaceIn(stringBuffer, 0, stringBuffer.length());
    }

    public boolean replaceIn(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return false;
        }
        StrBuilder append = new StrBuilder(i2).append(stringBuffer, i, i2);
        if (!substitute(append, 0, i2)) {
            return false;
        }
        stringBuffer.replace(i, i2 + i, append.toString());
        return true;
    }

    public boolean replaceIn(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, 0, strBuilder.length());
    }

    public boolean replaceIn(StrBuilder strBuilder, int i, int i2) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean substitute(StrBuilder strBuilder, int i, int i2) {
        return substitute(strBuilder, i, i2, (List<String>) null) > 0;
    }

    private int substitute(StrBuilder strBuilder, int i, int i2, List<String> list) {
        StrMatcher strMatcher;
        StrMatcher strMatcher2;
        boolean z;
        int isMatch;
        StrBuilder strBuilder2 = strBuilder;
        int i3 = i;
        int i4 = i2;
        StrMatcher variablePrefixMatcher = getVariablePrefixMatcher();
        StrMatcher variableSuffixMatcher = getVariableSuffixMatcher();
        char escapeChar2 = getEscapeChar();
        boolean z2 = list == null;
        int i5 = i3;
        int i6 = i3 + i4;
        int i7 = 0;
        int i8 = 0;
        char[] cArr = strBuilder2.buffer;
        List<String> list2 = list;
        while (i5 < i6) {
            int isMatch2 = variablePrefixMatcher.isMatch(cArr, i5, i3, i6);
            if (isMatch2 != 0) {
                if (i5 > i3) {
                    int i9 = i5 - 1;
                    if (cArr[i9] == escapeChar2) {
                        strBuilder2.deleteCharAt(i9);
                        i7--;
                        i6--;
                        strMatcher2 = variablePrefixMatcher;
                        strMatcher = variableSuffixMatcher;
                        cArr = strBuilder2.buffer;
                        i8 = 1;
                    }
                }
                int i10 = i5 + isMatch2;
                int i11 = i10;
                int i12 = 0;
                while (true) {
                    if (i11 >= i6) {
                        strMatcher2 = variablePrefixMatcher;
                        strMatcher = variableSuffixMatcher;
                        i5 = i11;
                        break;
                    } else if (!isEnableSubstitutionInVariables() || (isMatch = variablePrefixMatcher.isMatch(cArr, i11, i3, i6)) == 0) {
                        int isMatch3 = variableSuffixMatcher.isMatch(cArr, i11, i3, i6);
                        if (isMatch3 == 0) {
                            i11++;
                        } else if (i12 == 0) {
                            strMatcher2 = variablePrefixMatcher;
                            strMatcher = variableSuffixMatcher;
                            String str = new String(cArr, i10, (i11 - i5) - isMatch2);
                            if (isEnableSubstitutionInVariables()) {
                                StrBuilder strBuilder3 = new StrBuilder(str);
                                z = false;
                                substitute(strBuilder3, 0, strBuilder3.length());
                                str = strBuilder3.toString();
                            } else {
                                z = false;
                            }
                            int i13 = i11 + isMatch3;
                            if (list2 == null) {
                                list2 = new ArrayList<>();
                                list2.add(new String(cArr, i3, i4));
                            }
                            checkCyclicSubstitution(str, list2);
                            list2.add(str);
                            String resolveVariable = resolveVariable(str, strBuilder2, i5, i13);
                            if (resolveVariable != null) {
                                int length = resolveVariable.length();
                                strBuilder2.replace(i5, i13, resolveVariable);
                                int substitute = substitute(strBuilder2, i5, length, list2) + (length - (i13 - i5));
                                i6 += substitute;
                                i7 += substitute;
                                cArr = strBuilder2.buffer;
                                i5 = i13 + substitute;
                                i8 = 1;
                            } else {
                                i5 = i13;
                            }
                            list2.remove(list2.size() - 1);
                            boolean z3 = z;
                        } else {
                            i12--;
                            i11 += isMatch3;
                            variablePrefixMatcher = variablePrefixMatcher;
                            variableSuffixMatcher = variableSuffixMatcher;
                        }
                    } else {
                        i12++;
                        i11 += isMatch;
                    }
                }
            } else {
                i5++;
                strMatcher2 = variablePrefixMatcher;
                strMatcher = variableSuffixMatcher;
            }
            variablePrefixMatcher = strMatcher2;
            variableSuffixMatcher = strMatcher;
        }
        return z2 ? i8 : i7;
    }

    private void checkCyclicSubstitution(String str, List<String> list) {
        if (list.contains(str)) {
            StrBuilder strBuilder = new StrBuilder(256);
            strBuilder.append("Infinite loop in property interpolation of ");
            strBuilder.append(list.remove(0));
            strBuilder.append(": ");
            strBuilder.appendWithSeparators((Iterable<?>) list, "->");
            throw new IllegalStateException(strBuilder.toString());
        }
    }

    /* access modifiers changed from: protected */
    public String resolveVariable(String str, StrBuilder strBuilder, int i, int i2) {
        StrLookup<?> variableResolver2 = getVariableResolver();
        if (variableResolver2 == null) {
            return null;
        }
        return variableResolver2.lookup(str);
    }

    public char getEscapeChar() {
        return this.escapeChar;
    }

    public void setEscapeChar(char c) {
        this.escapeChar = c;
    }

    public StrMatcher getVariablePrefixMatcher() {
        return this.prefixMatcher;
    }

    public StrSubstitutor setVariablePrefixMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.prefixMatcher = strMatcher;
            return this;
        }
        throw new IllegalArgumentException("Variable prefix matcher must not be null!");
    }

    public StrSubstitutor setVariablePrefix(char c) {
        return setVariablePrefixMatcher(StrMatcher.charMatcher(c));
    }

    public StrSubstitutor setVariablePrefix(String str) {
        if (str != null) {
            return setVariablePrefixMatcher(StrMatcher.stringMatcher(str));
        }
        throw new IllegalArgumentException("Variable prefix must not be null!");
    }

    public StrMatcher getVariableSuffixMatcher() {
        return this.suffixMatcher;
    }

    public StrSubstitutor setVariableSuffixMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.suffixMatcher = strMatcher;
            return this;
        }
        throw new IllegalArgumentException("Variable suffix matcher must not be null!");
    }

    public StrSubstitutor setVariableSuffix(char c) {
        return setVariableSuffixMatcher(StrMatcher.charMatcher(c));
    }

    public StrSubstitutor setVariableSuffix(String str) {
        if (str != null) {
            return setVariableSuffixMatcher(StrMatcher.stringMatcher(str));
        }
        throw new IllegalArgumentException("Variable suffix must not be null!");
    }

    public StrLookup<?> getVariableResolver() {
        return this.variableResolver;
    }

    public void setVariableResolver(StrLookup<?> strLookup) {
        this.variableResolver = strLookup;
    }

    public boolean isEnableSubstitutionInVariables() {
        return this.enableSubstitutionInVariables;
    }

    public void setEnableSubstitutionInVariables(boolean z) {
        this.enableSubstitutionInVariables = z;
    }
}
