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
				Field f = clazz.getDeclaredField(entry.getKey());   //��ȡ��������е��ֶ�
				//�ж���������
				String value = null;
				if(entry.getValue().length==1) {    // ������ֵ���֣���Ϊ����һ��key��Ӧ�˶��ֵ  hobby  [swim,music,walk]   name [zhangsan]
					value = entry.getValue()[0];
				} else {
					value = Arrays.toString(entry.getValue());
				}
				//�������Ͳ�һ��
				Class type = f.getType();   //��ȡ��������          int,char,String,double
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
				f.setAccessible(true);  //˽���������ÿɷ���
				f.set(o, result);  //��o�����f���Ը�ֵ
			}
			return o;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
