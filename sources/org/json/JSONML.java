package org.json;

import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;

public class JSONML {
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x018f, code lost:
        r7 = r9.nextToken();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0195, code lost:
        if ((r7 instanceof java.lang.String) == false) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0197, code lost:
        r7 = (java.lang.String) r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0199, code lost:
        if (r12 == false) goto L_0x019c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01ab, code lost:
        throw r9.syntaxError("Missing value");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x01a0, code lost:
        r7 = org.json.XML.stringToValue(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x01a0, code lost:
        r7 = r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object parse(org.json.XMLTokener r9, boolean r10, org.json.JSONArray r11, boolean r12) throws org.json.JSONException {
        /*
        L_0x0000:
            boolean r0 = r9.more()
            if (r0 == 0) goto L_0x01ef
            java.lang.Object r0 = r9.nextContent()
            java.lang.Character r1 = org.json.XML.LT
            if (r0 != r1) goto L_0x01d5
            java.lang.Object r0 = r9.nextToken()
            boolean r1 = r0 instanceof java.lang.Character
            java.lang.String r2 = "'."
            java.lang.String r3 = "Misshaped tag"
            if (r1 == 0) goto L_0x00c6
            java.lang.Character r1 = org.json.XML.SLASH
            if (r0 != r1) goto L_0x0053
            java.lang.Object r10 = r9.nextToken()
            boolean r11 = r10 instanceof java.lang.String
            if (r11 == 0) goto L_0x0036
            java.lang.Object r11 = r9.nextToken()
            java.lang.Character r12 = org.json.XML.GT
            if (r11 != r12) goto L_0x002f
            return r10
        L_0x002f:
            java.lang.String r10 = "Misshaped close tag"
            org.json.JSONException r9 = r9.syntaxError(r10)
            throw r9
        L_0x0036:
            org.json.JSONException r9 = new org.json.JSONException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Expected a closing name instead of '"
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.StringBuilder r10 = r11.append(r10)
            java.lang.StringBuilder r10 = r10.append(r2)
            java.lang.String r10 = r10.toString()
            r9.<init>((java.lang.String) r10)
            throw r9
        L_0x0053:
            java.lang.Character r1 = org.json.XML.BANG
            if (r0 != r1) goto L_0x00b6
            char r0 = r9.next()
            r1 = 45
            if (r0 != r1) goto L_0x006f
            char r0 = r9.next()
            if (r0 != r1) goto L_0x006b
            java.lang.String r0 = "-->"
            r9.skipPast(r0)
            goto L_0x0000
        L_0x006b:
            r9.back()
            goto L_0x0000
        L_0x006f:
            r1 = 91
            if (r0 != r1) goto L_0x0097
            java.lang.Object r0 = r9.nextToken()
            java.lang.String r2 = "CDATA"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0090
            char r0 = r9.next()
            if (r0 != r1) goto L_0x0090
            if (r11 == 0) goto L_0x0000
            java.lang.String r0 = r9.nextCDATA()
            r11.put((java.lang.Object) r0)
            goto L_0x0000
        L_0x0090:
            java.lang.String r10 = "Expected 'CDATA['"
            org.json.JSONException r9 = r9.syntaxError(r10)
            throw r9
        L_0x0097:
            r0 = 1
        L_0x0098:
            java.lang.Object r1 = r9.nextMeta()
            if (r1 == 0) goto L_0x00af
            java.lang.Character r2 = org.json.XML.LT
            if (r1 != r2) goto L_0x00a5
            int r0 = r0 + 1
            goto L_0x00ab
        L_0x00a5:
            java.lang.Character r2 = org.json.XML.GT
            if (r1 != r2) goto L_0x00ab
            int r0 = r0 + -1
        L_0x00ab:
            if (r0 > 0) goto L_0x0098
            goto L_0x0000
        L_0x00af:
            java.lang.String r10 = "Missing '>' after '<!'."
            org.json.JSONException r9 = r9.syntaxError(r10)
            throw r9
        L_0x00b6:
            java.lang.Character r1 = org.json.XML.QUEST
            if (r0 != r1) goto L_0x00c1
            java.lang.String r0 = "?>"
            r9.skipPast(r0)
            goto L_0x0000
        L_0x00c1:
            org.json.JSONException r9 = r9.syntaxError(r3)
            throw r9
        L_0x00c6:
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L_0x01b9
            java.lang.String r0 = (java.lang.String) r0
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r4 = "tagName"
            if (r10 == 0) goto L_0x00e3
            r1.put((java.lang.Object) r0)
            if (r11 == 0) goto L_0x00eb
            r11.put((java.lang.Object) r1)
            goto L_0x00eb
        L_0x00e3:
            r2.put((java.lang.String) r4, (java.lang.Object) r0)
            if (r11 == 0) goto L_0x00eb
            r11.put((java.lang.Object) r2)
        L_0x00eb:
            r5 = 0
        L_0x00ec:
            r6 = r5
        L_0x00ed:
            if (r6 != 0) goto L_0x00f3
            java.lang.Object r6 = r9.nextToken()
        L_0x00f3:
            if (r6 == 0) goto L_0x01b4
            boolean r7 = r6 instanceof java.lang.String
            if (r7 != 0) goto L_0x016d
            if (r10 == 0) goto L_0x0104
            int r4 = r2.length()
            if (r4 <= 0) goto L_0x0104
            r1.put((java.lang.Object) r2)
        L_0x0104:
            java.lang.Character r4 = org.json.XML.SLASH
            if (r6 != r4) goto L_0x011b
            java.lang.Object r0 = r9.nextToken()
            java.lang.Character r4 = org.json.XML.GT
            if (r0 != r4) goto L_0x0116
            if (r11 != 0) goto L_0x0000
            if (r10 == 0) goto L_0x0115
            return r1
        L_0x0115:
            return r2
        L_0x0116:
            org.json.JSONException r9 = r9.syntaxError(r3)
            throw r9
        L_0x011b:
            java.lang.Character r4 = org.json.XML.GT
            if (r6 != r4) goto L_0x0168
            java.lang.Object r3 = parse(r9, r10, r1, r12)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x0000
            boolean r4 = r3.equals(r0)
            if (r4 == 0) goto L_0x0140
            if (r10 != 0) goto L_0x013a
            int r0 = r1.length()
            if (r0 <= 0) goto L_0x013a
            java.lang.String r0 = "childNodes"
            r2.put((java.lang.String) r0, (java.lang.Object) r1)
        L_0x013a:
            if (r11 != 0) goto L_0x0000
            if (r10 == 0) goto L_0x013f
            return r1
        L_0x013f:
            return r2
        L_0x0140:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Mismatched '"
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.StringBuilder r10 = r10.append(r0)
            java.lang.String r11 = "' and '"
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.StringBuilder r10 = r10.append(r3)
            java.lang.String r11 = "'"
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.String r10 = r10.toString()
            org.json.JSONException r9 = r9.syntaxError(r10)
            throw r9
        L_0x0168:
            org.json.JSONException r9 = r9.syntaxError(r3)
            throw r9
        L_0x016d:
            java.lang.String r6 = (java.lang.String) r6
            if (r10 != 0) goto L_0x0187
            boolean r7 = r4.equals(r6)
            if (r7 != 0) goto L_0x0180
            java.lang.String r7 = "childNode"
            boolean r7 = r7.equals(r6)
            if (r7 != 0) goto L_0x0180
            goto L_0x0187
        L_0x0180:
            java.lang.String r10 = "Reserved attribute."
            org.json.JSONException r9 = r9.syntaxError(r10)
            throw r9
        L_0x0187:
            java.lang.Object r7 = r9.nextToken()
            java.lang.Character r8 = org.json.XML.EQ
            if (r7 != r8) goto L_0x01ac
            java.lang.Object r7 = r9.nextToken()
            boolean r8 = r7 instanceof java.lang.String
            if (r8 == 0) goto L_0x01a5
            java.lang.String r7 = (java.lang.String) r7
            if (r12 == 0) goto L_0x019c
            goto L_0x01a0
        L_0x019c:
            java.lang.Object r7 = org.json.XML.stringToValue(r7)
        L_0x01a0:
            r2.accumulate(r6, r7)
            goto L_0x00ec
        L_0x01a5:
            java.lang.String r10 = "Missing value"
            org.json.JSONException r9 = r9.syntaxError(r10)
            throw r9
        L_0x01ac:
            java.lang.String r8 = ""
            r2.accumulate(r6, r8)
            r6 = r7
            goto L_0x00ed
        L_0x01b4:
            org.json.JSONException r9 = r9.syntaxError(r3)
            throw r9
        L_0x01b9:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Bad tagName '"
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.StringBuilder r10 = r10.append(r0)
            java.lang.StringBuilder r10 = r10.append(r2)
            java.lang.String r10 = r10.toString()
            org.json.JSONException r9 = r9.syntaxError(r10)
            throw r9
        L_0x01d5:
            if (r11 == 0) goto L_0x0000
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L_0x01ea
            if (r12 == 0) goto L_0x01e4
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = org.json.XML.unescape(r0)
            goto L_0x01ea
        L_0x01e4:
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = org.json.XML.stringToValue(r0)
        L_0x01ea:
            r11.put((java.lang.Object) r0)
            goto L_0x0000
        L_0x01ef:
            java.lang.String r10 = "Bad XML"
            org.json.JSONException r9 = r9.syntaxError(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.JSONML.parse(org.json.XMLTokener, boolean, org.json.JSONArray, boolean):java.lang.Object");
    }

    public static JSONArray toJSONArray(String str) throws JSONException {
        return (JSONArray) parse(new XMLTokener(str), true, (JSONArray) null, false);
    }

    public static JSONArray toJSONArray(String str, boolean z) throws JSONException {
        return (JSONArray) parse(new XMLTokener(str), true, (JSONArray) null, z);
    }

    public static JSONArray toJSONArray(XMLTokener xMLTokener, boolean z) throws JSONException {
        return (JSONArray) parse(xMLTokener, true, (JSONArray) null, z);
    }

    public static JSONArray toJSONArray(XMLTokener xMLTokener) throws JSONException {
        return (JSONArray) parse(xMLTokener, true, (JSONArray) null, false);
    }

    public static JSONObject toJSONObject(String str) throws JSONException {
        return (JSONObject) parse(new XMLTokener(str), false, (JSONArray) null, false);
    }

    public static JSONObject toJSONObject(String str, boolean z) throws JSONException {
        return (JSONObject) parse(new XMLTokener(str), false, (JSONArray) null, z);
    }

    public static JSONObject toJSONObject(XMLTokener xMLTokener) throws JSONException {
        return (JSONObject) parse(xMLTokener, false, (JSONArray) null, false);
    }

    public static JSONObject toJSONObject(XMLTokener xMLTokener, boolean z) throws JSONException {
        return (JSONObject) parse(xMLTokener, false, (JSONArray) null, z);
    }

    public static String toString(JSONArray jSONArray) throws JSONException {
        int i;
        StringBuilder sb = new StringBuilder();
        String string = jSONArray.getString(0);
        XML.noSpace(string);
        String escape = XML.escape(string);
        sb.append(Typography.less);
        sb.append(escape);
        Object opt = jSONArray.opt(1);
        if (opt instanceof JSONObject) {
            i = 2;
            JSONObject jSONObject = (JSONObject) opt;
            for (String next : jSONObject.keySet()) {
                Object opt2 = jSONObject.opt(next);
                XML.noSpace(next);
                if (opt2 != null) {
                    sb.append(' ');
                    sb.append(XML.escape(next));
                    sb.append('=');
                    sb.append(Typography.quote);
                    sb.append(XML.escape(opt2.toString()));
                    sb.append(Typography.quote);
                }
            }
        } else {
            i = 1;
        }
        int length = jSONArray.length();
        if (i >= length) {
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(Typography.greater);
        } else {
            sb.append(Typography.greater);
            do {
                Object obj = jSONArray.get(i);
                i++;
                if (obj != null) {
                    if (obj instanceof String) {
                        sb.append(XML.escape(obj.toString()));
                        continue;
                    } else if (obj instanceof JSONObject) {
                        sb.append(toString((JSONObject) obj));
                        continue;
                    } else if (obj instanceof JSONArray) {
                        sb.append(toString((JSONArray) obj));
                        continue;
                    } else {
                        sb.append(obj.toString());
                        continue;
                    }
                }
            } while (i < length);
            sb.append(Typography.less);
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(escape);
            sb.append(Typography.greater);
        }
        return sb.toString();
    }

    public static String toString(JSONObject jSONObject) throws JSONException {
        StringBuilder sb = new StringBuilder();
        String optString = jSONObject.optString("tagName");
        if (optString == null) {
            return XML.escape(jSONObject.toString());
        }
        XML.noSpace(optString);
        String escape = XML.escape(optString);
        sb.append(Typography.less);
        sb.append(escape);
        for (String next : jSONObject.keySet()) {
            if (!"tagName".equals(next) && !"childNodes".equals(next)) {
                XML.noSpace(next);
                Object opt = jSONObject.opt(next);
                if (opt != null) {
                    sb.append(' ');
                    sb.append(XML.escape(next));
                    sb.append('=');
                    sb.append(Typography.quote);
                    sb.append(XML.escape(opt.toString()));
                    sb.append(Typography.quote);
                }
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("childNodes");
        if (optJSONArray == null) {
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(Typography.greater);
        } else {
            sb.append(Typography.greater);
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                Object obj = optJSONArray.get(i);
                if (obj != null) {
                    if (obj instanceof String) {
                        sb.append(XML.escape(obj.toString()));
                    } else if (obj instanceof JSONObject) {
                        sb.append(toString((JSONObject) obj));
                    } else if (obj instanceof JSONArray) {
                        sb.append(toString((JSONArray) obj));
                    } else {
                        sb.append(obj.toString());
                    }
                }
            }
            sb.append(Typography.less);
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(escape);
            sb.append(Typography.greater);
        }
        return sb.toString();
    }
}
