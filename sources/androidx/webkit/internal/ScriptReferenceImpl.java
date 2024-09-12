package androidx.webkit.internal;

import androidx.webkit.ScriptReferenceCompat;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.ScriptReferenceBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class ScriptReferenceImpl extends ScriptReferenceCompat {
    private ScriptReferenceBoundaryInterface mBoundaryInterface;

    private ScriptReferenceImpl(ScriptReferenceBoundaryInterface scriptReferenceBoundaryInterface) {
        this.mBoundaryInterface = scriptReferenceBoundaryInterface;
    }

    public static ScriptReferenceImpl toScriptReferenceCompat(InvocationHandler invocationHandler) {
        return new ScriptReferenceImpl((ScriptReferenceBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(ScriptReferenceBoundaryInterface.class, invocationHandler));
    }

    public void remove() {
        this.mBoundaryInterface.remove();
    }
}
