package com.adapty.internal.utils;

import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.utils.AdaptyLogLevel;
import io.sentry.Session;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\u0001\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001c\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¨\u0006\f"}, d2 = {"Lcom/adapty/internal/utils/CustomAttributeValidator;", "", "()V", "throwWrongParamError", "", "message", "", "validate", "", "attrs", "", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CustomAttributeValidator.kt */
public final class CustomAttributeValidator {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final int MAX_ATTRS_COUNT = 30;
    @Deprecated
    public static final int MAX_KEY_LENGTH = 30;
    @Deprecated
    public static final int MAX_VALUE_LENGTH = 50;

    private final Void throwWrongParamError(String str) {
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.ERROR;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, str));
        }
        throw new AdaptyError((Throwable) null, str, AdaptyErrorCode.WRONG_PARAMETER, 1, (DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/utils/CustomAttributeValidator$Companion;", "", "()V", "MAX_ATTRS_COUNT", "", "MAX_KEY_LENGTH", "MAX_VALUE_LENGTH", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CustomAttributeValidator.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void validate(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, Session.JsonKeys.ATTRS);
        int i = 0;
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (value != null) {
                i++;
            }
            if (i <= 30) {
                CharSequence charSequence = str;
                int length = StringsKt.trim(charSequence).toString().length();
                boolean z = true;
                if (1 <= length && length < 31) {
                    if (value instanceof String) {
                        int length2 = StringsKt.trim((CharSequence) (String) value).toString().length();
                        if (1 > length2 || length2 >= 51) {
                            z = false;
                        }
                        if (!z) {
                            throwWrongParamError("The value must not be empty and be no more than 50 characters");
                            throw new KotlinNothingValueException();
                        }
                    }
                    if (!new Regex("[\\dA-Za-z_.-]+").matches(charSequence)) {
                        throwWrongParamError("Only letters, numbers, dashes, points and underscores allowed in keys");
                        throw new KotlinNothingValueException();
                    }
                } else {
                    throwWrongParamError("The key must not be empty and be no more than 30 characters");
                    throw new KotlinNothingValueException();
                }
            } else {
                throwWrongParamError("There must be no more than 30 attributes");
                throw new KotlinNothingValueException();
            }
        }
    }
}
