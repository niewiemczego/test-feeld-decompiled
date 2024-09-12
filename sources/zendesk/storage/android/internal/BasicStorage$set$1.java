package zendesk.storage.android.internal;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Landroid/content/SharedPreferences$Editor;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BasicStorage.kt */
final class BasicStorage$set$1 extends Lambda implements Function1<SharedPreferences.Editor, Unit> {
    final /* synthetic */ String $key;
    final /* synthetic */ T $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicStorage$set$1(T t, String str) {
        super(1);
        this.$value = t;
        this.$key = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SharedPreferences.Editor) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SharedPreferences.Editor editor) {
        Intrinsics.checkNotNullParameter(editor, "$this$edit");
        T t = this.$value;
        if (t == null) {
            editor.remove(this.$key);
        } else if (t instanceof String) {
            editor.putString(this.$key, (String) t);
        } else if (t instanceof Integer) {
            editor.putInt(this.$key, ((Number) t).intValue());
        } else if (t instanceof Boolean) {
            editor.putBoolean(this.$key, ((Boolean) t).booleanValue());
        } else if (t instanceof Float) {
            editor.putFloat(this.$key, ((Number) t).floatValue());
        } else if (t instanceof Long) {
            editor.putLong(this.$key, ((Number) t).longValue());
        } else {
            Logger.e("SimpleStorage", "Unable to store the value provided as it is not a supported type", new Object[0]);
        }
    }
}
