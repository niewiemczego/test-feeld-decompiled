package com.facebook.appevents.cloudbridge;

import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.cloudbridge.AppEventType;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001:\u00042345B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0001\u0010\u000e\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00132\u0018\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00060\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\b\u0018JJ\u0010\u0019\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006\u0018\u00010\u000f2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\u0018\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00060\u000fH\u0002J:\u0010\u001b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006\u0018\u00010\u000f2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002JU\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006H\u0000¢\u0006\u0002\b\u001dJ5\u0010\u001e\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006\u0018\u00010\u000f2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006H\u0000¢\u0006\u0002\b J\u0001\u0010!\u001a\u00020\u00112\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00132.\u0010\u0016\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00060\"j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006`#2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0013H\u0002JE\u0010$\u001a\u00020%2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u0001H\u0000¢\u0006\u0002\b(J,\u0010)\u001a\u00020%2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u0001H\u0002J,\u0010*\u001a\u00020%2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u0001H\u0002J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004H\u0002JA\u0010-\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006\u0018\u00010\"j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006\u0018\u0001`#2\u0006\u0010.\u001a\u00020\u0004H\u0001¢\u0006\u0002\b/J\u001f\u00100\u001a\u0004\u0018\u00010\u00012\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0001H\u0001¢\u0006\u0002\b1R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer;", "", "()V", "TAG", "", "customEventTransformations", "", "Lcom/facebook/appevents/cloudbridge/CustomEventField;", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$SectionCustomEventFieldMapping;", "standardEventTransformations", "Lcom/facebook/appevents/cloudbridge/ConversionsAPIEventName;", "topLevelTransformations", "Lcom/facebook/appevents/cloudbridge/AppEventUserAndAppDataField;", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$SectionFieldMapping;", "combineAllTransformedData", "", "eventType", "Lcom/facebook/appevents/cloudbridge/AppEventType;", "userData", "", "appData", "restOfData", "customEvents", "eventTime", "combineAllTransformedData$facebook_core_release", "combineAllTransformedDataForCustom", "commonFields", "combineAllTransformedDataForMobileAppInstall", "combineCommonFields", "combineCommonFields$facebook_core_release", "conversionsAPICompatibleEvent", "parameters", "conversionsAPICompatibleEvent$facebook_core_release", "splitAppEventParameters", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "transformAndUpdateAppAndUserData", "", "field", "value", "transformAndUpdateAppAndUserData$facebook_core_release", "transformAndUpdateAppData", "transformAndUpdateUserData", "transformEventName", "input", "transformEvents", "appEvents", "transformEvents$facebook_core_release", "transformValue", "transformValue$facebook_core_release", "DataProcessingParameterName", "SectionCustomEventFieldMapping", "SectionFieldMapping", "ValueTransformationType", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppEventsConversionsAPITransformer.kt */
public final class AppEventsConversionsAPITransformer {
    public static final AppEventsConversionsAPITransformer INSTANCE = new AppEventsConversionsAPITransformer();
    public static final String TAG = "AppEventsConversionsAPITransformer";
    public static final Map<CustomEventField, SectionCustomEventFieldMapping> customEventTransformations = MapsKt.mapOf(TuplesKt.to(CustomEventField.EVENT_TIME, new SectionCustomEventFieldMapping((ConversionsAPISection) null, ConversionsAPICustomEventField.EVENT_TIME)), TuplesKt.to(CustomEventField.EVENT_NAME, new SectionCustomEventFieldMapping((ConversionsAPISection) null, ConversionsAPICustomEventField.EVENT_NAME)), TuplesKt.to(CustomEventField.VALUE_TO_SUM, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.VALUE_TO_SUM)), TuplesKt.to(CustomEventField.CONTENT_IDS, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.CONTENT_IDS)), TuplesKt.to(CustomEventField.CONTENTS, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.CONTENTS)), TuplesKt.to(CustomEventField.CONTENT_TYPE, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.CONTENT_TYPE)), TuplesKt.to(CustomEventField.CURRENCY, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.CURRENCY)), TuplesKt.to(CustomEventField.DESCRIPTION, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.DESCRIPTION)), TuplesKt.to(CustomEventField.LEVEL, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.LEVEL)), TuplesKt.to(CustomEventField.MAX_RATING_VALUE, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.MAX_RATING_VALUE)), TuplesKt.to(CustomEventField.NUM_ITEMS, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.NUM_ITEMS)), TuplesKt.to(CustomEventField.PAYMENT_INFO_AVAILABLE, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.PAYMENT_INFO_AVAILABLE)), TuplesKt.to(CustomEventField.REGISTRATION_METHOD, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.REGISTRATION_METHOD)), TuplesKt.to(CustomEventField.SEARCH_STRING, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.SEARCH_STRING)), TuplesKt.to(CustomEventField.SUCCESS, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.SUCCESS)), TuplesKt.to(CustomEventField.ORDER_ID, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.ORDER_ID)), TuplesKt.to(CustomEventField.AD_TYPE, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.AD_TYPE)));
    public static final Map<String, ConversionsAPIEventName> standardEventTransformations = MapsKt.mapOf(TuplesKt.to(AppEventsConstants.EVENT_NAME_UNLOCKED_ACHIEVEMENT, ConversionsAPIEventName.UNLOCKED_ACHIEVEMENT), TuplesKt.to(AppEventsConstants.EVENT_NAME_ACTIVATED_APP, ConversionsAPIEventName.ACTIVATED_APP), TuplesKt.to(AppEventsConstants.EVENT_NAME_ADDED_PAYMENT_INFO, ConversionsAPIEventName.ADDED_PAYMENT_INFO), TuplesKt.to(AppEventsConstants.EVENT_NAME_ADDED_TO_CART, ConversionsAPIEventName.ADDED_TO_CART), TuplesKt.to(AppEventsConstants.EVENT_NAME_ADDED_TO_WISHLIST, ConversionsAPIEventName.ADDED_TO_WISHLIST), TuplesKt.to(AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, ConversionsAPIEventName.COMPLETED_REGISTRATION), TuplesKt.to(AppEventsConstants.EVENT_NAME_VIEWED_CONTENT, ConversionsAPIEventName.VIEWED_CONTENT), TuplesKt.to(AppEventsConstants.EVENT_NAME_INITIATED_CHECKOUT, ConversionsAPIEventName.INITIATED_CHECKOUT), TuplesKt.to(AppEventsConstants.EVENT_NAME_ACHIEVED_LEVEL, ConversionsAPIEventName.ACHIEVED_LEVEL), TuplesKt.to(AppEventsConstants.EVENT_NAME_PURCHASED, ConversionsAPIEventName.PURCHASED), TuplesKt.to(AppEventsConstants.EVENT_NAME_RATED, ConversionsAPIEventName.RATED), TuplesKt.to(AppEventsConstants.EVENT_NAME_SEARCHED, ConversionsAPIEventName.SEARCHED), TuplesKt.to(AppEventsConstants.EVENT_NAME_SPENT_CREDITS, ConversionsAPIEventName.SPENT_CREDITS), TuplesKt.to(AppEventsConstants.EVENT_NAME_COMPLETED_TUTORIAL, ConversionsAPIEventName.COMPLETED_TUTORIAL));
    private static final Map<AppEventUserAndAppDataField, SectionFieldMapping> topLevelTransformations = MapsKt.mapOf(TuplesKt.to(AppEventUserAndAppDataField.ANON_ID, new SectionFieldMapping(ConversionsAPISection.USER_DATA, ConversionsAPIUserAndAppDataField.ANON_ID)), TuplesKt.to(AppEventUserAndAppDataField.APP_USER_ID, new SectionFieldMapping(ConversionsAPISection.USER_DATA, ConversionsAPIUserAndAppDataField.FB_LOGIN_ID)), TuplesKt.to(AppEventUserAndAppDataField.ADVERTISER_ID, new SectionFieldMapping(ConversionsAPISection.USER_DATA, ConversionsAPIUserAndAppDataField.MAD_ID)), TuplesKt.to(AppEventUserAndAppDataField.PAGE_ID, new SectionFieldMapping(ConversionsAPISection.USER_DATA, ConversionsAPIUserAndAppDataField.PAGE_ID)), TuplesKt.to(AppEventUserAndAppDataField.PAGE_SCOPED_USER_ID, new SectionFieldMapping(ConversionsAPISection.USER_DATA, ConversionsAPIUserAndAppDataField.PAGE_SCOPED_USER_ID)), TuplesKt.to(AppEventUserAndAppDataField.ADV_TE, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.ADV_TE)), TuplesKt.to(AppEventUserAndAppDataField.APP_TE, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.APP_TE)), TuplesKt.to(AppEventUserAndAppDataField.CONSIDER_VIEWS, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.CONSIDER_VIEWS)), TuplesKt.to(AppEventUserAndAppDataField.DEVICE_TOKEN, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.DEVICE_TOKEN)), TuplesKt.to(AppEventUserAndAppDataField.EXT_INFO, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.EXT_INFO)), TuplesKt.to(AppEventUserAndAppDataField.INCLUDE_DWELL_DATA, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.INCLUDE_DWELL_DATA)), TuplesKt.to(AppEventUserAndAppDataField.INCLUDE_VIDEO_DATA, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.INCLUDE_VIDEO_DATA)), TuplesKt.to(AppEventUserAndAppDataField.INSTALL_REFERRER, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.INSTALL_REFERRER)), TuplesKt.to(AppEventUserAndAppDataField.INSTALLER_PACKAGE, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.INSTALLER_PACKAGE)), TuplesKt.to(AppEventUserAndAppDataField.RECEIPT_DATA, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.RECEIPT_DATA)), TuplesKt.to(AppEventUserAndAppDataField.URL_SCHEMES, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.URL_SCHEMES)), TuplesKt.to(AppEventUserAndAppDataField.USER_DATA, new SectionFieldMapping(ConversionsAPISection.USER_DATA, (ConversionsAPIUserAndAppDataField) null)));

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AppEventsConversionsAPITransformer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ValueTransformationType.values().length];
            iArr[ValueTransformationType.ARRAY.ordinal()] = 1;
            iArr[ValueTransformationType.BOOL.ordinal()] = 2;
            iArr[ValueTransformationType.INT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ConversionsAPISection.values().length];
            iArr2[ConversionsAPISection.APP_DATA.ordinal()] = 1;
            iArr2[ConversionsAPISection.USER_DATA.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[AppEventType.values().length];
            iArr3[AppEventType.MOBILE_APP_INSTALL.ordinal()] = 1;
            iArr3[AppEventType.CUSTOM.ordinal()] = 2;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    private AppEventsConversionsAPITransformer() {
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$SectionFieldMapping;", "", "section", "Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;", "field", "Lcom/facebook/appevents/cloudbridge/ConversionsAPIUserAndAppDataField;", "(Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;Lcom/facebook/appevents/cloudbridge/ConversionsAPIUserAndAppDataField;)V", "getField", "()Lcom/facebook/appevents/cloudbridge/ConversionsAPIUserAndAppDataField;", "setField", "(Lcom/facebook/appevents/cloudbridge/ConversionsAPIUserAndAppDataField;)V", "getSection", "()Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;", "setSection", "(Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AppEventsConversionsAPITransformer.kt */
    public static final class SectionFieldMapping {
        private ConversionsAPIUserAndAppDataField field;
        private ConversionsAPISection section;

        public static /* synthetic */ SectionFieldMapping copy$default(SectionFieldMapping sectionFieldMapping, ConversionsAPISection conversionsAPISection, ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField, int i, Object obj) {
            if ((i & 1) != 0) {
                conversionsAPISection = sectionFieldMapping.section;
            }
            if ((i & 2) != 0) {
                conversionsAPIUserAndAppDataField = sectionFieldMapping.field;
            }
            return sectionFieldMapping.copy(conversionsAPISection, conversionsAPIUserAndAppDataField);
        }

        public final ConversionsAPISection component1() {
            return this.section;
        }

        public final ConversionsAPIUserAndAppDataField component2() {
            return this.field;
        }

        public final SectionFieldMapping copy(ConversionsAPISection conversionsAPISection, ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField) {
            Intrinsics.checkNotNullParameter(conversionsAPISection, "section");
            return new SectionFieldMapping(conversionsAPISection, conversionsAPIUserAndAppDataField);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SectionFieldMapping)) {
                return false;
            }
            SectionFieldMapping sectionFieldMapping = (SectionFieldMapping) obj;
            return this.section == sectionFieldMapping.section && this.field == sectionFieldMapping.field;
        }

        public int hashCode() {
            int hashCode = this.section.hashCode() * 31;
            ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField = this.field;
            return hashCode + (conversionsAPIUserAndAppDataField == null ? 0 : conversionsAPIUserAndAppDataField.hashCode());
        }

        public String toString() {
            return "SectionFieldMapping(section=" + this.section + ", field=" + this.field + ')';
        }

        public SectionFieldMapping(ConversionsAPISection conversionsAPISection, ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField) {
            Intrinsics.checkNotNullParameter(conversionsAPISection, "section");
            this.section = conversionsAPISection;
            this.field = conversionsAPIUserAndAppDataField;
        }

        public final ConversionsAPISection getSection() {
            return this.section;
        }

        public final void setSection(ConversionsAPISection conversionsAPISection) {
            Intrinsics.checkNotNullParameter(conversionsAPISection, "<set-?>");
            this.section = conversionsAPISection;
        }

        public final ConversionsAPIUserAndAppDataField getField() {
            return this.field;
        }

        public final void setField(ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField) {
            this.field = conversionsAPIUserAndAppDataField;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$SectionCustomEventFieldMapping;", "", "section", "Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;", "field", "Lcom/facebook/appevents/cloudbridge/ConversionsAPICustomEventField;", "(Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;Lcom/facebook/appevents/cloudbridge/ConversionsAPICustomEventField;)V", "getField", "()Lcom/facebook/appevents/cloudbridge/ConversionsAPICustomEventField;", "setField", "(Lcom/facebook/appevents/cloudbridge/ConversionsAPICustomEventField;)V", "getSection", "()Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;", "setSection", "(Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AppEventsConversionsAPITransformer.kt */
    public static final class SectionCustomEventFieldMapping {
        private ConversionsAPICustomEventField field;
        private ConversionsAPISection section;

        public static /* synthetic */ SectionCustomEventFieldMapping copy$default(SectionCustomEventFieldMapping sectionCustomEventFieldMapping, ConversionsAPISection conversionsAPISection, ConversionsAPICustomEventField conversionsAPICustomEventField, int i, Object obj) {
            if ((i & 1) != 0) {
                conversionsAPISection = sectionCustomEventFieldMapping.section;
            }
            if ((i & 2) != 0) {
                conversionsAPICustomEventField = sectionCustomEventFieldMapping.field;
            }
            return sectionCustomEventFieldMapping.copy(conversionsAPISection, conversionsAPICustomEventField);
        }

        public final ConversionsAPISection component1() {
            return this.section;
        }

        public final ConversionsAPICustomEventField component2() {
            return this.field;
        }

        public final SectionCustomEventFieldMapping copy(ConversionsAPISection conversionsAPISection, ConversionsAPICustomEventField conversionsAPICustomEventField) {
            Intrinsics.checkNotNullParameter(conversionsAPICustomEventField, "field");
            return new SectionCustomEventFieldMapping(conversionsAPISection, conversionsAPICustomEventField);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SectionCustomEventFieldMapping)) {
                return false;
            }
            SectionCustomEventFieldMapping sectionCustomEventFieldMapping = (SectionCustomEventFieldMapping) obj;
            return this.section == sectionCustomEventFieldMapping.section && this.field == sectionCustomEventFieldMapping.field;
        }

        public int hashCode() {
            ConversionsAPISection conversionsAPISection = this.section;
            return ((conversionsAPISection == null ? 0 : conversionsAPISection.hashCode()) * 31) + this.field.hashCode();
        }

        public String toString() {
            return "SectionCustomEventFieldMapping(section=" + this.section + ", field=" + this.field + ')';
        }

        public SectionCustomEventFieldMapping(ConversionsAPISection conversionsAPISection, ConversionsAPICustomEventField conversionsAPICustomEventField) {
            Intrinsics.checkNotNullParameter(conversionsAPICustomEventField, "field");
            this.section = conversionsAPISection;
            this.field = conversionsAPICustomEventField;
        }

        public final ConversionsAPISection getSection() {
            return this.section;
        }

        public final void setSection(ConversionsAPISection conversionsAPISection) {
            this.section = conversionsAPISection;
        }

        public final ConversionsAPICustomEventField getField() {
            return this.field;
        }

        public final void setField(ConversionsAPICustomEventField conversionsAPICustomEventField) {
            Intrinsics.checkNotNullParameter(conversionsAPICustomEventField, "<set-?>");
            this.field = conversionsAPICustomEventField;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$DataProcessingParameterName;", "", "rawValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "OPTIONS", "COUNTRY", "STATE", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AppEventsConversionsAPITransformer.kt */
    public enum DataProcessingParameterName {
        OPTIONS(FacebookSdk.DATA_PROCESSION_OPTIONS),
        COUNTRY(FacebookSdk.DATA_PROCESSION_OPTIONS_COUNTRY),
        STATE(FacebookSdk.DATA_PROCESSION_OPTIONS_STATE);
        
        public static final Companion Companion = null;
        private final String rawValue;

        private DataProcessingParameterName(String str) {
            this.rawValue = str;
        }

        public final String getRawValue() {
            return this.rawValue;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$DataProcessingParameterName$Companion;", "", "()V", "invoke", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$DataProcessingParameterName;", "rawValue", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: AppEventsConversionsAPITransformer.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final DataProcessingParameterName invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "rawValue");
                for (DataProcessingParameterName dataProcessingParameterName : DataProcessingParameterName.values()) {
                    if (Intrinsics.areEqual((Object) dataProcessingParameterName.getRawValue(), (Object) str)) {
                        return dataProcessingParameterName;
                    }
                }
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$ValueTransformationType;", "", "(Ljava/lang/String;I)V", "ARRAY", "BOOL", "INT", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AppEventsConversionsAPITransformer.kt */
    public enum ValueTransformationType {
        ARRAY,
        BOOL,
        INT;
        
        public static final Companion Companion = null;

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$ValueTransformationType$Companion;", "", "()V", "invoke", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$ValueTransformationType;", "rawValue", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: AppEventsConversionsAPITransformer.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ValueTransformationType invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "rawValue");
                Companion companion = this;
                if (Intrinsics.areEqual((Object) str, (Object) AppEventUserAndAppDataField.EXT_INFO.getRawValue())) {
                    return ValueTransformationType.ARRAY;
                }
                if (Intrinsics.areEqual((Object) str, (Object) AppEventUserAndAppDataField.URL_SCHEMES.getRawValue())) {
                    return ValueTransformationType.ARRAY;
                }
                if (Intrinsics.areEqual((Object) str, (Object) CustomEventField.CONTENT_IDS.getRawValue())) {
                    return ValueTransformationType.ARRAY;
                }
                if (Intrinsics.areEqual((Object) str, (Object) CustomEventField.CONTENTS.getRawValue())) {
                    return ValueTransformationType.ARRAY;
                }
                if (Intrinsics.areEqual((Object) str, (Object) DataProcessingParameterName.OPTIONS.getRawValue())) {
                    return ValueTransformationType.ARRAY;
                }
                if (Intrinsics.areEqual((Object) str, (Object) AppEventUserAndAppDataField.ADV_TE.getRawValue())) {
                    return ValueTransformationType.BOOL;
                }
                if (Intrinsics.areEqual((Object) str, (Object) AppEventUserAndAppDataField.APP_TE.getRawValue())) {
                    return ValueTransformationType.BOOL;
                }
                if (Intrinsics.areEqual((Object) str, (Object) CustomEventField.EVENT_TIME.getRawValue())) {
                    return ValueTransformationType.INT;
                }
                return null;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:29|30) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:26|27|28|31|32|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0089, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r5 = com.facebook.internal.Utility.INSTANCE;
        r1 = com.facebook.internal.Utility.convertJSONArrayToList(new org.json.JSONArray(r1));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0089 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0094 */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object transformValue$facebook_core_release(java.lang.String r6, java.lang.Object r7) {
        /*
            java.lang.String r0 = "field"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer$ValueTransformationType$Companion r0 = com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.ValueTransformationType.Companion
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer$ValueTransformationType r6 = r0.invoke(r6)
            boolean r0 = r7 instanceof java.lang.String
            r1 = 0
            if (r0 == 0) goto L_0x0019
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x001a
        L_0x0019:
            r0 = r1
        L_0x001a:
            if (r6 == 0) goto L_0x00ae
            if (r0 != 0) goto L_0x0020
            goto L_0x00ae
        L_0x0020:
            int[] r2 = com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r2[r6]
            r2 = 0
            r3 = 2
            r4 = 1
            if (r6 == r4) goto L_0x005b
            if (r6 == r3) goto L_0x0041
            r0 = 3
            if (r6 != r0) goto L_0x003b
            java.lang.String r6 = r7.toString()
            java.lang.Integer r6 = kotlin.text.StringsKt.toIntOrNull(r6)
            return r6
        L_0x003b:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L_0x0041:
            java.lang.String r6 = r0.toString()
            java.lang.Integer r6 = kotlin.text.StringsKt.toIntOrNull(r6)
            if (r6 == 0) goto L_0x0057
            int r6 = r6.intValue()
            if (r6 == 0) goto L_0x0052
            r2 = r4
        L_0x0052:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            goto L_0x005a
        L_0x0057:
            r6 = r1
            java.lang.Boolean r6 = (java.lang.Boolean) r6
        L_0x005a:
            return r1
        L_0x005b:
            com.facebook.internal.Utility r6 = com.facebook.internal.Utility.INSTANCE     // Catch:{ JSONException -> 0x0099 }
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0099 }
            r6.<init>((java.lang.String) r0)     // Catch:{ JSONException -> 0x0099 }
            java.util.List r6 = com.facebook.internal.Utility.convertJSONArrayToList(r6)     // Catch:{ JSONException -> 0x0099 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0099 }
            r0.<init>()     // Catch:{ JSONException -> 0x0099 }
            java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ JSONException -> 0x0099 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ JSONException -> 0x0099 }
        L_0x0071:
            boolean r1 = r6.hasNext()     // Catch:{ JSONException -> 0x0099 }
            if (r1 == 0) goto L_0x0098
            java.lang.Object r1 = r6.next()     // Catch:{ JSONException -> 0x0099 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ JSONException -> 0x0099 }
            com.facebook.internal.Utility r5 = com.facebook.internal.Utility.INSTANCE     // Catch:{ JSONException -> 0x0089 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0089 }
            r5.<init>((java.lang.String) r1)     // Catch:{ JSONException -> 0x0089 }
            java.util.Map r1 = com.facebook.internal.Utility.convertJSONObjectToHashMap(r5)     // Catch:{ JSONException -> 0x0089 }
            goto L_0x0094
        L_0x0089:
            com.facebook.internal.Utility r5 = com.facebook.internal.Utility.INSTANCE     // Catch:{ JSONException -> 0x0094 }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0094 }
            r5.<init>((java.lang.String) r1)     // Catch:{ JSONException -> 0x0094 }
            java.util.List r1 = com.facebook.internal.Utility.convertJSONArrayToList(r5)     // Catch:{ JSONException -> 0x0094 }
        L_0x0094:
            r0.add(r1)     // Catch:{ JSONException -> 0x0099 }
            goto L_0x0071
        L_0x0098:
            return r0
        L_0x0099:
            r6 = move-exception
            com.facebook.internal.Logger$Companion r0 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r1 = com.facebook.LoggingBehavior.APP_EVENTS
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r7
            r3[r4] = r6
            java.lang.String r6 = "AppEventsConversionsAPITransformer"
            java.lang.String r7 = "\n transformEvents JSONException: \n%s\n%s"
            r0.log((com.facebook.LoggingBehavior) r1, (java.lang.String) r6, (java.lang.String) r7, (java.lang.Object[]) r3)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x00ae:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.transformValue$facebook_core_release(java.lang.String, java.lang.Object):java.lang.Object");
    }

    @JvmStatic
    public static final ArrayList<Map<String, Object>> transformEvents$facebook_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "appEvents");
        ArrayList<Map> arrayList = new ArrayList<>();
        try {
            Utility utility = Utility.INSTANCE;
            for (String jSONObject : Utility.convertJSONArrayToList(new JSONArray(str))) {
                Utility utility2 = Utility.INSTANCE;
                arrayList.add(Utility.convertJSONObjectToHashMap(new JSONObject(jSONObject)));
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            ArrayList<Map<String, Object>> arrayList2 = new ArrayList<>();
            for (Map map : arrayList) {
                Map linkedHashMap = new LinkedHashMap();
                Map linkedHashMap2 = new LinkedHashMap();
                for (String str2 : map.keySet()) {
                    CustomEventField invoke = CustomEventField.Companion.invoke(str2);
                    SectionCustomEventFieldMapping sectionCustomEventFieldMapping = customEventTransformations.get(invoke);
                    if (!(invoke == null || sectionCustomEventFieldMapping == null)) {
                        ConversionsAPISection section = sectionCustomEventFieldMapping.getSection();
                        if (section == null) {
                            try {
                                String rawValue = sectionCustomEventFieldMapping.getField().getRawValue();
                                if (invoke == CustomEventField.EVENT_NAME && ((String) map.get(str2)) != null) {
                                    AppEventsConversionsAPITransformer appEventsConversionsAPITransformer = INSTANCE;
                                    Object obj = map.get(str2);
                                    if (obj != null) {
                                        linkedHashMap2.put(rawValue, appEventsConversionsAPITransformer.transformEventName((String) obj));
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                } else if (invoke == CustomEventField.EVENT_TIME && ((Integer) map.get(str2)) != null) {
                                    Object obj2 = map.get(str2);
                                    if (obj2 != null) {
                                        Object transformValue$facebook_core_release = transformValue$facebook_core_release(str2, obj2);
                                        if (transformValue$facebook_core_release != null) {
                                            linkedHashMap2.put(rawValue, transformValue$facebook_core_release);
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                        }
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                    }
                                }
                            } catch (ClassCastException e) {
                                Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "\n transformEvents ClassCastException: \n %s ", ExceptionsKt.stackTraceToString(e));
                            }
                        } else if (section == ConversionsAPISection.CUSTOM_DATA) {
                            String rawValue2 = sectionCustomEventFieldMapping.getField().getRawValue();
                            Object obj3 = map.get(str2);
                            if (obj3 != null) {
                                Object transformValue$facebook_core_release2 = transformValue$facebook_core_release(str2, obj3);
                                if (transformValue$facebook_core_release2 != null) {
                                    linkedHashMap.put(rawValue2, transformValue$facebook_core_release2);
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (!linkedHashMap.isEmpty()) {
                    linkedHashMap2.put(ConversionsAPISection.CUSTOM_DATA.getRawValue(), linkedHashMap);
                }
                arrayList2.add(linkedHashMap2);
            }
            return arrayList2;
        } catch (JSONException e2) {
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "\n transformEvents JSONException: \n%s\n%s", str, e2);
            return null;
        }
    }

    private final void transformAndUpdateAppData(Map<String, Object> map, AppEventUserAndAppDataField appEventUserAndAppDataField, Object obj) {
        SectionFieldMapping sectionFieldMapping = topLevelTransformations.get(appEventUserAndAppDataField);
        ConversionsAPIUserAndAppDataField field = sectionFieldMapping == null ? null : sectionFieldMapping.getField();
        if (field != null) {
            map.put(field.getRawValue(), obj);
        }
    }

    private final void transformAndUpdateUserData(Map<String, Object> map, AppEventUserAndAppDataField appEventUserAndAppDataField, Object obj) {
        if (appEventUserAndAppDataField == AppEventUserAndAppDataField.USER_DATA) {
            try {
                Utility utility = Utility.INSTANCE;
                map.putAll(Utility.convertJSONObjectToHashMap(new JSONObject((String) obj)));
            } catch (JSONException e) {
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "\n transformEvents JSONException: \n%s\n%s", obj, e);
            }
        } else {
            SectionFieldMapping sectionFieldMapping = topLevelTransformations.get(appEventUserAndAppDataField);
            ConversionsAPIUserAndAppDataField field = sectionFieldMapping == null ? null : sectionFieldMapping.getField();
            if (field != null) {
                map.put(field.getRawValue(), obj);
            }
        }
    }

    public final void transformAndUpdateAppAndUserData$facebook_core_release(Map<String, Object> map, Map<String, Object> map2, AppEventUserAndAppDataField appEventUserAndAppDataField, Object obj) {
        Intrinsics.checkNotNullParameter(map, "userData");
        Intrinsics.checkNotNullParameter(map2, "appData");
        Intrinsics.checkNotNullParameter(appEventUserAndAppDataField, "field");
        Intrinsics.checkNotNullParameter(obj, "value");
        SectionFieldMapping sectionFieldMapping = topLevelTransformations.get(appEventUserAndAppDataField);
        if (sectionFieldMapping != null) {
            int i = WhenMappings.$EnumSwitchMapping$1[sectionFieldMapping.getSection().ordinal()];
            if (i == 1) {
                transformAndUpdateAppData(map2, appEventUserAndAppDataField, obj);
            } else if (i == 2) {
                transformAndUpdateUserData(map, appEventUserAndAppDataField, obj);
            }
        }
    }

    private final String transformEventName(String str) {
        Map<String, ConversionsAPIEventName> map = standardEventTransformations;
        if (!map.containsKey(str)) {
            return str;
        }
        ConversionsAPIEventName conversionsAPIEventName = map.get(str);
        return conversionsAPIEventName == null ? "" : conversionsAPIEventName.getRawValue();
    }

    public final Map<String, Object> combineCommonFields$facebook_core_release(Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Map<String, ? extends Object> map3) {
        Intrinsics.checkNotNullParameter(map, "userData");
        Intrinsics.checkNotNullParameter(map2, "appData");
        Intrinsics.checkNotNullParameter(map3, "restOfData");
        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(OtherEventConstants.ACTION_SOURCE.getRawValue(), OtherEventConstants.APP.getRawValue());
        linkedHashMap.put(ConversionsAPISection.USER_DATA.getRawValue(), map);
        linkedHashMap.put(ConversionsAPISection.APP_DATA.getRawValue(), map2);
        linkedHashMap.putAll(map3);
        return linkedHashMap;
    }

    private final List<Map<String, Object>> combineAllTransformedDataForMobileAppInstall(Map<String, ? extends Object> map, Object obj) {
        if (obj == null) {
            return null;
        }
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(map);
        linkedHashMap.put(ConversionsAPICustomEventField.EVENT_NAME.getRawValue(), OtherEventConstants.MOBILE_APP_INSTALL.getRawValue());
        linkedHashMap.put(ConversionsAPICustomEventField.EVENT_TIME.getRawValue(), obj);
        return CollectionsKt.listOf(linkedHashMap);
    }

    private final List<Map<String, Object>> combineAllTransformedDataForCustom(Map<String, ? extends Object> map, List<? extends Map<String, ? extends Object>> list) {
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map putAll : list) {
            Map linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(map);
            linkedHashMap.putAll(putAll);
            arrayList.add(linkedHashMap);
        }
        return arrayList;
    }

    public final List<Map<String, Object>> combineAllTransformedData$facebook_core_release(AppEventType appEventType, Map<String, Object> map, Map<String, Object> map2, Map<String, Object> map3, List<? extends Map<String, ? extends Object>> list, Object obj) {
        Intrinsics.checkNotNullParameter(appEventType, "eventType");
        Intrinsics.checkNotNullParameter(map, "userData");
        Intrinsics.checkNotNullParameter(map2, "appData");
        Intrinsics.checkNotNullParameter(map3, "restOfData");
        Intrinsics.checkNotNullParameter(list, "customEvents");
        Map<String, Object> combineCommonFields$facebook_core_release = combineCommonFields$facebook_core_release(map, map2, map3);
        int i = WhenMappings.$EnumSwitchMapping$2[appEventType.ordinal()];
        if (i == 1) {
            return combineAllTransformedDataForMobileAppInstall(combineCommonFields$facebook_core_release, obj);
        }
        if (i != 2) {
            return null;
        }
        return combineAllTransformedDataForCustom(combineCommonFields$facebook_core_release, list);
    }

    private final AppEventType splitAppEventParameters(Map<String, ? extends Object> map, Map<String, Object> map2, Map<String, Object> map3, ArrayList<Map<String, Object>> arrayList, Map<String, Object> map4) {
        Object obj = map.get(OtherEventConstants.EVENT.getRawValue());
        AppEventType.Companion companion = AppEventType.Companion;
        if (obj != null) {
            AppEventType invoke = companion.invoke((String) obj);
            if (invoke == AppEventType.OTHER) {
                return invoke;
            }
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                AppEventUserAndAppDataField invoke2 = AppEventUserAndAppDataField.Companion.invoke(str);
                if (invoke2 != null) {
                    INSTANCE.transformAndUpdateAppAndUserData$facebook_core_release(map2, map3, invoke2, value);
                } else {
                    boolean areEqual = Intrinsics.areEqual((Object) str, (Object) ConversionsAPISection.CUSTOM_EVENTS.getRawValue());
                    boolean z = value instanceof String;
                    if (invoke == AppEventType.CUSTOM && areEqual && z) {
                        ArrayList<Map<String, Object>> transformEvents$facebook_core_release = transformEvents$facebook_core_release((String) value);
                        if (transformEvents$facebook_core_release != null) {
                            arrayList.addAll(transformEvents$facebook_core_release);
                        }
                    } else if (DataProcessingParameterName.Companion.invoke(str) != null) {
                        map4.put(str, value);
                    }
                }
            }
            return invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final List<Map<String, Object>> conversionsAPICompatibleEvent$facebook_core_release(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
        Map linkedHashMap = new LinkedHashMap();
        Map linkedHashMap2 = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        Map linkedHashMap3 = new LinkedHashMap();
        AppEventType splitAppEventParameters = splitAppEventParameters(map, linkedHashMap, linkedHashMap2, arrayList, linkedHashMap3);
        if (splitAppEventParameters == AppEventType.OTHER) {
            return null;
        }
        return combineAllTransformedData$facebook_core_release(splitAppEventParameters, linkedHashMap, linkedHashMap2, linkedHashMap3, arrayList, map.get(OtherEventConstants.INSTALL_EVENT_TIME.getRawValue()));
    }
}
