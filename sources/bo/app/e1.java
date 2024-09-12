package bo.app;

import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.braze.events.IFireOnceEventSubscriber;
import com.braze.events.NoMatchingTriggerEvent;
import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

public final class e1 implements i2 {
    public static final a h = new a((DefaultConstructorMarker) null);
    private final g5 a;
    private final ConcurrentMap b = new ConcurrentHashMap();
    private final ConcurrentMap c = new ConcurrentHashMap();
    private final ConcurrentMap d = new ConcurrentHashMap();
    private final ReentrantLock e = new ReentrantLock();
    private final ReentrantLock f = new ReentrantLock();
    private final ReentrantLock g = new ReentrantLock();

    public static final class a {

        /* renamed from: bo.app.e1$a$a  reason: collision with other inner class name */
        static final class C0006a extends Lambda implements Function0 {
            final /* synthetic */ Class b;
            final /* synthetic */ Set c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0006a(Class cls, Set set) {
                super(0);
                this.b = cls;
                this.c = set;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Triggering " + this.b.getName() + " on " + this.c.size() + " subscribers.";
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }

        /* access modifiers changed from: private */
        public final Set a(Class cls, Set set) {
            Intrinsics.checkNotNull(set, "null cannot be cast to non-null type kotlin.collections.Set<com.braze.events.IEventSubscriber<T of com.braze.events.EventMessenger.Companion.getCastSubscriberSet>>");
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new C0006a(cls, set), 3, (Object) null);
            return set;
        }

        /* access modifiers changed from: private */
        public final Set a(ConcurrentMap concurrentMap, Class cls, ReentrantLock reentrantLock) {
            reentrantLock.lock();
            try {
                CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) concurrentMap.get(cls);
                if (copyOnWriteArraySet == null) {
                    return new HashSet();
                }
                HashSet hashSet = new HashSet(copyOnWriteArraySet);
                ArrayList arrayList = new ArrayList();
                for (Object next : copyOnWriteArraySet) {
                    if (next instanceof IFireOnceEventSubscriber) {
                        arrayList.add(next);
                    }
                }
                copyOnWriteArraySet.removeAll(CollectionsKt.toSet(arrayList));
                concurrentMap.put(cls, copyOnWriteArraySet);
                reentrantLock.unlock();
                return hashSet;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ Class b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Class cls) {
            super(0);
            this.b = cls;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Publishing cached event for class: " + this.b;
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ Class b;
        final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Class cls, Object obj) {
            super(0);
            this.b = cls;
            this.c = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "SDK is disabled. Not publishing event class: " + this.b.getName() + " and message: " + this.c;
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ Class b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Class cls) {
            super(0);
            this.b = cls;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not publishing null message to event class " + this.b.getName();
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ Class b;
        final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Class cls, Object obj) {
            super(0);
            this.b = cls;
            this.c = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return this.b.getName() + " fired:\n" + this.c;
        }
    }

    static final class f extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ IEventSubscriber c;
        final /* synthetic */ Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(IEventSubscriber iEventSubscriber, Object obj, Continuation continuation) {
            super(2, continuation);
            this.c = iEventSubscriber;
            this.d = obj;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new f(this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                this.c.trigger(this.d);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ Class b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(Class cls) {
            super(0);
            this.b = cls;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Event was published, but no subscribers were found. But not saving event for publishing later. Event class: " + this.b;
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ Class b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(Class cls) {
            super(0);
            this.b = cls;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Event was published, but no subscribers were found. Saving event for later publishing to a matching subscriber. Event class: " + this.b;
        }
    }

    public e1(g5 g5Var) {
        Intrinsics.checkNotNullParameter(g5Var, "sdkEnablementProvider");
        this.a = g5Var;
    }

    public void a(Class cls, IEventSubscriber iEventSubscriber) {
        Intrinsics.checkNotNullParameter(cls, "eventClass");
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            a(iEventSubscriber, cls, this.b);
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean b(Class cls, IEventSubscriber iEventSubscriber) {
        Intrinsics.checkNotNullParameter(cls, "eventClass");
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) this.c.get(cls);
            if (copyOnWriteArraySet != null) {
                return copyOnWriteArraySet.remove(iEventSubscriber);
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean c(Class cls, IEventSubscriber iEventSubscriber) {
        Intrinsics.checkNotNullParameter(cls, "eventClass");
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            return a(iEventSubscriber, cls, this.c);
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean d(Class cls, IEventSubscriber iEventSubscriber) {
        Intrinsics.checkNotNullParameter(cls, "eventClass");
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) this.b.get(cls);
            if (copyOnWriteArraySet != null) {
                return copyOnWriteArraySet.remove(iEventSubscriber);
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void b() {
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            this.d.remove(ContentCardsUpdatedEvent.class);
        } finally {
            reentrantLock.unlock();
        }
    }

    public void a(Object obj, Class cls) {
        Object obj2 = obj;
        Class cls2 = cls;
        Intrinsics.checkNotNullParameter(cls2, "eventClass");
        if (this.a.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new c(cls2, obj2), 3, (Object) null);
        } else if (obj2 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new d(cls2), 3, (Object) null);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new e(cls2, obj2), 3, (Object) null);
            a aVar = h;
            Set a2 = aVar.a(this.b, cls2, this.e);
            for (IEventSubscriber fVar : aVar.a(cls2, a2)) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new f(fVar, obj2, (Continuation) null), 3, (Object) null);
            }
            a aVar2 = h;
            Set a3 = aVar2.a(this.c, cls2, this.f);
            for (IEventSubscriber trigger : aVar2.a(cls2, a3)) {
                trigger.trigger(obj2);
            }
            if (a3.isEmpty() && a2.isEmpty()) {
                if (Intrinsics.areEqual((Object) cls2, (Object) NoMatchingTriggerEvent.class)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new g(cls2), 2, (Object) null);
                    return;
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new h(cls2), 2, (Object) null);
                ReentrantLock reentrantLock = this.g;
                reentrantLock.lock();
                try {
                    this.d.put(cls2, obj2);
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void a() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            this.b.clear();
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            ReentrantLock reentrantLock2 = this.f;
            reentrantLock2.lock();
            try {
                this.c.clear();
                Unit unit2 = Unit.INSTANCE;
            } finally {
                reentrantLock2.unlock();
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    private final boolean a(IEventSubscriber iEventSubscriber, Class cls, ConcurrentMap concurrentMap) {
        CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) concurrentMap.get(cls);
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet();
            CopyOnWriteArraySet copyOnWriteArraySet2 = (CopyOnWriteArraySet) concurrentMap.putIfAbsent(cls, copyOnWriteArraySet);
            if (copyOnWriteArraySet2 != null) {
                copyOnWriteArraySet = copyOnWriteArraySet2;
            }
        }
        boolean add = copyOnWriteArraySet.add(iEventSubscriber);
        a(cls);
        return add;
    }

    private final void a(Class cls) {
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            if (this.d.containsKey(cls)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new b(cls), 2, (Object) null);
                Object remove = this.d.remove(cls);
                if (remove != null) {
                    a(remove, cls);
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }
}
