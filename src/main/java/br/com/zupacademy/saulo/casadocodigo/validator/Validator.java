/*package br.com.zupacademy.saulo.casadocodigo.validator;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

Problema onde o não consegui transformar minha classe em um Bean gerenciado pelo Spring
assim não conseguindo injetar o EntityManager corretamente.

public class Validator implements ConstraintValidator<UniqueValue, Object> {

    private String domainAttribute;
    private Class<?> klazz;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueValue params) {
        domainAttribute = params.fieldName();
        klazz = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager
                .createQuery("select 1 from "+klazz.getName()+" where "+domainAttribute+" =:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();

        Assert.state(
                list.size()<=1,
                "Foi encontrado mais de um: "+klazz+" com o atributo "+domainAttribute+" = "+value
        );
        return list.isEmpty();
    }
}
*/