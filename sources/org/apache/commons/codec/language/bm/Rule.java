package org.apache.commons.codec.language.bm;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.apache.commons.codec.language.bm.Languages;

public class Rule {
    public static final String ALL = "ALL";
    public static final RPattern ALL_STRINGS_RMATCHER = new RPattern() {
        public boolean isMatch(CharSequence charSequence) {
            return true;
        }
    };
    private static final String DOUBLE_QUOTE = "\"";
    private static final String HASH_INCLUDE = "#include";
    private static final Map<NameType, Map<RuleType, Map<String, Map<String, List<Rule>>>>> RULES = new EnumMap(NameType.class);
    private final RPattern lContext;
    private final String pattern;
    private final PhonemeExpr phoneme;
    private final RPattern rContext;

    public interface PhonemeExpr {
        Iterable<Phoneme> getPhonemes();
    }

    public interface RPattern {
        boolean isMatch(CharSequence charSequence);
    }

    public static final class Phoneme implements PhonemeExpr {
        public static final Comparator<Phoneme> COMPARATOR = new Comparator<Phoneme>() {
            public int compare(Phoneme phoneme, Phoneme phoneme2) {
                for (int i = 0; i < phoneme.phonemeText.length(); i++) {
                    if (i >= phoneme2.phonemeText.length()) {
                        return 1;
                    }
                    int charAt = phoneme.phonemeText.charAt(i) - phoneme2.phonemeText.charAt(i);
                    if (charAt != 0) {
                        return charAt;
                    }
                }
                if (phoneme.phonemeText.length() < phoneme2.phonemeText.length()) {
                    return -1;
                }
                return 0;
            }
        };
        private final Languages.LanguageSet languages;
        /* access modifiers changed from: private */
        public final StringBuilder phonemeText;

        public Phoneme(CharSequence charSequence, Languages.LanguageSet languageSet) {
            this.phonemeText = new StringBuilder(charSequence);
            this.languages = languageSet;
        }

        public Phoneme(Phoneme phoneme, Phoneme phoneme2) {
            this((CharSequence) phoneme.phonemeText, phoneme.languages);
            this.phonemeText.append(phoneme2.phonemeText);
        }

        public Phoneme(Phoneme phoneme, Phoneme phoneme2, Languages.LanguageSet languageSet) {
            this((CharSequence) phoneme.phonemeText, languageSet);
            this.phonemeText.append(phoneme2.phonemeText);
        }

        public Phoneme append(CharSequence charSequence) {
            this.phonemeText.append(charSequence);
            return this;
        }

        public Languages.LanguageSet getLanguages() {
            return this.languages;
        }

        public Iterable<Phoneme> getPhonemes() {
            return Collections.singleton(this);
        }

        public CharSequence getPhonemeText() {
            return this.phonemeText;
        }

        @Deprecated
        public Phoneme join(Phoneme phoneme) {
            return new Phoneme((CharSequence) this.phonemeText.toString() + phoneme.phonemeText.toString(), this.languages.restrictTo(phoneme.languages));
        }

        public Phoneme mergeWithLanguage(Languages.LanguageSet languageSet) {
            return new Phoneme((CharSequence) this.phonemeText.toString(), this.languages.merge(languageSet));
        }

        public String toString() {
            return this.phonemeText.toString() + "[" + this.languages + "]";
        }
    }

    public static final class PhonemeList implements PhonemeExpr {
        private final List<Phoneme> phonemes;

        public PhonemeList(List<Phoneme> list) {
            this.phonemes = list;
        }

        public List<Phoneme> getPhonemes() {
            return this.phonemes;
        }
    }

    static {
        for (NameType nameType : NameType.values()) {
            EnumMap enumMap = new EnumMap(RuleType.class);
            for (RuleType ruleType : RuleType.values()) {
                HashMap hashMap = new HashMap();
                for (String next : Languages.getInstance(nameType).getLanguages()) {
                    try {
                        hashMap.put(next, parseRules(createScanner(nameType, ruleType, next), createResourceName(nameType, ruleType, next)));
                    } catch (IllegalStateException e) {
                        throw new IllegalStateException("Problem processing " + createResourceName(nameType, ruleType, next), e);
                    }
                }
                if (!ruleType.equals(RuleType.RULES)) {
                    hashMap.put("common", parseRules(createScanner(nameType, ruleType, "common"), createResourceName(nameType, ruleType, "common")));
                }
                enumMap.put(ruleType, Collections.unmodifiableMap(hashMap));
            }
            RULES.put(nameType, Collections.unmodifiableMap(enumMap));
        }
    }

