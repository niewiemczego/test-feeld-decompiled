package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;

public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new Parcelable.Creator<TextInformationFrame>() {
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }

        public TextInformationFrame[] newArray(int i) {
            return new TextInformationFrame[i];
        }
    };
    public final String description;
    public final String value;

    public TextInformationFrame(String str, String str2, String str3) {
        super(str);
        this.description = str2;
        this.value = str3;
    }

    TextInformationFrame(Parcel parcel) {
        super((String) Util.castNonNull(parcel.readString()));
        this.description = parcel.readString();
        this.value = (String) Util.castNonNull(parcel.readString());
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void populateMediaMetadata(com.google.android.exoplayer2.MediaMetadata.Builder r9) {
        /*
            r8 = this;
            java.lang.String r0 = r8.id
            r0.hashCode()
            int r1 = r0.hashCode()
            r2 = 4
            r3 = 3
            r4 = 0
            r5 = 2
            r6 = 1
            r7 = -1
            switch(r1) {
                case 82815: goto L_0x0125;
                case 82878: goto L_0x011a;
                case 82897: goto L_0x010f;
                case 83253: goto L_0x0104;
                case 83254: goto L_0x00f9;
                case 83255: goto L_0x00ee;
                case 83341: goto L_0x00e3;
                case 83378: goto L_0x00d8;
                case 83536: goto L_0x00ca;
                case 83552: goto L_0x00bc;
                case 2567331: goto L_0x00ae;
                case 2569357: goto L_0x00a0;
                case 2569891: goto L_0x0092;
                case 2570401: goto L_0x0084;
                case 2570410: goto L_0x0076;
                case 2571565: goto L_0x0068;
                case 2575251: goto L_0x005a;
                case 2581512: goto L_0x004c;
                case 2581513: goto L_0x003e;
                case 2581514: goto L_0x0030;
                case 2583398: goto L_0x0022;
                case 2590194: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x012f
        L_0x0014:
            java.lang.String r1 = "TYER"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x001e
            goto L_0x012f
        L_0x001e:
            r7 = 21
            goto L_0x012f
        L_0x0022:
            java.lang.String r1 = "TRCK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002c
            goto L_0x012f
        L_0x002c:
            r7 = 20
            goto L_0x012f
        L_0x0030:
            java.lang.String r1 = "TPE3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003a
            goto L_0x012f
        L_0x003a:
            r7 = 19
            goto L_0x012f
        L_0x003e:
            java.lang.String r1 = "TPE2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0048
            goto L_0x012f
        L_0x0048:
            r7 = 18
            goto L_0x012f
        L_0x004c:
            java.lang.String r1 = "TPE1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0056
            goto L_0x012f
        L_0x0056:
            r7 = 17
            goto L_0x012f
        L_0x005a:
            java.lang.String r1 = "TIT2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0064
            goto L_0x012f
        L_0x0064:
            r7 = 16
            goto L_0x012f
        L_0x0068:
            java.lang.String r1 = "TEXT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0072
            goto L_0x012f
        L_0x0072:
            r7 = 15
            goto L_0x012f
        L_0x0076:
            java.lang.String r1 = "TDRL"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0080
            goto L_0x012f
        L_0x0080:
            r7 = 14
            goto L_0x012f
        L_0x0084:
            java.lang.String r1 = "TDRC"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x008e
            goto L_0x012f
        L_0x008e:
            r7 = 13
            goto L_0x012f
        L_0x0092:
            java.lang.String r1 = "TDAT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x009c
            goto L_0x012f
        L_0x009c:
            r7 = 12
            goto L_0x012f
        L_0x00a0:
            java.lang.String r1 = "TCOM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00aa
            goto L_0x012f
        L_0x00aa:
            r7 = 11
            goto L_0x012f
        L_0x00ae:
            java.lang.String r1 = "TALB"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00b8
            goto L_0x012f
        L_0x00b8:
            r7 = 10
            goto L_0x012f
        L_0x00bc:
            java.lang.String r1 = "TYE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c6
            goto L_0x012f
        L_0x00c6:
            r7 = 9
            goto L_0x012f
        L_0x00ca:
            java.lang.String r1 = "TXT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00d4
            goto L_0x012f
        L_0x00d4:
            r7 = 8
            goto L_0x012f
        L_0x00d8:
            java.lang.String r1 = "TT2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00e1
            goto L_0x012f
        L_0x00e1:
            r7 = 7
            goto L_0x012f
        L_0x00e3:
            java.lang.String r1 = "TRK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00ec
            goto L_0x012f
        L_0x00ec:
            r7 = 6
            goto L_0x012f
        L_0x00ee:
            java.lang.String r1 = "TP3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00f7
            goto L_0x012f
        L_0x00f7:
            r7 = 5
            goto L_0x012f
        L_0x00f9:
            java.lang.String r1 = "TP2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0102
            goto L_0x012f
        L_0x0102:
            r7 = r2
            goto L_0x012f
        L_0x0104:
            java.lang.String r1 = "TP1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x010d
            goto L_0x012f
        L_0x010d:
            r7 = r3
            goto L_0x012f
        L_0x010f:
            java.lang.String r1 = "TDA"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0118
            goto L_0x012f
        L_0x0118:
            r7 = r5
            goto L_0x012f
        L_0x011a:
            java.lang.String r1 = "TCM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0123
            goto L_0x012f
        L_0x0123:
            r7 = r6
            goto L_0x012f
        L_0x0125:
            java.lang.String r1 = "TAL"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x012e
            goto L_0x012f
        L_0x012e:
            r7 = r4
        L_0x012f:
            switch(r7) {
                case 0: goto L_0x0213;
                case 1: goto L_0x020d;
                case 2: goto L_0x01e9;
                case 3: goto L_0x01e3;
                case 4: goto L_0x01dd;
                case 5: goto L_0x01d7;
                case 6: goto L_0x01ae;
                case 7: goto L_0x01a8;
                case 8: goto L_0x01a1;
                case 9: goto L_0x0192;
                case 10: goto L_0x0213;
                case 11: goto L_0x020d;
                case 12: goto L_0x01e9;
                case 13: goto L_0x0163;
                case 14: goto L_0x0134;
                case 15: goto L_0x01a1;
                case 16: goto L_0x01a8;
                case 17: goto L_0x01e3;
                case 18: goto L_0x01dd;
                case 19: goto L_0x01d7;
                case 20: goto L_0x01ae;
                case 21: goto L_0x0192;
                default: goto L_0x0132;
            }
        L_0x0132:
            goto L_0x0218
        L_0x0134:
            java.lang.String r0 = r8.value
            java.util.List r0 = parseId3v2point4TimestampFrameForDate(r0)
            int r1 = r0.size()
            if (r1 == r6) goto L_0x0158
            if (r1 == r5) goto L_0x014f
            if (r1 == r3) goto L_0x0146
            goto L_0x0218
        L_0x0146:
            java.lang.Object r1 = r0.get(r5)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r9.setReleaseDay(r1)
        L_0x014f:
            java.lang.Object r1 = r0.get(r6)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r9.setReleaseMonth(r1)
        L_0x0158:
            java.lang.Object r0 = r0.get(r4)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r9.setReleaseYear(r0)
            goto L_0x0218
        L_0x0163:
            java.lang.String r0 = r8.value
            java.util.List r0 = parseId3v2point4TimestampFrameForDate(r0)
            int r1 = r0.size()
            if (r1 == r6) goto L_0x0187
            if (r1 == r5) goto L_0x017e
            if (r1 == r3) goto L_0x0175
            goto L_0x0218
        L_0x0175:
            java.lang.Object r1 = r0.get(r5)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r9.setRecordingDay(r1)
        L_0x017e:
            java.lang.Object r1 = r0.get(r6)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r9.setRecordingMonth(r1)
        L_0x0187:
            java.lang.Object r0 = r0.get(r4)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r9.setRecordingYear(r0)
            goto L_0x0218
        L_0x0192:
            java.lang.String r0 = r8.value     // Catch:{  }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{  }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{  }
            r9.setRecordingYear(r0)     // Catch:{  }
            goto L_0x0218
        L_0x01a1:
            java.lang.String r0 = r8.value
            r9.setWriter(r0)
            goto L_0x0218
        L_0x01a8:
            java.lang.String r0 = r8.value
            r9.setTitle(r0)
            goto L_0x0218
        L_0x01ae:
            java.lang.String r0 = r8.value
            java.lang.String r1 = "/"
            java.lang.String[] r0 = com.google.android.exoplayer2.util.Util.split(r0, r1)
            r1 = r0[r4]     // Catch:{  }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{  }
            int r2 = r0.length     // Catch:{  }
            if (r2 <= r6) goto L_0x01ca
            r0 = r0[r6]     // Catch:{  }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{  }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{  }
            goto L_0x01cb
        L_0x01ca:
            r0 = 0
        L_0x01cb:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{  }
            com.google.android.exoplayer2.MediaMetadata$Builder r9 = r9.setTrackNumber(r1)     // Catch:{  }
            r9.setTotalTrackCount(r0)     // Catch:{  }
            goto L_0x0218
        L_0x01d7:
            java.lang.String r0 = r8.value
            r9.setConductor(r0)
            goto L_0x0218
        L_0x01dd:
            java.lang.String r0 = r8.value
            r9.setAlbumArtist(r0)
            goto L_0x0218
        L_0x01e3:
            java.lang.String r0 = r8.value
            r9.setArtist(r0)
            goto L_0x0218
        L_0x01e9:
            java.lang.String r0 = r8.value     // Catch:{ NumberFormatException -> 0x0218 }
            java.lang.String r0 = r0.substring(r5, r2)     // Catch:{ NumberFormatException -> 0x0218 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0218 }
            java.lang.String r1 = r8.value     // Catch:{ NumberFormatException -> 0x0218 }
            java.lang.String r1 = r1.substring(r4, r5)     // Catch:{ NumberFormatException -> 0x0218 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0218 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0218 }
            com.google.android.exoplayer2.MediaMetadata$Builder r9 = r9.setRecordingMonth(r0)     // Catch:{ NumberFormatException -> 0x0218 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x0218 }
            r9.setRecordingDay(r0)     // Catch:{ NumberFormatException -> 0x0218 }
            goto L_0x0218
        L_0x020d:
            java.lang.String r0 = r8.value
            r9.setComposer(r0)
            goto L_0x0218
        L_0x0213:
            java.lang.String r0 = r8.value
            r9.setAlbumTitle(r0)
        L_0x0218:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.TextInformationFrame.populateMediaMetadata(com.google.android.exoplayer2.MediaMetadata$Builder):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        if (!Util.areEqual(this.id, textInformationFrame.id) || !Util.areEqual(this.description, textInformationFrame.description) || !Util.areEqual(this.value, textInformationFrame.value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (527 + this.id.hashCode()) * 31;
        String str = this.description;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return this.id + ": description=" + this.description + ": value=" + this.value;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.description);
        parcel.writeString(this.value);
    }

    private static List<Integer> parseId3v2point4TimestampFrameForDate(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }
}
