package org.acme.interceptor;

import javax.enterprise.context.Dependent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Dependent
public class CacheMap  {
    private final HashMap<MethodKey, Object> map;

    public CacheMap(){
        this.map = new HashMap<>();
    }

    public Object put(MethodKey key, Object value){
        return map.put(key, value);
    }

    public Object get(MethodKey key){
        return map.get(key);
    }

    public int size(){
        return map.size();
    }

    public boolean isEmpty(){
        return map.isEmpty();
    }
}
