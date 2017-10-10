package com.neo.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * created by 魏霖涛 on 2017/10/10 0010
 */
public class WltAnnotionValide {
//    public static void validLength(Class<?> clazz){
//        Field[] fields = clazz.getDeclaredFields();//返回直接存在于此元素上的所有注释。与此接口中的其他方法不同，该方法将忽略继承的注释。（如果没有注释直接存在于此元素上，则返回长度为零的一个数组。）该方法的调用者可以随意修改返回的数组；这不会对其他调用者返回的数组产生任何影响。
//
//        for(Field field :fields){
//            if(field.isAnnotationPresent(WltLength.class)){
//                WltLength fruitName = (WltLength) field.getAnnotation(WltLength.class);//返回改程序元素上存在的、指定类型的注解，如果该类型注解不存在，则返回null。
//            }
//        }
//    }
    private static final String VALIDOK = "valid ok";
    private static final String VALIDMINFAIL = "'length less than minimum-";
    private static final String VALIDMAXFAIL = "'length exceed the maximum-";
    private static final String VALIDISEMPTYFAIL = " need not null";
    private static Logger log = LoggerFactory.getLogger("");
    @SuppressWarnings("unchecked")
    public static Map<String, Object> validate(Object bean) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("message", "验证通过");
        result.put("result", true);
        Class<?> cls = bean.getClass();
        // 检测field是否存在
        try {
            // 获取实体字段集合
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                // 通过反射获取该属性对应的值
                f.setAccessible(true);
                // 获取字段值
                Object value = f.get(bean);
                // 获取字段上的注解集合
                Annotation[] arrayAno = f.getAnnotations();
                for (Annotation annotation : arrayAno) {
                    // 获取注解类型（注解类的Class）
                    Class<?> clazz = annotation.annotationType();
                    // 获取注解类中的方法集合
                    Method[] methodArray = clazz.getDeclaredMethods();
                    for (Method method : methodArray) {
                        // 获取方法名
                        String methodName = method.getName();
                        // 过滤错误提示方法的调用
                        if(methodName.equals("message")) {
                            continue;
                        }
                        // 初始化注解验证的方法处理类 （我的处理方法卸载本类中）
                        Object obj = WltAnnotionValide.class.newInstance();
                        // 获取方法
                        try {
                            // 根据方法名获取该方法(这种调用方式要求，注解里头的方法和对应的验证方法的方法名一样)
                            Method m = obj.getClass().getDeclaredMethod(methodName, Object.class, Field.class);
                            // 调用该方法
                            result = (Map<String, Object>)m.invoke(obj, value, f);
                            /* 验证结果 有一处失败则退出 */
                            if(result.get("result").equals(false)) {
                                return result;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.info("找不到该方法:"+methodName);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("验证出错");
        }
        return result;
    }
    /**
     * 验证是否空值
     *
     * @author zhy
     * @param value 参数值
     * @param field 字段
     * @return
     */
    public Map<String, Object> isEmpty(Object value, Field field) {
        Map<String, Object> validateResult = new HashMap<String, Object>();
        WltLength annotation = field.getAnnotation(WltLength.class);
        if(annotation.isEmpty()){
            validateResult.put("result", true);
            return validateResult;
        }
        if(value == null || value.equals("")) {
            validateResult.put("message", wltNotNull(annotation.message())?annotation.message():(field.getName()+WltAnnotionValide.VALIDISEMPTYFAIL));
            validateResult.put("result", false);
        } else {
            validateResult.put("message", WltAnnotionValide.VALIDOK);
            validateResult.put("result", true);
        }
        return validateResult;
    }
    /**
     * 验证最小值
     *
     * @author zhy
     * @param value 参数值
     * @param field 字段
     * @return
     */
    public Map<String, Object> min(Object value, Field field) {
        Map<String, Object> validateResult = new HashMap<String, Object>();
        WltLength annotation = field.getAnnotation(WltLength.class);
        if(value != null && value.toString().length() < annotation.min()) {
            validateResult.put("message", wltNotNull(annotation.message())?annotation.message():(field.getName()+WltAnnotionValide.VALIDMINFAIL+annotation.min()));
            validateResult.put("result", false);
        } else {
            validateResult.put("message", WltAnnotionValide.VALIDOK);
            validateResult.put("result", true);
        }
        return validateResult;
    }
    /**
     * 验证最大值
     *
     * @author zhy
     * @param value 参数值
     * @param field 字段
     * @return
     */
    public Map<String, Object> max(Object value, Field field) {
        Map<String, Object> validateResult = new HashMap<String, Object>();
        WltLength annotation = field.getAnnotation(WltLength.class);
        if(value != null && value.toString().length() > annotation.max()) {
            validateResult.put("message", wltNotNull(annotation.message())?annotation.message():(field.getName()+WltAnnotionValide.VALIDMAXFAIL+annotation.max()));
            validateResult.put("result", false);
        } else {
            validateResult.put("message", WltAnnotionValide.VALIDOK);
            validateResult.put("result", true);
        }
        return validateResult;
    }

    public boolean wltNotNull(String str){
        if(str!=null&&str.length()!=0){
            return true;
        }
        return false;
    }

//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//        Test test = new Test();
//        test.setName("111111111111");
//        System.out.println(validate(test));
//
//    }
}
