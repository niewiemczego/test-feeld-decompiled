package zendesk.messaging.android.internal;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002:\u0005\t\n\u000b\f\rB\u000f\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0001\u0005\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lzendesk/messaging/android/internal/IntentDelegate;", "T", "Lkotlin/properties/ReadWriteProperty;", "Landroid/content/Intent;", "key", "", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "Boolean", "Int", "Parcelable", "Serializable", "String", "Lzendesk/messaging/android/internal/IntentDelegate$Int;", "Lzendesk/messaging/android/internal/IntentDelegate$String;", "Lzendesk/messaging/android/internal/IntentDelegate$Boolean;", "Lzendesk/messaging/android/internal/IntentDelegate$Serializable;", "Lzendesk/messaging/android/internal/IntentDelegate$Parcelable;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IntentDelegate.kt */
public abstract class IntentDelegate<T> implements ReadWriteProperty<Intent, T> {
    private final String key;

    public /* synthetic */ IntentDelegate(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private IntentDelegate(String str) {
        this.key = str;
    }

    /* access modifiers changed from: protected */
    public final String getKey() {
        return this.key;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002¢\u0006\u0002\u0010\fJ%\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002R\u000e\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lzendesk/messaging/android/internal/IntentDelegate$Int;", "Lzendesk/messaging/android/internal/IntentDelegate;", "", "key", "", "defaultValue", "(Ljava/lang/String;I)V", "getValue", "thisRef", "Landroid/content/Intent;", "property", "Lkotlin/reflect/KProperty;", "(Landroid/content/Intent;Lkotlin/reflect/KProperty;)Ljava/lang/Integer;", "setValue", "", "value", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IntentDelegate.kt */
    public static final class Int extends IntentDelegate<Integer> {
        private final int defaultValue;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Int(String str, int i) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "key");
            this.defaultValue = i;
        }

        public /* bridge */ /* synthetic */ void setValue(Object obj, KProperty kProperty, Object obj2) {
            setValue((Intent) obj, (KProperty<?>) kProperty, ((Number) obj2).intValue());
        }

        public Integer getValue(Intent intent, KProperty<?> kProperty) {
            Intrinsics.checkNotNullParameter(intent, "thisRef");
            Intrinsics.checkNotNullParameter(kProperty, "property");
            return Integer.valueOf(intent.getIntExtra(getKey(), this.defaultValue));
        }

        public void setValue(Intent intent, KProperty<?> kProperty, int i) {
            Intrinsics.checkNotNullParameter(intent, "thisRef");
            Intrinsics.checkNotNullParameter(kProperty, "property");
            intent.putExtra(getKey(), i);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J%\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\f\u001a\u00020\u0002H\u0002¨\u0006\r"}, d2 = {"Lzendesk/messaging/android/internal/IntentDelegate$String;", "Lzendesk/messaging/android/internal/IntentDelegate;", "", "key", "(Ljava/lang/String;)V", "getValue", "thisRef", "Landroid/content/Intent;", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "value", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IntentDelegate.kt */
    public static final class String extends IntentDelegate<String> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public String(String str) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "key");
        }

        public String getValue(Intent intent, KProperty<?> kProperty) {
            Intrinsics.checkNotNullParameter(intent, "thisRef");
            Intrinsics.checkNotNullParameter(kProperty, "property");
            String stringExtra = intent.getStringExtra(getKey());
            return stringExtra == null ? "" : stringExtra;
        }

        public void setValue(Intent intent, KProperty<?> kProperty, String str) {
            Intrinsics.checkNotNullParameter(intent, "thisRef");
            Intrinsics.checkNotNullParameter(kProperty, "property");
            Intrinsics.checkNotNullParameter(str, "value");
            intent.putExtra(getKey(), str);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002¢\u0006\u0002\u0010\fJ%\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002R\u000e\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lzendesk/messaging/android/internal/IntentDelegate$Boolean;", "Lzendesk/messaging/android/internal/IntentDelegate;", "", "key", "", "defaultValue", "(Ljava/lang/String;Z)V", "getValue", "thisRef", "Landroid/content/Intent;", "property", "Lkotlin/reflect/KProperty;", "(Landroid/content/Intent;Lkotlin/reflect/KProperty;)Ljava/lang/Boolean;", "setValue", "", "value", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IntentDelegate.kt */
    public static final class Boolean extends IntentDelegate<Boolean> {
        private final boolean defaultValue;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Boolean(String str, boolean z) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "key");
            this.defaultValue = z;
        }

