package zendesk.ui.android.conversation.item;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B=\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0013JL\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lzendesk/ui/android/conversation/item/Item;", "T", "", "id", "", "title", "titleColor", "", "subtitle", "value", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;)V", "getId", "()Ljava/lang/String;", "getSubtitle", "getTitle", "getTitleColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;)Lzendesk/ui/android/conversation/item/Item;", "equals", "", "other", "hashCode", "toString", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Item.kt */
public final class Item<T> {
    private final String id;
    private final String subtitle;
    private final String title;
    private final Integer titleColor;
    private final T value;

    public Item() {
        this((String) null, (String) null, (Integer) null, (String) null, (Object) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Item copy$default(Item item, String str, String str2, Integer num, String str3, T t, int i, Object obj) {
        if ((i & 1) != 0) {
            str = item.id;
        }
        if ((i & 2) != 0) {
            str2 = item.title;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            num = item.titleColor;
        }
        Integer num2 = num;
        if ((i & 8) != 0) {
            str3 = item.subtitle;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            t = item.value;
        }
        return item.copy(str, str4, num2, str5, t);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final Integer component3() {
        return this.titleColor;
    }

    public final String component4() {
        return this.subtitle;
    }

    public final T component5() {
        return this.value;
    }

    public final Item<T> copy(String str, String str2, Integer num, String str3, T t) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new Item(str, str2, num, str3, t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Item)) {
            return false;
        }
        Item item = (Item) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) item.id) && Intrinsics.areEqual((Object) this.title, (Object) item.title) && Intrinsics.areEqual((Object) this.titleColor, (Object) item.titleColor) && Intrinsics.areEqual((Object) this.subtitle, (Object) item.subtitle) && Intrinsics.areEqual((Object) this.value, (Object) item.value);
    }

    public int hashCode() {
        int hashCode = ((this.id.hashCode() * 31) + this.title.hashCode()) * 31;
        Integer num = this.titleColor;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.subtitle;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        T t = this.value;
        if (t != null) {
            i = t.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "Item(id=" + this.id + ", title=" + this.title + ", titleColor=" + this.titleColor + ", subtitle=" + this.subtitle + ", value=" + this.value + ')';
    }

    public Item(String str, String str2, Integer num, String str3, T t) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.titleColor = num;
        this.subtitle = str3;
        this.value = t;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Item(java.lang.String r7, java.lang.String r8, java.lang.Integer r9, java.lang.String r10, java.lang.Object r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 1
            if (r13 == 0) goto L_0x0011
            java.util.UUID r7 = java.util.UUID.randomUUID()
            java.lang.String r7 = r7.toString()
            java.lang.String r13 = "randomUUID().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r13)
        L_0x0011:
            r1 = r7
            r7 = r12 & 2
            if (r7 == 0) goto L_0x0018
            java.lang.String r8 = ""
        L_0x0018:
            r2 = r8
            r7 = r12 & 4
            r8 = 0
            if (r7 == 0) goto L_0x0020
            r3 = r8
            goto L_0x0021
        L_0x0020:
            r3 = r9
        L_0x0021:
            r7 = r12 & 8
            if (r7 == 0) goto L_0x0027
            r4 = r8
            goto L_0x0028
        L_0x0027:
            r4 = r10
        L_0x0028:
            r7 = r12 & 16
            if (r7 == 0) goto L_0x002e
            r5 = r8
            goto L_0x002f
        L_0x002e:
            r5 = r11
        L_0x002f:
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.ui.android.conversation.item.Item.<init>(java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Object, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getTitleColor() {
        return this.titleColor;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final T getValue() {
        return this.value;
    }
}
