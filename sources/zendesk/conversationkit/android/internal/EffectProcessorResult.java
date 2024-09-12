package zendesk.conversationkit.android.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.ConversationKitError;
import zendesk.conversationkit.android.ConversationKitEvent;
import zendesk.conversationkit.android.ConversationKitResult;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B3\b\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\tR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b\u0001\u0002\u0011\u0012¨\u0006\u0013"}, d2 = {"Lzendesk/conversationkit/android/internal/EffectProcessorResult;", "", "newAccessLevel", "Lzendesk/conversationkit/android/internal/AccessLevel;", "events", "", "Lzendesk/conversationkit/android/ConversationKitEvent;", "supplementaryActions", "Lzendesk/conversationkit/android/internal/Action;", "(Lzendesk/conversationkit/android/internal/AccessLevel;Ljava/util/List;Ljava/util/List;)V", "getEvents", "()Ljava/util/List;", "getNewAccessLevel", "()Lzendesk/conversationkit/android/internal/AccessLevel;", "getSupplementaryActions", "Continues", "Ends", "Lzendesk/conversationkit/android/internal/EffectProcessorResult$Continues;", "Lzendesk/conversationkit/android/internal/EffectProcessorResult$Ends;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EffectProcessor.kt */
public abstract class EffectProcessorResult {
    private final List<ConversationKitEvent> events;
    private final AccessLevel newAccessLevel;
    private final List<Action> supplementaryActions;

    public /* synthetic */ EffectProcessorResult(AccessLevel accessLevel, List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(accessLevel, list, list2);
    }

    private EffectProcessorResult(AccessLevel accessLevel, List<? extends ConversationKitEvent> list, List<? extends Action> list2) {
        this.newAccessLevel = accessLevel;
        this.events = list;
        this.supplementaryActions = list2;
    }

    public AccessLevel getNewAccessLevel() {
        return this.newAccessLevel;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EffectProcessorResult(AccessLevel accessLevel, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : accessLevel, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, (DefaultConstructorMarker) null);
    }

    public List<ConversationKitEvent> getEvents() {
        return this.events;
    }

    public List<Action> getSupplementaryActions() {
        return this.supplementaryActions;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lzendesk/conversationkit/android/internal/EffectProcessorResult$Continues;", "Lzendesk/conversationkit/android/internal/EffectProcessorResult;", "newAccessLevel", "Lzendesk/conversationkit/android/internal/AccessLevel;", "events", "", "Lzendesk/conversationkit/android/ConversationKitEvent;", "supplementaryActions", "Lzendesk/conversationkit/android/internal/Action;", "followingAction", "(Lzendesk/conversationkit/android/internal/AccessLevel;Ljava/util/List;Ljava/util/List;Lzendesk/conversationkit/android/internal/Action;)V", "getEvents", "()Ljava/util/List;", "getFollowingAction", "()Lzendesk/conversationkit/android/internal/Action;", "getNewAccessLevel", "()Lzendesk/conversationkit/android/internal/AccessLevel;", "getSupplementaryActions", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EffectProcessor.kt */
    public static final class Continues extends EffectProcessorResult {
        private final List<ConversationKitEvent> events;
        private final Action followingAction;
        private final AccessLevel newAccessLevel;
        private final List<Action> supplementaryActions;

        public static /* synthetic */ Continues copy$default(Continues continues, AccessLevel accessLevel, List<ConversationKitEvent> list, List<Action> list2, Action action, int i, Object obj) {
            if ((i & 1) != 0) {
                accessLevel = continues.getNewAccessLevel();
            }
            if ((i & 2) != 0) {
                list = continues.getEvents();
            }
            if ((i & 4) != 0) {
                list2 = continues.getSupplementaryActions();
            }
            if ((i & 8) != 0) {
                action = continues.followingAction;
            }
            return continues.copy(accessLevel, list, list2, action);
        }

        public final AccessLevel component1() {
            return getNewAccessLevel();
        }

        public final List<ConversationKitEvent> component2() {
            return getEvents();
        }

        public final List<Action> component3() {
            return getSupplementaryActions();
        }

        public final Action component4() {
            return this.followingAction;
        }

        public final Continues copy(AccessLevel accessLevel, List<? extends ConversationKitEvent> list, List<? extends Action> list2, Action action) {
            Intrinsics.checkNotNullParameter(list, "events");
            Intrinsics.checkNotNullParameter(list2, "supplementaryActions");
            Intrinsics.checkNotNullParameter(action, "followingAction");
            return new Continues(accessLevel, list, list2, action);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Continues)) {
                return false;
            }
            Continues continues = (Continues) obj;
            return Intrinsics.areEqual((Object) getNewAccessLevel(), (Object) continues.getNewAccessLevel()) && Intrinsics.areEqual((Object) getEvents(), (Object) continues.getEvents()) && Intrinsics.areEqual((Object) getSupplementaryActions(), (Object) continues.getSupplementaryActions()) && Intrinsics.areEqual((Object) this.followingAction, (Object) continues.followingAction);
        }

        public int hashCode() {
            return ((((((getNewAccessLevel() == null ? 0 : getNewAccessLevel().hashCode()) * 31) + getEvents().hashCode()) * 31) + getSupplementaryActions().hashCode()) * 31) + this.followingAction.hashCode();
        }

        public String toString() {
            return "Continues(newAccessLevel=" + getNewAccessLevel() + ", events=" + getEvents() + ", supplementaryActions=" + getSupplementaryActions() + ", followingAction=" + this.followingAction + ')';
        }

