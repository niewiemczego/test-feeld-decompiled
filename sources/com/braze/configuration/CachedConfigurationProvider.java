package com.braze.configuration;

import android.content.Context;
import android.content.res.Resources;
import com.braze.support.BrazeLogger;
import com.braze.support.PackageUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\f\b\u0017\u0018\u0000 02\u00020\u0001:\u000212B%\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\n\u0012\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b.\u0010/J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006J\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\u00022\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0004J$\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0004J$\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0004J$\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007J$\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007J\u0018\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0006H\u0007R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R%\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00063"}, d2 = {"Lcom/braze/configuration/CachedConfigurationProvider;", "", "", "key", "Lcom/braze/configuration/CachedConfigurationProvider$b;", "resourceType", "", "getResourceIdentifier", "getFallbackConfigKey", "primaryKey", "", "defaultValue", "getBooleanValue", "getStringValue", "getIntValue", "getColorValue", "(Ljava/lang/String;)Ljava/lang/Integer;", "", "getStringSetValue", "getDrawableValue", "type", "getRuntimeConfigurationValue", "getResourceConfigurationValue", "getConfigurationValue", "readResourceValue", "resourceId", "getValueFromResources", "Landroid/content/Context;", "context", "Landroid/content/Context;", "shouldUseConfigurationCache", "Z", "Lcom/braze/configuration/RuntimeAppConfigurationProvider;", "runtimeAppConfigurationProvider", "Lcom/braze/configuration/RuntimeAppConfigurationProvider;", "getRuntimeAppConfigurationProvider", "()Lcom/braze/configuration/RuntimeAppConfigurationProvider;", "setRuntimeAppConfigurationProvider", "(Lcom/braze/configuration/RuntimeAppConfigurationProvider;)V", "", "configurationCache", "Ljava/util/Map;", "getConfigurationCache", "()Ljava/util/Map;", "resourcePackageName", "Ljava/lang/String;", "<init>", "(Landroid/content/Context;ZLcom/braze/configuration/RuntimeAppConfigurationProvider;)V", "Companion", "a", "b", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public class CachedConfigurationProvider {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final int MISSING_RESOURCE_IDENTIFIER = 0;
    private final Map<String, Object> configurationCache;
    private Context context;
    private final String resourcePackageName;
    private RuntimeAppConfigurationProvider runtimeAppConfigurationProvider;
    private boolean shouldUseConfigurationCache;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public enum b {
        INTEGER("integer"),
        COLOR("color"),
        BOOLEAN("bool"),
        STRING("string"),
        DRAWABLE_IDENTIFIER("drawable"),
        STRING_ARRAY("array");
        
        private final String b;

        private b(String str) {
            this.b = str;
        }

        public final String b() {
            return this.b;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.braze.configuration.CachedConfigurationProvider$b[] r0 = com.braze.configuration.CachedConfigurationProvider.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.braze.configuration.CachedConfigurationProvider$b r1 = com.braze.configuration.CachedConfigurationProvider.b.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.braze.configuration.CachedConfigurationProvider$b r1 = com.braze.configuration.CachedConfigurationProvider.b.STRING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.braze.configuration.CachedConfigurationProvider$b r1 = com.braze.configuration.CachedConfigurationProvider.b.STRING_ARRAY     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.braze.configuration.CachedConfigurationProvider$b r1 = com.braze.configuration.CachedConfigurationProvider.b.INTEGER     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.braze.configuration.CachedConfigurationProvider$b r1 = com.braze.configuration.CachedConfigurationProvider.b.COLOR     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.braze.configuration.CachedConfigurationProvider$b r1 = com.braze.configuration.CachedConfigurationProvider.b.DRAWABLE_IDENTIFIER     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.configuration.CachedConfigurationProvider.c.<clinit>():void");
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, Object obj) {
            super(0);
            this.b = str;
            this.c = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Using resources value for key: '" + this.b + "' and value: '" + this.c + '\'';
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str, Object obj) {
            super(0);
            this.b = str;
            this.c = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Using runtime override value for key: '" + this.b + "' and value: '" + this.c + '\'';
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str, Object obj) {
            super(0);
            this.b = str;
            this.c = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Primary key '" + this.b + "' had no identifier. No secondary key to read resource value. Returning default value: '" + this.c + '\'';
        }
    }

    static final class g extends Lambda implements Function0 {
        public static final g b = new g();

        g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception retrieving resource value";
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ b b;
        final /* synthetic */ String c;
        final /* synthetic */ Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(b bVar, String str, Object obj) {
            super(0);
            this.b = bVar;
            this.c = str;
            this.d = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unable to find the xml " + this.b + " configuration value with primary key '" + this.c + "'. Using default value '" + this.d + "'.";
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CachedConfigurationProvider(Context context2) {
        this(context2, false, (RuntimeAppConfigurationProvider) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context2, "context");
    }

    private final String getFallbackConfigKey(String str) {
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "braze", false, 2, (Object) null)) {
            return StringsKt.replace$default(str, "braze", "appboy", false, 4, (Object) null);
        }
        return null;
    }

    private final int getResourceIdentifier(String str, b bVar) {
        if (str == null) {
            return 0;
        }
        return this.context.getResources().getIdentifier(str, bVar.b(), this.resourcePackageName);
    }

    public final boolean getBooleanValue(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "primaryKey");
        Object configurationValue = getConfigurationValue(b.BOOLEAN, str, Boolean.valueOf(z));
        Intrinsics.checkNotNull(configurationValue, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) configurationValue).booleanValue();
    }

    public final Integer getColorValue(String str) {
        Intrinsics.checkNotNullParameter(str, "primaryKey");
        return (Integer) getConfigurationValue(b.COLOR, str, (Object) null);
    }

    public final Map<String, Object> getConfigurationCache() {
        return this.configurationCache;
    }

    public final Object getConfigurationValue(b bVar, String str, Object obj) {
        Intrinsics.checkNotNullParameter(bVar, "type");
        Intrinsics.checkNotNullParameter(str, "key");
        if (this.shouldUseConfigurationCache && this.configurationCache.containsKey(str)) {
            return this.configurationCache.get(str);
        }
        if (this.runtimeAppConfigurationProvider.containsKey(str)) {
            return getRuntimeConfigurationValue(bVar, str, obj);
        }
        return getResourceConfigurationValue(bVar, str, obj);
    }

    /* access modifiers changed from: protected */
    public final int getDrawableValue(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "primaryKey");
        Object configurationValue = getConfigurationValue(b.DRAWABLE_IDENTIFIER, str, Integer.valueOf(i));
        Intrinsics.checkNotNull(configurationValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) configurationValue).intValue();
    }

    public final int getIntValue(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "primaryKey");
        Object configurationValue = getConfigurationValue(b.INTEGER, str, Integer.valueOf(i));
        Intrinsics.checkNotNull(configurationValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) configurationValue).intValue();
    }

    /* access modifiers changed from: protected */
    public final Object getResourceConfigurationValue(b bVar, String str, Object obj) {
        Intrinsics.checkNotNullParameter(bVar, "type");
        Intrinsics.checkNotNullParameter(str, "key");
        Object readResourceValue = readResourceValue(bVar, str, obj);
        this.configurationCache.put(str, readResourceValue);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new d(str, readResourceValue), 3, (Object) null);
        return readResourceValue;
    }

    public final RuntimeAppConfigurationProvider getRuntimeAppConfigurationProvider() {
        return this.runtimeAppConfigurationProvider;
    }

    /* access modifiers changed from: protected */
    public final Object getRuntimeConfigurationValue(b bVar, String str, Object obj) {
        Object obj2;
        int i;
        Intrinsics.checkNotNullParameter(bVar, "type");
        Intrinsics.checkNotNullParameter(str, "key");
        switch (c.a[bVar.ordinal()]) {
            case 1:
                RuntimeAppConfigurationProvider runtimeAppConfigurationProvider2 = this.runtimeAppConfigurationProvider;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                obj2 = Boolean.valueOf(runtimeAppConfigurationProvider2.getBooleanValue(str, ((Boolean) obj).booleanValue()));
                break;
            case 2:
                obj2 = this.runtimeAppConfigurationProvider.getStringValue(str, (String) obj);
                break;
            case 3:
                RuntimeAppConfigurationProvider runtimeAppConfigurationProvider3 = this.runtimeAppConfigurationProvider;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String?>");
                obj2 = runtimeAppConfigurationProvider3.getStringSetValue(str, (Set) obj);
                break;
            case 4:
            case 5:
                if (obj == null) {
                    i = this.runtimeAppConfigurationProvider.getIntValue(str, 0);
                } else {
                    i = this.runtimeAppConfigurationProvider.getIntValue(str, ((Integer) obj).intValue());
                }
                obj2 = Integer.valueOf(i);
                break;
            case 6:
                obj2 = Integer.valueOf(getResourceIdentifier(this.runtimeAppConfigurationProvider.getStringValue(str, ""), b.DRAWABLE_IDENTIFIER));
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        this.configurationCache.put(str, obj2);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new e(str, obj2), 3, (Object) null);
        return obj2;
    }

    public final Set<String> getStringSetValue(String str, Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "primaryKey");
        Object configurationValue = getConfigurationValue(b.STRING_ARRAY, str, set);
        if (configurationValue == null) {
            return set;
        }
        return (Set) configurationValue;
    }

    public final String getStringValue(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "primaryKey");
        return (String) getConfigurationValue(b.STRING, str, str2);
    }

    public final Object getValueFromResources(b bVar, int i) {
        Intrinsics.checkNotNullParameter(bVar, "type");
        Resources resources = this.context.getResources();
        switch (c.a[bVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(resources.getBoolean(i));
            case 2:
                String string = resources.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(resourceId)");
                return string;
            case 3:
                String[] stringArray = resources.getStringArray(i);
                Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(resourceId)");
                return new HashSet(CollectionsKt.listOf(Arrays.copyOf(stringArray, stringArray.length)));
            case 4:
                return Integer.valueOf(resources.getInteger(i));
            case 5:
                return Integer.valueOf(resources.getColor(i));
            case 6:
                return Integer.valueOf(i);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final Object readResourceValue(b bVar, String str, Object obj) {
        Intrinsics.checkNotNullParameter(bVar, "type");
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            int resourceIdentifier = getResourceIdentifier(str, bVar);
            if (resourceIdentifier != 0) {
                return getValueFromResources(bVar, resourceIdentifier);
            }
            String fallbackConfigKey = getFallbackConfigKey(str);
            if (fallbackConfigKey == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new f(str, obj), 3, (Object) null);
                return obj;
            }
            int resourceIdentifier2 = getResourceIdentifier(fallbackConfigKey, bVar);
            if (resourceIdentifier2 != 0) {
                return getValueFromResources(bVar, resourceIdentifier2);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new h(bVar, str, obj), 3, (Object) null);
            return obj;
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) g.b);
        }
    }

    public final void setRuntimeAppConfigurationProvider(RuntimeAppConfigurationProvider runtimeAppConfigurationProvider2) {
        Intrinsics.checkNotNullParameter(runtimeAppConfigurationProvider2, "<set-?>");
        this.runtimeAppConfigurationProvider = runtimeAppConfigurationProvider2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CachedConfigurationProvider(Context context2, boolean z) {
        this(context2, z, (RuntimeAppConfigurationProvider) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context2, "context");
    }

    public CachedConfigurationProvider(Context context2, boolean z, RuntimeAppConfigurationProvider runtimeAppConfigurationProvider2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(runtimeAppConfigurationProvider2, "runtimeAppConfigurationProvider");
        this.context = context2;
        this.shouldUseConfigurationCache = z;
        this.runtimeAppConfigurationProvider = runtimeAppConfigurationProvider2;
        Map<String, Object> synchronizedMap = Collections.synchronizedMap(new HashMap());
        Intrinsics.checkNotNullExpressionValue(synchronizedMap, "synchronizedMap(HashMap())");
        this.configurationCache = synchronizedMap;
        this.resourcePackageName = PackageUtils.getResourcePackageName(this.context);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CachedConfigurationProvider(Context context2, boolean z, RuntimeAppConfigurationProvider runtimeAppConfigurationProvider2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i & 2) != 0 ? true : z, (i & 4) != 0 ? new RuntimeAppConfigurationProvider(context2) : runtimeAppConfigurationProvider2);
    }
}
