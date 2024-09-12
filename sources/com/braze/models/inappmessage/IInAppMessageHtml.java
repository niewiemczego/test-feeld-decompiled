package com.braze.models.inappmessage;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/braze/models/inappmessage/IInAppMessageHtml;", "Lcom/braze/models/inappmessage/IInAppMessage;", "localAssetsDirectoryUrl", "", "getLocalAssetsDirectoryUrl", "()Ljava/lang/String;", "setLocalAssetsDirectoryUrl", "(Ljava/lang/String;)V", "logButtonClick", "", "buttonId", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IInAppMessageHtml extends IInAppMessage {
    String getLocalAssetsDirectoryUrl();

    boolean logButtonClick(String str);

    void setLocalAssetsDirectoryUrl(String str);
}
