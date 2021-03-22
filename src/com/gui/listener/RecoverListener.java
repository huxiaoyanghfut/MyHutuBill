package com.gui.listener;

import com.gui.panel.BackupPanel;
import com.gui.panel.ConfigPanel;
import com.gui.panel.MainPanel;
import com.service.ConfigService;
import com.until.MysqlUtil;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class RecoverListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        BackupPanel backupPanel = BackupPanel.instance;
        String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
        if (0 == mysqlPath.length()) {
            JOptionPane.showMessageDialog(backupPanel, "请配置数据库路径！");
            MainPanel.instance.workingPanel.show(ConfigPanel.instance);
            return;
        }
        JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(new File("hutubill.sql"));
        fc.setFileFilter(new FileFilter() {

            @Override
            public String getDescription() {
                return ".sql";
            }

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                return f.getName().toLowerCase().endsWith(".sql");
            }
        });
        int returnVal = fc.showSaveDialog(backupPanel);
        File file = fc.getSelectedFile();
        System.out.println(file);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //如果保存的文件名没有以.sql结尾，自动加上.sql
            System.out.println(file);
            if (!file.getName().toLowerCase().endsWith(".sql"))
                file = new File(file.getParent(), file.getName() + ".sql");
            System.out.println(file);
        }
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                MysqlUtil.recover(mysqlPath,file.getAbsolutePath());
//              MysqlUtil.recover(mysqlPath, file.getAbsolutePath());
                JOptionPane.showMessageDialog(backupPanel, "恢复成功");
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(backupPanel, "恢复失败\r\n,错误:\r\n"+e1.getMessage());
            }

        }
    }
}
