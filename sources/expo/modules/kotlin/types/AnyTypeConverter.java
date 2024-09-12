package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/AnyTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "", "isOptional", "", "(Z)V", "convertFromAny", "value", "convertFromDynamic", "Lcom/facebook/react/bridge/Dynamic;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AnyTypeConverter.kt */
public final class AnyTypeConverter extends DynamicAwareTypeConverters<Object> {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AnyTypeConverter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            iArr[ReadableType.Boolean.ordinal()] = 1;
            iArr[ReadableType.Number.ordinal()] = 2;
            iArr[ReadableType.String.ordinal()] = 3;
            iArr[ReadableType.Map.ordinal()] = 4;
            iArr[ReadableType.Array.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Object convertFromAny(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        return obj;
    }

    public AnyTypeConverter(boolean z) {
        super(z);
    }

    public Object convertFromDynamic(Dynamic dynamic) {
        Object obj;
        Intrinsics.checkNotNullParameter(dynamic, "value");
        ReadableType type = dynamic.getType();
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            obj = Boolean.valueOf(dynamic.asBoolean());
        } else if (i == 2) {
            obj = Double.valueOf(dynamic.asDouble());
        } else if (i == 3) {
            obj = dynamic.asString();
        } else if (i == 4) {
            obj = dynamic.asMap();
        } else if (i == 5) {
            obj = dynamic.asArray();
        } else {
            throw new IllegalStateException(("Unknown dynamic type: " + dynamic.getType()).toString());
        }
        Intrinsics.checkNotNullExpressionValue(obj, "when (value.type) {\n    …pe: ${value.type}\")\n    }");
        return obj;
    }

    public ExpectedType getCppRequiredTypes() {
        return ExpectedType.Companion.forAny();
    }
}
