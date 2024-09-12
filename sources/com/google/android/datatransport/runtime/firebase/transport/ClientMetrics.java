package com.google.android.datatransport.runtime.firebase.transport;

import com.google.android.datatransport.runtime.ProtoEncoderDoNotUse;
import com.google.firebase.encoders.annotations.Encodable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ClientMetrics {
    private static final ClientMetrics DEFAULT_INSTANCE = new Builder().build();
    private final String app_namespace_;
    private final GlobalMetrics global_metrics_;
    private final List<LogSourceMetrics> log_source_metrics_;
    private final TimeWindow window_;

    ClientMetrics(TimeWindow timeWindow, List<LogSourceMetrics> list, GlobalMetrics globalMetrics, String str) {
        this.window_ = timeWindow;
        this.log_source_metrics_ = list;
        this.global_metrics_ = globalMetrics;
        this.app_namespace_ = str;
    }

    public byte[] toByteArray() {
        return ProtoEncoderDoNotUse.encode(this);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        ProtoEncoderDoNotUse.encode(this, outputStream);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Encodable.Ignore
    public TimeWindow getWindow() {
        TimeWindow timeWindow = this.window_;
        return timeWindow == null ? TimeWindow.getDefaultInstance() : timeWindow;
    }

    @Encodable.Field(name = "window")
    public TimeWindow getWindowInternal() {
        return this.window_;
    }

    @Encodable.Field(name = "logSourceMetrics")
    public List<LogSourceMetrics> getLogSourceMetricsList() {
        return this.log_source_metrics_;
    }

    @Encodable.Ignore
    public GlobalMetrics getGlobalMetrics() {
        GlobalMetrics globalMetrics = this.global_metrics_;
        return globalMetrics == null ? GlobalMetrics.getDefaultInstance() : globalMetrics;
    }

    @Encodable.Field(name = "globalMetrics")
    public GlobalMetrics getGlobalMetricsInternal() {
        return this.global_metrics_;
    }

    public String getAppNamespace() {
        return this.app_namespace_;
    }

    public static ClientMetrics getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder {
        private String app_namespace_ = "";
        private GlobalMetrics global_metrics_ = null;
        private List<LogSourceMetrics> log_source_metrics_ = new ArrayList();
        private TimeWindow window_ = null;

        Builder() {
        }

        public ClientMetrics build() {
            return new ClientMetrics(this.window_, Collections.unmodifiableList(this.log_source_metrics_), this.global_metrics_, this.app_namespace_);
        }

        public Builder setWindow(TimeWindow timeWindow) {
            this.window_ = timeWindow;
            return this;
        }

        public Builder addLogSourceMetrics(LogSourceMetrics logSourceMetrics) {
            this.log_source_metrics_.add(logSourceMetrics);
            return this;
        }

        public Builder setLogSourceMetricsList(List<LogSourceMetrics> list) {
            this.log_source_metrics_ = list;
            return this;
        }

        public Builder setGlobalMetrics(GlobalMetrics globalMetrics) {
            this.global_metrics_ = globalMetrics;
            return this;
        }

        public Builder setAppNamespace(String str) {
            this.app_namespace_ = str;
            return this;
        }
    }
}
