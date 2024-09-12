package com.google.android.gms.fido.u2f.api.messagebased;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
public enum RequestType {
    REGISTER("u2f_register_request"),
    SIGN("u2f_sign_request");
    
    private final String zzb;

    /* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
    public static class UnsupportedRequestTypeException extends Exception {
        public UnsupportedRequestTypeException(String str) {
            super("Unsupported request type ".concat(String.valueOf(str)));
        }
    }

    private RequestType(String str) {
        this.zzb = str;
    }

    public static RequestType fromString(String str) throws UnsupportedRequestTypeException {
        for (RequestType requestType : values()) {
            if (str.equals(requestType.zzb)) {
                return requestType;
            }
        }
        throw new UnsupportedRequestTypeException(str);
    }

    public String toString() {
        return this.zzb;
    }
}
