package com.google.android.exoplayer2.util;

import android.content.Context;
import android.opengl.GLES20;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

public final class GlProgram {
    private static final int GL_SAMPLER_EXTERNAL_2D_Y2Y_EXT = 35815;
    private final Map<String, Attribute> attributeByName;
    private final Attribute[] attributes;
    private final int programId;
    private final Map<String, Uniform> uniformByName;
    private final Uniform[] uniforms;

    public GlProgram(Context context, String str, String str2) throws IOException {
        this(GlUtil.loadAsset(context, str), GlUtil.loadAsset(context, str2));
    }

    public GlProgram(String str, String str2) {
        int glCreateProgram = GLES20.glCreateProgram();
        this.programId = glCreateProgram;
        GlUtil.checkGlError();
        addShader(glCreateProgram, 35633, str);
        addShader(glCreateProgram, 35632, str2);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            GlUtil.throwGlException("Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(glCreateProgram));
        }
        GLES20.glUseProgram(glCreateProgram);
        this.attributeByName = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35721, iArr2, 0);
        this.attributes = new Attribute[iArr2[0]];
        for (int i = 0; i < iArr2[0]; i++) {
            Attribute create = Attribute.create(this.programId, i);
            this.attributes[i] = create;
            this.attributeByName.put(create.name, create);
        }
        this.uniformByName = new HashMap();
        int[] iArr3 = new int[1];
        GLES20.glGetProgramiv(this.programId, 35718, iArr3, 0);
        this.uniforms = new Uniform[iArr3[0]];
        for (int i2 = 0; i2 < iArr3[0]; i2++) {
            Uniform create2 = Uniform.create(this.programId, i2);
            this.uniforms[i2] = create2;
            this.uniformByName.put(create2.name, create2);
        }
        GlUtil.checkGlError();
    }

    private static void addShader(int i, int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            GlUtil.throwGlException(GLES20.glGetShaderInfoLog(glCreateShader) + ", source: " + str);
        }
        GLES20.glAttachShader(i, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        GlUtil.checkGlError();
    }

    /* access modifiers changed from: private */
    public static int getAttributeLocation(int i, String str) {
        return GLES20.glGetAttribLocation(i, str);
    }

    private int getAttributeLocation(String str) {
        return getAttributeLocation(this.programId, str);
    }

    /* access modifiers changed from: private */
    public static int getUniformLocation(int i, String str) {
        return GLES20.glGetUniformLocation(i, str);
    }

    public int getUniformLocation(String str) {
        return getUniformLocation(this.programId, str);
    }

    public void use() {
        GLES20.glUseProgram(this.programId);
        GlUtil.checkGlError();
    }

    public void delete() {
        GLES20.glDeleteProgram(this.programId);
        GlUtil.checkGlError();
    }

    public int getAttributeArrayLocationAndEnable(String str) {
        int attributeLocation = getAttributeLocation(str);
        GLES20.glEnableVertexAttribArray(attributeLocation);
        GlUtil.checkGlError();
        return attributeLocation;
    }

    public void setBufferAttribute(String str, float[] fArr, int i) {
        ((Attribute) Assertions.checkNotNull(this.attributeByName.get(str))).setBuffer(fArr, i);
    }

    public void setSamplerTexIdUniform(String str, int i, int i2) {
        ((Uniform) Assertions.checkNotNull(this.uniformByName.get(str))).setSamplerTexId(i, i2);
    }

    public void setFloatUniform(String str, float f) {
        ((Uniform) Assertions.checkNotNull(this.uniformByName.get(str))).setFloat(f);
    }

    public void setFloatsUniform(String str, float[] fArr) {
        ((Uniform) Assertions.checkNotNull(this.uniformByName.get(str))).setFloats(fArr);
    }

    public void bindAttributesAndUniforms() {
        for (Attribute bind : this.attributes) {
            bind.bind();
        }
        for (Uniform bind2 : this.uniforms) {
            bind2.bind();
        }
    }

    /* access modifiers changed from: private */
    public static int getCStringLength(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] == 0) {
                return i;
            }
        }
        return bArr.length;
    }

    private static final class Attribute {
        private Buffer buffer;
        private final int index;
        private final int location;
        public final String name;
        private int size;

        public static Attribute create(int i, int i2) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i, 35722, iArr, 0);
            int i3 = iArr[0];
            byte[] bArr = new byte[i3];
            GLES20.glGetActiveAttrib(i, i2, i3, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, GlProgram.getCStringLength(bArr));
            return new Attribute(str, i2, GlProgram.getAttributeLocation(i, str));
        }

        private Attribute(String str, int i, int i2) {
            this.name = str;
            this.index = i;
            this.location = i2;
        }

        public void setBuffer(float[] fArr, int i) {
            this.buffer = GlUtil.createBuffer(fArr);
            this.size = i;
        }

        public void bind() {
            GLES20.glBindBuffer(34962, 0);
            GLES20.glVertexAttribPointer(this.location, this.size, 5126, false, 0, (Buffer) Assertions.checkNotNull(this.buffer, "call setBuffer before bind"));
            GLES20.glEnableVertexAttribArray(this.index);
            GlUtil.checkGlError();
        }
    }

    private static final class Uniform {
        private final int location;
        public final String name;
        private int texId;
        private int texUnitIndex;
        private final int type;
        private final float[] value = new float[16];

        public static Uniform create(int i, int i2) {
            int i3 = i;
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            int i4 = iArr[0];
            byte[] bArr = new byte[i4];
            GLES20.glGetActiveUniform(i, i2, i4, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, GlProgram.getCStringLength(bArr));
            return new Uniform(str, GlProgram.getUniformLocation(i, str), iArr2[0]);
        }

        private Uniform(String str, int i, int i2) {
            this.name = str;
            this.location = i;
            this.type = i2;
        }

        public void setSamplerTexId(int i, int i2) {
            this.texId = i;
            this.texUnitIndex = i2;
        }

        public void setFloat(float f) {
            this.value[0] = f;
        }

        public void setFloats(float[] fArr) {
            System.arraycopy(fArr, 0, this.value, 0, fArr.length);
        }

        public void bind() {
            switch (this.type) {
                case 5126:
                    GLES20.glUniform1fv(this.location, 1, this.value, 0);
                    GlUtil.checkGlError();
                    return;
                case 35664:
                    GLES20.glUniform2fv(this.location, 1, this.value, 0);
                    GlUtil.checkGlError();
                    return;
                case 35665:
                    GLES20.glUniform3fv(this.location, 1, this.value, 0);
                    GlUtil.checkGlError();
                    return;
                case 35675:
                    GLES20.glUniformMatrix3fv(this.location, 1, false, this.value, 0);
                    GlUtil.checkGlError();
                    return;
                case 35676:
                    GLES20.glUniformMatrix4fv(this.location, 1, false, this.value, 0);
                    GlUtil.checkGlError();
                    return;
                case 35678:
                case GlProgram.GL_SAMPLER_EXTERNAL_2D_Y2Y_EXT /*35815*/:
                case 36198:
                    if (this.texId != 0) {
                        GLES20.glActiveTexture(this.texUnitIndex + 33984);
                        GlUtil.checkGlError();
                        GlUtil.bindTexture(this.type == 35678 ? 3553 : 36197, this.texId);
                        GLES20.glUniform1i(this.location, this.texUnitIndex);
                        GlUtil.checkGlError();
                        return;
                    }
                    throw new IllegalStateException("No call to setSamplerTexId() before bind.");
                default:
                    throw new IllegalStateException("Unexpected uniform type: " + this.type);
            }
        }
    }
}
