package bo.app;

public final class i3 {
    public static final i3 a = new i3();

    private i3() {
    }

    public static final double a(double d, double d2, double d3, double d4) {
        double radians = Math.toRadians(d3 - d);
        double radians2 = Math.toRadians(d4 - d2);
        double d5 = (double) 2;
        return Math.asin(Math.sqrt(Math.pow(Math.sin(radians / d5), 2.0d) + (Math.pow(Math.sin(radians2 / d5), 2.0d) * Math.cos(Math.toRadians(d)) * Math.cos(Math.toRadians(d3))))) * 1.2742E7d;
    }
}
