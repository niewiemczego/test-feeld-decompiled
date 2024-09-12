package com.facebook.internal.security;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0016\u0010\u0003\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\t"}, d2 = {"Lcom/facebook/internal/security/CertificateUtil;", "", "()V", "DELIMITER", "", "getDELIMITER$facebook_core_release$annotations", "getCertificateHash", "ctx", "Landroid/content/Context;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CertificateUtil.kt */
public final class CertificateUtil {
    public static final String DELIMITER = ":";
    public static final CertificateUtil INSTANCE = new CertificateUtil();

    public static /* synthetic */ void getDELIMITER$facebook_core_release$annotations() {
    }

    private CertificateUtil() {
    }

    @JvmStatic
    public static final String getCertificateHash(Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            StringBuilder sb = new StringBuilder();
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            Intrinsics.checkNotNullExpressionValue(signatureArr, "signatures");
            int length = signatureArr.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                Signature signature = signatureArr[i];
                i++;
                instance.update(signature.toByteArray());
                sb.append(Base64.encodeToString(instance.digest(), 0));
                sb.append(DELIMITER);
            }
            if (sb.length() > 0) {
                z = true;
            }
            if (z) {
                sb.setLength(sb.length() - 1);
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
            return sb2;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
