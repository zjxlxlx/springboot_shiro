//package com.tofindwork.work.utils;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.Date;
//
//public class ReflectUtil {
//
//    public String reflect(Object model) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//
//        Field[] field = model.getClass().getDeclaredFields();
//        // 遍历所有属性
//        for (int j = 0; j < field.length; j++) {
//            // 获取属性的名字
//            String name = field[j].getName();
//            // 将属性的首字符大写，方便构造get，set方法
//            name = name.substring(0, 1).toUpperCase() + name.substring(1);
//            // 获取属性的类型
//            String type = field[j].getGenericType().toString();
//            // 如果type是类类型，则前面包含"class "，后面跟类名
//            System.out.println("属性为：" + name);
//                Method m = model.getClass().getMethod("get" + name);
//                // 调用getter方法获取属性值
//                String value = (String) m.invoke(model);
//
//                if (value != null) {
//                    return value;
//                } else {
//                    System.out.println("属性值为：空");
//                }
//
//
//
//
//
//
//        }
//    }
//
//
//
//
//    }
//
//
//
