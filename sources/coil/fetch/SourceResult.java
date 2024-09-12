package coil.fetch;

import coil.decode.DataSource;
import coil.decode.ImageSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcoil/fetch/SourceResult;", "Lcoil/fetch/FetchResult;", "source", "Lcoil/decode/ImageSource;", "mimeType", "", "dataSource", "Lcoil/decode/DataSource;", "(Lcoil/decode/ImageSource;Ljava/lang/String;Lcoil/decode/DataSource;)V", "getDataSource", "()Lcoil/decode/DataSource;", "getMimeType", "()Ljava/lang/String;", "getSource", "()Lcoil/decode/ImageSource;", "copy", "equals", "", "other", "", "hashCode", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FetchResult.kt */
public final class SourceResult extends FetchResult {
    private final DataSource dataSource;
    private final String mimeType;
    private final ImageSource source;

    public final ImageSource getSource() {
        return this.source;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public SourceResult(ImageSource imageSource, String str, DataSource dataSource2) {
        super((DefaultConstructorMarker) null);
        this.source = imageSource;
        this.mimeType = str;
        this.dataSource = dataSource2;
    }

    public static /* synthetic */ SourceResult copy$default(SourceResult sourceResult, ImageSource imageSource, String str, DataSource dataSource2, int i, Object obj) {
        if ((i & 1) != 0) {
            imageSource = sourceResult.source;
        }
        if ((i & 2) != 0) {
            str = sourceResult.mimeType;
        }
        if ((i & 4) != 0) {
            dataSource2 = sourceResult.dataSource;
        }
        return sourceResult.copy(imageSource, str, dataSource2);
    }

    public final SourceResult copy(ImageSource imageSource, String str, DataSource dataSource2) {
        return new SourceResult(imageSource, str, dataSource2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SourceResult) {
            SourceResult sourceResult = (SourceResult) obj;
            if (!Intrinsics.areEqual((Object) this.source, (Object) sourceResult.source) || !Intrinsics.areEqual((Object) this.mimeType, (Object) sourceResult.mimeType) || this.dataSource != sourceResult.dataSource) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.source.hashCode() * 31;
        String str = this.mimeType;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.dataSource.hashCode();
    }
}
