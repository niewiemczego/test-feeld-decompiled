package com.adapty.internal.data.cloud;

import java.lang.reflect.Type;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/cloud/HttpClient;", "", "newCall", "Lcom/adapty/internal/data/cloud/Response;", "T", "request", "Lcom/adapty/internal/data/cloud/Request;", "typeOfT", "Ljava/lang/reflect/Type;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HttpClient.kt */
public interface HttpClient {
    <T> Response<T> newCall(Request request, Type type);
}
