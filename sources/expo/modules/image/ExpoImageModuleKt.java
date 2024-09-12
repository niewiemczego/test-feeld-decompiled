package expo.modules.image;

import android.view.View;
import expo.modules.kotlin.types.AnyTypeKt;
import expo.modules.kotlin.views.AnyViewProp;
import expo.modules.kotlin.views.ConcreteViewProp;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a¯\u0001\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\u0004\u0018\u0001\"\u0006\b\u0002\u0010\u0005\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00062*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00050\t0\b\"\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00050\t2M\b\b\u0010\u000b\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\fH\b¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"PropGroup", "", "T", "Landroid/view/View;", "PropType", "CustomValueType", "Lexpo/modules/kotlin/views/ViewDefinitionBuilder;", "props", "", "Lkotlin/Pair;", "", "body", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "view", "value", "prop", "(Lexpo/modules/kotlin/views/ViewDefinitionBuilder;[Lkotlin/Pair;Lkotlin/jvm/functions/Function3;)V", "expo-image_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoImageModule.kt */
public final class ExpoImageModuleKt {
    private static final /* synthetic */ <T extends View, PropType, CustomValueType> void PropGroup(ViewDefinitionBuilder<T> viewDefinitionBuilder, Pair<String, ? extends CustomValueType>[] pairArr, Function3<? super T, ? super CustomValueType, ? super PropType, Unit> function3) {
        for (Pair<String, ? extends CustomValueType> pair : pairArr) {
            String component1 = pair.component1();
            Object component2 = pair.component2();
            Intrinsics.needClassReification();
            Map<String, AnyViewProp> props = viewDefinitionBuilder.getProps();
            Intrinsics.reifiedOperationMarker(6, "PropType");
            props.put(component1, new ConcreteViewProp(component1, AnyTypeKt.toAnyType((KType) null), new ExpoImageModuleKt$PropGroup$1(function3, component2)));
        }
    }
}
