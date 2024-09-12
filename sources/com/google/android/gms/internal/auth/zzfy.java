package com.google.android.gms.internal.auth;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzfy {
    static String zza(zzfw zzfw, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzfw, sb, 0);
        return sb.toString();
    }

    static final void zzb(StringBuilder sb, int i, String str, Object obj) {
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
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzgw.zza(zzee.zzl((String) obj)));
                sb.append(Typography.quote);
            } else if (obj instanceof zzee) {
                sb.append(": \"");
                sb.append(zzgw.zza((zzee) obj));
                sb.append(Typography.quote);
            } else if (obj instanceof zzeu) {
                sb.append(" {");
                zzd((zzeu) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i4 = i + 2;
                zzb(sb, i4, "key", entry.getKey());
                zzb(sb, i4, "value", entry.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    private static final String zzc(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    private static void zzd(zzfw zzfw, StringBuilder sb, int i) {
        boolean z;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Method method : zzfw.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String substring = str.startsWith("get") ? str.substring(3) : str;
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                String concat = String.valueOf(substring.substring(0, 1).toLowerCase()).concat(String.valueOf(substring.substring(1, substring.length() - 4)));
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i, zzc(concat), zzeu.zze(method2, zzfw, new Object[0]));
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String concat2 = String.valueOf(substring.substring(0, 1).toLowerCase()).concat(String.valueOf(substring.substring(1, substring.length() - 3)));
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i, zzc(concat2), zzeu.zze(method3, zzfw, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set".concat(String.valueOf(substring)))) != null && (!substring.endsWith("Bytes") || !hashMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                String concat3 = String.valueOf(substring.substring(0, 1).toLowerCase()).concat(String.valueOf(substring.substring(1)));
                Method method4 = (Method) hashMap.get("get".concat(String.valueOf(substring)));
                Method method5 = (Method) hashMap.get("has".concat(String.valueOf(substring)));
                if (method4 != null) {
                    Object zze = zzeu.zze(method4, zzfw, new Object[0]);
                    if (method5 == null) {
                        if (zze instanceof Boolean) {
                            if (!((Boolean) zze).booleanValue()) {
                            }
                        } else if (zze instanceof Integer) {
                            if (((Integer) zze).intValue() == 0) {
                            }
                        } else if (zze instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zze).floatValue()) == 0) {
                            }
                        } else if (!(zze instanceof Double)) {
                            if (zze instanceof String) {
                                z = zze.equals("");
                            } else if (zze instanceof zzee) {
                                z = zze.equals(zzee.zzb);
                            } else if (zze instanceof zzfw) {
                                if (zze == ((zzfw) zze).zzh()) {
                                }
                            } else if ((zze instanceof Enum) && ((Enum) zze).ordinal() == 0) {
                            }
                            if (z) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zze).doubleValue()) == 0) {
                        }
                    } else if (!((Boolean) zzeu.zze(method5, zzfw, new Object[0])).booleanValue()) {
                    }
                    zzb(sb, i, zzc(concat3), zze);
                }
            }
        }
        if (!(zzfw instanceof zzet)) {
            zzgz zzgz = ((zzeu) zzfw).zzc;
            if (zzgz != null) {
                zzgz.zze(sb, i);
                return;
            }
            return;
        }
        zzep zzep = ((zzet) zzfw).zzb;
        throw null;
    }
}
