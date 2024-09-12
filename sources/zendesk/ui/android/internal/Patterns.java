package zendesk.ui.android.internal;

import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u00020\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lzendesk/ui/android/internal/Patterns;", "", "()V", "EMAIL_REGEX", "Lkotlin/text/Regex;", "getEMAIL_REGEX$annotations", "getEMAIL_REGEX", "()Lkotlin/text/Regex;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Patterns.kt */
public final class Patterns {
    private static final Regex EMAIL_REGEX = new Regex("((\"[^\"\\f\\n\\r\\t\\cK\b]+\")|([.\\w=!#$%&'*+\\-~/^`|{}]+))@((\\[(((25[0-5])|(2[0-4][0-9])|([0-1]?[0-9]?[0-9]))\\.((25[0-5])|(2[0-4][0-9])|([0-1]?[0-9]?[0-9]))\\.((25[0-5])|(2[0-4][0-9])|([0-1]?[0-9]?[0-9]))\\.((25[0-5])|(2[0-4][0-9])|([0-1]?[0-9]?[0-9])))])|(((25[0-5])|(2[0-4][0-9])|([0-1]?[0-9]?[0-9]))\\.((25[0-5])|(2[0-4][0-9])|([0-1]?[0-9]?[0-9]))\\.((25[0-5])|(2[0-4][0-9])|([0-1]?[0-9]?[0-9]))\\.((25[0-5])|(2[0-4][0-9])|([0-1]?[0-9]?[0-9])))|((([A-Za-z0-9\\-])+\\.)+[A-Za-z\\-]+))");
    public static final Patterns INSTANCE = new Patterns();

    public static /* synthetic */ void getEMAIL_REGEX$annotations() {
    }

    private Patterns() {
    }

    public final Regex getEMAIL_REGEX() {
        return EMAIL_REGEX;
    }
}
