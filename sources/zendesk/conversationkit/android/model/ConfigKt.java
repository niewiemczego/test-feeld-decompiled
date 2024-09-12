package zendesk.conversationkit.android.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.ConfigDto;
import zendesk.conversationkit.android.internal.rest.model.ConfigResponseDto;
import zendesk.conversationkit.android.internal.rest.model.IntegrationDtoKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toConfig", "Lzendesk/conversationkit/android/model/Config;", "Lzendesk/conversationkit/android/internal/rest/model/ConfigResponseDto;", "zendesk.conversationkit_conversationkit-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Config.kt */
public final class ConfigKt {
    public static final Config toConfig(ConfigResponseDto configResponseDto) {
        Intrinsics.checkNotNullParameter(configResponseDto, "<this>");
        ConfigDto config = configResponseDto.getConfig();
        return new Config(AppKt.toApp(config.getApp()), config.getBaseUrl().getAndroid(), IntegrationDtoKt.toIntegration(config.getIntegration()), RestRetryPolicyKt.toRestRetryPolicy(config.getRestRetryPolicy()));
    }
}
