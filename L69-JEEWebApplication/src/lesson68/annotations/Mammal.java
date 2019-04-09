package lesson68.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/** some javadoc
 * @author mitrofanov_a
 */
//@Inherited
@Documented
@Target(value={ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Mammal {
	int pawsAmt() default 2;
	String[] pawsColor();
}
