package com.adapty.internal.crossplatform;

import com.adapty.models.AdaptyAttributionSource;
import com.adapty.utils.AdaptyLogLevel;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J/\u0010\u0007\u001a\n \t*\u0004\u0018\u0001H\bH\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\r¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u0012\u001a\n \t*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010\u0013\u001a\u00020\u0001J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/adapty/internal/crossplatform/CrossplatformHelper;", "", "serializationHelper", "Lcom/adapty/internal/crossplatform/SerializationHelper;", "enumConverter", "Lcom/adapty/internal/crossplatform/EnumConverter;", "(Lcom/adapty/internal/crossplatform/SerializationHelper;Lcom/adapty/internal/crossplatform/EnumConverter;)V", "fromJson", "T", "kotlin.jvm.PlatformType", "json", "", "type", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "toAttributionSourceType", "Lcom/adapty/models/AdaptyAttributionSource;", "value", "toJson", "src", "toLogLevel", "Lcom/adapty/utils/AdaptyLogLevel;", "Companion", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CrossplatformHelper.kt */
public final class CrossplatformHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static CrossplatformHelper _shared;
    /* access modifiers changed from: private */
    public static MetaInfo meta;
    /* access modifiers changed from: private */
    public static final CrossplatformHelper shared;
    private final EnumConverter enumConverter;
    private final SerializationHelper serializationHelper;

    @JvmStatic
    @Deprecated(message = "Replace with CrossplatformHelper.init() and then CrossplatformHelper.shared")
    public static final CrossplatformHelper create(MetaInfo metaInfo) {
        return Companion.create(metaInfo);
    }

    public static final synchronized CrossplatformHelper getShared() {
        CrossplatformHelper shared2;
        synchronized (CrossplatformHelper.class) {
            shared2 = Companion.getShared();
        }
        return shared2;
    }

    @JvmStatic
    public static final void init(MetaInfo metaInfo) {
        Companion.init(metaInfo);
    }

    private CrossplatformHelper(SerializationHelper serializationHelper2, EnumConverter enumConverter2) {
        this.serializationHelper = serializationHelper2;
        this.enumConverter = enumConverter2;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0006H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u00020\u00048FX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/adapty/internal/crossplatform/CrossplatformHelper$Companion;", "", "()V", "_shared", "Lcom/adapty/internal/crossplatform/CrossplatformHelper;", "meta", "Lcom/adapty/internal/crossplatform/MetaInfo;", "shared", "getShared$annotations", "getShared", "()Lcom/adapty/internal/crossplatform/CrossplatformHelper;", "create", "metaInfo", "init", "", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CrossplatformHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getShared$annotations() {
        }

        private Companion() {
        }

        @JvmStatic
        public final void init(MetaInfo metaInfo) {
            Intrinsics.checkNotNullParameter(metaInfo, "metaInfo");
            CrossplatformHelper.meta = metaInfo;
        }

        @JvmStatic
        @Deprecated(message = "Replace with CrossplatformHelper.init() and then CrossplatformHelper.shared")
        public final CrossplatformHelper create(MetaInfo metaInfo) {
            Intrinsics.checkNotNullParameter(metaInfo, "metaInfo");
            init(metaInfo);
            return getShared();
        }

        public final synchronized CrossplatformHelper getShared() {
            return CrossplatformHelper.shared;
        }
    }

    static {
        CrossplatformHelper crossplatformHelper = _shared;
        if (crossplatformHelper == null) {
            crossplatformHelper = new CrossplatformHelper(new SerializationHelper(), new EnumConverter());
            _shared = crossplatformHelper;
        }
        shared = crossplatformHelper;
    }

    public final <T> T fromJson(String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.checkNotNullParameter(cls, "type");
        return this.serializationHelper.fromJson(str, cls);
    }

    public final String toJson(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "src");
        return this.serializationHelper.toJson(obj);
    }

    public final AdaptyAttributionSource toAttributionSourceType(String str) {
        return this.enumConverter.toAttributionSourceType(str);
    }

    public final AdaptyLogLevel toLogLevel(String str) {
        return this.enumConverter.toLogLevel(str);
    }
}
