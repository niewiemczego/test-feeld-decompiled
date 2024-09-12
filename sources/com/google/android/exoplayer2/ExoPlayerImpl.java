package com.google.android.exoplayer2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.AudioBecomingNoisyManager;
import com.google.android.exoplayer2.AudioFocusManager;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.StreamVolumeManager;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.MediaMetricsListener;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

final class ExoPlayerImpl extends BasePlayer implements ExoPlayer, ExoPlayer.AudioComponent, ExoPlayer.VideoComponent, ExoPlayer.TextComponent, ExoPlayer.DeviceComponent {
    private static final String TAG = "ExoPlayerImpl";
    /* access modifiers changed from: private */
    public final AnalyticsCollector analyticsCollector;
    private final Context applicationContext;
    private final Looper applicationLooper;
    private AudioAttributes audioAttributes;
    private final AudioBecomingNoisyManager audioBecomingNoisyManager;
    /* access modifiers changed from: private */
    public DecoderCounters audioDecoderCounters;
    private final AudioFocusManager audioFocusManager;
    /* access modifiers changed from: private */
    public Format audioFormat;
    private final CopyOnWriteArraySet<ExoPlayer.AudioOffloadListener> audioOffloadListeners;
    private int audioSessionId;
    private Player.Commands availableCommands;
    private final BandwidthMeter bandwidthMeter;
    private CameraMotionListener cameraMotionListener;
    private final Clock clock;
    private final ComponentListener componentListener;
    private final ConditionVariable constructorFinished;
    /* access modifiers changed from: private */
    public CueGroup currentCueGroup;
    private final long detachSurfaceTimeoutMs;
    /* access modifiers changed from: private */
    public DeviceInfo deviceInfo;
    final TrackSelectorResult emptyTrackSelectorResult;
    private boolean foregroundMode;
    private final FrameMetadataListener frameMetadataListener;
    private boolean hasNotifiedFullWrongThreadWarning;
    private final ExoPlayerImplInternal internalPlayer;
    private boolean isPriorityTaskManagerRegistered;
    private AudioTrack keepSessionIdAudioTrack;
    /* access modifiers changed from: private */
    public final ListenerSet<Player.Listener> listeners;
    private int maskingPeriodIndex;
    private int maskingWindowIndex;
    private long maskingWindowPositionMs;
    /* access modifiers changed from: private */
    public MediaMetadata mediaMetadata;
    private final MediaSource.Factory mediaSourceFactory;
    private final List<MediaSourceHolderSnapshot> mediaSourceHolderSnapshots;
    private Surface ownedSurface;
    private boolean pauseAtEndOfMediaItems;
    private boolean pendingDiscontinuity;
    private int pendingDiscontinuityReason;
    private int pendingOperationAcks;
    private int pendingPlayWhenReadyChangeReason;
    private final Timeline.Period period;
    final Player.Commands permanentAvailableCommands;
    private PlaybackInfo playbackInfo;
    private final HandlerWrapper playbackInfoUpdateHandler;
    private final ExoPlayerImplInternal.PlaybackInfoUpdateListener playbackInfoUpdateListener;
    private boolean playerReleased;
    private MediaMetadata playlistMetadata;
    private PriorityTaskManager priorityTaskManager;
    private final Renderer[] renderers;
    private int repeatMode;
    private final long seekBackIncrementMs;
    private final long seekForwardIncrementMs;
    private SeekParameters seekParameters;
    private boolean shuffleModeEnabled;
    private ShuffleOrder shuffleOrder;
    /* access modifiers changed from: private */
    public boolean skipSilenceEnabled;
    private SphericalGLSurfaceView sphericalGLSurfaceView;
    /* access modifiers changed from: private */
    public MediaMetadata staticAndDynamicMediaMetadata;
    /* access modifiers changed from: private */
    public final StreamVolumeManager streamVolumeManager;
    private int surfaceHeight;
    private SurfaceHolder surfaceHolder;
    /* access modifiers changed from: private */
    public boolean surfaceHolderSurfaceIsVideoOutput;
    private int surfaceWidth;
    private TextureView textureView;
    private boolean throwsWhenUsingWrongThread;
    private final TrackSelector trackSelector;
    private final boolean useLazyPreparation;
    private int videoChangeFrameRateStrategy;
    /* access modifiers changed from: private */
    public DecoderCounters videoDecoderCounters;
    /* access modifiers changed from: private */
    public Format videoFormat;
    private VideoFrameMetadataListener videoFrameMetadataListener;
    /* access modifiers changed from: private */
    public Object videoOutput;
    private int videoScalingMode;
    /* access modifiers changed from: private */
    public VideoSize videoSize;
    private float volume;
    private final WakeLockManager wakeLockManager;
    private final WifiLockManager wifiLockManager;
    private final Player wrappingPlayer;

    /* access modifiers changed from: private */
    public static int getPlayWhenReadyChangeReason(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.exoplayer");
    }

