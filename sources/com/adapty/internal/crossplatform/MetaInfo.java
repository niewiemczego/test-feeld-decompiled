package com.adapty.internal.crossplatform;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/crossplatform/MetaInfo;", "", "name", "", "version", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MetaInfo.kt */
public final class MetaInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String name;
    private final String version;

    public /* synthetic */ MetaInfo(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    @JvmStatic
    public static final MetaInfo from(CrossplatformName crossplatformName, String str) {
        return Companion.from(crossplatformName, str);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/adapty/internal/crossplatform/MetaInfo$Companion;", "", "()V", "from", "Lcom/adapty/internal/crossplatform/MetaInfo;", "crossplatformName", "Lcom/adapty/internal/crossplatform/CrossplatformName;", "sdkVersion", "", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MetaInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MetaInfo from(CrossplatformName crossplatformName, String str) {
            Intrinsics.checkNotNullParameter(crossplatformName, "crossplatformName");
            Intrinsics.checkNotNullParameter(str, "sdkVersion");
            return new MetaInfo(crossplatformName.getValue$crossplatform_release(), str, (DefaultConstructorMarker) null);
        }
    }

    private MetaInfo(String str, String str2) {
        this.name = str;
        this.version = str2;
    }
}
