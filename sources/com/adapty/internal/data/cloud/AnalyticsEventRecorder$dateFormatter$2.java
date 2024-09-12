package com.adapty.internal.data.cloud;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/text/SimpleDateFormat;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnalyticsEventRecorder.kt */
final class AnalyticsEventRecorder$dateFormatter$2 extends Lambda implements Function0<SimpleDateFormat> {
    public static final AnalyticsEventRecorder$dateFormatter$2 INSTANCE = new AnalyticsEventRecorder$dateFormatter$2();

    AnalyticsEventRecorder$dateFormatter$2() {
        super(0);
    }

    public final SimpleDateFormat invoke() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
