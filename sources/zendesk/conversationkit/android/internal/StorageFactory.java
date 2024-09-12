package zendesk.conversationkit.android.internal;

import android.content.Context;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.app.AppStorage;
import zendesk.conversationkit.android.internal.proactivemessaging.ProactiveMessagingStorage;
import zendesk.conversationkit.android.internal.user.UserStorage;
import zendesk.storage.android.Serializer;
import zendesk.storage.android.StorageType;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lzendesk/conversationkit/android/internal/StorageFactory;", "", "context", "Landroid/content/Context;", "serializer", "Lzendesk/storage/android/Serializer;", "(Landroid/content/Context;Lzendesk/storage/android/Serializer;)V", "createAppStorage", "Lzendesk/conversationkit/android/internal/app/AppStorage;", "appId", "", "createConversationKitStorage", "Lzendesk/conversationkit/android/internal/ConversationKitStorage;", "createProactiveMessagingStorage", "Lzendesk/conversationkit/android/internal/proactivemessaging/ProactiveMessagingStorage;", "createUserStorage", "Lzendesk/conversationkit/android/internal/user/UserStorage;", "userId", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StorageFactory.kt */
public final class StorageFactory {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String PROACTIVE_MESSAGING_STORAGE_NAMESPACE = "zendesk.conversationkit.proactivemessaging";
    private final Context context;
    private final Serializer serializer;

    public StorageFactory(Context context2, Serializer serializer2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(serializer2, "serializer");
        this.context = context2;
        this.serializer = serializer2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StorageFactory(Context context2, Serializer serializer2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i & 2) != 0 ? new DefaultSerializer((Moshi) null, 1, (DefaultConstructorMarker) null) : serializer2);
    }

    public final ConversationKitStorage createConversationKitStorage() {
        return new ConversationKitStorage(zendesk.storage.android.StorageFactory.INSTANCE.create("zendesk.conversationkit", this.context, StorageType.Basic.INSTANCE));
    }

    public final AppStorage createAppStorage(String str) {
        Intrinsics.checkNotNullParameter(str, "appId");
        return new AppStorage(zendesk.storage.android.StorageFactory.INSTANCE.create("zendesk.conversationkit.app." + str, this.context, new StorageType.Complex(this.serializer)));
    }

    public final UserStorage createUserStorage(String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        return new UserStorage(zendesk.storage.android.StorageFactory.INSTANCE.create("zendesk.conversationkit.user." + str, this.context, new StorageType.Complex(this.serializer)));
    }

    public final ProactiveMessagingStorage createProactiveMessagingStorage() {
        return new ProactiveMessagingStorage(zendesk.storage.android.StorageFactory.INSTANCE.create(PROACTIVE_MESSAGING_STORAGE_NAMESPACE, this.context, new StorageType.Complex(this.serializer)));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/conversationkit/android/internal/StorageFactory$Companion;", "", "()V", "PROACTIVE_MESSAGING_STORAGE_NAMESPACE", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StorageFactory.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
