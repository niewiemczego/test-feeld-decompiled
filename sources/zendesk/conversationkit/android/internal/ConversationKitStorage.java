package zendesk.conversationkit.android.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import zendesk.conversationkit.android.model.VisitType;
import zendesk.storage.android.PersistedProperty;
import zendesk.storage.android.Storage;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0015\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0012\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u001b\u0010\r\u001a\u00020\u00182\b\u0010\n\u001a\u0004\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0019\u0010\u0013\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R/\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00068B@BX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R/\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00068B@BX\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lzendesk/conversationkit/android/internal/ConversationKitStorage;", "", "storage", "Lzendesk/storage/android/Storage;", "(Lzendesk/storage/android/Storage;)V", "clientId", "", "persistenceDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "<set-?>", "pushToken", "getPushToken", "()Ljava/lang/String;", "setPushToken", "(Ljava/lang/String;)V", "pushToken$delegate", "Lzendesk/storage/android/PersistedProperty;", "visitType", "getVisitType", "setVisitType", "visitType$delegate", "getClientId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lzendesk/conversationkit/android/model/VisitType;", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lzendesk/conversationkit/android/model/VisitType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationKitStorage.kt */
public final class ConversationKitStorage {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_CLIENT_ID = "CLIENT_ID";
    private static final String KEY_PUSH_TOKEN = "PUSH_TOKEN";
    private static final String KEY_VISIT_TYPE = "VISIT_TYPE";
    private String clientId;
    private final ExecutorCoroutineDispatcher persistenceDispatcher;
    private final PersistedProperty pushToken$delegate;
    /* access modifiers changed from: private */
    public final Storage storage;
    private final PersistedProperty visitType$delegate;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ConversationKitStorage(zendesk.storage.android.Storage r4) {
        /*
            r3 = this;
            java.lang.String r0 = "storage"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r3.<init>()
            r3.storage = r4
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newSingleThreadExecutor()
            java.lang.String r1 = "newSingleThreadExecutor()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            kotlinx.coroutines.ExecutorCoroutineDispatcher r0 = kotlinx.coroutines.ExecutorsKt.from((java.util.concurrent.ExecutorService) r0)
            r3.persistenceDispatcher = r0
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r0 = r0.getName()
            java.lang.String r1 = "CLIENT_ID"
            if (r0 == 0) goto L_0x0072
            int r2 = r0.hashCode()
            switch(r2) {
                case -2056817302: goto L_0x0061;
                case -527879800: goto L_0x004f;
                case 344809556: goto L_0x003d;
                case 398795216: goto L_0x002b;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x0072
        L_0x002b:
            java.lang.String r2 = "java.lang.Long"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0034
            goto L_0x0072
        L_0x0034:
            java.lang.Class r0 = java.lang.Long.TYPE
            java.lang.Object r0 = r4.get(r1, r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0078
        L_0x003d:
            java.lang.String r2 = "java.lang.Boolean"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0046
            goto L_0x0072
        L_0x0046:
            java.lang.Class r0 = java.lang.Boolean.TYPE
            java.lang.Object r0 = r4.get(r1, r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0078
        L_0x004f:
            java.lang.String r2 = "java.lang.Float"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0058
            goto L_0x0072
        L_0x0058:
            java.lang.Class r0 = java.lang.Float.TYPE
            java.lang.Object r0 = r4.get(r1, r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0078
        L_0x0061:
            java.lang.String r2 = "java.lang.Integer"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0072
            java.lang.Class r0 = java.lang.Integer.TYPE
            java.lang.Object r0 = r4.get(r1, r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0078
        L_0x0072:
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.Object r0 = r4.get(r1, r0)
        L_0x0078:
            java.lang.String r0 = (java.lang.String) r0
            r3.clientId = r0
            zendesk.storage.android.PersistedProperty r0 = new zendesk.storage.android.PersistedProperty
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            java.lang.String r2 = "PUSH_TOKEN"
            r0.<init>(r4, r2, r1)
            r3.pushToken$delegate = r0
            zendesk.storage.android.PersistedProperty r0 = new zendesk.storage.android.PersistedProperty
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            java.lang.String r2 = "VISIT_TYPE"
            r0.<init>(r4, r2, r1)
            r3.visitType$delegate = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.ConversationKitStorage.<init>(zendesk.storage.android.Storage):void");
    }

    static {
        Class<ConversationKitStorage> cls = ConversationKitStorage.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "pushToken", "getPushToken()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "visitType", "getVisitType()Ljava/lang/String;", 0))};
    }

    /* access modifiers changed from: private */
    public final String getPushToken() {
        return (String) this.pushToken$delegate.getValue(this, $$delegatedProperties[0]);
    }

    /* access modifiers changed from: private */
    public final void setPushToken(String str) {
        this.pushToken$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    private final String getVisitType() {
        return (String) this.visitType$delegate.getValue(this, $$delegatedProperties[1]);
    }

    /* access modifiers changed from: private */
    public final void setVisitType(String str) {
        this.visitType$delegate.setValue(this, $$delegatedProperties[1], str);
    }

    public final Object getPushToken(Continuation<? super String> continuation) {
        return BuildersKt.withContext(this.persistenceDispatcher, new ConversationKitStorage$getPushToken$2(this, (Continuation<? super ConversationKitStorage$getPushToken$2>) null), continuation);
    }

    public final Object setPushToken(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.persistenceDispatcher, new ConversationKitStorage$setPushToken$2(this, str, (Continuation<? super ConversationKitStorage$setPushToken$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getClientId(kotlin.coroutines.Continuation<? super java.lang.String> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof zendesk.conversationkit.android.internal.ConversationKitStorage$getClientId$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            zendesk.conversationkit.android.internal.ConversationKitStorage$getClientId$1 r0 = (zendesk.conversationkit.android.internal.ConversationKitStorage$getClientId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.ConversationKitStorage$getClientId$1 r0 = new zendesk.conversationkit.android.internal.ConversationKitStorage$getClientId$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0065
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r7 = r6.clientId
            if (r7 == 0) goto L_0x003e
            return r7
        L_0x003e:
            java.util.UUID r7 = java.util.UUID.randomUUID()
            java.lang.String r7 = r7.toString()
            java.lang.String r2 = "randomUUID().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)
            r6.clientId = r7
            kotlinx.coroutines.ExecutorCoroutineDispatcher r2 = r6.persistenceDispatcher
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            zendesk.conversationkit.android.internal.ConversationKitStorage$getClientId$3 r4 = new zendesk.conversationkit.android.internal.ConversationKitStorage$getClientId$3
            r5 = 0
            r4.<init>(r6, r7, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            if (r0 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r0 = r7
        L_0x0065:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.ConversationKitStorage.getClientId(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getVisitType(kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.model.VisitType> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof zendesk.conversationkit.android.internal.ConversationKitStorage$getVisitType$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            zendesk.conversationkit.android.internal.ConversationKitStorage$getVisitType$1 r0 = (zendesk.conversationkit.android.internal.ConversationKitStorage$getVisitType$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.ConversationKitStorage$getVisitType$1 r0 = new zendesk.conversationkit.android.internal.ConversationKitStorage$getVisitType$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            zendesk.conversationkit.android.model.VisitType r0 = (zendesk.conversationkit.android.model.VisitType) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0065
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r7 = r6.getVisitType()
            if (r7 == 0) goto L_0x0044
            zendesk.conversationkit.android.model.VisitType r7 = zendesk.conversationkit.android.model.VisitType.valueOf(r7)
            return r7
        L_0x0044:
            zendesk.conversationkit.android.model.VisitType r7 = zendesk.conversationkit.android.model.VisitType.NEW
            java.lang.String r2 = r7.name()
            r6.setVisitType(r2)
            kotlinx.coroutines.ExecutorCoroutineDispatcher r2 = r6.persistenceDispatcher
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            zendesk.conversationkit.android.internal.ConversationKitStorage$getVisitType$3 r4 = new zendesk.conversationkit.android.internal.ConversationKitStorage$getVisitType$3
            r5 = 0
            r4.<init>(r6, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            if (r0 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r0 = r7
        L_0x0065:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.ConversationKitStorage.getVisitType(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object setVisitType(VisitType visitType, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.persistenceDispatcher, new ConversationKitStorage$setVisitType$2(this, visitType, (Continuation<? super ConversationKitStorage$setVisitType$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lzendesk/conversationkit/android/internal/ConversationKitStorage$Companion;", "", "()V", "KEY_CLIENT_ID", "", "KEY_PUSH_TOKEN", "KEY_VISIT_TYPE", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitStorage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
