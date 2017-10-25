/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sce.gerencial.presupuestoproyectado.entity;

//import com.sce.util.StrUtil;

/**
 *
 * @author Marvin
 */
public class Bitacora {

    private String sistema;
    private String tabla;
    private String dtabla;
    private String documento;
    private String proceso;
    private String usuario;
    private String strSql;
    StringBuilder sql;

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getDtabla() {
        return dtabla;
    }

    public void setDtabla(String dtabla) {
        this.dtabla = dtabla;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getStrSql() {
        return strSql;
    }

    public void setStrSql(String strSql) {
        this.strSql = strSql;
    }
}
