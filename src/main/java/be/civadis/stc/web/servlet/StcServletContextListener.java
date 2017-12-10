/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.civadis.stc.web.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Listener de servlet défini (son appel est défini dans le web.xml) pour:
 * <ul>
 * <li>remettre à jour la DB au démarrage du STC lorsqu'un nouveau release a été déployé.</li>
 * </ul>
 * @author yvp
 */
public class StcServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
    }

    public void contextDestroyed(ServletContextEvent event) {
    }

    /**
     * Pour test et debug
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            StcServletContextListener contextListener = new StcServletContextListener();
            contextListener.contextInitialized(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
