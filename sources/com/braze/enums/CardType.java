package com.braze.enums;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/braze/enums/CardType;", "", "(Ljava/lang/String;I)V", "value", "", "getValue", "()I", "IMAGE", "CAPTIONED_IMAGE", "DEFAULT", "SHORT_NEWS", "TEXT_ANNOUNCEMENT", "CONTROL", "Companion", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum CardType {
    IMAGE,
    CAPTIONED_IMAGE,
    DEFAULT,
    SHORT_NEWS,
    TEXT_ANNOUNCEMENT,
    CONTROL;
    
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/braze/enums/CardType$Companion;", "", "()V", "fromValue", "Lcom/braze/enums/CardType;", "value", "", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final CardType fromValue(int i) {
            return CardType.values()[i];
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final CardType fromValue(int i) {
        return Companion.fromValue(i);
    }

    public final int getValue() {
        return ordinal();
    }
}
