package zendesk.conversationkit.android.model;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.core.android.internal.DateKtxKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lzendesk/conversationkit/android/model/LocalDateTimeAdapter;", "", "()V", "fromJson", "Ljava/time/LocalDateTime;", "date", "Ljava/util/Date;", "toJson", "localDateTime", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocalDateTimeAdapter.kt */
public final class LocalDateTimeAdapter {
    @ToJson
    public final Date toJson(LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "localDateTime");
        return DateKtxKt.toDate$default(localDateTime, (ZoneId) null, 1, (Object) null);
    }

    @FromJson
    public final LocalDateTime fromJson(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return DateKtxKt.toLocalDateTime$default(date, (ZoneId) null, 1, (Object) null);
    }
}
