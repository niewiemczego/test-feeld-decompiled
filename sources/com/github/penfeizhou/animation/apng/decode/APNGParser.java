package com.github.penfeizhou.animation.apng.decode;

import android.content.Context;
import com.github.penfeizhou.animation.apng.io.APNGReader;
import com.github.penfeizhou.animation.io.Reader;
import com.github.penfeizhou.animation.io.StreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class APNGParser {

    static class FormatException extends IOException {
        FormatException() {
            super("APNG Format error");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0020 A[SYNTHETIC, Splitter:B:16:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x002c A[SYNTHETIC, Splitter:B:24:0x002c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isAPNG(java.lang.String r2) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0029, all -> 0x001d }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0029, all -> 0x001d }
            com.github.penfeizhou.animation.io.StreamReader r2 = new com.github.penfeizhou.animation.io.StreamReader     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            boolean r2 = isAPNG((com.github.penfeizhou.animation.io.Reader) r2)     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            r1.close()     // Catch:{ IOException -> 0x0013 }
            goto L_0x0017
        L_0x0013:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0017:
            return r2
        L_0x0018:
            r2 = move-exception
            r0 = r1
            goto L_0x001e
        L_0x001b:
            r0 = r1
            goto L_0x0029
        L_0x001d:
            r2 = move-exception
        L_0x001e:
            if (r0 == 0) goto L_0x0028
            r0.close()     // Catch:{ IOException -> 0x0024 }
            goto L_0x0028
        L_0x0024:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0028:
            throw r2
        L_0x0029:
            r2 = 0
            if (r0 == 0) goto L_0x0034
            r0.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0034
        L_0x0030:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0034:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.penfeizhou.animation.apng.decode.APNGParser.isAPNG(java.lang.String):boolean");
    }

    public static boolean isAPNG(Context context, String str) {
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            boolean isAPNG = isAPNG((Reader) new StreamReader(open));
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return isAPNG;
        } catch (Exception unused) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean isAPNG(Context context, int i) {
        InputStream inputStream = null;
        try {
            InputStream openRawResource = context.getResources().openRawResource(i);
            boolean isAPNG = isAPNG((Reader) new StreamReader(openRawResource));
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return isAPNG;
        } catch (Exception unused) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean isAPNG(Reader reader) {
        APNGReader aPNGReader = reader instanceof APNGReader ? (APNGReader) reader : new APNGReader(reader);
        try {
            if (!aPNGReader.matchFourCC("PNG") || !aPNGReader.matchFourCC("\r\n\u001a\n")) {
                throw new FormatException();
            }
            while (aPNGReader.available() > 0) {
                if (parseChunk(aPNGReader) instanceof ACTLChunk) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            if (e instanceof FormatException) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public static List<Chunk> parse(APNGReader aPNGReader) throws IOException {
        if (!aPNGReader.matchFourCC("PNG") || !aPNGReader.matchFourCC("\r\n\u001a\n")) {
            throw new FormatException();
        }
        ArrayList arrayList = new ArrayList();
        while (aPNGReader.available() > 0) {
            arrayList.add(parseChunk(aPNGReader));
        }
        return arrayList;
    }

    private static Chunk parseChunk(APNGReader aPNGReader) throws IOException {
        Chunk chunk;
        int position = aPNGReader.position();
        int readInt = aPNGReader.readInt();
        int readFourCC = aPNGReader.readFourCC();
        if (readFourCC == ACTLChunk.ID) {
            chunk = new ACTLChunk();
        } else if (readFourCC == FCTLChunk.ID) {
            chunk = new FCTLChunk();
        } else if (readFourCC == FDATChunk.ID) {
            chunk = new FDATChunk();
        } else if (readFourCC == IDATChunk.ID) {
            chunk = new IDATChunk();
        } else if (readFourCC == IENDChunk.ID) {
            chunk = new IENDChunk();
        } else if (readFourCC == IHDRChunk.ID) {
            chunk = new IHDRChunk();
        } else {
            chunk = new Chunk();
        }
        chunk.offset = position;
        chunk.fourcc = readFourCC;
        chunk.length = readInt;
        chunk.parse(aPNGReader);
        chunk.crc = aPNGReader.readInt();
        return chunk;
    }
}
