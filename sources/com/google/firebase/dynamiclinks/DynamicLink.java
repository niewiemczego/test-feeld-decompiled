package com.google.firebase.dynamiclinks;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.dynamiclinks.internal.FirebaseDynamicLinksImpl;

public final class DynamicLink {
    private final Bundle builderParameters;

    DynamicLink(Bundle bundle) {
        this.builderParameters = bundle;
    }

    public Uri getUri() {
        return FirebaseDynamicLinksImpl.createDynamicLink(this.builderParameters);
    }

    public static final class Builder {
        private static final String APP_GOO_GL_PATTERN = "(https:\\/\\/)?[a-z0-9]{3,}\\.app\\.goo\\.gl$";
        public static final String KEY_API_KEY = "apiKey";
        public static final String KEY_DOMAIN = "domain";
        public static final String KEY_DOMAIN_URI_PREFIX = "domainUriPrefix";
        public static final String KEY_DYNAMIC_LINK = "dynamicLink";
        public static final String KEY_DYNAMIC_LINK_PARAMETERS = "parameters";
        public static final String KEY_LINK = "link";
        public static final String KEY_SUFFIX = "suffix";
        private static final String PAGE_LINK_PATTERN = "(https:\\/\\/)?[a-z0-9]{3,}\\.page\\.link$";
        private static final String SCHEME_PREFIX = "https://";
        private final Bundle builderParameters;
        private final Bundle fdlParameters;
        private final FirebaseDynamicLinksImpl firebaseDynamicLinksImpl;

        public Builder(FirebaseDynamicLinksImpl firebaseDynamicLinksImpl2) {
            this.firebaseDynamicLinksImpl = firebaseDynamicLinksImpl2;
            Bundle bundle = new Bundle();
            this.builderParameters = bundle;
            bundle.putString(KEY_API_KEY, firebaseDynamicLinksImpl2.getFirebaseApp().getOptions().getApiKey());
            Bundle bundle2 = new Bundle();
            this.fdlParameters = bundle2;
            bundle.putBundle(KEY_DYNAMIC_LINK_PARAMETERS, bundle2);
        }

        public Builder setLongLink(Uri uri) {
            this.builderParameters.putParcelable(KEY_DYNAMIC_LINK, uri);
            return this;
        }

        public Uri getLongLink() {
            Uri uri = (Uri) this.fdlParameters.getParcelable(KEY_DYNAMIC_LINK);
            return uri == null ? Uri.EMPTY : uri;
        }

        public Builder setLink(Uri uri) {
            this.fdlParameters.putParcelable("link", uri);
            return this;
        }

        public Uri getLink() {
            Uri uri = (Uri) this.fdlParameters.getParcelable("link");
            return uri == null ? Uri.EMPTY : uri;
        }

        @Deprecated
        public Builder setDynamicLinkDomain(String str) {
            if (str.matches(APP_GOO_GL_PATTERN) || str.matches(PAGE_LINK_PATTERN)) {
                this.builderParameters.putString(KEY_DOMAIN, str);
                this.builderParameters.putString(KEY_DOMAIN_URI_PREFIX, SCHEME_PREFIX + str);
                return this;
            }
            throw new IllegalArgumentException("Use setDomainUriPrefix() instead, setDynamicLinkDomain() is only applicable for *.page.link and *.app.goo.gl domains.");
        }

        public Builder setDomainUriPrefix(String str) {
            if (str.matches(APP_GOO_GL_PATTERN) || str.matches(PAGE_LINK_PATTERN)) {
                this.builderParameters.putString(KEY_DOMAIN, str.replace(SCHEME_PREFIX, ""));
            }
            this.builderParameters.putString(KEY_DOMAIN_URI_PREFIX, str);
            return this;
        }

        public String getDomainUriPrefix() {
            return this.builderParameters.getString(KEY_DOMAIN_URI_PREFIX, "");
        }

        public Builder setAndroidParameters(AndroidParameters androidParameters) {
            this.fdlParameters.putAll(androidParameters.parameters);
            return this;
        }

