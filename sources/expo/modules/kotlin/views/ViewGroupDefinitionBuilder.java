package expo.modules.kotlin.views;

import android.view.View;
import android.view.ViewGroup;
import expo.modules.kotlin.modules.DefinitionMarker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004Jg\u00100\u001a\u00020\u000e\"\n\b\u0001\u00101\u0018\u0001*\u00020\n2M\b\u0004\u00102\u001aG\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u0011H1¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0006H\bø\u0001\u0000J1\u00103\u001a\u00020\u000e2#\b\u0004\u00102\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\f0\u001eH\bø\u0001\u0000JT\u00105\u001a\u00020\u000e\"\n\b\u0001\u00101\u0018\u0001*\u00020\n2:\b\u0004\u00102\u001a4\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u0001H10\u0016H\bø\u0001\u0000JR\u00106\u001a\u00020\u000e\"\n\b\u0001\u00101\u0018\u0001*\u00020\n28\b\b\u00102\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u0011H1¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0016H\bø\u0001\u0000JF\u00107\u001a\u00020\u000e28\b\u0004\u00102\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0016H\bø\u0001\u0000J\u0006\u00108\u001a\u000209Rq\u0010\u0005\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0006j\u0004\u0018\u0001`\u000f8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R^\u0010\u0015\u001a<\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u00178\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cRG\u0010\u001d\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u001ej\u0004\u0018\u0001`\u001f8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\\\u0010%\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016j\u0004\u0018\u0001`'8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001cR\\\u0010+\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016j\u0004\u0018\u0001`,8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010\u001c\u0002\u0007\n\u0005\b20\u0001¨\u0006:"}, d2 = {"Lexpo/modules/kotlin/views/ViewGroupDefinitionBuilder;", "ParentType", "Landroid/view/ViewGroup;", "", "()V", "addViewAction", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "parent", "Landroid/view/View;", "child", "", "index", "", "Lexpo/modules/kotlin/views/AddViewAction;", "getAddViewAction$annotations", "getAddViewAction", "()Lkotlin/jvm/functions/Function3;", "setAddViewAction", "(Lkotlin/jvm/functions/Function3;)V", "getChildAtAction", "Lkotlin/Function2;", "Lexpo/modules/kotlin/views/GetChildAtAction;", "getGetChildAtAction$annotations", "getGetChildAtAction", "()Lkotlin/jvm/functions/Function2;", "setGetChildAtAction", "(Lkotlin/jvm/functions/Function2;)V", "getChildCountAction", "Lkotlin/Function1;", "Lexpo/modules/kotlin/views/GetChildCountAction;", "getGetChildCountAction$annotations", "getGetChildCountAction", "()Lkotlin/jvm/functions/Function1;", "setGetChildCountAction", "(Lkotlin/jvm/functions/Function1;)V", "removeViewAction", "childToRemove", "Lexpo/modules/kotlin/views/RemoveViewAction;", "getRemoveViewAction$annotations", "getRemoveViewAction", "setRemoveViewAction", "removeViewAtAction", "Lexpo/modules/kotlin/views/RemoveViewAtAction;", "getRemoveViewAtAction$annotations", "getRemoveViewAtAction", "setRemoveViewAtAction", "AddChildView", "ChildViewType", "body", "GetChildCount", "view", "GetChildViewAt", "RemoveChildView", "RemoveChildViewAt", "build", "Lexpo/modules/kotlin/views/ViewGroupDefinition;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@DefinitionMarker
/* compiled from: ViewGroupDefinitionBuilder.kt */
public final class ViewGroupDefinitionBuilder<ParentType extends ViewGroup> {
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

    public final /* synthetic */ <ChildViewType extends View> void AddChildView(Function3<? super ParentType, ? super ChildViewType, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "body");
        Intrinsics.needClassReification();
        setAddViewAction(new ViewGroupDefinitionBuilder$AddChildView$1(function3));
    }

    public final void GetChildCount(Function1<? super ParentType, Integer> function1) {
        Intrinsics.checkNotNullParameter(function1, "body");
        setGetChildCountAction(new ViewGroupDefinitionBuilder$GetChildCount$1(function1));
    }

    public final /* synthetic */ <ChildViewType extends View> void GetChildViewAt(Function2<? super ParentType, ? super Integer, ? extends ChildViewType> function2) {
        Intrinsics.checkNotNullParameter(function2, "body");
        Intrinsics.needClassReification();
        setGetChildAtAction(new ViewGroupDefinitionBuilder$GetChildViewAt$1(function2));
    }

    public final void RemoveChildViewAt(Function2<? super ParentType, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "body");
        setRemoveViewAtAction(new ViewGroupDefinitionBuilder$RemoveChildViewAt$1(function2));
    }

    public final /* synthetic */ <ChildViewType extends View> void RemoveChildView(Function2<? super ParentType, ? super ChildViewType, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "body");
        Intrinsics.needClassReification();
        setRemoveViewAction(new ViewGroupDefinitionBuilder$RemoveChildView$1(function2));
    }
}