        public AccessLevel getNewAccessLevel() {
            return this.newAccessLevel;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Continues(AccessLevel accessLevel, List list, List list2, Action action, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : accessLevel, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, action);
        }

        public List<ConversationKitEvent> getEvents() {
            return this.events;
        }

        public List<Action> getSupplementaryActions() {
            return this.supplementaryActions;
        }

        public final Action getFollowingAction() {
            return this.followingAction;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Continues(AccessLevel accessLevel, List<? extends ConversationKitEvent> list, List<? extends Action> list2, Action action) {
            super(accessLevel, list, list2, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "events");
            Intrinsics.checkNotNullParameter(list2, "supplementaryActions");
            Intrinsics.checkNotNullParameter(action, "followingAction");
            this.newAccessLevel = accessLevel;
            this.events = list;
            this.supplementaryActions = list2;
            this.followingAction = action;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¢\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nHÆ\u0003JG\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006 "}, d2 = {"Lzendesk/conversationkit/android/internal/EffectProcessorResult$Ends;", "Lzendesk/conversationkit/android/internal/EffectProcessorResult;", "newAccessLevel", "Lzendesk/conversationkit/android/internal/AccessLevel;", "events", "", "Lzendesk/conversationkit/android/ConversationKitEvent;", "supplementaryActions", "Lzendesk/conversationkit/android/internal/Action;", "result", "Lzendesk/conversationkit/android/ConversationKitResult;", "", "(Lzendesk/conversationkit/android/internal/AccessLevel;Ljava/util/List;Ljava/util/List;Lzendesk/conversationkit/android/ConversationKitResult;)V", "getEvents", "()Ljava/util/List;", "getNewAccessLevel", "()Lzendesk/conversationkit/android/internal/AccessLevel;", "getResult", "()Lzendesk/conversationkit/android/ConversationKitResult;", "getSupplementaryActions", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EffectProcessor.kt */
    public static final class Ends extends EffectProcessorResult {
        private final List<ConversationKitEvent> events;
        private final AccessLevel newAccessLevel;
        private final ConversationKitResult<Object> result;
        private final List<Action> supplementaryActions;

        public Ends() {
            this((AccessLevel) null, (List) null, (List) null, (ConversationKitResult) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Ends copy$default(Ends ends, AccessLevel accessLevel, List<ConversationKitEvent> list, List<Action> list2, ConversationKitResult<Object> conversationKitResult, int i, Object obj) {
            if ((i & 1) != 0) {
                accessLevel = ends.getNewAccessLevel();
            }
            if ((i & 2) != 0) {
                list = ends.getEvents();
            }
            if ((i & 4) != 0) {
                list2 = ends.getSupplementaryActions();
            }
            if ((i & 8) != 0) {
                conversationKitResult = ends.result;
            }
            return ends.copy(accessLevel, list, list2, conversationKitResult);
        }

        public final AccessLevel component1() {
            return getNewAccessLevel();
        }

        public final List<ConversationKitEvent> component2() {
            return getEvents();
        }

        public final List<Action> component3() {
            return getSupplementaryActions();
        }

        public final ConversationKitResult<Object> component4() {
            return this.result;
        }

        public final Ends copy(AccessLevel accessLevel, List<? extends ConversationKitEvent> list, List<? extends Action> list2, ConversationKitResult<? extends Object> conversationKitResult) {
            Intrinsics.checkNotNullParameter(list, "events");
            Intrinsics.checkNotNullParameter(list2, "supplementaryActions");
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            return new Ends(accessLevel, list, list2, conversationKitResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Ends)) {
                return false;
            }
            Ends ends = (Ends) obj;
            return Intrinsics.areEqual((Object) getNewAccessLevel(), (Object) ends.getNewAccessLevel()) && Intrinsics.areEqual((Object) getEvents(), (Object) ends.getEvents()) && Intrinsics.areEqual((Object) getSupplementaryActions(), (Object) ends.getSupplementaryActions()) && Intrinsics.areEqual((Object) this.result, (Object) ends.result);
        }

        public int hashCode() {
            return ((((((getNewAccessLevel() == null ? 0 : getNewAccessLevel().hashCode()) * 31) + getEvents().hashCode()) * 31) + getSupplementaryActions().hashCode()) * 31) + this.result.hashCode();
        }

        public String toString() {
            return "Ends(newAccessLevel=" + getNewAccessLevel() + ", events=" + getEvents() + ", supplementaryActions=" + getSupplementaryActions() + ", result=" + this.result + ')';
        }

        public AccessLevel getNewAccessLevel() {
            return this.newAccessLevel;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Ends(AccessLevel accessLevel, List list, List list2, ConversationKitResult conversationKitResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : accessLevel, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, (i & 8) != 0 ? new ConversationKitResult.Failure(ConversationKitError.NoResultReceived.INSTANCE) : conversationKitResult);
        }

        public List<ConversationKitEvent> getEvents() {
            return this.events;
        }

        public List<Action> getSupplementaryActions() {
            return this.supplementaryActions;
        }

        public final ConversationKitResult<Object> getResult() {
            return this.result;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ends(AccessLevel accessLevel, List<? extends ConversationKitEvent> list, List<? extends Action> list2, ConversationKitResult<? extends Object> conversationKitResult) {
            super(accessLevel, list, list2, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "events");
            Intrinsics.checkNotNullParameter(list2, "supplementaryActions");
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            this.newAccessLevel = accessLevel;
            this.events = list;
            this.supplementaryActions = list2;
            this.result = conversationKitResult;
        }
    }
}
