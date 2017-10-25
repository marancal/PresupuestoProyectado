/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sce.gerencial.presupuestoproyectado.dao;


import com.sce.gerencial.presupuestoproyectado.entity.WsUser;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CPizarro
 */
@Mapper
@Repository
public interface WsUserDAO {

    List<WsUser> getAll();

}