        public /* bridge */ /* synthetic */ void setValue(Object obj, KProperty kProperty, Object obj2) {
            setValue((Intent) obj, (KProperty<?>) kProperty, ((Boolean) obj2).booleanValue());
        }

        public Boolean getValue(Intent intent, KProperty<?> kProperty) {
            Intrinsics.checkNotNullParameter(intent, "thisRef");
            Intrinsics.checkNotNullParameter(kProperty, "property");
            return Boolean.valueOf(intent.getBooleanExtra(getKey(), this.defaultValue));
        }

        public void setValue(Intent intent, KProperty<?> kProperty, boolean z) {
            Intrinsics.checkNotNullParameter(intent, "thisRef");
            Intrinsics.checkNotNullParameter(kProperty, "property");
            intent.putExtra(getKey(), z);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002¢\u0006\u0002\u0010\fJ,\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lzendesk/messaging/android/internal/IntentDelegate$Serializable;", "T", "Ljava/io/Serializable;", "Lzendesk/messaging/android/internal/IntentDelegate;", "key", "", "(Ljava/lang/String;)V", "getValue", "thisRef", "Landroid/content/Intent;", "property", "Lkotlin/reflect/KProperty;", "(Landroid/content/Intent;Lkotlin/reflect/KProperty;)Ljava/io/Serializable;", "setValue", "", "value", "(Landroid/content/Intent;Lkotlin/reflect/KProperty;Ljava/io/Serializable;)V", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IntentDelegate.kt */
    public static final class Serializable<T extends java.io.Serializable> extends IntentDelegate<T> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Serializable(String str) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "key");
        }

        public T getValue(Intent intent, KProperty<?> kProperty) {
            Intrinsics.checkNotNullParameter(intent, "thisRef");
            Intrinsics.checkNotNullParameter(kProperty, "property");
            T serializableExtra = intent.getSerializableExtra(getKey());
            if (serializableExtra instanceof java.io.Serializable) {
                return serializableExtra;
            }
            return null;
        }

        public void setValue(Intent intent, KProperty<?> kProperty, T t) {
            Intrinsics.checkNotNullParameter(intent, "thisRef");
            Intrinsics.checkNotNullParameter(kProperty, "property");
            intent.putExtra(getKey(), t);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002¢\u0006\u0002\u0010\fJ,\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lzendesk/messaging/android/internal/IntentDelegate$Parcelable;", "T", "Landroid/os/Parcelable;", "Lzendesk/messaging/android/internal/IntentDelegate;", "key", "", "(Ljava/lang/String;)V", "getValue", "thisRef", "Landroid/content/Intent;", "property", "Lkotlin/reflect/KProperty;", "(Landroid/content/Intent;Lkotlin/reflect/KProperty;)Landroid/os/Parcelable;", "setValue", "", "value", "(Landroid/content/Intent;Lkotlin/reflect/KProperty;Landroid/os/Parcelable;)V", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IntentDelegate.kt */
    public static final class Parcelable<T extends android.os.Parcelable> extends IntentDelegate<T> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Parcelable(String str) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "key");
        }

        public T getValue(Intent intent, KProperty<?> kProperty) {
            Intrinsics.checkNotNullParameter(intent, "thisRef");
            Intrinsics.checkNotNullParameter(kProperty, "property");
            return intent.getParcelableExtra(getKey());
        }

        public void setValue(Intent intent, KProperty<?> kProperty, T t) {
            Intrinsics.checkNotNullParameter(intent, "thisRef");
            Intrinsics.checkNotNullParameter(kProperty, "property");
            intent.putExtra(getKey(), t);
        }
    }
}
