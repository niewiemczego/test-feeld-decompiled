package com.braze.models.inappmessage;

import com.braze.enums.inappmessage.ImageStyle;
import com.braze.enums.inappmessage.TextAlign;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020$H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000eX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u00020\u0014X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0005\"\u0004\b\u001b\u0010\u0007R\u0018\u0010\u001c\u001a\u00020\u001dX¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006,À\u0006\u0001"}, d2 = {"Lcom/braze/models/inappmessage/IInAppMessageImmersive;", "Lcom/braze/models/inappmessage/IInAppMessage;", "closeButtonColor", "", "getCloseButtonColor", "()I", "setCloseButtonColor", "(I)V", "frameColor", "getFrameColor", "()Ljava/lang/Integer;", "setFrameColor", "(Ljava/lang/Integer;)V", "header", "", "getHeader", "()Ljava/lang/String;", "setHeader", "(Ljava/lang/String;)V", "headerTextAlign", "Lcom/braze/enums/inappmessage/TextAlign;", "getHeaderTextAlign", "()Lcom/braze/enums/inappmessage/TextAlign;", "setHeaderTextAlign", "(Lcom/braze/enums/inappmessage/TextAlign;)V", "headerTextColor", "getHeaderTextColor", "setHeaderTextColor", "imageStyle", "Lcom/braze/enums/inappmessage/ImageStyle;", "getImageStyle", "()Lcom/braze/enums/inappmessage/ImageStyle;", "setImageStyle", "(Lcom/braze/enums/inappmessage/ImageStyle;)V", "messageButtons", "", "Lcom/braze/models/inappmessage/MessageButton;", "getMessageButtons", "()Ljava/util/List;", "setMessageButtons", "(Ljava/util/List;)V", "logButtonClick", "", "messageButton", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IInAppMessageImmersive extends IInAppMessage {
    int getCloseButtonColor();

    Integer getFrameColor();

    String getHeader();

    TextAlign getHeaderTextAlign();

    int getHeaderTextColor();

    ImageStyle getImageStyle();

    List<MessageButton> getMessageButtons();

    boolean logButtonClick(MessageButton messageButton);

    void setCloseButtonColor(int i);

    void setFrameColor(Integer num);

    void setHeader(String str);

    void setHeaderTextAlign(TextAlign textAlign);

    void setHeaderTextColor(int i);

    void setImageStyle(ImageStyle imageStyle);

    void setMessageButtons(List<? extends MessageButton> list);
}
