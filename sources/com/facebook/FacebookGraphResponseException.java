package com.facebook;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\u0005H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/facebook/FacebookGraphResponseException;", "Lcom/facebook/FacebookException;", "graphResponse", "Lcom/facebook/GraphResponse;", "errorMessage", "", "(Lcom/facebook/GraphResponse;Ljava/lang/String;)V", "getGraphResponse", "()Lcom/facebook/GraphResponse;", "toString", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FacebookGraphResponseException.kt */
public final class FacebookGraphResponseException extends FacebookException {
    private final GraphResponse graphResponse;

    public final GraphResponse getGraphResponse() {
        return this.graphResponse;
    }

    public FacebookGraphResponseException(GraphResponse graphResponse2, String str) {
        super(str);
        this.graphResponse = graphResponse2;
    }

    public String toString() {
        GraphResponse graphResponse2 = this.graphResponse;
        FacebookRequestError error = graphResponse2 == null ? null : graphResponse2.getError();
        StringBuilder append = new StringBuilder().append("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            append.append(message);
            append.append(" ");
        }
        if (error != null) {
            append.append("httpResponseCode: ").append(error.getRequestStatusCode()).append(", facebookErrorCode: ").append(error.getErrorCode()).append(", facebookErrorType: ").append(error.getErrorType()).append(", message: ").append(error.getErrorMessage()).append("}");
        }
        String sb = append.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "errorStringBuilder.toString()");
        return sb;
    }
}
