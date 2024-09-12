package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.common.R;
import com.facebook.login.LoginClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 82\u00020\u0001:\u00018B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0014J\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020 H\u0002J\"\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J&\u0010(\u001a\u0004\u0018\u00010\u00142\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010-\u001a\u00020\u001bH\u0016J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\u001bH\u0016J\b\u00102\u001a\u00020\u001bH\u0016J\u0010\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020'H\u0016J\b\u00105\u001a\u00020\u001bH\u0014J\b\u00106\u001a\u00020\u001bH\u0014J\b\u00107\u001a\u00020\u001bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006@BX.¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8UX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/facebook/login/LoginFragment;", "Landroidx/fragment/app/Fragment;", "()V", "callingPackage", "", "<set-?>", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "launcher", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "layoutResId", "", "getLayoutResId", "()I", "Lcom/facebook/login/LoginClient;", "loginClient", "getLoginClient", "()Lcom/facebook/login/LoginClient;", "progressBar", "Landroid/view/View;", "request", "Lcom/facebook/login/LoginClient$Request;", "createLoginClient", "getLoginMethodHandlerCallback", "Lkotlin/Function1;", "Landroidx/activity/result/ActivityResult;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "hideSpinner", "initializeCallingPackage", "Landroid/app/Activity;", "onActivityResult", "requestCode", "resultCode", "data", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onLoginClientCompleted", "outcome", "Lcom/facebook/login/LoginClient$Result;", "onPause", "onResume", "onSaveInstanceState", "outState", "onSpinnerHidden", "onSpinnerShown", "showSpinner", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LoginFragment.kt */
public class LoginFragment extends Fragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_REQUEST = "request";
    private static final String NULL_CALLING_PKG_ERROR_MSG = "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.";
    public static final String REQUEST_KEY = "com.facebook.LoginFragment:Request";
    public static final String RESULT_KEY = "com.facebook.LoginFragment:Result";
    private static final String SAVED_LOGIN_CLIENT = "loginClient";
    private static final String TAG = "LoginFragment";
    private String callingPackage;
    private ActivityResultLauncher<Intent> launcher;
    private LoginClient loginClient;
    private View progressBar;
    private LoginClient.Request request;

    /* access modifiers changed from: protected */
    public void onSpinnerHidden() {
    }

    /* access modifiers changed from: protected */
    public void onSpinnerShown() {
    }

    public final LoginClient getLoginClient() {
        LoginClient loginClient2 = this.loginClient;
        if (loginClient2 != null) {
            return loginClient2;
        }
        Intrinsics.throwUninitializedPropertyAccessException(SAVED_LOGIN_CLIENT);
        throw null;
    }

    public final ActivityResultLauncher<Intent> getLauncher() {
        ActivityResultLauncher<Intent> activityResultLauncher = this.launcher;
        if (activityResultLauncher != null) {
            return activityResultLauncher;
        }
        Intrinsics.throwUninitializedPropertyAccessException("launcher");
        throw null;
    }

    public void onCreate(Bundle bundle) {
        LoginClient loginClient2;
        Bundle bundleExtra;
        super.onCreate(bundle);
        if (bundle == null) {
            loginClient2 = null;
        } else {
            loginClient2 = (LoginClient) bundle.getParcelable(SAVED_LOGIN_CLIENT);
        }
        if (loginClient2 != null) {
            loginClient2.setFragment(this);
        } else {
            loginClient2 = createLoginClient();
        }
        this.loginClient = loginClient2;
        getLoginClient().setOnCompletedListener(new LoginFragment$$ExternalSyntheticLambda0(this));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            initializeCallingPackage(activity);
            Intent intent = activity.getIntent();
            if (!(intent == null || (bundleExtra = intent.getBundleExtra(REQUEST_KEY)) == null)) {
                this.request = (LoginClient.Request) bundleExtra.getParcelable("request");
            }
            ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new LoginFragment$$ExternalSyntheticLambda1(getLoginMethodHandlerCallback(activity)));
            Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(\n            ActivityResultContracts.StartActivityForResult(),\n            getLoginMethodHandlerCallback(activity))");
            this.launcher = registerForActivityResult;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m386onCreate$lambda0(LoginFragment loginFragment, LoginClient.Result result) {
        Intrinsics.checkNotNullParameter(loginFragment, "this$0");
        Intrinsics.checkNotNullParameter(result, "outcome");
        loginFragment.onLoginClientCompleted(result);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m387onCreate$lambda1(Function1 function1, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(activityResult);
    }

    private final Function1<ActivityResult, Unit> getLoginMethodHandlerCallback(FragmentActivity fragmentActivity) {
        return new LoginFragment$getLoginMethodHandlerCallback$1(this, fragmentActivity);
    }

    /* access modifiers changed from: protected */
    public LoginClient createLoginClient() {
        return new LoginClient((Fragment) this);
    }

    public void onDestroy() {
        getLoginClient().cancelCurrentHandler();
        super.onDestroy();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(getLayoutResId(), viewGroup, false);
        View findViewById = inflate.findViewById(R.id.com_facebook_login_fragment_progress_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<View>(R.id.com_facebook_login_fragment_progress_bar)");
        this.progressBar = findViewById;
        getLoginClient().setBackgroundProcessingListener(new LoginFragment$onCreateView$1(this));
        return inflate;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.com_facebook_login_fragment;
    }

    private final void onLoginClientCompleted(LoginClient.Result result) {
        this.request = null;
        int i = result.code == LoginClient.Result.Code.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESULT_KEY, result);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        FragmentActivity activity = getActivity();
        if (isAdded() && activity != null) {
            activity.setResult(i, intent);
            activity.finish();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.callingPackage == null) {
            Log.e(TAG, NULL_CALLING_PKG_ERROR_MSG);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        getLoginClient().startOrContinueAuth(this.request);
    }

    public void onPause() {
        super.onPause();
        View view = getView();
        View findViewById = view == null ? null : view.findViewById(R.id.com_facebook_login_fragment_progress_bar);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        getLoginClient().onActivityResult(i, i2, intent);
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(SAVED_LOGIN_CLIENT, getLoginClient());
    }

    /* access modifiers changed from: private */
    public final void showSpinner() {
        View view = this.progressBar;
        if (view != null) {
            view.setVisibility(0);
            onSpinnerShown();
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        throw null;
    }

    /* access modifiers changed from: private */
    public final void hideSpinner() {
        View view = this.progressBar;
        if (view != null) {
            view.setVisibility(8);
            onSpinnerHidden();
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        throw null;
    }

    private final void initializeCallingPackage(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            this.callingPackage = callingActivity.getPackageName();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/login/LoginFragment$Companion;", "", "()V", "EXTRA_REQUEST", "", "NULL_CALLING_PKG_ERROR_MSG", "REQUEST_KEY", "RESULT_KEY", "SAVED_LOGIN_CLIENT", "TAG", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LoginFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
