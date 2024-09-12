package expo.modules.kotlin.records;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import expo.modules.kotlin.allocators.ObjectConstructor;
import expo.modules.kotlin.allocators.ObjectConstructorFactory;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.FieldCastException;
import expo.modules.kotlin.exception.FieldRequiredException;
import expo.modules.kotlin.exception.RecordCastException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.DynamicAwareTypeConverters;
import expo.modules.kotlin.types.TypeConverter;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001(B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u0015\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001f\"\u0004\b\u0001\u0010\u00012\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00010!H\u0002J&\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030$0#2\u0012\u0010%\u001a\u000e\u0012\u0006\b\u0001\u0012\u00020\u000e\u0012\u0002\b\u00030\rH\u0002J\b\u0010&\u001a\u00020'H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u000e\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000f0\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006)"}, d2 = {"Lexpo/modules/kotlin/records/RecordTypeConverter;", "T", "Lexpo/modules/kotlin/records/Record;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "type", "Lkotlin/reflect/KType;", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lkotlin/reflect/KType;)V", "objectConstructorFactory", "Lexpo/modules/kotlin/allocators/ObjectConstructorFactory;", "propertyDescriptors", "", "Lkotlin/reflect/KProperty1;", "", "Lexpo/modules/kotlin/records/RecordTypeConverter$PropertyDescriptor;", "getType", "()Lkotlin/reflect/KType;", "convertFromAny", "value", "(Ljava/lang/Object;)Lexpo/modules/kotlin/records/Record;", "convertFromDynamic", "Lcom/facebook/react/bridge/Dynamic;", "(Lcom/facebook/react/bridge/Dynamic;)Lexpo/modules/kotlin/records/Record;", "convertFromReadableMap", "jsMap", "Lcom/facebook/react/bridge/ReadableMap;", "(Lcom/facebook/react/bridge/ReadableMap;)Lexpo/modules/kotlin/records/Record;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "getObjectConstructor", "Lexpo/modules/kotlin/allocators/ObjectConstructor;", "clazz", "Ljava/lang/Class;", "getValidators", "", "Lexpo/modules/kotlin/records/FieldValidator;", "property", "isTrivial", "", "PropertyDescriptor", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RecordTypeConverter.kt */
public final class RecordTypeConverter<T extends Record> extends DynamicAwareTypeConverters<T> {
    private final TypeConverterProvider converterProvider;
    private final ObjectConstructorFactory objectConstructorFactory = new ObjectConstructorFactory();
    private final Map<KProperty1<? extends Object, ?>, PropertyDescriptor> propertyDescriptors;
    private final KType type;

    public boolean isTrivial() {
        return false;
    }

    public final KType getType() {
        return this.type;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: kotlin.Pair} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: kotlin.Pair} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: kotlin.Pair} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: kotlin.Pair} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.lang.annotation.Annotation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: kotlin.Pair} */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RecordTypeConverter(expo.modules.kotlin.types.TypeConverterProvider r8, kotlin.reflect.KType r9) {
        /*
            r7 = this;
            java.lang.String r0 = "converterProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            boolean r0 = r9.isMarkedNullable()
            r7.<init>(r0)
            r7.converterProvider = r8
            r7.type = r9
            expo.modules.kotlin.allocators.ObjectConstructorFactory r8 = new expo.modules.kotlin.allocators.ObjectConstructorFactory
            r8.<init>()
            r7.objectConstructorFactory = r8
            kotlin.reflect.KClassifier r8 = r9.getClassifier()
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.reflect.KClass<*>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r9)
            kotlin.reflect.KClass r8 = (kotlin.reflect.KClass) r8
            java.util.Collection r8 = kotlin.reflect.full.KClasses.getMemberProperties(r8)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r9 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r0)
            r9.<init>(r0)
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r8 = r8.iterator()
        L_0x003f:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x00b5
            java.lang.Object r0 = r8.next()
            kotlin.reflect.KProperty1 r0 = (kotlin.reflect.KProperty1) r0
            r1 = r0
            kotlin.reflect.KAnnotatedElement r1 = (kotlin.reflect.KAnnotatedElement) r1
            java.util.List r2 = r1.getAnnotations()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0058:
            boolean r3 = r2.hasNext()
            r4 = 0
            if (r3 == 0) goto L_0x006b
            java.lang.Object r3 = r2.next()
            r5 = r3
            java.lang.annotation.Annotation r5 = (java.lang.annotation.Annotation) r5
            boolean r5 = r5 instanceof expo.modules.kotlin.records.Field
            if (r5 == 0) goto L_0x0058
            goto L_0x006c
        L_0x006b:
            r3 = r4
        L_0x006c:
            expo.modules.kotlin.records.Field r3 = (expo.modules.kotlin.records.Field) r3
            java.lang.annotation.Annotation r3 = (java.lang.annotation.Annotation) r3
            expo.modules.kotlin.records.Field r3 = (expo.modules.kotlin.records.Field) r3
            if (r3 != 0) goto L_0x0075
            goto L_0x00b1
        L_0x0075:
            expo.modules.kotlin.types.TypeConverterProvider r2 = r7.converterProvider
            kotlin.reflect.KType r5 = r0.getReturnType()
            expo.modules.kotlin.types.TypeConverter r2 = r2.obtainTypeConverter(r5)
            java.util.List r1 = r1.getAnnotations()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0089:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x009b
            java.lang.Object r5 = r1.next()
            r6 = r5
            java.lang.annotation.Annotation r6 = (java.lang.annotation.Annotation) r6
            boolean r6 = r6 instanceof expo.modules.kotlin.records.Required
            if (r6 == 0) goto L_0x0089
            r4 = r5
        L_0x009b:
            expo.modules.kotlin.records.Required r4 = (expo.modules.kotlin.records.Required) r4
            java.lang.annotation.Annotation r4 = (java.lang.annotation.Annotation) r4
            if (r4 == 0) goto L_0x00a3
            r1 = 1
            goto L_0x00a4
        L_0x00a3:
            r1 = 0
        L_0x00a4:
            java.util.List r4 = r7.getValidators(r0)
            expo.modules.kotlin.records.RecordTypeConverter$PropertyDescriptor r5 = new expo.modules.kotlin.records.RecordTypeConverter$PropertyDescriptor
            r5.<init>(r2, r3, r1, r4)
            kotlin.Pair r4 = kotlin.TuplesKt.to(r0, r5)
        L_0x00b1:
            r9.add(r4)
            goto L_0x003f
        L_0x00b5:
            java.util.List r9 = (java.util.List) r9
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.List r8 = kotlin.collections.CollectionsKt.filterNotNull(r9)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Map r8 = kotlin.collections.MapsKt.toMap(r8)
            r7.propertyDescriptors = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.records.RecordTypeConverter.<init>(expo.modules.kotlin.types.TypeConverterProvider, kotlin.reflect.KType):void");
    }

    public T convertFromDynamic(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, "value");
        try {
            ReadableMap asMap = dynamic.asMap();
            Intrinsics.checkNotNullExpressionValue(asMap, "jsMap");
            return convertFromReadableMap(asMap);
        } catch (CodedException e) {
            throw new RecordCastException(this.type, e);
        } catch (expo.modules.core.errors.CodedException e2) {
            String code = e2.getCode();
            Intrinsics.checkNotNullExpressionValue(code, "e.code");
            throw new RecordCastException(this.type, new CodedException(code, e2.getMessage(), e2.getCause()));
        } catch (Throwable th) {
            throw new RecordCastException(this.type, new UnexpectedException(th));
        }
    }

    public T convertFromAny(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        if (obj instanceof ReadableMap) {
            return convertFromReadableMap((ReadableMap) obj);
        }
        return (Record) obj;
    }

    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.READABLE_MAP);
    }

    private final T convertFromReadableMap(ReadableMap readableMap) {
        KClassifier classifier = this.type.getClassifier();
        Intrinsics.checkNotNull(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        T construct = getObjectConstructor(JvmClassMappingKt.getJavaClass((KClass) classifier)).construct();
        for (Map.Entry next : this.propertyDescriptors.entrySet()) {
            KProperty1 kProperty1 = (KProperty1) next.getKey();
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) next.getValue();
            String key = propertyDescriptor.getFieldAnnotation().key();
            if (StringsKt.isBlank(key)) {
                key = null;
            }
            if (key == null) {
                key = kProperty1.getName();
            }
            if (readableMap.hasKey(key)) {
                Dynamic dynamic = readableMap.getDynamic(key);
                Intrinsics.checkNotNullExpressionValue(dynamic, "jsMap.getDynamic(jsKey)");
                try {
                    Field javaField = ReflectJvmMapping.getJavaField(kProperty1);
                    Intrinsics.checkNotNull(javaField);
                    Object convert = propertyDescriptor.getTypeConverter().convert(dynamic);
                    if (convert != null) {
                        for (FieldValidator fieldValidator : propertyDescriptor.getValidators()) {
                            Intrinsics.checkNotNull(fieldValidator, "null cannot be cast to non-null type expo.modules.kotlin.records.FieldValidator<kotlin.Any>");
                            fieldValidator.validate(convert);
                        }
                    }
                    javaField.setAccessible(true);
                    javaField.set(construct, convert);
                    Unit unit = Unit.INSTANCE;
                    dynamic.recycle();
                } catch (CodedException e) {
                    String name = kProperty1.getName();
                    KType returnType = kProperty1.getReturnType();
                    ReadableType type2 = dynamic.getType();
                    Intrinsics.checkNotNullExpressionValue(type2, "type");
                    throw new FieldCastException(name, returnType, type2, e);
                } catch (expo.modules.core.errors.CodedException e2) {
                    String code = e2.getCode();
                    Intrinsics.checkNotNullExpressionValue(code, "e.code");
                    CodedException codedException = new CodedException(code, e2.getMessage(), e2.getCause());
                    String name2 = kProperty1.getName();
                    KType returnType2 = kProperty1.getReturnType();
                    ReadableType type3 = dynamic.getType();
                    Intrinsics.checkNotNullExpressionValue(type3, "type");
                    throw new FieldCastException(name2, returnType2, type3, codedException);
                } catch (Throwable th) {
                    dynamic.recycle();
                    throw th;
                }
            } else if (propertyDescriptor.isRequired()) {
                throw new FieldRequiredException(kProperty1);
            }
        }
        Intrinsics.checkNotNull(construct, "null cannot be cast to non-null type T of expo.modules.kotlin.records.RecordTypeConverter");
        return (Record) construct;
    }

    private final <T> ObjectConstructor<T> getObjectConstructor(Class<T> cls) {
        return this.objectConstructorFactory.get(cls);
    }

    private final List<FieldValidator<?>> getValidators(KProperty1<? extends Object, ?> kProperty1) {
        Pair pair;
        Object obj;
        Iterable<Annotation> annotations = kProperty1.getAnnotations();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(annotations, 10));
        for (Annotation annotation : annotations) {
            Iterator it = JvmClassMappingKt.getAnnotationClass(annotation).getAnnotations().iterator();
            while (true) {
                pair = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((Annotation) obj) instanceof BindUsing) {
                    break;
                }
            }
            BindUsing bindUsing = (BindUsing) obj;
            if (bindUsing != null) {
                pair = TuplesKt.to(annotation, bindUsing);
            }
            arrayList.add(pair);
        }
        Iterable<Pair> filterNotNull = CollectionsKt.filterNotNull((List) arrayList);
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(filterNotNull, 10));
        for (Pair pair2 : filterNotNull) {
            Object createInstance = KClasses.createInstance(Reflection.getOrCreateKotlinClass(((BindUsing) pair2.component2()).binder()));
            Intrinsics.checkNotNull(createInstance, "null cannot be cast to non-null type expo.modules.kotlin.records.ValidationBinder");
            arrayList2.add(((ValidationBinder) createInstance).bind((Annotation) pair2.component1(), kProperty1.getReturnType()));
        }
        return (List) arrayList2;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t¢\u0006\u0002\u0010\u000bJ\r\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lexpo/modules/kotlin/records/RecordTypeConverter$PropertyDescriptor;", "", "typeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "fieldAnnotation", "Lexpo/modules/kotlin/records/Field;", "isRequired", "", "validators", "", "Lexpo/modules/kotlin/records/FieldValidator;", "(Lexpo/modules/kotlin/types/TypeConverter;Lexpo/modules/kotlin/records/Field;ZLjava/util/List;)V", "getFieldAnnotation", "()Lexpo/modules/kotlin/records/Field;", "()Z", "getTypeConverter", "()Lexpo/modules/kotlin/types/TypeConverter;", "getValidators", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RecordTypeConverter.kt */
    private static final class PropertyDescriptor {
        private final Field fieldAnnotation;
        private final boolean isRequired;
        private final TypeConverter<?> typeConverter;
        private final List<FieldValidator<?>> validators;

        public static /* synthetic */ PropertyDescriptor copy$default(PropertyDescriptor propertyDescriptor, TypeConverter<?> typeConverter2, Field field, boolean z, List<FieldValidator<?>> list, int i, Object obj) {
            if ((i & 1) != 0) {
                typeConverter2 = propertyDescriptor.typeConverter;
            }
            if ((i & 2) != 0) {
                field = propertyDescriptor.fieldAnnotation;
            }
            if ((i & 4) != 0) {
                z = propertyDescriptor.isRequired;
            }
            if ((i & 8) != 0) {
                list = propertyDescriptor.validators;
            }
            return propertyDescriptor.copy(typeConverter2, field, z, list);
        }

        public final TypeConverter<?> component1() {
            return this.typeConverter;
        }

        public final Field component2() {
            return this.fieldAnnotation;
        }

        public final boolean component3() {
            return this.isRequired;
        }

        public final List<FieldValidator<?>> component4() {
            return this.validators;
        }

        public final PropertyDescriptor copy(TypeConverter<?> typeConverter2, Field field, boolean z, List<? extends FieldValidator<?>> list) {
            Intrinsics.checkNotNullParameter(typeConverter2, "typeConverter");
            Intrinsics.checkNotNullParameter(field, "fieldAnnotation");
            Intrinsics.checkNotNullParameter(list, "validators");
            return new PropertyDescriptor(typeConverter2, field, z, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PropertyDescriptor)) {
                return false;
            }
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) obj;
            return Intrinsics.areEqual((Object) this.typeConverter, (Object) propertyDescriptor.typeConverter) && Intrinsics.areEqual((Object) this.fieldAnnotation, (Object) propertyDescriptor.fieldAnnotation) && this.isRequired == propertyDescriptor.isRequired && Intrinsics.areEqual((Object) this.validators, (Object) propertyDescriptor.validators);
        }

        public int hashCode() {
            int hashCode = ((this.typeConverter.hashCode() * 31) + this.fieldAnnotation.hashCode()) * 31;
            boolean z = this.isRequired;
            if (z) {
                z = true;
            }
            return ((hashCode + (z ? 1 : 0)) * 31) + this.validators.hashCode();
        }

        public String toString() {
            TypeConverter<?> typeConverter2 = this.typeConverter;
            Field field = this.fieldAnnotation;
            boolean z = this.isRequired;
            return "PropertyDescriptor(typeConverter=" + typeConverter2 + ", fieldAnnotation=" + field + ", isRequired=" + z + ", validators=" + this.validators + ")";
        }

        public PropertyDescriptor(TypeConverter<?> typeConverter2, Field field, boolean z, List<? extends FieldValidator<?>> list) {
            Intrinsics.checkNotNullParameter(typeConverter2, "typeConverter");
            Intrinsics.checkNotNullParameter(field, "fieldAnnotation");
            Intrinsics.checkNotNullParameter(list, "validators");
            this.typeConverter = typeConverter2;
            this.fieldAnnotation = field;
            this.isRequired = z;
            this.validators = list;
        }

        public final TypeConverter<?> getTypeConverter() {
            return this.typeConverter;
        }

        public final Field getFieldAnnotation() {
            return this.fieldAnnotation;
        }

        public final boolean isRequired() {
            return this.isRequired;
        }

        public final List<FieldValidator<?>> getValidators() {
            return this.validators;
        }
    }
}
