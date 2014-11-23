package br.com.programadoresemacao.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface HelpListViewComponent {
	int value();
	String imageTipe() default "RESOURCE";  // BITMAP
}
