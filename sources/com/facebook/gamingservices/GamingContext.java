package com.facebook.gamingservices;

import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/facebook/gamingservices/GamingContext;", "", "contextID", "", "(Ljava/lang/String;)V", "getContextID", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GamingContext.kt */
public final class GamingContext {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DEFAULT_TIMEOUT = 5;
    /* access modifiers changed from: private */
    public static GamingContext currentContext;
    private final String contextID;

    public static /* synthetic */ GamingContext copy$default(GamingContext gamingContext, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gamingContext.contextID;
        }
        return gamingContext.copy(str);
    }

    @JvmStatic
    public static final GamingContext getCurrentGamingContext() {
        return Companion.getCurrentGamingContext();
    }

    @JvmStatic
    public static final void setCurrentGamingContext(GamingContext gamingContext) {
        Companion.setCurrentGamingContext(gamingContext);
    }

    public final String component1() {
        return this.contextID;
    }

    public final GamingContext copy(String str) {
        Intrinsics.checkNotNullParameter(str, "contextID");
        return new GamingContext(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GamingContext) && Intrinsics.areEqual((Object) this.contextID, (Object) ((GamingContext) obj).contextID);
    }

    public int hashCode() {
        return this.contextID.hashCode();
    }

    public String toString() {
        return "GamingContext(contextID=" + this.contextID + ')';
    }

    public GamingContext(String str) {
        Intrinsics.checkNotNullParameter(str, "contextID");
        this.contextID = str;
    }

    public final String getContextID() {
        return this.contextID;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/facebook/gamingservices/GamingContext$Companion;", "", "()V", "DEFAULT_TIMEOUT", "", "currentContext", "Lcom/facebook/gamingservices/GamingContext;", "getCurrentGamingContext", "setCurrentGamingContext", "", "ctx", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GamingContext.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GamingContext getCurrentGamingContext() {
            String str;
            JSONObject jSONObject;
            if (!CloudGameLoginHandler.isRunningInCloud()) {
                return GamingContext.currentContext;
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            GraphResponse executeAndWait = DaemonRequest.executeAndWait(FacebookSdk.getApplicationContext(), (JSONObject) null, SDKMessageEnum.CONTEXT_GET_ID, 5);
            if (executeAndWait == null || (jSONObject = executeAndWait.getJSONObject()) == null) {
                str = null;
            } else {
                str = jSONObject.getString("id");
            }
            if (str == null) {
                return null;
            }
            return new GamingContext(str);
        }

        @JvmStatic
        public final void setCurrentGamingContext(GamingContext gamingContext) {
            Intrinsics.checkNotNullParameter(gamingContext, "ctx");
            if (!CloudGameLoginHandler.isRunningInCloud()) {
                GamingContext.currentContext = gamingContext;
            }
        }
    }
}
