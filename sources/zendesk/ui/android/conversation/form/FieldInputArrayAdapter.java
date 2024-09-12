package zendesk.ui.android.conversation.form;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.Filter;
import android.widget.Filterable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zendesk.ui.android.R;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0007H\u0016J\r\u0010\u0011\u001a\u00020\u0002H\u0000¢\u0006\u0002\b\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0002J\"\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\r\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b\"J\r\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%J\r\u0010&\u001a\u00020$H\u0000¢\u0006\u0002\b'J\r\u0010(\u001a\u00020$H\u0000¢\u0006\u0002\b)J\u0015\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0002H\u0000¢\u0006\u0002\b,J\u0014\u0010-\u001a\u00020$*\u00020.2\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0016\u0010/\u001a\u00020.*\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldInputArrayAdapter;", "Landroid/widget/ArrayAdapter;", "Lzendesk/ui/android/conversation/form/SelectOption;", "Landroid/widget/Filterable;", "context", "Landroid/content/Context;", "layoutResource", "", "allMenuOptions", "", "(Landroid/content/Context;ILjava/util/List;)V", "currentSelectedOption", "invalidTypedTextQuery", "", "noMatchesFound", "suggestedMenuOptions", "getCount", "getCurrentSelectedOption", "getCurrentSelectedOption$zendesk_ui_ui_android", "getFilter", "Landroid/widget/Filter;", "getInvalidTypedTextQuery", "getInvalidTypedTextQuery$zendesk_ui_ui_android", "getItem", "position", "getSuggestions", "query", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "hasValidSuggestions", "", "hasValidSuggestions$zendesk_ui_ui_android", "performFilterOnInvalidTypedQuery", "", "performFilterOnInvalidTypedQuery$zendesk_ui_ui_android", "resetInvalidTypedTextQuery", "resetInvalidTypedTextQuery$zendesk_ui_ui_android", "resetSuggestions", "resetSuggestions$zendesk_ui_ui_android", "setCurrentSelectedOption", "selectedOption", "setCurrentSelectedOption$zendesk_ui_ui_android", "disableIfNoMatchesFound", "Landroid/widget/CheckedTextView;", "toCheckedTextView", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FieldInputArrayAdapter.kt */
public final class FieldInputArrayAdapter extends ArrayAdapter<SelectOption> implements Filterable {
    private final List<SelectOption> allMenuOptions;
    private SelectOption currentSelectedOption;
    private String invalidTypedTextQuery;
    private final int layoutResource;
    private final SelectOption noMatchesFound;
    /* access modifiers changed from: private */
    public List<SelectOption> suggestedMenuOptions;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FieldInputArrayAdapter(Context context, int i, List<SelectOption> list) {
        super(context, i, list);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "allMenuOptions");
        this.layoutResource = i;
        this.allMenuOptions = list;
        this.suggestedMenuOptions = list;
        String string = context.getString(R.string.zuia_no_matches_found_label);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…a_no_matches_found_label)");
        this.noMatchesFound = new SelectOption("", string);
    }

    public int getCount() {
        return this.suggestedMenuOptions.size();
    }

    public SelectOption getItem(int i) {
        return this.suggestedMenuOptions.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        CheckedTextView checkedTextView = toCheckedTextView(view, viewGroup);
        checkedTextView.setText(getItem(i).getLabel());
        disableIfNoMatchesFound(checkedTextView, i);
        return checkedTextView;
    }

    public Filter getFilter() {
        return new FieldInputArrayAdapter$getFilter$1(this);
    }

    public final void resetSuggestions$zendesk_ui_ui_android() {
        if (this.suggestedMenuOptions.size() != this.allMenuOptions.size()) {
            getFilter().filter((CharSequence) null);
        }
    }

    public final void performFilterOnInvalidTypedQuery$zendesk_ui_ui_android() {
        CharSequence charSequence = this.invalidTypedTextQuery;
        if (!(charSequence == null || charSequence.length() == 0)) {
            getFilter().filter(this.invalidTypedTextQuery);
        }
    }

    public final void setCurrentSelectedOption$zendesk_ui_ui_android(SelectOption selectOption) {
        Intrinsics.checkNotNullParameter(selectOption, "selectedOption");
        this.currentSelectedOption = selectOption;
    }

    public final SelectOption getCurrentSelectedOption$zendesk_ui_ui_android() {
        SelectOption selectOption = this.currentSelectedOption;
        if (selectOption != null) {
            return selectOption;
        }
        Intrinsics.throwUninitializedPropertyAccessException("currentSelectedOption");
        return null;
    }

    public final String getInvalidTypedTextQuery$zendesk_ui_ui_android() {
        return this.invalidTypedTextQuery;
    }

    public final void resetInvalidTypedTextQuery$zendesk_ui_ui_android() {
        if (this.invalidTypedTextQuery != null) {
            this.invalidTypedTextQuery = null;
        }
    }

    /* access modifiers changed from: private */
    public final List<SelectOption> getSuggestions(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return this.allMenuOptions;
        }
        Collection arrayList = new ArrayList();
        for (Object next : this.allMenuOptions) {
            String label = ((SelectOption) next).getLabel();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String lowerCase = label.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (StringsKt.contains$default((CharSequence) lowerCase, charSequence, false, 2, (Object) null)) {
                arrayList.add(next);
            }
        }
        Collection collection = (List) arrayList;
        boolean isEmpty = collection.isEmpty();
        List list = collection;
        if (isEmpty) {
            this.invalidTypedTextQuery = str;
            list = CollectionsKt.listOf(this.noMatchesFound);
        }
        return (List) list;
    }

    private final void disableIfNoMatchesFound(CheckedTextView checkedTextView, int i) {
        boolean areEqual = Intrinsics.areEqual((Object) getItem(i).getLabel(), (Object) this.noMatchesFound.getLabel());
        checkedTextView.setClickable(areEqual);
        checkedTextView.setEnabled(!areEqual);
    }

    public final boolean hasValidSuggestions$zendesk_ui_ui_android() {
        return (this.suggestedMenuOptions.isEmpty() ^ true) && !Intrinsics.areEqual((Object) this.suggestedMenuOptions.get(0).getLabel(), (Object) this.noMatchesFound.getLabel());
    }

    private final CheckedTextView toCheckedTextView(View view, ViewGroup viewGroup) {
        CheckedTextView checkedTextView = view instanceof CheckedTextView ? (CheckedTextView) view : null;
        if (checkedTextView != null) {
            return checkedTextView;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(this.layoutResource, viewGroup, false);
        if (inflate != null) {
            return (CheckedTextView) inflate;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.CheckedTextView");
    }
}
