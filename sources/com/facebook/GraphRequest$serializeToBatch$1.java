package com.facebook;

import com.facebook.GraphRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/facebook/GraphRequest$serializeToBatch$1", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "writeString", "", "key", "", "value", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GraphRequest.kt */
public final class GraphRequest$serializeToBatch$1 implements GraphRequest.KeyValueSerializer {
    final /* synthetic */ ArrayList<String> $keysAndValues;

    GraphRequest$serializeToBatch$1(ArrayList<String> arrayList) {
        this.$keysAndValues = arrayList;
    }

    public void writeString(String str, String str2) throws IOException {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        ArrayList<String> arrayList = this.$keysAndValues;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, "%s=%s", Arrays.copyOf(new Object[]{str, URLEncoder.encode(str2, "UTF-8")}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
        arrayList.add(format);
    }
}
