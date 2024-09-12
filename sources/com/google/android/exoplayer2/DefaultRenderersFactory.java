package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.mediacodec.DefaultMediaCodecAdapterFactory;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionRenderer;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

public class DefaultRenderersFactory implements RenderersFactory {
    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000;
    public static final int EXTENSION_RENDERER_MODE_OFF = 0;
    public static final int EXTENSION_RENDERER_MODE_ON = 1;
    public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
    public static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
    private static final String TAG = "DefaultRenderersFactory";
    private long allowedVideoJoiningTimeMs = 5000;
    private final DefaultMediaCodecAdapterFactory codecAdapterFactory = new DefaultMediaCodecAdapterFactory();
    private final Context context;
    private boolean enableAudioTrackPlaybackParams;
    private boolean enableDecoderFallback;
    private boolean enableFloatOutput;
    private boolean enableOffload;
    private int extensionRendererMode = 0;
    private MediaCodecSelector mediaCodecSelector = MediaCodecSelector.DEFAULT;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExtensionRendererMode {
    }

    /* access modifiers changed from: protected */
    public void buildMiscellaneousRenderers(Context context2, Handler handler, int i, ArrayList<Renderer> arrayList) {
    }

    public DefaultRenderersFactory(Context context2) {
        this.context = context2;
    }

    public DefaultRenderersFactory setExtensionRendererMode(int i) {
        this.extensionRendererMode = i;
        return this;
    }

    public DefaultRenderersFactory forceEnableMediaCodecAsynchronousQueueing() {
        this.codecAdapterFactory.forceEnableAsynchronous();
        return this;
    }

    public DefaultRenderersFactory forceDisableMediaCodecAsynchronousQueueing() {
        this.codecAdapterFactory.forceDisableAsynchronous();
        return this;
    }

    public DefaultRenderersFactory experimentalSetSynchronizeCodecInteractionsWithQueueingEnabled(boolean z) {
        this.codecAdapterFactory.experimentalSetSynchronizeCodecInteractionsWithQueueingEnabled(z);
        return this;
    }

    public DefaultRenderersFactory setEnableDecoderFallback(boolean z) {
        this.enableDecoderFallback = z;
        return this;
    }

