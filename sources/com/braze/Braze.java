package com.braze;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import bo.app.f6;
import bo.app.g5;
import bo.app.i5;
import bo.app.j;
import bo.app.q4;
import bo.app.w6;
import bo.app.x6;
import bo.app.y3;
import com.braze.configuration.BrazeConfig;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.configuration.RuntimeAppConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.enums.BrazePushEventType;
import com.braze.enums.BrazeSdkMetadata;
import com.braze.enums.GeofenceTransitionType;
import com.braze.events.BrazeNetworkFailureEvent;
import com.braze.events.BrazePushEvent;
import com.braze.events.BrazeSdkAuthenticationErrorEvent;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.events.FeatureFlagsUpdatedEvent;
import com.braze.events.FeedUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.braze.events.IValueCallback;
import com.braze.events.InAppMessageEvent;
import com.braze.events.NoMatchingTriggerEvent;
import com.braze.events.SdkDataWipeEvent;
import com.braze.events.SessionStateChangedEvent;
import com.braze.images.DefaultBrazeImageLoader;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.FeatureFlag;
import com.braze.models.IBrazeLocation;
import com.braze.models.cards.Card;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.outgoing.BrazeLocation;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.models.push.BrazeNotificationPayload;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.PermissionUtils;
import com.braze.support.StringUtils;
import com.braze.support.ValidationUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000à\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0007\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002B\u0015\b\u0001\u0012\b\u0010\u0002\u001a\u00030Æ\u0001¢\u0006\u0006\b\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002Ja\u0010\u001d\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u00028\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00042'\u0010\u001c\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0017¢\u0006\u0002\b\u001bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010!\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010\"\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010$\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010$\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u000f2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J&\u0010+\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000f2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J0\u0010+\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000f2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J.\u0010+\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000f2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010-\u001a\u00020,H\u0016J8\u0010+\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000f2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010-\u001a\u00020,2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010/\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010/\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u000100H\u0016J&\u00104\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\u000f2\b\u00102\u001a\u0004\u0018\u00010\u000f2\b\u00103\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u00106\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\u000f2\b\u00105\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u00107\u001a\u00020\u0006H\u0016J\b\u00108\u001a\u00020\u0006H\u0016J\b\u00109\u001a\u00020\u0006H\u0016J\u0010\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0004H\u0017J\b\u0010;\u001a\u00020\u0006H\u0016J\b\u0010<\u001a\u00020\u0006H\u0016J\b\u0010=\u001a\u00020\u0006H\u0016J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020?0>H\u0016J\u0012\u0010B\u001a\u0004\u0018\u00010?2\u0006\u0010A\u001a\u00020\u000fH\u0016J\u0010\u0010C\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u000fH\u0016J\b\u0010D\u001a\u00020\u0006H\u0016J\u0016\u0010H\u001a\u00020\u00062\f\u0010G\u001a\b\u0012\u0004\u0012\u00020F0EH\u0016J\u0016\u0010J\u001a\u00020\u00062\f\u0010G\u001a\b\u0012\u0004\u0012\u00020I0EH\u0016J\u0016\u0010L\u001a\u00020\u00062\f\u0010G\u001a\b\u0012\u0004\u0012\u00020K0EH\u0016J\u0016\u0010N\u001a\u00020\u00062\f\u0010G\u001a\b\u0012\u0004\u0012\u00020M0EH\u0016J\u0016\u0010P\u001a\u00020\u00062\f\u0010G\u001a\b\u0012\u0004\u0012\u00020O0EH\u0016J\u0016\u0010R\u001a\u00020\u00062\f\u0010G\u001a\b\u0012\u0004\u0012\u00020Q0EH\u0016J\u0016\u0010T\u001a\u00020\u00062\f\u0010G\u001a\b\u0012\u0004\u0012\u00020S0EH\u0016J\u0016\u0010V\u001a\u00020\u00062\f\u0010G\u001a\b\u0012\u0004\u0012\u00020U0EH\u0016J\u0016\u0010X\u001a\u00020\u00062\f\u0010G\u001a\b\u0012\u0004\u0012\u00020W0EH\u0016J*\u0010[\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00122\f\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000E2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000YH\u0016J,\u0010\\\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00122\u000e\u0010G\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010E2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000YH\u0016J\u0012\u0010^\u001a\u00020\u00062\b\u0010]\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010^\u001a\u00020\u00062\b\u0010]\u001a\u0004\u0018\u00010\u000f2\b\u0010_\u001a\u0004\u0018\u00010\u000fH\u0016J\u0016\u0010c\u001a\u00020\u00062\f\u0010b\u001a\b\u0012\u0004\u0012\u00020a0`H\u0016J\u0016\u0010d\u001a\u00020\u00062\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u000f0`H\u0016J\b\u0010e\u001a\u00020,H\u0016J\b\u0010f\u001a\u00020,H\u0016J\b\u0010h\u001a\u00020gH\u0016J\u0010\u0010j\u001a\n\u0012\u0004\u0012\u00020i\u0018\u00010>H\u0016J\u0014\u0010l\u001a\u0004\u0018\u00010i2\b\u0010k\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010l\u001a\u0004\u0018\u00010i2\b\u0010n\u001a\u0004\u0018\u00010mH\u0016J\u0012\u0010p\u001a\u00020\u00062\b\u0010o\u001a\u0004\u0018\u00010\u000fH\u0017J\u0012\u0010q\u001a\u00020\u00062\b\u0010o\u001a\u0004\u0018\u00010\u000fH\u0017J\u0014\u0010t\u001a\u0004\u0018\u00010s2\b\u0010r\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010x\u001a\u00020\u00062\u0006\u0010v\u001a\u00020u2\u0006\u0010w\u001a\u00020uH\u0016J\b\u0010y\u001a\u00020\u0006H\u0016J\u0018\u0010|\u001a\u00020\u00062\u0006\u0010z\u001a\u00020\u000f2\u0006\u0010{\u001a\u00020\u0004H\u0016J\u0010\u0010~\u001a\u00020\u00062\u0006\u0010}\u001a\u00020\u000fH\u0016J(\u0010\u0001\u001a\u00020\u00062\b\u0010\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u00062\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u0004H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J%\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u000f2\b\u0010]\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\u00062\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0012\u0010\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0012\u0010\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001a\u0010\u0001\u001a\u00020\u00062\u0006\u00101\u001a\u000200H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0012\u0010\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020FH\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010¡\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020FH\u0000¢\u0006\u0006\b \u0001\u0010\u0001J&\u0010¨\u0001\u001a\u00020\u00062\b\u0010£\u0001\u001a\u00030¢\u00012\b\u0010¥\u0001\u001a\u00030¤\u0001H\u0000¢\u0006\u0006\b¦\u0001\u0010§\u0001J#\u0010¬\u0001\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u000f2\u0007\u0010©\u0001\u001a\u00020gH\u0000¢\u0006\u0006\bª\u0001\u0010«\u0001J\u001b\u0010¯\u0001\u001a\u00020\u00062\u0007\u0010©\u0001\u001a\u00020gH\u0000¢\u0006\u0006\b­\u0001\u0010®\u0001J\u0012\u0010±\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0006\b°\u0001\u0010\u0001J\u001b\u0010µ\u0001\u001a\u00020\u00062\u0007\u0010²\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0006\b³\u0001\u0010´\u0001J\u001b\u0010¹\u0001\u001a\u00020\u00042\u0007\u0010¶\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0006\b·\u0001\u0010¸\u0001J\u0012\u0010»\u0001\u001a\u00020\u0006H\u0001¢\u0006\u0006\bº\u0001\u0010\u0001J:\u0010¾\u0001\u001a\u00020\u00062\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0001¢\u0006\u0006\b¼\u0001\u0010½\u0001R*\u0010À\u0001\u001a\u00030¿\u00018\u0016@\u0016X.¢\u0006\u0018\n\u0006\bÀ\u0001\u0010Á\u0001\u001a\u0006\bÂ\u0001\u0010Ã\u0001\"\u0006\bÄ\u0001\u0010Å\u0001R\u001a\u0010Ç\u0001\u001a\u00030Æ\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u001a\u0010Ê\u0001\u001a\u00030É\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u0019\u0010Ì\u0001\u001a\u00020a8\u0002@\u0002X.¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R3\u0010Î\u0001\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u000e¢\u0006 \n\u0006\bÎ\u0001\u0010Ï\u0001\u0012\u0006\bÔ\u0001\u0010\u0001\u001a\u0006\bÐ\u0001\u0010Ñ\u0001\"\u0006\bÒ\u0001\u0010Ó\u0001R\u0019\u0010Õ\u0001\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R2\u0010Ø\u0001\u001a\u00030×\u00018\u0000@\u0000X.¢\u0006 \n\u0006\bØ\u0001\u0010Ù\u0001\u0012\u0006\bÞ\u0001\u0010\u0001\u001a\u0006\bÚ\u0001\u0010Û\u0001\"\u0006\bÜ\u0001\u0010Ý\u0001R2\u0010à\u0001\u001a\u00030ß\u00018\u0000@\u0000X\u000e¢\u0006 \n\u0006\bà\u0001\u0010á\u0001\u0012\u0006\bæ\u0001\u0010\u0001\u001a\u0006\bâ\u0001\u0010ã\u0001\"\u0006\bä\u0001\u0010å\u0001R\"\u0010è\u0001\u001a\u00030ç\u00018\u0002@\u0002X.¢\u0006\u0010\n\u0006\bè\u0001\u0010é\u0001\u0012\u0006\bê\u0001\u0010\u0001R2\u0010ì\u0001\u001a\u00030ë\u00018\u0000@\u0000X.¢\u0006 \n\u0006\bì\u0001\u0010í\u0001\u0012\u0006\bò\u0001\u0010\u0001\u001a\u0006\bî\u0001\u0010ï\u0001\"\u0006\bð\u0001\u0010ñ\u0001R2\u0010ô\u0001\u001a\u00030ó\u00018\u0000@\u0000X.¢\u0006 \n\u0006\bô\u0001\u0010õ\u0001\u0012\u0006\bú\u0001\u0010\u0001\u001a\u0006\bö\u0001\u0010÷\u0001\"\u0006\bø\u0001\u0010ù\u0001R2\u0010ü\u0001\u001a\u00030û\u00018\u0000@\u0000X.¢\u0006 \n\u0006\bü\u0001\u0010ý\u0001\u0012\u0006\b\u0002\u0010\u0001\u001a\u0006\bþ\u0001\u0010ÿ\u0001\"\u0006\b\u0002\u0010\u0002R\u0019\u0010\u0002\u001a\u0004\u0018\u00010K8BX\u0004¢\u0006\b\u001a\u0006\b\u0002\u0010\u0002R\u0017\u0010\u0002\u001a\u00020\u000f8VX\u0004¢\u0006\b\u001a\u0006\b\u0002\u0010\u0002R\u0018\u0010\u0002\u001a\u0004\u0018\u00010a8VX\u0004¢\u0006\u0007\u001a\u0005\bc\u0010\u0002R.\u0010\u0002\u001a\u0004\u0018\u00010\u000f2\t\u0010\u0002\u001a\u0004\u0018\u00010\u000f8V@VX\u000e¢\u0006\u0010\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010´\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006\u0002"}, d2 = {"Lcom/braze/Braze;", "Lcom/braze/IBraze;", "Lbo/app/d2;", "getDeviceDataProvider", "", "isOffline", "", "setSyncPolicyOfflineStatus", "", "throwable", "publishError", "verifyProperSdkSetup", "Lbo/app/x6;", "dependencyProvider", "setUserSpecificMemberVariablesAndStartDispatch", "", "key", "isEphemeralEventKey", "T", "defaultValueOnException", "Lkotlin/Function0;", "errorLog", "earlyReturnIfDisabled", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "runForResult", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Landroid/app/Activity;", "activity", "openSession", "closeSession", "eventName", "logCustomEvent", "Lcom/braze/models/outgoing/BrazeProperties;", "properties", "productId", "currencyCode", "Ljava/math/BigDecimal;", "price", "logPurchase", "", "quantity", "campaignId", "logPushNotificationOpened", "Landroid/content/Intent;", "intent", "actionId", "actionType", "logPushNotificationActionClicked", "pageId", "logPushStoryPageClicked", "logFeedDisplayed", "requestFeedRefreshFromCache", "requestFeedRefresh", "fromCache", "requestContentCardsRefresh", "requestContentCardsRefreshFromCache", "refreshFeatureFlags", "", "Lcom/braze/models/FeatureFlag;", "getAllFeatureFlags", "id", "getFeatureFlag", "logFeatureFlagImpression", "requestImmediateDataFlush", "Lcom/braze/events/IEventSubscriber;", "Lcom/braze/events/InAppMessageEvent;", "subscriber", "subscribeToNewInAppMessages", "Lcom/braze/events/NoMatchingTriggerEvent;", "subscribeToNoMatchingTriggerForEvent", "Lcom/braze/events/ContentCardsUpdatedEvent;", "subscribeToContentCardsUpdates", "Lcom/braze/events/FeatureFlagsUpdatedEvent;", "subscribeToFeatureFlagsUpdates", "Lcom/braze/events/FeedUpdatedEvent;", "subscribeToFeedUpdates", "Lcom/braze/events/SessionStateChangedEvent;", "subscribeToSessionUpdates", "Lcom/braze/events/BrazeNetworkFailureEvent;", "subscribeToNetworkFailures", "Lcom/braze/events/BrazeSdkAuthenticationErrorEvent;", "subscribeToSdkAuthenticationFailures", "Lcom/braze/events/BrazePushEvent;", "subscribeToPushNotificationEvents", "Ljava/lang/Class;", "eventClass", "addSingleSynchronousSubscription", "removeSingleSubscription", "userId", "changeUser", "sdkAuthSignature", "Lcom/braze/events/IValueCallback;", "Lcom/braze/BrazeUser;", "completionCallback", "getCurrentUser", "getDeviceIdAsync", "getContentCardCount", "getContentCardUnviewedCount", "", "getContentCardsLastUpdatedInSecondsFromEpoch", "Lcom/braze/models/cards/Card;", "getCachedContentCards", "contentCardString", "deserializeContentCard", "Lorg/json/JSONObject;", "contentCardJson", "cardId", "logFeedCardImpression", "logFeedCardClick", "inAppMessageString", "Lcom/braze/models/inappmessage/IInAppMessage;", "deserializeInAppMessageString", "", "latitude", "longitude", "requestGeofences", "requestLocationInitialization", "googleAdvertisingId", "isLimitAdTrackingEnabled", "setGoogleAdvertisingId", "signature", "setSdkAuthenticationSignature", "geofenceId", "Lcom/braze/enums/GeofenceTransitionType;", "transitionType", "recordGeofenceTransition$android_sdk_base_release", "(Ljava/lang/String;Lcom/braze/enums/GeofenceTransitionType;)V", "recordGeofenceTransition", "Lcom/braze/models/IBrazeLocation;", "location", "requestGeofenceRefresh$android_sdk_base_release", "(Lcom/braze/models/IBrazeLocation;)V", "requestGeofenceRefresh", "ignoreRateLimit", "(Z)V", "serializedCardJson", "addSerializedCardJsonToStorage$android_sdk_base_release", "(Ljava/lang/String;Ljava/lang/String;)V", "addSerializedCardJsonToStorage", "logLocationRecordedEventFromLocationUpdate$android_sdk_base_release", "logLocationRecordedEventFromLocationUpdate", "requestGeofencesInitialization$android_sdk_base_release", "()V", "requestGeofencesInitialization", "requestSingleLocationUpdate$android_sdk_base_release", "requestSingleLocationUpdate", "handleInAppMessageTestPush$android_sdk_base_release", "(Landroid/content/Intent;)V", "handleInAppMessageTestPush", "applyPendingRuntimeConfiguration$android_sdk_base_release", "applyPendingRuntimeConfiguration", "event", "retryInAppMessage$android_sdk_base_release", "(Lcom/braze/events/InAppMessageEvent;)V", "retryInAppMessage", "reenqueueInAppMessage$android_sdk_base_release", "reenqueueInAppMessage", "Lcom/braze/enums/BrazePushEventType;", "pushActionType", "Lcom/braze/models/push/BrazeNotificationPayload;", "payload", "publishBrazePushAction$android_sdk_base_release", "(Lcom/braze/enums/BrazePushEventType;Lcom/braze/models/push/BrazeNotificationPayload;)V", "publishBrazePushAction", "timeInMs", "logPushDelivery$android_sdk_base_release", "(Ljava/lang/String;J)V", "logPushDelivery", "schedulePushDelivery$android_sdk_base_release", "(J)V", "schedulePushDelivery", "performPushDeliveryFlush$android_sdk_base_release", "performPushDeliveryFlush", "campaign", "logPushMaxCampaign$android_sdk_base_release", "(Ljava/lang/String;)V", "logPushMaxCampaign", "pushId", "validateAndStorePushId$android_sdk_base_release", "(Ljava/lang/String;)Z", "validateAndStorePushId", "waitForUserDependencyThread$android_sdk_base_release", "waitForUserDependencyThread", "run$android_sdk_base_release", "(Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function0;)V", "run", "Lcom/braze/images/IBrazeImageLoader;", "imageLoader", "Lcom/braze/images/IBrazeImageLoader;", "getImageLoader", "()Lcom/braze/images/IBrazeImageLoader;", "setImageLoader", "(Lcom/braze/images/IBrazeImageLoader;)V", "Landroid/content/Context;", "applicationContext", "Landroid/content/Context;", "Lbo/app/t3;", "offlineUserStorageProvider", "Lbo/app/t3;", "brazeUser", "Lcom/braze/BrazeUser;", "isApiKeyPresent", "Ljava/lang/Boolean;", "isApiKeyPresent$android_sdk_base_release", "()Ljava/lang/Boolean;", "setApiKeyPresent$android_sdk_base_release", "(Ljava/lang/Boolean;)V", "isApiKeyPresent$android_sdk_base_release$annotations", "isInstanceStopped", "Z", "Lbo/app/e2;", "deviceIdProvider", "Lbo/app/e2;", "getDeviceIdProvider$android_sdk_base_release", "()Lbo/app/e2;", "setDeviceIdProvider$android_sdk_base_release", "(Lbo/app/e2;)V", "getDeviceIdProvider$android_sdk_base_release$annotations", "Lbo/app/i2;", "externalIEventMessenger", "Lbo/app/i2;", "getExternalIEventMessenger$android_sdk_base_release", "()Lbo/app/i2;", "setExternalIEventMessenger$android_sdk_base_release", "(Lbo/app/i2;)V", "getExternalIEventMessenger$android_sdk_base_release$annotations", "Lbo/app/l2;", "registrationDataProvider", "Lbo/app/l2;", "getRegistrationDataProvider$annotations", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "getConfigurationProvider$android_sdk_base_release", "()Lcom/braze/configuration/BrazeConfigurationProvider;", "setConfigurationProvider$android_sdk_base_release", "(Lcom/braze/configuration/BrazeConfigurationProvider;)V", "getConfigurationProvider$android_sdk_base_release$annotations", "Lbo/app/k4;", "pushDeliveryManager", "Lbo/app/k4;", "getPushDeliveryManager$android_sdk_base_release", "()Lbo/app/k4;", "setPushDeliveryManager$android_sdk_base_release", "(Lbo/app/k4;)V", "getPushDeliveryManager$android_sdk_base_release$annotations", "Lbo/app/a3;", "udm", "Lbo/app/a3;", "getUdm$android_sdk_base_release", "()Lbo/app/a3;", "setUdm$android_sdk_base_release", "(Lbo/app/a3;)V", "getUdm$android_sdk_base_release$annotations", "getCachedContentCardsUpdatedEvent", "()Lcom/braze/events/ContentCardsUpdatedEvent;", "cachedContentCardsUpdatedEvent", "getDeviceId", "()Ljava/lang/String;", "deviceId", "()Lcom/braze/BrazeUser;", "currentUser", "value", "getRegisteredPushToken", "setRegisteredPushToken", "registeredPushToken", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public final class Braze implements IBraze {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Set<String> KNOWN_APP_CRAWLER_DEVICE_MODELS = SetsKt.setOf("calypso appcrawler");
    private static final Set<String> NECESSARY_BRAZE_SDK_PERMISSIONS = SetsKt.setOf("android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET");
    /* access modifiers changed from: private */
    public static boolean areOutboundNetworkRequestsOffline;
    /* access modifiers changed from: private */
    public static final ReentrantLock brazeClassLock = new ReentrantLock();
    /* access modifiers changed from: private */
    public static final BrazeConfig clearConfigSentinel = new BrazeConfig.Builder().build();
    /* access modifiers changed from: private */
    public static IBrazeNotificationFactory customBrazeNotificationFactory;
    /* access modifiers changed from: private */
    public static bo.app.d2 deviceDataProvider;
    /* access modifiers changed from: private */
    public static IBrazeEndpointProvider endpointProvider;
    /* access modifiers changed from: private */
    public static final ReentrantLock endpointProviderLock = new ReentrantLock();
    /* access modifiers changed from: private */
    public static volatile Braze instance;
    /* access modifiers changed from: private */
    public static final List<BrazeConfig> pendingConfigurations = new ArrayList();
    /* access modifiers changed from: private */
    public static g5 sdkEnablementProvider;
    /* access modifiers changed from: private */
    public static boolean shouldMockNetworkRequestsAndDropEvents;
    /* access modifiers changed from: private */
    public Context applicationContext;
    /* access modifiers changed from: private */
    public BrazeUser brazeUser;
    public BrazeConfigurationProvider configurationProvider;
    public bo.app.e2 deviceIdProvider;
    private bo.app.i2 externalIEventMessenger;
    public IBrazeImageLoader imageLoader;
    private Boolean isApiKeyPresent;
    /* access modifiers changed from: private */
    public boolean isInstanceStopped;
    /* access modifiers changed from: private */
    public bo.app.t3 offlineUserStorageProvider;
    public bo.app.k4 pushDeliveryManager;
    /* access modifiers changed from: private */
    public bo.app.l2 registrationDataProvider;
    public bo.app.a3 udm;

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bd\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007J\b\u0010\u0012\u001a\u00020\u0010H\u0007J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u001a\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007J\u001e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0007J\b\u0010\u001d\u001a\u00020\u0006H\u0007J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0019\u0010$\u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\fH\u0001¢\u0006\u0004\b\"\u0010#J\u001f\u0010+\u001a\u00020\u00102\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0001¢\u0006\u0004\b)\u0010*J\u000f\u0010.\u001a\u00020\u0010H\u0001¢\u0006\u0004\b,\u0010-J\u000f\u00100\u001a\u00020\u0010H\u0001¢\u0006\u0004\b/\u0010-R*\u00101\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u000e¢\u0006\u0018\n\u0004\b1\u00102\u0012\u0004\b7\u0010-\u001a\u0004\b3\u00104\"\u0004\b5\u00106R*\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b9\u0010:\u0012\u0004\b?\u0010-\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R*\u0010A\u001a\u0004\u0018\u00010@8\u0000@\u0000X\u000e¢\u0006\u0018\n\u0004\bA\u0010B\u0012\u0004\bG\u0010-\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR*\u0010N\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u00068F@FX\u000e¢\u0006\u0012\u0012\u0004\bM\u0010-\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010O\u001a\u00020\u00068FX\u0004¢\u0006\f\u0012\u0004\bP\u0010-\u001a\u0004\bO\u0010JR\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020\f0Q8\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\f0Q8\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010SR\u0016\u0010U\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010Z\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\\R\u0014\u0010]\u001a\u00020W8\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010YR\u0018\u0010^\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00160`8\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010V¨\u0006e"}, d2 = {"Lcom/braze/Braze$Companion;", "", "Landroid/content/Context;", "context", "Lbo/app/g5;", "getSdkEnablementProvider", "", "shouldAllowSingletonInitialization", "Lcom/braze/Braze;", "getInstance", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "", "getConfiguredApiKey", "Lcom/braze/IBrazeEndpointProvider;", "endpointProvider", "", "setEndpointProvider", "clearEndpointProvider", "Landroid/net/Uri;", "brazeEndpoint", "getApiEndpoint", "Lcom/braze/configuration/BrazeConfig;", "config", "configure", "Ljava/util/EnumSet;", "Lcom/braze/enums/BrazeSdkMetadata;", "sdkMetadata", "addSdkMetadata", "enableMockNetworkRequestsAndDropEventsMode", "disableSdk", "enableSdk", "wipeData", "configuredCustomEndpoint", "setConfiguredCustomEndpoint$android_sdk_base_release", "(Ljava/lang/String;)V", "setConfiguredCustomEndpoint", "Landroid/content/Intent;", "intent", "Lbo/app/z1;", "brazeManager", "requestTriggersIfInAppMessageTestPush$android_sdk_base_release", "(Landroid/content/Intent;Lbo/app/z1;)V", "requestTriggersIfInAppMessageTestPush", "stopInstance$android_sdk_base_release", "()V", "stopInstance", "clearInstance$android_sdk_base_release", "clearInstance", "sdkEnablementProvider", "Lbo/app/g5;", "getSdkEnablementProvider$android_sdk_base_release", "()Lbo/app/g5;", "setSdkEnablementProvider$android_sdk_base_release", "(Lbo/app/g5;)V", "getSdkEnablementProvider$android_sdk_base_release$annotations", "Lcom/braze/IBrazeNotificationFactory;", "customBrazeNotificationFactory", "Lcom/braze/IBrazeNotificationFactory;", "getCustomBrazeNotificationFactory", "()Lcom/braze/IBrazeNotificationFactory;", "setCustomBrazeNotificationFactory", "(Lcom/braze/IBrazeNotificationFactory;)V", "getCustomBrazeNotificationFactory$annotations", "Lbo/app/d2;", "deviceDataProvider", "Lbo/app/d2;", "getDeviceDataProvider$android_sdk_base_release", "()Lbo/app/d2;", "setDeviceDataProvider$android_sdk_base_release", "(Lbo/app/d2;)V", "getDeviceDataProvider$android_sdk_base_release$annotations", "isOffline", "getOutboundNetworkRequestsOffline", "()Z", "setOutboundNetworkRequestsOffline", "(Z)V", "getOutboundNetworkRequestsOffline$annotations", "outboundNetworkRequestsOffline", "isDisabled", "isDisabled$annotations", "", "KNOWN_APP_CRAWLER_DEVICE_MODELS", "Ljava/util/Set;", "NECESSARY_BRAZE_SDK_PERMISSIONS", "areOutboundNetworkRequestsOffline", "Z", "Ljava/util/concurrent/locks/ReentrantLock;", "brazeClassLock", "Ljava/util/concurrent/locks/ReentrantLock;", "clearConfigSentinel", "Lcom/braze/configuration/BrazeConfig;", "Lcom/braze/IBrazeEndpointProvider;", "endpointProviderLock", "instance", "Lcom/braze/Braze;", "", "pendingConfigurations", "Ljava/util/List;", "shouldMockNetworkRequestsAndDropEvents", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        static final class a extends Lambda implements Function0 {
            final /* synthetic */ EnumSet b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(EnumSet enumSet) {
                super(0);
                this.b = enumSet;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to add SDK Metadata of: " + this.b;
            }
        }

        static final class a0 extends Lambda implements Function0 {
            public static final a0 b = new a0();

            a0() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to delete data from the internal storage cache.";
            }
        }

        static final class b extends Lambda implements Function0 {
            public static final b b = new b();

            b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Clearing Braze instance";
            }
        }

        static final class b0 extends Lambda implements Function0 {
            final /* synthetic */ File b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b0(File file) {
                super(0);
                this.b = file;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Deleting shared prefs file at: " + this.b.getAbsolutePath();
            }
        }

        static final class c extends Lambda implements Function0 {
            final /* synthetic */ BrazeConfig b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(BrazeConfig brazeConfig) {
                super(0);
                this.b = brazeConfig;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Braze.configure() called with configuration: " + this.b;
            }
        }

        static final class c0 extends Lambda implements Function0 {
            public static final c0 b = new c0();

            c0() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to delete shared preference data for the Braze SDK.";
            }
        }

        static final class d extends Lambda implements Function0 {
            public static final d b = new d();

            d() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Braze.configure() cannot be called while the singleton is still live.";
            }
        }

        static final class e extends Lambda implements Function0 {
            public static final e b = new e();

            e() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Braze.configure() called with a null config; Clearing all configuration values.";
            }
        }

        static final class f extends Lambda implements Function0 {
            public static final f b = new f();

            f() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Stopping the SDK instance.";
            }
        }

        static final class g extends Lambda implements Function0 {
            public static final g b = new g();

            g() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Disabling all network requests";
            }
        }

        static final class h extends Lambda implements Function0 {
            public static final h b = new h();

            h() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Braze network requests already being mocked. Note that events dispatched in this mode are dropped.";
            }
        }

        static final class i extends Lambda implements Function0 {
            public static final i b = new i();

            i() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Braze network requests will be mocked. Events dispatchedin this mode will be dropped.";
            }
        }

        static final class j extends Lambda implements Function0 {
            public static final j b = new j();

            j() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Attempt to enable mocking Braze network requests had no effect since getInstance() has already been called.";
            }
        }

        static final class k extends Lambda implements Function0 {
            public static final k b = new k();

            k() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Setting SDK to enabled.";
            }
        }

        static final class l extends Lambda implements Function0 {
            public static final l b = new l();

            l() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Enabling all network requests";
            }
        }

        static final class m extends Lambda implements Function0 {
            public static final m b = new m();

            m() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Caught exception trying to get a Braze API endpoint from the BrazeEndpointProvider. Using the original URI";
            }
        }

        static final class n extends Lambda implements Function0 {
            public static final n b = new n();

            n() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Caught exception while retrieving API key.";
            }
        }

        static final class o extends Lambda implements Function0 {
            public static final o b = new o();

            o() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "SDK enablement provider was null. Returning SDK as enabled.";
            }
        }

        static final class p extends Lambda implements Function0 {
            public static final p b = new p();

            p() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "API key not present. Actions will not be performed on the SDK.";
            }
        }

        static final class q extends Lambda implements Function0 {
            public static final q b = new q();

            q() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "SDK is disabled. Actions will not be performed on the SDK.";
            }
        }

        static final class r extends Lambda implements Function0 {
            final /* synthetic */ boolean b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            r(boolean z) {
                super(0);
                this.b = z;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Braze SDK outbound network requests are now " + (this.b ? "disabled" : "enabled");
            }
        }

        static final class s extends Lambda implements Function0 {
            public static final s b = new s();

            s() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Push contained key for fetching test triggers, fetching triggers.";
            }
        }

        static final class t extends Lambda implements Function0 {
            public static final t b = new t();

            t() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "The instance is null. Allowing instance initialization";
            }
        }

        static final class u extends Lambda implements Function0 {
            public static final u b = new u();

            u() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "The instance was stopped. Allowing instance initialization";
            }
        }

        static final class v extends Lambda implements Function0 {
            public static final v b = new v();

            v() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "No API key was found previously. Allowing instance initialization";
            }
        }

        static final class w extends Lambda implements Function0 {
            public static final w b = new w();

            w() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Shutting down all queued work on the Braze SDK";
            }
        }

        static final class x extends Lambda implements Function0 {
            public static final x b = new x();

            x() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Sending sdk data wipe event to external subscribers";
            }
        }

        static final class y extends Lambda implements Function0 {
            public static final y b = new y();

            y() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Shutting down the singleton work queue";
            }
        }

        static final class z extends Lambda implements Function0 {
            public static final z b = new z();

            z() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to shutdown queued work on the Braze SDK.";
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getCustomBrazeNotificationFactory$annotations() {
        }

        public static /* synthetic */ void getDeviceDataProvider$android_sdk_base_release$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getOutboundNetworkRequestsOffline$annotations() {
        }

        /* access modifiers changed from: private */
        public final g5 getSdkEnablementProvider(Context context) {
            g5 sdkEnablementProvider$android_sdk_base_release = getSdkEnablementProvider$android_sdk_base_release();
            if (sdkEnablementProvider$android_sdk_base_release != null) {
                return sdkEnablementProvider$android_sdk_base_release;
            }
            g5 g5Var = new g5(context);
            setSdkEnablementProvider$android_sdk_base_release(g5Var);
            return g5Var;
        }

        public static /* synthetic */ void getSdkEnablementProvider$android_sdk_base_release$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void isDisabled$annotations() {
        }

        /* access modifiers changed from: private */
        public static final Uri setConfiguredCustomEndpoint$lambda$12$lambda$11(String str, Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "brazeEndpoint");
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String encodedAuthority = parse.getEncodedAuthority();
            Uri.Builder buildUpon = uri.buildUpon();
            boolean z2 = false;
            if (!(scheme == null || StringsKt.isBlank(scheme))) {
                if (encodedAuthority == null || StringsKt.isBlank(encodedAuthority)) {
                    z2 = true;
                }
                if (!z2) {
                    buildUpon.encodedAuthority(encodedAuthority);
                    buildUpon.scheme(scheme);
                    return buildUpon.build();
                }
            }
            return buildUpon.encodedAuthority(str).build();
        }

        private final boolean shouldAllowSingletonInitialization() {
            Braze access$getInstance$cp = Braze.instance;
            if (access$getInstance$cp == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) t.b, 2, (Object) null);
                return true;
            } else if (access$getInstance$cp.isInstanceStopped) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) u.b, 3, (Object) null);
                return true;
            } else if (!Intrinsics.areEqual((Object) Boolean.FALSE, (Object) access$getInstance$cp.isApiKeyPresent$android_sdk_base_release())) {
                return false;
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) v.b, 3, (Object) null);
                return true;
            }
        }

        /* access modifiers changed from: private */
        public static final boolean wipeData$lambda$9(File file, String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            if ((!StringsKt.startsWith$default(str, "com.appboy", false, 2, (Object) null) || Intrinsics.areEqual((Object) str, (Object) "com.appboy.override.configuration.cache")) && (!StringsKt.startsWith$default(str, "com.braze", false, 2, (Object) null) || Intrinsics.areEqual((Object) str, (Object) "com.braze.override.configuration.cache"))) {
                return false;
            }
            return true;
        }

        @JvmStatic
        public final void addSdkMetadata(Context context, EnumSet<BrazeSdkMetadata> enumSet) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(enumSet, "sdkMetadata");
            ReentrantLock access$getBrazeClassLock$cp = Braze.brazeClassLock;
            access$getBrazeClassLock$cp.lock();
            try {
                Braze.pendingConfigurations.add(new BrazeConfig.Builder().setSdkMetadata(enumSet).build());
                Braze access$getInstance$cp = Braze.instance;
                if (access$getInstance$cp != null) {
                    access$getInstance$cp.applyPendingRuntimeConfiguration$android_sdk_base_release();
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) Braze.Companion, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new a(enumSet));
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                access$getBrazeClassLock$cp.unlock();
                throw th;
            }
            access$getBrazeClassLock$cp.unlock();
        }

        @JvmStatic
        public final void clearEndpointProvider() {
            ReentrantLock access$getEndpointProviderLock$cp = Braze.endpointProviderLock;
            access$getEndpointProviderLock$cp.lock();
            try {
                Braze.endpointProvider = null;
                Unit unit = Unit.INSTANCE;
            } finally {
                access$getEndpointProviderLock$cp.unlock();
            }
        }

        public final /* synthetic */ void clearInstance$android_sdk_base_release() {
            ReentrantLock access$getBrazeClassLock$cp = Braze.brazeClassLock;
            access$getBrazeClassLock$cp.lock();
            try {
                Braze access$getInstance$cp = Braze.instance;
                BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                Companion companion = Braze.Companion;
                BrazeLogger.brazelog$default(brazeLogger, (Object) companion, BrazeLogger.Priority.W, (Throwable) null, (Function0) b.b, 2, (Object) null);
                BrazeCoroutineScope.cancelChildren();
                if (!(access$getInstance$cp == null || access$getInstance$cp.udm == null)) {
                    access$getInstance$cp.getUdm$android_sdk_base_release().k().h();
                }
                Braze.instance = null;
                Braze.shouldMockNetworkRequestsAndDropEvents = false;
                Braze.areOutboundNetworkRequestsOffline = false;
                companion.setSdkEnablementProvider$android_sdk_base_release((g5) null);
                Braze.endpointProvider = null;
                Unit unit = Unit.INSTANCE;
            } finally {
                access$getBrazeClassLock$cp.unlock();
            }
        }

        /* JADX INFO: finally extract failed */
        @JvmStatic
        public final boolean configure(Context context, BrazeConfig brazeConfig) {
            Intrinsics.checkNotNullParameter(context, "context");
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.Priority priority = BrazeLogger.Priority.I;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, (Function0) new c(brazeConfig), 2, (Object) null);
            ReentrantLock access$getBrazeClassLock$cp = Braze.brazeClassLock;
            access$getBrazeClassLock$cp.lock();
            try {
                Braze access$getInstance$cp = Braze.instance;
                if (access$getInstance$cp == null || access$getInstance$cp.isInstanceStopped || !Intrinsics.areEqual((Object) Boolean.TRUE, (Object) access$getInstance$cp.isApiKeyPresent$android_sdk_base_release())) {
                    if (brazeConfig != null) {
                        Braze.pendingConfigurations.add(brazeConfig);
                    } else {
                        BrazeLogger.brazelog$default(brazeLogger, (Object) Braze.Companion, priority, (Throwable) null, (Function0) e.b, 2, (Object) null);
                        Braze.pendingConfigurations.add(Braze.clearConfigSentinel);
                    }
                    access$getBrazeClassLock$cp.unlock();
                    return true;
                }
                BrazeLogger.brazelog$default(brazeLogger, (Object) Braze.Companion, priority, (Throwable) null, (Function0) d.b, 2, (Object) null);
                access$getBrazeClassLock$cp.unlock();
                return false;
            } catch (Throwable th) {
                access$getBrazeClassLock$cp.unlock();
                throw th;
            }
        }

        @JvmStatic
        public final void disableSdk(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            getSdkEnablementProvider(context).a(true);
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger brazeLogger2 = brazeLogger;
            BrazeLogger.Priority priority = BrazeLogger.Priority.W;
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, (Function0) f.b, 2, (Object) null);
            stopInstance$android_sdk_base_release();
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, (Function0) g.b, 2, (Object) null);
            setOutboundNetworkRequestsOffline(true);
        }

        @JvmStatic
        public final boolean enableMockNetworkRequestsAndDropEventsMode() {
            if (Braze.instance == null) {
                ReentrantLock access$getBrazeClassLock$cp = Braze.brazeClassLock;
                access$getBrazeClassLock$cp.lock();
                try {
                    if (Braze.instance == null) {
                        if (Braze.shouldMockNetworkRequestsAndDropEvents) {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) Braze.Companion, BrazeLogger.Priority.I, (Throwable) null, (Function0) h.b, 2, (Object) null);
                        } else {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) Braze.Companion, BrazeLogger.Priority.I, (Throwable) null, (Function0) i.b, 2, (Object) null);
                            Braze.shouldMockNetworkRequestsAndDropEvents = true;
                        }
                        return true;
                    }
                    Unit unit = Unit.INSTANCE;
                    access$getBrazeClassLock$cp.unlock();
                } finally {
                    access$getBrazeClassLock$cp.unlock();
                }
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) j.b, 2, (Object) null);
            return false;
        }

        @JvmStatic
        public final void enableSdk(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger brazeLogger2 = brazeLogger;
            BrazeLogger.Priority priority = BrazeLogger.Priority.W;
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, (Function0) k.b, 2, (Object) null);
            getSdkEnablementProvider(context).a(false);
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, (Function0) l.b, 2, (Object) null);
            setOutboundNetworkRequestsOffline(false);
        }

        @JvmStatic
        public final Uri getApiEndpoint(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "brazeEndpoint");
            ReentrantLock access$getEndpointProviderLock$cp = Braze.endpointProviderLock;
            access$getEndpointProviderLock$cp.lock();
            try {
                IBrazeEndpointProvider access$getEndpointProvider$cp = Braze.endpointProvider;
                if (access$getEndpointProvider$cp != null) {
                    Uri apiEndpoint = access$getEndpointProvider$cp.getApiEndpoint(uri);
                    if (apiEndpoint != null) {
                        access$getEndpointProviderLock$cp.unlock();
                        return apiEndpoint;
                    }
                }
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) Braze.Companion, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) m.b);
            } catch (Throwable th) {
                access$getEndpointProviderLock$cp.unlock();
                throw th;
            }
            access$getEndpointProviderLock$cp.unlock();
            return uri;
        }

        @JvmStatic
        public final String getConfiguredApiKey(BrazeConfigurationProvider brazeConfigurationProvider) {
            Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
            try {
                return brazeConfigurationProvider.getBrazeApiKey().toString();
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) n.b);
                return null;
            }
        }

        public final IBrazeNotificationFactory getCustomBrazeNotificationFactory() {
            return Braze.customBrazeNotificationFactory;
        }

        public final bo.app.d2 getDeviceDataProvider$android_sdk_base_release() {
            return Braze.deviceDataProvider;
        }

        @JvmStatic
        public final Braze getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (shouldAllowSingletonInitialization()) {
                ReentrantLock access$getBrazeClassLock$cp = Braze.brazeClassLock;
                access$getBrazeClassLock$cp.lock();
                try {
                    if (Braze.Companion.shouldAllowSingletonInitialization()) {
                        Braze braze = new Braze(context);
                        braze.isInstanceStopped = false;
                        Braze.instance = braze;
                        return braze;
                    }
                    Unit unit = Unit.INSTANCE;
                    access$getBrazeClassLock$cp.unlock();
                } finally {
                    access$getBrazeClassLock$cp.unlock();
                }
            }
            Braze access$getInstance$cp = Braze.instance;
            Intrinsics.checkNotNull(access$getInstance$cp, "null cannot be cast to non-null type com.braze.Braze");
            return access$getInstance$cp;
        }

        public final boolean getOutboundNetworkRequestsOffline() {
            return Braze.areOutboundNetworkRequestsOffline;
        }

        public final g5 getSdkEnablementProvider$android_sdk_base_release() {
            return Braze.sdkEnablementProvider;
        }

        public final boolean isDisabled() {
            g5 sdkEnablementProvider$android_sdk_base_release = getSdkEnablementProvider$android_sdk_base_release();
            if (sdkEnablementProvider$android_sdk_base_release == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) o.b, 3, (Object) null);
                return false;
            }
            Braze access$getInstance$cp = Braze.instance;
            if (access$getInstance$cp == null || !Intrinsics.areEqual((Object) Boolean.FALSE, (Object) access$getInstance$cp.isApiKeyPresent$android_sdk_base_release())) {
                boolean a2 = sdkEnablementProvider$android_sdk_base_release.a();
                if (a2) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) q.b, 2, (Object) null);
                }
                return a2;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) p.b, 2, (Object) null);
            return true;
        }

        public final void requestTriggersIfInAppMessageTestPush$android_sdk_base_release(Intent intent, bo.app.z1 z1Var) {
            Intent intent2 = intent;
            bo.app.z1 z1Var2 = z1Var;
            Intrinsics.checkNotNullParameter(intent2, SDKConstants.PARAM_INTENT);
            Intrinsics.checkNotNullParameter(z1Var2, "brazeManager");
            String stringExtra = intent2.getStringExtra(Constants.BRAZE_PUSH_FETCH_TEST_TRIGGERS_KEY);
            if (stringExtra != null && Intrinsics.areEqual((Object) stringExtra, (Object) ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) s.b, 2, (Object) null);
                z1Var2.a(new y3.a((String) null, (Boolean) null, (Boolean) null, (bo.app.x3) null, 15, (DefaultConstructorMarker) null).e());
            }
        }

        public final void setConfiguredCustomEndpoint$android_sdk_base_release(String str) {
            ReentrantLock access$getEndpointProviderLock$cp = Braze.endpointProviderLock;
            access$getEndpointProviderLock$cp.lock();
            try {
                Braze.Companion.setEndpointProvider(new Braze$Companion$$ExternalSyntheticLambda1(str));
                Unit unit = Unit.INSTANCE;
            } finally {
                access$getEndpointProviderLock$cp.unlock();
            }
        }

        public final void setCustomBrazeNotificationFactory(IBrazeNotificationFactory iBrazeNotificationFactory) {
            Braze.customBrazeNotificationFactory = iBrazeNotificationFactory;
        }

        public final void setDeviceDataProvider$android_sdk_base_release(bo.app.d2 d2Var) {
            Braze.deviceDataProvider = d2Var;
        }

        @JvmStatic
        public final void setEndpointProvider(IBrazeEndpointProvider iBrazeEndpointProvider) {
            ReentrantLock access$getEndpointProviderLock$cp = Braze.endpointProviderLock;
            access$getEndpointProviderLock$cp.lock();
            try {
                Braze.endpointProvider = iBrazeEndpointProvider;
                Unit unit = Unit.INSTANCE;
            } finally {
                access$getEndpointProviderLock$cp.unlock();
            }
        }

        public final void setOutboundNetworkRequestsOffline(boolean z2) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new r(z2), 2, (Object) null);
            ReentrantLock access$getBrazeClassLock$cp = Braze.brazeClassLock;
            access$getBrazeClassLock$cp.lock();
            try {
                Braze.areOutboundNetworkRequestsOffline = z2;
                Braze access$getInstance$cp = Braze.instance;
                if (access$getInstance$cp != null) {
                    access$getInstance$cp.setSyncPolicyOfflineStatus(z2);
                    Unit unit = Unit.INSTANCE;
                }
            } finally {
                access$getBrazeClassLock$cp.unlock();
            }
        }

        public final void setSdkEnablementProvider$android_sdk_base_release(g5 g5Var) {
            Braze.sdkEnablementProvider = g5Var;
        }

        public final void stopInstance$android_sdk_base_release() {
            ReentrantLock access$getBrazeClassLock$cp;
            try {
                BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) w.b, 2, (Object) null);
                access$getBrazeClassLock$cp = Braze.brazeClassLock;
                access$getBrazeClassLock$cp.lock();
                BrazeCoroutineScope.cancelChildren();
                Braze access$getInstance$cp = Braze.instance;
                if (access$getInstance$cp != null) {
                    Companion companion = Braze.Companion;
                    BrazeLogger.brazelog$default(brazeLogger, (Object) companion, BrazeLogger.Priority.V, (Throwable) null, (Function0) x.b, 2, (Object) null);
                    access$getInstance$cp.getExternalIEventMessenger$android_sdk_base_release().a((Object) new SdkDataWipeEvent(), SdkDataWipeEvent.class);
                    BrazeLogger.brazelog$default(brazeLogger, (Object) companion, (BrazeLogger.Priority) null, (Throwable) null, (Function0) y.b, 3, (Object) null);
                    i5.a.a();
                    if (access$getInstance$cp.udm != null) {
                        access$getInstance$cp.getUdm$android_sdk_base_release().k().a(true);
                        access$getInstance$cp.getUdm$android_sdk_base_release().m().a();
                        access$getInstance$cp.getUdm$android_sdk_base_release().p().unregisterGeofences();
                    }
                    access$getInstance$cp.isInstanceStopped = true;
                }
                Unit unit = Unit.INSTANCE;
                access$getBrazeClassLock$cp.unlock();
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) z.b);
            } catch (Throwable th) {
                access$getBrazeClassLock$cp.unlock();
                throw th;
            }
        }

        @JvmStatic
        public final void wipeData(Context context) {
            List<File> asList;
            Intrinsics.checkNotNullParameter(context, "context");
            stopInstance$android_sdk_base_release();
            try {
                f6.e.a(context);
                DefaultBrazeImageLoader.Companion.a(context);
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) a0.b);
            }
            try {
                File file = new File(context.getApplicationInfo().dataDir, "shared_prefs");
                if (!file.exists()) {
                    return;
                }
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles(new Braze$Companion$$ExternalSyntheticLambda0());
                    if (listFiles != null && (asList = ArraysKt.asList((T[]) listFiles)) != null) {
                        for (File file2 : asList) {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) Braze.Companion, BrazeLogger.Priority.V, (Throwable) null, (Function0) new b0(file2), 2, (Object) null);
                            Intrinsics.checkNotNullExpressionValue(file2, "file");
                            BrazeFileUtils.deleteSharedPreferencesFile(context, file2);
                        }
                    }
                }
            } catch (Exception e3) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e3, (Function0<String>) c0.b);
            }
        }

        private Companion() {
        }
    }

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze SDK Initializing";
        }
    }

    static final class a0 extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ Braze c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a0(Braze braze, Continuation continuation) {
            super(2, continuation);
            this.c = braze;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new a0(this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                return this.c.getDeviceIdProvider$android_sdk_base_release().getDeviceId();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class a1 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a1(Braze braze) {
            super(0);
            this.b = braze;
        }

        public final void a() {
            bo.app.x1 a = bo.app.j.h.a();
            if (a != null) {
                this.b.getUdm$android_sdk_base_release().f().a(a);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class a2 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;
        final /* synthetic */ InAppMessageEvent c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a2(Braze braze, InAppMessageEvent inAppMessageEvent) {
            super(0);
            this.b = braze;
            this.c = inAppMessageEvent;
        }

        public final void a() {
            this.b.getUdm$android_sdk_base_release().r().d(this.c.getTriggerAction());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class a3 extends Lambda implements Function0 {
        public static final a3 b = new a3();

        a3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to request data flush.";
        }
    }

    static final class a4 extends Lambda implements Function0 {
        public static final a4 b = new a4();

        a4() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add subscriber for push notification updates.";
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Device build model matches a known crawler. Enabling mock network request mode. Device it: " + this.b;
        }
    }

    static final class b0 extends Lambda implements Function0 {
        public static final b0 b = new b0();

        b0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get all feature flags";
        }
    }

    static final class b1 extends Lambda implements Function0 {
        public static final b1 b = new b1();

        b1() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log location recorded event.";
        }
    }

    static final class b2 extends Lambda implements Function0 {
        public static final b2 b = new b2();

        b2() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to refresh feature flags.";
        }
    }

    static final class b3 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "requestImmediateDataFlush() called";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b3(Braze braze) {
            super(0);
            this.b = braze;
        }

        public final void a() {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.b, BrazeLogger.Priority.V, (Throwable) null, (Function0) a.b, 2, (Object) null);
            this.b.getUdm$android_sdk_base_release().f().e();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class b4 extends Lambda implements Function0 {
        public static final b4 b = new b4();

        b4() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add subscriber for SDK authentication failures.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to perform initial Braze singleton setup.";
        }
    }

    static final class c0 extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ Braze c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c0(Braze braze, Continuation continuation) {
            super(2, continuation);
            this.c = braze;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((c0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new c0(this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.c.getUdm$android_sdk_base_release().l().A()) {
                    return bo.app.j1.a(this.c.getUdm$android_sdk_base_release().s(), (String) null, 1, (Object) null);
                }
                return CollectionsKt.emptyList();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class c1 extends Lambda implements Function0 {
        final /* synthetic */ IBrazeLocation b;
        final /* synthetic */ Braze c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c1(IBrazeLocation iBrazeLocation, Braze braze) {
            super(0);
            this.b = iBrazeLocation;
            this.c = braze;
        }

        public final void a() {
            bo.app.x1 a = bo.app.j.h.a(this.b);
            if (a != null) {
                this.c.getUdm$android_sdk_base_release().f().a(a);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class c2 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Feature flags not enabled. Not refreshing feature flags.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c2(Braze braze) {
            super(0);
            this.b = braze;
        }

        public final void a() {
            if (this.b.getUdm$android_sdk_base_release().l().A()) {
                this.b.getUdm$android_sdk_base_release().s().h();
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.b, BrazeLogger.Priority.I, (Throwable) null, (Function0) a.b, 2, (Object) null);
            this.b.getUdm$android_sdk_base_release().e().a((Object) new bo.app.l1(), bo.app.l1.class);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class c3 extends Lambda implements Function0 {
        public static final c3 b = new c3();

        c3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Location permissions were granted. Requesting geofence and location initialization.";
        }
    }

    static final class c4 extends Lambda implements Function0 {
        public static final c4 b = new c4();

        c4() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add subscriber for session updates.";
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ Braze b;
        final /* synthetic */ Context c;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to startup user dependency manager.";
            }
        }

        static final class b extends Lambda implements Function0 {
            public static final b b = new b();

            b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Firebase Cloud Messaging found. Setting up Firebase Cloud Messaging.";
            }
        }

        static final class c extends Lambda implements Function0 {
            public static final c b = new c();

            c() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Firebase Cloud Messaging requirements not met. Braze will not register for Firebase Cloud Messaging.";
            }
        }

        /* renamed from: com.braze.Braze$d$d  reason: collision with other inner class name */
        static final class C0027d extends Lambda implements Function0 {
            public static final C0027d b = new C0027d();

            C0027d() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Automatic Firebase Cloud Messaging registration not enabled in configuration. Braze will not register for Firebase Cloud Messaging.";
            }
        }

        static final class e extends Lambda implements Function0 {
            public static final e b = new e();

            e() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Amazon Device Messaging found. Setting up Amazon Device Messaging";
            }
        }

        static final class f extends Lambda implements Function0 {
            public static final f b = new f();

            f() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "ADM manifest requirements not met. Braze will not register for ADM.";
            }
        }

        static final class g extends Lambda implements Function0 {
            public static final g b = new g();

            g() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Automatic ADM registration not enabled in configuration. Braze will not register for ADM.";
            }
        }

        static final class h extends Lambda implements Function0 {
            public static final h b = new h();

            h() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to setup pre SDK tasks";
            }
        }

        static final class i extends Lambda implements Function0 {
            public static final i b = new i();

            i() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Starting up a new user dependency manager";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Braze braze, Context context) {
            super(0);
            this.b = braze;
            this.c = context;
        }

        public final void a() {
            bo.app.t3 t3Var;
            bo.app.l2 l2Var;
            this.b.applyPendingRuntimeConfiguration$android_sdk_base_release();
            this.b.setConfigurationProvider$android_sdk_base_release(new BrazeConfigurationProvider(this.b.applicationContext));
            Braze braze = this.b;
            Companion companion = Braze.Companion;
            String configuredApiKey = companion.getConfiguredApiKey(braze.getConfigurationProvider$android_sdk_base_release());
            boolean z = false;
            braze.setApiKeyPresent$android_sdk_base_release(Boolean.valueOf(!(configuredApiKey == null || StringsKt.isBlank(configuredApiKey))));
            BrazeLogger.setInitialLogLevelFromConfiguration(this.b.getConfigurationProvider$android_sdk_base_release().getLoggerInitialLogLevel());
            BrazeLogger.checkForSystemLogLevelProperty$default(false, 1, (Object) null);
            if (companion.getSdkEnablementProvider(this.c).a()) {
                companion.setOutboundNetworkRequestsOffline(true);
            }
            this.b.setPushDeliveryManager$android_sdk_base_release(new bo.app.k4(this.b.applicationContext, this.b.getConfigurationProvider$android_sdk_base_release().getBrazeApiKey().toString()));
            this.b.setDeviceIdProvider$android_sdk_base_release(new bo.app.l0(this.b.applicationContext));
            this.b.offlineUserStorageProvider = new bo.app.t3(this.b.applicationContext);
            this.b.registrationDataProvider = new q4(this.b.applicationContext, this.b.getConfigurationProvider$android_sdk_base_release());
            String customEndpoint = this.b.getConfigurationProvider$android_sdk_base_release().getCustomEndpoint();
            if (customEndpoint == null || StringsKt.isBlank(customEndpoint)) {
                z = true;
            }
            if (!z) {
                companion.setConfiguredCustomEndpoint$android_sdk_base_release(this.b.getConfigurationProvider$android_sdk_base_release().getCustomEndpoint());
            }
            try {
                if (this.b.getConfigurationProvider$android_sdk_base_release().isFirebaseCloudMessagingRegistrationEnabled()) {
                    Context context = this.c;
                    bo.app.l2 access$getRegistrationDataProvider$p = this.b.registrationDataProvider;
                    if (access$getRegistrationDataProvider$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("registrationDataProvider");
                        access$getRegistrationDataProvider$p = null;
                    }
                    bo.app.q1 q1Var = new bo.app.q1(context, access$getRegistrationDataProvider$p);
                    if (q1Var.a()) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.b, BrazeLogger.Priority.I, (Throwable) null, (Function0) b.b, 2, (Object) null);
                        String firebaseCloudMessagingSenderIdKey = this.b.getConfigurationProvider$android_sdk_base_release().getFirebaseCloudMessagingSenderIdKey();
                        if (firebaseCloudMessagingSenderIdKey != null) {
                            q1Var.a(firebaseCloudMessagingSenderIdKey);
                        }
                    } else {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.b, BrazeLogger.Priority.W, (Throwable) null, (Function0) c.b, 2, (Object) null);
                    }
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.b, BrazeLogger.Priority.I, (Throwable) null, (Function0) C0027d.b, 2, (Object) null);
                }
                if (!this.b.getConfigurationProvider$android_sdk_base_release().isAdmMessagingRegistrationEnabled()) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.b, BrazeLogger.Priority.I, (Throwable) null, (Function0) g.b, 2, (Object) null);
                } else if (bo.app.b.c.a(this.b.applicationContext)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.b, BrazeLogger.Priority.I, (Throwable) null, (Function0) e.b, 2, (Object) null);
                    Context access$getApplicationContext$p = this.b.applicationContext;
                    bo.app.l2 access$getRegistrationDataProvider$p2 = this.b.registrationDataProvider;
                    if (access$getRegistrationDataProvider$p2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("registrationDataProvider");
                        access$getRegistrationDataProvider$p2 = null;
                    }
                    new bo.app.b(access$getApplicationContext$p, access$getRegistrationDataProvider$p2).a();
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.b, BrazeLogger.Priority.W, (Throwable) null, (Function0) f.b, 2, (Object) null);
                }
                this.b.verifyProperSdkSetup();
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this.b, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) h.b);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.b, BrazeLogger.Priority.V, (Throwable) null, (Function0) i.b, 2, (Object) null);
            try {
                Braze braze2 = this.b;
                Context access$getApplicationContext$p2 = braze2.applicationContext;
                bo.app.t3 access$getOfflineUserStorageProvider$p = this.b.offlineUserStorageProvider;
                if (access$getOfflineUserStorageProvider$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("offlineUserStorageProvider");
                    t3Var = null;
                } else {
                    t3Var = access$getOfflineUserStorageProvider$p;
                }
                BrazeConfigurationProvider configurationProvider$android_sdk_base_release = this.b.getConfigurationProvider$android_sdk_base_release();
                bo.app.i2 externalIEventMessenger$android_sdk_base_release = this.b.getExternalIEventMessenger$android_sdk_base_release();
                bo.app.e2 deviceIdProvider$android_sdk_base_release = this.b.getDeviceIdProvider$android_sdk_base_release();
                bo.app.l2 access$getRegistrationDataProvider$p3 = this.b.registrationDataProvider;
                if (access$getRegistrationDataProvider$p3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("registrationDataProvider");
                    l2Var = null;
                } else {
                    l2Var = access$getRegistrationDataProvider$p3;
                }
                braze2.setUserSpecificMemberVariablesAndStartDispatch(new x6(access$getApplicationContext$p2, t3Var, configurationProvider$android_sdk_base_release, externalIEventMessenger$android_sdk_base_release, deviceIdProvider$android_sdk_base_release, l2Var, this.b.getPushDeliveryManager$android_sdk_base_release(), Braze.shouldMockNetworkRequestsAndDropEvents, Braze.areOutboundNetworkRequestsOffline, this.b.getDeviceDataProvider()));
            } catch (Exception e3) {
                BrazeLogger.INSTANCE.brazelog((Object) this.b, BrazeLogger.Priority.E, (Throwable) e3, (Function0<String>) a.b);
                this.b.publishError(e3);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class d0 extends Lambda implements Function0 {
        public static final d0 b = new d0();

        d0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The ContentCardsUpdatedEvent was null. Returning null for the list of cached cards.";
        }
    }

    static final class d1 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d1(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log purchase event of: " + this.b;
        }
    }

    static final class d2 extends Lambda implements Function0 {
        public static final d2 b = new d2();

        d2() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get the registered push registration token.";
        }
    }

    static final class d3 extends Lambda implements Function0 {
        public static final d3 b = new d3();

        d3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to request single location update";
        }
    }

    static final class d4 extends Lambda implements Function0 {
        public static final d4 b = new d4();

        d4() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to validate and store push identifier";
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ long b;
        final /* synthetic */ long c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(long j, long j2) {
            super(0);
            this.b = j;
            this.c = j2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze SDK loaded in " + TimeUnit.MILLISECONDS.convert(this.b - this.c, TimeUnit.NANOSECONDS) + " ms.";
        }
    }

    static final class e0 extends Lambda implements Function0 {
        public static final e0 b = new e0();

        e0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The ContentCardsUpdatedEvent was null. Returning the default value for the card count.";
        }
    }

    static final class e1 extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ BigDecimal d;
        final /* synthetic */ int e;
        final /* synthetic */ Braze f;
        final /* synthetic */ BrazeProperties g;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Log purchase input was invalid. Not logging in-app purchase to Braze.";
            }
        }

        static final class b extends Lambda implements Function0 {
            public static final b b = new b();

            b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Purchase logged with invalid properties. Not logging custom event to Braze.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e1(String str, String str2, BigDecimal bigDecimal, int i, Braze braze, BrazeProperties brazeProperties) {
            super(0);
            this.b = str;
            this.c = str2;
            this.d = bigDecimal;
            this.e = i;
            this.f = braze;
            this.g = brazeProperties;
        }

        public final void a() {
            String str = this.b;
            if (!ValidationUtils.isValidLogPurchaseInput(str, this.c, this.d, this.e, this.f.getUdm$android_sdk_base_release().l())) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f, BrazeLogger.Priority.W, (Throwable) null, (Function0) a.b, 2, (Object) null);
                return;
            }
            BrazeProperties brazeProperties = this.g;
            boolean z = true;
            if (brazeProperties == null || !brazeProperties.isInvalid()) {
                z = false;
            }
            if (z) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f, BrazeLogger.Priority.W, (Throwable) null, (Function0) b.b, 2, (Object) null);
                return;
            }
            String ensureBrazeFieldLength = ValidationUtils.ensureBrazeFieldLength(str);
            j.a aVar = bo.app.j.h;
            String str2 = this.c;
            Intrinsics.checkNotNull(str2);
            BigDecimal bigDecimal = this.d;
            Intrinsics.checkNotNull(bigDecimal);
            bo.app.x1 a2 = aVar.a(ensureBrazeFieldLength, str2, bigDecimal, this.e, this.g);
            if (a2 != null && this.f.getUdm$android_sdk_base_release().f().a(a2)) {
                this.f.getUdm$android_sdk_base_release().r().a((bo.app.u2) new bo.app.d4(ensureBrazeFieldLength, this.g, a2));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class e2 extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ Braze c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e2(Braze braze, Continuation continuation) {
            super(2, continuation);
            this.c = braze;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((e2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new e2(this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                bo.app.l2 access$getRegistrationDataProvider$p = this.c.registrationDataProvider;
                if (access$getRegistrationDataProvider$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("registrationDataProvider");
                    access$getRegistrationDataProvider$p = null;
                }
                return access$getRegistrationDataProvider$p.a();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class e3 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e3(Braze braze) {
            super(0);
            this.b = braze;
        }

        public final void a() {
            this.b.getUdm$android_sdk_base_release().o().a();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class e4 extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ Braze c;
        final /* synthetic */ String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e4(Braze braze, String str, Continuation continuation) {
            super(2, continuation);
            this.c = braze;
            this.d = str;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((e4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new e4(this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(this.c.getUdm$android_sdk_base_release().d().c(this.d));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str, String str2) {
            super(0);
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to update ContentCard storage provider with single card update. User id: " + this.b + " Serialized json: " + this.c;
        }
    }

    static final class f0 extends Lambda implements Function0 {
        public static final f0 b = new f0();

        f0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The ContentCardsUpdatedEvent was null. Returning the default value for the unviewed card count.";
        }
    }

    static final class f1 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f1(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error logging Push Delivery " + this.b;
        }
    }

    static final class f2 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f2(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set the push token " + this.b;
        }
    }

    static final class f3 extends Lambda implements Function0 {
        final /* synthetic */ InAppMessageEvent b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f3(InAppMessageEvent inAppMessageEvent) {
            super(0);
            this.b = inAppMessageEvent;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error retrying In-App Message from event " + this.b;
        }
    }

    static final class f4 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f4(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The Braze SDK requires the permission " + this.b + ". Check your AndroidManifest.";
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Braze c;
        final /* synthetic */ String d;

        static final class a extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str, String str2) {
                super(0);
                this.b = str;
                this.c = str2;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Cannot add null or blank card json to storage. Returning. User id: " + this.b + " Serialized json: " + this.c;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(String str, Braze braze, String str2) {
            super(0);
            this.b = str;
            this.c = braze;
            this.d = str2;
        }

        public final void a() {
            if (StringsKt.isBlank(this.b)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.W, (Throwable) null, (Function0) new a(this.d, this.b), 2, (Object) null);
                return;
            }
            this.c.getUdm$android_sdk_base_release().q().a(new bo.app.z(this.b), this.d);
            this.c.getExternalIEventMessenger$android_sdk_base_release().a((Object) this.c.getUdm$android_sdk_base_release().q().getCachedCardsAsEvent(), ContentCardsUpdatedEvent.class);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class g0 extends Lambda implements Function0 {
        public static final g0 b = new g0();

        g0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The ContentCardsUpdatedEvent was null. Returning the default value for the last update timestamp.";
        }
    }

    static final class g1 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;
        final /* synthetic */ String c;
        final /* synthetic */ long d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g1(Braze braze, String str, long j) {
            super(0);
            this.b = braze;
            this.c = str;
            this.d = j;
        }

        public final void a() {
            this.b.getUdm$android_sdk_base_release().f().a(this.c);
            this.b.schedulePushDelivery$android_sdk_base_release(this.d);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class g2 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;
        final /* synthetic */ String c;

        static final class a extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Push token " + this.b + " registered and immediately being flushed.";
            }
        }

        static final class b extends Lambda implements Function0 {
            public static final b b = new b();

            b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Push token must not be null or blank. Not registering for push with Braze.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g2(Braze braze, String str) {
            super(0);
            this.b = braze;
            this.c = str;
        }

        public final void a() {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this.b, BrazeLogger.Priority.I, (Throwable) null, (Function0) new a(this.c), 2, (Object) null);
            String str = this.c;
            if (str == null || StringsKt.isBlank(str)) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this.b, BrazeLogger.Priority.W, (Throwable) null, (Function0) b.b, 2, (Object) null);
                return;
            }
            bo.app.l2 access$getRegistrationDataProvider$p = this.b.registrationDataProvider;
            if (access$getRegistrationDataProvider$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("registrationDataProvider");
                access$getRegistrationDataProvider$p = null;
            }
            access$getRegistrationDataProvider$p.a(this.c);
            this.b.getUdm$android_sdk_base_release().j().e();
            this.b.requestImmediateDataFlush();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class g3 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;
        final /* synthetic */ InAppMessageEvent c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g3(Braze braze, InAppMessageEvent inAppMessageEvent) {
            super(0);
            this.b = braze;
            this.c = inAppMessageEvent;
        }

        public final void a() {
            this.b.getUdm$android_sdk_base_release().r().a(this.c.getTriggerEvent(), this.c.getTriggerAction());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class g4 extends Lambda implements Function0 {
        public static final g4 b = new g4();

        g4() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The Braze SDK requires a non-empty API key. Check your braze.xml or BrazeConfig.";
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ Class b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(Class cls) {
            super(0);
            this.b = cls;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add synchronous subscriber for class: " + this.b;
        }
    }

    static final class h0 extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ IValueCallback c;
        final /* synthetic */ Braze d;

        static final class a extends SuspendLambda implements Function2 {
            int b;
            final /* synthetic */ IValueCallback c;
            final /* synthetic */ Braze d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(IValueCallback iValueCallback, Braze braze, Continuation continuation) {
                super(2, continuation);
                this.c = iValueCallback;
                this.d = braze;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.c, this.d, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.b == 0) {
                    ResultKt.throwOnFailure(obj);
                    IValueCallback iValueCallback = this.c;
                    BrazeUser access$getBrazeUser$p = this.d.brazeUser;
                    if (access$getBrazeUser$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("brazeUser");
                        access$getBrazeUser$p = null;
                    }
                    iValueCallback.onSuccess(access$getBrazeUser$p);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h0(IValueCallback iValueCallback, Braze braze, Continuation continuation) {
            super(2, continuation);
            this.c = iValueCallback;
            this.d = braze;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((h0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new h0(this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineContext coroutineContext = BrazeCoroutineScope.INSTANCE.getCoroutineContext();
                a aVar = new a(this.c, this.d, (Continuation) null);
                this.b = 1;
                if (BuildersKt.withContext(coroutineContext, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    static final class h1 extends Lambda implements Function0 {
        public static final h1 b = new h1();

        h1() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log push max campaign";
        }
    }

    static final class h2 extends Lambda implements Function0 {
        final /* synthetic */ Class b;
        final /* synthetic */ IEventSubscriber c;
        final /* synthetic */ boolean d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h2(Class cls, IEventSubscriber iEventSubscriber, boolean z) {
            super(0);
            this.b = cls;
            this.c = iEventSubscriber;
            this.d = z;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Did remove the background " + this.b + ' ' + this.c + "? " + this.d;
        }
    }

    static final class h3 extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ Function0 c;

        static final class a extends SuspendLambda implements Function2 {
            int b;
            final /* synthetic */ Function0 c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Function0 function0, Continuation continuation) {
                super(2, continuation);
                this.c = function0;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.c, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.b == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.c.invoke();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h3(Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.c = function0;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((h3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new h3(this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new a(this.c, (Continuation) null), 1, (Object) null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class h4 extends Lambda implements Function0 {
        public static final h4 b = new h4();

        h4() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The Braze SDK is not integrated correctly. Please visit https://www.braze.com/docs/developer_guide/platform_integration_guides/android/initial_sdk_setup/android_sdk_integration/";
        }
    }

    static final class i extends Lambda implements Function0 {
        public static final i b = new i();

        i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Applying any pending runtime configuration values";
        }
    }

    static final class i0 extends Lambda implements Function0 {
        public static final i0 b = new i0();

        i0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to retrieve the current user.";
        }
    }

    static final class i1 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i1(Braze braze, String str) {
            super(0);
            this.b = braze;
            this.c = str;
        }

        public final void a() {
            this.b.getUdm$android_sdk_base_release().f().b(this.c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class i2 extends Lambda implements Function0 {
        final /* synthetic */ Class b;
        final /* synthetic */ IEventSubscriber c;
        final /* synthetic */ boolean d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i2(Class cls, IEventSubscriber iEventSubscriber, boolean z) {
            super(0);
            this.b = cls;
            this.c = iEventSubscriber;
            this.d = z;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Did remove the synchronous " + this.b + ' ' + this.c + "? " + this.d;
        }
    }

    static final class i3 extends Lambda implements Function0 {
        public static final i3 b = new i3();

        i3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Got error in singleton run without result";
        }
    }

    static final class i4 extends Lambda implements Function0 {
        public static final i4 b = new i4();

        i4() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "";
        }
    }

    static final class j extends Lambda implements Function0 {
        public static final j b = new j();

        j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Clearing config values";
        }
    }

    static final class j0 extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ IValueCallback c;
        final /* synthetic */ Braze d;

        static final class a extends SuspendLambda implements Function2 {
            int b;
            final /* synthetic */ IValueCallback c;
            final /* synthetic */ Braze d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(IValueCallback iValueCallback, Braze braze, Continuation continuation) {
                super(2, continuation);
                this.c = iValueCallback;
                this.d = braze;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.c, this.d, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.b == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.c.onSuccess(this.d.getDeviceIdProvider$android_sdk_base_release().getDeviceId());
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j0(IValueCallback iValueCallback, Braze braze, Continuation continuation) {
            super(2, continuation);
            this.c = iValueCallback;
            this.d = braze;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((j0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new j0(this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineContext coroutineContext = BrazeCoroutineScope.INSTANCE.getCoroutineContext();
                a aVar = new a(this.c, this.d, (Continuation) null);
                this.b = 1;
                if (BuildersKt.withContext(coroutineContext, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    static final class j1 extends Lambda implements Function0 {
        public static final j1 b = new j1();

        j1() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log push notification action clicked.";
        }
    }

    static final class j2 extends Lambda implements Function0 {
        final /* synthetic */ Class b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j2(Class cls) {
            super(0);
            this.b = cls;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to remove " + this.b.getName() + " subscriber.";
        }
    }

    static final class j3 extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ Function2 c;

        static final class a extends SuspendLambda implements Function2 {
            int b;
            final /* synthetic */ Function2 c;

            /* renamed from: com.braze.Braze$j3$a$a  reason: collision with other inner class name */
            static final class C0028a extends SuspendLambda implements Function2 {
                int b;
                private /* synthetic */ Object c;
                final /* synthetic */ Function2 d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0028a(Function2 function2, Continuation continuation) {
                    super(2, continuation);
                    this.d = function2;
                }

                /* renamed from: a */
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((C0028a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                public final Continuation create(Object obj, Continuation continuation) {
                    C0028a aVar = new C0028a(this.d, continuation);
                    aVar.c = obj;
                    return aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.b;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function2 function2 = this.d;
                        this.b = 1;
                        obj = function2.invoke((CoroutineScope) this.c, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return obj;
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Function2 function2, Continuation continuation) {
                super(2, continuation);
                this.c = function2;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.c, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.b == 0) {
                    ResultKt.throwOnFailure(obj);
                    return BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new C0028a(this.c, (Continuation) null), 1, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j3(Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.c = function2;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((j3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new j3(this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Deferred async$default = BuildersKt__Builders_commonKt.async$default(i5.a, (CoroutineContext) null, (CoroutineStart) null, new a(this.c, (Continuation) null), 3, (Object) null);
                this.b = 1;
                obj = async$default.await(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    static final class j4 extends SuspendLambda implements Function2 {
        int b;
        private /* synthetic */ Object c;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Waited on previous tasks to finish!";
            }
        }

        j4(Continuation continuation) {
            super(2, continuation);
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((j4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            j4 j4Var = new j4(continuation);
            j4Var.c = obj;
            return j4Var;
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) (CoroutineScope) this.c, (BrazeLogger.Priority) null, (Throwable) null, (Function0) a.b, 3, (Object) null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class k extends Lambda implements Function0 {
        final /* synthetic */ BrazeConfig b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(BrazeConfig brazeConfig) {
            super(0);
            this.b = brazeConfig;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Setting pending config object: " + this.b;
        }
    }

    static final class k0 extends Lambda implements Function0 {
        public static final k0 b = new k0();

        k0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to retrieve the current device id.";
        }
    }

    static final class k1 extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Braze c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "No campaign Id associated with this notification (this is expected for test sends). Not logging push notification action clicked.";
            }
        }

        static final class b extends Lambda implements Function0 {
            public static final b b = new b();

            b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Action ID cannot be null or blank.";
            }
        }

        static final class c extends Lambda implements Function0 {
            public static final c b = new c();

            c() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Action Type cannot be null or blank.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k1(String str, Braze braze, String str2, String str3) {
            super(0);
            this.b = str;
            this.c = braze;
            this.d = str2;
            this.e = str3;
        }

        public final void a() {
            String str = this.b;
            boolean z = false;
            if (str == null || StringsKt.isBlank(str)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.W, (Throwable) null, (Function0) a.b, 2, (Object) null);
                return;
            }
            String str2 = this.d;
            if (str2 == null || StringsKt.isBlank(str2)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.W, (Throwable) null, (Function0) b.b, 2, (Object) null);
                return;
            }
            String str3 = this.e;
            if (str3 == null || StringsKt.isBlank(str3)) {
                z = true;
            }
            if (z) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.W, (Throwable) null, (Function0) c.b, 2, (Object) null);
            } else {
                this.c.getUdm$android_sdk_base_release().f().a(bo.app.f4.k.a(this.b, this.d, this.e));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class k2 extends Lambda implements Function0 {
        public static final k2 b = new k2();

        k2() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to request Content Cards refresh from Braze servers.";
        }
    }

    static final class k3 extends Lambda implements Function0 {
        public static final k3 b = new k3();

        k3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error scheduling push delivery";
        }
    }

    static final class k4 extends Lambda implements Function0 {
        public static final k4 b = new k4();

        k4() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception while waiting for previous tasks in serial work queue to finish.";
        }
    }

    static final class l extends Lambda implements Function0 {
        public static final l b = new l();

        l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to retrieve the cached ContentCardsUpdatedEvent.";
        }
    }

    static final class l0 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l0(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get feature flag " + this.b;
        }
    }

    static final class l1 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l1(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log push open for '" + this.b + '\'';
        }
    }

    static final class l2 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Content Cards is not enabled, skipping API call to refresh";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l2(Braze braze) {
            super(0);
            this.b = braze;
        }

        public final void a() {
            if (this.b.getUdm$android_sdk_base_release().l().x()) {
                bo.app.z1.a(this.b.getUdm$android_sdk_base_release().f(), this.b.getUdm$android_sdk_base_release().q().e(), this.b.getUdm$android_sdk_base_release().q().f(), 0, true, 4, (Object) null);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.b, (BrazeLogger.Priority) null, (Throwable) null, (Function0) a.b, 3, (Object) null);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class l3 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;
        final /* synthetic */ long c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l3(Braze braze, long j) {
            super(0);
            this.b = braze;
            this.c = j;
        }

        public final void a() {
            this.b.getUdm$android_sdk_base_release().f().a(this.c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class m extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ Braze c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(Braze braze, Continuation continuation) {
            super(2, continuation);
            this.c = braze;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((m) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new m(this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.c.getUdm$android_sdk_base_release().l().x()) {
                    return this.c.getUdm$android_sdk_base_release().q().getCachedCardsAsEvent();
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class m0 extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ Braze c;
        final /* synthetic */ String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m0(Braze braze, String str, Continuation continuation) {
            super(2, continuation);
            this.c = braze;
            this.d = str;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((m0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new m0(this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.c.getUdm$android_sdk_base_release().l().A()) {
                    return (FeatureFlag) CollectionsKt.firstOrNull(this.c.getUdm$android_sdk_base_release().s().b(this.d));
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class m1 extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Braze c;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "No campaign Id associated with this notification (this is expected for test sends). Not logging push notification opened.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m1(String str, Braze braze) {
            super(0);
            this.b = str;
            this.c = braze;
        }

        public final void a() {
            String str = this.b;
            if (str == null || StringsKt.isBlank(str)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.W, (Throwable) null, (Function0) a.b, 2, (Object) null);
            } else {
                this.c.getUdm$android_sdk_base_release().f().a((bo.app.x1) bo.app.i4.j.a(this.b));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class m2 extends Lambda implements Function0 {
        public static final m2 b = new m2();

        m2() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to request Content Cards refresh from the cache.";
        }
    }

    static final class m3 extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m3(String str, boolean z) {
            super(0);
            this.b = str;
            this.c = z;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set Google Advertising ID data on device. Google Advertising ID: " + this.b + " and limit-ad-tracking: " + this.c;
        }
    }

    static final class n extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set external id to: " + this.b;
        }
    }

    static final class n0 extends Lambda implements Function0 {
        public static final n0 b = new n0();

        n0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error handling test in-app message push";
        }
    }

    static final class n1 extends Lambda implements Function0 {
        final /* synthetic */ Intent b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n1(Intent intent) {
            super(0);
            this.b = intent;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error logging push notification with intent: " + this.b;
        }
    }

    static final class n2 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n2(Braze braze) {
            super(0);
            this.b = braze;
        }

        public final void a() {
            this.b.getExternalIEventMessenger$android_sdk_base_release().a((Object) this.b.getUdm$android_sdk_base_release().q().getCachedCardsAsEvent(), ContentCardsUpdatedEvent.class);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class n3 extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Braze c;
        final /* synthetic */ boolean d;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Google Advertising ID cannot be null or blank";
            }
        }

        static final class b extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ boolean c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(String str, boolean z) {
                super(0);
                this.b = str;
                this.c = z;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Setting Google Advertising ID: " + this.b + " and limit-ad-tracking: " + this.c;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n3(String str, Braze braze, boolean z) {
            super(0);
            this.b = str;
            this.c = braze;
            this.d = z;
        }

        public final void a() {
            if (StringsKt.isBlank(this.b)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.W, (Throwable) null, (Function0) a.b, 2, (Object) null);
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.D, (Throwable) null, (Function0) new b(this.b, this.d), 2, (Object) null);
            this.c.getDeviceDataProvider().a(this.b);
            this.c.getDeviceDataProvider().a(this.d);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class o extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Braze c;
        final /* synthetic */ String d;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "userId passed to changeUser was null or empty. The current user will remain the active user.";
            }
        }

        static final class b extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Rejected user id with byte length longer than 997. Not changing user. Input user id: " + this.b;
            }
        }

        static final class c extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Received request to change current user " + this.b + " to the same user id. Not changing user.";
            }
        }

        static final class d extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Set sdk auth signature on changeUser call: " + this.b;
            }
        }

        static final class e extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Changing anonymous user to " + this.b;
            }
        }

        static final class f extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(String str, String str2) {
                super(0);
                this.b = str;
                this.c = str2;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Changing current user " + this.b + " to new user " + this.c + '.';
            }
        }

        static final class g extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Set sdk auth signature on changeUser call: " + this.b;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(String str, Braze braze, String str2) {
            super(0);
            this.b = str;
            this.c = braze;
            this.d = str2;
        }

        public final void a() {
            bo.app.t3 t3Var;
            bo.app.l2 l2Var;
            String str = this.b;
            boolean z = false;
            if (str == null || str.length() == 0) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.W, (Throwable) null, (Function0) a.b, 2, (Object) null);
            } else if (StringUtils.getByteSize(this.b) > 997) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.W, (Throwable) null, (Function0) new b(this.b), 2, (Object) null);
            } else {
                BrazeUser access$getBrazeUser$p = this.c.brazeUser;
                if (access$getBrazeUser$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("brazeUser");
                    access$getBrazeUser$p = null;
                }
                String userId = access$getBrazeUser$p.getUserId();
                if (Intrinsics.areEqual((Object) userId, (Object) this.b)) {
                    BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this.c, BrazeLogger.Priority.I, (Throwable) null, (Function0) new c(this.b), 2, (Object) null);
                    String str2 = this.d;
                    if (str2 == null || StringsKt.isBlank(str2)) {
                        z = true;
                    }
                    if (!z) {
                        BrazeLogger.brazelog$default(brazeLogger, (Object) this.c, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new d(this.d), 3, (Object) null);
                        this.c.getUdm$android_sdk_base_release().h().a(this.d);
                        return;
                    }
                    return;
                }
                this.c.getUdm$android_sdk_base_release().e().b();
                this.c.getUdm$android_sdk_base_release().n().d();
                if (Intrinsics.areEqual((Object) userId, (Object) "")) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.I, (Throwable) null, (Function0) new e(this.b), 2, (Object) null);
                    bo.app.t3 access$getOfflineUserStorageProvider$p = this.c.offlineUserStorageProvider;
                    if (access$getOfflineUserStorageProvider$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("offlineUserStorageProvider");
                        access$getOfflineUserStorageProvider$p = null;
                    }
                    access$getOfflineUserStorageProvider$p.a(this.b);
                    BrazeUser access$getBrazeUser$p2 = this.c.brazeUser;
                    if (access$getBrazeUser$p2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("brazeUser");
                        access$getBrazeUser$p2 = null;
                    }
                    access$getBrazeUser$p2.setUserId(this.b);
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.I, (Throwable) null, (Function0) new f(userId, this.b), 2, (Object) null);
                    this.c.getExternalIEventMessenger$android_sdk_base_release().a((Object) new FeedUpdatedEvent(new ArrayList(), this.b, false, DateTimeUtils.nowInSeconds()), FeedUpdatedEvent.class);
                }
                this.c.getUdm$android_sdk_base_release().f().g();
                this.c.getUdm$android_sdk_base_release().b().a();
                bo.app.t3 access$getOfflineUserStorageProvider$p2 = this.c.offlineUserStorageProvider;
                if (access$getOfflineUserStorageProvider$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("offlineUserStorageProvider");
                    access$getOfflineUserStorageProvider$p2 = null;
                }
                access$getOfflineUserStorageProvider$p2.a(this.b);
                bo.app.a3 udm$android_sdk_base_release = this.c.getUdm$android_sdk_base_release();
                Context access$getApplicationContext$p = this.c.applicationContext;
                bo.app.t3 access$getOfflineUserStorageProvider$p3 = this.c.offlineUserStorageProvider;
                if (access$getOfflineUserStorageProvider$p3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("offlineUserStorageProvider");
                    t3Var = null;
                } else {
                    t3Var = access$getOfflineUserStorageProvider$p3;
                }
                BrazeConfigurationProvider configurationProvider$android_sdk_base_release = this.c.getConfigurationProvider$android_sdk_base_release();
                bo.app.i2 externalIEventMessenger$android_sdk_base_release = this.c.getExternalIEventMessenger$android_sdk_base_release();
                bo.app.e2 deviceIdProvider$android_sdk_base_release = this.c.getDeviceIdProvider$android_sdk_base_release();
                bo.app.l2 access$getRegistrationDataProvider$p = this.c.registrationDataProvider;
                if (access$getRegistrationDataProvider$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("registrationDataProvider");
                    l2Var = null;
                } else {
                    l2Var = access$getRegistrationDataProvider$p;
                }
                this.c.setUserSpecificMemberVariablesAndStartDispatch(new x6(access$getApplicationContext$p, t3Var, configurationProvider$android_sdk_base_release, externalIEventMessenger$android_sdk_base_release, deviceIdProvider$android_sdk_base_release, l2Var, this.c.getPushDeliveryManager$android_sdk_base_release(), Braze.shouldMockNetworkRequestsAndDropEvents, Braze.areOutboundNetworkRequestsOffline, this.c.getDeviceDataProvider()));
                String str3 = this.d;
                if (str3 == null || StringsKt.isBlank(str3)) {
                    z = true;
                }
                if (!z) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new g(this.d), 3, (Object) null);
                    this.c.getUdm$android_sdk_base_release().h().a(this.d);
                }
                this.c.getUdm$android_sdk_base_release().i().g();
                this.c.getUdm$android_sdk_base_release().f().f();
                udm$android_sdk_base_release.a();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class o0 extends Lambda implements Function0 {
        final /* synthetic */ Intent b;
        final /* synthetic */ Braze c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o0(Intent intent, Braze braze) {
            super(0);
            this.b = intent;
            this.c = braze;
        }

        public final void a() {
            Braze.Companion.requestTriggersIfInAppMessageTestPush$android_sdk_base_release(this.b, this.c.getUdm$android_sdk_base_release().f());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class o1 extends Lambda implements Function0 {
        final /* synthetic */ Intent b;
        final /* synthetic */ Braze c;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Cannot logPushNotificationOpened with null intent. Not logging push click.";
            }
        }

        static final class b extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Logging push click. Campaign Id: " + this.b;
            }
        }

        static final class c extends Lambda implements Function0 {
            public static final c b = new c();

            c() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "No campaign Id associated with this notification (this is expected for test sends). Not logging push click.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o1(Intent intent, Braze braze) {
            super(0);
            this.b = intent;
            this.c = braze;
        }

        public final void a() {
            Intent intent = this.b;
            if (intent == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.I, (Throwable) null, (Function0) a.b, 2, (Object) null);
                return;
            }
            String stringExtra = intent.getStringExtra(Constants.BRAZE_PUSH_CAMPAIGN_ID_KEY);
            if (!(stringExtra == null || StringsKt.isBlank(stringExtra))) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.I, (Throwable) null, (Function0) new b(stringExtra), 2, (Object) null);
                this.c.getUdm$android_sdk_base_release().f().a((bo.app.x1) bo.app.i4.j.a(stringExtra));
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.I, (Throwable) null, (Function0) c.b, 2, (Object) null);
            }
            Braze.Companion.requestTriggersIfInAppMessageTestPush$android_sdk_base_release(this.b, this.c.getUdm$android_sdk_base_release().f());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class o2 extends Lambda implements Function0 {
        public static final o2 b = new o2();

        o2() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to request refresh of feed.";
        }
    }

    static final class o3 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o3(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set SDK authentication signature on device.\n" + this.b;
        }
    }

    static final class p extends Lambda implements Function0 {
        public static final p b = new p();

        p() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to close session.";
        }
    }

    static final class p0 extends Lambda implements Function0 {
        public static final p0 b = new p0();

        p0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Ephemeral events enabled";
        }
    }

    static final class p1 extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p1(String str, String str2) {
            super(0);
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log push story page clicked for pageId: " + this.b + " campaignId: " + this.c;
        }
    }

    static final class p2 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p2(Braze braze) {
            super(0);
            this.b = braze;
        }

        public final void a() {
            this.b.getUdm$android_sdk_base_release().f().a(new y3.a((String) null, (Boolean) null, (Boolean) null, (bo.app.x3) null, 15, (DefaultConstructorMarker) null).d());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class p3 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;
        final /* synthetic */ String c;

        static final class a extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Got new sdk auth signature " + this.b;
            }
        }

        static final class b extends Lambda implements Function0 {
            public static final b b = new b();

            b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "SDK authentication signature cannot be null or blank";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p3(Braze braze, String str) {
            super(0);
            this.b = braze;
            this.c = str;
        }

        public final void a() {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this.b, BrazeLogger.Priority.V, (Throwable) null, (Function0) new a(this.c), 2, (Object) null);
            if (StringsKt.isBlank(this.c)) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this.b, BrazeLogger.Priority.W, (Throwable) null, (Function0) b.b, 2, (Object) null);
                return;
            }
            this.b.getUdm$android_sdk_base_release().h().a(this.c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class q extends Lambda implements Function0 {
        final /* synthetic */ Activity b;
        final /* synthetic */ Braze c;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Cannot close session with null activity.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(Activity activity, Braze braze) {
            super(0);
            this.b = activity;
            this.c = braze;
        }

        public final void a() {
            if (this.b == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.W, (Throwable) null, (Function0) a.b, 2, (Object) null);
            } else {
                this.c.getUdm$android_sdk_base_release().f().closeSession(this.b);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class q0 extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Set c;
        final /* synthetic */ boolean d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q0(String str, Set set, boolean z) {
            super(0);
            this.b = str;
            this.c = set;
            this.d = z;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Checking event key [" + this.b + "] against ephemeral event list " + this.c + " and got match?: " + this.d;
        }
    }

    static final class q1 extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ Braze d;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Push story page click input was invalid. Not logging in-app purchase to Braze.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q1(String str, String str2, Braze braze) {
            super(0);
            this.b = str;
            this.c = str2;
            this.d = braze;
        }

        public final void a() {
            if (!ValidationUtils.isValidPushStoryClickInput(this.b, this.c)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.d, BrazeLogger.Priority.W, (Throwable) null, (Function0) a.b, 2, (Object) null);
                return;
            }
            j.a aVar = bo.app.j.h;
            String str = this.b;
            Intrinsics.checkNotNull(str);
            String str2 = this.c;
            Intrinsics.checkNotNull(str2);
            bo.app.x1 e = aVar.e(str, str2);
            if (e != null) {
                this.d.getUdm$android_sdk_base_release().f().a(e);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class q2 extends Lambda implements Function0 {
        public static final q2 b = new q2();

        q2() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to retrieve and publish feed from offline cache.";
        }
    }

    static final class q3 extends Lambda implements Function0 {
        final /* synthetic */ boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q3(boolean z) {
            super(0);
            this.b = z;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set sync policy offline to " + this.b;
        }
    }

    static final class r extends Lambda implements Function0 {
        public static final r b = new r();

        r() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to retrieve the current user.";
        }
    }

    static final class r0 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r0(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log custom event: " + this.b;
        }
    }

    static final class r1 extends Lambda implements Function0 {
        public static final r1 b = new r1();

        r1() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to open session.";
        }
    }

    static final class r2 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r2(Braze braze) {
            super(0);
            this.b = braze;
        }

        public final void a() {
            this.b.getExternalIEventMessenger$android_sdk_base_release().a((Object) this.b.getUdm$android_sdk_base_release().c().getCachedCardsAsEvent(), FeedUpdatedEvent.class);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class r3 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;
        final /* synthetic */ boolean c;

        static final class a extends Lambda implements Function0 {
            final /* synthetic */ boolean b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(boolean z) {
                super(0);
                this.b = z;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Setting the image loader deny network downloads to " + this.b;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r3(Braze braze, boolean z) {
            super(0);
            this.b = braze;
            this.c = z;
        }

        public final void a() {
            this.b.getUdm$android_sdk_base_release().f().c(this.c);
            this.b.getUdm$android_sdk_base_release().k().a(this.c);
            Braze braze = this.b;
            if (braze.imageLoader != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) braze, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new a(this.c), 3, (Object) null);
                this.b.getImageLoader().setOffline(this.c);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class s extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ Braze c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(Braze braze, Continuation continuation) {
            super(2, continuation);
            this.c = braze;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((s) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new s(this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                BrazeUser access$getBrazeUser$p = this.c.brazeUser;
                if (access$getBrazeUser$p != null) {
                    return access$getBrazeUser$p;
                }
                Intrinsics.throwUninitializedPropertyAccessException("brazeUser");
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class s0 extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Braze c;
        final /* synthetic */ BrazeProperties d;

        static final class a extends Lambda implements Function0 {
            final /* synthetic */ Ref.ObjectRef b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Ref.ObjectRef objectRef) {
                super(0);
                this.b = objectRef;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Logged custom event with name " + ((String) this.b.element) + " was invalid. Not logging custom event to Braze.";
            }
        }

        static final class b extends Lambda implements Function0 {
            final /* synthetic */ Ref.ObjectRef b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(Ref.ObjectRef objectRef) {
                super(0);
                this.b = objectRef;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Custom event with name " + ((String) this.b.element) + " logged with invalid properties. Not logging custom event to Braze.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s0(String str, Braze braze, BrazeProperties brazeProperties) {
            super(0);
            this.b = str;
            this.c = braze;
            this.d = brazeProperties;
        }

        public final void a() {
            boolean z;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            T t = this.b;
            objectRef.element = t;
            if (!ValidationUtils.isValidLogCustomEventInput(t, this.c.getUdm$android_sdk_base_release().l())) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.W, (Throwable) null, (Function0) new a(objectRef), 2, (Object) null);
                return;
            }
            BrazeProperties brazeProperties = this.d;
            boolean z2 = true;
            if (brazeProperties == null || !brazeProperties.isInvalid()) {
                z2 = false;
            }
            if (z2) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.W, (Throwable) null, (Function0) new b(objectRef), 2, (Object) null);
                return;
            }
            T ensureBrazeFieldLength = ValidationUtils.ensureBrazeFieldLength((String) objectRef.element);
            objectRef.element = ensureBrazeFieldLength;
            bo.app.x1 a2 = bo.app.j.h.a((String) ensureBrazeFieldLength, this.d);
            if (a2 != null) {
                if (this.c.isEphemeralEventKey((String) objectRef.element)) {
                    z = this.c.getUdm$android_sdk_base_release().l().z();
                } else {
                    z = this.c.getUdm$android_sdk_base_release().f().a(a2);
                }
                if (z) {
                    this.c.getUdm$android_sdk_base_release().r().a((bo.app.u2) new bo.app.d0((String) objectRef.element, this.d, a2));
                }
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class s1 extends Lambda implements Function0 {
        final /* synthetic */ Activity b;
        final /* synthetic */ Braze c;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Cannot open session with null activity.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s1(Activity activity, Braze braze) {
            super(0);
            this.b = activity;
            this.c = braze;
        }

        public final void a() {
            if (this.b == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.I, (Throwable) null, (Function0) a.b, 2, (Object) null);
            } else {
                this.c.getUdm$android_sdk_base_release().f().openSession(this.b);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class s2 extends Lambda implements Function0 {
        public static final s2 b = new s2();

        s2() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to request geofence refresh.";
        }
    }

    static final class s3 extends Lambda implements Function0 {
        public static final s3 b = new s3();

        s3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add subscriber for Content Cards updates.";
        }
    }

    static final class t extends Lambda implements Function0 {
        public static final t b = new t();

        t() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot deserialize null content card json string. Returning null.";
        }
    }

    static final class t0 extends Lambda implements Function0 {
        public static final t0 b = new t0();

        t0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log a Feature Flag impression.";
        }
    }

    static final class t1 extends Lambda implements Function0 {
        public static final t1 b = new t1();

        t1() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to flush push delivery events";
        }
    }

    static final class t2 extends Lambda implements Function0 {
        final /* synthetic */ IBrazeLocation b;
        final /* synthetic */ Braze c;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Cannot request Geofence refresh with null location.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t2(IBrazeLocation iBrazeLocation, Braze braze) {
            super(0);
            this.b = iBrazeLocation;
            this.c = braze;
        }

        public final void a() {
            if (this.b == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, (BrazeLogger.Priority) null, (Throwable) null, (Function0) a.b, 3, (Object) null);
            } else {
                this.c.getUdm$android_sdk_base_release().p().requestGeofenceRefresh(this.b);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class t3 extends Lambda implements Function0 {
        public static final t3 b = new t3();

        t3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to send cached feature flags upon subscribeToFeatureFlagsUpdates.";
        }
    }

    static final class u extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to deserialize content card json string. Payload: " + this.b;
        }
    }

    static final class u0 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u0(Braze braze, String str) {
            super(0);
            this.b = braze;
            this.c = str;
        }

        public final void a() {
            this.b.getUdm$android_sdk_base_release().s().a(this.c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class u1 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u1(Braze braze) {
            super(0);
            this.b = braze;
        }

        public final void a() {
            bo.app.z1.a(this.b.getUdm$android_sdk_base_release().f(), 0, 1, (Object) null);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class u2 extends Lambda implements Function0 {
        final /* synthetic */ boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u2(boolean z) {
            super(0);
            this.b = z;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to request geofence refresh with rate limit ignore: " + this.b;
        }
    }

    static final class u3 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Sending cached update upon feature flag subscription";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u3(Braze braze) {
            super(0);
            this.b = braze;
        }

        public final void a() {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.b, (BrazeLogger.Priority) null, (Throwable) null, (Function0) a.b, 3, (Object) null);
            if (this.b.getUdm$android_sdk_base_release().l().A()) {
                this.b.getUdm$android_sdk_base_release().s().g();
            } else {
                this.b.getUdm$android_sdk_base_release().e().a((Object) new bo.app.l1(), bo.app.l1.class);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class v extends Lambda implements Function0 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(JSONObject jSONObject) {
            super(0);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to deserialize content card json. Payload: " + this.b;
        }
    }

    static final class v0 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v0(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log feed card clicked. Card id: " + this.b;
        }
    }

    static final class v1 extends Lambda implements Function0 {
        public static final v1 b = new v1();

        v1() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "User dependency manager is uninitialized. Not publishing error.";
        }
    }

    static final class v2 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;
        final /* synthetic */ boolean c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v2(Braze braze, boolean z) {
            super(0);
            this.b = braze;
            this.c = z;
        }

        public final void a() {
            this.b.getUdm$android_sdk_base_release().p().requestGeofenceRefresh(this.c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class v3 extends Lambda implements Function0 {
        public static final v3 b = new v3();

        v3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add subscriber for Feature Flags updates.";
        }
    }

    static final class w extends SuspendLambda implements Function2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ Braze d;
        final /* synthetic */ JSONObject e;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Content Cards are disabled. Not deserializing json. Returning null.";
            }
        }

        static final class b extends Lambda implements Function0 {
            public static final b b = new b();

            b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Cannot deserialize null content card json. Returning null.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(Braze braze, JSONObject jSONObject, Continuation continuation) {
            super(2, continuation);
            this.d = braze;
            this.e = jSONObject;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((w) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            w wVar = new w(this.d, this.e, continuation);
            wVar.c = obj;
            return wVar;
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.c;
                if (!this.d.getUdm$android_sdk_base_release().l().x()) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) coroutineScope, BrazeLogger.Priority.W, (Throwable) null, (Function0) a.b, 2, (Object) null);
                    return null;
                } else if (this.e != null) {
                    return this.d.getUdm$android_sdk_base_release().q().a(this.e);
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) coroutineScope, BrazeLogger.Priority.W, (Throwable) null, (Function0) b.b, 2, (Object) null);
                    return null;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    static final class w0 extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Braze c;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Card ID cannot be null or blank.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w0(String str, Braze braze) {
            super(0);
            this.b = str;
            this.c = braze;
        }

        public final void a() {
            String str = this.b;
            if (str == null || StringsKt.isBlank(str)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.W, (Throwable) null, (Function0) a.b, 2, (Object) null);
                return;
            }
            bo.app.x1 e = bo.app.j.h.e(this.b);
            if (e != null) {
                this.c.getUdm$android_sdk_base_release().f().a(e);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class w1 extends Lambda implements Function0 {
        final /* synthetic */ Throwable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w1(Throwable th) {
            super(0);
            this.b = th;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log throwable: " + this.b;
        }
    }

    static final class w2 extends Lambda implements Function0 {
        public static final w2 b = new w2();

        w2() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to request geofence refresh.";
        }
    }

    static final class w3 extends Lambda implements Function0 {
        public static final w3 b = new w3();

        w3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add subscriber for feed updates.";
        }
    }

    static final class x extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to deserialize in-app message json. Payload: " + this.b;
        }
    }

    static final class x0 extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x0(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log feed card impression. Card id: " + this.b;
        }
    }

    static final class x1 extends Lambda implements Function0 {
        public static final x1 b = new x1();

        x1() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to post geofence report.";
        }
    }

    static final class x2 extends Lambda implements Function0 {
        final /* synthetic */ double b;
        final /* synthetic */ double c;
        final /* synthetic */ Braze d;

        static final class a extends Lambda implements Function0 {
            final /* synthetic */ double b;
            final /* synthetic */ double c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(double d, double d2) {
                super(0);
                this.b = d;
                this.c = d2;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Location provided is invalid. Not requesting refresh of Braze Geofences. Provided latitude - longitude: " + this.b + " - " + this.c;
            }
        }

        static final class b extends Lambda implements Function0 {
            final /* synthetic */ double b;
            final /* synthetic */ double c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(double d, double d2) {
                super(0);
                this.b = d;
                this.c = d2;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Manually requesting Geofence refresh of with provided latitude - longitude: " + this.b + " - " + this.c;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x2(double d2, double d3, Braze braze) {
            super(0);
            this.b = d2;
            this.c = d3;
            this.d = braze;
        }

        public final void a() {
            if (!ValidationUtils.isValidLocation(this.b, this.c)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.d, BrazeLogger.Priority.W, (Throwable) null, (Function0) new a(this.b, this.c), 2, (Object) null);
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.d, BrazeLogger.Priority.W, (Throwable) null, (Function0) new b(this.b, this.c), 2, (Object) null);
            this.d.getUdm$android_sdk_base_release().p().requestGeofenceRefresh((IBrazeLocation) new BrazeLocation(this.b, this.c, (Double) null, (Double) null, (Double) null, 28, (DefaultConstructorMarker) null));
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class x3 extends Lambda implements Function0 {
        public static final x3 b = new x3();

        x3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add subscriber for network failures.";
        }
    }

    static final class y extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ Braze d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y(String str, Braze braze, Continuation continuation) {
            super(2, continuation);
            this.c = str;
            this.d = braze;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((y) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new y(this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                String str = this.c;
                if (str == null) {
                    return null;
                }
                return com.braze.support.h.a(str, this.d.getUdm$android_sdk_base_release().f());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class y0 extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Braze c;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Card ID cannot be null or blank.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y0(String str, Braze braze) {
            super(0);
            this.b = str;
            this.c = braze;
        }

        public final void a() {
            String str = this.b;
            if (str == null || StringsKt.isBlank(str)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, BrazeLogger.Priority.W, (Throwable) null, (Function0) a.b, 2, (Object) null);
                return;
            }
            bo.app.x1 f = bo.app.j.h.f(this.b);
            if (f != null) {
                this.c.getUdm$android_sdk_base_release().f().a(f);
            }
            this.c.getUdm$android_sdk_base_release().c().markCardAsViewed(this.b);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class y1 extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ GeofenceTransitionType c;
        final /* synthetic */ Braze d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y1(String str, GeofenceTransitionType geofenceTransitionType, Braze braze) {
            super(0);
            this.b = str;
            this.c = geofenceTransitionType;
            this.d = braze;
        }

        public final void a() {
            String str = this.b;
            if (!(str == null || StringsKt.isBlank(str)) && this.c != null) {
                this.d.getUdm$android_sdk_base_release().p().postGeofenceReport(this.b, this.c);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class y2 extends Lambda implements Function0 {
        public static final y2 b = new y2();

        y2() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to initialize geofences with the geofence manager.";
        }
    }

    static final class y3 extends Lambda implements Function0 {
        public static final y3 b = new y3();

        y3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add subscriber to new in-app messages.";
        }
    }

    static final class z extends Lambda implements Function0 {
        public static final z b = new z();

        z() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to retrieve the device id.";
        }
    }

    static final class z0 extends Lambda implements Function0 {
        public static final z0 b = new z0();

        z0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log that the feed was displayed.";
        }
    }

    static final class z1 extends Lambda implements Function0 {
        final /* synthetic */ InAppMessageEvent b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z1(InAppMessageEvent inAppMessageEvent) {
            super(0);
            this.b = inAppMessageEvent;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error reenqueueing In-App Message from event " + this.b;
        }
    }

    static final class z2 extends Lambda implements Function0 {
        final /* synthetic */ Braze b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z2(Braze braze) {
            super(0);
            this.b = braze;
        }

        public final void a() {
            this.b.getUdm$android_sdk_base_release().p().initializeGeofences();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class z3 extends Lambda implements Function0 {
        public static final z3 b = new z3();

        z3() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add subscriber to no matching trigger events.";
        }
    }

    public Braze(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        long nanoTime = System.nanoTime();
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) a.b, 3, (Object) null);
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "context.applicationContext");
        this.applicationContext = applicationContext2;
        String str = Build.MODEL;
        if (str != null) {
            Set<String> set = KNOWN_APP_CRAWLER_DEVICE_MODELS;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (set.contains(lowerCase)) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new b(str), 2, (Object) null);
                Companion.enableMockNetworkRequestsAndDropEventsMode();
            }
        }
        setImageLoader(new DefaultBrazeImageLoader(this.applicationContext));
        this.externalIEventMessenger = new bo.app.e1(Companion.getSdkEnablementProvider(this.applicationContext));
        run$android_sdk_base_release(c.b, false, new d(this, context));
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new e(System.nanoTime(), nanoTime), 3, (Object) null);
    }

    @JvmStatic
    public static final void addSdkMetadata(Context context, EnumSet<BrazeSdkMetadata> enumSet) {
        Companion.addSdkMetadata(context, enumSet);
    }

    @JvmStatic
    public static final void clearEndpointProvider() {
        Companion.clearEndpointProvider();
    }

    @JvmStatic
    public static final boolean configure(Context context, BrazeConfig brazeConfig) {
        return Companion.configure(context, brazeConfig);
    }

    @JvmStatic
    public static final void disableSdk(Context context) {
        Companion.disableSdk(context);
    }

    @JvmStatic
    public static final boolean enableMockNetworkRequestsAndDropEventsMode() {
        return Companion.enableMockNetworkRequestsAndDropEventsMode();
    }

    @JvmStatic
    public static final void enableSdk(Context context) {
        Companion.enableSdk(context);
    }

    @JvmStatic
    public static final Uri getApiEndpoint(Uri uri) {
        return Companion.getApiEndpoint(uri);
    }

    private final ContentCardsUpdatedEvent getCachedContentCardsUpdatedEvent() {
        return (ContentCardsUpdatedEvent) runForResult$default(this, (Object) null, l.b, false, new m(this, (Continuation) null), 4, (Object) null);
    }

    public static /* synthetic */ void getConfigurationProvider$android_sdk_base_release$annotations() {
    }

    @JvmStatic
    public static final String getConfiguredApiKey(BrazeConfigurationProvider brazeConfigurationProvider) {
        return Companion.getConfiguredApiKey(brazeConfigurationProvider);
    }

    public static final IBrazeNotificationFactory getCustomBrazeNotificationFactory() {
        return Companion.getCustomBrazeNotificationFactory();
    }

    /* access modifiers changed from: private */
    public final bo.app.d2 getDeviceDataProvider() {
        bo.app.d2 d2Var = deviceDataProvider;
        if (d2Var == null) {
            d2Var = new bo.app.k0(this.applicationContext, getConfigurationProvider$android_sdk_base_release());
        }
        deviceDataProvider = d2Var;
        return d2Var;
    }

    public static /* synthetic */ void getDeviceIdProvider$android_sdk_base_release$annotations() {
    }

    public static /* synthetic */ void getExternalIEventMessenger$android_sdk_base_release$annotations() {
    }

    @JvmStatic
    public static final Braze getInstance(Context context) {
        return Companion.getInstance(context);
    }

    public static final boolean getOutboundNetworkRequestsOffline() {
        return Companion.getOutboundNetworkRequestsOffline();
    }

    public static /* synthetic */ void getPushDeliveryManager$android_sdk_base_release$annotations() {
    }

    private static /* synthetic */ void getRegistrationDataProvider$annotations() {
    }

    public static /* synthetic */ void getUdm$android_sdk_base_release$annotations() {
    }

    public static /* synthetic */ void isApiKeyPresent$android_sdk_base_release$annotations() {
    }

    public static final boolean isDisabled() {
        return Companion.isDisabled();
    }

    /* access modifiers changed from: private */
    public final boolean isEphemeralEventKey(String str) {
        if (!getConfigurationProvider$android_sdk_base_release().isEphemeralEventsEnabled()) {
            return false;
        }
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, (Function0) p0.b, 2, (Object) null);
        Set<String> ephemeralEventKeys = getConfigurationProvider$android_sdk_base_release().getEphemeralEventKeys();
        boolean contains = ephemeralEventKeys.contains(str);
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, (Function0) new q0(str, ephemeralEventKeys, contains), 2, (Object) null);
        return contains;
    }

    /* access modifiers changed from: private */
    public final void publishError(Throwable th) {
        if (this.udm == null) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.V, th, (Function0<String>) v1.b);
            return;
        }
        try {
            getUdm$android_sdk_base_release().e().a((Object) th, Throwable.class);
        } catch (Exception e5) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e5, (Function0<String>) new w1(th));
        }
    }

    public static /* synthetic */ void run$android_sdk_base_release$default(Braze braze, Function0 function0, boolean z4, Function0 function02, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = true;
        }
        braze.run$android_sdk_base_release(function0, z4, function02);
    }

    private final <T> T runForResult(T t4, Function0<String> function0, boolean z4, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        if (z4 && Companion.isDisabled()) {
            return t4;
        }
        try {
            return BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new j3(function2, (Continuation) null), 1, (Object) null);
        } catch (Exception e5) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e5, function0);
            publishError(e5);
            return t4;
        }
    }

    static /* synthetic */ Object runForResult$default(Braze braze, Object obj, Function0 function0, boolean z4, Function2 function2, int i5, Object obj2) {
        if ((i5 & 4) != 0) {
            z4 = true;
        }
        return braze.runForResult(obj, function0, z4, function2);
    }

    public static final void setCustomBrazeNotificationFactory(IBrazeNotificationFactory iBrazeNotificationFactory) {
        Companion.setCustomBrazeNotificationFactory(iBrazeNotificationFactory);
    }

    @JvmStatic
    public static final void setEndpointProvider(IBrazeEndpointProvider iBrazeEndpointProvider) {
        Companion.setEndpointProvider(iBrazeEndpointProvider);
    }

    public static final void setOutboundNetworkRequestsOffline(boolean z4) {
        Companion.setOutboundNetworkRequestsOffline(z4);
    }

    /* access modifiers changed from: private */
    public final void setSyncPolicyOfflineStatus(boolean z4) {
        run$android_sdk_base_release$default(this, new q3(z4), false, new r3(this, z4), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void setUserSpecificMemberVariablesAndStartDispatch(x6 x6Var) {
        setUdm$android_sdk_base_release(x6Var);
        i5.a.a(getUdm$android_sdk_base_release().e());
        w6 i5 = getUdm$android_sdk_base_release().i();
        bo.app.z1 f5 = getUdm$android_sdk_base_release().f();
        bo.app.t3 t3Var = this.offlineUserStorageProvider;
        if (t3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offlineUserStorageProvider");
            t3Var = null;
        }
        this.brazeUser = new BrazeUser(i5, f5, t3Var.a(), getUdm$android_sdk_base_release().o(), getUdm$android_sdk_base_release().l());
        getUdm$android_sdk_base_release().t().a((bo.app.i2) getUdm$android_sdk_base_release().e());
        getUdm$android_sdk_base_release().g().d();
        getUdm$android_sdk_base_release().m().a((bo.app.f2) getUdm$android_sdk_base_release().g());
    }

    /* access modifiers changed from: private */
    public final void verifyProperSdkSetup() {
        boolean z4 = false;
        boolean z5 = true;
        for (String next : NECESSARY_BRAZE_SDK_PERMISSIONS) {
            if (!PermissionUtils.hasPermission(this.applicationContext, next)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new f4(next), 2, (Object) null);
                z5 = false;
            }
        }
        if (StringsKt.isBlank(getConfigurationProvider$android_sdk_base_release().getBrazeApiKey().toString())) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) g4.b, 2, (Object) null);
        } else {
            z4 = z5;
        }
        if (!z4) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) h4.b, 2, (Object) null);
        }
    }

    @JvmStatic
    public static final void wipeData(Context context) {
        Companion.wipeData(context);
    }

    public final /* synthetic */ void addSerializedCardJsonToStorage$android_sdk_base_release(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "serializedCardJson");
        run$android_sdk_base_release$default(this, new f(str2, str), false, new g(str, this, str2), 2, (Object) null);
    }

    public <T> void addSingleSynchronousSubscription(IEventSubscriber<T> iEventSubscriber, Class<T> cls) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        Intrinsics.checkNotNullParameter(cls, "eventClass");
        try {
            this.externalIEventMessenger.c(cls, iEventSubscriber);
        } catch (Exception e5) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e5, (Function0<String>) new h(cls));
            publishError(e5);
        }
    }

    public final /* synthetic */ void applyPendingRuntimeConfiguration$android_sdk_base_release() {
        ReentrantLock reentrantLock = brazeClassLock;
        reentrantLock.lock();
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) i.b, 3, (Object) null);
            RuntimeAppConfigurationProvider runtimeAppConfigurationProvider = new RuntimeAppConfigurationProvider(this.applicationContext);
            for (BrazeConfig next : pendingConfigurations) {
                if (Intrinsics.areEqual((Object) next, (Object) clearConfigSentinel)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) j.b, 2, (Object) null);
                    runtimeAppConfigurationProvider.clearAllConfigurationValues();
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new k(next), 2, (Object) null);
                    runtimeAppConfigurationProvider.setConfiguration(next);
                }
            }
            pendingConfigurations.clear();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void changeUser(String str) {
        changeUser(str, (String) null);
    }

    public void closeSession(Activity activity) {
        run$android_sdk_base_release$default(this, p.b, false, new q(activity, this), 2, (Object) null);
    }

    public Card deserializeContentCard(String str) {
        if (Companion.isDisabled()) {
            return null;
        }
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) t.b, 2, (Object) null);
            return null;
        }
        try {
            return deserializeContentCard(new JSONObject(str));
        } catch (Exception e5) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e5, (Function0<String>) new u(str));
            publishError(e5);
            return null;
        }
    }

    public IInAppMessage deserializeInAppMessageString(String str) {
        return (IInAppMessage) runForResult$default(this, (Object) null, new x(str), false, new y(str, this, (Continuation) null), 4, (Object) null);
    }

    public List<FeatureFlag> getAllFeatureFlags() {
        return (List) runForResult$default(this, CollectionsKt.emptyList(), b0.b, false, new c0(this, (Continuation) null), 4, (Object) null);
    }

    public List<Card> getCachedContentCards() {
        if (Companion.isDisabled()) {
            return null;
        }
        ContentCardsUpdatedEvent cachedContentCardsUpdatedEvent = getCachedContentCardsUpdatedEvent();
        if (cachedContentCardsUpdatedEvent != null) {
            return cachedContentCardsUpdatedEvent.getAllCards();
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) d0.b, 2, (Object) null);
        return null;
    }

    public final BrazeConfigurationProvider getConfigurationProvider$android_sdk_base_release() {
        BrazeConfigurationProvider brazeConfigurationProvider = this.configurationProvider;
        if (brazeConfigurationProvider != null) {
            return brazeConfigurationProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationProvider");
        return null;
    }

    public int getContentCardCount() {
        if (Companion.isDisabled()) {
            return -1;
        }
        ContentCardsUpdatedEvent cachedContentCardsUpdatedEvent = getCachedContentCardsUpdatedEvent();
        if (cachedContentCardsUpdatedEvent != null) {
            return cachedContentCardsUpdatedEvent.getCardCount();
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) e0.b, 2, (Object) null);
        return -1;
    }

    public int getContentCardUnviewedCount() {
        if (Companion.isDisabled()) {
            return -1;
        }
        ContentCardsUpdatedEvent cachedContentCardsUpdatedEvent = getCachedContentCardsUpdatedEvent();
        if (cachedContentCardsUpdatedEvent != null) {
            return cachedContentCardsUpdatedEvent.getUnviewedCardCount();
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) f0.b, 2, (Object) null);
        return -1;
    }

    public long getContentCardsLastUpdatedInSecondsFromEpoch() {
        if (Companion.isDisabled()) {
            return -1;
        }
        ContentCardsUpdatedEvent cachedContentCardsUpdatedEvent = getCachedContentCardsUpdatedEvent();
        if (cachedContentCardsUpdatedEvent != null) {
            return cachedContentCardsUpdatedEvent.getTimestampSeconds();
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) g0.b, 2, (Object) null);
        return -1;
    }

    public BrazeUser getCurrentUser() {
        return (BrazeUser) runForResult((Object) null, r.b, false, new s(this, (Continuation) null));
    }

    public String getDeviceId() {
        return (String) runForResult("", z.b, false, new a0(this, (Continuation) null));
    }

    public void getDeviceIdAsync(IValueCallback<String> iValueCallback) {
        Intrinsics.checkNotNullParameter(iValueCallback, "completionCallback");
        if (Companion.isDisabled()) {
            iValueCallback.onError();
            return;
        }
        try {
            Job unused = BuildersKt__Builders_commonKt.launch$default(i5.a, (CoroutineContext) null, (CoroutineStart) null, new j0(iValueCallback, this, (Continuation) null), 3, (Object) null);
        } catch (Exception e5) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e5, (Function0<String>) k0.b);
            iValueCallback.onError();
            publishError(e5);
        }
    }

    public final bo.app.e2 getDeviceIdProvider$android_sdk_base_release() {
        bo.app.e2 e2Var = this.deviceIdProvider;
        if (e2Var != null) {
            return e2Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deviceIdProvider");
        return null;
    }

    public final bo.app.i2 getExternalIEventMessenger$android_sdk_base_release() {
        return this.externalIEventMessenger;
    }

    public FeatureFlag getFeatureFlag(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return (FeatureFlag) runForResult$default(this, (Object) null, new l0(str), false, new m0(this, str, (Continuation) null), 4, (Object) null);
    }

    public IBrazeImageLoader getImageLoader() {
        IBrazeImageLoader iBrazeImageLoader = this.imageLoader;
        if (iBrazeImageLoader != null) {
            return iBrazeImageLoader;
        }
        Intrinsics.throwUninitializedPropertyAccessException("imageLoader");
        return null;
    }

    public final bo.app.k4 getPushDeliveryManager$android_sdk_base_release() {
        bo.app.k4 k4Var = this.pushDeliveryManager;
        if (k4Var != null) {
            return k4Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pushDeliveryManager");
        return null;
    }

    public String getRegisteredPushToken() {
        return (String) runForResult$default(this, (Object) null, d2.b, false, new e2(this, (Continuation) null), 4, (Object) null);
    }

    public final bo.app.a3 getUdm$android_sdk_base_release() {
        bo.app.a3 a3Var = this.udm;
        if (a3Var != null) {
            return a3Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("udm");
        return null;
    }

    public final /* synthetic */ void handleInAppMessageTestPush$android_sdk_base_release(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        run$android_sdk_base_release$default(this, n0.b, false, new o0(intent, this), 2, (Object) null);
    }

    public final Boolean isApiKeyPresent$android_sdk_base_release() {
        return this.isApiKeyPresent;
    }

    public void logCustomEvent(String str) {
        logCustomEvent(str, (BrazeProperties) null);
    }

    public void logFeatureFlagImpression(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        run$android_sdk_base_release$default(this, t0.b, false, new u0(this, str), 2, (Object) null);
    }

    @Deprecated(message = "Please call {@link Card#logClick()} instead to log a click.", replaceWith = @ReplaceWith(expression = "Card.logClick()", imports = {}))
    public void logFeedCardClick(String str) {
        run$android_sdk_base_release$default(this, new v0(str), false, new w0(str, this), 2, (Object) null);
    }

    @Deprecated(message = "Please call {@link Card#logImpression()} instead to log an impression.", replaceWith = @ReplaceWith(expression = "Card.logImpression", imports = {}))
    public void logFeedCardImpression(String str) {
        run$android_sdk_base_release$default(this, new x0(str), false, new y0(str, this), 2, (Object) null);
    }

    public void logFeedDisplayed() {
        run$android_sdk_base_release$default(this, z0.b, false, new a1(this), 2, (Object) null);
    }

    public final /* synthetic */ void logLocationRecordedEventFromLocationUpdate$android_sdk_base_release(IBrazeLocation iBrazeLocation) {
        Intrinsics.checkNotNullParameter(iBrazeLocation, FirebaseAnalytics.Param.LOCATION);
        run$android_sdk_base_release$default(this, b1.b, false, new c1(iBrazeLocation, this), 2, (Object) null);
    }

    public void logPurchase(String str, String str2, BigDecimal bigDecimal) {
        logPurchase(str, str2, bigDecimal, 1);
    }

    public final /* synthetic */ void logPushDelivery$android_sdk_base_release(String str, long j5) {
        Intrinsics.checkNotNullParameter(str, "campaignId");
        run$android_sdk_base_release$default(this, new f1(str), false, new g1(this, str, j5), 2, (Object) null);
    }

    public final /* synthetic */ void logPushMaxCampaign$android_sdk_base_release(String str) {
        Intrinsics.checkNotNullParameter(str, "campaign");
        run$android_sdk_base_release$default(this, h1.b, false, new i1(this, str), 2, (Object) null);
    }

    public void logPushNotificationActionClicked(String str, String str2, String str3) {
        run$android_sdk_base_release$default(this, j1.b, false, new k1(str, this, str2, str3), 2, (Object) null);
    }

    public void logPushNotificationOpened(String str) {
        run$android_sdk_base_release$default(this, new l1(str), false, new m1(str, this), 2, (Object) null);
    }

    public void logPushStoryPageClicked(String str, String str2) {
        run$android_sdk_base_release$default(this, new p1(str2, str), false, new q1(str, str2, this), 2, (Object) null);
    }

    public void openSession(Activity activity) {
        run$android_sdk_base_release$default(this, r1.b, false, new s1(activity, this), 2, (Object) null);
    }

    public final /* synthetic */ void performPushDeliveryFlush$android_sdk_base_release() {
        run$android_sdk_base_release$default(this, t1.b, false, new u1(this), 2, (Object) null);
    }

    public final /* synthetic */ void publishBrazePushAction$android_sdk_base_release(BrazePushEventType brazePushEventType, BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(brazePushEventType, "pushActionType");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        this.externalIEventMessenger.a((Object) new BrazePushEvent(brazePushEventType, brazeNotificationPayload), BrazePushEvent.class);
    }

    public final /* synthetic */ void recordGeofenceTransition$android_sdk_base_release(String str, GeofenceTransitionType geofenceTransitionType) {
        run$android_sdk_base_release$default(this, x1.b, false, new y1(str, geofenceTransitionType, this), 2, (Object) null);
    }

    public final void reenqueueInAppMessage$android_sdk_base_release(InAppMessageEvent inAppMessageEvent) {
        Intrinsics.checkNotNullParameter(inAppMessageEvent, "event");
        run$android_sdk_base_release$default(this, new z1(inAppMessageEvent), false, new a2(this, inAppMessageEvent), 2, (Object) null);
    }

    public void refreshFeatureFlags() {
        run$android_sdk_base_release$default(this, b2.b, false, new c2(this), 2, (Object) null);
    }

    public <T> void removeSingleSubscription(IEventSubscriber<T> iEventSubscriber, Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "eventClass");
        if (iEventSubscriber != null) {
            try {
                boolean d5 = this.externalIEventMessenger.d(cls, iEventSubscriber);
                BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                BrazeLogger.Priority priority = BrazeLogger.Priority.V;
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, (Function0) new h2(cls, iEventSubscriber, d5), 2, (Object) null);
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, (Function0) new i2(cls, iEventSubscriber, this.externalIEventMessenger.b(cls, iEventSubscriber)), 2, (Object) null);
            } catch (Exception e5) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e5, (Function0<String>) new j2(cls));
                publishError(e5);
            }
        }
    }

    @Deprecated(message = "Please call {@link IBraze#requestContentCardsRefresh()} or {@link IBraze#requestContentCardsRefreshFromCache()} instead to refresh Content Cards", replaceWith = @ReplaceWith(expression = "IBraze.requestContentCardsRefresh", imports = {}))
    public void requestContentCardsRefresh(boolean z4) {
        if (z4) {
            requestContentCardsRefreshFromCache();
        } else {
            requestContentCardsRefresh();
        }
    }

    public void requestContentCardsRefreshFromCache() {
        run$android_sdk_base_release$default(this, m2.b, false, new n2(this), 2, (Object) null);
    }

    public void requestFeedRefresh() {
        run$android_sdk_base_release$default(this, o2.b, false, new p2(this), 2, (Object) null);
    }

    public void requestFeedRefreshFromCache() {
        run$android_sdk_base_release$default(this, q2.b, false, new r2(this), 2, (Object) null);
    }

    public final /* synthetic */ void requestGeofenceRefresh$android_sdk_base_release(IBrazeLocation iBrazeLocation) {
        run$android_sdk_base_release$default(this, s2.b, false, new t2(iBrazeLocation, this), 2, (Object) null);
    }

    public void requestGeofences(double d5, double d6) {
        run$android_sdk_base_release$default(this, w2.b, false, new x2(d5, d6, this), 2, (Object) null);
    }

    public final /* synthetic */ void requestGeofencesInitialization$android_sdk_base_release() {
        run$android_sdk_base_release$default(this, y2.b, false, new z2(this), 2, (Object) null);
    }

    public void requestImmediateDataFlush() {
        run$android_sdk_base_release$default(this, a3.b, false, new b3(this), 2, (Object) null);
    }

    public void requestLocationInitialization() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) c3.b, 3, (Object) null);
        requestGeofencesInitialization$android_sdk_base_release();
        requestSingleLocationUpdate$android_sdk_base_release();
    }

    public final /* synthetic */ void requestSingleLocationUpdate$android_sdk_base_release() {
        run$android_sdk_base_release$default(this, d3.b, false, new e3(this), 2, (Object) null);
    }

    public final /* synthetic */ void retryInAppMessage$android_sdk_base_release(InAppMessageEvent inAppMessageEvent) {
        Intrinsics.checkNotNullParameter(inAppMessageEvent, "event");
        run$android_sdk_base_release$default(this, new f3(inAppMessageEvent), false, new g3(this, inAppMessageEvent), 2, (Object) null);
    }

    public final /* synthetic */ void run$android_sdk_base_release(Function0 function0, boolean z4, Function0 function02) {
        Intrinsics.checkNotNullParameter(function02, "block");
        if (!z4 || !Companion.isDisabled()) {
            try {
                Job unused = BuildersKt__Builders_commonKt.launch$default(i5.a, (CoroutineContext) null, (CoroutineStart) null, new h3(function02, (Continuation) null), 3, (Object) null);
            } catch (Exception e5) {
                if (function0 == null) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) e5, (Function0) i3.b, 1, (Object) null);
                } else {
                    BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e5, (Function0<String>) function0);
                }
                publishError(e5);
            }
        }
    }

    public final /* synthetic */ void schedulePushDelivery$android_sdk_base_release(long j5) {
        run$android_sdk_base_release$default(this, k3.b, false, new l3(this, j5), 2, (Object) null);
    }

    public final void setApiKeyPresent$android_sdk_base_release(Boolean bool) {
        this.isApiKeyPresent = bool;
    }

    public final void setConfigurationProvider$android_sdk_base_release(BrazeConfigurationProvider brazeConfigurationProvider) {
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "<set-?>");
        this.configurationProvider = brazeConfigurationProvider;
    }

    public final void setDeviceIdProvider$android_sdk_base_release(bo.app.e2 e2Var) {
        Intrinsics.checkNotNullParameter(e2Var, "<set-?>");
        this.deviceIdProvider = e2Var;
    }

    public final void setExternalIEventMessenger$android_sdk_base_release(bo.app.i2 i2Var) {
        Intrinsics.checkNotNullParameter(i2Var, "<set-?>");
        this.externalIEventMessenger = i2Var;
    }

    public void setGoogleAdvertisingId(String str, boolean z4) {
        Intrinsics.checkNotNullParameter(str, "googleAdvertisingId");
        run$android_sdk_base_release$default(this, new m3(str, z4), false, new n3(str, this, z4), 2, (Object) null);
    }

    public void setImageLoader(IBrazeImageLoader iBrazeImageLoader) {
        Intrinsics.checkNotNullParameter(iBrazeImageLoader, "<set-?>");
        this.imageLoader = iBrazeImageLoader;
    }

    public final void setPushDeliveryManager$android_sdk_base_release(bo.app.k4 k4Var) {
        Intrinsics.checkNotNullParameter(k4Var, "<set-?>");
        this.pushDeliveryManager = k4Var;
    }

    public void setRegisteredPushToken(String str) {
        run$android_sdk_base_release$default(this, new f2(str), false, new g2(this, str), 2, (Object) null);
    }

    public void setSdkAuthenticationSignature(String str) {
        Intrinsics.checkNotNullParameter(str, "signature");
        run$android_sdk_base_release$default(this, new o3(str), false, new p3(this, str), 2, (Object) null);
    }

    public final void setUdm$android_sdk_base_release(bo.app.a3 a3Var) {
        Intrinsics.checkNotNullParameter(a3Var, "<set-?>");
        this.udm = a3Var;
    }

    public void subscribeToContentCardsUpdates(IEventSubscriber<ContentCardsUpdatedEvent> iEventSubscriber) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        try {
            this.externalIEventMessenger.a(ContentCardsUpdatedEvent.class, (IEventSubscriber) iEventSubscriber);
        } catch (Exception e5) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e5, (Function0<String>) s3.b);
            publishError(e5);
        }
    }

    public void subscribeToFeatureFlagsUpdates(IEventSubscriber<FeatureFlagsUpdatedEvent> iEventSubscriber) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        try {
            this.externalIEventMessenger.a(FeatureFlagsUpdatedEvent.class, (IEventSubscriber) iEventSubscriber);
            run$android_sdk_base_release$default(this, t3.b, false, new u3(this), 2, (Object) null);
        } catch (Exception e5) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e5, (Function0<String>) v3.b);
            publishError(e5);
        }
    }

    public void subscribeToFeedUpdates(IEventSubscriber<FeedUpdatedEvent> iEventSubscriber) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        try {
            this.externalIEventMessenger.a(FeedUpdatedEvent.class, (IEventSubscriber) iEventSubscriber);
        } catch (Exception e5) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e5, (Function0<String>) w3.b);
            publishError(e5);
        }
    }

    public void subscribeToNetworkFailures(IEventSubscriber<BrazeNetworkFailureEvent> iEventSubscriber) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        try {
            this.externalIEventMessenger.a(BrazeNetworkFailureEvent.class, (IEventSubscriber) iEventSubscriber);
        } catch (Exception e5) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e5, (Function0<String>) x3.b);
            publishError(e5);
        }
    }

    public void subscribeToNewInAppMessages(IEventSubscriber<InAppMessageEvent> iEventSubscriber) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        try {
            this.externalIEventMessenger.a(InAppMessageEvent.class, (IEventSubscriber) iEventSubscriber);
        } catch (Exception e5) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e5, (Function0<String>) y3.b);
            publishError(e5);
        }
    }

    public void subscribeToNoMatchingTriggerForEvent(IEventSubscriber<NoMatchingTriggerEvent> iEventSubscriber) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        try {
            this.externalIEventMessenger.a(NoMatchingTriggerEvent.class, (IEventSubscriber) iEventSubscriber);
        } catch (Exception e5) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e5, (Function0<String>) z3.b);
            publishError(e5);
        }
    }

    public void subscribeToPushNotificationEvents(IEventSubscriber<BrazePushEvent> iEventSubscriber) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        try {
            this.externalIEventMessenger.a(BrazePushEvent.class, (IEventSubscriber) iEventSubscriber);
        } catch (Exception e5) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e5, (Function0<String>) a4.b);
            publishError(e5);
        }
    }

    public void subscribeToSdkAuthenticationFailures(IEventSubscriber<BrazeSdkAuthenticationErrorEvent> iEventSubscriber) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        try {
            this.externalIEventMessenger.a(BrazeSdkAuthenticationErrorEvent.class, (IEventSubscriber) iEventSubscriber);
        } catch (Exception e5) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e5, (Function0<String>) b4.b);
            publishError(e5);
        }
    }

    public void subscribeToSessionUpdates(IEventSubscriber<SessionStateChangedEvent> iEventSubscriber) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        try {
            this.externalIEventMessenger.a(SessionStateChangedEvent.class, (IEventSubscriber) iEventSubscriber);
        } catch (Exception e5) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e5, (Function0<String>) c4.b);
            publishError(e5);
        }
    }

    public final /* synthetic */ boolean validateAndStorePushId$android_sdk_base_release(String str) {
        Intrinsics.checkNotNullParameter(str, "pushId");
        return ((Boolean) runForResult$default(this, Boolean.TRUE, d4.b, false, new e4(this, str, (Continuation) null), 4, (Object) null)).booleanValue();
    }

    public final /* synthetic */ void waitForUserDependencyThread$android_sdk_base_release() {
        try {
            runForResult((Object) null, i4.b, false, new j4((Continuation) null));
        } catch (Exception e5) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e5, (Function0<String>) k4.b);
        }
    }

    public void changeUser(String str, String str2) {
        run$android_sdk_base_release$default(this, new n(str), false, new o(str, this, str2), 2, (Object) null);
    }

    public void getCurrentUser(IValueCallback<BrazeUser> iValueCallback) {
        Intrinsics.checkNotNullParameter(iValueCallback, "completionCallback");
        if (Companion.isDisabled()) {
            iValueCallback.onError();
            return;
        }
        try {
            Job unused = BuildersKt__Builders_commonKt.launch$default(i5.a, (CoroutineContext) null, (CoroutineStart) null, new h0(iValueCallback, this, (Continuation) null), 3, (Object) null);
        } catch (Exception e5) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e5, (Function0<String>) i0.b);
            iValueCallback.onError();
            publishError(e5);
        }
    }

    public void logCustomEvent(String str, BrazeProperties brazeProperties) {
        run$android_sdk_base_release$default(this, new r0(str), false, new s0(str, this, brazeProperties != null ? brazeProperties.clone() : null), 2, (Object) null);
    }

    public void logPurchase(String str, String str2, BigDecimal bigDecimal, BrazeProperties brazeProperties) {
        logPurchase(str, str2, bigDecimal, 1, brazeProperties);
    }

    public void logPushNotificationOpened(Intent intent) {
        run$android_sdk_base_release$default(this, new n1(intent), false, new o1(intent, this), 2, (Object) null);
    }

    public final /* synthetic */ void requestGeofenceRefresh$android_sdk_base_release(boolean z4) {
        run$android_sdk_base_release$default(this, new u2(z4), false, new v2(this, z4), 2, (Object) null);
    }

    public void logPurchase(String str, String str2, BigDecimal bigDecimal, int i5) {
        logPurchase(str, str2, bigDecimal, i5, (BrazeProperties) null);
    }

    public void logPurchase(String str, String str2, BigDecimal bigDecimal, int i5, BrazeProperties brazeProperties) {
        run$android_sdk_base_release$default(this, new d1(str), false, new e1(str, str2, bigDecimal, i5, this, brazeProperties != null ? brazeProperties.clone() : null), 2, (Object) null);
    }

    public void requestContentCardsRefresh() {
        run$android_sdk_base_release$default(this, k2.b, false, new l2(this), 2, (Object) null);
    }

    public Card deserializeContentCard(JSONObject jSONObject) {
        return (Card) runForResult$default(this, (Object) null, new v(jSONObject), false, new w(this, jSONObject, (Continuation) null), 4, (Object) null);
    }
}