    /* access modifiers changed from: private */
    public static boolean contains(CharSequence charSequence, char c) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    private static String createResourceName(NameType nameType, RuleType ruleType, String str) {
        return String.format("org/apache/commons/codec/language/bm/%s_%s_%s.txt", new Object[]{nameType.getName(), ruleType.getName(), str});
    }

    private static Scanner createScanner(NameType nameType, RuleType ruleType, String str) {
        String createResourceName = createResourceName(nameType, ruleType, str);
        InputStream resourceAsStream = Languages.class.getClassLoader().getResourceAsStream(createResourceName);
        if (resourceAsStream != null) {
            return new Scanner(resourceAsStream, "UTF-8");
        }
        throw new IllegalArgumentException("Unable to load resource: " + createResourceName);
    }

    private static Scanner createScanner(String str) {
        String format = String.format("org/apache/commons/codec/language/bm/%s.txt", new Object[]{str});
        InputStream resourceAsStream = Languages.class.getClassLoader().getResourceAsStream(format);
        if (resourceAsStream != null) {
            return new Scanner(resourceAsStream, "UTF-8");
        }
        throw new IllegalArgumentException("Unable to load resource: " + format);
    }

    /* access modifiers changed from: private */
    public static boolean endsWith(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        int length = charSequence.length() - 1;
        for (int length2 = charSequence2.length() - 1; length2 >= 0; length2--) {
            if (charSequence.charAt(length) != charSequence2.charAt(length2)) {
                return false;
            }
            length--;
        }
        return true;
    }

    public static List<Rule> getInstance(NameType nameType, RuleType ruleType, Languages.LanguageSet languageSet) {
        Map<String, List<Rule>> instanceMap = getInstanceMap(nameType, ruleType, languageSet);
        ArrayList arrayList = new ArrayList();
        for (List<Rule> addAll : instanceMap.values()) {
            arrayList.addAll(addAll);
        }
        return arrayList;
    }

    public static List<Rule> getInstance(NameType nameType, RuleType ruleType, String str) {
        return getInstance(nameType, ruleType, Languages.LanguageSet.from(new HashSet(Arrays.asList(new String[]{str}))));
    }

    public static Map<String, List<Rule>> getInstanceMap(NameType nameType, RuleType ruleType, Languages.LanguageSet languageSet) {
        return getInstanceMap(nameType, ruleType, languageSet.isSingleton() ? languageSet.getAny() : Languages.ANY);
    }

    public static Map<String, List<Rule>> getInstanceMap(NameType nameType, RuleType ruleType, String str) {
        Map<String, List<Rule>> map = (Map) ((Map) RULES.get(nameType).get(ruleType)).get(str);
        if (map != null) {
            return map;
        }
        throw new IllegalArgumentException(String.format("No rules found for %s, %s, %s.", new Object[]{nameType.getName(), ruleType.getName(), str}));
    }

    private static Phoneme parsePhoneme(String str) {
        int indexOf = str.indexOf("[");
        if (indexOf < 0) {
            return new Phoneme((CharSequence) str, Languages.ANY_LANGUAGE);
        }
        if (str.endsWith("]")) {
            return new Phoneme((CharSequence) str.substring(0, indexOf), Languages.LanguageSet.from(new HashSet(Arrays.asList(str.substring(indexOf + 1, str.length() - 1).split("[+]")))));
        }
        throw new IllegalArgumentException("Phoneme expression contains a '[' but does not end in ']'");
    }

