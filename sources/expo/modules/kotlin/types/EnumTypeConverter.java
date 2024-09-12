package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.ReadableTypeExtensionsKt;
import expo.modules.kotlin.exception.EnumNoSuchValueException;
import expo.modules.kotlin.exception.IncompatibleArgTypeException;
import expo.modules.kotlin.jni.ExpectedType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.full.KClassifiers;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u001f\u0012\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J5\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013J-\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0015\u001a\u00020\u00122\u0012\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\tH\u0002¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0014\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0018\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016R\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0004X\u0004¢\u0006\u0002\n\u0000RD\u0010\b\u001a6\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \n*\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0002 \n*\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0002\b\u0003 \n*\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u00020\t0\tX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0018\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lexpo/modules/kotlin/types/EnumTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "", "enumClass", "Lkotlin/reflect/KClass;", "isOptional", "", "(Lkotlin/reflect/KClass;Z)V", "enumConstants", "", "kotlin.jvm.PlatformType", "[Ljava/lang/Enum;", "primaryConstructor", "Lkotlin/reflect/KFunction;", "convertEnumWithParameter", "jsValue", "", "parameterName", "", "(Ljava/lang/Object;[Ljava/lang/Enum;Ljava/lang/String;)Ljava/lang/Enum;", "convertEnumWithoutParameter", "stringRepresentation", "(Ljava/lang/String;[Ljava/lang/Enum;)Ljava/lang/Enum;", "convertFromAny", "value", "convertFromDynamic", "Lcom/facebook/react/bridge/Dynamic;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: EnumTypeConverter.kt */
public final class EnumTypeConverter extends DynamicAwareTypeConverters<Enum<?>> {
    private final KClass<Enum<?>> enumClass;
    private final Enum<?>[] enumConstants;
    private final KFunction<Enum<?>> primaryConstructor;

    public boolean isTrivial() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnumTypeConverter(KClass<Enum<?>> kClass, boolean z) {
        super(z);
        Intrinsics.checkNotNullParameter(kClass, "enumClass");
        this.enumClass = kClass;
        Object[] enumConstants2 = JvmClassMappingKt.getJavaClass(kClass).getEnumConstants();
        if (enumConstants2 != null) {
            Enum<?>[] enumArr = (Enum[]) enumConstants2;
            if (!(enumArr.length == 0)) {
                this.enumConstants = enumArr;
                KFunction<Enum<?>> primaryConstructor2 = KClasses.getPrimaryConstructor(kClass);
                if (primaryConstructor2 != null) {
                    this.primaryConstructor = primaryConstructor2;
                    if (!KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(Enumerable.class))) {
                        Logger.warn$default(CoreLoggerKt.getLogger(), "Enum '" + kClass + "' should inherit from " + Reflection.getOrCreateKotlinClass(Enumerable.class) + ".", (Throwable) null, 2, (Object) null);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot convert js value to enum without the primary constructor".toString());
            }
            throw new IllegalArgumentException("Passed enum type is empty".toString());
        }
        throw new IllegalArgumentException("Passed type is not an enum type".toString());
    }

    public ExpectedType getCppRequiredTypes() {
        return ExpectedType.Companion.forEnum();
    }

    public Enum<?> convertFromDynamic(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, "value");
        if (this.primaryConstructor.getParameters().isEmpty()) {
            String asString = dynamic.asString();
            Intrinsics.checkNotNullExpressionValue(asString, "value.asString()");
            return convertEnumWithoutParameter(asString, this.enumConstants);
        } else if (this.primaryConstructor.getParameters().size() == 1) {
            Enum<?>[] enumArr = this.enumConstants;
            String name = ((KParameter) CollectionsKt.first(this.primaryConstructor.getParameters())).getName();
            Intrinsics.checkNotNull(name);
            return convertEnumWithParameter(dynamic, enumArr, name);
        } else {
            ReadableType type = dynamic.getType();
            Intrinsics.checkNotNullExpressionValue(type, "value.type");
            throw new IncompatibleArgTypeException(ReadableTypeExtensionsKt.toKType(type), KClassifiers.createType$default(this.enumClass, (List) null, false, (List) null, 7, (Object) null), (Throwable) null, 4, (DefaultConstructorMarker) null);
        }
    }

    public Enum<?> convertFromAny(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        if (this.primaryConstructor.getParameters().isEmpty()) {
            return convertEnumWithoutParameter((String) obj, this.enumConstants);
        }
        if (this.primaryConstructor.getParameters().size() == 1) {
            Enum<?>[] enumArr = this.enumConstants;
            String name = ((KParameter) CollectionsKt.first(this.primaryConstructor.getParameters())).getName();
            Intrinsics.checkNotNull(name);
            return convertEnumWithParameter(obj, enumArr, name);
        }
        throw new IncompatibleArgTypeException(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(obj.getClass()), (List) null, false, (List) null, 7, (Object) null), KClassifiers.createType$default(this.enumClass, (List) null, false, (List) null, 7, (Object) null), (Throwable) null, 4, (DefaultConstructorMarker) null);
    }

    private final Enum<?> convertEnumWithoutParameter(String str, Enum<?>[] enumArr) {
        Enum<?> enumR;
        int length = enumArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                enumR = null;
                break;
            }
            enumR = enumArr[i];
            if (Intrinsics.areEqual((Object) enumR.name(), (Object) str)) {
                break;
            }
            i++;
        }
        if (enumR != null) {
            return enumR;
        }
        throw new EnumNoSuchValueException(this.enumClass, enumArr, str);
    }

    private final Enum<?> convertEnumWithParameter(Object obj, Enum<?>[] enumArr, String str) {
        Enum<?> enumR;
        Object obj2;
        Object obj3;
        int i;
        Iterator it = KClasses.getDeclaredMemberProperties(this.enumClass).iterator();
        while (true) {
            enumR = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (Intrinsics.areEqual((Object) ((KProperty1) obj2).getName(), (Object) str)) {
                break;
            }
        }
        KProperty1 kProperty1 = (KProperty1) obj2;
        if (kProperty1 != null) {
            KClassifier classifier = kProperty1.getReturnType().getClassifier();
            if (obj instanceof Dynamic) {
                if (Intrinsics.areEqual((Object) classifier, (Object) Reflection.getOrCreateKotlinClass(String.class))) {
                    obj3 = ((Dynamic) obj).asString();
                } else {
                    obj3 = Integer.valueOf(((Dynamic) obj).asInt());
                }
            } else if (Intrinsics.areEqual((Object) classifier, (Object) Reflection.getOrCreateKotlinClass(String.class))) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                obj3 = (String) obj;
            } else {
                if (obj instanceof Double) {
                    i = (int) ((Number) obj).doubleValue();
                } else {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    i = ((Integer) obj).intValue();
                }
                obj3 = Integer.valueOf(i);
            }
            int i2 = 0;
            int length = enumArr.length;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Enum<?> enumR2 = enumArr[i2];
                if (Intrinsics.areEqual(kProperty1.get(enumR2), obj3)) {
                    enumR = enumR2;
                    break;
                }
                i2++;
            }
            if (enumR != null) {
                return enumR;
            }
            throw new IllegalArgumentException(("Couldn't convert '" + obj + "' to " + this.enumClass.getSimpleName() + " where " + str + " is the enum parameter").toString());
        }
        throw new IllegalArgumentException(("Cannot find a property for " + str + " parameter").toString());
    }
}
