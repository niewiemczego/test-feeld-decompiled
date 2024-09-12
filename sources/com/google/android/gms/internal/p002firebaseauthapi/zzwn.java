package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.KeyAgreement;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzwn {
    public static int zza(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        return (zzmd.zza(ellipticCurve).subtract(BigInteger.ONE).bitLength() + 7) / 8;
    }

    private static BigInteger zza(BigInteger bigInteger, boolean z, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger zza = zzmd.zza(ellipticCurve);
        BigInteger mod = bigInteger.multiply(bigInteger).add(ellipticCurve.getA()).multiply(bigInteger).add(ellipticCurve.getB()).mod(zza);
        if (zza.signum() == 1) {
            BigInteger mod2 = mod.mod(zza);
            BigInteger bigInteger4 = null;
            if (mod2.equals(BigInteger.ZERO)) {
                bigInteger2 = BigInteger.ZERO;
            } else {
                if (zza.testBit(0) && zza.testBit(1)) {
                    bigInteger4 = mod2.modPow(zza.add(BigInteger.ONE).shiftRight(2), zza);
                } else if (zza.testBit(0) && !zza.testBit(1)) {
                    bigInteger3 = BigInteger.ONE;
                    BigInteger shiftRight = zza.subtract(BigInteger.ONE).shiftRight(1);
                    int i = 0;
                    while (true) {
                        BigInteger mod3 = bigInteger3.multiply(bigInteger3).subtract(mod2).mod(zza);
                        if (mod3.equals(BigInteger.ZERO)) {
                            break;
                        }
                        BigInteger modPow = mod3.modPow(shiftRight, zza);
                        if (modPow.add(BigInteger.ONE).equals(zza)) {
                            BigInteger shiftRight2 = zza.add(BigInteger.ONE).shiftRight(1);
                            BigInteger bigInteger5 = BigInteger.ONE;
                            BigInteger bigInteger6 = bigInteger5;
                            BigInteger bigInteger7 = bigInteger3;
                            for (int bitLength = shiftRight2.bitLength() - 2; bitLength >= 0; bitLength--) {
                                BigInteger multiply = bigInteger7.multiply(bigInteger6);
                                bigInteger7 = bigInteger7.multiply(bigInteger7).add(bigInteger6.multiply(bigInteger6).mod(zza).multiply(mod3)).mod(zza);
                                bigInteger6 = multiply.add(multiply).mod(zza);
                                if (shiftRight2.testBit(bitLength)) {
                                    BigInteger mod4 = bigInteger7.multiply(bigInteger3).add(bigInteger6.multiply(mod3)).mod(zza);
                                    bigInteger6 = bigInteger3.multiply(bigInteger6).add(bigInteger7).mod(zza);
                                    bigInteger7 = mod4;
                                }
                            }
                            bigInteger4 = bigInteger7;
                        } else if (modPow.equals(BigInteger.ONE)) {
                            bigInteger3 = bigInteger3.add(BigInteger.ONE);
                            i++;
                            if (i == 128 && !zza.isProbablePrime(80)) {
                                throw new InvalidAlgorithmParameterException("p is not prime");
                            }
                        } else {
                            throw new InvalidAlgorithmParameterException("p is not prime");
                        }
                    }
                }
                if (bigInteger3 != null && bigInteger3.multiply(bigInteger3).mod(zza).compareTo(mod2) != 0) {
                    throw new GeneralSecurityException("Could not find a modular square root");
                }
                bigInteger2 = bigInteger3;
            }
            return z != bigInteger2.testBit(0) ? zza.subtract(bigInteger2).mod(zza) : bigInteger2;
        }
        throw new InvalidAlgorithmParameterException("p must be positive");
    }

    public static ECPrivateKey zza(zzwq zzwq, byte[] bArr) throws GeneralSecurityException {
        return (ECPrivateKey) zzwr.zze.zza("EC").generatePrivate(new ECPrivateKeySpec(zzmb.zza(bArr), zza(zzwq)));
    }

    public static ECPublicKey zza(zzwq zzwq, zzwp zzwp, byte[] bArr) throws GeneralSecurityException {
        return zza(zza(zzwq), zzwp, bArr);
    }

    public static ECPublicKey zza(ECParameterSpec eCParameterSpec, zzwp zzwp, byte[] bArr) throws GeneralSecurityException {
        return (ECPublicKey) zzwr.zze.zza("EC").generatePublic(new ECPublicKeySpec(zza(eCParameterSpec.getCurve(), zzwp, bArr), eCParameterSpec));
    }

    public static ECParameterSpec zza(zzwq zzwq) throws NoSuchAlgorithmException {
        int ordinal = zzwq.ordinal();
        if (ordinal == 0) {
            return zzmd.zza;
        }
        if (ordinal == 1) {
            return zzmd.zzb;
        }
        if (ordinal == 2) {
            return zzmd.zzc;
        }
        throw new NoSuchAlgorithmException("curve not implemented:" + String.valueOf(zzwq));
    }

    public static ECPoint zza(EllipticCurve ellipticCurve, zzwp zzwp, byte[] bArr) throws GeneralSecurityException {
        int zza = zza(ellipticCurve);
        int ordinal = zzwp.ordinal();
        boolean z = false;
        if (ordinal != 0) {
            if (ordinal == 1) {
                BigInteger zza2 = zzmd.zza(ellipticCurve);
                if (bArr.length == zza + 1) {
                    byte b = bArr[0];
                    if (b != 2) {
                        if (b == 3) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("invalid format");
                        }
                    }
                    BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (bigInteger.signum() != -1 && bigInteger.compareTo(zza2) < 0) {
                        return new ECPoint(bigInteger, zza(bigInteger, z, ellipticCurve));
                    }
                    throw new GeneralSecurityException("x is out of range");
                }
                throw new GeneralSecurityException("compressed point has wrong length");
            } else if (ordinal != 2) {
                throw new GeneralSecurityException("invalid format:" + String.valueOf(zzwp));
            } else if (bArr.length == zza * 2) {
                ECPoint eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 0, zza)), new BigInteger(1, Arrays.copyOfRange(bArr, zza, bArr.length)));
                zzmd.zza(eCPoint, ellipticCurve);
                return eCPoint;
            } else {
                throw new GeneralSecurityException("invalid point size");
            }
        } else if (bArr.length != (zza * 2) + 1) {
            throw new GeneralSecurityException("invalid point size");
        } else if (bArr[0] == 4) {
            int i = zza + 1;
            ECPoint eCPoint2 = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 1, i)), new BigInteger(1, Arrays.copyOfRange(bArr, i, bArr.length)));
            zzmd.zza(eCPoint2, ellipticCurve);
            return eCPoint2;
        } else {
            throw new GeneralSecurityException("invalid point format");
        }
    }

    public static void zza(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        zzb(eCPublicKey, eCPrivateKey);
        zzmd.zza(eCPublicKey.getW(), eCPrivateKey.getParams().getCurve());
    }

    private static void zzb(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        try {
            if (!zzmd.zza(eCPublicKey.getParams(), eCPrivateKey.getParams())) {
                throw new GeneralSecurityException("invalid public key spec");
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new GeneralSecurityException(e);
        }
    }

    public static byte[] zza(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey) throws GeneralSecurityException {
        zzb(eCPublicKey, eCPrivateKey);
        return zza(eCPrivateKey, eCPublicKey.getW());
    }

    private static byte[] zza(ECPrivateKey eCPrivateKey, ECPoint eCPoint) throws GeneralSecurityException {
        zzmd.zza(eCPoint, eCPrivateKey.getParams().getCurve());
        PublicKey generatePublic = zzwr.zze.zza("EC").generatePublic(new ECPublicKeySpec(eCPoint, eCPrivateKey.getParams()));
        KeyAgreement zza = zzwr.zzc.zza("ECDH");
        zza.init(eCPrivateKey);
        try {
            zza.doPhase(generatePublic, true);
            byte[] generateSecret = zza.generateSecret();
            EllipticCurve curve = eCPrivateKey.getParams().getCurve();
            BigInteger bigInteger = new BigInteger(1, generateSecret);
            if (bigInteger.signum() == -1 || bigInteger.compareTo(zzmd.zza(curve)) >= 0) {
                throw new GeneralSecurityException("shared secret is out of range");
            }
            zza(bigInteger, true, curve);
            return generateSecret;
        } catch (IllegalStateException e) {
            throw new GeneralSecurityException(e);
        }
    }
}
