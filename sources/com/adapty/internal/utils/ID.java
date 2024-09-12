package com.adapty.internal.utils;

import java.lang.String;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JvmInline
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b@\u0018\u0000 \u0015*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\u00020\u0003:\u0001\u0015B\u0012\u0012\u0006\u0010\u0004\u001a\u00028\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0006R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b\u0001\u0004ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/adapty/internal/utils/ID;", "T", "", "", "value", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Ljava/lang/String;", "equals", "", "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ID.kt */
public final class ID<T extends String> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String UNSPECIFIED = m92constructorimpl("");
    private final T value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ID m91boximpl(String str) {
        return new ID(str);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static <T extends String> String m92constructorimpl(T t) {
        return t;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m93equalsimpl(String str, Object obj) {
        return (obj instanceof ID) && Intrinsics.areEqual((Object) str, (Object) ((ID) obj).m97unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m94equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual((Object) str, (Object) str2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m95hashCodeimpl(String str) {
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m96toStringimpl(String str) {
        return "ID(value=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m93equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m95hashCodeimpl(this.value);
    }

    public String toString() {
        return m96toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ String m97unboximpl() {
        return this.value;
    }

    private /* synthetic */ ID(String str) {
        this.value = str;
    }

    public final T getValue() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\t"}, d2 = {"Lcom/adapty/internal/utils/ID$Companion;", "", "()V", "UNSPECIFIED", "Lcom/adapty/internal/utils/ID;", "", "getUNSPECIFIED-sonumTQ", "()Ljava/lang/String;", "Ljava/lang/String;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ID.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getUNSPECIFIED-sonumTQ  reason: not valid java name */
        public final String m98getUNSPECIFIEDsonumTQ() {
            return ID.UNSPECIFIED;
        }
    }
}
