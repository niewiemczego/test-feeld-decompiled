package com.braze.ui.actions.brazeactions;

import android.net.Uri;
import com.braze.enums.Channel;
import com.braze.models.cards.Card;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageImmersive;
import com.braze.models.inappmessage.MessageButton;
import com.braze.ui.actions.brazeactions.BrazeActionParser;
import com.braze.ui.actions.brazeactions.steps.ContainerStep;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\u001a\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\u0001*\u00020\u000bH\u0000\u001a\f\u0010\f\u001a\u00020\u0001*\u00020\rH\u0000\u001a\f\u0010\f\u001a\u00020\u0001*\u00020\u000bH\u0000\u001a\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u0004\u0018\u00010\u000bH\u0000¨\u0006\u000f"}, d2 = {"doAnyTypesMatch", "", "actionType", "Lcom/braze/ui/actions/brazeactions/BrazeActionParser$ActionType;", "uriList", "", "Landroid/net/Uri;", "getAllBrazeActionStepTypes", "json", "Lorg/json/JSONObject;", "containsAnyPushPermissionBrazeActions", "Lcom/braze/models/inappmessage/IInAppMessage;", "containsInvalidBrazeAction", "Lcom/braze/models/cards/Card;", "getAllUris", "android-sdk-ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeActionUtils.kt */
public final class BrazeActionUtils {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BrazeActionUtils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BrazeActionParser.ActionType.values().length];
            try {
                iArr[BrazeActionParser.ActionType.CONTAINER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean containsAnyPushPermissionBrazeActions(IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "<this>");
        return doAnyTypesMatch(BrazeActionParser.ActionType.REQUEST_PUSH_PERMISSION, getAllUris(iInAppMessage));
    }

    public static final boolean containsInvalidBrazeAction(IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "<this>");
        return doAnyTypesMatch(BrazeActionParser.ActionType.INVALID, getAllUris(iInAppMessage));
    }

    public static final boolean containsInvalidBrazeAction(Card card) {
        Intrinsics.checkNotNullParameter(card, "<this>");
        if (card.getUrl() != null) {
            return doAnyTypesMatch(BrazeActionParser.ActionType.INVALID, CollectionsKt.listOf(Uri.parse(card.getUrl())));
        }
        return false;
    }

    public static final /* synthetic */ List getAllUris(IInAppMessage iInAppMessage) {
        if (iInAppMessage == null) {
            return CollectionsKt.emptyList();
        }
        List arrayList = new ArrayList();
        Uri uri = iInAppMessage.getUri();
        if (uri != null) {
            arrayList.add(uri);
        }
        if (iInAppMessage instanceof IInAppMessageImmersive) {
            Collection arrayList2 = new ArrayList();
            for (MessageButton uri2 : ((IInAppMessageImmersive) iInAppMessage).getMessageButtons()) {
                Uri uri3 = uri2.getUri();
                if (uri3 != null) {
                    arrayList2.add(uri3);
                }
            }
            arrayList.addAll((List) arrayList2);
        }
        return arrayList;
    }

    public static final /* synthetic */ List getAllBrazeActionStepTypes(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        List arrayList = new ArrayList();
        StepData stepData = new StepData(jSONObject, (Channel) null, 2, (DefaultConstructorMarker) null);
        BrazeActionParser.ActionType actionType$android_sdk_ui_release = BrazeActionParser.INSTANCE.getActionType$android_sdk_ui_release(stepData);
        if (WhenMappings.$EnumSwitchMapping$0[actionType$android_sdk_ui_release.ordinal()] == 1) {
            Iterator childStepIterator$android_sdk_ui_release = ContainerStep.INSTANCE.getChildStepIterator$android_sdk_ui_release(stepData);
            while (childStepIterator$android_sdk_ui_release.hasNext()) {
                arrayList.addAll(getAllBrazeActionStepTypes((JSONObject) childStepIterator$android_sdk_ui_release.next()));
            }
        } else {
            arrayList.add(actionType$android_sdk_ui_release);
        }
        return arrayList;
    }

    public static final boolean doAnyTypesMatch(BrazeActionParser.ActionType actionType, List<? extends Uri> list) {
        boolean z;
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(actionType, SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(list, "uriList");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (BrazeActionParser.INSTANCE.isBrazeActionUri((Uri) next)) {
                arrayList.add(next);
            }
        }
        Iterable<Uri> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Uri brazeActionVersionAndJson$android_sdk_ui_release : iterable) {
            Pair brazeActionVersionAndJson$android_sdk_ui_release2 = BrazeActionParser.INSTANCE.getBrazeActionVersionAndJson$android_sdk_ui_release(brazeActionVersionAndJson$android_sdk_ui_release);
            if (brazeActionVersionAndJson$android_sdk_ui_release2 == null || (jSONObject = (JSONObject) brazeActionVersionAndJson$android_sdk_ui_release2.getSecond()) == null) {
                jSONObject = new JSONObject();
            }
            arrayList2.add(jSONObject);
        }
        Collection arrayList3 = new ArrayList();
        for (JSONObject allBrazeActionStepTypes : (List) arrayList2) {
            CollectionsKt.addAll(arrayList3, getAllBrazeActionStepTypes(allBrazeActionStepTypes));
        }
        Iterable<BrazeActionParser.ActionType> iterable2 = (List) arrayList3;
        if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
            for (BrazeActionParser.ActionType actionType2 : iterable2) {
                if (actionType2 == actionType) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }
}
