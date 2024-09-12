package com.braze.ui.contentcards.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.braze.ui.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0005R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/braze/ui/contentcards/view/ContentCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "showUnreadIndicator", "", "(Landroid/view/View;Z)V", "actionHint", "Landroid/widget/TextView;", "pinnedIcon", "Landroid/widget/ImageView;", "unreadBar", "setActionHintText", "", "text", "", "setActionHintVisible", "isVisible", "setPinnedIconVisible", "setUnreadBarVisible", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContentCardViewHolder.kt */
public class ContentCardViewHolder extends RecyclerView.ViewHolder {
    private final TextView actionHint;
    private final ImageView pinnedIcon;
    private final View unreadBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContentCardViewHolder(View view, boolean z) {
        super(view);
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        View findViewById = view.findViewById(R.id.com_braze_content_cards_unread_bar);
        this.unreadBar = findViewById;
        this.pinnedIcon = (ImageView) view.findViewById(R.id.com_braze_content_cards_pinned_icon);
        this.actionHint = (TextView) view.findViewById(R.id.com_braze_content_cards_action_hint);
        if (z) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            if (findViewById != null) {
                findViewById.setBackground(view.getContext().getResources().getDrawable(R.drawable.com_braze_content_cards_unread_bar_background));
            }
        } else if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public final void setPinnedIconVisible(boolean z) {
        ImageView imageView = this.pinnedIcon;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public final void setUnreadBarVisible(boolean z) {
        View view = this.unreadBar;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public final void setActionHintVisible(boolean z) {
        TextView textView = this.actionHint;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    public final void setActionHintText(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextView textView = this.actionHint;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
