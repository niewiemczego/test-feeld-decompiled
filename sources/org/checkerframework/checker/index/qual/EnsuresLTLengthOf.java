package org.checkerframework.checker.index.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.InheritedAnnotation;
import org.checkerframework.framework.qual.JavaExpression;
import org.checkerframework.framework.qual.PostconditionAnnotation;
import org.checkerframework.framework.qual.QualifierArgument;

@Repeatable(List.class)
@PostconditionAnnotation(qualifier = LTLengthOf.class)
@Documented
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@InheritedAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface EnsuresLTLengthOf {

    @PostconditionAnnotation(qualifier = LTLengthOf.class)
    @Documented
    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
    @InheritedAnnotation
    @Retention(RetentionPolicy.RUNTIME)
    public @interface List {
        EnsuresLTLengthOf[] value();
    }

    @JavaExpression
    @QualifierArgument("offset")
    String[] offset() default {};

    @JavaExpression
    @QualifierArgument("value")
    String[] targetValue();

    @JavaExpression
    String[] value();
}
