package com.swmansion.gesturehandler.react;

import android.util.SparseArray;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerInteractionController;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\bJ \u0010\u0014\u001a\u00020\u00152\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J \u0010\u0017\u001a\u00020\u00152\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J \u0010\u0018\u001a\u00020\u00152\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J \u0010\u0019\u001a\u00020\u00152\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\nH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerInteractionManager;", "Lcom/swmansion/gesturehandler/core/GestureHandlerInteractionController;", "()V", "simultaneousRelations", "Landroid/util/SparseArray;", "", "waitForRelations", "configureInteractions", "", "handler", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "config", "Lcom/facebook/react/bridge/ReadableMap;", "convertHandlerTagsArray", "key", "", "dropRelationsForHandlerWithTag", "handlerTag", "", "reset", "shouldHandlerBeCancelledBy", "", "otherHandler", "shouldRecognizeSimultaneously", "shouldRequireHandlerToWaitForFailure", "shouldWaitForHandlerFailure", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RNGestureHandlerInteractionManager.kt */
public final class RNGestureHandlerInteractionManager implements GestureHandlerInteractionController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_SIMULTANEOUS_HANDLERS = "simultaneousHandlers";
    private static final String KEY_WAIT_FOR = "waitFor";
    private final SparseArray<int[]> simultaneousRelations = new SparseArray<>();
    private final SparseArray<int[]> waitForRelations = new SparseArray<>();

    public boolean shouldRequireHandlerToWaitForFailure(GestureHandler<?> gestureHandler, GestureHandler<?> gestureHandler2) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        Intrinsics.checkNotNullParameter(gestureHandler2, "otherHandler");
        return false;
    }

    public final void dropRelationsForHandlerWithTag(int i) {
        this.waitForRelations.remove(i);
        this.simultaneousRelations.remove(i);
    }

    private final int[] convertHandlerTagsArray(ReadableMap readableMap, String str) {
        ReadableArray array = readableMap.getArray(str);
        Intrinsics.checkNotNull(array);
        int size = array.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = array.getInt(i);
        }
        return iArr;
    }

    public final void configureInteractions(GestureHandler<?> gestureHandler, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        Intrinsics.checkNotNullParameter(readableMap, "config");
        gestureHandler.setInteractionController(this);
        if (readableMap.hasKey(KEY_WAIT_FOR)) {
            this.waitForRelations.put(gestureHandler.getTag(), convertHandlerTagsArray(readableMap, KEY_WAIT_FOR));
        }
        if (readableMap.hasKey(KEY_SIMULTANEOUS_HANDLERS)) {
            this.simultaneousRelations.put(gestureHandler.getTag(), convertHandlerTagsArray(readableMap, KEY_SIMULTANEOUS_HANDLERS));
        }
    }

    public boolean shouldWaitForHandlerFailure(GestureHandler<?> gestureHandler, GestureHandler<?> gestureHandler2) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        Intrinsics.checkNotNullParameter(gestureHandler2, "otherHandler");
        int[] iArr = this.waitForRelations.get(gestureHandler.getTag());
        if (iArr == null) {
            return false;
        }
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (iArr[i] == gestureHandler2.getTag()) {
                return true;
            }
        }
        return false;
    }

    public boolean shouldHandlerBeCancelledBy(GestureHandler<?> gestureHandler, GestureHandler<?> gestureHandler2) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        Intrinsics.checkNotNullParameter(gestureHandler2, "otherHandler");
        if (gestureHandler2 instanceof NativeViewGestureHandler) {
            return ((NativeViewGestureHandler) gestureHandler2).getDisallowInterruption();
        }
        return false;
    }

    public boolean shouldRecognizeSimultaneously(GestureHandler<?> gestureHandler, GestureHandler<?> gestureHandler2) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        Intrinsics.checkNotNullParameter(gestureHandler2, "otherHandler");
        int[] iArr = this.simultaneousRelations.get(gestureHandler.getTag());
        if (iArr == null) {
            return false;
        }
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (iArr[i] == gestureHandler2.getTag()) {
                return true;
            }
        }
        return false;
    }

    public final void reset() {
        this.waitForRelations.clear();
        this.simultaneousRelations.clear();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerInteractionManager$Companion;", "", "()V", "KEY_SIMULTANEOUS_HANDLERS", "", "KEY_WAIT_FOR", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RNGestureHandlerInteractionManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
