package com.braze.enums;

import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/braze/enums/Month;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER", "Companion", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum Month {
    JANUARY(0),
    FEBRUARY(1),
    MARCH(2),
    APRIL(3),
    MAY(4),
    JUNE(5),
    JULY(6),
    AUGUST(7),
    SEPTEMBER(8),
    OCTOBER(9),
    NOVEMBER(10),
    DECEMBER(11);
    
    public static final Companion Companion = null;
    private final int value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/braze/enums/Month$Companion;", "", "()V", "getMonth", "Lcom/braze/enums/Month;", "value", "", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final class a extends Lambda implements Function0 {
            final /* synthetic */ int b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(int i) {
                super(0);
                this.b = i;
            }

            /* renamed from: a */
            public final String invoke() {
                return "No month with value " + this.b + ", value must be in (0,11)";
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Month getMonth(int i) {
            Month month;
            Month[] values = Month.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    month = null;
                    break;
                }
                month = values[i2];
                if (month.getValue() == i) {
                    break;
                }
                i2++;
            }
            if (month != null) {
                return month;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new a(i), 2, (Object) null);
            return null;
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private Month(int i) {
        this.value = i;
    }

    @JvmStatic
    public static final Month getMonth(int i) {
        return Companion.getMonth(i);
    }

    public final int getValue() {
        return this.value;
    }
}
