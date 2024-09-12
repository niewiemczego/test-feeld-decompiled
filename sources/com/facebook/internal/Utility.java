package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.adapty.internal.crossplatform.AdaptyImmutableMapTypeAdapterFactory;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.react.util.JSStackTrace;
import io.sentry.protocol.Response;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002Î\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u00042\u0006\u0010/\u001a\u000200H\u0002J \u00101\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0002J'\u00102\u001a\u00020 \"\u0004\b\u0000\u001032\b\u00104\u001a\u0004\u0018\u0001H32\b\u00105\u001a\u0004\u0018\u0001H3H\u0007¢\u0006\u0002\u00106J\u0012\u00107\u001a\u0004\u0018\u00010\u001a2\u0006\u00108\u001a\u00020\u0004H\u0007J&\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u00042\b\u0010<\u001a\u0004\u0018\u00010\u00042\b\u0010=\u001a\u0004\u0018\u00010>H\u0007J\u0018\u0010?\u001a\u00020*2\u0006\u0010/\u001a\u0002002\u0006\u0010@\u001a\u00020\u0004H\u0002J\u0010\u0010A\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0007J\u0012\u0010B\u001a\u00020*2\b\u0010C\u001a\u0004\u0018\u00010DH\u0007J\u001e\u0010E\u001a\u0004\u0018\u00010\u00042\b\u0010F\u001a\u0004\u0018\u00010\u00042\b\u0010G\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010H\u001a\u00020\u00132\u0006\u0010I\u001a\u00020JH\u0002J\u0016\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040L2\u0006\u0010M\u001a\u00020NH\u0007J\u001c\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010P2\u0006\u0010Q\u001a\u00020\u001aH\u0007J\u001c\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040P2\u0006\u0010Q\u001a\u00020\u001aH\u0007J\u001a\u0010S\u001a\u00020\u00062\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010V\u001a\u00020WH\u0007J\u0012\u0010X\u001a\u00020*2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0007J\b\u0010[\u001a\u00020 H\u0002J\u0010\u0010\\\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u0006H\u0007J\u0012\u0010^\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u000100H\u0007J\u0010\u0010_\u001a\u00020\u00042\u0006\u0010/\u001a\u000200H\u0007J\n\u0010`\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010a\u001a\u0004\u0018\u00010b2\b\u0010c\u001a\u0004\u0018\u00010>2\b\u0010d\u001a\u0004\u0018\u00010\u00042\u0006\u0010e\u001a\u00020bH\u0007J\u0010\u0010f\u001a\u00020\u00132\u0006\u0010g\u001a\u00020:H\u0007J\n\u0010h\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010i\u001a\u00020\u00042\b\u0010j\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010k\u001a\u00020l2\u0006\u00108\u001a\u00020\u0004H\u0002J\u0018\u0010m\u001a\u00020*2\u0006\u00108\u001a\u00020\u00042\u0006\u0010n\u001a\u00020oH\u0007J\u0012\u0010p\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u000100H\u0007JC\u0010q\u001a\u0004\u0018\u00010r2\n\u0010s\u001a\u0006\u0012\u0002\b\u00030t2\u0006\u0010u\u001a\u00020\u00042\u001e\u0010v\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010t0w\"\b\u0012\u0002\b\u0003\u0018\u00010tH\u0007¢\u0006\u0002\u0010xJ?\u0010q\u001a\u0004\u0018\u00010r2\u0006\u0010y\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u00042\u001e\u0010v\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010t0w\"\b\u0012\u0002\b\u0003\u0018\u00010tH\u0007¢\u0006\u0002\u0010zJ\u0012\u0010{\u001a\u00020\u00042\b\u0010|\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010}\u001a\u0004\u0018\u00010\u00012\u0006\u0010Q\u001a\u00020\u001a2\b\u0010d\u001a\u0004\u0018\u00010\u00042\b\u0010~\u001a\u0004\u0018\u00010\u0004H\u0007J\u0015\u0010\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010:H\u0007J\u001c\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010I\u001a\u00030\u0001H\u0002J\u001d\u0010\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0001\u001a\u00020\u00042\u0007\u0010I\u001a\u00030\u0001H\u0002J\u001c\u0010\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0001\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u0004H\u0002J>\u0010\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020r2\u0017\u0010\u0001\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010w\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0001\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0007J\u0011\u0010\u0001\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0007J\u0014\u0010\u0001\u001a\u00020 2\t\u0010\u0001\u001a\u0004\u0018\u00010:H\u0007J\u0015\u0010\u0001\u001a\u00020 2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\u0014\u0010\u0001\u001a\u00020 2\t\u0010\u0001\u001a\u0004\u0018\u00010:H\u0007J\u0011\u0010\u0001\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0002J\u0013\u0010\u0001\u001a\u00020 2\b\u0010F\u001a\u0004\u0018\u00010\u0004H\u0007J\u0019\u0010\u0001\u001a\u00020 2\u000e\u0010\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u0001H\u0007J\u0014\u0010\u0001\u001a\u00020 2\t\u0010\u0001\u001a\u0004\u0018\u00010:H\u0007J\u0018\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010M\u001a\u00020NH\u0007J\u0017\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040L2\u0006\u0010M\u001a\u00020NH\u0007J\u001e\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040P2\u0007\u0010\u0001\u001a\u00020\u0004H\u0007J'\u0010\u0001\u001a\u00020*2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\u0011\u0010\u0001\u001a\f\u0018\u00010 \u0001j\u0005\u0018\u0001`¡\u0001H\u0007J\u001f\u0010\u0001\u001a\u00020*2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J+\u0010\u0001\u001a\u00020*2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u00042\n\u0010£\u0001\u001a\u0005\u0018\u00010¤\u0001H\u0007J\"\u0010¥\u0001\u001a\u00020\u00042\u0017\u0010¦\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040PH\u0007J\u0013\u0010§\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010d\u001a\u00020\u0004H\u0007J\u0011\u0010¨\u0001\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0007J\u0014\u0010©\u0001\u001a\u00020>2\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J.\u0010«\u0001\u001a\u00020*2\u0006\u00105\u001a\u00020>2\b\u0010d\u001a\u0004\u0018\u00010\u00042\u0011\u0010¬\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010LH\u0007J&\u0010­\u0001\u001a\u00020 2\u0006\u0010c\u001a\u00020>2\b\u0010d\u001a\u0004\u0018\u00010\u00042\t\u0010®\u0001\u001a\u0004\u0018\u00010\u0001H\u0007J&\u0010¯\u0001\u001a\u00020*2\u0006\u00105\u001a\u00020>2\b\u0010d\u001a\u0004\u0018\u00010\u00042\t\u0010®\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010°\u0001\u001a\u00020*2\u0006\u00105\u001a\u00020>2\b\u0010d\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010:H\u0007J!\u0010±\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010P2\b\u0010²\u0001\u001a\u00030³\u0001H\u0007J\u0013\u0010´\u0001\u001a\u00020\u00042\b\u0010T\u001a\u0004\u0018\u00010UH\u0007J%\u0010µ\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010P2\b\u0010²\u0001\u001a\u00030³\u0001H\u0007J\t\u0010¶\u0001\u001a\u00020*H\u0002J\t\u0010·\u0001\u001a\u00020\u0006H\u0002J\u0012\u0010¸\u0001\u001a\u00020*2\u0007\u0010¹\u0001\u001a\u000200H\u0002J\u0012\u0010º\u0001\u001a\u00020*2\u0007\u0010¹\u0001\u001a\u000200H\u0002J\t\u0010»\u0001\u001a\u00020*H\u0002J\t\u0010¼\u0001\u001a\u00020*H\u0002J\u0015\u0010½\u0001\u001a\u00020*2\n\u0010¾\u0001\u001a\u0005\u0018\u00010¿\u0001H\u0007J\u001f\u0010À\u0001\u001a\u00020\u00042\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010Â\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J6\u0010Ã\u0001\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001a2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010\u00042\u0007\u0010Ä\u0001\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0007J\u001a\u0010Å\u0001\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001a2\u0007\u0010¹\u0001\u001a\u000200H\u0007J\u0014\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010I\u001a\u00030\u0001H\u0007J\u0013\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010d\u001a\u00020\u0004H\u0007J\u0016\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010I\u001a\u0005\u0018\u00010\u0001H\u0007J\u0015\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010d\u001a\u0004\u0018\u00010\u0004H\u0007J\u001d\u0010È\u0001\u001a\u00020 2\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010É\u0001\u001a\u0004\u0018\u00010N2\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010Ë\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J*\u0010Ì\u0001\u001a\u00020*2\b\u0010²\u0001\u001a\u00030³\u00012\u0015\u0010¦\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010PH\u0007J.\u0010Í\u0001\u001a\u00020*2\b\u0010²\u0001\u001a\u00030³\u00012\u0019\u0010¦\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010PH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a8G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 8FX\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\u001f\u0010\"R\u0011\u0010#\u001a\u00020 8G¢\u0006\u0006\u001a\u0004\b#\u0010\"R\u000e\u0010$\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010%\u001a\u0004\u0018\u00010\u00168G¢\u0006\u0006\u001a\u0004\b&\u0010\u0018R\u000e\u0010'\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006Ï\u0001"}, d2 = {"Lcom/facebook/internal/Utility;", "", "()V", "ARC_DEVICE_PATTERN", "", "DEFAULT_STREAM_BUFFER_SIZE", "", "EXTRA_APP_EVENTS_INFO_FORMAT_VERSION", "FACEBOOK_PROFILE_FIELDS", "HASH_ALGORITHM_MD5", "HASH_ALGORITHM_SHA1", "HASH_ALGORITHM_SHA256", "INSTAGRAM_PROFILE_FIELDS", "LOG_TAG", "NO_CARRIER", "REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS", "URL_SCHEME", "UTF8", "availableExternalStorageGB", "", "carrierName", "currentLocale", "Ljava/util/Locale;", "getCurrentLocale", "()Ljava/util/Locale;", "dataProcessingOptions", "Lorg/json/JSONObject;", "getDataProcessingOptions", "()Lorg/json/JSONObject;", "deviceTimeZoneName", "deviceTimezoneAbbreviation", "isAutoAppLinkSetup", "", "isAutoAppLinkSetup$annotations", "()Z", "isDataProcessingRestricted", "numCPUCores", "resourceLocale", "getResourceLocale", "timestampOfLastCheck", "totalExternalStorageGB", "appendAnonIdUnderCompliance", "", "params", "attributionIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "anonymousAppDeviceGUID", "context", "Landroid/content/Context;", "appendAttributionIdUnderCompliance", "areObjectsEqual", "T", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "awaitGetGraphMeRequestWithCache", "accessToken", "buildUri", "Landroid/net/Uri;", "authority", "path", "parameters", "Landroid/os/Bundle;", "clearCookiesForDomain", "domain", "clearFacebookCookies", "closeQuietly", "closeable", "Ljava/io/Closeable;", "coerceValueIfNullOrEmpty", "s", "valueIfNullOrEmpty", "convertBytesToGB", "bytes", "", "convertJSONArrayToList", "", "jsonArray", "Lorg/json/JSONArray;", "convertJSONObjectToHashMap", "", "jsonObject", "convertJSONObjectToStringMap", "copyAndCloseInputStream", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "disconnectQuietly", "connection", "Ljava/net/URLConnection;", "externalStorageExists", "generateRandomString", "length", "getActivityName", "getAppName", "getAppVersion", "getBundleLongAsDate", "Ljava/util/Date;", "bundle", "key", "dateBase", "getContentSize", "contentUri", "getCurrentTokenDomainWithDefault", "getGraphDomainFromTokenDomain", "tokenGraphDomain", "getGraphMeRequestWithCache", "Lcom/facebook/GraphRequest;", "getGraphMeRequestWithCacheAsync", "callback", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "getMetadataApplicationId", "getMethodQuietly", "Ljava/lang/reflect/Method;", "clazz", "Ljava/lang/Class;", "methodName", "parameterTypes", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "className", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getProfileFieldsForGraphDomain", "graphDomain", "getStringPropertyAsJSON", "nonJSONPropertyKey", "getUriString", "uri", "hashBytes", "hash", "Ljava/security/MessageDigest;", "", "hashWithAlgorithm", "algorithm", "invokeMethodQuietly", "receiver", "method", "args", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "isAutofillAvailable", "isChromeOS", "isContentUri", "isCurrentAccessToken", "token", "Lcom/facebook/AccessToken;", "isFileUri", "isGooglePlayServicesAvailable", "isNullOrEmpty", "c", "", "isWebUri", "jsonArrayToSet", "", "jsonArrayToStringList", "jsonStrToMap", "str", "logd", "tag", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "t", "", "mapToJsonStr", "map", "md5hash", "mustFixWindowParamsForAutofill", "parseUrlQueryString", "queryString", "putCommaSeparatedStringList", "list", "putJSONValueInBundle", "value", "putNonEmptyString", "putUri", "readNonnullStringMapFromParcel", "parcel", "Landroid/os/Parcel;", "readStreamToString", "readStringMapFromParcel", "refreshAvailableExternalStorage", "refreshBestGuessNumberOfCPUCores", "refreshCarrierName", "appContext", "refreshPeriodicExtendedDeviceInfo", "refreshTimezone", "refreshTotalExternalStorage", "runOnNonUiThread", "runnable", "Ljava/lang/Runnable;", "safeGetStringFromResponse", "response", "propertyName", "setAppEventAttributionParameters", "limitEventUsage", "setAppEventExtendedDeviceInfoParameters", "sha1hash", "sha256hash", "stringsEqualOrEmpty", "tryGetJSONArrayFromResponse", "propertyKey", "tryGetJSONObjectFromResponse", "writeNonnullStringMapToParcel", "writeStringMapToParcel", "GraphMeRequestWithCacheCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Utility.kt */
public final class Utility {
    private static final String ARC_DEVICE_PATTERN = ".+_cheets|cheets_.+";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";
    private static final String FACEBOOK_PROFILE_FIELDS = "id,name,first_name,middle_name,last_name";
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
    private static final String HASH_ALGORITHM_SHA256 = "SHA-256";
    private static final String INSTAGRAM_PROFILE_FIELDS = "id,name,profile_picture";
    public static final Utility INSTANCE = new Utility();
    public static final String LOG_TAG = "FacebookSDK";
    private static final String NO_CARRIER = "NoCarrier";
    private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;
    private static final String URL_SCHEME = "https";
    private static final String UTF8 = "UTF-8";
    private static long availableExternalStorageGB = -1;
    private static String carrierName = NO_CARRIER;
    private static String deviceTimeZoneName = "";
    private static String deviceTimezoneAbbreviation = "";
    private static int numCPUCores;
    private static long timestampOfLastCheck = -1;
    private static long totalExternalStorageGB = -1;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "", "onFailure", "", "error", "Lcom/facebook/FacebookException;", "onSuccess", "userInfo", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Utility.kt */
    public interface GraphMeRequestWithCacheCallback {
        void onFailure(FacebookException facebookException);

        void onSuccess(JSONObject jSONObject);
    }

    @JvmStatic
    public static /* synthetic */ void isAutoAppLinkSetup$annotations() {
    }

    private Utility() {
    }

    @JvmStatic
    public static final boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    @JvmStatic
    public static final boolean isNullOrEmpty(String str) {
        if (str != null) {
            if (!(str.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final String coerceValueIfNullOrEmpty(String str, String str2) {
        return isNullOrEmpty(str) ? str2 : str;
    }

    @JvmStatic
    public static final String md5hash(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return INSTANCE.hashWithAlgorithm("MD5", str);
    }

    @JvmStatic
    public static final String sha1hash(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return INSTANCE.hashWithAlgorithm("SHA-1", str);
    }

    @JvmStatic
    public static final String sha1hash(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        return INSTANCE.hashWithAlgorithm("SHA-1", bArr);
    }

    @JvmStatic
    public static final String sha256hash(String str) {
        if (str != null) {
            return INSTANCE.hashWithAlgorithm("SHA-256", str);
        }
        String str2 = null;
        return null;
    }

    @JvmStatic
    public static final String sha256hash(byte[] bArr) {
        if (bArr != null) {
            return INSTANCE.hashWithAlgorithm("SHA-256", bArr);
        }
        String str = null;
        return null;
    }

    private final String hashWithAlgorithm(String str, String str2) {
        Charset charset = Charsets.UTF_8;
        if (str2 != null) {
            byte[] bytes = str2.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return hashWithAlgorithm(str, bytes);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private final String hashWithAlgorithm(String str, byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            Intrinsics.checkNotNullExpressionValue(instance, "hash");
            return hashBytes(instance, bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private final String hashBytes(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNullExpressionValue(digest, "digest");
        int length = digest.length;
        int i = 0;
        while (i < length) {
            byte b = digest[i];
            i++;
            sb.append(Integer.toHexString((b >> 4) & 15));
            sb.append(Integer.toHexString((b >> 0) & 15));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }

    @JvmStatic
    public static final Uri buildUri(String str, String str2, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        Uri build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    @JvmStatic
    public static final Bundle parseUrlQueryString(String str) {
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(str)) {
            if (str != null) {
                Object[] array = StringsKt.split$default((CharSequence) str, new String[]{"&"}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    int length = strArr.length;
                    int i = 0;
                    while (i < length) {
                        String str2 = strArr[i];
                        i++;
                        Object[] array2 = StringsKt.split$default((CharSequence) str2, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                        if (array2 != null) {
                            String[] strArr2 = (String[]) array2;
                            try {
                                if (strArr2.length == 2) {
                                    bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), URLDecoder.decode(strArr2[1], "UTF-8"));
                                } else if (strArr2.length == 1) {
                                    bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), "");
                                }
                            } catch (UnsupportedEncodingException e) {
                                logd(LOG_TAG, (Exception) e);
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        return bundle;
    }

    @JvmStatic
    public static final void putNonEmptyString(Bundle bundle, String str, String str2) {
        Intrinsics.checkNotNullParameter(bundle, "b");
        if (!isNullOrEmpty(str2)) {
            bundle.putString(str, str2);
        }
    }

    @JvmStatic
    public static final void putCommaSeparatedStringList(Bundle bundle, String str, List<String> list) {
        Intrinsics.checkNotNullParameter(bundle, "b");
        if (list != null) {
            bundle.putString(str, TextUtils.join(",", list));
        }
    }

    @JvmStatic
    public static final void putUri(Bundle bundle, String str, Uri uri) {
        Intrinsics.checkNotNullParameter(bundle, "b");
        if (uri != null) {
            putNonEmptyString(bundle, str, uri.toString());
        }
    }

    @JvmStatic
    public static final boolean putJSONValueInBundle(Bundle bundle, String str, Object obj) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (obj == null) {
            bundle.remove(str);
            return true;
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        } else if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
            return true;
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Number) obj).doubleValue());
            return true;
        } else if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
            return true;
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Number) obj).intValue());
            return true;
        } else if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
            return true;
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Number) obj).longValue());
            return true;
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
            return true;
        } else if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return true;
        } else if (obj instanceof JSONArray) {
            bundle.putString(str, ((JSONArray) obj).toString());
            return true;
        } else if (!(obj instanceof JSONObject)) {
            return false;
        } else {
            bundle.putString(str, ((JSONObject) obj).toString());
            return true;
        }
    }

    @JvmStatic
    public static final void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @JvmStatic
    public static final void disconnectQuietly(URLConnection uRLConnection) {
        if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    @JvmStatic
    public static final String getMetadataApplicationId(Context context) {
        Validate validate = Validate.INSTANCE;
        Validate.notNull(context, "context");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FacebookSdk.getApplicationId();
    }

    @JvmStatic
    public static final Map<String, Object> convertJSONObjectToHashMap(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        HashMap hashMap = new HashMap();
        JSONArray names = jSONObject.names();
        if (names == null) {
            return hashMap;
        }
        int i = 0;
        int length = names.length();
        if (length > 0) {
            while (true) {
                int i2 = i + 1;
                try {
                    String string = names.getString(i);
                    Intrinsics.checkNotNullExpressionValue(string, "keys.getString(i)");
                    Object obj = jSONObject.get(string);
                    if (obj instanceof JSONObject) {
                        obj = convertJSONObjectToHashMap((JSONObject) obj);
                    }
                    Intrinsics.checkNotNullExpressionValue(obj, "value");
                    hashMap.put(string, obj);
                } catch (JSONException unused) {
                }
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return hashMap;
    }

    @JvmStatic
    public static final Map<String, String> convertJSONObjectToStringMap(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (optString != null) {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                hashMap.put(next, optString);
            }
        }
        return hashMap;
    }

    @JvmStatic
    public static final List<String> convertJSONArrayToList(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
        try {
            List<String> arrayList = new ArrayList<>();
            int i = 0;
            int length = jSONArray.length();
            if (length <= 0) {
                return arrayList;
            }
            while (true) {
                int i2 = i + 1;
                String string = jSONArray.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                arrayList.add(string);
                if (i2 >= length) {
                    return arrayList;
                }
                i = i2;
            }
        } catch (JSONException unused) {
            return new ArrayList<>();
        }
    }

    @JvmStatic
    public static final Object getStringPropertyAsJSON(JSONObject jSONObject, String str, String str2) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Object opt = jSONObject.opt(str);
        if (opt != null && (opt instanceof String)) {
            opt = new JSONTokener((String) opt).nextValue();
        }
        if (opt == null || (opt instanceof JSONObject) || (opt instanceof JSONArray)) {
            return opt;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, opt);
            return jSONObject2;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    @JvmStatic
    public static final String readStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
                closeQuietly(bufferedInputStream);
                closeQuietly(inputStreamReader);
                throw th;
            }
            try {
                StringBuilder sb = new StringBuilder();
                char[] cArr = new char[2048];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        sb.append(cArr, 0, read);
                    } else {
                        String sb2 = sb.toString();
                        Intrinsics.checkNotNullExpressionValue(sb2, "{\n      bufferedInputStream = BufferedInputStream(inputStream)\n      reader = InputStreamReader(bufferedInputStream)\n      val stringBuilder = StringBuilder()\n      val bufferSize = 1024 * 2\n      val buffer = CharArray(bufferSize)\n      var n = 0\n      while (reader.read(buffer).also { n = it } != -1) {\n        stringBuilder.append(buffer, 0, n)\n      }\n      stringBuilder.toString()\n    }");
                        closeQuietly(bufferedInputStream);
                        closeQuietly(inputStreamReader);
                        return sb2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                closeQuietly(bufferedInputStream);
                closeQuietly(inputStreamReader);
                throw th;
            }
        } catch (Throwable th4) {
            bufferedInputStream = null;
            th = th4;
            inputStreamReader = null;
            closeQuietly(bufferedInputStream);
            closeQuietly(inputStreamReader);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0034  */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int copyAndCloseInputStream(java.io.InputStream r6, java.io.OutputStream r7) throws java.io.IOException {
        /*
            java.lang.String r0 = "outputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ all -> 0x002a }
            r1.<init>(r6)     // Catch:{ all -> 0x002a }
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0027 }
            r2 = 0
            r3 = r2
        L_0x0011:
            int r4 = r1.read(r0)     // Catch:{ all -> 0x0027 }
            r5 = -1
            if (r4 == r5) goto L_0x001d
            r7.write(r0, r2, r4)     // Catch:{ all -> 0x0027 }
            int r3 = r3 + r4
            goto L_0x0011
        L_0x001d:
            r1.close()
            if (r6 != 0) goto L_0x0023
            goto L_0x0026
        L_0x0023:
            r6.close()
        L_0x0026:
            return r3
        L_0x0027:
            r7 = move-exception
            r0 = r1
            goto L_0x002b
        L_0x002a:
            r7 = move-exception
        L_0x002b:
            if (r0 != 0) goto L_0x002e
            goto L_0x0031
        L_0x002e:
            r0.close()
        L_0x0031:
            if (r6 != 0) goto L_0x0034
            goto L_0x0037
        L_0x0034:
            r6.close()
        L_0x0037:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Utility.copyAndCloseInputStream(java.io.InputStream, java.io.OutputStream):int");
    }

    @JvmStatic
    public static final boolean stringsEqualOrEmpty(String str, String str2) {
        CharSequence charSequence = str;
        boolean z = charSequence == null || charSequence.length() == 0;
        CharSequence charSequence2 = str2;
        boolean z2 = charSequence2 == null || charSequence2.length() == 0;
        if (z && z2) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return Intrinsics.areEqual((Object) str, (Object) str2);
    }

    private final void clearCookiesForDomain(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager instance = CookieManager.getInstance();
        String cookie = instance.getCookie(str);
        if (cookie != null) {
            Object[] array = StringsKt.split$default((CharSequence) cookie, new String[]{";"}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    String str2 = strArr[i];
                    i++;
                    Object[] array2 = StringsKt.split$default((CharSequence) str2, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                    if (array2 != null) {
                        String[] strArr2 = (String[]) array2;
                        if (strArr2.length > 0) {
                            CharSequence charSequence = strArr2[0];
                            int length2 = charSequence.length() - 1;
                            int i2 = 0;
                            boolean z = false;
                            while (i2 <= length2) {
                                boolean z2 = Intrinsics.compare((int) charSequence.charAt(!z ? i2 : length2), 32) <= 0;
                                if (!z) {
                                    if (!z2) {
                                        z = true;
                                    } else {
                                        i2++;
                                    }
                                } else if (!z2) {
                                    break;
                                } else {
                                    length2--;
                                }
                            }
                            instance.setCookie(str, Intrinsics.stringPlus(charSequence.subSequence(i2, length2 + 1).toString(), "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;"));
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                instance.removeExpiredCookie();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    @JvmStatic
    public static final void clearFacebookCookies(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Utility utility = INSTANCE;
            utility.clearCookiesForDomain(context, "facebook.com");
            utility.clearCookiesForDomain(context, ".facebook.com");
            utility.clearCookiesForDomain(context, "https://facebook.com");
            utility.clearCookiesForDomain(context, "https://.facebook.com");
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void logd(String str, Exception exc) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.isDebugEnabled() && str != null && exc != null) {
            Log.d(str, exc.getClass().getSimpleName() + ": " + exc.getMessage());
        }
    }

    @JvmStatic
    public static final void logd(String str, String str2) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.isDebugEnabled() && str != null && str2 != null) {
            Log.d(str, str2);
        }
    }

    @JvmStatic
    public static final void logd(String str, String str2, Throwable th) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.isDebugEnabled() && !isNullOrEmpty(str)) {
            Log.d(str, str2, th);
        }
    }

    @JvmStatic
    public static final <T> boolean areObjectsEqual(T t, T t2) {
        if (t == null) {
            return t2 == null;
        }
        return Intrinsics.areEqual((Object) t, (Object) t2);
    }

    @JvmStatic
    public static final String safeGetStringFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return "";
        }
        String optString = jSONObject.optString(str, "");
        Intrinsics.checkNotNullExpressionValue(optString, "response.optString(propertyName, \"\")");
        return optString;
    }

    @JvmStatic
    public static final JSONObject tryGetJSONObjectFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONObject(str);
    }

    @JvmStatic
    public static final JSONArray tryGetJSONArrayFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONArray(str);
    }

    @JvmStatic
    public static final List<String> jsonArrayToStringList(JSONArray jSONArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                arrayList.add(jSONArray.getString(i));
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return arrayList;
    }

    @JvmStatic
    public static final Set<String> jsonArrayToSet(JSONArray jSONArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
        Set<String> hashSet = new HashSet<>();
        int length = jSONArray.length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                String string = jSONArray.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                hashSet.add(string);
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return hashSet;
    }

    @JvmStatic
    public static final String mapToJsonStr(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, AdaptyImmutableMapTypeAdapterFactory.MAP);
        String str = "";
        if (!map.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry next : map.entrySet()) {
                    jSONObject.put((String) next.getKey(), (Object) (String) next.getValue());
                }
                str = jSONObject.toString();
            } catch (JSONException unused) {
            }
            Intrinsics.checkNotNullExpressionValue(str, "{\n      try {\n        val jsonObject = JSONObject()\n        for ((key, value) in map) {\n          jsonObject.put(key, value)\n        }\n        jsonObject.toString()\n      } catch (_e: JSONException) {\n        \"\"\n      }\n    }");
        }
        return str;
    }

    @JvmStatic
    public static final Map<String, String> jsonStrToMap(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        if (str.length() == 0) {
            return new HashMap<>();
        }
        try {
            Map<String, String> hashMap = new HashMap<>();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Intrinsics.checkNotNullExpressionValue(next, "key");
                String string = jSONObject.getString(next);
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
                hashMap.put(next, string);
            }
            return hashMap;
        } catch (JSONException unused) {
            return new HashMap<>();
        }
    }

    @JvmStatic
    public static final void setAppEventAttributionParameters(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, String str, boolean z, Context context) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "params");
        Intrinsics.checkNotNullParameter(context, "context");
        FeatureManager featureManager = FeatureManager.INSTANCE;
        if (!FeatureManager.isEnabled(FeatureManager.Feature.ServiceUpdateCompliance)) {
            jSONObject.put("anon_id", (Object) str);
        }
        boolean z2 = true;
        jSONObject.put("application_tracking_enabled", !z);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        jSONObject.put("advertiser_id_collection_enabled", FacebookSdk.getAdvertiserIDCollectionEnabled());
        if (attributionIdentifiers != null) {
            FeatureManager featureManager2 = FeatureManager.INSTANCE;
            if (FeatureManager.isEnabled(FeatureManager.Feature.ServiceUpdateCompliance)) {
                INSTANCE.appendAnonIdUnderCompliance(jSONObject, attributionIdentifiers, str, context);
            }
            if (attributionIdentifiers.getAttributionId() != null) {
                FeatureManager featureManager3 = FeatureManager.INSTANCE;
                if (FeatureManager.isEnabled(FeatureManager.Feature.ServiceUpdateCompliance)) {
                    INSTANCE.appendAttributionIdUnderCompliance(jSONObject, attributionIdentifiers, context);
                } else {
                    jSONObject.put("attribution", (Object) attributionIdentifiers.getAttributionId());
                }
            }
            if (attributionIdentifiers.getAndroidAdvertiserId() != null) {
                jSONObject.put("advertiser_id", (Object) attributionIdentifiers.getAndroidAdvertiserId());
                jSONObject.put("advertiser_tracking_enabled", !attributionIdentifiers.isTrackingLimited());
            }
            if (!attributionIdentifiers.isTrackingLimited()) {
                UserDataStore userDataStore = UserDataStore.INSTANCE;
                String allHashedUserData = UserDataStore.getAllHashedUserData();
                if (allHashedUserData.length() != 0) {
                    z2 = false;
                }
                if (!z2) {
                    jSONObject.put("ud", (Object) allHashedUserData);
                }
            }
            if (attributionIdentifiers.getAndroidInstallerPackage() != null) {
                jSONObject.put("installer_package", (Object) attributionIdentifiers.getAndroidInstallerPackage());
            }
        }
    }

    @JvmStatic
    public static final String getAppVersion() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final void setAppEventExtendedDeviceInfoParameters(JSONObject jSONObject, Context context) throws JSONException {
        String str;
        Locale locale;
        int i;
        Intrinsics.checkNotNullParameter(jSONObject, "params");
        Intrinsics.checkNotNullParameter(context, "appContext");
        JSONArray jSONArray = new JSONArray();
        Utility utility = INSTANCE;
        jSONArray.put((Object) EXTRA_APP_EVENTS_INFO_FORMAT_VERSION);
        utility.refreshPeriodicExtendedDeviceInfo(context);
        String packageName = context.getPackageName();
        int i2 = 0;
        int i3 = -1;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            if (packageInfo != null) {
                i3 = packageInfo.versionCode;
                str = packageInfo.versionName;
                jSONArray.put((Object) packageName);
                jSONArray.put(i3);
                jSONArray.put((Object) str);
                jSONArray.put((Object) Build.VERSION.RELEASE);
                jSONArray.put((Object) Build.MODEL);
                try {
                    locale = context.getResources().getConfiguration().locale;
                } catch (Exception unused) {
                    locale = Locale.getDefault();
                }
                jSONArray.put((Object) locale.getLanguage() + '_' + locale.getCountry());
                jSONArray.put((Object) deviceTimezoneAbbreviation);
                jSONArray.put((Object) carrierName);
                double d = 0.0d;
                try {
                    Display display = null;
                    if (Build.VERSION.SDK_INT >= 17) {
                        Object systemService = context.getSystemService("display");
                        DisplayManager displayManager = systemService instanceof DisplayManager ? (DisplayManager) systemService : null;
                        if (displayManager != null) {
                            display = displayManager.getDisplay(0);
                        }
                    } else {
                        Object systemService2 = context.getSystemService("window");
                        WindowManager windowManager = systemService2 instanceof WindowManager ? (WindowManager) systemService2 : null;
                        if (windowManager != null) {
                            display = windowManager.getDefaultDisplay();
                        }
                    }
                    if (display != null) {
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        display.getMetrics(displayMetrics);
                        int i4 = displayMetrics.widthPixels;
                        try {
                            i2 = displayMetrics.heightPixels;
                            d = (double) displayMetrics.density;
                        } catch (Exception unused2) {
                        }
                        i = i2;
                        i2 = i4;
                        jSONArray.put(i2);
                        jSONArray.put(i);
                        jSONArray.put((Object) new DecimalFormat("#.##").format(d));
                        jSONArray.put(INSTANCE.refreshBestGuessNumberOfCPUCores());
                        jSONArray.put(totalExternalStorageGB);
                        jSONArray.put(availableExternalStorageGB);
                        jSONArray.put((Object) deviceTimeZoneName);
                        jSONObject.put(Constants.EXTINFO, (Object) jSONArray.toString());
                    }
                } catch (Exception unused3) {
                }
                i = 0;
                jSONArray.put(i2);
                jSONArray.put(i);
                jSONArray.put((Object) new DecimalFormat("#.##").format(d));
                jSONArray.put(INSTANCE.refreshBestGuessNumberOfCPUCores());
                jSONArray.put(totalExternalStorageGB);
                jSONArray.put(availableExternalStorageGB);
                jSONArray.put((Object) deviceTimeZoneName);
                jSONObject.put(Constants.EXTINFO, (Object) jSONArray.toString());
            }
        } catch (PackageManager.NameNotFoundException unused4) {
            str = "";
        }
    }

    @JvmStatic
    public static final Method getMethodQuietly(Class<?> cls, String str, Class<?>... clsArr) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(str, JSStackTrace.METHOD_NAME_KEY);
        Intrinsics.checkNotNullParameter(clsArr, "parameterTypes");
        try {
            return cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            Method method = null;
            return null;
        }
    }

    @JvmStatic
    public static final Method getMethodQuietly(String str, String str2, Class<?>... clsArr) {
        Intrinsics.checkNotNullParameter(str, "className");
        Intrinsics.checkNotNullParameter(str2, JSStackTrace.METHOD_NAME_KEY);
        Intrinsics.checkNotNullParameter(clsArr, "parameterTypes");
        try {
            Class<?> cls = Class.forName(str);
            Intrinsics.checkNotNullExpressionValue(cls, "clazz");
            return getMethodQuietly(cls, str2, (Class<?>[]) (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (ClassNotFoundException unused) {
            Method method = null;
            return null;
        }
    }

    @JvmStatic
    public static final Object invokeMethodQuietly(Object obj, Method method, Object... objArr) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        try {
            return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final String getActivityName(Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        String simpleName = context.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "{\n      context.javaClass.simpleName\n    }");
        return simpleName;
    }

    @JvmStatic
    public static final String getUriString(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    @JvmStatic
    public static final boolean isWebUri(Uri uri) {
        if (uri == null || (!StringsKt.equals("http", uri.getScheme(), true) && !StringsKt.equals("https", uri.getScheme(), true) && !StringsKt.equals("fbstaging", uri.getScheme(), true))) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean isContentUri(Uri uri) {
        return uri != null && StringsKt.equals("content", uri.getScheme(), true);
    }

    @JvmStatic
    public static final boolean isFileUri(Uri uri) {
        return uri != null && StringsKt.equals("file", uri.getScheme(), true);
    }

    @JvmStatic
    public static final long getContentSize(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "contentUri");
        Cursor cursor = null;
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Cursor query = FacebookSdk.getApplicationContext().getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
            if (query == null) {
                return 0;
            }
            int columnIndex = query.getColumnIndex("_size");
            query.moveToFirst();
            long j = query.getLong(columnIndex);
            query.close();
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @JvmStatic
    public static final Date getBundleLongAsDate(Bundle bundle, String str, Date date) {
        long j;
        Intrinsics.checkNotNullParameter(date, "dateBase");
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            j = ((Number) obj).longValue();
        } else {
            if (obj instanceof String) {
                try {
                    j = Long.parseLong((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        if (j == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date(date.getTime() + (j * 1000));
    }

    @JvmStatic
    public static final void writeStringMapToParcel(Parcel parcel, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
    }

    @JvmStatic
    public static final Map<String, String> readStringMapFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        Map<String, String> hashMap = new HashMap<>();
        int i = 0;
        if (readInt > 0) {
            do {
                i++;
                hashMap.put(parcel.readString(), parcel.readString());
            } while (i < readInt);
        }
        return hashMap;
    }

    @JvmStatic
    public static final void writeNonnullStringMapToParcel(Parcel parcel, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
    }

    @JvmStatic
    public static final Map<String, String> readNonnullStringMapFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        Map<String, String> hashMap = new HashMap<>();
        int i = 0;
        if (readInt > 0) {
            do {
                i++;
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (!(readString == null || readString2 == null)) {
                    hashMap.put(readString, readString2);
                    continue;
                }
            } while (i < readInt);
        }
        return hashMap;
    }

    @JvmStatic
    public static final boolean isCurrentAccessToken(AccessToken accessToken) {
        return accessToken != null && Intrinsics.areEqual((Object) accessToken, (Object) AccessToken.Companion.getCurrentAccessToken());
    }

    @JvmStatic
    public static final String getGraphDomainFromTokenDomain(String str) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String facebookDomain = FacebookSdk.getFacebookDomain();
        if (str == null) {
            return facebookDomain;
        }
        if (Intrinsics.areEqual((Object) str, (Object) FacebookSdk.GAMING)) {
            return StringsKt.replace$default(facebookDomain, "facebook.com", "fb.gg", false, 4, (Object) null);
        }
        return Intrinsics.areEqual((Object) str, (Object) FacebookSdk.INSTAGRAM) ? StringsKt.replace$default(facebookDomain, "facebook.com", FacebookSdk.INSTAGRAM_COM, false, 4, (Object) null) : facebookDomain;
    }

    @JvmStatic
    public static final void getGraphMeRequestWithCacheAsync(String str, GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback) {
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_ACCESS_TOKEN);
        Intrinsics.checkNotNullParameter(graphMeRequestWithCacheCallback, "callback");
        ProfileInformationCache profileInformationCache = ProfileInformationCache.INSTANCE;
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            graphMeRequestWithCacheCallback.onSuccess(profileInformation);
            return;
        }
        Utility$$ExternalSyntheticLambda0 utility$$ExternalSyntheticLambda0 = new Utility$$ExternalSyntheticLambda0(graphMeRequestWithCacheCallback, str);
        GraphRequest graphMeRequestWithCache = INSTANCE.getGraphMeRequestWithCache(str);
        graphMeRequestWithCache.setCallback(utility$$ExternalSyntheticLambda0);
        graphMeRequestWithCache.executeAsync();
    }

    /* access modifiers changed from: private */
    /* renamed from: getGraphMeRequestWithCacheAsync$lambda-3  reason: not valid java name */
    public static final void m345getGraphMeRequestWithCacheAsync$lambda3(GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback, String str, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(graphMeRequestWithCacheCallback, "$callback");
        Intrinsics.checkNotNullParameter(str, "$accessToken");
        Intrinsics.checkNotNullParameter(graphResponse, Response.TYPE);
        if (graphResponse.getError() != null) {
            graphMeRequestWithCacheCallback.onFailure(graphResponse.getError().getException());
            return;
        }
        ProfileInformationCache profileInformationCache = ProfileInformationCache.INSTANCE;
        JSONObject jsonObject = graphResponse.getJsonObject();
        if (jsonObject != null) {
            ProfileInformationCache.putProfileInformation(str, jsonObject);
            graphMeRequestWithCacheCallback.onSuccess(graphResponse.getJsonObject());
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @JvmStatic
    public static final JSONObject awaitGetGraphMeRequestWithCache(String str) {
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_ACCESS_TOKEN);
        ProfileInformationCache profileInformationCache = ProfileInformationCache.INSTANCE;
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            return profileInformation;
        }
        GraphResponse executeAndWait = INSTANCE.getGraphMeRequestWithCache(str).executeAndWait();
        if (executeAndWait.getError() == null) {
            return executeAndWait.getJsonObject();
        }
        JSONObject jSONObject = null;
        return null;
    }

    private final GraphRequest getGraphMeRequestWithCache(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, getProfileFieldsForGraphDomain(getCurrentTokenDomainWithDefault()));
        bundle.putString("access_token", str);
        GraphRequest newMeRequest = GraphRequest.Companion.newMeRequest((AccessToken) null, (GraphRequest.GraphJSONObjectCallback) null);
        newMeRequest.setParameters(bundle);
        newMeRequest.setHttpMethod(HttpMethod.GET);
        return newMeRequest;
    }

    private final String getProfileFieldsForGraphDomain(String str) {
        return Intrinsics.areEqual((Object) str, (Object) FacebookSdk.INSTAGRAM) ? INSTAGRAM_PROFILE_FIELDS : FACEBOOK_PROFILE_FIELDS;
    }

    private final String getCurrentTokenDomainWithDefault() {
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        return (currentAccessToken == null || currentAccessToken.getGraphDomain() == null) ? AccessToken.DEFAULT_GRAPH_DOMAIN : currentAccessToken.getGraphDomain();
    }

    private final int refreshBestGuessNumberOfCPUCores() {
        int i = numCPUCores;
        if (i > 0) {
            return i;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new Utility$$ExternalSyntheticLambda1());
            if (listFiles != null) {
                numCPUCores = listFiles.length;
            }
        } catch (Exception unused) {
        }
        if (numCPUCores <= 0) {
            numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return numCPUCores;
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshBestGuessNumberOfCPUCores$lambda-4  reason: not valid java name */
    public static final boolean m346refreshBestGuessNumberOfCPUCores$lambda4(File file, String str) {
        return Pattern.matches("cpu[0-9]+", str);
    }

    private final void refreshPeriodicExtendedDeviceInfo(Context context) {
        if (timestampOfLastCheck == -1 || System.currentTimeMillis() - timestampOfLastCheck >= 1800000) {
            timestampOfLastCheck = System.currentTimeMillis();
            refreshTimezone();
            refreshCarrierName(context);
            refreshTotalExternalStorage();
            refreshAvailableExternalStorage();
        }
    }

    private final void refreshTimezone() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            String displayName = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            Intrinsics.checkNotNullExpressionValue(displayName, "tz.getDisplayName(tz.inDaylightTime(Date()), TimeZone.SHORT)");
            deviceTimezoneAbbreviation = displayName;
            String id = timeZone.getID();
            Intrinsics.checkNotNullExpressionValue(id, "tz.id");
            deviceTimeZoneName = id;
        } catch (AssertionError | Exception unused) {
        }
    }

    private final void refreshCarrierName(Context context) {
        if (Intrinsics.areEqual((Object) carrierName, (Object) NO_CARRIER)) {
            try {
                Object systemService = context.getSystemService("phone");
                if (systemService != null) {
                    String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
                    Intrinsics.checkNotNullExpressionValue(networkOperatorName, "telephonyManager.networkOperatorName");
                    carrierName = networkOperatorName;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
            } catch (Exception unused) {
            }
        }
    }

    private final boolean externalStorageExists() {
        return Intrinsics.areEqual((Object) "mounted", (Object) Environment.getExternalStorageState());
    }

    private final void refreshAvailableExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                availableExternalStorageGB = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
            availableExternalStorageGB = convertBytesToGB((double) availableExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private final void refreshTotalExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                totalExternalStorageGB = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            }
            totalExternalStorageGB = convertBytesToGB((double) totalExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private final long convertBytesToGB(double d) {
        return Math.round(d / 1.073741824E9d);
    }

    private final void appendAnonIdUnderCompliance(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, String str, Context context) {
        if (Build.VERSION.SDK_INT < 31 || !isGooglePlayServicesAvailable(context)) {
            jSONObject.put("anon_id", (Object) str);
        } else if (!attributionIdentifiers.isTrackingLimited()) {
            jSONObject.put("anon_id", (Object) str);
        }
    }

    private final void appendAttributionIdUnderCompliance(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, Context context) {
        if (Build.VERSION.SDK_INT < 31 || !isGooglePlayServicesAvailable(context)) {
            jSONObject.put("attribution", (Object) attributionIdentifiers.getAttributionId());
        } else if (!attributionIdentifiers.isTrackingLimited()) {
            jSONObject.put("attribution", (Object) attributionIdentifiers.getAttributionId());
        }
    }

    private final boolean isGooglePlayServicesAvailable(Context context) {
        Method methodQuietly = getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
        if (methodQuietly == null) {
            return false;
        }
        Object invokeMethodQuietly = invokeMethodQuietly((Object) null, methodQuietly, context);
        if (!(invokeMethodQuietly instanceof Integer) || !Intrinsics.areEqual(invokeMethodQuietly, (Object) 0)) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final String generateRandomString(int i) {
        String bigInteger = new BigInteger(i * 5, new Random()).toString(32);
        Intrinsics.checkNotNullExpressionValue(bigInteger, "BigInteger(length * 5, r).toString(32)");
        return bigInteger;
    }

    @JvmStatic
    public static final boolean mustFixWindowParamsForAutofill(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return isAutofillAvailable(context);
    }

    @JvmStatic
    public static final boolean isAutofillAvailable(Context context) {
        AutofillManager autofillManager;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class)) != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled()) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean isChromeOS(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        if (Build.DEVICE != null) {
            String str = Build.DEVICE;
            Intrinsics.checkNotNullExpressionValue(str, "DEVICE");
            if (new Regex(ARC_DEVICE_PATTERN).matches(str)) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final Locale getResourceLocale() {
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            return FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
        } catch (Exception unused) {
            Locale locale = null;
            return null;
        }
    }

    @JvmStatic
    public static final Locale getCurrentLocale() {
        Locale resourceLocale = getResourceLocale();
        if (resourceLocale != null) {
            return resourceLocale;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        return locale;
    }

    @JvmStatic
    public static final void runOnNonUiThread(Runnable runnable) {
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FacebookSdk.getExecutor().execute(runnable);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final String getAppName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            String applicationName = FacebookSdk.getApplicationName();
            if (applicationName != null) {
                return applicationName;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            if (i == 0) {
                return applicationInfo.nonLocalizedLabel.toString();
            }
            String string = context.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(stringId)");
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static final boolean isAutoAppLinkSetup() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            String format = String.format("fb%s://applinks", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            intent.setData(Uri.parse(format));
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            String packageName = applicationContext.getPackageName();
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)");
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                if (Intrinsics.areEqual((Object) packageName, (Object) resolveInfo.activityInfo.packageName)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @JvmStatic
    public static final JSONObject getDataProcessingOptions() {
        Class<Utility> cls = Utility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            String string = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.DATA_PROCESSING_OPTIONS_PREFERENCES, 0).getString(FacebookSdk.DATA_PROCESSION_OPTIONS, (String) null);
            if (string != null) {
                try {
                    return new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final boolean isDataProcessingRestricted() {
        Class<Utility> cls = Utility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            JSONObject dataProcessingOptions = getDataProcessingOptions();
            if (dataProcessingOptions == null) {
                return false;
            }
            try {
                JSONArray jSONArray = dataProcessingOptions.getJSONArray(FacebookSdk.DATA_PROCESSION_OPTIONS);
                int length = jSONArray.length();
                if (length > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        String string = jSONArray.getString(i);
                        Intrinsics.checkNotNullExpressionValue(string, "options.getString(i)");
                        String lowerCase = string.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                        if (Intrinsics.areEqual((Object) lowerCase, (Object) "ldu")) {
                            return true;
                        }
                        if (i2 >= length) {
                            break;
                        }
                        i = i2;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }
}