        public Builder setIosParameters(IosParameters iosParameters) {
            this.fdlParameters.putAll(iosParameters.parameters);
            return this;
        }

        public Builder setGoogleAnalyticsParameters(GoogleAnalyticsParameters googleAnalyticsParameters) {
            this.fdlParameters.putAll(googleAnalyticsParameters.parameters);
            return this;
        }

        public Builder setItunesConnectAnalyticsParameters(ItunesConnectAnalyticsParameters itunesConnectAnalyticsParameters) {
            this.fdlParameters.putAll(itunesConnectAnalyticsParameters.parameters);
            return this;
        }

        public Builder setSocialMetaTagParameters(SocialMetaTagParameters socialMetaTagParameters) {
            this.fdlParameters.putAll(socialMetaTagParameters.parameters);
            return this;
        }

        public Builder setNavigationInfoParameters(NavigationInfoParameters navigationInfoParameters) {
            this.fdlParameters.putAll(navigationInfoParameters.parameters);
            return this;
        }

        public DynamicLink buildDynamicLink() {
            FirebaseDynamicLinksImpl.verifyDomainUriPrefix(this.builderParameters);
            return new DynamicLink(this.builderParameters);
        }

        public Task<ShortDynamicLink> buildShortDynamicLink() {
            verifyApiKey();
            return this.firebaseDynamicLinksImpl.createShortDynamicLink(this.builderParameters);
        }

        public Task<ShortDynamicLink> buildShortDynamicLink(int i) {
            verifyApiKey();
            this.builderParameters.putInt(KEY_SUFFIX, i);
            return this.firebaseDynamicLinksImpl.createShortDynamicLink(this.builderParameters);
        }

        private void verifyApiKey() {
            if (this.builderParameters.getString(KEY_API_KEY) == null) {
                throw new IllegalArgumentException("Missing API key. Set with setApiKey().");
            }
        }
    }

    public static final class AndroidParameters {
        public static final String KEY_ANDROID_FALLBACK_LINK = "afl";
        public static final String KEY_ANDROID_MIN_VERSION_CODE = "amv";
        public static final String KEY_ANDROID_PACKAGE_NAME = "apn";
        final Bundle parameters;

        private AndroidParameters(Bundle bundle) {
            this.parameters = bundle;
        }

        public static final class Builder {
            private final Bundle parameters;

            public Builder() {
                if (FirebaseApp.getInstance() != null) {
                    Bundle bundle = new Bundle();
                    this.parameters = bundle;
                    bundle.putString(AndroidParameters.KEY_ANDROID_PACKAGE_NAME, FirebaseApp.getInstance().getApplicationContext().getPackageName());
                    return;
                }
                throw new IllegalStateException("FirebaseApp not initialized.");
            }

            public Builder(String str) {
                Bundle bundle = new Bundle();
                this.parameters = bundle;
                bundle.putString(AndroidParameters.KEY_ANDROID_PACKAGE_NAME, str);
            }

            public Builder setFallbackUrl(Uri uri) {
                this.parameters.putParcelable(AndroidParameters.KEY_ANDROID_FALLBACK_LINK, uri);
                return this;
            }

            public Uri getFallbackUrl() {
                Uri uri = (Uri) this.parameters.getParcelable(AndroidParameters.KEY_ANDROID_FALLBACK_LINK);
                return uri == null ? Uri.EMPTY : uri;
            }

            public Builder setMinimumVersion(int i) {
                this.parameters.putInt(AndroidParameters.KEY_ANDROID_MIN_VERSION_CODE, i);
                return this;
            }

            public int getMinimumVersion() {
                return this.parameters.getInt(AndroidParameters.KEY_ANDROID_MIN_VERSION_CODE);
            }

            public AndroidParameters build() {
                return new AndroidParameters(this.parameters);
            }
        }
    }

