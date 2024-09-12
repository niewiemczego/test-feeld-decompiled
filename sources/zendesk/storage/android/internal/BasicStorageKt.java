package zendesk.storage.android.internal;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0002¨\u0006\u0007"}, d2 = {"edit", "", "Landroid/content/SharedPreferences;", "block", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/ExtensionFunctionType;", "zendesk.storage_storage-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BasicStorage.kt */
public final class BasicStorageKt {
    /* access modifiers changed from: private */
    public static final void edit(SharedPreferences sharedPreferences, Function1<? super SharedPreferences.Editor, Unit> function1) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        function1.invoke(edit);
        edit.apply();
    }
}
