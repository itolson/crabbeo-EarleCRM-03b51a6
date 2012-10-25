package com.enterprise.crm.common.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.Arrays;


public class LoggingInterceptor {
    @AroundInvoke
    public Object execute(final InvocationContext ictx) throws Exception {
        final Logger log = LoggerFactory.getLogger(ictx.getTarget().getClass());
        if (log.isTraceEnabled()) {
            String method = buildMethodLogString(ictx);
            log.trace(method + " called");
        }

        try {
            return ictx.proceed();
        } catch (Exception ex) {
            String method = buildMethodLogString(ictx);
            log.error(method + " threw exception", ex);
            throw ex; 
        }
    }

    private String buildMethodLogString(InvocationContext ictx) {
        StringBuilder builder = new StringBuilder(ictx.getMethod().toGenericString());
        Object[] parameters = ictx.getParameters();
        if (parameters != null) {
            builder.append(Arrays.asList(parameters));
        }
        return builder.toString();
    }
}
