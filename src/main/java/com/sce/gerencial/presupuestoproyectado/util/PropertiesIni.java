/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sce.gerencial.presupuestoproyectado.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesIni {

    public static final Logger LOGGER = LoggerFactory.getLogger(PropertiesIni.class);
    private final LinkedHashMap<String, Object> header = new LinkedHashMap<String, Object>();

    public synchronized void load(File file) {
        InputStream is = null;
        try {
            is = new FileInputStream(file.getAbsoluteFile());
            load(is);
        } catch (Exception ex) {
            LOGGER.error("Exception: " + ex.getMessage());
        } finally {
            try {
                is.close();
            } catch (Exception ex) {
                LOGGER.error("Exception: " + ex.getMessage());
            }
        }
    }

    public synchronized void load(InputStream is) {
        BufferedReader br = null;
        InputStreamReader isr = null;
        String line;
        int come = 0;
        String comeVal = "";
        try {
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            line = br.readLine();
            while (line != null) {
                if (line.startsWith("#") || line.startsWith(";")) {
                    header.put("Comentario_" + come, line);
                    come++;
                    line = br.readLine();
                } else if (line.trim().startsWith("[") && line.trim().endsWith("]")) {
                    if (!comeVal.equals("")) {
                        header.put("Comentario_" + come, comeVal);
                        come++;
                        comeVal = "";
                    }
                    String group = line.substring(1, line.length() - 1);
                    line = br.readLine();
                    LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
                    while (line != null && !line.trim().startsWith("[")) {
                        if (!comeVal.equals("")) {
                            data.put("Comentario_" + come, comeVal);
                            come++;
                            comeVal = "";
                        }
                        if (line.startsWith("#") || line.startsWith(";")) {
                            comeVal = line;
                            line = br.readLine();
                            continue;
                        } else if (line.trim().equals("") || line.indexOf("=") == -1) {
                            line = br.readLine();
                            continue;
                        }

                        String[] key = new String[2];
                        int index = line.indexOf("=");
                        key[0] = line.substring(0, index);
                        key[1] = line.substring(index + 1, line.length());
                        data.put(key[0], key[1]);
                        line = br.readLine();
                    }
                    header.put(group, data);
                } else {
                    line = br.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
            LOGGER.error("FileNotFoundException: " + ex.getMessage());
        } catch (IOException ex) {
            LOGGER.error("IOException: " + ex.getMessage());
        } catch (Exception ex) {
            LOGGER.error("Exception: " + ex.getMessage());
        } finally {
            try {
                br.close();
                isr.close();
                is.close();
            } catch (IOException ex) {
                LOGGER.error("IOException: " + ex.getMessage());
            } catch (Exception ex) {
                LOGGER.error("Exception: " + ex.getMessage());
            }
        }
    }

    public String get(String seccion, String key) throws Exception {
        LinkedHashMap val = (LinkedHashMap) header.get(seccion);
        return val.get(key).toString();
    }

    public void set(String seccion, String key, String value) {
        LinkedHashMap val = (LinkedHashMap) header.get(seccion);
        val.put(key, value);
    }

    public void store(File file) {
        FileWriter fw;
        PrintWriter pw;
        try {
            fw = new FileWriter(file);
            pw = new PrintWriter(fw);
            Set<String> keys = header.keySet();
            Object[] keyArrays = keys.toArray();
            for (int i = 0; i < keyArrays.length; i++) {
                String seccion = keyArrays[i].toString();
                Object data = header.get(seccion);
                if (data.getClass().equals(String.class)) {
                    pw.println(data.toString());
                } else {
                    pw.println("[" + seccion + "]");
                    LinkedHashMap val = (LinkedHashMap) data;
                    Object[] valueArrays = val.keySet().toArray();
                    for (int j = 0; j < valueArrays.length; j++) {
                        String value = val.get(valueArrays[j]).toString();
                        if (value.startsWith("#") || value.startsWith(";")) {
                            pw.println(value);
                        } else {
                            pw.println(valueArrays[j] + "=" + value);
                        }
                    }
                    pw.println();
                }
            }
            pw.close();
        } catch (IOException ex) {
            LOGGER.error("IOException: " + ex.getMessage());
        } catch (Exception ex) {
            LOGGER.error("Exception: " + ex.getMessage());
        }
    }
}
