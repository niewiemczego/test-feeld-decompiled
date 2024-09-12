package com.appsflyer.internal;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.amplitude.reactnative.DatabaseConstants;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFf1jSDK;
import io.sentry.protocol.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

public class AFf1mSDK extends AFf1pSDK {
    public final Map<String, Object> AFInAppEventParameterName = new HashMap();

    public AFf1mSDK(Runnable runnable) {
        super(DatabaseConstants.STORE_TABLE_NAME, "google", runnable);
    }

    private static boolean valueOf(Context context) {
        if (!AFKeystoreWrapper(context)) {
            return false;
        }
        try {
            Class.forName("com.android.installreferrer.api.InstallReferrerClient");
            if (AFa1cSDK.AFKeystoreWrapper(context, "com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE")) {
                AFLogger.afDebugLog("Install referrer is allowed");
                return true;
            }
            AFLogger.afDebugLog("Install referrer is not allowed");
            return false;
        } catch (ClassNotFoundException e) {
            AFLogger.afErrorLogForExcManagerOnly("InstallReferrerClient not found", e);
            AFLogger.afRDLog(new StringBuilder("Class ").append("com.android.installreferrer.api.InstallReferrerClient").append(" not found").toString());
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to verify manifest : ".concat("com.android.installreferrer.api.InstallReferrerClient"), th);
            return false;
        }
    }

    public final void values(final Context context) {
        if (valueOf(context)) {
            this.AFLogger = System.currentTimeMillis();
            this.AFKeystoreWrapper = AFf1jSDK.AFa1wSDK.STARTED;
            addObserver(new Observer() {
                public final void update(
/*
Method generation error in method: com.appsflyer.internal.AFf1jSDK.4.update(java.util.Observable, java.lang.Object):void, dex: classes2.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFf1jSDK.4.update(java.util.Observable, java.lang.Object):void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
            try {
                final InstallReferrerClient build = InstallReferrerClient.newBuilder(context).build();
                AFLogger.afDebugLog("Connecting to Install Referrer Library...");
                build.startConnection(new InstallReferrerStateListener() {
                    public final void onInstallReferrerSetupFinished(int i) {
                        AFf1mSDK.this.AFInAppEventParameterName.put("code", String.valueOf(i));
                        AFf1mSDK.this.AFInAppEventType.put("api_ver", Long.valueOf(AFa1cSDK.values(context, "com.android.vending")));
                        AFf1mSDK.this.AFInAppEventType.put("api_ver_name", AFa1cSDK.AFInAppEventParameterName(context, "com.android.vending"));
                        if (i == -1) {
                            AFLogger.afWarnLog("InstallReferrer SERVICE_DISCONNECTED");
                            AFf1mSDK.this.AFInAppEventType.put(Response.TYPE, "SERVICE_DISCONNECTED");
                        } else if (i == 0) {
                            AFf1mSDK.this.AFInAppEventType.put(Response.TYPE, "OK");
                            try {
                                AFLogger.afDebugLog("InstallReferrer connected");
                                if (build.isReady()) {
                                    ReferrerDetails installReferrer = build.getInstallReferrer();
                                    String installReferrer2 = installReferrer.getInstallReferrer();
                                    if (installReferrer2 != null) {
                                        AFf1mSDK.this.AFInAppEventParameterName.put("val", installReferrer2);
                                        AFf1mSDK.this.AFInAppEventType.put("referrer", installReferrer2);
                                    }
                                    long referrerClickTimestampSeconds = installReferrer.getReferrerClickTimestampSeconds();
                                    AFf1mSDK.this.AFInAppEventParameterName.put("clk", Long.toString(referrerClickTimestampSeconds));
                                    AFf1mSDK.this.AFInAppEventType.put("click_ts", Long.valueOf(referrerClickTimestampSeconds));
                                    long installBeginTimestampSeconds = installReferrer.getInstallBeginTimestampSeconds();
                                    AFf1mSDK.this.AFInAppEventParameterName.put("install", Long.toString(installBeginTimestampSeconds));
                                    AFf1mSDK.this.AFInAppEventType.put("install_begin_ts", Long.valueOf(installBeginTimestampSeconds));
                                    HashMap hashMap = new HashMap();
                                    boolean googlePlayInstantParam = installReferrer.getGooglePlayInstantParam();
                                    AFf1mSDK.this.AFInAppEventParameterName.put("instant", Boolean.valueOf(googlePlayInstantParam));
                                    hashMap.put("instant", Boolean.valueOf(googlePlayInstantParam));
                                    try {
                                        hashMap.put("click_server_ts", Long.valueOf(installReferrer.getReferrerClickTimestampServerSeconds()));
                                        hashMap.put("install_begin_server_ts", Long.valueOf(installReferrer.getInstallBeginTimestampServerSeconds()));
                                        hashMap.put("install_version", installReferrer.getInstallVersion());
                                    } catch (NoSuchMethodError e) {
                                        AFLogger.afErrorLogForExcManagerOnly("some method not exist", e);
                                    }
                                    if (!hashMap.isEmpty()) {
                                        AFf1mSDK.this.AFInAppEventType.put("google_custom", hashMap);
                                    }
                                } else {
                                    AFLogger.afWarnLog("ReferrerClient: InstallReferrer is not ready");
                                    AFf1mSDK.this.AFInAppEventParameterName.put(NotificationCompat.CATEGORY_ERROR, "ReferrerClient: InstallReferrer is not ready");
                                }
                            } catch (NoSuchMethodError e2) {
                                AFLogger.afErrorLogForExcManagerOnly("getGooglePlayInstantParam not exist", e2);
                            } catch (Throwable th) {
                                AFLogger.afWarnLog("Failed to get install referrer: " + th.getMessage());
                                AFf1mSDK.this.AFInAppEventParameterName.put(NotificationCompat.CATEGORY_ERROR, th.getMessage());
                                AFLogger.afErrorLogForExcManagerOnly("Failed to get install referrer", th);
                            }
                        } else if (i == 1) {
                            AFf1mSDK.this.AFInAppEventType.put(Response.TYPE, "SERVICE_UNAVAILABLE");
                            AFLogger.afWarnLog("InstallReferrer not supported");
                        } else if (i == 2) {
                            AFLogger.afWarnLog("InstallReferrer FEATURE_NOT_SUPPORTED");
                            AFf1mSDK.this.AFInAppEventType.put(Response.TYPE, "FEATURE_NOT_SUPPORTED");
                        } else if (i != 3) {
                            AFLogger.afWarnLog("responseCode not found.");
                        } else {
                            AFLogger.afWarnLog("InstallReferrer DEVELOPER_ERROR");
                            AFf1mSDK.this.AFInAppEventType.put(Response.TYPE, "DEVELOPER_ERROR");
                        }
                        AFLogger.afDebugLog("Install Referrer collected locally");
                        AFf1mSDK.this.values();
                        build.endConnection();
                    }

                    public final void onInstallReferrerServiceDisconnected() {
                        AFLogger.afDebugLog("Install Referrer service disconnected");
                    }
                });
            } catch (Throwable th) {
                AFLogger.afErrorLog("referrerClient -> startConnection", th);
            }
        }
    }
}
