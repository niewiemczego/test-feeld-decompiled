package com.google.android.recaptcha.internal;

import android.content.Context;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.text.StringsKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzy implements zzh {
    private final Context zza;
    private final String zzb = "rce_";
    private final zzad zzc;

    public zzy(Context context) {
        this.zza = context;
        this.zzc = new zzad(context);
    }

    public final String zza(String str) {
        File file = new File(this.zza.getCacheDir(), this.zzb.concat(String.valueOf(str)));
        if (file.exists()) {
            return new String(zzad.zza(file), StandardCharsets.UTF_8);
        }
        return null;
    }

    public final void zzb() {
        try {
            File[] listFiles = this.zza.getCacheDir().listFiles();
            if (listFiles != null) {
                ArrayList<File> arrayList = new ArrayList<>();
                for (File file : listFiles) {
                    if (StringsKt.startsWith$default(file.getName(), this.zzb, false, 2, (Object) null)) {
                        arrayList.add(file);
                    }
                }
                for (File delete : arrayList) {
                    delete.delete();
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void zzc(String str, String str2) {
        CharRange charRange = new CharRange('A', 'z');
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(charRange, 10));
        Iterator it = charRange.iterator();
        while (it.hasNext()) {
            arrayList.add(Character.valueOf(((CharIterator) it).nextChar()));
        }
        String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.shuffled(arrayList).subList(0, 8), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        File file = new File(this.zza.getCacheDir(), this.zzb.concat(String.valueOf(joinToString$default)));
        zzad.zzb(file, String.valueOf(str2).getBytes(StandardCharsets.UTF_8));
        file.renameTo(new File(this.zza.getCacheDir(), this.zzb.concat(String.valueOf(str))));
    }

    public final boolean zzd(String str) {
        try {
            File[] listFiles = this.zza.getCacheDir().listFiles();
            File file = null;
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    File file2 = listFiles[i];
                    if (Intrinsics.areEqual((Object) file2.getName(), (Object) this.zzb + str)) {
                        file = file2;
                        break;
                    }
                    i++;
                }
            }
            return file != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
