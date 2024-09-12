package com.adapty.internal.utils;

import android.graphics.Color;
import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.internal.crossplatform.AdaptyPaywallTypeAdapterFactory;
import com.adapty.internal.crossplatform.AdaptyUIActionTypeAdapterFactory;
import com.adapty.models.AdaptyViewConfiguration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u000e\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000eH\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u000e\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000eH\u0002J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u000e\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000eH\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\r\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000eH\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000eH\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u000e\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000eH\u0002J\u0018\u0010 \u001a\u00020!2\u000e\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000eH\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0011H\u0003J$\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020%0\u000e2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0002J\u0014\u0010)\u001a\u0004\u0018\u00010*2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0011H\u0002¨\u0006-"}, d2 = {"Lcom/adapty/internal/utils/ViewConfigurationMapper;", "", "()V", "compareByOrder", "", "firstMap", "secondMap", "map", "Lcom/adapty/models/AdaptyViewConfiguration;", "viewConfig", "Lcom/adapty/internal/data/models/ViewConfigurationDto;", "mapButtonAction", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Action;", "value", "", "mapButtonAlign", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Align;", "", "mapButtonComponent", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Button;", "mapButtonTransition", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Button$Transition;", "mapCustomObjectComponent", "Lcom/adapty/models/AdaptyViewConfiguration$Component$CustomObject;", "mapHorizontalAlign", "Lcom/adapty/models/AdaptyViewConfiguration$HorizontalAlign;", "mapProductObjectComponent", "Lcom/adapty/models/AdaptyViewConfiguration$Component$ProductObject;", "mapShapeComponent", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Shape;", "mapStyle", "Lcom/adapty/models/AdaptyViewConfiguration$Style;", "mapTextComponent", "Lcom/adapty/models/AdaptyViewConfiguration$Component$Text;", "mapVisualAssetColorString", "colorString", "mapVisualAssets", "Lcom/adapty/models/AdaptyViewConfiguration$Asset;", "assets", "", "Lcom/adapty/internal/data/models/ViewConfigurationConfig$Asset;", "mapVisualStyleComponent", "Lcom/adapty/models/AdaptyViewConfiguration$Component;", "rgbaToArgbStr", "rgbaColorString", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewConfigurationMapper.kt */
public final class ViewConfigurationMapper {
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0015, code lost:
        r4 = r1.isHard();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.adapty.models.AdaptyViewConfiguration map(com.adapty.internal.data.models.ViewConfigurationDto r28) {
        /*
            r27 = this;
            r0 = r27
            java.lang.String r1 = "viewConfig"
            r2 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            com.adapty.internal.data.models.ViewConfigurationConfig r1 = r28.getConfig()
            java.lang.String r3 = r28.getId()
            if (r3 == 0) goto L_0x01b5
            if (r1 == 0) goto L_0x0020
            java.lang.Boolean r4 = r1.isHard()
            if (r4 == 0) goto L_0x0020
            boolean r4 = r4.booleanValue()
            goto L_0x0021
        L_0x0020:
            r4 = 0
        L_0x0021:
            if (r1 == 0) goto L_0x0028
            java.lang.String r6 = r1.getTemplateId()
            goto L_0x0029
        L_0x0028:
            r6 = 0
        L_0x0029:
            if (r1 == 0) goto L_0x0030
            java.lang.String r7 = r1.getDefaultLocalization()
            goto L_0x0031
        L_0x0030:
            r7 = 0
        L_0x0031:
            if (r1 == 0) goto L_0x003e
            java.lang.Float r8 = r1.getMainImageRelativeHeight()
            if (r8 == 0) goto L_0x003e
            float r8 = r8.floatValue()
            goto L_0x0040
        L_0x003e:
            r8 = 1065353216(0x3f800000, float:1.0)
        L_0x0040:
            if (r1 == 0) goto L_0x0047
            java.util.List r9 = r1.getAssets()
            goto L_0x0048
        L_0x0047:
            r9 = 0
        L_0x0048:
            java.util.Map r9 = r0.mapVisualAssets(r9)
            if (r1 == 0) goto L_0x014b
            java.util.List r10 = r1.getLocalizations()
            if (r10 == 0) goto L_0x014b
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            r11 = 10
            int r12 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r11)
            int r12 = kotlin.collections.MapsKt.mapCapacity(r12)
            r13 = 16
            int r12 = kotlin.ranges.RangesKt.coerceAtLeast((int) r12, (int) r13)
            java.util.LinkedHashMap r14 = new java.util.LinkedHashMap
            r14.<init>(r12)
            java.util.Map r14 = (java.util.Map) r14
            java.util.Iterator r10 = r10.iterator()
        L_0x0071:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L_0x014c
            java.lang.Object r12 = r10.next()
            com.adapty.internal.data.models.ViewConfigurationConfig$Localization r12 = (com.adapty.internal.data.models.ViewConfigurationConfig.Localization) r12
            java.lang.String r15 = r12.getId()
            if (r15 == 0) goto L_0x0139
            java.util.List r15 = r12.getStrings()
            if (r15 == 0) goto L_0x0108
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            int r16 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r15, r11)
            int r2 = kotlin.collections.MapsKt.mapCapacity(r16)
            int r2 = kotlin.ranges.RangesKt.coerceAtLeast((int) r2, (int) r13)
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
            r5.<init>(r2)
            java.util.Map r5 = (java.util.Map) r5
            java.util.Iterator r2 = r15.iterator()
        L_0x00a2:
            boolean r15 = r2.hasNext()
            if (r15 == 0) goto L_0x0105
            java.lang.Object r15 = r2.next()
            com.adapty.internal.data.models.ViewConfigurationConfig$Localization$Str r15 = (com.adapty.internal.data.models.ViewConfigurationConfig.Localization.Str) r15
            java.lang.String r17 = r15.getId()
            if (r17 == 0) goto L_0x00f3
            java.lang.String r17 = r15.getValue()
            if (r17 == 0) goto L_0x00f3
            java.lang.String r11 = r15.getId()
            com.adapty.models.AdaptyViewConfiguration$Localization$Str r13 = new com.adapty.models.AdaptyViewConfiguration$Localization$Str
            r19 = r2
            java.lang.String r2 = r15.getValue()
            r20 = r10
            java.lang.String r10 = r15.getFallback()
            java.lang.Boolean r15 = r15.getHasTags()
            if (r15 == 0) goto L_0x00d7
            boolean r15 = r15.booleanValue()
            goto L_0x00d8
        L_0x00d7:
            r15 = 0
        L_0x00d8:
            r13.<init>(r2, r10, r15)
            kotlin.Pair r2 = kotlin.TuplesKt.to(r11, r13)
            java.lang.Object r10 = r2.getFirst()
            java.lang.Object r2 = r2.getSecond()
            r5.put(r10, r2)
            r2 = r19
            r10 = r20
            r11 = 10
            r13 = 16
            goto L_0x00a2
        L_0x00f3:
            com.adapty.errors.AdaptyError r1 = new com.adapty.errors.AdaptyError
            r22 = 0
            com.adapty.errors.AdaptyErrorCode r24 = com.adapty.errors.AdaptyErrorCode.DECODING_FAILED
            r25 = 1
            r26 = 0
            java.lang.String r23 = "id and value in strings in Localization should not be null"
            r21 = r1
            r21.<init>(r22, r23, r24, r25, r26)
            throw r1
        L_0x0105:
            r20 = r10
            goto L_0x010b
        L_0x0108:
            r20 = r10
            r5 = 0
        L_0x010b:
            if (r5 != 0) goto L_0x0111
            java.util.Map r5 = kotlin.collections.MapsKt.emptyMap()
        L_0x0111:
            java.util.List r2 = r12.getAssets()
            java.util.Map r2 = r0.mapVisualAssets(r2)
            java.lang.String r10 = r12.getId()
            com.adapty.models.AdaptyViewConfiguration$Localization r11 = new com.adapty.models.AdaptyViewConfiguration$Localization
            r11.<init>(r5, r2)
            kotlin.Pair r2 = kotlin.TuplesKt.to(r10, r11)
            java.lang.Object r5 = r2.getFirst()
            java.lang.Object r2 = r2.getSecond()
            r14.put(r5, r2)
            r10 = r20
            r11 = 10
            r13 = 16
            goto L_0x0071
        L_0x0139:
            com.adapty.errors.AdaptyError r1 = new com.adapty.errors.AdaptyError
            r22 = 0
            com.adapty.errors.AdaptyErrorCode r24 = com.adapty.errors.AdaptyErrorCode.DECODING_FAILED
            r25 = 1
            r26 = 0
            java.lang.String r23 = "id in Localization should not be null"
            r21 = r1
            r21.<init>(r22, r23, r24, r25, r26)
            throw r1
        L_0x014b:
            r14 = 0
        L_0x014c:
            if (r14 != 0) goto L_0x0153
            java.util.Map r2 = kotlin.collections.MapsKt.emptyMap()
            r14 = r2
        L_0x0153:
            if (r1 == 0) goto L_0x01a0
            java.util.HashMap r1 = r1.getStyles()
            if (r1 == 0) goto L_0x01a0
            java.util.Map r1 = (java.util.Map) r1
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            int r5 = r1.size()
            int r5 = kotlin.collections.MapsKt.mapCapacity(r5)
            r2.<init>(r5)
            java.util.Map r2 = (java.util.Map) r2
            java.util.Set r1 = r1.entrySet()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0176:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x019e
            java.lang.Object r5 = r1.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r10 = r5.getKey()
            java.lang.Object r5 = r5.getValue()
            boolean r11 = r5 instanceof java.util.Map
            if (r11 == 0) goto L_0x0191
            java.util.Map r5 = (java.util.Map) r5
            goto L_0x0192
        L_0x0191:
            r5 = 0
        L_0x0192:
            if (r5 == 0) goto L_0x0199
            com.adapty.models.AdaptyViewConfiguration$Style r5 = r0.mapStyle(r5)
            goto L_0x019a
        L_0x0199:
            r5 = 0
        L_0x019a:
            r2.put(r10, r5)
            goto L_0x0176
        L_0x019e:
            r5 = r2
            goto L_0x01a1
        L_0x01a0:
            r5 = 0
        L_0x01a1:
            if (r5 != 0) goto L_0x01a9
            java.util.Map r1 = kotlin.collections.MapsKt.emptyMap()
            r10 = r1
            goto L_0x01aa
        L_0x01a9:
            r10 = r5
        L_0x01aa:
            com.adapty.models.AdaptyViewConfiguration r1 = new com.adapty.models.AdaptyViewConfiguration
            r2 = r1
            r5 = r6
            r6 = r8
            r8 = r9
            r9 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r1
        L_0x01b5:
            com.adapty.errors.AdaptyError r1 = new com.adapty.errors.AdaptyError
            r16 = 0
            com.adapty.errors.AdaptyErrorCode r18 = com.adapty.errors.AdaptyErrorCode.DECODING_FAILED
            r19 = 1
            r20 = 0
            java.lang.String r17 = "id in ViewConfiguration should not be null"
            r15 = r1
            r15.<init>(r16, r17, r18, r19, r20)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.ViewConfigurationMapper.map(com.adapty.internal.data.models.ViewConfigurationDto):com.adapty.models.AdaptyViewConfiguration");
    }

    private final AdaptyViewConfiguration.Style mapStyle(Map<?, ?> map) {
        AdaptyViewConfiguration.ProductBlock.Type type;
        AdaptyViewConfiguration.FeatureBlock featureBlock;
        AdaptyViewConfiguration.FooterBlock footerBlock;
        Pair pair;
        AdaptyViewConfiguration.Component mapVisualStyleComponent;
        AdaptyViewConfiguration.FeatureBlock.Type type2;
        Map<?, ?> mutableMap = MapsKt.toMutableMap(map);
        Object remove = mutableMap.remove("products_block");
        Map map2 = remove instanceof Map ? (Map) remove : null;
        if (map2 != null) {
            Object obj = map2.get("type");
            if (Intrinsics.areEqual(obj, (Object) "horizontal")) {
                type = AdaptyViewConfiguration.ProductBlock.Type.HORIZONTAL;
            } else if (Intrinsics.areEqual(obj, (Object) "single")) {
                type = AdaptyViewConfiguration.ProductBlock.Type.SINGLE;
            } else if (Intrinsics.areEqual(obj, (Object) "vertical")) {
                type = AdaptyViewConfiguration.ProductBlock.Type.VERTICAL;
            } else {
                throw new AdaptyError((Throwable) null, "Unsupported type (\"" + obj + "\") in products_block", AdaptyErrorCode.DECODING_FAILED, 1, (DefaultConstructorMarker) null);
            }
            Object obj2 = map2.get("main_product_index");
            Number number = obj2 instanceof Number ? (Number) obj2 : null;
            boolean z = false;
            int coerceAtLeast = number != null ? RangesKt.coerceAtLeast(number.intValue(), 0) : 0;
            Object obj3 = map2.get("initiate_purchase_on_tap");
            Boolean bool = obj3 instanceof Boolean ? (Boolean) obj3 : null;
            if (bool != null) {
                z = bool.booleanValue();
            }
            Object obj4 = map2.get(AdaptyPaywallTypeAdapterFactory.PRODUCTS);
            List list = obj4 instanceof List ? (List) obj4 : null;
            if (list != null) {
                Collection arrayList = new ArrayList();
                for (Object next : list) {
                    Map map3 = next instanceof Map ? (Map) next : null;
                    AdaptyViewConfiguration.Component.ProductObject mapProductObjectComponent = map3 != null ? mapProductObjectComponent(map3) : null;
                    Pair pair2 = mapProductObjectComponent != null ? TuplesKt.to(mapProductObjectComponent.getProductId(), mapProductObjectComponent) : null;
                    if (pair2 != null) {
                        arrayList.add(pair2);
                    }
                }
                Map map4 = MapsKt.toMap((List) arrayList);
                if (map4 != null) {
                    AdaptyViewConfiguration.ProductBlock productBlock = new AdaptyViewConfiguration.ProductBlock(type, coerceAtLeast, z, map4);
                    Object remove2 = mutableMap.remove("features_block");
                    Map map5 = remove2 instanceof Map ? (Map) remove2 : null;
                    if (map5 != null) {
                        Object obj5 = map5.get("type");
                        if (Intrinsics.areEqual(obj5, (Object) "list")) {
                            type2 = AdaptyViewConfiguration.FeatureBlock.Type.LIST;
                        } else if (Intrinsics.areEqual(obj5, (Object) "timeline")) {
                            type2 = AdaptyViewConfiguration.FeatureBlock.Type.TIMELINE;
                        } else {
                            throw new AdaptyError((Throwable) null, "Unsupported type (\"" + obj5 + "\") in features_block", AdaptyErrorCode.DECODING_FAILED, 1, (DefaultConstructorMarker) null);
                        }
                        Collection arrayList2 = new ArrayList();
                        for (Object next2 : map5.values()) {
                            if (next2 instanceof Map) {
                                arrayList2.add(next2);
                            }
                        }
                        Collection arrayList3 = new ArrayList();
                        for (Object mapVisualStyleComponent2 : CollectionsKt.sortedWith((List) arrayList2, new ViewConfigurationMapper$$ExternalSyntheticLambda0(this))) {
                            AdaptyViewConfiguration.Component mapVisualStyleComponent3 = mapVisualStyleComponent(mapVisualStyleComponent2);
                            if (mapVisualStyleComponent3 != null) {
                                arrayList3.add(mapVisualStyleComponent3);
                            }
                        }
                        featureBlock = new AdaptyViewConfiguration.FeatureBlock(type2, (List) arrayList3);
                    } else {
                        featureBlock = null;
                    }
                    Object remove3 = mutableMap.remove("footer_block");
                    Map map6 = remove3 instanceof Map ? (Map) remove3 : null;
                    if (map6 != null) {
                        Collection arrayList4 = new ArrayList();
                        for (Object next3 : map6.values()) {
                            if (next3 instanceof Map) {
                                arrayList4.add(next3);
                            }
                        }
                        Collection arrayList5 = new ArrayList();
                        for (Object mapVisualStyleComponent4 : CollectionsKt.sortedWith((List) arrayList4, new ViewConfigurationMapper$$ExternalSyntheticLambda1(this))) {
                            AdaptyViewConfiguration.Component mapVisualStyleComponent5 = mapVisualStyleComponent(mapVisualStyleComponent4);
                            if (mapVisualStyleComponent5 != null) {
                                arrayList5.add(mapVisualStyleComponent5);
                            }
                        }
                        footerBlock = new AdaptyViewConfiguration.FooterBlock((List) arrayList5);
                    } else {
                        footerBlock = null;
                    }
                    Collection arrayList6 = new ArrayList();
                    for (Map.Entry next4 : mutableMap.entrySet()) {
                        Object key = next4.getKey();
                        Object value = next4.getValue();
                        if (!(key instanceof String) || value == null || (mapVisualStyleComponent = mapVisualStyleComponent(value)) == null) {
                            pair = null;
                        } else {
                            pair = TuplesKt.to(key, mapVisualStyleComponent);
                        }
                        if (pair != null) {
                            arrayList6.add(pair);
                        }
                    }
                    return new AdaptyViewConfiguration.Style(featureBlock, productBlock, footerBlock, MapsKt.toMap((List) arrayList6));
                }
            }
            throw new AdaptyError((Throwable) null, "products in ProductBlock should not be null", AdaptyErrorCode.DECODING_FAILED, 1, (DefaultConstructorMarker) null);
        }
        throw new AdaptyError((Throwable) null, "products_block in style should not be null", AdaptyErrorCode.DECODING_FAILED, 1, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public static final int mapStyle$lambda$9$lambda$7(ViewConfigurationMapper viewConfigurationMapper, Map map, Map map2) {
        Intrinsics.checkNotNullParameter(viewConfigurationMapper, "this$0");
        return viewConfigurationMapper.compareByOrder(map, map2);
    }

    /* access modifiers changed from: private */
    public static final int mapStyle$lambda$12$lambda$10(ViewConfigurationMapper viewConfigurationMapper, Map map, Map map2) {
        Intrinsics.checkNotNullParameter(viewConfigurationMapper, "this$0");
        return viewConfigurationMapper.compareByOrder(map, map2);
    }

    private final AdaptyViewConfiguration.Component mapVisualStyleComponent(Object obj) {
        if (obj instanceof String) {
            return new AdaptyViewConfiguration.Component.Reference((String) obj);
        }
        if (!(obj instanceof Map)) {
            return null;
        }
        Map map = (Map) obj;
        Object obj2 = map.get("type");
        boolean z = true;
        if (!(Intrinsics.areEqual(obj2, (Object) "shape") ? true : Intrinsics.areEqual(obj2, (Object) "rectangle") ? true : Intrinsics.areEqual(obj2, (Object) "rect") ? true : Intrinsics.areEqual(obj2, (Object) TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE) ? true : Intrinsics.areEqual(obj2, (Object) "curve_up"))) {
            z = Intrinsics.areEqual(obj2, (Object) "curve_down");
        }
        if (z) {
            return mapShapeComponent(map);
        }
        if (Intrinsics.areEqual(obj2, (Object) "text")) {
            return mapTextComponent(map);
        }
        if (Intrinsics.areEqual(obj2, (Object) "button")) {
            return mapButtonComponent(map);
        }
        if (Intrinsics.areEqual(obj2, (Object) "product")) {
            return mapProductObjectComponent(map);
        }
        return mapCustomObjectComponent(map);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.adapty.models.AdaptyViewConfiguration$Component$Shape$Border} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r0 == null) goto L_0x0017;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.adapty.models.AdaptyViewConfiguration.Component.Shape mapShapeComponent(java.util.Map<?, ?> r9) {
        /*
            r8 = this;
            java.lang.String r0 = "type"
            java.lang.Object r0 = r9.get(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0017
            java.lang.String r3 = "shape"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            r3 = r3 ^ r1
            if (r3 == 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r0 = r2
        L_0x0015:
            if (r0 != 0) goto L_0x001d
        L_0x0017:
            java.lang.String r0 = "value"
            java.lang.Object r0 = r9.get(r0)
        L_0x001d:
            java.lang.String r3 = "circle"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            r4 = 0
            if (r3 == 0) goto L_0x002c
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$Type$Circle r0 = com.adapty.models.AdaptyViewConfiguration.Component.Shape.Type.Circle.INSTANCE
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$Type r0 = (com.adapty.models.AdaptyViewConfiguration.Component.Shape.Type) r0
            goto L_0x017f
        L_0x002c:
            java.lang.String r3 = "curve_up"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x003f
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$Type$RectWithArc r0 = new com.adapty.models.AdaptyViewConfiguration$Component$Shape$Type$RectWithArc
            r1 = 1101004800(0x41a00000, float:20.0)
            r0.<init>(r1)
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$Type r0 = (com.adapty.models.AdaptyViewConfiguration.Component.Shape.Type) r0
            goto L_0x017f
        L_0x003f:
            java.lang.String r3 = "curve_down"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x0052
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$Type$RectWithArc r0 = new com.adapty.models.AdaptyViewConfiguration$Component$Shape$Type$RectWithArc
            r1 = -1046478848(0xffffffffc1a00000, float:-20.0)
            r0.<init>(r1)
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$Type r0 = (com.adapty.models.AdaptyViewConfiguration.Component.Shape.Type) r0
            goto L_0x017f
        L_0x0052:
            java.lang.String r0 = "rect_corner_radius"
            java.lang.Object r0 = r9.get(r0)
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$Type$Rectangle r3 = new com.adapty.models.AdaptyViewConfiguration$Component$Shape$Type$Rectangle
            boolean r5 = r0 instanceof java.lang.Number
            if (r5 == 0) goto L_0x006d
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$CornerRadius$Same r1 = new com.adapty.models.AdaptyViewConfiguration$Component$Shape$CornerRadius$Same
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            r1.<init>(r0)
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$CornerRadius r1 = (com.adapty.models.AdaptyViewConfiguration.Component.Shape.CornerRadius) r1
            goto L_0x0179
        L_0x006d:
            boolean r5 = r0 instanceof java.util.List
            if (r5 == 0) goto L_0x0100
            java.util.List r0 = (java.util.List) r0
            boolean r5 = r0.isEmpty()
            if (r5 == 0) goto L_0x0080
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$CornerRadius$None r0 = com.adapty.models.AdaptyViewConfiguration.Component.Shape.CornerRadius.None.INSTANCE
            r1 = r0
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$CornerRadius r1 = (com.adapty.models.AdaptyViewConfiguration.Component.Shape.CornerRadius) r1
            goto L_0x0179
        L_0x0080:
            int r5 = r0.size()
            r6 = 0
            if (r5 != r1) goto L_0x00a4
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$CornerRadius$Same r1 = new com.adapty.models.AdaptyViewConfiguration$Component$Shape$CornerRadius$Same
            java.lang.Object r0 = r0.get(r6)
            boolean r5 = r0 instanceof java.lang.Number
            if (r5 == 0) goto L_0x0094
            java.lang.Number r0 = (java.lang.Number) r0
            goto L_0x0095
        L_0x0094:
            r0 = r2
        L_0x0095:
            if (r0 == 0) goto L_0x009c
            float r0 = r0.floatValue()
            goto L_0x009d
        L_0x009c:
            r0 = r4
        L_0x009d:
            r1.<init>(r0)
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$CornerRadius r1 = (com.adapty.models.AdaptyViewConfiguration.Component.Shape.CornerRadius) r1
            goto L_0x0179
        L_0x00a4:
            java.lang.Object r5 = kotlin.collections.CollectionsKt.getOrNull(r0, r6)
            boolean r6 = r5 instanceof java.lang.Number
            if (r6 == 0) goto L_0x00af
            java.lang.Number r5 = (java.lang.Number) r5
            goto L_0x00b0
        L_0x00af:
            r5 = r2
        L_0x00b0:
            if (r5 == 0) goto L_0x00b7
            float r5 = r5.floatValue()
            goto L_0x00b8
        L_0x00b7:
            r5 = r4
        L_0x00b8:
            java.lang.Object r1 = kotlin.collections.CollectionsKt.getOrNull(r0, r1)
            boolean r6 = r1 instanceof java.lang.Number
            if (r6 == 0) goto L_0x00c3
            java.lang.Number r1 = (java.lang.Number) r1
            goto L_0x00c4
        L_0x00c3:
            r1 = r2
        L_0x00c4:
            if (r1 == 0) goto L_0x00cb
            float r1 = r1.floatValue()
            goto L_0x00cc
        L_0x00cb:
            r1 = r4
        L_0x00cc:
            r6 = 2
            java.lang.Object r6 = kotlin.collections.CollectionsKt.getOrNull(r0, r6)
            boolean r7 = r6 instanceof java.lang.Number
            if (r7 == 0) goto L_0x00d8
            java.lang.Number r6 = (java.lang.Number) r6
            goto L_0x00d9
        L_0x00d8:
            r6 = r2
        L_0x00d9:
            if (r6 == 0) goto L_0x00e0
            float r6 = r6.floatValue()
            goto L_0x00e1
        L_0x00e0:
            r6 = r4
        L_0x00e1:
            r7 = 3
            java.lang.Object r0 = kotlin.collections.CollectionsKt.getOrNull(r0, r7)
            boolean r7 = r0 instanceof java.lang.Number
            if (r7 == 0) goto L_0x00ed
            java.lang.Number r0 = (java.lang.Number) r0
            goto L_0x00ee
        L_0x00ed:
            r0 = r2
        L_0x00ee:
            if (r0 == 0) goto L_0x00f5
            float r0 = r0.floatValue()
            goto L_0x00f6
        L_0x00f5:
            r0 = r4
        L_0x00f6:
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$CornerRadius$Different r7 = new com.adapty.models.AdaptyViewConfiguration$Component$Shape$CornerRadius$Different
            r7.<init>(r5, r1, r6, r0)
            r1 = r7
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$CornerRadius r1 = (com.adapty.models.AdaptyViewConfiguration.Component.Shape.CornerRadius) r1
            goto L_0x0179
        L_0x0100:
            boolean r1 = r0 instanceof java.util.Map
            if (r1 == 0) goto L_0x0174
            java.util.Map r0 = (java.util.Map) r0
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0113
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$CornerRadius$None r0 = com.adapty.models.AdaptyViewConfiguration.Component.Shape.CornerRadius.None.INSTANCE
            r1 = r0
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$CornerRadius r1 = (com.adapty.models.AdaptyViewConfiguration.Component.Shape.CornerRadius) r1
            goto L_0x0179
        L_0x0113:
            java.lang.String r1 = "tl"
            java.lang.Object r1 = r0.get(r1)
            boolean r5 = r1 instanceof java.lang.Number
            if (r5 == 0) goto L_0x0120
            java.lang.Number r1 = (java.lang.Number) r1
            goto L_0x0121
        L_0x0120:
            r1 = r2
        L_0x0121:
            if (r1 == 0) goto L_0x0128
            float r1 = r1.floatValue()
            goto L_0x0129
        L_0x0128:
            r1 = r4
        L_0x0129:
            java.lang.String r5 = "tr"
            java.lang.Object r5 = r0.get(r5)
            boolean r6 = r5 instanceof java.lang.Number
            if (r6 == 0) goto L_0x0136
            java.lang.Number r5 = (java.lang.Number) r5
            goto L_0x0137
        L_0x0136:
            r5 = r2
        L_0x0137:
            if (r5 == 0) goto L_0x013e
            float r5 = r5.floatValue()
            goto L_0x013f
        L_0x013e:
            r5 = r4
        L_0x013f:
            java.lang.String r6 = "br"
            java.lang.Object r6 = r0.get(r6)
            boolean r7 = r6 instanceof java.lang.Number
            if (r7 == 0) goto L_0x014c
            java.lang.Number r6 = (java.lang.Number) r6
            goto L_0x014d
        L_0x014c:
            r6 = r2
        L_0x014d:
            if (r6 == 0) goto L_0x0154
            float r6 = r6.floatValue()
            goto L_0x0155
        L_0x0154:
            r6 = r4
        L_0x0155:
            java.lang.String r7 = "bl"
            java.lang.Object r0 = r0.get(r7)
            boolean r7 = r0 instanceof java.lang.Number
            if (r7 == 0) goto L_0x0162
            java.lang.Number r0 = (java.lang.Number) r0
            goto L_0x0163
        L_0x0162:
            r0 = r2
        L_0x0163:
            if (r0 == 0) goto L_0x016a
            float r0 = r0.floatValue()
            goto L_0x016b
        L_0x016a:
            r0 = r4
        L_0x016b:
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$CornerRadius$Different r7 = new com.adapty.models.AdaptyViewConfiguration$Component$Shape$CornerRadius$Different
            r7.<init>(r1, r5, r6, r0)
            r1 = r7
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$CornerRadius r1 = (com.adapty.models.AdaptyViewConfiguration.Component.Shape.CornerRadius) r1
            goto L_0x0179
        L_0x0174:
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$CornerRadius$None r0 = com.adapty.models.AdaptyViewConfiguration.Component.Shape.CornerRadius.None.INSTANCE
            r1 = r0
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$CornerRadius r1 = (com.adapty.models.AdaptyViewConfiguration.Component.Shape.CornerRadius) r1
        L_0x0179:
            r3.<init>(r1)
            r0 = r3
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$Type r0 = (com.adapty.models.AdaptyViewConfiguration.Component.Shape.Type) r0
        L_0x017f:
            java.lang.String r1 = "background"
            java.lang.Object r1 = r9.get(r1)
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L_0x018c
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x018d
        L_0x018c:
            r1 = r2
        L_0x018d:
            java.lang.String r3 = "border"
            java.lang.Object r3 = r9.get(r3)
            boolean r5 = r3 instanceof java.lang.String
            if (r5 == 0) goto L_0x019a
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x019b
        L_0x019a:
            r3 = r2
        L_0x019b:
            if (r3 == 0) goto L_0x01b6
            com.adapty.models.AdaptyViewConfiguration$Component$Shape$Border r5 = new com.adapty.models.AdaptyViewConfiguration$Component$Shape$Border
            java.lang.String r6 = "thickness"
            java.lang.Object r9 = r9.get(r6)
            boolean r6 = r9 instanceof java.lang.Number
            if (r6 == 0) goto L_0x01ac
            r2 = r9
            java.lang.Number r2 = (java.lang.Number) r2
        L_0x01ac:
            if (r2 == 0) goto L_0x01b2
            float r4 = r2.floatValue()
        L_0x01b2:
            r5.<init>(r3, r4)
            r2 = r5
        L_0x01b6:
            com.adapty.models.AdaptyViewConfiguration$Component$Shape r9 = new com.adapty.models.AdaptyViewConfiguration$Component$Shape
            r9.<init>(r1, r0, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.ViewConfigurationMapper.mapShapeComponent(java.util.Map):com.adapty.models.AdaptyViewConfiguration$Component$Shape");
    }

    /* JADX WARNING: type inference failed for: r5v21, types: [com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$BulletedText$TextBullet] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x02b1 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.adapty.models.AdaptyViewConfiguration.Component.Text mapTextComponent(java.util.Map<?, ?> r36) {
        /*
            r35 = this;
            r0 = r35
            r1 = r36
            java.lang.String r2 = "size"
            java.lang.Object r3 = r1.get(r2)
            boolean r4 = r3 instanceof java.lang.Number
            if (r4 == 0) goto L_0x0011
            java.lang.Number r3 = (java.lang.Number) r3
            goto L_0x0012
        L_0x0011:
            r3 = 0
        L_0x0012:
            if (r3 == 0) goto L_0x001e
            float r3 = r3.floatValue()
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            r9 = r3
            goto L_0x001f
        L_0x001e:
            r9 = 0
        L_0x001f:
            java.lang.String r3 = "color"
            java.lang.Object r4 = r1.get(r3)
            boolean r6 = r4 instanceof java.lang.String
            if (r6 == 0) goto L_0x002d
            java.lang.String r4 = (java.lang.String) r4
            r10 = r4
            goto L_0x002e
        L_0x002d:
            r10 = 0
        L_0x002e:
            java.lang.String r4 = "font"
            java.lang.Object r6 = r1.get(r4)
            boolean r7 = r6 instanceof java.lang.String
            if (r7 == 0) goto L_0x003c
            java.lang.String r6 = (java.lang.String) r6
            r8 = r6
            goto L_0x003d
        L_0x003c:
            r8 = 0
        L_0x003d:
            java.lang.String r6 = "horizontal_align"
            java.lang.Object r7 = r1.get(r6)
            boolean r11 = r7 instanceof java.lang.String
            if (r11 == 0) goto L_0x004a
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x004b
        L_0x004a:
            r7 = 0
        L_0x004b:
            com.adapty.models.AdaptyViewConfiguration$HorizontalAlign r11 = r0.mapHorizontalAlign(r7)
            java.lang.String r7 = "bullet_space"
            java.lang.Object r7 = r1.get(r7)
            boolean r12 = r7 instanceof java.lang.Number
            if (r12 == 0) goto L_0x005c
            java.lang.Number r7 = (java.lang.Number) r7
            goto L_0x005d
        L_0x005c:
            r7 = 0
        L_0x005d:
            if (r7 == 0) goto L_0x0068
            float r7 = r7.floatValue()
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            goto L_0x0069
        L_0x0068:
            r7 = 0
        L_0x0069:
            java.lang.String r12 = "items"
            java.lang.Object r12 = r1.get(r12)
            boolean r13 = r12 instanceof java.util.List
            if (r13 == 0) goto L_0x0076
            java.util.List r12 = (java.util.List) r12
            goto L_0x0077
        L_0x0076:
            r12 = 0
        L_0x0077:
            java.lang.String r13 = "string_id"
            if (r12 == 0) goto L_0x02c4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.Iterator r12 = r12.iterator()
            r16 = 0
            r17 = 0
            r18 = 0
        L_0x008e:
            boolean r19 = r12.hasNext()
            if (r19 == 0) goto L_0x02c1
            java.lang.Object r5 = r12.next()
            int r20 = r16 + 1
            if (r16 >= 0) goto L_0x009f
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x009f:
            boolean r15 = r5 instanceof java.util.Map
            if (r15 == 0) goto L_0x00a6
            java.util.Map r5 = (java.util.Map) r5
            goto L_0x00a7
        L_0x00a6:
            r5 = 0
        L_0x00a7:
            if (r5 == 0) goto L_0x02a1
            java.lang.String r15 = "newline"
            java.lang.Object r15 = r5.get(r15)
            if (r15 == 0) goto L_0x00c5
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$NewLine r5 = com.adapty.models.AdaptyViewConfiguration.Component.Text.Item.NewLine.INSTANCE
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Item r5 = (com.adapty.models.AdaptyViewConfiguration.Component.Text.Item) r5
            r22 = r2
            r23 = r3
            r28 = r4
            r24 = r6
            r21 = r12
        L_0x00bf:
            r17 = 0
            r18 = 0
            goto L_0x02ac
        L_0x00c5:
            java.lang.String r15 = "space"
            java.lang.Object r15 = r5.get(r15)
            r21 = r12
            boolean r12 = r15 instanceof java.lang.Number
            if (r12 == 0) goto L_0x00d4
            java.lang.Number r15 = (java.lang.Number) r15
            goto L_0x00d5
        L_0x00d4:
            r15 = 0
        L_0x00d5:
            if (r15 == 0) goto L_0x00e0
            float r12 = r15.floatValue()
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            goto L_0x00e1
        L_0x00e0:
            r12 = 0
        L_0x00e1:
            if (r12 == 0) goto L_0x0106
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$Space r5 = new com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$Space
            float r12 = r12.floatValue()
            r5.<init>(r12)
            if (r17 != 0) goto L_0x00fa
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Item r5 = (com.adapty.models.AdaptyViewConfiguration.Component.Text.Item) r5
            r22 = r2
            r23 = r3
            r28 = r4
        L_0x00f6:
            r24 = r6
            goto L_0x02ac
        L_0x00fa:
            r22 = r2
            r23 = r3
            r28 = r4
            r18 = r5
        L_0x0102:
            r24 = r6
            goto L_0x02ab
        L_0x0106:
            java.lang.Object r12 = r5.get(r13)
            boolean r15 = r12 instanceof java.lang.String
            if (r15 == 0) goto L_0x0113
            java.lang.String r12 = (java.lang.String) r12
            r23 = r12
            goto L_0x0115
        L_0x0113:
            r23 = 0
        L_0x0115:
            java.lang.String r12 = "bullet"
            if (r23 == 0) goto L_0x01f9
            java.lang.Object r15 = r5.get(r4)
            r28 = r4
            boolean r4 = r15 instanceof java.lang.String
            if (r4 == 0) goto L_0x0126
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x0127
        L_0x0126:
            r15 = 0
        L_0x0127:
            if (r15 != 0) goto L_0x0140
            if (r8 == 0) goto L_0x012e
            r24 = r8
            goto L_0x0142
        L_0x012e:
            com.adapty.errors.AdaptyError r1 = new com.adapty.errors.AdaptyError
            r30 = 0
            com.adapty.errors.AdaptyErrorCode r32 = com.adapty.errors.AdaptyErrorCode.DECODING_FAILED
            r33 = 1
            r34 = 0
            java.lang.String r31 = "fontId in TextItem should not be null"
            r29 = r1
            r29.<init>(r30, r31, r32, r33, r34)
            throw r1
        L_0x0140:
            r24 = r15
        L_0x0142:
            java.lang.Object r4 = r5.get(r2)
            boolean r15 = r4 instanceof java.lang.Number
            if (r15 == 0) goto L_0x014d
            java.lang.Number r4 = (java.lang.Number) r4
            goto L_0x014e
        L_0x014d:
            r4 = 0
        L_0x014e:
            if (r4 == 0) goto L_0x015b
            float r4 = r4.floatValue()
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r25 = r4
            goto L_0x015d
        L_0x015b:
            r25 = r9
        L_0x015d:
            java.lang.Object r4 = r5.get(r3)
            boolean r15 = r4 instanceof java.lang.String
            if (r15 == 0) goto L_0x0168
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0169
        L_0x0168:
            r4 = 0
        L_0x0169:
            if (r4 != 0) goto L_0x016e
            r26 = r10
            goto L_0x0170
        L_0x016e:
            r26 = r4
        L_0x0170:
            java.lang.Object r4 = r5.get(r6)
            boolean r15 = r4 instanceof java.lang.String
            if (r15 == 0) goto L_0x017b
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x017c
        L_0x017b:
            r4 = 0
        L_0x017c:
            if (r4 == 0) goto L_0x0188
            com.adapty.models.AdaptyViewConfiguration$HorizontalAlign r4 = r0.mapHorizontalAlign(r4)
            if (r4 != 0) goto L_0x0185
            goto L_0x0188
        L_0x0185:
            r27 = r4
            goto L_0x018a
        L_0x0188:
            r27 = r11
        L_0x018a:
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$Text r4 = new com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$Text
            r22 = r4
            r22.<init>(r23, r24, r25, r26, r27)
            java.lang.Object r5 = r5.get(r12)
            boolean r12 = r5 instanceof java.lang.Boolean
            if (r12 == 0) goto L_0x019c
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            goto L_0x019d
        L_0x019c:
            r5 = 0
        L_0x019d:
            r12 = 1
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r12)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r15)
            if (r5 == 0) goto L_0x01c5
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$BulletedText$TextBullet r5 = new com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$BulletedText$TextBullet
            r5.<init>(r4)
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$NewLine r4 = com.adapty.models.AdaptyViewConfiguration.Component.Text.Item.NewLine.INSTANCE
            if (r16 <= 0) goto L_0x01b3
            r15 = 1
            goto L_0x01b4
        L_0x01b3:
            r15 = 0
        L_0x01b4:
            if (r15 == 0) goto L_0x01b7
            goto L_0x01b8
        L_0x01b7:
            r4 = 0
        L_0x01b8:
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Item r4 = (com.adapty.models.AdaptyViewConfiguration.Component.Text.Item) r4
            r22 = r2
            r23 = r3
            r17 = r5
            r24 = r6
            r5 = r4
            goto L_0x02ac
        L_0x01c5:
            r5 = r17
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$BulletedText$Bullet r5 = (com.adapty.models.AdaptyViewConfiguration.Component.Text.Item.BulletedText.Bullet) r5
            if (r5 == 0) goto L_0x01f0
            if (r18 != 0) goto L_0x01de
            if (r7 == 0) goto L_0x01dc
            r12 = r7
            java.lang.Number r12 = (java.lang.Number) r12
            float r12 = r12.floatValue()
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$Space r15 = new com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$Space
            r15.<init>(r12)
            goto L_0x01e0
        L_0x01dc:
            r15 = 0
            goto L_0x01e0
        L_0x01de:
            r15 = r18
        L_0x01e0:
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$BulletedText r12 = new com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$BulletedText
            r12.<init>(r5, r15, r4)
            r5 = r12
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Item r5 = (com.adapty.models.AdaptyViewConfiguration.Component.Text.Item) r5
            r22 = r2
            r23 = r3
            r24 = r6
            goto L_0x00bf
        L_0x01f0:
            r5 = r4
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Item r5 = (com.adapty.models.AdaptyViewConfiguration.Component.Text.Item) r5
            r22 = r2
            r23 = r3
            goto L_0x00f6
        L_0x01f9:
            r28 = r4
            java.lang.String r4 = "image"
            java.lang.Object r4 = r5.get(r4)
            boolean r15 = r4 instanceof java.lang.String
            if (r15 == 0) goto L_0x0208
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0209
        L_0x0208:
            r4 = 0
        L_0x0209:
            if (r4 == 0) goto L_0x029b
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$Image r15 = new com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$Image
            java.lang.Object r0 = r5.get(r3)
            r22 = r2
            boolean r2 = r0 instanceof java.lang.String
            if (r2 == 0) goto L_0x021a
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x021b
        L_0x021a:
            r0 = 0
        L_0x021b:
            java.lang.String r2 = "width"
            java.lang.Object r2 = r5.get(r2)
            r23 = r3
            boolean r3 = r2 instanceof java.lang.Number
            if (r3 == 0) goto L_0x022a
            java.lang.Number r2 = (java.lang.Number) r2
            goto L_0x022b
        L_0x022a:
            r2 = 0
        L_0x022b:
            if (r2 == 0) goto L_0x028d
            float r2 = r2.floatValue()
            java.lang.String r3 = "height"
            java.lang.Object r3 = r5.get(r3)
            r24 = r6
            boolean r6 = r3 instanceof java.lang.Number
            if (r6 == 0) goto L_0x0240
            java.lang.Number r3 = (java.lang.Number) r3
            goto L_0x0241
        L_0x0240:
            r3 = 0
        L_0x0241:
            if (r3 == 0) goto L_0x027b
            float r3 = r3.floatValue()
            r15.<init>(r4, r0, r2, r3)
            java.lang.Object r0 = r5.get(r12)
            boolean r2 = r0 instanceof java.lang.Boolean
            if (r2 == 0) goto L_0x0255
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            goto L_0x0256
        L_0x0255:
            r0 = 0
        L_0x0256:
            r2 = 1
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x0277
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$BulletedText$ImageBullet r0 = new com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$BulletedText$ImageBullet
            r0.<init>(r15)
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Item$NewLine r3 = com.adapty.models.AdaptyViewConfiguration.Component.Text.Item.NewLine.INSTANCE
            if (r16 <= 0) goto L_0x026c
            r15 = r2
            goto L_0x026d
        L_0x026c:
            r15 = 0
        L_0x026d:
            if (r15 == 0) goto L_0x0270
            goto L_0x0271
        L_0x0270:
            r3 = 0
        L_0x0271:
            r5 = r3
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Item r5 = (com.adapty.models.AdaptyViewConfiguration.Component.Text.Item) r5
            r17 = r0
            goto L_0x02ac
        L_0x0277:
            r5 = r15
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Item r5 = (com.adapty.models.AdaptyViewConfiguration.Component.Text.Item) r5
            goto L_0x02ac
        L_0x027b:
            com.adapty.errors.AdaptyError r0 = new com.adapty.errors.AdaptyError
            r30 = 0
            com.adapty.errors.AdaptyErrorCode r32 = com.adapty.errors.AdaptyErrorCode.DECODING_FAILED
            r33 = 1
            r34 = 0
            java.lang.String r31 = "height in ImageItem should not be null"
            r29 = r0
            r29.<init>(r30, r31, r32, r33, r34)
            throw r0
        L_0x028d:
            com.adapty.errors.AdaptyError r0 = new com.adapty.errors.AdaptyError
            r2 = 0
            com.adapty.errors.AdaptyErrorCode r4 = com.adapty.errors.AdaptyErrorCode.DECODING_FAILED
            r5 = 1
            r6 = 0
            java.lang.String r3 = "width in ImageItem should not be null"
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            throw r0
        L_0x029b:
            r22 = r2
            r23 = r3
            goto L_0x0102
        L_0x02a1:
            r22 = r2
            r23 = r3
            r28 = r4
            r24 = r6
            r21 = r12
        L_0x02ab:
            r5 = 0
        L_0x02ac:
            if (r5 == 0) goto L_0x02b1
            r14.add(r5)
        L_0x02b1:
            r0 = r35
            r16 = r20
            r12 = r21
            r2 = r22
            r3 = r23
            r6 = r24
            r4 = r28
            goto L_0x008e
        L_0x02c1:
            java.util.List r14 = (java.util.List) r14
            goto L_0x02c5
        L_0x02c4:
            r14 = 0
        L_0x02c5:
            if (r14 == 0) goto L_0x02cf
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Multiple r0 = new com.adapty.models.AdaptyViewConfiguration$Component$Text$Multiple
            r0.<init>(r14, r11)
            com.adapty.models.AdaptyViewConfiguration$Component$Text r0 = (com.adapty.models.AdaptyViewConfiguration.Component.Text) r0
            goto L_0x02e9
        L_0x02cf:
            com.adapty.models.AdaptyViewConfiguration$Component$Text$Single r0 = new com.adapty.models.AdaptyViewConfiguration$Component$Text$Single
            java.lang.Object r1 = r1.get(r13)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x02de
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5
            r7 = r5
            goto L_0x02df
        L_0x02de:
            r7 = 0
        L_0x02df:
            if (r7 == 0) goto L_0x02f8
            if (r8 == 0) goto L_0x02ea
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            com.adapty.models.AdaptyViewConfiguration$Component$Text r0 = (com.adapty.models.AdaptyViewConfiguration.Component.Text) r0
        L_0x02e9:
            return r0
        L_0x02ea:
            com.adapty.errors.AdaptyError r0 = new com.adapty.errors.AdaptyError
            r2 = 0
            com.adapty.errors.AdaptyErrorCode r4 = com.adapty.errors.AdaptyErrorCode.DECODING_FAILED
            r5 = 1
            r6 = 0
            java.lang.String r3 = "font in Text should not be null"
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            throw r0
        L_0x02f8:
            com.adapty.errors.AdaptyError r0 = new com.adapty.errors.AdaptyError
            r8 = 0
            com.adapty.errors.AdaptyErrorCode r10 = com.adapty.errors.AdaptyErrorCode.DECODING_FAILED
            r11 = 1
            r12 = 0
            java.lang.String r9 = "stringId in Text should not be null"
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.ViewConfigurationMapper.mapTextComponent(java.util.Map):com.adapty.models.AdaptyViewConfiguration$Component$Text");
    }

    private final AdaptyViewConfiguration.Component.Button mapButtonComponent(Map<?, ?> map) {
        Object obj = map.get("shape");
        AdaptyViewConfiguration.Component.Button.Transition transition = null;
        Map map2 = obj instanceof Map ? (Map) obj : null;
        AdaptyViewConfiguration.Component.Shape mapShapeComponent = map2 != null ? mapShapeComponent(map2) : null;
        Object obj2 = map.get("selected_shape");
        Map map3 = obj2 instanceof Map ? (Map) obj2 : null;
        AdaptyViewConfiguration.Component.Shape mapShapeComponent2 = map3 != null ? mapShapeComponent(map3) : null;
        Object obj3 = map.get("title");
        Map map4 = obj3 instanceof Map ? (Map) obj3 : null;
        AdaptyViewConfiguration.Component.Text mapTextComponent = map4 != null ? mapTextComponent(map4) : null;
        Object obj4 = map.get("selected_title");
        Map map5 = obj4 instanceof Map ? (Map) obj4 : null;
        AdaptyViewConfiguration.Component.Text mapTextComponent2 = map5 != null ? mapTextComponent(map5) : null;
        Object obj5 = map.get("align");
        AdaptyViewConfiguration.Component.Button.Align mapButtonAlign = mapButtonAlign(obj5 instanceof String ? (String) obj5 : null);
        Object obj6 = map.get("action");
        Map map6 = obj6 instanceof Map ? (Map) obj6 : null;
        AdaptyViewConfiguration.Component.Button.Action mapButtonAction = map6 != null ? mapButtonAction(map6) : null;
        Object obj7 = map.get("visibility");
        Boolean bool = obj7 instanceof Boolean ? (Boolean) obj7 : null;
        boolean booleanValue = bool != null ? bool.booleanValue() : true;
        Object obj8 = map.get("transition_in");
        Map map7 = obj8 instanceof Map ? (Map) obj8 : null;
        if (map7 != null) {
            transition = mapButtonTransition(map7);
        }
        return new AdaptyViewConfiguration.Component.Button(mapShapeComponent, mapShapeComponent2, mapTextComponent, mapTextComponent2, mapButtonAlign, mapButtonAction, booleanValue, transition);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0020 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.adapty.models.AdaptyViewConfiguration.Component.ProductObject mapProductObjectComponent(java.util.Map<?, ?> r9) {
        /*
            r8 = this;
            java.lang.String r0 = "product_id"
            java.lang.Object r1 = r9.get(r0)
            boolean r2 = r1 instanceof java.lang.String
            r3 = 0
            if (r2 == 0) goto L_0x000e
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x000f
        L_0x000e:
            r1 = r3
        L_0x000f:
            if (r1 == 0) goto L_0x0073
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Set r9 = r9.entrySet()
            java.util.Iterator r9 = r9.iterator()
        L_0x0020:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L_0x0065
            java.lang.Object r4 = r9.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            boolean r6 = r5 instanceof java.lang.String
            if (r6 != 0) goto L_0x003a
        L_0x0038:
            r4 = r3
            goto L_0x005f
        L_0x003a:
            java.lang.String r6 = "type"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            r7 = 1
            if (r6 == 0) goto L_0x0045
            r6 = r7
            goto L_0x004b
        L_0x0045:
            java.lang.String r6 = "order"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
        L_0x004b:
            if (r6 == 0) goto L_0x004e
            goto L_0x0052
        L_0x004e:
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r0)
        L_0x0052:
            if (r7 == 0) goto L_0x0055
            goto L_0x0038
        L_0x0055:
            com.adapty.models.AdaptyViewConfiguration$Component r4 = r8.mapVisualStyleComponent(r4)
            if (r4 == 0) goto L_0x0038
            kotlin.Pair r4 = kotlin.TuplesKt.to(r5, r4)
        L_0x005f:
            if (r4 == 0) goto L_0x0020
            r2.add(r4)
            goto L_0x0020
        L_0x0065:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Map r9 = kotlin.collections.MapsKt.toMap(r2)
            com.adapty.models.AdaptyViewConfiguration$Component$ProductObject r0 = new com.adapty.models.AdaptyViewConfiguration$Component$ProductObject
            r0.<init>(r1, r9)
            return r0
        L_0x0073:
            com.adapty.errors.AdaptyError r9 = new com.adapty.errors.AdaptyError
            r3 = 0
            com.adapty.errors.AdaptyErrorCode r5 = com.adapty.errors.AdaptyErrorCode.DECODING_FAILED
            r6 = 1
            r7 = 0
            java.lang.String r4 = "productId in Product should not be null"
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.ViewConfigurationMapper.mapProductObjectComponent(java.util.Map):com.adapty.models.AdaptyViewConfiguration$Component$ProductObject");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0021 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.adapty.models.AdaptyViewConfiguration.Component.CustomObject mapCustomObjectComponent(java.util.Map<?, ?> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "type"
            java.lang.Object r1 = r8.get(r0)
            boolean r2 = r1 instanceof java.lang.String
            r3 = 0
            if (r2 == 0) goto L_0x000e
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x000f
        L_0x000e:
            r1 = r3
        L_0x000f:
            if (r1 != 0) goto L_0x0012
            return r3
        L_0x0012:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x0021:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L_0x0056
            java.lang.Object r4 = r8.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            boolean r6 = r5 instanceof java.lang.String
            if (r6 != 0) goto L_0x003b
        L_0x0039:
            r4 = r3
            goto L_0x0050
        L_0x003b:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r0)
            if (r6 == 0) goto L_0x0043
            r6 = 1
            goto L_0x0049
        L_0x0043:
            java.lang.String r6 = "order"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
        L_0x0049:
            if (r6 == 0) goto L_0x004c
            goto L_0x0039
        L_0x004c:
            kotlin.Pair r4 = kotlin.TuplesKt.to(r5, r4)
        L_0x0050:
            if (r4 == 0) goto L_0x0021
            r2.add(r4)
            goto L_0x0021
        L_0x0056:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            com.adapty.internal.utils.ViewConfigurationMapper$$ExternalSyntheticLambda2 r8 = new com.adapty.internal.utils.ViewConfigurationMapper$$ExternalSyntheticLambda2
            r8.<init>(r7)
            java.util.List r8 = kotlin.collections.CollectionsKt.sortedWith(r2, r8)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r8 = r8.iterator()
        L_0x0070:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x0098
            java.lang.Object r2 = r8.next()
            kotlin.Pair r2 = (kotlin.Pair) r2
            java.lang.Object r4 = r2.component1()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r2 = r2.component2()
            com.adapty.models.AdaptyViewConfiguration$Component r2 = r7.mapVisualStyleComponent(r2)
            if (r2 == 0) goto L_0x0091
            kotlin.Pair r2 = kotlin.TuplesKt.to(r4, r2)
            goto L_0x0092
        L_0x0091:
            r2 = r3
        L_0x0092:
            if (r2 == 0) goto L_0x0070
            r0.add(r2)
            goto L_0x0070
        L_0x0098:
            java.util.List r0 = (java.util.List) r0
            com.adapty.models.AdaptyViewConfiguration$Component$CustomObject r8 = new com.adapty.models.AdaptyViewConfiguration$Component$CustomObject
            r8.<init>(r1, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.ViewConfigurationMapper.mapCustomObjectComponent(java.util.Map):com.adapty.models.AdaptyViewConfiguration$Component$CustomObject");
    }

    /* access modifiers changed from: private */
    public static final int mapCustomObjectComponent$lambda$32(ViewConfigurationMapper viewConfigurationMapper, Pair pair, Pair pair2) {
        Intrinsics.checkNotNullParameter(viewConfigurationMapper, "this$0");
        return viewConfigurationMapper.compareByOrder(pair.component2(), pair2.component2());
    }

    private final int compareByOrder(Object obj, Object obj2) {
        int intValue;
        Number number = null;
        Map map = obj instanceof Map ? (Map) obj : null;
        Object obj3 = map != null ? map.get("order") : null;
        Number number2 = obj3 instanceof Number ? (Number) obj3 : null;
        if (number2 == null) {
            return 0;
        }
        int intValue2 = number2.intValue();
        Map map2 = obj2 instanceof Map ? (Map) obj2 : null;
        Object obj4 = map2 != null ? map2.get("order") : null;
        if (obj4 instanceof Number) {
            number = (Number) obj4;
        }
        if (number == null || (intValue = intValue2 - number.intValue()) == 0) {
            return 0;
        }
        return intValue / Math.abs(intValue);
    }

    private final AdaptyViewConfiguration.HorizontalAlign mapHorizontalAlign(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) TtmlNode.CENTER)) {
            return AdaptyViewConfiguration.HorizontalAlign.CENTER;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "right")) {
            return AdaptyViewConfiguration.HorizontalAlign.RIGHT;
        }
        return AdaptyViewConfiguration.HorizontalAlign.LEFT;
    }

    private final AdaptyViewConfiguration.Component.Button.Align mapButtonAlign(String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 3143043) {
                if (hashCode != 50359046) {
                    if (hashCode == 1276059676 && str.equals("trailing")) {
                        return AdaptyViewConfiguration.Component.Button.Align.TRAILING;
                    }
                } else if (str.equals("leading")) {
                    return AdaptyViewConfiguration.Component.Button.Align.LEADING;
                }
            } else if (str.equals("fill")) {
                return AdaptyViewConfiguration.Component.Button.Align.FILL;
            }
        }
        return AdaptyViewConfiguration.Component.Button.Align.CENTER;
    }

    private final AdaptyViewConfiguration.Component.Button.Action mapButtonAction(Map<?, ?> map) {
        Object obj = map.get("type");
        String str = null;
        if (Intrinsics.areEqual((Object) obj, (Object) AdaptyUIActionTypeAdapterFactory.TYPE_OPEN_URL)) {
            Object obj2 = map.get("url");
            if (obj2 instanceof String) {
                str = (String) obj2;
            }
            if (str != null) {
                return new AdaptyViewConfiguration.Component.Button.Action.OpenUrl(str);
            }
            throw new AdaptyError((Throwable) null, "url value should not be null when type is open_url", AdaptyErrorCode.DECODING_FAILED, 1, (DefaultConstructorMarker) null);
        } else if (Intrinsics.areEqual((Object) obj, (Object) "restore")) {
            return AdaptyViewConfiguration.Component.Button.Action.Restore.INSTANCE;
        } else {
            if (Intrinsics.areEqual((Object) obj, (Object) AdaptyUIActionTypeAdapterFactory.TYPE_CLOSE)) {
                return AdaptyViewConfiguration.Component.Button.Action.Close.INSTANCE;
            }
            if (!Intrinsics.areEqual((Object) obj, (Object) AdaptyUIActionTypeAdapterFactory.TYPE_CUSTOM)) {
                return null;
            }
            Object obj3 = map.get("custom_id");
            if (obj3 instanceof String) {
                str = (String) obj3;
            }
            if (str != null) {
                return new AdaptyViewConfiguration.Component.Button.Action.Custom(str);
            }
            throw new AdaptyError((Throwable) null, "custom_id value should not be null when type is custom", AdaptyErrorCode.DECODING_FAILED, 1, (DefaultConstructorMarker) null);
        }
    }

    private final AdaptyViewConfiguration.Component.Button.Transition mapButtonTransition(Map<?, ?> map) {
        String str = null;
        if (!Intrinsics.areEqual((Object) map.get("type"), (Object) "fade")) {
            return null;
        }
        Object obj = map.get("duration");
        Number number = obj instanceof Number ? (Number) obj : null;
        long longValue = number != null ? number.longValue() : 300;
        Object obj2 = map.get("start_delay");
        Number number2 = obj2 instanceof Number ? (Number) obj2 : null;
        long longValue2 = number2 != null ? number2.longValue() : 0;
        Object obj3 = map.get("interpolator");
        if (obj3 instanceof String) {
            str = (String) obj3;
        }
        return new AdaptyViewConfiguration.Component.Button.Transition.Fade(longValue, longValue2, str == null ? "ease_in_out" : str);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01b6, code lost:
        if ((r9 instanceof java.lang.Number) == false) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01b8, code lost:
        r9 = (java.lang.Number) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01bb, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01bc, code lost:
        if (r9 == null) goto L_0x01f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01be, code lost:
        r9 = r9.floatValue();
        r10 = r6.get("x1");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01ca, code lost:
        if ((r10 instanceof java.lang.Number) == false) goto L_0x01cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01cc, code lost:
        r10 = (java.lang.Number) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01cf, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01d0, code lost:
        if (r10 == null) goto L_0x01f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01d2, code lost:
        r10 = r10.floatValue();
        r6 = r6.get("y1");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01de, code lost:
        if ((r6 instanceof java.lang.Number) == false) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01e0, code lost:
        r6 = (java.lang.Number) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01e3, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01e4, code lost:
        if (r6 == null) goto L_0x01f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01e6, code lost:
        r11 = new com.adapty.models.AdaptyViewConfiguration.Asset.Gradient.Points(r8, r9, r10, r6.floatValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01f0, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01f1, code lost:
        if (r11 == null) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01f3, code lost:
        r5 = new com.adapty.models.AdaptyViewConfiguration.Asset.Gradient(r5, r7, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0209, code lost:
        throw new com.adapty.errors.AdaptyError((java.lang.Throwable) null, "gradient points should not be null", com.adapty.errors.AdaptyErrorCode.DECODING_FAILED, 1, (kotlin.jvm.internal.DefaultConstructorMarker) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0219, code lost:
        throw new com.adapty.errors.AdaptyError((java.lang.Throwable) null, "gradient values should not be null", com.adapty.errors.AdaptyErrorCode.DECODING_FAILED, 1, (kotlin.jvm.internal.DefaultConstructorMarker) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
        if (r5.equals("radial-gradient") == false) goto L_0x021a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (r5.equals("linear-gradient") == false) goto L_0x021a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0107, code lost:
        if (r5.equals("conic-gradient") == false) goto L_0x021a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x010b, code lost:
        r5 = r4.getType();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0113, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) "radial-gradient") == false) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0115, code lost:
        r5 = com.adapty.models.AdaptyViewConfiguration.Asset.Gradient.Type.RADIAL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x011c, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) "conic-gradient") == false) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x011e, code lost:
        r5 = com.adapty.models.AdaptyViewConfiguration.Asset.Gradient.Type.CONIC;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0121, code lost:
        r5 = com.adapty.models.AdaptyViewConfiguration.Asset.Gradient.Type.LINEAR;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0123, code lost:
        r6 = r4.getValues();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0129, code lost:
        if ((r6 instanceof java.util.List) == false) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012c, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x012d, code lost:
        if (r6 == null) goto L_0x020a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012f, code lost:
        r7 = new java.util.ArrayList();
        r6 = r6.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0140, code lost:
        if (r6.hasNext() == false) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0142, code lost:
        r9 = r6.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0148, code lost:
        if ((r9 instanceof java.util.HashMap) == false) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x014a, code lost:
        r9 = (java.util.HashMap) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x014d, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x014e, code lost:
        if (r9 == null) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0150, code lost:
        r9 = r9;
        r10 = r9.get("p");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x015a, code lost:
        if ((r10 instanceof java.lang.Number) == false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x015c, code lost:
        r10 = (java.lang.Number) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x015f, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0160, code lost:
        if (r10 == null) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0162, code lost:
        r10 = r10.floatValue();
        r9 = r9.get("color");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x016c, code lost:
        if ((r9 instanceof java.lang.String) == false) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x016e, code lost:
        r9 = (java.lang.String) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0171, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0172, code lost:
        if (r9 == null) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0174, code lost:
        r9 = new com.adapty.models.AdaptyViewConfiguration.Asset.Gradient.Value(r10, new com.adapty.models.AdaptyViewConfiguration.Asset.Color(mapVisualAssetColorString(r9)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0183, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0184, code lost:
        if (r9 == null) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0186, code lost:
        r7.add(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x018a, code lost:
        r7 = (java.util.List) r7;
        r6 = r4.getPoints();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0192, code lost:
        if ((r6 instanceof java.util.HashMap) == false) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0195, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0196, code lost:
        if (r6 == null) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0198, code lost:
        r6 = r6;
        r8 = r6.get("x0");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01a2, code lost:
        if ((r8 instanceof java.lang.Number) == false) goto L_0x01a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01a4, code lost:
        r8 = (java.lang.Number) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01a7, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01a8, code lost:
        if (r8 == null) goto L_0x01f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01aa, code lost:
        r8 = r8.floatValue();
        r9 = r6.get("y0");
     */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0014 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.Map<java.lang.String, com.adapty.models.AdaptyViewConfiguration.Asset> mapVisualAssets(java.util.List<com.adapty.internal.data.models.ViewConfigurationConfig.Asset> r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = 0
            if (r19 == 0) goto L_0x0236
            r2 = r19
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r2 = r2.iterator()
        L_0x0014:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x022e
            java.lang.Object r4 = r2.next()
            com.adapty.internal.data.models.ViewConfigurationConfig$Asset r4 = (com.adapty.internal.data.models.ViewConfigurationConfig.Asset) r4
            java.lang.String r5 = r4.getId()
            if (r5 == 0) goto L_0x0226
            java.lang.String r5 = r4.getType()
            if (r5 == 0) goto L_0x0226
            java.lang.String r5 = r4.getType()
            if (r5 == 0) goto L_0x021a
            int r6 = r5.hashCode()
            java.lang.String r7 = "radial-gradient"
            java.lang.String r8 = "color"
            java.lang.String r9 = "conic-gradient"
            switch(r6) {
                case -1317182527: goto L_0x0103;
                case 3148879: goto L_0x00a4;
                case 94842723: goto L_0x0072;
                case 100313435: goto L_0x0053;
                case 1520903384: goto L_0x0049;
                case 2060256030: goto L_0x0041;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x021a
        L_0x0041:
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L_0x010b
            goto L_0x021a
        L_0x0049:
            java.lang.String r6 = "linear-gradient"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x010b
            goto L_0x021a
        L_0x0053:
            java.lang.String r6 = "image"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x005d
            goto L_0x021a
        L_0x005d:
            com.adapty.models.AdaptyViewConfiguration$Asset$Image r5 = new com.adapty.models.AdaptyViewConfiguration$Asset$Image
            java.lang.Object r6 = r4.getValue()
            boolean r7 = r6 instanceof java.lang.String
            if (r7 == 0) goto L_0x006a
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x006b
        L_0x006a:
            r6 = r1
        L_0x006b:
            r5.<init>(r6)
            com.adapty.models.AdaptyViewConfiguration$Asset r5 = (com.adapty.models.AdaptyViewConfiguration.Asset) r5
            goto L_0x021b
        L_0x0072:
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L_0x007a
            goto L_0x021a
        L_0x007a:
            java.lang.Object r5 = r4.getValue()
            boolean r6 = r5 instanceof java.lang.String
            if (r6 == 0) goto L_0x0085
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0086
        L_0x0085:
            r5 = r1
        L_0x0086:
            if (r5 == 0) goto L_0x0096
            int r5 = r0.mapVisualAssetColorString(r5)
            com.adapty.models.AdaptyViewConfiguration$Asset$Color r6 = new com.adapty.models.AdaptyViewConfiguration$Asset$Color
            r6.<init>(r5)
            r5 = r6
            com.adapty.models.AdaptyViewConfiguration$Asset r5 = (com.adapty.models.AdaptyViewConfiguration.Asset) r5
            goto L_0x021b
        L_0x0096:
            com.adapty.errors.AdaptyError r1 = new com.adapty.errors.AdaptyError
            r7 = 0
            com.adapty.errors.AdaptyErrorCode r9 = com.adapty.errors.AdaptyErrorCode.DECODING_FAILED
            r10 = 1
            r11 = 0
            java.lang.String r8 = "color value should not be null"
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11)
            throw r1
        L_0x00a4:
            java.lang.String r6 = "font"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00ae
            goto L_0x021a
        L_0x00ae:
            java.lang.String r5 = r4.getFamilyName()
            if (r5 != 0) goto L_0x00b6
            java.lang.String r5 = "adapty_system"
        L_0x00b6:
            r7 = r5
            java.lang.String[] r5 = r4.getResources()
            r6 = 0
            if (r5 != 0) goto L_0x00c0
            java.lang.String[] r5 = new java.lang.String[r6]
        L_0x00c0:
            r8 = r5
            java.lang.Integer r5 = r4.getWeight()
            if (r5 == 0) goto L_0x00cc
            int r5 = r5.intValue()
            goto L_0x00ce
        L_0x00cc:
            r5 = 400(0x190, float:5.6E-43)
        L_0x00ce:
            r9 = r5
            java.lang.Boolean r5 = r4.isItalic()
            if (r5 == 0) goto L_0x00db
            boolean r5 = r5.booleanValue()
            r10 = r5
            goto L_0x00dc
        L_0x00db:
            r10 = r6
        L_0x00dc:
            java.lang.Float r11 = r4.getSize()
            java.lang.String r5 = r4.getHorizontalAlign()
            com.adapty.models.AdaptyViewConfiguration$HorizontalAlign r12 = r0.mapHorizontalAlign(r5)
            java.lang.String r5 = r4.getColor()
            if (r5 == 0) goto L_0x00f8
            int r5 = r0.mapVisualAssetColorString(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r13 = r5
            goto L_0x00f9
        L_0x00f8:
            r13 = r1
        L_0x00f9:
            com.adapty.models.AdaptyViewConfiguration$Asset$Font r5 = new com.adapty.models.AdaptyViewConfiguration$Asset$Font
            r6 = r5
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            com.adapty.models.AdaptyViewConfiguration$Asset r5 = (com.adapty.models.AdaptyViewConfiguration.Asset) r5
            goto L_0x021b
        L_0x0103:
            boolean r5 = r5.equals(r9)
            if (r5 != 0) goto L_0x010b
            goto L_0x021a
        L_0x010b:
            java.lang.String r5 = r4.getType()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0118
            com.adapty.models.AdaptyViewConfiguration$Asset$Gradient$Type r5 = com.adapty.models.AdaptyViewConfiguration.Asset.Gradient.Type.RADIAL
            goto L_0x0123
        L_0x0118:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r9)
            if (r5 == 0) goto L_0x0121
            com.adapty.models.AdaptyViewConfiguration$Asset$Gradient$Type r5 = com.adapty.models.AdaptyViewConfiguration.Asset.Gradient.Type.CONIC
            goto L_0x0123
        L_0x0121:
            com.adapty.models.AdaptyViewConfiguration$Asset$Gradient$Type r5 = com.adapty.models.AdaptyViewConfiguration.Asset.Gradient.Type.LINEAR
        L_0x0123:
            java.util.List r6 = r4.getValues()
            boolean r7 = r6 instanceof java.util.List
            if (r7 == 0) goto L_0x012c
            goto L_0x012d
        L_0x012c:
            r6 = r1
        L_0x012d:
            if (r6 == 0) goto L_0x020a
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r6 = r6.iterator()
        L_0x013c:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x018a
            java.lang.Object r9 = r6.next()
            boolean r10 = r9 instanceof java.util.HashMap
            if (r10 == 0) goto L_0x014d
            java.util.HashMap r9 = (java.util.HashMap) r9
            goto L_0x014e
        L_0x014d:
            r9 = r1
        L_0x014e:
            if (r9 == 0) goto L_0x0183
            java.util.Map r9 = (java.util.Map) r9
            java.lang.String r10 = "p"
            java.lang.Object r10 = r9.get(r10)
            boolean r11 = r10 instanceof java.lang.Number
            if (r11 == 0) goto L_0x015f
            java.lang.Number r10 = (java.lang.Number) r10
            goto L_0x0160
        L_0x015f:
            r10 = r1
        L_0x0160:
            if (r10 == 0) goto L_0x0183
            float r10 = r10.floatValue()
            java.lang.Object r9 = r9.get(r8)
            boolean r11 = r9 instanceof java.lang.String
            if (r11 == 0) goto L_0x0171
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x0172
        L_0x0171:
            r9 = r1
        L_0x0172:
            if (r9 == 0) goto L_0x0183
            int r9 = r0.mapVisualAssetColorString(r9)
            com.adapty.models.AdaptyViewConfiguration$Asset$Color r11 = new com.adapty.models.AdaptyViewConfiguration$Asset$Color
            r11.<init>(r9)
            com.adapty.models.AdaptyViewConfiguration$Asset$Gradient$Value r9 = new com.adapty.models.AdaptyViewConfiguration$Asset$Gradient$Value
            r9.<init>(r10, r11)
            goto L_0x0184
        L_0x0183:
            r9 = r1
        L_0x0184:
            if (r9 == 0) goto L_0x013c
            r7.add(r9)
            goto L_0x013c
        L_0x018a:
            java.util.List r7 = (java.util.List) r7
            java.util.HashMap r6 = r4.getPoints()
            boolean r8 = r6 instanceof java.util.HashMap
            if (r8 == 0) goto L_0x0195
            goto L_0x0196
        L_0x0195:
            r6 = r1
        L_0x0196:
            if (r6 == 0) goto L_0x01fc
            java.util.Map r6 = (java.util.Map) r6
            java.lang.String r8 = "x0"
            java.lang.Object r8 = r6.get(r8)
            boolean r9 = r8 instanceof java.lang.Number
            if (r9 == 0) goto L_0x01a7
            java.lang.Number r8 = (java.lang.Number) r8
            goto L_0x01a8
        L_0x01a7:
            r8 = r1
        L_0x01a8:
            if (r8 == 0) goto L_0x01f0
            float r8 = r8.floatValue()
            java.lang.String r9 = "y0"
            java.lang.Object r9 = r6.get(r9)
            boolean r10 = r9 instanceof java.lang.Number
            if (r10 == 0) goto L_0x01bb
            java.lang.Number r9 = (java.lang.Number) r9
            goto L_0x01bc
        L_0x01bb:
            r9 = r1
        L_0x01bc:
            if (r9 == 0) goto L_0x01f0
            float r9 = r9.floatValue()
            java.lang.String r10 = "x1"
            java.lang.Object r10 = r6.get(r10)
            boolean r11 = r10 instanceof java.lang.Number
            if (r11 == 0) goto L_0x01cf
            java.lang.Number r10 = (java.lang.Number) r10
            goto L_0x01d0
        L_0x01cf:
            r10 = r1
        L_0x01d0:
            if (r10 == 0) goto L_0x01f0
            float r10 = r10.floatValue()
            java.lang.String r11 = "y1"
            java.lang.Object r6 = r6.get(r11)
            boolean r11 = r6 instanceof java.lang.Number
            if (r11 == 0) goto L_0x01e3
            java.lang.Number r6 = (java.lang.Number) r6
            goto L_0x01e4
        L_0x01e3:
            r6 = r1
        L_0x01e4:
            if (r6 == 0) goto L_0x01f0
            float r6 = r6.floatValue()
            com.adapty.models.AdaptyViewConfiguration$Asset$Gradient$Points r11 = new com.adapty.models.AdaptyViewConfiguration$Asset$Gradient$Points
            r11.<init>(r8, r9, r10, r6)
            goto L_0x01f1
        L_0x01f0:
            r11 = r1
        L_0x01f1:
            if (r11 == 0) goto L_0x01fc
            com.adapty.models.AdaptyViewConfiguration$Asset$Gradient r6 = new com.adapty.models.AdaptyViewConfiguration$Asset$Gradient
            r6.<init>(r5, r7, r11)
            r5 = r6
            com.adapty.models.AdaptyViewConfiguration$Asset r5 = (com.adapty.models.AdaptyViewConfiguration.Asset) r5
            goto L_0x021b
        L_0x01fc:
            com.adapty.errors.AdaptyError r1 = new com.adapty.errors.AdaptyError
            r7 = 0
            com.adapty.errors.AdaptyErrorCode r9 = com.adapty.errors.AdaptyErrorCode.DECODING_FAILED
            r10 = 1
            r11 = 0
            java.lang.String r8 = "gradient points should not be null"
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11)
            throw r1
        L_0x020a:
            com.adapty.errors.AdaptyError r1 = new com.adapty.errors.AdaptyError
            r13 = 0
            com.adapty.errors.AdaptyErrorCode r15 = com.adapty.errors.AdaptyErrorCode.DECODING_FAILED
            r16 = 1
            r17 = 0
            java.lang.String r14 = "gradient values should not be null"
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17)
            throw r1
        L_0x021a:
            r5 = r1
        L_0x021b:
            if (r5 == 0) goto L_0x0226
            java.lang.String r4 = r4.getId()
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r5)
            goto L_0x0227
        L_0x0226:
            r4 = r1
        L_0x0227:
            if (r4 == 0) goto L_0x0014
            r3.add(r4)
            goto L_0x0014
        L_0x022e:
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Map r1 = kotlin.collections.MapsKt.toMap(r3)
        L_0x0236:
            if (r1 != 0) goto L_0x023c
            java.util.Map r1 = kotlin.collections.MapsKt.emptyMap()
        L_0x023c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.ViewConfigurationMapper.mapVisualAssets(java.util.List):java.util.Map");
    }

    private final int mapVisualAssetColorString(String str) {
        try {
            if (str.length() == 9) {
                str = rgbaToArgbStr(str);
            }
            return Color.parseColor(str);
        } catch (Exception e) {
            throw new AdaptyError(e, "color value should be a valid #RRGGBB or #RRGGBBAA", AdaptyErrorCode.DECODING_FAILED);
        }
    }

    private final String rgbaToArgbStr(String str) {
        char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        char c = charArray[7];
        char c2 = charArray[8];
        for (int i = 8; 2 < i; i--) {
            charArray[i] = charArray[i - 2];
        }
        charArray[1] = c;
        charArray[2] = c2;
        return new String(charArray);
    }
}
