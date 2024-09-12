package coil.transition;

import coil.request.ImageResult;
import coil.transition.NoneTransition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0005"}, d2 = {"Lcoil/transition/Transition;", "", "transition", "", "Factory", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Transition.kt */
public interface Transition {
    void transition();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcoil/transition/Transition$Factory;", "", "create", "Lcoil/transition/Transition;", "target", "Lcoil/transition/TransitionTarget;", "result", "Lcoil/request/ImageResult;", "Companion", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Transition.kt */
    public interface Factory {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final Factory NONE = new NoneTransition.Factory();

        Transition create(TransitionTarget transitionTarget, ImageResult imageResult);

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0005"}, d2 = {"Lcoil/transition/Transition$Factory$Companion;", "", "()V", "NONE", "Lcoil/transition/Transition$Factory;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: Transition.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }
        }
    }
}