    /* JADX WARNING: type inference failed for: r39v0, types: [com.google.android.exoplayer2.Player] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExoPlayerImpl(com.google.android.exoplayer2.ExoPlayer.Builder r38, com.google.android.exoplayer2.Player r39) {
        /*
            r37 = this;
            r1 = r37
            r0 = r38
            r37.<init>()
            com.google.android.exoplayer2.util.ConditionVariable r2 = new com.google.android.exoplayer2.util.ConditionVariable
            r2.<init>()
            r1.constructorFinished = r2
            java.lang.String r3 = "ExoPlayerImpl"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x034d }
            r4.<init>()     // Catch:{ all -> 0x034d }
            java.lang.String r5 = "Init "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x034d }
            int r5 = java.lang.System.identityHashCode(r37)     // Catch:{ all -> 0x034d }
            java.lang.String r5 = java.lang.Integer.toHexString(r5)     // Catch:{ all -> 0x034d }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x034d }
            java.lang.String r5 = " ["
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x034d }
            java.lang.String r5 = "ExoPlayerLib/2.18.1"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x034d }
            java.lang.String r5 = "] ["
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x034d }
            java.lang.String r5 = com.google.android.exoplayer2.util.Util.DEVICE_DEBUG_INFO     // Catch:{ all -> 0x034d }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x034d }
            java.lang.String r5 = "]"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x034d }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.util.Log.i(r3, r4)     // Catch:{ all -> 0x034d }
            android.content.Context r3 = r0.context     // Catch:{ all -> 0x034d }
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x034d }
            r1.applicationContext = r3     // Catch:{ all -> 0x034d }
            com.google.common.base.Function<com.google.android.exoplayer2.util.Clock, com.google.android.exoplayer2.analytics.AnalyticsCollector> r4 = r0.analyticsCollectorFunction     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.util.Clock r5 = r0.clock     // Catch:{ all -> 0x034d }
            java.lang.Object r4 = r4.apply(r5)     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.analytics.AnalyticsCollector r4 = (com.google.android.exoplayer2.analytics.AnalyticsCollector) r4     // Catch:{ all -> 0x034d }
            r1.analyticsCollector = r4     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.util.PriorityTaskManager r5 = r0.priorityTaskManager     // Catch:{ all -> 0x034d }
            r1.priorityTaskManager = r5     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.audio.AudioAttributes r5 = r0.audioAttributes     // Catch:{ all -> 0x034d }
            r1.audioAttributes = r5     // Catch:{ all -> 0x034d }
            int r5 = r0.videoScalingMode     // Catch:{ all -> 0x034d }
            r1.videoScalingMode = r5     // Catch:{ all -> 0x034d }
            int r5 = r0.videoChangeFrameRateStrategy     // Catch:{ all -> 0x034d }
            r1.videoChangeFrameRateStrategy = r5     // Catch:{ all -> 0x034d }
            boolean r5 = r0.skipSilenceEnabled     // Catch:{ all -> 0x034d }
            r1.skipSilenceEnabled = r5     // Catch:{ all -> 0x034d }
            long r5 = r0.detachSurfaceTimeoutMs     // Catch:{ all -> 0x034d }
            r1.detachSurfaceTimeoutMs = r5     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.ExoPlayerImpl$ComponentListener r15 = new com.google.android.exoplayer2.ExoPlayerImpl$ComponentListener     // Catch:{ all -> 0x034d }
            r14 = 0
            r15.<init>()     // Catch:{ all -> 0x034d }
            r1.componentListener = r15     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.ExoPlayerImpl$FrameMetadataListener r13 = new com.google.android.exoplayer2.ExoPlayerImpl$FrameMetadataListener     // Catch:{ all -> 0x034d }
            r13.<init>()     // Catch:{ all -> 0x034d }
            r1.frameMetadataListener = r13     // Catch:{ all -> 0x034d }
            android.os.Handler r6 = new android.os.Handler     // Catch:{ all -> 0x034d }
            android.os.Looper r5 = r0.looper     // Catch:{ all -> 0x034d }
            r6.<init>(r5)     // Catch:{ all -> 0x034d }
            com.google.common.base.Supplier<com.google.android.exoplayer2.RenderersFactory> r5 = r0.renderersFactorySupplier     // Catch:{ all -> 0x034d }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x034d }
            r7 = r5
            com.google.android.exoplayer2.RenderersFactory r7 = (com.google.android.exoplayer2.RenderersFactory) r7     // Catch:{ all -> 0x034d }
            r8 = r6
            r9 = r15
            r10 = r15
            r11 = r15
            r12 = r15
            com.google.android.exoplayer2.Renderer[] r7 = r7.createRenderers(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x034d }
            r1.renderers = r7     // Catch:{ all -> 0x034d }
            int r5 = r7.length     // Catch:{ all -> 0x034d }
            r12 = 0
            if (r5 <= 0) goto L_0x00a8
            r5 = 1
            goto L_0x00a9
        L_0x00a8:
            r5 = r12
        L_0x00a9:
            com.google.android.exoplayer2.util.Assertions.checkState(r5)     // Catch:{ all -> 0x034d }
            com.google.common.base.Supplier<com.google.android.exoplayer2.trackselection.TrackSelector> r5 = r0.trackSelectorSupplier     // Catch:{ all -> 0x034d }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x034d }
            r10 = r5
            com.google.android.exoplayer2.trackselection.TrackSelector r10 = (com.google.android.exoplayer2.trackselection.TrackSelector) r10     // Catch:{ all -> 0x034d }
            r1.trackSelector = r10     // Catch:{ all -> 0x034d }
            com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSource$Factory> r5 = r0.mediaSourceFactorySupplier     // Catch:{ all -> 0x034d }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.source.MediaSource$Factory r5 = (com.google.android.exoplayer2.source.MediaSource.Factory) r5     // Catch:{ all -> 0x034d }
            r1.mediaSourceFactory = r5     // Catch:{ all -> 0x034d }
            com.google.common.base.Supplier<com.google.android.exoplayer2.upstream.BandwidthMeter> r5 = r0.bandwidthMeterSupplier     // Catch:{ all -> 0x034d }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x034d }
            r9 = r5
            com.google.android.exoplayer2.upstream.BandwidthMeter r9 = (com.google.android.exoplayer2.upstream.BandwidthMeter) r9     // Catch:{ all -> 0x034d }
            r1.bandwidthMeter = r9     // Catch:{ all -> 0x034d }
            boolean r5 = r0.useLazyPreparation     // Catch:{ all -> 0x034d }
            r1.useLazyPreparation = r5     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.SeekParameters r5 = r0.seekParameters     // Catch:{ all -> 0x034d }
            r1.seekParameters = r5     // Catch:{ all -> 0x034d }
            r16 = r15
            long r14 = r0.seekBackIncrementMs     // Catch:{ all -> 0x034d }
            r1.seekBackIncrementMs = r14     // Catch:{ all -> 0x034d }
            long r14 = r0.seekForwardIncrementMs     // Catch:{ all -> 0x034d }
            r1.seekForwardIncrementMs = r14     // Catch:{ all -> 0x034d }
            boolean r5 = r0.pauseAtEndOfMediaItems     // Catch:{ all -> 0x034d }
            r1.pauseAtEndOfMediaItems = r5     // Catch:{ all -> 0x034d }
            android.os.Looper r15 = r0.looper     // Catch:{ all -> 0x034d }
            r1.applicationLooper = r15     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.util.Clock r14 = r0.clock     // Catch:{ all -> 0x034d }
            r1.clock = r14     // Catch:{ all -> 0x034d }
            if (r39 != 0) goto L_0x00ee
            r5 = r1
            goto L_0x00f0
        L_0x00ee:
            r5 = r39
        L_0x00f0:
            r1.wrappingPlayer = r5     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.util.ListenerSet r8 = new com.google.android.exoplayer2.util.ListenerSet     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda11 r11 = new com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda11     // Catch:{ all -> 0x034d }
            r11.<init>(r1)     // Catch:{ all -> 0x034d }
            r8.<init>(r15, r14, r11)     // Catch:{ all -> 0x034d }
            r1.listeners = r8     // Catch:{ all -> 0x034d }
            java.util.concurrent.CopyOnWriteArraySet r8 = new java.util.concurrent.CopyOnWriteArraySet     // Catch:{ all -> 0x034d }
            r8.<init>()     // Catch:{ all -> 0x034d }
            r1.audioOffloadListeners = r8     // Catch:{ all -> 0x034d }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x034d }
            r8.<init>()     // Catch:{ all -> 0x034d }
            r1.mediaSourceHolderSnapshots = r8     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.source.ShuffleOrder$DefaultShuffleOrder r8 = new com.google.android.exoplayer2.source.ShuffleOrder$DefaultShuffleOrder     // Catch:{ all -> 0x034d }
            r8.<init>(r12)     // Catch:{ all -> 0x034d }
            r1.shuffleOrder = r8     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.trackselection.TrackSelectorResult r8 = new com.google.android.exoplayer2.trackselection.TrackSelectorResult     // Catch:{ all -> 0x034d }
            int r11 = r7.length     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.RendererConfiguration[] r11 = new com.google.android.exoplayer2.RendererConfiguration[r11]     // Catch:{ all -> 0x034d }
            int r12 = r7.length     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.trackselection.ExoTrackSelection[] r12 = new com.google.android.exoplayer2.trackselection.ExoTrackSelection[r12]     // Catch:{ all -> 0x034d }
            r20 = r6
            com.google.android.exoplayer2.Tracks r6 = com.google.android.exoplayer2.Tracks.EMPTY     // Catch:{ all -> 0x034d }
            r21 = r9
            r9 = 0
            r8.<init>(r11, r12, r6, r9)     // Catch:{ all -> 0x034d }
            r1.emptyTrackSelectorResult = r8     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.Timeline$Period r6 = new com.google.android.exoplayer2.Timeline$Period     // Catch:{ all -> 0x034d }
            r6.<init>()     // Catch:{ all -> 0x034d }
            r1.period = r6     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.Player$Commands$Builder r6 = new com.google.android.exoplayer2.Player$Commands$Builder     // Catch:{ all -> 0x034d }
            r6.<init>()     // Catch:{ all -> 0x034d }
            r12 = 21
            int[] r9 = new int[r12]     // Catch:{ all -> 0x034d }
            r11 = 1
            r18 = 0
            r9[r18] = r11     // Catch:{ all -> 0x034d }
            r12 = 2
            r9[r11] = r12     // Catch:{ all -> 0x034d }
            r23 = r2
            r2 = 3
            r9[r12] = r2     // Catch:{ all -> 0x034d }
            r19 = 13
            r9[r2] = r19     // Catch:{ all -> 0x034d }
            r22 = 14
            r2 = 4
            r9[r2] = r22     // Catch:{ all -> 0x034d }
            r24 = 15
            r2 = 5
            r9[r2] = r24     // Catch:{ all -> 0x034d }
            r25 = 16
            r2 = 6
            r9[r2] = r25     // Catch:{ all -> 0x034d }
            r26 = 17
            r2 = 7
            r9[r2] = r26     // Catch:{ all -> 0x034d }
            r27 = 18
            r2 = 8
            r9[r2] = r27     // Catch:{ all -> 0x034d }
            r28 = 19
            r2 = 9
            r9[r2] = r28     // Catch:{ all -> 0x034d }
            r11 = 31
            r2 = 10
            r9[r2] = r11     // Catch:{ all -> 0x034d }
            r29 = 11
            r30 = 20
            r9[r29] = r30     // Catch:{ all -> 0x034d }
            r29 = 12
            r31 = 30
            r9[r29] = r31     // Catch:{ all -> 0x034d }
            r29 = 21
            r9[r19] = r29     // Catch:{ all -> 0x034d }
            r19 = 22
            r9[r22] = r19     // Catch:{ all -> 0x034d }
            r19 = 23
            r9[r24] = r19     // Catch:{ all -> 0x034d }
            r19 = 24
            r9[r25] = r19     // Catch:{ all -> 0x034d }
            r19 = 25
            r9[r26] = r19     // Catch:{ all -> 0x034d }
            r19 = 26
            r9[r27] = r19     // Catch:{ all -> 0x034d }
            r19 = 27
            r9[r28] = r19     // Catch:{ all -> 0x034d }
            r19 = 28
            r9[r30] = r19     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.Player$Commands$Builder r6 = r6.addAll((int[]) r9)     // Catch:{ all -> 0x034d }
            r9 = 29
            boolean r12 = r10.isSetParametersSupported()     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.Player$Commands$Builder r6 = r6.addIf(r9, r12)     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.Player$Commands r6 = r6.build()     // Catch:{ all -> 0x034d }
            r1.permanentAvailableCommands = r6     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.Player$Commands$Builder r9 = new com.google.android.exoplayer2.Player$Commands$Builder     // Catch:{ all -> 0x034d }
            r9.<init>()     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.Player$Commands$Builder r6 = r9.addAll((com.google.android.exoplayer2.Player.Commands) r6)     // Catch:{ all -> 0x034d }
            r9 = 4
            com.google.android.exoplayer2.Player$Commands$Builder r6 = r6.add(r9)     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.Player$Commands$Builder r6 = r6.add(r2)     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.Player$Commands r6 = r6.build()     // Catch:{ all -> 0x034d }
            r1.availableCommands = r6     // Catch:{ all -> 0x034d }
            r12 = 0
            com.google.android.exoplayer2.util.HandlerWrapper r6 = r14.createHandler(r15, r12)     // Catch:{ all -> 0x034d }
            r1.playbackInfoUpdateHandler = r6     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda21 r9 = new com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda21     // Catch:{ all -> 0x034d }
            r9.<init>(r1)     // Catch:{ all -> 0x034d }
            r1.playbackInfoUpdateListener = r9     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.PlaybackInfo r6 = com.google.android.exoplayer2.PlaybackInfo.createDummy(r8)     // Catch:{ all -> 0x034d }
            r1.playbackInfo = r6     // Catch:{ all -> 0x034d }
            r4.setPlayer(r5, r15)     // Catch:{ all -> 0x034d }
            int r5 = com.google.android.exoplayer2.util.Util.SDK_INT     // Catch:{ all -> 0x034d }
            if (r5 >= r11) goto L_0x01e7
            com.google.android.exoplayer2.analytics.PlayerId r5 = new com.google.android.exoplayer2.analytics.PlayerId     // Catch:{ all -> 0x034d }
            r5.<init>()     // Catch:{ all -> 0x034d }
            goto L_0x01ed
        L_0x01e7:
            boolean r5 = r0.usePlatformDiagnostics     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.analytics.PlayerId r5 = com.google.android.exoplayer2.ExoPlayerImpl.Api31.registerMediaMetricsListener(r3, r1, r5)     // Catch:{ all -> 0x034d }
        L_0x01ed:
            r22 = r5
            com.google.android.exoplayer2.ExoPlayerImplInternal r11 = new com.google.android.exoplayer2.ExoPlayerImplInternal     // Catch:{ all -> 0x034d }
            com.google.common.base.Supplier<com.google.android.exoplayer2.LoadControl> r5 = r0.loadControlSupplier     // Catch:{ all -> 0x034d }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x034d }
            r17 = r5
            com.google.android.exoplayer2.LoadControl r17 = (com.google.android.exoplayer2.LoadControl) r17     // Catch:{ all -> 0x034d }
            int r6 = r1.repeatMode     // Catch:{ all -> 0x034d }
            boolean r5 = r1.shuffleModeEnabled     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.SeekParameters r2 = r1.seekParameters     // Catch:{ all -> 0x034d }
            r19 = r15
            com.google.android.exoplayer2.LivePlaybackSpeedControl r15 = r0.livePlaybackSpeedControl     // Catch:{ all -> 0x034d }
            r26 = r2
            r25 = r3
            long r2 = r0.releaseTimeoutMs     // Catch:{ all -> 0x034d }
            boolean r0 = r1.pauseAtEndOfMediaItems     // Catch:{ all -> 0x034d }
            r27 = r5
            r5 = r11
            r32 = r20
            r20 = r6
            r6 = r7
            r7 = r10
            r28 = r21
            r21 = r9
            r9 = r17
            r33 = r10
            r10 = r28
            r34 = r11
            r11 = r20
            r17 = r12
            r12 = r27
            r35 = r13
            r13 = r4
            r20 = r14
            r27 = r17
            r14 = r26
            r36 = r16
            r39 = r19
            r16 = r2
            r18 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22)     // Catch:{ all -> 0x034d }
            r0 = r34
            r1.internalPlayer = r0     // Catch:{ all -> 0x034d }
            r2 = 1065353216(0x3f800000, float:1.0)
            r1.volume = r2     // Catch:{ all -> 0x034d }
            r2 = 0
            r1.repeatMode = r2     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.MediaMetadata r3 = com.google.android.exoplayer2.MediaMetadata.EMPTY     // Catch:{ all -> 0x034d }
            r1.mediaMetadata = r3     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.MediaMetadata r3 = com.google.android.exoplayer2.MediaMetadata.EMPTY     // Catch:{ all -> 0x034d }
            r1.playlistMetadata = r3     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.MediaMetadata r3 = com.google.android.exoplayer2.MediaMetadata.EMPTY     // Catch:{ all -> 0x034d }
            r1.staticAndDynamicMediaMetadata = r3     // Catch:{ all -> 0x034d }
            r3 = -1
            r1.maskingWindowIndex = r3     // Catch:{ all -> 0x034d }
            int r3 = com.google.android.exoplayer2.util.Util.SDK_INT     // Catch:{ all -> 0x034d }
            r5 = 21
            if (r3 >= r5) goto L_0x0263
            int r3 = r1.initializeKeepSessionIdAudioTrack(r2)     // Catch:{ all -> 0x034d }
            r1.audioSessionId = r3     // Catch:{ all -> 0x034d }
            goto L_0x0269
        L_0x0263:
            int r3 = com.google.android.exoplayer2.util.Util.generateAudioSessionIdV21(r25)     // Catch:{ all -> 0x034d }
            r1.audioSessionId = r3     // Catch:{ all -> 0x034d }
        L_0x0269:
            com.google.android.exoplayer2.text.CueGroup r3 = com.google.android.exoplayer2.text.CueGroup.EMPTY     // Catch:{ all -> 0x034d }
            r1.currentCueGroup = r3     // Catch:{ all -> 0x034d }
            r3 = 1
            r1.throwsWhenUsingWrongThread = r3     // Catch:{ all -> 0x034d }
            r1.addListener(r4)     // Catch:{ all -> 0x034d }
            android.os.Handler r5 = new android.os.Handler     // Catch:{ all -> 0x034d }
            r6 = r39
            r5.<init>(r6)     // Catch:{ all -> 0x034d }
            r6 = r28
            r6.addEventListener(r5, r4)     // Catch:{ all -> 0x034d }
            r4 = r36
            r1.addAudioOffloadListener(r4)     // Catch:{ all -> 0x034d }
            r5 = r38
            long r6 = r5.foregroundModeTimeoutMs     // Catch:{ all -> 0x034d }
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x0293
            long r6 = r5.foregroundModeTimeoutMs     // Catch:{ all -> 0x034d }
            r0.experimentalSetForegroundModeTimeoutMs(r6)     // Catch:{ all -> 0x034d }
        L_0x0293:
            com.google.android.exoplayer2.AudioBecomingNoisyManager r0 = new com.google.android.exoplayer2.AudioBecomingNoisyManager     // Catch:{ all -> 0x034d }
            android.content.Context r6 = r5.context     // Catch:{ all -> 0x034d }
            r7 = r32
            r0.<init>(r6, r7, r4)     // Catch:{ all -> 0x034d }
            r1.audioBecomingNoisyManager = r0     // Catch:{ all -> 0x034d }
            boolean r6 = r5.handleAudioBecomingNoisy     // Catch:{ all -> 0x034d }
            r0.setEnabled(r6)     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.AudioFocusManager r0 = new com.google.android.exoplayer2.AudioFocusManager     // Catch:{ all -> 0x034d }
            android.content.Context r6 = r5.context     // Catch:{ all -> 0x034d }
            r0.<init>(r6, r7, r4)     // Catch:{ all -> 0x034d }
            r1.audioFocusManager = r0     // Catch:{ all -> 0x034d }
            boolean r6 = r5.handleAudioFocus     // Catch:{ all -> 0x034d }
            if (r6 == 0) goto L_0x02b3
            com.google.android.exoplayer2.audio.AudioAttributes r14 = r1.audioAttributes     // Catch:{ all -> 0x034d }
            goto L_0x02b5
        L_0x02b3:
            r14 = r27
        L_0x02b5:
            r0.setAudioAttributes(r14)     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.StreamVolumeManager r0 = new com.google.android.exoplayer2.StreamVolumeManager     // Catch:{ all -> 0x034d }
            android.content.Context r6 = r5.context     // Catch:{ all -> 0x034d }
            r0.<init>(r6, r7, r4)     // Catch:{ all -> 0x034d }
            r1.streamVolumeManager = r0     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.audio.AudioAttributes r4 = r1.audioAttributes     // Catch:{ all -> 0x034d }
            int r4 = r4.usage     // Catch:{ all -> 0x034d }
            int r4 = com.google.android.exoplayer2.util.Util.getStreamTypeForAudioUsage(r4)     // Catch:{ all -> 0x034d }
            r0.setStreamType(r4)     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.WakeLockManager r4 = new com.google.android.exoplayer2.WakeLockManager     // Catch:{ all -> 0x034d }
            android.content.Context r6 = r5.context     // Catch:{ all -> 0x034d }
            r4.<init>(r6)     // Catch:{ all -> 0x034d }
            r1.wakeLockManager = r4     // Catch:{ all -> 0x034d }
            int r6 = r5.wakeMode     // Catch:{ all -> 0x034d }
            if (r6 == 0) goto L_0x02db
            r12 = r3
            goto L_0x02dc
        L_0x02db:
            r12 = r2
        L_0x02dc:
            r4.setEnabled(r12)     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.WifiLockManager r4 = new com.google.android.exoplayer2.WifiLockManager     // Catch:{ all -> 0x034d }
            android.content.Context r6 = r5.context     // Catch:{ all -> 0x034d }
            r4.<init>(r6)     // Catch:{ all -> 0x034d }
            r1.wifiLockManager = r4     // Catch:{ all -> 0x034d }
            int r5 = r5.wakeMode     // Catch:{ all -> 0x034d }
            r6 = 2
            if (r5 != r6) goto L_0x02ef
            r12 = r3
            goto L_0x02f0
        L_0x02ef:
            r12 = r2
        L_0x02f0:
            r4.setEnabled(r12)     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.DeviceInfo r0 = createDeviceInfo(r0)     // Catch:{ all -> 0x034d }
            r1.deviceInfo = r0     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.video.VideoSize r0 = com.google.android.exoplayer2.video.VideoSize.UNKNOWN     // Catch:{ all -> 0x034d }
            r1.videoSize = r0     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.audio.AudioAttributes r0 = r1.audioAttributes     // Catch:{ all -> 0x034d }
            r5 = r33
            r5.setAudioAttributes(r0)     // Catch:{ all -> 0x034d }
            int r0 = r1.audioSessionId     // Catch:{ all -> 0x034d }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x034d }
            r2 = 10
            r1.sendRendererMessage(r3, r2, r0)     // Catch:{ all -> 0x034d }
            int r0 = r1.audioSessionId     // Catch:{ all -> 0x034d }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x034d }
            r1.sendRendererMessage(r6, r2, r0)     // Catch:{ all -> 0x034d }
            com.google.android.exoplayer2.audio.AudioAttributes r0 = r1.audioAttributes     // Catch:{ all -> 0x034d }
            r2 = 3
            r1.sendRendererMessage(r3, r2, r0)     // Catch:{ all -> 0x034d }
            int r0 = r1.videoScalingMode     // Catch:{ all -> 0x034d }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x034d }
            r2 = 4
            r1.sendRendererMessage(r6, r2, r0)     // Catch:{ all -> 0x034d }
            int r0 = r1.videoChangeFrameRateStrategy     // Catch:{ all -> 0x034d }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x034d }
            r2 = 5
            r1.sendRendererMessage(r6, r2, r0)     // Catch:{ all -> 0x034d }
            boolean r0 = r1.skipSilenceEnabled     // Catch:{ all -> 0x034d }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x034d }
            r2 = 9
            r1.sendRendererMessage(r3, r2, r0)     // Catch:{ all -> 0x034d }
            r0 = r35
            r2 = 7
            r1.sendRendererMessage(r6, r2, r0)     // Catch:{ all -> 0x034d }
            r2 = 8
            r3 = 6
            r1.sendRendererMessage(r3, r2, r0)     // Catch:{ all -> 0x034d }
            r23.open()
            return
        L_0x034d:
            r0 = move-exception
            com.google.android.exoplayer2.util.ConditionVariable r2 = r1.constructorFinished
            r2.open()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImpl.<init>(com.google.android.exoplayer2.ExoPlayer$Builder, com.google.android.exoplayer2.Player):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-google-android-exoplayer2-ExoPlayerImpl  reason: not valid java name */
    public /* synthetic */ void m456lambda$new$0$comgoogleandroidexoplayer2ExoPlayerImpl(Player.Listener listener, FlagSet flagSet) {
        listener.onEvents(this.wrappingPlayer, new Player.Events(flagSet));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$2$com-google-android-exoplayer2-ExoPlayerImpl  reason: not valid java name */
    public /* synthetic */ void m458lambda$new$2$comgoogleandroidexoplayer2ExoPlayerImpl(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.playbackInfoUpdateHandler.post(new ExoPlayerImpl$$ExternalSyntheticLambda24(this, playbackInfoUpdate));
    }

    @Deprecated
    public ExoPlayer.AudioComponent getAudioComponent() {
        verifyApplicationThread();
        return this;
    }

    @Deprecated
    public ExoPlayer.VideoComponent getVideoComponent() {
        verifyApplicationThread();
        return this;
    }

    @Deprecated
    public ExoPlayer.TextComponent getTextComponent() {
        verifyApplicationThread();
        return this;
    }

    @Deprecated
    public ExoPlayer.DeviceComponent getDeviceComponent() {
        verifyApplicationThread();
        return this;
    }

    public void experimentalSetOffloadSchedulingEnabled(boolean z) {
        verifyApplicationThread();
        this.internalPlayer.experimentalSetOffloadSchedulingEnabled(z);
        Iterator<ExoPlayer.AudioOffloadListener> it = this.audioOffloadListeners.iterator();
        while (it.hasNext()) {
            it.next().onExperimentalOffloadSchedulingEnabledChanged(z);
        }
    }

    public boolean experimentalIsSleepingForOffload() {
        verifyApplicationThread();
        return this.playbackInfo.sleepingForOffload;
    }

    public Looper getPlaybackLooper() {
        return this.internalPlayer.getPlaybackLooper();
    }

    public Looper getApplicationLooper() {
        return this.applicationLooper;
    }

    public Clock getClock() {
        return this.clock;
    }

    public void addAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.audioOffloadListeners.add(audioOffloadListener);
    }

