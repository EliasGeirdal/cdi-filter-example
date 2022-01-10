package org.acme.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class MethodKey {
    private Object[] parameters;
    private Method method;

    public MethodKey(Object[] parameters, Method method){
        this.parameters = parameters;
        this.method = method;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public Method getMethod() {
        return method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodKey methodKey = (MethodKey) o;
        return Arrays.equals(parameters, methodKey.parameters) && Objects.equals(method, methodKey.method);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(method);
        result = 31 * result + Arrays.hashCode(parameters);
        return result;
    }
}
