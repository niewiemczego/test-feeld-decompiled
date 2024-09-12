package com.facebook.systrace;

import java.util.ArrayList;
import java.util.List;

public final class SystraceMessage {
    public static Boolean INCLUDE_ARGS = false;

    public static abstract class Builder {
        public abstract Builder arg(String str, double d);

        public abstract Builder arg(String str, int i);

        public abstract Builder arg(String str, long j);

        public abstract Builder arg(String str, Object obj);

        public abstract void flush();
    }

    public static Builder beginSection(long j, String str) {
        return new StartSectionBuilder(j, str);
    }

    public static Builder endSection(long j) {
        return new EndSectionBuilder(j);
    }

    private static class StartSectionBuilder extends Builder {
        private List<String> mArgs = new ArrayList();
        private String mSectionName;
        private long mTag;

        public StartSectionBuilder(long j, String str) {
            this.mTag = j;
            this.mSectionName = str;
        }

        public void flush() {
            Systrace.beginSection(this.mTag, this.mSectionName + ((!SystraceMessage.INCLUDE_ARGS.booleanValue() || this.mArgs.size() <= 0) ? "" : " (" + String.join(", ", this.mArgs) + ")"));
        }

        public Builder arg(String str, Object obj) {
            addArg(str, String.valueOf(obj));
            return this;
        }

        public Builder arg(String str, int i) {
            addArg(str, String.valueOf(i));
            return this;
        }

        public Builder arg(String str, long j) {
            addArg(str, String.valueOf(j));
            return this;
        }

        public Builder arg(String str, double d) {
            addArg(str, String.valueOf(d));
            return this;
        }

        private void addArg(String str, String str2) {
            this.mArgs.add(str + ": " + str2);
        }
    }

    private static class EndSectionBuilder extends Builder {
        private long mTag;

        public Builder arg(String str, double d) {
            return this;
        }

        public Builder arg(String str, int i) {
            return this;
        }

        public Builder arg(String str, long j) {
            return this;
        }

        public Builder arg(String str, Object obj) {
            return this;
        }

        public EndSectionBuilder(long j) {
            this.mTag = j;
        }

        public void flush() {
            Systrace.endSection(this.mTag);
        }
    }
}
