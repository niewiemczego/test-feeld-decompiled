package com.braze.models.inappmessage;

import android.net.Uri;
import com.braze.enums.inappmessage.ClickAction;
import com.braze.enums.inappmessage.CropType;
import com.braze.enums.inappmessage.DismissType;
import com.braze.enums.inappmessage.MessageType;
import com.braze.enums.inappmessage.Orientation;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.models.IPutIntoJson;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0014\u0010_\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002000/H\u0016J\u000e\u0010`\u001a\b\u0012\u0004\u0012\u0002000aH&J\b\u0010b\u001a\u00020\u0004H&J\b\u0010c\u001a\u00020\u0004H&J\b\u0010d\u001a\u00020eH&J\u0010\u0010f\u001a\u00020e2\u0006\u0010\u0015\u001a\u00020\u0016H&J\u001c\u0010f\u001a\u00020e2\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\H&J\u001c\u0010g\u001a\u00020e2\u0012\u0010h\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002000/H&R\u001e\u0010\u0003\u001a\u00020\u0004X¦\u000e¢\u0006\u0012\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u0004X¦\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u0018\u0010\u000f\u001a\u00020\u0010X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u00020\u001aX¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u00020 X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010%\u001a\u00020\u0010X¦\u000e¢\u0006\f\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R\u0018\u0010(\u001a\u00020)X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002000/X¦\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u0004\u0018\u000100X¦\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0018\u0010:\u001a\u00020\u0010X¦\u000e¢\u0006\f\u001a\u0004\b;\u0010\u0012\"\u0004\b<\u0010\u0014R\u0018\u0010=\u001a\u00020\u0010X¦\u000e¢\u0006\f\u001a\u0004\b>\u0010\u0012\"\u0004\b?\u0010\u0014R\u0012\u0010@\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\bR\u001a\u0010A\u001a\u0004\u0018\u000100X¦\u000e¢\u0006\f\u001a\u0004\bB\u00107\"\u0004\bC\u00109R\u0018\u0010D\u001a\u00020EX¦\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0018\u0010J\u001a\u00020\u0010X¦\u000e¢\u0006\f\u001a\u0004\bK\u0010\u0012\"\u0004\bL\u0010\u0014R\u0012\u0010M\u001a\u00020NX¦\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u001e\u0010Q\u001a\u00020\u0004X¦\u000e¢\u0006\u0012\u0012\u0004\bR\u0010\u0006\u001a\u0004\bS\u0010\b\"\u0004\bT\u0010\nR\u0018\u0010U\u001a\u00020VX¦\u000e¢\u0006\f\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0014\u0010[\u001a\u0004\u0018\u00010\\X¦\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006iÀ\u0006\u0001"}, d2 = {"Lcom/braze/models/inappmessage/IInAppMessage;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONObject;", "animateIn", "", "getAnimateIn$annotations", "()V", "getAnimateIn", "()Z", "setAnimateIn", "(Z)V", "animateOut", "getAnimateOut$annotations", "getAnimateOut", "setAnimateOut", "backgroundColor", "", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "clickAction", "Lcom/braze/enums/inappmessage/ClickAction;", "getClickAction", "()Lcom/braze/enums/inappmessage/ClickAction;", "cropType", "Lcom/braze/enums/inappmessage/CropType;", "getCropType", "()Lcom/braze/enums/inappmessage/CropType;", "setCropType", "(Lcom/braze/enums/inappmessage/CropType;)V", "dismissType", "Lcom/braze/enums/inappmessage/DismissType;", "getDismissType", "()Lcom/braze/enums/inappmessage/DismissType;", "setDismissType", "(Lcom/braze/enums/inappmessage/DismissType;)V", "durationInMilliseconds", "getDurationInMilliseconds", "setDurationInMilliseconds", "expirationTimestamp", "", "getExpirationTimestamp", "()J", "setExpirationTimestamp", "(J)V", "extras", "", "", "getExtras", "()Ljava/util/Map;", "setExtras", "(Ljava/util/Map;)V", "icon", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "iconBackgroundColor", "getIconBackgroundColor", "setIconBackgroundColor", "iconColor", "getIconColor", "setIconColor", "isControl", "message", "getMessage", "setMessage", "messageTextAlign", "Lcom/braze/enums/inappmessage/TextAlign;", "getMessageTextAlign", "()Lcom/braze/enums/inappmessage/TextAlign;", "setMessageTextAlign", "(Lcom/braze/enums/inappmessage/TextAlign;)V", "messageTextColor", "getMessageTextColor", "setMessageTextColor", "messageType", "Lcom/braze/enums/inappmessage/MessageType;", "getMessageType", "()Lcom/braze/enums/inappmessage/MessageType;", "openUriInWebView", "getOpenUriInWebView$annotations", "getOpenUriInWebView", "setOpenUriInWebView", "orientation", "Lcom/braze/enums/inappmessage/Orientation;", "getOrientation", "()Lcom/braze/enums/inappmessage/Orientation;", "setOrientation", "(Lcom/braze/enums/inappmessage/Orientation;)V", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "getLocalPrefetchedAssetPaths", "getRemoteAssetPathsForPrefetch", "", "logClick", "logImpression", "onAfterClosed", "", "setClickBehavior", "setLocalPrefetchedAssetPaths", "remotePathToLocalAssetMap", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IInAppMessage extends IPutIntoJson<JSONObject> {
    static /* synthetic */ void getAnimateIn$annotations() {
    }

    static /* synthetic */ void getAnimateOut$annotations() {
    }

    static /* synthetic */ void getOpenUriInWebView$annotations() {
    }

    static /* synthetic */ void setClickBehavior$default(IInAppMessage iInAppMessage, ClickAction clickAction, Uri uri, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                uri = null;
            }
            iInAppMessage.setClickBehavior(clickAction, uri);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setClickBehavior");
    }

    boolean getAnimateIn();

    boolean getAnimateOut();

    int getBackgroundColor();

    ClickAction getClickAction();

    CropType getCropType();

    DismissType getDismissType();

    int getDurationInMilliseconds();

    long getExpirationTimestamp();

    Map<String, String> getExtras();

    String getIcon();

    int getIconBackgroundColor();

    int getIconColor();

    Map<String, String> getLocalPrefetchedAssetPaths() {
        return MapsKt.emptyMap();
    }

    String getMessage();

    TextAlign getMessageTextAlign();

    int getMessageTextColor();

    MessageType getMessageType();

    boolean getOpenUriInWebView();

    Orientation getOrientation();

    List<String> getRemoteAssetPathsForPrefetch();

    Uri getUri();

    boolean isControl();

    boolean logClick();

    boolean logImpression();

    void onAfterClosed();

    void setAnimateIn(boolean z);

    void setAnimateOut(boolean z);

    void setBackgroundColor(int i);

    void setClickBehavior(ClickAction clickAction);

    void setClickBehavior(ClickAction clickAction, Uri uri);

    void setCropType(CropType cropType);

    void setDismissType(DismissType dismissType);

    void setDurationInMilliseconds(int i);

    void setExpirationTimestamp(long j);

    void setExtras(Map<String, String> map);

    void setIcon(String str);

    void setIconBackgroundColor(int i);

    void setIconColor(int i);

    void setLocalPrefetchedAssetPaths(Map<String, String> map);

    void setMessage(String str);

    void setMessageTextAlign(TextAlign textAlign);

    void setMessageTextColor(int i);

    void setOpenUriInWebView(boolean z);

    void setOrientation(Orientation orientation);
}
