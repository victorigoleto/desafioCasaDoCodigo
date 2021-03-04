package br.com.zup.desafio.CasaDoCodigo.compartilhado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    @PersistenceContext
    EntityManager em;
    private String domainAttribute;
    private Class<?> klass;

    @Override
    public void initialize(UniqueValue uniqueValue) {
        domainAttribute = uniqueValue.fieldName().toLowerCase();
        klass = uniqueValue.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Query query = em.createQuery("SELECT 1 FROM " + klass.getName()
                + " WHERE " + domainAttribute + "=:value");
        query.setParameter("value", value);

        List<?> list = query.getResultList();

        return list.isEmpty();
    }
}
