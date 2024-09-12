package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.GraphRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001J\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J!\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/facebook/GraphRequest$ParcelableResourceWithMimeType$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/GraphRequest$ParcelableResourceWithMimeType;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/GraphRequest$ParcelableResourceWithMimeType;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GraphRequest.kt */
public final class GraphRequest$ParcelableResourceWithMimeType$Companion$CREATOR$1 implements Parcelable.Creator<GraphRequest.ParcelableResourceWithMimeType<?>> {
    GraphRequest$ParcelableResourceWithMimeType$Companion$CREATOR$1() {
    }

    public GraphRequest.ParcelableResourceWithMimeType<?> createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        return new GraphRequest.ParcelableResourceWithMimeType<>(parcel, (DefaultConstructorMarker) null);
    }

    public GraphRequest.ParcelableResourceWithMimeType<?>[] newArray(int i) {
        return new GraphRequest.ParcelableResourceWithMimeType[i];
    }
}