    private static PhonemeExpr parsePhonemeExpr(String str) {
        if (!str.startsWith("(")) {
            return parsePhoneme(str);
        }
        if (str.endsWith(")")) {
            ArrayList arrayList = new ArrayList();
            String substring = str.substring(1, str.length() - 1);
            for (String parsePhoneme : substring.split("[|]")) {
                arrayList.add(parsePhoneme(parsePhoneme));
            }
            if (substring.startsWith("|") || substring.endsWith("|")) {
                arrayList.add(new Phoneme((CharSequence) "", Languages.ANY_LANGUAGE));
            }
            return new PhonemeList(arrayList);
        }
        throw new IllegalArgumentException("Phoneme starts with '(' so must end with ')'");
    }

    private static Map<String, List<Rule>> parseRules(Scanner scanner, String str) {
        int i;
        String str2;
        String str3 = str;
        HashMap hashMap = new HashMap();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (scanner.hasNextLine()) {
            int i5 = i3 + 1;
            String nextLine = scanner.nextLine();
            if (i4 != 0) {
                i = i2;
                if (nextLine.endsWith("*/")) {
                    i4 = i;
                }
            } else if (nextLine.startsWith("/*")) {
                i = i2;
                i4 = 1;
            } else {
                int indexOf = nextLine.indexOf("//");
                String trim = (indexOf >= 0 ? nextLine.substring(i2, indexOf) : nextLine).trim();
                if (trim.length() == 0) {
                    continue;
                    i3 = i5;
                } else if (trim.startsWith(HASH_INCLUDE)) {
                    String trim2 = trim.substring(8).trim();
                    if (!trim2.contains(" ")) {
                        hashMap.putAll(parseRules(createScanner(trim2), str3 + "->" + trim2));
                        i = i2;
                    } else {
                        throw new IllegalArgumentException("Malformed import statement '" + nextLine + "' in " + str3);
                    }
                } else {
                    String[] split = trim.split("\\s+");
                    if (split.length == 4) {
                        try {
                            String stripQuotes = stripQuotes(split[i2]);
                            String stripQuotes2 = stripQuotes(split[1]);
                            String stripQuotes3 = stripQuotes(split[2]);
                            AnonymousClass2 r12 = r1;
                            str2 = "' in ";
                            try {
                                AnonymousClass2 r1 = new Rule(stripQuotes, stripQuotes2, stripQuotes3, parsePhonemeExpr(stripQuotes(split[3])), i5, str, stripQuotes, stripQuotes2, stripQuotes3) {
                                    private final String loc;
                                    private final int myLine;
                                    final /* synthetic */ int val$cLine;
                                    final /* synthetic */ String val$lCon;
                                    final /* synthetic */ String val$location;
                                    final /* synthetic */ String val$pat;
                                    final /* synthetic */ String val$rCon;

                                    {
                                        this.val$cLine = r5;
                                        this.val$location = r6;
                                        this.val$pat = r7;
                                        this.val$lCon = r8;
                                        this.val$rCon = r9;
                                        this.myLine = r5;
                                        this.loc = r6;
                                    }

                                    public String toString() {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("Rule");
                                        sb.append("{line=").append(this.myLine);
                                        sb.append(", loc='").append(this.loc).append('\'');
                                        sb.append(", pat='").append(this.val$pat).append('\'');
                                        sb.append(", lcon='").append(this.val$lCon).append('\'');
                                        sb.append(", rcon='").append(this.val$rCon).append('\'');
                                        sb.append('}');
                                        return sb.toString();
                                    }
                                };
                                i = 0;
                                String substring = r12.pattern.substring(0, 1);
                                List list = (List) hashMap.get(substring);
                                if (list == null) {
                                    list = new ArrayList();
                                    hashMap.put(substring, list);
                                }
                                list.add(r12);
                            } catch (IllegalArgumentException e) {
                                e = e;
                                throw new IllegalStateException("Problem parsing line '" + i5 + str2 + str3, e);
                            }
                        } catch (IllegalArgumentException e2) {
                            e = e2;
                            str2 = "' in ";
                            throw new IllegalStateException("Problem parsing line '" + i5 + str2 + str3, e);
                        }
                    } else {
                        throw new IllegalArgumentException("Malformed rule statement split into " + split.length + " parts: " + nextLine + " in " + str3);
                    }
                }
            }
            i2 = i;
            i3 = i5;
        }
        return hashMap;
    }

