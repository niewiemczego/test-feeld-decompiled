package org.json;

import com.facebook.hermes.intl.Constants;
import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class JSONWriter {
    private static final int maxdepth = 200;
    private boolean comma = false;
    protected char mode = 'i';
    private final JSONObject[] stack = new JSONObject[200];
    private int top = 0;
    protected Appendable writer;

    public JSONWriter(Appendable appendable) {
        this.writer = appendable;
    }

    private JSONWriter append(String str) throws JSONException {
        if (str != null) {
            char c = this.mode;
            if (c == 'o' || c == 'a') {
                try {
                    if (this.comma && c == 'a') {
                        this.writer.append(',');
                    }
                    this.writer.append(str);
                    if (this.mode == 'o') {
                        this.mode = 'k';
                    }
                    this.comma = true;
                    return this;
                } catch (IOException e) {
                    throw new JSONException((Throwable) e);
                }
            } else {
                throw new JSONException("Value out of sequence.");
            }
        } else {
            throw new JSONException("Null pointer");
        }
    }

    public JSONWriter array() throws JSONException {
        char c = this.mode;
        if (c == 'i' || c == 'o' || c == 'a') {
            push((JSONObject) null);
            append("[");
            this.comma = false;
            return this;
        }
        throw new JSONException("Misplaced array.");
    }

    private JSONWriter end(char c, char c2) throws JSONException {
        if (this.mode != c) {
            throw new JSONException(c == 'a' ? "Misplaced endArray." : "Misplaced endObject.");
        }
        pop(c);
        try {
            this.writer.append(c2);
            this.comma = true;
            return this;
        } catch (IOException e) {
            throw new JSONException((Throwable) e);
        }
    }

    public JSONWriter endArray() throws JSONException {
        return end('a', ']');
    }

    public JSONWriter endObject() throws JSONException {
        return end('k', '}');
    }

    public JSONWriter key(String str) throws JSONException {
        if (str == null) {
            throw new JSONException("Null key.");
        } else if (this.mode == 'k') {
            try {
                JSONObject jSONObject = this.stack[this.top - 1];
                if (!jSONObject.has(str)) {
                    jSONObject.put(str, true);
                    if (this.comma) {
                        this.writer.append(',');
                    }
                    this.writer.append(JSONObject.quote(str));
                    this.writer.append(':');
                    this.comma = false;
                    this.mode = 'o';
                    return this;
                }
                throw new JSONException("Duplicate key \"" + str + "\"");
            } catch (IOException e) {
                throw new JSONException((Throwable) e);
            }
        } else {
            throw new JSONException("Misplaced key.");
        }
    }

    public JSONWriter object() throws JSONException {
        if (this.mode == 'i') {
            this.mode = 'o';
        }
        char c = this.mode;
        if (c == 'o' || c == 'a') {
            append("{");
            push(new JSONObject());
            this.comma = false;
            return this;
        }
        throw new JSONException("Misplaced object.");
    }

    private void pop(char c) throws JSONException {
        int i = this.top;
        if (i > 0) {
            JSONObject[] jSONObjectArr = this.stack;
            char c2 = 'a';
            if ((jSONObjectArr[i + -1] == null ? 'a' : 'k') == c) {
                int i2 = i - 1;
                this.top = i2;
                if (i2 == 0) {
                    c2 = 'd';
                } else if (jSONObjectArr[i2 - 1] != null) {
                    c2 = 'k';
                }
                this.mode = c2;
                return;
            }
            throw new JSONException("Nesting error.");
        }
        throw new JSONException("Nesting error.");
    }

    private void push(JSONObject jSONObject) throws JSONException {
        int i = this.top;
        if (i < 200) {
            this.stack[i] = jSONObject;
            this.mode = jSONObject == null ? 'a' : 'k';
            this.top = i + 1;
            return;
        }
        throw new JSONException("Nesting too deep.");
    }

    public static String valueToString(Object obj) throws JSONException {
        if (obj == null || obj.equals((Object) null)) {
            return "null";
        }
        if (obj instanceof JSONString) {
            try {
                String jSONString = ((JSONString) obj).toJSONString();
                if (jSONString != null) {
                    return jSONString;
                }
                throw new JSONException("Bad value from toJSONString: " + jSONString);
            } catch (Exception e) {
                throw new JSONException((Throwable) e);
            }
        } else if (obj instanceof Number) {
            String numberToString = JSONObject.numberToString((Number) obj);
            if (JSONObject.NUMBER_PATTERN.matcher(numberToString).matches()) {
                return numberToString;
            }
            return JSONObject.quote(numberToString);
        } else if ((obj instanceof Boolean) || (obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            return obj.toString();
        } else {
            if (obj instanceof Map) {
                return new JSONObject((Map<?, ?>) (Map) obj).toString();
            }
            if (obj instanceof Collection) {
                return new JSONArray((Collection<?>) (Collection) obj).toString();
            }
            if (obj.getClass().isArray()) {
                return new JSONArray(obj).toString();
            }
            if (obj instanceof Enum) {
                return JSONObject.quote(((Enum) obj).name());
            }
            return JSONObject.quote(obj.toString());
        }
    }

    public JSONWriter value(boolean z) throws JSONException {
        return append(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : Constants.CASEFIRST_FALSE);
    }

    public JSONWriter value(double d) throws JSONException {
        return value((Object) Double.valueOf(d));
    }

    public JSONWriter value(long j) throws JSONException {
        return append(Long.toString(j));
    }

    public JSONWriter value(Object obj) throws JSONException {
        return append(valueToString(obj));
    }
}
