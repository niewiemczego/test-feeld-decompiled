package expo.modules.kotlin.views;

import android.view.View;
import android.view.ViewGroup;
import expo.modules.kotlin.modules.DefinitionMarker;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002Js\u0010/\u001a\u00020\r\"\n\b\u0000\u00100\u0018\u0001*\u00020\u0005\"\n\b\u0001\u00101\u0018\u0001*\u00020\t2M\b\b\u00102\u001aG\u0012\u0013\u0012\u0011H0¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H1¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0004H\bø\u0001\u0000J=\u00103\u001a\u00020\r\"\n\b\u0000\u00100\u0018\u0001*\u00020\u00052#\b\b\u00102\u001a\u001d\u0012\u0013\u0012\u0011H0¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u000b0\u001dH\bø\u0001\u0000J`\u00105\u001a\u00020\r\"\n\b\u0000\u00100\u0018\u0001*\u00020\u0005\"\n\b\u0001\u00101\u0018\u0001*\u00020\t2:\b\b\u00102\u001a4\u0012\u0013\u0012\u0011H0¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u0001H10\u0015H\bø\u0001\u0000J^\u00106\u001a\u00020\r\"\n\b\u0000\u00100\u0018\u0001*\u00020\u0005\"\n\b\u0001\u00101\u0018\u0001*\u00020\t28\b\b\u00102\u001a2\u0012\u0013\u0012\u0011H0¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H1¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\r0\u0015H\bø\u0001\u0000JR\u00107\u001a\u00020\r\"\n\b\u0000\u00100\u0018\u0001*\u00020\u000528\b\b\u00102\u001a2\u0012\u0013\u0012\u0011H0¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0015H\bø\u0001\u0000J\u0006\u00108\u001a\u000209Rq\u0010\u0003\u001aO\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0004j\u0004\u0018\u0001`\u000e8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R^\u0010\u0014\u001a<\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0015j\u0004\u0018\u0001`\u00168\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bRG\u0010\u001c\u001a%\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\\\u0010$\u001a:\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015j\u0004\u0018\u0001`&8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u0002\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR\\\u0010*\u001a:\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015j\u0004\u0018\u0001`+8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b,\u0010\u0002\u001a\u0004\b-\u0010\u0019\"\u0004\b.\u0010\u001b\u0002\u0007\n\u0005\b20\u0001¨\u0006:"}, d2 = {"Lexpo/modules/kotlin/views/ViewGroupDefinitionLegacyBuilder;", "", "()V", "addViewAction", "Lkotlin/Function3;", "Landroid/view/ViewGroup;", "Lkotlin/ParameterName;", "name", "parent", "Landroid/view/View;", "child", "", "index", "", "Lexpo/modules/kotlin/views/AddViewAction;", "getAddViewAction$annotations", "getAddViewAction", "()Lkotlin/jvm/functions/Function3;", "setAddViewAction", "(Lkotlin/jvm/functions/Function3;)V", "getChildAtAction", "Lkotlin/Function2;", "Lexpo/modules/kotlin/views/GetChildAtAction;", "getGetChildAtAction$annotations", "getGetChildAtAction", "()Lkotlin/jvm/functions/Function2;", "setGetChildAtAction", "(Lkotlin/jvm/functions/Function2;)V", "getChildCountAction", "Lkotlin/Function1;", "Lexpo/modules/kotlin/views/GetChildCountAction;", "getGetChildCountAction$annotations", "getGetChildCountAction", "()Lkotlin/jvm/functions/Function1;", "setGetChildCountAction", "(Lkotlin/jvm/functions/Function1;)V", "removeViewAction", "childToRemove", "Lexpo/modules/kotlin/views/RemoveViewAction;", "getRemoveViewAction$annotations", "getRemoveViewAction", "setRemoveViewAction", "removeViewAtAction", "Lexpo/modules/kotlin/views/RemoveViewAtAction;", "getRemoveViewAtAction$annotations", "getRemoveViewAtAction", "setRemoveViewAtAction", "AddChildView", "ParentViewType", "ChildViewType", "body", "GetChildCount", "view", "GetChildViewAt", "RemoveChildView", "RemoveChildViewAt", "build", "Lexpo/modules/kotlin/views/ViewGroupDefinition;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@DefinitionMarker
@Deprecated(message = "Use `ViewGroupDefinitionBuilder` instead.")
/* compiled from: ViewGroupDefinitionBuilder.kt */
public final class ViewGroupDefinitionLegacyBuilder {
    private Function3<? super ViewGroup, ? super View, ? super Integer, Unit> addViewAction;
    private Function2<? super ViewGroup, ? super Integer, ? extends View> getChildAtAction;
    private Function1<? super ViewGroup, Integer> getChildCountAction;
    private Function2<? super ViewGroup, ? super View, Unit> removeViewAction;
    private Function2<? super ViewGroup, ? super Integer, Unit> removeViewAtAction;

    public static /* synthetic */ void getAddViewAction$annotations() {
    }

    public static /* synthetic */ void getGetChildAtAction$annotations() {
    }

    public static /* synthetic */ void getGetChildCountAction$annotations() {
    }

    public static /* synthetic */ void getRemoveViewAction$annotations() {
    }

    public static /* synthetic */ void getRemoveViewAtAction$annotations() {
    }

    public final Function3<ViewGroup, View, Integer, Unit> getAddViewAction() {
        return this.addViewAction;
    }

    public final void setAddViewAction(Function3<? super ViewGroup, ? super View, ? super Integer, Unit> function3) {
        this.addViewAction = function3;
    }

    public final Function2<ViewGroup, Integer, View> getGetChildAtAction() {
        return this.getChildAtAction;
    }

    public final void setGetChildAtAction(Function2<? super ViewGroup, ? super Integer, ? extends View> function2) {
        this.getChildAtAction = function2;
    }

    public final Function1<ViewGroup, Integer> getGetChildCountAction() {
        return this.getChildCountAction;
    }

    public final void setGetChildCountAction(Function1<? super ViewGroup, Integer> function1) {
        this.getChildCountAction = function1;
    }

    public final Function2<ViewGroup, View, Unit> getRemoveViewAction() {
        return this.removeViewAction;
    }

    public final void setRemoveViewAction(Function2<? super ViewGroup, ? super View, Unit> function2) {
        this.removeViewAction = function2;
    }

    public final Function2<ViewGroup, Integer, Unit> getRemoveViewAtAction() {
        return this.removeViewAtAction;
    }

    public final void setRemoveViewAtAction(Function2<? super ViewGroup, ? super Integer, Unit> function2) {
        this.removeViewAtAction = function2;
    }

    public final ViewGroupDefinition build() {
        return new ViewGroupDefinition(this.addViewAction, this.getChildAtAction, this.getChildCountAction, this.removeViewAction, this.removeViewAtAction);
    }

    public final /* synthetic */ <ParentViewType extends ViewGroup, ChildViewType extends View> void AddChildView(Function3<? super ParentViewType, ? super ChildViewType, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "body");
        Intrinsics.needClassReification();
        setAddViewAction(new ViewGroupDefinitionLegacyBuilder$AddChildView$1(function3));
    }

    public final /* synthetic */ <ParentViewType extends ViewGroup> void GetChildCount(Function1<? super ParentViewType, Integer> function1) {
        Intrinsics.checkNotNullParameter(function1, "body");
        Intrinsics.needClassReification();
        setGetChildCountAction(new ViewGroupDefinitionLegacyBuilder$GetChildCount$1(function1));
    }

    public final /* synthetic */ <ParentViewType extends ViewGroup, ChildViewType extends View> void GetChildViewAt(Function2<? super ParentViewType, ? super Integer, ? extends ChildViewType> function2) {
        Intrinsics.checkNotNullParameter(function2, "body");
        Intrinsics.needClassReification();
        setGetChildAtAction(new ViewGroupDefinitionLegacyBuilder$GetChildViewAt$1(function2));
    }

    public final /* synthetic */ <ParentViewType extends ViewGroup> void RemoveChildViewAt(Function2<? super ParentViewType, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "body");
        Intrinsics.needClassReification();
        setRemoveViewAtAction(new ViewGroupDefinitionLegacyBuilder$RemoveChildViewAt$1(function2));
    }

    public final /* synthetic */ <ParentViewType extends ViewGroup, ChildViewType extends View> void RemoveChildView(Function2<? super ParentViewType, ? super ChildViewType, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "body");
        Intrinsics.needClassReification();
        setRemoveViewAction(new ViewGroupDefinitionLegacyBuilder$RemoveChildView$1(function2));
    }
}
