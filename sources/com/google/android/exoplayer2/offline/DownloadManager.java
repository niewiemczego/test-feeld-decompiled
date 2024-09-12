package com.google.android.exoplayer2.offline;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl$$ExternalSyntheticLambda0;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

public final class DownloadManager {
    public static final int DEFAULT_MAX_PARALLEL_DOWNLOADS = 3;
    public static final int DEFAULT_MIN_RETRY_COUNT = 5;
    public static final Requirements DEFAULT_REQUIREMENTS = new Requirements(1);
    private static final int MSG_ADD_DOWNLOAD = 6;
    private static final int MSG_CONTENT_LENGTH_CHANGED = 10;
    private static final int MSG_DOWNLOAD_UPDATE = 2;
    private static final int MSG_INITIALIZE = 0;
    private static final int MSG_INITIALIZED = 0;
    private static final int MSG_PROCESSED = 1;
    private static final int MSG_RELEASE = 12;
    private static final int MSG_REMOVE_ALL_DOWNLOADS = 8;
    private static final int MSG_REMOVE_DOWNLOAD = 7;
    private static final int MSG_SET_DOWNLOADS_PAUSED = 1;
    private static final int MSG_SET_MAX_PARALLEL_DOWNLOADS = 4;
    private static final int MSG_SET_MIN_RETRY_COUNT = 5;
    private static final int MSG_SET_NOT_MET_REQUIREMENTS = 2;
    private static final int MSG_SET_STOP_REASON = 3;
    private static final int MSG_TASK_STOPPED = 9;
    private static final int MSG_UPDATE_PROGRESS = 11;
    private static final String TAG = "DownloadManager";
    private int activeTaskCount;
    private final Handler applicationHandler;
    private final Context context;
    private final WritableDownloadIndex downloadIndex;
    private List<Download> downloads;
    private boolean downloadsPaused;
    private boolean initialized;
    private final InternalHandler internalHandler;
    private final CopyOnWriteArraySet<Listener> listeners;
    private int maxParallelDownloads;
    private int minRetryCount;
    private int notMetRequirements;
    private int pendingMessages;
    private final RequirementsWatcher.Listener requirementsListener;
    private RequirementsWatcher requirementsWatcher;
    private boolean waitingForRequirements;

    public interface Listener {
        void onDownloadChanged(DownloadManager downloadManager, Download download, Exception exc) {
        }

        void onDownloadRemoved(DownloadManager downloadManager, Download download) {
        }

        void onDownloadsPausedChanged(DownloadManager downloadManager, boolean z) {
        }

        void onIdle(DownloadManager downloadManager) {
        }

        void onInitialized(DownloadManager downloadManager) {
        }

        void onRequirementsStateChanged(DownloadManager downloadManager, Requirements requirements, int i) {
        }

        void onWaitingForRequirementsChanged(DownloadManager downloadManager, boolean z) {
        }
    }

    @Deprecated
    public DownloadManager(Context context2, DatabaseProvider databaseProvider, Cache cache, DataSource.Factory factory) {
        this(context2, databaseProvider, cache, factory, new AdIdManager$Api33Ext4Impl$$ExternalSyntheticLambda0());
    }

    public DownloadManager(Context context2, DatabaseProvider databaseProvider, Cache cache, DataSource.Factory factory, Executor executor) {
        this(context2, new DefaultDownloadIndex(databaseProvider), new DefaultDownloaderFactory(new CacheDataSource.Factory().setCache(cache).setUpstreamDataSourceFactory(factory), executor));
    }

