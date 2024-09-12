package zendesk.storage.android.internal;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.logger.Logger;
import zendesk.storage.android.Storage;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J+\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J3\u0010\u0014\u001a\u00020\f\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u0001H\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011H\u0016¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lzendesk/storage/android/internal/BasicStorage;", "Lzendesk/storage/android/Storage;", "namespace", "", "context", "Landroid/content/Context;", "(Ljava/lang/String;Landroid/content/Context;)V", "getNamespace", "()Ljava/lang/String;", "sharedPreferences", "Landroid/content/SharedPreferences;", "clear", "", "get", "T", "key", "type", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "remove", "set", "value", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Class;)V", "Companion", "zendesk.storage_storage-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BasicStorage.kt */
public final class BasicStorage implements Storage {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "SimpleStorage";
    private final String namespace;
    private final SharedPreferences sharedPreferences;

    public BasicStorage(String str, Context context) {
        Intrinsics.checkNotNullParameter(str, "namespace");
        Intrinsics.checkNotNullParameter(context, "context");
        this.namespace = str;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(getNamespace(), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "context.getSharedPrefere…ce, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences2;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public <T> T get(String str, Class<T> cls) {
        T valueOf;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cls, "type");
        if (!this.sharedPreferences.contains(str)) {
            Logger.w(LOG_TAG, "There is no stored data for the given key", new Object[0]);
            return null;
        }
        try {
            if (Intrinsics.areEqual((Object) cls, (Object) String.class)) {
                valueOf = this.sharedPreferences.getString(str, (String) null);
            } else if (Intrinsics.areEqual((Object) cls, (Object) Integer.TYPE)) {
                valueOf = Integer.valueOf(this.sharedPreferences.getInt(str, 0));
            } else if (Intrinsics.areEqual((Object) cls, (Object) Boolean.TYPE)) {
                valueOf = Boolean.valueOf(this.sharedPreferences.getBoolean(str, false));
            } else if (Intrinsics.areEqual((Object) cls, (Object) Float.TYPE)) {
                valueOf = Float.valueOf(this.sharedPreferences.getFloat(str, 0.0f));
            } else if (!Intrinsics.areEqual((Object) cls, (Object) Long.TYPE)) {
                return null;
            } else {
                valueOf = Long.valueOf(this.sharedPreferences.getLong(str, 0));
            }
            return valueOf;
        } catch (ClassCastException e) {
            Logger.e(LOG_TAG, "The stored data did not match the requested type", e, new Object[0]);
            return null;
        }
    }

    public <T> void set(String str, T t, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cls, "type");
        BasicStorageKt.edit(this.sharedPreferences, new BasicStorage$set$1(t, str));
    }

    public void remove(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        BasicStorageKt.edit(this.sharedPreferences, new BasicStorage$remove$1(str));
    }

    public void clear() {
        BasicStorageKt.edit(this.sharedPreferences, BasicStorage$clear$1.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/storage/android/internal/BasicStorage$Companion;", "", "()V", "LOG_TAG", "", "zendesk.storage_storage-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BasicStorage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
