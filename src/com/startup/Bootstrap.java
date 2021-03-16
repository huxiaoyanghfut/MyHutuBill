package com.startup;


import com.gui.frame.MainFrame;
import com.gui.panel.MainPanel;
import com.gui.panel.SpendPanel;
import com.until.GUIUtil;

import javax.swing.SwingUtilities;



public class Bootstrap {
    public static void main(String[] args) throws Exception{
        GUIUtil.useLNF();

        SwingUtilities.invokeAndWait(() -> {
            MainFrame.instance.setVisible(true);
            MainPanel.instance.workingPanel.show(SpendPanel.instance);
        });
    }
}
