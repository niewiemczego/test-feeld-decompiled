package com.github.penfeizhou.animation.gif.decode;

import android.content.Context;
import com.github.penfeizhou.animation.gif.io.GifReader;
import com.github.penfeizhou.animation.io.Reader;
import com.github.penfeizhou.animation.io.StreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GifParser {

    static class FormatException extends IOException {
        FormatException() {
            super("Gif Format error");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0020 A[SYNTHETIC, Splitter:B:16:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x002c A[SYNTHETIC, Splitter:B:24:0x002c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isGif(java.lang.String r2) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0029, all -> 0x001d }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0029, all -> 0x001d }
            com.github.penfeizhou.animation.io.StreamReader r2 = new com.github.penfeizhou.animation.io.StreamReader     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            boolean r2 = isGif((com.github.penfeizhou.animation.io.Reader) r2)     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.github.penfeizhou.animation.gif.decode.GifParser.isGif(java.lang.String):boolean");
    }

    public static boolean isGif(Context context, String str) {
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            boolean isGif = isGif((Reader) new StreamReader(open));
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return isGif;
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

    public static boolean isGif(Context context, int i) {
        InputStream inputStream = null;
        try {
            InputStream openRawResource = context.getResources().openRawResource(i);
            boolean isGif = isGif((Reader) new StreamReader(openRawResource));
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return isGif;
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

    public static boolean isGif(Reader reader) {
        try {
            checkHeader(reader instanceof GifReader ? (GifReader) reader : new GifReader(reader));
            return true;
        } catch (IOException e) {
            if (e instanceof FormatException) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public static List<Block> parse(GifReader gifReader) throws IOException {
        checkHeader(gifReader);
        ArrayList arrayList = new ArrayList();
        LogicalScreenDescriptor logicalScreenDescriptor = new LogicalScreenDescriptor();
        logicalScreenDescriptor.receive(gifReader);
        arrayList.add(logicalScreenDescriptor);
        if (logicalScreenDescriptor.gColorTableFlag()) {
            ColorTable colorTable = new ColorTable(logicalScreenDescriptor.gColorTableSize());
            colorTable.receive(gifReader);
            arrayList.add(colorTable);
        }
        while (true) {
            try {
                byte peek = gifReader.peek();
                if (peek == 59) {
                    break;
                }
                Block block = null;
                if (peek == 33) {
                    block = ExtensionBlock.retrieve(gifReader);
                } else if (peek == 44) {
                    block = new ImageDescriptor();
                }
                if (block != null) {
                    block.receive(gifReader);
                    arrayList.add(block);
                } else {
                    throw new FormatException();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    private static void checkHeader(GifReader gifReader) throws IOException {
        byte peek;
        if (gifReader.peek() != 71 || gifReader.peek() != 73 || gifReader.peek() != 70 || gifReader.peek() != 56 || (((peek = gifReader.peek()) != 55 && peek != 57) || gifReader.peek() != 97)) {
            throw new FormatException();
        }
    }
}
