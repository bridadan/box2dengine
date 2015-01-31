package com.bridadan.box2dengine.utils;

public class Utils {
	@SuppressWarnings("rawtypes")
	static public boolean hasSuperclass(Class childClass, Class targetSuperclass) {
		Class superclass = childClass.getSuperclass();
		
		while (superclass != null) {
			if (superclass == targetSuperclass) {
				return true;
			} else {
				superclass = superclass.getSuperclass();
			}
		}
		
		return false;
	}
}
