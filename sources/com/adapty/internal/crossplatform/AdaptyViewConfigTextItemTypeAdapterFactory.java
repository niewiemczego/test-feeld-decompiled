package com.adapty.internal.crossplatform;

import com.adapty.models.AdaptyViewConfiguration;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0003J2\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\u00022\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000b0\nH\u0016J\u001e\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J0\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000b0\nH\u0016¨\u0006\u0014"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyViewConfigTextItemTypeAdapterFactory;", "Lcom/adapty/internal/crossplatform/AdaptyViewConfigBaseTypeAdapterFactory;", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text$Item;", "()V", "createJsonElementWithClassValueOnWrite", "Lkotlin/Pair;", "Lcom/google/gson/JsonElement;", "", "value", "orderedChildAdapters", "", "Lcom/google/gson/TypeAdapter;", "createOrderedChildAdapters", "gson", "Lcom/google/gson/Gson;", "createResultOnRead", "jsonObject", "Lcom/google/gson/JsonObject;", "classValue", "Companion", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyViewConfigTextItemTypeAdapterFactory.kt */
public final class AdaptyViewConfigTextItemTypeAdapterFactory extends AdaptyViewConfigBaseTypeAdapterFactory<AdaptyViewConfiguration.Component.Text.Item> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Deprecated
    public static final List<String> orderedClassValues = CollectionsKt.listOf("BulletedText", "Image", "NewLine", "Space", "Text");

    public AdaptyViewConfigTextItemTypeAdapterFactory() {
        super(AdaptyViewConfiguration.Component.Text.Item.class);
    }

    public List<TypeAdapter<? extends AdaptyViewConfiguration.Component.Text.Item>> createOrderedChildAdapters(Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        TypeAdapterFactory typeAdapterFactory = this;
        return CollectionsKt.listOf(gson.getDelegateAdapter(typeAdapterFactory, TypeToken.get(AdaptyViewConfiguration.Component.Text.Item.BulletedText.class)), gson.getDelegateAdapter(typeAdapterFactory, TypeToken.get(AdaptyViewConfiguration.Component.Text.Item.Image.class)), gson.getDelegateAdapter(typeAdapterFactory, TypeToken.get(AdaptyViewConfiguration.Component.Text.Item.NewLine.class)), gson.getDelegateAdapter(typeAdapterFactory, TypeToken.get(AdaptyViewConfiguration.Component.Text.Item.Space.class)), gson.getDelegateAdapter(typeAdapterFactory, TypeToken.get(AdaptyViewConfiguration.Component.Text.Item.C0025Text.class)));
    }

    public Pair<JsonElement, String> createJsonElementWithClassValueOnWrite(AdaptyViewConfiguration.Component.Text.Item item, List<? extends TypeAdapter<? extends AdaptyViewConfiguration.Component.Text.Item>> list) {
        Intrinsics.checkNotNullParameter(item, "value");
        Intrinsics.checkNotNullParameter(list, "orderedChildAdapters");
        if (item instanceof AdaptyViewConfiguration.Component.Text.Item.BulletedText) {
            JsonElement jsonTree = getFor(list, 0).toJsonTree(item);
            Intrinsics.checkNotNull(jsonTree, "null cannot be cast to non-null type com.google.gson.JsonObject");
            return TuplesKt.to((JsonObject) jsonTree, orderedClassValues.get(0));
        } else if (item instanceof AdaptyViewConfiguration.Component.Text.Item.Image) {
            JsonElement jsonTree2 = getFor(list, 1).toJsonTree(item);
            Intrinsics.checkNotNull(jsonTree2, "null cannot be cast to non-null type com.google.gson.JsonObject");
            return TuplesKt.to((JsonObject) jsonTree2, orderedClassValues.get(1));
        } else if (item instanceof AdaptyViewConfiguration.Component.Text.Item.NewLine) {
            JsonElement jsonTree3 = getFor(list, 2).toJsonTree(item);
            Intrinsics.checkNotNull(jsonTree3, "null cannot be cast to non-null type com.google.gson.JsonObject");
            return TuplesKt.to((JsonObject) jsonTree3, orderedClassValues.get(2));
        } else if (item instanceof AdaptyViewConfiguration.Component.Text.Item.Space) {
            JsonElement jsonTree4 = getFor(list, 3).toJsonTree(item);
            Intrinsics.checkNotNull(jsonTree4, "null cannot be cast to non-null type com.google.gson.JsonObject");
            return TuplesKt.to((JsonObject) jsonTree4, orderedClassValues.get(3));
        } else if (item instanceof AdaptyViewConfiguration.Component.Text.Item.C0025Text) {
            JsonElement jsonTree5 = getFor(list, 4).toJsonTree(item);
            Intrinsics.checkNotNull(jsonTree5, "null cannot be cast to non-null type com.google.gson.JsonObject");
            return TuplesKt.to((JsonObject) jsonTree5, orderedClassValues.get(4));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public AdaptyViewConfiguration.Component.Text.Item createResultOnRead(JsonObject jsonObject, String str, List<? extends TypeAdapter<? extends AdaptyViewConfiguration.Component.Text.Item>> list) {
        TypeAdapter<ACTUAL_TYPE> typeAdapter;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(str, "classValue");
        Intrinsics.checkNotNullParameter(list, "orderedChildAdapters");
        List<String> list2 = orderedClassValues;
        if (Intrinsics.areEqual((Object) str, (Object) list2.get(2))) {
            return AdaptyViewConfiguration.Component.Text.Item.NewLine.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) str, (Object) list2.get(0))) {
            typeAdapter = getFor(list, 0);
        } else if (Intrinsics.areEqual((Object) str, (Object) list2.get(1))) {
            typeAdapter = getFor(list, 1);
        } else if (Intrinsics.areEqual((Object) str, (Object) list2.get(3))) {
            typeAdapter = getFor(list, 3);
        } else {
            typeAdapter = Intrinsics.areEqual((Object) str, (Object) list2.get(4)) ? getFor(list, 4) : null;
        }
        if (typeAdapter != null) {
            return (AdaptyViewConfiguration.Component.Text.Item) typeAdapter.fromJsonTree(jsonObject);
        }
        return null;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyViewConfigTextItemTypeAdapterFactory$Companion;", "", "()V", "orderedClassValues", "", "", "getOrderedClassValues", "()Ljava/util/List;", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyViewConfigTextItemTypeAdapterFactory.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<String> getOrderedClassValues() {
            return AdaptyViewConfigTextItemTypeAdapterFactory.orderedClassValues;
        }
    }
}