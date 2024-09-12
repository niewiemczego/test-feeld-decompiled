package com.adapty.internal.utils;

import android.content.pm.PackageInfo;
import android.os.Build;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: MetaInfoRetriever.kt */
final class MetaInfoRetriever$appBuildAndVersion$2 extends Lambda implements Function0<Pair<? extends String, ? extends String>> {
    final /* synthetic */ MetaInfoRetriever this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MetaInfoRetriever$appBuildAndVersion$2(MetaInfoRetriever metaInfoRetriever) {
        super(0);
        this.this$0 = metaInfoRetriever;
    }

    public final Pair<String, String> invoke() {
        String str;
        PackageInfo packageInfo = this.this$0.appContext.getPackageManager().getPackageInfo(this.this$0.appContext.getPackageName(), 0);
        if (Build.VERSION.SDK_INT >= 28) {
            str = String.valueOf(packageInfo.getLongVersionCode());
        } else {
            str = String.valueOf(packageInfo.versionCode);
        }
        return TuplesKt.to(str, packageInfo.versionName);
    }
}
