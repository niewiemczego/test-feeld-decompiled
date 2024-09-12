package zendesk.core.android.internal;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0016\u0010\u0005\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0016\u0010\u0005\u001a\u00020\u0002*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u001f\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0016\u0010\b\u001a\u00020\t*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"toDate", "Ljava/util/Date;", "Ljava/time/LocalDateTime;", "zoneId", "Ljava/time/ZoneId;", "toLocalDateTime", "", "(Ljava/lang/Double;Ljava/time/ZoneId;)Ljava/time/LocalDateTime;", "toTimestamp", "", "zendesk.core_core-utilities"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DateKtx.kt */
public final class DateKtxKt {
    public static /* synthetic */ LocalDateTime toLocalDateTime$default(double d, ZoneId zoneId, int i, Object obj) {
        if ((i & 1) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault()");
        }
        return toLocalDateTime(d, zoneId);
    }

    @InternalZendeskApi
    public static final LocalDateTime toLocalDateTime(double d, ZoneId zoneId) {
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        LocalDateTime localDateTime = Instant.ofEpochMilli((long) (d * ((double) 1000))).atZone(zoneId).toLocalDateTime();
        Intrinsics.checkNotNullExpressionValue(localDateTime, "ofEpochMilli((this * 1_0…zoneId).toLocalDateTime()");
        return localDateTime;
    }

    public static /* synthetic */ LocalDateTime toLocalDateTime$default(Double d, ZoneId zoneId, int i, Object obj) {
        if ((i & 1) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault()");
        }
        return toLocalDateTime(d, zoneId);
    }

    @InternalZendeskApi
    public static final LocalDateTime toLocalDateTime(Double d, ZoneId zoneId) {
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        if (d != null) {
            return toLocalDateTime(d.doubleValue(), zoneId);
        }
        return null;
    }

    @InternalZendeskApi
    public static final LocalDateTime toLocalDateTime(Date date, ZoneId zoneId) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        LocalDateTime localDateTime = date.toInstant().atZone(zoneId).toLocalDateTime();
        Intrinsics.checkNotNullExpressionValue(localDateTime, "this.toInstant()\n    .at…d)\n    .toLocalDateTime()");
        return localDateTime;
    }

    public static /* synthetic */ LocalDateTime toLocalDateTime$default(Date date, ZoneId zoneId, int i, Object obj) {
        if ((i & 1) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault()");
        }
        return toLocalDateTime(date, zoneId);
    }

    public static /* synthetic */ Date toDate$default(LocalDateTime localDateTime, ZoneId zoneId, int i, Object obj) {
        if ((i & 1) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault()");
        }
        return toDate(localDateTime, zoneId);
    }

    @InternalZendeskApi
    public static final Date toDate(LocalDateTime localDateTime, ZoneId zoneId) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        Date from = Date.from(localDateTime.atZone(zoneId).toInstant());
        Intrinsics.checkNotNullExpressionValue(from, "from(this.atZone(zoneId).toInstant())");
        return from;
    }

    public static /* synthetic */ long toTimestamp$default(LocalDateTime localDateTime, ZoneId zoneId, int i, Object obj) {
        if ((i & 1) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault()");
        }
        return toTimestamp(localDateTime, zoneId);
    }

    @InternalZendeskApi
    public static final long toTimestamp(LocalDateTime localDateTime, ZoneId zoneId) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        return localDateTime.atZone(zoneId).toInstant().toEpochMilli();
    }
}
