package org.acme.interceptor;


import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Cached
@Interceptor
public class CacheInterceptor {

    private CacheMap map;

    @Inject
    public CacheInterceptor(CacheMap map){
        this.map = map;
    }

    @AroundInvoke
    public Object cacheMethod(InvocationContext invocationContext) throws Exception {
        MethodKey key = new MethodKey(invocationContext.getParameters(), invocationContext.getMethod());
        Object object;
        if (!map.isEmpty() && map.get(key) != null){
            object =  map.get(key);
            return "It worked wuhu";
        } else {
            object = invocationContext.proceed();
            map.put(key, object);
        }
        return object;
    }
}
