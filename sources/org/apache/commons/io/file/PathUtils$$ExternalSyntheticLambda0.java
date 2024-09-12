package org.apache.commons.io.file;

import java.nio.file.Path;
import java.util.function.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PathUtils$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ Path f$0;

    public /* synthetic */ PathUtils$$ExternalSyntheticLambda0(Path path) {
        this.f$0 = path;
    }

    public final Object apply(Object obj) {
        return this.f$0.relativize((Path) obj);
    }
}
