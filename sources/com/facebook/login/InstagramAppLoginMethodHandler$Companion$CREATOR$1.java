package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/facebook/login/InstagramAppLoginMethodHandler$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/InstagramAppLoginMethodHandler;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/login/InstagramAppLoginMethodHandler;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InstagramAppLoginMethodHandler.kt */
public final class InstagramAppLoginMethodHandler$Companion$CREATOR$1 implements Parcelable.Creator<InstagramAppLoginMethodHandler> {
    InstagramAppLoginMethodHandler$Companion$CREATOR$1() {
    }

    public InstagramAppLoginMethodHandler createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        return new InstagramAppLoginMethodHandler(parcel);
    }

    public InstagramAppLoginMethodHandler[] newArray(int i) {
        return new InstagramAppLoginMethodHandler[i];
    }
}
