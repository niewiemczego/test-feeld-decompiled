package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import com.facebook.appevents.UserDataStore;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.google.common.base.Ascii;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class TtmlDecoder extends SimpleSubtitleDecoder {
    private static final String ATTR_BEGIN = "begin";
    private static final String ATTR_DURATION = "dur";
    private static final String ATTR_END = "end";
    private static final String ATTR_IMAGE = "backgroundImage";
    private static final String ATTR_REGION = "region";
    private static final String ATTR_STYLE = "style";
    private static final Pattern CELL_RESOLUTION = Pattern.compile("^(\\d+) (\\d+)$");
    private static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final CellResolution DEFAULT_CELL_RESOLUTION = new CellResolution(32, 15);
    private static final FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE = new FrameAndTickRate(30.0f, 1, 1);
    private static final int DEFAULT_FRAME_RATE = 30;
    private static final Pattern FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    static final Pattern PERCENTAGE_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern PIXEL_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    static final Pattern SIGNED_PERCENTAGE = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    private static final String TAG = "TtmlDecoder";
    private static final String TTP = "http://www.w3.org/ns/ttml#parameter";
    private final XmlPullParserFactory xmlParserFactory;

    public TtmlDecoder() {
        super(TAG);
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.xmlParserFactory = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* access modifiers changed from: protected */
    public Subtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        FrameAndTickRate frameAndTickRate;
        try {
            XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new TtmlRegion(""));
            TtsExtent ttsExtent = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), (String) null);
            ArrayDeque arrayDeque = new ArrayDeque();
            FrameAndTickRate frameAndTickRate2 = DEFAULT_FRAME_AND_TICK_RATE;
            CellResolution cellResolution = DEFAULT_CELL_RESOLUTION;
            int i2 = 0;
            TtmlSubtitle ttmlSubtitle = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) arrayDeque.peek();
                if (i2 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if (TtmlNode.TAG_TT.equals(name)) {
                            frameAndTickRate2 = parseFrameAndTickRates(newPullParser);
                            cellResolution = parseCellResolution(newPullParser, DEFAULT_CELL_RESOLUTION);
                            ttsExtent = parseTtsExtent(newPullParser);
                        }
                        TtsExtent ttsExtent2 = ttsExtent;
                        FrameAndTickRate frameAndTickRate3 = frameAndTickRate2;
                        CellResolution cellResolution2 = cellResolution;
                        if (!isSupportedTag(name)) {
                            Log.i(TAG, "Ignoring unsupported tag: " + newPullParser.getName());
                            i2++;
                            frameAndTickRate2 = frameAndTickRate3;
                        } else {
                            if (TtmlNode.TAG_HEAD.equals(name)) {
                                frameAndTickRate = frameAndTickRate3;
                                parseHeader(newPullParser, hashMap, cellResolution2, ttsExtent2, hashMap2, hashMap3);
                            } else {
                                frameAndTickRate = frameAndTickRate3;
                                try {
                                    TtmlNode parseNode = parseNode(newPullParser, ttmlNode, hashMap2, frameAndTickRate);
                                    arrayDeque.push(parseNode);
                                    if (ttmlNode != null) {
                                        ttmlNode.addChild(parseNode);
                                    }
                                } catch (SubtitleDecoderException e) {
                                    Log.w(TAG, "Suppressing parser error", e);
                                    i2++;
                                }
                            }
                            frameAndTickRate2 = frameAndTickRate;
                        }
                        ttsExtent = ttsExtent2;
                        cellResolution = cellResolution2;
                    } else if (eventType == 4) {
                        ((TtmlNode) Assertions.checkNotNull(ttmlNode)).addChild(TtmlNode.buildTextNode(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals(TtmlNode.TAG_TT)) {
                            ttmlSubtitle = new TtmlSubtitle((TtmlNode) Assertions.checkNotNull((TtmlNode) arrayDeque.peek()), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                newPullParser.next();
            }
            if (ttmlSubtitle != null) {
                return ttmlSubtitle;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (XmlPullParserException e2) {
            throw new SubtitleDecoderException("Unable to decode source", e2);
        } catch (IOException e3) {
            throw new IllegalStateException("Unexpected error when reading input.", e3);
        }
    }

    private static FrameAndTickRate parseFrameAndTickRates(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue(TTP, "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        float f = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue(TTP, "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] split = Util.split(attributeValue2, " ");
            if (split.length == 2) {
                f = ((float) Integer.parseInt(split[0])) / ((float) Integer.parseInt(split[1]));
            } else {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
        }
        FrameAndTickRate frameAndTickRate = DEFAULT_FRAME_AND_TICK_RATE;
        int i = frameAndTickRate.subFrameRate;
        String attributeValue3 = xmlPullParser.getAttributeValue(TTP, "subFrameRate");
        if (attributeValue3 != null) {
            i = Integer.parseInt(attributeValue3);
        }
        int i2 = frameAndTickRate.tickRate;
        String attributeValue4 = xmlPullParser.getAttributeValue(TTP, "tickRate");
        if (attributeValue4 != null) {
            i2 = Integer.parseInt(attributeValue4);
        }
        return new FrameAndTickRate(((float) parseInt) * f, i, i2);
    }

    private static CellResolution parseCellResolution(XmlPullParser xmlPullParser, CellResolution cellResolution) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue(TTP, "cellResolution");
        if (attributeValue == null) {
            return cellResolution;
        }
        Matcher matcher = CELL_RESOLUTION.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.w(TAG, "Ignoring malformed cell resolution: " + attributeValue);
            return cellResolution;
        }
        try {
            int parseInt = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1)));
            int parseInt2 = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2)));
            if (parseInt != 0 && parseInt2 != 0) {
                return new CellResolution(parseInt, parseInt2);
            }
            throw new SubtitleDecoderException("Invalid cell resolution " + parseInt + " " + parseInt2);
        } catch (NumberFormatException unused) {
            Log.w(TAG, "Ignoring malformed cell resolution: " + attributeValue);
            return cellResolution;
        }
    }

    private static TtsExtent parseTtsExtent(XmlPullParser xmlPullParser) {
        String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_TTS_EXTENT);
        if (attributeValue == null) {
            return null;
        }
        Matcher matcher = PIXEL_COORDINATES.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.w(TAG, "Ignoring non-pixel tts extent: " + attributeValue);
            return null;
        }
        try {
            return new TtsExtent(Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1))), Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2))));
        } catch (NumberFormatException unused) {
            Log.w(TAG, "Ignoring malformed tts extent: " + attributeValue);
            return null;
        }
    }

    private static Map<String, TtmlStyle> parseHeader(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, CellResolution cellResolution, TtsExtent ttsExtent, Map<String, TtmlRegion> map2, Map<String, String> map3) throws IOException, XmlPullParserException {
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "style")) {
                String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "style");
                TtmlStyle parseStyleAttributes = parseStyleAttributes(xmlPullParser, new TtmlStyle());
                if (attributeValue != null) {
                    for (String str : parseStyleIds(attributeValue)) {
                        parseStyleAttributes.chain(map.get(str));
                    }
                }
                String id = parseStyleAttributes.getId();
                if (id != null) {
                    map.put(id, parseStyleAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "region")) {
                TtmlRegion parseRegionAttributes = parseRegionAttributes(xmlPullParser, cellResolution, ttsExtent);
                if (parseRegionAttributes != null) {
                    map2.put(parseRegionAttributes.id, parseRegionAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, TtmlNode.TAG_METADATA)) {
                parseMetadata(xmlPullParser, map3);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, TtmlNode.TAG_HEAD));
        return map;
    }

    private static void parseMetadata(XmlPullParser xmlPullParser, Map<String, String> map) throws IOException, XmlPullParserException {
        String attributeValue;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "image") && (attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "id")) != null) {
                map.put(attributeValue, xmlPullParser.nextText());
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, TtmlNode.TAG_METADATA));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01b0, code lost:
        if (r0.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.VERTICAL) == false) goto L_0x0192;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0183  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.text.ttml.TtmlRegion parseRegionAttributes(org.xmlpull.v1.XmlPullParser r17, com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution r18, com.google.android.exoplayer2.text.ttml.TtmlDecoder.TtsExtent r19) {
        /*
            r0 = r17
            r1 = r19
            java.lang.String r2 = "id"
            java.lang.String r4 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(r0, r2)
            r2 = 0
            if (r4 != 0) goto L_0x000e
            return r2
        L_0x000e:
            java.lang.String r3 = "origin"
            java.lang.String r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(r0, r3)
            java.lang.String r5 = "TtmlDecoder"
            if (r3 == 0) goto L_0x0226
            java.util.regex.Pattern r6 = PERCENTAGE_COORDINATES
            java.util.regex.Matcher r7 = r6.matcher(r3)
            java.util.regex.Pattern r8 = PIXEL_COORDINATES
            java.util.regex.Matcher r9 = r8.matcher(r3)
            boolean r10 = r7.matches()
            java.lang.String r11 = "Ignoring region with malformed origin: "
            java.lang.String r12 = "Ignoring region with missing tts:extent: "
            r13 = 1120403456(0x42c80000, float:100.0)
            r14 = 2
            r15 = 1
            if (r10 == 0) goto L_0x006b
            java.lang.String r9 = r7.group(r15)     // Catch:{ NumberFormatException -> 0x0056 }
            java.lang.Object r9 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r9)     // Catch:{ NumberFormatException -> 0x0056 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ NumberFormatException -> 0x0056 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0056 }
            float r9 = r9 / r13
            java.lang.String r7 = r7.group(r14)     // Catch:{ NumberFormatException -> 0x0056 }
            java.lang.Object r7 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r7)     // Catch:{ NumberFormatException -> 0x0056 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ NumberFormatException -> 0x0056 }
            float r7 = java.lang.Float.parseFloat(r7)     // Catch:{ NumberFormatException -> 0x0056 }
            float r7 = r7 / r13
            r16 = r9
            r9 = r7
            r7 = r16
            goto L_0x00ae
        L_0x0056:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r11)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        L_0x006b:
            boolean r7 = r9.matches()
            if (r7 == 0) goto L_0x020f
            if (r1 != 0) goto L_0x0088
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r12)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        L_0x0088:
            java.lang.String r7 = r9.group(r15)     // Catch:{ NumberFormatException -> 0x01fa }
            java.lang.Object r7 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r7)     // Catch:{ NumberFormatException -> 0x01fa }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ NumberFormatException -> 0x01fa }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x01fa }
            java.lang.String r9 = r9.group(r14)     // Catch:{ NumberFormatException -> 0x01fa }
            java.lang.Object r9 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r9)     // Catch:{ NumberFormatException -> 0x01fa }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ NumberFormatException -> 0x01fa }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x01fa }
            float r7 = (float) r7     // Catch:{ NumberFormatException -> 0x01fa }
            int r10 = r1.width     // Catch:{ NumberFormatException -> 0x01fa }
            float r10 = (float) r10     // Catch:{ NumberFormatException -> 0x01fa }
            float r7 = r7 / r10
            float r9 = (float) r9     // Catch:{ NumberFormatException -> 0x01fa }
            int r10 = r1.height     // Catch:{ NumberFormatException -> 0x01fa }
            float r10 = (float) r10
            float r9 = r9 / r10
        L_0x00ae:
            java.lang.String r10 = "extent"
            java.lang.String r10 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(r0, r10)
            if (r10 == 0) goto L_0x01f4
            java.util.regex.Matcher r6 = r6.matcher(r10)
            java.util.regex.Matcher r8 = r8.matcher(r10)
            boolean r10 = r6.matches()
            java.lang.String r11 = "Ignoring region with malformed extent: "
            if (r10 == 0) goto L_0x00fb
            java.lang.String r1 = r6.group(r15)     // Catch:{ NumberFormatException -> 0x00e6 }
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r1)     // Catch:{ NumberFormatException -> 0x00e6 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NumberFormatException -> 0x00e6 }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x00e6 }
            float r1 = r1 / r13
            java.lang.String r6 = r6.group(r14)     // Catch:{ NumberFormatException -> 0x00e6 }
            java.lang.Object r6 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r6)     // Catch:{ NumberFormatException -> 0x00e6 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ NumberFormatException -> 0x00e6 }
            float r2 = java.lang.Float.parseFloat(r6)     // Catch:{ NumberFormatException -> 0x00e6 }
            float r2 = r2 / r13
            r10 = r2
            goto L_0x0140
        L_0x00e6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r11)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        L_0x00fb:
            boolean r6 = r8.matches()
            if (r6 == 0) goto L_0x01dd
            if (r1 != 0) goto L_0x0118
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r12)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        L_0x0118:
            java.lang.String r6 = r8.group(r15)     // Catch:{ NumberFormatException -> 0x01c8 }
            java.lang.Object r6 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r6)     // Catch:{ NumberFormatException -> 0x01c8 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ NumberFormatException -> 0x01c8 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x01c8 }
            java.lang.String r8 = r8.group(r14)     // Catch:{ NumberFormatException -> 0x01c8 }
            java.lang.Object r8 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r8)     // Catch:{ NumberFormatException -> 0x01c8 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ NumberFormatException -> 0x01c8 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x01c8 }
            float r6 = (float) r6     // Catch:{ NumberFormatException -> 0x01c8 }
            int r10 = r1.width     // Catch:{ NumberFormatException -> 0x01c8 }
            float r10 = (float) r10     // Catch:{ NumberFormatException -> 0x01c8 }
            float r6 = r6 / r10
            float r8 = (float) r8     // Catch:{ NumberFormatException -> 0x01c8 }
            int r1 = r1.height     // Catch:{ NumberFormatException -> 0x01c8 }
            float r1 = (float) r1
            float r8 = r8 / r1
            r1 = r6
            r10 = r8
        L_0x0140:
            java.lang.String r2 = "displayAlign"
            java.lang.String r2 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(r0, r2)
            r3 = 0
            if (r2 == 0) goto L_0x016d
            java.lang.String r2 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r2)
            r2.hashCode()
            java.lang.String r5 = "center"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x0165
            java.lang.String r5 = "after"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x0161
            goto L_0x016d
        L_0x0161:
            float r9 = r9 + r10
            r6 = r9
            r8 = r14
            goto L_0x016f
        L_0x0165:
            r2 = 1073741824(0x40000000, float:2.0)
            float r2 = r10 / r2
            float r9 = r9 + r2
            r6 = r9
            r8 = r15
            goto L_0x016f
        L_0x016d:
            r8 = r3
            r6 = r9
        L_0x016f:
            r2 = 1065353216(0x3f800000, float:1.0)
            r5 = r18
            int r5 = r5.rows
            float r5 = (float) r5
            float r12 = r2 / r5
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.String r5 = "writingMode"
            java.lang.String r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(r0, r5)
            if (r0 == 0) goto L_0x01bb
            java.lang.String r0 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r0)
            r0.hashCode()
            r5 = -1
            int r9 = r0.hashCode()
            switch(r9) {
                case 3694: goto L_0x01aa;
                case 3553396: goto L_0x019f;
                case 3553576: goto L_0x0194;
                default: goto L_0x0192;
            }
        L_0x0192:
            r3 = r5
            goto L_0x01b3
        L_0x0194:
            java.lang.String r3 = "tbrl"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x019d
            goto L_0x0192
        L_0x019d:
            r3 = r14
            goto L_0x01b3
        L_0x019f:
            java.lang.String r3 = "tblr"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x01a8
            goto L_0x0192
        L_0x01a8:
            r3 = r15
            goto L_0x01b3
        L_0x01aa:
            java.lang.String r9 = "tb"
            boolean r0 = r0.equals(r9)
            if (r0 != 0) goto L_0x01b3
            goto L_0x0192
        L_0x01b3:
            switch(r3) {
                case 0: goto L_0x01b9;
                case 1: goto L_0x01b9;
                case 2: goto L_0x01b7;
                default: goto L_0x01b6;
            }
        L_0x01b6:
            goto L_0x01bb
        L_0x01b7:
            r13 = r15
            goto L_0x01bc
        L_0x01b9:
            r13 = r14
            goto L_0x01bc
        L_0x01bb:
            r13 = r2
        L_0x01bc:
            com.google.android.exoplayer2.text.ttml.TtmlRegion r0 = new com.google.android.exoplayer2.text.ttml.TtmlRegion
            r2 = 0
            r11 = 1
            r3 = r0
            r5 = r7
            r7 = r2
            r9 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r0
        L_0x01c8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r11)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        L_0x01dd:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Ignoring region with unsupported extent: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        L_0x01f4:
            java.lang.String r0 = "Ignoring region without an extent"
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        L_0x01fa:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r11)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        L_0x020f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Ignoring region with unsupported origin: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        L_0x0226:
            java.lang.String r0 = "Ignoring region without an origin"
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.parseRegionAttributes(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlDecoder$CellResolution, com.google.android.exoplayer2.text.ttml.TtmlDecoder$TtsExtent):com.google.android.exoplayer2.text.ttml.TtmlRegion");
    }

    private static String[] parseStyleIds(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : Util.split(trim, "\\s+");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01e6, code lost:
        if (r3.equals("text") == false) goto L_0x01de;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.text.ttml.TtmlStyle parseStyleAttributes(org.xmlpull.v1.XmlPullParser r12, com.google.android.exoplayer2.text.ttml.TtmlStyle r13) {
        /*
            int r0 = r12.getAttributeCount()
            r1 = 0
            r2 = r1
        L_0x0006:
            if (r2 >= r0) goto L_0x02fc
            java.lang.String r3 = r12.getAttributeValue(r2)
            java.lang.String r4 = r12.getAttributeName(r2)
            r4.hashCode()
            int r5 = r4.hashCode()
            r6 = 5
            r7 = 4
            r8 = -1
            r9 = 3
            r10 = 2
            r11 = 1
            switch(r5) {
                case -1550943582: goto L_0x00cf;
                case -1224696685: goto L_0x00c3;
                case -1065511464: goto L_0x00b7;
                case -879295043: goto L_0x00ab;
                case -734428249: goto L_0x009f;
                case 3355: goto L_0x0094;
                case 3511770: goto L_0x0089;
                case 94842723: goto L_0x007e;
                case 109403361: goto L_0x0071;
                case 110138194: goto L_0x0064;
                case 365601008: goto L_0x0057;
                case 921125321: goto L_0x004a;
                case 1115953443: goto L_0x003d;
                case 1287124693: goto L_0x0030;
                case 1754920356: goto L_0x0023;
                default: goto L_0x0020;
            }
        L_0x0020:
            r4 = r8
            goto L_0x00da
        L_0x0023:
            java.lang.String r5 = "multiRowAlign"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x002c
            goto L_0x0020
        L_0x002c:
            r4 = 14
            goto L_0x00da
        L_0x0030:
            java.lang.String r5 = "backgroundColor"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0039
            goto L_0x0020
        L_0x0039:
            r4 = 13
            goto L_0x00da
        L_0x003d:
            java.lang.String r5 = "rubyPosition"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0046
            goto L_0x0020
        L_0x0046:
            r4 = 12
            goto L_0x00da
        L_0x004a:
            java.lang.String r5 = "textEmphasis"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0053
            goto L_0x0020
        L_0x0053:
            r4 = 11
            goto L_0x00da
        L_0x0057:
            java.lang.String r5 = "fontSize"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0060
            goto L_0x0020
        L_0x0060:
            r4 = 10
            goto L_0x00da
        L_0x0064:
            java.lang.String r5 = "textCombine"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x006d
            goto L_0x0020
        L_0x006d:
            r4 = 9
            goto L_0x00da
        L_0x0071:
            java.lang.String r5 = "shear"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x007a
            goto L_0x0020
        L_0x007a:
            r4 = 8
            goto L_0x00da
        L_0x007e:
            java.lang.String r5 = "color"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0087
            goto L_0x0020
        L_0x0087:
            r4 = 7
            goto L_0x00da
        L_0x0089:
            java.lang.String r5 = "ruby"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0092
            goto L_0x0020
        L_0x0092:
            r4 = 6
            goto L_0x00da
        L_0x0094:
            java.lang.String r5 = "id"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x009d
            goto L_0x0020
        L_0x009d:
            r4 = r6
            goto L_0x00da
        L_0x009f:
            java.lang.String r5 = "fontWeight"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00a9
            goto L_0x0020
        L_0x00a9:
            r4 = r7
            goto L_0x00da
        L_0x00ab:
            java.lang.String r5 = "textDecoration"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00b5
            goto L_0x0020
        L_0x00b5:
            r4 = r9
            goto L_0x00da
        L_0x00b7:
            java.lang.String r5 = "textAlign"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00c1
            goto L_0x0020
        L_0x00c1:
            r4 = r10
            goto L_0x00da
        L_0x00c3:
            java.lang.String r5 = "fontFamily"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00cd
            goto L_0x0020
        L_0x00cd:
            r4 = r11
            goto L_0x00da
        L_0x00cf:
            java.lang.String r5 = "fontStyle"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00d9
            goto L_0x0020
        L_0x00d9:
            r4 = r1
        L_0x00da:
            java.lang.String r5 = "TtmlDecoder"
            switch(r4) {
                case 0: goto L_0x02ea;
                case 1: goto L_0x02e1;
                case 2: goto L_0x02d4;
                case 3: goto L_0x0272;
                case 4: goto L_0x0262;
                case 5: goto L_0x024c;
                case 6: goto L_0x01d0;
                case 7: goto L_0x01ab;
                case 8: goto L_0x019d;
                case 9: goto L_0x0170;
                case 10: goto L_0x014f;
                case 11: goto L_0x0141;
                case 12: goto L_0x0114;
                case 13: goto L_0x00ef;
                case 14: goto L_0x00e1;
                default: goto L_0x00df;
            }
        L_0x00df:
            goto L_0x02f8
        L_0x00e1:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            android.text.Layout$Alignment r3 = parseAlignment(r3)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setMultiRowAlign(r3)
            goto L_0x02f8
        L_0x00ef:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            int r4 = com.google.android.exoplayer2.util.ColorParser.parseTtmlColor(r3)     // Catch:{ IllegalArgumentException -> 0x00fc }
            r13.setBackgroundColor(r4)     // Catch:{ IllegalArgumentException -> 0x00fc }
            goto L_0x02f8
        L_0x00fc:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Failed parsing background value: "
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r3 = r3.toString()
            com.google.android.exoplayer2.util.Log.w(r5, r3)
            goto L_0x02f8
        L_0x0114:
            java.lang.String r3 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r3)
            r3.hashCode()
            java.lang.String r4 = "before"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x0137
            java.lang.String r4 = "after"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x012d
            goto L_0x02f8
        L_0x012d:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setRubyPosition(r10)
            goto L_0x02f8
        L_0x0137:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setRubyPosition(r11)
            goto L_0x02f8
        L_0x0141:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TextEmphasis r3 = com.google.android.exoplayer2.text.ttml.TextEmphasis.parse(r3)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setTextEmphasis(r3)
            goto L_0x02f8
        L_0x014f:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)     // Catch:{ SubtitleDecoderException -> 0x0158 }
            parseFontSize(r3, r13)     // Catch:{ SubtitleDecoderException -> 0x0158 }
            goto L_0x02f8
        L_0x0158:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Failed parsing fontSize value: "
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r3 = r3.toString()
            com.google.android.exoplayer2.util.Log.w(r5, r3)
            goto L_0x02f8
        L_0x0170:
            java.lang.String r3 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r3)
            r3.hashCode()
            java.lang.String r4 = "all"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x0193
            java.lang.String r4 = "none"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0189
            goto L_0x02f8
        L_0x0189:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setTextCombine(r1)
            goto L_0x02f8
        L_0x0193:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setTextCombine(r11)
            goto L_0x02f8
        L_0x019d:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            float r3 = parseShear(r3)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setShearPercentage(r3)
            goto L_0x02f8
        L_0x01ab:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            int r4 = com.google.android.exoplayer2.util.ColorParser.parseTtmlColor(r3)     // Catch:{ IllegalArgumentException -> 0x01b8 }
            r13.setFontColor(r4)     // Catch:{ IllegalArgumentException -> 0x01b8 }
            goto L_0x02f8
        L_0x01b8:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Failed parsing color value: "
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r3 = r3.toString()
            com.google.android.exoplayer2.util.Log.w(r5, r3)
            goto L_0x02f8
        L_0x01d0:
            java.lang.String r3 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r3)
            r3.hashCode()
            int r4 = r3.hashCode()
            switch(r4) {
                case -618561360: goto L_0x0215;
                case -410956671: goto L_0x020a;
                case -250518009: goto L_0x01ff;
                case -136074796: goto L_0x01f4;
                case 3016401: goto L_0x01e9;
                case 3556653: goto L_0x01e0;
                default: goto L_0x01de;
            }
        L_0x01de:
            r6 = r8
            goto L_0x021f
        L_0x01e0:
            java.lang.String r4 = "text"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x021f
            goto L_0x01de
        L_0x01e9:
            java.lang.String r4 = "base"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01f2
            goto L_0x01de
        L_0x01f2:
            r6 = r7
            goto L_0x021f
        L_0x01f4:
            java.lang.String r4 = "textContainer"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01fd
            goto L_0x01de
        L_0x01fd:
            r6 = r9
            goto L_0x021f
        L_0x01ff:
            java.lang.String r4 = "delimiter"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0208
            goto L_0x01de
        L_0x0208:
            r6 = r10
            goto L_0x021f
        L_0x020a:
            java.lang.String r4 = "container"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0213
            goto L_0x01de
        L_0x0213:
            r6 = r11
            goto L_0x021f
        L_0x0215:
            java.lang.String r4 = "baseContainer"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x021e
            goto L_0x01de
        L_0x021e:
            r6 = r1
        L_0x021f:
            switch(r6) {
                case 0: goto L_0x0242;
                case 1: goto L_0x0238;
                case 2: goto L_0x022e;
                case 3: goto L_0x0224;
                case 4: goto L_0x0242;
                case 5: goto L_0x0224;
                default: goto L_0x0222;
            }
        L_0x0222:
            goto L_0x02f8
        L_0x0224:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setRubyType(r9)
            goto L_0x02f8
        L_0x022e:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setRubyType(r7)
            goto L_0x02f8
        L_0x0238:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setRubyType(r11)
            goto L_0x02f8
        L_0x0242:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setRubyType(r10)
            goto L_0x02f8
        L_0x024c:
            java.lang.String r4 = r12.getName()
            java.lang.String r5 = "style"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x02f8
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setId(r3)
            goto L_0x02f8
        L_0x0262:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            java.lang.String r4 = "bold"
            boolean r3 = r4.equalsIgnoreCase(r3)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setBold(r3)
            goto L_0x02f8
        L_0x0272:
            java.lang.String r3 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r3)
            r3.hashCode()
            int r4 = r3.hashCode()
            switch(r4) {
                case -1461280213: goto L_0x02a2;
                case -1026963764: goto L_0x0297;
                case 913457136: goto L_0x028c;
                case 1679736913: goto L_0x0281;
                default: goto L_0x0280;
            }
        L_0x0280:
            goto L_0x02ac
        L_0x0281:
            java.lang.String r4 = "linethrough"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x028a
            goto L_0x02ac
        L_0x028a:
            r8 = r9
            goto L_0x02ac
        L_0x028c:
            java.lang.String r4 = "nolinethrough"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0295
            goto L_0x02ac
        L_0x0295:
            r8 = r10
            goto L_0x02ac
        L_0x0297:
            java.lang.String r4 = "underline"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x02a0
            goto L_0x02ac
        L_0x02a0:
            r8 = r11
            goto L_0x02ac
        L_0x02a2:
            java.lang.String r4 = "nounderline"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x02ab
            goto L_0x02ac
        L_0x02ab:
            r8 = r1
        L_0x02ac:
            switch(r8) {
                case 0: goto L_0x02cb;
                case 1: goto L_0x02c2;
                case 2: goto L_0x02b9;
                case 3: goto L_0x02b0;
                default: goto L_0x02af;
            }
        L_0x02af:
            goto L_0x02f8
        L_0x02b0:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setLinethrough(r11)
            goto L_0x02f8
        L_0x02b9:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setLinethrough(r1)
            goto L_0x02f8
        L_0x02c2:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setUnderline(r11)
            goto L_0x02f8
        L_0x02cb:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setUnderline(r1)
            goto L_0x02f8
        L_0x02d4:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            android.text.Layout$Alignment r3 = parseAlignment(r3)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setTextAlign(r3)
            goto L_0x02f8
        L_0x02e1:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setFontFamily(r3)
            goto L_0x02f8
        L_0x02ea:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            java.lang.String r4 = "italic"
            boolean r3 = r4.equalsIgnoreCase(r3)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setItalic(r3)
        L_0x02f8:
            int r2 = r2 + 1
            goto L_0x0006
        L_0x02fc:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.parseStyleAttributes(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlStyle):com.google.android.exoplayer2.text.ttml.TtmlStyle");
    }

    private static TtmlStyle createIfNull(TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    private static Layout.Alignment parseAlignment(String str) {
        String lowerCase = Ascii.toLowerCase(str);
        lowerCase.hashCode();
        char c = 65535;
        switch (lowerCase.hashCode()) {
            case -1364013995:
                if (lowerCase.equals(TtmlNode.CENTER)) {
                    c = 0;
                    break;
                }
                break;
            case 100571:
                if (lowerCase.equals("end")) {
                    c = 1;
                    break;
                }
                break;
            case 3317767:
                if (lowerCase.equals("left")) {
                    c = 2;
                    break;
                }
                break;
            case 108511772:
                if (lowerCase.equals("right")) {
                    c = 3;
                    break;
                }
                break;
            case 109757538:
                if (lowerCase.equals("start")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Layout.Alignment.ALIGN_CENTER;
            case 1:
            case 3:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 2:
            case 4:
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.text.ttml.TtmlNode parseNode(org.xmlpull.v1.XmlPullParser r19, com.google.android.exoplayer2.text.ttml.TtmlNode r20, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlRegion> r21, com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate r22) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        /*
            r0 = r19
            r9 = r20
            r1 = r22
            int r2 = r19.getAttributeCount()
            r3 = 0
            com.google.android.exoplayer2.text.ttml.TtmlStyle r5 = parseStyleAttributes(r0, r3)
            java.lang.String r8 = ""
            r11 = r3
            r10 = r8
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = r11
            r3 = 0
        L_0x0024:
            if (r3 >= r2) goto L_0x00b4
            java.lang.String r4 = r0.getAttributeName(r3)
            java.lang.String r6 = r0.getAttributeValue(r3)
            r4.hashCode()
            int r18 = r4.hashCode()
            switch(r18) {
                case -934795532: goto L_0x0071;
                case 99841: goto L_0x0066;
                case 100571: goto L_0x005b;
                case 93616297: goto L_0x0050;
                case 109780401: goto L_0x0045;
                case 1292595405: goto L_0x003a;
                default: goto L_0x0038;
            }
        L_0x0038:
            r7 = -1
            goto L_0x007b
        L_0x003a:
            java.lang.String r7 = "backgroundImage"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x0043
            goto L_0x0038
        L_0x0043:
            r7 = 5
            goto L_0x007b
        L_0x0045:
            java.lang.String r7 = "style"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x004e
            goto L_0x0038
        L_0x004e:
            r7 = 4
            goto L_0x007b
        L_0x0050:
            java.lang.String r7 = "begin"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x0059
            goto L_0x0038
        L_0x0059:
            r7 = 3
            goto L_0x007b
        L_0x005b:
            java.lang.String r7 = "end"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x0064
            goto L_0x0038
        L_0x0064:
            r7 = 2
            goto L_0x007b
        L_0x0066:
            java.lang.String r7 = "dur"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x006f
            goto L_0x0038
        L_0x006f:
            r7 = 1
            goto L_0x007b
        L_0x0071:
            java.lang.String r7 = "region"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x007a
            goto L_0x0038
        L_0x007a:
            r7 = 0
        L_0x007b:
            switch(r7) {
                case 0: goto L_0x00a7;
                case 1: goto L_0x00a2;
                case 2: goto L_0x009d;
                case 3: goto L_0x0096;
                case 4: goto L_0x008d;
                case 5: goto L_0x007f;
                default: goto L_0x007e;
            }
        L_0x007e:
            goto L_0x009a
        L_0x007f:
            java.lang.String r4 = "#"
            boolean r4 = r6.startsWith(r4)
            if (r4 == 0) goto L_0x009a
            r4 = 1
            java.lang.String r11 = r6.substring(r4)
            goto L_0x009a
        L_0x008d:
            java.lang.String[] r4 = parseStyleIds(r6)
            int r6 = r4.length
            if (r6 <= 0) goto L_0x009a
            r8 = r4
            goto L_0x009a
        L_0x0096:
            long r12 = parseTimeExpression(r6, r1)
        L_0x009a:
            r4 = r21
            goto L_0x00b0
        L_0x009d:
            long r14 = parseTimeExpression(r6, r1)
            goto L_0x009a
        L_0x00a2:
            long r16 = parseTimeExpression(r6, r1)
            goto L_0x009a
        L_0x00a7:
            r4 = r21
            boolean r7 = r4.containsKey(r6)
            if (r7 == 0) goto L_0x00b0
            r10 = r6
        L_0x00b0:
            int r3 = r3 + 1
            goto L_0x0024
        L_0x00b4:
            if (r9 == 0) goto L_0x00d0
            long r1 = r9.startTimeUs
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00d5
            int r1 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00c8
            long r1 = r9.startTimeUs
            long r12 = r12 + r1
        L_0x00c8:
            int r1 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00d5
            long r1 = r9.startTimeUs
            long r14 = r14 + r1
            goto L_0x00d5
        L_0x00d0:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x00d5:
            r1 = r12
            int r6 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x00ee
            int r6 = (r16 > r3 ? 1 : (r16 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x00e3
            long r16 = r1 + r16
            r3 = r16
            goto L_0x00ef
        L_0x00e3:
            if (r9 == 0) goto L_0x00ee
            long r6 = r9.endTimeUs
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x00ee
            long r3 = r9.endTimeUs
            goto L_0x00ef
        L_0x00ee:
            r3 = r14
        L_0x00ef:
            java.lang.String r0 = r19.getName()
            r6 = r8
            r7 = r10
            r8 = r11
            r9 = r20
            com.google.android.exoplayer2.text.ttml.TtmlNode r0 = com.google.android.exoplayer2.text.ttml.TtmlNode.buildNode(r0, r1, r3, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.parseNode(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlNode, java.util.Map, com.google.android.exoplayer2.text.ttml.TtmlDecoder$FrameAndTickRate):com.google.android.exoplayer2.text.ttml.TtmlNode");
    }

    private static boolean isSupportedTag(String str) {
        return str.equals(TtmlNode.TAG_TT) || str.equals(TtmlNode.TAG_HEAD) || str.equals("body") || str.equals(TtmlNode.TAG_DIV) || str.equals("p") || str.equals(TtmlNode.TAG_SPAN) || str.equals(TtmlNode.TAG_BR) || str.equals("style") || str.equals(TtmlNode.TAG_STYLING) || str.equals(TtmlNode.TAG_LAYOUT) || str.equals("region") || str.equals(TtmlNode.TAG_METADATA) || str.equals("image") || str.equals("data") || str.equals(TtmlNode.TAG_INFORMATION);
    }

    private static void parseFontSize(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String[] split = Util.split(str, "\\s+");
        if (split.length == 1) {
            matcher = FONT_SIZE.matcher(str);
        } else if (split.length == 2) {
            matcher = FONT_SIZE.matcher(split[1]);
            Log.w(TAG, "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + split.length + ".");
        }
        if (matcher.matches()) {
            String str2 = (String) Assertions.checkNotNull(matcher.group(3));
            str2.hashCode();
            char c = 65535;
            switch (str2.hashCode()) {
                case 37:
                    if (str2.equals("%")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3240:
                    if (str2.equals(UserDataStore.EMAIL)) {
                        c = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (str2.equals("px")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    ttmlStyle.setFontSizeUnit(3);
                    break;
                case 1:
                    ttmlStyle.setFontSizeUnit(2);
                    break;
                case 2:
                    ttmlStyle.setFontSizeUnit(1);
                    break;
                default:
                    throw new SubtitleDecoderException("Invalid unit for fontSize: '" + str2 + "'.");
            }
            ttmlStyle.setFontSize(Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1))));
            return;
        }
        throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
    }

    private static float parseShear(String str) {
        Matcher matcher = SIGNED_PERCENTAGE.matcher(str);
        if (!matcher.matches()) {
            Log.w(TAG, "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1)))));
        } catch (NumberFormatException e) {
            Log.w(TAG, "Failed to parse shear: " + str, e);
            return Float.MAX_VALUE;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00bc, code lost:
        if (r13.equals("ms") == false) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f3, code lost:
        r8 = r8 / r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0101, code lost:
        r8 = r8 * r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long parseTimeExpression(java.lang.String r13, com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate r14) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        /*
            java.util.regex.Pattern r0 = CLOCK_TIME
            java.util.regex.Matcher r0 = r0.matcher(r13)
            boolean r1 = r0.matches()
            r2 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r1 == 0) goto L_0x0085
            java.lang.String r13 = r0.group(r7)
            java.lang.Object r13 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r13)
            java.lang.String r13 = (java.lang.String) r13
            long r7 = java.lang.Long.parseLong(r13)
            r9 = 3600(0xe10, double:1.7786E-320)
            long r7 = r7 * r9
            double r7 = (double) r7
            java.lang.String r13 = r0.group(r6)
            java.lang.Object r13 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r13)
            java.lang.String r13 = (java.lang.String) r13
            long r9 = java.lang.Long.parseLong(r13)
            r11 = 60
            long r9 = r9 * r11
            double r9 = (double) r9
            double r7 = r7 + r9
            java.lang.String r13 = r0.group(r5)
            java.lang.Object r13 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r13)
            java.lang.String r13 = (java.lang.String) r13
            long r5 = java.lang.Long.parseLong(r13)
            double r5 = (double) r5
            double r7 = r7 + r5
            java.lang.String r13 = r0.group(r4)
            r4 = 0
            if (r13 == 0) goto L_0x0057
            double r9 = java.lang.Double.parseDouble(r13)
            goto L_0x0058
        L_0x0057:
            r9 = r4
        L_0x0058:
            double r7 = r7 + r9
            r13 = 5
            java.lang.String r13 = r0.group(r13)
            if (r13 == 0) goto L_0x006a
            long r9 = java.lang.Long.parseLong(r13)
            float r13 = (float) r9
            float r1 = r14.effectiveFrameRate
            float r13 = r13 / r1
            double r9 = (double) r13
            goto L_0x006b
        L_0x006a:
            r9 = r4
        L_0x006b:
            double r7 = r7 + r9
            r13 = 6
            java.lang.String r13 = r0.group(r13)
            if (r13 == 0) goto L_0x0081
            long r0 = java.lang.Long.parseLong(r13)
            double r0 = (double) r0
            int r13 = r14.subFrameRate
            double r4 = (double) r13
            double r0 = r0 / r4
            float r13 = r14.effectiveFrameRate
            double r13 = (double) r13
            double r4 = r0 / r13
        L_0x0081:
            double r7 = r7 + r4
            double r7 = r7 * r2
            long r13 = (long) r7
            return r13
        L_0x0085:
            java.util.regex.Pattern r0 = OFFSET_TIME
            java.util.regex.Matcher r0 = r0.matcher(r13)
            boolean r1 = r0.matches()
            if (r1 == 0) goto L_0x010a
            java.lang.String r13 = r0.group(r7)
            java.lang.Object r13 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r13)
            java.lang.String r13 = (java.lang.String) r13
            double r8 = java.lang.Double.parseDouble(r13)
            java.lang.String r13 = r0.group(r6)
            java.lang.Object r13 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r13)
            java.lang.String r13 = (java.lang.String) r13
            r13.hashCode()
            r0 = -1
            int r1 = r13.hashCode()
            switch(r1) {
                case 102: goto L_0x00e0;
                case 104: goto L_0x00d5;
                case 109: goto L_0x00ca;
                case 116: goto L_0x00bf;
                case 3494: goto L_0x00b6;
                default: goto L_0x00b4;
            }
        L_0x00b4:
            r4 = r0
            goto L_0x00ea
        L_0x00b6:
            java.lang.String r1 = "ms"
            boolean r13 = r13.equals(r1)
            if (r13 != 0) goto L_0x00ea
            goto L_0x00b4
        L_0x00bf:
            java.lang.String r1 = "t"
            boolean r13 = r13.equals(r1)
            if (r13 != 0) goto L_0x00c8
            goto L_0x00b4
        L_0x00c8:
            r4 = r5
            goto L_0x00ea
        L_0x00ca:
            java.lang.String r1 = "m"
            boolean r13 = r13.equals(r1)
            if (r13 != 0) goto L_0x00d3
            goto L_0x00b4
        L_0x00d3:
            r4 = r6
            goto L_0x00ea
        L_0x00d5:
            java.lang.String r1 = "h"
            boolean r13 = r13.equals(r1)
            if (r13 != 0) goto L_0x00de
            goto L_0x00b4
        L_0x00de:
            r4 = r7
            goto L_0x00ea
        L_0x00e0:
            java.lang.String r1 = "f"
            boolean r13 = r13.equals(r1)
            if (r13 != 0) goto L_0x00e9
            goto L_0x00b4
        L_0x00e9:
            r4 = 0
        L_0x00ea:
            switch(r4) {
                case 0: goto L_0x0103;
                case 1: goto L_0x00fc;
                case 2: goto L_0x00f9;
                case 3: goto L_0x00f5;
                case 4: goto L_0x00ee;
                default: goto L_0x00ed;
            }
        L_0x00ed:
            goto L_0x0107
        L_0x00ee:
            r13 = 4652007308841189376(0x408f400000000000, double:1000.0)
        L_0x00f3:
            double r8 = r8 / r13
            goto L_0x0107
        L_0x00f5:
            int r13 = r14.tickRate
            double r13 = (double) r13
            goto L_0x00f3
        L_0x00f9:
            r13 = 4633641066610819072(0x404e000000000000, double:60.0)
            goto L_0x0101
        L_0x00fc:
            r13 = 4660134898793709568(0x40ac200000000000, double:3600.0)
        L_0x0101:
            double r8 = r8 * r13
            goto L_0x0107
        L_0x0103:
            float r13 = r14.effectiveFrameRate
            double r13 = (double) r13
            goto L_0x00f3
        L_0x0107:
            double r8 = r8 * r2
            long r13 = (long) r8
            return r13
        L_0x010a:
            com.google.android.exoplayer2.text.SubtitleDecoderException r14 = new com.google.android.exoplayer2.text.SubtitleDecoderException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Malformed time expression: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r13 = r0.append(r13)
            java.lang.String r13 = r13.toString()
            r14.<init>((java.lang.String) r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.parseTimeExpression(java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlDecoder$FrameAndTickRate):long");
    }

    private static final class FrameAndTickRate {
        final float effectiveFrameRate;
        final int subFrameRate;
        final int tickRate;

        FrameAndTickRate(float f, int i, int i2) {
            this.effectiveFrameRate = f;
            this.subFrameRate = i;
            this.tickRate = i2;
        }
    }

    private static final class CellResolution {
        final int columns;
        final int rows;

        CellResolution(int i, int i2) {
            this.columns = i;
            this.rows = i2;
        }
    }

    private static final class TtsExtent {
        final int height;
        final int width;

        TtsExtent(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }
}
