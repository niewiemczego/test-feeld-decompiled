package com.google.zxing.client.result;

import com.google.zxing.Result;
import zendesk.messaging.android.internal.KnownUriSchemes;

public final class TelResultParser extends ResultParser {
    public TelParsedResult parse(Result result) {
        String massagedText = getMassagedText(result);
        if (!massagedText.startsWith(KnownUriSchemes.PHONE_NUMBER) && !massagedText.startsWith("TEL:")) {
            return null;
        }
        String str = massagedText.startsWith("TEL:") ? KnownUriSchemes.PHONE_NUMBER + massagedText.substring(4) : massagedText;
        int indexOf = massagedText.indexOf(63, 4);
        return new TelParsedResult(indexOf < 0 ? massagedText.substring(4) : massagedText.substring(4, indexOf), str, (String) null);
    }
}
