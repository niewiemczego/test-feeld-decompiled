package zendesk.storage.android.internal;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/content/SharedPreferences$Editor;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BasicStorage.kt */
final class BasicStorage$remove$1 extends Lambda implements Function1<SharedPreferences.Editor, Unit> {
    final /* synthetic */ String $key;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicStorage$remove$1(String str) {
        super(1);
        this.$key = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SharedPreferences.Editor) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SharedPreferences.Editor editor) {
        Intrinsics.checkNotNullParameter(editor, "$this$edit");
        editor.remove(this.$key);
    }
}
