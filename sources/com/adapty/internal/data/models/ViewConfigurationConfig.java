package com.adapty.internal.data.models;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0001\u0018\u00002\u00020\u0001:\u0002\u001f Bs\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0007\u0010\u0016R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR6\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015¨\u0006!"}, d2 = {"Lcom/adapty/internal/data/models/ViewConfigurationConfig;", "", "assets", "", "Lcom/adapty/internal/data/models/ViewConfigurationConfig$Asset;", "defaultLocalization", "", "isHard", "", "localizations", "Lcom/adapty/internal/data/models/ViewConfigurationConfig$Localization;", "styles", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "templateId", "mainImageRelativeHeight", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/Float;)V", "getAssets", "()Ljava/util/List;", "getDefaultLocalization", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLocalizations", "getMainImageRelativeHeight", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getStyles", "()Ljava/util/HashMap;", "getTemplateId", "Asset", "Localization", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewConfigurationDto.kt */
public final class ViewConfigurationConfig {
    @SerializedName("assets")
    private final List<Asset> assets;
    @SerializedName("default_localization")
    private final String defaultLocalization;
    @SerializedName("is_hard_paywall")
    private final Boolean isHard;
    @SerializedName("localizations")
    private final List<Localization> localizations;
    @SerializedName("main_image_relative_height")
    private final Float mainImageRelativeHeight;
    @SerializedName("styles")
    private final HashMap<String, Object> styles;
    @SerializedName("template_id")
    private final String templateId;

    public ViewConfigurationConfig(List<Asset> list, String str, Boolean bool, List<Localization> list2, HashMap<String, Object> hashMap, String str2, Float f) {
        Intrinsics.checkNotNullParameter(list2, "localizations");
        Intrinsics.checkNotNullParameter(hashMap, "styles");
        this.assets = list;
        this.defaultLocalization = str;
        this.isHard = bool;
        this.localizations = list2;
        this.styles = hashMap;
        this.templateId = str2;
        this.mainImageRelativeHeight = f;
    }

    public final List<Asset> getAssets() {
        return this.assets;
    }

    public final String getDefaultLocalization() {
        return this.defaultLocalization;
    }

    public final Boolean isHard() {
        return this.isHard;
    }

    public final List<Localization> getLocalizations() {
        return this.localizations;
    }

    public final HashMap<String, Object> getStyles() {
        return this.styles;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final Float getMainImageRelativeHeight() {
        return this.mainImageRelativeHeight;
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0019\u0018\u00002\u00020\u0001BÏ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012*\u0010\t\u001a&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\nj\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013\u00122\u0010\u0014\u001a.\u0012(\u0012&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nj\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\u000b\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0010\u0010\u001cR:\u0010\t\u001a&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\nj\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR \u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00138\u0006X\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(RB\u0010\u0014\u001a.\u0012(\u0012&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nj\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\u000b\u0018\u00010\u00158\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/adapty/internal/data/models/ViewConfigurationConfig$Asset;", "", "id", "", "size", "", "type", "color", "value", "points", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "horizontalAlign", "familyName", "weight", "", "isItalic", "", "resources", "", "values", "", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;[Ljava/lang/String;Ljava/util/List;)V", "getColor", "()Ljava/lang/String;", "getFamilyName", "getHorizontalAlign", "getId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPoints", "()Ljava/util/HashMap;", "getResources", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getSize", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getType", "getValue", "()Ljava/lang/Object;", "getValues", "()Ljava/util/List;", "getWeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ViewConfigurationDto.kt */
    public static final class Asset {
        @SerializedName("color")
        private final String color;
        @SerializedName("family_name")
        private final String familyName;
        @SerializedName("horizontal_align")
        private final String horizontalAlign;
        @SerializedName("id")
        private final String id;
        @SerializedName("italic")
        private final Boolean isItalic;
        @SerializedName("points")
        private final HashMap<String, Float> points;
        @SerializedName("resources")
        private final String[] resources;
        @SerializedName("size")
        private final Float size;
        @SerializedName("type")
        private final String type;
        @SerializedName("value")
        private final Object value;
        @SerializedName("values")
        private final List<HashMap<String, Object>> values;
        @SerializedName("weight")
        private final Integer weight;

        public Asset(String str, Float f, String str2, String str3, Object obj, HashMap<String, Float> hashMap, String str4, String str5, Integer num, Boolean bool, String[] strArr, List<? extends HashMap<String, Object>> list) {
            this.id = str;
            this.size = f;
            this.type = str2;
            this.color = str3;
            this.value = obj;
            this.points = hashMap;
            this.horizontalAlign = str4;
            this.familyName = str5;
            this.weight = num;
            this.isItalic = bool;
            this.resources = strArr;
            this.values = list;
        }

        public final String getId() {
            return this.id;
        }

        public final Float getSize() {
            return this.size;
        }

        public final String getType() {
            return this.type;
        }

        public final String getColor() {
            return this.color;
        }

        public final Object getValue() {
            return this.value;
        }

        public final HashMap<String, Float> getPoints() {
            return this.points;
        }

        public final String getHorizontalAlign() {
            return this.horizontalAlign;
        }

        public final String getFamilyName() {
            return this.familyName;
        }

        public final Integer getWeight() {
            return this.weight;
        }

        public final Boolean isItalic() {
            return this.isItalic;
        }

        public final String[] getResources() {
            return this.resources;
        }

        public final List<HashMap<String, Object>> getValues() {
            return this.values;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000fB/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0002\u0010\tR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/adapty/internal/data/models/ViewConfigurationConfig$Localization;", "", "id", "", "strings", "", "Lcom/adapty/internal/data/models/ViewConfigurationConfig$Localization$Str;", "assets", "Lcom/adapty/internal/data/models/ViewConfigurationConfig$Asset;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getAssets", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getStrings", "Str", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ViewConfigurationDto.kt */
    public static final class Localization {
        @SerializedName("assets")
        private final List<Asset> assets;
        @SerializedName("id")
        private final String id;
        @SerializedName("strings")
        private final List<Str> strings;

        public Localization(String str, List<Str> list, List<Asset> list2) {
            this.id = str;
            this.strings = list;
            this.assets = list2;
        }

        public final String getId() {
            return this.id;
        }

        public final List<Str> getStrings() {
            return this.strings;
        }

        public final List<Asset> getAssets() {
            return this.assets;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/adapty/internal/data/models/ViewConfigurationConfig$Localization$Str;", "", "id", "", "value", "hasTags", "", "fallback", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getFallback", "()Ljava/lang/String;", "getHasTags", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "getValue", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: ViewConfigurationDto.kt */
        public static final class Str {
            @SerializedName("fallback")
            private final String fallback;
            @SerializedName("has_tags")
            private final Boolean hasTags;
            @SerializedName("id")
            private final String id;
            @SerializedName("value")
            private final String value;

            public Str(String str, String str2, Boolean bool, String str3) {
                this.id = str;
                this.value = str2;
                this.hasTags = bool;
                this.fallback = str3;
            }

            public final String getId() {
                return this.id;
            }

            public final String getValue() {
                return this.value;
            }

            public final Boolean getHasTags() {
                return this.hasTags;
            }

            public final String getFallback() {
                return this.fallback;
            }
        }
    }
}
