/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sce.gerencial.presupuestoproyectado.service.impl;


import com.sce.gerencial.presupuestoproyectado.dao.WsUserDAO;
import com.sce.gerencial.presupuestoproyectado.entity.WsUser;
import com.sce.gerencial.presupuestoproyectado.service.IExampleService;
import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author CPizarro
 */
@Data
@Service
@Transactional
public class ExampleServiceImpl implements IExampleService {

    @Autowired
    private WsUserDAO wsUserDAO;

    @Override
    public List<WsUser> getAllWsUser() {
        return wsUserDAO.getAll();
    }

}
