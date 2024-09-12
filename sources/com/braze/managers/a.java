package com.braze.managers;

import android.content.Context;
import bo.app.j;
import bo.app.k2;
import bo.app.n;
import bo.app.x1;
import bo.app.z1;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.LocationProviderName;
import com.braze.models.IBrazeLocation;
import com.braze.support.BrazeLogger;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.EnumSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

public final class a implements k2 {
    public static final b d = new b((DefaultConstructorMarker) null);
    private final z1 a;
    private final BrazeConfigurationProvider b;
    private n c;

    /* renamed from: com.braze.managers.a$a  reason: collision with other inner class name */
    static final class C0030a extends Lambda implements Function0 {
        public static final C0030a b = new C0030a();

        C0030a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "***Location API not found. Please include android-sdk-location module***";
        }
    }

    public static final class b {

        /* renamed from: com.braze.managers.a$b$a  reason: collision with other inner class name */
        static final class C0031a extends Lambda implements Function0 {
            final /* synthetic */ Ref.ObjectRef b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0031a(Ref.ObjectRef objectRef) {
                super(0);
                this.b = objectRef;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Using location providers: " + this.b.element;
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EnumSet a(BrazeConfigurationProvider brazeConfigurationProvider) {
            Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "appConfigurationProvider");
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = EnumSet.of(LocationProviderName.PASSIVE, LocationProviderName.NETWORK);
            if (!brazeConfigurationProvider.getCustomLocationProviderNames().isEmpty()) {
                objectRef.element = brazeConfigurationProvider.getCustomLocationProviderNames();
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new C0031a(objectRef), 2, (Object) null);
            }
            T t = objectRef.element;
            Intrinsics.checkNotNullExpressionValue(t, "allowedLocationProviders");
            return (EnumSet) t;
        }

        private b() {
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ IBrazeLocation b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(IBrazeLocation iBrazeLocation) {
            super(0);
            this.b = iBrazeLocation;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invoked manualSetUserLocation for " + this.b;
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log location recorded event.";
        }
    }

    static final class e extends Lambda implements Function1 {
        final /* synthetic */ a b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(a aVar) {
            super(1);
            this.b = aVar;
        }

        public final void a(IBrazeLocation iBrazeLocation) {
            Intrinsics.checkNotNullParameter(iBrazeLocation, "it");
            this.b.a(iBrazeLocation);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((IBrazeLocation) obj);
            return Unit.INSTANCE;
        }
    }

    public a(Context context, z1 z1Var, BrazeConfigurationProvider brazeConfigurationProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "appConfigurationProvider");
        this.a = z1Var;
        this.b = brazeConfigurationProvider;
        n nVar = new n(context, d.a(brazeConfigurationProvider), brazeConfigurationProvider);
        this.c = nVar;
        if (!nVar.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) C0030a.b, 2, (Object) null);
        }
    }

    public boolean a(IBrazeLocation iBrazeLocation) {
        Intrinsics.checkNotNullParameter(iBrazeLocation, FirebaseAnalytics.Param.LOCATION);
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new c(iBrazeLocation), 2, (Object) null);
            x1 a2 = j.h.a(iBrazeLocation);
            if (a2 != null) {
                this.a.a(a2);
            }
            return true;
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) d.b);
            return false;
        }
    }

    public boolean a() {
        return this.c.a(new e(this));
    }
}
