package com.wadia.view;

import javax.faces.context.FacesContext;

public class BaseBean {

    public Object getManagedBean(String expression) {
	FacesContext context = FacesContext.getCurrentInstance();
	Object data = context.getApplication().getExpressionFactory()
		.createValueExpression(context.getELContext(), expression, Object.class)
		.getValue(context.getELContext());
	return data;
    }
}
