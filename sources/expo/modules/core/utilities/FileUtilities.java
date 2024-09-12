package expo.modules.core.utilities;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtilities {
    public static File ensureDirExists(File file) throws IOException {
        if (file.isDirectory() || file.mkdirs()) {
            return file;
        }
        throw new IOException("Couldn't create directory '" + file + "'");
    }

    public static String generateOutputPath(File file, String str, String str2) throws IOException {
        File file2 = new File(file + File.separator + str);
        ensureDirExists(file2);
        StringBuilder append = new StringBuilder().append(file2).append(File.separator).append(UUID.randomUUID().toString());
        if (!str2.startsWith(".")) {
            str2 = "." + str2;
        }
        return append.append(str2).toString();
    }
}
