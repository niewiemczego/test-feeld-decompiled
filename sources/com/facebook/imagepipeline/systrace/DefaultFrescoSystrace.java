package com.facebook.imagepipeline.systrace;

import android.os.Build;
import android.os.Trace;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

public class DefaultFrescoSystrace implements FrescoSystrace.Systrace {
    public void beginSection(String str) {
    }

    public void endSection() {
    }

    public boolean isTracing() {
        return false;
    }

    public FrescoSystrace.ArgsBuilder beginSectionWithArgs(String str) {
        return FrescoSystrace.NO_OP_ARGS_BUILDER;
    }

    private static final class DefaultArgsBuilder implements FrescoSystrace.ArgsBuilder {
        private final StringBuilder mStringBuilder;

        public DefaultArgsBuilder(String str) {
            this.mStringBuilder = new StringBuilder(str);
        }

        public void flush() {
            if (this.mStringBuilder.length() > 127) {
                this.mStringBuilder.setLength(127);
            }
            if (Build.VERSION.SDK_INT >= 18) {
                Trace.beginSection(this.mStringBuilder.toString());
            }
        }

        public FrescoSystrace.ArgsBuilder arg(String str, Object obj) {
            String str2;
            StringBuilder append = this.mStringBuilder.append(';').append(str).append('=');
            if (obj == null) {
                str2 = "null";
            } else {
                str2 = obj.toString();
            }
            append.append(str2);
            return this;
        }

        public FrescoSystrace.ArgsBuilder arg(String str, int i) {
            this.mStringBuilder.append(';').append(str).append('=').append(Integer.toString(i));
            return this;
        }

        public FrescoSystrace.ArgsBuilder arg(String str, long j) {
            this.mStringBuilder.append(';').append(str).append('=').append(Long.toString(j));
            return this;
        }

        public FrescoSystrace.ArgsBuilder arg(String str, double d) {
            this.mStringBuilder.append(';').append(str).append('=').append(Double.toString(d));
            return this;
        }
    }
}
