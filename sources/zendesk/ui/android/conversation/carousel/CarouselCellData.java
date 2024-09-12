package zendesk.ui.android.conversation.carousel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.conversation.avatar.AvatarImageState;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lzendesk/ui/android/conversation/carousel/CarouselCellData;", "", "carouselViewType", "Lzendesk/ui/android/conversation/carousel/CarouselViewType;", "(Lzendesk/ui/android/conversation/carousel/CarouselViewType;)V", "getCarouselViewType", "()Lzendesk/ui/android/conversation/carousel/CarouselViewType;", "Avatar", "Item", "Lzendesk/ui/android/conversation/carousel/CarouselCellData$Item;", "Lzendesk/ui/android/conversation/carousel/CarouselCellData$Avatar;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CarouselCellState.kt */
public abstract class CarouselCellData {
    private final CarouselViewType carouselViewType;

    public /* synthetic */ CarouselCellData(CarouselViewType carouselViewType2, DefaultConstructorMarker defaultConstructorMarker) {
        this(carouselViewType2);
    }

    private CarouselCellData(CarouselViewType carouselViewType2) {
        this.carouselViewType = carouselViewType2;
    }

    public final CarouselViewType getCarouselViewType() {
        return this.carouselViewType;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003JC\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001e"}, d2 = {"Lzendesk/ui/android/conversation/carousel/CarouselCellData$Item;", "Lzendesk/ui/android/conversation/carousel/CarouselCellData;", "title", "", "description", "mediaUrl", "mediaType", "action", "Lzendesk/ui/android/conversation/carousel/CarouselCellAction;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzendesk/ui/android/conversation/carousel/CarouselCellAction;)V", "getAction", "()Lzendesk/ui/android/conversation/carousel/CarouselCellAction;", "getDescription", "()Ljava/lang/String;", "getMediaType", "getMediaUrl", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CarouselCellState.kt */
    public static final class Item extends CarouselCellData {
        private final CarouselCellAction action;
        private final String description;
        private final String mediaType;
        private final String mediaUrl;
        private final String title;

        public static /* synthetic */ Item copy$default(Item item, String str, String str2, String str3, String str4, CarouselCellAction carouselCellAction, int i, Object obj) {
            if ((i & 1) != 0) {
                str = item.title;
            }
            if ((i & 2) != 0) {
                str2 = item.description;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = item.mediaUrl;
            }
            String str6 = str3;
            if ((i & 8) != 0) {
                str4 = item.mediaType;
            }
            String str7 = str4;
            if ((i & 16) != 0) {
                carouselCellAction = item.action;
            }
            return item.copy(str, str5, str6, str7, carouselCellAction);
        }

        public final String component1() {
            return this.title;
        }

        public final String component2() {
            return this.description;
        }

        public final String component3() {
            return this.mediaUrl;
        }

        public final String component4() {
            return this.mediaType;
        }

        public final CarouselCellAction component5() {
            return this.action;
        }

        public final Item copy(String str, String str2, String str3, String str4, CarouselCellAction carouselCellAction) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new Item(str, str2, str3, str4, carouselCellAction);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return Intrinsics.areEqual((Object) this.title, (Object) item.title) && Intrinsics.areEqual((Object) this.description, (Object) item.description) && Intrinsics.areEqual((Object) this.mediaUrl, (Object) item.mediaUrl) && Intrinsics.areEqual((Object) this.mediaType, (Object) item.mediaType) && Intrinsics.areEqual((Object) this.action, (Object) item.action);
        }

        public int hashCode() {
            int hashCode = this.title.hashCode() * 31;
            String str = this.description;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.mediaUrl;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.mediaType;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            CarouselCellAction carouselCellAction = this.action;
            if (carouselCellAction != null) {
                i = carouselCellAction.hashCode();
            }
            return hashCode4 + i;
        }

        public String toString() {
            return "Item(title=" + this.title + ", description=" + this.description + ", mediaUrl=" + this.mediaUrl + ", mediaType=" + this.mediaType + ", action=" + this.action + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Item(String str, String str2, String str3, String str4, CarouselCellAction carouselCellAction, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : carouselCellAction);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getMediaUrl() {
            return this.mediaUrl;
        }

        public final String getMediaType() {
            return this.mediaType;
        }

        public final CarouselCellAction getAction() {
            return this.action;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Item(String str, String str2, String str3, String str4, CarouselCellAction carouselCellAction) {
            super(CarouselViewType.ITEM, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.description = str2;
            this.mediaUrl = str3;
            this.mediaType = str4;
            this.action = carouselCellAction;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/ui/android/conversation/carousel/CarouselCellData$Avatar;", "Lzendesk/ui/android/conversation/carousel/CarouselCellData;", "avatarImageState", "Lzendesk/ui/android/conversation/avatar/AvatarImageState;", "(Lzendesk/ui/android/conversation/avatar/AvatarImageState;)V", "getAvatarImageState", "()Lzendesk/ui/android/conversation/avatar/AvatarImageState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CarouselCellState.kt */
    public static final class Avatar extends CarouselCellData {
        private final AvatarImageState avatarImageState;

        public static /* synthetic */ Avatar copy$default(Avatar avatar, AvatarImageState avatarImageState2, int i, Object obj) {
            if ((i & 1) != 0) {
                avatarImageState2 = avatar.avatarImageState;
            }
            return avatar.copy(avatarImageState2);
        }

        public final AvatarImageState component1() {
            return this.avatarImageState;
        }

        public final Avatar copy(AvatarImageState avatarImageState2) {
            return new Avatar(avatarImageState2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Avatar) && Intrinsics.areEqual((Object) this.avatarImageState, (Object) ((Avatar) obj).avatarImageState);
        }

        public int hashCode() {
            AvatarImageState avatarImageState2 = this.avatarImageState;
            if (avatarImageState2 == null) {
                return 0;
            }
            return avatarImageState2.hashCode();
        }

        public String toString() {
            return "Avatar(avatarImageState=" + this.avatarImageState + ')';
        }

        public final AvatarImageState getAvatarImageState() {
            return this.avatarImageState;
        }

        public Avatar(AvatarImageState avatarImageState2) {
            super(CarouselViewType.AVATAR, (DefaultConstructorMarker) null);
            this.avatarImageState = avatarImageState2;
        }
    }
}
