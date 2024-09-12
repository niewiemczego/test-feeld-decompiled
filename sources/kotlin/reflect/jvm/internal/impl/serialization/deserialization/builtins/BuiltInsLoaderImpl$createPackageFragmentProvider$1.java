package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: BuiltInsLoaderImpl.kt */
/* synthetic */ class BuiltInsLoaderImpl$createPackageFragmentProvider$1 extends FunctionReference implements Function1<String, InputStream> {
    BuiltInsLoaderImpl$createPackageFragmentProvider$1(Object obj) {
        super(1, obj);
    }

    public final String getName() {
        return "loadResource";
    }

    public final String getSignature() {
        return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(BuiltInsResourceLoader.class);
    }

    public final InputStream invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        return ((BuiltInsResourceLoader) this.receiver).loadResource(str);
    }
}
