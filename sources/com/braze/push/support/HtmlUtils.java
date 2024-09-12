package com.braze.push.support;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"TAG", "", "getHtmlSpannedTextIfEnabled", "", "configurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "android-sdk-ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: HtmlUtils.kt */
public final class HtmlUtils {
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("HtmlUtils");

    public static final CharSequence getHtmlSpannedTextIfEnabled(String str, BrazeConfigurationProvider brazeConfigurationProvider) {
        Spanned spanned;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        CharSequence charSequence = str;
        if (StringsKt.isBlank(charSequence)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, (Function0) HtmlUtils$getHtmlSpannedTextIfEnabled$1.INSTANCE, 6, (Object) null);
            return charSequence;
        } else if (!brazeConfigurationProvider.isPushNotificationHtmlRenderingEnabled()) {
            return charSequence;
        } else {
            if (Build.VERSION.SDK_INT >= 24) {
                spanned = Html.fromHtml(str, 0);
            } else {
                spanned = Html.fromHtml(str);
            }
            Intrinsics.checkNotNullExpressionValue(spanned, "{\n        if (Build.VERS…tml(this)\n        }\n    }");
            return spanned;
        }
    }
}
