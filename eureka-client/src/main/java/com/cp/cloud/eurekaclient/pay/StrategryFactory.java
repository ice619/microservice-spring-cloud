package com.cp.cloud.eurekaclient.pay;

import java.util.HashMap;
import java.util.Set;

import org.reflections.Reflections;

/**
 * Description: 策略工厂
 *
 * @author chenpeng
 * @date 2019/2/27 17:45
 */
public class StrategryFactory {

    private static StrategryFactory factory = new StrategryFactory();
    private StrategryFactory(){}

    public static StrategryFactory getInstance(){
        return factory;
    }

    public static HashMap<Integer, String> source_map = new HashMap<>();

    static{
        //source_map.put(1,"icbcpay");

        //根据注解解析出来，放到map中去，
        // key是注解的值，value是com.cp.pay.impl.ICBCPay
        Reflections  reflections = new Reflections("com.cp.cloud.eurekaclient.pay.impl");
        Set<Class<?>> classList = reflections.getTypesAnnotatedWith(Pay.class);

        //把类上面有pay注解的拿出来，放到map中去
        for(Class clazz : classList){
            Pay t = (Pay)clazz.getAnnotation(Pay.class);
            source_map.put(t.value(),clazz.getCanonicalName());
        }
    }

    public Strategry create(int channlId) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //根据渠道id 去map中取出实现类全类名 ICBCPay
        String clazzCanonicalName = source_map.get(channlId);

        Class<?> clazz_ = Class.forName(clazzCanonicalName);
        return (Strategry)clazz_.newInstance();
    }

}
