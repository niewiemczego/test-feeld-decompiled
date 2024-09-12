package com.google.android.exoplayer2.drm;

import android.media.MediaDrmException;
import android.os.PersistableBundle;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DummyExoMediaDrm implements ExoMediaDrm {
    public void acquire() {
    }

    public void closeSession(byte[] bArr) {
    }

    public int getCryptoType() {
        return 1;
    }

    public PersistableBundle getMetrics() {
        return null;
    }

    public String getPropertyString(String str) {
        return "";
    }

    public void release() {
    }

    public void setOnEventListener(ExoMediaDrm.OnEventListener onEventListener) {
    }

    public void setOnExpirationUpdateListener(ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener) {
    }

    public void setOnKeyStatusChangeListener(ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener) {
    }

    public void setPropertyByteArray(String str, byte[] bArr) {
    }

    public void setPropertyString(String str, String str2) {
    }

    public static DummyExoMediaDrm getInstance() {
        return new DummyExoMediaDrm();
    }

    public byte[] openSession() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    public ExoMediaDrm.KeyRequest getKeyRequest(byte[] bArr, List<DrmInitData.SchemeData> list, int i, HashMap<String, String> hashMap) {
        throw new IllegalStateException();
    }

    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    public ExoMediaDrm.ProvisionRequest getProvisionRequest() {
        throw new IllegalStateException();
    }

    public void provideProvisionResponse(byte[] bArr) {
        throw new IllegalStateException();
    }

    public Map<String, String> queryKeyStatus(byte[] bArr) {
        throw new IllegalStateException();
    }

    public boolean requiresSecureDecoder(byte[] bArr, String str) {
        throw new IllegalStateException();
    }

    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    public byte[] getPropertyByteArray(String str) {
        return Util.EMPTY_BYTE_ARRAY;
    }

    public CryptoConfig createCryptoConfig(byte[] bArr) {
        throw new IllegalStateException();
    }
}
