package bo.app;

import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

public final class y4 {
    public static final y4 a = new y4();

    private y4() {
    }

    public static final Map a() {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate");
        hashMap.put("Content-Type", "application/json");
        return hashMap;
    }
}
