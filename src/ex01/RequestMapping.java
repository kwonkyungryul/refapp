package ex01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 메서드 위에만 걸 수 있다.
@Retention(RetentionPolicy.RUNTIME) // 런타임시에 실행됨
public @interface RequestMapping {
    String uri();
}
