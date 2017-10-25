                                                                                                                                         /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sce.gerencial.presupuestoproyectado.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author CPizarro
 */
@Data
@ToString
@NoArgsConstructor
public class WsUser implements Serializable {

    private Integer idUser;
    private String user;
    private String password;

}
