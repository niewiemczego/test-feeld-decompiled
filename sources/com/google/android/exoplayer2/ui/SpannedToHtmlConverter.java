package com.google.android.exoplayer2.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan;
import com.google.android.exoplayer2.text.span.RubySpan;
import com.google.android.exoplayer2.text.span.TextEmphasisSpan;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

final class SpannedToHtmlConverter {
    private static final Pattern NEWLINE_PATTERN = Pattern.compile("(&#13;)?&#10;");

    private static final class Transition {
        /* access modifiers changed from: private */
        public final List<SpanInfo> spansAdded = new ArrayList();
        /* access modifiers changed from: private */
        public final List<SpanInfo> spansRemoved = new ArrayList();
    }

    private static String getTextEmphasisPosition(int i) {
        return i != 2 ? "over right" : "under left";
    }

    private SpannedToHtmlConverter() {
    }

    public static HtmlAndCss convert(CharSequence charSequence, float f) {
        if (charSequence == null) {
            return new HtmlAndCss("", ImmutableMap.of());
        }
        if (!(charSequence instanceof Spanned)) {
            return new HtmlAndCss(escapeHtml(charSequence), ImmutableMap.of());
        }
        Spanned spanned = (Spanned) charSequence;
        HashSet<Integer> hashSet = new HashSet<>();
        int i = 0;
        for (BackgroundColorSpan backgroundColor : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
            hashSet.add(Integer.valueOf(backgroundColor.getBackgroundColor()));
        }
        HashMap hashMap = new HashMap();
        for (Integer intValue : hashSet) {
            int intValue2 = intValue.intValue();
            hashMap.put(HtmlUtils.cssAllClassDescendantsSelector("bg_" + intValue2), Util.formatInvariant("background-color:%s;", HtmlUtils.toCssRgba(intValue2)));
        }
        SparseArray<Transition> findSpanTransitions = findSpanTransitions(spanned, f);
        StringBuilder sb = new StringBuilder(spanned.length());
        int i2 = 0;
        while (i < findSpanTransitions.size()) {
            int keyAt = findSpanTransitions.keyAt(i);
            sb.append(escapeHtml(spanned.subSequence(i2, keyAt)));
            Transition transition = findSpanTransitions.get(keyAt);
            Collections.sort(transition.spansRemoved, SpanInfo.FOR_CLOSING_TAGS);
            for (SpanInfo spanInfo : transition.spansRemoved) {
                sb.append(spanInfo.closingTag);
            }
            Collections.sort(transition.spansAdded, SpanInfo.FOR_OPENING_TAGS);
            for (SpanInfo spanInfo2 : transition.spansAdded) {
                sb.append(spanInfo2.openingTag);
            }
            i++;
            i2 = keyAt;
        }
        sb.append(escapeHtml(spanned.subSequence(i2, spanned.length())));
        return new HtmlAndCss(sb.toString(), hashMap);
    }

    private static SparseArray<Transition> findSpanTransitions(Spanned spanned, float f) {
        SparseArray<Transition> sparseArray = new SparseArray<>();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String openingTag = getOpeningTag(obj, f);
            String closingTag = getClosingTag(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (openingTag != null) {
                Assertions.checkNotNull(closingTag);
                SpanInfo spanInfo = new SpanInfo(spanStart, spanEnd, openingTag, closingTag);
                getOrCreate(sparseArray, spanStart).spansAdded.add(spanInfo);
                getOrCreate(sparseArray, spanEnd).spansRemoved.add(spanInfo);
            }
        }
        return sparseArray;
    }

