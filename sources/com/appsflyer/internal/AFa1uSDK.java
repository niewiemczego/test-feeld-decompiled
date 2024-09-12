package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFc1qSDK;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

final class AFa1uSDK {

    enum AFa1ySDK {
        NONE,
        FIRST,
        ALL
    }

    AFa1uSDK() {
    }

    static List<BigDecimal> AFInAppEventParameterName(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        Float f = (Float) arrayList.get(0);
        Float f2 = (Float) arrayList.get(1);
        Float f3 = (Float) arrayList.get(2);
        ArrayList arrayList2 = new ArrayList();
        try {
            arrayList2.add(BigDecimal.valueOf(AFc1qSDK.AFa1vSDK.AFInAppEventParameterName(f.toString())));
            arrayList2.add(BigDecimal.valueOf(AFc1qSDK.AFa1vSDK.AFInAppEventParameterName(f2.toString())));
            arrayList2.add(BigDecimal.valueOf(AFc1qSDK.AFa1vSDK.AFInAppEventParameterName(f3.toString())));
        } catch (ParseException e) {
            AFLogger.afErrorLogForExcManagerOnly("failed to parse string to number", e);
        }
        return arrayList2;
    }

    enum AFa1wSDK {
        UNKNOWN(0),
        ACCELEROMETER(1),
        MAGNETOMETER(2),
        RESERVED(3),
        GYROSCOPE(4);
        
        private int AFLogger;

        private AFa1wSDK(int i) {
            this.AFLogger = i;
        }
    }

    enum AFa1xSDK {
        UNKNOWN("uk"),
        ACCELEROMETER("am"),
        MAGNETOMETER("mm"),
        RESERVED("rs"),
        GYROSCOPE("gs");
        
        String values;

        private AFa1xSDK(String str) {
            this.values = str;
        }
    }
}
