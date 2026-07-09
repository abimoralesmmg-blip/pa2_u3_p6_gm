package ec.com.uce.domain.respository;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.interceptor.InterceptorBinding;

@Retention (RetentionPolicy.RUNTIME)
@Target ({ElementType.METHOD, ElementType.TYPE})
@InterceptorBinding
public @interface Auditar {



}
