package com.shiningcity.fanshe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shiningcity.company.pojo.BaseCompany;

public class Reflection {
	
	private static Logger logger = LoggerFactory.getLogger(Reflection.class);
	
	public static void main(String[] args) {
		BaseCompany com = new BaseCompany();
		com.setCompanyCode("666");
		com.setCompanyName("闪耀之城");
		com.setCompanyAddress("中国");
//		Person person=new Person();Class clazz=person.getClass();
//		Person person=new Person();Class clazz=person.class;
//		Class clazz=Class.formName("com.tlc.Person");
		Class<? extends BaseCompany> class1 = com.getClass();
		Class<? extends BaseCompany> class2 = BaseCompany.class;
		Class<?> class3 = null;
		try {
			class3 = Class.forName("com.shiningcity.company.pojo.BaseCompany");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.warn("--------------------------------");
		logger.warn("class1 == {}",class1.getName());
		logger.warn("class2 == {}",class2.getName());
		logger.warn("class3 == {}",class3.getName());
		
		Class<?> superclass = class1.getSuperclass();
		logger.warn("superclass == {}",superclass.getName());

		logger.warn("--------------------------------");
		try {
			//获取类型为public的属性，没有则抛出异常
			Field field = class1.getField("companyCode");
			String name = field.getName();
			logger.warn("field.getName('companyCode') == {}",name);
		} catch (NoSuchFieldException | SecurityException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		logger.warn("--------------------------------");
		//获取此类或者接口中的为public类型的属性
		Field[] fields = class1.getFields();
		for (int i = 0; i < fields.length; i++) {
			String name = fields[i].getName();
			int modifiers = fields[i].getModifiers();
			Class<?> type = fields[i].getType();
			logger.warn("field.getName() == {}",name);
			logger.warn("field.getModifiers() == {}",modifiers);
			logger.warn("field.getType() == {}",type);
		}
		/*
JAVA 反射机制中，Field的getModifiers()方法返回int类型值表示该字段的修饰符。
其中，该修饰符是java.lang.reflect.Modifier的静态属性。
对应表如下：
PUBLIC: 1
PRIVATE: 2
PROTECTED: 4
STATIC: 8
FINAL: 16
SYNCHRONIZED: 32
VOLATILE: 64
TRANSIENT: 128
NATIVE: 256
INTERFACE: 512
ABSTRACT: 1024
STRICT: 2048
		 */

		logger.warn("--------------------------------");
		try {
			Field declaredField = class1.getDeclaredField("companyCode");
			logger.warn("field.getDeclaredField('companyCode') == {}",declaredField.getName());
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.warn("--------------------------------");
		Field[] declaredFields = class1.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			String name = declaredFields[i].getName();
			int modifiers = declaredFields[i].getModifiers();
			Class<?> type = declaredFields[i].getType();
			logger.warn("field.getDeclaredField() == {}",name);
			logger.warn("field.getModifiers() == {}",modifiers);
			logger.warn("field.getType() == {}",type);
		}

		logger.warn("--------------------------------");
		Method[] methods = class1.getMethods();
		for (int i = 0; i < methods.length; i++) {
			String name = methods[i].getName();
			int modifiers = methods[i].getModifiers();
			Class<?>[] parameterTypes = methods[i].getParameterTypes();
			Class<?> returnType = methods[i].getReturnType();
			logger.warn("field.getDeclaredField() == {}",name);
			logger.warn("field.getModifiers() == {}",modifiers);
			logger.warn("field.getParameterTypes() == {}",parameterTypes);
			logger.warn("field.getReturnType() == {}",returnType);
		}
		
		
	}
}
