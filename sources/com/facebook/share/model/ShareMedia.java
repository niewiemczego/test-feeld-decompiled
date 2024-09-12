package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMedia.Builder;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b'\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0000*\u0014\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004:\u0002\u0017\u0018B\u001b\b\u0014\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0002\u0010\u0006B\u000f\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0007J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0011H\u0016R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/facebook/share/model/ShareMedia;", "M", "B", "Lcom/facebook/share/model/ShareMedia$Builder;", "Lcom/facebook/share/model/ShareModel;", "builder", "(Lcom/facebook/share/model/ShareMedia$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mediaType", "Lcom/facebook/share/model/ShareMedia$Type;", "getMediaType", "()Lcom/facebook/share/model/ShareMedia$Type;", "params", "Landroid/os/Bundle;", "describeContents", "", "getParameters", "writeToParcel", "", "dest", "flags", "Builder", "Type", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ShareMedia.kt */
public abstract class ShareMedia<M extends ShareMedia<M, B>, B extends Builder<M, B>> implements ShareModel {
    /* access modifiers changed from: private */
    public final Bundle params;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/share/model/ShareMedia$Type;", "", "(Ljava/lang/String;I)V", "PHOTO", "VIDEO", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareMedia.kt */
    public enum Type {
        PHOTO,
        VIDEO
    }

    public int describeContents() {
        return 0;
    }

    public abstract Type getMediaType();

    @Deprecated(message = "This method is deprecated. Use GraphRequest directly to set parameters.")
    public final Bundle getParameters() {
        return new Bundle(this.params);
    }

    protected ShareMedia(Builder<M, B> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.params = new Bundle(builder.getParams$facebook_common_release());
    }

    public ShareMedia(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Bundle readBundle = parcel.readBundle(getClass().getClassLoader());
        this.params = readBundle == null ? new Bundle() : readBundle;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeBundle(this.params);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u0000 \u0017*\u0014\b\u0002\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0003\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00002\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0005J\u0017\u0010\f\u001a\u00028\u00032\b\u0010\r\u001a\u0004\u0018\u00018\u0002H\u0016¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000f\u001a\u00028\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0014\u001a\u00028\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/facebook/share/model/ShareMedia$Builder;", "M", "Lcom/facebook/share/model/ShareMedia;", "B", "Lcom/facebook/share/model/ShareModelBuilder;", "()V", "params", "Landroid/os/Bundle;", "getParams$facebook_common_release", "()Landroid/os/Bundle;", "setParams$facebook_common_release", "(Landroid/os/Bundle;)V", "readFrom", "model", "(Lcom/facebook/share/model/ShareMedia;)Lcom/facebook/share/model/ShareMedia$Builder;", "setParameter", "key", "", "value", "(Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/share/model/ShareMedia$Builder;", "setParameters", "parameters", "(Landroid/os/Bundle;)Lcom/facebook/share/model/ShareMedia$Builder;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareMedia.kt */
    public static abstract class Builder<M extends ShareMedia<M, B>, B extends Builder<M, B>> implements ShareModelBuilder<M, B> {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private Bundle params = new Bundle();

        @JvmStatic
        public static final List<ShareMedia<?, ?>> readListFrom$facebook_common_release(Parcel parcel) {
            return Companion.readListFrom$facebook_common_release(parcel);
        }

        @JvmStatic
        public static final void writeListTo$facebook_common_release(Parcel parcel, int i, List<? extends ShareMedia<?, ?>> list) {
            Companion.writeListTo$facebook_common_release(parcel, i, list);
        }

        public final Bundle getParams$facebook_common_release() {
            return this.params;
        }

        public final void setParams$facebook_common_release(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "<set-?>");
            this.params = bundle;
        }

        @Deprecated(message = "This method is deprecated. Use GraphRequest directly to set parameters.")
        public final B setParameter(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(str2, "value");
            this.params.putString(str, str2);
            return this;
        }

        @Deprecated(message = "This method is deprecated. Use GraphRequest directly to set parameters.")
        public final B setParameters(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
            this.params.putAll(bundle);
            return this;
        }

        public B readFrom(M m) {
            return m == null ? this : setParameters(m.params);
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\bJ3\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0004H\u0001¢\u0006\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/facebook/share/model/ShareMedia$Builder$Companion;", "", "()V", "readListFrom", "", "Lcom/facebook/share/model/ShareMedia;", "parcel", "Landroid/os/Parcel;", "readListFrom$facebook_common_release", "writeListTo", "", "out", "parcelFlags", "", "media", "writeListTo$facebook_common_release", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: ShareMedia.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final void writeListTo$facebook_common_release(Parcel parcel, int i, List<? extends ShareMedia<?, ?>> list) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                Intrinsics.checkNotNullParameter(list, "media");
                Object[] array = list.toArray(new ShareMedia[0]);
                if (array != null) {
                    parcel.writeParcelableArray((Parcelable[]) array, i);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }

            @JvmStatic
            public final List<ShareMedia<?, ?>> readListFrom$facebook_common_release(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Parcelable[] readParcelableArray = parcel.readParcelableArray(ShareMedia.class.getClassLoader());
                if (readParcelableArray == null) {
                    return CollectionsKt.emptyList();
                }
                Collection arrayList = new ArrayList();
                for (Parcelable parcelable : readParcelableArray) {
                    if (parcelable instanceof ShareMedia) {
                        arrayList.add(parcelable);
                    }
                }
                return (List) arrayList;
            }
        }
    }
}
