package zendesk.ui.android.conversation.form;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lzendesk/ui/android/conversation/form/DisplayedField;", "Landroid/os/Parcelable;", "index", "", "value", "", "(ILjava/lang/String;)V", "getIndex", "()I", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormView.kt */
public final class DisplayedField implements Parcelable {
    public static final Parcelable.Creator<DisplayedField> CREATOR = new Creator();
    private final int index;
    private final String value;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FormView.kt */
    public static final class Creator implements Parcelable.Creator<DisplayedField> {
        public final DisplayedField createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DisplayedField(parcel.readInt(), parcel.readString());
        }

        public final DisplayedField[] newArray(int i) {
            return new DisplayedField[i];
        }
    }

    public static /* synthetic */ DisplayedField copy$default(DisplayedField displayedField, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = displayedField.index;
        }
        if ((i2 & 2) != 0) {
            str = displayedField.value;
        }
        return displayedField.copy(i, str);
    }

    public final int component1() {
        return this.index;
    }

    public final String component2() {
        return this.value;
    }

    public final DisplayedField copy(int i, String str) {
        return new DisplayedField(i, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DisplayedField)) {
            return false;
        }
        DisplayedField displayedField = (DisplayedField) obj;
        return this.index == displayedField.index && Intrinsics.areEqual((Object) this.value, (Object) displayedField.value);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.index) * 31;
        String str = this.value;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "DisplayedField(index=" + this.index + ", value=" + this.value + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.index);
        parcel.writeString(this.value);
    }

    public DisplayedField(int i, String str) {
        this.index = i;
        this.value = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DisplayedField(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str);
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getValue() {
        return this.value;
    }
}
