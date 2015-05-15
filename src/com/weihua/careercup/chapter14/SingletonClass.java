package com.weihua.careercup.chapter14;

public class SingletonClass {
    
    private static SingletonClass singletonClassInstance = null;
    
    private SingletonClass() {
    }
    
    public synchronized SingletonClass getInstance() {
        if (singletonClassInstance == null) {
            singletonClassInstance = new SingletonClass();
        }
        
        return singletonClassInstance;
    }

}
