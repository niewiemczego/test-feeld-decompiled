package expo.modules.image;

import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.oblador.keychain.KeychainModule;
import expo.modules.image.enums.ContentFit;
import expo.modules.image.enums.Priority;
import expo.modules.image.records.CachePolicy;
import expo.modules.image.records.ContentPosition;
import expo.modules.image.records.ImageTransition;
import expo.modules.image.records.SourceMap;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.Queues;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeKt;
import expo.modules.kotlin.views.ConcreteViewProp;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import io.sentry.protocol.SentryThread;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KTypeProjection;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lexpo/modules/image/ExpoImageModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoImageModule.kt */
public final class ExpoImageModule extends Module {
    public ModuleDefinitionData definition() {
        ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(this);
        moduleDefinitionBuilder.Name("ExpoImage");
        ObjectDefinitionBuilder objectDefinitionBuilder = moduleDefinitionBuilder;
        objectDefinitionBuilder.getSyncFunctions().put("prefetch", new SyncFunctionComponent("prefetch", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class))))}, new ExpoImageModule$definition$lambda9$$inlined$Function$1(this)));
        AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent("clearMemoryCache", new AnyType[0], new ExpoImageModule$definition$lambda9$$inlined$AsyncFunctionWithoutArgs$1(this));
        objectDefinitionBuilder.getAsyncFunctions().put("clearMemoryCache", asyncFunctionComponent);
        asyncFunctionComponent.runOnQueue(Queues.MAIN);
        AsyncFunctionComponent asyncFunctionComponent2 = new AsyncFunctionComponent("clearDiskCache", new AnyType[0], new ExpoImageModule$definition$lambda9$$inlined$AsyncFunctionWithoutArgs$2(this));
        objectDefinitionBuilder.getAsyncFunctions().put("clearDiskCache", asyncFunctionComponent2);
        AsyncFunction asyncFunction = asyncFunctionComponent2;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ExpoImageViewWrapper.class);
        if (moduleDefinitionBuilder.getViewManagerDefinition() == null) {
            ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(orCreateKotlinClass);
            viewDefinitionBuilder.Events("onLoadStart", "onProgress", "onError", "onLoad");
            viewDefinitionBuilder.getProps().put("source", new ConcreteViewProp("source", AnyTypeKt.toAnyType(Reflection.nullableTypeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SourceMap.class)))), ExpoImageModule$definition$1$4$1.INSTANCE));
            viewDefinitionBuilder.getProps().put("contentFit", new ConcreteViewProp("contentFit", AnyTypeKt.toAnyType(Reflection.nullableTypeOf(ContentFit.class)), ExpoImageModule$definition$1$4$2.INSTANCE));
            viewDefinitionBuilder.getProps().put("placeholderContentFit", new ConcreteViewProp("placeholderContentFit", AnyTypeKt.toAnyType(Reflection.nullableTypeOf(ContentFit.class)), ExpoImageModule$definition$1$4$3.INSTANCE));
            viewDefinitionBuilder.getProps().put("contentPosition", new ConcreteViewProp("contentPosition", AnyTypeKt.toAnyType(Reflection.nullableTypeOf(ContentPosition.class)), ExpoImageModule$definition$1$4$4.INSTANCE));
            viewDefinitionBuilder.getProps().put("blurRadius", new ConcreteViewProp("blurRadius", AnyTypeKt.toAnyType(Reflection.nullableTypeOf(Integer.class)), ExpoImageModule$definition$1$4$5.INSTANCE));
            viewDefinitionBuilder.getProps().put("transition", new ConcreteViewProp("transition", AnyTypeKt.toAnyType(Reflection.nullableTypeOf(ImageTransition.class)), ExpoImageModule$definition$1$4$6.INSTANCE));
            Pair[] pairArr = {TuplesKt.to("borderRadius", 0), TuplesKt.to(ViewProps.BORDER_TOP_LEFT_RADIUS, 1), TuplesKt.to(ViewProps.BORDER_TOP_RIGHT_RADIUS, 2), TuplesKt.to(ViewProps.BORDER_BOTTOM_RIGHT_RADIUS, 3), TuplesKt.to(ViewProps.BORDER_BOTTOM_LEFT_RADIUS, 4), TuplesKt.to(ViewProps.BORDER_TOP_START_RADIUS, 5), TuplesKt.to(ViewProps.BORDER_TOP_END_RADIUS, 6), TuplesKt.to(ViewProps.BORDER_BOTTOM_START_RADIUS, 7), TuplesKt.to(ViewProps.BORDER_BOTTOM_END_RADIUS, 8)};
            Function3 function3 = ExpoImageModule$definition$1$4$7.INSTANCE;
            int i = 0;
            for (int i2 = 9; i < i2; i2 = 9) {
                Pair pair = pairArr[i];
                String str = (String) pair.component1();
                viewDefinitionBuilder.getProps().put(str, new ConcreteViewProp(str, AnyTypeKt.toAnyType(Reflection.nullableTypeOf(Float.class)), new ExpoImageModule$definition$lambda9$lambda8$$inlined$PropGroup$1(function3, pair.component2())));
                i++;
            }
            Pair[] pairArr2 = {TuplesKt.to(ViewProps.BORDER_WIDTH, 8), TuplesKt.to(ViewProps.BORDER_LEFT_WIDTH, 0), TuplesKt.to(ViewProps.BORDER_RIGHT_WIDTH, 2), TuplesKt.to(ViewProps.BORDER_TOP_WIDTH, 1), TuplesKt.to(ViewProps.BORDER_BOTTOM_WIDTH, 3), TuplesKt.to(ViewProps.BORDER_START_WIDTH, 4), TuplesKt.to(ViewProps.BORDER_END_WIDTH, 5)};
            Function3 function32 = ExpoImageModule$definition$1$4$8.INSTANCE;
            for (int i3 = 0; i3 < 7; i3++) {
                Pair pair2 = pairArr2[i3];
                String str2 = (String) pair2.component1();
                viewDefinitionBuilder.getProps().put(str2, new ConcreteViewProp(str2, AnyTypeKt.toAnyType(Reflection.nullableTypeOf(Float.class)), new ExpoImageModule$definition$lambda9$lambda8$$inlined$PropGroup$2(function32, pair2.component2())));
            }
            Pair[] pairArr3 = {TuplesKt.to(ViewProps.BORDER_COLOR, 8), TuplesKt.to(ViewProps.BORDER_LEFT_COLOR, 0), TuplesKt.to(ViewProps.BORDER_RIGHT_COLOR, 2), TuplesKt.to(ViewProps.BORDER_TOP_COLOR, 1), TuplesKt.to(ViewProps.BORDER_BOTTOM_COLOR, 3), TuplesKt.to(ViewProps.BORDER_START_COLOR, 4), TuplesKt.to(ViewProps.BORDER_END_COLOR, 5)};
            Function3 function33 = ExpoImageModule$definition$1$4$9.INSTANCE;
            for (int i4 = 0; i4 < 7; i4++) {
                Pair pair3 = pairArr3[i4];
                String str3 = (String) pair3.component1();
                viewDefinitionBuilder.getProps().put(str3, new ConcreteViewProp(str3, AnyTypeKt.toAnyType(Reflection.nullableTypeOf(Integer.class)), new ExpoImageModule$definition$lambda9$lambda8$$inlined$PropGroup$3(function33, pair3.component2())));
            }
            viewDefinitionBuilder.getProps().put("borderStyle", new ConcreteViewProp("borderStyle", AnyTypeKt.toAnyType(Reflection.nullableTypeOf(String.class)), ExpoImageModule$definition$1$4$10.INSTANCE));
            viewDefinitionBuilder.getProps().put("backgroundColor", new ConcreteViewProp("backgroundColor", AnyTypeKt.toAnyType(Reflection.nullableTypeOf(Integer.class)), ExpoImageModule$definition$1$4$11.INSTANCE));
            viewDefinitionBuilder.getProps().put("tintColor", new ConcreteViewProp("tintColor", AnyTypeKt.toAnyType(Reflection.nullableTypeOf(Integer.class)), ExpoImageModule$definition$1$4$12.INSTANCE));
            viewDefinitionBuilder.getProps().put(ReactTextInputShadowNode.PROP_PLACEHOLDER, new ConcreteViewProp(ReactTextInputShadowNode.PROP_PLACEHOLDER, AnyTypeKt.toAnyType(Reflection.nullableTypeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SourceMap.class)))), ExpoImageModule$definition$1$4$13.INSTANCE));
            viewDefinitionBuilder.getProps().put(KeychainModule.Maps.ACCESSIBLE, new ConcreteViewProp(KeychainModule.Maps.ACCESSIBLE, AnyTypeKt.toAnyType(Reflection.nullableTypeOf(Boolean.class)), ExpoImageModule$definition$1$4$14.INSTANCE));
            viewDefinitionBuilder.getProps().put(ViewProps.ACCESSIBILITY_LABEL, new ConcreteViewProp(ViewProps.ACCESSIBILITY_LABEL, AnyTypeKt.toAnyType(Reflection.nullableTypeOf(String.class)), ExpoImageModule$definition$1$4$15.INSTANCE));
            viewDefinitionBuilder.getProps().put("focusable", new ConcreteViewProp("focusable", AnyTypeKt.toAnyType(Reflection.nullableTypeOf(Boolean.class)), ExpoImageModule$definition$1$4$16.INSTANCE));
            viewDefinitionBuilder.getProps().put(SentryThread.JsonKeys.PRIORITY, new ConcreteViewProp(SentryThread.JsonKeys.PRIORITY, AnyTypeKt.toAnyType(Reflection.nullableTypeOf(Priority.class)), ExpoImageModule$definition$1$4$17.INSTANCE));
            viewDefinitionBuilder.getProps().put("cachePolicy", new ConcreteViewProp("cachePolicy", AnyTypeKt.toAnyType(Reflection.nullableTypeOf(CachePolicy.class)), ExpoImageModule$definition$1$4$18.INSTANCE));
            viewDefinitionBuilder.getProps().put("recyclingKey", new ConcreteViewProp("recyclingKey", AnyTypeKt.toAnyType(Reflection.nullableTypeOf(String.class)), ExpoImageModule$definition$1$4$19.INSTANCE));
            viewDefinitionBuilder.getProps().put("allowDownscaling", new ConcreteViewProp("allowDownscaling", AnyTypeKt.toAnyType(Reflection.nullableTypeOf(Boolean.class)), ExpoImageModule$definition$1$4$20.INSTANCE));
            viewDefinitionBuilder.setOnViewDidUpdateProps(new ExpoImageModule$definition$lambda9$lambda8$$inlined$OnViewDidUpdateProps$1());
            viewDefinitionBuilder.setOnViewDestroys(new ExpoImageModule$definition$lambda9$lambda8$$inlined$OnViewDestroys$1());
            moduleDefinitionBuilder.setViewManagerDefinition(viewDefinitionBuilder.build());
            return moduleDefinitionBuilder.buildModule();
        }
        throw new IllegalArgumentException("The module definition may have exported only one view manager.".toString());
    }
}
