package zendesk.ui.android.conversation.quickreply;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.ui.android.conversation.quickreply.QuickReplyOptionRendering;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionRendering;", "quickReplyOptionRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: QuickReplyView.kt */
final class QuickReplyView$addQuickReplyOption$1$1 extends Lambda implements Function1<QuickReplyOptionRendering, QuickReplyOptionRendering> {
    final /* synthetic */ String $id;
    final /* synthetic */ String $text;
    final /* synthetic */ QuickReplyView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuickReplyView$addQuickReplyOption$1$1(String str, String str2, QuickReplyView quickReplyView) {
        super(1);
        this.$id = str;
        this.$text = str2;
        this.this$0 = quickReplyView;
    }

    public final QuickReplyOptionRendering invoke(QuickReplyOptionRendering quickReplyOptionRendering) {
        Intrinsics.checkNotNullParameter(quickReplyOptionRendering, "quickReplyOptionRendering");
        QuickReplyOptionRendering.Builder builder = quickReplyOptionRendering.toBuilder();
        final String str = this.$id;
        final String str2 = this.$text;
        final QuickReplyView quickReplyView = this.this$0;
        QuickReplyOptionRendering.Builder state = builder.state(new Function1<QuickReplyOptionState, QuickReplyOptionState>() {
            public final QuickReplyOptionState invoke(QuickReplyOptionState quickReplyOptionState) {
                Intrinsics.checkNotNullParameter(quickReplyOptionState, "state");
                return quickReplyOptionState.copy(str, str2, quickReplyView.rendering.getState$zendesk_ui_ui_android().getColor$zendesk_ui_ui_android());
            }
        });
        final QuickReplyView quickReplyView2 = this.this$0;
        return state.onOptionClicked(new Function2<String, String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, (String) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(str2, "text");
                Function1<QuickReplyOption, Unit> onOptionClicked$zendesk_ui_ui_android = quickReplyView2.rendering.getOnOptionClicked$zendesk_ui_ui_android();
                if (onOptionClicked$zendesk_ui_ui_android != null) {
                    onOptionClicked$zendesk_ui_ui_android.invoke(new QuickReplyOption(str, str2));
                }
                int childCount = quickReplyView2.quickReplyChipGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = quickReplyView2.quickReplyChipGroup.getChildAt(i);
                    QuickReplyOptionView quickReplyOptionView = childAt instanceof QuickReplyOptionView ? (QuickReplyOptionView) childAt : null;
                    if ((quickReplyOptionView != null && !quickReplyOptionView.isSelected()) && quickReplyOptionView.getChildCount() > 0) {
                        quickReplyOptionView.getChildAt(0).setEnabled(false);
                    }
                }
            }
        }).build();
    }
}
