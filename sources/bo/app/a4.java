package bo.app;

import com.braze.enums.BrazeDateFormat;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.JsonUtils;
import java.util.Date;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class a4 implements c2 {
    private static final String f = BrazeLogger.getBrazeLogTag((Class<?>) a4.class);
    private final b4 b;
    private final String c;
    private final int d;
    private Object e;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                bo.app.b4[] r0 = bo.app.b4.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                bo.app.b4 r1 = bo.app.b4.STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                bo.app.b4 r1 = bo.app.b4.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                bo.app.b4 r1 = bo.app.b4.DATE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                bo.app.b4 r1 = bo.app.b4.NUMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.a4.a.<clinit>():void");
        }
    }

    a4(b4 b4Var, String str, int i) {
        this.b = b4Var;
        this.c = str;
        this.d = i;
    }

    private boolean b(Object obj) {
        if ((obj instanceof Integer) || (obj instanceof Double)) {
            double doubleValue = ((Number) obj).doubleValue();
            double doubleValue2 = ((Number) this.e).doubleValue();
            int i = this.d;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 5 && doubleValue < doubleValue2) {
                            return true;
                        }
                        return false;
                    } else if (doubleValue > doubleValue2) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (doubleValue != doubleValue2) {
                    return true;
                } else {
                    return false;
                }
            } else if (doubleValue == doubleValue2) {
                return true;
            } else {
                return false;
            }
        } else if (this.d == 2) {
            return true;
        } else {
            return false;
        }
    }

    private boolean c(Object obj) {
        if (!(obj instanceof String)) {
            int i = this.d;
            if (i == 2 || i == 17) {
                return true;
            }
            return false;
        }
        int i2 = this.d;
        if (i2 == 1) {
            return obj.equals(this.e);
        }
        if (i2 == 2) {
            return !obj.equals(this.e);
        }
        if (i2 == 10) {
            return a((String) this.e, (String) obj);
        }
        if (i2 != 17) {
            return false;
        }
        return !a((String) this.e, (String) obj);
    }

    public boolean a(u2 u2Var) {
        if (!(u2Var instanceof w2)) {
            return false;
        }
        BrazeProperties c2 = ((w2) u2Var).c();
        Object obj = null;
        if (c2 != null) {
            try {
                obj = c2.forJsonPut().opt(this.c);
            } catch (Exception e2) {
                BrazeLogger.e(f, "Caught exception checking property filter condition.", e2);
                return false;
            }
        }
        if (obj == null) {
            int i = this.d;
            if (i == 12 || i == 17 || i == 2) {
                return true;
            }
            return false;
        }
        int i2 = this.d;
        if (i2 == 11) {
            return true;
        }
        if (i2 == 12) {
            return false;
        }
        int i3 = a.a[this.b.ordinal()];
        if (i3 == 1) {
            return c(obj);
        }
        if (i3 == 2) {
            return a(obj);
        }
        if (i3 == 3) {
            return a(obj, u2Var.b());
        }
        if (i3 != 4) {
            return false;
        }
        return b(obj);
    }

    /* renamed from: u */
    public JSONObject forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!this.b.equals(b4.UNKNOWN)) {
                jSONObject.put("property_type", (Object) this.b.toString());
            }
            jSONObject.put("property_key", (Object) this.c);
            jSONObject.put("comparator", this.d);
            jSONObject.put("property_value", this.e);
        } catch (JSONException e2) {
            BrazeLogger.e(f, "Caught exception creating property filter Json.", e2);
        }
        return jSONObject;
    }

    protected a4(JSONObject jSONObject) {
        this((b4) JsonUtils.optEnum(jSONObject, "property_type", b4.class, b4.UNKNOWN), jSONObject.getString("property_key"), jSONObject.getInt("comparator"));
        if (!jSONObject.has("property_value")) {
            return;
        }
        if (this.b.equals(b4.STRING)) {
            this.e = jSONObject.getString("property_value");
        } else if (this.b.equals(b4.BOOLEAN)) {
            this.e = Boolean.valueOf(jSONObject.getBoolean("property_value"));
        } else if (this.b.equals(b4.NUMBER)) {
            this.e = Double.valueOf(jSONObject.getDouble("property_value"));
        } else if (this.b.equals(b4.DATE)) {
            this.e = Long.valueOf(jSONObject.getLong("property_value"));
        }
    }

    private boolean a(Object obj, long j) {
        Date date = null;
        if (obj instanceof String) {
            try {
                date = DateTimeUtils.parseDate((String) obj, BrazeDateFormat.LONG);
            } catch (Exception e2) {
                BrazeLogger.e(f, "Caught exception trying to parse date in compareTimestamps", e2);
            }
        }
        if (date != null) {
            long timeFromEpochInSeconds = DateTimeUtils.getTimeFromEpochInSeconds(date);
            long longValue = ((Number) this.e).longValue();
            int i = this.d;
            if (i != 15) {
                if (i != 16) {
                    switch (i) {
                        case 1:
                            if (timeFromEpochInSeconds == longValue) {
                                return true;
                            }
                            return false;
                        case 2:
                            if (timeFromEpochInSeconds != longValue) {
                                return true;
                            }
                            return false;
                        case 3:
                            if (timeFromEpochInSeconds > longValue) {
                                return true;
                            }
                            return false;
                        case 4:
                            if (timeFromEpochInSeconds >= j - longValue) {
                                return true;
                            }
                            return false;
                        case 5:
                            if (timeFromEpochInSeconds < longValue) {
                                return true;
                            }
                            return false;
                        case 6:
                            if (timeFromEpochInSeconds <= j - longValue) {
                                return true;
                            }
                            return false;
                        default:
                            return false;
                    }
                } else if (timeFromEpochInSeconds > j + longValue) {
                    return true;
                } else {
                    return false;
                }
            } else if (timeFromEpochInSeconds < j + longValue) {
                return true;
            } else {
                return false;
            }
        } else if (this.d == 2) {
            return true;
        } else {
            return false;
        }
    }

    private boolean a(Object obj) {
        if (obj instanceof Boolean) {
            int i = this.d;
            if (i == 1) {
                return obj.equals(this.e);
            }
            if (i != 2) {
                return false;
            }
            return !obj.equals(this.e);
        } else if (this.d == 2) {
            return true;
        } else {
            return false;
        }
    }

    static boolean a(String str, String str2) {
        return Pattern.compile(str, 2).matcher(str2).find();
    }
}
