/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.utilidades;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author talentoti
 */
public class ConversionesDeFecha {
    
    /**
     *
     * @param s metodo para convertir de Cadena de caracteres(String) a Date
     *           con el formato dd/MM/yyyy
     * @return fecha la fecha convertida con su formato
     * @throws ParseException lanza esta excepcion en caso que haya ocurrido un error en la conversion de la fecha
     */
    public static Date stringaDate(String s) throws ParseException{
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = formatoDelTexto.parse(s);
        return fecha;
    }
    
    /**
     *
     * @param d metodo para convertir de Date a Cadena de caracteres(String) 
     *           con el formato dd/MM/yyyy
     * @return string la fecha convertida a caracteres
     */
    public static String dateaString(Date d){
        DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        String string = fecha.format(d);
        return string;
    }
     /**
     *
     * @param s metodo para convertir de Cadena de caracteres(String) a Date
     *           con el formato yyyy/dd/MM
     * @return fecha la fecha convertida con su formato
     * @throws ParseException lanza esta excepcion en caso que haya ocurrido un error en la conversion de la fecha
     */
    public static Date stringaDate2(String s) throws ParseException{
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy/dd/MM");
        Date fecha = formatoDelTexto.parse(s);
        return fecha;
    }
    
    /**
     *
     * @param d metodo para convertir de Date a Cadena de caracteres(String) 
     *           con el formato yyyy/dd/MM
     * @return  string la fecha convertida a caracteres
     */
    public static String dateaString2(Date d){
        DateFormat fecha = new SimpleDateFormat("yyyy/dd/MM");
        String string = fecha.format(d);
        return string;
    }
    /**
     *
     * @param d metodo para convertir de Date a Cadena de caracteres(String) 
     *           con el formato dd/MM/yy
     * @return string la fecha convertida a caracteres
     */
    public static String dateaString3(Date d){
        DateFormat fecha = new SimpleDateFormat("dd/MM/yy");
        String string = fecha.format(d);
        return string;
    }
     /**
     *
     * @param s metodo para convertir de Cadena de caracteres(String) a Date
     *           con el formato dd/MM/yy
     * @return fecha la fecha convertida a caracteres
     * @throws ParseException lanza esta excepcion en caso que haya ocurrido un error en la conversion de la fecha
     */
    public static Date stringaDate3(String s) throws ParseException{
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yy");
        Date fecha = formatoDelTexto.parse(s);
        return fecha;
    }

}
