package com.braze.location;

import android.content.Context;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.LocationProviderName;
import com.braze.models.IBrazeLocation;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH&J+\u0010\u000b\u001a\u00020\f2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00030\u000eH&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Lcom/braze/location/IBrazeLocationApi;", "", "initWithContext", "", "context", "Landroid/content/Context;", "allowedProviders", "Ljava/util/EnumSet;", "Lcom/braze/enums/LocationProviderName;", "appConfigurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "requestSingleLocationUpdate", "", "manualLocationUpdateCallback", "Lkotlin/Function1;", "Lcom/braze/models/IBrazeLocation;", "Lkotlin/ParameterName;", "name", "location", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IBrazeLocationApi {
    void initWithContext(Context context, EnumSet<LocationProviderName> enumSet, BrazeConfigurationProvider brazeConfigurationProvider);

    boolean requestSingleLocationUpdate(Function1<? super IBrazeLocation, Unit> function1);
}
