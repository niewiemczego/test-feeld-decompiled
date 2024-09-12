package com.facebook.gamingservices.cloudgaming.internal;

import com.google.firebase.analytics.FirebaseAnalytics;

public enum SDKMessageEnum {
    OPEN_PLAY_STORE("openPlayStore"),
    OPEN_APP_STORE("openAppStore"),
    MARK_GAME_LOADED("markGameLoaded"),
    GET_PLAYER_DATA("getPlayerData"),
    SET_PLAYER_DATA("setPlayerData"),
    GET_CATALOG("getCatalog"),
    GET_PURCHASES("getPurchases"),
    PURCHASE(FirebaseAnalytics.Event.PURCHASE),
    CONSUME_PURCHASE("consumePurchase"),
    ON_READY("onReady"),
    GET_SUBSCRIBABLE_CATALOG("getSubscribableCatalog"),
    PURCHASE_SUBSCRIPTION("purchaseSubscription"),
    GET_SUBSCRIPTIONS("getSubscriptions"),
    CANCEL_SUBSCRIPTION("cancelSubscription"),
    LOAD_INTERSTITIAL_AD("loadInterstitialAd"),
    LOAD_REWARDED_VIDEO("loadRewardedVideo"),
    SHOW_INTERSTITIAL_AD("showInterstitialAd"),
    SHOW_REWARDED_VIDEO("showRewardedVideo"),
    GET_ACCESS_TOKEN("getAccessToken"),
    GET_CONTEXT_TOKEN("getContextToken"),
    GET_PAYLOAD("getPayload"),
    IS_ENV_READY("isEnvReady"),
    SHARE("share"),
    CAN_CREATE_SHORTCUT("canCreateShortcut"),
    CREATE_SHORTCUT("createShortcut"),
    OPEN_GAMING_SERVICES_DEEP_LINK("openGamingServicesDeepLink"),
    OPEN_GAME_REQUESTS_DIALOG("openGameRequestsDialog"),
    POST_SESSION_SCORE("postSessionScore"),
    POST_SESSION_SCORE_ASYNC("postSessionScoreAsync"),
    GET_TOURNAMENT_ASYNC("getTournamentAsync"),
    TOURNAMENT_CREATE_ASYNC("tournamentCreateAsync"),
    TOURNAMENT_SHARE_ASYNC("tournamentShareAsync"),
    TOURNAMENT_POST_SCORE_ASYNC("tournamentPostScoreAsync"),
    TOURNAMENT_GET_TOURNAMENTS_ASYNC("getTournaments"),
    TOURNAMENT_JOIN_ASYNC("joinTournament"),
    OPEN_LINK("openExternalLink"),
    PERFORM_HAPTIC_FEEDBACK_ASYNC("performHapticFeedbackAsync"),
    CONTEXT_SWITCH("contextSwitch"),
    CONTEXT_CHOOSE("contextChoose"),
    CONTEXT_CREATE("contextCreate"),
    CONTEXT_GET_ID("contextGetID"),
    DEBUG_PRINT("debugPrint"),
    GET_COUNTRY_ISO("getCountryISO");
    
    private final String mStringValue;

    private SDKMessageEnum(String str) {
        this.mStringValue = str;
    }

    public String toString() {
        return this.mStringValue;
    }

    public static SDKMessageEnum fromString(String str) {
        for (SDKMessageEnum sDKMessageEnum : values()) {
            if (sDKMessageEnum.toString().equals(str)) {
                return sDKMessageEnum;
            }
        }
        return null;
    }
}
