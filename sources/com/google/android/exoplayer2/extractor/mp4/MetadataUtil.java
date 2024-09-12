package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.net.HttpHeaders;
import com.reactnativecommunity.clipboard.ClipboardModule;

final class MetadataUtil {
    private static final int PICTURE_TYPE_FRONT_COVER = 3;
    private static final int SHORT_TYPE_ALBUM = 6384738;
    private static final int SHORT_TYPE_ARTIST = 4280916;
    private static final int SHORT_TYPE_COMMENT = 6516084;
    private static final int SHORT_TYPE_COMPOSER_1 = 6516589;
    private static final int SHORT_TYPE_COMPOSER_2 = 7828084;
    private static final int SHORT_TYPE_ENCODER = 7630703;
    private static final int SHORT_TYPE_GENRE = 6776174;
    private static final int SHORT_TYPE_LYRICS = 7108978;
    private static final int SHORT_TYPE_NAME_1 = 7233901;
    private static final int SHORT_TYPE_NAME_2 = 7631467;
    private static final int SHORT_TYPE_YEAR = 6578553;
    static final String[] STANDARD_GENRES = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    private static final String TAG = "MetadataUtil";
    private static final int TYPE_ALBUM_ARTIST = 1631670868;
    private static final int TYPE_COMPILATION = 1668311404;
    private static final int TYPE_COVER_ART = 1668249202;
    private static final int TYPE_DISK_NUMBER = 1684632427;
    private static final int TYPE_GAPLESS_ALBUM = 1885823344;
    private static final int TYPE_GENRE = 1735291493;
    private static final int TYPE_GROUPING = 6779504;
    private static final int TYPE_INTERNAL = 757935405;
    private static final int TYPE_RATING = 1920233063;
    private static final int TYPE_SORT_ALBUM = 1936679276;
    private static final int TYPE_SORT_ALBUM_ARTIST = 1936679265;
    private static final int TYPE_SORT_ARTIST = 1936679282;
    private static final int TYPE_SORT_COMPOSER = 1936679791;
    private static final int TYPE_SORT_TRACK_NAME = 1936682605;
    private static final int TYPE_TEMPO = 1953329263;
    private static final int TYPE_TOP_BYTE_COPYRIGHT = 169;
    private static final int TYPE_TOP_BYTE_REPLACEMENT = 253;
    private static final int TYPE_TRACK_NUMBER = 1953655662;
    private static final int TYPE_TV_SHOW = 1953919848;
    private static final int TYPE_TV_SORT_SHOW = 1936683886;

