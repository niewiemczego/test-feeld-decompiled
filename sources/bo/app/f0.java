package bo.app;

import android.content.Context;
import com.braze.configuration.BrazeConfigurationProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class f0 extends BrazeConfigurationProvider {
    public static final a a = new a((DefaultConstructorMarker) null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f0(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final long a() {
        return ((long) getIntValue(BrazeConfigurationProvider.b.DATA_SYNC_BAD_NETWORK_INTERVAL_KEY.b(), 60)) * 1000;
    }

    public final long b() {
        return ((long) getIntValue(BrazeConfigurationProvider.b.DATA_SYNC_GOOD_NETWORK_INTERVAL_KEY.b(), 30)) * 1000;
    }

    public final long c() {
        return ((long) getIntValue(BrazeConfigurationProvider.b.DATA_SYNC_GREAT_NETWORK_INTERVAL_KEY.b(), 10)) * 1000;
    }
}
