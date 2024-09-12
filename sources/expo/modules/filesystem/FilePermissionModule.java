package expo.modules.filesystem;

import android.content.Context;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.interfaces.filesystem.FilePermissionModuleInterface;
import expo.modules.interfaces.filesystem.Permission;
import java.io.File;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0014J \u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u0011"}, d2 = {"Lexpo/modules/filesystem/FilePermissionModule;", "Lexpo/modules/interfaces/filesystem/FilePermissionModuleInterface;", "Lexpo/modules/core/interfaces/InternalModule;", "()V", "getExportedInterfaces", "", "Ljava/lang/Class;", "getExternalPathPermissions", "Ljava/util/EnumSet;", "Lexpo/modules/interfaces/filesystem/Permission;", "path", "", "getInternalPathPermissions", "context", "Landroid/content/Context;", "getInternalPaths", "getPathPermissions", "expo-file-system_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FilePermissionModule.kt */
public class FilePermissionModule implements FilePermissionModuleInterface, InternalModule {
    public List<Class<?>> getExportedInterfaces() {
        return CollectionsKt.listOf(FilePermissionModuleInterface.class);
    }

    public EnumSet<Permission> getPathPermissions(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        EnumSet<Permission> internalPathPermissions = getInternalPathPermissions(str, context);
        return internalPathPermissions == null ? getExternalPathPermissions(str) : internalPathPermissions;
    }

    private final EnumSet<Permission> getInternalPathPermissions(String str, Context context) {
        Object obj;
        try {
            String canonicalPath = new File(str).getCanonicalPath();
            Iterator it = getInternalPaths(context).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                String str2 = (String) obj;
                Intrinsics.checkNotNullExpressionValue(canonicalPath, "canonicalPath");
                boolean z = false;
                if (StringsKt.startsWith$default(canonicalPath, str2 + "/", false, 2, (Object) null) || Intrinsics.areEqual((Object) str2, (Object) canonicalPath)) {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            if (((String) obj) != null) {
                return EnumSet.of(Permission.READ, Permission.WRITE);
            }
            return null;
        } catch (IOException unused) {
            return EnumSet.noneOf(Permission.class);
        }
    }

    /* access modifiers changed from: protected */
    public EnumSet<Permission> getExternalPathPermissions(String str) {
        Intrinsics.checkNotNullParameter(str, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        File file = new File(str);
        EnumSet<Permission> noneOf = EnumSet.noneOf(Permission.class);
        if (file.canRead()) {
            noneOf.add(Permission.READ);
        }
        if (file.canWrite()) {
            noneOf.add(Permission.WRITE);
        }
        Intrinsics.checkNotNullExpressionValue(noneOf, "noneOf(Permission::class…sion.WRITE)\n      }\n    }");
        return noneOf;
    }

    private final List<String> getInternalPaths(Context context) throws IOException {
        return CollectionsKt.listOf(context.getFilesDir().getCanonicalPath(), context.getCacheDir().getCanonicalPath());
    }
}
