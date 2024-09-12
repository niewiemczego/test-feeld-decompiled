package expo.modules.filesystem;

import android.content.Context;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.interfaces.filesystem.AppDirectoriesModuleInterface;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\rH\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u000f"}, d2 = {"Lexpo/modules/filesystem/AppDirectoriesModule;", "Lexpo/modules/interfaces/filesystem/AppDirectoriesModuleInterface;", "Lexpo/modules/core/interfaces/InternalModule;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cacheDirectory", "Ljava/io/File;", "getCacheDirectory", "()Ljava/io/File;", "persistentFilesDirectory", "getPersistentFilesDirectory", "getExportedInterfaces", "", "Ljava/lang/Class;", "expo-file-system_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AppDirectoriesModule.kt */
public class AppDirectoriesModule implements AppDirectoriesModuleInterface, InternalModule {
    private final Context context;

    public AppDirectoriesModule(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public List<Class<?>> getExportedInterfaces() {
        return CollectionsKt.listOf(AppDirectoriesModuleInterface.class);
    }

    public File getCacheDirectory() {
        File cacheDir = this.context.getCacheDir();
        Intrinsics.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
        return cacheDir;
    }

    public File getPersistentFilesDirectory() {
        File filesDir = this.context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "context.filesDir");
        return filesDir;
    }
}
