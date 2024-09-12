package coil.size;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import coil.size.Dimension;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0002J\u0011\u0010\u0015\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcoil/size/ViewSizeResolver;", "T", "Landroid/view/View;", "Lcoil/size/SizeResolver;", "subtractPadding", "", "getSubtractPadding", "()Z", "view", "getView", "()Landroid/view/View;", "getDimension", "Lcoil/size/Dimension;", "paramSize", "", "viewSize", "paddingSize", "getHeight", "getSize", "Lcoil/size/Size;", "getWidth", "size", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removePreDrawListenerSafe", "", "Landroid/view/ViewTreeObserver;", "victim", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ViewSizeResolver.kt */
public interface ViewSizeResolver<T extends View> extends SizeResolver {
    boolean getSubtractPadding();

    T getView();

    Object size(Continuation<? super Size> continuation);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ViewSizeResolver.kt */
    public static final class DefaultImpls {
        public static <T extends View> boolean getSubtractPadding(ViewSizeResolver<T> viewSizeResolver) {
            return true;
        }

        public static <T extends View> Object size(ViewSizeResolver<T> viewSizeResolver, Continuation<? super Size> continuation) {
            Size size = getSize(viewSizeResolver);
            if (size != null) {
                return size;
            }
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
            ViewTreeObserver viewTreeObserver = viewSizeResolver.getView().getViewTreeObserver();
            ViewSizeResolver$size$3$preDrawListener$1 viewSizeResolver$size$3$preDrawListener$1 = new ViewSizeResolver$size$3$preDrawListener$1(viewSizeResolver, viewTreeObserver, cancellableContinuation);
            viewTreeObserver.addOnPreDrawListener(viewSizeResolver$size$3$preDrawListener$1);
            cancellableContinuation.invokeOnCancellation(new ViewSizeResolver$size$3$1(viewSizeResolver, viewTreeObserver, viewSizeResolver$size$3$preDrawListener$1));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        /* access modifiers changed from: private */
        public static <T extends View> Size getSize(ViewSizeResolver<T> viewSizeResolver) {
            Dimension height;
            Dimension width = getWidth(viewSizeResolver);
            if (width == null || (height = getHeight(viewSizeResolver)) == null) {
                return null;
            }
            return new Size(width, height);
        }

        private static <T extends View> Dimension getWidth(ViewSizeResolver<T> viewSizeResolver) {
            ViewGroup.LayoutParams layoutParams = viewSizeResolver.getView().getLayoutParams();
            return getDimension(viewSizeResolver, layoutParams != null ? layoutParams.width : -1, viewSizeResolver.getView().getWidth(), viewSizeResolver.getSubtractPadding() ? viewSizeResolver.getView().getPaddingLeft() + viewSizeResolver.getView().getPaddingRight() : 0);
        }

        private static <T extends View> Dimension getHeight(ViewSizeResolver<T> viewSizeResolver) {
            ViewGroup.LayoutParams layoutParams = viewSizeResolver.getView().getLayoutParams();
            return getDimension(viewSizeResolver, layoutParams != null ? layoutParams.height : -1, viewSizeResolver.getView().getHeight(), viewSizeResolver.getSubtractPadding() ? viewSizeResolver.getView().getPaddingTop() + viewSizeResolver.getView().getPaddingBottom() : 0);
        }

        private static <T extends View> Dimension getDimension(ViewSizeResolver<T> viewSizeResolver, int i, int i2, int i3) {
            if (i == -2) {
                return Dimension.Undefined.INSTANCE;
            }
            int i4 = i - i3;
            if (i4 > 0) {
                return Dimensions.Dimension(i4);
            }
            int i5 = i2 - i3;
            if (i5 > 0) {
                return Dimensions.Dimension(i5);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static <T extends View> void removePreDrawListenerSafe(ViewSizeResolver<T> viewSizeResolver, ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            } else {
                viewSizeResolver.getView().getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
            }
        }
    }
}