    private MetadataUtil() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        if (r6 != null) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040 A[LOOP:1: B:17:0x003e->B:18:0x0040, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setFormatMetadata(int r5, com.google.android.exoplayer2.metadata.Metadata r6, com.google.android.exoplayer2.metadata.Metadata r7, com.google.android.exoplayer2.Format.Builder r8, com.google.android.exoplayer2.metadata.Metadata... r9) {
        /*
            com.google.android.exoplayer2.metadata.Metadata r0 = new com.google.android.exoplayer2.metadata.Metadata
            r1 = 0
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r2 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r1]
            r0.<init>((com.google.android.exoplayer2.metadata.Metadata.Entry[]) r2)
            r2 = 1
            if (r5 != r2) goto L_0x000e
            if (r6 == 0) goto L_0x003c
            goto L_0x003d
        L_0x000e:
            r6 = 2
            if (r5 != r6) goto L_0x003c
            if (r7 == 0) goto L_0x003c
            r5 = r1
        L_0x0014:
            int r6 = r7.length()
            if (r5 >= r6) goto L_0x003c
            com.google.android.exoplayer2.metadata.Metadata$Entry r6 = r7.get(r5)
            boolean r3 = r6 instanceof com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry
            if (r3 == 0) goto L_0x0039
            com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry r6 = (com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry) r6
            java.lang.String r3 = r6.key
            java.lang.String r4 = "com.android.capture.fps"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0039
            com.google.android.exoplayer2.metadata.Metadata r5 = new com.google.android.exoplayer2.metadata.Metadata
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r7 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r2]
            r7[r1] = r6
            r5.<init>((com.google.android.exoplayer2.metadata.Metadata.Entry[]) r7)
            r6 = r5
            goto L_0x003d
        L_0x0039:
            int r5 = r5 + 1
            goto L_0x0014
        L_0x003c:
            r6 = r0
        L_0x003d:
            int r5 = r9.length
        L_0x003e:
            if (r1 >= r5) goto L_0x0049
            r7 = r9[r1]
            com.google.android.exoplayer2.metadata.Metadata r6 = r6.copyWithAppendedEntriesFrom(r7)
            int r1 = r1 + 1
            goto L_0x003e
        L_0x0049:
            int r5 = r6.length()
            if (r5 <= 0) goto L_0x0052
            r8.setMetadata(r6)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.MetadataUtil.setFormatMetadata(int, com.google.android.exoplayer2.metadata.Metadata, com.google.android.exoplayer2.metadata.Metadata, com.google.android.exoplayer2.Format$Builder, com.google.android.exoplayer2.metadata.Metadata[]):void");
    }

    public static void setFormatGaplessInfo(int i, GaplessInfoHolder gaplessInfoHolder, Format.Builder builder) {
        if (i == 1 && gaplessInfoHolder.hasGaplessInfo()) {
            builder.setEncoderDelay(gaplessInfoHolder.encoderDelay).setEncoderPadding(gaplessInfoHolder.encoderPadding);
        }
    }

    public static Metadata.Entry parseIlstElement(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition() + parsableByteArray.readInt();
        int readInt = parsableByteArray.readInt();
        int i = (readInt >> 24) & 255;
        if (i == TYPE_TOP_BYTE_COPYRIGHT || i == TYPE_TOP_BYTE_REPLACEMENT) {
            int i2 = 16777215 & readInt;
            if (i2 == SHORT_TYPE_COMMENT) {
                CommentFrame parseCommentAttribute = parseCommentAttribute(readInt, parsableByteArray);
                parsableByteArray.setPosition(position);
                return parseCommentAttribute;
            } else if (i2 == SHORT_TYPE_NAME_1 || i2 == SHORT_TYPE_NAME_2) {
                TextInformationFrame parseTextAttribute = parseTextAttribute(readInt, "TIT2", parsableByteArray);
                parsableByteArray.setPosition(position);
                return parseTextAttribute;
            } else if (i2 == SHORT_TYPE_COMPOSER_1 || i2 == SHORT_TYPE_COMPOSER_2) {
                TextInformationFrame parseTextAttribute2 = parseTextAttribute(readInt, "TCOM", parsableByteArray);
                parsableByteArray.setPosition(position);
                return parseTextAttribute2;
            } else if (i2 == SHORT_TYPE_YEAR) {
                TextInformationFrame parseTextAttribute3 = parseTextAttribute(readInt, "TDRC", parsableByteArray);
                parsableByteArray.setPosition(position);
                return parseTextAttribute3;
            } else if (i2 == SHORT_TYPE_ARTIST) {
                TextInformationFrame parseTextAttribute4 = parseTextAttribute(readInt, "TPE1", parsableByteArray);
                parsableByteArray.setPosition(position);
                return parseTextAttribute4;
            } else if (i2 == SHORT_TYPE_ENCODER) {
                TextInformationFrame parseTextAttribute5 = parseTextAttribute(readInt, "TSSE", parsableByteArray);
                parsableByteArray.setPosition(position);
                return parseTextAttribute5;
            } else if (i2 == SHORT_TYPE_ALBUM) {
                TextInformationFrame parseTextAttribute6 = parseTextAttribute(readInt, "TALB", parsableByteArray);
                parsableByteArray.setPosition(position);
                return parseTextAttribute6;
            } else if (i2 == SHORT_TYPE_LYRICS) {
                TextInformationFrame parseTextAttribute7 = parseTextAttribute(readInt, "USLT", parsableByteArray);
                parsableByteArray.setPosition(position);
                return parseTextAttribute7;
            } else if (i2 == SHORT_TYPE_GENRE) {
                TextInformationFrame parseTextAttribute8 = parseTextAttribute(readInt, "TCON", parsableByteArray);
                parsableByteArray.setPosition(position);
                return parseTextAttribute8;
            } else if (i2 == TYPE_GROUPING) {
                TextInformationFrame parseTextAttribute9 = parseTextAttribute(readInt, "TIT1", parsableByteArray);
                parsableByteArray.setPosition(position);
                return parseTextAttribute9;
            }
        } else if (readInt == TYPE_GENRE) {
            try {
                return parseStandardGenreAttribute(parsableByteArray);
            } finally {
                parsableByteArray.setPosition(position);
            }
        } else if (readInt == TYPE_DISK_NUMBER) {
            TextInformationFrame parseIndexAndCountAttribute = parseIndexAndCountAttribute(readInt, "TPOS", parsableByteArray);
            parsableByteArray.setPosition(position);
            return parseIndexAndCountAttribute;
        } else if (readInt == TYPE_TRACK_NUMBER) {
            TextInformationFrame parseIndexAndCountAttribute2 = parseIndexAndCountAttribute(readInt, "TRCK", parsableByteArray);
            parsableByteArray.setPosition(position);
            return parseIndexAndCountAttribute2;
        } else if (readInt == TYPE_TEMPO) {
            Id3Frame parseUint8Attribute = parseUint8Attribute(readInt, "TBPM", parsableByteArray, true, false);
            parsableByteArray.setPosition(position);
            return parseUint8Attribute;
        } else if (readInt == TYPE_COMPILATION) {
            Id3Frame parseUint8Attribute2 = parseUint8Attribute(readInt, "TCMP", parsableByteArray, true, true);
            parsableByteArray.setPosition(position);
            return parseUint8Attribute2;
        } else if (readInt == TYPE_COVER_ART) {
            ApicFrame parseCoverArt = parseCoverArt(parsableByteArray);
            parsableByteArray.setPosition(position);
            return parseCoverArt;
        } else if (readInt == TYPE_ALBUM_ARTIST) {
            TextInformationFrame parseTextAttribute10 = parseTextAttribute(readInt, "TPE2", parsableByteArray);
            parsableByteArray.setPosition(position);
            return parseTextAttribute10;
        } else if (readInt == TYPE_SORT_TRACK_NAME) {
            TextInformationFrame parseTextAttribute11 = parseTextAttribute(readInt, "TSOT", parsableByteArray);
            parsableByteArray.setPosition(position);
            return parseTextAttribute11;
        } else if (readInt == TYPE_SORT_ALBUM) {
            TextInformationFrame parseTextAttribute12 = parseTextAttribute(readInt, "TSO2", parsableByteArray);
            parsableByteArray.setPosition(position);
            return parseTextAttribute12;
        } else if (readInt == TYPE_SORT_ARTIST) {
            TextInformationFrame parseTextAttribute13 = parseTextAttribute(readInt, "TSOA", parsableByteArray);
            parsableByteArray.setPosition(position);
            return parseTextAttribute13;
        } else if (readInt == TYPE_SORT_ALBUM_ARTIST) {
            TextInformationFrame parseTextAttribute14 = parseTextAttribute(readInt, "TSOP", parsableByteArray);
            parsableByteArray.setPosition(position);
            return parseTextAttribute14;
        } else if (readInt == TYPE_SORT_COMPOSER) {
            TextInformationFrame parseTextAttribute15 = parseTextAttribute(readInt, "TSOC", parsableByteArray);
            parsableByteArray.setPosition(position);
            return parseTextAttribute15;
        } else if (readInt == TYPE_RATING) {
            Id3Frame parseUint8Attribute3 = parseUint8Attribute(readInt, "ITUNESADVISORY", parsableByteArray, false, false);
            parsableByteArray.setPosition(position);
            return parseUint8Attribute3;
        } else if (readInt == TYPE_GAPLESS_ALBUM) {
            Id3Frame parseUint8Attribute4 = parseUint8Attribute(readInt, "ITUNESGAPLESS", parsableByteArray, false, true);
            parsableByteArray.setPosition(position);
            return parseUint8Attribute4;
        } else if (readInt == TYPE_TV_SORT_SHOW) {
            TextInformationFrame parseTextAttribute16 = parseTextAttribute(readInt, "TVSHOWSORT", parsableByteArray);
            parsableByteArray.setPosition(position);
            return parseTextAttribute16;
        } else if (readInt == TYPE_TV_SHOW) {
            TextInformationFrame parseTextAttribute17 = parseTextAttribute(readInt, "TVSHOW", parsableByteArray);
            parsableByteArray.setPosition(position);
            return parseTextAttribute17;
        } else if (readInt == TYPE_INTERNAL) {
            Id3Frame parseInternalAttribute = parseInternalAttribute(parsableByteArray, position);
            parsableByteArray.setPosition(position);
            return parseInternalAttribute;
        }
        Log.d(TAG, "Skipped unknown metadata entry: " + Atom.getAtomTypeString(readInt));
        parsableByteArray.setPosition(position);
        return null;
    }

    public static MdtaMetadataEntry parseMdtaMetadataEntryFromIlst(ParsableByteArray parsableByteArray, int i, String str) {
        while (true) {
            int position = parsableByteArray.getPosition();
            if (position >= i) {
                return null;
            }
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1684108385) {
                int readInt2 = parsableByteArray.readInt();
                int readInt3 = parsableByteArray.readInt();
                int i2 = readInt - 16;
                byte[] bArr = new byte[i2];
                parsableByteArray.readBytes(bArr, 0, i2);
                return new MdtaMetadataEntry(str, bArr, readInt3, readInt2);
            }
            parsableByteArray.setPosition(position + readInt);
        }
    }

    private static TextInformationFrame parseTextAttribute(int i, String str, ParsableByteArray parsableByteArray) {
        int readInt = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            return new TextInformationFrame(str, (String) null, parsableByteArray.readNullTerminatedString(readInt - 16));
        }
        Log.w(TAG, "Failed to parse text attribute: " + Atom.getAtomTypeString(i));
        return null;
    }

    private static CommentFrame parseCommentAttribute(int i, ParsableByteArray parsableByteArray) {
        int readInt = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            String readNullTerminatedString = parsableByteArray.readNullTerminatedString(readInt - 16);
            return new CommentFrame(C.LANGUAGE_UNDETERMINED, readNullTerminatedString, readNullTerminatedString);
        }
        Log.w(TAG, "Failed to parse comment attribute: " + Atom.getAtomTypeString(i));
        return null;
    }

    private static Id3Frame parseUint8Attribute(int i, String str, ParsableByteArray parsableByteArray, boolean z, boolean z2) {
        int parseUint8AttributeValue = parseUint8AttributeValue(parsableByteArray);
        if (z2) {
            parseUint8AttributeValue = Math.min(1, parseUint8AttributeValue);
        }
        if (parseUint8AttributeValue < 0) {
            Log.w(TAG, "Failed to parse uint8 attribute: " + Atom.getAtomTypeString(i));
            return null;
        } else if (z) {
            return new TextInformationFrame(str, (String) null, Integer.toString(parseUint8AttributeValue));
        } else {
            return new CommentFrame(C.LANGUAGE_UNDETERMINED, str, Integer.toString(parseUint8AttributeValue));
        }
    }

    private static TextInformationFrame parseIndexAndCountAttribute(int i, String str, ParsableByteArray parsableByteArray) {
        int readInt = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385 && readInt >= 22) {
            parsableByteArray.skipBytes(10);
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            if (readUnsignedShort > 0) {
                String str2 = "" + readUnsignedShort;
                int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    str2 = str2 + "/" + readUnsignedShort2;
                }
                return new TextInformationFrame(str, (String) null, str2);
            }
        }
        Log.w(TAG, "Failed to parse index/count attribute: " + Atom.getAtomTypeString(i));
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.metadata.id3.TextInformationFrame parseStandardGenreAttribute(com.google.android.exoplayer2.util.ParsableByteArray r3) {
        /*
            int r3 = parseUint8AttributeValue(r3)
            r0 = 0
            if (r3 <= 0) goto L_0x0011
            java.lang.String[] r1 = STANDARD_GENRES
            int r2 = r1.length
            if (r3 > r2) goto L_0x0011
            int r3 = r3 + -1
            r3 = r1[r3]
            goto L_0x0012
        L_0x0011:
            r3 = r0
        L_0x0012:
            if (r3 == 0) goto L_0x001c
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame
            java.lang.String r2 = "TCON"
            r1.<init>(r2, r0, r3)
            return r1
        L_0x001c:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            com.google.android.exoplayer2.util.Log.w(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.MetadataUtil.parseStandardGenreAttribute(com.google.android.exoplayer2.util.ParsableByteArray):com.google.android.exoplayer2.metadata.id3.TextInformationFrame");
    }

    private static ApicFrame parseCoverArt(ParsableByteArray parsableByteArray) {
        int readInt = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
            String str = parseFullAtomFlags == 13 ? "image/jpeg" : parseFullAtomFlags == 14 ? ClipboardModule.MIMETYPE_PNG : null;
            if (str == null) {
                Log.w(TAG, "Unrecognized cover art flags: " + parseFullAtomFlags);
                return null;
            }
            parsableByteArray.skipBytes(4);
            int i = readInt - 16;
            byte[] bArr = new byte[i];
            parsableByteArray.readBytes(bArr, 0, i);
            return new ApicFrame(str, (String) null, 3, bArr);
        }
        Log.w(TAG, "Failed to parse cover art attribute");
        return null;
    }

    private static Id3Frame parseInternalAttribute(ParsableByteArray parsableByteArray, int i) {
        int i2 = -1;
        int i3 = -1;
        String str = null;
        String str2 = null;
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            if (readInt2 == 1835360622) {
                str = parsableByteArray.readNullTerminatedString(readInt - 12);
            } else if (readInt2 == 1851878757) {
                str2 = parsableByteArray.readNullTerminatedString(readInt - 12);
            } else {
                if (readInt2 == 1684108385) {
                    i2 = position;
                    i3 = readInt;
                }
                parsableByteArray.skipBytes(readInt - 12);
            }
        }
        if (str == null || str2 == null || i2 == -1) {
            return null;
        }
        parsableByteArray.setPosition(i2);
        parsableByteArray.skipBytes(16);
        return new InternalFrame(str, str2, parsableByteArray.readNullTerminatedString(i3 - 16));
    }

    private static int parseUint8AttributeValue(ParsableByteArray parsableByteArray) {
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            return parsableByteArray.readUnsignedByte();
        }
        Log.w(TAG, "Failed to parse uint8 attribute value");
        return -1;
    }
}
