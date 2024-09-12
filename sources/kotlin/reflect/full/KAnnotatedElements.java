package kotlin.reflect.full;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KAnnotatedElement;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\"\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\b¢\u0006\u0002\u0010\u0004\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\b\u001a*\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\bH\u0007\u001a\u0019\u0010\t\u001a\u00020\n\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\b¨\u0006\u000b"}, d2 = {"findAnnotation", "T", "", "Lkotlin/reflect/KAnnotatedElement;", "(Lkotlin/reflect/KAnnotatedElement;)Ljava/lang/annotation/Annotation;", "findAnnotations", "", "klass", "Lkotlin/reflect/KClass;", "hasAnnotation", "", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: KAnnotatedElements.kt */
public final class KAnnotatedElements {
    public static final /* synthetic */ <T extends Annotation> T findAnnotation(KAnnotatedElement kAnnotatedElement) {
        T t;
        Intrinsics.checkNotNullParameter(kAnnotatedElement, "<this>");
        Iterator it = kAnnotatedElement.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (((Annotation) t) instanceof Annotation) {
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(1, "T?");
        return (Annotation) t;
    }

    public static final /* synthetic */ <T extends Annotation> List<T> findAnnotations(KAnnotatedElement kAnnotatedElement) {
        Intrinsics.checkNotNullParameter(kAnnotatedElement, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return findAnnotations(kAnnotatedElement, Reflection.getOrCreateKotlinClass(Annotation.class));
    }

    public static final <T extends Annotation> List<T> findAnnotations(KAnnotatedElement kAnnotatedElement, KClass<T> kClass) {
        Object obj;
        Intrinsics.checkNotNullParameter(kAnnotatedElement, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "klass");
        List<T> filterIsInstance = CollectionsKt.filterIsInstance(kAnnotatedElement.getAnnotations(), JvmClassMappingKt.getJavaClass(kClass));
        if (!filterIsInstance.isEmpty()) {
            return filterIsInstance;
        }
        Class<? extends Annotation> loadRepeatableContainer = Java8RepeatableContainerLoader.INSTANCE.loadRepeatableContainer(JvmClassMappingKt.getJavaClass(kClass));
        if (loadRepeatableContainer != null) {
            Iterator it = kAnnotatedElement.getAnnotations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass((Annotation) obj)), (Object) loadRepeatableContainer)) {
                    break;
                }
            }
            Annotation annotation = (Annotation) obj;
            if (annotation != null) {
                Object invoke = annotation.getClass().getMethod("value", new Class[0]).invoke(annotation, new Object[0]);
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.full.KAnnotatedElements.findAnnotations>");
                return ArraysKt.asList((T[]) (Annotation[]) invoke);
            }
        }
        return CollectionsKt.emptyList();
    }

    public static final /* synthetic */ <T extends Annotation> boolean hasAnnotation(KAnnotatedElement kAnnotatedElement) {
        Object obj;
        Intrinsics.checkNotNullParameter(kAnnotatedElement, "<this>");
        Iterator it = kAnnotatedElement.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (((Annotation) obj) instanceof Annotation) {
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(1, "T?");
        if (((Annotation) obj) != null) {
            return true;
        }
        return false;
    }
}
