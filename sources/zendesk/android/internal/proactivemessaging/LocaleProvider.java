package zendesk.android.internal.proactivemessaging;

import android.content.Context;
import androidx.core.os.ConfigurationCompat;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lzendesk/android/internal/proactivemessaging/LocaleProvider;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "locale", "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocaleProvider.kt */
public final class LocaleProvider {
    private final Context context;

    @Inject
    public LocaleProvider(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Locale getLocale() {
        Locale locale = ConfigurationCompat.getLocales(this.context.getResources().getConfiguration()).get(0);
        if (locale != null) {
            return locale;
        }
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
        return locale2;
    }
}
