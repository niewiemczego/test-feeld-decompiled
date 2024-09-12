package androidx.work;

import androidx.exifinterface.media.ExifInterface;
import androidx.work.OneTimeWorkRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b\u001a\u001f\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0010\b\u0001\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\b¨\u0006\b"}, d2 = {"OneTimeWorkRequestBuilder", "Landroidx/work/OneTimeWorkRequest$Builder;", "W", "Landroidx/work/ListenableWorker;", "setInputMerger", "inputMerger", "Lkotlin/reflect/KClass;", "Landroidx/work/InputMerger;", "work-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: OneTimeWorkRequest.kt */
public final class OneTimeWorkRequestKt {
    public static final /* synthetic */ <W extends ListenableWorker> OneTimeWorkRequest.Builder OneTimeWorkRequestBuilder() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        Class<ListenableWorker> cls = ListenableWorker.class;
        Class cls2 = cls;
        return new OneTimeWorkRequest.Builder(cls);
    }

    public static final OneTimeWorkRequest.Builder setInputMerger(OneTimeWorkRequest.Builder builder, KClass<? extends InputMerger> kClass) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "inputMerger");
        return builder.setInputMerger(JvmClassMappingKt.getJavaClass(kClass));
    }
}
