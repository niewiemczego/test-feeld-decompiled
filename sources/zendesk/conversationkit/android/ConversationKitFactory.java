package zendesk.conversationkit.android;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.Config;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J+\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitFactory;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "create", "Lzendesk/conversationkit/android/ConversationKitResult;", "Lzendesk/conversationkit/android/ConversationKit;", "settings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "config", "Lzendesk/conversationkit/android/model/Config;", "(Lzendesk/conversationkit/android/ConversationKitSettings;Lzendesk/conversationkit/android/model/Config;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationKitFactory.kt */
public final class ConversationKitFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Context context;

    public /* synthetic */ ConversationKitFactory(Context context2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2);
    }

    @JvmStatic
    public static final ConversationKitFactory from(Context context2) {
        return Companion.from(context2);
    }

    public final Object create(ConversationKitSettings conversationKitSettings, Continuation<? super ConversationKitResult<? extends ConversationKit>> continuation) {
        return create$default(this, conversationKitSettings, (Config) null, continuation, 2, (Object) null);
    }

    private ConversationKitFactory(Context context2) {
        this.context = context2;
    }

    public static /* synthetic */ Object create$default(ConversationKitFactory conversationKitFactory, ConversationKitSettings conversationKitSettings, Config config, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            config = null;
        }
        return conversationKitFactory.create(conversationKitSettings, config, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object create(zendesk.conversationkit.android.ConversationKitSettings r6, zendesk.conversationkit.android.model.Config r7, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.ConversationKitResult<? extends zendesk.conversationkit.android.ConversationKit>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof zendesk.conversationkit.android.ConversationKitFactory$create$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            zendesk.conversationkit.android.ConversationKitFactory$create$1 r0 = (zendesk.conversationkit.android.ConversationKitFactory$create$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.ConversationKitFactory$create$1 r0 = new zendesk.conversationkit.android.ConversationKitFactory$create$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r6 = r0.L$0
            zendesk.conversationkit.android.DefaultConversationKit r6 = (zendesk.conversationkit.android.DefaultConversationKit) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004e
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
            zendesk.conversationkit.android.DefaultConversationKit r8 = new zendesk.conversationkit.android.DefaultConversationKit
            android.content.Context r2 = r5.context
            r8.<init>(r2)
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r6 = r8.setup$zendesk_conversationkit_conversationkit_android(r6, r7, r0)
            if (r6 != r1) goto L_0x004b
            return r1
        L_0x004b:
            r4 = r8
            r8 = r6
            r6 = r4
        L_0x004e:
            zendesk.conversationkit.android.ConversationKitResult r8 = (zendesk.conversationkit.android.ConversationKitResult) r8
            boolean r7 = r8 instanceof zendesk.conversationkit.android.ConversationKitResult.Success
            if (r7 == 0) goto L_0x005c
            zendesk.conversationkit.android.ConversationKitResult$Success r7 = new zendesk.conversationkit.android.ConversationKitResult$Success
            r7.<init>(r6)
            zendesk.conversationkit.android.ConversationKitResult r7 = (zendesk.conversationkit.android.ConversationKitResult) r7
            goto L_0x0068
        L_0x005c:
            zendesk.conversationkit.android.ConversationKitResult$Failure r6 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            zendesk.conversationkit.android.ConversationKitError$FailedToInitialize r7 = zendesk.conversationkit.android.ConversationKitError.FailedToInitialize.INSTANCE
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r6.<init>(r7)
            r7 = r6
            zendesk.conversationkit.android.ConversationKitResult r7 = (zendesk.conversationkit.android.ConversationKitResult) r7
        L_0x0068:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.ConversationKitFactory.create(zendesk.conversationkit.android.ConversationKitSettings, zendesk.conversationkit.android.model.Config, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitFactory$Companion;", "", "()V", "from", "Lzendesk/conversationkit/android/ConversationKitFactory;", "context", "Landroid/content/Context;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ConversationKitFactory from(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new ConversationKitFactory(context, (DefaultConstructorMarker) null);
        }
    }
}
