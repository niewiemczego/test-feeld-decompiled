package zendesk.conversationkit.android.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.integration.IntegrationActionProcessor;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/IntegrationAccess;", "Lzendesk/conversationkit/android/internal/AccessLevel;", "integrationProcessor", "Lzendesk/conversationkit/android/internal/integration/IntegrationActionProcessor;", "(Lzendesk/conversationkit/android/internal/integration/IntegrationActionProcessor;)V", "getIntegrationProcessor", "()Lzendesk/conversationkit/android/internal/integration/IntegrationActionProcessor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccessLevel.kt */
public final class IntegrationAccess extends AccessLevel {
    private final IntegrationActionProcessor integrationProcessor;

    public static /* synthetic */ IntegrationAccess copy$default(IntegrationAccess integrationAccess, IntegrationActionProcessor integrationActionProcessor, int i, Object obj) {
        if ((i & 1) != 0) {
            integrationActionProcessor = integrationAccess.integrationProcessor;
        }
        return integrationAccess.copy(integrationActionProcessor);
    }

    public final IntegrationActionProcessor component1() {
        return this.integrationProcessor;
    }

    public final IntegrationAccess copy(IntegrationActionProcessor integrationActionProcessor) {
        Intrinsics.checkNotNullParameter(integrationActionProcessor, "integrationProcessor");
        return new IntegrationAccess(integrationActionProcessor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IntegrationAccess) && Intrinsics.areEqual((Object) this.integrationProcessor, (Object) ((IntegrationAccess) obj).integrationProcessor);
    }

    public int hashCode() {
        return this.integrationProcessor.hashCode();
    }

    public String toString() {
        return "IntegrationAccess(integrationProcessor=" + this.integrationProcessor + ')';
    }

    public final IntegrationActionProcessor getIntegrationProcessor() {
        return this.integrationProcessor;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntegrationAccess(IntegrationActionProcessor integrationActionProcessor) {
        super("IntegrationAccess", (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(integrationActionProcessor, "integrationProcessor");
        this.integrationProcessor = integrationActionProcessor;
    }
}
