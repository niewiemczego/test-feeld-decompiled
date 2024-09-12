package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.util.Base64OutputStream;
import androidx.core.os.UserManagerCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class DefaultHeartBeatController implements HeartBeatController, HeartBeatInfo {
    private final Context applicationContext;
    private final Executor backgroundExecutor;
    private final Set<HeartBeatConsumer> consumers;
    private final Provider<HeartBeatInfoStorage> storageProvider;
    private final Provider<UserAgentPublisher> userAgentProvider;

    public Task<Void> registerHeartBeat() {
        if (this.consumers.size() <= 0) {
            return Tasks.forResult(null);
        }
        if (!UserManagerCompat.isUserUnlocked(this.applicationContext)) {
            return Tasks.forResult(null);
        }
        return Tasks.call(this.backgroundExecutor, new DefaultHeartBeatController$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$registerHeartBeat$0$com-google-firebase-heartbeatinfo-DefaultHeartBeatController  reason: not valid java name */
    public /* synthetic */ Void m582lambda$registerHeartBeat$0$comgooglefirebaseheartbeatinfoDefaultHeartBeatController() throws Exception {
        synchronized (this) {
            this.storageProvider.get().storeHeartBeat(System.currentTimeMillis(), this.userAgentProvider.get().getUserAgent());
        }
        return null;
    }

    public Task<String> getHeartBeatsHeader() {
        if (!UserManagerCompat.isUserUnlocked(this.applicationContext)) {
            return Tasks.forResult("");
        }
        return Tasks.call(this.backgroundExecutor, new DefaultHeartBeatController$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getHeartBeatsHeader$1$com-google-firebase-heartbeatinfo-DefaultHeartBeatController  reason: not valid java name */
    public /* synthetic */ String m581lambda$getHeartBeatsHeader$1$comgooglefirebaseheartbeatinfoDefaultHeartBeatController() throws Exception {
        GZIPOutputStream gZIPOutputStream;
        String byteArrayOutputStream;
        synchronized (this) {
            HeartBeatInfoStorage heartBeatInfoStorage = this.storageProvider.get();
            List<HeartBeatResult> allHeartBeats = heartBeatInfoStorage.getAllHeartBeats();
            heartBeatInfoStorage.deleteAllHeartBeats();
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < allHeartBeats.size(); i++) {
                HeartBeatResult heartBeatResult = allHeartBeats.get(i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("agent", (Object) heartBeatResult.getUserAgent());
                jSONObject.put("dates", (Object) new JSONArray((Collection<?>) heartBeatResult.getUsedDates()));
                jSONArray.put((Object) jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("heartbeats", (Object) jSONArray);
            jSONObject2.put("version", (Object) ExifInterface.GPS_MEASUREMENT_2D);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
            try {
                gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                gZIPOutputStream.close();
                base64OutputStream.close();
                byteArrayOutputStream = byteArrayOutputStream2.toString("UTF-8");
            } catch (Throwable th) {
                try {
                    base64OutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        return byteArrayOutputStream;
        throw th;
    }

    private DefaultHeartBeatController(Context context, String str, Set<HeartBeatConsumer> set, Provider<UserAgentPublisher> provider, Executor executor) {
        this((Provider<HeartBeatInfoStorage>) new DefaultHeartBeatController$$ExternalSyntheticLambda3(context, str), set, executor, provider, context);
    }

    static /* synthetic */ HeartBeatInfoStorage lambda$new$2(Context context, String str) {
        return new HeartBeatInfoStorage(context, str);
    }

    DefaultHeartBeatController(Provider<HeartBeatInfoStorage> provider, Set<HeartBeatConsumer> set, Executor executor, Provider<UserAgentPublisher> provider2, Context context) {
        this.storageProvider = provider;
        this.consumers = set;
        this.backgroundExecutor = executor;
        this.userAgentProvider = provider2;
        this.applicationContext = context;
    }

    public static Component<DefaultHeartBeatController> component() {
        Qualified<Executor> qualified = Qualified.qualified(Background.class, Executor.class);
        return Component.builder(DefaultHeartBeatController.class, (Class<? super T>[]) new Class[]{HeartBeatController.class, HeartBeatInfo.class}).add(Dependency.required((Class<?>) Context.class)).add(Dependency.required((Class<?>) FirebaseApp.class)).add(Dependency.setOf((Class<?>) HeartBeatConsumer.class)).add(Dependency.requiredProvider((Class<?>) UserAgentPublisher.class)).add(Dependency.required((Qualified<?>) qualified)).factory(new DefaultHeartBeatController$$ExternalSyntheticLambda2(qualified)).build();
    }

    static /* synthetic */ DefaultHeartBeatController lambda$component$3(Qualified qualified, ComponentContainer componentContainer) {
        return new DefaultHeartBeatController((Context) componentContainer.get(Context.class), ((FirebaseApp) componentContainer.get(FirebaseApp.class)).getPersistenceKey(), componentContainer.setOf(HeartBeatConsumer.class), componentContainer.getProvider(UserAgentPublisher.class), (Executor) componentContainer.get(qualified));
    }

    public synchronized HeartBeatInfo.HeartBeat getHeartBeatCode(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        HeartBeatInfoStorage heartBeatInfoStorage = this.storageProvider.get();
        if (heartBeatInfoStorage.shouldSendGlobalHeartBeat(currentTimeMillis)) {
            heartBeatInfoStorage.postHeartBeatCleanUp();
            return HeartBeatInfo.HeartBeat.GLOBAL;
        }
        return HeartBeatInfo.HeartBeat.NONE;
    }
}
