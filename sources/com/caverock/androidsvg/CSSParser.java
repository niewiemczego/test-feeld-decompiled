package com.caverock.androidsvg;

import android.util.Log;
import androidx.webkit.ProxyConfig;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import com.facebook.react.uimanager.events.TouchesHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

class CSSParser {
    private static final String CLASS = "class";
    static final String CSS_MIME_TYPE = "text/css";
    private static final String ID = "id";
    private static final int SPECIFICITY_ATTRIBUTE_OR_PSEUDOCLASS = 1000;
    private static final int SPECIFICITY_ELEMENT_OR_PSEUDOELEMENT = 1;
    private static final int SPECIFICITY_ID_ATTRIBUTE = 1000000;
    private static final String TAG = "CSSParser";
    private MediaType deviceMediaType;
    private boolean inMediaRule;
    private Source source;

    private enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    private enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    enum MediaType {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        speech,
        tty,
        tv
    }

    private interface PseudoClass {
        boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase);
    }

    enum Source {
        Document,
        RenderOptions
    }

    private enum PseudoClassIdents {
        target,
        root,
        nth_child,
        nth_last_child,
        nth_of_type,
        nth_last_of_type,
        first_child,
        last_child,
        first_of_type,
        last_of_type,
        only_child,
        only_of_type,
        empty,
        not,
        lang,
        link,
        visited,
        hover,
        active,
        focus,
        enabled,
        disabled,
        checked,
        indeterminate,
        UNSUPPORTED;
        
        private static final Map<String, PseudoClassIdents> cache = null;

        static {
            cache = new HashMap();
            for (PseudoClassIdents pseudoClassIdents : values()) {
                if (pseudoClassIdents != UNSUPPORTED) {
                    cache.put(pseudoClassIdents.name().replace('_', '-'), pseudoClassIdents);
                }
            }
        }

        public static PseudoClassIdents fromString(String str) {
            PseudoClassIdents pseudoClassIdents = cache.get(str);
            if (pseudoClassIdents != null) {
                return pseudoClassIdents;
            }
            return UNSUPPORTED;
        }
    }

    private static class Attrib {
        public final String name;
        final AttribOp operation;
        public final String value;

        Attrib(String str, AttribOp attribOp, String str2) {
            this.name = str;
            this.operation = attribOp;
            this.value = str2;
        }
    }

    private static class SimpleSelector {
        List<Attrib> attribs = null;
        Combinator combinator = null;
        List<PseudoClass> pseudos = null;
        String tag = null;

        SimpleSelector(Combinator combinator2, String str) {
            this.combinator = combinator2 == null ? Combinator.DESCENDANT : combinator2;
            this.tag = str;
        }

        /* access modifiers changed from: package-private */
        public void addAttrib(String str, AttribOp attribOp, String str2) {
            if (this.attribs == null) {
                this.attribs = new ArrayList();
            }
            this.attribs.add(new Attrib(str, attribOp, str2));
        }

        /* access modifiers changed from: package-private */
        public void addPseudo(PseudoClass pseudoClass) {
            if (this.pseudos == null) {
                this.pseudos = new ArrayList();
            }
            this.pseudos.add(pseudoClass);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.combinator == Combinator.CHILD) {
                sb.append("> ");
            } else if (this.combinator == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            String str = this.tag;
            if (str == null) {
                str = ProxyConfig.MATCH_ALL_SCHEMES;
            }
            sb.append(str);
            List<Attrib> list = this.attribs;
            if (list != null) {
                for (Attrib next : list) {
                    sb.append('[').append(next.name);
                    int i = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp[next.operation.ordinal()];
                    if (i == 1) {
                        sb.append('=').append(next.value);
                    } else if (i == 2) {
                        sb.append("~=").append(next.value);
                    } else if (i == 3) {
                        sb.append("|=").append(next.value);
                    }
                    sb.append(']');
                }
            }
            List<PseudoClass> list2 = this.pseudos;
            if (list2 != null) {
                for (PseudoClass append : list2) {
                    sb.append(':').append(append);
                }
            }
            return sb.toString();
        }
    }

    static class Ruleset {
        private List<Rule> rules = null;

        Ruleset() {
        }

        /* access modifiers changed from: package-private */
        public void add(Rule rule) {
            if (this.rules == null) {
                this.rules = new ArrayList();
            }
            for (int i = 0; i < this.rules.size(); i++) {
                if (this.rules.get(i).selector.specificity > rule.selector.specificity) {
                    this.rules.add(i, rule);
                    return;
                }
            }
            this.rules.add(rule);
        }

        /* access modifiers changed from: package-private */
        public void addAll(Ruleset ruleset) {
            if (ruleset.rules != null) {
                if (this.rules == null) {
                    this.rules = new ArrayList(ruleset.rules.size());
                }
                for (Rule add : ruleset.rules) {
                    add(add);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public List<Rule> getRules() {
            return this.rules;
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            List<Rule> list = this.rules;
            return list == null || list.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public int ruleCount() {
            List<Rule> list = this.rules;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void removeFromSource(Source source) {
            List<Rule> list = this.rules;
            if (list != null) {
                Iterator<Rule> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().source == source) {
                        it.remove();
                    }
                }
            }
        }

        public String toString() {
            if (this.rules == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (Rule rule : this.rules) {
                sb.append(rule.toString()).append(10);
            }
            return sb.toString();
        }
    }

    static class Rule {
        Selector selector;
        Source source;
        SVG.Style style;

        Rule(Selector selector2, SVG.Style style2, Source source2) {
            this.selector = selector2;
            this.style = style2;
            this.source = source2;
        }

        public String toString() {
            return String.valueOf(this.selector) + " {...} (src=" + this.source + ")";
        }
    }

    private static class Selector {
        List<SimpleSelector> simpleSelectors;
        int specificity;

        private Selector() {
            this.simpleSelectors = null;
            this.specificity = 0;
        }

        /* synthetic */ Selector(AnonymousClass1 r1) {
            this();
        }

        /* access modifiers changed from: package-private */
        public void add(SimpleSelector simpleSelector) {
            if (this.simpleSelectors == null) {
                this.simpleSelectors = new ArrayList();
            }
            this.simpleSelectors.add(simpleSelector);
        }

        /* access modifiers changed from: package-private */
        public int size() {
            List<SimpleSelector> list = this.simpleSelectors;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* access modifiers changed from: package-private */
        public SimpleSelector get(int i) {
            return this.simpleSelectors.get(i);
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            List<SimpleSelector> list = this.simpleSelectors;
            return list == null || list.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public void addedIdAttribute() {
            this.specificity += 1000000;
        }

        /* access modifiers changed from: package-private */
        public void addedAttributeOrPseudo() {
            this.specificity += 1000;
        }

        /* access modifiers changed from: package-private */
        public void addedElement() {
            this.specificity++;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (SimpleSelector append : this.simpleSelectors) {
                sb.append(append).append(' ');
            }
            return sb.append('[').append(this.specificity).append(']').toString();
        }
    }

    CSSParser() {
        this(MediaType.screen, Source.Document);
    }

    CSSParser(Source source2) {
        this(MediaType.screen, source2);
    }

    CSSParser(MediaType mediaType, Source source2) {
        this.inMediaRule = false;
        this.deviceMediaType = mediaType;
        this.source = source2;
    }

    /* access modifiers changed from: package-private */
    public Ruleset parse(String str) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        cSSTextScanner.skipWhitespace();
        return parseRuleset(cSSTextScanner);
    }

    static boolean mediaMatches(String str, MediaType mediaType) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        cSSTextScanner.skipWhitespace();
        return mediaMatches(parseMediaList(cSSTextScanner), mediaType);
    }

    private static void warn(String str, Object... objArr) {
        Log.w(TAG, String.format(str, objArr));
    }

    private static class CSSTextScanner extends SVGParser.TextScanner {
        private int hexChar(int i) {
            if (i >= 48 && i <= 57) {
                return i - 48;
            }
            int i2 = 65;
            if (i < 65 || i > 70) {
                i2 = 97;
                if (i < 97 || i > 102) {
                    return -1;
                }
            }
            return (i - i2) + 10;
        }

        CSSTextScanner(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        /* access modifiers changed from: package-private */
        public String nextIdentifier() {
            int scanForIdentifier = scanForIdentifier();
            if (scanForIdentifier == this.position) {
                return null;
            }
            String substring = this.input.substring(this.position, scanForIdentifier);
            this.position = scanForIdentifier;
            return substring;
        }

        private int scanForIdentifier() {
            if (empty()) {
                return this.position;
            }
            int i = this.position;
            int i2 = this.position;
            int charAt = this.input.charAt(this.position);
            if (charAt == 45) {
                charAt = advanceChar();
            }
            if ((charAt >= 65 && charAt <= 90) || ((charAt >= 97 && charAt <= 122) || charAt == 95)) {
                int advanceChar = advanceChar();
                while (true) {
                    if ((advanceChar < 65 || advanceChar > 90) && ((advanceChar < 97 || advanceChar > 122) && !((advanceChar >= 48 && advanceChar <= 57) || advanceChar == 45 || advanceChar == 95))) {
                        break;
                    }
                    advanceChar = advanceChar();
                }
                i2 = this.position;
            }
            this.position = i;
            return i2;
        }

        /* access modifiers changed from: private */
        public List<Selector> nextSelectorGroup() throws CSSParseException {
            if (empty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(1);
            Selector selector = new Selector((AnonymousClass1) null);
            while (!empty() && nextSimpleSelector(selector)) {
                if (skipCommaWhitespace()) {
                    arrayList.add(selector);
                    selector = new Selector((AnonymousClass1) null);
                }
            }
            if (!selector.isEmpty()) {
                arrayList.add(selector);
            }
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x0130  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0135  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean nextSimpleSelector(com.caverock.androidsvg.CSSParser.Selector r11) throws com.caverock.androidsvg.CSSParseException {
            /*
                r10 = this;
                boolean r0 = r10.empty()
                r1 = 0
                if (r0 == 0) goto L_0x0008
                return r1
            L_0x0008:
                int r0 = r10.position
                boolean r2 = r11.isEmpty()
                r3 = 0
                if (r2 != 0) goto L_0x002d
                r2 = 62
                boolean r2 = r10.consume((char) r2)
                if (r2 == 0) goto L_0x001f
                com.caverock.androidsvg.CSSParser$Combinator r2 = com.caverock.androidsvg.CSSParser.Combinator.CHILD
                r10.skipWhitespace()
                goto L_0x002e
            L_0x001f:
                r2 = 43
                boolean r2 = r10.consume((char) r2)
                if (r2 == 0) goto L_0x002d
                com.caverock.androidsvg.CSSParser$Combinator r2 = com.caverock.androidsvg.CSSParser.Combinator.FOLLOWS
                r10.skipWhitespace()
                goto L_0x002e
            L_0x002d:
                r2 = r3
            L_0x002e:
                r4 = 42
                boolean r4 = r10.consume((char) r4)
                if (r4 == 0) goto L_0x003c
                com.caverock.androidsvg.CSSParser$SimpleSelector r4 = new com.caverock.androidsvg.CSSParser$SimpleSelector
                r4.<init>(r2, r3)
                goto L_0x004d
            L_0x003c:
                java.lang.String r4 = r10.nextIdentifier()
                if (r4 == 0) goto L_0x004c
                com.caverock.androidsvg.CSSParser$SimpleSelector r5 = new com.caverock.androidsvg.CSSParser$SimpleSelector
                r5.<init>(r2, r4)
                r11.addedElement()
                r4 = r5
                goto L_0x004d
            L_0x004c:
                r4 = r3
            L_0x004d:
                boolean r5 = r10.empty()
                if (r5 != 0) goto L_0x012e
                r5 = 46
                boolean r5 = r10.consume((char) r5)
                if (r5 == 0) goto L_0x007b
                if (r4 != 0) goto L_0x0062
                com.caverock.androidsvg.CSSParser$SimpleSelector r4 = new com.caverock.androidsvg.CSSParser$SimpleSelector
                r4.<init>(r2, r3)
            L_0x0062:
                java.lang.String r5 = r10.nextIdentifier()
                if (r5 == 0) goto L_0x0073
                com.caverock.androidsvg.CSSParser$AttribOp r6 = com.caverock.androidsvg.CSSParser.AttribOp.EQUALS
                java.lang.String r7 = "class"
                r4.addAttrib(r7, r6, r5)
                r11.addedAttributeOrPseudo()
                goto L_0x004d
            L_0x0073:
                com.caverock.androidsvg.CSSParseException r11 = new com.caverock.androidsvg.CSSParseException
                java.lang.String r0 = "Invalid \".class\" simpleSelectors"
                r11.<init>(r0)
                throw r11
            L_0x007b:
                r5 = 35
                boolean r5 = r10.consume((char) r5)
                if (r5 == 0) goto L_0x00a3
                if (r4 != 0) goto L_0x008a
                com.caverock.androidsvg.CSSParser$SimpleSelector r4 = new com.caverock.androidsvg.CSSParser$SimpleSelector
                r4.<init>(r2, r3)
            L_0x008a:
                java.lang.String r5 = r10.nextIdentifier()
                if (r5 == 0) goto L_0x009b
                com.caverock.androidsvg.CSSParser$AttribOp r6 = com.caverock.androidsvg.CSSParser.AttribOp.EQUALS
                java.lang.String r7 = "id"
                r4.addAttrib(r7, r6, r5)
                r11.addedIdAttribute()
                goto L_0x004d
            L_0x009b:
                com.caverock.androidsvg.CSSParseException r11 = new com.caverock.androidsvg.CSSParseException
                java.lang.String r0 = "Invalid \"#id\" simpleSelectors"
                r11.<init>(r0)
                throw r11
            L_0x00a3:
                r5 = 91
                boolean r5 = r10.consume((char) r5)
                if (r5 == 0) goto L_0x011a
                if (r4 != 0) goto L_0x00b2
                com.caverock.androidsvg.CSSParser$SimpleSelector r4 = new com.caverock.androidsvg.CSSParser$SimpleSelector
                r4.<init>(r2, r3)
            L_0x00b2:
                r10.skipWhitespace()
                java.lang.String r5 = r10.nextIdentifier()
                java.lang.String r6 = "Invalid attribute simpleSelectors"
                if (r5 == 0) goto L_0x0114
                r10.skipWhitespace()
                r7 = 61
                boolean r7 = r10.consume((char) r7)
                if (r7 == 0) goto L_0x00cb
                com.caverock.androidsvg.CSSParser$AttribOp r7 = com.caverock.androidsvg.CSSParser.AttribOp.EQUALS
                goto L_0x00e4
            L_0x00cb:
                java.lang.String r7 = "~="
                boolean r7 = r10.consume((java.lang.String) r7)
                if (r7 == 0) goto L_0x00d7
                com.caverock.androidsvg.CSSParser$AttribOp r7 = com.caverock.androidsvg.CSSParser.AttribOp.INCLUDES
                goto L_0x00e4
            L_0x00d7:
                java.lang.String r7 = "|="
                boolean r7 = r10.consume((java.lang.String) r7)
                if (r7 == 0) goto L_0x00e3
                com.caverock.androidsvg.CSSParser$AttribOp r7 = com.caverock.androidsvg.CSSParser.AttribOp.DASHMATCH
                goto L_0x00e4
            L_0x00e3:
                r7 = r3
            L_0x00e4:
                if (r7 == 0) goto L_0x00f9
                r10.skipWhitespace()
                java.lang.String r8 = r10.nextAttribValue()
                if (r8 == 0) goto L_0x00f3
                r10.skipWhitespace()
                goto L_0x00fa
            L_0x00f3:
                com.caverock.androidsvg.CSSParseException r11 = new com.caverock.androidsvg.CSSParseException
                r11.<init>(r6)
                throw r11
            L_0x00f9:
                r8 = r3
            L_0x00fa:
                r9 = 93
                boolean r9 = r10.consume((char) r9)
                if (r9 == 0) goto L_0x010e
                if (r7 != 0) goto L_0x0106
                com.caverock.androidsvg.CSSParser$AttribOp r7 = com.caverock.androidsvg.CSSParser.AttribOp.EXISTS
            L_0x0106:
                r4.addAttrib(r5, r7, r8)
                r11.addedAttributeOrPseudo()
                goto L_0x004d
            L_0x010e:
                com.caverock.androidsvg.CSSParseException r11 = new com.caverock.androidsvg.CSSParseException
                r11.<init>(r6)
                throw r11
            L_0x0114:
                com.caverock.androidsvg.CSSParseException r11 = new com.caverock.androidsvg.CSSParseException
                r11.<init>(r6)
                throw r11
            L_0x011a:
                r5 = 58
                boolean r5 = r10.consume((char) r5)
                if (r5 == 0) goto L_0x012e
                if (r4 != 0) goto L_0x0129
                com.caverock.androidsvg.CSSParser$SimpleSelector r4 = new com.caverock.androidsvg.CSSParser$SimpleSelector
                r4.<init>(r2, r3)
            L_0x0129:
                r10.parsePseudoClass(r11, r4)
                goto L_0x004d
            L_0x012e:
                if (r4 == 0) goto L_0x0135
                r11.add(r4)
                r11 = 1
                return r11
            L_0x0135:
                r10.position = r0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.CSSTextScanner.nextSimpleSelector(com.caverock.androidsvg.CSSParser$Selector):boolean");
        }

        private static class AnPlusB {
            public int a;
            public int b;

            AnPlusB(int i, int i2) {
                this.a = i;
                this.b = i2;
            }
        }

        private AnPlusB nextAnPlusB() throws CSSParseException {
            AnPlusB anPlusB;
            IntegerParser integerParser;
            if (empty()) {
                return null;
            }
            int i = this.position;
            if (!consume('(')) {
                return null;
            }
            skipWhitespace();
            int i2 = 1;
            if (consume("odd")) {
                anPlusB = new AnPlusB(2, 1);
            } else {
                int i3 = 0;
                if (consume("even")) {
                    anPlusB = new AnPlusB(2, 0);
                } else {
                    int i4 = (!consume('+') && consume('-')) ? -1 : 1;
                    IntegerParser parseInt = IntegerParser.parseInt(this.input, this.position, this.inputLength, false);
                    if (parseInt != null) {
                        this.position = parseInt.getEndPos();
                    }
                    if (consume('n') || consume('N')) {
                        if (parseInt == null) {
                            parseInt = new IntegerParser(1, this.position);
                        }
                        skipWhitespace();
                        boolean consume = consume('+');
                        if (!consume && (consume = consume('-'))) {
                            i2 = -1;
                        }
                        if (consume) {
                            skipWhitespace();
                            integerParser = IntegerParser.parseInt(this.input, this.position, this.inputLength, false);
                            if (integerParser != null) {
                                this.position = integerParser.getEndPos();
                            } else {
                                this.position = i;
                                return null;
                            }
                        } else {
                            integerParser = null;
                        }
                        int i5 = i2;
                        i2 = i4;
                        i4 = i5;
                    } else {
                        integerParser = parseInt;
                        parseInt = null;
                    }
                    int value = parseInt == null ? 0 : i2 * parseInt.value();
                    if (integerParser != null) {
                        i3 = i4 * integerParser.value();
                    }
                    anPlusB = new AnPlusB(value, i3);
                }
            }
            skipWhitespace();
            if (consume(')')) {
                return anPlusB;
            }
            this.position = i;
            return null;
        }

        private List<String> nextIdentListParam() throws CSSParseException {
            if (empty()) {
                return null;
            }
            int i = this.position;
            if (!consume('(')) {
                return null;
            }
            skipWhitespace();
            ArrayList arrayList = null;
            do {
                String nextIdentifier = nextIdentifier();
                if (nextIdentifier == null) {
                    this.position = i;
                    return null;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(nextIdentifier);
                skipWhitespace();
            } while (skipCommaWhitespace());
            if (consume(')')) {
                return arrayList;
            }
            this.position = i;
            return null;
        }

        private List<Selector> nextPseudoNotParam() throws CSSParseException {
            if (empty()) {
                return null;
            }
            int i = this.position;
            if (!consume('(')) {
                return null;
            }
            skipWhitespace();
            List<Selector> nextSelectorGroup = nextSelectorGroup();
            if (nextSelectorGroup == null) {
                this.position = i;
                return null;
            } else if (!consume(')')) {
                this.position = i;
                return null;
            } else {
                for (Selector next : nextSelectorGroup) {
                    if (next.simpleSelectors == null) {
                        break;
                    }
                    for (SimpleSelector next2 : next.simpleSelectors) {
                        if (next2.pseudos == null) {
                            continue;
                            break;
                        }
                        Iterator<PseudoClass> it = next2.pseudos.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (it.next() instanceof PseudoClassNot) {
                                    return null;
                                }
                            }
                        }
                    }
                }
                return nextSelectorGroup;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.caverock.androidsvg.CSSParser$PseudoClassAnPlusB} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.caverock.androidsvg.CSSParser$PseudoClassNot} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.caverock.androidsvg.CSSParser$PseudoClassAnPlusB} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: com.caverock.androidsvg.CSSParser$PseudoClassAnPlusB} */
        /* JADX WARNING: type inference failed for: r2v4, types: [com.caverock.androidsvg.CSSParser$PseudoClassOnlyChild] */
        /* JADX WARNING: type inference failed for: r2v7, types: [com.caverock.androidsvg.CSSParser$PseudoClassOnlyChild] */
        /* JADX WARNING: type inference failed for: r2v8, types: [com.caverock.androidsvg.CSSParser$PseudoClassRoot] */
        /* JADX WARNING: type inference failed for: r2v9, types: [com.caverock.androidsvg.CSSParser$PseudoClassEmpty] */
        /* JADX WARNING: type inference failed for: r2v20, types: [com.caverock.androidsvg.CSSParser$PseudoClassTarget] */
        /* JADX WARNING: type inference failed for: r2v21, types: [com.caverock.androidsvg.CSSParser$PseudoClassNotSupported] */
        /* JADX WARNING: type inference failed for: r2v22, types: [com.caverock.androidsvg.CSSParser$PseudoClassNotSupported] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 7 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void parsePseudoClass(com.caverock.androidsvg.CSSParser.Selector r21, com.caverock.androidsvg.CSSParser.SimpleSelector r22) throws com.caverock.androidsvg.CSSParseException {
            /*
                r20 = this;
                r0 = r22
                java.lang.String r1 = r20.nextIdentifier()
                if (r1 == 0) goto L_0x014d
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r2 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.fromString(r1)
                int[] r3 = com.caverock.androidsvg.CSSParser.AnonymousClass1.$SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents
                int r4 = r2.ordinal()
                r3 = r3[r4]
                java.lang.String r4 = "Invalid or missing parameter section for pseudo class: "
                r5 = 1
                r6 = 0
                r7 = 0
                switch(r3) {
                    case 1: goto L_0x0135;
                    case 2: goto L_0x0124;
                    case 3: goto L_0x0119;
                    case 4: goto L_0x0104;
                    case 5: goto L_0x00f2;
                    case 6: goto L_0x00e5;
                    case 7: goto L_0x00d9;
                    case 8: goto L_0x00cd;
                    case 9: goto L_0x0086;
                    case 10: goto L_0x0086;
                    case 11: goto L_0x0086;
                    case 12: goto L_0x0086;
                    case 13: goto L_0x0056;
                    case 14: goto L_0x004c;
                    case 15: goto L_0x003f;
                    case 16: goto L_0x0035;
                    case 17: goto L_0x0035;
                    case 18: goto L_0x0035;
                    case 19: goto L_0x0035;
                    case 20: goto L_0x0035;
                    case 21: goto L_0x0035;
                    case 22: goto L_0x0035;
                    case 23: goto L_0x0035;
                    case 24: goto L_0x0035;
                    default: goto L_0x001c;
                }
            L_0x001c:
                com.caverock.androidsvg.CSSParseException r0 = new com.caverock.androidsvg.CSSParseException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Unsupported pseudo class: "
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.StringBuilder r1 = r2.append(r1)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0035:
                com.caverock.androidsvg.CSSParser$PseudoClassNotSupported r2 = new com.caverock.androidsvg.CSSParser$PseudoClassNotSupported
                r2.<init>(r1)
                r21.addedAttributeOrPseudo()
                goto L_0x0149
            L_0x003f:
                r20.nextIdentListParam()
                com.caverock.androidsvg.CSSParser$PseudoClassNotSupported r2 = new com.caverock.androidsvg.CSSParser$PseudoClassNotSupported
                r2.<init>(r1)
                r21.addedAttributeOrPseudo()
                goto L_0x0149
            L_0x004c:
                com.caverock.androidsvg.CSSParser$PseudoClassTarget r2 = new com.caverock.androidsvg.CSSParser$PseudoClassTarget
                r2.<init>(r7)
                r21.addedAttributeOrPseudo()
                goto L_0x0149
            L_0x0056:
                java.util.List r2 = r20.nextPseudoNotParam()
                if (r2 == 0) goto L_0x006f
                com.caverock.androidsvg.CSSParser$PseudoClassNot r1 = new com.caverock.androidsvg.CSSParser$PseudoClassNot
                r1.<init>(r2)
                r2 = r1
                com.caverock.androidsvg.CSSParser$PseudoClassNot r2 = (com.caverock.androidsvg.CSSParser.PseudoClassNot) r2
                int r2 = r1.getSpecificity()
                r3 = r21
                r3.specificity = r2
            L_0x006c:
                r2 = r1
                goto L_0x0149
            L_0x006f:
                com.caverock.androidsvg.CSSParseException r0 = new com.caverock.androidsvg.CSSParseException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.StringBuilder r2 = r2.append(r4)
                java.lang.StringBuilder r1 = r2.append(r1)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0086:
                r3 = r21
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r7 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_child
                if (r2 == r7) goto L_0x0093
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r7 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_of_type
                if (r2 != r7) goto L_0x0091
                goto L_0x0093
            L_0x0091:
                r11 = r6
                goto L_0x0094
            L_0x0093:
                r11 = r5
            L_0x0094:
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r7 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_of_type
                if (r2 == r7) goto L_0x009f
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r7 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_last_of_type
                if (r2 != r7) goto L_0x009d
                goto L_0x009f
            L_0x009d:
                r12 = r6
                goto L_0x00a0
            L_0x009f:
                r12 = r5
            L_0x00a0:
                com.caverock.androidsvg.CSSParser$CSSTextScanner$AnPlusB r2 = r20.nextAnPlusB()
                if (r2 == 0) goto L_0x00b6
                com.caverock.androidsvg.CSSParser$PseudoClassAnPlusB r1 = new com.caverock.androidsvg.CSSParser$PseudoClassAnPlusB
                int r9 = r2.a
                int r10 = r2.b
                java.lang.String r13 = r0.tag
                r8 = r1
                r8.<init>(r9, r10, r11, r12, r13)
                r21.addedAttributeOrPseudo()
                goto L_0x006c
            L_0x00b6:
                com.caverock.androidsvg.CSSParseException r0 = new com.caverock.androidsvg.CSSParseException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.StringBuilder r2 = r2.append(r4)
                java.lang.StringBuilder r1 = r2.append(r1)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00cd:
                r3 = r21
                com.caverock.androidsvg.CSSParser$PseudoClassEmpty r2 = new com.caverock.androidsvg.CSSParser$PseudoClassEmpty
                r2.<init>(r7)
                r21.addedAttributeOrPseudo()
                goto L_0x0149
            L_0x00d9:
                r3 = r21
                com.caverock.androidsvg.CSSParser$PseudoClassRoot r2 = new com.caverock.androidsvg.CSSParser$PseudoClassRoot
                r2.<init>(r7)
                r21.addedAttributeOrPseudo()
                goto L_0x0149
            L_0x00e5:
                r3 = r21
                com.caverock.androidsvg.CSSParser$PseudoClassOnlyChild r2 = new com.caverock.androidsvg.CSSParser$PseudoClassOnlyChild
                java.lang.String r1 = r0.tag
                r2.<init>(r5, r1)
                r21.addedAttributeOrPseudo()
                goto L_0x0149
            L_0x00f2:
                r3 = r21
                com.caverock.androidsvg.CSSParser$PseudoClassAnPlusB r2 = new com.caverock.androidsvg.CSSParser$PseudoClassAnPlusB
                r7 = 0
                r8 = 1
                r9 = 0
                r10 = 1
                java.lang.String r11 = r0.tag
                r6 = r2
                r6.<init>(r7, r8, r9, r10, r11)
                r21.addedAttributeOrPseudo()
                goto L_0x0149
            L_0x0104:
                r3 = r21
                com.caverock.androidsvg.CSSParser$PseudoClassAnPlusB r2 = new com.caverock.androidsvg.CSSParser$PseudoClassAnPlusB
                r13 = 0
                r14 = 1
                r15 = 1
                r16 = 1
                java.lang.String r1 = r0.tag
                r12 = r2
                r17 = r1
                r12.<init>(r13, r14, r15, r16, r17)
                r21.addedAttributeOrPseudo()
                goto L_0x0149
            L_0x0119:
                r3 = r21
                com.caverock.androidsvg.CSSParser$PseudoClassOnlyChild r2 = new com.caverock.androidsvg.CSSParser$PseudoClassOnlyChild
                r2.<init>(r6, r7)
                r21.addedAttributeOrPseudo()
                goto L_0x0149
            L_0x0124:
                r3 = r21
                com.caverock.androidsvg.CSSParser$PseudoClassAnPlusB r2 = new com.caverock.androidsvg.CSSParser$PseudoClassAnPlusB
                r9 = 0
                r10 = 1
                r11 = 0
                r12 = 0
                r13 = 0
                r8 = r2
                r8.<init>(r9, r10, r11, r12, r13)
                r21.addedAttributeOrPseudo()
                goto L_0x0149
            L_0x0135:
                r3 = r21
                com.caverock.androidsvg.CSSParser$PseudoClassAnPlusB r2 = new com.caverock.androidsvg.CSSParser$PseudoClassAnPlusB
                r15 = 0
                r16 = 1
                r17 = 1
                r18 = 0
                r19 = 0
                r14 = r2
                r14.<init>(r15, r16, r17, r18, r19)
                r21.addedAttributeOrPseudo()
            L_0x0149:
                r0.addPseudo(r2)
                return
            L_0x014d:
                com.caverock.androidsvg.CSSParseException r0 = new com.caverock.androidsvg.CSSParseException
                java.lang.String r1 = "Invalid pseudo class"
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.CSSTextScanner.parsePseudoClass(com.caverock.androidsvg.CSSParser$Selector, com.caverock.androidsvg.CSSParser$SimpleSelector):void");
        }

        private String nextAttribValue() {
            if (empty()) {
                return null;
            }
            String nextQuotedString = nextQuotedString();
            if (nextQuotedString != null) {
                return nextQuotedString;
            }
            return nextIdentifier();
        }

        /* access modifiers changed from: package-private */
        public String nextPropertyValue() {
            if (empty()) {
                return null;
            }
            int i = this.position;
            int i2 = this.position;
            int charAt = this.input.charAt(this.position);
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !isEOL(charAt)) {
                if (!isWhitespace(charAt)) {
                    i2 = this.position + 1;
                }
                charAt = advanceChar();
            }
            if (this.position > i) {
                return this.input.substring(i, i2);
            }
            this.position = i;
            return null;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0057, code lost:
            r2 = nextChar().intValue();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String nextCSSString() {
            /*
                r8 = this;
                boolean r0 = r8.empty()
                r1 = 0
                if (r0 == 0) goto L_0x0008
                return r1
            L_0x0008:
                java.lang.String r0 = r8.input
                int r2 = r8.position
                char r0 = r0.charAt(r2)
                r2 = 39
                if (r0 == r2) goto L_0x0019
                r2 = 34
                if (r0 == r2) goto L_0x0019
                return r1
            L_0x0019:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                int r2 = r8.position
                r3 = 1
                int r2 = r2 + r3
                r8.position = r2
                java.lang.Integer r2 = r8.nextChar()
                int r2 = r2.intValue()
            L_0x002c:
                r4 = -1
                if (r2 == r4) goto L_0x0087
                if (r2 == r0) goto L_0x0087
                r5 = 92
                if (r2 != r5) goto L_0x007a
                java.lang.Integer r2 = r8.nextChar()
                int r2 = r2.intValue()
                if (r2 != r4) goto L_0x0040
                goto L_0x002c
            L_0x0040:
                r5 = 10
                if (r2 == r5) goto L_0x0071
                r5 = 13
                if (r2 == r5) goto L_0x0071
                r5 = 12
                if (r2 != r5) goto L_0x004d
                goto L_0x0071
            L_0x004d:
                int r5 = r8.hexChar(r2)
                if (r5 == r4) goto L_0x007a
                r6 = r3
            L_0x0054:
                r7 = 5
                if (r6 > r7) goto L_0x006c
                java.lang.Integer r2 = r8.nextChar()
                int r2 = r2.intValue()
                int r7 = r8.hexChar(r2)
                if (r7 != r4) goto L_0x0066
                goto L_0x006c
            L_0x0066:
                int r5 = r5 * 16
                int r5 = r5 + r7
                int r6 = r6 + 1
                goto L_0x0054
            L_0x006c:
                char r4 = (char) r5
                r1.append(r4)
                goto L_0x002c
            L_0x0071:
                java.lang.Integer r2 = r8.nextChar()
                int r2 = r2.intValue()
                goto L_0x002c
            L_0x007a:
                char r2 = (char) r2
                r1.append(r2)
                java.lang.Integer r2 = r8.nextChar()
                int r2 = r2.intValue()
                goto L_0x002c
            L_0x0087:
                java.lang.String r0 = r1.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.CSSTextScanner.nextCSSString():java.lang.String");
        }

        /* access modifiers changed from: package-private */
        public String nextURL() {
            if (empty()) {
                return null;
            }
            int i = this.position;
            if (!consume("url(")) {
                return null;
            }
            skipWhitespace();
            String nextCSSString = nextCSSString();
            if (nextCSSString == null) {
                nextCSSString = nextLegacyURL();
            }
            if (nextCSSString == null) {
                this.position = i;
                return null;
            }
            skipWhitespace();
            if (empty() || consume(")")) {
                return nextCSSString;
            }
            this.position = i;
            return null;
        }

        /* access modifiers changed from: package-private */
        public String nextLegacyURL() {
            char charAt;
            int hexChar;
            StringBuilder sb = new StringBuilder();
            while (!empty() && (charAt = this.input.charAt(this.position)) != '\'' && charAt != '\"' && charAt != '(' && charAt != ')' && !isWhitespace(charAt) && !Character.isISOControl(charAt)) {
                this.position++;
                if (charAt == '\\') {
                    if (!empty()) {
                        String str = this.input;
                        int i = this.position;
                        this.position = i + 1;
                        charAt = str.charAt(i);
                        if (!(charAt == 10 || charAt == 13 || charAt == 12)) {
                            int hexChar2 = hexChar(charAt);
                            if (hexChar2 != -1) {
                                for (int i2 = 1; i2 <= 5 && !empty() && (hexChar = hexChar(this.input.charAt(this.position))) != -1; i2++) {
                                    this.position++;
                                    hexChar2 = (hexChar2 * 16) + hexChar;
                                }
                                sb.append((char) hexChar2);
                            }
                        }
                    }
                }
                sb.append((char) charAt);
            }
            if (sb.length() == 0) {
                return null;
            }
            return sb.toString();
        }
    }

    /* renamed from: com.caverock.androidsvg.CSSParser$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp;
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents;

        /* JADX WARNING: Can't wrap try/catch for region: R(54:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|(3:59|60|62)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|62) */
        /* JADX WARNING: Can't wrap try/catch for region: R(57:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|62) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|62) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|62) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0131 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x013b */
        static {
            /*
                com.caverock.androidsvg.CSSParser$PseudoClassIdents[] r0 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents = r0
                r1 = 1
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r2 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.first_child     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x001d }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r3 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.last_child     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.only_child     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.first_of_type     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x003e }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.last_of_type     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.only_of_type     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.root     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r5 = 7
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.empty     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r5 = 8
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x006c }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_child     // Catch:{ NoSuchFieldError -> 0x006c }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r5 = 9
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_last_child     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r5 = 10
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_of_type     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r5 = 11
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_last_of_type     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r5 = 12
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x009c }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.not     // Catch:{ NoSuchFieldError -> 0x009c }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r5 = 13
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.target     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r5 = 14
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.lang     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r5 = 15
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.link     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r5 = 16
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.visited     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r5 = 17
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.hover     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r5 = 18
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.active     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r5 = 19
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.focus     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r5 = 20
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.enabled     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r5 = 21
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x0108 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.disabled     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r5 = 22
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x0114 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.checked     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r5 = 23
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents     // Catch:{ NoSuchFieldError -> 0x0120 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.indeterminate     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r5 = 24
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                com.caverock.androidsvg.CSSParser$AttribOp[] r3 = com.caverock.androidsvg.CSSParser.AttribOp.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp = r3
                com.caverock.androidsvg.CSSParser$AttribOp r4 = com.caverock.androidsvg.CSSParser.AttribOp.EQUALS     // Catch:{ NoSuchFieldError -> 0x0131 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0131 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0131 }
            L_0x0131:
                int[] r1 = $SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp     // Catch:{ NoSuchFieldError -> 0x013b }
                com.caverock.androidsvg.CSSParser$AttribOp r3 = com.caverock.androidsvg.CSSParser.AttribOp.INCLUDES     // Catch:{ NoSuchFieldError -> 0x013b }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x013b }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x013b }
            L_0x013b:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp     // Catch:{ NoSuchFieldError -> 0x0145 }
                com.caverock.androidsvg.CSSParser$AttribOp r1 = com.caverock.androidsvg.CSSParser.AttribOp.DASHMATCH     // Catch:{ NoSuchFieldError -> 0x0145 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0145 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0145 }
            L_0x0145:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.AnonymousClass1.<clinit>():void");
        }
    }

    private static boolean mediaMatches(List<MediaType> list, MediaType mediaType) {
        for (MediaType next : list) {
            if (next == MediaType.all) {
                return true;
            }
            if (next == mediaType) {
                return true;
            }
        }
        return false;
    }

    private static List<MediaType> parseMediaList(CSSTextScanner cSSTextScanner) {
        String nextWord;
        ArrayList arrayList = new ArrayList();
        while (!cSSTextScanner.empty() && (nextWord = cSSTextScanner.nextWord()) != null) {
            try {
                arrayList.add(MediaType.valueOf(nextWord));
            } catch (IllegalArgumentException unused) {
            }
            if (!cSSTextScanner.skipCommaWhitespace()) {
                break;
            }
        }
        return arrayList;
    }

    private void parseAtRule(Ruleset ruleset, CSSTextScanner cSSTextScanner) throws CSSParseException {
        String nextIdentifier = cSSTextScanner.nextIdentifier();
        cSSTextScanner.skipWhitespace();
        if (nextIdentifier != null) {
            if (!this.inMediaRule && nextIdentifier.equals("media")) {
                List<MediaType> parseMediaList = parseMediaList(cSSTextScanner);
                if (cSSTextScanner.consume('{')) {
                    cSSTextScanner.skipWhitespace();
                    if (mediaMatches(parseMediaList, this.deviceMediaType)) {
                        this.inMediaRule = true;
                        ruleset.addAll(parseRuleset(cSSTextScanner));
                        this.inMediaRule = false;
                    } else {
                        parseRuleset(cSSTextScanner);
                    }
                    if (!cSSTextScanner.empty() && !cSSTextScanner.consume('}')) {
                        throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
                    }
                } else {
                    throw new CSSParseException("Invalid @media rule: missing rule set");
                }
            } else if (this.inMediaRule || !nextIdentifier.equals("import")) {
                warn("Ignoring @%s rule", nextIdentifier);
                skipAtRule(cSSTextScanner);
            } else {
                String nextURL = cSSTextScanner.nextURL();
                if (nextURL == null) {
                    nextURL = cSSTextScanner.nextCSSString();
                }
                if (nextURL != null) {
                    cSSTextScanner.skipWhitespace();
                    List<MediaType> parseMediaList2 = parseMediaList(cSSTextScanner);
                    if (!cSSTextScanner.empty() && !cSSTextScanner.consume(';')) {
                        throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
                    } else if (SVG.getFileResolver() != null && mediaMatches(parseMediaList2, this.deviceMediaType)) {
                        String resolveCSSStyleSheet = SVG.getFileResolver().resolveCSSStyleSheet(nextURL);
                        if (resolveCSSStyleSheet != null) {
                            ruleset.addAll(parse(resolveCSSStyleSheet));
                        } else {
                            return;
                        }
                    }
                } else {
                    throw new CSSParseException("Invalid @import rule: expected string or url()");
                }
            }
            cSSTextScanner.skipWhitespace();
            return;
        }
        throw new CSSParseException("Invalid '@' rule");
    }

    private void skipAtRule(CSSTextScanner cSSTextScanner) {
        int i = 0;
        while (!cSSTextScanner.empty()) {
            int intValue = cSSTextScanner.nextChar().intValue();
            if (intValue != 59 || i != 0) {
                if (intValue == 123) {
                    i++;
                } else if (intValue == 125 && i > 0 && i - 1 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private Ruleset parseRuleset(CSSTextScanner cSSTextScanner) {
        Ruleset ruleset = new Ruleset();
        while (!cSSTextScanner.empty()) {
            try {
                if (!cSSTextScanner.consume("<!--")) {
                    if (!cSSTextScanner.consume("-->")) {
                        if (!cSSTextScanner.consume('@')) {
                            if (!parseRule(ruleset, cSSTextScanner)) {
                                break;
                            }
                        } else {
                            parseAtRule(ruleset, cSSTextScanner);
                        }
                    }
                }
            } catch (CSSParseException e) {
                Log.e(TAG, "CSS parser terminated early due to error: " + e.getMessage());
            }
        }
        return ruleset;
    }

    private boolean parseRule(Ruleset ruleset, CSSTextScanner cSSTextScanner) throws CSSParseException {
        List<Selector> access$400 = cSSTextScanner.nextSelectorGroup();
        if (access$400 == null || access$400.isEmpty()) {
            return false;
        }
        if (cSSTextScanner.consume('{')) {
            cSSTextScanner.skipWhitespace();
            SVG.Style parseDeclarations = parseDeclarations(cSSTextScanner);
            cSSTextScanner.skipWhitespace();
            for (Selector rule : access$400) {
                ruleset.add(new Rule(rule, parseDeclarations, this.source));
            }
            return true;
        }
        throw new CSSParseException("Malformed rule block: expected '{'");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.caverock.androidsvg.SVG.Style parseDeclarations(com.caverock.androidsvg.CSSParser.CSSTextScanner r5) throws com.caverock.androidsvg.CSSParseException {
        /*
            r4 = this;
            com.caverock.androidsvg.SVG$Style r0 = new com.caverock.androidsvg.SVG$Style
            r0.<init>()
        L_0x0005:
            java.lang.String r1 = r5.nextIdentifier()
            r5.skipWhitespace()
            r2 = 58
            boolean r2 = r5.consume((char) r2)
            if (r2 == 0) goto L_0x0061
            r5.skipWhitespace()
            java.lang.String r2 = r5.nextPropertyValue()
            if (r2 == 0) goto L_0x0059
            r5.skipWhitespace()
            r3 = 33
            boolean r3 = r5.consume((char) r3)
            if (r3 == 0) goto L_0x003f
            r5.skipWhitespace()
            java.lang.String r3 = "important"
            boolean r3 = r5.consume((java.lang.String) r3)
            if (r3 == 0) goto L_0x0037
            r5.skipWhitespace()
            goto L_0x003f
        L_0x0037:
            com.caverock.androidsvg.CSSParseException r5 = new com.caverock.androidsvg.CSSParseException
            java.lang.String r0 = "Malformed rule set: found unexpected '!'"
            r5.<init>(r0)
            throw r5
        L_0x003f:
            r3 = 59
            r5.consume((char) r3)
            com.caverock.androidsvg.SVGParser.processStyleProperty(r0, r1, r2)
            r5.skipWhitespace()
            boolean r1 = r5.empty()
            if (r1 != 0) goto L_0x0058
            r1 = 125(0x7d, float:1.75E-43)
            boolean r1 = r5.consume((char) r1)
            if (r1 == 0) goto L_0x0005
        L_0x0058:
            return r0
        L_0x0059:
            com.caverock.androidsvg.CSSParseException r5 = new com.caverock.androidsvg.CSSParseException
            java.lang.String r0 = "Expected property value"
            r5.<init>(r0)
            throw r5
        L_0x0061:
            com.caverock.androidsvg.CSSParseException r5 = new com.caverock.androidsvg.CSSParseException
            java.lang.String r0 = "Expected ':'"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.parseDeclarations(com.caverock.androidsvg.CSSParser$CSSTextScanner):com.caverock.androidsvg.SVG$Style");
    }

    public static List<String> parseClassAttribute(String str) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        ArrayList arrayList = null;
        while (!cSSTextScanner.empty()) {
            String nextToken = cSSTextScanner.nextToken();
            if (nextToken != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(nextToken);
                cSSTextScanner.skipWhitespace();
            }
        }
        return arrayList;
    }

    static class RuleMatchContext {
        SVG.SvgElementBase targetElement;

        RuleMatchContext() {
        }

        public String toString() {
            SVG.SvgElementBase svgElementBase = this.targetElement;
            if (svgElementBase == null) {
                return "";
            }
            return String.format("<%s id=\"%s\">", new Object[]{svgElementBase.getNodeName(), this.targetElement.id});
        }
    }

    static boolean ruleMatch(RuleMatchContext ruleMatchContext, Selector selector, SVG.SvgElementBase svgElementBase) {
        ArrayList arrayList = new ArrayList();
        for (SVG.SvgContainer svgContainer = svgElementBase.parent; svgContainer != null; svgContainer = ((SVG.SvgObject) svgContainer).parent) {
            arrayList.add(0, svgContainer);
        }
        int size = arrayList.size() - 1;
        if (selector.size() == 1) {
            return selectorMatch(ruleMatchContext, selector.get(0), arrayList, size, svgElementBase);
        }
        return ruleMatch(ruleMatchContext, selector, selector.size() - 1, arrayList, size, svgElementBase);
    }

    private static boolean ruleMatch(RuleMatchContext ruleMatchContext, Selector selector, int i, List<SVG.SvgContainer> list, int i2, SVG.SvgElementBase svgElementBase) {
        SimpleSelector simpleSelector = selector.get(i);
        if (!selectorMatch(ruleMatchContext, simpleSelector, list, i2, svgElementBase)) {
            return false;
        }
        if (simpleSelector.combinator == Combinator.DESCENDANT) {
            if (i == 0) {
                return true;
            }
            for (int i3 = i2; i3 >= 0; i3--) {
                if (ruleMatchOnAncestors(ruleMatchContext, selector, i - 1, list, i3)) {
                    return true;
                }
            }
            return false;
        } else if (simpleSelector.combinator == Combinator.CHILD) {
            return ruleMatchOnAncestors(ruleMatchContext, selector, i - 1, list, i2);
        } else {
            int childPosition = getChildPosition(list, i2, svgElementBase);
            if (childPosition <= 0) {
                return false;
            }
            return ruleMatch(ruleMatchContext, selector, i - 1, list, i2, (SVG.SvgElementBase) svgElementBase.parent.getChildren().get(childPosition - 1));
        }
    }

    private static boolean ruleMatchOnAncestors(RuleMatchContext ruleMatchContext, Selector selector, int i, List<SVG.SvgContainer> list, int i2) {
        SimpleSelector simpleSelector = selector.get(i);
        SVG.SvgElementBase svgElementBase = (SVG.SvgElementBase) list.get(i2);
        if (!selectorMatch(ruleMatchContext, simpleSelector, list, i2, svgElementBase)) {
            return false;
        }
        if (simpleSelector.combinator == Combinator.DESCENDANT) {
            if (i == 0) {
                return true;
            }
            int i3 = i2;
            while (i3 > 0) {
                i3--;
                if (ruleMatchOnAncestors(ruleMatchContext, selector, i - 1, list, i3)) {
                    return true;
                }
            }
            return false;
        } else if (simpleSelector.combinator == Combinator.CHILD) {
            return ruleMatchOnAncestors(ruleMatchContext, selector, i - 1, list, i2 - 1);
        } else {
            int childPosition = getChildPosition(list, i2, svgElementBase);
            if (childPosition <= 0) {
                return false;
            }
            return ruleMatch(ruleMatchContext, selector, i - 1, list, i2, (SVG.SvgElementBase) svgElementBase.parent.getChildren().get(childPosition - 1));
        }
    }

    private static int getChildPosition(List<SVG.SvgContainer> list, int i, SVG.SvgElementBase svgElementBase) {
        int i2 = 0;
        if (i < 0) {
            return 0;
        }
        if (list.get(i) != svgElementBase.parent) {
            return -1;
        }
        for (SVG.SvgObject svgObject : svgElementBase.parent.getChildren()) {
            if (svgObject == svgElementBase) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private static boolean selectorMatch(RuleMatchContext ruleMatchContext, SimpleSelector simpleSelector, List<SVG.SvgContainer> list, int i, SVG.SvgElementBase svgElementBase) {
        if (simpleSelector.tag != null && !simpleSelector.tag.equals(svgElementBase.getNodeName().toLowerCase(Locale.US))) {
            return false;
        }
        if (simpleSelector.attribs != null) {
            for (Attrib next : simpleSelector.attribs) {
                String str = next.name;
                str.hashCode();
                if (!str.equals("id")) {
                    if (!str.equals("class") || svgElementBase.classNames == null || !svgElementBase.classNames.contains(next.value)) {
                        return false;
                    }
                } else if (!next.value.equals(svgElementBase.id)) {
                    return false;
                }
            }
        }
        if (simpleSelector.pseudos == null) {
            return true;
        }
        for (PseudoClass matches : simpleSelector.pseudos) {
            if (!matches.matches(ruleMatchContext, svgElementBase)) {
                return false;
            }
        }
        return true;
    }

    private static class PseudoClassAnPlusB implements PseudoClass {
        private int a;
        private int b;
        private boolean isFromStart;
        private boolean isOfType;
        private String nodeName;

        PseudoClassAnPlusB(int i, int i2, boolean z, boolean z2, String str) {
            this.a = i;
            this.b = i2;
            this.isFromStart = z;
            this.isOfType = z2;
            this.nodeName = str;
        }

        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            int i;
            int i2;
            String nodeName2 = (!this.isOfType || this.nodeName != null) ? this.nodeName : svgElementBase.getNodeName();
            if (svgElementBase.parent != null) {
                Iterator<SVG.SvgObject> it = svgElementBase.parent.getChildren().iterator();
                i2 = 0;
                i = 0;
                while (it.hasNext()) {
                    SVG.SvgElementBase svgElementBase2 = (SVG.SvgElementBase) it.next();
                    if (svgElementBase2 == svgElementBase) {
                        i2 = i;
                    }
                    if (nodeName2 == null || svgElementBase2.getNodeName().equals(nodeName2)) {
                        i++;
                    }
                }
            } else {
                i2 = 0;
                i = 1;
            }
            int i3 = this.isFromStart ? i2 + 1 : i - i2;
            int i4 = this.a;
            if (i4 != 0) {
                int i5 = this.b;
                if ((i3 - i5) % i4 != 0) {
                    return false;
                }
                if (Integer.signum(i3 - i5) == 0 || Integer.signum(i3 - this.b) == Integer.signum(this.a)) {
                    return true;
                }
                return false;
            } else if (i3 == this.b) {
                return true;
            } else {
                return false;
            }
        }

        public String toString() {
            String str = this.isFromStart ? "" : "last-";
            if (this.isOfType) {
                return String.format("nth-%schild(%dn%+d of type <%s>)", new Object[]{str, Integer.valueOf(this.a), Integer.valueOf(this.b), this.nodeName});
            }
            return String.format("nth-%schild(%dn%+d)", new Object[]{str, Integer.valueOf(this.a), Integer.valueOf(this.b)});
        }
    }

    private static class PseudoClassOnlyChild implements PseudoClass {
        private boolean isOfType;
        private String nodeName;

        public PseudoClassOnlyChild(boolean z, String str) {
            this.isOfType = z;
            this.nodeName = str;
        }

        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            int i;
            String nodeName2 = (!this.isOfType || this.nodeName != null) ? this.nodeName : svgElementBase.getNodeName();
            if (svgElementBase.parent != null) {
                Iterator<SVG.SvgObject> it = svgElementBase.parent.getChildren().iterator();
                i = 0;
                while (it.hasNext()) {
                    SVG.SvgElementBase svgElementBase2 = (SVG.SvgElementBase) it.next();
                    if (nodeName2 == null || svgElementBase2.getNodeName().equals(nodeName2)) {
                        i++;
                    }
                }
            } else {
                i = 1;
            }
            if (i == 1) {
                return true;
            }
            return false;
        }

        public String toString() {
            if (!this.isOfType) {
                return String.format("only-child", new Object[0]);
            }
            return String.format("only-of-type <%s>", new Object[]{this.nodeName});
        }
    }

    private static class PseudoClassRoot implements PseudoClass {
        public String toString() {
            return "root";
        }

        private PseudoClassRoot() {
        }

        /* synthetic */ PseudoClassRoot(AnonymousClass1 r1) {
            this();
        }

        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return svgElementBase.parent == null;
        }
    }

    private static class PseudoClassEmpty implements PseudoClass {
        public String toString() {
            return "empty";
        }

        private PseudoClassEmpty() {
        }

        /* synthetic */ PseudoClassEmpty(AnonymousClass1 r1) {
            this();
        }

        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            if (!(svgElementBase instanceof SVG.SvgContainer) || ((SVG.SvgContainer) svgElementBase).getChildren().size() == 0) {
                return true;
            }
            return false;
        }
    }

    private static class PseudoClassNot implements PseudoClass {
        private List<Selector> selectorGroup;

        PseudoClassNot(List<Selector> list) {
            this.selectorGroup = list;
        }

        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            for (Selector ruleMatch : this.selectorGroup) {
                if (CSSParser.ruleMatch(ruleMatchContext, ruleMatch, svgElementBase)) {
                    return false;
                }
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public int getSpecificity() {
            int i = Integer.MIN_VALUE;
            for (Selector next : this.selectorGroup) {
                if (next.specificity > i) {
                    i = next.specificity;
                }
            }
            return i;
        }

        public String toString() {
            return "not(" + this.selectorGroup + ")";
        }
    }

    private static class PseudoClassTarget implements PseudoClass {
        public String toString() {
            return TouchesHelper.TARGET_KEY;
        }

        private PseudoClassTarget() {
        }

        /* synthetic */ PseudoClassTarget(AnonymousClass1 r1) {
            this();
        }

        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return ruleMatchContext != null && svgElementBase == ruleMatchContext.targetElement;
        }
    }

    private static class PseudoClassNotSupported implements PseudoClass {
        private String clazz;

        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return false;
        }

        PseudoClassNotSupported(String str) {
            this.clazz = str;
        }

        public String toString() {
            return this.clazz;
        }
    }
}
