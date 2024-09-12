package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: JobSupport.kt */
/* synthetic */ class JobSupport$onAwaitInternal$2 extends FunctionReferenceImpl implements Function3<JobSupport, Object, Object, Object> {
    public static final JobSupport$onAwaitInternal$2 INSTANCE = new JobSupport$onAwaitInternal$2();

    JobSupport$onAwaitInternal$2() {
        super(3, JobSupport.class, "onAwaitInternalProcessResFunc", "onAwaitInternalProcessResFunc(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(JobSupport jobSupport, Object obj, Object obj2) {
        return jobSupport.onAwaitInternalProcessResFunc(obj, obj2);
    }
}
