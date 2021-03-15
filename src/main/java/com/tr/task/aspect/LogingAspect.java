package com.tr.task.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tr.task.utils.FactoryUtils;

@Component
@Aspect
public class LogingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogingAspect.class);

	@Pointcut("@annotation(com.tr.task.aspect.Loggable)")
	public void executeLogMethod() {
	};

//	@Before("executeLogMethod()")
//	public void executeLogMetod(JoinPoint joinPoint) {
//		StringBuilder message = new StringBuilder();
//		message.append(joinPoint.getSignature().getDeclaringTypeName());
//		message.append(".");
//		message.append(joinPoint.getSignature().getName() + "()");
//
//		Object[] args = joinPoint.getArgs();
//
//		if (args != null && args.length > 0) {
//
//			message.append(" args:[|");
//			Arrays.asList(args).forEach(arg -> {
//				message.append(arg);
//				message.append("|");
//			});
//			message.append("]");
//		}
//
//		LOGGER.info(message.toString());
//
//	}

	@Around("@annotation(com.tr.task.aspect.Loggable)")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = FactoryUtils.tic();

		StringBuilder message = new StringBuilder();
		message.append(joinPoint.getSignature().getDeclaringTypeName());
		message.append(".");
		message.append(joinPoint.getSignature().getName() + "()");

		Object returnValue = joinPoint.proceed();
		long elapsedTime = FactoryUtils.toc(startTime);

		LOGGER.info(message.toString());

		LOGGER.info("Elapsed Time:" + elapsedTime + "ms");

		return returnValue;
	}
}
