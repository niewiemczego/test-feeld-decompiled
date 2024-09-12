package zendesk.ui.android.conversation.carousel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import coil.ImageLoader;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.conversation.carousel.ArticleCarouselViewHolder;
import zendesk.ui.android.conversation.carousel.AvatarCarouselViewHolder;
import zendesk.ui.android.conversation.carousel.CarouselCellData;
import zendesk.ui.android.internal.ImageLoaderFactory;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012H\u0016J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lzendesk/ui/android/conversation/carousel/CarouselRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lzendesk/ui/android/conversation/carousel/CarouselViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "data", "Ljava/util/ArrayList;", "Lzendesk/ui/android/conversation/carousel/CarouselCellData;", "Lkotlin/collections/ArrayList;", "imageLoader", "Lcoil/ImageLoader;", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "rendering", "Lzendesk/ui/android/conversation/carousel/CarouselRendering;", "getItemCount", "", "getItemViewType", "position", "hasAvatar", "", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "swapData", "state", "Lzendesk/ui/android/conversation/carousel/CarouselCellState;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CarouselRecyclerViewAdapter.kt */
public final class CarouselRecyclerViewAdapter extends RecyclerView.Adapter<CarouselViewHolder> {
    private final ArrayList<CarouselCellData> data = new ArrayList<>();
    private final ImageLoader imageLoader;
    private final LayoutInflater layoutInflater;
    private CarouselRendering rendering = new CarouselRendering(0, 0, (Integer) null, false, 15, (DefaultConstructorMarker) null);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CarouselRecyclerViewAdapter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CarouselViewType.values().length];
            iArr[CarouselViewType.ITEM.ordinal()] = 1;
            iArr[CarouselViewType.AVATAR.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CarouselRecyclerViewAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.layoutInflater = LayoutInflater.from(context);
        this.imageLoader = ImageLoaderFactory.INSTANCE.getImageLoader(context);
    }

    public CarouselViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        int i2 = WhenMappings.$EnumSwitchMapping$0[CarouselViewType.values()[i].ordinal()];
        if (i2 == 1) {
            ArticleCarouselViewHolder.Companion companion = ArticleCarouselViewHolder.Companion;
            LayoutInflater layoutInflater2 = this.layoutInflater;
            Intrinsics.checkNotNullExpressionValue(layoutInflater2, "layoutInflater");
            return companion.create(layoutInflater2, viewGroup, this.imageLoader);
        } else if (i2 == 2) {
            AvatarCarouselViewHolder.Companion companion2 = AvatarCarouselViewHolder.Companion;
            LayoutInflater layoutInflater3 = this.layoutInflater;
            Intrinsics.checkNotNullExpressionValue(layoutInflater3, "layoutInflater");
            return companion2.create(layoutInflater3, viewGroup);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public void onBindViewHolder(CarouselViewHolder carouselViewHolder, int i) {
        Intrinsics.checkNotNullParameter(carouselViewHolder, "holder");
        if (carouselViewHolder instanceof ArticleCarouselViewHolder) {
            ((ArticleCarouselViewHolder) carouselViewHolder).bind(this.rendering, (CarouselCellData.Item) this.data.get(i));
        } else if (carouselViewHolder instanceof AvatarCarouselViewHolder) {
            ((AvatarCarouselViewHolder) carouselViewHolder).bind(this.rendering, (CarouselCellData.Avatar) this.data.get(i));
        }
    }

    public int getItemCount() {
        return this.data.size();
    }

    public int getItemViewType(int i) {
        if (i == -1) {
            return -1;
        }
        return this.data.get(i).getCarouselViewType().ordinal();
    }

    public final void swapData(CarouselCellState carouselCellState) {
        Intrinsics.checkNotNullParameter(carouselCellState, "state");
        this.data.clear();
        this.data.addAll(carouselCellState.getCellData());
        this.rendering = carouselCellState.getRendering();
        notifyItemRangeChanged(0, this.data.size());
    }

    public final boolean hasAvatar() {
        return CollectionsKt.firstOrNull(this.data) instanceof CarouselCellData.Avatar;
    }
}