    public DefaultRenderersFactory setMediaCodecSelector(MediaCodecSelector mediaCodecSelector2) {
        this.mediaCodecSelector = mediaCodecSelector2;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioFloatOutput(boolean z) {
        this.enableFloatOutput = z;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioOffload(boolean z) {
        this.enableOffload = z;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioTrackPlaybackParams(boolean z) {
        this.enableAudioTrackPlaybackParams = z;
        return this;
    }

    public DefaultRenderersFactory setAllowedVideoJoiningTimeMs(long j) {
        this.allowedVideoJoiningTimeMs = j;
        return this;
    }

    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        ArrayList arrayList = new ArrayList();
        buildVideoRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, this.enableDecoderFallback, handler, videoRendererEventListener, this.allowedVideoJoiningTimeMs, arrayList);
        AudioSink buildAudioSink = buildAudioSink(this.context, this.enableFloatOutput, this.enableAudioTrackPlaybackParams, this.enableOffload);
        if (buildAudioSink != null) {
            buildAudioRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, this.enableDecoderFallback, buildAudioSink, handler, audioRendererEventListener, arrayList);
        }
        ArrayList arrayList2 = arrayList;
        buildTextRenderers(this.context, textOutput, handler.getLooper(), this.extensionRendererMode, arrayList2);
        buildMetadataRenderers(this.context, metadataOutput, handler.getLooper(), this.extensionRendererMode, arrayList2);
        buildCameraMotionRenderers(this.context, this.extensionRendererMode, arrayList);
        Handler handler2 = handler;
        buildMiscellaneousRenderers(this.context, handler, this.extensionRendererMode, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0073, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007b, code lost:
        throw new java.lang.RuntimeException("Error instantiating VP9 extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0073 A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildVideoRenderers(android.content.Context r15, int r16, com.google.android.exoplayer2.mediacodec.MediaCodecSelector r17, boolean r18, android.os.Handler r19, com.google.android.exoplayer2.video.VideoRendererEventListener r20, long r21, java.util.ArrayList<com.google.android.exoplayer2.Renderer> r23) {
        /*
            r14 = this;
            r0 = r16
            r11 = r23
            java.lang.String r12 = "DefaultRenderersFactory"
            com.google.android.exoplayer2.video.MediaCodecVideoRenderer r13 = new com.google.android.exoplayer2.video.MediaCodecVideoRenderer
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$Factory r3 = r14.getCodecAdapterFactory()
            r10 = 50
            r1 = r13
            r2 = r15
            r4 = r17
            r5 = r21
            r7 = r18
            r8 = r19
            r9 = r20
            r1.<init>(r2, r3, r4, r5, r7, r8, r9, r10)
            r11.add(r13)
            if (r0 != 0) goto L_0x0023
            return
        L_0x0023:
            int r1 = r23.size()
            r2 = 2
            if (r0 != r2) goto L_0x002c
            int r1 = r1 + -1
        L_0x002c:
            r0 = 50
            r3 = 3
            r4 = 0
            r5 = 4
            r6 = 1
            java.lang.String r7 = "com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException -> 0x007c, Exception -> 0x0073 }
            java.lang.Class[] r8 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException -> 0x007c, Exception -> 0x0073 }
            java.lang.Class r9 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x007c, Exception -> 0x0073 }
            r8[r4] = r9     // Catch:{ ClassNotFoundException -> 0x007c, Exception -> 0x0073 }
            java.lang.Class<android.os.Handler> r9 = android.os.Handler.class
            r8[r6] = r9     // Catch:{ ClassNotFoundException -> 0x007c, Exception -> 0x0073 }
            java.lang.Class<com.google.android.exoplayer2.video.VideoRendererEventListener> r9 = com.google.android.exoplayer2.video.VideoRendererEventListener.class
            r8[r2] = r9     // Catch:{ ClassNotFoundException -> 0x007c, Exception -> 0x0073 }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x007c, Exception -> 0x0073 }
            r8[r3] = r9     // Catch:{ ClassNotFoundException -> 0x007c, Exception -> 0x0073 }
            java.lang.reflect.Constructor r7 = r7.getConstructor(r8)     // Catch:{ ClassNotFoundException -> 0x007c, Exception -> 0x0073 }
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ ClassNotFoundException -> 0x007c, Exception -> 0x0073 }
            java.lang.Long r9 = java.lang.Long.valueOf(r21)     // Catch:{ ClassNotFoundException -> 0x007c, Exception -> 0x0073 }
            r8[r4] = r9     // Catch:{ ClassNotFoundException -> 0x007c, Exception -> 0x0073 }
            r8[r6] = r19     // Catch:{ ClassNotFoundException -> 0x007c, Exception -> 0x0073 }
            r8[r2] = r20     // Catch:{ ClassNotFoundException -> 0x007c, Exception -> 0x0073 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x007c, Exception -> 0x0073 }
            r8[r3] = r9     // Catch:{ ClassNotFoundException -> 0x007c, Exception -> 0x0073 }
            java.lang.Object r7 = r7.newInstance(r8)     // Catch:{ ClassNotFoundException -> 0x007c, Exception -> 0x0073 }
            com.google.android.exoplayer2.Renderer r7 = (com.google.android.exoplayer2.Renderer) r7     // Catch:{ ClassNotFoundException -> 0x007c, Exception -> 0x0073 }
            int r8 = r1 + 1
            r11.add(r1, r7)     // Catch:{ ClassNotFoundException -> 0x0071, Exception -> 0x0073 }
            java.lang.String r1 = "Loaded LibvpxVideoRenderer."
            com.google.android.exoplayer2.util.Log.i(r12, r1)     // Catch:{ ClassNotFoundException -> 0x0071, Exception -> 0x0073 }
            goto L_0x007d
        L_0x0071:
            r1 = r8
            goto L_0x007c
        L_0x0073:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating VP9 extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x007c:
            r8 = r1
        L_0x007d:
            java.lang.String r1 = "com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.Class r9 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            r7[r4] = r9     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.Class<android.os.Handler> r9 = android.os.Handler.class
            r7[r6] = r9     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.Class<com.google.android.exoplayer2.video.VideoRendererEventListener> r9 = com.google.android.exoplayer2.video.VideoRendererEventListener.class
            r7[r2] = r9     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            r7[r3] = r9     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.reflect.Constructor r1 = r1.getConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.Long r7 = java.lang.Long.valueOf(r21)     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            r5[r4] = r7     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            r5[r6] = r19     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            r5[r2] = r20     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            r5[r3] = r0     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.Object r0 = r1.newInstance(r5)     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            com.google.android.exoplayer2.Renderer r0 = (com.google.android.exoplayer2.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            r11.add(r8, r0)     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            java.lang.String r0 = "Loaded Libgav1VideoRenderer."
            com.google.android.exoplayer2.util.Log.i(r12, r0)     // Catch:{ ClassNotFoundException -> 0x00c3, Exception -> 0x00ba }
            goto L_0x00c3
        L_0x00ba:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating AV1 extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.DefaultRenderersFactory.buildVideoRenderers(android.content.Context, int, com.google.android.exoplayer2.mediacodec.MediaCodecSelector, boolean, android.os.Handler, com.google.android.exoplayer2.video.VideoRendererEventListener, long, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
        throw new java.lang.RuntimeException("Error instantiating MIDI extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0089, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0091, code lost:
        throw new java.lang.RuntimeException("Error instantiating Opus extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ce, code lost:
        throw new java.lang.RuntimeException("Error instantiating FLAC extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a A[ExcHandler: Exception (r0v8 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0089 A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:20:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c6 A[ExcHandler: Exception (r0v6 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:33:0x0095] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildAudioRenderers(android.content.Context r13, int r14, com.google.android.exoplayer2.mediacodec.MediaCodecSelector r15, boolean r16, com.google.android.exoplayer2.audio.AudioSink r17, android.os.Handler r18, com.google.android.exoplayer2.audio.AudioRendererEventListener r19, java.util.ArrayList<com.google.android.exoplayer2.Renderer> r20) {
        /*
            r12 = this;
            r0 = r14
            r9 = r20
            java.lang.String r10 = "DefaultRenderersFactory"
            com.google.android.exoplayer2.audio.MediaCodecAudioRenderer r11 = new com.google.android.exoplayer2.audio.MediaCodecAudioRenderer
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$Factory r3 = r12.getCodecAdapterFactory()
            r1 = r11
            r2 = r13
            r4 = r15
            r5 = r16
            r6 = r18
            r7 = r19
            r8 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r9.add(r11)
            if (r0 != 0) goto L_0x001f
            return
        L_0x001f:
            int r1 = r20.size()
            r2 = 2
            if (r0 != r2) goto L_0x0028
            int r1 = r1 + -1
        L_0x0028:
            r0 = 0
            java.lang.String r3 = "com.google.android.exoplayer2.decoder.midi.MidiRenderer"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x0053, Exception -> 0x004a }
            java.lang.Class[] r4 = new java.lang.Class[r0]     // Catch:{ ClassNotFoundException -> 0x0053, Exception -> 0x004a }
            java.lang.reflect.Constructor r3 = r3.getConstructor(r4)     // Catch:{ ClassNotFoundException -> 0x0053, Exception -> 0x004a }
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch:{ ClassNotFoundException -> 0x0053, Exception -> 0x004a }
            java.lang.Object r3 = r3.newInstance(r4)     // Catch:{ ClassNotFoundException -> 0x0053, Exception -> 0x004a }
            com.google.android.exoplayer2.Renderer r3 = (com.google.android.exoplayer2.Renderer) r3     // Catch:{ ClassNotFoundException -> 0x0053, Exception -> 0x004a }
            int r4 = r1 + 1
            r9.add(r1, r3)     // Catch:{ ClassNotFoundException -> 0x0048, Exception -> 0x004a }
            java.lang.String r1 = "Loaded MidiRenderer."
            com.google.android.exoplayer2.util.Log.i(r10, r1)     // Catch:{ ClassNotFoundException -> 0x0048, Exception -> 0x004a }
            goto L_0x0054
        L_0x0048:
            r1 = r4
            goto L_0x0053
        L_0x004a:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating MIDI extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x0053:
            r4 = r1
        L_0x0054:
            r1 = 3
            r3 = 1
            java.lang.String r5 = "com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ ClassNotFoundException -> 0x0092, Exception -> 0x0089 }
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x0092, Exception -> 0x0089 }
            java.lang.Class<android.os.Handler> r7 = android.os.Handler.class
            r6[r0] = r7     // Catch:{ ClassNotFoundException -> 0x0092, Exception -> 0x0089 }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioRendererEventListener> r7 = com.google.android.exoplayer2.audio.AudioRendererEventListener.class
            r6[r3] = r7     // Catch:{ ClassNotFoundException -> 0x0092, Exception -> 0x0089 }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioSink> r7 = com.google.android.exoplayer2.audio.AudioSink.class
            r6[r2] = r7     // Catch:{ ClassNotFoundException -> 0x0092, Exception -> 0x0089 }
            java.lang.reflect.Constructor r5 = r5.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x0092, Exception -> 0x0089 }
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x0092, Exception -> 0x0089 }
            r6[r0] = r18     // Catch:{ ClassNotFoundException -> 0x0092, Exception -> 0x0089 }
            r6[r3] = r19     // Catch:{ ClassNotFoundException -> 0x0092, Exception -> 0x0089 }
            r6[r2] = r17     // Catch:{ ClassNotFoundException -> 0x0092, Exception -> 0x0089 }
            java.lang.Object r5 = r5.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x0092, Exception -> 0x0089 }
            com.google.android.exoplayer2.Renderer r5 = (com.google.android.exoplayer2.Renderer) r5     // Catch:{ ClassNotFoundException -> 0x0092, Exception -> 0x0089 }
            int r6 = r4 + 1
            r9.add(r4, r5)     // Catch:{ ClassNotFoundException -> 0x0087, Exception -> 0x0089 }
            java.lang.String r4 = "Loaded LibopusAudioRenderer."
            com.google.android.exoplayer2.util.Log.i(r10, r4)     // Catch:{ ClassNotFoundException -> 0x0087, Exception -> 0x0089 }
            goto L_0x0093
        L_0x0087:
            r4 = r6
            goto L_0x0092
        L_0x0089:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating Opus extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x0092:
            r6 = r4
        L_0x0093:
            java.lang.String r4 = "com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            java.lang.Class<android.os.Handler> r7 = android.os.Handler.class
            r5[r0] = r7     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioRendererEventListener> r7 = com.google.android.exoplayer2.audio.AudioRendererEventListener.class
            r5[r3] = r7     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioSink> r7 = com.google.android.exoplayer2.audio.AudioSink.class
            r5[r2] = r7     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            java.lang.reflect.Constructor r4 = r4.getConstructor(r5)     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            r5[r0] = r18     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            r5[r3] = r19     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            r5[r2] = r17     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            java.lang.Object r4 = r4.newInstance(r5)     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            com.google.android.exoplayer2.Renderer r4 = (com.google.android.exoplayer2.Renderer) r4     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            int r5 = r6 + 1
            r9.add(r6, r4)     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00c6 }
            java.lang.String r4 = "Loaded LibflacAudioRenderer."
            com.google.android.exoplayer2.util.Log.i(r10, r4)     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00c6 }
            goto L_0x00d0
        L_0x00c4:
            r6 = r5
            goto L_0x00cf
        L_0x00c6:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FLAC extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00cf:
            r5 = r6
        L_0x00d0:
            java.lang.String r4 = "com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ ClassNotFoundException -> 0x0108, Exception -> 0x00ff }
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x0108, Exception -> 0x00ff }
            java.lang.Class<android.os.Handler> r7 = android.os.Handler.class
            r6[r0] = r7     // Catch:{ ClassNotFoundException -> 0x0108, Exception -> 0x00ff }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioRendererEventListener> r7 = com.google.android.exoplayer2.audio.AudioRendererEventListener.class
            r6[r3] = r7     // Catch:{ ClassNotFoundException -> 0x0108, Exception -> 0x00ff }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioSink> r7 = com.google.android.exoplayer2.audio.AudioSink.class
            r6[r2] = r7     // Catch:{ ClassNotFoundException -> 0x0108, Exception -> 0x00ff }
            java.lang.reflect.Constructor r4 = r4.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x0108, Exception -> 0x00ff }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x0108, Exception -> 0x00ff }
            r1[r0] = r18     // Catch:{ ClassNotFoundException -> 0x0108, Exception -> 0x00ff }
            r1[r3] = r19     // Catch:{ ClassNotFoundException -> 0x0108, Exception -> 0x00ff }
            r1[r2] = r17     // Catch:{ ClassNotFoundException -> 0x0108, Exception -> 0x00ff }
            java.lang.Object r0 = r4.newInstance(r1)     // Catch:{ ClassNotFoundException -> 0x0108, Exception -> 0x00ff }
            com.google.android.exoplayer2.Renderer r0 = (com.google.android.exoplayer2.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x0108, Exception -> 0x00ff }
            r9.add(r5, r0)     // Catch:{ ClassNotFoundException -> 0x0108, Exception -> 0x00ff }
            java.lang.String r0 = "Loaded FfmpegAudioRenderer."
            com.google.android.exoplayer2.util.Log.i(r10, r0)     // Catch:{ ClassNotFoundException -> 0x0108, Exception -> 0x00ff }
            goto L_0x0108
        L_0x00ff:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FFmpeg extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.DefaultRenderersFactory.buildAudioRenderers(android.content.Context, int, com.google.android.exoplayer2.mediacodec.MediaCodecSelector, boolean, com.google.android.exoplayer2.audio.AudioSink, android.os.Handler, com.google.android.exoplayer2.audio.AudioRendererEventListener, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    public void buildTextRenderers(Context context2, TextOutput textOutput, Looper looper, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new TextRenderer(textOutput, looper));
    }

    /* access modifiers changed from: protected */
    public void buildMetadataRenderers(Context context2, MetadataOutput metadataOutput, Looper looper, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new MetadataRenderer(metadataOutput, looper));
    }

    /* access modifiers changed from: protected */
    public void buildCameraMotionRenderers(Context context2, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new CameraMotionRenderer());
    }

    /* access modifiers changed from: protected */
    public AudioSink buildAudioSink(Context context2, boolean z, boolean z2, boolean z3) {
        return new DefaultAudioSink.Builder().setAudioCapabilities(AudioCapabilities.getCapabilities(context2)).setEnableFloatOutput(z).setEnableAudioTrackPlaybackParams(z2).setOffloadMode(z3 ? 1 : 0).build();
    }

    /* access modifiers changed from: protected */
    public MediaCodecAdapter.Factory getCodecAdapterFactory() {
        return this.codecAdapterFactory;
    }
}
