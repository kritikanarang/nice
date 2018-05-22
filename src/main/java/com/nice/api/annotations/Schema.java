package com.nice.api.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Documented
@Target(FIELD)
@Retention(RUNTIME)
public @interface Schema {

	String dataType() default "";

	int maxLength() default 0;

	String format() default "";
	
	boolean required() default false;
	
	boolean enums() default false;
	
	Class<?> repoName() default void.class ;
	
	String[] enumValues() default "";
	

}
