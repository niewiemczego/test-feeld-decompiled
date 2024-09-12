package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.amr.AmrExtractor;
import com.google.android.exoplayer2.extractor.avi.AviExtractor;
import com.google.android.exoplayer2.extractor.flac.FlacExtractor;
import com.google.android.exoplayer2.extractor.flv.FlvExtractor;
import com.google.android.exoplayer2.extractor.jpeg.JpegExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.ogg.OggExtractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.wav.WavExtractor;
import com.google.android.exoplayer2.util.FileTypes;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class DefaultExtractorsFactory implements ExtractorsFactory {
    private static final int[] DEFAULT_EXTRACTOR_ORDER = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};
    private static final ExtensionLoader FLAC_EXTENSION_LOADER = new ExtensionLoader(new DefaultExtractorsFactory$$ExternalSyntheticLambda0());
    private static final ExtensionLoader MIDI_EXTENSION_LOADER = new ExtensionLoader(new DefaultExtractorsFactory$$ExternalSyntheticLambda1());
    private int adtsFlags;
    private int amrFlags;
    private boolean constantBitrateSeekingAlwaysEnabled;
    private boolean constantBitrateSeekingEnabled;
    private int flacFlags;
    private int fragmentedMp4Flags;
    private int matroskaFlags;
    private int mp3Flags;
    private int mp4Flags;
    private int tsFlags;
    private int tsMode = 1;
    private int tsTimestampSearchBytes = TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES;

    public synchronized DefaultExtractorsFactory setConstantBitrateSeekingEnabled(boolean z) {
        this.constantBitrateSeekingEnabled = z;
        return this;
    }

    public synchronized DefaultExtractorsFactory setConstantBitrateSeekingAlwaysEnabled(boolean z) {
        this.constantBitrateSeekingAlwaysEnabled = z;
        return this;
    }

    public synchronized DefaultExtractorsFactory setAdtsExtractorFlags(int i) {
        this.adtsFlags = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setAmrExtractorFlags(int i) {
        this.amrFlags = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setFlacExtractorFlags(int i) {
        this.flacFlags = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMatroskaExtractorFlags(int i) {
        this.matroskaFlags = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMp4ExtractorFlags(int i) {
        this.mp4Flags = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setFragmentedMp4ExtractorFlags(int i) {
        this.fragmentedMp4Flags = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMp3ExtractorFlags(int i) {
        this.mp3Flags = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorMode(int i) {
        this.tsMode = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorFlags(int i) {
        this.tsFlags = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorTimestampSearchBytes(int i) {
        this.tsTimestampSearchBytes = i;
        return this;
    }

    public synchronized Extractor[] createExtractors() {
        return createExtractors(Uri.EMPTY, new HashMap());
    }

    public synchronized Extractor[] createExtractors(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        int[] iArr = DEFAULT_EXTRACTOR_ORDER;
        arrayList = new ArrayList(iArr.length);
        int inferFileTypeFromResponseHeaders = FileTypes.inferFileTypeFromResponseHeaders(map);
        if (inferFileTypeFromResponseHeaders != -1) {
            addExtractorsForFileType(inferFileTypeFromResponseHeaders, arrayList);
        }
        int inferFileTypeFromUri = FileTypes.inferFileTypeFromUri(uri);
        if (!(inferFileTypeFromUri == -1 || inferFileTypeFromUri == inferFileTypeFromResponseHeaders)) {
            addExtractorsForFileType(inferFileTypeFromUri, arrayList);
        }
        for (int i : iArr) {
            if (!(i == inferFileTypeFromResponseHeaders || i == inferFileTypeFromUri)) {
                addExtractorsForFileType(i, arrayList);
            }
        }
        return (Extractor[]) arrayList.toArray(new Extractor[arrayList.size()]);
    }

    private void addExtractorsForFileType(int i, List<Extractor> list) {
        int i2 = 2;
        switch (i) {
            case 0:
                list.add(new Ac3Extractor());
                return;
            case 1:
                list.add(new Ac4Extractor());
                return;
            case 2:
                boolean z = this.adtsFlags | this.constantBitrateSeekingEnabled;
                if (!this.constantBitrateSeekingAlwaysEnabled) {
                    i2 = 0;
                }
                list.add(new AdtsExtractor(i2 | z ? 1 : 0));
                return;
            case 3:
                boolean z2 = this.amrFlags | this.constantBitrateSeekingEnabled;
                if (!this.constantBitrateSeekingAlwaysEnabled) {
                    i2 = 0;
                }
                list.add(new AmrExtractor(i2 | z2 ? 1 : 0));
                return;
            case 4:
                Extractor extractor = FLAC_EXTENSION_LOADER.getExtractor(Integer.valueOf(this.flacFlags));
                if (extractor != null) {
                    list.add(extractor);
                    return;
                } else {
                    list.add(new FlacExtractor(this.flacFlags));
                    return;
                }
            case 5:
                list.add(new FlvExtractor());
                return;
            case 6:
                list.add(new MatroskaExtractor(this.matroskaFlags));
                return;
            case 7:
                boolean z3 = this.mp3Flags | this.constantBitrateSeekingEnabled;
                if (!this.constantBitrateSeekingAlwaysEnabled) {
                    i2 = 0;
                }
                list.add(new Mp3Extractor(i2 | z3 ? 1 : 0));
                return;
            case 8:
                list.add(new FragmentedMp4Extractor(this.fragmentedMp4Flags));
                list.add(new Mp4Extractor(this.mp4Flags));
                return;
            case 9:
                list.add(new OggExtractor());
                return;
            case 10:
                list.add(new PsExtractor());
                return;
            case 11:
                list.add(new TsExtractor(this.tsMode, this.tsFlags, this.tsTimestampSearchBytes));
                return;
            case 12:
                list.add(new WavExtractor());
                return;
            case 14:
                list.add(new JpegExtractor());
                return;
            case 15:
                Extractor extractor2 = MIDI_EXTENSION_LOADER.getExtractor(new Object[0]);
                if (extractor2 != null) {
                    list.add(extractor2);
                    return;
                }
                return;
            case 16:
                list.add(new AviExtractor());
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public static Constructor<? extends Extractor> getMidiExtractorConstructor() throws ClassNotFoundException, NoSuchMethodException {
        return Class.forName("com.google.android.exoplayer2.decoder.midi.MidiExtractor").asSubclass(Extractor.class).getConstructor(new Class[0]);
    }

    /* access modifiers changed from: private */
    public static Constructor<? extends Extractor> getFlacExtractorConstructor() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (!Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke((Object) null, new Object[0]))) {
            return null;
        }
        return Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(new Class[]{Integer.TYPE});
    }

    private static final class ExtensionLoader {
        private final ConstructorSupplier constructorSupplier;
        private final AtomicBoolean extensionLoaded = new AtomicBoolean(false);
        private Constructor<? extends Extractor> extractorConstructor;

        public interface ConstructorSupplier {
            Constructor<? extends Extractor> getConstructor() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException;
        }

        public ExtensionLoader(ConstructorSupplier constructorSupplier2) {
            this.constructorSupplier = constructorSupplier2;
        }

        public Extractor getExtractor(Object... objArr) {
            Constructor<? extends Extractor> maybeLoadExtractorConstructor = maybeLoadExtractorConstructor();
            if (maybeLoadExtractorConstructor == null) {
                return null;
            }
            try {
                return (Extractor) maybeLoadExtractorConstructor.newInstance(objArr);
            } catch (Exception e) {
                throw new IllegalStateException("Unexpected error creating extractor", e);
            }
        }

        private Constructor<? extends Extractor> maybeLoadExtractorConstructor() {
            synchronized (this.extensionLoaded) {
                if (this.extensionLoaded.get()) {
                    Constructor<? extends Extractor> constructor = this.extractorConstructor;
                    return constructor;
                }
                try {
                    Constructor<? extends Extractor> constructor2 = this.constructorSupplier.getConstructor();
                    return constructor2;
                } catch (ClassNotFoundException unused) {
                    this.extensionLoaded.set(true);
                    return this.extractorConstructor;
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating extension", e);
                }
            }
        }
    }
}
