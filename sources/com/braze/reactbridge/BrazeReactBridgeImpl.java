package com.braze.reactbridge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.braze.Braze;
import com.braze.BrazeUser;
import com.braze.Constants;
import com.braze.enums.BrazePushEventType;
import com.braze.enums.CardCategory;
import com.braze.enums.NotificationSubscriptionType;
import com.braze.enums.inappmessage.ClickAction;
import com.braze.events.BrazePushEvent;
import com.braze.events.BrazeSdkAuthenticationErrorEvent;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.events.FeatureFlagsUpdatedEvent;
import com.braze.events.FeedUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.braze.models.FeatureFlag;
import com.braze.models.cards.Card;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageImmersive;
import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.models.inappmessage.MessageButton;
import com.braze.models.outgoing.AttributionData;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.models.push.BrazeNotificationPayload;
import com.braze.support.BrazeLogger;
import com.braze.support.PermissionUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.actions.UriAction;
import com.braze.ui.activities.BrazeFeedActivity;
import com.braze.ui.activities.ContentCardsActivity;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.InAppMessageOperation;
import com.braze.ui.inappmessage.listeners.DefaultInAppMessageManagerListener;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b,\u0018\u0000 Í\u00012\u00020\u0001:\u0002Í\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010/J\u000e\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020/J$\u00103\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u00010/2\b\u00105\u001a\u0004\u0018\u00010/2\b\u00106\u001a\u0004\u0018\u00010\u000eJ\u001a\u00107\u001a\u00020-2\b\u00108\u001a\u0004\u0018\u00010/2\b\u00106\u001a\u0004\u0018\u00010\u000eJ\u001a\u00109\u001a\u00020-2\b\u0010:\u001a\u0004\u0018\u00010/2\b\u0010;\u001a\u0004\u0018\u00010/J \u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020/0AH\u0002J\u0006\u0010B\u001a\u00020-J\u0006\u0010C\u001a\u00020-J\u0010\u0010D\u001a\u00020-2\b\u0010E\u001a\u0004\u0018\u00010FJ\u0010\u0010G\u001a\u00020-2\b\u0010E\u001a\u0004\u0018\u00010FJ\u001a\u0010H\u001a\u00020-2\b\u0010I\u001a\u0004\u0018\u00010/2\b\u00106\u001a\u0004\u0018\u00010\u000eJ$\u0010J\u001a\u00020-2\b\u0010I\u001a\u0004\u0018\u00010/2\b\u00106\u001a\u0004\u0018\u00010\u000e2\u0006\u0010K\u001a\u00020/H\u0002J\u0012\u0010L\u001a\u0004\u0018\u00010\u00122\u0006\u0010M\u001a\u00020/H\u0002J\u0010\u0010N\u001a\u00020-2\b\u0010E\u001a\u0004\u0018\u00010FJ\u0010\u0010O\u001a\u00020-2\b\u00106\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010P\u001a\u00020-2\b\u0010M\u001a\u0004\u0018\u00010/2\b\u0010E\u001a\u0004\u0018\u00010FJ$\u0010Q\u001a\u00020-2\b\u0010M\u001a\u0004\u0018\u00010/2\b\u00104\u001a\u0004\u0018\u00010/2\b\u0010E\u001a\u0004\u0018\u00010FJ$\u0010R\u001a\u00020-2\b\u0010M\u001a\u0004\u0018\u00010/2\b\u00104\u001a\u0004\u0018\u00010/2\b\u0010E\u001a\u0004\u0018\u00010FJ$\u0010S\u001a\u00020-2\b\u0010M\u001a\u0004\u0018\u00010/2\b\u00104\u001a\u0004\u0018\u00010/2\b\u0010E\u001a\u0004\u0018\u00010FJ\u0012\u0010T\u001a\u0004\u0018\u00010\u00122\u0006\u0010M\u001a\u00020/H\u0002J\u0010\u0010U\u001a\u00020-2\b\u0010E\u001a\u0004\u0018\u00010FJ\u001a\u0010V\u001a\u00020-2\b\u0010I\u001a\u0004\u0018\u00010/2\b\u00106\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010W\u001a\u00020-2\b\u00106\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010X\u001a\u00020-J\"\u0010Y\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u00010/2\u0006\u0010Z\u001a\u00020[2\b\u00106\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\\\u001a\u00020-J\u0006\u0010]\u001a\u00020-J\u0010\u0010^\u001a\u00020-2\b\u0010M\u001a\u0004\u0018\u00010/J\u0010\u0010_\u001a\u00020-2\b\u0010M\u001a\u0004\u0018\u00010/J\u0010\u0010`\u001a\u00020-2\b\u0010M\u001a\u0004\u0018\u00010/J\u001a\u0010a\u001a\u00020-2\b\u00102\u001a\u0004\u0018\u00010/2\b\u0010b\u001a\u0004\u0018\u00010=J\u000e\u0010c\u001a\u00020-2\u0006\u0010M\u001a\u00020/J\u0018\u0010d\u001a\u00020-2\b\u0010e\u001a\u0004\u0018\u00010/2\u0006\u0010f\u001a\u00020[J\u0010\u0010g\u001a\u00020-2\b\u0010e\u001a\u0004\u0018\u00010/J\u0017\u0010h\u001a\u0004\u0018\u00010\u000f2\b\u0010e\u001a\u0004\u0018\u00010/¢\u0006\u0002\u0010iJ\u0010\u0010j\u001a\u00020-2\b\u0010M\u001a\u0004\u0018\u00010/J\u0010\u0010k\u001a\u00020-2\b\u0010M\u001a\u0004\u0018\u00010/J6\u0010l\u001a\u00020-2\b\u0010m\u001a\u0004\u0018\u00010/2\b\u0010n\u001a\u0004\u0018\u00010/2\b\u0010o\u001a\u0004\u0018\u00010/2\u0006\u0010p\u001a\u00020[2\b\u0010b\u001a\u0004\u0018\u00010=J\u0018\u0010q\u001a\u00020-2\b\u0010e\u001a\u0004\u0018\u00010/2\u0006\u0010f\u001a\u00020[J\u0010\u0010r\u001a\u00020-2\b\u0010M\u001a\u0004\u0018\u00010/J\u0006\u0010s\u001a\u00020-J\u0010\u0010t\u001a\u00020-2\b\u0010u\u001a\u0004\u0018\u00010/J$\u0010v\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u00010/2\b\u00105\u001a\u0004\u0018\u00010/2\b\u00106\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010w\u001a\u00020-2\b\u00108\u001a\u0004\u0018\u00010/2\b\u00106\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010x\u001a\u00020-2\u0006\u0010y\u001a\u00020[J\u0006\u0010z\u001a\u00020-J\u0006\u0010{\u001a\u00020-J \u0010|\u001a\u00020-2\b\u0010}\u001a\u0004\u0018\u00010~2\b\u0010\u001a\u0004\u0018\u00010~¢\u0006\u0003\u0010\u0001J\u0007\u0010\u0001\u001a\u00020-J\u0007\u0010\u0001\u001a\u00020-J\u0012\u0010\u0001\u001a\u00020-2\t\u0010\u0001\u001a\u0004\u0018\u00010=J2\u0010\u0001\u001a\u00020-2'\u0010\u0001\u001a\"\u0012\u0017\u0012\u00150\u0001¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020-0\u0001H\u0002J3\u0010\u0001\u001a\u00020-2\t\u0010\u0001\u001a\u0004\u0018\u00010/2\t\u0010\u0001\u001a\u0004\u0018\u00010/2\t\u0010\u0001\u001a\u0004\u0018\u00010/2\t\u0010\u0001\u001a\u0004\u0018\u00010/J+\u0010\u0001\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u00010/2\b\u00105\u001a\u0004\u0018\u00010\u000f2\b\u00106\u001a\u0004\u0018\u00010\u000e¢\u0006\u0003\u0010\u0001J\u0012\u0010\u0001\u001a\u00020-2\t\u0010\u0001\u001a\u0004\u0018\u00010/J&\u0010\u0001\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u00010/2\t\u00105\u001a\u0005\u0018\u00010\u00012\b\u00106\u001a\u0004\u0018\u00010\u000eJ,\u0010\u0001\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u00010/2\u0006\u00105\u001a\u00020=2\u0007\u0010\u0001\u001a\u00020\u000f2\b\u00106\u001a\u0004\u0018\u00010\u000eJ&\u0010\u0001\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u00010/2\t\u00105\u001a\u0005\u0018\u00010\u00012\b\u00106\u001a\u0004\u0018\u00010\u000eJ$\u0010\u0001\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u00010/2\u0007\u0010\u0001\u001a\u00020[2\b\u00106\u001a\u0004\u0018\u00010\u000eJ\"\u0010\u0001\u001a\u00020-2\u0007\u0010\u0001\u001a\u00020[2\u0007\u0010\u0001\u001a\u00020[2\u0007\u0010\u0001\u001a\u00020[J\t\u0010 \u0001\u001a\u00020-H\u0002J$\u0010¡\u0001\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u00010/2\u0007\u00105\u001a\u00030¢\u00012\b\u00106\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010£\u0001\u001a\u00020-2\t\u0010¤\u0001\u001a\u0004\u0018\u00010/J\u001c\u0010¥\u0001\u001a\u00020-2\t\u0010¦\u0001\u001a\u0004\u0018\u00010/2\b\u00106\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010§\u0001\u001a\u00020-2\t\u0010¨\u0001\u001a\u0004\u0018\u00010/J\u001c\u0010©\u0001\u001a\u00020-2\t\u0010ª\u0001\u001a\u0004\u0018\u00010/2\b\u00106\u001a\u0004\u0018\u00010\u000eJ#\u0010«\u0001\u001a\u00020-2\t\u0010¬\u0001\u001a\u0004\u0018\u00010/2\t\u0010­\u0001\u001a\u0004\u0018\u00010\u000f¢\u0006\u0003\u0010®\u0001J\u0012\u0010¯\u0001\u001a\u00020-2\t\u0010°\u0001\u001a\u0004\u0018\u00010/J#\u0010±\u0001\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u00010/2\u0006\u00105\u001a\u00020[2\b\u00106\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010²\u0001\u001a\u00020-2\t\u0010³\u0001\u001a\u0004\u0018\u00010/J2\u0010´\u0001\u001a\u00020-2\u0006\u0010}\u001a\u00020~2\u0006\u0010\u001a\u00020~2\u0007\u0010µ\u0001\u001a\u00020~2\u0007\u0010¶\u0001\u001a\u00020~2\u0007\u0010·\u0001\u001a\u00020~J\u0012\u0010¸\u0001\u001a\u00020-2\t\u0010¹\u0001\u001a\u0004\u0018\u00010/J5\u0010º\u0001\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u00010/2\b\u0010}\u001a\u0004\u0018\u00010~2\b\u0010\u001a\u0004\u0018\u00010~2\b\u00106\u001a\u0004\u0018\u00010\u000e¢\u0006\u0003\u0010»\u0001J\u0012\u0010¼\u0001\u001a\u00020-2\t\u0010½\u0001\u001a\u0004\u0018\u00010/J\u001c\u0010¾\u0001\u001a\u00020-2\t\u0010¦\u0001\u001a\u0004\u0018\u00010/2\b\u00106\u001a\u0004\u0018\u00010\u000eJ\u0011\u0010¿\u0001\u001a\u00020-2\b\u0010u\u001a\u0004\u0018\u00010/J%\u0010À\u0001\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u00010/2\b\u00105\u001a\u0004\u0018\u00010/2\b\u00106\u001a\u0004\u0018\u00010\u000eJ\t\u0010Á\u0001\u001a\u00020-H\u0002J\t\u0010Â\u0001\u001a\u00020-H\u0002J\u0010\u0010Ã\u0001\u001a\u00020-2\u0007\u0010Ä\u0001\u001a\u00020\u000fJ\t\u0010Å\u0001\u001a\u00020-H\u0002J\t\u0010Æ\u0001\u001a\u00020-H\u0002J\t\u0010Ç\u0001\u001a\u00020-H\u0002J\u001b\u0010È\u0001\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u00010/2\b\u00106\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010É\u0001\u001a\u00020-2\u0007\u0010Ê\u0001\u001a\u00020\u0019H\u0002J\u0012\u0010Ë\u0001\u001a\u00020-2\u0007\u0010Ê\u0001\u001a\u00020#H\u0002J\u0007\u0010Ì\u0001\u001a\u00020-R\u0014\u0010\u0007\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X.¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0018X.¢\u0006\u0002\n\u0000R\"\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\f\u0012\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00180%X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0018X.¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u0018X.¢\u0006\u0002\n\u0000¨\u0006Î\u0001"}, d2 = {"Lcom/braze/reactbridge/BrazeReactBridgeImpl;", "", "reactApplicationContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "currentActivity", "Landroid/app/Activity;", "(Lcom/facebook/react/bridge/ReactApplicationContext;Landroid/app/Activity;)V", "braze", "Lcom/braze/Braze;", "getBraze", "()Lcom/braze/Braze;", "callbackCallLock", "callbackCallMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/facebook/react/bridge/Callback;", "", "contentCards", "", "Lcom/braze/models/cards/Card;", "contentCardsLock", "Ljava/util/concurrent/locks/ReentrantLock;", "contentCardsUpdatedAt", "", "contentCardsUpdatedSubscriber", "Lcom/braze/events/IEventSubscriber;", "Lcom/braze/events/ContentCardsUpdatedEvent;", "getCurrentActivity", "()Landroid/app/Activity;", "featureFlagsUpdatedSubscriber", "Lcom/braze/events/FeatureFlagsUpdatedEvent;", "inAppMessageDisplayOperation", "Lcom/braze/ui/inappmessage/InAppMessageOperation;", "newsFeedCards", "newsFeedCardsUpdatedAt", "newsFeedCardsUpdatedSubscriber", "Lcom/braze/events/FeedUpdatedEvent;", "newsFeedSubscriberMap", "", "pushNotificationEventSubscriber", "Lcom/braze/events/BrazePushEvent;", "getReactApplicationContext", "()Lcom/facebook/react/bridge/ReactApplicationContext;", "sdkAuthErrorSubscriber", "Lcom/braze/events/BrazeSdkAuthenticationErrorEvent;", "addAlias", "", "aliasName", "", "aliasLabel", "addListener", "eventName", "addToCustomAttributeArray", "key", "value", "callback", "addToSubscriptionGroup", "groupId", "changeUser", "userName", "sdkAuthToken", "convertToMap", "Lcom/facebook/react/bridge/ReadableMap;", "bundle", "Landroid/os/Bundle;", "filteringKeys", "", "disableSDK", "enableSDK", "getAllFeatureFlags", "promise", "Lcom/facebook/react/bridge/Promise;", "getCachedContentCards", "getCardCountForCategories", "category", "getCardCountForTag", "cardCountTag", "getContentCardById", "id", "getContentCards", "getDeviceId", "getFeatureFlag", "getFeatureFlagBooleanProperty", "getFeatureFlagNumberProperty", "getFeatureFlagStringProperty", "getNewsFeedCardById", "getNewsFeedCards", "getUnreadCardCountForCategories", "getUserId", "hideCurrentInAppMessage", "incrementCustomUserAttribute", "incrementValue", "", "launchContentCards", "launchNewsFeed", "logContentCardClicked", "logContentCardDismissed", "logContentCardImpression", "logCustomEvent", "eventProperties", "logFeatureFlagImpression", "logInAppMessageButtonClicked", "inAppMessageString", "buttonId", "logInAppMessageClicked", "logInAppMessageImpression", "(Ljava/lang/String;)Ljava/lang/Boolean;", "logNewsFeedCardClicked", "logNewsFeedCardImpression", "logPurchase", "productIdentifier", "price", "currencyCode", "quantity", "performInAppMessageAction", "processContentCardClickAction", "refreshFeatureFlags", "registerPushToken", "token", "removeFromCustomAttributeArray", "removeFromSubscriptionGroup", "removeListeners", "count", "requestContentCardsRefresh", "requestFeedRefresh", "requestGeofences", "latitude", "", "longitude", "(Ljava/lang/Double;Ljava/lang/Double;)V", "requestImmediateDataFlush", "requestLocationInitialization", "requestPushPermission", "options", "runOnUser", "block", "Lkotlin/Function1;", "Lcom/braze/BrazeUser;", "Lkotlin/ParameterName;", "name", "user", "setAttributionData", "network", "campaign", "adGroup", "creative", "setBoolCustomUserAttribute", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/facebook/react/bridge/Callback;)V", "setCountry", "country", "setCustomUserAttributeArray", "Lcom/facebook/react/bridge/ReadableArray;", "setCustomUserAttributeObject", "merge", "setCustomUserAttributeObjectArray", "setDateCustomUserAttribute", "timeStamp", "setDateOfBirth", "year", "month", "day", "setDefaultInAppMessageListener", "setDoubleCustomUserAttribute", "", "setEmail", "email", "setEmailNotificationSubscriptionType", "subscriptionType", "setFirstName", "firstName", "setGender", "gender", "setGoogleAdvertisingId", "googleAdvertisingId", "adTrackingEnabled", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "setHomeCity", "homeCity", "setIntCustomUserAttribute", "setLanguage", "language", "setLastKnownLocation", "altitude", "horizontalAccuracy", "verticalAccuracy", "setLastName", "lastName", "setLocationCustomAttribute", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Lcom/facebook/react/bridge/Callback;)V", "setPhoneNumber", "phoneNumber", "setPushNotificationSubscriptionType", "setSdkAuthenticationSignature", "setStringCustomUserAttribute", "subscribeToContentCardsUpdatedEvent", "subscribeToFeatureFlagsUpdatedEvent", "subscribeToInAppMessage", "useBrazeUI", "subscribeToNewsFeedCardsUpdatedEvent", "subscribeToPushNotificationEvents", "subscribeToSdkAuthenticationErrorEvents", "unsetCustomUserAttribute", "updateContentCardsIfNeeded", "event", "updateNewsFeedCardsIfNeeded", "wipeData", "Companion", "braze_react-native-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BrazeReactBridgeImpl.kt */
public final class BrazeReactBridgeImpl {
    private static final String CARD_COUNT_TAG = "card count";
    private static final String CONTENT_CARDS_UPDATED_EVENT_NAME = "contentCardsUpdated";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FEATURE_FLAGS_UPDATED_EVENT_NAME = "featureFlagsUpdated";
    private static final String IN_APP_MESSAGE_RECEIVED_EVENT_NAME = "inAppMessageReceived";
    public static final String NAME = "BrazeReactBridge";
    private static final String NEWS_FEED_CARDS_UPDATED_EVENT_NAME = "newsFeedCardsUpdated";
    private static final String PUSH_NOTIFICATION_EVENT_NAME = "pushNotificationEvent";
    private static final String SDK_AUTH_ERROR_EVENT_NAME = "sdkAuthenticationError";
    private static final String UNREAD_CARD_COUNT_TAG = "unread card count";
    private final Object callbackCallLock = new Object();
    private final ConcurrentHashMap<Callback, Boolean> callbackCallMap = new ConcurrentHashMap<>();
    private final List<Card> contentCards = new ArrayList();
    private final ReentrantLock contentCardsLock = new ReentrantLock();
    private long contentCardsUpdatedAt;
    private IEventSubscriber<ContentCardsUpdatedEvent> contentCardsUpdatedSubscriber;
    private final Activity currentActivity;
    private IEventSubscriber<FeatureFlagsUpdatedEvent> featureFlagsUpdatedSubscriber;
    /* access modifiers changed from: private */
    public InAppMessageOperation inAppMessageDisplayOperation = InAppMessageOperation.DISPLAY_NOW;
    private final List<Card> newsFeedCards = new ArrayList();
    private long newsFeedCardsUpdatedAt;
    private IEventSubscriber<FeedUpdatedEvent> newsFeedCardsUpdatedSubscriber;
    private final Map<Callback, IEventSubscriber<FeedUpdatedEvent>> newsFeedSubscriberMap = new ConcurrentHashMap();
    private IEventSubscriber<BrazePushEvent> pushNotificationEventSubscriber;
    private final ReactApplicationContext reactApplicationContext;
    private IEventSubscriber<BrazeSdkAuthenticationErrorEvent> sdkAuthErrorSubscriber;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BrazeReactBridgeImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[BrazePushEventType.values().length];
            iArr[BrazePushEventType.NOTIFICATION_RECEIVED.ordinal()] = 1;
            iArr[BrazePushEventType.NOTIFICATION_OPENED.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ClickAction.values().length];
            iArr2[ClickAction.NEWS_FEED.ordinal()] = 1;
            iArr2[ClickAction.URI.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public final void removeListeners(int i) {
    }

    public BrazeReactBridgeImpl(ReactApplicationContext reactApplicationContext2, Activity activity) {
        Intrinsics.checkNotNullParameter(reactApplicationContext2, "reactApplicationContext");
        this.reactApplicationContext = reactApplicationContext2;
        this.currentActivity = activity;
        subscribeToContentCardsUpdatedEvent();
        subscribeToNewsFeedCardsUpdatedEvent();
        subscribeToSdkAuthenticationErrorEvents();
        subscribeToFeatureFlagsUpdatedEvent();
    }

    public final ReactApplicationContext getReactApplicationContext() {
        return this.reactApplicationContext;
    }

    public final Activity getCurrentActivity() {
        return this.currentActivity;
    }

    private final Braze getBraze() {
        return Braze.Companion.getInstance(this.reactApplicationContext);
    }

    public final void requestImmediateDataFlush() {
        getBraze().requestImmediateDataFlush();
    }

    public final void changeUser(String str, String str2) {
        getBraze().changeUser(str, str2);
    }

    public final void getUserId(Callback callback) {
        runOnUser(new BrazeReactBridgeImpl$getUserId$1(callback));
    }

    public final void addAlias(String str, String str2) {
        CharSequence charSequence = str;
        boolean z = false;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) BrazeReactBridgeImpl$addAlias$1.INSTANCE, 2, (Object) null);
            return;
        }
        CharSequence charSequence2 = str2;
        if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
            z = true;
        }
        if (z) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) BrazeReactBridgeImpl$addAlias$2.INSTANCE, 2, (Object) null);
        } else {
            runOnUser(new BrazeReactBridgeImpl$addAlias$3(str, str2));
        }
    }

    public final void registerPushToken(String str) {
        getBraze().setRegisteredPushToken(str);
    }

    public final void setGoogleAdvertisingId(String str, Boolean bool) {
        if (str != null && bool != null) {
            getBraze().setGoogleAdvertisingId(str, bool.booleanValue());
        }
    }

    public final void logCustomEvent(String str, ReadableMap readableMap) {
        getBraze().logCustomEvent(str, Companion.populateEventPropertiesFromReadableMap(readableMap));
    }

    public final void logPurchase(String str, String str2, String str3, int i, ReadableMap readableMap) {
        getBraze().logPurchase(str, str3, new BigDecimal(str2), i, Companion.populateEventPropertiesFromReadableMap(readableMap));
    }

    public final void setStringCustomUserAttribute(String str, String str2, Callback callback) {
        if (str == null || str2 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$setStringCustomUserAttribute$1.INSTANCE, 3, (Object) null);
            return;
        }
        runOnUser(new BrazeReactBridgeImpl$setStringCustomUserAttribute$2(callback, str, str2));
    }

    public final void setBoolCustomUserAttribute(String str, Boolean bool, Callback callback) {
        if (str == null || bool == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$setBoolCustomUserAttribute$1.INSTANCE, 3, (Object) null);
            return;
        }
        runOnUser(new BrazeReactBridgeImpl$setBoolCustomUserAttribute$2(callback, str, bool));
    }

    public final void setIntCustomUserAttribute(String str, int i, Callback callback) {
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$setIntCustomUserAttribute$1.INSTANCE, 3, (Object) null);
            return;
        }
        runOnUser(new BrazeReactBridgeImpl$setIntCustomUserAttribute$2(callback, str, i));
    }

    public final void setDoubleCustomUserAttribute(String str, float f, Callback callback) {
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$setDoubleCustomUserAttribute$1.INSTANCE, 3, (Object) null);
            return;
        }
        runOnUser(new BrazeReactBridgeImpl$setDoubleCustomUserAttribute$2(callback, str, f));
    }

    public final void setDateCustomUserAttribute(String str, int i, Callback callback) {
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$setDateCustomUserAttribute$1.INSTANCE, 3, (Object) null);
            return;
        }
        runOnUser(new BrazeReactBridgeImpl$setDateCustomUserAttribute$2(callback, str, i));
    }

    public final void incrementCustomUserAttribute(String str, int i, Callback callback) {
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$incrementCustomUserAttribute$1.INSTANCE, 3, (Object) null);
            return;
        }
        runOnUser(new BrazeReactBridgeImpl$incrementCustomUserAttribute$2(callback, str, i));
    }

    public final void unsetCustomUserAttribute(String str, Callback callback) {
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$unsetCustomUserAttribute$1.INSTANCE, 3, (Object) null);
            return;
        }
        runOnUser(new BrazeReactBridgeImpl$unsetCustomUserAttribute$2(callback, str));
    }

    public final void setCustomUserAttributeObjectArray(String str, ReadableArray readableArray, Callback callback) {
        ReadableArray readableArray2 = readableArray;
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$setCustomUserAttributeObjectArray$1.INSTANCE, 3, (Object) null);
        } else if (readableArray2 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$setCustomUserAttributeObjectArray$2.INSTANCE, 3, (Object) null);
        } else {
            runOnUser(new BrazeReactBridgeImpl$setCustomUserAttributeObjectArray$3(callback, str, new JSONArray((Collection<?>) Companion.parseReadableArray(readableArray2))));
        }
    }

    public final void setCustomUserAttributeArray(String str, ReadableArray readableArray, Callback callback) {
        ReadableArray readableArray2 = readableArray;
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$setCustomUserAttributeArray$1.INSTANCE, 3, (Object) null);
        } else if (readableArray2 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$setCustomUserAttributeArray$2.INSTANCE, 3, (Object) null);
        } else {
            int size = readableArray.size();
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                strArr[i] = readableArray2.getString(i);
            }
            runOnUser(new BrazeReactBridgeImpl$setCustomUserAttributeArray$3(callback, str, strArr));
        }
    }

    public final void setCustomUserAttributeObject(String str, ReadableMap readableMap, boolean z, Callback callback) {
        Intrinsics.checkNotNullParameter(readableMap, "value");
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$setCustomUserAttributeObject$1.INSTANCE, 3, (Object) null);
            return;
        }
        runOnUser(new BrazeReactBridgeImpl$setCustomUserAttributeObject$2(callback, str, new JSONObject((Map<?, ?>) Companion.parseReadableMap(readableMap)), z));
    }

    public final void addToCustomAttributeArray(String str, String str2, Callback callback) {
        if (str == null || str2 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$addToCustomAttributeArray$1.INSTANCE, 3, (Object) null);
            return;
        }
        runOnUser(new BrazeReactBridgeImpl$addToCustomAttributeArray$2(callback, str, str2));
    }

    public final void removeFromCustomAttributeArray(String str, String str2, Callback callback) {
        if (str == null || str2 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$removeFromCustomAttributeArray$1.INSTANCE, 3, (Object) null);
            return;
        }
        runOnUser(new BrazeReactBridgeImpl$removeFromCustomAttributeArray$2(callback, str, str2));
    }

    public final void setFirstName(String str) {
        runOnUser(new BrazeReactBridgeImpl$setFirstName$1(str));
    }

    public final void setLastName(String str) {
        runOnUser(new BrazeReactBridgeImpl$setLastName$1(str));
    }

    public final void setEmail(String str) {
        runOnUser(new BrazeReactBridgeImpl$setEmail$1(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0014, code lost:
        if (r1 == null) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setGender(java.lang.String r8, com.facebook.react.bridge.Callback r9) {
        /*
            r7 = this;
            com.braze.enums.Gender$Companion r0 = com.braze.enums.Gender.Companion
            if (r8 == 0) goto L_0x0016
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r2 = "US"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r1 = r8.toLowerCase(r1)
            java.lang.String r2 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            if (r1 != 0) goto L_0x0018
        L_0x0016:
            java.lang.String r1 = ""
        L_0x0018:
            com.braze.enums.Gender r0 = r0.getGender(r1)
            if (r0 != 0) goto L_0x0041
            com.braze.reactbridge.BrazeReactBridgeImpl$Companion r1 = Companion
            r3 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Invalid input "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r8 = r0.append(r8)
            java.lang.String r0 = ". Gender not set."
            java.lang.StringBuilder r8 = r8.append(r0)
            java.lang.String r4 = r8.toString()
            r5 = 1
            r6 = 0
            r2 = r9
            com.braze.reactbridge.BrazeReactBridgeImpl.Companion.reportResult$default(r1, r2, r3, r4, r5, r6)
            return
        L_0x0041:
            com.braze.reactbridge.BrazeReactBridgeImpl$setGender$1 r8 = new com.braze.reactbridge.BrazeReactBridgeImpl$setGender$1
            r8.<init>(r9, r0)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r7.runOnUser(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.reactbridge.BrazeReactBridgeImpl.setGender(java.lang.String, com.facebook.react.bridge.Callback):void");
    }

    public final void setDateOfBirth(int i, int i2, int i3) {
        runOnUser(new BrazeReactBridgeImpl$setDateOfBirth$1(i2, i, i3));
    }

    public final void setCountry(String str) {
        runOnUser(new BrazeReactBridgeImpl$setCountry$1(str));
    }

    public final void setHomeCity(String str) {
        runOnUser(new BrazeReactBridgeImpl$setHomeCity$1(str));
    }

    public final void setPhoneNumber(String str) {
        runOnUser(new BrazeReactBridgeImpl$setPhoneNumber$1(str));
    }

    public final void setLanguage(String str) {
        runOnUser(new BrazeReactBridgeImpl$setLanguage$1(str));
    }

    public final void addToSubscriptionGroup(String str, Callback callback) {
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$addToSubscriptionGroup$1.INSTANCE, 3, (Object) null);
            return;
        }
        runOnUser(new BrazeReactBridgeImpl$addToSubscriptionGroup$2(callback, str));
    }

    public final void removeFromSubscriptionGroup(String str, Callback callback) {
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$removeFromSubscriptionGroup$1.INSTANCE, 3, (Object) null);
            return;
        }
        runOnUser(new BrazeReactBridgeImpl$removeFromSubscriptionGroup$2(callback, str));
    }

    public final void setPushNotificationSubscriptionType(String str, Callback callback) {
        Companion companion = Companion;
        NotificationSubscriptionType access$parseNotificationSubscriptionType = companion.parseNotificationSubscriptionType(str);
        if (access$parseNotificationSubscriptionType == null) {
            Companion.reportResult$default(companion, callback, (Object) null, "Invalid subscription type " + str + ". Push notification subscription type not set.", 1, (Object) null);
            return;
        }
        runOnUser(new BrazeReactBridgeImpl$setPushNotificationSubscriptionType$1(callback, access$parseNotificationSubscriptionType));
    }

    public final void setEmailNotificationSubscriptionType(String str, Callback callback) {
        Companion companion = Companion;
        NotificationSubscriptionType access$parseNotificationSubscriptionType = companion.parseNotificationSubscriptionType(str);
        if (access$parseNotificationSubscriptionType == null) {
            Companion.reportResult$default(companion, callback, (Object) null, "Invalid subscription type " + str + ". Email notification subscription type not set.", 1, (Object) null);
            return;
        }
        runOnUser(new BrazeReactBridgeImpl$setEmailNotificationSubscriptionType$1(callback, access$parseNotificationSubscriptionType));
    }

    public final void launchNewsFeed() {
        Intent intent = new Intent(this.currentActivity, BrazeFeedActivity.class);
        intent.setFlags(872415232);
        this.reactApplicationContext.startActivity(intent);
    }

    public final void requestFeedRefresh() {
        getBraze().requestFeedRefresh();
    }

    public final void getNewsFeedCards(Promise promise) {
        getBraze().subscribeToFeedUpdates(new BrazeReactBridgeImpl$$ExternalSyntheticLambda10(promise, this));
        getBraze().requestFeedRefresh();
    }

    /* access modifiers changed from: private */
    /* renamed from: getNewsFeedCards$lambda-0  reason: not valid java name */
    public static final void m157getNewsFeedCards$lambda0(Promise promise, BrazeReactBridgeImpl brazeReactBridgeImpl, FeedUpdatedEvent feedUpdatedEvent) {
        Intrinsics.checkNotNullParameter(brazeReactBridgeImpl, "this$0");
        Intrinsics.checkNotNullParameter(feedUpdatedEvent, "it");
        if (promise != null) {
            List<Card> feedCards = feedUpdatedEvent.getFeedCards();
            Intrinsics.checkNotNullExpressionValue(feedCards, "it.feedCards");
            promise.resolve(ContentCardUtilKt.mapContentCards(feedCards));
        }
        brazeReactBridgeImpl.updateNewsFeedCardsIfNeeded(feedUpdatedEvent);
    }

    public final void logNewsFeedCardClicked(String str) {
        Card newsFeedCardById;
        if (str != null && (newsFeedCardById = getNewsFeedCardById(str)) != null) {
            newsFeedCardById.logClick();
        }
    }

    public final void logNewsFeedCardImpression(String str) {
        Card newsFeedCardById;
        if (str != null && (newsFeedCardById = getNewsFeedCardById(str)) != null) {
            newsFeedCardById.logImpression();
        }
    }

    public final void launchContentCards() {
        Intent intent = new Intent(this.currentActivity, ContentCardsActivity.class);
        intent.setFlags(872415232);
        this.reactApplicationContext.startActivity(intent);
    }

    public final void requestContentCardsRefresh() {
        getBraze().requestContentCardsRefresh();
    }

    public final void getContentCards(Promise promise) {
        getBraze().subscribeToContentCardsUpdates(new BrazeReactBridgeImpl$$ExternalSyntheticLambda3(promise, this));
        getBraze().requestContentCardsRefresh();
    }

    /* access modifiers changed from: private */
    /* renamed from: getContentCards$lambda-3  reason: not valid java name */
    public static final void m155getContentCards$lambda3(Promise promise, BrazeReactBridgeImpl brazeReactBridgeImpl, ContentCardsUpdatedEvent contentCardsUpdatedEvent) {
        Intrinsics.checkNotNullParameter(brazeReactBridgeImpl, "this$0");
        Intrinsics.checkNotNullParameter(contentCardsUpdatedEvent, "message");
        if (promise != null) {
            promise.resolve(ContentCardUtilKt.mapContentCards(contentCardsUpdatedEvent.getAllCards()));
        }
        brazeReactBridgeImpl.updateContentCardsIfNeeded(contentCardsUpdatedEvent);
    }

    public final void getCachedContentCards(Promise promise) {
        Lock lock = this.contentCardsLock;
        lock.lock();
        if (promise != null) {
            try {
                promise.resolve(ContentCardUtilKt.mapContentCards(this.contentCards));
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                lock.unlock();
                throw th;
            }
        }
        lock.unlock();
    }

    public final void setSdkAuthenticationSignature(String str) {
        if (str != null) {
            getBraze().setSdkAuthenticationSignature(str);
        }
    }

    public final void requestPushPermission(ReadableMap readableMap) {
        PermissionUtils.requestPushPermissionPrompt(this.currentActivity);
    }

    private final void subscribeToContentCardsUpdatedEvent() {
        IEventSubscriber<ContentCardsUpdatedEvent> iEventSubscriber = null;
        if (this.contentCardsUpdatedSubscriber != null) {
            Braze braze = getBraze();
            IEventSubscriber<ContentCardsUpdatedEvent> iEventSubscriber2 = this.contentCardsUpdatedSubscriber;
            if (iEventSubscriber2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentCardsUpdatedSubscriber");
                iEventSubscriber2 = null;
            }
            braze.removeSingleSubscription(iEventSubscriber2, ContentCardsUpdatedEvent.class);
        }
        this.contentCardsUpdatedSubscriber = new BrazeReactBridgeImpl$$ExternalSyntheticLambda1(this);
        Braze braze2 = getBraze();
        IEventSubscriber<ContentCardsUpdatedEvent> iEventSubscriber3 = this.contentCardsUpdatedSubscriber;
        if (iEventSubscriber3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentCardsUpdatedSubscriber");
        } else {
            iEventSubscriber = iEventSubscriber3;
        }
        braze2.subscribeToContentCardsUpdates(iEventSubscriber);
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeToContentCardsUpdatedEvent$lambda-5  reason: not valid java name */
    public static final void m159subscribeToContentCardsUpdatedEvent$lambda5(BrazeReactBridgeImpl brazeReactBridgeImpl, ContentCardsUpdatedEvent contentCardsUpdatedEvent) {
        Intrinsics.checkNotNullParameter(brazeReactBridgeImpl, "this$0");
        Intrinsics.checkNotNullParameter(contentCardsUpdatedEvent, "event");
        WritableMap createMap = Arguments.createMap();
        createMap.putArray("cards", ContentCardUtilKt.mapContentCards(contentCardsUpdatedEvent.getAllCards()));
        if (brazeReactBridgeImpl.reactApplicationContext.hasActiveReactInstance()) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) brazeReactBridgeImpl.reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(CONTENT_CARDS_UPDATED_EVENT_NAME, createMap);
        }
        brazeReactBridgeImpl.updateContentCardsIfNeeded(contentCardsUpdatedEvent);
    }

    private final void subscribeToNewsFeedCardsUpdatedEvent() {
        IEventSubscriber<FeedUpdatedEvent> iEventSubscriber = null;
        if (this.newsFeedCardsUpdatedSubscriber != null) {
            Braze braze = getBraze();
            IEventSubscriber<FeedUpdatedEvent> iEventSubscriber2 = this.newsFeedCardsUpdatedSubscriber;
            if (iEventSubscriber2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("newsFeedCardsUpdatedSubscriber");
                iEventSubscriber2 = null;
            }
            braze.removeSingleSubscription(iEventSubscriber2, FeedUpdatedEvent.class);
        }
        this.newsFeedCardsUpdatedSubscriber = new BrazeReactBridgeImpl$$ExternalSyntheticLambda4(this);
        Braze braze2 = getBraze();
        IEventSubscriber<FeedUpdatedEvent> iEventSubscriber3 = this.newsFeedCardsUpdatedSubscriber;
        if (iEventSubscriber3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newsFeedCardsUpdatedSubscriber");
        } else {
            iEventSubscriber = iEventSubscriber3;
        }
        braze2.subscribeToFeedUpdates(iEventSubscriber);
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeToNewsFeedCardsUpdatedEvent$lambda-6  reason: not valid java name */
    public static final void m161subscribeToNewsFeedCardsUpdatedEvent$lambda6(BrazeReactBridgeImpl brazeReactBridgeImpl, FeedUpdatedEvent feedUpdatedEvent) {
        Intrinsics.checkNotNullParameter(brazeReactBridgeImpl, "this$0");
        Intrinsics.checkNotNullParameter(feedUpdatedEvent, "event");
        boolean z = feedUpdatedEvent.lastUpdatedInSecondsFromEpoch() > brazeReactBridgeImpl.contentCardsUpdatedAt;
        if (z && brazeReactBridgeImpl.reactApplicationContext.hasActiveReactInstance()) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) brazeReactBridgeImpl.reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(NEWS_FEED_CARDS_UPDATED_EVENT_NAME, Boolean.valueOf(z));
        }
        brazeReactBridgeImpl.updateNewsFeedCardsIfNeeded(feedUpdatedEvent);
    }

    private final void subscribeToFeatureFlagsUpdatedEvent() {
        IEventSubscriber<FeatureFlagsUpdatedEvent> iEventSubscriber = null;
        if (this.featureFlagsUpdatedSubscriber != null) {
            Braze braze = getBraze();
            IEventSubscriber<FeatureFlagsUpdatedEvent> iEventSubscriber2 = this.featureFlagsUpdatedSubscriber;
            if (iEventSubscriber2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("featureFlagsUpdatedSubscriber");
                iEventSubscriber2 = null;
            }
            braze.removeSingleSubscription(iEventSubscriber2, FeatureFlagsUpdatedEvent.class);
        }
        this.featureFlagsUpdatedSubscriber = new BrazeReactBridgeImpl$$ExternalSyntheticLambda2(this);
        Braze braze2 = getBraze();
        IEventSubscriber<FeatureFlagsUpdatedEvent> iEventSubscriber3 = this.featureFlagsUpdatedSubscriber;
        if (iEventSubscriber3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("featureFlagsUpdatedSubscriber");
        } else {
            iEventSubscriber = iEventSubscriber3;
        }
        braze2.subscribeToFeatureFlagsUpdates(iEventSubscriber);
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeToFeatureFlagsUpdatedEvent$lambda-8  reason: not valid java name */
    public static final void m160subscribeToFeatureFlagsUpdatedEvent$lambda8(BrazeReactBridgeImpl brazeReactBridgeImpl, FeatureFlagsUpdatedEvent featureFlagsUpdatedEvent) {
        Intrinsics.checkNotNullParameter(brazeReactBridgeImpl, "this$0");
        Intrinsics.checkNotNullParameter(featureFlagsUpdatedEvent, "event");
        WritableArray createArray = Arguments.createArray();
        for (FeatureFlag convertFeatureFlag : featureFlagsUpdatedEvent.getFeatureFlags()) {
            createArray.pushMap(FeatureFlagUtilKt.convertFeatureFlag(convertFeatureFlag));
        }
        if (brazeReactBridgeImpl.reactApplicationContext.hasActiveReactInstance()) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) brazeReactBridgeImpl.reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(FEATURE_FLAGS_UPDATED_EVENT_NAME, createArray);
        }
    }

    private final void subscribeToSdkAuthenticationErrorEvents() {
        IEventSubscriber<BrazeSdkAuthenticationErrorEvent> iEventSubscriber = null;
        if (this.sdkAuthErrorSubscriber != null) {
            Braze braze = getBraze();
            IEventSubscriber<BrazeSdkAuthenticationErrorEvent> iEventSubscriber2 = this.sdkAuthErrorSubscriber;
            if (iEventSubscriber2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sdkAuthErrorSubscriber");
                iEventSubscriber2 = null;
            }
            braze.removeSingleSubscription(iEventSubscriber2, BrazeSdkAuthenticationErrorEvent.class);
        }
        this.sdkAuthErrorSubscriber = new BrazeReactBridgeImpl$$ExternalSyntheticLambda6(this);
        Braze braze2 = getBraze();
        IEventSubscriber<BrazeSdkAuthenticationErrorEvent> iEventSubscriber3 = this.sdkAuthErrorSubscriber;
        if (iEventSubscriber3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sdkAuthErrorSubscriber");
        } else {
            iEventSubscriber = iEventSubscriber3;
        }
        braze2.subscribeToSdkAuthenticationFailures(iEventSubscriber);
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeToSdkAuthenticationErrorEvents$lambda-9  reason: not valid java name */
    public static final void m163subscribeToSdkAuthenticationErrorEvents$lambda9(BrazeReactBridgeImpl brazeReactBridgeImpl, BrazeSdkAuthenticationErrorEvent brazeSdkAuthenticationErrorEvent) {
        Intrinsics.checkNotNullParameter(brazeReactBridgeImpl, "this$0");
        Intrinsics.checkNotNullParameter(brazeSdkAuthenticationErrorEvent, "errorEvent");
        if (brazeReactBridgeImpl.reactApplicationContext.hasActiveReactInstance()) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putInt("error_code", brazeSdkAuthenticationErrorEvent.getErrorCode());
            writableNativeMap.putString("user_id", brazeSdkAuthenticationErrorEvent.getUserId());
            writableNativeMap.putString("original_signature", brazeSdkAuthenticationErrorEvent.getSignature());
            writableNativeMap.putString("error_reason", brazeSdkAuthenticationErrorEvent.getErrorReason());
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) brazeReactBridgeImpl.reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(SDK_AUTH_ERROR_EVENT_NAME, writableNativeMap);
        }
    }

    private final void subscribeToPushNotificationEvents() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) BrazeReactBridgeImpl$subscribeToPushNotificationEvents$1.INSTANCE, 2, (Object) null);
        if (!this.reactApplicationContext.hasActiveReactInstance()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$subscribeToPushNotificationEvents$2.INSTANCE, 3, (Object) null);
            return;
        }
        IEventSubscriber<BrazePushEvent> iEventSubscriber = null;
        if (this.pushNotificationEventSubscriber != null) {
            Braze braze = getBraze();
            IEventSubscriber<BrazePushEvent> iEventSubscriber2 = this.pushNotificationEventSubscriber;
            if (iEventSubscriber2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pushNotificationEventSubscriber");
                iEventSubscriber2 = null;
            }
            braze.removeSingleSubscription(iEventSubscriber2, BrazePushEvent.class);
        }
        this.pushNotificationEventSubscriber = new BrazeReactBridgeImpl$$ExternalSyntheticLambda5(this);
        Braze braze2 = getBraze();
        IEventSubscriber<BrazePushEvent> iEventSubscriber3 = this.pushNotificationEventSubscriber;
        if (iEventSubscriber3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pushNotificationEventSubscriber");
        } else {
            iEventSubscriber = iEventSubscriber3;
        }
        braze2.subscribeToPushNotificationEvents(iEventSubscriber);
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeToPushNotificationEvents$lambda-14  reason: not valid java name */
    public static final void m162subscribeToPushNotificationEvents$lambda14(BrazeReactBridgeImpl brazeReactBridgeImpl, BrazePushEvent brazePushEvent) {
        String str;
        Intrinsics.checkNotNullParameter(brazeReactBridgeImpl, "this$0");
        Intrinsics.checkNotNullParameter(brazePushEvent, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[brazePushEvent.getEventType().ordinal()];
        boolean z = true;
        if (i == 1) {
            str = "push_received";
        } else if (i == 2) {
            str = "push_opened";
        } else {
            return;
        }
        BrazeNotificationPayload notificationPayload = brazePushEvent.getNotificationPayload();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("payload_type", str);
        writableNativeMap.putString("url", notificationPayload.getDeeplink());
        writableNativeMap.putString("title", notificationPayload.getTitleText());
        writableNativeMap.putString("body", notificationPayload.getContentText());
        writableNativeMap.putString("summary_text", notificationPayload.getSummaryText());
        Integer notificationBadgeNumber = notificationPayload.getNotificationBadgeNumber();
        if (notificationBadgeNumber != null) {
            writableNativeMap.putInt("badge_count", notificationBadgeNumber.intValue());
        }
        Long valueOf = Long.valueOf(notificationPayload.getNotificationExtras().getLong(Constants.BRAZE_PUSH_RECEIVED_TIMESTAMP_MILLIS));
        if (valueOf.longValue() == 0) {
            valueOf = null;
        }
        if (valueOf != null) {
            writableNativeMap.putInt("timestamp", (int) valueOf.longValue());
        }
        writableNativeMap.putBoolean(InAppMessageBase.OPEN_URI_IN_WEBVIEW, Intrinsics.areEqual((Object) notificationPayload.getNotificationExtras().getString(Constants.BRAZE_PUSH_OPEN_URI_IN_WEBVIEW_KEY), (Object) ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
        writableNativeMap.putBoolean("is_silent", notificationPayload.getTitleText() == null && notificationPayload.getContentText() == null);
        if (!notificationPayload.isUninstallTrackingPush() && !notificationPayload.getShouldSyncGeofences() && !notificationPayload.getShouldRefreshFeatureFlags()) {
            z = false;
        }
        writableNativeMap.putBoolean("is_braze_internal", z);
        writableNativeMap.putString("image_url", notificationPayload.getBigImageUrl());
        writableNativeMap.putMap("android", convertToMap$default(brazeReactBridgeImpl, notificationPayload.getNotificationExtras(), (Set) null, 2, (Object) null));
        writableNativeMap.putString("push_event_type", str);
        writableNativeMap.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, notificationPayload.getDeeplink());
        writableNativeMap.putString("content_text", notificationPayload.getContentText());
        writableNativeMap.putString("raw_android_push_data", notificationPayload.getNotificationExtras().toString());
        ReadableMap convertToMap = brazeReactBridgeImpl.convertToMap(notificationPayload.getBrazeExtras(), SetsKt.setOf(Constants.BRAZE_PUSH_BIG_IMAGE_URL_KEY));
        writableNativeMap.putMap("braze_properties", brazeReactBridgeImpl.convertToMap(notificationPayload.getBrazeExtras(), SetsKt.setOf(Constants.BRAZE_PUSH_BIG_IMAGE_URL_KEY)));
        writableNativeMap.putMap("kvp_data", convertToMap);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) brazeReactBridgeImpl, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeReactBridgeImpl$subscribeToPushNotificationEvents$4$1(writableNativeMap), 3, (Object) null);
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) brazeReactBridgeImpl.reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(PUSH_NOTIFICATION_EVENT_NAME, writableNativeMap);
    }

    public final void logContentCardDismissed(String str) {
        Card contentCardById;
        if (str != null && (contentCardById = getContentCardById(str)) != null) {
            contentCardById.setDismissed(true);
        }
    }

    public final void logContentCardClicked(String str) {
        Card contentCardById;
        if (str != null && (contentCardById = getContentCardById(str)) != null) {
            contentCardById.logClick();
        }
    }

    public final void logContentCardImpression(String str) {
        Card contentCardById;
        if (str != null && (contentCardById = getContentCardById(str)) != null) {
            contentCardById.logImpression();
        }
    }

    public final void processContentCardClickAction(String str) {
        Card contentCardById;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeReactBridgeImpl$processContentCardClickAction$1(str), 2, (Object) null);
        if (str != null && (contentCardById = getContentCardById(str)) != null) {
            Bundle bundle = new Bundle();
            for (String next : contentCardById.getExtras().keySet()) {
                bundle.putString(next, contentCardById.getExtras().get(next));
            }
            String url = contentCardById.getUrl();
            if (url == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) BrazeReactBridgeImpl$processContentCardClickAction$2$1.INSTANCE, 2, (Object) null);
                return;
            }
            UriAction createUriActionFromUrlString = BrazeDeeplinkHandler.Companion.getInstance().createUriActionFromUrlString(url, bundle, contentCardById.getOpenUriInWebView(), contentCardById.getChannel());
            if (createUriActionFromUrlString != null) {
                BrazeDeeplinkHandler.Companion.getInstance().gotoUri(this.reactApplicationContext, createUriActionFromUrlString);
            }
        }
    }

    private final void getCardCountForTag(String str, Callback callback, String str2) {
        if (callback != null) {
            Companion companion = Companion;
            CardCategory access$getCardCategoryFromString = companion.getCardCategoryFromString(str);
            if (str == null || (access$getCardCategoryFromString == null && !Intrinsics.areEqual((Object) str, (Object) "all"))) {
                Companion.reportResult$default(companion, callback, (Object) null, "Invalid card category " + str + ", could not retrieve" + str2, 1, (Object) null);
                return;
            }
            IEventSubscriber iEventSubscriber = null;
            boolean z = false;
            if (Intrinsics.areEqual((Object) str2, (Object) CARD_COUNT_TAG)) {
                iEventSubscriber = new BrazeReactBridgeImpl$$ExternalSyntheticLambda8(this, callback, str, access$getCardCategoryFromString);
            } else {
                if (Intrinsics.areEqual((Object) str2, (Object) UNREAD_CARD_COUNT_TAG)) {
                    iEventSubscriber = new BrazeReactBridgeImpl$$ExternalSyntheticLambda9(this, callback, str, access$getCardCategoryFromString);
                }
                if (z && iEventSubscriber != null) {
                    this.newsFeedSubscriberMap.put(callback, iEventSubscriber);
                    getBraze().subscribeToFeedUpdates(iEventSubscriber);
                    getBraze().requestFeedRefreshFromCache();
                    return;
                }
            }
            z = true;
            if (z) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getCardCountForTag$lambda-20  reason: not valid java name */
    public static final void m153getCardCountForTag$lambda20(BrazeReactBridgeImpl brazeReactBridgeImpl, Callback callback, String str, CardCategory cardCategory, FeedUpdatedEvent feedUpdatedEvent) {
        Intrinsics.checkNotNullParameter(brazeReactBridgeImpl, "this$0");
        Intrinsics.checkNotNullParameter(feedUpdatedEvent, "newsFeedUpdatedEvent");
        synchronized (brazeReactBridgeImpl.callbackCallLock) {
            if (brazeReactBridgeImpl.callbackCallMap.get(callback) == null) {
                brazeReactBridgeImpl.callbackCallMap.put(callback, true);
                if (Intrinsics.areEqual((Object) str, (Object) "all")) {
                    Companion.reportResult$default(Companion, callback, Integer.valueOf(feedUpdatedEvent.getCardCount()), (String) null, 2, (Object) null);
                } else {
                    Companion.reportResult$default(Companion, callback, Integer.valueOf(feedUpdatedEvent.getCardCount(cardCategory)), (String) null, 2, (Object) null);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        brazeReactBridgeImpl.getBraze().removeSingleSubscription(brazeReactBridgeImpl.newsFeedSubscriberMap.get(callback), FeedUpdatedEvent.class);
        brazeReactBridgeImpl.newsFeedSubscriberMap.remove(callback);
    }

    /* access modifiers changed from: private */
    /* renamed from: getCardCountForTag$lambda-22  reason: not valid java name */
    public static final void m154getCardCountForTag$lambda22(BrazeReactBridgeImpl brazeReactBridgeImpl, Callback callback, String str, CardCategory cardCategory, FeedUpdatedEvent feedUpdatedEvent) {
        Intrinsics.checkNotNullParameter(brazeReactBridgeImpl, "this$0");
        Intrinsics.checkNotNullParameter(feedUpdatedEvent, "newsFeedUpdatedEvent");
        synchronized (brazeReactBridgeImpl.callbackCallLock) {
            if (brazeReactBridgeImpl.callbackCallMap.get(callback) == null) {
                brazeReactBridgeImpl.callbackCallMap.put(callback, true);
                if (Intrinsics.areEqual((Object) str, (Object) "all")) {
                    Companion.reportResult$default(Companion, callback, Integer.valueOf(feedUpdatedEvent.getUnreadCardCount()), (String) null, 2, (Object) null);
                } else {
                    Companion.reportResult$default(Companion, callback, Integer.valueOf(feedUpdatedEvent.getUnreadCardCount(cardCategory)), (String) null, 2, (Object) null);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        brazeReactBridgeImpl.getBraze().removeSingleSubscription(brazeReactBridgeImpl.newsFeedSubscriberMap.get(callback), FeedUpdatedEvent.class);
        brazeReactBridgeImpl.newsFeedSubscriberMap.remove(callback);
    }

    public final void getCardCountForCategories(String str, Callback callback) {
        getCardCountForTag(str, callback, CARD_COUNT_TAG);
    }

    public final void getUnreadCardCountForCategories(String str, Callback callback) {
        getCardCountForTag(str, callback, UNREAD_CARD_COUNT_TAG);
    }

    public final void wipeData() {
        Braze.Companion.wipeData(this.reactApplicationContext);
    }

    public final void disableSDK() {
        Braze.Companion.disableSdk(this.reactApplicationContext);
    }

    public final void enableSDK() {
        Braze.Companion.enableSdk(this.reactApplicationContext);
    }

    public final void requestLocationInitialization() {
        getBraze().requestLocationInitialization();
    }

    public final void requestGeofences(Double d, Double d2) {
        if (d == null || d2 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$requestGeofences$1.INSTANCE, 3, (Object) null);
            return;
        }
        getBraze().requestGeofences(d.doubleValue(), d2.doubleValue());
    }

    public final void setLocationCustomAttribute(String str, Double d, Double d2, Callback callback) {
        if (str == null || d == null || d2 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$setLocationCustomAttribute$1.INSTANCE, 3, (Object) null);
            return;
        }
        runOnUser(new BrazeReactBridgeImpl$setLocationCustomAttribute$2(str, d, d2, callback));
    }

    public final void setLastKnownLocation(double d, double d2, double d3, double d4, double d5) {
        runOnUser(new BrazeReactBridgeImpl$setLastKnownLocation$1(d4, d5, d3, d, d2));
    }

    public final void subscribeToInAppMessage(boolean z) {
        InAppMessageOperation inAppMessageOperation;
        if (z) {
            inAppMessageOperation = InAppMessageOperation.DISPLAY_NOW;
        } else {
            inAppMessageOperation = InAppMessageOperation.DISPLAY_LATER;
        }
        this.inAppMessageDisplayOperation = inAppMessageOperation;
        setDefaultInAppMessageListener();
    }

    public final void hideCurrentInAppMessage() {
        BrazeInAppMessageManager.Companion.getInstance().hideCurrentlyDisplayingInAppMessage(true);
    }

    public final void logInAppMessageClicked(String str) {
        IInAppMessage deserializeInAppMessageString = getBraze().deserializeInAppMessageString(str);
        if (deserializeInAppMessageString != null) {
            deserializeInAppMessageString.logClick();
        }
    }

    public final Boolean logInAppMessageImpression(String str) {
        IInAppMessage deserializeInAppMessageString = getBraze().deserializeInAppMessageString(str);
        if (deserializeInAppMessageString != null) {
            return Boolean.valueOf(deserializeInAppMessageString.logImpression());
        }
        return null;
    }

    public final void logInAppMessageButtonClicked(String str, int i) {
        Object obj;
        boolean z;
        IInAppMessage deserializeInAppMessageString = getBraze().deserializeInAppMessageString(str);
        if (deserializeInAppMessageString instanceof IInAppMessageImmersive) {
            IInAppMessageImmersive iInAppMessageImmersive = (IInAppMessageImmersive) deserializeInAppMessageString;
            Iterator it = iInAppMessageImmersive.getMessageButtons().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((MessageButton) obj).getId() == i) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            MessageButton messageButton = (MessageButton) obj;
            if (messageButton != null) {
                iInAppMessageImmersive.logButtonClick(messageButton);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void performInAppMessageAction(java.lang.String r15, int r16) {
        /*
            r14 = this;
            r7 = r14
            r8 = r15
            r9 = r16
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.V
            com.braze.reactbridge.BrazeReactBridgeImpl$performInAppMessageAction$1 r1 = new com.braze.reactbridge.BrazeReactBridgeImpl$performInAppMessageAction$1
            r1.<init>(r15)
            r4 = r1
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r3 = 0
            r5 = 2
            r6 = 0
            r1 = r14
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (kotlin.jvm.functions.Function0) r4, (int) r5, (java.lang.Object) r6)
            com.braze.Braze r0 = r14.getBraze()
            com.braze.models.inappmessage.IInAppMessage r8 = r0.deserializeInAppMessageString(r15)
            if (r8 == 0) goto L_0x0154
            android.app.Activity r10 = r7.currentActivity
            if (r10 != 0) goto L_0x0036
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.W
            r3 = 0
            com.braze.reactbridge.BrazeReactBridgeImpl$performInAppMessageAction$2$1 r1 = com.braze.reactbridge.BrazeReactBridgeImpl$performInAppMessageAction$2$1.INSTANCE
            r4 = r1
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r5 = 2
            r6 = 0
            r1 = r14
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (kotlin.jvm.functions.Function0) r4, (int) r5, (java.lang.Object) r6)
            return
        L_0x0036:
            r11 = 1
            r0 = 0
            r1 = 0
            if (r9 < 0) goto L_0x0079
            boolean r2 = r8 instanceof com.braze.models.inappmessage.InAppMessageImmersiveBase
            if (r2 == 0) goto L_0x0069
            r2 = r8
            com.braze.models.inappmessage.InAppMessageImmersiveBase r2 = (com.braze.models.inappmessage.InAppMessageImmersiveBase) r2
            java.util.List r2 = r2.getMessageButtons()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x004c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0065
            java.lang.Object r3 = r2.next()
            r4 = r3
            com.braze.models.inappmessage.MessageButton r4 = (com.braze.models.inappmessage.MessageButton) r4
            int r4 = r4.getId()
            if (r4 != r9) goto L_0x0061
            r4 = r11
            goto L_0x0062
        L_0x0061:
            r4 = r0
        L_0x0062:
            if (r4 == 0) goto L_0x004c
            goto L_0x0066
        L_0x0065:
            r3 = r1
        L_0x0066:
            com.braze.models.inappmessage.MessageButton r3 = (com.braze.models.inappmessage.MessageButton) r3
            goto L_0x007a
        L_0x0069:
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            r2 = 0
            r3 = 0
            com.braze.reactbridge.BrazeReactBridgeImpl$performInAppMessageAction$2$3 r1 = com.braze.reactbridge.BrazeReactBridgeImpl$performInAppMessageAction$2$3.INSTANCE
            r4 = r1
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r5 = 3
            r6 = 0
            r1 = r14
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (kotlin.jvm.functions.Function0) r4, (int) r5, (java.lang.Object) r6)
            return
        L_0x0079:
            r3 = r1
        L_0x007a:
            if (r9 >= 0) goto L_0x0082
            com.braze.enums.inappmessage.ClickAction r2 = r8.getClickAction()
        L_0x0080:
            r12 = r2
            goto L_0x008a
        L_0x0082:
            if (r3 == 0) goto L_0x0089
            com.braze.enums.inappmessage.ClickAction r2 = r3.getClickAction()
            goto L_0x0080
        L_0x0089:
            r12 = r1
        L_0x008a:
            if (r9 >= 0) goto L_0x0092
            android.net.Uri r1 = r8.getUri()
        L_0x0090:
            r13 = r1
            goto L_0x0099
        L_0x0092:
            if (r3 == 0) goto L_0x0090
            android.net.Uri r1 = r3.getUri()
            goto L_0x0090
        L_0x0099:
            if (r9 >= 0) goto L_0x00a1
            boolean r0 = r8.getOpenUriInWebView()
        L_0x009f:
            r9 = r0
            goto L_0x00a8
        L_0x00a1:
            if (r3 == 0) goto L_0x009f
            boolean r0 = r3.getOpenUriInWebview()
            goto L_0x009f
        L_0x00a8:
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            r2 = 0
            r3 = 0
            com.braze.reactbridge.BrazeReactBridgeImpl$performInAppMessageAction$2$4 r1 = new com.braze.reactbridge.BrazeReactBridgeImpl$performInAppMessageAction$2$4
            r1.<init>(r13, r9, r12)
            r4 = r1
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r5 = 3
            r6 = 0
            r1 = r14
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (kotlin.jvm.functions.Function0) r4, (int) r5, (java.lang.Object) r6)
            if (r12 != 0) goto L_0x00be
            r0 = -1
            goto L_0x00c6
        L_0x00be:
            int[] r0 = com.braze.reactbridge.BrazeReactBridgeImpl.WhenMappings.$EnumSwitchMapping$1
            int r1 = r12.ordinal()
            r0 = r0[r1]
        L_0x00c6:
            if (r0 == r11) goto L_0x013a
            r1 = 2
            if (r0 == r1) goto L_0x00df
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            r2 = 0
            r3 = 0
            com.braze.reactbridge.BrazeReactBridgeImpl$performInAppMessageAction$2$8 r1 = new com.braze.reactbridge.BrazeReactBridgeImpl$performInAppMessageAction$2$8
            r1.<init>(r12)
            r4 = r1
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r5 = 3
            r6 = 0
            r1 = r14
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (kotlin.jvm.functions.Function0) r4, (int) r5, (java.lang.Object) r6)
            goto L_0x0154
        L_0x00df:
            if (r13 != 0) goto L_0x00f1
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            r2 = 0
            r3 = 0
            com.braze.reactbridge.BrazeReactBridgeImpl$performInAppMessageAction$2$5 r1 = com.braze.reactbridge.BrazeReactBridgeImpl$performInAppMessageAction$2$5.INSTANCE
            r4 = r1
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r5 = 3
            r6 = 0
            r1 = r14
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (kotlin.jvm.functions.Function0) r4, (int) r5, (java.lang.Object) r6)
            return
        L_0x00f1:
            com.braze.ui.BrazeDeeplinkHandler$Companion r0 = com.braze.ui.BrazeDeeplinkHandler.Companion
            com.braze.IBrazeDeeplinkHandler r0 = r0.getInstance()
            java.util.Map r1 = r8.getExtras()
            android.os.Bundle r1 = com.braze.support.BundleUtils.toBundle(r1)
            com.braze.enums.Channel r2 = com.braze.enums.Channel.INAPP_MESSAGE
            com.braze.ui.actions.UriAction r8 = r0.createUriActionFromUri(r13, r1, r9, r2)
            com.facebook.react.bridge.ReactApplicationContext r0 = r7.reactApplicationContext
            if (r0 != 0) goto L_0x0119
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            r2 = 0
            r3 = 0
            com.braze.reactbridge.BrazeReactBridgeImpl$performInAppMessageAction$2$6 r1 = com.braze.reactbridge.BrazeReactBridgeImpl$performInAppMessageAction$2$6.INSTANCE
            r4 = r1
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r5 = 3
            r6 = 0
            r1 = r14
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (kotlin.jvm.functions.Function0) r4, (int) r5, (java.lang.Object) r6)
            return
        L_0x0119:
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.W
            r3 = 0
            com.braze.reactbridge.BrazeReactBridgeImpl$performInAppMessageAction$2$7 r1 = new com.braze.reactbridge.BrazeReactBridgeImpl$performInAppMessageAction$2$7
            r1.<init>(r13, r9)
            r4 = r1
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r5 = 2
            r6 = 0
            r1 = r14
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (kotlin.jvm.functions.Function0) r4, (int) r5, (java.lang.Object) r6)
            com.braze.ui.BrazeDeeplinkHandler$Companion r0 = com.braze.ui.BrazeDeeplinkHandler.Companion
            com.braze.IBrazeDeeplinkHandler r0 = r0.getInstance()
            com.facebook.react.bridge.ReactApplicationContext r1 = r7.reactApplicationContext
            android.content.Context r1 = (android.content.Context) r1
            r0.gotoUri(r1, r8)
            goto L_0x0154
        L_0x013a:
            com.braze.ui.actions.NewsfeedAction r0 = new com.braze.ui.actions.NewsfeedAction
            java.util.Map r1 = r8.getExtras()
            android.os.Bundle r1 = com.braze.support.BundleUtils.toBundle(r1)
            com.braze.enums.Channel r2 = com.braze.enums.Channel.INAPP_MESSAGE
            r0.<init>(r1, r2)
            com.braze.ui.BrazeDeeplinkHandler$Companion r1 = com.braze.ui.BrazeDeeplinkHandler.Companion
            com.braze.IBrazeDeeplinkHandler r1 = r1.getInstance()
            android.content.Context r10 = (android.content.Context) r10
            r1.gotoNewsFeed(r10, r0)
        L_0x0154:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.reactbridge.BrazeReactBridgeImpl.performInAppMessageAction(java.lang.String, int):void");
    }

    public final void setAttributionData(String str, String str2, String str3, String str4) {
        if (str == null || str2 == null || str3 == null || str4 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeReactBridgeImpl$setAttributionData$1.INSTANCE, 3, (Object) null);
            return;
        }
        runOnUser(new BrazeReactBridgeImpl$setAttributionData$2(new AttributionData(str, str2, str3, str4)));
    }

    /* access modifiers changed from: private */
    /* renamed from: getDeviceId$lambda-27  reason: not valid java name */
    public static final void m156getDeviceId$lambda27(Callback callback, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        Companion.reportResult$default(Companion, callback, str, (String) null, 2, (Object) null);
    }

    public final void getDeviceId(Callback callback) {
        getBraze().getDeviceIdAsync(new BrazeReactBridgeImpl$$ExternalSyntheticLambda0(callback));
    }

    private final void runOnUser(Function1<? super BrazeUser, Unit> function1) {
        getBraze().getCurrentUser(new BrazeReactBridgeImpl$$ExternalSyntheticLambda7(function1));
    }

    /* access modifiers changed from: private */
    /* renamed from: runOnUser$lambda-28  reason: not valid java name */
    public static final void m158runOnUser$lambda28(Function1 function1, BrazeUser brazeUser) {
        Intrinsics.checkNotNullParameter(function1, "$block");
        Intrinsics.checkNotNullParameter(brazeUser, "it");
        function1.invoke(brazeUser);
    }

    public final void addListener(String str) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        if (Intrinsics.areEqual((Object) str, (Object) PUSH_NOTIFICATION_EVENT_NAME)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeReactBridgeImpl$addListener$1(str), 3, (Object) null);
            subscribeToPushNotificationEvents();
        } else if (Intrinsics.areEqual((Object) str, (Object) IN_APP_MESSAGE_RECEIVED_EVENT_NAME) && (BrazeInAppMessageManager.Companion.getInstance().getInAppMessageManagerListener() instanceof DefaultInAppMessageManagerListener)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeReactBridgeImpl$addListener$2(str), 3, (Object) null);
            setDefaultInAppMessageListener();
        }
    }

    private final void updateContentCardsIfNeeded(ContentCardsUpdatedEvent contentCardsUpdatedEvent) {
        if (contentCardsUpdatedEvent.getTimestampSeconds() > this.contentCardsUpdatedAt) {
            Lock lock = this.contentCardsLock;
            lock.lock();
            try {
                this.contentCardsUpdatedAt = contentCardsUpdatedEvent.getTimestampSeconds();
                this.contentCards.clear();
                this.contentCards.addAll(contentCardsUpdatedEvent.getAllCards());
            } finally {
                lock.unlock();
            }
        }
    }

    private final void updateNewsFeedCardsIfNeeded(FeedUpdatedEvent feedUpdatedEvent) {
        if (feedUpdatedEvent.lastUpdatedInSecondsFromEpoch() > this.newsFeedCardsUpdatedAt) {
            this.newsFeedCardsUpdatedAt = feedUpdatedEvent.lastUpdatedInSecondsFromEpoch();
            this.newsFeedCards.clear();
            List<Card> list = this.newsFeedCards;
            List<Card> feedCards = feedUpdatedEvent.getFeedCards();
            Intrinsics.checkNotNullExpressionValue(feedCards, "event.feedCards");
            list.addAll(feedCards);
        }
    }

    private final Card getNewsFeedCardById(String str) {
        Object obj;
        Iterator it = this.newsFeedCards.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((Card) obj).getId(), (Object) str)) {
                break;
            }
        }
        return (Card) obj;
    }

    private final Card getContentCardById(String str) {
        Object obj;
        Lock lock = this.contentCardsLock;
        lock.lock();
        try {
            Iterator it = this.contentCards.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((Card) obj).getId(), (Object) str)) {
                    break;
                }
            }
            return (Card) obj;
        } finally {
            lock.unlock();
        }
    }

    public final void getAllFeatureFlags(Promise promise) {
        List<FeatureFlag> allFeatureFlags = getBraze().getAllFeatureFlags();
        WritableArray createArray = Arguments.createArray();
        for (FeatureFlag convertFeatureFlag : allFeatureFlags) {
            createArray.pushMap(FeatureFlagUtilKt.convertFeatureFlag(convertFeatureFlag));
        }
        if (promise != null) {
            promise.resolve(createArray);
        }
    }

    public final void getFeatureFlag(String str, Promise promise) {
        if (str != null && promise != null) {
            FeatureFlag featureFlag = getBraze().getFeatureFlag(str);
            if (featureFlag == null) {
                promise.resolve((Object) null);
            } else {
                promise.resolve(FeatureFlagUtilKt.convertFeatureFlag(featureFlag));
            }
        }
    }

    public final void refreshFeatureFlags() {
        getBraze().refreshFeatureFlags();
    }

    public final void logFeatureFlagImpression(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        getBraze().logFeatureFlagImpression(str);
    }

    public final void getFeatureFlagBooleanProperty(String str, String str2, Promise promise) {
        if (str != null && str2 != null && promise != null) {
            FeatureFlag featureFlag = getBraze().getFeatureFlag(str);
            promise.resolve(featureFlag != null ? featureFlag.getBooleanProperty(str2) : null);
        }
    }

    public final void getFeatureFlagStringProperty(String str, String str2, Promise promise) {
        if (str != null && str2 != null && promise != null) {
            FeatureFlag featureFlag = getBraze().getFeatureFlag(str);
            promise.resolve(featureFlag != null ? featureFlag.getStringProperty(str2) : null);
        }
    }

    public final void getFeatureFlagNumberProperty(String str, String str2, Promise promise) {
        if (str != null && str2 != null && promise != null) {
            FeatureFlag featureFlag = getBraze().getFeatureFlag(str);
            promise.resolve(featureFlag != null ? featureFlag.getNumberProperty(str2) : null);
        }
    }

    private final void setDefaultInAppMessageListener() {
        BrazeInAppMessageManager.Companion.getInstance().setCustomInAppMessageManagerListener(new BrazeReactBridgeImpl$setDefaultInAppMessageListener$1(this));
    }

    static /* synthetic */ ReadableMap convertToMap$default(BrazeReactBridgeImpl brazeReactBridgeImpl, Bundle bundle, Set set, int i, Object obj) {
        if ((i & 2) != 0) {
            set = SetsKt.emptySet();
        }
        return brazeReactBridgeImpl.convertToMap(bundle, set);
    }

    private final ReadableMap convertToMap(Bundle bundle, Set<String> set) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        Set keySet = bundle.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "bundle.keySet()");
        Collection arrayList = new ArrayList();
        for (Object next : keySet) {
            if (!set.contains((String) next)) {
                arrayList.add(next);
            }
        }
        Iterable iterable = (List) arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next2 : iterable) {
            linkedHashMap.put(next2, bundle.get((String) next2));
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            writableNativeMap.putString((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        return writableNativeMap;
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u0004\u0018\u00010\u0004H\u0002J&\u0010\u001d\u001a\u00020\u001e*\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/braze/reactbridge/BrazeReactBridgeImpl$Companion;", "", "()V", "CARD_COUNT_TAG", "", "CONTENT_CARDS_UPDATED_EVENT_NAME", "FEATURE_FLAGS_UPDATED_EVENT_NAME", "IN_APP_MESSAGE_RECEIVED_EVENT_NAME", "NAME", "NEWS_FEED_CARDS_UPDATED_EVENT_NAME", "PUSH_NOTIFICATION_EVENT_NAME", "SDK_AUTH_ERROR_EVENT_NAME", "UNREAD_CARD_COUNT_TAG", "getCardCategoryFromString", "Lcom/braze/enums/CardCategory;", "categoryString", "parseReadableArray", "", "readableArray", "Lcom/facebook/react/bridge/ReadableArray;", "parseReadableMap", "", "readableMap", "Lcom/facebook/react/bridge/ReadableMap;", "populateEventPropertiesFromReadableMap", "Lcom/braze/models/outgoing/BrazeProperties;", "eventProperties", "parseNotificationSubscriptionType", "Lcom/braze/enums/NotificationSubscriptionType;", "reportResult", "", "Lcom/facebook/react/bridge/Callback;", "result", "error", "braze_react-native-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BrazeReactBridgeImpl.kt */
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* compiled from: BrazeReactBridgeImpl.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ReadableType.values().length];
                iArr[ReadableType.Map.ordinal()] = 1;
                iArr[ReadableType.Array.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        static /* synthetic */ void reportResult$default(Companion companion, Callback callback, Object obj, String str, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = null;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            companion.reportResult(callback, obj, str);
        }

        /* access modifiers changed from: private */
        public final void reportResult(Callback callback, Object obj, String str) {
            if (callback == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) BrazeReactBridgeImpl$Companion$reportResult$1.INSTANCE, 2, (Object) null);
            } else if (str != null) {
                callback.invoke(str);
            } else {
                callback.invoke(null, obj);
            }
        }

        /* access modifiers changed from: private */
        public final BrazeProperties populateEventPropertiesFromReadableMap(ReadableMap readableMap) {
            if (readableMap == null) {
                return null;
            }
            if (Intrinsics.areEqual((Object) readableMap, JSONObject.NULL)) {
                return new BrazeProperties();
            }
            return new BrazeProperties(new JSONObject(parseReadableMap(readableMap)));
        }

        /* access modifiers changed from: private */
        public final Map<?, ?> parseReadableMap(ReadableMap readableMap) {
            ReadableArray array;
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            Intrinsics.checkNotNullExpressionValue(keySetIterator, "readableMap.keySetIterator()");
            HashMap<String, Object> hashMap = readableMap.toHashMap();
            Intrinsics.checkNotNullExpressionValue(hashMap, "readableMap.toHashMap()");
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                int i = WhenMappings.$EnumSwitchMapping$0[readableMap.getType(nextKey).ordinal()];
                if (i == 1) {
                    ReadableMap map = readableMap.getMap(nextKey);
                    if (map != null) {
                        if (!map.hasKey("type") || map.getType("type") != ReadableType.String || !Intrinsics.areEqual((Object) map.getString("type"), (Object) "UNIX_timestamp")) {
                            hashMap.put(nextKey, parseReadableMap(map));
                        } else {
                            hashMap.put(nextKey, new Date((long) map.getDouble("value")));
                        }
                    }
                } else if (i == 2 && (array = readableMap.getArray(nextKey)) != null) {
                    hashMap.put(nextKey, BrazeReactBridgeImpl.Companion.parseReadableArray(array));
                }
            }
            return hashMap;
        }

        /* access modifiers changed from: private */
        public final List<?> parseReadableArray(ReadableArray readableArray) {
            ArrayList<Object> arrayList = readableArray.toArrayList();
            Intrinsics.checkNotNullExpressionValue(arrayList, "readableArray.toArrayList()");
            int size = readableArray.size();
            for (int i = 0; i < size; i++) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[readableArray.getType(i).ordinal()];
                if (i2 == 1) {
                    ReadableMap map = readableArray.getMap(i);
                    Intrinsics.checkNotNullExpressionValue(map, "readableArray.getMap(i)");
                    if (!map.hasKey("type") || map.getType("type") != ReadableType.String || !Intrinsics.areEqual((Object) map.getString("type"), (Object) "UNIX_timestamp")) {
                        ReadableMap map2 = readableArray.getMap(i);
                        Intrinsics.checkNotNullExpressionValue(map2, "readableArray.getMap(i)");
                        arrayList.set(i, parseReadableMap(map2));
                    } else {
                        arrayList.set(i, new Date((long) map.getDouble("value")));
                    }
                } else if (i2 == 2) {
                    ReadableArray array = readableArray.getArray(i);
                    Intrinsics.checkNotNullExpressionValue(array, "readableArray.getArray(i)");
                    arrayList.set(i, parseReadableArray(array));
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public final NotificationSubscriptionType parseNotificationSubscriptionType(String str) {
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1249604809) {
                    if (hashCode != -1219769254) {
                        if (hashCode == 901853107 && str.equals("unsubscribed")) {
                            return NotificationSubscriptionType.UNSUBSCRIBED;
                        }
                    } else if (str.equals("subscribed")) {
                        return NotificationSubscriptionType.SUBSCRIBED;
                    }
                } else if (str.equals("optedin")) {
                    return NotificationSubscriptionType.OPTED_IN;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public final CardCategory getCardCategoryFromString(String str) {
            if (str == null) {
                return null;
            }
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String upperCase = str.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            if (upperCase == null) {
                return null;
            }
            for (CardCategory cardCategory : CardCategory.values()) {
                if (Intrinsics.areEqual((Object) cardCategory.name(), (Object) upperCase)) {
                    return cardCategory;
                }
            }
            return null;
        }
    }
}
