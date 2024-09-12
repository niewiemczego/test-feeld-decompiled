package com.google.firebase;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import java.lang.annotation.Annotation;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\rH\b\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u001a\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006\u001a\"\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"app", "Lcom/google/firebase/FirebaseApp;", "Lcom/google/firebase/Firebase;", "getApp", "(Lcom/google/firebase/Firebase;)Lcom/google/firebase/FirebaseApp;", "options", "Lcom/google/firebase/FirebaseOptions;", "getOptions", "(Lcom/google/firebase/Firebase;)Lcom/google/firebase/FirebaseOptions;", "coroutineDispatcher", "Lcom/google/firebase/components/Component;", "Lkotlinx/coroutines/CoroutineDispatcher;", "T", "", "name", "", "initialize", "context", "Landroid/content/Context;", "com.google.firebase-firebase-common"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Firebase.kt */
public final class FirebaseKt {
    public static final FirebaseApp getApp(Firebase firebase) {
        Intrinsics.checkNotNullParameter(firebase, "<this>");
        FirebaseApp instance = FirebaseApp.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    public static final FirebaseApp app(Firebase firebase, String str) {
        Intrinsics.checkNotNullParameter(firebase, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        FirebaseApp instance = FirebaseApp.getInstance(str);
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(name)");
        return instance;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context) {
        Intrinsics.checkNotNullParameter(firebase, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return FirebaseApp.initializeApp(context);
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions firebaseOptions) {
        Intrinsics.checkNotNullParameter(firebase, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(firebaseOptions, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, firebaseOptions);
        Intrinsics.checkNotNullExpressionValue(initializeApp, "initializeApp(context, options)");
        return initializeApp;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions firebaseOptions, String str) {
        Intrinsics.checkNotNullParameter(firebase, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(firebaseOptions, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        Intrinsics.checkNotNullParameter(str, "name");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, firebaseOptions, str);
        Intrinsics.checkNotNullExpressionValue(initializeApp, "initializeApp(context, options, name)");
        return initializeApp;
    }

    public static final FirebaseOptions getOptions(Firebase firebase) {
        Intrinsics.checkNotNullParameter(firebase, "<this>");
        FirebaseOptions options = getApp(Firebase.INSTANCE).getOptions();
        Intrinsics.checkNotNullExpressionValue(options, "Firebase.app.options");
        return options;
    }

    private static final /* synthetic */ <T extends Annotation> Component<CoroutineDispatcher> coroutineDispatcher() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<Annotation> cls = Annotation.class;
        Class cls2 = cls;
        Class<CoroutineDispatcher> cls3 = CoroutineDispatcher.class;
        Class cls4 = cls3;
        Component.Builder<CoroutineDispatcher> builder = Component.builder(Qualified.qualified(cls, cls3));
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<Annotation> cls5 = Annotation.class;
        Class cls6 = cls5;
        Class<Executor> cls7 = Executor.class;
        Class cls8 = cls7;
        Component.Builder<CoroutineDispatcher> add = builder.add(Dependency.required((Qualified<?>) Qualified.qualified(cls5, cls7)));
        Intrinsics.needClassReification();
        Component<CoroutineDispatcher> build = add.factory(FirebaseKt$coroutineDispatcher$1.INSTANCE).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Component component = build;
        return build;
    }
}
