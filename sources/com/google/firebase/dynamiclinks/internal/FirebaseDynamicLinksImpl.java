package com.google.firebase.dynamiclinks.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks;
import com.google.firebase.inject.Provider;

public class FirebaseDynamicLinksImpl extends FirebaseDynamicLinks {
    private static final String ANALYTICS_FDL_ORIGIN = "fdl";
    public static final String EXTRA_DYNAMIC_LINK_DATA = "com.google.firebase.dynamiclinks.DYNAMIC_LINK_DATA";
    public static final String KEY_SCION_DATA = "scionData";
    private static final String TAG = "FDL";
    private final Provider<AnalyticsConnector> analytics;
    private final FirebaseApp firebaseApp;
    private final GoogleApi<Api.ApiOptions.NoOptions> googleApi;

    public FirebaseDynamicLinksImpl(FirebaseApp firebaseApp2, Provider<AnalyticsConnector> provider) {
        this(new DynamicLinksApi(firebaseApp2.getApplicationContext()), firebaseApp2, provider);
    }

    public FirebaseDynamicLinksImpl(GoogleApi<Api.ApiOptions.NoOptions> googleApi2, FirebaseApp firebaseApp2, Provider<AnalyticsConnector> provider) {
        this.googleApi = googleApi2;
        this.firebaseApp = (FirebaseApp) Preconditions.checkNotNull(firebaseApp2);
        this.analytics = provider;
        if (provider.get() == null) {
            Log.w(TAG, "FDL logging failed. Add a dependency for Firebase Analytics to your app to enable logging of Dynamic Link events.");
        }
    }

    public FirebaseApp getFirebaseApp() {
        return this.firebaseApp;
    }

    public PendingDynamicLinkData getPendingDynamicLinkData(Intent intent) {
        DynamicLinkData dynamicLinkData = (DynamicLinkData) SafeParcelableSerializer.deserializeFromIntentExtra(intent, EXTRA_DYNAMIC_LINK_DATA, DynamicLinkData.CREATOR);
        if (dynamicLinkData != null) {
            return new PendingDynamicLinkData(dynamicLinkData);
        }
        return null;
    }

    public Task<PendingDynamicLinkData> getDynamicLink(Intent intent) {
        PendingDynamicLinkData pendingDynamicLinkData;
        Task<TResult> doWrite = this.googleApi.doWrite(new GetDynamicLinkImpl(this.analytics, intent != null ? intent.getDataString() : null));
        return (intent == null || (pendingDynamicLinkData = getPendingDynamicLinkData(intent)) == null) ? doWrite : Tasks.forResult(pendingDynamicLinkData);
    }

    public Task<PendingDynamicLinkData> getDynamicLink(Uri uri) {
        return this.googleApi.doWrite(new GetDynamicLinkImpl(this.analytics, uri.toString()));
    }

    public DynamicLink.Builder createDynamicLink() {
        return new DynamicLink.Builder(this);
    }