    public DownloadManager(Context context2, WritableDownloadIndex writableDownloadIndex, DownloaderFactory downloaderFactory) {
        this.context = context2.getApplicationContext();
        this.downloadIndex = writableDownloadIndex;
        this.maxParallelDownloads = 3;
        this.minRetryCount = 5;
        this.downloadsPaused = true;
        this.downloads = Collections.emptyList();
        this.listeners = new CopyOnWriteArraySet<>();
        Handler createHandlerForCurrentOrMainLooper = Util.createHandlerForCurrentOrMainLooper(new DownloadManager$$ExternalSyntheticLambda0(this));
        this.applicationHandler = createHandlerForCurrentOrMainLooper;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadManager");
        handlerThread.start();
        InternalHandler internalHandler2 = new InternalHandler(handlerThread, writableDownloadIndex, downloaderFactory, createHandlerForCurrentOrMainLooper, this.maxParallelDownloads, this.minRetryCount, this.downloadsPaused);
        this.internalHandler = internalHandler2;
        DownloadManager$$ExternalSyntheticLambda1 downloadManager$$ExternalSyntheticLambda1 = new DownloadManager$$ExternalSyntheticLambda1(this);
        this.requirementsListener = downloadManager$$ExternalSyntheticLambda1;
        RequirementsWatcher requirementsWatcher2 = new RequirementsWatcher(context2, downloadManager$$ExternalSyntheticLambda1, DEFAULT_REQUIREMENTS);
        this.requirementsWatcher = requirementsWatcher2;
        int start = requirementsWatcher2.start();
        this.notMetRequirements = start;
        this.pendingMessages = 1;
        internalHandler2.obtainMessage(0, start, 0).sendToTarget();
    }

