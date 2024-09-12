package androidx.work;

import android.os.Build;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0002\u0005\u0006B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0007"}, d2 = {"Landroidx/work/OneTimeWorkRequest;", "Landroidx/work/WorkRequest;", "builder", "Landroidx/work/OneTimeWorkRequest$Builder;", "(Landroidx/work/OneTimeWorkRequest$Builder;)V", "Builder", "Companion", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OneTimeWorkRequest.kt */
public final class OneTimeWorkRequest extends WorkRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final OneTimeWorkRequest from(Class<? extends ListenableWorker> cls) {
        return Companion.from(cls);
    }

    @JvmStatic
    public static final List<OneTimeWorkRequest> from(List<? extends Class<? extends ListenableWorker>> list) {
        return Companion.from(list);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OneTimeWorkRequest(Builder builder) {
        super(builder.getId$work_runtime_release(), builder.getWorkSpec$work_runtime_release(), builder.getTags$work_runtime_release());
        Intrinsics.checkNotNullParameter(builder, "builder");
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\r\u0010\n\u001a\u00020\u0002H\u0010¢\u0006\u0002\b\u000bJ\u0016\u0010\f\u001a\u00020\u00002\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0004R\u0014\u0010\u0007\u001a\u00020\u00008PX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Landroidx/work/OneTimeWorkRequest$Builder;", "Landroidx/work/WorkRequest$Builder;", "Landroidx/work/OneTimeWorkRequest;", "workerClass", "Ljava/lang/Class;", "Landroidx/work/ListenableWorker;", "(Ljava/lang/Class;)V", "thisObject", "getThisObject$work_runtime_release", "()Landroidx/work/OneTimeWorkRequest$Builder;", "buildInternal", "buildInternal$work_runtime_release", "setInputMerger", "inputMerger", "Landroidx/work/InputMerger;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OneTimeWorkRequest.kt */
    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        public Builder getThisObject$work_runtime_release() {
            return this;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(Class<? extends ListenableWorker> cls) {
            super(cls);
            Intrinsics.checkNotNullParameter(cls, "workerClass");
            getWorkSpec$work_runtime_release().inputMergerClassName = OverwritingInputMerger.class.getName();
        }

        public final Builder setInputMerger(Class<? extends InputMerger> cls) {
            Intrinsics.checkNotNullParameter(cls, "inputMerger");
            getWorkSpec$work_runtime_release().inputMergerClassName = cls.getName();
            return this;
        }

        public OneTimeWorkRequest buildInternal$work_runtime_release() {
            if (!getBackoffCriteriaSet$work_runtime_release() || Build.VERSION.SDK_INT < 23 || !getWorkSpec$work_runtime_release().constraints.requiresDeviceIdle()) {
                return new OneTimeWorkRequest(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job".toString());
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0007J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\bH\u0007¨\u0006\n"}, d2 = {"Landroidx/work/OneTimeWorkRequest$Companion;", "", "()V", "from", "Landroidx/work/OneTimeWorkRequest;", "workerClass", "Ljava/lang/Class;", "Landroidx/work/ListenableWorker;", "", "workerClasses", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OneTimeWorkRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final OneTimeWorkRequest from(Class<? extends ListenableWorker> cls) {
            Intrinsics.checkNotNullParameter(cls, "workerClass");
            return (OneTimeWorkRequest) new Builder(cls).build();
        }

        @JvmStatic
        public final List<OneTimeWorkRequest> from(List<? extends Class<? extends ListenableWorker>> list) {
            Intrinsics.checkNotNullParameter(list, "workerClasses");
            Iterable<Class> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Class builder : iterable) {
                arrayList.add((OneTimeWorkRequest) new Builder(builder).build());
            }
            return (List) arrayList;
        }
    }
}
