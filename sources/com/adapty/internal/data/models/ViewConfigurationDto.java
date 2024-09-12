package com.adapty.internal.data.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/data/models/ViewConfigurationDto;", "", "config", "Lcom/adapty/internal/data/models/ViewConfigurationConfig;", "id", "", "(Lcom/adapty/internal/data/models/ViewConfigurationConfig;Ljava/lang/String;)V", "getConfig", "()Lcom/adapty/internal/data/models/ViewConfigurationConfig;", "getId", "()Ljava/lang/String;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewConfigurationDto.kt */
public final class ViewConfigurationDto {
    @SerializedName("paywall_builder_config")
    private final ViewConfigurationConfig config;
    @SerializedName("paywall_builder_id")
    private final String id;

    public ViewConfigurationDto(ViewConfigurationConfig viewConfigurationConfig, String str) {
        this.config = viewConfigurationConfig;
        this.id = str;
    }

    public final ViewConfigurationConfig getConfig() {
        return this.config;
    }

    public final String getId() {
        return this.id;
    }
}