    private static String getOpeningTag(Object obj, float f) {
        float f2;
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return Util.formatInvariant("<span style='color:%s;'>", HtmlUtils.toCssRgba(((ForegroundColorSpan) obj).getForegroundColor()));
        } else if (obj instanceof BackgroundColorSpan) {
            return Util.formatInvariant("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        } else if (obj instanceof HorizontalTextInVerticalContextSpan) {
            return "<span style='text-combine-upright:all;'>";
        } else {
            if (obj instanceof AbsoluteSizeSpan) {
                AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
                if (absoluteSizeSpan.getDip()) {
                    f2 = (float) absoluteSizeSpan.getSize();
                } else {
                    f2 = ((float) absoluteSizeSpan.getSize()) / f;
                }
                return Util.formatInvariant("<span style='font-size:%.2fpx;'>", Float.valueOf(f2));
            } else if (obj instanceof RelativeSizeSpan) {
                return Util.formatInvariant("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
            } else if (obj instanceof TypefaceSpan) {
                String family = ((TypefaceSpan) obj).getFamily();
                if (family == null) {
                    return null;
                }
                return Util.formatInvariant("<span style='font-family:\"%s\";'>", family);
            } else if (obj instanceof StyleSpan) {
                int style = ((StyleSpan) obj).getStyle();
                if (style == 1) {
                    return "<b>";
                }
                if (style == 2) {
                    return "<i>";
                }
                if (style != 3) {
                    return null;
                }
                return "<b><i>";
            } else if (obj instanceof RubySpan) {
                int i = ((RubySpan) obj).position;
                if (i == -1) {
                    return "<ruby style='ruby-position:unset;'>";
                }
                if (i == 1) {
                    return "<ruby style='ruby-position:over;'>";
                }
                if (i != 2) {
                    return null;
                }
                return "<ruby style='ruby-position:under;'>";
            } else if (obj instanceof UnderlineSpan) {
                return "<u>";
            } else {
                if (!(obj instanceof TextEmphasisSpan)) {
                    return null;
                }
                TextEmphasisSpan textEmphasisSpan = (TextEmphasisSpan) obj;
                return Util.formatInvariant("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", getTextEmphasisStyle(textEmphasisSpan.markShape, textEmphasisSpan.markFill), getTextEmphasisPosition(textEmphasisSpan.position));
            }
        }
    }

    private static String getClosingTag(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof HorizontalTextInVerticalContextSpan) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof TextEmphasisSpan)) {
            return "</span>";
        }
        if (!(obj instanceof TypefaceSpan)) {
            if (obj instanceof StyleSpan) {
                int style = ((StyleSpan) obj).getStyle();
                if (style == 1) {
                    return "</b>";
                }
                if (style == 2) {
                    return "</i>";
                }
                if (style != 3) {
                    return null;
                }
                return "</i></b>";
            } else if (obj instanceof RubySpan) {
                return "<rt>" + escapeHtml(((RubySpan) obj).rubyText) + "</rt></ruby>";
            } else {
                if (obj instanceof UnderlineSpan) {
                    return "</u>";
                }
            }
            return null;
        } else if (((TypefaceSpan) obj).getFamily() != null) {
            return "</span>";
        } else {
            return null;
        }
    }

    private static String getTextEmphasisStyle(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (i2 == 1) {
            sb.append("filled ");
        } else if (i2 == 2) {
            sb.append("open ");
        }
        if (i == 0) {
            sb.append("none");
        } else if (i == 1) {
            sb.append(TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE);
        } else if (i == 2) {
            sb.append(TtmlNode.TEXT_EMPHASIS_MARK_DOT);
        } else if (i != 3) {
            sb.append("unset");
        } else {
            sb.append(TtmlNode.TEXT_EMPHASIS_MARK_SESAME);
        }
        return sb.toString();
    }

    private static Transition getOrCreate(SparseArray<Transition> sparseArray, int i) {
        Transition transition = sparseArray.get(i);
        if (transition != null) {
            return transition;
        }
        Transition transition2 = new Transition();
        sparseArray.put(i, transition2);
        return transition2;
    }

    private static String escapeHtml(CharSequence charSequence) {
        return NEWLINE_PATTERN.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    public static class HtmlAndCss {
        public final Map<String, String> cssRuleSets;
        public final String html;

        private HtmlAndCss(String str, Map<String, String> map) {
            this.html = str;
            this.cssRuleSets = map;
        }
    }

    private static final class SpanInfo {
        /* access modifiers changed from: private */
        public static final Comparator<SpanInfo> FOR_CLOSING_TAGS = new SpannedToHtmlConverter$SpanInfo$$ExternalSyntheticLambda1();
        /* access modifiers changed from: private */
        public static final Comparator<SpanInfo> FOR_OPENING_TAGS = new SpannedToHtmlConverter$SpanInfo$$ExternalSyntheticLambda0();
        public final String closingTag;
        public final int end;
        public final String openingTag;
        public final int start;

        static /* synthetic */ int lambda$static$0(SpanInfo spanInfo, SpanInfo spanInfo2) {
            int compare = Integer.compare(spanInfo2.end, spanInfo.end);
            if (compare != 0) {
                return compare;
            }
            int compareTo = spanInfo.openingTag.compareTo(spanInfo2.openingTag);
            if (compareTo != 0) {
                return compareTo;
            }
            return spanInfo.closingTag.compareTo(spanInfo2.closingTag);
        }

        static /* synthetic */ int lambda$static$1(SpanInfo spanInfo, SpanInfo spanInfo2) {
            int compare = Integer.compare(spanInfo2.start, spanInfo.start);
            if (compare != 0) {
                return compare;
            }
            int compareTo = spanInfo2.openingTag.compareTo(spanInfo.openingTag);
            if (compareTo != 0) {
                return compareTo;
            }
            return spanInfo2.closingTag.compareTo(spanInfo.closingTag);
        }

        private SpanInfo(int i, int i2, String str, String str2) {
            this.start = i;
            this.end = i2;
            this.openingTag = str;
            this.closingTag = str2;
        }
    }
}
