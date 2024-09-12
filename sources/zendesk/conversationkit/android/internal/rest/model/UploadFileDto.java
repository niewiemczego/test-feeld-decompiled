package zendesk.conversationkit.android.internal.rest.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/UploadFileDto;", "", "author", "Lzendesk/conversationkit/android/internal/rest/model/AuthorDto;", "metadata", "Lzendesk/conversationkit/android/internal/rest/model/MetadataDto;", "upload", "Lzendesk/conversationkit/android/internal/rest/model/Upload;", "(Lzendesk/conversationkit/android/internal/rest/model/AuthorDto;Lzendesk/conversationkit/android/internal/rest/model/MetadataDto;Lzendesk/conversationkit/android/internal/rest/model/Upload;)V", "getAuthor", "()Lzendesk/conversationkit/android/internal/rest/model/AuthorDto;", "getMetadata", "()Lzendesk/conversationkit/android/internal/rest/model/MetadataDto;", "getUpload", "()Lzendesk/conversationkit/android/internal/rest/model/Upload;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UploadFileDto.kt */
public final class UploadFileDto {
    private final AuthorDto author;
    private final MetadataDto metadata;
    private final Upload upload;

    public static /* synthetic */ UploadFileDto copy$default(UploadFileDto uploadFileDto, AuthorDto authorDto, MetadataDto metadataDto, Upload upload2, int i, Object obj) {
        if ((i & 1) != 0) {
            authorDto = uploadFileDto.author;
        }
        if ((i & 2) != 0) {
            metadataDto = uploadFileDto.metadata;
        }
        if ((i & 4) != 0) {
            upload2 = uploadFileDto.upload;
        }
        return uploadFileDto.copy(authorDto, metadataDto, upload2);
    }

    public final AuthorDto component1() {
        return this.author;
    }

    public final MetadataDto component2() {
        return this.metadata;
    }

    public final Upload component3() {
        return this.upload;
    }

    public final UploadFileDto copy(AuthorDto authorDto, MetadataDto metadataDto, Upload upload2) {
        Intrinsics.checkNotNullParameter(authorDto, "author");
        Intrinsics.checkNotNullParameter(metadataDto, TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullParameter(upload2, "upload");
        return new UploadFileDto(authorDto, metadataDto, upload2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadFileDto)) {
            return false;
        }
        UploadFileDto uploadFileDto = (UploadFileDto) obj;
        return Intrinsics.areEqual((Object) this.author, (Object) uploadFileDto.author) && Intrinsics.areEqual((Object) this.metadata, (Object) uploadFileDto.metadata) && Intrinsics.areEqual((Object) this.upload, (Object) uploadFileDto.upload);
    }

    public int hashCode() {
        return (((this.author.hashCode() * 31) + this.metadata.hashCode()) * 31) + this.upload.hashCode();
    }

    public String toString() {
        return "UploadFileDto(author=" + this.author + ", metadata=" + this.metadata + ", upload=" + this.upload + ')';
    }

    public UploadFileDto(AuthorDto authorDto, MetadataDto metadataDto, Upload upload2) {
        Intrinsics.checkNotNullParameter(authorDto, "author");
        Intrinsics.checkNotNullParameter(metadataDto, TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullParameter(upload2, "upload");
        this.author = authorDto;
        this.metadata = metadataDto;
        this.upload = upload2;
    }

    public final AuthorDto getAuthor() {
        return this.author;
    }

    public final MetadataDto getMetadata() {
        return this.metadata;
    }

    public final Upload getUpload() {
        return this.upload;
    }
}
