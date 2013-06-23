package com.example.mb.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class FooConverter implements Converter {

    // Init ---------------------------------------------------------------------------------------
    
    private static FooDAO fooDAO = new FooDAO();

    // Actions ------------------------------------------------------------------------------------
    
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        // Convert the unique String representation of Foo to the actual Foo object.
        return fooDAO.find(value);
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        // Convert the Foo object to its unique String representation.
        return ((Foo) value).getKey();
    }

}