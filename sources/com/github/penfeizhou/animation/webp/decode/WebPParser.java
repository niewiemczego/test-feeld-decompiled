package com.github.penfeizhou.animation.webp.decode;

import android.content.Context;
import com.github.penfeizhou.animation.io.Reader;
import com.github.penfeizhou.animation.io.StreamReader;
import com.github.penfeizhou.animation.webp.io.WebPReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class WebPParser {

    static class FormatException extends IOException {
        FormatException() {
            super("WebP Format error");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0020 A[SYNTHETIC, Splitter:B:16:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x002c A[SYNTHETIC, Splitter:B:24:0x002c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isAWebP(java.lang.String r2) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0029, all -> 0x001d }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0029, all -> 0x001d }
            com.github.penfeizhou.animation.io.StreamReader r2 = new com.github.penfeizhou.animation.io.StreamReader     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            boolean r2 = isAWebP((com.github.penfeizhou.animation.io.Reader) r2)     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.github.penfeizhou.animation.webp.decode.WebPParser.isAWebP(java.lang.String):boolean");
    }

    public static boolean isAWebP(Context context, String str) {
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            boolean isAWebP = isAWebP((Reader) new StreamReader(open));
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return isAWebP;
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

    public static boolean isAWebP(Context context, int i) {
        InputStream inputStream = null;
        try {
            InputStream openRawResource = context.getResources().openRawResource(i);
            boolean isAWebP = isAWebP((Reader) new StreamReader(openRawResource));
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return isAWebP;
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

    public static boolean isAWebP(Reader reader) {
        WebPReader webPReader = reader instanceof WebPReader ? (WebPReader) reader : new WebPReader(reader);
        try {
            if (!webPReader.matchFourCC("RIFF")) {
                return false;
            }
            webPReader.skip(4);
            if (!webPReader.matchFourCC("WEBP")) {
                return false;
            }
            while (webPReader.available() > 0) {
                BaseChunk parseChunk = parseChunk(webPReader);
                if (parseChunk instanceof VP8XChunk) {
                    return ((VP8XChunk) parseChunk).animation();
                }
            }
            return false;
        } catch (IOException e) {
            if (!(e instanceof FormatException)) {
                e.printStackTrace();
            }
        }
    }

    public static List<BaseChunk> parse(WebPReader webPReader) throws IOException {
        if (webPReader.matchFourCC("RIFF")) {
            webPReader.skip(4);
            if (webPReader.matchFourCC("WEBP")) {
                ArrayList arrayList = new ArrayList();
                while (webPReader.available() > 0) {
                    arrayList.add(parseChunk(webPReader));
                }
                return arrayList;
            }
            throw new FormatException();
        }
        throw new FormatException();
    }

    static BaseChunk parseChunk(WebPReader webPReader) throws IOException {
        BaseChunk baseChunk;
        int position = webPReader.position();
        int fourCC = webPReader.getFourCC();
        int uInt32 = webPReader.getUInt32();
        if (VP8XChunk.ID == fourCC) {
            baseChunk = new VP8XChunk();
        } else if (ANIMChunk.ID == fourCC) {
            baseChunk = new ANIMChunk();
        } else if (ANMFChunk.ID == fourCC) {
            baseChunk = new ANMFChunk();
        } else if (ALPHChunk.ID == fourCC) {
            baseChunk = new ALPHChunk();
        } else if (VP8Chunk.ID == fourCC) {
            baseChunk = new VP8Chunk();
        } else if (VP8LChunk.ID == fourCC) {
            baseChunk = new VP8LChunk();
        } else if (ICCPChunk.ID == fourCC) {
            baseChunk = new ICCPChunk();
        } else if (XMPChunk.ID == fourCC) {
            baseChunk = new XMPChunk();
        } else if (EXIFChunk.ID == fourCC) {
            baseChunk = new EXIFChunk();
        } else {
            baseChunk = new BaseChunk();
        }
        baseChunk.chunkFourCC = fourCC;
        baseChunk.payloadSize = uInt32;
        baseChunk.offset = position;
        baseChunk.parse(webPReader);
        return baseChunk;
    }
}
