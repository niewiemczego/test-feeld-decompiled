package zendesk.ui.android.conversation.carousel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.conversation.avatar.AvatarImageState;
import zendesk.ui.android.conversation.carousel.CarouselCellData;
import zendesk.ui.android.internal.ViewKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010$\u001a\u00020%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030'H\u0016J\b\u0010(\u001a\u00020%H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0018\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lzendesk/ui/android/conversation/carousel/CarouselCellView;", "Landroid/widget/FrameLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/carousel/CarouselCellState;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lzendesk/ui/android/conversation/carousel/CarouselRecyclerViewAdapter;", "itemDecoration", "Lzendesk/ui/android/conversation/carousel/CarouselItemDecoration;", "layoutManager", "Lzendesk/ui/android/conversation/carousel/CarouselLayoutManager;", "nextButton", "Landroid/view/View;", "getNextButton", "()Landroid/view/View;", "nextButton$delegate", "Lkotlin/Lazy;", "prevButton", "getPrevButton", "prevButton$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "smoothScroller", "Lzendesk/ui/android/conversation/carousel/CenterSmoothScroller;", "snapHelper", "Lzendesk/ui/android/conversation/carousel/CarouselSnapHelper;", "state", "render", "", "renderingUpdate", "Lkotlin/Function1;", "setUpNextAndPreviousButton", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CarouselCellView.kt */
public final class CarouselCellView extends FrameLayout implements Renderer<CarouselCellState> {
    /* access modifiers changed from: private */
    public final CarouselRecyclerViewAdapter adapter;
    private final CarouselItemDecoration itemDecoration;
    /* access modifiers changed from: private */
    public final CarouselLayoutManager layoutManager;
    private final Lazy nextButton$delegate;
    private final Lazy prevButton$delegate;
    private final Lazy recyclerView$delegate;
    private final CenterSmoothScroller smoothScroller;
    private final CarouselSnapHelper snapHelper;
    private CarouselCellState state;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CarouselCellView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CarouselCellView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CarouselCellView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarouselCellView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.state = new CarouselCellState((List) null, (AvatarImageState) null, (CarouselRendering) null, 7, (DefaultConstructorMarker) null);
        View view = this;
        this.recyclerView$delegate = ViewKt.lazyViewById(view, R.id.zuia_carousel_list);
        this.nextButton$delegate = ViewKt.lazyViewById(view, R.id.zuia_carousel_next_button);
        this.prevButton$delegate = ViewKt.lazyViewById(view, R.id.zuia_carousel_prev_button);
        CarouselRecyclerViewAdapter carouselRecyclerViewAdapter = new CarouselRecyclerViewAdapter(context);
        this.adapter = carouselRecyclerViewAdapter;
        CarouselLayoutManager carouselLayoutManager = new CarouselLayoutManager(context, carouselRecyclerViewAdapter);
        this.layoutManager = carouselLayoutManager;
        CarouselItemDecoration carouselItemDecoration = new CarouselItemDecoration(context);
        this.itemDecoration = carouselItemDecoration;
        CarouselSnapHelper carouselSnapHelper = new CarouselSnapHelper(carouselLayoutManager);
        this.snapHelper = carouselSnapHelper;
        this.smoothScroller = new CenterSmoothScroller(context);
        context.getTheme().applyStyle(R.style.ThemeOverlay_ZendeskComponents_TextCellStyle, false);
        FrameLayout.inflate(context, R.layout.zuia_view_carousel_cell, this);
        getRecyclerView().setAdapter(carouselRecyclerViewAdapter);
        getRecyclerView().setLayoutManager(carouselLayoutManager);
        getRecyclerView().addItemDecoration(carouselItemDecoration);
        carouselSnapHelper.attachToRecyclerView(getRecyclerView());
        setUpNextAndPreviousButton();
    }

    private final RecyclerView getRecyclerView() {
        return (RecyclerView) this.recyclerView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final View getNextButton() {
        return (View) this.nextButton$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final View getPrevButton() {
        return (View) this.prevButton$delegate.getValue();
    }

    public void render(Function1<? super CarouselCellState, CarouselCellState> function1) {
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        this.state = function1.invoke(this.state);
        CarouselCellState copy$default = CarouselCellState.copy$default(this.state, CollectionsKt.plus(CollectionsKt.listOf(new CarouselCellData.Avatar(this.state.getAvatarImageState())), this.state.getCellData()), (AvatarImageState) null, (CarouselRendering) null, 6, (Object) null);
        this.state = copy$default;
        this.layoutManager.setItemMargin$zendesk_ui_ui_android(copy$default.getRendering().getMargin());
        this.adapter.swapData(this.state);
    }

    private final void setUpNextAndPreviousButton() {
        getNextButton().setOnClickListener(new CarouselCellView$$ExternalSyntheticLambda0(this));
        getPrevButton().setOnClickListener(new CarouselCellView$$ExternalSyntheticLambda1(this));
        getRecyclerView().addOnScrollListener(new CarouselCellView$setUpNextAndPreviousButton$3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpNextAndPreviousButton$lambda-0  reason: not valid java name */
    public static final void m2762setUpNextAndPreviousButton$lambda0(CarouselCellView carouselCellView, View view) {
        Intrinsics.checkNotNullParameter(carouselCellView, "this$0");
        int findLastCompletelyVisibleItemPosition = carouselCellView.layoutManager.findLastCompletelyVisibleItemPosition();
        int findLastVisibleItemPosition = carouselCellView.layoutManager.findLastVisibleItemPosition();
        if (findLastVisibleItemPosition == findLastCompletelyVisibleItemPosition) {
            findLastVisibleItemPosition = findLastCompletelyVisibleItemPosition + 1;
        }
        carouselCellView.smoothScroller.setTargetPosition(findLastVisibleItemPosition);
        if (findLastVisibleItemPosition < carouselCellView.adapter.getItemCount()) {
            carouselCellView.layoutManager.startSmoothScroll(carouselCellView.smoothScroller);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpNextAndPreviousButton$lambda-1  reason: not valid java name */
    public static final void m2763setUpNextAndPreviousButton$lambda1(CarouselCellView carouselCellView, View view) {
        Intrinsics.checkNotNullParameter(carouselCellView, "this$0");
        int findFirstCompletelyVisibleItemPosition = carouselCellView.layoutManager.findFirstCompletelyVisibleItemPosition();
        int findFirstVisibleItemPosition = carouselCellView.layoutManager.findFirstVisibleItemPosition();
        boolean z = true;
        if (findFirstVisibleItemPosition == findFirstCompletelyVisibleItemPosition) {
            findFirstVisibleItemPosition = findFirstCompletelyVisibleItemPosition - 1;
        }
        carouselCellView.smoothScroller.setTargetPosition(findFirstVisibleItemPosition);
        if (findFirstVisibleItemPosition < 0 && (!carouselCellView.adapter.hasAvatar() || findFirstVisibleItemPosition < 1)) {
            z = false;
        }
        if (z) {
            carouselCellView.layoutManager.startSmoothScroll(carouselCellView.smoothScroller);
        }
    }
}
