package com.google.android.exoplayer2.util;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLU;
import androidx.work.Data;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;

public final class GlUtil {
    private static final int[] EGL_CONFIG_ATTRIBUTES_RGBA_1010102 = {12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344};
    private static final int[] EGL_CONFIG_ATTRIBUTES_RGBA_8888 = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
    private static final int EGL_GL_COLORSPACE_BT2020_PQ_EXT = 13120;
    private static final int EGL_GL_COLORSPACE_KHR = 12445;
    private static final int[] EGL_WINDOW_SURFACE_ATTRIBUTES_BT2020_PQ = {EGL_GL_COLORSPACE_KHR, EGL_GL_COLORSPACE_BT2020_PQ_EXT, 12344};
    private static final int[] EGL_WINDOW_SURFACE_ATTRIBUTES_NONE = {12344};
    private static final String EXTENSION_PROTECTED_CONTENT = "EGL_EXT_protected_content";
    private static final String EXTENSION_SURFACELESS_CONTEXT = "EGL_KHR_surfaceless_context";
    public static final int HOMOGENEOUS_COORDINATE_VECTOR_SIZE = 4;
    public static final float LENGTH_NDC = 2.0f;
    private static final String TAG = "GlUtil";
    public static boolean glAssertionsEnabled = false;

    public static final class GlException extends RuntimeException {
        public GlException(String str) {
            super(str);
        }
    }

    private GlUtil() {
    }

    public static float[] getNormalizedCoordinateBounds() {
        return new float[]{-1.0f, -1.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    }

    public static float[] getTextureCoordinateBounds() {
        return new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    }

    public static float[] createVertexBuffer(List<float[]> list) {
        float[] fArr = new float[(list.size() * 4)];
        for (int i = 0; i < list.size(); i++) {
            System.arraycopy(list.get(i), 0, fArr, i * 4, 4);
        }
        return fArr;
    }

    public static boolean isProtectedContentExtensionSupported(Context context) {
        String eglQueryString;
        if (Util.SDK_INT < 24) {
            return false;
        }
        if (Util.SDK_INT < 26 && ("samsung".equals(Util.MANUFACTURER) || "XT1650".equals(Util.MODEL))) {
            return false;
        }
        if ((Util.SDK_INT >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains(EXTENSION_PROTECTED_CONTENT)) {
            return true;
        }
        return false;
    }

    public static boolean isSurfacelessContextExtensionSupported() {
        String eglQueryString;
        if (Util.SDK_INT >= 17 && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains(EXTENSION_SURFACELESS_CONTEXT)) {
            return true;
        }
        return false;
    }

    public static EGLDisplay createEglDisplay() {
        return Api17.createEglDisplay();
    }

    public static EGLContext createEglContext(EGLDisplay eGLDisplay) {
        return Api17.createEglContext(eGLDisplay, 2, EGL_CONFIG_ATTRIBUTES_RGBA_8888);
    }

    public static EGLContext createEglContextEs3Rgba1010102(EGLDisplay eGLDisplay) {
        return Api17.createEglContext(eGLDisplay, 3, EGL_CONFIG_ATTRIBUTES_RGBA_1010102);
    }

    public static EGLSurface getEglSurface(EGLDisplay eGLDisplay, Object obj) {
        return Api17.getEglSurface(eGLDisplay, obj, EGL_CONFIG_ATTRIBUTES_RGBA_8888, EGL_WINDOW_SURFACE_ATTRIBUTES_NONE);
    }

    public static EGLSurface getEglSurfaceBt2020Pq(EGLDisplay eGLDisplay, Object obj) {
        return Api17.getEglSurface(eGLDisplay, obj, EGL_CONFIG_ATTRIBUTES_RGBA_1010102, EGL_WINDOW_SURFACE_ATTRIBUTES_BT2020_PQ);
    }

    private static EGLSurface createPbufferSurface(EGLDisplay eGLDisplay, int i, int i2) {
        return Api17.createEglPbufferSurface(eGLDisplay, EGL_CONFIG_ATTRIBUTES_RGBA_8888, new int[]{12375, i, 12374, i2, 12344});
    }

    public static EGLSurface createPlaceholderEglSurface(EGLDisplay eGLDisplay) {
        if (isSurfacelessContextExtensionSupported()) {
            return EGL14.EGL_NO_SURFACE;
        }
        return createPbufferSurface(eGLDisplay, 1, 1);
    }

    public static void focusPlaceholderEglSurface(EGLContext eGLContext, EGLDisplay eGLDisplay) {
        focusEglSurface(eGLDisplay, eGLContext, createPbufferSurface(eGLDisplay, 1, 1), 1, 1);
    }

    public static void focusPlaceholderEglSurfaceBt2020Pq(EGLContext eGLContext, EGLDisplay eGLDisplay) {
        focusEglSurface(eGLDisplay, eGLContext, Api17.createEglPbufferSurface(eGLDisplay, EGL_CONFIG_ATTRIBUTES_RGBA_1010102, new int[]{12375, 1, 12374, 1, EGL_GL_COLORSPACE_KHR, EGL_GL_COLORSPACE_BT2020_PQ_EXT, 12344}), 1, 1);
    }

    public static void checkGlError() {
        int i = 0;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                break;
            }
            Log.e(TAG, "glError: " + GLU.gluErrorString(glGetError));
            i = glGetError;
        }
        if (i != 0) {
            throwGlException("glError: " + GLU.gluErrorString(i));
        }
    }

