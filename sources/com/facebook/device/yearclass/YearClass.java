package com.facebook.device.yearclass;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.io.FileUtils;

public class YearClass {
    public static final int CLASS_2008 = 2008;
    public static final int CLASS_2009 = 2009;
    public static final int CLASS_2010 = 2010;
    public static final int CLASS_2011 = 2011;
    public static final int CLASS_2012 = 2012;
    public static final int CLASS_2013 = 2013;
    public static final int CLASS_2014 = 2014;
    public static final int CLASS_2015 = 2015;
    public static final int CLASS_2016 = 2016;
    public static final int CLASS_UNKNOWN = -1;
    private static final long MB = 1048576;
    private static final int MHZ_IN_KHZ = 1000;
    private static volatile Integer mYearCategory;

    public static int get(Context context) {
        if (mYearCategory == null) {
            synchronized (YearClass.class) {
                if (mYearCategory == null) {
                    mYearCategory = Integer.valueOf(categorizeByYear2016Method(context));
                }
            }
        }
        return mYearCategory.intValue();
    }

    private static void conditionallyAdd(ArrayList<Integer> arrayList, int i) {
        if (i != -1) {
            arrayList.add(Integer.valueOf(i));
        }
    }

    private static int categorizeByYear2016Method(Context context) {
        long totalMemory = DeviceInfo.getTotalMemory(context);
        if (totalMemory == -1) {
            return categorizeByYear2014Method(context);
        }
        if (totalMemory <= 805306368) {
            return DeviceInfo.getNumberOfCPUCores() <= 1 ? CLASS_2009 : CLASS_2010;
        }
        if (totalMemory <= FileUtils.ONE_GB) {
            if (DeviceInfo.getCPUMaxFreqKHz() < 1300000) {
                return CLASS_2011;
            }
            return CLASS_2012;
        } else if (totalMemory <= 1610612736) {
            if (DeviceInfo.getCPUMaxFreqKHz() < 1800000) {
                return CLASS_2012;
            }
            return CLASS_2013;
        } else if (totalMemory <= 2147483648L) {
            return CLASS_2013;
        } else {
            if (totalMemory <= 3221225472L) {
                return CLASS_2014;
            }
            return totalMemory <= 5368709120L ? CLASS_2015 : CLASS_2016;
        }
    }

    private static int categorizeByYear2014Method(Context context) {
        ArrayList arrayList = new ArrayList();
        conditionallyAdd(arrayList, getNumCoresYear());
        conditionallyAdd(arrayList, getClockSpeedYear());
        conditionallyAdd(arrayList, getRamYear(context));
        if (arrayList.isEmpty()) {
            return -1;
        }
        Collections.sort(arrayList);
        if ((arrayList.size() & 1) == 1) {
            return ((Integer) arrayList.get(arrayList.size() / 2)).intValue();
        }
        int size = (arrayList.size() / 2) - 1;
        return ((Integer) arrayList.get(size)).intValue() + ((((Integer) arrayList.get(size + 1)).intValue() - ((Integer) arrayList.get(size)).intValue()) / 2);
    }

    private static int getNumCoresYear() {
        int numberOfCPUCores = DeviceInfo.getNumberOfCPUCores();
        if (numberOfCPUCores < 1) {
            return -1;
        }
        if (numberOfCPUCores == 1) {
            return 2008;
        }
        return numberOfCPUCores <= 3 ? CLASS_2011 : CLASS_2012;
    }

    private static int getClockSpeedYear() {
        long cPUMaxFreqKHz = (long) DeviceInfo.getCPUMaxFreqKHz();
        if (cPUMaxFreqKHz == -1) {
            return -1;
        }
        if (cPUMaxFreqKHz <= 528000) {
            return 2008;
        }
        if (cPUMaxFreqKHz <= 620000) {
            return CLASS_2009;
        }
        if (cPUMaxFreqKHz <= 1020000) {
            return CLASS_2010;
        }
        if (cPUMaxFreqKHz <= 1220000) {
            return CLASS_2011;
        }
        if (cPUMaxFreqKHz <= 1520000) {
            return CLASS_2012;
        }
        return cPUMaxFreqKHz <= 2020000 ? CLASS_2013 : CLASS_2014;
    }

    private static int getRamYear(Context context) {
        long totalMemory = DeviceInfo.getTotalMemory(context);
        if (totalMemory <= 0) {
            return -1;
        }
        if (totalMemory <= 201326592) {
            return 2008;
        }
        if (totalMemory <= 304087040) {
            return CLASS_2009;
        }
        if (totalMemory <= 536870912) {
            return CLASS_2010;
        }
        if (totalMemory <= FileUtils.ONE_GB) {
            return CLASS_2011;
        }
        if (totalMemory <= 1610612736) {
            return CLASS_2012;
        }
        return totalMemory <= 2147483648L ? CLASS_2013 : CLASS_2014;
    }
}