    public Looper getApplicationLooper() {
        return this.applicationHandler.getLooper();
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public boolean isIdle() {
        return this.activeTaskCount == 0 && this.pendingMessages == 0;
    }

    public boolean isWaitingForRequirements() {
        return this.waitingForRequirements;
    }

    public void addListener(Listener listener) {
        Assertions.checkNotNull(listener);
        this.listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }

    public Requirements getRequirements() {
        return this.requirementsWatcher.getRequirements();
    }

    public int getNotMetRequirements() {
        return this.notMetRequirements;
    }

    public void setRequirements(Requirements requirements) {
        if (!requirements.equals(this.requirementsWatcher.getRequirements())) {
            this.requirementsWatcher.stop();
            RequirementsWatcher requirementsWatcher2 = new RequirementsWatcher(this.context, this.requirementsListener, requirements);
            this.requirementsWatcher = requirementsWatcher2;
            onRequirementsStateChanged(this.requirementsWatcher, requirementsWatcher2.start());
        }
    }

    public int getMaxParallelDownloads() {
        return this.maxParallelDownloads;
    }

    public void setMaxParallelDownloads(int i) {
        Assertions.checkArgument(i > 0);
        if (this.maxParallelDownloads != i) {
            this.maxParallelDownloads = i;
            this.pendingMessages++;
            this.internalHandler.obtainMessage(4, i, 0).sendToTarget();
        }
    }

    public int getMinRetryCount() {
        return this.minRetryCount;
    }

    public void setMinRetryCount(int i) {
        Assertions.checkArgument(i >= 0);
        if (this.minRetryCount != i) {
            this.minRetryCount = i;
            this.pendingMessages++;
            this.internalHandler.obtainMessage(5, i, 0).sendToTarget();
        }
    }

    public DownloadIndex getDownloadIndex() {
        return this.downloadIndex;
    }

    public List<Download> getCurrentDownloads() {
        return this.downloads;
    }

    public boolean getDownloadsPaused() {
        return this.downloadsPaused;
    }

    public void resumeDownloads() {
        setDownloadsPaused(false);
    }

    public void pauseDownloads() {
        setDownloadsPaused(true);
    }

    public void setStopReason(String str, int i) {
        this.pendingMessages++;
        this.internalHandler.obtainMessage(3, i, 0, str).sendToTarget();
    }

    public void addDownload(DownloadRequest downloadRequest) {
        addDownload(downloadRequest, 0);
    }

    public void addDownload(DownloadRequest downloadRequest, int i) {
        this.pendingMessages++;
        this.internalHandler.obtainMessage(6, i, 0, downloadRequest).sendToTarget();
    }

    public void removeDownload(String str) {
        this.pendingMessages++;
        this.internalHandler.obtainMessage(7, str).sendToTarget();
    }

    public void removeAllDownloads() {
        this.pendingMessages++;
        this.internalHandler.obtainMessage(8).sendToTarget();
    }

    public void release() {
        synchronized (this.internalHandler) {
            if (!this.internalHandler.released) {
                this.internalHandler.sendEmptyMessage(12);
                boolean z = false;
                while (!this.internalHandler.released) {
                    try {
                        this.internalHandler.wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
                if (z) {
                    Thread.currentThread().interrupt();
                }
                this.applicationHandler.removeCallbacksAndMessages((Object) null);
                this.downloads = Collections.emptyList();
                this.pendingMessages = 0;
                this.activeTaskCount = 0;
                this.initialized = false;
                this.notMetRequirements = 0;
                this.waitingForRequirements = false;
            }
        }
    }

    private void setDownloadsPaused(boolean z) {
        if (this.downloadsPaused != z) {
            this.downloadsPaused = z;
            this.pendingMessages++;
            this.internalHandler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
            boolean updateWaitingForRequirements = updateWaitingForRequirements();
            Iterator<Listener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onDownloadsPausedChanged(this, z);
            }
            if (updateWaitingForRequirements) {
                notifyWaitingForRequirementsChanged();
            }
        }
    }

    /* access modifiers changed from: private */
    public void onRequirementsStateChanged(RequirementsWatcher requirementsWatcher2, int i) {
        Requirements requirements = requirementsWatcher2.getRequirements();
        if (this.notMetRequirements != i) {
            this.notMetRequirements = i;
            this.pendingMessages++;
            this.internalHandler.obtainMessage(2, i, 0).sendToTarget();
        }
        boolean updateWaitingForRequirements = updateWaitingForRequirements();
        Iterator<Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onRequirementsStateChanged(this, requirements, i);
        }
        if (updateWaitingForRequirements) {
            notifyWaitingForRequirementsChanged();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean updateWaitingForRequirements() {
        /*
            r4 = this;
            boolean r0 = r4.downloadsPaused
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0024
            int r0 = r4.notMetRequirements
            if (r0 == 0) goto L_0x0024
            r0 = r2
        L_0x000b:
            java.util.List<com.google.android.exoplayer2.offline.Download> r3 = r4.downloads
            int r3 = r3.size()
            if (r0 >= r3) goto L_0x0024
            java.util.List<com.google.android.exoplayer2.offline.Download> r3 = r4.downloads
            java.lang.Object r3 = r3.get(r0)
            com.google.android.exoplayer2.offline.Download r3 = (com.google.android.exoplayer2.offline.Download) r3
            int r3 = r3.state
            if (r3 != 0) goto L_0x0021
            r0 = r1
            goto L_0x0025
        L_0x0021:
            int r0 = r0 + 1
            goto L_0x000b
        L_0x0024:
            r0 = r2
        L_0x0025:
            boolean r3 = r4.waitingForRequirements
            if (r3 == r0) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            r1 = r2
        L_0x002b:
            r4.waitingForRequirements = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.DownloadManager.updateWaitingForRequirements():boolean");
    }

    private void notifyWaitingForRequirementsChanged() {
        Iterator<Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onWaitingForRequirementsChanged(this, this.waitingForRequirements);
        }
    }

    /* access modifiers changed from: private */
    public boolean handleMainMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            onInitialized((List) message.obj);
        } else if (i == 1) {
            onMessageProcessed(message.arg1, message.arg2);
        } else if (i == 2) {
            onDownloadUpdate((DownloadUpdate) message.obj);
        } else {
            throw new IllegalStateException();
        }
        return true;
    }

    private void onInitialized(List<Download> list) {
        this.initialized = true;
        this.downloads = Collections.unmodifiableList(list);
        boolean updateWaitingForRequirements = updateWaitingForRequirements();
        Iterator<Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onInitialized(this);
        }
        if (updateWaitingForRequirements) {
            notifyWaitingForRequirementsChanged();
        }
    }

    private void onDownloadUpdate(DownloadUpdate downloadUpdate) {
        this.downloads = Collections.unmodifiableList(downloadUpdate.downloads);
        Download download = downloadUpdate.download;
        boolean updateWaitingForRequirements = updateWaitingForRequirements();
        if (downloadUpdate.isRemove) {
            Iterator<Listener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onDownloadRemoved(this, download);
            }
        } else {
            Iterator<Listener> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                it2.next().onDownloadChanged(this, download, downloadUpdate.finalException);
            }
        }
        if (updateWaitingForRequirements) {
            notifyWaitingForRequirementsChanged();
        }
    }

    private void onMessageProcessed(int i, int i2) {
        this.pendingMessages -= i;
        this.activeTaskCount = i2;
        if (isIdle()) {
            Iterator<Listener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onIdle(this);
            }
        }
    }

    static Download mergeRequest(Download download, DownloadRequest downloadRequest, int i, long j) {
        int i2;
        Download download2 = download;
        int i3 = download2.state;
        long j2 = (i3 == 5 || download.isTerminalState()) ? j : download2.startTimeMs;
        if (i3 == 5 || i3 == 7) {
            i2 = 7;
        } else {
            i2 = i != 0 ? 1 : 0;
        }
        return new Download(download2.request.copyWithMergedRequest(downloadRequest), i2, j2, j, -1, i, 0);
    }

    private static final class InternalHandler extends Handler {
        private static final int UPDATE_PROGRESS_INTERVAL_MS = 5000;
        private int activeDownloadTaskCount;
        private final HashMap<String, Task> activeTasks = new HashMap<>();
        private final WritableDownloadIndex downloadIndex;
        private final DownloaderFactory downloaderFactory;
        private final ArrayList<Download> downloads = new ArrayList<>();
        private boolean downloadsPaused;
        private final Handler mainHandler;
        private int maxParallelDownloads;
        private int minRetryCount;
        private int notMetRequirements;
        public boolean released;
        private final HandlerThread thread;

        public InternalHandler(HandlerThread handlerThread, WritableDownloadIndex writableDownloadIndex, DownloaderFactory downloaderFactory2, Handler handler, int i, int i2, boolean z) {
            super(handlerThread.getLooper());
            this.thread = handlerThread;
            this.downloadIndex = writableDownloadIndex;
            this.downloaderFactory = downloaderFactory2;
            this.mainHandler = handler;
            this.maxParallelDownloads = i;
            this.minRetryCount = i2;
            this.downloadsPaused = z;
        }

        public void handleMessage(Message message) {
            boolean z = false;
            switch (message.what) {
                case 0:
                    initialize(message.arg1);
                    break;
                case 1:
                    if (message.arg1 != 0) {
                        z = true;
                    }
                    setDownloadsPaused(z);
                    break;
                case 2:
                    setNotMetRequirements(message.arg1);
                    break;
                case 3:
                    setStopReason((String) message.obj, message.arg1);
                    break;
                case 4:
                    setMaxParallelDownloads(message.arg1);
                    break;
                case 5:
                    setMinRetryCount(message.arg1);
                    break;
                case 6:
                    addDownload((DownloadRequest) message.obj, message.arg1);
                    break;
                case 7:
                    removeDownload((String) message.obj);
                    break;
                case 8:
                    removeAllDownloads();
                    break;
                case 9:
                    onTaskStopped((Task) message.obj);
                    break;
                case 10:
                    onContentLengthChanged((Task) message.obj, Util.toLong(message.arg1, message.arg2));
                    return;
                case 11:
                    updateProgress();
                    return;
                case 12:
                    release();
                    return;
                default:
                    throw new IllegalStateException();
            }
            z = true;
            this.mainHandler.obtainMessage(1, z ? 1 : 0, this.activeTasks.size()).sendToTarget();
        }

        private void initialize(int i) {
            this.notMetRequirements = i;
            DownloadCursor downloadCursor = null;
            try {
                this.downloadIndex.setDownloadingStatesToQueued();
                downloadCursor = this.downloadIndex.getDownloads(0, 1, 2, 5, 7);
                while (downloadCursor.moveToNext()) {
                    this.downloads.add(downloadCursor.getDownload());
                }
            } catch (IOException e) {
                Log.e(DownloadManager.TAG, "Failed to load index.", e);
                this.downloads.clear();
            } catch (Throwable th) {
                Util.closeQuietly((Closeable) null);
                throw th;
            }
            Util.closeQuietly(downloadCursor);
            this.mainHandler.obtainMessage(0, new ArrayList(this.downloads)).sendToTarget();
            syncTasks();
        }

        private void setDownloadsPaused(boolean z) {
            this.downloadsPaused = z;
            syncTasks();
        }

        private void setNotMetRequirements(int i) {
            this.notMetRequirements = i;
            syncTasks();
        }

        private void setStopReason(String str, int i) {
            if (str == null) {
                for (int i2 = 0; i2 < this.downloads.size(); i2++) {
                    setStopReason(this.downloads.get(i2), i);
                }
                try {
                    this.downloadIndex.setStopReason(i);
                } catch (IOException e) {
                    Log.e(DownloadManager.TAG, "Failed to set manual stop reason", e);
                }
            } else {
                Download download = getDownload(str, false);
                if (download != null) {
                    setStopReason(download, i);
                } else {
                    try {
                        this.downloadIndex.setStopReason(str, i);
                    } catch (IOException e2) {
                        Log.e(DownloadManager.TAG, "Failed to set manual stop reason: " + str, e2);
                    }
                }
            }
            syncTasks();
        }

        private void setStopReason(Download download, int i) {
            Download download2 = download;
            int i2 = i;
            if (i2 == 0) {
                if (download2.state == 1) {
                    putDownloadWithState(download, 0, 0);
                }
            } else if (i2 != download2.stopReason) {
                int i3 = download2.state;
                if (i3 == 0 || i3 == 2) {
                    i3 = 1;
                }
                putDownload(new Download(download2.request, i3, download2.startTimeMs, System.currentTimeMillis(), download2.contentLength, i, 0, download2.progress));
            }
        }

        private void setMaxParallelDownloads(int i) {
            this.maxParallelDownloads = i;
            syncTasks();
        }

        private void setMinRetryCount(int i) {
            this.minRetryCount = i;
        }

        private void addDownload(DownloadRequest downloadRequest, int i) {
            int i2 = 1;
            Download download = getDownload(downloadRequest.id, true);
            long currentTimeMillis = System.currentTimeMillis();
            if (download != null) {
                putDownload(DownloadManager.mergeRequest(download, downloadRequest, i, currentTimeMillis));
            } else {
                if (i == 0) {
                    i2 = 0;
                }
                putDownload(new Download(downloadRequest, i2, currentTimeMillis, currentTimeMillis, -1, i, 0));
            }
            syncTasks();
        }

        private void removeDownload(String str) {
            Download download = getDownload(str, true);
            if (download == null) {
                Log.e(DownloadManager.TAG, "Failed to remove nonexistent download: " + str);
                return;
            }
            putDownloadWithState(download, 5, 0);
            syncTasks();
        }

        private void removeAllDownloads() {
            DownloadCursor downloads2;
            ArrayList arrayList = new ArrayList();
            try {
                downloads2 = this.downloadIndex.getDownloads(3, 4);
                while (downloads2.moveToNext()) {
                    arrayList.add(downloads2.getDownload());
                }
                if (downloads2 != null) {
                    downloads2.close();
                }
            } catch (IOException unused) {
                Log.e(DownloadManager.TAG, "Failed to load downloads.");
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            for (int i = 0; i < this.downloads.size(); i++) {
                ArrayList<Download> arrayList2 = this.downloads;
                arrayList2.set(i, copyDownloadWithState(arrayList2.get(i), 5, 0));
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                this.downloads.add(copyDownloadWithState((Download) arrayList.get(i2), 5, 0));
            }
            Collections.sort(this.downloads, new DownloadManager$InternalHandler$$ExternalSyntheticLambda0());
            try {
                this.downloadIndex.setStatesToRemoving();
            } catch (IOException e) {
                Log.e(DownloadManager.TAG, "Failed to update index.", e);
            }
            ArrayList arrayList3 = new ArrayList(this.downloads);
            for (int i3 = 0; i3 < this.downloads.size(); i3++) {
                this.mainHandler.obtainMessage(2, new DownloadUpdate(this.downloads.get(i3), false, arrayList3, (Exception) null)).sendToTarget();
            }
            syncTasks();
            return;
            throw th;
        }

        private void release() {
            for (Task cancel : this.activeTasks.values()) {
                cancel.cancel(true);
            }
            try {
                this.downloadIndex.setDownloadingStatesToQueued();
            } catch (IOException e) {
                Log.e(DownloadManager.TAG, "Failed to update index.", e);
            }
            this.downloads.clear();
            this.thread.quit();
            synchronized (this) {
                this.released = true;
                notifyAll();
            }
        }

        private void syncTasks() {
            int i = 0;
            for (int i2 = 0; i2 < this.downloads.size(); i2++) {
                Download download = this.downloads.get(i2);
                Task task = this.activeTasks.get(download.request.id);
                int i3 = download.state;
                if (i3 == 0) {
                    task = syncQueuedDownload(task, download);
                } else if (i3 == 1) {
                    syncStoppedDownload(task);
                } else if (i3 == 2) {
                    Assertions.checkNotNull(task);
                    syncDownloadingDownload(task, download, i);
                } else if (i3 == 5 || i3 == 7) {
                    syncRemovingDownload(task, download);
                } else {
                    throw new IllegalStateException();
                }
                if (task != null && !task.isRemove) {
                    i++;
                }
            }
        }

        private void syncStoppedDownload(Task task) {
            if (task != null) {
                Assertions.checkState(!task.isRemove);
                task.cancel(false);
            }
        }

        private Task syncQueuedDownload(Task task, Download download) {
            if (task != null) {
                Assertions.checkState(!task.isRemove);
                task.cancel(false);
                return task;
            } else if (!canDownloadsRun() || this.activeDownloadTaskCount >= this.maxParallelDownloads) {
                return null;
            } else {
                Download putDownloadWithState = putDownloadWithState(download, 2, 0);
                Task task2 = new Task(putDownloadWithState.request, this.downloaderFactory.createDownloader(putDownloadWithState.request), putDownloadWithState.progress, false, this.minRetryCount, this);
                this.activeTasks.put(putDownloadWithState.request.id, task2);
                int i = this.activeDownloadTaskCount;
                this.activeDownloadTaskCount = i + 1;
                if (i == 0) {
                    sendEmptyMessageDelayed(11, 5000);
                }
                task2.start();
                return task2;
            }
        }

        private void syncDownloadingDownload(Task task, Download download, int i) {
            Assertions.checkState(!task.isRemove);
            if (!canDownloadsRun() || i >= this.maxParallelDownloads) {
                putDownloadWithState(download, 0, 0);
                task.cancel(false);
            }
        }

        private void syncRemovingDownload(Task task, Download download) {
            if (task == null) {
                Task task2 = new Task(download.request, this.downloaderFactory.createDownloader(download.request), download.progress, true, this.minRetryCount, this);
                this.activeTasks.put(download.request.id, task2);
                task2.start();
            } else if (!task.isRemove) {
                task.cancel(false);
            }
        }

        private void onContentLengthChanged(Task task, long j) {
            Download download = (Download) Assertions.checkNotNull(getDownload(task.request.id, false));
            if (j != download.contentLength && j != -1) {
                putDownload(new Download(download.request, download.state, download.startTimeMs, System.currentTimeMillis(), j, download.stopReason, download.failureReason, download.progress));
            }
        }

        private void onTaskStopped(Task task) {
            String str = task.request.id;
            this.activeTasks.remove(str);
            boolean access$000 = task.isRemove;
            if (!access$000) {
                int i = this.activeDownloadTaskCount - 1;
                this.activeDownloadTaskCount = i;
                if (i == 0) {
                    removeMessages(11);
                }
            }
            if (task.isCanceled) {
                syncTasks();
                return;
            }
            Exception access$400 = task.finalException;
            if (access$400 != null) {
                Log.e(DownloadManager.TAG, "Task failed: " + task.request + ", " + access$000, access$400);
            }
            Download download = (Download) Assertions.checkNotNull(getDownload(str, false));
            int i2 = download.state;
            if (i2 == 2) {
                Assertions.checkState(!access$000);
                onDownloadTaskStopped(download, access$400);
            } else if (i2 == 5 || i2 == 7) {
                Assertions.checkState(access$000);
                onRemoveTaskStopped(download);
            } else {
                throw new IllegalStateException();
            }
            syncTasks();
        }

        private void onDownloadTaskStopped(Download download, Exception exc) {
            Download download2 = download;
            Exception exc2 = exc;
            Download download3 = new Download(download2.request, exc2 == null ? 3 : 4, download2.startTimeMs, System.currentTimeMillis(), download2.contentLength, download2.stopReason, exc2 == null ? 0 : 1, download2.progress);
            this.downloads.remove(getDownloadIndex(download3.request.id));
            try {
                this.downloadIndex.putDownload(download3);
            } catch (IOException e) {
                Log.e(DownloadManager.TAG, "Failed to update index.", e);
            }
            this.mainHandler.obtainMessage(2, new DownloadUpdate(download3, false, new ArrayList(this.downloads), exc2)).sendToTarget();
        }

        private void onRemoveTaskStopped(Download download) {
            int i = 1;
            if (download.state == 7) {
                if (download.stopReason == 0) {
                    i = 0;
                }
                putDownloadWithState(download, i, download.stopReason);
                syncTasks();
                return;
            }
            this.downloads.remove(getDownloadIndex(download.request.id));
            try {
                this.downloadIndex.removeDownload(download.request.id);
            } catch (IOException unused) {
                Log.e(DownloadManager.TAG, "Failed to remove from database");
            }
            this.mainHandler.obtainMessage(2, new DownloadUpdate(download, true, new ArrayList(this.downloads), (Exception) null)).sendToTarget();
        }

        private void updateProgress() {
            for (int i = 0; i < this.downloads.size(); i++) {
                Download download = this.downloads.get(i);
                if (download.state == 2) {
                    try {
                        this.downloadIndex.putDownload(download);
                    } catch (IOException e) {
                        Log.e(DownloadManager.TAG, "Failed to update index.", e);
                    }
                }
            }
            sendEmptyMessageDelayed(11, 5000);
        }

        private boolean canDownloadsRun() {
            return !this.downloadsPaused && this.notMetRequirements == 0;
        }

        private Download putDownloadWithState(Download download, int i, int i2) {
            Assertions.checkState((i == 3 || i == 4) ? false : true);
            return putDownload(copyDownloadWithState(download, i, i2));
        }

        private Download putDownload(Download download) {
            boolean z = true;
            Assertions.checkState((download.state == 3 || download.state == 4) ? false : true);
            int downloadIndex2 = getDownloadIndex(download.request.id);
            if (downloadIndex2 == -1) {
                this.downloads.add(download);
                Collections.sort(this.downloads, new DownloadManager$InternalHandler$$ExternalSyntheticLambda0());
            } else {
                if (download.startTimeMs == this.downloads.get(downloadIndex2).startTimeMs) {
                    z = false;
                }
                this.downloads.set(downloadIndex2, download);
                if (z) {
                    Collections.sort(this.downloads, new DownloadManager$InternalHandler$$ExternalSyntheticLambda0());
                }
            }
            try {
                this.downloadIndex.putDownload(download);
            } catch (IOException e) {
                Log.e(DownloadManager.TAG, "Failed to update index.", e);
            }
            this.mainHandler.obtainMessage(2, new DownloadUpdate(download, false, new ArrayList(this.downloads), (Exception) null)).sendToTarget();
            return download;
        }

        private Download getDownload(String str, boolean z) {
            int downloadIndex2 = getDownloadIndex(str);
            if (downloadIndex2 != -1) {
                return this.downloads.get(downloadIndex2);
            }
            if (!z) {
                return null;
            }
            try {
                return this.downloadIndex.getDownload(str);
            } catch (IOException e) {
                Log.e(DownloadManager.TAG, "Failed to load download: " + str, e);
                return null;
            }
        }

        private int getDownloadIndex(String str) {
            for (int i = 0; i < this.downloads.size(); i++) {
                if (this.downloads.get(i).request.id.equals(str)) {
                    return i;
                }
            }
            return -1;
        }

        private static Download copyDownloadWithState(Download download, int i, int i2) {
            return new Download(download.request, i, download.startTimeMs, System.currentTimeMillis(), download.contentLength, i2, 0, download.progress);
        }

        /* access modifiers changed from: private */
        public static int compareStartTimes(Download download, Download download2) {
            return Util.compareLong(download.startTimeMs, download2.startTimeMs);
        }
    }

    private static class Task extends Thread implements Downloader.ProgressListener {
        private long contentLength;
        private final DownloadProgress downloadProgress;
        private final Downloader downloader;
        /* access modifiers changed from: private */
        public Exception finalException;
        private volatile InternalHandler internalHandler;
        /* access modifiers changed from: private */
        public volatile boolean isCanceled;
        /* access modifiers changed from: private */
        public final boolean isRemove;
        private final int minRetryCount;
        /* access modifiers changed from: private */
        public final DownloadRequest request;

        private Task(DownloadRequest downloadRequest, Downloader downloader2, DownloadProgress downloadProgress2, boolean z, int i, InternalHandler internalHandler2) {
            this.request = downloadRequest;
            this.downloader = downloader2;
            this.downloadProgress = downloadProgress2;
            this.isRemove = z;
            this.minRetryCount = i;
            this.internalHandler = internalHandler2;
            this.contentLength = -1;
        }

        public void cancel(boolean z) {
            if (z) {
                this.internalHandler = null;
            }
            if (!this.isCanceled) {
                this.isCanceled = true;
                this.downloader.cancel();
                interrupt();
            }
        }

        public void run() {
            long j;
            int i;
            try {
                if (this.isRemove) {
                    this.downloader.remove();
                } else {
                    j = -1;
                    i = 0;
                    while (!this.isCanceled) {
                        this.downloader.download(this);
                    }
                }
            } catch (IOException e) {
                if (!this.isCanceled) {
                    long j2 = this.downloadProgress.bytesDownloaded;
                    if (j2 != j) {
                        i = 0;
                        j = j2;
                    }
                    i++;
                    if (i <= this.minRetryCount) {
                        Thread.sleep((long) getRetryDelayMillis(i));
                    } else {
                        throw e;
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (Exception e2) {
                this.finalException = e2;
            }
            InternalHandler internalHandler2 = this.internalHandler;
            if (internalHandler2 != null) {
                internalHandler2.obtainMessage(9, this).sendToTarget();
            }
        }

        public void onProgress(long j, long j2, float f) {
            this.downloadProgress.bytesDownloaded = j2;
            this.downloadProgress.percentDownloaded = f;
            if (j != this.contentLength) {
                this.contentLength = j;
                InternalHandler internalHandler2 = this.internalHandler;
                if (internalHandler2 != null) {
                    internalHandler2.obtainMessage(10, (int) (j >> 32), (int) j, this).sendToTarget();
                }
            }
        }

        private static int getRetryDelayMillis(int i) {
            return Math.min((i - 1) * 1000, 5000);
        }
    }

    private static final class DownloadUpdate {
        public final Download download;
        public final List<Download> downloads;
        public final Exception finalException;
        public final boolean isRemove;

        public DownloadUpdate(Download download2, boolean z, List<Download> list, Exception exc) {
            this.download = download2;
            this.isRemove = z;
            this.downloads = list;
            this.finalException = exc;
        }
    }
}