    public static Uri createDynamicLink(Bundle bundle) {
        verifyDomainUriPrefix(bundle);
        Uri uri = (Uri) bundle.getParcelable(DynamicLink.Builder.KEY_DYNAMIC_LINK);
        if (uri != null) {
            return uri;
        }
        Uri.Builder builder = new Uri.Builder();
        Uri parse = Uri.parse((String) Preconditions.checkNotNull(bundle.getString(DynamicLink.Builder.KEY_DOMAIN_URI_PREFIX)));
        builder.scheme(parse.getScheme());
        builder.authority(parse.getAuthority());
        builder.path(parse.getPath());
        Bundle bundle2 = bundle.getBundle(DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                Object obj = bundle2.get(str);
                if (obj != null) {
                    builder.appendQueryParameter(str, obj.toString());
                }
            }
        }
        return builder.build();
    }

    public Task<ShortDynamicLink> createShortDynamicLink(Bundle bundle) {
        verifyDomainUriPrefix(bundle);
        return this.googleApi.doWrite(new CreateShortDynamicLinkImpl(bundle));
    }

    public static void verifyDomainUriPrefix(Bundle bundle) {
        Uri uri = (Uri) bundle.getParcelable(DynamicLink.Builder.KEY_DYNAMIC_LINK);
        if (TextUtils.isEmpty(bundle.getString(DynamicLink.Builder.KEY_DOMAIN_URI_PREFIX)) && uri == null) {
            throw new IllegalArgumentException("FDL domain is missing. Set with setDomainUriPrefix() or setDynamicLinkDomain().");
        }
    }

    static final class GetDynamicLinkImpl extends TaskApiCall<DynamicLinksClient, PendingDynamicLinkData> {
        private final Provider<AnalyticsConnector> analytics;
        private final String dynamicLink;

        GetDynamicLinkImpl(Provider<AnalyticsConnector> provider, String str) {
            super((Feature[]) null, false, FirebaseDynamicLinksImplConstants.GET_DYNAMIC_LINK_METHOD_KEY);
            this.dynamicLink = str;
            this.analytics = provider;
        }

        /* access modifiers changed from: protected */
        public void doExecute(DynamicLinksClient dynamicLinksClient, TaskCompletionSource<PendingDynamicLinkData> taskCompletionSource) throws RemoteException {
            dynamicLinksClient.getDynamicLink(new DynamicLinkCallbacks(this.analytics, taskCompletionSource), this.dynamicLink);
        }
    }

    static final class CreateShortDynamicLinkImpl extends TaskApiCall<DynamicLinksClient, ShortDynamicLink> {
        private final Bundle builderParameters;

        CreateShortDynamicLinkImpl(Bundle bundle) {
            super((Feature[]) null, false, FirebaseDynamicLinksImplConstants.CREATE_SHORT_DYNAMIC_LINK_METHOD_KEY);
            this.builderParameters = bundle;
        }

        /* access modifiers changed from: protected */
        public void doExecute(DynamicLinksClient dynamicLinksClient, TaskCompletionSource<ShortDynamicLink> taskCompletionSource) throws RemoteException {
            dynamicLinksClient.createShortDynamicLink(new CreateShortDynamicLinkCallbacks(taskCompletionSource), this.builderParameters);
        }
    }

    static class AbstractDynamicLinkCallbacks extends IDynamicLinksCallbacks.Stub {
        AbstractDynamicLinkCallbacks() {
        }

        public void onGetDynamicLink(Status status, DynamicLinkData dynamicLinkData) {
            throw new UnsupportedOperationException();
        }

        public void onCreateShortDynamicLink(Status status, ShortDynamicLinkImpl shortDynamicLinkImpl) {
            throw new UnsupportedOperationException();
        }
    }

    static class DynamicLinkCallbacks extends AbstractDynamicLinkCallbacks {
        private final Provider<AnalyticsConnector> analytics;
        private final TaskCompletionSource<PendingDynamicLinkData> completionSource;

        public DynamicLinkCallbacks(Provider<AnalyticsConnector> provider, TaskCompletionSource<PendingDynamicLinkData> taskCompletionSource) {
            this.analytics = provider;
            this.completionSource = taskCompletionSource;
        }

        public void onGetDynamicLink(Status status, DynamicLinkData dynamicLinkData) {
            Bundle bundle;
            AnalyticsConnector analyticsConnector;
            TaskUtil.setResultOrApiException(status, dynamicLinkData == null ? null : new PendingDynamicLinkData(dynamicLinkData), this.completionSource);
            if (dynamicLinkData != null && (bundle = dynamicLinkData.getExtensionBundle().getBundle("scionData")) != null && bundle.keySet() != null && (analyticsConnector = this.analytics.get()) != null) {
                for (String str : bundle.keySet()) {
                    analyticsConnector.logEvent(FirebaseDynamicLinksImpl.ANALYTICS_FDL_ORIGIN, str, bundle.getBundle(str));
                }
            }
        }
    }

    static class CreateShortDynamicLinkCallbacks extends AbstractDynamicLinkCallbacks {
        private final TaskCompletionSource<ShortDynamicLink> completionSource;

        CreateShortDynamicLinkCallbacks(TaskCompletionSource<ShortDynamicLink> taskCompletionSource) {
            this.completionSource = taskCompletionSource;
        }

        public void onCreateShortDynamicLink(Status status, ShortDynamicLinkImpl shortDynamicLinkImpl) {
            TaskUtil.setResultOrApiException(status, shortDynamicLinkImpl, this.completionSource);
        }
    }
}
