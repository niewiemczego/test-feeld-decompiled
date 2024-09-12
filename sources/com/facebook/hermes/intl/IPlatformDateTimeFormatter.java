package com.facebook.hermes.intl;

import com.braze.Constants;
import java.text.AttributedCharacterIterator;

public interface IPlatformDateTimeFormatter {
    void configure(ILocaleObject<?> iLocaleObject, String str, String str2, FormatMatcher formatMatcher, WeekDay weekDay, Era era, Year year, Month month, Day day, Hour hour, Minute minute, Second second, TimeZoneName timeZoneName, HourCycle hourCycle, Object obj) throws JSRangeErrorException;

    String fieldToString(AttributedCharacterIterator.Attribute attribute, String str);

    String format(double d) throws JSRangeErrorException;

    AttributedCharacterIterator formatToParts(double d) throws JSRangeErrorException;

    String[] getAvailableLocales();

    String getDefaultCalendarName(ILocaleObject<?> iLocaleObject) throws JSRangeErrorException;

    HourCycle getDefaultHourCycle(ILocaleObject<?> iLocaleObject) throws JSRangeErrorException;

    String getDefaultNumberingSystem(ILocaleObject<?> iLocaleObject) throws JSRangeErrorException;

    String getDefaultTimeZone(ILocaleObject<?> iLocaleObject) throws JSRangeErrorException;

    public enum FormatMatcher {
        BESTFIT,
        BASIC;