    public static final class IosParameters {
        public static final String KEY_IOS_APP_STORE_ID = "isi";
        public static final String KEY_IOS_BUNDLE_ID = "ibi";
        public static final String KEY_IOS_CUSTOM_SCHEME = "ius";
        public static final String KEY_IOS_FALLBACK_LINK = "ifl";
        public static final String KEY_IOS_MINIMUM_VERSION = "imv";
        public static final String KEY_IPAD_BUNDLE_ID = "ipbi";
        public static final String KEY_IPAD_FALLBACK_LINK = "ipfl";
        final Bundle parameters;

        private IosParameters(Bundle bundle) {
            this.parameters = bundle;
        }

        public static final class Builder {
            private final Bundle parameters;

            public Builder(String str) {
                Bundle bundle = new Bundle();
                this.parameters = bundle;
                bundle.putString(IosParameters.KEY_IOS_BUNDLE_ID, str);
            }

            public Builder setFallbackUrl(Uri uri) {
                this.parameters.putParcelable(IosParameters.KEY_IOS_FALLBACK_LINK, uri);
                return this;
            }

            public Builder setCustomScheme(String str) {
                this.parameters.putString(IosParameters.KEY_IOS_CUSTOM_SCHEME, str);
                return this;
            }

            public String getCustomScheme() {
                return this.parameters.getString(IosParameters.KEY_IOS_CUSTOM_SCHEME, "");
            }

            public Builder setIpadFallbackUrl(Uri uri) {
                this.parameters.putParcelable(IosParameters.KEY_IPAD_FALLBACK_LINK, uri);
                return this;
            }

            public Uri getIpadFallbackUrl() {
                Uri uri = (Uri) this.parameters.getParcelable(IosParameters.KEY_IPAD_FALLBACK_LINK);
                return uri == null ? Uri.EMPTY : uri;
            }

            public Builder setIpadBundleId(String str) {
                this.parameters.putString(IosParameters.KEY_IPAD_BUNDLE_ID, str);
                return this;
            }

            public String getIpadBundleId() {
                return this.parameters.getString(IosParameters.KEY_IPAD_BUNDLE_ID, "");
            }

            public Builder setAppStoreId(String str) {
                this.parameters.putString(IosParameters.KEY_IOS_APP_STORE_ID, str);
                return this;
            }

            public String getAppStoreId() {
                return this.parameters.getString(IosParameters.KEY_IOS_APP_STORE_ID, "");
            }

            public Builder setMinimumVersion(String str) {
                this.parameters.putString(IosParameters.KEY_IOS_MINIMUM_VERSION, str);
                return this;
            }

            public String getMinimumVersion() {
                return this.parameters.getString(IosParameters.KEY_IOS_MINIMUM_VERSION, "");
            }

            public IosParameters build() {
                return new IosParameters(this.parameters);
            }
        }
    }

    public static final class GoogleAnalyticsParameters {
        public static final String KEY_UTM_CAMPAIGN = "utm_campaign";
        public static final String KEY_UTM_CONTENT = "utm_content";
        public static final String KEY_UTM_MEDIUM = "utm_medium";
        public static final String KEY_UTM_SOURCE = "utm_source";
        public static final String KEY_UTM_TERM = "utm_term";
        Bundle parameters;

        private GoogleAnalyticsParameters(Bundle bundle) {
            this.parameters = bundle;
        }

        public static final class Builder {
            private final Bundle parameters;

            public Builder() {
                this.parameters = new Bundle();
            }

            public Builder(String str, String str2, String str3) {
                Bundle bundle = new Bundle();
                this.parameters = bundle;
                bundle.putString("utm_source", str);
                bundle.putString("utm_medium", str2);
                bundle.putString("utm_campaign", str3);
            }

            public Builder setSource(String str) {
                this.parameters.putString("utm_source", str);
                return this;
            }

            public String getSource() {
                return this.parameters.getString("utm_source", "");
            }

            public Builder setMedium(String str) {
                this.parameters.putString("utm_medium", str);
                return this;
            }

            public String getMedium() {
                return this.parameters.getString("utm_medium", "");
            }

            public Builder setCampaign(String str) {
                this.parameters.putString("utm_campaign", str);
                return this;
            }

            public String getCampaign() {
                return this.parameters.getString("utm_campaign", "");
            }

