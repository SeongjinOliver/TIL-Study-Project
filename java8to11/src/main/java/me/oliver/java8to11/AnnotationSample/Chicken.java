package me.oliver.java8to11.AnnotationSample;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Target(ElementType.TYPE_USE) Annotation : ElementType.TYPE_PARAMETER를 통함한 곳 모든 곳에서 사용 가능하다.
 *
 * Repeatable Annotation : 여러개의 애노테이션들을 감싸고 있을 컨테이너 애노테이션 타입을 선언한다.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Repeatable(ChickenContainer.class)
public @interface Chicken {
  String value();
}
