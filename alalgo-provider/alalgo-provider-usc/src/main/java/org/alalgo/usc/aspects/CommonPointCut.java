package org.alalgo.usc.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 常用pointcut放在一起，便于复用
 * @author security
 *
 */
@Aspect
@Component
public class CommonPointCut {
	@Pointcut("within(org.alalgo.usc.service..*)")	
	public void serviceLayer() {}

	@Pointcut("within(org.alalgo.usc..*)")
	public void allLayer() {}
}
