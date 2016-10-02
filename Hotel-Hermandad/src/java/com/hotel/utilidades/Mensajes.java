package com.hotel.utilidades;

import javax.faces.application.FacesMessage;
import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import static javax.faces.application.FacesMessage.SEVERITY_INFO;
import static javax.faces.application.FacesMessage.SEVERITY_WARN;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.context.FacesContext;


/**
 *
 * @author Carlos
 */
public class Mensajes {
    
    /**
     * Muestra un mensaje de error en la pagina, con detalles
     * @param mensaje representa el mensaje a mostrar 
     * @param detalles representa los posibles detalles del mensaje (opcional)
     */
    public static void agregarMensajeError(String mensaje, String detalles) {        
        agregarMensaje(SEVERITY_ERROR, mensaje, detalles);
    }
    
    public static boolean retraso(){
        try{
            Thread.sleep(2000);  
        }catch (InterruptedException ie){
            System.out.println(ie.getMessage());
        }
        return false;
    }
    
    /**
     * Muestra un mensaje de error en la pagina, pero sin detalles
     * @param mensaje representa el mensaje a mostrar 
     */
    public static void agregarMensajeError(String mensaje) {
        agregarMensaje(SEVERITY_ERROR, mensaje, null);
    }
    
    
    /**
     * Muestra un mensaje de información en la pagina 
     * @param mensaje: representa el mensaje a mostrar
     * @param detalles: representa los posibles detalles del mensaje (opcional)
     */
    public static void agregarMensajeInformacion(String mensaje, String detalles) {        
        agregarMensaje(SEVERITY_INFO, mensaje, detalles);
    }
    
    /**
     * Muestra un mensaje de información en la pagina, pero sin detalles
     * @param mensaje  representa el mensaje a mostrar
     */
    public static void agregarMensajeInformacion(String mensaje) {
        agregarMensaje(SEVERITY_INFO, mensaje, null);
    }
    
    
    /**
     * Muestra un mensaje de advertencia en la pagina 
     * @param mensaje: representa el mensaje a mostrar
     * @param detalles: representa los posibles detalles del mensaje (opcional)
     */
    public static void agregarMensajeAdvertenica(String mensaje, String detalles) {        
        agregarMensaje(SEVERITY_WARN, mensaje, detalles);
    }
    
    /**
     * Muestra un mensaje de advertencia en la pagina, pero sin detalles
     * @param mensaje representa el mensaje a mostrar
     */
    public static void agregarMensajeAdvertenica(String mensaje) {
        agregarMensaje(SEVERITY_WARN, mensaje, null);
    }
    
    
    private static void agregarMensaje(FacesMessage.Severity severity, String mensaje, String detalles) {
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(severity, mensaje, detalles));
    }
    
     public static boolean isDummySelectItem(UIComponent component, String value) {
        for (UIComponent children : component.getChildren()) {
            if (children instanceof UISelectItem) {
                UISelectItem item = (UISelectItem) children;
                if (item.getItemValue() == null && item.getItemLabel().equals(value)) {
                    return true;
                }
                break;
            }
        }
        return false;
    }
    
}
