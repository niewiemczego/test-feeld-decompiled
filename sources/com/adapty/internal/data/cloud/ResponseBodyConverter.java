package com.adapty.internal.data.cloud;

import java.lang.reflect.Type;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/cloud/ResponseBodyConverter;", "", "convertSuccess", "T", "response", "", "typeOfT", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ResponseBodyConverter.kt */
public interface ResponseBodyConverter {
    <T> T convertSuccess(String str, Type type);
}
