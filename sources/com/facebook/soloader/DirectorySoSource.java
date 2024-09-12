package com.facebook.soloader;

import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

public class DirectorySoSource extends SoSource {
    public static final int ON_LD_LIBRARY_PATH = 2;
    public static final int RESOLVE_DEPENDENCIES = 1;
    protected final List<String> denyList;
    protected final int flags;
    protected final File soDirectory;

    public DirectorySoSource(File file, int i) {
        this(file, i, new String[0]);
    }

    public DirectorySoSource(File file, int i, String[] strArr) {
        this.soDirectory = file;
        this.flags = i;
        this.denyList = Arrays.asList(strArr);
    }

    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
    }

    /* access modifiers changed from: protected */
    public int loadLibraryFrom(String str, int i, File file, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        if (SoLoader.sSoFileLoader != null) {
            boolean z = false;
            if (this.denyList.contains(str)) {
                Log.d("SoLoader", str + " is on the denyList, skip loading from " + file.getCanonicalPath());
                return 0;
            }
            File soFileByName = getSoFileByName(str);
            if (soFileByName == null) {
                Log.v("SoLoader", str + " not found on " + file.getCanonicalPath());
                return 0;
            }
            Log.d("SoLoader", str + " found on " + file.getCanonicalPath());
            if ((i & 1) == 0 || (this.flags & 2) == 0) {
                ElfByteChannel elfByteChannel = null;
                if ((this.flags & 1) != 0) {
                    z = true;
                }
                boolean equals = soFileByName.getName().equals(str);
                if (z || !equals) {
                    try {
                        elfByteChannel = getChannel(soFileByName);
                    } catch (UnsatisfiedLinkError e) {
                        if (e.getMessage().contains("bad ELF magic")) {
                            Log.d("SoLoader", "Corrupted lib file detected");
                            if (elfByteChannel != null) {
                                elfByteChannel.close();
                            }
                            return 3;
                        }
                        throw e;
                    } catch (Throwable th) {
                        if (elfByteChannel != null) {
                            elfByteChannel.close();
                        }
                        throw th;
                    }
                }
                if (z) {
                    loadDependencies(str, elfByteChannel, i, threadPolicy);
                } else {
                    Log.d("SoLoader", "Not resolving dependencies for " + str);
                }
                if (equals) {
                    SoLoader.sSoFileLoader.load(soFileByName.getAbsolutePath(), i);
                } else {
                    SoLoader.sSoFileLoader.loadBytes(soFileByName.getAbsolutePath(), elfByteChannel, i);
                }
                if (elfByteChannel != null) {
                    elfByteChannel.close();
                }
                return 1;
            }
            Log.d("SoLoader", str + " loaded implicitly");
            return 2;
        }
        throw new IllegalStateException("SoLoader.init() not yet called");
    }

    /* access modifiers changed from: protected */
    @Nullable
    public File getSoFileByName(String str) throws IOException {
        File file = new File(this.soDirectory, str);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    @Nullable
    public String getLibraryPath(String str) throws IOException {
        File soFileByName = getSoFileByName(str);
        if (soFileByName == null) {
            return null;
        }
        return soFileByName.getCanonicalPath();
    }

    @Nullable
    public String[] getLibraryDependencies(String str) throws IOException {
        File soFileByName = getSoFileByName(str);
        if (soFileByName == null) {
            return null;
        }
        ElfByteChannel channel = getChannel(soFileByName);
        try {
            String[] dependencies = getDependencies(str, channel);
            if (channel != null) {
                channel.close();
            }
            return dependencies;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private void loadDependencies(String str, ElfByteChannel elfByteChannel, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        String[] dependencies = getDependencies(str, elfByteChannel);
        Log.d("SoLoader", "Loading " + str + "'s dependencies: " + Arrays.toString(dependencies));
        for (String str2 : dependencies) {
            if (!str2.startsWith("/")) {
                SoLoader.loadLibraryBySoName(str2, i | 1, threadPolicy);
            }
        }
    }

    /* access modifiers changed from: protected */
    public ElfByteChannel getChannel(File file) throws IOException {
        return new ElfFileChannel(file);
    }

    /* access modifiers changed from: protected */
    public String[] getDependencies(String str, ElfByteChannel elfByteChannel) throws IOException {
        if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
            Api18TraceUtils.beginTraceSection("SoLoader.getElfDependencies[", str, "]");
        }
        try {
            return NativeDeps.getDependencies(str, elfByteChannel);
        } finally {
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.endSection();
            }
        }
    }

    @Nullable
    public File unpackLibrary(String str) throws IOException {
        return getSoFileByName(str);
    }

    public void addToLdLibraryPath(Collection<String> collection) {
        collection.add(this.soDirectory.getAbsolutePath());
    }

    public String toString() {
        String str;
        try {
            str = String.valueOf(this.soDirectory.getCanonicalPath());
        } catch (IOException unused) {
            str = this.soDirectory.getName();
        }
        return getClass().getName() + "[root = " + str + " flags = " + this.flags + ']';
    }
}
