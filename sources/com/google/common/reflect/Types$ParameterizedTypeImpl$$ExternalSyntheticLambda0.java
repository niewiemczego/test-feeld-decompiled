package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.reflect.Types;
import java.lang.reflect.Type;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Types$ParameterizedTypeImpl$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ Types.JavaVersion f$0;

    public /* synthetic */ Types$ParameterizedTypeImpl$$ExternalSyntheticLambda0(Types.JavaVersion javaVersion) {
        this.f$0 = javaVersion;
    }

    public final Object apply(Object obj) {
        return this.f$0.typeName((Type) obj);
    }
}
