package zendesk.android.messaging.model;

import android.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001e"}, d2 = {"Lzendesk/android/messaging/model/ColorTheme;", "", "primaryColor", "", "messageColor", "actionColor", "notifyColor", "iconColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionColor", "()Ljava/lang/String;", "getIconColor", "getMessageColor", "getNotifyColor", "getPrimaryColor", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toColorInt", "colorCode", "(Ljava/lang/String;)Ljava/lang/Integer;", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ColorTheme.kt */
public final class ColorTheme {
    private final String actionColor;
    private final String iconColor;
    private final String messageColor;
    private final String notifyColor;
    private final String primaryColor;

    public static /* synthetic */ ColorTheme copy$default(ColorTheme colorTheme, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = colorTheme.primaryColor;
        }
        if ((i & 2) != 0) {
            str2 = colorTheme.messageColor;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = colorTheme.actionColor;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = colorTheme.notifyColor;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = colorTheme.iconColor;
        }
        return colorTheme.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.primaryColor;
    }

    public final String component2() {
        return this.messageColor;
    }

    public final String component3() {
        return this.actionColor;
    }

    public final String component4() {
        return this.notifyColor;
    }

    public final String component5() {
        return this.iconColor;
    }

    public final ColorTheme copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "primaryColor");
        Intrinsics.checkNotNullParameter(str2, "messageColor");
        Intrinsics.checkNotNullParameter(str3, "actionColor");
        return new ColorTheme(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColorTheme)) {
            return false;
        }
        ColorTheme colorTheme = (ColorTheme) obj;
        return Intrinsics.areEqual((Object) this.primaryColor, (Object) colorTheme.primaryColor) && Intrinsics.areEqual((Object) this.messageColor, (Object) colorTheme.messageColor) && Intrinsics.areEqual((Object) this.actionColor, (Object) colorTheme.actionColor) && Intrinsics.areEqual((Object) this.notifyColor, (Object) colorTheme.notifyColor) && Intrinsics.areEqual((Object) this.iconColor, (Object) colorTheme.iconColor);
    }

    public int hashCode() {
        int hashCode = ((((this.primaryColor.hashCode() * 31) + this.messageColor.hashCode()) * 31) + this.actionColor.hashCode()) * 31;
        String str = this.notifyColor;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.iconColor;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ColorTheme(primaryColor=" + this.primaryColor + ", messageColor=" + this.messageColor + ", actionColor=" + this.actionColor + ", notifyColor=" + this.notifyColor + ", iconColor=" + this.iconColor + ')';
    }

    public ColorTheme(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "primaryColor");
        Intrinsics.checkNotNullParameter(str2, "messageColor");
        Intrinsics.checkNotNullParameter(str3, "actionColor");
        this.primaryColor = str;
        this.messageColor = str2;
        this.actionColor = str3;
        this.notifyColor = str4;
        this.iconColor = str5;
    }

    public final String getPrimaryColor() {
        return this.primaryColor;
    }

    public final String getMessageColor() {
        return this.messageColor;
    }

    public final String getActionColor() {
        return this.actionColor;
    }

    public final String getNotifyColor() {
        return this.notifyColor;
    }

    public final String getIconColor() {
        return this.iconColor;
    }

    public final Integer toColorInt(String str) {
        Intrinsics.checkNotNullParameter(str, "colorCode");
        try {
            return Integer.valueOf(Color.parseColor(str));
        } catch (IllegalArgumentException unused) {
            Integer num = null;
            return null;
        } catch (StringIndexOutOfBoundsException unused2) {
            Integer num2 = null;
            return null;
        }
    }
}
