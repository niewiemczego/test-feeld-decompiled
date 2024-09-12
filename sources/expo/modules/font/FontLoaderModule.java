package expo.modules.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.core.ExportedModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.ModuleRegistryDelegate;
import expo.modules.core.Promise;
import expo.modules.core.interfaces.ExpoMethod;
import expo.modules.interfaces.constants.ConstantsInterface;
import expo.modules.interfaces.font.FontManagerInterface;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u001f\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u0001H\u0014H\u00140\u0013\"\u0006\b\u0000\u0010\u0014\u0018\u0001H\bJ\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0017H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018²\u0006\f\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0002²\u0006\f\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0002"}, d2 = {"Lexpo/modules/font/FontLoaderModule;", "Lexpo/modules/core/ExportedModule;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isScoped", "", "()Z", "moduleRegistryDelegate", "Lexpo/modules/core/ModuleRegistryDelegate;", "getName", "", "loadAsync", "", "fontFamilyName", "localUri", "promise", "Lexpo/modules/core/Promise;", "moduleRegistry", "Lkotlin/Lazy;", "T", "kotlin.jvm.PlatformType", "onCreate", "Lexpo/modules/core/ModuleRegistry;", "expo-font_release", "fontManager", "Lexpo/modules/interfaces/font/FontManagerInterface;", "constantsModule", "Lexpo/modules/interfaces/constants/ConstantsInterface;"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FontLoaderModule.kt */
public final class FontLoaderModule extends ExportedModule {
    private final ModuleRegistryDelegate moduleRegistryDelegate = new ModuleRegistryDelegate();

    public String getName() {
        return "ExpoFontLoader";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FontLoaderModule(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final /* synthetic */ <T> Lazy<T> moduleRegistry() {
        ModuleRegistryDelegate moduleRegistryDelegate2 = this.moduleRegistryDelegate;
        Intrinsics.needClassReification();
        return LazyKt.lazy(new FontLoaderModule$moduleRegistry$$inlined$getFromModuleRegistry$1(moduleRegistryDelegate2));
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        Intrinsics.checkNotNullParameter(moduleRegistry, "moduleRegistry");
        this.moduleRegistryDelegate.onCreate(moduleRegistry);
    }

    @ExpoMethod
    public final void loadAsync(String str, String str2, Promise promise) {
        Typeface typeface;
        Intrinsics.checkNotNullParameter(str, "fontFamilyName");
        Intrinsics.checkNotNullParameter(str2, "localUri");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            String str3 = isScoped() ? "ExpoFont-" : "";
            if (StringsKt.startsWith$default(str2, "asset://", false, 2, (Object) null)) {
                AssetManager assets = getContext().getAssets();
                String substring = str2.substring(9);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                typeface = Typeface.createFromAsset(assets, substring);
                Intrinsics.checkNotNullExpressionValue(typeface, "{\n        Typeface.creat…th + 1)\n        )\n      }");
            } else {
                typeface = Typeface.createFromFile(new File(Uri.parse(str2).getPath()));
                Intrinsics.checkNotNullExpressionValue(typeface, "{\n        Typeface.creat…(localUri).path))\n      }");
            }
            Lazy lazy = LazyKt.lazy(new FontLoaderModule$loadAsync$$inlined$moduleRegistry$1(this.moduleRegistryDelegate));
            if (m760loadAsync$lambda0(lazy) == null) {
                promise.reject("E_NO_FONT_MANAGER", "There is no FontManager in module registry. Are you sure all the dependencies of expo-font are installed and linked?");
                return;
            }
            FontManagerInterface r1 = m760loadAsync$lambda0(lazy);
            Intrinsics.checkNotNull(r1);
            r1.setTypeface(str3 + str, 0, typeface);
            promise.resolve((Object) null);
        } catch (Exception e) {
            promise.reject("E_UNEXPECTED", "Font.loadAsync unexpected exception: " + e.getMessage(), e);
        }
    }

    /* renamed from: loadAsync$lambda-0  reason: not valid java name */
    private static final FontManagerInterface m760loadAsync$lambda0(Lazy<? extends FontManagerInterface> lazy) {
        return (FontManagerInterface) lazy.getValue();
    }

    /* renamed from: _get_isScoped_$lambda-1  reason: not valid java name */
    private static final ConstantsInterface m759_get_isScoped_$lambda1(Lazy<? extends ConstantsInterface> lazy) {
        return (ConstantsInterface) lazy.getValue();
    }

    private final boolean isScoped() {
        Lazy lazy = LazyKt.lazy(new FontLoaderModule$special$$inlined$moduleRegistry$1(this.moduleRegistryDelegate));
        if (m759_get_isScoped_$lambda1(lazy) != null) {
            ConstantsInterface r0 = m759_get_isScoped_$lambda1(lazy);
            Intrinsics.checkNotNull(r0);
            if (Intrinsics.areEqual((Object) "expo", (Object) r0.getAppOwnership())) {
                return true;
            }
        }
        return false;
    }
}