            public Builder setTerm(String str) {
                this.parameters.putString(GoogleAnalyticsParameters.KEY_UTM_TERM, str);
                return this;
            }

            public String getTerm() {
                return this.parameters.getString(GoogleAnalyticsParameters.KEY_UTM_TERM, "");
            }

            public Builder setContent(String str) {
                this.parameters.putString(GoogleAnalyticsParameters.KEY_UTM_CONTENT, str);
                return this;
            }

            public String getContent() {
                return this.parameters.getString(GoogleAnalyticsParameters.KEY_UTM_CONTENT, "");
            }

            public GoogleAnalyticsParameters build() {
                return new GoogleAnalyticsParameters(this.parameters);
            }
        }
    }

    public static final class ItunesConnectAnalyticsParameters {
        public static final String KEY_ITUNES_CONNECT_AT = "at";
        public static final String KEY_ITUNES_CONNECT_CT = "ct";
        public static final String KEY_ITUNES_CONNECT_PT = "pt";
        final Bundle parameters;

        private ItunesConnectAnalyticsParameters(Bundle bundle) {
            this.parameters = bundle;
        }

        public static final class Builder {
            private final Bundle parameters = new Bundle();

            public Builder setProviderToken(String str) {
                this.parameters.putString(ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_PT, str);
                return this;
            }

            public String getProviderToken() {
                return this.parameters.getString(ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_PT, "");
            }

            public Builder setAffiliateToken(String str) {
                this.parameters.putString(ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_AT, str);
                return this;
            }

            public String getAffiliateToken() {
                return this.parameters.getString(ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_AT, "");
            }

            public Builder setCampaignToken(String str) {
                this.parameters.putString("ct", str);
                return this;
            }

            public String getCampaignToken() {
                return this.parameters.getString("ct", "");
            }

            public ItunesConnectAnalyticsParameters build() {
                return new ItunesConnectAnalyticsParameters(this.parameters);
            }
        }
    }

    public static final class SocialMetaTagParameters {
        public static final String KEY_SOCIAL_DESCRIPTION = "sd";
        public static final String KEY_SOCIAL_IMAGE_LINK = "si";
        public static final String KEY_SOCIAL_TITLE = "st";
        final Bundle parameters;

        private SocialMetaTagParameters(Bundle bundle) {
            this.parameters = bundle;
        }

        public static final class Builder {
            private final Bundle parameters = new Bundle();

            public Builder setTitle(String str) {
                this.parameters.putString("st", str);
                return this;
            }

            public String getTitle() {
                return this.parameters.getString("st", "");
            }

            public Builder setDescription(String str) {
                this.parameters.putString("sd", str);
                return this;
            }

            public String getDescription() {
                return this.parameters.getString("sd", "");
            }

            public Builder setImageUrl(Uri uri) {
                this.parameters.putParcelable(SocialMetaTagParameters.KEY_SOCIAL_IMAGE_LINK, uri);
                return this;
            }

            public Uri getImageUrl() {
                Uri uri = (Uri) this.parameters.getParcelable(SocialMetaTagParameters.KEY_SOCIAL_IMAGE_LINK);
                return uri == null ? Uri.EMPTY : uri;
            }

            public SocialMetaTagParameters build() {
                return new SocialMetaTagParameters(this.parameters);
            }
        }
    }

    public static final class NavigationInfoParameters {
        public static final String KEY_FORCED_REDIRECT = "efr";
        final Bundle parameters;

        private NavigationInfoParameters(Bundle bundle) {
            this.parameters = bundle;
        }

        public static final class Builder {
            private final Bundle parameters = new Bundle();

            public Builder setForcedRedirectEnabled(boolean z) {
                this.parameters.putInt(NavigationInfoParameters.KEY_FORCED_REDIRECT, z ? 1 : 0);
                return this;
            }

            public boolean getForcedRedirectEnabled() {
                return this.parameters.getInt(NavigationInfoParameters.KEY_FORCED_REDIRECT) == 1;
            }

            public NavigationInfoParameters build() {
                return new NavigationInfoParameters(this.parameters);
            }
        }
    }
}
