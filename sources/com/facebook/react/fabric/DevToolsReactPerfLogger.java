package com.facebook.react.fabric;

import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DevToolsReactPerfLogger implements ReactMarker.FabricMarkerListener {
    public static final LongStreamingStats mStreamingBatchExecutionStats = new LongStreamingStats();
    public static final LongStreamingStats mStreamingCommitStats = new LongStreamingStats();
    public static final LongStreamingStats mStreamingDiffStats = new LongStreamingStats();
    public static final LongStreamingStats mStreamingLayoutStats = new LongStreamingStats();
    public static final LongStreamingStats mStreamingTransactionEndStats = new LongStreamingStats();
    private final List<DevToolsReactPerfLoggerListener> mDevToolsReactPerfLoggerListeners = new ArrayList();
    private final Map<Integer, FabricCommitPoint> mFabricCommitMarkers = new HashMap();

    public interface DevToolsReactPerfLoggerListener {
        void onFabricCommitEnd(FabricCommitPoint fabricCommitPoint);
    }

    public static class FabricCommitPoint {
        private final long mCommitNumber;
        private final Map<ReactMarkerConstants, Long> mPoints;

        private FabricCommitPoint(int i) {
            this.mPoints = new HashMap();
            this.mCommitNumber = (long) i;
        }

        /* access modifiers changed from: private */
        public void addPoint(ReactMarkerConstants reactMarkerConstants, long j) {
            this.mPoints.put(reactMarkerConstants, Long.valueOf(j));
        }

        private long getValue(ReactMarkerConstants reactMarkerConstants) {
            Long l = this.mPoints.get(reactMarkerConstants);
            if (l != null) {
                return l.longValue();
            }
            return -1;
        }

        public long getCommitNumber() {
            return this.mCommitNumber;
        }

        public long getCommitStart() {
            return getValue(ReactMarkerConstants.FABRIC_COMMIT_START);
        }

        public long getCommitEnd() {
            return getValue(ReactMarkerConstants.FABRIC_COMMIT_END);
        }

        public long getFinishTransactionStart() {
            return getValue(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_START);
        }

        public long getFinishTransactionEnd() {
            return getValue(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_END);
        }

        public long getDiffStart() {
            return getValue(ReactMarkerConstants.FABRIC_DIFF_START);
        }

        public long getDiffEnd() {
            return getValue(ReactMarkerConstants.FABRIC_DIFF_END);
        }

        public long getLayoutStart() {
            return getValue(ReactMarkerConstants.FABRIC_LAYOUT_START);
        }

        public long getLayoutEnd() {
            return getValue(ReactMarkerConstants.FABRIC_LAYOUT_END);
        }

        public long getBatchExecutionStart() {
            return getValue(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_START);
        }

        public long getBatchExecutionEnd() {
            return getValue(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_END);
        }

        public long getUpdateUIMainThreadStart() {
            return getValue(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_START);
        }

        public long getUpdateUIMainThreadEnd() {
            return getValue(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END);
        }

        public long getCommitDuration() {
            return getCommitEnd() - getCommitStart();
        }

        public long getLayoutDuration() {
            return getLayoutEnd() - getLayoutStart();
        }

        public long getDiffDuration() {
            return getDiffEnd() - getDiffStart();
        }

        public long getTransactionEndDuration() {
            return getFinishTransactionEnd() - getFinishTransactionStart();
        }

        public long getBatchExecutionDuration() {
            return getBatchExecutionEnd() - getBatchExecutionStart();
        }
    }

    public void addDevToolsReactPerfLoggerListener(DevToolsReactPerfLoggerListener devToolsReactPerfLoggerListener) {
        this.mDevToolsReactPerfLoggerListeners.add(devToolsReactPerfLoggerListener);
    }

    public void removeDevToolsReactPerfLoggerListener(DevToolsReactPerfLoggerListener devToolsReactPerfLoggerListener) {
        this.mDevToolsReactPerfLoggerListeners.remove(devToolsReactPerfLoggerListener);
    }

    public void logFabricMarker(ReactMarkerConstants reactMarkerConstants, String str, int i, long j) {
        if (isFabricCommitMarker(reactMarkerConstants)) {
            FabricCommitPoint fabricCommitPoint = this.mFabricCommitMarkers.get(Integer.valueOf(i));
            if (fabricCommitPoint == null) {
                fabricCommitPoint = new FabricCommitPoint(i);
                this.mFabricCommitMarkers.put(Integer.valueOf(i), fabricCommitPoint);
            }
            fabricCommitPoint.addPoint(reactMarkerConstants, j);
            if (reactMarkerConstants == ReactMarkerConstants.FABRIC_BATCH_EXECUTION_END) {
                onFabricCommitEnd(fabricCommitPoint);
                this.mFabricCommitMarkers.remove(Integer.valueOf(i));
            }
        }
    }

    private void onFabricCommitEnd(FabricCommitPoint fabricCommitPoint) {
        for (DevToolsReactPerfLoggerListener onFabricCommitEnd : this.mDevToolsReactPerfLoggerListeners) {
            onFabricCommitEnd.onFabricCommitEnd(fabricCommitPoint);
        }
    }

    private static boolean isFabricCommitMarker(ReactMarkerConstants reactMarkerConstants) {
        return reactMarkerConstants == ReactMarkerConstants.FABRIC_COMMIT_START || reactMarkerConstants == ReactMarkerConstants.FABRIC_COMMIT_END || reactMarkerConstants == ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_START || reactMarkerConstants == ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_END || reactMarkerConstants == ReactMarkerConstants.FABRIC_DIFF_START || reactMarkerConstants == ReactMarkerConstants.FABRIC_DIFF_END || reactMarkerConstants == ReactMarkerConstants.FABRIC_LAYOUT_START || reactMarkerConstants == ReactMarkerConstants.FABRIC_LAYOUT_END || reactMarkerConstants == ReactMarkerConstants.FABRIC_BATCH_EXECUTION_START || reactMarkerConstants == ReactMarkerConstants.FABRIC_BATCH_EXECUTION_END || reactMarkerConstants == ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_START || reactMarkerConstants == ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END;
    }
}
