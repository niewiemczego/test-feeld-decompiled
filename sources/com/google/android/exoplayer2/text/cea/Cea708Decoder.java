package com.google.android.exoplayer2.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.primitives.SignedBytes;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.text.Typography;
import okio.Utf8;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class Cea708Decoder extends CeaDecoder {
    private static final int CC_VALID_FLAG = 4;
    private static final int CHARACTER_BIG_CARONS = 42;
    private static final int CHARACTER_BIG_OE = 44;
    private static final int CHARACTER_BOLD_BULLET = 53;
    private static final int CHARACTER_CLOSE_DOUBLE_QUOTE = 52;
    private static final int CHARACTER_CLOSE_SINGLE_QUOTE = 50;
    private static final int CHARACTER_DIAERESIS_Y = 63;
    private static final int CHARACTER_ELLIPSIS = 37;
    private static final int CHARACTER_FIVE_EIGHTHS = 120;
    private static final int CHARACTER_HORIZONTAL_BORDER = 125;
    private static final int CHARACTER_LOWER_LEFT_BORDER = 124;
    private static final int CHARACTER_LOWER_RIGHT_BORDER = 126;
    private static final int CHARACTER_MN = 127;
    private static final int CHARACTER_NBTSP = 33;
    private static final int CHARACTER_ONE_EIGHTH = 118;
    private static final int CHARACTER_OPEN_DOUBLE_QUOTE = 51;
    private static final int CHARACTER_OPEN_SINGLE_QUOTE = 49;
    private static final int CHARACTER_SEVEN_EIGHTHS = 121;
    private static final int CHARACTER_SM = 61;
    private static final int CHARACTER_SMALL_CARONS = 58;
    private static final int CHARACTER_SMALL_OE = 60;
    private static final int CHARACTER_SOLID_BLOCK = 48;
    private static final int CHARACTER_THREE_EIGHTHS = 119;
    private static final int CHARACTER_TM = 57;
    private static final int CHARACTER_TSP = 32;
    private static final int CHARACTER_UPPER_LEFT_BORDER = 127;
    private static final int CHARACTER_UPPER_RIGHT_BORDER = 123;
    private static final int CHARACTER_VERTICAL_BORDER = 122;
    private static final int COMMAND_BS = 8;
    private static final int COMMAND_CLW = 136;
    private static final int COMMAND_CR = 13;
    private static final int COMMAND_CW0 = 128;
    private static final int COMMAND_CW1 = 129;
    private static final int COMMAND_CW2 = 130;
    private static final int COMMAND_CW3 = 131;
    private static final int COMMAND_CW4 = 132;
    private static final int COMMAND_CW5 = 133;
    private static final int COMMAND_CW6 = 134;
    private static final int COMMAND_CW7 = 135;
    private static final int COMMAND_DF0 = 152;
    private static final int COMMAND_DF1 = 153;
    private static final int COMMAND_DF2 = 154;
    private static final int COMMAND_DF3 = 155;
    private static final int COMMAND_DF4 = 156;
    private static final int COMMAND_DF5 = 157;
    private static final int COMMAND_DF6 = 158;
    private static final int COMMAND_DF7 = 159;
    private static final int COMMAND_DLC = 142;
    private static final int COMMAND_DLW = 140;
    private static final int COMMAND_DLY = 141;
    private static final int COMMAND_DSW = 137;
    private static final int COMMAND_ETX = 3;
    private static final int COMMAND_EXT1 = 16;
    private static final int COMMAND_EXT1_END = 23;
    private static final int COMMAND_EXT1_START = 17;
    private static final int COMMAND_FF = 12;
    private static final int COMMAND_HCR = 14;
    private static final int COMMAND_HDW = 138;
    private static final int COMMAND_NUL = 0;
    private static final int COMMAND_P16_END = 31;
    private static final int COMMAND_P16_START = 24;
    private static final int COMMAND_RST = 143;
    private static final int COMMAND_SPA = 144;
    private static final int COMMAND_SPC = 145;
    private static final int COMMAND_SPL = 146;
    private static final int COMMAND_SWA = 151;
    private static final int COMMAND_TGW = 139;
    private static final int DTVCC_PACKET_DATA = 2;
    private static final int DTVCC_PACKET_START = 3;
    private static final int GROUP_C0_END = 31;
    private static final int GROUP_C1_END = 159;
    private static final int GROUP_C2_END = 31;
    private static final int GROUP_C3_END = 159;
    private static final int GROUP_G0_END = 127;
    private static final int GROUP_G1_END = 255;
    private static final int GROUP_G2_END = 127;
    private static final int GROUP_G3_END = 255;
    private static final int NUM_WINDOWS = 8;
    private static final String TAG = "Cea708Decoder";
    private final ParsableBitArray captionChannelPacketData = new ParsableBitArray();
    private final ParsableByteArray ccData = new ParsableByteArray();
    private final CueInfoBuilder[] cueInfoBuilders;
    private List<Cue> cues;
    private CueInfoBuilder currentCueInfoBuilder;
    private DtvCcPacket currentDtvCcPacket;
    private int currentWindow;
    private final boolean isWideAspectRatio;
    private List<Cue> lastCues;
    private int previousSequenceNumber = -1;
    private final int selectedServiceNumber;

    public String getName() {
        return TAG;
    }

    public /* bridge */ /* synthetic */ SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    public /* bridge */ /* synthetic */ SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        return super.dequeueOutputBuffer();
    }

    public /* bridge */ /* synthetic */ void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    public /* bridge */ /* synthetic */ void setPositionUs(long j) {
        super.setPositionUs(j);
    }

    public Cea708Decoder(int i, List<byte[]> list) {
        boolean z = true;
        this.selectedServiceNumber = i == -1 ? 1 : i;
        this.isWideAspectRatio = (list == null || !CodecSpecificDataUtil.parseCea708InitializationData(list)) ? false : z;
        this.cueInfoBuilders = new CueInfoBuilder[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.cueInfoBuilders[i2] = new CueInfoBuilder();
        }
        this.currentCueInfoBuilder = this.cueInfoBuilders[0];
    }

    public void flush() {
        super.flush();
        this.cues = null;
        this.lastCues = null;
        this.currentWindow = 0;
        this.currentCueInfoBuilder = this.cueInfoBuilders[0];
        resetCueBuilders();
        this.currentDtvCcPacket = null;
    }

    /* access modifiers changed from: protected */
    public boolean isNewSubtitleDataAvailable() {
        return this.cues != this.lastCues;
    }

    /* access modifiers changed from: protected */
    public Subtitle createSubtitle() {
        this.lastCues = this.cues;
        return new CeaSubtitle((List) Assertions.checkNotNull(this.cues));
    }

    /* access modifiers changed from: protected */
    public void decode(SubtitleInputBuffer subtitleInputBuffer) {
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(subtitleInputBuffer.data);
        this.ccData.reset(byteBuffer.array(), byteBuffer.limit());
        while (this.ccData.bytesLeft() >= 3) {
            int readUnsignedByte = this.ccData.readUnsignedByte() & 7;
            int i = readUnsignedByte & 3;
            boolean z = false;
            boolean z2 = (readUnsignedByte & 4) == 4;
            byte readUnsignedByte2 = (byte) this.ccData.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.ccData.readUnsignedByte();
            if ((i == 2 || i == 3) && z2) {
                if (i == 3) {
                    finalizeCurrentPacket();
                    int i2 = (readUnsignedByte2 & 192) >> 6;
                    int i3 = this.previousSequenceNumber;
                    if (!(i3 == -1 || i2 == (i3 + 1) % 4)) {
                        resetCueBuilders();
                        Log.w(TAG, "Sequence number discontinuity. previous=" + this.previousSequenceNumber + " current=" + i2);
                    }
                    this.previousSequenceNumber = i2;
                    byte b = readUnsignedByte2 & Utf8.REPLACEMENT_BYTE;
                    if (b == 0) {
                        b = SignedBytes.MAX_POWER_OF_TWO;
                    }
                    DtvCcPacket dtvCcPacket = new DtvCcPacket(i2, b);
                    this.currentDtvCcPacket = dtvCcPacket;
                    byte[] bArr = dtvCcPacket.packetData;
                    DtvCcPacket dtvCcPacket2 = this.currentDtvCcPacket;
                    int i4 = dtvCcPacket2.currentIndex;
                    dtvCcPacket2.currentIndex = i4 + 1;
                    bArr[i4] = readUnsignedByte3;
                } else {
                    if (i == 2) {
                        z = true;
                    }
                    Assertions.checkArgument(z);
                    DtvCcPacket dtvCcPacket3 = this.currentDtvCcPacket;
                    if (dtvCcPacket3 == null) {
                        Log.e(TAG, "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                    } else {
                        byte[] bArr2 = dtvCcPacket3.packetData;
                        DtvCcPacket dtvCcPacket4 = this.currentDtvCcPacket;
                        int i5 = dtvCcPacket4.currentIndex;
                        dtvCcPacket4.currentIndex = i5 + 1;
                        bArr2[i5] = readUnsignedByte2;
                        byte[] bArr3 = this.currentDtvCcPacket.packetData;
                        DtvCcPacket dtvCcPacket5 = this.currentDtvCcPacket;
                        int i6 = dtvCcPacket5.currentIndex;
                        dtvCcPacket5.currentIndex = i6 + 1;
                        bArr3[i6] = readUnsignedByte3;
                    }
                }
                if (this.currentDtvCcPacket.currentIndex == (this.currentDtvCcPacket.packetSize * 2) - 1) {
                    finalizeCurrentPacket();
                }
            }
        }
    }

    private void finalizeCurrentPacket() {
        if (this.currentDtvCcPacket != null) {
            processCurrentPacket();
            this.currentDtvCcPacket = null;
        }
    }

    @RequiresNonNull({"currentDtvCcPacket"})
    private void processCurrentPacket() {
        if (this.currentDtvCcPacket.currentIndex != (this.currentDtvCcPacket.packetSize * 2) - 1) {
            Log.d(TAG, "DtvCcPacket ended prematurely; size is " + ((this.currentDtvCcPacket.packetSize * 2) - 1) + ", but current index is " + this.currentDtvCcPacket.currentIndex + " (sequence number " + this.currentDtvCcPacket.sequenceNumber + ");");
        }
        boolean z = false;
        this.captionChannelPacketData.reset(this.currentDtvCcPacket.packetData, this.currentDtvCcPacket.currentIndex);
        while (true) {
            if (this.captionChannelPacketData.bitsLeft() <= 0) {
                break;
            }
            int readBits = this.captionChannelPacketData.readBits(3);
            int readBits2 = this.captionChannelPacketData.readBits(5);
            if (readBits == 7) {
                this.captionChannelPacketData.skipBits(2);
                readBits = this.captionChannelPacketData.readBits(6);
                if (readBits < 7) {
                    Log.w(TAG, "Invalid extended service number: " + readBits);
                }
            }
            if (readBits2 == 0) {
                if (readBits != 0) {
                    Log.w(TAG, "serviceNumber is non-zero (" + readBits + ") when blockSize is 0");
                }
            } else if (readBits != this.selectedServiceNumber) {
                this.captionChannelPacketData.skipBytes(readBits2);
            } else {
                int position = this.captionChannelPacketData.getPosition() + (readBits2 * 8);
                while (this.captionChannelPacketData.getPosition() < position) {
                    int readBits3 = this.captionChannelPacketData.readBits(8);
                    if (readBits3 == 16) {
                        int readBits4 = this.captionChannelPacketData.readBits(8);
                        if (readBits4 <= 31) {
                            handleC2Command(readBits4);
                        } else if (readBits4 <= 127) {
                            handleG2Character(readBits4);
                        } else if (readBits4 <= 159) {
                            handleC3Command(readBits4);
                        } else if (readBits4 <= 255) {
                            handleG3Character(readBits4);
                        } else {
                            Log.w(TAG, "Invalid extended command: " + readBits4);
                        }
                    } else if (readBits3 <= 31) {
                        handleC0Command(readBits3);
                    } else if (readBits3 <= 127) {
                        handleG0Character(readBits3);
                    } else if (readBits3 <= 159) {
                        handleC1Command(readBits3);
                    } else if (readBits3 <= 255) {
                        handleG1Character(readBits3);
                    } else {
                        Log.w(TAG, "Invalid base command: " + readBits3);
                    }
                    z = true;
                }
            }
        }
        if (z) {
            this.cues = getDisplayCues();
        }
    }

    private void handleC0Command(int i) {
        if (i == 0) {
            return;
        }
        if (i == 3) {
            this.cues = getDisplayCues();
        } else if (i != 8) {
            switch (i) {
                case 12:
                    resetCueBuilders();
                    return;
                case 13:
                    this.currentCueInfoBuilder.append(10);
                    return;
                case 14:
                    return;
                default:
                    if (i >= 17 && i <= 23) {
                        Log.w(TAG, "Currently unsupported COMMAND_EXT1 Command: " + i);
                        this.captionChannelPacketData.skipBits(8);
                        return;
                    } else if (i < 24 || i > 31) {
                        Log.w(TAG, "Invalid C0 command: " + i);
                        return;
                    } else {
                        Log.w(TAG, "Currently unsupported COMMAND_P16 Command: " + i);
                        this.captionChannelPacketData.skipBits(16);
                        return;
                    }
            }
        } else {
            this.currentCueInfoBuilder.backspace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0095, code lost:
        if (r2 > 8) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009d, code lost:
        if (r4.captionChannelPacketData.readBit() == false) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009f, code lost:
        r4.cueInfoBuilders[8 - r2].reset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a8, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c7, code lost:
        if (r2 > 8) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cf, code lost:
        if (r4.captionChannelPacketData.readBit() == false) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d1, code lost:
        r4.cueInfoBuilders[8 - r2].setVisibility(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00db, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f5, code lost:
        if (r2 > 8) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00fd, code lost:
        if (r4.captionChannelPacketData.readBit() == false) goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ff, code lost:
        r4.cueInfoBuilders[8 - r2].clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0108, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleC1Command(int r5) {
        /*
            r4 = this;
            r0 = 16
            r1 = 8
            r2 = 1
            switch(r5) {
                case 128: goto L_0x010b;
                case 129: goto L_0x010b;
                case 130: goto L_0x010b;
                case 131: goto L_0x010b;
                case 132: goto L_0x010b;
                case 133: goto L_0x010b;
                case 134: goto L_0x010b;
                case 135: goto L_0x010b;
                case 136: goto L_0x00f5;
                case 137: goto L_0x00de;
                case 138: goto L_0x00c7;
                case 139: goto L_0x00ab;
                case 140: goto L_0x0095;
                case 141: goto L_0x008e;
                case 142: goto L_0x0119;
                case 143: goto L_0x0089;
                case 144: goto L_0x0075;
                case 145: goto L_0x005f;
                case 146: goto L_0x004b;
                case 147: goto L_0x0008;
                case 148: goto L_0x0008;
                case 149: goto L_0x0008;
                case 150: goto L_0x0008;
                case 151: goto L_0x0035;
                case 152: goto L_0x0022;
                case 153: goto L_0x0022;
                case 154: goto L_0x0022;
                case 155: goto L_0x0022;
                case 156: goto L_0x0022;
                case 157: goto L_0x0022;
                case 158: goto L_0x0022;
                case 159: goto L_0x0022;
                default: goto L_0x0008;
            }
        L_0x0008:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid C1 command: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r5 = r0.append(r5)
            java.lang.String r5 = r5.toString()
            java.lang.String r0 = "Cea708Decoder"
            com.google.android.exoplayer2.util.Log.w(r0, r5)
            goto L_0x0119
        L_0x0022:
            int r5 = r5 + -152
            r4.handleDefineWindow(r5)
            int r0 = r4.currentWindow
            if (r0 == r5) goto L_0x0119
            r4.currentWindow = r5
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder[] r0 = r4.cueInfoBuilders
            r5 = r0[r5]
            r4.currentCueInfoBuilder = r5
            goto L_0x0119
        L_0x0035:
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder r5 = r4.currentCueInfoBuilder
            boolean r5 = r5.isDefined()
            if (r5 != 0) goto L_0x0046
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r4.captionChannelPacketData
            r0 = 32
            r5.skipBits(r0)
            goto L_0x0119
        L_0x0046:
            r4.handleSetWindowAttributes()
            goto L_0x0119
        L_0x004b:
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder r5 = r4.currentCueInfoBuilder
            boolean r5 = r5.isDefined()
            if (r5 != 0) goto L_0x005a
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r4.captionChannelPacketData
            r5.skipBits(r0)
            goto L_0x0119
        L_0x005a:
            r4.handleSetPenLocation()
            goto L_0x0119
        L_0x005f:
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder r5 = r4.currentCueInfoBuilder
            boolean r5 = r5.isDefined()
            if (r5 != 0) goto L_0x0070
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r4.captionChannelPacketData
            r0 = 24
            r5.skipBits(r0)
            goto L_0x0119
        L_0x0070:
            r4.handleSetPenColor()
            goto L_0x0119
        L_0x0075:
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder r5 = r4.currentCueInfoBuilder
            boolean r5 = r5.isDefined()
            if (r5 != 0) goto L_0x0084
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r4.captionChannelPacketData
            r5.skipBits(r0)
            goto L_0x0119
        L_0x0084:
            r4.handleSetPenAttributes()
            goto L_0x0119
        L_0x0089:
            r4.resetCueBuilders()
            goto L_0x0119
        L_0x008e:
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r4.captionChannelPacketData
            r5.skipBits(r1)
            goto L_0x0119
        L_0x0095:
            if (r2 > r1) goto L_0x0119
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r4.captionChannelPacketData
            boolean r5 = r5.readBit()
            if (r5 == 0) goto L_0x00a8
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder[] r5 = r4.cueInfoBuilders
            int r0 = 8 - r2
            r5 = r5[r0]
            r5.reset()
        L_0x00a8:
            int r2 = r2 + 1
            goto L_0x0095
        L_0x00ab:
            r5 = r2
        L_0x00ac:
            if (r5 > r1) goto L_0x0119
            com.google.android.exoplayer2.util.ParsableBitArray r0 = r4.captionChannelPacketData
            boolean r0 = r0.readBit()
            if (r0 == 0) goto L_0x00c4
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder[] r0 = r4.cueInfoBuilders
            int r3 = 8 - r5
            r0 = r0[r3]
            boolean r3 = r0.isVisible()
            r3 = r3 ^ r2
            r0.setVisibility(r3)
        L_0x00c4:
            int r5 = r5 + 1
            goto L_0x00ac
        L_0x00c7:
            if (r2 > r1) goto L_0x0119
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r4.captionChannelPacketData
            boolean r5 = r5.readBit()
            if (r5 == 0) goto L_0x00db
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder[] r5 = r4.cueInfoBuilders
            int r0 = 8 - r2
            r5 = r5[r0]
            r0 = 0
            r5.setVisibility(r0)
        L_0x00db:
            int r2 = r2 + 1
            goto L_0x00c7
        L_0x00de:
            r5 = r2
        L_0x00df:
            if (r5 > r1) goto L_0x0119
            com.google.android.exoplayer2.util.ParsableBitArray r0 = r4.captionChannelPacketData
            boolean r0 = r0.readBit()
            if (r0 == 0) goto L_0x00f2
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder[] r0 = r4.cueInfoBuilders
            int r3 = 8 - r5
            r0 = r0[r3]
            r0.setVisibility(r2)
        L_0x00f2:
            int r5 = r5 + 1
            goto L_0x00df
        L_0x00f5:
            if (r2 > r1) goto L_0x0119
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r4.captionChannelPacketData
            boolean r5 = r5.readBit()
            if (r5 == 0) goto L_0x0108
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder[] r5 = r4.cueInfoBuilders
            int r0 = 8 - r2
            r5 = r5[r0]
            r5.clear()
        L_0x0108:
            int r2 = r2 + 1
            goto L_0x00f5
        L_0x010b:
            int r5 = r5 + -128
            int r0 = r4.currentWindow
            if (r0 == r5) goto L_0x0119
            r4.currentWindow = r5
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder[] r0 = r4.cueInfoBuilders
            r5 = r0[r5]
            r4.currentCueInfoBuilder = r5
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.cea.Cea708Decoder.handleC1Command(int):void");
    }

    private void handleC2Command(int i) {
        if (i > 7) {
            if (i <= 15) {
                this.captionChannelPacketData.skipBits(8);
            } else if (i <= 23) {
                this.captionChannelPacketData.skipBits(16);
            } else if (i <= 31) {
                this.captionChannelPacketData.skipBits(24);
            }
        }
    }

    private void handleC3Command(int i) {
        if (i <= 135) {
            this.captionChannelPacketData.skipBits(32);
        } else if (i <= COMMAND_RST) {
            this.captionChannelPacketData.skipBits(40);
        } else if (i <= 159) {
            this.captionChannelPacketData.skipBits(2);
            this.captionChannelPacketData.skipBits(this.captionChannelPacketData.readBits(6) * 8);
        }
    }

    private void handleG0Character(int i) {
        if (i == 127) {
            this.currentCueInfoBuilder.append(9835);
        } else {
            this.currentCueInfoBuilder.append((char) (i & 255));
        }
    }

    private void handleG1Character(int i) {
        this.currentCueInfoBuilder.append((char) (i & 255));
    }

    private void handleG2Character(int i) {
        if (i == 32) {
            this.currentCueInfoBuilder.append(' ');
        } else if (i == 33) {
            this.currentCueInfoBuilder.append(Typography.nbsp);
        } else if (i == 37) {
            this.currentCueInfoBuilder.append(Typography.ellipsis);
        } else if (i == 42) {
            this.currentCueInfoBuilder.append(352);
        } else if (i == 44) {
            this.currentCueInfoBuilder.append(338);
        } else if (i == 63) {
            this.currentCueInfoBuilder.append(376);
        } else if (i == 57) {
            this.currentCueInfoBuilder.append(Typography.tm);
        } else if (i == 58) {
            this.currentCueInfoBuilder.append(353);
        } else if (i == 60) {
            this.currentCueInfoBuilder.append(339);
        } else if (i != 61) {
            switch (i) {
                case 48:
                    this.currentCueInfoBuilder.append(9608);
                    return;
                case 49:
                    this.currentCueInfoBuilder.append(Typography.leftSingleQuote);
                    return;
                case 50:
                    this.currentCueInfoBuilder.append(Typography.rightSingleQuote);
                    return;
                case 51:
                    this.currentCueInfoBuilder.append(Typography.leftDoubleQuote);
                    return;
                case 52:
                    this.currentCueInfoBuilder.append(Typography.rightDoubleQuote);
                    return;
                case 53:
                    this.currentCueInfoBuilder.append(Typography.bullet);
                    return;
                default:
                    switch (i) {
                        case 118:
                            this.currentCueInfoBuilder.append(8539);
                            return;
                        case 119:
                            this.currentCueInfoBuilder.append(8540);
                            return;
                        case 120:
                            this.currentCueInfoBuilder.append(8541);
                            return;
                        case 121:
                            this.currentCueInfoBuilder.append(8542);
                            return;
                        case 122:
                            this.currentCueInfoBuilder.append(9474);
                            return;
                        case 123:
                            this.currentCueInfoBuilder.append(9488);
                            return;
                        case 124:
                            this.currentCueInfoBuilder.append(9492);
                            return;
                        case 125:
                            this.currentCueInfoBuilder.append(9472);
                            return;
                        case 126:
                            this.currentCueInfoBuilder.append(9496);
                            return;
                        case 127:
                            this.currentCueInfoBuilder.append(9484);
                            return;
                        default:
                            Log.w(TAG, "Invalid G2 character: " + i);
                            return;
                    }
            }
        } else {
            this.currentCueInfoBuilder.append(8480);
        }
    }

    private void handleG3Character(int i) {
        if (i == 160) {
            this.currentCueInfoBuilder.append(13252);
            return;
        }
        Log.w(TAG, "Invalid G3 character: " + i);
        this.currentCueInfoBuilder.append('_');
    }

    private void handleSetPenAttributes() {
        this.currentCueInfoBuilder.setPenAttributes(this.captionChannelPacketData.readBits(4), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBit(), this.captionChannelPacketData.readBit(), this.captionChannelPacketData.readBits(3), this.captionChannelPacketData.readBits(3));
    }

    private void handleSetPenColor() {
        int argbColorFromCeaColor = CueInfoBuilder.getArgbColorFromCeaColor(this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2));
        int argbColorFromCeaColor2 = CueInfoBuilder.getArgbColorFromCeaColor(this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2));
        this.captionChannelPacketData.skipBits(2);
        this.currentCueInfoBuilder.setPenColor(argbColorFromCeaColor, argbColorFromCeaColor2, CueInfoBuilder.getArgbColorFromCeaColor(this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2)));
    }

    private void handleSetPenLocation() {
        this.captionChannelPacketData.skipBits(4);
        int readBits = this.captionChannelPacketData.readBits(4);
        this.captionChannelPacketData.skipBits(2);
        this.currentCueInfoBuilder.setPenLocation(readBits, this.captionChannelPacketData.readBits(6));
    }

    private void handleSetWindowAttributes() {
        int argbColorFromCeaColor = CueInfoBuilder.getArgbColorFromCeaColor(this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2));
        int readBits = this.captionChannelPacketData.readBits(2);
        int argbColorFromCeaColor2 = CueInfoBuilder.getArgbColorFromCeaColor(this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2), this.captionChannelPacketData.readBits(2));
        if (this.captionChannelPacketData.readBit()) {
            readBits |= 4;
        }
        boolean readBit = this.captionChannelPacketData.readBit();
        int readBits2 = this.captionChannelPacketData.readBits(2);
        int readBits3 = this.captionChannelPacketData.readBits(2);
        int readBits4 = this.captionChannelPacketData.readBits(2);
        this.captionChannelPacketData.skipBits(8);
        this.currentCueInfoBuilder.setWindowAttributes(argbColorFromCeaColor, argbColorFromCeaColor2, readBit, readBits, readBits2, readBits3, readBits4);
    }

    private void handleDefineWindow(int i) {
        CueInfoBuilder cueInfoBuilder = this.cueInfoBuilders[i];
        this.captionChannelPacketData.skipBits(2);
        boolean readBit = this.captionChannelPacketData.readBit();
        boolean readBit2 = this.captionChannelPacketData.readBit();
        boolean readBit3 = this.captionChannelPacketData.readBit();
        int readBits = this.captionChannelPacketData.readBits(3);
        boolean readBit4 = this.captionChannelPacketData.readBit();
        int readBits2 = this.captionChannelPacketData.readBits(7);
        int readBits3 = this.captionChannelPacketData.readBits(8);
        int readBits4 = this.captionChannelPacketData.readBits(4);
        int readBits5 = this.captionChannelPacketData.readBits(4);
        this.captionChannelPacketData.skipBits(2);
        int readBits6 = this.captionChannelPacketData.readBits(6);
        this.captionChannelPacketData.skipBits(2);
        cueInfoBuilder.defineWindow(readBit, readBit2, readBit3, readBits, readBit4, readBits2, readBits3, readBits5, readBits6, readBits4, this.captionChannelPacketData.readBits(3), this.captionChannelPacketData.readBits(3));
    }

    private List<Cue> getDisplayCues() {
        Cea708CueInfo build;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.cueInfoBuilders[i].isEmpty() && this.cueInfoBuilders[i].isVisible() && (build = this.cueInfoBuilders[i].build()) != null) {
                arrayList.add(build);
            }
        }
        Collections.sort(arrayList, Cea708CueInfo.LEAST_IMPORTANT_FIRST);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(((Cea708CueInfo) arrayList.get(i2)).cue);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    private void resetCueBuilders() {
        for (int i = 0; i < 8; i++) {
            this.cueInfoBuilders[i].reset();
        }
    }

    private static final class DtvCcPacket {
        int currentIndex = 0;
        public final byte[] packetData;
        public final int packetSize;
        public final int sequenceNumber;

        public DtvCcPacket(int i, int i2) {
            this.sequenceNumber = i;
            this.packetSize = i2;
            this.packetData = new byte[((i2 * 2) - 1)];
        }
    }

    private static final class CueInfoBuilder {
        private static final int BORDER_AND_EDGE_TYPE_NONE = 0;
        private static final int BORDER_AND_EDGE_TYPE_UNIFORM = 3;
        public static final int COLOR_SOLID_BLACK;
        public static final int COLOR_SOLID_WHITE = getArgbColorFromCeaColor(2, 2, 2, 0);
        public static final int COLOR_TRANSPARENT;
        private static final int DEFAULT_PRIORITY = 4;
        private static final int DIRECTION_BOTTOM_TO_TOP = 3;
        private static final int DIRECTION_LEFT_TO_RIGHT = 0;
        private static final int DIRECTION_RIGHT_TO_LEFT = 1;
        private static final int DIRECTION_TOP_TO_BOTTOM = 2;
        private static final int HORIZONTAL_SIZE = 209;
        private static final int JUSTIFICATION_CENTER = 2;
        private static final int JUSTIFICATION_FULL = 3;
        private static final int JUSTIFICATION_LEFT = 0;
        private static final int JUSTIFICATION_RIGHT = 1;
        private static final int MAXIMUM_ROW_COUNT = 15;
        private static final int PEN_FONT_STYLE_DEFAULT = 0;
        private static final int PEN_FONT_STYLE_MONOSPACED_WITHOUT_SERIFS = 3;
        private static final int PEN_FONT_STYLE_MONOSPACED_WITH_SERIFS = 1;
        private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITHOUT_SERIFS = 4;
        private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITH_SERIFS = 2;
        private static final int PEN_OFFSET_NORMAL = 1;
        private static final int PEN_SIZE_STANDARD = 1;
        private static final int[] PEN_STYLE_BACKGROUND;
        private static final int[] PEN_STYLE_EDGE_TYPE = {0, 0, 0, 0, 0, 3, 3};
        private static final int[] PEN_STYLE_FONT_STYLE = {0, 1, 2, 3, 4, 3, 4};
        private static final int RELATIVE_CUE_SIZE = 99;
        private static final int VERTICAL_SIZE = 74;
        private static final int[] WINDOW_STYLE_FILL;
        private static final int[] WINDOW_STYLE_JUSTIFICATION = {0, 0, 0, 0, 0, 2, 0};
        private static final int[] WINDOW_STYLE_PRINT_DIRECTION = {0, 0, 0, 0, 0, 0, 2};
        private static final int[] WINDOW_STYLE_SCROLL_DIRECTION = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] WINDOW_STYLE_WORD_WRAP = {false, false, false, true, true, true, false};
        private int anchorId;
        private int backgroundColor;
        private int backgroundColorStartPosition;
        private final SpannableStringBuilder captionStringBuilder = new SpannableStringBuilder();
        private boolean defined;
        private int foregroundColor;
        private int foregroundColorStartPosition;
        private int horizontalAnchor;
        private int italicsStartPosition;
        private int justification;
        private int penStyleId;
        private int priority;
        private boolean relativePositioning;
        private final List<SpannableString> rolledUpCaptions = new ArrayList();
        private int row;
        private int rowCount;
        private boolean rowLock;
        private int underlineStartPosition;
        private int verticalAnchor;
        private boolean visible;
        private int windowFillColor;
        private int windowStyleId;

        static {
            int argbColorFromCeaColor = getArgbColorFromCeaColor(0, 0, 0, 0);
            COLOR_SOLID_BLACK = argbColorFromCeaColor;
            int argbColorFromCeaColor2 = getArgbColorFromCeaColor(0, 0, 0, 3);
            COLOR_TRANSPARENT = argbColorFromCeaColor2;
            WINDOW_STYLE_FILL = new int[]{argbColorFromCeaColor, argbColorFromCeaColor2, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor2, argbColorFromCeaColor, argbColorFromCeaColor};
            PEN_STYLE_BACKGROUND = new int[]{argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor2, argbColorFromCeaColor2};
        }

        public CueInfoBuilder() {
            reset();
        }

        public boolean isEmpty() {
            return !isDefined() || (this.rolledUpCaptions.isEmpty() && this.captionStringBuilder.length() == 0);
        }

        public void reset() {
            clear();
            this.defined = false;
            this.visible = false;
            this.priority = 4;
            this.relativePositioning = false;
            this.verticalAnchor = 0;
            this.horizontalAnchor = 0;
            this.anchorId = 0;
            this.rowCount = 15;
            this.rowLock = true;
            this.justification = 0;
            this.windowStyleId = 0;
            this.penStyleId = 0;
            int i = COLOR_SOLID_BLACK;
            this.windowFillColor = i;
            this.foregroundColor = COLOR_SOLID_WHITE;
            this.backgroundColor = i;
        }

        public void clear() {
            this.rolledUpCaptions.clear();
            this.captionStringBuilder.clear();
            this.italicsStartPosition = -1;
            this.underlineStartPosition = -1;
            this.foregroundColorStartPosition = -1;
            this.backgroundColorStartPosition = -1;
            this.row = 0;
        }

        public boolean isDefined() {
            return this.defined;
        }

        public void setVisibility(boolean z) {
            this.visible = z;
        }

        public boolean isVisible() {
            return this.visible;
        }

        public void defineWindow(boolean z, boolean z2, boolean z3, int i, boolean z4, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            boolean z5 = z2;
            int i9 = i7;
            int i10 = i8;
            this.defined = true;
            this.visible = z;
            this.rowLock = z5;
            this.priority = i;
            this.relativePositioning = z4;
            this.verticalAnchor = i2;
            this.horizontalAnchor = i3;
            this.anchorId = i6;
            int i11 = i4 + 1;
            if (this.rowCount != i11) {
                this.rowCount = i11;
                while (true) {
                    if ((!z5 || this.rolledUpCaptions.size() < this.rowCount) && this.rolledUpCaptions.size() < 15) {
                        break;
                    }
                    this.rolledUpCaptions.remove(0);
                }
            }
            if (!(i9 == 0 || this.windowStyleId == i9)) {
                this.windowStyleId = i9;
                int i12 = i9 - 1;
                setWindowAttributes(WINDOW_STYLE_FILL[i12], COLOR_TRANSPARENT, WINDOW_STYLE_WORD_WRAP[i12], 0, WINDOW_STYLE_PRINT_DIRECTION[i12], WINDOW_STYLE_SCROLL_DIRECTION[i12], WINDOW_STYLE_JUSTIFICATION[i12]);
            }
            if (i10 != 0 && this.penStyleId != i10) {
                this.penStyleId = i10;
                int i13 = i10 - 1;
                setPenAttributes(0, 1, 1, false, false, PEN_STYLE_EDGE_TYPE[i13], PEN_STYLE_FONT_STYLE[i13]);
                setPenColor(COLOR_SOLID_WHITE, PEN_STYLE_BACKGROUND[i13], COLOR_SOLID_BLACK);
            }
        }

        public void setWindowAttributes(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
            this.windowFillColor = i;
            this.justification = i6;
        }

        public void setPenAttributes(int i, int i2, int i3, boolean z, boolean z2, int i4, int i5) {
            if (this.italicsStartPosition != -1) {
                if (!z) {
                    this.captionStringBuilder.setSpan(new StyleSpan(2), this.italicsStartPosition, this.captionStringBuilder.length(), 33);
                    this.italicsStartPosition = -1;
                }
            } else if (z) {
                this.italicsStartPosition = this.captionStringBuilder.length();
            }
            if (this.underlineStartPosition != -1) {
                if (!z2) {
                    this.captionStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, this.captionStringBuilder.length(), 33);
                    this.underlineStartPosition = -1;
                }
            } else if (z2) {
                this.underlineStartPosition = this.captionStringBuilder.length();
            }
        }

        public void setPenColor(int i, int i2, int i3) {
            if (!(this.foregroundColorStartPosition == -1 || this.foregroundColor == i)) {
                this.captionStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, this.captionStringBuilder.length(), 33);
            }
            if (i != COLOR_SOLID_WHITE) {
                this.foregroundColorStartPosition = this.captionStringBuilder.length();
                this.foregroundColor = i;
            }
            if (!(this.backgroundColorStartPosition == -1 || this.backgroundColor == i2)) {
                this.captionStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, this.captionStringBuilder.length(), 33);
            }
            if (i2 != COLOR_SOLID_BLACK) {
                this.backgroundColorStartPosition = this.captionStringBuilder.length();
                this.backgroundColor = i2;
            }
        }

        public void setPenLocation(int i, int i2) {
            if (this.row != i) {
                append(10);
            }
            this.row = i;
        }

        public void backspace() {
            int length = this.captionStringBuilder.length();
            if (length > 0) {
                this.captionStringBuilder.delete(length - 1, length);
            }
        }

        public void append(char c) {
            if (c == 10) {
                this.rolledUpCaptions.add(buildSpannableString());
                this.captionStringBuilder.clear();
                if (this.italicsStartPosition != -1) {
                    this.italicsStartPosition = 0;
                }
                if (this.underlineStartPosition != -1) {
                    this.underlineStartPosition = 0;
                }
                if (this.foregroundColorStartPosition != -1) {
                    this.foregroundColorStartPosition = 0;
                }
                if (this.backgroundColorStartPosition != -1) {
                    this.backgroundColorStartPosition = 0;
                }
                while (true) {
                    if ((this.rowLock && this.rolledUpCaptions.size() >= this.rowCount) || this.rolledUpCaptions.size() >= 15) {
                        this.rolledUpCaptions.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.captionStringBuilder.append(c);
            }
        }

        public SpannableString buildSpannableString() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.captionStringBuilder);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.italicsStartPosition != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.italicsStartPosition, length, 33);
                }
                if (this.underlineStartPosition != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, length, 33);
                }
                if (this.foregroundColorStartPosition != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, length, 33);
                }
                if (this.backgroundColorStartPosition != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0067  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0091  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x009e  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00a0  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00ac  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.exoplayer2.text.cea.Cea708Decoder.Cea708CueInfo build() {
            /*
                r15 = this;
                boolean r0 = r15.isEmpty()
                if (r0 == 0) goto L_0x0008
                r0 = 0
                return r0
            L_0x0008:
                android.text.SpannableStringBuilder r2 = new android.text.SpannableStringBuilder
                r2.<init>()
                r0 = 0
                r1 = r0
            L_0x000f:
                java.util.List<android.text.SpannableString> r3 = r15.rolledUpCaptions
                int r3 = r3.size()
                if (r1 >= r3) goto L_0x002a
                java.util.List<android.text.SpannableString> r3 = r15.rolledUpCaptions
                java.lang.Object r3 = r3.get(r1)
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r2.append(r3)
                r3 = 10
                r2.append(r3)
                int r1 = r1 + 1
                goto L_0x000f
            L_0x002a:
                android.text.SpannableString r1 = r15.buildSpannableString()
                r2.append(r1)
                int r1 = r15.justification
                r3 = 2
                r4 = 3
                r5 = 1
                if (r1 == 0) goto L_0x0060
                if (r1 == r5) goto L_0x005d
                if (r1 == r3) goto L_0x005a
                if (r1 != r4) goto L_0x003f
                goto L_0x0060
            L_0x003f:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unexpected justification value: "
                java.lang.StringBuilder r1 = r1.append(r2)
                int r2 = r15.justification
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x005a:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER
                goto L_0x0062
            L_0x005d:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE
                goto L_0x0062
            L_0x0060:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL
            L_0x0062:
                r6 = r1
                boolean r1 = r15.relativePositioning
                if (r1 == 0) goto L_0x0072
                int r1 = r15.horizontalAnchor
                float r1 = (float) r1
                r7 = 1120272384(0x42c60000, float:99.0)
                float r1 = r1 / r7
                int r8 = r15.verticalAnchor
                float r8 = (float) r8
                float r8 = r8 / r7
                goto L_0x007f
            L_0x0072:
                int r1 = r15.horizontalAnchor
                float r1 = (float) r1
                r7 = 1129381888(0x43510000, float:209.0)
                float r1 = r1 / r7
                int r7 = r15.verticalAnchor
                float r7 = (float) r7
                r8 = 1116995584(0x42940000, float:74.0)
                float r8 = r7 / r8
            L_0x007f:
                r7 = 1063675494(0x3f666666, float:0.9)
                float r1 = r1 * r7
                r9 = 1028443341(0x3d4ccccd, float:0.05)
                float r10 = r1 + r9
                float r8 = r8 * r7
                float r7 = r8 + r9
                int r1 = r15.anchorId
                int r8 = r1 / 3
                if (r8 != 0) goto L_0x0093
                r8 = r0
                goto L_0x009a
            L_0x0093:
                int r8 = r1 / 3
                if (r8 != r5) goto L_0x0099
                r8 = r5
                goto L_0x009a
            L_0x0099:
                r8 = r3
            L_0x009a:
                int r9 = r1 % 3
                if (r9 != 0) goto L_0x00a0
                r9 = r0
                goto L_0x00a6
            L_0x00a0:
                int r1 = r1 % r4
                if (r1 != r5) goto L_0x00a5
                r9 = r5
                goto L_0x00a6
            L_0x00a5:
                r9 = r3
            L_0x00a6:
                int r1 = r15.windowFillColor
                int r3 = COLOR_SOLID_BLACK
                if (r1 == r3) goto L_0x00ad
                r0 = r5
            L_0x00ad:
                com.google.android.exoplayer2.text.cea.Cea708Decoder$Cea708CueInfo r13 = new com.google.android.exoplayer2.text.cea.Cea708Decoder$Cea708CueInfo
                r5 = 0
                r11 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
                int r12 = r15.windowFillColor
                int r14 = r15.priority
                r1 = r13
                r3 = r6
                r4 = r7
                r6 = r8
                r7 = r10
                r8 = r9
                r9 = r11
                r10 = r0
                r11 = r12
                r12 = r14
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.cea.Cea708Decoder.CueInfoBuilder.build():com.google.android.exoplayer2.text.cea.Cea708Decoder$Cea708CueInfo");
        }

        public static int getArgbColorFromCeaColor(int i, int i2, int i3) {
            return getArgbColorFromCeaColor(i, i2, i3, 0);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0024  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0029  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x002b  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x002e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getArgbColorFromCeaColor(int r4, int r5, int r6, int r7) {
            /*
                r0 = 0
                r1 = 4
                com.google.android.exoplayer2.util.Assertions.checkIndex(r4, r0, r1)
                com.google.android.exoplayer2.util.Assertions.checkIndex(r5, r0, r1)
                com.google.android.exoplayer2.util.Assertions.checkIndex(r6, r0, r1)
                com.google.android.exoplayer2.util.Assertions.checkIndex(r7, r0, r1)
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L_0x0021
                if (r7 == r1) goto L_0x0021
                r3 = 2
                if (r7 == r3) goto L_0x001e
                r3 = 3
                if (r7 == r3) goto L_0x001c
                goto L_0x0021
            L_0x001c:
                r7 = r0
                goto L_0x0022
            L_0x001e:
                r7 = 127(0x7f, float:1.78E-43)
                goto L_0x0022
            L_0x0021:
                r7 = r2
            L_0x0022:
                if (r4 <= r1) goto L_0x0026
                r4 = r2
                goto L_0x0027
            L_0x0026:
                r4 = r0
            L_0x0027:
                if (r5 <= r1) goto L_0x002b
                r5 = r2
                goto L_0x002c
            L_0x002b:
                r5 = r0
            L_0x002c:
                if (r6 <= r1) goto L_0x002f
                r0 = r2
            L_0x002f:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.cea.Cea708Decoder.CueInfoBuilder.getArgbColorFromCeaColor(int, int, int, int):int");
        }
    }

    private static final class Cea708CueInfo {
        /* access modifiers changed from: private */
        public static final Comparator<Cea708CueInfo> LEAST_IMPORTANT_FIRST = new Cea708Decoder$Cea708CueInfo$$ExternalSyntheticLambda0();
        public final Cue cue;
        public final int priority;

        public Cea708CueInfo(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4, int i5) {
            Cue.Builder size = new Cue.Builder().setText(charSequence).setTextAlignment(alignment).setLine(f, i).setLineAnchor(i2).setPosition(f2).setPositionAnchor(i3).setSize(f3);
            if (z) {
                size.setWindowColor(i4);
            }
            this.cue = size.build();
            this.priority = i5;
        }
    }
}
