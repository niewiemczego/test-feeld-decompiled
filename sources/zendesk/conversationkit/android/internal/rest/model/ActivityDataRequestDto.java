package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/ActivityDataRequestDto;", "", "author", "Lzendesk/conversationkit/android/internal/rest/model/AuthorDto;", "activity", "Lzendesk/conversationkit/android/internal/rest/model/ActivityDataDto;", "(Lzendesk/conversationkit/android/internal/rest/model/AuthorDto;Lzendesk/conversationkit/android/internal/rest/model/ActivityDataDto;)V", "getActivity", "()Lzendesk/conversationkit/android/internal/rest/model/ActivityDataDto;", "getAuthor", "()Lzendesk/conversationkit/android/internal/rest/model/AuthorDto;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActivityDataRequestDto.kt */
public final class ActivityDataRequestDto {
    private final ActivityDataDto activity;
    private final AuthorDto author;

    public static /* synthetic */ ActivityDataRequestDto copy$default(ActivityDataRequestDto activityDataRequestDto, AuthorDto authorDto, ActivityDataDto activityDataDto, int i, Object obj) {
        if ((i & 1) != 0) {
            authorDto = activityDataRequestDto.author;
        }
        if ((i & 2) != 0) {
            activityDataDto = activityDataRequestDto.activity;
        }
        return activityDataRequestDto.copy(authorDto, activityDataDto);
    }

    public final AuthorDto component1() {
        return this.author;
    }

    public final ActivityDataDto component2() {
        return this.activity;
    }

    public final ActivityDataRequestDto copy(AuthorDto authorDto, ActivityDataDto activityDataDto) {
        Intrinsics.checkNotNullParameter(authorDto, "author");
        Intrinsics.checkNotNullParameter(activityDataDto, "activity");
        return new ActivityDataRequestDto(authorDto, activityDataDto);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityDataRequestDto)) {
            return false;
        }
        ActivityDataRequestDto activityDataRequestDto = (ActivityDataRequestDto) obj;
        return Intrinsics.areEqual((Object) this.author, (Object) activityDataRequestDto.author) && Intrinsics.areEqual((Object) this.activity, (Object) activityDataRequestDto.activity);
    }

    public int hashCode() {
        return (this.author.hashCode() * 31) + this.activity.hashCode();
    }

    public String toString() {
        return "ActivityDataRequestDto(author=" + this.author + ", activity=" + this.activity + ')';
    }

    public ActivityDataRequestDto(AuthorDto authorDto, ActivityDataDto activityDataDto) {
        Intrinsics.checkNotNullParameter(authorDto, "author");
        Intrinsics.checkNotNullParameter(activityDataDto, "activity");
        this.author = authorDto;
        this.activity = activityDataDto;
    }

    public final AuthorDto getAuthor() {
        return this.author;
    }

    public final ActivityDataDto getActivity() {
        return this.activity;
    }
}
