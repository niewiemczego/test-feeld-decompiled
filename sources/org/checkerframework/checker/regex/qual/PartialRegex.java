package org.checkerframework.checker.regex.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.InvisibleQualifier;
import org.checkerframework.framework.qual.SubtypeOf;

@InvisibleQualifier
@SubtypeOf({UnknownRegex.class})
@Documented
@Target({})
@Retention(RetentionPolicy.RUNTIME)
public @interface PartialRegex {
    String value() default "";
}
