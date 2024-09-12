package io.sentry.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public final class FileUtils {
    public static boolean deleteRecursively(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return true;
        }
        for (File deleteRecursively : listFiles) {
            if (!deleteRecursively(deleteRecursively)) {
                return false;
            }
        }
        return file.delete();
    }

    public static String readText(File file) throws IOException {
        if (file == null || !file.exists() || !file.isFile() || !file.canRead()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            }
            while (true) {
                String readLine2 = bufferedReader.readLine();
                if (readLine2 != null) {
                    sb.append("\n").append(readLine2);
                } else {
                    bufferedReader.close();
                    return sb.toString();
                }
            }
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static byte[] readBytesFromFile(String str, long j) throws IOException, SecurityException {
        ByteArrayOutputStream byteArrayOutputStream;
        File file = new File(str);
        if (!file.exists()) {
            throw new IOException(String.format("File '%s' doesn't exists", new Object[]{file.getName()}));
        } else if (!file.isFile()) {
            throw new IOException(String.format("Reading path %s failed, because it's not a file.", new Object[]{str}));
        } else if (!file.canRead()) {
            throw new IOException(String.format("Reading the item %s failed, because can't read the file.", new Object[]{str}));
        } else if (file.length() <= j) {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                            bufferedInputStream.close();
                            fileInputStream.close();
                            return byteArray;
                        }
                    }
                } catch (Throwable th) {
                    bufferedInputStream.close();
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } else {
            throw new IOException(String.format("Reading file failed, because size located at '%s' with %d bytes is bigger than the maximum allowed size of %d bytes.", new Object[]{str, Long.valueOf(file.length()), Long.valueOf(j)}));
        }
        throw th;
    }
}
