package com.adapty.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.adapty.internal.crossplatform.AdaptyPaywallTypeAdapterFactory;
import com.adapty.internal.utils.InternalAdaptyApi;
import com.braze.models.FeatureFlag;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\b%&'()*+,Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000b¢\u0006\u0002\u0010\u0011J!\u0010\u001b\u001a\u0004\u0018\u0001H\u001c\"\b\b\u0000\u0010\u001c*\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u0003H\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020\u0003H\u0007J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0003H\u0007R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0014R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0013¨\u0006-"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration;", "", "id", "", "isHard", "", "templateId", "mainImageRelativeHeight", "", "defaultLocalization", "assets", "", "Lcom/adapty/models/AdaptyViewConfiguration$Asset;", "localizations", "Lcom/adapty/models/AdaptyViewConfiguration$Localization;", "styles", "Lcom/adapty/models/AdaptyViewConfiguration$Style;", "(Ljava/lang/String;ZLjava/lang/String;FLjava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "()Z", "getMainImageRelativeHeight$annotations", "()V", "getMainImageRelativeHeight", "()F", "getTemplateId$annotations", "getTemplateId", "getAsset", "T", "assetId", "(Ljava/lang/String;)Lcom/adapty/models/AdaptyViewConfiguration$Asset;", "getString", "Lcom/adapty/models/AdaptyViewConfiguration$Localization$Str;", "strId", "getStyle", "styleId", "hasStyle", "Asset", "Component", "FeatureBlock", "FooterBlock", "HorizontalAlign", "Localization", "ProductBlock", "Style", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyViewConfiguration.kt */
public final class AdaptyViewConfiguration {
    private final Map<String, Asset> assets;
    private final String defaultLocalization;
    private final String id;
    private final boolean isHard;
    private final Map<String, Localization> localizations;
    private final float mainImageRelativeHeight;
    private final Map<String, Style> styles;
    private final String templateId;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$HorizontalAlign;", "", "(Ljava/lang/String;I)V", "LEFT", "CENTER", "RIGHT", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyViewConfiguration.kt */
    public enum HorizontalAlign {
        LEFT,
        CENTER,
        RIGHT
    }

    @InternalAdaptyApi
    public static /* synthetic */ void getMainImageRelativeHeight$annotations() {
    }

    @InternalAdaptyApi
    public static /* synthetic */ void getTemplateId$annotations() {
    }

