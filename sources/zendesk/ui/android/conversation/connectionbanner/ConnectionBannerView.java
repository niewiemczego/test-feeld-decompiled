package zendesk.ui.android.conversation.connectionbanner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.conversation.connectionbanner.ConnectionBannerState;
import zendesk.ui.android.internal.ColorExtKt;
import zendesk.ui.android.internal.DimensionExtKt;
import zendesk.ui.android.internal.ThrottledOnClickListenerKt;
import zendesk.ui.android.internal.ViewKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002%&B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001fH\u0014J\u001c\u0010!\u001a\u00020\u001a2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030#H\u0016J\b\u0010$\u001a\u00020\u001aH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerView;", "Landroid/widget/FrameLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "animationTime", "", "backgroundDrawable", "Landroid/graphics/drawable/GradientDrawable;", "connectionBanner", "Landroidx/constraintlayout/widget/ConstraintLayout;", "label", "Landroid/widget/TextView;", "rendering", "retryButton", "Landroid/widget/ImageView;", "shouldAnimate", "", "announceConnectionStatusForAccessibility", "", "accessibilityAnnouncement", "", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "render", "renderingUpdate", "Lkotlin/Function1;", "startAnimation", "Companion", "SavedState", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionBannerView.kt */
public final class ConnectionBannerView extends FrameLayout implements Renderer<ConnectionBannerRendering> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final long FADE_DURATION = 300;
    @Deprecated
    private static final long NOT_CONNECTED_ACCESSIBILITY_EVENT_DELAY = 3500;
    private final long animationTime;
    private final GradientDrawable backgroundDrawable;
    private final ConstraintLayout connectionBanner;
    private final TextView label;
    /* access modifiers changed from: private */
    public ConnectionBannerRendering rendering;
    private final ImageView retryButton;
    private boolean shouldAnimate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ConnectionBannerView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ConnectionBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ConnectionBannerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConnectionBannerView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionBannerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new ConnectionBannerRendering();
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.backgroundDrawable = gradientDrawable;
        context.getTheme().applyStyle(R.style.ThemeOverlay_ZendeskComponents_ConnectionBannerStyle, false);
        FrameLayout.inflate(context, R.layout.zuia_view_connection_banner, this);
        View findViewById = findViewById(R.id.zuia_connection_banner);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zuia_connection_banner)");
        this.connectionBanner = (ConstraintLayout) findViewById;
        View findViewById2 = findViewById(R.id.zuia_banner_label);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.zuia_banner_label)");
        this.label = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.zuia_retry_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.zuia_retry_button)");
        ImageView imageView = (ImageView) findViewById3;
        this.retryButton = imageView;
        this.animationTime = (long) getResources().getInteger(R.integer.zuia_connection_banner_animation_duration);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) DimensionExtKt.resolveDimensionAttr(context, new int[]{R.attr.connectionBannerRadius}));
        ViewKt.expandTouchArea(imageView, this, getResources().getDimensionPixelSize(R.dimen.zuia_connection_banner_expanded_touch_area), getResources().getDimensionPixelSize(R.dimen.zuia_connection_banner_expanded_touch_area), getResources().getDimensionPixelSize(R.dimen.zuia_connection_banner_expanded_touch_area), getResources().getDimensionPixelSize(R.dimen.zuia_connection_banner_expanded_touch_area));
        setVisibility(8);
        render(AnonymousClass2.INSTANCE);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.setVisibility$zendesk_ui_ui_android(getVisibility());
        savedState.setConnectionState$zendesk_ui_ui_android(this.rendering.getState$zendesk_ui_ui_android().getConnectionState());
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setVisibility(savedState.getVisibility$zendesk_ui_ui_android());
            render(new ConnectionBannerView$onRestoreInstanceState$1(parcelable));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void render(Function1<? super ConnectionBannerRendering, ConnectionBannerRendering> function1) {
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        this.rendering = function1.invoke(this.rendering);
        boolean z = true;
        this.retryButton.setOnClickListener(ThrottledOnClickListenerKt.throttledOnClickListener$default(0, new ConnectionBannerView$render$1(this), 1, (Object) null));
        if (getVisibility() == 0 || Intrinsics.areEqual((Object) this.rendering.getState$zendesk_ui_ui_android().getConnectionState(), (Object) ConnectionBannerState.ConnectionState.Disconnected.INSTANCE)) {
            int i = R.attr.connectionBannerBackgroundColor;
            int i2 = R.attr.connectionBannerLabelColor;
            int i3 = 8;
            CharSequence text = this.label.getText();
            ConnectionBannerState.ConnectionState connectionState = this.rendering.getState$zendesk_ui_ui_android().getConnectionState();
            if (Intrinsics.areEqual((Object) connectionState, (Object) ConnectionBannerState.ConnectionState.Disconnected.INSTANCE) ? true : Intrinsics.areEqual((Object) connectionState, (Object) ConnectionBannerState.ConnectionState.Connected.INSTANCE)) {
                this.label.setText(R.string.zuia_connection_banner_label_disconnected);
                this.shouldAnimate = true;
                text = new StringBuilder().append(this.label.getText()).append(' ').append(this.retryButton.getContentDescription()).toString();
                i3 = 0;
            } else if (Intrinsics.areEqual((Object) connectionState, (Object) ConnectionBannerState.ConnectionState.Reconnecting.INSTANCE)) {
                this.label.setText(R.string.zuia_connection_banner_label_reconnecting);
                this.shouldAnimate = false;
                text = this.label.getText();
            } else if (Intrinsics.areEqual((Object) connectionState, (Object) ConnectionBannerState.ConnectionState.Reconnected.INSTANCE)) {
                this.label.setText(R.string.zuia_connection_banner_label_reconnected);
                i = R.attr.connectionBannerSuccessBackgroundColor;
                i2 = R.attr.connectionBannerSuccessLabelColor;
                if (getVisibility() != 0) {
                    z = false;
                }
                this.shouldAnimate = z;
                onSaveInstanceState();
                text = this.label.getText();
            }
            this.connectionBanner.setContentDescription(text);
            if (text != null) {
                announceConnectionStatusForAccessibility((String) text);
                GradientDrawable gradientDrawable = this.backgroundDrawable;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                gradientDrawable.setColor(ColorExtKt.resolveColorAttr(context, i));
                this.retryButton.setVisibility(i3);
                TextView textView = this.label;
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                textView.setTextColor(ColorExtKt.resolveColorAttr(context2, i2));
                Drawable drawable = this.retryButton.getDrawable();
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                drawable.setTint(ColorExtKt.resolveColorAttr(context3, i2));
                this.connectionBanner.setBackground(this.backgroundDrawable);
                if (this.shouldAnimate) {
                    startAnimation();
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        animate().cancel();
    }

    private final void announceConnectionStatusForAccessibility(String str) {
        this.label.postDelayed(new ConnectionBannerView$$ExternalSyntheticLambda2(this, str), NOT_CONNECTED_ACCESSIBILITY_EVENT_DELAY);
    }

    /* access modifiers changed from: private */
    /* renamed from: announceConnectionStatusForAccessibility$lambda-2  reason: not valid java name */
    public static final void m2775announceConnectionStatusForAccessibility$lambda2(ConnectionBannerView connectionBannerView, String str) {
        Intrinsics.checkNotNullParameter(connectionBannerView, "this$0");
        Intrinsics.checkNotNullParameter(str, "$accessibilityAnnouncement");
        connectionBannerView.label.announceForAccessibility(str);
    }

    private final void startAnimation() {
        animate().setDuration(FADE_DURATION).setStartDelay(this.animationTime);
        if (Intrinsics.areEqual((Object) this.rendering.getState$zendesk_ui_ui_android().getConnectionState(), (Object) ConnectionBannerState.ConnectionState.Disconnected.INSTANCE)) {
            animate().alpha(1.0f).withStartAction(new ConnectionBannerView$$ExternalSyntheticLambda0(this)).start();
        }
        if (Intrinsics.areEqual((Object) this.rendering.getState$zendesk_ui_ui_android().getConnectionState(), (Object) ConnectionBannerState.ConnectionState.Reconnected.INSTANCE)) {
            animate().alpha(0.0f).withEndAction(new ConnectionBannerView$$ExternalSyntheticLambda1(this)).start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startAnimation$lambda-3  reason: not valid java name */
    public static final void m2776startAnimation$lambda3(ConnectionBannerView connectionBannerView) {
        Intrinsics.checkNotNullParameter(connectionBannerView, "this$0");
        connectionBannerView.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: startAnimation$lambda-4  reason: not valid java name */
    public static final void m2777startAnimation$lambda4(ConnectionBannerView connectionBannerView) {
        Intrinsics.checkNotNullParameter(connectionBannerView, "this$0");
        connectionBannerView.setVisibility(8);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerView$SavedState;", "Landroid/view/View$BaseSavedState;", "superState", "Landroid/os/Parcelable;", "(Landroid/os/Parcelable;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "connectionState", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState;", "getConnectionState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState;", "setConnectionState$zendesk_ui_ui_android", "(Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState;)V", "visibility", "", "getVisibility$zendesk_ui_ui_android", "()I", "setVisibility$zendesk_ui_ui_android", "(I)V", "writeToParcel", "", "out", "flags", "Companion", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionBannerView.kt */
    public static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new ConnectionBannerView$SavedState$Companion$CREATOR$1();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private ConnectionBannerState.ConnectionState connectionState = ConnectionBannerState.ConnectionState.Connected.INSTANCE;
        private int visibility = 8;

        public final int getVisibility$zendesk_ui_ui_android() {
            return this.visibility;
        }

        public final void setVisibility$zendesk_ui_ui_android(int i) {
            this.visibility = i;
        }

        public final ConnectionBannerState.ConnectionState getConnectionState$zendesk_ui_ui_android() {
            return this.connectionState;
        }

        public final void setConnectionState$zendesk_ui_ui_android(ConnectionBannerState.ConnectionState connectionState2) {
            Intrinsics.checkNotNullParameter(connectionState2, "<set-?>");
            this.connectionState = connectionState2;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            Intrinsics.checkNotNullParameter(parcel, "source");
            this.visibility = parcel.readInt();
            this.connectionState = Companion.parseConnectionStateValue(String.valueOf(parcel.readString()));
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.visibility);
            parcel.writeString(this.connectionState.getStateValue());
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002¨\u0006\u000b"}, d2 = {"Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerView$SavedState$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerView$SavedState;", "getCREATOR$annotations", "parseConnectionStateValue", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState;", "stateValue", "", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConnectionBannerView.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ void getCREATOR$annotations() {
            }

            private Companion() {
            }

            public final ConnectionBannerState.ConnectionState parseConnectionStateValue(String str) {
                Intrinsics.checkNotNullParameter(str, "stateValue");
                int hashCode = str.hashCode();
                if (hashCode != -1217068453) {
                    if (hashCode != -273361386) {
                        if (hashCode == 115735883 && str.equals("Reconnecting")) {
                            return ConnectionBannerState.ConnectionState.Reconnecting.INSTANCE;
                        }
                    } else if (str.equals("Reconnected")) {
                        return ConnectionBannerState.ConnectionState.Reconnected.INSTANCE;
                    }
                } else if (str.equals("Disconnected")) {
                    return ConnectionBannerState.ConnectionState.Disconnected.INSTANCE;
                }
                return ConnectionBannerState.ConnectionState.Connected.INSTANCE;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerView$Companion;", "", "()V", "FADE_DURATION", "", "NOT_CONNECTED_ACCESSIBILITY_EVENT_DELAY", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionBannerView.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
