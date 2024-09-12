package expo.modules.av.video;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.av.video.scalablevideoview.ScalableType;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeKt;
import expo.modules.kotlin.views.ConcreteViewProp;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lexpo/modules/av/video/VideoViewModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-av_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VideoViewModule.kt */
public final class VideoViewModule extends Module {
    public ModuleDefinitionData definition() {
        AsyncFunction asyncFunction;
        ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(this);
        moduleDefinitionBuilder.Name("ExpoVideoView");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(VideoViewWrapper.class);
        if (moduleDefinitionBuilder.getViewManagerDefinition() == null) {
            ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(orCreateKotlinClass);
            viewDefinitionBuilder.setOnViewDestroys(new VideoViewModule$definition$lambda2$lambda0$$inlined$OnViewDestroysGeneric$1(VideoViewModule$definition$1$1$1.INSTANCE));
            viewDefinitionBuilder.Events("onStatusUpdate", "onLoadStart", "onLoad", "onError", "onReadyForDisplay", "onFullscreenUpdate");
            viewDefinitionBuilder.getProps().put("status", new ConcreteViewProp("status", AnyTypeKt.toAnyType(Reflection.typeOf(ReadableMap.class)), VideoViewModule$definition$1$1$2.INSTANCE));
            viewDefinitionBuilder.getProps().put("useNativeControls", new ConcreteViewProp("useNativeControls", AnyTypeKt.toAnyType(Reflection.typeOf(Boolean.TYPE)), VideoViewModule$definition$1$1$3.INSTANCE));
            viewDefinitionBuilder.getProps().put("source", new ConcreteViewProp("source", AnyTypeKt.toAnyType(Reflection.typeOf(ReadableMap.class)), VideoViewModule$definition$1$1$4.INSTANCE));
            viewDefinitionBuilder.getProps().put(ViewProps.RESIZE_MODE, new ConcreteViewProp(ViewProps.RESIZE_MODE, AnyTypeKt.toAnyType(Reflection.typeOf(String.class)), VideoViewModule$definition$1$1$5.INSTANCE));
            moduleDefinitionBuilder.setViewManagerDefinition(viewDefinitionBuilder.build());
            moduleDefinitionBuilder.Constants((Pair<String, ? extends Object>[]) new Pair[]{TuplesKt.to("ScaleNone", String.valueOf(ScalableType.LEFT_TOP.ordinal())), TuplesKt.to("ScaleToFill", String.valueOf(ScalableType.FIT_XY.ordinal())), TuplesKt.to("ScaleAspectFit", String.valueOf(ScalableType.FIT_CENTER.ordinal())), TuplesKt.to("ScaleAspectFill", String.valueOf(ScalableType.CENTER_CROP.ordinal()))});
            ObjectDefinitionBuilder objectDefinitionBuilder = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Promise.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
                asyncFunction = new AsyncFunctionWithPromiseComponent("setFullscreen", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(Integer.TYPE)), AnyTypeKt.toAnyType(Reflection.typeOf(Boolean.TYPE))}, new VideoViewModule$definition$lambda2$$inlined$AsyncFunction$1(this));
            } else {
                asyncFunction = new AsyncFunctionComponent("setFullscreen", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(Integer.TYPE)), AnyTypeKt.toAnyType(Reflection.typeOf(Boolean.TYPE)), AnyTypeKt.toAnyType(Reflection.typeOf(Promise.class))}, new VideoViewModule$definition$lambda2$$inlined$AsyncFunction$2(this));
            }
            objectDefinitionBuilder.getAsyncFunctions().put("setFullscreen", asyncFunction);
            return moduleDefinitionBuilder.buildModule();
        }
        throw new IllegalArgumentException("The module definition may have exported only one view manager.".toString());
    }
}
