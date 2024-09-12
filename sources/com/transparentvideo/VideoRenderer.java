package com.transparentvideo;

import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import android.view.Surface;
import androidx.work.Data;
import com.facebook.internal.security.CertificateUtil;
import com.transparentvideo.GLTextureView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Locale;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class VideoRenderer implements GLTextureView.Renderer, SurfaceTexture.OnFrameAvailableListener {
    private static final int COLOR_MAX_VALUE = 255;
    private static final int FLOAT_SIZE_BYTES = 4;
    private static int GL_TEXTURE_EXTERNAL_OES = 36197;
    private static String TAG = "VideoRender";
    private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
    private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 20;
    private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 3;
    private int aPositionHandle;
    private int aTextureHandle;
    private double accuracy = 0.95d;
    private final String alphaPackedShader = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvarying mediump float text_alpha_out;\nvoid main() {\n  vec4 color = texture2D(sTexture, vec2(vTextureCoord.x, vTextureCoord.y / 2.0));\n  float alpha = texture2D(sTexture, vec2(vTextureCoord.x, 0.5 + vTextureCoord.y / 2.0)).r;\n  float flooredAlpha = alpha <= 0.1 ? 0.0 : alpha;\n  gl_FragColor = vec4(color.rgb, flooredAlpha);\n}\n";
    private final String alphaShader = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvarying mediump float text_alpha_out;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float red = %f;\n  float green = %f;\n  float blue = %f;\n  float accuracy = %f;\n  if (abs(color.r - red) <= accuracy && abs(color.g - green) <= accuracy && abs(color.b - blue) <= accuracy) {\n      gl_FragColor = vec4(color.r, color.g, color.b, 0.0);\n  } else {\n      gl_FragColor = vec4(color.r, color.g, color.b, 1.0);\n  }\n}\n";
    private float blueParam = 0.0f;
    private float greenParam = 1.0f;
    private boolean isCustom;
    private boolean isPacked;
    private float[] mVPMatrix = new float[16];
    private OnSurfacePrepareListener onSurfacePrepareListener;
    private int program;
    private float redParam = 0.0f;
    private float[] sTMatrix = new float[16];
    private String shader = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvarying mediump float text_alpha_out;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float red = %f;\n  float green = %f;\n  float blue = %f;\n  float accuracy = %f;\n  if (abs(color.r - red) <= accuracy && abs(color.g - green) <= accuracy && abs(color.b - blue) <= accuracy) {\n      gl_FragColor = vec4(color.r, color.g, color.b, 0.0);\n  } else {\n      gl_FragColor = vec4(color.r, color.g, color.b, 1.0);\n  }\n}\n";
    private SurfaceTexture surface;
    private int textureID;
    private FloatBuffer triangleVertices;
    private final float[] triangleVerticesData;
    private int uMVPMatrixHandle;
    private int uSTMatrixHandle;
    private boolean updateShader = false;
    private boolean updateSurface = false;
    private final String vertexShader = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";

    interface OnSurfacePrepareListener {
        void surfacePrepared(Surface surface);
    }

    VideoRenderer() {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.triangleVerticesData = fArr;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.triangleVertices = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(this.sTMatrix, 0);
    }

    public void onDrawFrame(GL10 gl10) {
        synchronized (this) {
            if (this.updateSurface) {
                this.surface.updateTexImage();
                this.surface.getTransformMatrix(this.sTMatrix);
                this.updateSurface = false;
            }
            if (this.updateShader) {
                initializeShader();
                this.updateShader = false;
            }
        }
        GLES20.glClear(16640);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glUseProgram(this.program);
        checkGlError("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GL_TEXTURE_EXTERNAL_OES, this.textureID);
        this.triangleVertices.position(0);
        GLES20.glVertexAttribPointer(this.aPositionHandle, 3, 5126, false, 20, this.triangleVertices);
        checkGlError("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.aPositionHandle);
        checkGlError("glEnableVertexAttribArray aPositionHandle");
        this.triangleVertices.position(3);
        GLES20.glVertexAttribPointer(this.aTextureHandle, 3, 5126, false, 20, this.triangleVertices);
        checkGlError("glVertexAttribPointer aTextureHandle");
        GLES20.glEnableVertexAttribArray(this.aTextureHandle);
        checkGlError("glEnableVertexAttribArray aTextureHandle");
        Matrix.setIdentityM(this.mVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.uMVPMatrixHandle, 1, false, this.mVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.uSTMatrixHandle, 1, false, this.sTMatrix, 0);
        GLES20.glDrawArrays(5, 0, 4);
        checkGlError("glDrawArrays");
        GLES20.glFinish();
    }

    public void onSurfaceDestroyed(GL10 gl10) {
        GLES20.glDeleteProgram(this.program);
        GLES20.glDeleteTextures(1, new int[]{this.textureID}, 0);
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        if (initializeShader()) {
            prepareSurface();
        }
    }

    public boolean initializeShader() {
        int createProgram = createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", resolveShader());
        this.program = createProgram;
        if (createProgram == 0) {
            return false;
        }
        this.aPositionHandle = GLES20.glGetAttribLocation(createProgram, "aPosition");
        checkGlError("glGetAttribLocation aPosition");
        if (this.aPositionHandle != -1) {
            this.aTextureHandle = GLES20.glGetAttribLocation(this.program, "aTextureCoord");
            checkGlError("glGetAttribLocation aTextureCoord");
            if (this.aTextureHandle != -1) {
                this.uMVPMatrixHandle = GLES20.glGetUniformLocation(this.program, "uMVPMatrix");
                checkGlError("glGetUniformLocation uMVPMatrix");
                if (this.uMVPMatrixHandle != -1) {
                    this.uSTMatrixHandle = GLES20.glGetUniformLocation(this.program, "uSTMatrix");
                    checkGlError("glGetUniformLocation uSTMatrix");
                    if (this.uSTMatrixHandle != -1) {
                        return true;
                    }
                    throw new RuntimeException("Could not get attrib location for uSTMatrix");
                }
                throw new RuntimeException("Could not get attrib location for uMVPMatrix");
            }
            throw new RuntimeException("Could not get attrib location for aTextureCoord");
        }
        throw new RuntimeException("Could not get attrib location for aPosition");
    }

    private void prepareSurface() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        this.textureID = i;
        GLES20.glBindTexture(GL_TEXTURE_EXTERNAL_OES, i);
        checkGlError("glBindTexture textureID");
        GLES20.glTexParameterf(GL_TEXTURE_EXTERNAL_OES, 10241, 9728.0f);
        GLES20.glTexParameterf(GL_TEXTURE_EXTERNAL_OES, Data.MAX_DATA_BYTES, 9729.0f);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.textureID);
        this.surface = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.onSurfacePrepareListener.surfacePrepared(new Surface(this.surface));
        synchronized (this) {
            this.updateSurface = false;
        }
    }

    public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.updateSurface = true;
    }

    public synchronized void refreshShader() {
        this.updateShader = true;
    }

    private int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e(TAG, "Could not compile shader " + i + CertificateUtil.DELIMITER);
        Log.e(TAG, GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    private int createProgram(String str, String str2) {
        int loadShader;
        int loadShader2 = loadShader(35633, str);
        if (loadShader2 == 0 || (loadShader = loadShader(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            checkGlError("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, loadShader);
            checkGlError("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                Log.e(TAG, "Could not link program: ");
                Log.e(TAG, GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
        }
        return glCreateProgram;
    }

    /* access modifiers changed from: package-private */
    public void setAlphaColor(int i) {
        this.redParam = ((float) Color.red(i)) / 255.0f;
        this.greenParam = ((float) Color.green(i)) / 255.0f;
        this.blueParam = ((float) Color.blue(i)) / 255.0f;
    }

    /* access modifiers changed from: package-private */
    public void setCustomShader(String str) {
        this.isCustom = true;
        this.shader = str;
    }

    /* access modifiers changed from: package-private */
    public void setPacked(boolean z) {
        this.isPacked = z;
    }

    /* access modifiers changed from: package-private */
    public void setAccuracy(double d) {
        if (d > 1.0d) {
            d = 1.0d;
        } else if (d < 0.0d) {
            d = 0.0d;
        }
        this.accuracy = d;
    }

    public double getAccuracy() {
        return this.accuracy;
    }

    private String resolveShader() {
        if (this.isCustom) {
            return this.shader;
        }
        if (this.isPacked) {
            return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvarying mediump float text_alpha_out;\nvoid main() {\n  vec4 color = texture2D(sTexture, vec2(vTextureCoord.x, vTextureCoord.y / 2.0));\n  float alpha = texture2D(sTexture, vec2(vTextureCoord.x, 0.5 + vTextureCoord.y / 2.0)).r;\n  float flooredAlpha = alpha <= 0.1 ? 0.0 : alpha;\n  gl_FragColor = vec4(color.rgb, flooredAlpha);\n}\n";
        }
        return String.format(Locale.ENGLISH, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvarying mediump float text_alpha_out;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float red = %f;\n  float green = %f;\n  float blue = %f;\n  float accuracy = %f;\n  if (abs(color.r - red) <= accuracy && abs(color.g - green) <= accuracy && abs(color.b - blue) <= accuracy) {\n      gl_FragColor = vec4(color.r, color.g, color.b, 0.0);\n  } else {\n      gl_FragColor = vec4(color.r, color.g, color.b, 1.0);\n  }\n}\n", new Object[]{Float.valueOf(this.redParam), Float.valueOf(this.greenParam), Float.valueOf(this.blueParam), Double.valueOf(1.0d - this.accuracy)});
    }

    private void checkGlError(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e(TAG, str + ": glError " + glGetError);
            throw new RuntimeException(str + ": glError " + glGetError);
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnSurfacePrepareListener(OnSurfacePrepareListener onSurfacePrepareListener2) {
        this.onSurfacePrepareListener = onSurfacePrepareListener2;
    }
}
