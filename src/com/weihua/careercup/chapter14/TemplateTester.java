package com.weihua.careercup.chapter14;

public class TemplateTester<T extends Object> {

    public T getMax(T t1, T t2) {
        return t1.hashCode() > t2.hashCode() ? t1 : t2;
    }
    
    // Note: below code won't compile, because "Cannot make a static reference to the non-static type T"
//    public static T getMax(T t1, T t2) {
//        return t1.hashCode() > t2.hashCode() ? t1 : t2;
//    }
}
