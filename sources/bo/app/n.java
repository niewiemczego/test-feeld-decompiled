package bo.app;

import android.content.Context;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.location.IBrazeLocationApi;
import java.util.EnumSet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public final class n {
    private IBrazeLocationApi a;

    public n(Context context, EnumSet enumSet, BrazeConfigurationProvider brazeConfigurationProvider) {
        IBrazeLocationApi iBrazeLocationApi;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(enumSet, "allowedProviders");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "appConfigurationProvider");
        try {
            Object newInstance = Class.forName("com.braze.location.BrazeInternalLocationApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.braze.location.IBrazeLocationApi");
            iBrazeLocationApi = (IBrazeLocationApi) newInstance;
        } catch (Exception unused) {
            iBrazeLocationApi = null;
        }
        this.a = iBrazeLocationApi;
        if (iBrazeLocationApi != null) {
            iBrazeLocationApi.initWithContext(context, enumSet, brazeConfigurationProvider);
        }
    }

    public final boolean a() {
        return this.a != null;
    }

    public final boolean a(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "manualLocationUpdateCallback");
        IBrazeLocationApi iBrazeLocationApi = this.a;
        if (iBrazeLocationApi != null) {
            return iBrazeLocationApi.requestSingleLocationUpdate(function1);
        }
        return false;
    }
}
