package com.yourpackage.logging;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingHandler implements InvocationHandler {
    private final Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Loggable.class)) {
            String methodName = method.getName();
            StringBuilder argsBuilder = new StringBuilder("(");
            if (args != null && args.length > 0) {
                argsBuilder.append(args[0]);
                for (int i = 1; i < args.length; i++) {
                    argsBuilder.append(", ").append(args[i]);
                }
            }
            argsBuilder.append(")");
            String argsString = argsBuilder.toString();
            String message = methodName + argsString;
            MethodLogger.log("Chamando: " + message);
        }
        return method.invoke(target, args);
    }
}