    public AdaptyViewConfiguration(String str, boolean z, String str2, float f, String str3, Map<String, ? extends Asset> map, Map<String, Localization> map2, Map<String, Style> map3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(map, "assets");
        Intrinsics.checkNotNullParameter(map2, "localizations");
        Intrinsics.checkNotNullParameter(map3, "styles");
        this.id = str;
        this.isHard = z;
        this.templateId = str2;
        this.mainImageRelativeHeight = f;
        this.defaultLocalization = str3;
        this.assets = map;
        this.localizations = map2;
        this.styles = map3;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean isHard() {
        return this.isHard;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final float getMainImageRelativeHeight() {
        return this.mainImageRelativeHeight;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Style;", "", "featureBlock", "Lcom/adapty/models/AdaptyViewConfiguration$FeatureBlock;", "productBlock", "Lcom/adapty/models/AdaptyViewConfiguration$ProductBlock;", "footerBlock", "Lcom/adapty/models/AdaptyViewConfiguration$FooterBlock;", "items", "", "", "Lcom/adapty/models/AdaptyViewConfiguration$Component;", "(Lcom/adapty/models/AdaptyViewConfiguration$FeatureBlock;Lcom/adapty/models/AdaptyViewConfiguration$ProductBlock;Lcom/adapty/models/AdaptyViewConfiguration$FooterBlock;Ljava/util/Map;)V", "getFeatureBlock", "()Lcom/adapty/models/AdaptyViewConfiguration$FeatureBlock;", "getFooterBlock", "()Lcom/adapty/models/AdaptyViewConfiguration$FooterBlock;", "getItems", "()Ljava/util/Map;", "getProductBlock", "()Lcom/adapty/models/AdaptyViewConfiguration$ProductBlock;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyViewConfiguration.kt */
    public static final class Style {
        private final FeatureBlock featureBlock;
        private final FooterBlock footerBlock;
        private final Map<String, Component> items;
        private final ProductBlock productBlock;

        public Style(FeatureBlock featureBlock2, ProductBlock productBlock2, FooterBlock footerBlock2, Map<String, ? extends Component> map) {
            Intrinsics.checkNotNullParameter(productBlock2, "productBlock");
            Intrinsics.checkNotNullParameter(map, FirebaseAnalytics.Param.ITEMS);
            this.featureBlock = featureBlock2;
            this.productBlock = productBlock2;
            this.footerBlock = footerBlock2;
            this.items = map;
        }

        public final FeatureBlock getFeatureBlock() {
            return this.featureBlock;
        }

        public final ProductBlock getProductBlock() {
            return this.productBlock;
        }

        public final FooterBlock getFooterBlock() {
            return this.footerBlock;
        }

        public final Map<String, Component> getItems() {
            return this.items;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$FeatureBlock;", "", "type", "Lcom/adapty/models/AdaptyViewConfiguration$FeatureBlock$Type;", "orderedItems", "", "Lcom/adapty/models/AdaptyViewConfiguration$Component;", "(Lcom/adapty/models/AdaptyViewConfiguration$FeatureBlock$Type;Ljava/util/List;)V", "getOrderedItems", "()Ljava/util/List;", "getType", "()Lcom/adapty/models/AdaptyViewConfiguration$FeatureBlock$Type;", "Type", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyViewConfiguration.kt */
    public static final class FeatureBlock {
        private final List<Component> orderedItems;
        private final Type type;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$FeatureBlock$Type;", "", "(Ljava/lang/String;I)V", "LIST", "TIMELINE", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyViewConfiguration.kt */
        public enum Type {
            LIST,
            TIMELINE
        }

        public FeatureBlock(Type type2, List<? extends Component> list) {
            Intrinsics.checkNotNullParameter(type2, "type");
            Intrinsics.checkNotNullParameter(list, "orderedItems");
            this.type = type2;
            this.orderedItems = list;
        }

        public final Type getType() {
            return this.type;
        }

        public final List<Component> getOrderedItems() {
            return this.orderedItems;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\u0015B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$ProductBlock;", "", "type", "Lcom/adapty/models/AdaptyViewConfiguration$ProductBlock$Type;", "mainProductIndex", "", "initiatePurchaseOnTap", "", "products", "", "", "Lcom/adapty/models/AdaptyViewConfiguration$Component$ProductObject;", "(Lcom/adapty/models/AdaptyViewConfiguration$ProductBlock$Type;IZLjava/util/Map;)V", "getInitiatePurchaseOnTap", "()Z", "getMainProductIndex", "()I", "getProducts", "()Ljava/util/Map;", "getType", "()Lcom/adapty/models/AdaptyViewConfiguration$ProductBlock$Type;", "Type", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyViewConfiguration.kt */
    public static final class ProductBlock {
        private final boolean initiatePurchaseOnTap;
        private final int mainProductIndex;
        private final Map<String, Component.ProductObject> products;
        private final Type type;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$ProductBlock$Type;", "", "(Ljava/lang/String;I)V", "SINGLE", "VERTICAL", "HORIZONTAL", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyViewConfiguration.kt */
        public enum Type {
            SINGLE,
            VERTICAL,
            HORIZONTAL
        }

        public ProductBlock(Type type2, int i, boolean z, Map<String, Component.ProductObject> map) {
            Intrinsics.checkNotNullParameter(type2, "type");
            Intrinsics.checkNotNullParameter(map, AdaptyPaywallTypeAdapterFactory.PRODUCTS);
            this.type = type2;
            this.mainProductIndex = i;
            this.initiatePurchaseOnTap = z;
            this.products = map;
        }

        public final Type getType() {
            return this.type;
        }

        public final int getMainProductIndex() {
            return this.mainProductIndex;
        }

        public final boolean getInitiatePurchaseOnTap() {
            return this.initiatePurchaseOnTap;
        }

        public final Map<String, Component.ProductObject> getProducts() {
            return this.products;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$FooterBlock;", "", "orderedItems", "", "Lcom/adapty/models/AdaptyViewConfiguration$Component;", "(Ljava/util/List;)V", "getOrderedItems", "()Ljava/util/List;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyViewConfiguration.kt */
    public static final class FooterBlock {
        private final List<Component> orderedItems;

        public FooterBlock(List<? extends Component> list) {
            Intrinsics.checkNotNullParameter(list, "orderedItems");
            this.orderedItems = list;
        }

        public final List<Component> getOrderedItems() {
            return this.orderedItems;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component;", "", "()V", "Button", "CustomObject", "ProductObject", "Reference", "Shape", "Text", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Button;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$CustomObject;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$ProductObject;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Reference;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyViewConfiguration.kt */
    public static abstract class Component {
        public /* synthetic */ Component(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Component() {
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Text;", "Lcom/adapty/models/AdaptyViewConfiguration$Component;", "horizontalAlign", "Lcom/adapty/models/AdaptyViewConfiguration$HorizontalAlign;", "(Lcom/adapty/models/AdaptyViewConfiguration$HorizontalAlign;)V", "getHorizontalAlign", "()Lcom/adapty/models/AdaptyViewConfiguration$HorizontalAlign;", "Item", "Multiple", "Single", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Multiple;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Single;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyViewConfiguration.kt */
        public static abstract class Text extends Component {
            private final HorizontalAlign horizontalAlign;

            public /* synthetic */ Text(HorizontalAlign horizontalAlign2, DefaultConstructorMarker defaultConstructorMarker) {
                this(horizontalAlign2);
            }

            public final HorizontalAlign getHorizontalAlign() {
                return this.horizontalAlign;
            }

            private Text(HorizontalAlign horizontalAlign2) {
                super((DefaultConstructorMarker) null);
                this.horizontalAlign = horizontalAlign2;
            }

            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Single;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text;", "stringId", "", "fontId", "size", "", "textColorId", "horizontalAlign", "Lcom/adapty/models/AdaptyViewConfiguration$HorizontalAlign;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Lcom/adapty/models/AdaptyViewConfiguration$HorizontalAlign;)V", "getFontId", "()Ljava/lang/String;", "getSize", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getStringId", "getTextColorId", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AdaptyViewConfiguration.kt */
            public static final class Single extends Text {
                private final String fontId;
                private final Float size;
                private final String stringId;
                private final String textColorId;

                public final String getStringId() {
                    return this.stringId;
                }

                public final String getFontId() {
                    return this.fontId;
                }

                public final Float getSize() {
                    return this.size;
                }

                public final String getTextColorId() {
                    return this.textColorId;
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Single(String str, String str2, Float f, String str3, HorizontalAlign horizontalAlign) {
                    super(horizontalAlign, (DefaultConstructorMarker) null);
                    Intrinsics.checkNotNullParameter(str, "stringId");
                    Intrinsics.checkNotNullParameter(str2, "fontId");
                    Intrinsics.checkNotNullParameter(horizontalAlign, "horizontalAlign");
                    this.stringId = str;
                    this.fontId = str2;
                    this.size = f;
                    this.textColorId = str3;
                }
            }

            @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Multiple;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text;", "items", "", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item;", "horizontalAlign", "Lcom/adapty/models/AdaptyViewConfiguration$HorizontalAlign;", "(Ljava/util/List;Lcom/adapty/models/AdaptyViewConfiguration$HorizontalAlign;)V", "getItems", "()Ljava/util/List;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AdaptyViewConfiguration.kt */
            public static final class Multiple extends Text {
                private final List<Item> items;

                public final List<Item> getItems() {
                    return this.items;
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Multiple(List<? extends Item> list, HorizontalAlign horizontalAlign) {
                    super(horizontalAlign, (DefaultConstructorMarker) null);
                    Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
                    Intrinsics.checkNotNullParameter(horizontalAlign, "horizontalAlign");
                    this.items = list;
                }
            }

            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item;", "", "()V", "BulletedText", "Image", "NewLine", "Space", "Text", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$BulletedText;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$Image;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$NewLine;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$Space;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$Text;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AdaptyViewConfiguration.kt */
            public static abstract class Item {
                public /* synthetic */ Item(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Item() {
                }

                @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$Text;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item;", "stringId", "", "fontId", "size", "", "textColorId", "horizontalAlign", "Lcom/adapty/models/AdaptyViewConfiguration$HorizontalAlign;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Lcom/adapty/models/AdaptyViewConfiguration$HorizontalAlign;)V", "getFontId", "()Ljava/lang/String;", "getHorizontalAlign", "()Lcom/adapty/models/AdaptyViewConfiguration$HorizontalAlign;", "getSize", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getStringId", "getTextColorId", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                /* renamed from: com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$Text  reason: collision with other inner class name */
                /* compiled from: AdaptyViewConfiguration.kt */
                public static final class C0025Text extends Item {
                    private final String fontId;
                    private final HorizontalAlign horizontalAlign;
                    private final Float size;
                    private final String stringId;
                    private final String textColorId;

                    public final String getStringId() {
                        return this.stringId;
                    }

                    public final String getFontId() {
                        return this.fontId;
                    }

                    public final Float getSize() {
                        return this.size;
                    }

                    public final String getTextColorId() {
                        return this.textColorId;
                    }

                    public final HorizontalAlign getHorizontalAlign() {
                        return this.horizontalAlign;
                    }

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public C0025Text(String str, String str2, Float f, String str3, HorizontalAlign horizontalAlign2) {
                        super((DefaultConstructorMarker) null);
                        Intrinsics.checkNotNullParameter(str, "stringId");
                        Intrinsics.checkNotNullParameter(str2, "fontId");
                        Intrinsics.checkNotNullParameter(horizontalAlign2, "horizontalAlign");
                        this.stringId = str;
                        this.fontId = str2;
                        this.size = f;
                        this.textColorId = str3;
                        this.horizontalAlign = horizontalAlign2;
                    }
                }

                @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$Image;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item;", "imageId", "", "tintColorId", "width", "", "height", "(Ljava/lang/String;Ljava/lang/String;FF)V", "getHeight", "()F", "getImageId", "()Ljava/lang/String;", "getTintColorId", "getWidth", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                /* compiled from: AdaptyViewConfiguration.kt */
                public static final class Image extends Item {
                    private final float height;
                    private final String imageId;
                    private final String tintColorId;
                    private final float width;

                    public final String getImageId() {
                        return this.imageId;
                    }

                    public final String getTintColorId() {
                        return this.tintColorId;
                    }

                    public final float getWidth() {
                        return this.width;
                    }

                    public final float getHeight() {
                        return this.height;
                    }

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public Image(String str, String str2, float f, float f2) {
                        super((DefaultConstructorMarker) null);
                        Intrinsics.checkNotNullParameter(str, "imageId");
                        this.imageId = str;
                        this.tintColorId = str2;
                        this.width = f;
                        this.height = f2;
                    }
                }

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$NewLine;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item;", "()V", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                /* compiled from: AdaptyViewConfiguration.kt */
                public static final class NewLine extends Item {
                    public static final NewLine INSTANCE = new NewLine();

                    private NewLine() {
                        super((DefaultConstructorMarker) null);
                    }
                }

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$Space;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item;", "value", "", "(F)V", "getValue", "()F", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                /* compiled from: AdaptyViewConfiguration.kt */
                public static final class Space extends Item {
                    private final float value;

                    public Space(float f) {
                        super((DefaultConstructorMarker) null);
                        this.value = f;
                    }

                    public final float getValue() {
                        return this.value;
                    }
                }

                @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$BulletedText;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item;", "bullet", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$BulletedText$Bullet;", "space", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$Space;", "text", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$Text;", "(Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$BulletedText$Bullet;Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$Space;Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$Text;)V", "getBullet", "()Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$BulletedText$Bullet;", "getSpace", "()Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$Space;", "getText", "()Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$Text;", "Bullet", "ImageBullet", "TextBullet", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                /* compiled from: AdaptyViewConfiguration.kt */
                public static final class BulletedText extends Item {
                    private final Bullet bullet;
                    private final Space space;
                    private final C0025Text text;

                    public final Bullet getBullet() {
                        return this.bullet;
                    }

                    public final Space getSpace() {
                        return this.space;
                    }

                    public final C0025Text getText() {
                        return this.text;
                    }

                    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$BulletedText$Bullet;", "", "()V", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$BulletedText$ImageBullet;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$BulletedText$TextBullet;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                    /* compiled from: AdaptyViewConfiguration.kt */
                    public static abstract class Bullet {
                        public /* synthetic */ Bullet(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Bullet() {
                        }
                    }

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public BulletedText(Bullet bullet2, Space space2, C0025Text text2) {
                        super((DefaultConstructorMarker) null);
                        Intrinsics.checkNotNullParameter(bullet2, "bullet");
                        Intrinsics.checkNotNullParameter(text2, "text");
                        this.bullet = bullet2;
                        this.space = space2;
                        this.text = text2;
                    }

                    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$BulletedText$ImageBullet;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$BulletedText$Bullet;", "image", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$Image;", "(Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$Image;)V", "getImage", "()Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$Image;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                    /* compiled from: AdaptyViewConfiguration.kt */
                    public static final class ImageBullet extends Bullet {
                        private final Image image;

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public ImageBullet(Image image2) {
                            super((DefaultConstructorMarker) null);
                            Intrinsics.checkNotNullParameter(image2, "image");
                            this.image = image2;
                        }

                        public final Image getImage() {
                            return this.image;
                        }
                    }

                    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$BulletedText$TextBullet;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$BulletedText$Bullet;", "text", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$Text;", "(Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$Text;)V", "getText", "()Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item$Text;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                    /* compiled from: AdaptyViewConfiguration.kt */
                    public static final class TextBullet extends Bullet {
                        private final C0025Text text;

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public TextBullet(C0025Text text2) {
                            super((DefaultConstructorMarker) null);
                            Intrinsics.checkNotNullParameter(text2, "text");
                            this.text = text2;
                        }

                        public final C0025Text getText() {
                            return this.text;
                        }
                    }
                }
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape;", "Lcom/adapty/models/AdaptyViewConfiguration$Component;", "backgroundAssetId", "", "type", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$Type;", "border", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$Border;", "(Ljava/lang/String;Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$Type;Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$Border;)V", "getBackgroundAssetId", "()Ljava/lang/String;", "getBorder", "()Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$Border;", "getType", "()Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$Type;", "Border", "CornerRadius", "Type", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyViewConfiguration.kt */
        public static final class Shape extends Component {
            private final String backgroundAssetId;
            private final Border border;
            private final Type type;

            public final String getBackgroundAssetId() {
                return this.backgroundAssetId;
            }

            public final Type getType() {
                return this.type;
            }

            public final Border getBorder() {
                return this.border;
            }

            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$Type;", "", "()V", "Circle", "RectWithArc", "Rectangle", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$Type$Circle;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$Type$RectWithArc;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$Type$Rectangle;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AdaptyViewConfiguration.kt */
            public static abstract class Type {
                public /* synthetic */ Type(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$Type$Rectangle;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$Type;", "cornerRadius", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$CornerRadius;", "(Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$CornerRadius;)V", "getCornerRadius", "()Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$CornerRadius;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                /* compiled from: AdaptyViewConfiguration.kt */
                public static final class Rectangle extends Type {
                    private final CornerRadius cornerRadius;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public Rectangle(CornerRadius cornerRadius2) {
                        super((DefaultConstructorMarker) null);
                        Intrinsics.checkNotNullParameter(cornerRadius2, "cornerRadius");
                        this.cornerRadius = cornerRadius2;
                    }

                    public final CornerRadius getCornerRadius() {
                        return this.cornerRadius;
                    }
                }

                private Type() {
                }

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$Type$Circle;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$Type;", "()V", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                /* compiled from: AdaptyViewConfiguration.kt */
                public static final class Circle extends Type {
                    public static final Circle INSTANCE = new Circle();

                    private Circle() {
                        super((DefaultConstructorMarker) null);
                    }
                }

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$Type$RectWithArc;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$Type;", "arcHeight", "", "(F)V", "getArcHeight", "()F", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                /* compiled from: AdaptyViewConfiguration.kt */
                public static final class RectWithArc extends Type {
                    public static final float ABS_ARC_HEIGHT = 20.0f;
                    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
                    private final float arcHeight;

                    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$Type$RectWithArc$Companion;", "", "()V", "ABS_ARC_HEIGHT", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                    /* compiled from: AdaptyViewConfiguration.kt */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }
                    }

                    public RectWithArc(float f) {
                        super((DefaultConstructorMarker) null);
                        this.arcHeight = f;
                    }

                    public final float getArcHeight() {
                        return this.arcHeight;
                    }
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Shape(String str, Type type2, Border border2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(type2, "type");
                this.backgroundAssetId = str;
                this.type = type2;
                this.border = border2;
            }

            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$CornerRadius;", "", "()V", "Different", "None", "Same", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$CornerRadius$Different;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$CornerRadius$None;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$CornerRadius$Same;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AdaptyViewConfiguration.kt */
            public static abstract class CornerRadius {
                public /* synthetic */ CornerRadius(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$CornerRadius$None;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$CornerRadius;", "()V", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                /* compiled from: AdaptyViewConfiguration.kt */
                public static final class None extends CornerRadius {
                    public static final None INSTANCE = new None();

                    private None() {
                        super((DefaultConstructorMarker) null);
                    }
                }

                private CornerRadius() {
                }

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$CornerRadius$Same;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$CornerRadius;", "value", "", "(F)V", "getValue", "()F", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                /* compiled from: AdaptyViewConfiguration.kt */
                public static final class Same extends CornerRadius {
                    private final float value;

                    public Same(float f) {
                        super((DefaultConstructorMarker) null);
                        this.value = f;
                    }

                    public final float getValue() {
                        return this.value;
                    }
                }

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$CornerRadius$Different;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$CornerRadius;", "topLeft", "", "topRight", "bottomRight", "bottomLeft", "(FFFF)V", "getBottomLeft", "()F", "getBottomRight", "getTopLeft", "getTopRight", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                /* compiled from: AdaptyViewConfiguration.kt */
                public static final class Different extends CornerRadius {
                    private final float bottomLeft;
                    private final float bottomRight;
                    private final float topLeft;
                    private final float topRight;

                    public final float getTopLeft() {
                        return this.topLeft;
                    }

                    public final float getTopRight() {
                        return this.topRight;
                    }

                    public final float getBottomRight() {
                        return this.bottomRight;
                    }

                    public final float getBottomLeft() {
                        return this.bottomLeft;
                    }

                    public Different(float f, float f2, float f3, float f4) {
                        super((DefaultConstructorMarker) null);
                        this.topLeft = f;
                        this.topRight = f2;
                        this.bottomRight = f3;
                        this.bottomLeft = f4;
                    }
                }
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape$Border;", "", "assetId", "", "thickness", "", "(Ljava/lang/String;F)V", "getAssetId", "()Ljava/lang/String;", "getThickness", "()F", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AdaptyViewConfiguration.kt */
            public static final class Border {
                private final String assetId;
                private final float thickness;

                public Border(String str, float f) {
                    Intrinsics.checkNotNullParameter(str, "assetId");
                    this.assetId = str;
                    this.thickness = f;
                }

                public final String getAssetId() {
                    return this.assetId;
                }

                public final float getThickness() {
                    return this.thickness;
                }
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0003\u001e\u001f BQ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Button;", "Lcom/adapty/models/AdaptyViewConfiguration$Component;", "shape", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape;", "selectedShape", "title", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text;", "selectedTitle", "align", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Align;", "action", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Action;", "isVisible", "", "transitionIn", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Transition;", "(Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape;Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape;Lcom/adapty/models/AdaptyViewConfiguration$Component$Text;Lcom/adapty/models/AdaptyViewConfiguration$Component$Text;Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Align;Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Action;ZLcom/adapty/models/AdaptyViewConfiguration$Component$Button$Transition;)V", "getAction", "()Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Action;", "getAlign", "()Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Align;", "()Z", "getSelectedShape", "()Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape;", "getSelectedTitle", "()Lcom/adapty/models/AdaptyViewConfiguration$Component$Text;", "getShape", "getTitle", "getTransitionIn", "()Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Transition;", "Action", "Align", "Transition", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyViewConfiguration.kt */
        public static final class Button extends Component {
            private final Action action;
            private final Align align;
            private final boolean isVisible;
            private final Shape selectedShape;
            private final Text selectedTitle;
            private final Shape shape;
            private final Text title;
            private final Transition transitionIn;

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Align;", "", "(Ljava/lang/String;I)V", "LEADING", "TRAILING", "CENTER", "FILL", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AdaptyViewConfiguration.kt */
            public enum Align {
                LEADING,
                TRAILING,
                CENTER,
                FILL
            }

            public final Shape getShape() {
                return this.shape;
            }

            public final Shape getSelectedShape() {
                return this.selectedShape;
            }

            public final Text getTitle() {
                return this.title;
            }

            public final Text getSelectedTitle() {
                return this.selectedTitle;
            }

            public final Align getAlign() {
                return this.align;
            }

            public final Action getAction() {
                return this.action;
            }

            public final boolean isVisible() {
                return this.isVisible;
            }

            public final Transition getTransitionIn() {
                return this.transitionIn;
            }

            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Action;", "", "()V", "Close", "Custom", "OpenUrl", "Restore", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Action$Close;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Action$Custom;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Action$OpenUrl;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Action$Restore;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AdaptyViewConfiguration.kt */
            public static abstract class Action {
                public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Action$Close;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Action;", "()V", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                /* compiled from: AdaptyViewConfiguration.kt */
                public static final class Close extends Action {
                    public static final Close INSTANCE = new Close();

                    private Close() {
                        super((DefaultConstructorMarker) null);
                    }
                }

                private Action() {
                }

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Action$Restore;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Action;", "()V", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                /* compiled from: AdaptyViewConfiguration.kt */
                public static final class Restore extends Action {
                    public static final Restore INSTANCE = new Restore();

                    private Restore() {
                        super((DefaultConstructorMarker) null);
                    }
                }

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Action$OpenUrl;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Action;", "urlId", "", "(Ljava/lang/String;)V", "getUrlId", "()Ljava/lang/String;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                /* compiled from: AdaptyViewConfiguration.kt */
                public static final class OpenUrl extends Action {
                    private final String urlId;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public OpenUrl(String str) {
                        super((DefaultConstructorMarker) null);
                        Intrinsics.checkNotNullParameter(str, "urlId");
                        this.urlId = str;
                    }

                    public final String getUrlId() {
                        return this.urlId;
                    }
                }

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Action$Custom;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Action;", "customId", "", "(Ljava/lang/String;)V", "getCustomId", "()Ljava/lang/String;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                /* compiled from: AdaptyViewConfiguration.kt */
                public static final class Custom extends Action {
                    private final String customId;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public Custom(String str) {
                        super((DefaultConstructorMarker) null);
                        Intrinsics.checkNotNullParameter(str, "customId");
                        this.customId = str;
                    }

                    public final String getCustomId() {
                        return this.customId;
                    }
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Button(Shape shape2, Shape shape3, Text text, Text text2, Align align2, Action action2, boolean z, Transition transition) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(align2, "align");
                this.shape = shape2;
                this.selectedShape = shape3;
                this.title = text;
                this.selectedTitle = text2;
                this.align = align2;
                this.action = action2;
                this.isVisible = z;
                this.transitionIn = transition;
            }

            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\rB\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u0001\u0001\u000e¨\u0006\u000f"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Transition;", "", "durationMillis", "", "startDelayMillis", "interpolatorName", "", "(JJLjava/lang/String;)V", "getDurationMillis", "()J", "getInterpolatorName", "()Ljava/lang/String;", "getStartDelayMillis", "Fade", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Transition$Fade;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AdaptyViewConfiguration.kt */
            public static abstract class Transition {
                private final long durationMillis;
                private final String interpolatorName;
                private final long startDelayMillis;

                public /* synthetic */ Transition(long j, long j2, String str, DefaultConstructorMarker defaultConstructorMarker) {
                    this(j, j2, str);
                }

                private Transition(long j, long j2, String str) {
                    this.durationMillis = j;
                    this.startDelayMillis = j2;
                    this.interpolatorName = str;
                }

                public final long getDurationMillis() {
                    return this.durationMillis;
                }

                public final long getStartDelayMillis() {
                    return this.startDelayMillis;
                }

                public final String getInterpolatorName() {
                    return this.interpolatorName;
                }

                @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Transition$Fade;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Transition;", "durationMillis", "", "startDelayMillis", "interpolatorName", "", "(JJLjava/lang/String;)V", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                /* compiled from: AdaptyViewConfiguration.kt */
                public static final class Fade extends Transition {
                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public Fade(long j, long j2, String str) {
                        super(j, j2, str, (DefaultConstructorMarker) null);
                        Intrinsics.checkNotNullParameter(str, "interpolatorName");
                    }
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$Reference;", "Lcom/adapty/models/AdaptyViewConfiguration$Component;", "assetId", "", "(Ljava/lang/String;)V", "getAssetId", "()Ljava/lang/String;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyViewConfiguration.kt */
        public static final class Reference extends Component {
            private final String assetId;

            public final String getAssetId() {
                return this.assetId;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Reference(String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "assetId");
                this.assetId = str;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$ProductObject;", "Lcom/adapty/models/AdaptyViewConfiguration$Component;", "productId", "", "properties", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getProductId", "()Ljava/lang/String;", "getProperties", "()Ljava/util/Map;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyViewConfiguration.kt */
        public static final class ProductObject extends Component {
            private final String productId;
            private final Map<String, Component> properties;

            public final String getProductId() {
                return this.productId;
            }

            public final Map<String, Component> getProperties() {
                return this.properties;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ProductObject(String str, Map<String, ? extends Component> map) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "productId");
                Intrinsics.checkNotNullParameter(map, FeatureFlag.PROPERTIES);
                this.productId = str;
                this.properties = map;
            }
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007R#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Component$CustomObject;", "Lcom/adapty/models/AdaptyViewConfiguration$Component;", "type", "", "properties", "", "Lkotlin/Pair;", "(Ljava/lang/String;Ljava/util/List;)V", "getProperties", "()Ljava/util/List;", "getType", "()Ljava/lang/String;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyViewConfiguration.kt */
        public static final class CustomObject extends Component {
            private final List<Pair<String, Component>> properties;
            private final String type;

            public final String getType() {
                return this.type;
            }

            public final List<Pair<String, Component>> getProperties() {
                return this.properties;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CustomObject(String str, List<? extends Pair<String, ? extends Component>> list) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "type");
                Intrinsics.checkNotNullParameter(list, FeatureFlag.PROPERTIES);
                this.type = str;
                this.properties = list;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Asset;", "", "()V", "Color", "Filling", "Font", "Gradient", "Image", "Lcom/adapty/models/AdaptyViewConfiguration$Asset$Filling;", "Lcom/adapty/models/AdaptyViewConfiguration$Asset$Font;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyViewConfiguration.kt */
    public static abstract class Asset {
        public /* synthetic */ Asset(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Asset() {
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Asset$Color;", "Lcom/adapty/models/AdaptyViewConfiguration$Asset$Filling;", "value", "", "(I)V", "getValue", "()I", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyViewConfiguration.kt */
        public static final class Color extends Filling {
            private final int value;

            public final int getValue() {
                return this.value;
            }

            public Color(int i) {
                super((DefaultConstructorMarker) null);
                this.value = i;
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0003\u0018\u0019\u001aB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Asset$Gradient;", "Lcom/adapty/models/AdaptyViewConfiguration$Asset$Filling;", "type", "Lcom/adapty/models/AdaptyViewConfiguration$Asset$Gradient$Type;", "values", "", "Lcom/adapty/models/AdaptyViewConfiguration$Asset$Gradient$Value;", "points", "Lcom/adapty/models/AdaptyViewConfiguration$Asset$Gradient$Points;", "(Lcom/adapty/models/AdaptyViewConfiguration$Asset$Gradient$Type;Ljava/util/List;Lcom/adapty/models/AdaptyViewConfiguration$Asset$Gradient$Points;)V", "colors", "", "getColors", "()[I", "getPoints", "()Lcom/adapty/models/AdaptyViewConfiguration$Asset$Gradient$Points;", "positions", "", "getPositions", "()[F", "getType", "()Lcom/adapty/models/AdaptyViewConfiguration$Asset$Gradient$Type;", "getValues", "()Ljava/util/List;", "Points", "Type", "Value", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyViewConfiguration.kt */
        public static final class Gradient extends Filling {
            private final Points points;
            private final Type type;
            private final List<Value> values;

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Asset$Gradient$Type;", "", "(Ljava/lang/String;I)V", "LINEAR", "RADIAL", "CONIC", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AdaptyViewConfiguration.kt */
            public enum Type {
                LINEAR,
                RADIAL,
                CONIC
            }

            public final Type getType() {
                return this.type;
            }

            public final List<Value> getValues() {
                return this.values;
            }

            public final Points getPoints() {
                return this.points;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Gradient(Type type2, List<Value> list, Points points2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(type2, "type");
                Intrinsics.checkNotNullParameter(list, "values");
                Intrinsics.checkNotNullParameter(points2, "points");
                this.type = type2;
                this.values = list;
                this.points = points2;
            }

            public final int[] getColors() {
                Iterable<Value> iterable = this.values;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Value color : iterable) {
                    arrayList.add(Integer.valueOf(color.getColor().getValue()));
                }
                return CollectionsKt.toIntArray((List) arrayList);
            }

            public final float[] getPositions() {
                Iterable<Value> iterable = this.values;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Value p : iterable) {
                    arrayList.add(Float.valueOf(p.getP()));
                }
                return CollectionsKt.toFloatArray((List) arrayList);
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Asset$Gradient$Value;", "", "p", "", "color", "Lcom/adapty/models/AdaptyViewConfiguration$Asset$Color;", "(FLcom/adapty/models/AdaptyViewConfiguration$Asset$Color;)V", "getColor", "()Lcom/adapty/models/AdaptyViewConfiguration$Asset$Color;", "getP", "()F", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AdaptyViewConfiguration.kt */
            public static final class Value {
                private final Color color;
                private final float p;

                public Value(float f, Color color2) {
                    Intrinsics.checkNotNullParameter(color2, "color");
                    this.p = f;
                    this.color = color2;
                }

                public final float getP() {
                    return this.p;
                }

                public final Color getColor() {
                    return this.color;
                }
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u0002J\t\u0010\u000e\u001a\u00020\u0003H\u0002J\t\u0010\u000f\u001a\u00020\u0003H\u0002J\t\u0010\u0010\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Asset$Gradient$Points;", "", "x0", "", "y0", "x1", "y1", "(FFFF)V", "getX0", "()F", "getX1", "getY0", "getY1", "component1", "component2", "component3", "component4", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AdaptyViewConfiguration.kt */
            public static final class Points {
                private final float x0;
                private final float x1;
                private final float y0;
                private final float y1;

                public Points(float f, float f2, float f3, float f4) {
                    this.x0 = f;
                    this.y0 = f2;
                    this.x1 = f3;
                    this.y1 = f4;
                }

                public final float getX0() {
                    return this.x0;
                }

                public final float getY0() {
                    return this.y0;
                }

                public final float getX1() {
                    return this.x1;
                }

                public final float getY1() {
                    return this.y1;
                }

                public final float component1() {
                    return this.x0;
                }

                public final float component2() {
                    return this.y0;
                }

                public final float component3() {
                    return this.x1;
                }

                public final float component4() {
                    return this.y1;
                }
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000fR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0017R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Asset$Font;", "Lcom/adapty/models/AdaptyViewConfiguration$Asset;", "familyName", "", "resources", "", "weight", "", "isItalic", "", "size", "", "horizontalAlign", "Lcom/adapty/models/AdaptyViewConfiguration$HorizontalAlign;", "color", "(Ljava/lang/String;[Ljava/lang/String;IZLjava/lang/Float;Lcom/adapty/models/AdaptyViewConfiguration$HorizontalAlign;Ljava/lang/Integer;)V", "getColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFamilyName", "()Ljava/lang/String;", "getHorizontalAlign", "()Lcom/adapty/models/AdaptyViewConfiguration$HorizontalAlign;", "()Z", "getResources", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getSize", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getWeight", "()I", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyViewConfiguration.kt */
        public static final class Font extends Asset {
            private final Integer color;
            private final String familyName;
            private final HorizontalAlign horizontalAlign;
            private final boolean isItalic;
            private final String[] resources;
            private final Float size;
            private final int weight;

            public final String getFamilyName() {
                return this.familyName;
            }

            public final String[] getResources() {
                return this.resources;
            }

            public final int getWeight() {
                return this.weight;
            }

            public final boolean isItalic() {
                return this.isItalic;
            }

            public final Float getSize() {
                return this.size;
            }

            public final HorizontalAlign getHorizontalAlign() {
                return this.horizontalAlign;
            }

            public final Integer getColor() {
                return this.color;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Font(String str, String[] strArr, int i, boolean z, Float f, HorizontalAlign horizontalAlign2, Integer num) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "familyName");
                Intrinsics.checkNotNullParameter(strArr, "resources");
                this.familyName = str;
                this.resources = strArr;
                this.weight = i;
                this.isItalic = z;
                this.size = f;
                this.horizontalAlign = horizontalAlign2;
                this.color = num;
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Asset$Image;", "Lcom/adapty/models/AdaptyViewConfiguration$Asset$Filling;", "imageBase64", "", "(Ljava/lang/String;)V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "calculateInSampleSize", "", "initialDimValue", "reqDimValue", "reqDim", "dim", "Lcom/adapty/models/AdaptyViewConfiguration$Asset$Image$Dimension;", "boundsW", "boundsH", "scaleType", "Lcom/adapty/models/AdaptyViewConfiguration$Asset$Image$ScaleType;", "Dimension", "ScaleType", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyViewConfiguration.kt */
        public static final class Image extends Filling {
            private final String imageBase64;

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Asset$Image$Dimension;", "", "(Ljava/lang/String;I)V", "WIDTH", "HEIGHT", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AdaptyViewConfiguration.kt */
            public enum Dimension {
                WIDTH,
                HEIGHT
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Asset$Image$ScaleType;", "", "(Ljava/lang/String;I)V", "FIT_MIN", "FIT_MAX", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AdaptyViewConfiguration.kt */
            public enum ScaleType {
                FIT_MIN,
                FIT_MAX
            }

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AdaptyViewConfiguration.kt */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;
                public static final /* synthetic */ int[] $EnumSwitchMapping$1;

                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
                static {
                    /*
                        com.adapty.models.AdaptyViewConfiguration$Asset$Image$ScaleType[] r0 = com.adapty.models.AdaptyViewConfiguration.Asset.Image.ScaleType.values()
                        int r0 = r0.length
                        int[] r0 = new int[r0]
                        r1 = 1
                        com.adapty.models.AdaptyViewConfiguration$Asset$Image$ScaleType r2 = com.adapty.models.AdaptyViewConfiguration.Asset.Image.ScaleType.FIT_MAX     // Catch:{ NoSuchFieldError -> 0x0010 }
                        int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                        r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
                    L_0x0010:
                        r2 = 2
                        com.adapty.models.AdaptyViewConfiguration$Asset$Image$ScaleType r3 = com.adapty.models.AdaptyViewConfiguration.Asset.Image.ScaleType.FIT_MIN     // Catch:{ NoSuchFieldError -> 0x0019 }
                        int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                        r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                    L_0x0019:
                        $EnumSwitchMapping$0 = r0
                        com.adapty.models.AdaptyViewConfiguration$Asset$Image$Dimension[] r0 = com.adapty.models.AdaptyViewConfiguration.Asset.Image.Dimension.values()
                        int r0 = r0.length
                        int[] r0 = new int[r0]
                        com.adapty.models.AdaptyViewConfiguration$Asset$Image$Dimension r3 = com.adapty.models.AdaptyViewConfiguration.Asset.Image.Dimension.WIDTH     // Catch:{ NoSuchFieldError -> 0x002a }
                        int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                        r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
                    L_0x002a:
                        com.adapty.models.AdaptyViewConfiguration$Asset$Image$Dimension r1 = com.adapty.models.AdaptyViewConfiguration.Asset.Image.Dimension.HEIGHT     // Catch:{ NoSuchFieldError -> 0x0032 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
                    L_0x0032:
                        $EnumSwitchMapping$1 = r0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.adapty.models.AdaptyViewConfiguration.Asset.Image.WhenMappings.<clinit>():void");
                }
            }

            public Image(String str) {
                super((DefaultConstructorMarker) null);
                this.imageBase64 = str;
            }

            public final Bitmap getBitmap() {
                return getBitmap(0, Dimension.WIDTH);
            }

            public final Bitmap getBitmap(int i, int i2, ScaleType scaleType) {
                Dimension dimension;
                Intrinsics.checkNotNullParameter(scaleType, "scaleType");
                int i3 = WhenMappings.$EnumSwitchMapping$0[scaleType.ordinal()];
                int i4 = 1;
                if (i3 != 1) {
                    if (i3 == 2) {
                        i4 = -1;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                if ((i - i2) * i4 > 0) {
                    dimension = Dimension.WIDTH;
                } else {
                    int i5 = i2;
                    dimension = Dimension.HEIGHT;
                    i = i5;
                }
                return getBitmap(i, dimension);
            }

            public final Bitmap getBitmap(int i, Dimension dimension) {
                int i2;
                Intrinsics.checkNotNullParameter(dimension, "dim");
                String str = this.imageBase64;
                if (str == null) {
                    return null;
                }
                byte[] decode = Base64.decode(str, 0);
                if (i <= 0) {
                    return BitmapFactory.decodeByteArray(decode, 0, decode.length);
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
                int i3 = WhenMappings.$EnumSwitchMapping$1[dimension.ordinal()];
                if (i3 == 1) {
                    i2 = options.outWidth;
                } else if (i3 == 2) {
                    i2 = options.outHeight;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                options.inSampleSize = calculateInSampleSize(i2, i);
                options.inJustDecodeBounds = false;
                return BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            }

            private final int calculateInSampleSize(int i, int i2) {
                int i3 = 1;
                if (i > i2) {
                    while ((i / 2) / i3 >= i2) {
                        i3 *= 2;
                    }
                }
                return i3;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Asset$Filling;", "Lcom/adapty/models/AdaptyViewConfiguration$Asset;", "()V", "Lcom/adapty/models/AdaptyViewConfiguration$Asset$Color;", "Lcom/adapty/models/AdaptyViewConfiguration$Asset$Gradient;", "Lcom/adapty/models/AdaptyViewConfiguration$Asset$Image;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyViewConfiguration.kt */
        public static abstract class Filling extends Asset {
            public /* synthetic */ Filling(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Filling() {
                super((DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\fB-\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\u0010\bR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\r"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Localization;", "", "strings", "", "", "Lcom/adapty/models/AdaptyViewConfiguration$Localization$Str;", "assets", "Lcom/adapty/models/AdaptyViewConfiguration$Asset;", "(Ljava/util/Map;Ljava/util/Map;)V", "getAssets", "()Ljava/util/Map;", "getStrings", "Str", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyViewConfiguration.kt */
    public static final class Localization {
        private final Map<String, Asset> assets;
        private final Map<String, Str> strings;

        public Localization(Map<String, Str> map, Map<String, ? extends Asset> map2) {
            Intrinsics.checkNotNullParameter(map, "strings");
            Intrinsics.checkNotNullParameter(map2, "assets");
            this.strings = map;
            this.assets = map2;
        }

        public final Map<String, Str> getStrings() {
            return this.strings;
        }

        public final Map<String, Asset> getAssets() {
            return this.assets;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/adapty/models/AdaptyViewConfiguration$Localization$Str;", "", "value", "", "fallback", "hasTags", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getFallback", "()Ljava/lang/String;", "getHasTags", "()Z", "getValue", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyViewConfiguration.kt */
        public static final class Str {
            private final String fallback;
            private final boolean hasTags;
            private final String value;

            public Str(String str, String str2, boolean z) {
                Intrinsics.checkNotNullParameter(str, "value");
                this.value = str;
                this.fallback = str2;
                this.hasTags = z;
            }

            public final String getValue() {
                return this.value;
            }

            public final String getFallback() {
                return this.fallback;
            }

            public final boolean getHasTags() {
                return this.hasTags;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = r0.getAssets();
     */
    @com.adapty.internal.utils.InternalAdaptyApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends com.adapty.models.AdaptyViewConfiguration.Asset> T getAsset(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = "assetId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = r3.defaultLocalization
            java.util.Map<java.lang.String, com.adapty.models.AdaptyViewConfiguration$Localization> r1 = r3.localizations
            java.lang.Object r0 = r1.get(r0)
            com.adapty.models.AdaptyViewConfiguration$Localization r0 = (com.adapty.models.AdaptyViewConfiguration.Localization) r0
            r1 = 0
            if (r0 == 0) goto L_0x0020
            java.util.Map r0 = r0.getAssets()
            if (r0 == 0) goto L_0x0020
            java.lang.Object r0 = r0.get(r4)
            com.adapty.models.AdaptyViewConfiguration$Asset r0 = (com.adapty.models.AdaptyViewConfiguration.Asset) r0
            if (r0 != 0) goto L_0x0045
        L_0x0020:
            java.util.Map<java.lang.String, com.adapty.models.AdaptyViewConfiguration$Localization> r0 = r3.localizations
            java.lang.String r2 = r3.defaultLocalization
            java.lang.Object r0 = r0.get(r2)
            com.adapty.models.AdaptyViewConfiguration$Localization r0 = (com.adapty.models.AdaptyViewConfiguration.Localization) r0
            if (r0 == 0) goto L_0x0039
            java.util.Map r0 = r0.getAssets()
            if (r0 == 0) goto L_0x0039
            java.lang.Object r0 = r0.get(r4)
            com.adapty.models.AdaptyViewConfiguration$Asset r0 = (com.adapty.models.AdaptyViewConfiguration.Asset) r0
            goto L_0x003a
        L_0x0039:
            r0 = r1
        L_0x003a:
            if (r0 != 0) goto L_0x0045
            java.util.Map<java.lang.String, com.adapty.models.AdaptyViewConfiguration$Asset> r0 = r3.assets
            java.lang.Object r4 = r0.get(r4)
            r0 = r4
            com.adapty.models.AdaptyViewConfiguration$Asset r0 = (com.adapty.models.AdaptyViewConfiguration.Asset) r0
        L_0x0045:
            boolean r4 = r0 instanceof com.adapty.models.AdaptyViewConfiguration.Asset
            if (r4 == 0) goto L_0x004a
            r1 = r0
        L_0x004a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.models.AdaptyViewConfiguration.getAsset(java.lang.String):com.adapty.models.AdaptyViewConfiguration$Asset");
    }

    @InternalAdaptyApi
    public final Localization.Str getString(String str) {
        Map<String, Localization.Str> strings;
        Map<String, Localization.Str> strings2;
        Localization.Str str2;
        Intrinsics.checkNotNullParameter(str, "strId");
        Localization localization = this.localizations.get(this.defaultLocalization);
        if (localization != null && (strings2 = localization.getStrings()) != null && (str2 = strings2.get(str)) != null) {
            return str2;
        }
        Localization localization2 = this.localizations.get(this.defaultLocalization);
        if (localization2 == null || (strings = localization2.getStrings()) == null) {
            return null;
        }
        return strings.get(str);
    }

    @InternalAdaptyApi
    public final Style getStyle(String str) {
        Intrinsics.checkNotNullParameter(str, "styleId");
        return this.styles.get(str);
    }

    @InternalAdaptyApi
    public final boolean hasStyle(String str) {
        Intrinsics.checkNotNullParameter(str, "styleId");
        return this.styles.get(str) != null;
    }
}
