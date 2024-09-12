package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 #2\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001#B\u001b\b\u0016\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0002\u0010\bB\u0015\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0010\nB\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0002\u0010\fB%\b\u0016\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0002\u0010\u000fB\u001f\b\u0016\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0010\u0010B\u0017\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0002\u0010\u0011J)\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\"\u00020\u0002H\u0017¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014J\b\u0010 \u001a\u00020\u001eH\u0017J\b\u0010!\u001a\u00020\"H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R.\u0010\u0015\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00142\u000e\u0010\u0012\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lcom/facebook/GraphRequestAsyncTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "Lcom/facebook/GraphResponse;", "requests", "", "Lcom/facebook/GraphRequest;", "([Lcom/facebook/GraphRequest;)V", "", "(Ljava/util/Collection;)V", "Lcom/facebook/GraphRequestBatch;", "(Lcom/facebook/GraphRequestBatch;)V", "connection", "Ljava/net/HttpURLConnection;", "(Ljava/net/HttpURLConnection;[Lcom/facebook/GraphRequest;)V", "(Ljava/net/HttpURLConnection;Ljava/util/Collection;)V", "(Ljava/net/HttpURLConnection;Lcom/facebook/GraphRequestBatch;)V", "<set-?>", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "getException", "()Ljava/lang/Exception;", "getRequests", "()Lcom/facebook/GraphRequestBatch;", "doInBackground", "params", "([Ljava/lang/Void;)Ljava/util/List;", "onPostExecute", "", "result", "onPreExecute", "toString", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GraphRequestAsyncTask.kt */
public class GraphRequestAsyncTask extends AsyncTask<Void, Void, List<? extends GraphResponse>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = GraphRequestAsyncTask.class.getCanonicalName();
    private final HttpURLConnection connection;
    private Exception exception;
    private final GraphRequestBatch requests;

    public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            return doInBackground((Void[]) objArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    onPostExecute((List<GraphResponse>) (List) obj);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final GraphRequestBatch getRequests() {
        return this.requests;
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
        this.connection = httpURLConnection;
        this.requests = graphRequestBatch;
    }

    /* access modifiers changed from: protected */
    public final Exception getException() {
        return this.exception;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/GraphRequestAsyncTask$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphRequestAsyncTask.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(GraphRequest... graphRequestArr) {
        this((HttpURLConnection) null, new GraphRequestBatch((GraphRequest[]) Arrays.copyOf(graphRequestArr, graphRequestArr.length)));
        Intrinsics.checkNotNullParameter(graphRequestArr, "requests");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(Collection<GraphRequest> collection) {
        this((HttpURLConnection) null, new GraphRequestBatch(collection));
        Intrinsics.checkNotNullParameter(collection, "requests");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(GraphRequestBatch graphRequestBatch) {
        this((HttpURLConnection) null, graphRequestBatch);
        Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequest... graphRequestArr) {
        this(httpURLConnection, new GraphRequestBatch((GraphRequest[]) Arrays.copyOf(graphRequestArr, graphRequestArr.length)));
        Intrinsics.checkNotNullParameter(graphRequestArr, "requests");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, Collection<GraphRequest> collection) {
        this(httpURLConnection, new GraphRequestBatch(collection));
        Intrinsics.checkNotNullParameter(collection, "requests");
    }

    public String toString() {
        String str = "{RequestAsyncTask: " + " connection: " + this.connection + ", requests: " + this.requests + "}";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder()\n        .append(\"{RequestAsyncTask: \")\n        .append(\" connection: \")\n        .append(connection)\n        .append(\", requests: \")\n        .append(requests)\n        .append(\"}\")\n        .toString()");
        return str;
    }

    public void onPreExecute() {
        Handler handler;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    super.onPreExecute();
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    if (FacebookSdk.isDebugEnabled()) {
                        Utility utility = Utility.INSTANCE;
                        String str = TAG;
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("execute async task: %s", Arrays.copyOf(new Object[]{this}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                        Utility.logd(str, format);
                    }
                    if (this.requests.getCallbackHandler() == null) {
                        if (Thread.currentThread() instanceof HandlerThread) {
                            handler = new Handler();
                        } else {
                            handler = new Handler(Looper.getMainLooper());
                        }
                        this.requests.setCallbackHandler(handler);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(List<GraphResponse> list) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    Intrinsics.checkNotNullParameter(list, "result");
                    super.onPostExecute(list);
                    Exception exc = this.exception;
                    if (exc != null) {
                        Utility utility = Utility.INSTANCE;
                        String str = TAG;
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("onPostExecute: exception encountered during request: %s", Arrays.copyOf(new Object[]{exc.getMessage()}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                        Utility.logd(str, format);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public List<GraphResponse> doInBackground(Void... voidArr) {
        List<GraphResponse> executeConnectionAndWait;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(voidArr, "params");
                if (this.connection == null) {
                    executeConnectionAndWait = this.requests.executeAndWait();
                } else {
                    executeConnectionAndWait = GraphRequest.Companion.executeConnectionAndWait(this.connection, this.requests);
                }
                return executeConnectionAndWait;
            } catch (Exception e) {
                this.exception = e;
                List list = null;
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }
}
