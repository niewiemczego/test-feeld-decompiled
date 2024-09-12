package com.google.android.gms.internal.play_billing;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzge {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String zza(zzgc zzgc, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzgc, sb, 0);
        return sb.toString();
    }

    static void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb, i, str, zzb);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(sb, i, str, zzb2);
            }
        } else {
            sb.append(10);
            zzc(i, sb);
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Character.toLowerCase(str.charAt(0)));
                for (int i2 = 1; i2 < str.length(); i2++) {
                    char charAt = str.charAt(i2);
                    if (Character.isUpperCase(charAt)) {
                        sb2.append("_");
                    }
                    sb2.append(Character.toLowerCase(charAt));
                }
                str = sb2.toString();
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzhb.zza(new zzdt(((String) obj).getBytes(zzfd.zzb))));
                sb.append(Typography.quote);
            } else if (obj instanceof zzdw) {
                sb.append(": \"");
                sb.append(zzhb.zza((zzdw) obj));
                sb.append(Typography.quote);
            } else if (obj instanceof zzex) {
                sb.append(" {");
                zzd((zzex) obj, sb, i + 2);
                sb.append("\n");
                zzc(i, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                int i3 = i + 2;
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                zzb(sb, i3, "key", entry.getKey());
                zzb(sb, i3, "value", entry.getValue());
                sb.append("\n");
                zzc(i, sb);
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    private static void zzc(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }

    private static void zzd(zzgc zzgc, StringBuilder sb, int i) {
        int i2;
        boolean z;
        Method method;
        Method method2;
        zzgc zzgc2 = zzgc;
        StringBuilder sb2 = sb;
        int i3 = i;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzgc.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i4 = 0;
        while (true) {
            i2 = 3;
            if (i4 >= length) {
                break;
            }
            Method method3 = declaredMethods[i4];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i4++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i2);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb2, i3, substring.substring(0, substring.length() - 4), zzex.zzl(method2, zzgc2, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb2, i3, substring.substring(0, substring.length() - 3), zzex.zzl(method, zzgc2, new Object[0]));
            } else if (hashSet.contains("set".concat(String.valueOf(substring))) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(String.valueOf(substring)));
                if (method4 != null) {
                    Object zzl = zzex.zzl(method4, zzgc2, new Object[0]);
                    if (method5 == null) {
                        if (zzl instanceof Boolean) {
                            if (!((Boolean) zzl).booleanValue()) {
                            }
                        } else if (zzl instanceof Integer) {
                            if (((Integer) zzl).intValue() == 0) {
                            }
                        } else if (zzl instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzl).floatValue()) == 0) {
                            }
                        } else if (!(zzl instanceof Double)) {
                            if (zzl instanceof String) {
                                z = zzl.equals("");
                            } else if (zzl instanceof zzdw) {
                                z = zzl.equals(zzdw.zzb);
                            } else if (zzl instanceof zzgc) {
                                if (zzl == ((zzgc) zzl).zzf()) {
                                }
                            } else if ((zzl instanceof Enum) && ((Enum) zzl).ordinal() == 0) {
                            }
                            if (z) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zzl).doubleValue()) == 0) {
                        }
                    } else if (!((Boolean) zzex.zzl(method5, zzgc2, new Object[0])).booleanValue()) {
                    }
                    zzb(sb2, i3, substring, zzl);
                }
            }
            i2 = 3;
        }
        if (!(zzgc2 instanceof zzeu)) {
            zzhe zzhe = ((zzex) zzgc2).zzc;
            if (zzhe != null) {
                zzhe.zzi(sb2, i3);
                return;
            }
            return;
        }
        zzeo zzeo = ((zzeu) zzgc2).zzb;
        throw null;
    }
}
