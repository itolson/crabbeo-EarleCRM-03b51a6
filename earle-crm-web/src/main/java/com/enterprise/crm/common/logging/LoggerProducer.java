
package com.enterprise.crm.common.logging;

import org.slf4j.Logger;

import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import static javax.ejb.LockType.READ;
import static org.slf4j.LoggerFactory.getLogger;

@Singleton
@Lock(READ)
public class LoggerProducer {
    @Produces
    public Logger createLogger(InjectionPoint injectionPoint) {
        return getLogger(injectionPoint.getMember().getDeclaringClass());
    }
}