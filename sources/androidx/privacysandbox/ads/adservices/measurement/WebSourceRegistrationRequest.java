package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import android.view.InputEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dBK\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest;", "", "webSourceParams", "", "Landroidx/privacysandbox/ads/adservices/measurement/WebSourceParams;", "topOriginUri", "Landroid/net/Uri;", "inputEvent", "Landroid/view/InputEvent;", "appDestination", "webDestination", "verifiedDestination", "(Ljava/util/List;Landroid/net/Uri;Landroid/view/InputEvent;Landroid/net/Uri;Landroid/net/Uri;Landroid/net/Uri;)V", "getAppDestination", "()Landroid/net/Uri;", "getInputEvent", "()Landroid/view/InputEvent;", "getTopOriginUri", "getVerifiedDestination", "getWebDestination", "getWebSourceParams", "()Ljava/util/List;", "equals", "", "other", "hashCode", "", "toString", "", "Builder", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WebSourceRegistrationRequest.kt */
public final class WebSourceRegistrationRequest {
    private final Uri appDestination;
    private final InputEvent inputEvent;
    private final Uri topOriginUri;
    private final Uri verifiedDestination;
    private final Uri webDestination;
    private final List<WebSourceParams> webSourceParams;

    public WebSourceRegistrationRequest(List<WebSourceParams> list, Uri uri, InputEvent inputEvent2, Uri uri2, Uri uri3, Uri uri4) {
        Intrinsics.checkNotNullParameter(list, "webSourceParams");
        Intrinsics.checkNotNullParameter(uri, "topOriginUri");
        this.webSourceParams = list;
        this.topOriginUri = uri;
        this.inputEvent = inputEvent2;
        this.appDestination = uri2;
        this.webDestination = uri3;
        this.verifiedDestination = uri4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebSourceRegistrationRequest(List list, Uri uri, InputEvent inputEvent2, Uri uri2, Uri uri3, Uri uri4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, uri, (i & 4) != 0 ? null : inputEvent2, (i & 8) != 0 ? null : uri2, (i & 16) != 0 ? null : uri3, (i & 32) != 0 ? null : uri4);
    }

    public final List<WebSourceParams> getWebSourceParams() {
        return this.webSourceParams;
    }

    public final Uri getTopOriginUri() {
        return this.topOriginUri;
    }

    public final InputEvent getInputEvent() {
        return this.inputEvent;
    }

    public final Uri getAppDestination() {
        return this.appDestination;
    }

    public final Uri getWebDestination() {
        return this.webDestination;
    }

    public final Uri getVerifiedDestination() {
        return this.verifiedDestination;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSourceRegistrationRequest)) {
            return false;
        }
        WebSourceRegistrationRequest webSourceRegistrationRequest = (WebSourceRegistrationRequest) obj;
        if (!Intrinsics.areEqual((Object) this.webSourceParams, (Object) webSourceRegistrationRequest.webSourceParams) || !Intrinsics.areEqual((Object) this.webDestination, (Object) webSourceRegistrationRequest.webDestination) || !Intrinsics.areEqual((Object) this.appDestination, (Object) webSourceRegistrationRequest.appDestination) || !Intrinsics.areEqual((Object) this.topOriginUri, (Object) webSourceRegistrationRequest.topOriginUri) || !Intrinsics.areEqual((Object) this.inputEvent, (Object) webSourceRegistrationRequest.inputEvent) || !Intrinsics.areEqual((Object) this.verifiedDestination, (Object) webSourceRegistrationRequest.verifiedDestination)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (this.webSourceParams.hashCode() * 31) + this.topOriginUri.hashCode();
        InputEvent inputEvent2 = this.inputEvent;
        if (inputEvent2 != null) {
            hashCode = (hashCode * 31) + inputEvent2.hashCode();
        }
        Uri uri = this.appDestination;
        if (uri != null) {
            hashCode = (hashCode * 31) + uri.hashCode();
        }
        Uri uri2 = this.webDestination;
        if (uri2 != null) {
            hashCode = (hashCode * 31) + uri2.hashCode();
        }
        int hashCode2 = (hashCode * 31) + this.topOriginUri.hashCode();
        InputEvent inputEvent3 = this.inputEvent;
        if (inputEvent3 != null) {
            hashCode2 = (hashCode2 * 31) + inputEvent3.hashCode();
        }
        Uri uri3 = this.verifiedDestination;
        return uri3 != null ? (hashCode2 * 31) + uri3.hashCode() : hashCode2;
    }

    public String toString() {
        return "WebSourceRegistrationRequest { " + ("WebSourceParams=[" + this.webSourceParams + "], TopOriginUri=" + this.topOriginUri + ", InputEvent=" + this.inputEvent + ", AppDestination=" + this.appDestination + ", WebDestination=" + this.webDestination + ", VerifiedDestination=" + this.verifiedDestination) + " }";
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest$Builder;", "", "webSourceParams", "", "Landroidx/privacysandbox/ads/adservices/measurement/WebSourceParams;", "topOriginUri", "Landroid/net/Uri;", "(Ljava/util/List;Landroid/net/Uri;)V", "appDestination", "inputEvent", "Landroid/view/InputEvent;", "verifiedDestination", "webDestination", "build", "Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest;", "setAppDestination", "setInputEvent", "setVerifiedDestination", "setWebDestination", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: WebSourceRegistrationRequest.kt */
    public static final class Builder {
        private Uri appDestination;
        private InputEvent inputEvent;
        private final Uri topOriginUri;
        private Uri verifiedDestination;
        private Uri webDestination;
        private final List<WebSourceParams> webSourceParams;

        public Builder(List<WebSourceParams> list, Uri uri) {
            Intrinsics.checkNotNullParameter(list, "webSourceParams");
            Intrinsics.checkNotNullParameter(uri, "topOriginUri");
            this.webSourceParams = list;
            this.topOriginUri = uri;
        }

        public final Builder setInputEvent(InputEvent inputEvent2) {
            Intrinsics.checkNotNullParameter(inputEvent2, "inputEvent");
            Builder builder = this;
            this.inputEvent = inputEvent2;
            return this;
        }

        public final Builder setAppDestination(Uri uri) {
            Builder builder = this;
            this.appDestination = uri;
            return this;
        }

        public final Builder setWebDestination(Uri uri) {
            Builder builder = this;
            this.webDestination = uri;
            return this;
        }

        public final Builder setVerifiedDestination(Uri uri) {
            Builder builder = this;
            this.verifiedDestination = uri;
            return this;
        }

        public final WebSourceRegistrationRequest build() {
            return new WebSourceRegistrationRequest(this.webSourceParams, this.topOriginUri, this.inputEvent, this.appDestination, this.webDestination, this.verifiedDestination);
        }
    }
}
