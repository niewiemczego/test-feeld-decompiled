package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.integration.avif.AvifGlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule;
import com.bumptech.glide.integration.webp.WebpGlideLibraryModule;
import com.github.penfeizhou.animation.glide.GlideAnimationModule;
import expo.modules.image.ExpoImageAppGlideModule;
import expo.modules.image.blurhash.BlurhashModule;
import expo.modules.image.dataurls.Base64Module;
import expo.modules.image.okhttp.ExpoImageOkHttpClientGlideModule;
import expo.modules.image.svg.SVGModule;
import expo.modules.image.thumbhash.ThumbhashModule;
import java.util.Collections;
import java.util.Set;

final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    private final ExpoImageAppGlideModule appGlideModule = new ExpoImageAppGlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: expo.modules.image.ExpoImageAppGlideModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.avif.AvifGlideModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.webp.WebpGlideLibraryModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.github.penfeizhou.animation.glide.GlideAnimationModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: expo.modules.image.blurhash.BlurhashModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: expo.modules.image.dataurls.Base64Module");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: expo.modules.image.okhttp.ExpoImageOkHttpClientGlideModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: expo.modules.image.svg.SVGModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: expo.modules.image.thumbhash.ThumbhashModule");
        }
    }

    public void applyOptions(Context context, GlideBuilder glideBuilder) {
        this.appGlideModule.applyOptions(context, glideBuilder);
    }

    public void registerComponents(Context context, Glide glide, Registry registry) {
        new AvifGlideModule().registerComponents(context, glide, registry);
        new OkHttpLibraryGlideModule().registerComponents(context, glide, registry);
        new WebpGlideLibraryModule().registerComponents(context, glide, registry);
        new GlideAnimationModule().registerComponents(context, glide, registry);
        new BlurhashModule().registerComponents(context, glide, registry);
        new Base64Module().registerComponents(context, glide, registry);
        new ExpoImageOkHttpClientGlideModule().registerComponents(context, glide, registry);
        new SVGModule().registerComponents(context, glide, registry);
        new ThumbhashModule().registerComponents(context, glide, registry);
        this.appGlideModule.registerComponents(context, glide, registry);
    }

    public boolean isManifestParsingEnabled() {
        return this.appGlideModule.isManifestParsingEnabled();
    }

    public Set<Class<?>> getExcludedModuleClasses() {
        return Collections.emptySet();
    }

    /* access modifiers changed from: package-private */
    public GeneratedRequestManagerFactory getRequestManagerFactory() {
        return new GeneratedRequestManagerFactory();
    }
}
