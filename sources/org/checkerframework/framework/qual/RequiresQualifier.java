package org.checkerframework.framework.qual;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Repeatable(List.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresQualifier {

    @Documented
    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface List {
        RequiresQualifier[] value();
    }

    String[] expression();

    Class<? extends Annotation> qualifier();
}