    public void removeAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.audioOffloadListeners.remove(audioOffloadListener);
    }

    public Player.Commands getAvailableCommands() {
        verifyApplicationThread();
        return this.availableCommands;
    }

    public int getPlaybackState() {
        verifyApplicationThread();
        return this.playbackInfo.playbackState;
    }

    public int getPlaybackSuppressionReason() {
        verifyApplicationThread();
        return this.playbackInfo.playbackSuppressionReason;
    }

    public ExoPlaybackException getPlayerError() {
        verifyApplicationThread();
        return this.playbackInfo.playbackError;
    }

    @Deprecated
    public void retry() {
        verifyApplicationThread();
        prepare();
    }

    public void prepare() {
        verifyApplicationThread();
        boolean playWhenReady = getPlayWhenReady();
        int i = 2;
        int updateAudioFocus = this.audioFocusManager.updateAudioFocus(playWhenReady, 2);
        updatePlayWhenReady(playWhenReady, updateAudioFocus, getPlayWhenReadyChangeReason(playWhenReady, updateAudioFocus));
        if (this.playbackInfo.playbackState == 1) {
            PlaybackInfo copyWithPlaybackError = this.playbackInfo.copyWithPlaybackError((ExoPlaybackException) null);
            if (copyWithPlaybackError.timeline.isEmpty()) {
                i = 4;
            }
            PlaybackInfo copyWithPlaybackState = copyWithPlaybackError.copyWithPlaybackState(i);
            this.pendingOperationAcks++;
            this.internalPlayer.prepare();
            updatePlaybackInfo(copyWithPlaybackState, 1, 1, false, false, 5, C.TIME_UNSET, -1);
        }
    }

    @Deprecated
    public void prepare(MediaSource mediaSource) {
        verifyApplicationThread();
        setMediaSource(mediaSource);
        prepare();
    }

    @Deprecated
    public void prepare(MediaSource mediaSource, boolean z, boolean z2) {
        verifyApplicationThread();
        setMediaSource(mediaSource, z);
        prepare();
    }

    public void setMediaItems(List<MediaItem> list, boolean z) {
        verifyApplicationThread();
        setMediaSources(createMediaSources(list), z);
    }

    public void setMediaItems(List<MediaItem> list, int i, long j) {
        verifyApplicationThread();
        setMediaSources(createMediaSources(list), i, j);
    }

    public void setMediaSource(MediaSource mediaSource) {
        verifyApplicationThread();
        setMediaSources(Collections.singletonList(mediaSource));
    }

    public void setMediaSource(MediaSource mediaSource, long j) {
        verifyApplicationThread();
        setMediaSources(Collections.singletonList(mediaSource), 0, j);
    }

    public void setMediaSource(MediaSource mediaSource, boolean z) {
        verifyApplicationThread();
        setMediaSources(Collections.singletonList(mediaSource), z);
    }

    public void setMediaSources(List<MediaSource> list) {
        verifyApplicationThread();
        setMediaSources(list, true);
    }

    public void setMediaSources(List<MediaSource> list, boolean z) {
        verifyApplicationThread();
        setMediaSourcesInternal(list, -1, C.TIME_UNSET, z);
    }

    public void setMediaSources(List<MediaSource> list, int i, long j) {
        verifyApplicationThread();
        setMediaSourcesInternal(list, i, j, false);
    }

    public void addMediaItems(int i, List<MediaItem> list) {
        verifyApplicationThread();
        addMediaSources(Math.min(i, this.mediaSourceHolderSnapshots.size()), createMediaSources(list));
    }

    public void addMediaSource(MediaSource mediaSource) {
        verifyApplicationThread();
        addMediaSources(Collections.singletonList(mediaSource));
    }

    public void addMediaSource(int i, MediaSource mediaSource) {
        verifyApplicationThread();
        addMediaSources(i, Collections.singletonList(mediaSource));
    }

    public void addMediaSources(List<MediaSource> list) {
        verifyApplicationThread();
        addMediaSources(this.mediaSourceHolderSnapshots.size(), list);
    }

    public void addMediaSources(int i, List<MediaSource> list) {
        verifyApplicationThread();
        Assertions.checkArgument(i >= 0);
        Timeline currentTimeline = getCurrentTimeline();
        this.pendingOperationAcks++;
        List<MediaSourceList.MediaSourceHolder> addMediaSourceHolders = addMediaSourceHolders(i, list);
        Timeline createMaskingTimeline = createMaskingTimeline();
        PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, getPeriodPositionUsAfterTimelineChanged(currentTimeline, createMaskingTimeline));
        this.internalPlayer.addMediaSources(i, addMediaSourceHolders, this.shuffleOrder);
        updatePlaybackInfo(maskTimelineAndPosition, 0, 1, false, false, 5, C.TIME_UNSET, -1);
    }

    public void removeMediaItems(int i, int i2) {
        verifyApplicationThread();
        PlaybackInfo removeMediaItemsInternal = removeMediaItemsInternal(i, Math.min(i2, this.mediaSourceHolderSnapshots.size()));
        updatePlaybackInfo(removeMediaItemsInternal, 0, 1, false, !removeMediaItemsInternal.periodId.periodUid.equals(this.playbackInfo.periodId.periodUid), 4, getCurrentPositionUsInternal(removeMediaItemsInternal), -1);
    }

    public void moveMediaItems(int i, int i2, int i3) {
        verifyApplicationThread();
        Assertions.checkArgument(i >= 0 && i <= i2 && i2 <= this.mediaSourceHolderSnapshots.size() && i3 >= 0);
        Timeline currentTimeline = getCurrentTimeline();
        this.pendingOperationAcks++;
        int min = Math.min(i3, this.mediaSourceHolderSnapshots.size() - (i2 - i));
        Util.moveItems(this.mediaSourceHolderSnapshots, i, i2, min);
        Timeline createMaskingTimeline = createMaskingTimeline();
        PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, getPeriodPositionUsAfterTimelineChanged(currentTimeline, createMaskingTimeline));
        this.internalPlayer.moveMediaSources(i, i2, min, this.shuffleOrder);
        updatePlaybackInfo(maskTimelineAndPosition, 0, 1, false, false, 5, C.TIME_UNSET, -1);
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder2) {
        verifyApplicationThread();
        this.shuffleOrder = shuffleOrder2;
        Timeline createMaskingTimeline = createMaskingTimeline();
        PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, maskWindowPositionMsOrGetPeriodPositionUs(createMaskingTimeline, getCurrentMediaItemIndex(), getCurrentPosition()));
        this.pendingOperationAcks++;
        this.internalPlayer.setShuffleOrder(shuffleOrder2);
        updatePlaybackInfo(maskTimelineAndPosition, 0, 1, false, false, 5, C.TIME_UNSET, -1);
    }

    public void setPauseAtEndOfMediaItems(boolean z) {
        verifyApplicationThread();
        if (this.pauseAtEndOfMediaItems != z) {
            this.pauseAtEndOfMediaItems = z;
            this.internalPlayer.setPauseAtEndOfWindow(z);
        }
    }

    public boolean getPauseAtEndOfMediaItems() {
        verifyApplicationThread();
        return this.pauseAtEndOfMediaItems;
    }

    public void setPlayWhenReady(boolean z) {
        verifyApplicationThread();
        int updateAudioFocus = this.audioFocusManager.updateAudioFocus(z, getPlaybackState());
        updatePlayWhenReady(z, updateAudioFocus, getPlayWhenReadyChangeReason(z, updateAudioFocus));
    }

    public boolean getPlayWhenReady() {
        verifyApplicationThread();
        return this.playbackInfo.playWhenReady;
    }

    public void setRepeatMode(int i) {
        verifyApplicationThread();
        if (this.repeatMode != i) {
            this.repeatMode = i;
            this.internalPlayer.setRepeatMode(i);
            this.listeners.queueEvent(8, new ExoPlayerImpl$$ExternalSyntheticLambda18(i));
            updateAvailableCommands();
            this.listeners.flushEvents();
        }
    }

    public int getRepeatMode() {
        verifyApplicationThread();
        return this.repeatMode;
    }

    public void setShuffleModeEnabled(boolean z) {
        verifyApplicationThread();
        if (this.shuffleModeEnabled != z) {
            this.shuffleModeEnabled = z;
            this.internalPlayer.setShuffleModeEnabled(z);
            this.listeners.queueEvent(9, new ExoPlayerImpl$$ExternalSyntheticLambda27(z));
            updateAvailableCommands();
            this.listeners.flushEvents();
        }
    }

    public boolean getShuffleModeEnabled() {
        verifyApplicationThread();
        return this.shuffleModeEnabled;
    }

    public boolean isLoading() {
        verifyApplicationThread();
        return this.playbackInfo.isLoading;
    }

    public void seekTo(int i, long j) {
        int i2 = i;
        long j2 = j;
        verifyApplicationThread();
        this.analyticsCollector.notifySeekStarted();
        Timeline timeline = this.playbackInfo.timeline;
        if (i2 < 0 || (!timeline.isEmpty() && i2 >= timeline.getWindowCount())) {
            throw new IllegalSeekPositionException(timeline, i, j2);
        }
        int i3 = 1;
        this.pendingOperationAcks++;
        if (isPlayingAd()) {
            Log.w(TAG, "seekTo ignored because an ad is playing");
            ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate = new ExoPlayerImplInternal.PlaybackInfoUpdate(this.playbackInfo);
            playbackInfoUpdate.incrementPendingOperationAcks(1);
            this.playbackInfoUpdateListener.onPlaybackInfoUpdate(playbackInfoUpdate);
            return;
        }
        if (getPlaybackState() != 1) {
            i3 = 2;
        }
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo.copyWithPlaybackState(i3), timeline, maskWindowPositionMsOrGetPeriodPositionUs(timeline, i, j2));
        this.internalPlayer.seekTo(timeline, i, Util.msToUs(j));
        updatePlaybackInfo(maskTimelineAndPosition, 0, 1, true, true, 1, getCurrentPositionUsInternal(maskTimelineAndPosition), currentMediaItemIndex);
    }

    public long getSeekBackIncrement() {
        verifyApplicationThread();
        return this.seekBackIncrementMs;
    }

    public long getSeekForwardIncrement() {
        verifyApplicationThread();
        return this.seekForwardIncrementMs;
    }

    public long getMaxSeekToPreviousPosition() {
        verifyApplicationThread();
        return 3000;
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        verifyApplicationThread();
        if (playbackParameters == null) {
            playbackParameters = PlaybackParameters.DEFAULT;
        }
        if (!this.playbackInfo.playbackParameters.equals(playbackParameters)) {
            PlaybackInfo copyWithPlaybackParameters = this.playbackInfo.copyWithPlaybackParameters(playbackParameters);
            this.pendingOperationAcks++;
            this.internalPlayer.setPlaybackParameters(playbackParameters);
            updatePlaybackInfo(copyWithPlaybackParameters, 0, 1, false, false, 5, C.TIME_UNSET, -1);
        }
    }

    public PlaybackParameters getPlaybackParameters() {
        verifyApplicationThread();
        return this.playbackInfo.playbackParameters;
    }

    public void setSeekParameters(SeekParameters seekParameters2) {
        verifyApplicationThread();
        if (seekParameters2 == null) {
            seekParameters2 = SeekParameters.DEFAULT;
        }
        if (!this.seekParameters.equals(seekParameters2)) {
            this.seekParameters = seekParameters2;
            this.internalPlayer.setSeekParameters(seekParameters2);
        }
    }

    public SeekParameters getSeekParameters() {
        verifyApplicationThread();
        return this.seekParameters;
    }

    public void setForegroundMode(boolean z) {
        verifyApplicationThread();
        if (this.foregroundMode != z) {
            this.foregroundMode = z;
            if (!this.internalPlayer.setForegroundMode(z)) {
                stopInternal(false, ExoPlaybackException.createForUnexpected(new ExoTimeoutException(2), 1003));
            }
        }
    }

    public void stop() {
        verifyApplicationThread();
        stop(false);
    }

    public void stop(boolean z) {
        verifyApplicationThread();
        this.audioFocusManager.updateAudioFocus(getPlayWhenReady(), 1);
        stopInternal(z, (ExoPlaybackException) null);
        this.currentCueGroup = CueGroup.EMPTY;
    }

    public void release() {
        AudioTrack audioTrack;
        Log.i(TAG, "Release " + Integer.toHexString(System.identityHashCode(this)) + " [" + ExoPlayerLibraryInfo.VERSION_SLASHY + "] [" + Util.DEVICE_DEBUG_INFO + "] [" + ExoPlayerLibraryInfo.registeredModules() + "]");
        verifyApplicationThread();
        if (Util.SDK_INT < 21 && (audioTrack = this.keepSessionIdAudioTrack) != null) {
            audioTrack.release();
            this.keepSessionIdAudioTrack = null;
        }
        this.audioBecomingNoisyManager.setEnabled(false);
        this.streamVolumeManager.release();
        this.wakeLockManager.setStayAwake(false);
        this.wifiLockManager.setStayAwake(false);
        this.audioFocusManager.release();
        if (!this.internalPlayer.release()) {
            this.listeners.sendEvent(10, new ExoPlayerImpl$$ExternalSyntheticLambda16());
        }
        this.listeners.release();
        this.playbackInfoUpdateHandler.removeCallbacksAndMessages((Object) null);
        this.bandwidthMeter.removeEventListener(this.analyticsCollector);
        PlaybackInfo copyWithPlaybackState = this.playbackInfo.copyWithPlaybackState(1);
        this.playbackInfo = copyWithPlaybackState;
        PlaybackInfo copyWithLoadingMediaPeriodId = copyWithPlaybackState.copyWithLoadingMediaPeriodId(copyWithPlaybackState.periodId);
        this.playbackInfo = copyWithLoadingMediaPeriodId;
        copyWithLoadingMediaPeriodId.bufferedPositionUs = copyWithLoadingMediaPeriodId.positionUs;
        this.playbackInfo.totalBufferedDurationUs = 0;
        this.analyticsCollector.release();
        this.trackSelector.release();
        removeSurfaceCallbacks();
        Surface surface = this.ownedSurface;
        if (surface != null) {
            surface.release();
            this.ownedSurface = null;
        }
        if (this.isPriorityTaskManagerRegistered) {
            ((PriorityTaskManager) Assertions.checkNotNull(this.priorityTaskManager)).remove(0);
            this.isPriorityTaskManagerRegistered = false;
        }
        this.currentCueGroup = CueGroup.EMPTY;
        this.playerReleased = true;
    }

    public PlayerMessage createMessage(PlayerMessage.Target target) {
        verifyApplicationThread();
        return createMessageInternal(target);
    }

    public int getCurrentPeriodIndex() {
        verifyApplicationThread();
        if (this.playbackInfo.timeline.isEmpty()) {
            return this.maskingPeriodIndex;
        }
        return this.playbackInfo.timeline.getIndexOfPeriod(this.playbackInfo.periodId.periodUid);
    }

    public int getCurrentMediaItemIndex() {
        verifyApplicationThread();
        int currentWindowIndexInternal = getCurrentWindowIndexInternal();
        if (currentWindowIndexInternal == -1) {
            return 0;
        }
        return currentWindowIndexInternal;
    }

    public long getDuration() {
        verifyApplicationThread();
        if (!isPlayingAd()) {
            return getContentDuration();
        }
        MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
        this.playbackInfo.timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        return Util.usToMs(this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup));
    }

    public long getCurrentPosition() {
        verifyApplicationThread();
        return Util.usToMs(getCurrentPositionUsInternal(this.playbackInfo));
    }

    public long getBufferedPosition() {
        verifyApplicationThread();
        if (!isPlayingAd()) {
            return getContentBufferedPosition();
        }
        if (this.playbackInfo.loadingMediaPeriodId.equals(this.playbackInfo.periodId)) {
            return Util.usToMs(this.playbackInfo.bufferedPositionUs);
        }
        return getDuration();
    }

    public long getTotalBufferedDuration() {
        verifyApplicationThread();
        return Util.usToMs(this.playbackInfo.totalBufferedDurationUs);
    }

    public boolean isPlayingAd() {
        verifyApplicationThread();
        return this.playbackInfo.periodId.isAd();
    }

    public int getCurrentAdGroupIndex() {
        verifyApplicationThread();
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adGroupIndex;
        }
        return -1;
    }

    public int getCurrentAdIndexInAdGroup() {
        verifyApplicationThread();
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adIndexInAdGroup;
        }
        return -1;
    }

    public long getContentPosition() {
        verifyApplicationThread();
        if (!isPlayingAd()) {
            return getCurrentPosition();
        }
        this.playbackInfo.timeline.getPeriodByUid(this.playbackInfo.periodId.periodUid, this.period);
        if (this.playbackInfo.requestedContentPositionUs == C.TIME_UNSET) {
            return this.playbackInfo.timeline.getWindow(getCurrentMediaItemIndex(), this.window).getDefaultPositionMs();
        }
        return this.period.getPositionInWindowMs() + Util.usToMs(this.playbackInfo.requestedContentPositionUs);
    }

    public long getContentBufferedPosition() {
        verifyApplicationThread();
        if (this.playbackInfo.timeline.isEmpty()) {
            return this.maskingWindowPositionMs;
        }
        if (this.playbackInfo.loadingMediaPeriodId.windowSequenceNumber != this.playbackInfo.periodId.windowSequenceNumber) {
            return this.playbackInfo.timeline.getWindow(getCurrentMediaItemIndex(), this.window).getDurationMs();
        }
        long j = this.playbackInfo.bufferedPositionUs;
        if (this.playbackInfo.loadingMediaPeriodId.isAd()) {
            Timeline.Period periodByUid = this.playbackInfo.timeline.getPeriodByUid(this.playbackInfo.loadingMediaPeriodId.periodUid, this.period);
            long adGroupTimeUs = periodByUid.getAdGroupTimeUs(this.playbackInfo.loadingMediaPeriodId.adGroupIndex);
            j = adGroupTimeUs == Long.MIN_VALUE ? periodByUid.durationUs : adGroupTimeUs;
        }
        return Util.usToMs(periodPositionUsToWindowPositionUs(this.playbackInfo.timeline, this.playbackInfo.loadingMediaPeriodId, j));
    }

    public int getRendererCount() {
        verifyApplicationThread();
        return this.renderers.length;
    }

    public int getRendererType(int i) {
        verifyApplicationThread();
        return this.renderers[i].getTrackType();
    }

    public Renderer getRenderer(int i) {
        verifyApplicationThread();
        return this.renderers[i];
    }

    public TrackSelector getTrackSelector() {
        verifyApplicationThread();
        return this.trackSelector;
    }

    public TrackGroupArray getCurrentTrackGroups() {
        verifyApplicationThread();
        return this.playbackInfo.trackGroups;
    }

    public TrackSelectionArray getCurrentTrackSelections() {
        verifyApplicationThread();
        return new TrackSelectionArray(this.playbackInfo.trackSelectorResult.selections);
    }

    public Tracks getCurrentTracks() {
        verifyApplicationThread();
        return this.playbackInfo.trackSelectorResult.tracks;
    }

    public TrackSelectionParameters getTrackSelectionParameters() {
        verifyApplicationThread();
        return this.trackSelector.getParameters();
    }

    public void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        verifyApplicationThread();
        if (this.trackSelector.isSetParametersSupported() && !trackSelectionParameters.equals(this.trackSelector.getParameters())) {
            this.trackSelector.setParameters(trackSelectionParameters);
            this.listeners.sendEvent(19, new ExoPlayerImpl$$ExternalSyntheticLambda19(trackSelectionParameters));
        }
    }

    public MediaMetadata getMediaMetadata() {
        verifyApplicationThread();
        return this.mediaMetadata;
    }

    public MediaMetadata getPlaylistMetadata() {
        verifyApplicationThread();
        return this.playlistMetadata;
    }

    public void setPlaylistMetadata(MediaMetadata mediaMetadata2) {
        verifyApplicationThread();
        Assertions.checkNotNull(mediaMetadata2);
        if (!mediaMetadata2.equals(this.playlistMetadata)) {
            this.playlistMetadata = mediaMetadata2;
            this.listeners.sendEvent(15, new ExoPlayerImpl$$ExternalSyntheticLambda26(this));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setPlaylistMetadata$7$com-google-android-exoplayer2-ExoPlayerImpl  reason: not valid java name */
    public /* synthetic */ void m459lambda$setPlaylistMetadata$7$comgoogleandroidexoplayer2ExoPlayerImpl(Player.Listener listener) {
        listener.onPlaylistMetadataChanged(this.playlistMetadata);
    }

    public Timeline getCurrentTimeline() {
        verifyApplicationThread();
        return this.playbackInfo.timeline;
    }

    public void setVideoScalingMode(int i) {
        verifyApplicationThread();
        this.videoScalingMode = i;
        sendRendererMessage(2, 4, Integer.valueOf(i));
    }

    public int getVideoScalingMode() {
        verifyApplicationThread();
        return this.videoScalingMode;
    }

    public void setVideoChangeFrameRateStrategy(int i) {
        verifyApplicationThread();
        if (this.videoChangeFrameRateStrategy != i) {
            this.videoChangeFrameRateStrategy = i;
            sendRendererMessage(2, 5, Integer.valueOf(i));
        }
    }

    public int getVideoChangeFrameRateStrategy() {
        verifyApplicationThread();
        return this.videoChangeFrameRateStrategy;
    }

    public VideoSize getVideoSize() {
        verifyApplicationThread();
        return this.videoSize;
    }

    public void clearVideoSurface() {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        setVideoOutputInternal((Object) null);
        maybeNotifySurfaceSizeChanged(0, 0);
    }

    public void clearVideoSurface(Surface surface) {
        verifyApplicationThread();
        if (surface != null && surface == this.videoOutput) {
            clearVideoSurface();
        }
    }

    public void setVideoSurface(Surface surface) {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        setVideoOutputInternal(surface);
        int i = surface == null ? 0 : -1;
        maybeNotifySurfaceSizeChanged(i, i);
    }

    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder2) {
        verifyApplicationThread();
        if (surfaceHolder2 == null) {
            clearVideoSurface();
            return;
        }
        removeSurfaceCallbacks();
        this.surfaceHolderSurfaceIsVideoOutput = true;
        this.surfaceHolder = surfaceHolder2;
        surfaceHolder2.addCallback(this.componentListener);
        Surface surface = surfaceHolder2.getSurface();
        if (surface == null || !surface.isValid()) {
            setVideoOutputInternal((Object) null);
            maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        setVideoOutputInternal(surface);
        Rect surfaceFrame = surfaceHolder2.getSurfaceFrame();
        maybeNotifySurfaceSizeChanged(surfaceFrame.width(), surfaceFrame.height());
    }

    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder2) {
        verifyApplicationThread();
        if (surfaceHolder2 != null && surfaceHolder2 == this.surfaceHolder) {
            clearVideoSurface();
        }
    }

    public void setVideoSurfaceView(SurfaceView surfaceView) {
        SurfaceHolder surfaceHolder2;
        verifyApplicationThread();
        if (surfaceView instanceof VideoDecoderOutputBufferRenderer) {
            removeSurfaceCallbacks();
            setVideoOutputInternal(surfaceView);
            setNonVideoOutputSurfaceHolderInternal(surfaceView.getHolder());
        } else if (surfaceView instanceof SphericalGLSurfaceView) {
            removeSurfaceCallbacks();
            this.sphericalGLSurfaceView = (SphericalGLSurfaceView) surfaceView;
            createMessageInternal(this.frameMetadataListener).setType(10000).setPayload(this.sphericalGLSurfaceView).send();
            this.sphericalGLSurfaceView.addVideoSurfaceListener(this.componentListener);
            setVideoOutputInternal(this.sphericalGLSurfaceView.getVideoSurface());
            setNonVideoOutputSurfaceHolderInternal(surfaceView.getHolder());
        } else {
            if (surfaceView == null) {
                surfaceHolder2 = null;
            } else {
                surfaceHolder2 = surfaceView.getHolder();
            }
            setVideoSurfaceHolder(surfaceHolder2);
        }
    }

    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        SurfaceHolder surfaceHolder2;
        verifyApplicationThread();
        if (surfaceView == null) {
            surfaceHolder2 = null;
        } else {
            surfaceHolder2 = surfaceView.getHolder();
        }
        clearVideoSurfaceHolder(surfaceHolder2);
    }

    public void setVideoTextureView(TextureView textureView2) {
        verifyApplicationThread();
        if (textureView2 == null) {
            clearVideoSurface();
            return;
        }
        removeSurfaceCallbacks();
        this.textureView = textureView2;
        if (textureView2.getSurfaceTextureListener() != null) {
            Log.w(TAG, "Replacing existing SurfaceTextureListener.");
        }
        textureView2.setSurfaceTextureListener(this.componentListener);
        SurfaceTexture surfaceTexture = textureView2.isAvailable() ? textureView2.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            setVideoOutputInternal((Object) null);
            maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        setSurfaceTextureInternal(surfaceTexture);
        maybeNotifySurfaceSizeChanged(textureView2.getWidth(), textureView2.getHeight());
    }

    public void clearVideoTextureView(TextureView textureView2) {
        verifyApplicationThread();
        if (textureView2 != null && textureView2 == this.textureView) {
            clearVideoSurface();
        }
    }

    public void setAudioAttributes(AudioAttributes audioAttributes2, boolean z) {
        verifyApplicationThread();
        if (!this.playerReleased) {
            if (!Util.areEqual(this.audioAttributes, audioAttributes2)) {
                this.audioAttributes = audioAttributes2;
                sendRendererMessage(1, 3, audioAttributes2);
                this.streamVolumeManager.setStreamType(Util.getStreamTypeForAudioUsage(audioAttributes2.usage));
                this.listeners.queueEvent(20, new ExoPlayerImpl$$ExternalSyntheticLambda23(audioAttributes2));
            }
            this.audioFocusManager.setAudioAttributes(z ? audioAttributes2 : null);
            this.trackSelector.setAudioAttributes(audioAttributes2);
            boolean playWhenReady = getPlayWhenReady();
            int updateAudioFocus = this.audioFocusManager.updateAudioFocus(playWhenReady, getPlaybackState());
            updatePlayWhenReady(playWhenReady, updateAudioFocus, getPlayWhenReadyChangeReason(playWhenReady, updateAudioFocus));
            this.listeners.flushEvents();
        }
    }

    public AudioAttributes getAudioAttributes() {
        verifyApplicationThread();
        return this.audioAttributes;
    }

    public void setAudioSessionId(int i) {
        verifyApplicationThread();
        if (this.audioSessionId != i) {
            if (i == 0) {
                if (Util.SDK_INT < 21) {
                    i = initializeKeepSessionIdAudioTrack(0);
                } else {
                    i = Util.generateAudioSessionIdV21(this.applicationContext);
                }
            } else if (Util.SDK_INT < 21) {
                initializeKeepSessionIdAudioTrack(i);
            }
            this.audioSessionId = i;
            sendRendererMessage(1, 10, Integer.valueOf(i));
            sendRendererMessage(2, 10, Integer.valueOf(i));
            this.listeners.sendEvent(21, new ExoPlayerImpl$$ExternalSyntheticLambda25(i));
        }
    }

    public int getAudioSessionId() {
        verifyApplicationThread();
        return this.audioSessionId;
    }

    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        verifyApplicationThread();
        sendRendererMessage(1, 6, auxEffectInfo);
    }

    public void clearAuxEffectInfo() {
        verifyApplicationThread();
        setAuxEffectInfo(new AuxEffectInfo(0, 0.0f));
    }

    public void setVolume(float f) {
        verifyApplicationThread();
        float constrainValue = Util.constrainValue(f, 0.0f, 1.0f);
        if (this.volume != constrainValue) {
            this.volume = constrainValue;
            sendVolumeToRenderers();
            this.listeners.sendEvent(22, new ExoPlayerImpl$$ExternalSyntheticLambda17(constrainValue));
        }
    }

    public float getVolume() {
        verifyApplicationThread();
        return this.volume;
    }

    public boolean getSkipSilenceEnabled() {
        verifyApplicationThread();
        return this.skipSilenceEnabled;
    }

    public void setSkipSilenceEnabled(boolean z) {
        verifyApplicationThread();
        if (this.skipSilenceEnabled != z) {
            this.skipSilenceEnabled = z;
            sendRendererMessage(1, 9, Boolean.valueOf(z));
            this.listeners.sendEvent(23, new ExoPlayerImpl$$ExternalSyntheticLambda22(z));
        }
    }

    public AnalyticsCollector getAnalyticsCollector() {
        verifyApplicationThread();
        return this.analyticsCollector;
    }

    public void addAnalyticsListener(AnalyticsListener analyticsListener) {
        Assertions.checkNotNull(analyticsListener);
        this.analyticsCollector.addListener(analyticsListener);
    }

    public void removeAnalyticsListener(AnalyticsListener analyticsListener) {
        this.analyticsCollector.removeListener(analyticsListener);
    }

    public void setHandleAudioBecomingNoisy(boolean z) {
        verifyApplicationThread();
        if (!this.playerReleased) {
            this.audioBecomingNoisyManager.setEnabled(z);
        }
    }

    public void setPriorityTaskManager(PriorityTaskManager priorityTaskManager2) {
        verifyApplicationThread();
        if (!Util.areEqual(this.priorityTaskManager, priorityTaskManager2)) {
            if (this.isPriorityTaskManagerRegistered) {
                ((PriorityTaskManager) Assertions.checkNotNull(this.priorityTaskManager)).remove(0);
            }
            if (priorityTaskManager2 == null || !isLoading()) {
                this.isPriorityTaskManagerRegistered = false;
            } else {
                priorityTaskManager2.add(0);
                this.isPriorityTaskManagerRegistered = true;
            }
            this.priorityTaskManager = priorityTaskManager2;
        }
    }

    public Format getVideoFormat() {
        verifyApplicationThread();
        return this.videoFormat;
    }

    public Format getAudioFormat() {
        verifyApplicationThread();
        return this.audioFormat;
    }

    public DecoderCounters getVideoDecoderCounters() {
        verifyApplicationThread();
        return this.videoDecoderCounters;
    }

    public DecoderCounters getAudioDecoderCounters() {
        verifyApplicationThread();
        return this.audioDecoderCounters;
    }

    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener2) {
        verifyApplicationThread();
        this.videoFrameMetadataListener = videoFrameMetadataListener2;
        createMessageInternal(this.frameMetadataListener).setType(7).setPayload(videoFrameMetadataListener2).send();
    }

    public void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener2) {
        verifyApplicationThread();
        if (this.videoFrameMetadataListener == videoFrameMetadataListener2) {
            createMessageInternal(this.frameMetadataListener).setType(7).setPayload((Object) null).send();
        }
    }

    public void setCameraMotionListener(CameraMotionListener cameraMotionListener2) {
        verifyApplicationThread();
        this.cameraMotionListener = cameraMotionListener2;
        createMessageInternal(this.frameMetadataListener).setType(8).setPayload(cameraMotionListener2).send();
    }

    public void clearCameraMotionListener(CameraMotionListener cameraMotionListener2) {
        verifyApplicationThread();
        if (this.cameraMotionListener == cameraMotionListener2) {
            createMessageInternal(this.frameMetadataListener).setType(8).setPayload((Object) null).send();
        }
    }

    public CueGroup getCurrentCues() {
        verifyApplicationThread();
        return this.currentCueGroup;
    }

    public void addListener(Player.Listener listener) {
        Assertions.checkNotNull(listener);
        this.listeners.add(listener);
    }

    public void removeListener(Player.Listener listener) {
        Assertions.checkNotNull(listener);
        this.listeners.remove(listener);
    }

    public void setHandleWakeLock(boolean z) {
        verifyApplicationThread();
        setWakeMode(z ? 1 : 0);
    }

    public void setWakeMode(int i) {
        verifyApplicationThread();
        if (i == 0) {
            this.wakeLockManager.setEnabled(false);
            this.wifiLockManager.setEnabled(false);
        } else if (i == 1) {
            this.wakeLockManager.setEnabled(true);
            this.wifiLockManager.setEnabled(false);
        } else if (i == 2) {
            this.wakeLockManager.setEnabled(true);
            this.wifiLockManager.setEnabled(true);
        }
    }

    public DeviceInfo getDeviceInfo() {
        verifyApplicationThread();
        return this.deviceInfo;
    }

    public int getDeviceVolume() {
        verifyApplicationThread();
        return this.streamVolumeManager.getVolume();
    }

    public boolean isDeviceMuted() {
        verifyApplicationThread();
        return this.streamVolumeManager.isMuted();
    }

    public void setDeviceVolume(int i) {
        verifyApplicationThread();
        this.streamVolumeManager.setVolume(i);
    }

    public void increaseDeviceVolume() {
        verifyApplicationThread();
        this.streamVolumeManager.increaseVolume();
    }

    public void decreaseDeviceVolume() {
        verifyApplicationThread();
        this.streamVolumeManager.decreaseVolume();
    }

    public void setDeviceMuted(boolean z) {
        verifyApplicationThread();
        this.streamVolumeManager.setMuted(z);
    }

    /* access modifiers changed from: package-private */
    public void setThrowsWhenUsingWrongThread(boolean z) {
        this.throwsWhenUsingWrongThread = z;
    }

    private void stopInternal(boolean z, ExoPlaybackException exoPlaybackException) {
        PlaybackInfo playbackInfo2;
        if (z) {
            playbackInfo2 = removeMediaItemsInternal(0, this.mediaSourceHolderSnapshots.size()).copyWithPlaybackError((ExoPlaybackException) null);
        } else {
            PlaybackInfo playbackInfo3 = this.playbackInfo;
            playbackInfo2 = playbackInfo3.copyWithLoadingMediaPeriodId(playbackInfo3.periodId);
            playbackInfo2.bufferedPositionUs = playbackInfo2.positionUs;
            playbackInfo2.totalBufferedDurationUs = 0;
        }
        PlaybackInfo copyWithPlaybackState = playbackInfo2.copyWithPlaybackState(1);
        if (exoPlaybackException != null) {
            copyWithPlaybackState = copyWithPlaybackState.copyWithPlaybackError(exoPlaybackException);
        }
        PlaybackInfo playbackInfo4 = copyWithPlaybackState;
        this.pendingOperationAcks++;
        this.internalPlayer.stop();
        updatePlaybackInfo(playbackInfo4, 0, 1, false, playbackInfo4.timeline.isEmpty() && !this.playbackInfo.timeline.isEmpty(), 4, getCurrentPositionUsInternal(playbackInfo4), -1);
    }

    private int getCurrentWindowIndexInternal() {
        if (this.playbackInfo.timeline.isEmpty()) {
            return this.maskingWindowIndex;
        }
        return this.playbackInfo.timeline.getPeriodByUid(this.playbackInfo.periodId.periodUid, this.period).windowIndex;
    }

    private long getCurrentPositionUsInternal(PlaybackInfo playbackInfo2) {
        if (playbackInfo2.timeline.isEmpty()) {
            return Util.msToUs(this.maskingWindowPositionMs);
        }
        if (playbackInfo2.periodId.isAd()) {
            return playbackInfo2.positionUs;
        }
        return periodPositionUsToWindowPositionUs(playbackInfo2.timeline, playbackInfo2.periodId, playbackInfo2.positionUs);
    }

    private List<MediaSource> createMediaSources(List<MediaItem> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(this.mediaSourceFactory.createMediaSource(list.get(i)));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: handlePlaybackInfo */
    public void m457lambda$new$1$comgoogleandroidexoplayer2ExoPlayerImpl(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        long j;
        boolean z;
        this.pendingOperationAcks -= playbackInfoUpdate.operationAcks;
        boolean z2 = true;
        if (playbackInfoUpdate.positionDiscontinuity) {
            this.pendingDiscontinuityReason = playbackInfoUpdate.discontinuityReason;
            this.pendingDiscontinuity = true;
        }
        if (playbackInfoUpdate.hasPlayWhenReadyChangeReason) {
            this.pendingPlayWhenReadyChangeReason = playbackInfoUpdate.playWhenReadyChangeReason;
        }
        if (this.pendingOperationAcks == 0) {
            Timeline timeline = playbackInfoUpdate.playbackInfo.timeline;
            if (!this.playbackInfo.timeline.isEmpty() && timeline.isEmpty()) {
                this.maskingWindowIndex = -1;
                this.maskingWindowPositionMs = 0;
                this.maskingPeriodIndex = 0;
            }
            if (!timeline.isEmpty()) {
                List<Timeline> childTimelines = ((PlaylistTimeline) timeline).getChildTimelines();
                Assertions.checkState(childTimelines.size() == this.mediaSourceHolderSnapshots.size());
                for (int i = 0; i < childTimelines.size(); i++) {
                    Timeline unused = this.mediaSourceHolderSnapshots.get(i).timeline = childTimelines.get(i);
                }
            }
            long j2 = C.TIME_UNSET;
            if (this.pendingDiscontinuity) {
                if (playbackInfoUpdate.playbackInfo.periodId.equals(this.playbackInfo.periodId) && playbackInfoUpdate.playbackInfo.discontinuityStartPositionUs == this.playbackInfo.positionUs) {
                    z2 = false;
                }
                if (z2) {
                    if (timeline.isEmpty() || playbackInfoUpdate.playbackInfo.periodId.isAd()) {
                        j2 = playbackInfoUpdate.playbackInfo.discontinuityStartPositionUs;
                    } else {
                        j2 = periodPositionUsToWindowPositionUs(timeline, playbackInfoUpdate.playbackInfo.periodId, playbackInfoUpdate.playbackInfo.discontinuityStartPositionUs);
                    }
                }
                j = j2;
                z = z2;
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            this.pendingDiscontinuity = false;
            updatePlaybackInfo(playbackInfoUpdate.playbackInfo, 1, this.pendingPlayWhenReadyChangeReason, false, z, this.pendingDiscontinuityReason, j, -1);
        }
    }

    private void updatePlaybackInfo(PlaybackInfo playbackInfo2, int i, int i2, boolean z, boolean z2, int i3, long j, int i4) {
        PlaybackInfo playbackInfo3 = playbackInfo2;
        int i5 = i3;
        PlaybackInfo playbackInfo4 = this.playbackInfo;
        this.playbackInfo = playbackInfo3;
        Pair<Boolean, Integer> evaluateMediaItemTransitionReason = evaluateMediaItemTransitionReason(playbackInfo2, playbackInfo4, z2, i3, !playbackInfo4.timeline.equals(playbackInfo3.timeline));
        boolean booleanValue = ((Boolean) evaluateMediaItemTransitionReason.first).booleanValue();
        int intValue = ((Integer) evaluateMediaItemTransitionReason.second).intValue();
        MediaMetadata mediaMetadata2 = this.mediaMetadata;
        MediaItem mediaItem = null;
        if (booleanValue) {
            if (!playbackInfo3.timeline.isEmpty()) {
                mediaItem = playbackInfo3.timeline.getWindow(playbackInfo3.timeline.getPeriodByUid(playbackInfo3.periodId.periodUid, this.period).windowIndex, this.window).mediaItem;
            }
            this.staticAndDynamicMediaMetadata = MediaMetadata.EMPTY;
        }
        if (booleanValue || !playbackInfo4.staticMetadata.equals(playbackInfo3.staticMetadata)) {
            this.staticAndDynamicMediaMetadata = this.staticAndDynamicMediaMetadata.buildUpon().populateFromMetadata(playbackInfo3.staticMetadata).build();
            mediaMetadata2 = buildUpdatedMediaMetadata();
        }
        boolean z3 = !mediaMetadata2.equals(this.mediaMetadata);
        this.mediaMetadata = mediaMetadata2;
        boolean z4 = playbackInfo4.playWhenReady != playbackInfo3.playWhenReady;
        boolean z5 = playbackInfo4.playbackState != playbackInfo3.playbackState;
        if (z5 || z4) {
            updateWakeAndWifiLock();
        }
        boolean z6 = playbackInfo4.isLoading != playbackInfo3.isLoading;
        if (z6) {
            updatePriorityTaskManagerForIsLoadingChange(playbackInfo3.isLoading);
        }
        if (!playbackInfo4.timeline.equals(playbackInfo3.timeline)) {
            this.listeners.queueEvent(0, new ExoPlayerImpl$$ExternalSyntheticLambda28(playbackInfo3, i));
        }
        if (z2) {
            this.listeners.queueEvent(11, new ExoPlayerImpl$$ExternalSyntheticLambda6(i5, getPreviousPositionInfo(i5, playbackInfo4, i4), getPositionInfo(j)));
        }
        if (booleanValue) {
            this.listeners.queueEvent(1, new ExoPlayerImpl$$ExternalSyntheticLambda7(mediaItem, intValue));
        }
        if (playbackInfo4.playbackError != playbackInfo3.playbackError) {
            this.listeners.queueEvent(10, new ExoPlayerImpl$$ExternalSyntheticLambda8(playbackInfo3));
            if (playbackInfo3.playbackError != null) {
                this.listeners.queueEvent(10, new ExoPlayerImpl$$ExternalSyntheticLambda9(playbackInfo3));
            }
        }
        if (playbackInfo4.trackSelectorResult != playbackInfo3.trackSelectorResult) {
            this.trackSelector.onSelectionActivated(playbackInfo3.trackSelectorResult.info);
            this.listeners.queueEvent(2, new ExoPlayerImpl$$ExternalSyntheticLambda10(playbackInfo3));
        }
        if (z3) {
            this.listeners.queueEvent(14, new ExoPlayerImpl$$ExternalSyntheticLambda12(this.mediaMetadata));
        }
        if (z6) {
            this.listeners.queueEvent(3, new ExoPlayerImpl$$ExternalSyntheticLambda13(playbackInfo3));
        }
        if (z5 || z4) {
            this.listeners.queueEvent(-1, new ExoPlayerImpl$$ExternalSyntheticLambda14(playbackInfo3));
        }
        if (z5) {
            this.listeners.queueEvent(4, new ExoPlayerImpl$$ExternalSyntheticLambda15(playbackInfo3));
        }
        if (z4) {
            this.listeners.queueEvent(5, new ExoPlayerImpl$$ExternalSyntheticLambda1(playbackInfo3, i2));
        }
        if (playbackInfo4.playbackSuppressionReason != playbackInfo3.playbackSuppressionReason) {
            this.listeners.queueEvent(6, new ExoPlayerImpl$$ExternalSyntheticLambda2(playbackInfo3));
        }
        if (isPlaying(playbackInfo4) != isPlaying(playbackInfo2)) {
            this.listeners.queueEvent(7, new ExoPlayerImpl$$ExternalSyntheticLambda3(playbackInfo3));
        }
        if (!playbackInfo4.playbackParameters.equals(playbackInfo3.playbackParameters)) {
            this.listeners.queueEvent(12, new ExoPlayerImpl$$ExternalSyntheticLambda4(playbackInfo3));
        }
        if (z) {
            this.listeners.queueEvent(-1, new ExoPlayerImpl$$ExternalSyntheticLambda5());
        }
        updateAvailableCommands();
        this.listeners.flushEvents();
        if (playbackInfo4.sleepingForOffload != playbackInfo3.sleepingForOffload) {
            Iterator<ExoPlayer.AudioOffloadListener> it = this.audioOffloadListeners.iterator();
            while (it.hasNext()) {
                it.next().onExperimentalSleepingForOffloadChanged(playbackInfo3.sleepingForOffload);
            }
        }
    }

    static /* synthetic */ void lambda$updatePlaybackInfo$13(int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, Player.Listener listener) {
        listener.onPositionDiscontinuity(i);
        listener.onPositionDiscontinuity(positionInfo, positionInfo2, i);
    }

    static /* synthetic */ void lambda$updatePlaybackInfo$19(PlaybackInfo playbackInfo2, Player.Listener listener) {
        listener.onLoadingChanged(playbackInfo2.isLoading);
        listener.onIsLoadingChanged(playbackInfo2.isLoading);
    }

    private Player.PositionInfo getPreviousPositionInfo(int i, PlaybackInfo playbackInfo2, int i2) {
        int i3;
        Object obj;
        MediaItem mediaItem;
        int i4;
        Object obj2;
        long j;
        long j2;
        PlaybackInfo playbackInfo3 = playbackInfo2;
        Timeline.Period period2 = new Timeline.Period();
        if (!playbackInfo3.timeline.isEmpty()) {
            Object obj3 = playbackInfo3.periodId.periodUid;
            playbackInfo3.timeline.getPeriodByUid(obj3, period2);
            int i5 = period2.windowIndex;
            i4 = i5;
            obj = obj3;
            i3 = playbackInfo3.timeline.getIndexOfPeriod(obj3);
            obj2 = playbackInfo3.timeline.getWindow(i5, this.window).uid;
            mediaItem = this.window.mediaItem;
        } else {
            i4 = i2;
            i3 = -1;
            obj2 = null;
            mediaItem = null;
            obj = null;
        }
        if (i == 0) {
            if (playbackInfo3.periodId.isAd()) {
                j2 = period2.getAdDurationUs(playbackInfo3.periodId.adGroupIndex, playbackInfo3.periodId.adIndexInAdGroup);
                j = getRequestedContentPositionUs(playbackInfo2);
                return new Player.PositionInfo(obj2, i4, mediaItem, obj, i3, Util.usToMs(j2), Util.usToMs(j), playbackInfo3.periodId.adGroupIndex, playbackInfo3.periodId.adIndexInAdGroup);
            } else if (playbackInfo3.periodId.nextAdGroupIndex != -1) {
                j2 = getRequestedContentPositionUs(this.playbackInfo);
            } else {
                j2 = period2.positionInWindowUs + period2.durationUs;
            }
        } else if (playbackInfo3.periodId.isAd()) {
            j2 = playbackInfo3.positionUs;
            j = getRequestedContentPositionUs(playbackInfo2);
            return new Player.PositionInfo(obj2, i4, mediaItem, obj, i3, Util.usToMs(j2), Util.usToMs(j), playbackInfo3.periodId.adGroupIndex, playbackInfo3.periodId.adIndexInAdGroup);
        } else {
            j2 = period2.positionInWindowUs + playbackInfo3.positionUs;
        }
        j = j2;
        return new Player.PositionInfo(obj2, i4, mediaItem, obj, i3, Util.usToMs(j2), Util.usToMs(j), playbackInfo3.periodId.adGroupIndex, playbackInfo3.periodId.adIndexInAdGroup);
    }

    private Player.PositionInfo getPositionInfo(long j) {
        int i;
        Object obj;
        MediaItem mediaItem;
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        Object obj2 = null;
        if (!this.playbackInfo.timeline.isEmpty()) {
            Object obj3 = this.playbackInfo.periodId.periodUid;
            this.playbackInfo.timeline.getPeriodByUid(obj3, this.period);
            i = this.playbackInfo.timeline.getIndexOfPeriod(obj3);
            obj2 = this.playbackInfo.timeline.getWindow(currentMediaItemIndex, this.window).uid;
            mediaItem = this.window.mediaItem;
            obj = obj3;
        } else {
            i = -1;
            mediaItem = null;
            obj = null;
        }
        long usToMs = Util.usToMs(j);
        return new Player.PositionInfo(obj2, currentMediaItemIndex, mediaItem, obj, i, usToMs, this.playbackInfo.periodId.isAd() ? Util.usToMs(getRequestedContentPositionUs(this.playbackInfo)) : usToMs, this.playbackInfo.periodId.adGroupIndex, this.playbackInfo.periodId.adIndexInAdGroup);
    }

    private static long getRequestedContentPositionUs(PlaybackInfo playbackInfo2) {
        Timeline.Window window = new Timeline.Window();
        Timeline.Period period2 = new Timeline.Period();
        playbackInfo2.timeline.getPeriodByUid(playbackInfo2.periodId.periodUid, period2);
        if (playbackInfo2.requestedContentPositionUs == C.TIME_UNSET) {
            return playbackInfo2.timeline.getWindow(period2.windowIndex, window).getDefaultPositionUs();
        }
        return period2.getPositionInWindowUs() + playbackInfo2.requestedContentPositionUs;
    }

    private Pair<Boolean, Integer> evaluateMediaItemTransitionReason(PlaybackInfo playbackInfo2, PlaybackInfo playbackInfo3, boolean z, int i, boolean z2) {
        Timeline timeline = playbackInfo3.timeline;
        Timeline timeline2 = playbackInfo2.timeline;
        if (timeline2.isEmpty() && timeline.isEmpty()) {
            return new Pair<>(false, -1);
        }
        int i2 = 3;
        if (timeline2.isEmpty() != timeline.isEmpty()) {
            return new Pair<>(true, 3);
        }
        if (!timeline.getWindow(timeline.getPeriodByUid(playbackInfo3.periodId.periodUid, this.period).windowIndex, this.window).uid.equals(timeline2.getWindow(timeline2.getPeriodByUid(playbackInfo2.periodId.periodUid, this.period).windowIndex, this.window).uid)) {
            if (z && i == 0) {
                i2 = 1;
            } else if (z && i == 1) {
                i2 = 2;
            } else if (!z2) {
                throw new IllegalStateException();
            }
            return new Pair<>(true, Integer.valueOf(i2));
        } else if (!z || i != 0 || playbackInfo3.periodId.windowSequenceNumber >= playbackInfo2.periodId.windowSequenceNumber) {
            return new Pair<>(false, -1);
        } else {
            return new Pair<>(true, 0);
        }
    }

    private void updateAvailableCommands() {
        Player.Commands commands = this.availableCommands;
        Player.Commands availableCommands2 = Util.getAvailableCommands(this.wrappingPlayer, this.permanentAvailableCommands);
        this.availableCommands = availableCommands2;
        if (!availableCommands2.equals(commands)) {
            this.listeners.queueEvent(13, new ExoPlayerImpl$$ExternalSyntheticLambda20(this));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$updateAvailableCommands$26$com-google-android-exoplayer2-ExoPlayerImpl  reason: not valid java name */
    public /* synthetic */ void m460lambda$updateAvailableCommands$26$comgoogleandroidexoplayer2ExoPlayerImpl(Player.Listener listener) {
        listener.onAvailableCommandsChanged(this.availableCommands);
    }

    private void setMediaSourcesInternal(List<MediaSource> list, int i, long j, boolean z) {
        int i2;
        long j2;
        int i3 = i;
        int currentWindowIndexInternal = getCurrentWindowIndexInternal();
        long currentPosition = getCurrentPosition();
        boolean z2 = true;
        this.pendingOperationAcks++;
        if (!this.mediaSourceHolderSnapshots.isEmpty()) {
            removeMediaSourceHolders(0, this.mediaSourceHolderSnapshots.size());
        }
        List<MediaSourceList.MediaSourceHolder> addMediaSourceHolders = addMediaSourceHolders(0, list);
        Timeline createMaskingTimeline = createMaskingTimeline();
        if (createMaskingTimeline.isEmpty() || i3 < createMaskingTimeline.getWindowCount()) {
            long j3 = j;
            if (z) {
                int firstWindowIndex = createMaskingTimeline.getFirstWindowIndex(this.shuffleModeEnabled);
                j2 = C.TIME_UNSET;
                i2 = firstWindowIndex;
            } else if (i3 == -1) {
                i2 = currentWindowIndexInternal;
                j2 = currentPosition;
            } else {
                i2 = i3;
                j2 = j3;
            }
            PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, maskWindowPositionMsOrGetPeriodPositionUs(createMaskingTimeline, i2, j2));
            int i4 = maskTimelineAndPosition.playbackState;
            if (!(i2 == -1 || maskTimelineAndPosition.playbackState == 1)) {
                i4 = (createMaskingTimeline.isEmpty() || i2 >= createMaskingTimeline.getWindowCount()) ? 4 : 2;
            }
            PlaybackInfo copyWithPlaybackState = maskTimelineAndPosition.copyWithPlaybackState(i4);
            this.internalPlayer.setMediaSources(addMediaSourceHolders, i2, Util.msToUs(j2), this.shuffleOrder);
            if (this.playbackInfo.periodId.periodUid.equals(copyWithPlaybackState.periodId.periodUid) || this.playbackInfo.timeline.isEmpty()) {
                z2 = false;
            }
            updatePlaybackInfo(copyWithPlaybackState, 0, 1, false, z2, 4, getCurrentPositionUsInternal(copyWithPlaybackState), -1);
            return;
        }
        throw new IllegalSeekPositionException(createMaskingTimeline, i3, j);
    }

    private List<MediaSourceList.MediaSourceHolder> addMediaSourceHolders(int i, List<MediaSource> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            MediaSourceList.MediaSourceHolder mediaSourceHolder = new MediaSourceList.MediaSourceHolder(list.get(i2), this.useLazyPreparation);
            arrayList.add(mediaSourceHolder);
            this.mediaSourceHolderSnapshots.add(i2 + i, new MediaSourceHolderSnapshot(mediaSourceHolder.uid, mediaSourceHolder.mediaSource.getTimeline()));
        }
        this.shuffleOrder = this.shuffleOrder.cloneAndInsert(i, arrayList.size());
        return arrayList;
    }

    private PlaybackInfo removeMediaItemsInternal(int i, int i2) {
        boolean z = false;
        Assertions.checkArgument(i >= 0 && i2 >= i && i2 <= this.mediaSourceHolderSnapshots.size());
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        Timeline currentTimeline = getCurrentTimeline();
        int size = this.mediaSourceHolderSnapshots.size();
        this.pendingOperationAcks++;
        removeMediaSourceHolders(i, i2);
        Timeline createMaskingTimeline = createMaskingTimeline();
        PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, getPeriodPositionUsAfterTimelineChanged(currentTimeline, createMaskingTimeline));
        if (maskTimelineAndPosition.playbackState != 1 && maskTimelineAndPosition.playbackState != 4 && i < i2 && i2 == size && currentMediaItemIndex >= maskTimelineAndPosition.timeline.getWindowCount()) {
            z = true;
        }
        if (z) {
            maskTimelineAndPosition = maskTimelineAndPosition.copyWithPlaybackState(4);
        }
        this.internalPlayer.removeMediaSources(i, i2, this.shuffleOrder);
        return maskTimelineAndPosition;
    }

    private void removeMediaSourceHolders(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            this.mediaSourceHolderSnapshots.remove(i3);
        }
        this.shuffleOrder = this.shuffleOrder.cloneAndRemove(i, i2);
    }

    private Timeline createMaskingTimeline() {
        return new PlaylistTimeline(this.mediaSourceHolderSnapshots, this.shuffleOrder);
    }

    private PlaybackInfo maskTimelineAndPosition(PlaybackInfo playbackInfo2, Timeline timeline, Pair<Object, Long> pair) {
        List list;
        int i;
        long j;
        Timeline timeline2 = timeline;
        Pair<Object, Long> pair2 = pair;
        Assertions.checkArgument(timeline.isEmpty() || pair2 != null);
        Timeline timeline3 = playbackInfo2.timeline;
        PlaybackInfo copyWithTimeline = playbackInfo2.copyWithTimeline(timeline);
        if (timeline.isEmpty()) {
            MediaSource.MediaPeriodId dummyPeriodForEmptyTimeline = PlaybackInfo.getDummyPeriodForEmptyTimeline();
            long msToUs = Util.msToUs(this.maskingWindowPositionMs);
            PlaybackInfo copyWithLoadingMediaPeriodId = copyWithTimeline.copyWithNewPosition(dummyPeriodForEmptyTimeline, msToUs, msToUs, msToUs, 0, TrackGroupArray.EMPTY, this.emptyTrackSelectorResult, ImmutableList.of()).copyWithLoadingMediaPeriodId(dummyPeriodForEmptyTimeline);
            copyWithLoadingMediaPeriodId.bufferedPositionUs = copyWithLoadingMediaPeriodId.positionUs;
            return copyWithLoadingMediaPeriodId;
        }
        Object obj = copyWithTimeline.periodId.periodUid;
        boolean z = !obj.equals(((Pair) Util.castNonNull(pair)).first);
        MediaSource.MediaPeriodId mediaPeriodId = z ? new MediaSource.MediaPeriodId(pair2.first) : copyWithTimeline.periodId;
        long longValue = ((Long) pair2.second).longValue();
        long msToUs2 = Util.msToUs(getContentPosition());
        if (!timeline3.isEmpty()) {
            msToUs2 -= timeline3.getPeriodByUid(obj, this.period).getPositionInWindowUs();
        }
        if (z || longValue < msToUs2) {
            MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
            Assertions.checkState(!mediaPeriodId2.isAd());
            TrackGroupArray trackGroupArray = z ? TrackGroupArray.EMPTY : copyWithTimeline.trackGroups;
            MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodId2;
            TrackSelectorResult trackSelectorResult = z ? this.emptyTrackSelectorResult : copyWithTimeline.trackSelectorResult;
            if (z) {
                list = ImmutableList.of();
            } else {
                list = copyWithTimeline.staticMetadata;
            }
            PlaybackInfo copyWithLoadingMediaPeriodId2 = copyWithTimeline.copyWithNewPosition(mediaPeriodId3, longValue, longValue, longValue, 0, trackGroupArray, trackSelectorResult, list).copyWithLoadingMediaPeriodId(mediaPeriodId3);
            copyWithLoadingMediaPeriodId2.bufferedPositionUs = longValue;
            return copyWithLoadingMediaPeriodId2;
        }
        if (i == 0) {
            int indexOfPeriod = timeline2.getIndexOfPeriod(copyWithTimeline.loadingMediaPeriodId.periodUid);
            if (indexOfPeriod == -1 || timeline2.getPeriod(indexOfPeriod, this.period).windowIndex != timeline2.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex) {
                timeline2.getPeriodByUid(mediaPeriodId.periodUid, this.period);
                if (mediaPeriodId.isAd()) {
                    j = this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
                } else {
                    j = this.period.durationUs;
                }
                copyWithTimeline = copyWithTimeline.copyWithNewPosition(mediaPeriodId, copyWithTimeline.positionUs, copyWithTimeline.positionUs, copyWithTimeline.discontinuityStartPositionUs, j - copyWithTimeline.positionUs, copyWithTimeline.trackGroups, copyWithTimeline.trackSelectorResult, copyWithTimeline.staticMetadata).copyWithLoadingMediaPeriodId(mediaPeriodId);
                copyWithTimeline.bufferedPositionUs = j;
            }
        } else {
            MediaSource.MediaPeriodId mediaPeriodId4 = mediaPeriodId;
            Assertions.checkState(!mediaPeriodId4.isAd());
            long max = Math.max(0, copyWithTimeline.totalBufferedDurationUs - (longValue - msToUs2));
            long j2 = copyWithTimeline.bufferedPositionUs;
            if (copyWithTimeline.loadingMediaPeriodId.equals(copyWithTimeline.periodId)) {
                j2 = longValue + max;
            }
            copyWithTimeline = copyWithTimeline.copyWithNewPosition(mediaPeriodId4, longValue, longValue, longValue, max, copyWithTimeline.trackGroups, copyWithTimeline.trackSelectorResult, copyWithTimeline.staticMetadata);
            copyWithTimeline.bufferedPositionUs = j2;
        }
        return copyWithTimeline;
    }

    private Pair<Object, Long> getPeriodPositionUsAfterTimelineChanged(Timeline timeline, Timeline timeline2) {
        long contentPosition = getContentPosition();
        int i = -1;
        if (timeline.isEmpty() || timeline2.isEmpty()) {
            boolean z = !timeline.isEmpty() && timeline2.isEmpty();
            if (!z) {
                i = getCurrentWindowIndexInternal();
            }
            if (z) {
                contentPosition = -9223372036854775807L;
            }
            return maskWindowPositionMsOrGetPeriodPositionUs(timeline2, i, contentPosition);
        }
        Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(this.window, this.period, getCurrentMediaItemIndex(), Util.msToUs(contentPosition));
        Object obj = ((Pair) Util.castNonNull(periodPositionUs)).first;
        if (timeline2.getIndexOfPeriod(obj) != -1) {
            return periodPositionUs;
        }
        Object resolveSubsequentPeriod = ExoPlayerImplInternal.resolveSubsequentPeriod(this.window, this.period, this.repeatMode, this.shuffleModeEnabled, obj, timeline, timeline2);
        if (resolveSubsequentPeriod == null) {
            return maskWindowPositionMsOrGetPeriodPositionUs(timeline2, -1, C.TIME_UNSET);
        }
        timeline2.getPeriodByUid(resolveSubsequentPeriod, this.period);
        return maskWindowPositionMsOrGetPeriodPositionUs(timeline2, this.period.windowIndex, timeline2.getWindow(this.period.windowIndex, this.window).getDefaultPositionMs());
    }

    private Pair<Object, Long> maskWindowPositionMsOrGetPeriodPositionUs(Timeline timeline, int i, long j) {
        if (timeline.isEmpty()) {
            this.maskingWindowIndex = i;
            if (j == C.TIME_UNSET) {
                j = 0;
            }
            this.maskingWindowPositionMs = j;
            this.maskingPeriodIndex = 0;
            return null;
        }
        if (i == -1 || i >= timeline.getWindowCount()) {
            i = timeline.getFirstWindowIndex(this.shuffleModeEnabled);
            j = timeline.getWindow(i, this.window).getDefaultPositionMs();
        }
        return timeline.getPeriodPositionUs(this.window, this.period, i, Util.msToUs(j));
    }

    private long periodPositionUsToWindowPositionUs(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j) {
        timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        return j + this.period.getPositionInWindowUs();
    }

    private PlayerMessage createMessageInternal(PlayerMessage.Target target) {
        int currentWindowIndexInternal = getCurrentWindowIndexInternal();
        ExoPlayerImplInternal exoPlayerImplInternal = this.internalPlayer;
        Timeline timeline = this.playbackInfo.timeline;
        if (currentWindowIndexInternal == -1) {
            currentWindowIndexInternal = 0;
        }
        return new PlayerMessage(exoPlayerImplInternal, target, timeline, currentWindowIndexInternal, this.clock, this.internalPlayer.getPlaybackLooper());
    }

    /* access modifiers changed from: private */
    public MediaMetadata buildUpdatedMediaMetadata() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return this.staticAndDynamicMediaMetadata;
        }
        return this.staticAndDynamicMediaMetadata.buildUpon().populate(currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).mediaItem.mediaMetadata).build();
    }

    private void removeSurfaceCallbacks() {
        if (this.sphericalGLSurfaceView != null) {
            createMessageInternal(this.frameMetadataListener).setType(10000).setPayload((Object) null).send();
            this.sphericalGLSurfaceView.removeVideoSurfaceListener(this.componentListener);
            this.sphericalGLSurfaceView = null;
        }
        TextureView textureView2 = this.textureView;
        if (textureView2 != null) {
            if (textureView2.getSurfaceTextureListener() != this.componentListener) {
                Log.w(TAG, "SurfaceTextureListener already unset or replaced.");
            } else {
                this.textureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            }
            this.textureView = null;
        }
        SurfaceHolder surfaceHolder2 = this.surfaceHolder;
        if (surfaceHolder2 != null) {
            surfaceHolder2.removeCallback(this.componentListener);
            this.surfaceHolder = null;
        }
    }

    /* access modifiers changed from: private */
    public void setSurfaceTextureInternal(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        setVideoOutputInternal(surface);
        this.ownedSurface = surface;
    }

    /* access modifiers changed from: private */
    public void setVideoOutputInternal(Object obj) {
        boolean z;
        ArrayList<PlayerMessage> arrayList = new ArrayList<>();
        Renderer[] rendererArr = this.renderers;
        int length = rendererArr.length;
        int i = 0;
        while (true) {
            z = true;
            if (i >= length) {
                break;
            }
            Renderer renderer = rendererArr[i];
            if (renderer.getTrackType() == 2) {
                arrayList.add(createMessageInternal(renderer).setType(1).setPayload(obj).send());
            }
            i++;
        }
        Object obj2 = this.videoOutput;
        if (obj2 == null || obj2 == obj) {
            z = false;
        } else {
            try {
                for (PlayerMessage blockUntilDelivered : arrayList) {
                    blockUntilDelivered.blockUntilDelivered(this.detachSurfaceTimeoutMs);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
            }
            z = false;
            Object obj3 = this.videoOutput;
            Surface surface = this.ownedSurface;
            if (obj3 == surface) {
                surface.release();
                this.ownedSurface = null;
            }
        }
        this.videoOutput = obj;
        if (z) {
            stopInternal(false, ExoPlaybackException.createForUnexpected(new ExoTimeoutException(3), 1003));
        }
    }

    private void setNonVideoOutputSurfaceHolderInternal(SurfaceHolder surfaceHolder2) {
        this.surfaceHolderSurfaceIsVideoOutput = false;
        this.surfaceHolder = surfaceHolder2;
        surfaceHolder2.addCallback(this.componentListener);
        Surface surface = this.surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        Rect surfaceFrame = this.surfaceHolder.getSurfaceFrame();
        maybeNotifySurfaceSizeChanged(surfaceFrame.width(), surfaceFrame.height());
    }

    /* access modifiers changed from: private */
    public void maybeNotifySurfaceSizeChanged(int i, int i2) {
        if (i != this.surfaceWidth || i2 != this.surfaceHeight) {
            this.surfaceWidth = i;
            this.surfaceHeight = i2;
            this.listeners.sendEvent(24, new ExoPlayerImpl$$ExternalSyntheticLambda0(i, i2));
        }
    }

    /* access modifiers changed from: private */
    public void sendVolumeToRenderers() {
        sendRendererMessage(1, 2, Float.valueOf(this.volume * this.audioFocusManager.getVolumeMultiplier()));
    }

    /* access modifiers changed from: private */
    public void updatePlayWhenReady(boolean z, int i, int i2) {
        int i3 = 0;
        boolean z2 = z && i != -1;
        if (z2 && i != 1) {
            i3 = 1;
        }
        if (this.playbackInfo.playWhenReady != z2 || this.playbackInfo.playbackSuppressionReason != i3) {
            this.pendingOperationAcks++;
            PlaybackInfo copyWithPlayWhenReady = this.playbackInfo.copyWithPlayWhenReady(z2, i3);
            this.internalPlayer.setPlayWhenReady(z2, i3);
            updatePlaybackInfo(copyWithPlayWhenReady, 0, i2, false, false, 5, C.TIME_UNSET, -1);
        }
    }

    /* access modifiers changed from: private */
    public void updateWakeAndWifiLock() {
        int playbackState = getPlaybackState();
        boolean z = true;
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                boolean experimentalIsSleepingForOffload = experimentalIsSleepingForOffload();
                WakeLockManager wakeLockManager2 = this.wakeLockManager;
                if (!getPlayWhenReady() || experimentalIsSleepingForOffload) {
                    z = false;
                }
                wakeLockManager2.setStayAwake(z);
                this.wifiLockManager.setStayAwake(getPlayWhenReady());
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.wakeLockManager.setStayAwake(false);
        this.wifiLockManager.setStayAwake(false);
    }

    private void verifyApplicationThread() {
        this.constructorFinished.blockUninterruptible();
        if (Thread.currentThread() != getApplicationLooper().getThread()) {
            String formatInvariant = Util.formatInvariant("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), getApplicationLooper().getThread().getName());
            if (!this.throwsWhenUsingWrongThread) {
                Log.w(TAG, formatInvariant, this.hasNotifiedFullWrongThreadWarning ? null : new IllegalStateException());
                this.hasNotifiedFullWrongThreadWarning = true;
                return;
            }
            throw new IllegalStateException(formatInvariant);
        }
    }

    private void sendRendererMessage(int i, int i2, Object obj) {
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == i) {
                createMessageInternal(renderer).setType(i2).setPayload(obj).send();
            }
        }
    }

    private int initializeKeepSessionIdAudioTrack(int i) {
        AudioTrack audioTrack = this.keepSessionIdAudioTrack;
        if (!(audioTrack == null || audioTrack.getAudioSessionId() == i)) {
            this.keepSessionIdAudioTrack.release();
            this.keepSessionIdAudioTrack = null;
        }
        if (this.keepSessionIdAudioTrack == null) {
            this.keepSessionIdAudioTrack = new AudioTrack(3, 4000, 4, 2, 2, 0, i);
        }
        return this.keepSessionIdAudioTrack.getAudioSessionId();
    }

    private void updatePriorityTaskManagerForIsLoadingChange(boolean z) {
        PriorityTaskManager priorityTaskManager2 = this.priorityTaskManager;
        if (priorityTaskManager2 == null) {
            return;
        }
        if (z && !this.isPriorityTaskManagerRegistered) {
            priorityTaskManager2.add(0);
            this.isPriorityTaskManagerRegistered = true;
        } else if (!z && this.isPriorityTaskManagerRegistered) {
            priorityTaskManager2.remove(0);
            this.isPriorityTaskManagerRegistered = false;
        }
    }

    /* access modifiers changed from: private */
    public static DeviceInfo createDeviceInfo(StreamVolumeManager streamVolumeManager2) {
        return new DeviceInfo(0, streamVolumeManager2.getMinVolume(), streamVolumeManager2.getMaxVolume());
    }

    private static boolean isPlaying(PlaybackInfo playbackInfo2) {
        return playbackInfo2.playbackState == 3 && playbackInfo2.playWhenReady && playbackInfo2.playbackSuppressionReason == 0;
    }

    private static final class MediaSourceHolderSnapshot implements MediaSourceInfoHolder {
        /* access modifiers changed from: private */
        public Timeline timeline;
        private final Object uid;

        public MediaSourceHolderSnapshot(Object obj, Timeline timeline2) {
            this.uid = obj;
            this.timeline = timeline2;
        }

        public Object getUid() {
            return this.uid;
        }

        public Timeline getTimeline() {
            return this.timeline;
        }
    }

    private final class ComponentListener implements VideoRendererEventListener, AudioRendererEventListener, TextOutput, MetadataOutput, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.VideoSurfaceListener, AudioFocusManager.PlayerControl, AudioBecomingNoisyManager.EventListener, StreamVolumeManager.Listener, ExoPlayer.AudioOffloadListener {
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        private ComponentListener() {
        }

        public void onVideoEnabled(DecoderCounters decoderCounters) {
            DecoderCounters unused = ExoPlayerImpl.this.videoDecoderCounters = decoderCounters;
            ExoPlayerImpl.this.analyticsCollector.onVideoEnabled(decoderCounters);
        }

        public void onVideoDecoderInitialized(String str, long j, long j2) {
            ExoPlayerImpl.this.analyticsCollector.onVideoDecoderInitialized(str, j, j2);
        }

        public void onVideoInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            Format unused = ExoPlayerImpl.this.videoFormat = format;
            ExoPlayerImpl.this.analyticsCollector.onVideoInputFormatChanged(format, decoderReuseEvaluation);
        }

        public void onDroppedFrames(int i, long j) {
            ExoPlayerImpl.this.analyticsCollector.onDroppedFrames(i, j);
        }

        public void onVideoSizeChanged(VideoSize videoSize) {
            VideoSize unused = ExoPlayerImpl.this.videoSize = videoSize;
            ExoPlayerImpl.this.listeners.sendEvent(25, new ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda8(videoSize));
        }

        public void onRenderedFirstFrame(Object obj, long j) {
            ExoPlayerImpl.this.analyticsCollector.onRenderedFirstFrame(obj, j);
            if (ExoPlayerImpl.this.videoOutput == obj) {
                ExoPlayerImpl.this.listeners.sendEvent(26, new ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda7());
            }
        }

        public void onVideoDecoderReleased(String str) {
            ExoPlayerImpl.this.analyticsCollector.onVideoDecoderReleased(str);
        }

        public void onVideoDisabled(DecoderCounters decoderCounters) {
            ExoPlayerImpl.this.analyticsCollector.onVideoDisabled(decoderCounters);
            Format unused = ExoPlayerImpl.this.videoFormat = null;
            DecoderCounters unused2 = ExoPlayerImpl.this.videoDecoderCounters = null;
        }

        public void onVideoFrameProcessingOffset(long j, int i) {
            ExoPlayerImpl.this.analyticsCollector.onVideoFrameProcessingOffset(j, i);
        }

        public void onVideoCodecError(Exception exc) {
            ExoPlayerImpl.this.analyticsCollector.onVideoCodecError(exc);
        }

        public void onAudioEnabled(DecoderCounters decoderCounters) {
            DecoderCounters unused = ExoPlayerImpl.this.audioDecoderCounters = decoderCounters;
            ExoPlayerImpl.this.analyticsCollector.onAudioEnabled(decoderCounters);
        }

        public void onAudioDecoderInitialized(String str, long j, long j2) {
            ExoPlayerImpl.this.analyticsCollector.onAudioDecoderInitialized(str, j, j2);
        }

        public void onAudioInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            Format unused = ExoPlayerImpl.this.audioFormat = format;
            ExoPlayerImpl.this.analyticsCollector.onAudioInputFormatChanged(format, decoderReuseEvaluation);
        }

        public void onAudioPositionAdvancing(long j) {
            ExoPlayerImpl.this.analyticsCollector.onAudioPositionAdvancing(j);
        }

        public void onAudioUnderrun(int i, long j, long j2) {
            ExoPlayerImpl.this.analyticsCollector.onAudioUnderrun(i, j, j2);
        }

        public void onAudioDecoderReleased(String str) {
            ExoPlayerImpl.this.analyticsCollector.onAudioDecoderReleased(str);
        }

        public void onAudioDisabled(DecoderCounters decoderCounters) {
            ExoPlayerImpl.this.analyticsCollector.onAudioDisabled(decoderCounters);
            Format unused = ExoPlayerImpl.this.audioFormat = null;
            DecoderCounters unused2 = ExoPlayerImpl.this.audioDecoderCounters = null;
        }

        public void onSkipSilenceEnabledChanged(boolean z) {
            if (ExoPlayerImpl.this.skipSilenceEnabled != z) {
                boolean unused = ExoPlayerImpl.this.skipSilenceEnabled = z;
                ExoPlayerImpl.this.listeners.sendEvent(23, new ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda4(z));
            }
        }

        public void onAudioSinkError(Exception exc) {
            ExoPlayerImpl.this.analyticsCollector.onAudioSinkError(exc);
        }

        public void onAudioCodecError(Exception exc) {
            ExoPlayerImpl.this.analyticsCollector.onAudioCodecError(exc);
        }

        public void onCues(List<Cue> list) {
            ExoPlayerImpl.this.listeners.sendEvent(27, new ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda2(list));
        }

        public void onCues(CueGroup cueGroup) {
            CueGroup unused = ExoPlayerImpl.this.currentCueGroup = cueGroup;
            ExoPlayerImpl.this.listeners.sendEvent(27, new ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda6(cueGroup));
        }

        public void onMetadata(Metadata metadata) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            MediaMetadata unused = exoPlayerImpl.staticAndDynamicMediaMetadata = exoPlayerImpl.staticAndDynamicMediaMetadata.buildUpon().populateFromMetadata(metadata).build();
            MediaMetadata access$1400 = ExoPlayerImpl.this.buildUpdatedMediaMetadata();
            if (!access$1400.equals(ExoPlayerImpl.this.mediaMetadata)) {
                MediaMetadata unused2 = ExoPlayerImpl.this.mediaMetadata = access$1400;
                ExoPlayerImpl.this.listeners.queueEvent(14, new ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda0(this));
            }
            ExoPlayerImpl.this.listeners.queueEvent(28, new ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda1(metadata));
            ExoPlayerImpl.this.listeners.flushEvents();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$onMetadata$4$com-google-android-exoplayer2-ExoPlayerImpl$ComponentListener  reason: not valid java name */
        public /* synthetic */ void m461lambda$onMetadata$4$comgoogleandroidexoplayer2ExoPlayerImpl$ComponentListener(Player.Listener listener) {
            listener.onMediaMetadataChanged(ExoPlayerImpl.this.mediaMetadata);
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (ExoPlayerImpl.this.surfaceHolderSurfaceIsVideoOutput) {
                ExoPlayerImpl.this.setVideoOutputInternal(surfaceHolder.getSurface());
            }
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            ExoPlayerImpl.this.maybeNotifySurfaceSizeChanged(i2, i3);
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (ExoPlayerImpl.this.surfaceHolderSurfaceIsVideoOutput) {
                ExoPlayerImpl.this.setVideoOutputInternal((Object) null);
            }
            ExoPlayerImpl.this.maybeNotifySurfaceSizeChanged(0, 0);
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            ExoPlayerImpl.this.setSurfaceTextureInternal(surfaceTexture);
            ExoPlayerImpl.this.maybeNotifySurfaceSizeChanged(i, i2);
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            ExoPlayerImpl.this.maybeNotifySurfaceSizeChanged(i, i2);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ExoPlayerImpl.this.setVideoOutputInternal((Object) null);
            ExoPlayerImpl.this.maybeNotifySurfaceSizeChanged(0, 0);
            return true;
        }

        public void onVideoSurfaceCreated(Surface surface) {
            ExoPlayerImpl.this.setVideoOutputInternal(surface);
        }

        public void onVideoSurfaceDestroyed(Surface surface) {
            ExoPlayerImpl.this.setVideoOutputInternal((Object) null);
        }

        public void setVolumeMultiplier(float f) {
            ExoPlayerImpl.this.sendVolumeToRenderers();
        }

        public void executePlayerCommand(int i) {
            boolean playWhenReady = ExoPlayerImpl.this.getPlayWhenReady();
            ExoPlayerImpl.this.updatePlayWhenReady(playWhenReady, i, ExoPlayerImpl.getPlayWhenReadyChangeReason(playWhenReady, i));
        }

        public void onAudioBecomingNoisy() {
            ExoPlayerImpl.this.updatePlayWhenReady(false, -1, 3);
        }

        public void onStreamTypeChanged(int i) {
            DeviceInfo access$2400 = ExoPlayerImpl.createDeviceInfo(ExoPlayerImpl.this.streamVolumeManager);
            if (!access$2400.equals(ExoPlayerImpl.this.deviceInfo)) {
                DeviceInfo unused = ExoPlayerImpl.this.deviceInfo = access$2400;
                ExoPlayerImpl.this.listeners.sendEvent(29, new ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda3(access$2400));
            }
        }

        public void onStreamVolumeChanged(int i, boolean z) {
            ExoPlayerImpl.this.listeners.sendEvent(30, new ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda5(i, z));
        }

        public void onExperimentalSleepingForOffloadChanged(boolean z) {
            ExoPlayerImpl.this.updateWakeAndWifiLock();
        }
    }

    private static final class FrameMetadataListener implements VideoFrameMetadataListener, CameraMotionListener, PlayerMessage.Target {
        public static final int MSG_SET_CAMERA_MOTION_LISTENER = 8;
        public static final int MSG_SET_SPHERICAL_SURFACE_VIEW = 10000;
        public static final int MSG_SET_VIDEO_FRAME_METADATA_LISTENER = 7;
        private CameraMotionListener cameraMotionListener;
        private CameraMotionListener internalCameraMotionListener;
        private VideoFrameMetadataListener internalVideoFrameMetadataListener;
        private VideoFrameMetadataListener videoFrameMetadataListener;

        private FrameMetadataListener() {
        }

        public void handleMessage(int i, Object obj) {
            if (i == 7) {
                this.videoFrameMetadataListener = (VideoFrameMetadataListener) obj;
            } else if (i == 8) {
                this.cameraMotionListener = (CameraMotionListener) obj;
            } else if (i == 10000) {
                SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
                if (sphericalGLSurfaceView == null) {
                    this.internalVideoFrameMetadataListener = null;
                    this.internalCameraMotionListener = null;
                    return;
                }
                this.internalVideoFrameMetadataListener = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                this.internalCameraMotionListener = sphericalGLSurfaceView.getCameraMotionListener();
            }
        }

        public void onVideoFrameAboutToBeRendered(long j, long j2, Format format, MediaFormat mediaFormat) {
            VideoFrameMetadataListener videoFrameMetadataListener2 = this.internalVideoFrameMetadataListener;
            if (videoFrameMetadataListener2 != null) {
                videoFrameMetadataListener2.onVideoFrameAboutToBeRendered(j, j2, format, mediaFormat);
            }
            VideoFrameMetadataListener videoFrameMetadataListener3 = this.videoFrameMetadataListener;
            if (videoFrameMetadataListener3 != null) {
                videoFrameMetadataListener3.onVideoFrameAboutToBeRendered(j, j2, format, mediaFormat);
            }
        }

        public void onCameraMotion(long j, float[] fArr) {
            CameraMotionListener cameraMotionListener2 = this.internalCameraMotionListener;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.onCameraMotion(j, fArr);
            }
            CameraMotionListener cameraMotionListener3 = this.cameraMotionListener;
            if (cameraMotionListener3 != null) {
                cameraMotionListener3.onCameraMotion(j, fArr);
            }
        }

        public void onCameraMotionReset() {
            CameraMotionListener cameraMotionListener2 = this.internalCameraMotionListener;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.onCameraMotionReset();
            }
            CameraMotionListener cameraMotionListener3 = this.cameraMotionListener;
            if (cameraMotionListener3 != null) {
                cameraMotionListener3.onCameraMotionReset();
            }
        }
    }

    private static final class Api31 {
        private Api31() {
        }

        public static PlayerId registerMediaMetricsListener(Context context, ExoPlayerImpl exoPlayerImpl, boolean z) {
            MediaMetricsListener create = MediaMetricsListener.create(context);
            if (create == null) {
                Log.w(ExoPlayerImpl.TAG, "MediaMetricsService unavailable.");
                return new PlayerId(LogSessionId.LOG_SESSION_ID_NONE);
            }
            if (z) {
                exoPlayerImpl.addAnalyticsListener(create);
            }
            return new PlayerId(create.getLogSessionId());
        }
    }
}
