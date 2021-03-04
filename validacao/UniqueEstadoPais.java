package br.com.zup.desafio.casadocodigo.paisestado.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = {UniqueEstadoPaisValidator.class})
public @interface UniqueEstadoPais {
    String message() default "Error: Somente valores únicos!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String fieldName1();
    String fieldName2();
    Class<?> domainClass();
}
