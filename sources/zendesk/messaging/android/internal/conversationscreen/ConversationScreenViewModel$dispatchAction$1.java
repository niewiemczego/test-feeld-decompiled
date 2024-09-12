package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$dispatchAction$1", f = "ConversationScreenViewModel.kt", i = {4, 7}, l = {333, 338, 342, 350, 378, 388, 394, 417, 421, 425}, m = "invokeSuspend", n = {"conversationId", "initialText"}, s = {"L$0", "L$0"})
/* compiled from: ConversationScreenViewModel.kt */
final class ConversationScreenViewModel$dispatchAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ConversationScreenAction $conversationScreenAction;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ConversationScreenViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenViewModel$dispatchAction$1(ConversationScreenAction conversationScreenAction, ConversationScreenViewModel conversationScreenViewModel, Continuation<? super ConversationScreenViewModel$dispatchAction$1> continuation) {
        super(2, continuation);
        this.$conversationScreenAction = conversationScreenAction;
        this.this$0 = conversationScreenViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationScreenViewModel$dispatchAction$1(this.$conversationScreenAction, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConversationScreenViewModel$dispatchAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0083, code lost:
        r0.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0092, code lost:
        if (r0.this$0.messagingStorage.clear(r0) != r1) goto L_0x02a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0094, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0178, code lost:
        if (r2.hasNext() == false) goto L_0x02a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x017a, code lost:
        r6 = (zendesk.messaging.android.internal.model.UploadFile) r2.next();
        r6 = zendesk.conversationkit.android.model.Message.Companion.create$default(zendesk.conversationkit.android.model.Message.Companion, new zendesk.conversationkit.android.model.MessageContent.FileUpload(r6.getUri(), r6.getName(), r6.getSize(), r6.getMimeType()), (java.util.Map) null, (java.lang.String) null, 6, (java.lang.Object) null);
        r7 = r3.conversationKit;
        r5.L$0 = r4;
        r5.L$1 = r3;
        r5.L$2 = r2;
        r5.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x01b8, code lost:
        if (r7.sendMessage(r6, r4, r5) != r1) goto L_0x0174;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01ba, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0271, code lost:
        r2 = zendesk.messaging.android.internal.conversationscreen.cache.MessagingUIPersistence.copy$default((zendesk.messaging.android.internal.conversationscreen.cache.MessagingUIPersistence) r2, (java.lang.String) null, r4, 1, (java.lang.Object) null);
        r0.L$0 = null;
        r0.label = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x028a, code lost:
        if (r0.this$0.messagingStorage.setMessagingPersistence(r2, r0) != r1) goto L_0x02a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x028c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x02a5, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            r21 = this;
            r0 = r21
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            r5 = 0
            switch(r2) {
                case 0: goto L_0x003d;
                case 1: goto L_0x0039;
                case 2: goto L_0x0034;
                case 3: goto L_0x0034;
                case 4: goto L_0x0034;
                case 5: goto L_0x0022;
                case 6: goto L_0x0034;
                case 7: goto L_0x0034;
                case 8: goto L_0x0016;
                case 9: goto L_0x0034;
                case 10: goto L_0x0034;
                default: goto L_0x000e;
            }
        L_0x000e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0016:
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r22)
            r4 = r2
            r2 = r22
            goto L_0x0271
        L_0x0022:
            java.lang.Object r2 = r0.L$2
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r3 = r0.L$1
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r3 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel) r3
            java.lang.Object r4 = r0.L$0
            java.lang.String r4 = (java.lang.String) r4
            kotlin.ResultKt.throwOnFailure(r22)
            r5 = r0
            goto L_0x0174
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r22)
            goto L_0x02a3
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r22)
            goto L_0x0083
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r22)
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction r2 = r0.$conversationScreenAction
            boolean r6 = r2 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.SendTextMessage
            if (r6 == 0) goto L_0x0095
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$SendTextMessage r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.SendTextMessage) r2
            java.lang.String r2 = r2.getConversationId()
            zendesk.conversationkit.android.model.Message$Companion r6 = zendesk.conversationkit.android.model.Message.Companion
            zendesk.conversationkit.android.model.MessageContent$Text r7 = new zendesk.conversationkit.android.model.MessageContent$Text
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction r8 = r0.$conversationScreenAction
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$SendTextMessage r8 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.SendTextMessage) r8
            java.lang.String r8 = r8.getTextMessage()
            r7.<init>(r8, r5, r4, r5)
            zendesk.conversationkit.android.model.MessageContent r7 = (zendesk.conversationkit.android.model.MessageContent) r7
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction r5 = r0.$conversationScreenAction
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$SendTextMessage r5 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.SendTextMessage) r5
            java.util.Map r5 = r5.getMetadata()
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction r8 = r0.$conversationScreenAction
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$SendTextMessage r8 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.SendTextMessage) r8
            java.lang.String r8 = r8.getPayload()
            zendesk.conversationkit.android.model.Message r5 = r6.create(r7, r5, r8)
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r6 = r0.this$0
            zendesk.conversationkit.android.ConversationKit r6 = r6.conversationKit
            r7 = r0
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r0.label = r3
            java.lang.Object r2 = r6.sendMessage(r5, r2, r7)
            if (r2 != r1) goto L_0x0083
            return r1
        L_0x0083:
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r2 = r0.this$0
            zendesk.messaging.android.internal.conversationscreen.cache.MessagingStorage r2 = r2.messagingStorage
            r3 = r0
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r0.label = r4
            java.lang.Object r2 = r2.clear(r3)
            if (r2 != r1) goto L_0x02a3
            return r1
        L_0x0095:
            boolean r4 = r2 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.ResendFailedMessage
            if (r4 == 0) goto L_0x00be
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$ResendFailedMessage r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.ResendFailedMessage) r2
            java.lang.String r2 = r2.getConversationId()
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r3 = r0.this$0
            zendesk.conversationkit.android.ConversationKit r3 = r3.conversationKit
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction r4 = r0.$conversationScreenAction
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$ResendFailedMessage r4 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.ResendFailedMessage) r4
            zendesk.messaging.android.internal.model.MessageLogEntry$MessageContainer r4 = r4.getFailedMessageContainer()
            zendesk.conversationkit.android.model.Message r4 = r4.getMessage()
            r5 = r0
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6 = 3
            r0.label = r6
            java.lang.Object r2 = r3.sendMessage(r4, r2, r5)
            if (r2 != r1) goto L_0x02a3
            return r1
        L_0x00be:
            boolean r4 = r2 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.SendFormResponse
            if (r4 == 0) goto L_0x0153
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$SendFormResponse r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.SendFormResponse) r2
            java.lang.String r2 = r2.getConversationId()
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r3 = r0.this$0
            zendesk.conversationkit.android.ConversationKit r3 = r3.conversationKit
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction r4 = r0.$conversationScreenAction
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$SendFormResponse r4 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.SendFormResponse) r4
            zendesk.messaging.android.internal.model.MessageLogEntry$MessageContainer r4 = r4.getFormMessageContainer()
            zendesk.conversationkit.android.model.Message r4 = r4.getMessage()
            zendesk.conversationkit.android.model.MessageStatus r4 = r4.getStatus()
            zendesk.conversationkit.android.model.MessageStatus r5 = zendesk.conversationkit.android.model.MessageStatus.FAILED
            if (r4 != r5) goto L_0x0120
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction r4 = r0.$conversationScreenAction
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$SendFormResponse r4 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.SendFormResponse) r4
            zendesk.messaging.android.internal.model.MessageLogEntry$MessageContainer r4 = r4.getFormMessageContainer()
            zendesk.conversationkit.android.model.Message r5 = r4.getMessage()
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            zendesk.conversationkit.android.model.MessageContent$FormResponse r4 = new zendesk.conversationkit.android.model.MessageContent$FormResponse
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction r13 = r0.$conversationScreenAction
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$SendFormResponse r13 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.SendFormResponse) r13
            zendesk.messaging.android.internal.model.MessageLogEntry$MessageContainer r13 = r13.getFormMessageContainer()
            java.lang.String r13 = r13.getId()
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction r14 = r0.$conversationScreenAction
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$SendFormResponse r14 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.SendFormResponse) r14
            java.util.List r14 = r14.getFields()
            r4.<init>(r13, r14)
            r13 = r4
            zendesk.conversationkit.android.model.MessageContent r13 = (zendesk.conversationkit.android.model.MessageContent) r13
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 1983(0x7bf, float:2.779E-42)
            r19 = 0
            zendesk.conversationkit.android.model.Message r4 = zendesk.conversationkit.android.model.Message.copy$default(r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18, r19)
            goto L_0x0146
        L_0x0120:
            zendesk.conversationkit.android.model.Message$Companion r5 = zendesk.conversationkit.android.model.Message.Companion
            zendesk.conversationkit.android.model.MessageContent$FormResponse r4 = new zendesk.conversationkit.android.model.MessageContent$FormResponse
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction r6 = r0.$conversationScreenAction
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$SendFormResponse r6 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.SendFormResponse) r6
            zendesk.messaging.android.internal.model.MessageLogEntry$MessageContainer r6 = r6.getFormMessageContainer()
            java.lang.String r6 = r6.getId()
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction r7 = r0.$conversationScreenAction
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$SendFormResponse r7 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.SendFormResponse) r7
            java.util.List r7 = r7.getFields()
            r4.<init>(r6, r7)
            r6 = r4
            zendesk.conversationkit.android.model.MessageContent r6 = (zendesk.conversationkit.android.model.MessageContent) r6
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            zendesk.conversationkit.android.model.Message r4 = zendesk.conversationkit.android.model.Message.Companion.create$default(r5, r6, r7, r8, r9, r10)
        L_0x0146:
            r5 = r0
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6 = 4
            r0.label = r6
            java.lang.Object r2 = r3.sendMessage(r4, r2, r5)
            if (r2 != r1) goto L_0x02a3
            return r1
        L_0x0153:
            boolean r4 = r2 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.UploadFiles
            if (r4 == 0) goto L_0x01bb
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$UploadFiles r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.UploadFiles) r2
            java.lang.String r2 = r2.getConversationId()
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction r3 = r0.$conversationScreenAction
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$UploadFiles r3 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.UploadFiles) r3
            java.util.List r3 = r3.getUploads()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r4 = r0.this$0
            java.util.Iterator r3 = r3.iterator()
            r5 = r0
            r20 = r4
            r4 = r2
            r2 = r3
            r3 = r20
        L_0x0174:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x02a3
            java.lang.Object r6 = r2.next()
            zendesk.messaging.android.internal.model.UploadFile r6 = (zendesk.messaging.android.internal.model.UploadFile) r6
            zendesk.conversationkit.android.model.MessageContent$FileUpload r13 = new zendesk.conversationkit.android.model.MessageContent$FileUpload
            java.lang.String r8 = r6.getUri()
            java.lang.String r9 = r6.getName()
            long r10 = r6.getSize()
            java.lang.String r12 = r6.getMimeType()
            r7 = r13
            r7.<init>(r8, r9, r10, r12)
            zendesk.conversationkit.android.model.Message$Companion r14 = zendesk.conversationkit.android.model.Message.Companion
            r15 = r13
            zendesk.conversationkit.android.model.MessageContent r15 = (zendesk.conversationkit.android.model.MessageContent) r15
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            zendesk.conversationkit.android.model.Message r6 = zendesk.conversationkit.android.model.Message.Companion.create$default(r14, r15, r16, r17, r18, r19)
            zendesk.conversationkit.android.ConversationKit r7 = r3.conversationKit
            r5.L$0 = r4
            r5.L$1 = r3
            r5.L$2 = r2
            r8 = 5
            r5.label = r8
            java.lang.Object r6 = r7.sendMessage(r6, r4, r5)
            if (r6 != r1) goto L_0x0174
            return r1
        L_0x01bb:
            boolean r4 = r2 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.SendActivityData
            if (r4 == 0) goto L_0x01e0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$SendActivityData r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.SendActivityData) r2
            java.lang.String r2 = r2.getConversationId()
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r3 = r0.this$0
            zendesk.conversationkit.android.ConversationKit r3 = r3.conversationKit
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction r4 = r0.$conversationScreenAction
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$SendActivityData r4 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.SendActivityData) r4
            zendesk.conversationkit.android.model.ActivityData r4 = r4.getActivityData()
            r5 = r0
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6 = 6
            r0.label = r6
            java.lang.Object r2 = r3.sendActivityData(r4, r2, r5)
            if (r2 != r1) goto L_0x02a3
            return r1
        L_0x01e0:
            boolean r4 = r2 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.RetryConnection
            if (r4 == 0) goto L_0x01f7
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r2 = r0.this$0
            zendesk.conversationkit.android.ConversationKit r2 = r2.conversationKit
            r3 = r0
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 7
            r0.label = r4
            java.lang.Object r2 = r2.resume(r3)
            if (r2 != r1) goto L_0x02a3
            return r1
        L_0x01f7:
            boolean r4 = r2 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.ShowMessageComposer
            if (r4 == 0) goto L_0x020c
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r1 = r0.this$0
            kotlinx.coroutines.flow.MutableStateFlow r1 = r1.conversationScreenStateFlow
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r2 = r0.this$0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r2 = r2.showMessageComposerState()
            r1.setValue(r2)
            goto L_0x02a3
        L_0x020c:
            boolean r4 = r2 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.HideMessageComposer
            if (r4 == 0) goto L_0x0221
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r1 = r0.this$0
            kotlinx.coroutines.flow.MutableStateFlow r1 = r1.conversationScreenStateFlow
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r2 = r0.this$0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r2 = r2.hideMessageComposerState()
            r1.setValue(r2)
            goto L_0x02a3
        L_0x0221:
            boolean r4 = r2 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.HideDeniedPermission
            if (r4 == 0) goto L_0x0235
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r1 = r0.this$0
            kotlinx.coroutines.flow.MutableStateFlow r1 = r1.conversationScreenStateFlow
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r2 = r0.this$0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r2 = r2.hideDeniedPermission()
            r1.setValue(r2)
            goto L_0x02a3
        L_0x0235:
            boolean r4 = r2 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.ShowDeniedPermission
            if (r4 == 0) goto L_0x0249
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r1 = r0.this$0
            kotlinx.coroutines.flow.MutableStateFlow r1 = r1.conversationScreenStateFlow
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r2 = r0.this$0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r2 = r2.showDeniedPermission()
            r1.setValue(r2)
            goto L_0x02a3
        L_0x0249:
            boolean r4 = r2 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.PersistComposerText
            if (r4 == 0) goto L_0x028d
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$PersistComposerText r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.PersistComposerText) r2
            java.lang.String r2 = r2.getConversationId()
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction r4 = r0.$conversationScreenAction
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$PersistComposerText r4 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.PersistComposerText) r4
            java.lang.String r4 = r4.getComposerText()
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r6 = r0.this$0
            zendesk.messaging.android.internal.conversationscreen.cache.MessagingStorage r6 = r6.messagingStorage
            r7 = r0
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r0.L$0 = r4
            r8 = 8
            r0.label = r8
            java.lang.Object r2 = r6.getMessagingPersistence(r2, r7)
            if (r2 != r1) goto L_0x0271
            return r1
        L_0x0271:
            zendesk.messaging.android.internal.conversationscreen.cache.MessagingUIPersistence r2 = (zendesk.messaging.android.internal.conversationscreen.cache.MessagingUIPersistence) r2
            zendesk.messaging.android.internal.conversationscreen.cache.MessagingUIPersistence r2 = zendesk.messaging.android.internal.conversationscreen.cache.MessagingUIPersistence.copy$default(r2, r5, r4, r3, r5)
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r3 = r0.this$0
            zendesk.messaging.android.internal.conversationscreen.cache.MessagingStorage r3 = r3.messagingStorage
            r4 = r0
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r0.L$0 = r5
            r5 = 9
            r0.label = r5
            java.lang.Object r2 = r3.setMessagingPersistence(r2, r4)
            if (r2 != r1) goto L_0x02a3
            return r1
        L_0x028d:
            boolean r3 = r2 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.LoadMoreMessages
            if (r3 == 0) goto L_0x02a3
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r3 = r0.this$0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$LoadMoreMessages r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.LoadMoreMessages) r2
            r4 = r0
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5 = 10
            r0.label = r5
            java.lang.Object r2 = r3.loadMoreMessages(r2, r4)
            if (r2 != r1) goto L_0x02a3
            return r1
        L_0x02a3:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$dispatchAction$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
