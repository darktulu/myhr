package com.wadia.view;

import javax.faces.context.FacesContext;

public class SpringJSFUtil {
	
	public static <T> T getBean(String beanName) {
        if (beanName == null) {
            return null;
        }
        return getValue("#{" + beanName + "}");
    }

    @SuppressWarnings("unchecked")
    private static <T> T getValue(String expression) {
        FacesContext context = FacesContext.getCurrentInstance();
        return (T) context.getApplication().evaluateExpressionGet(context,
                expression, Object.class);
    }

}
