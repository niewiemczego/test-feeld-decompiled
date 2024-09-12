package io.sentry.transport;

public abstract class TransportResult {
    public abstract int getResponseCode();

    public abstract boolean isSuccess();

    public static TransportResult success() {
        return SuccessTransportResult.INSTANCE;
    }

    public static TransportResult error(int i) {
        return new ErrorTransportResult(i);
    }

    public static TransportResult error() {
        return error(-1);
    }

    private TransportResult() {
    }

    private static final class SuccessTransportResult extends TransportResult {
        static final SuccessTransportResult INSTANCE = new SuccessTransportResult();

        public int getResponseCode() {
            return -1;
        }

        public boolean isSuccess() {
            return true;
        }

        private SuccessTransportResult() {
            super();
        }
    }

    private static final class ErrorTransportResult extends TransportResult {
        private final int responseCode;

        public boolean isSuccess() {
            return false;
        }

        ErrorTransportResult(int i) {
            super();
            this.responseCode = i;
        }

        public int getResponseCode() {
            return this.responseCode;
        }
    }
}