    private static RPattern pattern(String str) {
        boolean startsWith = str.startsWith("^");
        boolean endsWith = str.endsWith("$");
        int length = str.length();
        if (endsWith) {
            length--;
        }
        final String substring = str.substring(startsWith ? 1 : 0, length);
        if (substring.contains("[")) {
            boolean startsWith2 = substring.startsWith("[");
            boolean endsWith2 = substring.endsWith("]");
            if (startsWith2 && endsWith2) {
                final String substring2 = substring.substring(1, substring.length() - 1);
                if (!substring2.contains("[")) {
                    boolean startsWith3 = substring2.startsWith("^");
                    if (startsWith3) {
                        substring2 = substring2.substring(1);
                    }
                    final boolean z = !startsWith3;
                    if (startsWith && endsWith) {
                        return new RPattern() {
                            public boolean isMatch(CharSequence charSequence) {
                                return charSequence.length() == 1 && Rule.contains(substring2, charSequence.charAt(0)) == z;
                            }
                        };
                    }
                    if (startsWith) {
                        return new RPattern() {
                            public boolean isMatch(CharSequence charSequence) {
                                return charSequence.length() > 0 && Rule.contains(substring2, charSequence.charAt(0)) == z;
                            }
                        };
                    }
                    if (endsWith) {
                        return new RPattern() {
                            public boolean isMatch(CharSequence charSequence) {
                                return charSequence.length() > 0 && Rule.contains(substring2, charSequence.charAt(charSequence.length() - 1)) == z;
                            }
                        };
                    }
                }
            }
        } else if (!startsWith || !endsWith) {
            if ((startsWith || endsWith) && substring.length() == 0) {
                return ALL_STRINGS_RMATCHER;
            }
            if (startsWith) {
                return new RPattern() {
                    public boolean isMatch(CharSequence charSequence) {
                        return Rule.startsWith(charSequence, substring);
                    }
                };
            }
            if (endsWith) {
                return new RPattern() {
                    public boolean isMatch(CharSequence charSequence) {
                        return Rule.endsWith(charSequence, substring);
                    }
                };
            }
        } else if (substring.length() == 0) {
            return new RPattern() {
                public boolean isMatch(CharSequence charSequence) {
                    return charSequence.length() == 0;
                }
            };
        } else {
            return new RPattern() {
                public boolean isMatch(CharSequence charSequence) {
                    return charSequence.equals(substring);
                }
            };
        }
        return new RPattern(str) {
            Pattern pattern;
            final /* synthetic */ String val$regex;

            {
                this.val$regex = r1;
                this.pattern = Pattern.compile(r1);
            }

            public boolean isMatch(CharSequence charSequence) {
                return this.pattern.matcher(charSequence).find();
            }
        };
    }

    /* access modifiers changed from: private */
    public static boolean startsWith(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        for (int i = 0; i < charSequence2.length(); i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static String stripQuotes(String str) {
        if (str.startsWith(DOUBLE_QUOTE)) {
            str = str.substring(1);
        }
        return str.endsWith(DOUBLE_QUOTE) ? str.substring(0, str.length() - 1) : str;
    }

    public Rule(String str, String str2, String str3, PhonemeExpr phonemeExpr) {
        this.pattern = str;
        this.lContext = pattern(str2 + "$");
        this.rContext = pattern("^" + str3);
        this.phoneme = phonemeExpr;
    }

    public RPattern getLContext() {
        return this.lContext;
    }

    public String getPattern() {
        return this.pattern;
    }

    public PhonemeExpr getPhoneme() {
        return this.phoneme;
    }

    public RPattern getRContext() {
        return this.rContext;
    }

    public boolean patternAndContextMatches(CharSequence charSequence, int i) {
        if (i >= 0) {
            int length = this.pattern.length() + i;
            if (length <= charSequence.length() && charSequence.subSequence(i, length).equals(this.pattern) && this.rContext.isMatch(charSequence.subSequence(length, charSequence.length()))) {
                return this.lContext.isMatch(charSequence.subSequence(0, i));
            }
            return false;
        }
        throw new IndexOutOfBoundsException("Can not match pattern at negative indexes");
    }
}
