package com.enterprise.crm.common.validation;

import org.slf4j.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.slf4j.LoggerFactory.getLogger;

public class ConstraintViolationInterceptor {
    @AroundInvoke
    public Object execute(final InvocationContext ictx) throws Exception {
        try {
            return ictx.proceed();
        } catch (ConstraintViolationException e) {
            final Logger log = getLogger(ictx.getTarget().getClass());
            log.error("***********************************************************");
            log.error(ictx.getMethod().toGenericString() + asList(ictx.getParameters()) + " had the following validation errors: ");

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            for (ConstraintViolation<?> violation : violations) {
                log.error(buildViolationMessage(violation));
            }

            log.error("***********************************************************");

            throw e;
        }
    }

    private String buildViolationMessage(ConstraintViolation<?> violation) {
        return String.format("bean: %s, property: %s, error: %s", violation.getRootBean(), violation.getPropertyPath(),
                violation.getMessage());
    }
}
