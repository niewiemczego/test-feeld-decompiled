package com.transparentvideo;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final boolean LOG_ATTACH_DETACH = true;
    private static final boolean LOG_EGL = true;
    private static final boolean LOG_PAUSE_RESUME = true;
    private static final boolean LOG_RENDERER = true;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    private static final boolean LOG_SURFACE = true;
    private static final boolean LOG_THREADS = true;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final String TAG = "GLTextureView";
    /* access modifiers changed from: private */
    public static final GLThreadManager sGLThreadManager = new GLThreadManager();
    /* access modifiers changed from: private */
    public int mDebugFlags;
    private boolean mDetached;
    /* access modifiers changed from: private */
    public EGLConfigChooser mEGLConfigChooser;
    /* access modifiers changed from: private */
    public int mEGLContextClientVersion;
    /* access modifiers changed from: private */
    public EGLContextFactory mEGLContextFactory;
    /* access modifiers changed from: private */
    public EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLThread mGLThread;
    /* access modifiers changed from: private */
    public GLWrapper mGLWrapper;
    /* access modifiers changed from: private */
    public boolean mPreserveEGLContextOnPause;
    /* access modifiers changed from: private */
    public Renderer mRenderer;
    private final WeakReference<GLTextureView> mThisWeakRef = new WeakReference<>(this);

    public interface EGLConfigChooser {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface EGLContextFactory {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public interface EGLWindowSurfaceFactory {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    public interface GLWrapper {
        GL wrap(GL gl);
    }

    public interface Renderer {
        void onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i, int i2);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);

        void onSurfaceDestroyed(GL10 gl10);
    }

    public GLTextureView(Context context) {
        super(context);
        init();
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            GLThread gLThread = this.mGLThread;
            if (gLThread != null) {
                gLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(GLWrapper gLWrapper) {
        this.mGLWrapper = gLWrapper;
    }

    public void setDebugFlags(int i) {
        this.mDebugFlags = i;
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.mPreserveEGLContextOnPause = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public void setRenderer(Renderer renderer) {
        checkRenderThreadState();
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new DefaultContextFactory();
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        }
        this.mRenderer = renderer;
        GLThread gLThread = new GLThread(this.mThisWeakRef);
        this.mGLThread = gLThread;
        gLThread.start();
    }

    public void setEGLContextFactory(EGLContextFactory eGLContextFactory) {
        checkRenderThreadState();
        this.mEGLContextFactory = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = eGLWindowSurfaceFactory;
    }

    public void setEGLConfigChooser(EGLConfigChooser eGLConfigChooser) {
        checkRenderThreadState();
        this.mEGLConfigChooser = eGLConfigChooser;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser((EGLConfigChooser) new SimpleEGLConfigChooser(z));
    }

    public void setEGLConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
        setEGLConfigChooser((EGLConfigChooser) new ComponentSizeChooser(i, i2, i3, i4, i5, i6));
    }

    public void setEGLContextClientVersion(int i) {
        checkRenderThreadState();
        this.mEGLContextClientVersion = i;
    }

    public void setRenderMode(int i) {
        this.mGLThread.setRenderMode(i);
    }

    public int getRenderMode() {
        return this.mGLThread.getRenderMode();
    }

    public void requestRender() {
        this.mGLThread.requestRender();
    }

    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.mGLThread.surfaceCreated();
    }

    public void surfaceDestroyed(SurfaceTexture surfaceTexture) {
        this.mGLThread.surfaceDestroyed();
    }

    public void surfaceChanged(SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        this.mGLThread.onWindowResize(i2, i3);
    }

    public void onPause() {
        this.mGLThread.onPause();
    }

    public void onResume() {
        this.mGLThread.onResume();
    }

    public void queueEvent(Runnable runnable) {
        this.mGLThread.queueEvent(runnable);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAG, "onAttachedToWindow reattach =" + this.mDetached);
        if (this.mDetached && this.mRenderer != null) {
            GLThread gLThread = this.mGLThread;
            int renderMode = gLThread != null ? gLThread.getRenderMode() : 1;
            GLThread gLThread2 = new GLThread(this.mThisWeakRef);
            this.mGLThread = gLThread2;
            if (renderMode != 1) {
                gLThread2.setRenderMode(renderMode);
            }
            this.mGLThread.start();
        }
        this.mDetached = false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        Log.d(TAG, "onDetachedFromWindow");
        GLThread gLThread = this.mGLThread;
        if (gLThread != null) {
            gLThread.requestExitAndWait();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        surfaceChanged(getSurfaceTexture(), 0, i3 - i, i4 - i2);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        surfaceCreated(surfaceTexture);
        surfaceChanged(surfaceTexture, 0, i, i2);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        surfaceChanged(surfaceTexture, 0, i, i2);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        surfaceDestroyed(surfaceTexture);
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    private class DefaultContextFactory implements EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private DefaultContextFactory() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLTextureView.this.mEGLContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                Log.i("DefaultContextFactory", "tid=" + Thread.currentThread().getId());
                EglHelper.throwEglException("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    private static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, (int[]) null);
            } catch (IllegalArgumentException e) {
                Log.e(GLTextureView.TAG, "eglCreateWindowSurface", e);
                return null;
            }
        }

        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    private abstract class BaseConfigChooser implements EGLConfigChooser {
        protected int[] mConfigSpec;

        /* access modifiers changed from: package-private */
        public abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public BaseConfigChooser(int[] iArr) {
            this.mConfigSpec = filterConfigSpec(iArr);
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, (EGLConfig[]) null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, eGLConfigArr, i, iArr)) {
                        EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
                        if (chooseConfig != null) {
                            return chooseConfig;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        private int[] filterConfigSpec(int[] iArr) {
            if (GLTextureView.this.mEGLContextClientVersion != 2) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            iArr2[length] = 4;
            iArr2[length + 1] = 12344;
            return iArr2;
        }
    }

    private class ComponentSizeChooser extends BaseConfigChooser {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public ComponentSizeChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                EGL10 egl102 = egl10;
                EGLDisplay eGLDisplay2 = eGLDisplay;
                EGLConfig eGLConfig2 = eGLConfig;
                int findConfigAttrib = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    EGL10 egl103 = egl10;
                    EGLDisplay eGLDisplay3 = eGLDisplay;
                    EGLConfig eGLConfig3 = eGLConfig;
                    int findConfigAttrib3 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12324, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12323, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12322, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12321, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue) ? this.mValue[0] : i2;
        }
    }

    private class SimpleEGLConfigChooser extends ComponentSizeChooser {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SimpleEGLConfigChooser(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    private static class EglHelper {
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<GLTextureView> mGLSurfaceViewWeakRef;

        public EglHelper(WeakReference<GLTextureView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        public void start() {
            Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.mEgl = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.mEglDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
                    GLTextureView gLTextureView = (GLTextureView) this.mGLSurfaceViewWeakRef.get();
                    if (gLTextureView == null) {
                        this.mEglConfig = null;
                        this.mEglContext = null;
                    } else {
                        this.mEglConfig = gLTextureView.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                        this.mEglContext = gLTextureView.mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
                    }
                    EGLContext eGLContext = this.mEglContext;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.mEglContext = null;
                        throwEglException("createContext");
                    }
                    Log.w("EglHelper", "createContext " + this.mEglContext + " tid=" + Thread.currentThread().getId());
                    this.mEglSurface = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public boolean createSurface() {
            Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            if (this.mEgl == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.mEglDisplay == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.mEglConfig != null) {
                destroySurfaceImp();
                GLTextureView gLTextureView = (GLTextureView) this.mGLSurfaceViewWeakRef.get();
                if (gLTextureView != null) {
                    this.mEglSurface = gLTextureView.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, gLTextureView.getSurfaceTexture());
                } else {
                    this.mEglSurface = null;
                }
                EGLSurface eGLSurface = this.mEglSurface;
                if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                    if (this.mEgl.eglGetError() == 12299) {
                        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                }
                EGL10 egl10 = this.mEgl;
                EGLDisplay eGLDisplay = this.mEglDisplay;
                EGLSurface eGLSurface2 = this.mEglSurface;
                if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.mEglContext)) {
                    return true;
                }
                logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
                return false;
            } else {
                throw new RuntimeException("mEglConfig not initialized");
            }
        }

        /* access modifiers changed from: package-private */
        public GL createGL() {
            GL gl = this.mEglContext.getGL();
            GLTextureView gLTextureView = (GLTextureView) this.mGLSurfaceViewWeakRef.get();
            if (gLTextureView == null) {
                return gl;
            }
            if (gLTextureView.mGLWrapper != null) {
                gl = gLTextureView.mGLWrapper.wrap(gl);
            }
            if ((gLTextureView.mDebugFlags & 3) == 0) {
                return gl;
            }
            int i = 0;
            LogWriter logWriter = null;
            if ((gLTextureView.mDebugFlags & 1) != 0) {
                i = 1;
            }
            if ((gLTextureView.mDebugFlags & 2) != 0) {
                logWriter = new LogWriter();
            }
            return GLDebugHelper.wrap(gl, i, logWriter);
        }

        public int swap() {
            if (!this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                return this.mEgl.eglGetError();
            }
            return 12288;
        }

        public void destroySurface() {
            Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
            destroySurfaceImp();
        }

        private void destroySurfaceImp() {
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                GLTextureView gLTextureView = (GLTextureView) this.mGLSurfaceViewWeakRef.get();
                if (gLTextureView != null) {
                    gLTextureView.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
                }
                this.mEglSurface = null;
            }
        }

        public void finish() {
            Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
            if (this.mEglContext != null) {
                GLTextureView gLTextureView = (GLTextureView) this.mGLSurfaceViewWeakRef.get();
                if (gLTextureView != null) {
                    gLTextureView.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                }
                this.mEglContext = null;
            }
            EGLDisplay eGLDisplay = this.mEglDisplay;
            if (eGLDisplay != null) {
                this.mEgl.eglTerminate(eGLDisplay);
                this.mEglDisplay = null;
            }
        }

        private void throwEglException(String str) {
            throwEglException(str, this.mEgl.eglGetError());
        }

        public static void throwEglException(String str, int i) {
            String formatEglError = formatEglError(str, i);
            Log.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + formatEglError);
            throw new RuntimeException(formatEglError);
        }

        public static void logEglErrorAsWarning(String str, String str2, int i) {
            Log.w(str, formatEglError(str2, i));
        }

        public static String formatEglError(String str, int i) {
            return str + " failed: " + i;
        }
    }

    static class GLThread extends Thread {
        private EglHelper mEglHelper;
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        /* access modifiers changed from: private */
        public boolean mExited;
        private WeakReference<GLTextureView> mGLSurfaceViewWeakRef;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private int mHeight = 0;
        private boolean mPaused;
        private boolean mRenderComplete;
        private int mRenderMode = 1;
        private boolean mRequestPaused;
        private boolean mRequestRender = true;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        private boolean mSizeChanged = true;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private int mWidth = 0;

        GLThread(WeakReference<GLTextureView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        public void run() {
            setName("GLThread " + getId());
            Log.i("GLThread", "starting tid=" + getId());
            try {
                guardedRun();
            } catch (Exception | IllegalStateException | InterruptedException unused) {
            } catch (Throwable th) {
                GLTextureView.sGLThreadManager.threadExiting(this);
                throw th;
            }
            GLTextureView.sGLThreadManager.threadExiting(this);
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                GLTextureView.sGLThreadManager.releaseEglContextLocked(this);
            }
        }

        /* JADX WARNING: type inference failed for: r2v29, types: [javax.microedition.khronos.opengles.GL] */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x0268, code lost:
            if (r14 == null) goto L_0x0271;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x0271, code lost:
            if (r5 == false) goto L_0x029a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x0273, code lost:
            android.util.Log.w("GLThread", "egl createSurface");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x0280, code lost:
            if (r1.mEglHelper.createSurface() != false) goto L_0x0299;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x0282, code lost:
            r2 = com.transparentvideo.GLTextureView.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x0286, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
            r1.mSurfaceIsBad = true;
            com.transparentvideo.GLTextureView.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x0291, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x0292, code lost:
            r3 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x0299, code lost:
            r5 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x029a, code lost:
            if (r6 == false) goto L_0x02ae;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x029c, code lost:
            r3 = r1.mEglHelper.createGL();
            com.transparentvideo.GLTextureView.access$800().checkGLDriver(r3);
            r6 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x02ae, code lost:
            r3 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x02b0, code lost:
            if (r4 == false) goto L_0x02cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x02b2, code lost:
            android.util.Log.w("GLThread", "onSurfaceCreated");
            r2 = (com.transparentvideo.GLTextureView) r1.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x02c1, code lost:
            if (r2 == null) goto L_0x02ce;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x02c3, code lost:
            com.transparentvideo.GLTextureView.access$1000(r2).onSurfaceCreated(r3, r1.mEglHelper.mEglConfig);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x02ce, code lost:
            r4 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x02cf, code lost:
            if (r8 == false) goto L_0x030b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x02d1, code lost:
            android.util.Log.w("GLThread", "onSurfaceChanged(" + r12 + ", " + r13 + ")");
            r2 = (com.transparentvideo.GLTextureView) r1.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x0301, code lost:
            if (r2 == null) goto L_0x030a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x0303, code lost:
            com.transparentvideo.GLTextureView.access$1000(r2).onSurfaceChanged(r3, r12, r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x030a, code lost:
            r8 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
            r2 = (com.transparentvideo.GLTextureView) r1.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x0313, code lost:
            if (r2 == null) goto L_0x031c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:?, code lost:
            com.transparentvideo.GLTextureView.access$1000(r2).onDrawFrame(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
            r2 = r1.mEglHelper.swap();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x0324, code lost:
            if (r2 == 12288) goto L_0x0363;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x0328, code lost:
            if (r2 == 12302) goto L_0x0345;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
            com.transparentvideo.GLTextureView.EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", r2);
            r2 = com.transparentvideo.GLTextureView.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x0335, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:?, code lost:
            r1.mSurfaceIsBad = true;
            com.transparentvideo.GLTextureView.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x0340, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
            android.util.Log.i("GLThread", "egl context lost tid=" + getId());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x0362, code lost:
            r7 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x0363, code lost:
            if (r9 == false) goto L_0x0366;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x0365, code lost:
            r10 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x0366, code lost:
            r1 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x036b, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x036c, code lost:
            r2 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:187:0x0428, code lost:
            monitor-enter(com.transparentvideo.GLTextureView.access$800());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:?, code lost:
            stopEglSurfaceLocked();
            stopEglContextLocked();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x0430, code lost:
            throw r0;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:200:0x022f A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x0221 A[SYNTHETIC, Splitter:B:87:0x0221] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void guardedRun() throws java.lang.InterruptedException {
            /*
                r19 = this;
                r1 = r19
                com.transparentvideo.GLTextureView$EglHelper r0 = new com.transparentvideo.GLTextureView$EglHelper
                java.lang.ref.WeakReference<com.transparentvideo.GLTextureView> r2 = r1.mGLSurfaceViewWeakRef
                r0.<init>(r2)
                r1.mEglHelper = r0
                r0 = 0
                r1.mHaveEglContext = r0
                r1.mHaveEglSurface = r0
                r4 = r0
                r5 = r4
                r6 = r5
                r7 = r6
                r8 = r7
                r9 = r8
                r10 = r9
                r11 = r10
                r12 = r11
                r13 = r12
                r3 = 0
            L_0x001b:
                r14 = 0
            L_0x001c:
                com.transparentvideo.GLTextureView$GLThreadManager r15 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0422 }
                monitor-enter(r15)     // Catch:{ all -> 0x0422 }
            L_0x0021:
                boolean r2 = r1.mShouldExit     // Catch:{ all -> 0x041a }
                if (r2 == 0) goto L_0x0036
                monitor-exit(r15)     // Catch:{ all -> 0x041a }
                com.transparentvideo.GLTextureView$GLThreadManager r2 = com.transparentvideo.GLTextureView.sGLThreadManager
                monitor-enter(r2)
                r19.stopEglSurfaceLocked()     // Catch:{ all -> 0x0033 }
                r19.stopEglContextLocked()     // Catch:{ all -> 0x0033 }
                monitor-exit(r2)     // Catch:{ all -> 0x0033 }
                return
            L_0x0033:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0033 }
                throw r0
            L_0x0036:
                java.util.ArrayList<java.lang.Runnable> r2 = r1.mEventQueue     // Catch:{ all -> 0x041a }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x041a }
                if (r2 != 0) goto L_0x004d
                java.util.ArrayList<java.lang.Runnable> r2 = r1.mEventQueue     // Catch:{ all -> 0x041a }
                r14 = 0
                java.lang.Object r2 = r2.remove(r14)     // Catch:{ all -> 0x041a }
                r14 = r2
                java.lang.Runnable r14 = (java.lang.Runnable) r14     // Catch:{ all -> 0x041a }
                r17 = r3
                r0 = 0
                goto L_0x0267
            L_0x004d:
                boolean r2 = r1.mPaused     // Catch:{ all -> 0x041a }
                boolean r0 = r1.mRequestPaused     // Catch:{ all -> 0x041a }
                if (r2 == r0) goto L_0x008b
                r1.mPaused = r0     // Catch:{ all -> 0x041a }
                com.transparentvideo.GLTextureView$GLThreadManager r2 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x041a }
                r2.notifyAll()     // Catch:{ all -> 0x041a }
                java.lang.String r2 = "GLThread"
                r16 = r0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x041a }
                r0.<init>()     // Catch:{ all -> 0x041a }
                r17 = r3
                java.lang.String r3 = "mPaused is now "
                java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ all -> 0x041a }
                boolean r3 = r1.mPaused     // Catch:{ all -> 0x041a }
                java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ all -> 0x041a }
                java.lang.String r3 = " tid="
                java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ all -> 0x041a }
                r18 = r4
                long r3 = r19.getId()     // Catch:{ all -> 0x041a }
                java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ all -> 0x041a }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x041a }
                android.util.Log.i(r2, r0)     // Catch:{ all -> 0x041a }
                goto L_0x0091
            L_0x008b:
                r17 = r3
                r18 = r4
                r16 = 0
            L_0x0091:
                boolean r0 = r1.mShouldReleaseEglContext     // Catch:{ all -> 0x041a }
                if (r0 == 0) goto L_0x00bb
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x041a }
                r2.<init>()     // Catch:{ all -> 0x041a }
                java.lang.String r3 = "releasing EGL context because asked to tid="
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x041a }
                long r3 = r19.getId()     // Catch:{ all -> 0x041a }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x041a }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x041a }
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x041a }
                r19.stopEglSurfaceLocked()     // Catch:{ all -> 0x041a }
                r19.stopEglContextLocked()     // Catch:{ all -> 0x041a }
                r0 = 0
                r1.mShouldReleaseEglContext = r0     // Catch:{ all -> 0x041a }
                r11 = 1
            L_0x00bb:
                if (r7 == 0) goto L_0x00c4
                r19.stopEglSurfaceLocked()     // Catch:{ all -> 0x041a }
                r19.stopEglContextLocked()     // Catch:{ all -> 0x041a }
                r7 = 0
            L_0x00c4:
                if (r16 == 0) goto L_0x00e9
                boolean r0 = r1.mHaveEglSurface     // Catch:{ all -> 0x041a }
                if (r0 == 0) goto L_0x00e9
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x041a }
                r2.<init>()     // Catch:{ all -> 0x041a }
                java.lang.String r3 = "releasing EGL surface because paused tid="
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x041a }
                long r3 = r19.getId()     // Catch:{ all -> 0x041a }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x041a }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x041a }
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x041a }
                r19.stopEglSurfaceLocked()     // Catch:{ all -> 0x041a }
            L_0x00e9:
                if (r16 == 0) goto L_0x012a
                boolean r0 = r1.mHaveEglContext     // Catch:{ all -> 0x041a }
                if (r0 == 0) goto L_0x012a
                java.lang.ref.WeakReference<com.transparentvideo.GLTextureView> r0 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x041a }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x041a }
                com.transparentvideo.GLTextureView r0 = (com.transparentvideo.GLTextureView) r0     // Catch:{ all -> 0x041a }
                if (r0 != 0) goto L_0x00fb
                r0 = 0
                goto L_0x00ff
            L_0x00fb:
                boolean r0 = r0.mPreserveEGLContextOnPause     // Catch:{ all -> 0x041a }
            L_0x00ff:
                if (r0 == 0) goto L_0x010b
                com.transparentvideo.GLTextureView$GLThreadManager r0 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x041a }
                boolean r0 = r0.shouldReleaseEGLContextWhenPausing()     // Catch:{ all -> 0x041a }
                if (r0 == 0) goto L_0x012a
            L_0x010b:
                r19.stopEglContextLocked()     // Catch:{ all -> 0x041a }
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x041a }
                r2.<init>()     // Catch:{ all -> 0x041a }
                java.lang.String r3 = "releasing EGL context because paused tid="
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x041a }
                long r3 = r19.getId()     // Catch:{ all -> 0x041a }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x041a }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x041a }
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x041a }
            L_0x012a:
                if (r16 == 0) goto L_0x0157
                com.transparentvideo.GLTextureView$GLThreadManager r0 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x041a }
                boolean r0 = r0.shouldTerminateEGLWhenPausing()     // Catch:{ all -> 0x041a }
                if (r0 == 0) goto L_0x0157
                com.transparentvideo.GLTextureView$EglHelper r0 = r1.mEglHelper     // Catch:{ all -> 0x041a }
                r0.finish()     // Catch:{ all -> 0x041a }
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x041a }
                r2.<init>()     // Catch:{ all -> 0x041a }
                java.lang.String r3 = "terminating EGL because paused tid="
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x041a }
                long r3 = r19.getId()     // Catch:{ all -> 0x041a }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x041a }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x041a }
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x041a }
            L_0x0157:
                boolean r0 = r1.mHasSurface     // Catch:{ all -> 0x041a }
                if (r0 != 0) goto L_0x018f
                boolean r0 = r1.mWaitingForSurface     // Catch:{ all -> 0x041a }
                if (r0 != 0) goto L_0x018f
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x041a }
                r2.<init>()     // Catch:{ all -> 0x041a }
                java.lang.String r3 = "noticed surfaceView surface lost tid="
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x041a }
                long r3 = r19.getId()     // Catch:{ all -> 0x041a }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x041a }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x041a }
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x041a }
                boolean r0 = r1.mHaveEglSurface     // Catch:{ all -> 0x041a }
                if (r0 == 0) goto L_0x0182
                r19.stopEglSurfaceLocked()     // Catch:{ all -> 0x041a }
            L_0x0182:
                r0 = 1
                r1.mWaitingForSurface = r0     // Catch:{ all -> 0x041a }
                r0 = 0
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x041a }
                com.transparentvideo.GLTextureView$GLThreadManager r0 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x041a }
                r0.notifyAll()     // Catch:{ all -> 0x041a }
            L_0x018f:
                boolean r0 = r1.mHasSurface     // Catch:{ all -> 0x041a }
                if (r0 == 0) goto L_0x01bd
                boolean r0 = r1.mWaitingForSurface     // Catch:{ all -> 0x041a }
                if (r0 == 0) goto L_0x01bd
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x041a }
                r2.<init>()     // Catch:{ all -> 0x041a }
                java.lang.String r3 = "noticed surfaceView surface acquired tid="
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x041a }
                long r3 = r19.getId()     // Catch:{ all -> 0x041a }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x041a }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x041a }
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x041a }
                r0 = 0
                r1.mWaitingForSurface = r0     // Catch:{ all -> 0x041a }
                com.transparentvideo.GLTextureView$GLThreadManager r0 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x041a }
                r0.notifyAll()     // Catch:{ all -> 0x041a }
            L_0x01bd:
                if (r10 == 0) goto L_0x01e7
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x041a }
                r2.<init>()     // Catch:{ all -> 0x041a }
                java.lang.String r3 = "sending render notification tid="
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x041a }
                long r3 = r19.getId()     // Catch:{ all -> 0x041a }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x041a }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x041a }
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x041a }
                r0 = 1
                r1.mRenderComplete = r0     // Catch:{ all -> 0x041a }
                com.transparentvideo.GLTextureView$GLThreadManager r0 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x041a }
                r0.notifyAll()     // Catch:{ all -> 0x041a }
                r9 = 0
                r10 = 0
            L_0x01e7:
                boolean r0 = r19.readyToDraw()     // Catch:{ all -> 0x041a }
                if (r0 == 0) goto L_0x0375
                boolean r0 = r1.mHaveEglContext     // Catch:{ all -> 0x0370 }
                if (r0 != 0) goto L_0x021b
                if (r11 == 0) goto L_0x01f7
                r4 = r18
                r11 = 0
                goto L_0x021d
            L_0x01f7:
                com.transparentvideo.GLTextureView$GLThreadManager r0 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x041a }
                boolean r0 = r0.tryAcquireEglContextLocked(r1)     // Catch:{ all -> 0x041a }
                if (r0 == 0) goto L_0x021b
                com.transparentvideo.GLTextureView$EglHelper r0 = r1.mEglHelper     // Catch:{ RuntimeException -> 0x0212 }
                r0.start()     // Catch:{ RuntimeException -> 0x0212 }
                r0 = 1
                r1.mHaveEglContext = r0     // Catch:{ all -> 0x041a }
                com.transparentvideo.GLTextureView$GLThreadManager r0 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x041a }
                r0.notifyAll()     // Catch:{ all -> 0x041a }
                r4 = 1
                goto L_0x021d
            L_0x0212:
                r0 = move-exception
                com.transparentvideo.GLTextureView$GLThreadManager r2 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x041a }
                r2.releaseEglContextLocked(r1)     // Catch:{ all -> 0x041a }
                throw r0     // Catch:{ all -> 0x041a }
            L_0x021b:
                r4 = r18
            L_0x021d:
                boolean r0 = r1.mHaveEglContext     // Catch:{ all -> 0x0370 }
                if (r0 == 0) goto L_0x022b
                boolean r0 = r1.mHaveEglSurface     // Catch:{ all -> 0x041a }
                if (r0 != 0) goto L_0x022b
                r0 = 1
                r1.mHaveEglSurface = r0     // Catch:{ all -> 0x041a }
                r5 = 1
                r6 = 1
                r8 = 1
            L_0x022b:
                boolean r0 = r1.mHaveEglSurface     // Catch:{ all -> 0x0370 }
                if (r0 == 0) goto L_0x0377
                boolean r0 = r1.mSizeChanged     // Catch:{ all -> 0x0370 }
                if (r0 == 0) goto L_0x025d
                int r0 = r1.mWidth     // Catch:{ all -> 0x041a }
                int r2 = r1.mHeight     // Catch:{ all -> 0x041a }
                java.lang.String r3 = "GLThread"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x041a }
                r5.<init>()     // Catch:{ all -> 0x041a }
                java.lang.String r8 = "noticing that we want render notification tid="
                java.lang.StringBuilder r5 = r5.append(r8)     // Catch:{ all -> 0x041a }
                long r8 = r19.getId()     // Catch:{ all -> 0x041a }
                java.lang.StringBuilder r5 = r5.append(r8)     // Catch:{ all -> 0x041a }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x041a }
                android.util.Log.i(r3, r5)     // Catch:{ all -> 0x041a }
                r3 = 0
                r1.mSizeChanged = r3     // Catch:{ all -> 0x041a }
                r12 = r0
                r13 = r2
                r0 = 0
                r5 = 1
                r8 = 1
                r9 = 1
                goto L_0x025e
            L_0x025d:
                r0 = 0
            L_0x025e:
                r1.mRequestRender = r0     // Catch:{ all -> 0x0370 }
                com.transparentvideo.GLTextureView$GLThreadManager r2 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0370 }
                r2.notifyAll()     // Catch:{ all -> 0x0370 }
            L_0x0267:
                monitor-exit(r15)     // Catch:{ all -> 0x0370 }
                if (r14 == 0) goto L_0x0271
                r14.run()     // Catch:{ all -> 0x0422 }
                r3 = r17
                goto L_0x001b
            L_0x0271:
                if (r5 == 0) goto L_0x029a
                java.lang.String r2 = "GLThread"
                java.lang.String r3 = "egl createSurface"
                android.util.Log.w(r2, r3)     // Catch:{ all -> 0x0422 }
                com.transparentvideo.GLTextureView$EglHelper r2 = r1.mEglHelper     // Catch:{ all -> 0x0422 }
                boolean r2 = r2.createSurface()     // Catch:{ all -> 0x0422 }
                if (r2 != 0) goto L_0x0299
                com.transparentvideo.GLTextureView$GLThreadManager r2 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0422 }
                monitor-enter(r2)     // Catch:{ all -> 0x0422 }
                r3 = 1
                r1.mSurfaceIsBad = r3     // Catch:{ all -> 0x0296 }
                com.transparentvideo.GLTextureView$GLThreadManager r3 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0296 }
                r3.notifyAll()     // Catch:{ all -> 0x0296 }
                monitor-exit(r2)     // Catch:{ all -> 0x0296 }
                r3 = r17
                goto L_0x001c
            L_0x0296:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0296 }
                throw r0     // Catch:{ all -> 0x0422 }
            L_0x0299:
                r5 = r0
            L_0x029a:
                if (r6 == 0) goto L_0x02ae
                com.transparentvideo.GLTextureView$EglHelper r2 = r1.mEglHelper     // Catch:{ all -> 0x0422 }
                javax.microedition.khronos.opengles.GL r2 = r2.createGL()     // Catch:{ all -> 0x0422 }
                r3 = r2
                javax.microedition.khronos.opengles.GL10 r3 = (javax.microedition.khronos.opengles.GL10) r3     // Catch:{ all -> 0x0422 }
                com.transparentvideo.GLTextureView$GLThreadManager r2 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0422 }
                r2.checkGLDriver(r3)     // Catch:{ all -> 0x0422 }
                r6 = r0
                goto L_0x02b0
            L_0x02ae:
                r3 = r17
            L_0x02b0:
                if (r4 == 0) goto L_0x02cf
                java.lang.String r2 = "GLThread"
                java.lang.String r4 = "onSurfaceCreated"
                android.util.Log.w(r2, r4)     // Catch:{ all -> 0x0422 }
                java.lang.ref.WeakReference<com.transparentvideo.GLTextureView> r2 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x0422 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0422 }
                com.transparentvideo.GLTextureView r2 = (com.transparentvideo.GLTextureView) r2     // Catch:{ all -> 0x0422 }
                if (r2 == 0) goto L_0x02ce
                com.transparentvideo.GLTextureView$Renderer r2 = r2.mRenderer     // Catch:{ all -> 0x0422 }
                com.transparentvideo.GLTextureView$EglHelper r4 = r1.mEglHelper     // Catch:{ all -> 0x0422 }
                javax.microedition.khronos.egl.EGLConfig r4 = r4.mEglConfig     // Catch:{ all -> 0x0422 }
                r2.onSurfaceCreated(r3, r4)     // Catch:{ all -> 0x0422 }
            L_0x02ce:
                r4 = r0
            L_0x02cf:
                if (r8 == 0) goto L_0x030b
                java.lang.String r2 = "GLThread"
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0422 }
                r8.<init>()     // Catch:{ all -> 0x0422 }
                java.lang.String r15 = "onSurfaceChanged("
                java.lang.StringBuilder r8 = r8.append(r15)     // Catch:{ all -> 0x0422 }
                java.lang.StringBuilder r8 = r8.append(r12)     // Catch:{ all -> 0x0422 }
                java.lang.String r15 = ", "
                java.lang.StringBuilder r8 = r8.append(r15)     // Catch:{ all -> 0x0422 }
                java.lang.StringBuilder r8 = r8.append(r13)     // Catch:{ all -> 0x0422 }
                java.lang.String r15 = ")"
                java.lang.StringBuilder r8 = r8.append(r15)     // Catch:{ all -> 0x0422 }
                java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0422 }
                android.util.Log.w(r2, r8)     // Catch:{ all -> 0x0422 }
                java.lang.ref.WeakReference<com.transparentvideo.GLTextureView> r2 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x0422 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0422 }
                com.transparentvideo.GLTextureView r2 = (com.transparentvideo.GLTextureView) r2     // Catch:{ all -> 0x0422 }
                if (r2 == 0) goto L_0x030a
                com.transparentvideo.GLTextureView$Renderer r2 = r2.mRenderer     // Catch:{ all -> 0x0422 }
                r2.onSurfaceChanged(r3, r12, r13)     // Catch:{ all -> 0x0422 }
            L_0x030a:
                r8 = r0
            L_0x030b:
                java.lang.ref.WeakReference<com.transparentvideo.GLTextureView> r2 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x036b }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x036b }
                com.transparentvideo.GLTextureView r2 = (com.transparentvideo.GLTextureView) r2     // Catch:{ all -> 0x036b }
                if (r2 == 0) goto L_0x031c
                com.transparentvideo.GLTextureView$Renderer r2 = r2.mRenderer     // Catch:{ all -> 0x0422 }
                r2.onDrawFrame(r3)     // Catch:{ all -> 0x0422 }
            L_0x031c:
                com.transparentvideo.GLTextureView$EglHelper r2 = r1.mEglHelper     // Catch:{ all -> 0x036b }
                int r2 = r2.swap()     // Catch:{ all -> 0x036b }
                r15 = 12288(0x3000, float:1.7219E-41)
                if (r2 == r15) goto L_0x0363
                r15 = 12302(0x300e, float:1.7239E-41)
                if (r2 == r15) goto L_0x0345
                java.lang.String r15 = "GLThread"
                java.lang.String r0 = "eglSwapBuffers"
                com.transparentvideo.GLTextureView.EglHelper.logEglErrorAsWarning(r15, r0, r2)     // Catch:{ all -> 0x0422 }
                com.transparentvideo.GLTextureView$GLThreadManager r2 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0422 }
                monitor-enter(r2)     // Catch:{ all -> 0x0422 }
                r0 = 1
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x0342 }
                com.transparentvideo.GLTextureView$GLThreadManager r15 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0342 }
                r15.notifyAll()     // Catch:{ all -> 0x0342 }
                monitor-exit(r2)     // Catch:{ all -> 0x0342 }
                goto L_0x0363
            L_0x0342:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0342 }
                throw r0     // Catch:{ all -> 0x0422 }
            L_0x0345:
                r0 = 1
                java.lang.String r2 = "GLThread"
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x036b }
                r7.<init>()     // Catch:{ all -> 0x036b }
                java.lang.String r15 = "egl context lost tid="
                java.lang.StringBuilder r7 = r7.append(r15)     // Catch:{ all -> 0x036b }
                long r0 = r19.getId()     // Catch:{ all -> 0x036b }
                java.lang.StringBuilder r0 = r7.append(r0)     // Catch:{ all -> 0x036b }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x036b }
                android.util.Log.i(r2, r0)     // Catch:{ all -> 0x036b }
                r7 = 1
            L_0x0363:
                if (r9 == 0) goto L_0x0366
                r10 = 1
            L_0x0366:
                r0 = 0
                r1 = r19
                goto L_0x001c
            L_0x036b:
                r0 = move-exception
                r2 = r19
                goto L_0x0424
            L_0x0370:
                r0 = move-exception
                r2 = r19
                goto L_0x041c
            L_0x0375:
                r4 = r18
            L_0x0377:
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0370 }
                r1.<init>()     // Catch:{ all -> 0x0370 }
                java.lang.String r2 = "waiting tid="
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0370 }
                long r2 = r19.getId()     // Catch:{ all -> 0x0370 }
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0370 }
                java.lang.String r2 = " mHaveEglContext: "
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0370 }
                r2 = r19
                boolean r3 = r2.mHaveEglContext     // Catch:{ all -> 0x0420 }
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                java.lang.String r3 = " mHaveEglSurface: "
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                boolean r3 = r2.mHaveEglSurface     // Catch:{ all -> 0x0420 }
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                java.lang.String r3 = " mPaused: "
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                boolean r3 = r2.mPaused     // Catch:{ all -> 0x0420 }
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                java.lang.String r3 = " mHasSurface: "
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                boolean r3 = r2.mHasSurface     // Catch:{ all -> 0x0420 }
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                java.lang.String r3 = " mSurfaceIsBad: "
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                boolean r3 = r2.mSurfaceIsBad     // Catch:{ all -> 0x0420 }
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                java.lang.String r3 = " mWaitingForSurface: "
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                boolean r3 = r2.mWaitingForSurface     // Catch:{ all -> 0x0420 }
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                java.lang.String r3 = " mWidth: "
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                int r3 = r2.mWidth     // Catch:{ all -> 0x0420 }
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                java.lang.String r3 = " mHeight: "
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                int r3 = r2.mHeight     // Catch:{ all -> 0x0420 }
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                java.lang.String r3 = " mRequestRender: "
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                boolean r3 = r2.mRequestRender     // Catch:{ all -> 0x0420 }
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                java.lang.String r3 = " mRenderMode: "
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                int r3 = r2.mRenderMode     // Catch:{ all -> 0x0420 }
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0420 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0420 }
                android.util.Log.i(r0, r1)     // Catch:{ all -> 0x0420 }
                com.transparentvideo.GLTextureView$GLThreadManager r0 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0420 }
                r0.wait()     // Catch:{ all -> 0x0420 }
                r1 = r2
                r3 = r17
                r0 = 0
                goto L_0x0021
            L_0x041a:
                r0 = move-exception
                r2 = r1
            L_0x041c:
                monitor-exit(r15)     // Catch:{ all -> 0x0420 }
                throw r0     // Catch:{ all -> 0x041e }
            L_0x041e:
                r0 = move-exception
                goto L_0x0424
            L_0x0420:
                r0 = move-exception
                goto L_0x041c
            L_0x0422:
                r0 = move-exception
                r2 = r1
            L_0x0424:
                com.transparentvideo.GLTextureView$GLThreadManager r1 = com.transparentvideo.GLTextureView.sGLThreadManager
                monitor-enter(r1)
                r19.stopEglSurfaceLocked()     // Catch:{ all -> 0x0431 }
                r19.stopEglContextLocked()     // Catch:{ all -> 0x0431 }
                monitor-exit(r1)     // Catch:{ all -> 0x0431 }
                throw r0
            L_0x0431:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0431 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transparentvideo.GLTextureView.GLThread.guardedRun():void");
        }

        public boolean ableToDraw() {
            return this.mHaveEglContext && this.mHaveEglSurface && readyToDraw();
        }

        private boolean readyToDraw() {
            return !this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (GLTextureView.sGLThreadManager) {
                this.mRenderMode = i;
                GLTextureView.sGLThreadManager.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (GLTextureView.sGLThreadManager) {
                i = this.mRenderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (GLTextureView.sGLThreadManager) {
                this.mRequestRender = true;
                GLTextureView.sGLThreadManager.notifyAll();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x002b, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void surfaceCreated() {
            /*
                r5 = this;
                com.transparentvideo.GLTextureView$GLThreadManager r0 = com.transparentvideo.GLTextureView.sGLThreadManager
                monitor-enter(r0)
                java.lang.String r1 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
                r2.<init>()     // Catch:{ all -> 0x0045 }
                java.lang.String r3 = "surfaceCreated tid="
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0045 }
                long r3 = r5.getId()     // Catch:{ all -> 0x0045 }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0045 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0045 }
                android.util.Log.i(r1, r2)     // Catch:{ all -> 0x0045 }
                r1 = 1
                r5.mHasSurface = r1     // Catch:{ all -> 0x0045 }
                com.transparentvideo.GLTextureView$GLThreadManager r1 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0045 }
                r1.notifyAll()     // Catch:{ all -> 0x0045 }
            L_0x002b:
                boolean r1 = r5.mWaitingForSurface     // Catch:{ all -> 0x0045 }
                if (r1 == 0) goto L_0x0043
                boolean r1 = r5.mExited     // Catch:{ all -> 0x0045 }
                if (r1 != 0) goto L_0x0043
                com.transparentvideo.GLTextureView$GLThreadManager r1 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x003b }
                r1.wait()     // Catch:{ InterruptedException -> 0x003b }
                goto L_0x002b
            L_0x003b:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0045 }
                r1.interrupt()     // Catch:{ all -> 0x0045 }
                goto L_0x002b
            L_0x0043:
                monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                return
            L_0x0045:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transparentvideo.GLTextureView.GLThread.surfaceCreated():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x002b, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void surfaceDestroyed() {
            /*
                r5 = this;
                com.transparentvideo.GLTextureView$GLThreadManager r0 = com.transparentvideo.GLTextureView.sGLThreadManager
                monitor-enter(r0)
                java.lang.String r1 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
                r2.<init>()     // Catch:{ all -> 0x0045 }
                java.lang.String r3 = "surfaceDestroyed tid="
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0045 }
                long r3 = r5.getId()     // Catch:{ all -> 0x0045 }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0045 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0045 }
                android.util.Log.i(r1, r2)     // Catch:{ all -> 0x0045 }
                r1 = 0
                r5.mHasSurface = r1     // Catch:{ all -> 0x0045 }
                com.transparentvideo.GLTextureView$GLThreadManager r1 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0045 }
                r1.notifyAll()     // Catch:{ all -> 0x0045 }
            L_0x002b:
                boolean r1 = r5.mWaitingForSurface     // Catch:{ all -> 0x0045 }
                if (r1 != 0) goto L_0x0043
                boolean r1 = r5.mExited     // Catch:{ all -> 0x0045 }
                if (r1 != 0) goto L_0x0043
                com.transparentvideo.GLTextureView$GLThreadManager r1 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x003b }
                r1.wait()     // Catch:{ InterruptedException -> 0x003b }
                goto L_0x002b
            L_0x003b:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0045 }
                r1.interrupt()     // Catch:{ all -> 0x0045 }
                goto L_0x002b
            L_0x0043:
                monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                return
            L_0x0045:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transparentvideo.GLTextureView.GLThread.surfaceDestroyed():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:9|10|11|12|13|23|19|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x002b, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0042 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPause() {
            /*
                r5 = this;
                com.transparentvideo.GLTextureView$GLThreadManager r0 = com.transparentvideo.GLTextureView.sGLThreadManager
                monitor-enter(r0)
                java.lang.String r1 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
                r2.<init>()     // Catch:{ all -> 0x004c }
                java.lang.String r3 = "onPause tid="
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x004c }
                long r3 = r5.getId()     // Catch:{ all -> 0x004c }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x004c }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x004c }
                android.util.Log.i(r1, r2)     // Catch:{ all -> 0x004c }
                r1 = 1
                r5.mRequestPaused = r1     // Catch:{ all -> 0x004c }
                com.transparentvideo.GLTextureView$GLThreadManager r1 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x004c }
                r1.notifyAll()     // Catch:{ all -> 0x004c }
            L_0x002b:
                boolean r1 = r5.mExited     // Catch:{ all -> 0x004c }
                if (r1 != 0) goto L_0x004a
                boolean r1 = r5.mPaused     // Catch:{ all -> 0x004c }
                if (r1 != 0) goto L_0x004a
                java.lang.String r1 = "Main thread"
                java.lang.String r2 = "onPause waiting for mPaused."
                android.util.Log.i(r1, r2)     // Catch:{ all -> 0x004c }
                com.transparentvideo.GLTextureView$GLThreadManager r1 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x0042 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0042 }
                goto L_0x002b
            L_0x0042:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x004c }
                r1.interrupt()     // Catch:{ all -> 0x004c }
                goto L_0x002b
            L_0x004a:
                monitor-exit(r0)     // Catch:{ all -> 0x004c }
                return
            L_0x004c:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x004c }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transparentvideo.GLTextureView.GLThread.onPause():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:11|12|13|14|15|26|21|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0030, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x004b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResume() {
            /*
                r5 = this;
                com.transparentvideo.GLTextureView$GLThreadManager r0 = com.transparentvideo.GLTextureView.sGLThreadManager
                monitor-enter(r0)
                java.lang.String r1 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
                r2.<init>()     // Catch:{ all -> 0x0055 }
                java.lang.String r3 = "onResume tid="
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0055 }
                long r3 = r5.getId()     // Catch:{ all -> 0x0055 }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0055 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0055 }
                android.util.Log.i(r1, r2)     // Catch:{ all -> 0x0055 }
                r1 = 0
                r5.mRequestPaused = r1     // Catch:{ all -> 0x0055 }
                r2 = 1
                r5.mRequestRender = r2     // Catch:{ all -> 0x0055 }
                r5.mRenderComplete = r1     // Catch:{ all -> 0x0055 }
                com.transparentvideo.GLTextureView$GLThreadManager r1 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0055 }
                r1.notifyAll()     // Catch:{ all -> 0x0055 }
            L_0x0030:
                boolean r1 = r5.mExited     // Catch:{ all -> 0x0055 }
                if (r1 != 0) goto L_0x0053
                boolean r1 = r5.mPaused     // Catch:{ all -> 0x0055 }
                if (r1 == 0) goto L_0x0053
                boolean r1 = r5.mRenderComplete     // Catch:{ all -> 0x0055 }
                if (r1 != 0) goto L_0x0053
                java.lang.String r1 = "Main thread"
                java.lang.String r2 = "onResume waiting for !mPaused."
                android.util.Log.i(r1, r2)     // Catch:{ all -> 0x0055 }
                com.transparentvideo.GLTextureView$GLThreadManager r1 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x004b }
                r1.wait()     // Catch:{ InterruptedException -> 0x004b }
                goto L_0x0030
            L_0x004b:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0055 }
                r1.interrupt()     // Catch:{ all -> 0x0055 }
                goto L_0x0030
            L_0x0053:
                monitor-exit(r0)     // Catch:{ all -> 0x0055 }
                return
            L_0x0055:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0055 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transparentvideo.GLTextureView.GLThread.onResume():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:12|13|14|15|16|28|22|4) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0018, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onWindowResize(int r4, int r5) {
            /*
                r3 = this;
                com.transparentvideo.GLTextureView$GLThreadManager r0 = com.transparentvideo.GLTextureView.sGLThreadManager
                monitor-enter(r0)
                r3.mWidth = r4     // Catch:{ all -> 0x0058 }
                r3.mHeight = r5     // Catch:{ all -> 0x0058 }
                r4 = 1
                r3.mSizeChanged = r4     // Catch:{ all -> 0x0058 }
                r3.mRequestRender = r4     // Catch:{ all -> 0x0058 }
                r4 = 0
                r3.mRenderComplete = r4     // Catch:{ all -> 0x0058 }
                com.transparentvideo.GLTextureView$GLThreadManager r4 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0058 }
                r4.notifyAll()     // Catch:{ all -> 0x0058 }
            L_0x0018:
                boolean r4 = r3.mExited     // Catch:{ all -> 0x0058 }
                if (r4 != 0) goto L_0x0056
                boolean r4 = r3.mPaused     // Catch:{ all -> 0x0058 }
                if (r4 != 0) goto L_0x0056
                boolean r4 = r3.mRenderComplete     // Catch:{ all -> 0x0058 }
                if (r4 != 0) goto L_0x0056
                boolean r4 = r3.ableToDraw()     // Catch:{ all -> 0x0058 }
                if (r4 == 0) goto L_0x0056
                java.lang.String r4 = "Main thread"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0058 }
                r5.<init>()     // Catch:{ all -> 0x0058 }
                java.lang.String r1 = "onWindowResize waiting for render complete from tid="
                java.lang.StringBuilder r5 = r5.append(r1)     // Catch:{ all -> 0x0058 }
                long r1 = r3.getId()     // Catch:{ all -> 0x0058 }
                java.lang.StringBuilder r5 = r5.append(r1)     // Catch:{ all -> 0x0058 }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0058 }
                android.util.Log.i(r4, r5)     // Catch:{ all -> 0x0058 }
                com.transparentvideo.GLTextureView$GLThreadManager r4 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x004e }
                r4.wait()     // Catch:{ InterruptedException -> 0x004e }
                goto L_0x0018
            L_0x004e:
                java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0058 }
                r4.interrupt()     // Catch:{ all -> 0x0058 }
                goto L_0x0018
            L_0x0056:
                monitor-exit(r0)     // Catch:{ all -> 0x0058 }
                return
            L_0x0058:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0058 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transparentvideo.GLTextureView.GLThread.onWindowResize(int, int):void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|19|16|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void requestExitAndWait() {
            /*
                r2 = this;
                com.transparentvideo.GLTextureView$GLThreadManager r0 = com.transparentvideo.GLTextureView.sGLThreadManager
                monitor-enter(r0)
                r1 = 1
                r2.mShouldExit = r1     // Catch:{ all -> 0x0025 }
                com.transparentvideo.GLTextureView$GLThreadManager r1 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0025 }
                r1.notifyAll()     // Catch:{ all -> 0x0025 }
            L_0x000f:
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0025 }
                if (r1 != 0) goto L_0x0023
                com.transparentvideo.GLTextureView$GLThreadManager r1 = com.transparentvideo.GLTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x001b }
                r1.wait()     // Catch:{ InterruptedException -> 0x001b }
                goto L_0x000f
            L_0x001b:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0025 }
                r1.interrupt()     // Catch:{ all -> 0x0025 }
                goto L_0x000f
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                return
            L_0x0025:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transparentvideo.GLTextureView.GLThread.requestExitAndWait():void");
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            GLTextureView.sGLThreadManager.notifyAll();
        }

        public void queueEvent(Runnable runnable) {
            if (runnable != null) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mEventQueue.add(runnable);
                    GLTextureView.sGLThreadManager.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    static class LogWriter extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        LogWriter() {
        }

        public void close() {
            flushBuilder();
        }

        public void flush() {
            flushBuilder();
        }

        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == 10) {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                Log.v(GLTextureView.TAG, this.mBuilder.toString());
                StringBuilder sb = this.mBuilder;
                sb.delete(0, sb.length());
            }
        }
    }

    private void checkRenderThreadState() {
        if (this.mGLThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private static class GLThreadManager {
        private static String TAG = "GLThreadManager";
        private static final int kGLES_20 = 131072;
        private static final String kMSM7K_RENDERER_PREFIX = "Q3Dimension MSM7500 ";
        private GLThread mEglOwner;
        private boolean mGLESDriverCheckComplete;
        private int mGLESVersion;
        private boolean mGLESVersionCheckComplete;
        private boolean mLimitedGLESContexts;
        private boolean mMultipleGLESContextsAllowed;

        private GLThreadManager() {
        }

        public synchronized void threadExiting(GLThread gLThread) {
            Log.i("GLThread", "exiting tid=" + gLThread.getId());
            boolean unused = gLThread.mExited = true;
            if (this.mEglOwner == gLThread) {
                this.mEglOwner = null;
            }
            notifyAll();
        }

        public boolean tryAcquireEglContextLocked(GLThread gLThread) {
            GLThread gLThread2 = this.mEglOwner;
            if (gLThread2 == gLThread || gLThread2 == null) {
                this.mEglOwner = gLThread;
                notifyAll();
                return true;
            }
            checkGLESVersion();
            if (this.mMultipleGLESContextsAllowed) {
                return true;
            }
            GLThread gLThread3 = this.mEglOwner;
            if (gLThread3 == null) {
                return false;
            }
            gLThread3.requestReleaseEglContextLocked();
            return false;
        }

        public void releaseEglContextLocked(GLThread gLThread) {
            if (this.mEglOwner == gLThread) {
                this.mEglOwner = null;
            }
            notifyAll();
        }

        public synchronized boolean shouldReleaseEGLContextWhenPausing() {
            return this.mLimitedGLESContexts;
        }

        public synchronized boolean shouldTerminateEGLWhenPausing() {
            checkGLESVersion();
            return !this.mMultipleGLESContextsAllowed;
        }

        public synchronized void checkGLDriver(GL10 gl10) {
            if (!this.mGLESDriverCheckComplete) {
                checkGLESVersion();
                String glGetString = gl10.glGetString(7937);
                boolean z = false;
                if (this.mGLESVersion < 131072) {
                    this.mMultipleGLESContextsAllowed = !glGetString.startsWith(kMSM7K_RENDERER_PREFIX);
                    notifyAll();
                }
                if (!this.mMultipleGLESContextsAllowed) {
                    z = true;
                }
                this.mLimitedGLESContexts = z;
                Log.w(TAG, "checkGLDriver renderer = \"" + glGetString + "\" multipleContextsAllowed = " + this.mMultipleGLESContextsAllowed + " mLimitedGLESContexts = " + this.mLimitedGLESContexts);
                this.mGLESDriverCheckComplete = true;
            }
        }

        private void checkGLESVersion() {
            if (!this.mGLESVersionCheckComplete) {
                this.mGLESVersionCheckComplete = true;
            }
        }
    }
}
