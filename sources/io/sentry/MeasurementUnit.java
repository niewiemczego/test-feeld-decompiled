package io.sentry;

import java.util.Locale;

public interface MeasurementUnit {
    public static final String NONE = "none";

    String apiName();

    String name();

    public enum Duration implements MeasurementUnit {
        NANOSECOND,
        MICROSECOND,
        MILLISECOND,
        SECOND,
        MINUTE,
        HOUR,
        DAY,
        WEEK;

        public String apiName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }

    public enum Information implements MeasurementUnit {
        BIT,
        BYTE,
        KILOBYTE,
        KIBIBYTE,
        MEGABYTE,
        MEBIBYTE,
        GIGABYTE,
        GIBIBYTE,
        TERABYTE,
        TEBIBYTE,
        PETABYTE,
        PEBIBYTE,
        EXABYTE,
        EXBIBYTE;

        public String apiName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }

    public enum Fraction implements MeasurementUnit {
        RATIO,
        PERCENT;

        public String apiName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }

    public static final class Custom implements MeasurementUnit {
        private final String name;

        public Custom(String str) {
            this.name = str;
        }

        public String name() {
            return this.name;
        }

        public String apiName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }
}
