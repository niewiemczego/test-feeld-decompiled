package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import io.sentry.protocol.Request;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/fragment/app/strictmode/Violation;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "fragment", "Landroidx/fragment/app/Fragment;", "violationMessage", "", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "fragment_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Violation.kt */
public abstract class Violation extends RuntimeException {
    private final Fragment fragment;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Violation(Fragment fragment2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment2, (i & 2) != 0 ? null : str);
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Violation(Fragment fragment2, String str) {
        super(str);
        Intrinsics.checkNotNullParameter(fragment2, Request.JsonKeys.FRAGMENT);
        this.fragment = fragment2;
    }
}
