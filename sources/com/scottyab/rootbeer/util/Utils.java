package com.scottyab.rootbeer.util;

public final class Utils {
    private Utils() throws InstantiationException {
        throw new InstantiationException("This class is not for instantiation");
    }

    public static boolean isSelinuxFlagInEnabled() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return "1".equals((String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.build.selinux"}));
        } catch (Exception unused) {
            return false;
        }
    }
}
