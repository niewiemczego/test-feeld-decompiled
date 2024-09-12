package com.adapty.internal.crossplatform;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/adapty/internal/crossplatform/CrossplatformName;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue$crossplatform_release", "()Ljava/lang/String;", "REACT_NATIVE", "FLUTTER", "UNITY", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MetaInfo.kt */
public enum CrossplatformName {
    REACT_NATIVE("react-native"),
    FLUTTER("flutter"),
    UNITY("unity");
    
    private final String value;

    private CrossplatformName(String str) {
        this.value = str;
    }

    public final String getValue$crossplatform_release() {
        return this.value;
    }
}
