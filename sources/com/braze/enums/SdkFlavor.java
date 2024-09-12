package com.braze.enums;

import com.braze.models.IPutIntoJson;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/braze/enums/SdkFlavor;", "", "Lcom/braze/models/IPutIntoJson;", "", "jsonKey", "(Ljava/lang/String;ILjava/lang/String;)V", "forJsonPut", "UNITY", "REACT", "CORDOVA", "XAMARIN", "FLUTTER", "SEGMENT", "TEALIUM", "MPARTICLE", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum SdkFlavor implements IPutIntoJson<String> {
    UNITY("unity"),
    REACT("react"),
    CORDOVA("cordova"),
    XAMARIN("xamarin"),
    FLUTTER("flutter"),
    SEGMENT("segment"),
    TEALIUM("tealium"),
    MPARTICLE("mparticle");
    
    private final String jsonKey;

    private SdkFlavor(String str) {
        this.jsonKey = str;
    }

    public String forJsonPut() {
        return this.jsonKey;
    }
}
