package com.google.android.recaptcha.internal;

import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzej implements zzen {
    private static final boolean zzb(int i) {
        try {
            new Socket(AndroidInfoHelpers.DEVICE_LOCALHOST, i).close();
            return true;
        } catch (ConnectException unused) {
            return false;
        }
    }

    public final /* synthetic */ Object cs(Object[] objArr) {
        return zzel.zza(this, objArr);
    }

    public final Object zza(Object... objArr) {
        int length = objArr.length;
        ArrayList<Number> arrayList = new ArrayList<>(length);
        int i = 0;
        while (i < length) {
            Integer num = objArr[i];
            if (true != (num instanceof Integer)) {
                num = null;
            }
            Integer num2 = num;
            if (num2 != null) {
                arrayList.add(Integer.valueOf(num2.intValue()));
                i++;
            } else {
                throw new zzae(4, 5, (Throwable) null);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Number intValue : arrayList) {
            int intValue2 = intValue.intValue();
            if (zzb(intValue2)) {
                arrayList2.add(Integer.valueOf(intValue2));
            }
        }
        return arrayList2;
    }
}
