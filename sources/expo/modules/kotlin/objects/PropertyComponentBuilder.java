package expo.modules.kotlin.objects;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\"\u0010\u0012\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u00132\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0015H\bø\u0001\u0000J9\u0010\u0016\u001a\u00020\u0000\"\u0006\b\u0000\u0010\u0013\u0018\u00012#\b\u0004\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u0011H\u0013¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0017H\bø\u0001\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\n\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001b"}, d2 = {"Lexpo/modules/kotlin/objects/PropertyComponentBuilder;", "", "name", "", "(Ljava/lang/String;)V", "getter", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "getGetter", "()Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "setGetter", "(Lexpo/modules/kotlin/functions/SyncFunctionComponent;)V", "getName", "()Ljava/lang/String;", "setter", "getSetter", "setSetter", "build", "Lexpo/modules/kotlin/objects/PropertyComponent;", "get", "T", "body", "Lkotlin/Function0;", "set", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "newValue", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PropertyComponentBuilder.kt */
public final class PropertyComponentBuilder {
    private SyncFunctionComponent getter;
    private final String name;
    private SyncFunctionComponent setter;

    public PropertyComponentBuilder(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }

    public final SyncFunctionComponent getGetter() {
        return this.getter;
    }

    public final void setGetter(SyncFunctionComponent syncFunctionComponent) {
        this.getter = syncFunctionComponent;
    }

    public final SyncFunctionComponent getSetter() {
        return this.setter;
    }

    public final void setSetter(SyncFunctionComponent syncFunctionComponent) {
        this.setter = syncFunctionComponent;
    }

    public final <T> PropertyComponentBuilder get(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "body");
        PropertyComponentBuilder propertyComponentBuilder = this;
        setGetter(new SyncFunctionComponent("get", new AnyType[0], new PropertyComponentBuilder$get$1$1(function0)));
        return this;
    }

    public final /* synthetic */ <T> PropertyComponentBuilder set(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "body");
        PropertyComponentBuilder propertyComponentBuilder = this;
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        setSetter(new SyncFunctionComponent("set", anyTypeArr, new PropertyComponentBuilder$set$1$1(function1)));
        return this;
    }

    public final PropertyComponent build() {
        return new PropertyComponent(this.name, this.getter, this.setter);
    }
}