        public String toString() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$FormatMatcher[ordinal()];
            if (i == 1) {
                return Constants.LOCALEMATCHER_BESTFIT;
            }
            if (i == 2) {
                return "basic";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum HourCycle {
        H11,
        H12,
        H23,
        H24,
        UNDEFINED;

        public String toString() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$HourCycle[ordinal()];
            if (i == 1) {
                return "h11";
            }
            if (i == 2) {
                return "h12";
            }
            if (i == 3) {
                return "h23";
            }
            if (i == 4) {
                return "h24";
            }
            if (i == 5) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum WeekDay {
        LONG,
        SHORT,
        NARROW,
        UNDEFINED;

        public String toString() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$WeekDay[ordinal()];
            if (i == 1) {
                return "long";
            }
            if (i == 2) {
                return "short";
            }
            if (i == 3) {
                return "narrow";
            }
            if (i == 4) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String getSkeleonSymbol() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$WeekDay[ordinal()];
            if (i == 1) {
                return "EEEE";
            }
            if (i == 2) {
                return "EEE";
            }
            if (i == 3) {
                return "EEEEE";
            }
            if (i == 4) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum Era {
        LONG,
        SHORT,
        NARROW,
        UNDEFINED;

        public String toString() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Era[ordinal()];
            if (i == 1) {
                return "long";
            }
            if (i == 2) {
                return "short";
            }
            if (i == 3) {
                return "narrow";
            }
            if (i == 4) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String getSkeleonSymbol() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Era[ordinal()];
            if (i == 1) {
                return "GGGG";
            }
            if (i == 2) {
                return "GGG";
            }
            if (i == 3) {
                return "G5";
            }
            if (i == 4) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum Year {
        NUMERIC,
        DIGIT2,
        UNDEFINED;

        public String toString() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Year[ordinal()];
            if (i == 1) {
                return Constants.COLLATION_OPTION_NUMERIC;
            }
            if (i == 2) {
                return "2-digit";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String getSkeleonSymbol() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Year[ordinal()];
            if (i == 1) {
                return "yyyy";
            }
            if (i == 2) {
                return "yy";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum Month {
        NUMERIC,
        DIGIT2,
        LONG,
        SHORT,
        NARROW,
        UNDEFINED;

        public String toString() {
            switch (AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Month[ordinal()]) {
                case 1:
                    return Constants.COLLATION_OPTION_NUMERIC;
                case 2:
                    return "2-digit";
                case 3:
                    return "long";
                case 4:
                    return "short";
                case 5:
                    return "narrow";
                case 6:
                    return "";
                default:
                    throw new IllegalArgumentException();
            }
        }

        public String getSkeleonSymbol() {
            switch (AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Month[ordinal()]) {
                case 1:
                    return "M";
                case 2:
                    return "MM";
                case 3:
                    return "MMMM";
                case 4:
                    return "MMM";
                case 5:
                    return "MMMMM";
                case 6:
                    return "";
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    public enum Day {
        NUMERIC,
        DIGIT2,
        UNDEFINED;

        public String toString() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Day[ordinal()];
            if (i == 1) {
                return Constants.COLLATION_OPTION_NUMERIC;
            }
            if (i == 2) {
                return "2-digit";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String getSkeleonSymbol() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Day[ordinal()];
            if (i == 1) {
                return Constants.BRAZE_PUSH_NOTIFICATION_SOUND_DEFAULT_VALUE;
            }
            if (i == 2) {
                return "dd";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum Hour {
        NUMERIC,
        DIGIT2,
        UNDEFINED;

        public String toString() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Hour[ordinal()];
            if (i == 1) {
                return Constants.COLLATION_OPTION_NUMERIC;
            }
            if (i == 2) {
                return "2-digit";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String getSkeleonSymbol12() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Hour[ordinal()];
            if (i == 1) {
                return "h";
            }
            if (i == 2) {
                return "hh";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String getSkeleonSymbol24() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Hour[ordinal()];
            if (i == 1) {
                return "k";
            }
            if (i == 2) {
                return "kk";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum Minute {
        NUMERIC,
        DIGIT2,
        UNDEFINED;

        public String toString() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Minute[ordinal()];
            if (i == 1) {
                return Constants.COLLATION_OPTION_NUMERIC;
            }
            if (i == 2) {
                return "2-digit";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String getSkeleonSymbol() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Minute[ordinal()];
            if (i == 1) {
                return "m";
            }
            if (i == 2) {
                return "mm";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum Second {
        NUMERIC,
        DIGIT2,
        UNDEFINED;

        public String toString() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Second[ordinal()];
            if (i == 1) {
                return Constants.COLLATION_OPTION_NUMERIC;
            }
            if (i == 2) {
                return "2-digit";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String getSkeleonSymbol() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Second[ordinal()];
            if (i == 1) {
                return Constants.BRAZE_PUSH_SUMMARY_TEXT_KEY;
            }
            if (i == 2) {
                return "ss";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: com.facebook.hermes.intl.IPlatformDateTimeFormatter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Day;
        static final /* synthetic */ int[] $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Era;
        static final /* synthetic */ int[] $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$FormatMatcher;
        static final /* synthetic */ int[] $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Hour;
        static final /* synthetic */ int[] $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$HourCycle;
        static final /* synthetic */ int[] $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Minute;
        static final /* synthetic */ int[] $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Month;
        static final /* synthetic */ int[] $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Second;
        static final /* synthetic */ int[] $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$TimeZoneName;
        static final /* synthetic */ int[] $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$WeekDay;
        static final /* synthetic */ int[] $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Year;

        /* JADX WARNING: Can't wrap try/catch for region: R(80:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|21|22|23|24|25|26|27|29|30|31|32|(2:33|34)|35|37|38|39|40|(2:41|42)|43|45|46|47|48|(2:49|50)|51|(2:53|54)|55|57|58|(2:59|60)|61|63|64|65|66|(2:67|68)|69|71|72|73|74|75|76|(2:77|78)|79|81|82|83|84|85|86|87|88|89|91|92|93|94|95|96|97|98|(2:99|100)|101|103|104|(3:105|106|108)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(83:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|21|22|23|24|25|26|27|29|30|31|32|(2:33|34)|35|37|38|39|40|41|42|43|45|46|47|48|(2:49|50)|51|(2:53|54)|55|57|58|59|60|61|63|64|65|66|(2:67|68)|69|71|72|73|74|75|76|(2:77|78)|79|81|82|83|84|85|86|87|88|89|91|92|93|94|95|96|97|98|99|100|101|103|104|(3:105|106|108)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(84:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|21|22|23|24|25|26|27|29|30|31|32|(2:33|34)|35|37|38|39|40|41|42|43|45|46|47|48|(2:49|50)|51|53|54|55|57|58|59|60|61|63|64|65|66|(2:67|68)|69|71|72|73|74|75|76|(2:77|78)|79|81|82|83|84|85|86|87|88|89|91|92|93|94|95|96|97|98|99|100|101|103|104|(3:105|106|108)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(85:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|(2:17|18)|19|21|22|23|24|25|26|27|29|30|31|32|(2:33|34)|35|37|38|39|40|41|42|43|45|46|47|48|(2:49|50)|51|53|54|55|57|58|59|60|61|63|64|65|66|(2:67|68)|69|71|72|73|74|75|76|(2:77|78)|79|81|82|83|84|85|86|87|88|89|91|92|93|94|95|96|97|98|99|100|101|103|104|(3:105|106|108)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(87:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|(2:17|18)|19|21|22|23|24|25|26|27|29|30|31|32|(2:33|34)|35|37|38|39|40|41|42|43|45|46|47|48|49|50|51|53|54|55|57|58|59|60|61|63|64|65|66|67|68|69|71|72|73|74|75|76|(2:77|78)|79|81|82|83|84|85|86|87|88|89|91|92|93|94|95|96|97|98|99|100|101|103|104|(3:105|106|108)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(88:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|(2:17|18)|19|21|22|23|24|25|26|27|29|30|31|32|(2:33|34)|35|37|38|39|40|41|42|43|45|46|47|48|49|50|51|53|54|55|57|58|59|60|61|63|64|65|66|67|68|69|71|72|73|74|75|76|(2:77|78)|79|81|82|83|84|85|86|87|88|89|91|92|93|94|95|96|97|98|99|100|101|103|104|(3:105|106|108)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(90:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|(2:17|18)|19|21|22|23|24|25|26|27|29|30|31|32|(2:33|34)|35|37|38|39|40|41|42|43|45|46|47|48|49|50|51|53|54|55|57|58|59|60|61|63|64|65|66|67|68|69|71|72|73|74|75|76|(2:77|78)|79|81|82|83|84|85|86|87|88|89|91|92|93|94|95|96|97|98|99|100|101|103|104|105|106|108) */
        /* JADX WARNING: Can't wrap try/catch for region: R(93:0|1|2|3|5|6|7|9|10|11|13|14|15|16|(2:17|18)|19|21|22|23|24|25|26|27|29|30|31|32|33|34|35|37|38|39|40|41|42|43|45|46|47|48|49|50|51|53|54|55|57|58|59|60|61|63|64|65|66|67|68|69|71|72|73|74|75|76|77|78|79|81|82|83|84|85|86|87|88|89|91|92|93|94|95|96|97|98|99|100|101|103|104|105|106|108) */
        /* JADX WARNING: Can't wrap try/catch for region: R(94:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|29|30|31|32|33|34|35|37|38|39|40|41|42|43|45|46|47|48|49|50|51|53|54|55|57|58|59|60|61|63|64|65|66|67|68|69|71|72|73|74|75|76|77|78|79|81|82|83|84|85|86|87|88|89|91|92|93|94|95|96|97|98|99|100|101|103|104|105|106|108) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:105:0x01cf */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0068 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00b2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00cd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00d7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00f7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0113 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x011d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0138 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0142 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x014c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x0167 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x0171 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x017b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x0196 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x01a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:97:0x01aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:99:0x01b4 */
        static {
            /*
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$TimeZoneName[] r0 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.TimeZoneName.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$TimeZoneName = r0
                r1 = 1
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$TimeZoneName r2 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.TimeZoneName.LONG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$TimeZoneName     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$TimeZoneName r3 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.TimeZoneName.SHORT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$TimeZoneName     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$TimeZoneName r4 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.TimeZoneName.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Second[] r3 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Second.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Second = r3
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Second r4 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Second.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r3 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Second     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Second r4 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Second.DIGIT2     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Second     // Catch:{ NoSuchFieldError -> 0x004d }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Second r4 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Second.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x004d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Minute[] r3 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Minute.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Minute = r3
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Minute r4 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Minute.NUMERIC     // Catch:{ NoSuchFieldError -> 0x005e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r3 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Minute     // Catch:{ NoSuchFieldError -> 0x0068 }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Minute r4 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Minute.DIGIT2     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0068 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0068 }
            L_0x0068:
                int[] r3 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Minute     // Catch:{ NoSuchFieldError -> 0x0072 }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Minute r4 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Minute.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0072 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0072 }
            L_0x0072:
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Hour[] r3 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Hour.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Hour = r3
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Hour r4 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Hour.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r3 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Hour     // Catch:{ NoSuchFieldError -> 0x008d }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Hour r4 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Hour.DIGIT2     // Catch:{ NoSuchFieldError -> 0x008d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x008d }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x008d }
            L_0x008d:
                int[] r3 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Hour     // Catch:{ NoSuchFieldError -> 0x0097 }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Hour r4 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Hour.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0097 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0097 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0097 }
            L_0x0097:
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Day[] r3 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Day.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Day = r3
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Day r4 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Day.NUMERIC     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r3 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Day     // Catch:{ NoSuchFieldError -> 0x00b2 }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Day r4 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Day.DIGIT2     // Catch:{ NoSuchFieldError -> 0x00b2 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b2 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x00b2 }
            L_0x00b2:
                int[] r3 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Day     // Catch:{ NoSuchFieldError -> 0x00bc }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Day r4 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Day.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x00bc }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bc }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x00bc }
            L_0x00bc:
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Month[] r3 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Month.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Month = r3
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Month r4 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Month.NUMERIC     // Catch:{ NoSuchFieldError -> 0x00cd }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cd }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x00cd }
            L_0x00cd:
                int[] r3 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Month     // Catch:{ NoSuchFieldError -> 0x00d7 }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Month r4 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Month.DIGIT2     // Catch:{ NoSuchFieldError -> 0x00d7 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d7 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x00d7 }
            L_0x00d7:
                int[] r3 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Month     // Catch:{ NoSuchFieldError -> 0x00e1 }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Month r4 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Month.LONG     // Catch:{ NoSuchFieldError -> 0x00e1 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e1 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x00e1 }
            L_0x00e1:
                r3 = 4
                int[] r4 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Month     // Catch:{ NoSuchFieldError -> 0x00ec }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Month r5 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Month.SHORT     // Catch:{ NoSuchFieldError -> 0x00ec }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ec }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x00ec }
            L_0x00ec:
                r4 = 5
                int[] r5 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Month     // Catch:{ NoSuchFieldError -> 0x00f7 }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Month r6 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Month.NARROW     // Catch:{ NoSuchFieldError -> 0x00f7 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f7 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x00f7 }
            L_0x00f7:
                int[] r5 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Month     // Catch:{ NoSuchFieldError -> 0x0102 }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Month r6 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Month.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0102 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0102 }
                r7 = 6
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0102 }
            L_0x0102:
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Year[] r5 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Year.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Year = r5
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Year r6 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Year.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0113 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0113 }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0113 }
            L_0x0113:
                int[] r5 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Year     // Catch:{ NoSuchFieldError -> 0x011d }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Year r6 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Year.DIGIT2     // Catch:{ NoSuchFieldError -> 0x011d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x011d }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x011d }
            L_0x011d:
                int[] r5 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Year     // Catch:{ NoSuchFieldError -> 0x0127 }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Year r6 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Year.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0127 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0127 }
                r5[r6] = r2     // Catch:{ NoSuchFieldError -> 0x0127 }
            L_0x0127:
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Era[] r5 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Era.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Era = r5
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Era r6 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Era.LONG     // Catch:{ NoSuchFieldError -> 0x0138 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0138 }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0138 }
            L_0x0138:
                int[] r5 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Era     // Catch:{ NoSuchFieldError -> 0x0142 }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Era r6 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Era.SHORT     // Catch:{ NoSuchFieldError -> 0x0142 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0142 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0142 }
            L_0x0142:
                int[] r5 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Era     // Catch:{ NoSuchFieldError -> 0x014c }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Era r6 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Era.NARROW     // Catch:{ NoSuchFieldError -> 0x014c }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x014c }
                r5[r6] = r2     // Catch:{ NoSuchFieldError -> 0x014c }
            L_0x014c:
                int[] r5 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Era     // Catch:{ NoSuchFieldError -> 0x0156 }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$Era r6 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.Era.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0156 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0156 }
                r5[r6] = r3     // Catch:{ NoSuchFieldError -> 0x0156 }
            L_0x0156:
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$WeekDay[] r5 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.WeekDay.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$WeekDay = r5
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$WeekDay r6 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.WeekDay.LONG     // Catch:{ NoSuchFieldError -> 0x0167 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0167 }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0167 }
            L_0x0167:
                int[] r5 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$WeekDay     // Catch:{ NoSuchFieldError -> 0x0171 }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$WeekDay r6 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.WeekDay.SHORT     // Catch:{ NoSuchFieldError -> 0x0171 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0171 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0171 }
            L_0x0171:
                int[] r5 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$WeekDay     // Catch:{ NoSuchFieldError -> 0x017b }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$WeekDay r6 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.WeekDay.NARROW     // Catch:{ NoSuchFieldError -> 0x017b }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x017b }
                r5[r6] = r2     // Catch:{ NoSuchFieldError -> 0x017b }
            L_0x017b:
                int[] r5 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$WeekDay     // Catch:{ NoSuchFieldError -> 0x0185 }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$WeekDay r6 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.WeekDay.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0185 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0185 }
                r5[r6] = r3     // Catch:{ NoSuchFieldError -> 0x0185 }
            L_0x0185:
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$HourCycle[] r5 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.HourCycle.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$HourCycle = r5
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$HourCycle r6 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.HourCycle.H11     // Catch:{ NoSuchFieldError -> 0x0196 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0196 }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0196 }
            L_0x0196:
                int[] r5 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$HourCycle     // Catch:{ NoSuchFieldError -> 0x01a0 }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$HourCycle r6 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.HourCycle.H12     // Catch:{ NoSuchFieldError -> 0x01a0 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x01a0 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x01a0 }
            L_0x01a0:
                int[] r5 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$HourCycle     // Catch:{ NoSuchFieldError -> 0x01aa }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$HourCycle r6 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.HourCycle.H23     // Catch:{ NoSuchFieldError -> 0x01aa }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x01aa }
                r5[r6] = r2     // Catch:{ NoSuchFieldError -> 0x01aa }
            L_0x01aa:
                int[] r2 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$HourCycle     // Catch:{ NoSuchFieldError -> 0x01b4 }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$HourCycle r5 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.HourCycle.H24     // Catch:{ NoSuchFieldError -> 0x01b4 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x01b4 }
                r2[r5] = r3     // Catch:{ NoSuchFieldError -> 0x01b4 }
            L_0x01b4:
                int[] r2 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$HourCycle     // Catch:{ NoSuchFieldError -> 0x01be }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$HourCycle r3 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.HourCycle.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x01be }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x01be }
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x01be }
            L_0x01be:
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$FormatMatcher[] r2 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.FormatMatcher.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$FormatMatcher = r2
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$FormatMatcher r3 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.FormatMatcher.BESTFIT     // Catch:{ NoSuchFieldError -> 0x01cf }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x01cf }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x01cf }
            L_0x01cf:
                int[] r1 = $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$FormatMatcher     // Catch:{ NoSuchFieldError -> 0x01d9 }
                com.facebook.hermes.intl.IPlatformDateTimeFormatter$FormatMatcher r2 = com.facebook.hermes.intl.IPlatformDateTimeFormatter.FormatMatcher.BASIC     // Catch:{ NoSuchFieldError -> 0x01d9 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x01d9 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x01d9 }
            L_0x01d9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.hermes.intl.IPlatformDateTimeFormatter.AnonymousClass1.<clinit>():void");
        }
    }

    public enum TimeZoneName {
        LONG,
        SHORT,
        UNDEFINED;

        public String toString() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$TimeZoneName[ordinal()];
            if (i == 1) {
                return "long";
            }
            if (i == 2) {
                return "short";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String getSkeleonSymbol() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$TimeZoneName[ordinal()];
            if (i == 1) {
                return "VV";
            }
            if (i == 2) {
                return "O";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }
}
