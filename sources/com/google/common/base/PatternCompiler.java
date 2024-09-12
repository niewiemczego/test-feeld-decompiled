package com.google.common.base;

@ElementTypesAreNonnullByDefault
interface PatternCompiler {
    CommonPattern compile(String str);

    boolean isPcreLike();
}
