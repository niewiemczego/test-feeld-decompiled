package com.adapty.internal.di;

import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.data.cloud.CloudRepository;
import com.adapty.internal.domain.AuthInteractor;
import com.adapty.internal.domain.ProfileInteractor;
import com.adapty.internal.utils.AttributionHelper;
import com.adapty.internal.utils.CustomAttributeValidator;
import com.adapty.internal.utils.IPv4Retriever;
import com.adapty.internal.utils.ProfileMapper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/adapty/internal/domain/ProfileInteractor;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$45 extends Lambda implements Function0<ProfileInteractor> {
    public static final Dependencies$init$45 INSTANCE = new Dependencies$init$45();

    Dependencies$init$45() {
        super(0);
    }

    public final ProfileInteractor invoke() {
        Object obj = Dependencies.INSTANCE.getMap$adapty_release().get(AuthInteractor.class);
        Intrinsics.checkNotNull(obj);
        Object obj2 = ((Map) obj).get((Object) null);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj3 = Dependencies.INSTANCE.getMap$adapty_release().get(CloudRepository.class);
        Intrinsics.checkNotNull(obj3);
        Object obj4 = ((Map) obj3).get((Object) null);
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj5 = Dependencies.INSTANCE.getMap$adapty_release().get(CacheRepository.class);
        Intrinsics.checkNotNull(obj5);
        Object obj6 = ((Map) obj5).get((Object) null);
        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj7 = Dependencies.INSTANCE.getMap$adapty_release().get(ProfileMapper.class);
        Intrinsics.checkNotNull(obj7);
        Object obj8 = ((Map) obj7).get((Object) null);
        Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj9 = Dependencies.INSTANCE.getMap$adapty_release().get(AttributionHelper.class);
        Intrinsics.checkNotNull(obj9);
        Object obj10 = ((Map) obj9).get((Object) null);
        Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj11 = Dependencies.INSTANCE.getMap$adapty_release().get(CustomAttributeValidator.class);
        Intrinsics.checkNotNull(obj11);
        Object obj12 = ((Map) obj11).get((Object) null);
        Intrinsics.checkNotNull(obj12, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj13 = Dependencies.INSTANCE.getMap$adapty_release().get(IPv4Retriever.class);
        Intrinsics.checkNotNull(obj13);
        Object obj14 = ((Map) obj13).get((Object) null);
        Intrinsics.checkNotNull(obj14, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        return new ProfileInteractor((AuthInteractor) ((DIObject) obj2).provide(), (CloudRepository) ((DIObject) obj4).provide(), (CacheRepository) ((DIObject) obj6).provide(), (ProfileMapper) ((DIObject) obj8).provide(), (AttributionHelper) ((DIObject) obj10).provide(), (CustomAttributeValidator) ((DIObject) obj12).provide(), (IPv4Retriever) ((DIObject) obj14).provide());
    }
}
