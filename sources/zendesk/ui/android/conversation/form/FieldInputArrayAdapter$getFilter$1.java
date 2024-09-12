package zendesk.ui.android.conversation.form;

import android.widget.Filter;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0014¨\u0006\t"}, d2 = {"zendesk/ui/android/conversation/form/FieldInputArrayAdapter$getFilter$1", "Landroid/widget/Filter;", "performFiltering", "Landroid/widget/Filter$FilterResults;", "charSequence", "", "publishResults", "", "filterResults", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FieldInputArrayAdapter.kt */
public final class FieldInputArrayAdapter$getFilter$1 extends Filter {
    final /* synthetic */ FieldInputArrayAdapter this$0;

    FieldInputArrayAdapter$getFilter$1(FieldInputArrayAdapter fieldInputArrayAdapter) {
        this.this$0 = fieldInputArrayAdapter;
    }

    /* access modifiers changed from: protected */
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Intrinsics.checkNotNullParameter(filterResults, "filterResults");
        FieldInputArrayAdapter fieldInputArrayAdapter = this.this$0;
        Object obj = filterResults.values;
        if (obj != null) {
            fieldInputArrayAdapter.suggestedMenuOptions = (List) obj;
            this.this$0.notifyDataSetChanged();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<zendesk.ui.android.conversation.form.SelectOption>");
    }

    /* access modifiers changed from: protected */
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        String str;
        String obj;
        if (charSequence == null || (obj = charSequence.toString()) == null) {
            str = null;
        } else {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            str = obj.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(locale)");
        }
        Filter.FilterResults filterResults = new Filter.FilterResults();
        filterResults.values = this.this$0.getSuggestions(str);
        return filterResults;
    }
}
