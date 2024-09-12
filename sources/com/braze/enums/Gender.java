package com.braze.enums;

import com.braze.Constants;
import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/braze/enums/Gender;", "", "Lcom/braze/models/IPutIntoJson;", "", "value", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "forJsonPut", "MALE", "FEMALE", "OTHER", "UNKNOWN", "NOT_APPLICABLE", "PREFER_NOT_TO_SAY", "Companion", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum Gender implements IPutIntoJson<String> {
    MALE("m"),
    FEMALE("f"),
    OTHER("o"),
    UNKNOWN("u"),
    NOT_APPLICABLE(Constants.BRAZE_PUSH_CUSTOM_NOTIFICATION_ID),
    PREFER_NOT_TO_SAY("p");
    
    public static final Companion Companion = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/braze/enums/Gender$Companion;", "", "()V", "getGender", "Lcom/braze/enums/Gender;", "value", "", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final class a extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "No gender with value " + this.b + '.';
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Gender getGender(String str) {
            String str2;
            Gender gender = null;
            if (str != null) {
                str2 = str.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            } else {
                str2 = null;
            }
            Gender[] values = Gender.values();
            int length = values.length;
            int i = 0;
            Gender gender2 = null;
            boolean z = false;
            while (true) {
                if (i < length) {
                    Gender gender3 = values[i];
                    if (Intrinsics.areEqual((Object) gender3.getValue(), (Object) str2)) {
                        if (z) {
                            break;
                        }
                        z = true;
                        gender2 = gender3;
                    }
                    i++;
                } else if (z) {
                    gender = gender2;
                }
            }
            if (gender == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new a(str), 2, (Object) null);
            }
            return gender;
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private Gender(String str) {
        this.value = str;
    }

    @JvmStatic
    public static final Gender getGender(String str) {
        return Companion.getGender(str);
    }

    public final String getValue() {
        return this.value;
    }

    public String forJsonPut() {
        return this.value;
    }
}
