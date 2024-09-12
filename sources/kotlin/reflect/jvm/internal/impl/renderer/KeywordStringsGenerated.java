package kotlin.reflect.jvm.internal.impl.renderer;

import com.adapty.internal.crossplatform.UtilsKt;
import com.facebook.hermes.intl.Constants;
import com.facebook.internal.ServerProtocol;
import io.sentry.protocol.SentryStackFrame;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KeywordStringsGenerated {
    public static final Set<String> KEYWORDS = new HashSet(Arrays.asList(new String[]{SentryStackFrame.JsonKeys.PACKAGE, "as", "typealias", UtilsKt.CLASS_KEY, "this", "super", "val", "var", "fun", "for", "null", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, Constants.CASEFIRST_FALSE, "is", "in", "throw", "return", "break", "continue", "object", "if", "try", "else", "while", "do", "when", "interface", "typeof"}));
}
