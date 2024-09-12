package expo.modules.kotlin.events;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lexpo/modules/kotlin/events/OnActivityResultPayload;", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "(IILandroid/content/Intent;)V", "getData", "()Landroid/content/Intent;", "getRequestCode", "()I", "getResultCode", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OnActivityResultPayload.kt */
public final class OnActivityResultPayload {
    private final Intent data;
    private final int requestCode;
    private final int resultCode;

    public static /* synthetic */ OnActivityResultPayload copy$default(OnActivityResultPayload onActivityResultPayload, int i, int i2, Intent intent, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = onActivityResultPayload.requestCode;
        }
        if ((i3 & 2) != 0) {
            i2 = onActivityResultPayload.resultCode;
        }
        if ((i3 & 4) != 0) {
            intent = onActivityResultPayload.data;
        }
        return onActivityResultPayload.copy(i, i2, intent);
    }

    public final int component1() {
        return this.requestCode;
    }

    public final int component2() {
        return this.resultCode;
    }

    public final Intent component3() {
        return this.data;
    }

    public final OnActivityResultPayload copy(int i, int i2, Intent intent) {
        return new OnActivityResultPayload(i, i2, intent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnActivityResultPayload)) {
            return false;
        }
        OnActivityResultPayload onActivityResultPayload = (OnActivityResultPayload) obj;
        return this.requestCode == onActivityResultPayload.requestCode && this.resultCode == onActivityResultPayload.resultCode && Intrinsics.areEqual((Object) this.data, (Object) onActivityResultPayload.data);
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.requestCode) * 31) + Integer.hashCode(this.resultCode)) * 31;
        Intent intent = this.data;
        return hashCode + (intent == null ? 0 : intent.hashCode());
    }

    public String toString() {
        int i = this.requestCode;
        int i2 = this.resultCode;
        return "OnActivityResultPayload(requestCode=" + i + ", resultCode=" + i2 + ", data=" + this.data + ")";
    }

    public OnActivityResultPayload(int i, int i2, Intent intent) {
        this.requestCode = i;
        this.resultCode = i2;
        this.data = intent;
    }

    public final Intent getData() {
        return this.data;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final int getResultCode() {
        return this.resultCode;
    }
}
