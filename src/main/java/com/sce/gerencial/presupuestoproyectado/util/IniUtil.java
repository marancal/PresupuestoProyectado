/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sce.gerencial.presupuestoproyectado.util;

import java.io.File;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IniUtil {

    public static final Logger LOGGER = LoggerFactory.getLogger(IniUtil.class);
    private static String ini = "Control.ini";

    /**
     * Lee el archivo de configuracion
     *
     * @param sector Sector del ini al cual acceder
     * @param key Valor correspondiente a la llave
     * @return
     */
    public static String readIni(String sector, String key) {
        return readIni(ini, sector, key);
    }

    /**
     * Lee el archivo de configuracion
     *
     * @param fileName Archivo Ini
     * @param sector Sector del ini al cual acceder
     * @param key Valor correspondiente a la llave
     * @return
     */
    public static String readIni(String fileName, String sector, String key) {
        String value;
        PropertiesIni p = new PropertiesIni();
        try {
            p.load(new File(fileName));
            value = p.get(sector, key);
        } catch (Exception ex) {
            value = null;
            LOGGER.error("Exception: " + sector + "-" + key + " : " + ex.getMessage());
        }
        return value;
    }

    public static String readIni(InputStream is, String sector, String key) {
        String value = "";
        PropertiesIni p = new PropertiesIni();
        try {
            p.load(is);
            value = p.get(sector, key);
        } catch (Exception ex) {
            LOGGER.error("Exception: " + ex.getMessage());
        }
        return value;
    }

    /**
     * Escribir el archivo de configuracion
     *
     * @param sector Sector del ini al cual acceder
     * @param key Valor correspondiente a la llave
     * @param value Valor a escibir
     */
    public static void writeIni(String sector, String key, String value) {
        writeIni(ini, sector, key, value);
    }

    /**
     * Escribir el archivo de configuracion
     *
     * @param fileName Nombre del Archivo
     * @param sector Sector del ini al cual acceder
     * @param key Valor correspondiente a la llave
     * @param value Valor a escibir
     *
     */
    public static void writeIni(String fileName, String sector, String key, String value) {
        PropertiesIni p = new PropertiesIni();
        File file = new File(fileName);
        try {
            p.load(file.getAbsoluteFile());
            p.set(sector, key, value);
            p.store(file);
        } catch (Exception ex) {
            LOGGER.error("Exception: " + ex.getMessage());
        }
    }

    public static void setIni(String ini) {
        IniUtil.ini = ini;
    }
}