    public static void assertValidTextureSize(int i, int i2) {
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(3379, iArr, 0);
        int i3 = iArr[0];
        if (i < 0 || i2 < 0) {
            throwGlException("width or height is less than 0");
        }
        if (i > i3 || i2 > i3) {
            throwGlException("width or height is greater than GL_MAX_TEXTURE_SIZE " + i3);
        }
    }

    public static void focusEglSurface(EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, int i, int i2) {
        Api17.focusRenderTarget(eGLDisplay, eGLContext, eGLSurface, 0, i, i2);
    }

    public static void focusFramebuffer(EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, int i, int i2, int i3) {
        Api17.focusRenderTarget(eGLDisplay, eGLContext, eGLSurface, i, i2, i3);
    }

    public static void deleteTexture(int i) {
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
        checkGlError();
    }

    public static void destroyEglContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        Api17.destroyEglContext(eGLDisplay, eGLContext);
    }

    public static FloatBuffer createBuffer(float[] fArr) {
        return (FloatBuffer) createBuffer(fArr.length).put(fArr).flip();
    }

    public static FloatBuffer createBuffer(int i) {
        return ByteBuffer.allocateDirect(i * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static String loadAsset(Context context, String str) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            return Util.fromUtf8Bytes(Util.toByteArray(inputStream));
        } finally {
            Util.closeQuietly(inputStream);
        }
    }

    public static int createExternalTexture() {
        int generateTexture = generateTexture();
        bindTexture(36197, generateTexture);
        return generateTexture;
    }

    public static int createTexture(int i, int i2) {
        assertValidTextureSize(i, i2);
        int generateTexture = generateTexture();
        bindTexture(3553, generateTexture);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, ByteBuffer.allocateDirect(i * i2 * 4));
        checkGlError();
        return generateTexture;
    }

    private static int generateTexture() {
        checkEglException(!Util.areEqual(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT), "No current context");
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        checkGlError();
        return iArr[0];
    }

    public static void bindTexture(int i, int i2) {
        GLES20.glBindTexture(i, i2);
        checkGlError();
        GLES20.glTexParameteri(i, Data.MAX_DATA_BYTES, 9729);
        checkGlError();
        GLES20.glTexParameteri(i, 10241, 9729);
        checkGlError();
        GLES20.glTexParameteri(i, 10242, 33071);
        checkGlError();
        GLES20.glTexParameteri(i, 10243, 33071);
        checkGlError();
    }

    public static int createFboForTexture(int i) {
        checkEglException(!Util.areEqual(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT), "No current context");
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        checkGlError();
        GLES20.glBindFramebuffer(36160, iArr[0]);
        checkGlError();
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        checkGlError();
        return iArr[0];
    }

    static void throwGlException(String str) {
        if (!glAssertionsEnabled) {
            Log.e(TAG, str);
            return;
        }
        throw new GlException(str);
    }

    /* access modifiers changed from: private */
    public static void checkEglException(boolean z, String str) {
        if (!z) {
            throwGlException(str);
        }
    }

    /* access modifiers changed from: private */
    public static void checkEglException(String str) {
        int eglGetError = EGL14.eglGetError();
        checkEglException(eglGetError == 12288, str + ", error code: " + eglGetError);
    }

    private static final class Api17 {
        private Api17() {
        }

        public static EGLDisplay createEglDisplay() {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            GlUtil.checkEglException(!eglGetDisplay.equals(EGL14.EGL_NO_DISPLAY), "No EGL display.");
            if (!EGL14.eglInitialize(eglGetDisplay, new int[1], 0, new int[1], 0)) {
                GlUtil.throwGlException("Error in eglInitialize.");
            }
            GlUtil.checkGlError();
            return eglGetDisplay;
        }

        public static EGLContext createEglContext(EGLDisplay eGLDisplay, int i, int[] iArr) {
            EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, getEglConfig(eGLDisplay, iArr), EGL14.EGL_NO_CONTEXT, new int[]{12440, i, 12344}, 0);
            if (eglCreateContext == null) {
                EGL14.eglTerminate(eGLDisplay);
                GlUtil.throwGlException("eglCreateContext() failed to create a valid context. The device may not support EGL version " + i);
            }
            GlUtil.checkGlError();
            return eglCreateContext;
        }

        public static EGLSurface getEglSurface(EGLDisplay eGLDisplay, Object obj, int[] iArr, int[] iArr2) {
            EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay, getEglConfig(eGLDisplay, iArr), obj, iArr2, 0);
            GlUtil.checkEglException("Error creating surface");
            return eglCreateWindowSurface;
        }

        public static EGLSurface createEglPbufferSurface(EGLDisplay eGLDisplay, int[] iArr, int[] iArr2) {
            EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, getEglConfig(eGLDisplay, iArr), iArr2, 0);
            GlUtil.checkEglException("Error creating surface");
            return eglCreatePbufferSurface;
        }

        public static void focusRenderTarget(EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, int i, int i2, int i3) {
            int[] iArr = new int[1];
            GLES20.glGetIntegerv(36006, iArr, 0);
            if (iArr[0] != i) {
                GLES20.glBindFramebuffer(36160, i);
            }
            GlUtil.checkGlError();
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
            GlUtil.checkEglException("Error making context current");
            GLES20.glViewport(0, 0, i2, i3);
            GlUtil.checkGlError();
        }

        public static void destroyEglContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (eGLDisplay != null) {
                EGL14.eglMakeCurrent(eGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                GlUtil.checkEglException("Error releasing context");
                if (eGLContext != null) {
                    EGL14.eglDestroyContext(eGLDisplay, eGLContext);
                    GlUtil.checkEglException("Error destroying context");
                }
                EGL14.eglReleaseThread();
                GlUtil.checkEglException("Error releasing thread");
                EGL14.eglTerminate(eGLDisplay);
                GlUtil.checkEglException("Error terminating display");
            }
        }

        private static EGLConfig getEglConfig(EGLDisplay eGLDisplay, int[] iArr) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!EGL14.eglChooseConfig(eGLDisplay, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                GlUtil.throwGlException("eglChooseConfig failed.");
            }
            return eGLConfigArr[0];
        }
    }
}
