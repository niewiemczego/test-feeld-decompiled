package com.appsflyer;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import com.appsflyer.internal.AFa1cSDK;
import com.oblador.keychain.cipherStorage.CipherStorageBase;
import com.oblador.keychain.cipherStorage.CipherStorageKeystoreRsaEcb;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

public class AFKeystoreWrapper {
    public KeyStore AFInAppEventParameterName;
    public final Object AFInAppEventType = new Object();
    private Context AFKeystoreWrapper;
    public int valueOf;
    public String values;

    public AFKeystoreWrapper(Context context) {
        this.AFKeystoreWrapper = context;
        this.values = "";
        this.valueOf = 0;
        AFLogger.afInfoLog("Initialising KeyStore..");
        try {
            KeyStore instance = KeyStore.getInstance(CipherStorageBase.KEYSTORE_TYPE);
            this.AFInAppEventParameterName = instance;
            instance.load((KeyStore.LoadStoreParameter) null);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            AFLogger.afErrorLog("Couldn't load keystore instance of type: AndroidKeyStore", e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        r1 = r4.split(",");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        if (r1.length != 3) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        com.appsflyer.AFLogger.afInfoLog("Found a matching AF key with alias:\n".concat(java.lang.String.valueOf(r4)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3 = r1[1].trim().split("=");
        r1 = r1[2].trim().split("=");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (r3.length != 2) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        if (r1.length != 2) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0057, code lost:
        r7.values = r3[1].trim();
        r7.valueOf = java.lang.Integer.parseInt(r1[1].trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006c, code lost:
        r1 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean AFKeystoreWrapper() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.AFInAppEventType
            monitor-enter(r0)
            java.security.KeyStore r1 = r7.AFInAppEventParameterName     // Catch:{ all -> 0x008e }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x008b
            java.util.Enumeration r1 = r1.aliases()     // Catch:{ all -> 0x006e }
        L_0x000d:
            boolean r4 = r1.hasMoreElements()     // Catch:{ all -> 0x006e }
            if (r4 == 0) goto L_0x008b
            java.lang.Object r4 = r1.nextElement()     // Catch:{ all -> 0x006e }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x006e }
            if (r4 == 0) goto L_0x000d
            boolean r5 = valueOf(r4)     // Catch:{ all -> 0x006e }
            if (r5 == 0) goto L_0x000d
            java.lang.String r1 = ","
            java.lang.String[] r1 = r4.split(r1)     // Catch:{ all -> 0x006e }
            int r5 = r1.length     // Catch:{ all -> 0x006e }
            r6 = 3
            if (r5 != r6) goto L_0x008b
            java.lang.String r5 = "Found a matching AF key with alias:\n"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x006e }
            java.lang.String r4 = r5.concat(r4)     // Catch:{ all -> 0x006e }
            com.appsflyer.AFLogger.afInfoLog(r4)     // Catch:{ all -> 0x006e }
            r3 = r1[r2]     // Catch:{ all -> 0x006c }
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x006c }
            java.lang.String r4 = "="
            java.lang.String[] r3 = r3.split(r4)     // Catch:{ all -> 0x006c }
            r4 = 2
            r1 = r1[r4]     // Catch:{ all -> 0x006c }
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x006c }
            java.lang.String r5 = "="
            java.lang.String[] r1 = r1.split(r5)     // Catch:{ all -> 0x006c }
            int r5 = r3.length     // Catch:{ all -> 0x006c }
            if (r5 != r4) goto L_0x008c
            int r5 = r1.length     // Catch:{ all -> 0x006c }
            if (r5 != r4) goto L_0x008c
            r3 = r3[r2]     // Catch:{ all -> 0x006c }
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x006c }
            r7.values = r3     // Catch:{ all -> 0x006c }
            r1 = r1[r2]     // Catch:{ all -> 0x006c }
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x006c }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x006c }
            r7.valueOf = r1     // Catch:{ all -> 0x006c }
            goto L_0x008c
        L_0x006c:
            r1 = move-exception
            goto L_0x0070
        L_0x006e:
            r1 = move-exception
            r2 = r3
        L_0x0070:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            java.lang.String r4 = "Couldn't list KeyStore Aliases: "
            r3.<init>(r4)     // Catch:{ all -> 0x008e }
            java.lang.Class r4 = r1.getClass()     // Catch:{ all -> 0x008e }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x008e }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x008e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x008e }
            com.appsflyer.AFLogger.afErrorLog(r3, r1)     // Catch:{ all -> 0x008e }
            goto L_0x008c
        L_0x008b:
            r2 = r3
        L_0x008c:
            monitor-exit(r0)     // Catch:{ all -> 0x008e }
            return r2
        L_0x008e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AFKeystoreWrapper.AFKeystoreWrapper():boolean");
    }

    public final void AFInAppEventType(String str) {
        AFLogger.afInfoLog("Creating a new key with alias: ".concat(String.valueOf(str)));
        try {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.add(1, 5);
            AlgorithmParameterSpec algorithmParameterSpec = null;
            synchronized (this.AFInAppEventType) {
                if (!this.AFInAppEventParameterName.containsAlias(str)) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        algorithmParameterSpec = new KeyGenParameterSpec.Builder(str, 3).setCertificateSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setCertificateSerialNumber(BigInteger.ONE).setCertificateNotBefore(instance.getTime()).setCertificateNotAfter(instance2.getTime()).build();
                    } else if (Build.VERSION.SDK_INT >= 18 && !AFa1cSDK.AFKeystoreWrapper()) {
                        algorithmParameterSpec = new KeyPairGeneratorSpec.Builder(this.AFKeystoreWrapper).setAlias(str).setSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setSerialNumber(BigInteger.ONE).setStartDate(instance.getTime()).setEndDate(instance2.getTime()).build();
                    }
                    KeyPairGenerator instance3 = KeyPairGenerator.getInstance(CipherStorageKeystoreRsaEcb.ALGORITHM_RSA, CipherStorageBase.KEYSTORE_TYPE);
                    instance3.initialize(algorithmParameterSpec);
                    instance3.generateKeyPair();
                } else {
                    AFLogger.afInfoLog("Alias already exists: ".concat(String.valueOf(str)));
                }
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog(new StringBuilder("Exception ").append(th.getMessage()).append(" occurred").toString(), th);
        }
    }

    private static boolean valueOf(String str) {
        return str.startsWith("com.appsflyer");
    }

    public final String AFInAppEventParameterName() {
        StringBuilder sb = new StringBuilder();
        sb.append("com.appsflyer,");
        synchronized (this.AFInAppEventType) {
            sb.append("KSAppsFlyerId=").append(this.values).append(",");
            sb.append("KSAppsFlyerRICounter=").append(this.valueOf);
        }
        return sb.toString();
    }

    public final String values() {
        String str;
        synchronized (this.AFInAppEventType) {
            str = this.values;
        }
        return str;
    }

    public final int AFInAppEventType() {
        int i;
        synchronized (this.AFInAppEventType) {
            i = this.valueOf;
        }
        return i;
    }
}
