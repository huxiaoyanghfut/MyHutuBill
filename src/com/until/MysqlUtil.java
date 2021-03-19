package com.until;

import java.io.*;

public class MysqlUtil {
    public static  void backup(String mysqlPath, String backupFile) throws IOException{
        String commandFormat = "\"%s/bin/mysqldump.exe\" -u%s -p%s  -hlocalhost  -P%d %s -r \"%s\"";
        String command = String.format(commandFormat, mysqlPath, DBUtil.loginName,DBUtil.password, DBUtil.port, DBUtil.database, backupFile);
        Runtime.getRuntime().exec(command);

    }

    public static void recover(String mysqlPath, String recoverFile) throws IOException {
        try{
            String commandFormat = "\"%s/bin/mysql.exe\" -u%s -p%s  %s";
            String command = String.format(commandFormat, mysqlPath, DBUtil.loginName, DBUtil.password, DBUtil.database);
            Process p = Runtime.getRuntime().exec(command);
            //把数据库文件备份到指定文件夹
            OutputStream out = p.getOutputStream();
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            //缓冲输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(recoverFile),"utf-8"));
            while((inStr = br.readLine()) !=null){
                sb.append(inStr+"\r\n");
            }
            outStr = sb.toString();

            OutputStreamWriter writer = new OutputStreamWriter(out,"utf-8");
            writer.write(outStr);
            writer.flush();
            out.close();
            br.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String mysqlPath = "C:\\Program Files\\MySQL\\MySQL Server 5.7";
        String file = "D:\\coding\\javaProjects\\Projects\\MyHutuBill\\backup\\hutubill.sql";
        backup(mysqlPath, file);
        recover(mysqlPath, file);
//        restore();


    }

}
