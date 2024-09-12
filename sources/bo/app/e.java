package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.coroutine.BrazeCoroutineScope;
import java.util.Map;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

public final class e implements SharedPreferences {
    /* access modifiers changed from: private */
    public final Context a;
    /* access modifiers changed from: private */
    public final String b;
    private SharedPreferences c;
    /* access modifiers changed from: private */
    public final Job d = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new a(this, (Continuation) null), 3, (Object) null);

    static final class a extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ e c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(e eVar, Continuation continuation) {
            super(2, continuation);
            this.c = eVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new a(this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                this.c.a.getSharedPreferences(this.c.b, 0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class b extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ e c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e eVar, Continuation continuation) {
            super(2, continuation);
            this.c = eVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new b(this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Job c2 = this.c.d;
                this.b = 1;
                if (c2.join(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public e(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        this.a = context;
        this.b = str;
    }

    public boolean contains(String str) {
        a();
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.contains(str);
    }

    public SharedPreferences.Editor edit() {
        a();
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "prefs.edit()");
        return edit;
    }

    public Map getAll() {
        a();
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        Map<String, ?> all = sharedPreferences.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "prefs.all");
        return all;
    }

    public boolean getBoolean(String str, boolean z) {
        a();
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getBoolean(str, z);
    }

    public float getFloat(String str, float f) {
        a();
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getFloat(str, f);
    }

    public int getInt(String str, int i) {
        a();
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getInt(str, i);
    }

    public long getLong(String str, long j) {
        a();
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getLong(str, j);
    }

    public String getString(String str, String str2) {
        a();
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getString(str, str2);
    }

    public Set getStringSet(String str, Set set) {
        a();
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getStringSet(str, set);
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        a();
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        a();
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    private final void a() {
        if (!this.d.isCompleted()) {
            Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new b(this, (Continuation) null), 1, (Object) null);
        }
        SharedPreferences sharedPreferences = this.a.getSharedPreferences(this.b, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
        this.c = sharedPreferences;
    }
}
