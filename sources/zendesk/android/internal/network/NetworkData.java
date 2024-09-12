package zendesk.android.internal.network;

import android.content.Context;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.internal.di.ZendeskComponentConfig;
import zendesk.android.internal.extension.AndroidExtKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lzendesk/android/internal/network/NetworkData;", "", "context", "Landroid/content/Context;", "config", "Lzendesk/android/internal/di/ZendeskComponentConfig;", "(Landroid/content/Context;Lzendesk/android/internal/di/ZendeskComponentConfig;)V", "languageTag", "", "userAgent", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetworkData.kt */
public final class NetworkData {
    private final ZendeskComponentConfig config;
    private final Context context;

    @Inject
    public NetworkData(Context context2, ZendeskComponentConfig zendeskComponentConfig) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(zendeskComponentConfig, "config");
        this.context = context2;
        this.config = zendeskComponentConfig;
    }

    public final String userAgent() {
        return "Zendesk-SDK/" + this.config.getVersionName() + " Android/" + this.config.getOsVersion() + " Variant/Zendesk";
    }

    public final String languageTag() {
        return AndroidExtKt.getLanguageTag(this.context);
    }
}
