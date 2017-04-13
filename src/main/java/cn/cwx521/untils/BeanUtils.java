package cn.cwx521.untils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class BeanUtils {
	public static Object createBean(Map<String, String[]> map, Class clazz) {
		try {
			Object o = clazz.newInstance();   // new User();
			Field[] field = clazz.getDeclaredFields();
			for(Iterator<Entry<String, String[]>> iterator = map.entrySet().iterator();iterator.hasNext();) {
				Entry<String, String[]> entry = iterator.next();
				Field f = clazz.getDeclaredField(entry.getKey());   //获取到类对象中的字段
				//判断数据类型
				String value = null;
				if(entry.getValue().length==1) {    // 将数据值区分，因为存在一个key对应了多个值  hobby  [swim,music,walk]   name [zhangsan]
					value = entry.getValue()[0];
				} else {
					value = Arrays.toString(entry.getValue());
				}
				//数据类型不一样
				Class type = f.getType();   //获取属性类型          int,char,String,double
				Object result = null;
				switch(f.getType().getSimpleName()) {
					case "int":
						result = Integer.valueOf(value);
						break;
					case "double":
						result = Double.valueOf(value);
						break;
					case "String":
						result = value;
						break;
					case "char":
						result = value.charAt(0);
						break;
				}
				f.setAccessible(true);  //私有属性设置可访问
				f.set(o, result);  //给o对象的f属性赋值
			}
			return o;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
