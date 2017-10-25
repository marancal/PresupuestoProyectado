/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sce.gerencial.presupuestoproyectado;


import com.sce.gerencial.presupuestoproyectado.view.JFrmMain;
import com.sce.gerencial.presupuestoproyectado.view.JFrmPresupuesto;
import javax.swing.SwingUtilities;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Sintad
 */
@SpringBootApplication
@EnableTransactionManagement
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         ConfigurableApplicationContext context = new SpringApplicationBuilder(Main.class).headless(false).run();
        SwingUtilities.invokeLater(() -> {
             JFrmPresupuesto frmMain = context.getBean(JFrmPresupuesto.class);
            frmMain.setLocationRelativeTo(null);
            frmMain.setVisible(true);
        });
    }
    
}
