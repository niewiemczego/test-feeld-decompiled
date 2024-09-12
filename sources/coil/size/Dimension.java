package coil.size;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcoil/size/Dimension;", "", "()V", "Pixels", "Undefined", "Lcoil/size/Dimension$Pixels;", "Lcoil/size/Dimension$Undefined;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Dimension.kt */
public abstract class Dimension {
    public /* synthetic */ Dimension(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Dimension() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcoil/size/Dimension$Pixels;", "Lcoil/size/Dimension;", "px", "", "(I)V", "equals", "", "other", "", "hashCode", "toString", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Dimension.kt */
    public static final class Pixels extends Dimension {
        public final int px;

        public Pixels(int i) {
            super((DefaultConstructorMarker) null);
            this.px = i;
            if (!(i > 0)) {
                throw new IllegalArgumentException("px must be > 0.".toString());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Pixels) && this.px == ((Pixels) obj).px;
        }

        public int hashCode() {
            return this.px;
        }

        public String toString() {
            return String.valueOf(this.px);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcoil/size/Dimension$Undefined;", "Lcoil/size/Dimension;", "()V", "toString", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Dimension.kt */
    public static final class Undefined extends Dimension {
        public static final Undefined INSTANCE = new Undefined();

        public String toString() {
            return "Dimension.Undefined";
        }

        private Undefined() {
            super((DefaultConstructorMarker) null);
        }
    }
}
