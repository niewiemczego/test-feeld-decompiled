package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public interface MediaSourceEventListener {
    void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
    }

    void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
    }

    void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
    }

    public static class EventDispatcher {
        private final CopyOnWriteArrayList<ListenerAndHandler> listenerAndHandlers;
        public final MediaSource.MediaPeriodId mediaPeriodId;
        private final long mediaTimeOffsetMs;
        public final int windowIndex;

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, (MediaSource.MediaPeriodId) null, 0);
        }

        private EventDispatcher(CopyOnWriteArrayList<ListenerAndHandler> copyOnWriteArrayList, int i, MediaSource.MediaPeriodId mediaPeriodId2, long j) {
            this.listenerAndHandlers = copyOnWriteArrayList;
            this.windowIndex = i;
            this.mediaPeriodId = mediaPeriodId2;
            this.mediaTimeOffsetMs = j;
        }

        public EventDispatcher withParameters(int i, MediaSource.MediaPeriodId mediaPeriodId2, long j) {
            return new EventDispatcher(this.listenerAndHandlers, i, mediaPeriodId2, j);
        }

        public void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            Assertions.checkNotNull(handler);
            Assertions.checkNotNull(mediaSourceEventListener);
            this.listenerAndHandlers.add(new ListenerAndHandler(handler, mediaSourceEventListener));
        }

        public void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                if (next.listener == mediaSourceEventListener) {
                    this.listenerAndHandlers.remove(next);
                }
            }
        }

        public void loadStarted(LoadEventInfo loadEventInfo, int i) {
            loadStarted(loadEventInfo, i, -1, (Format) null, 0, (Object) null, C.TIME_UNSET, C.TIME_UNSET);
        }

        public void loadStarted(LoadEventInfo loadEventInfo, int i, int i2, Format format, int i3, Object obj, long j, long j2) {
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            loadStarted(loadEventInfo, new MediaLoadData(i, i2, format, i3, obj, adjustMediaTime(j), adjustMediaTime(j2)));
        }

        public void loadStarted(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                Util.postOrRun(next.handler, new MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda0(this, next.listener, loadEventInfo, mediaLoadData));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$loadStarted$0$com-google-android-exoplayer2-source-MediaSourceEventListener$EventDispatcher  reason: not valid java name */
        public /* synthetic */ void m509lambda$loadStarted$0$comgoogleandroidexoplayer2sourceMediaSourceEventListener$EventDispatcher(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onLoadStarted(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        public void loadCompleted(LoadEventInfo loadEventInfo, int i) {
            loadCompleted(loadEventInfo, i, -1, (Format) null, 0, (Object) null, C.TIME_UNSET, C.TIME_UNSET);
        }

        public void loadCompleted(LoadEventInfo loadEventInfo, int i, int i2, Format format, int i3, Object obj, long j, long j2) {
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            loadCompleted(loadEventInfo, new MediaLoadData(i, i2, format, i3, obj, adjustMediaTime(j), adjustMediaTime(j2)));
        }

        public void loadCompleted(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                Util.postOrRun(next.handler, new MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda3(this, next.listener, loadEventInfo, mediaLoadData));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$loadCompleted$1$com-google-android-exoplayer2-source-MediaSourceEventListener$EventDispatcher  reason: not valid java name */
        public /* synthetic */ void m507lambda$loadCompleted$1$comgoogleandroidexoplayer2sourceMediaSourceEventListener$EventDispatcher(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onLoadCompleted(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        public void loadCanceled(LoadEventInfo loadEventInfo, int i) {
            loadCanceled(loadEventInfo, i, -1, (Format) null, 0, (Object) null, C.TIME_UNSET, C.TIME_UNSET);
        }

        public void loadCanceled(LoadEventInfo loadEventInfo, int i, int i2, Format format, int i3, Object obj, long j, long j2) {
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            loadCanceled(loadEventInfo, new MediaLoadData(i, i2, format, i3, obj, adjustMediaTime(j), adjustMediaTime(j2)));
        }

        public void loadCanceled(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                Util.postOrRun(next.handler, new MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda4(this, next.listener, loadEventInfo, mediaLoadData));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$loadCanceled$2$com-google-android-exoplayer2-source-MediaSourceEventListener$EventDispatcher  reason: not valid java name */
        public /* synthetic */ void m506lambda$loadCanceled$2$comgoogleandroidexoplayer2sourceMediaSourceEventListener$EventDispatcher(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onLoadCanceled(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        public void loadError(LoadEventInfo loadEventInfo, int i, IOException iOException, boolean z) {
            loadError(loadEventInfo, i, -1, (Format) null, 0, (Object) null, C.TIME_UNSET, C.TIME_UNSET, iOException, z);
        }

        public void loadError(LoadEventInfo loadEventInfo, int i, int i2, Format format, int i3, Object obj, long j, long j2, IOException iOException, boolean z) {
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            loadError(loadEventInfo, new MediaLoadData(i, i2, format, i3, obj, adjustMediaTime(j), adjustMediaTime(j2)), iOException, z);
        }

        public void loadError(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                Util.postOrRun(next.handler, new MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda2(this, next.listener, loadEventInfo, mediaLoadData, iOException, z));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$loadError$3$com-google-android-exoplayer2-source-MediaSourceEventListener$EventDispatcher  reason: not valid java name */
        public /* synthetic */ void m508lambda$loadError$3$comgoogleandroidexoplayer2sourceMediaSourceEventListener$EventDispatcher(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            mediaSourceEventListener.onLoadError(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData, iOException, z);
        }

        public void upstreamDiscarded(int i, long j, long j2) {
            long j3 = j;
            upstreamDiscarded(new MediaLoadData(1, i, (Format) null, 3, (Object) null, adjustMediaTime(j), adjustMediaTime(j2)));
        }

        public void upstreamDiscarded(MediaLoadData mediaLoadData) {
            MediaSource.MediaPeriodId mediaPeriodId2 = (MediaSource.MediaPeriodId) Assertions.checkNotNull(this.mediaPeriodId);
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                Util.postOrRun(next.handler, new MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda5(this, next.listener, mediaPeriodId2, mediaLoadData));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$upstreamDiscarded$4$com-google-android-exoplayer2-source-MediaSourceEventListener$EventDispatcher  reason: not valid java name */
        public /* synthetic */ void m510lambda$upstreamDiscarded$4$comgoogleandroidexoplayer2sourceMediaSourceEventListener$EventDispatcher(MediaSourceEventListener mediaSourceEventListener, MediaSource.MediaPeriodId mediaPeriodId2, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onUpstreamDiscarded(this.windowIndex, mediaPeriodId2, mediaLoadData);
        }

        public void downstreamFormatChanged(int i, Format format, int i2, Object obj, long j) {
            downstreamFormatChanged(new MediaLoadData(1, i, format, i2, obj, adjustMediaTime(j), C.TIME_UNSET));
        }

        public void downstreamFormatChanged(MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                Util.postOrRun(next.handler, new MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda1(this, next.listener, mediaLoadData));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$downstreamFormatChanged$5$com-google-android-exoplayer2-source-MediaSourceEventListener$EventDispatcher  reason: not valid java name */
        public /* synthetic */ void m505lambda$downstreamFormatChanged$5$comgoogleandroidexoplayer2sourceMediaSourceEventListener$EventDispatcher(MediaSourceEventListener mediaSourceEventListener, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onDownstreamFormatChanged(this.windowIndex, this.mediaPeriodId, mediaLoadData);
        }

        private long adjustMediaTime(long j) {
            long usToMs = Util.usToMs(j);
            if (usToMs == C.TIME_UNSET) {
                return C.TIME_UNSET;
            }
            return this.mediaTimeOffsetMs + usToMs;
        }

        private static final class ListenerAndHandler {
            public Handler handler;
            public MediaSourceEventListener listener;

            public ListenerAndHandler(Handler handler2, MediaSourceEventListener mediaSourceEventListener) {
                this.handler = handler2;
                this.listener = mediaSourceEventListener;
            }
        }
    }
}
