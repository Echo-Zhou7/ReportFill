package com.example.reportfill;

import com.example.reportfill.sqlite.SqliteHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author EchoZhou
 * @Description TODO
 * @Date 2023/10/10 18:23
 * @Version 1.0
 */
public class MainApplication extends Application {
    // db 文件存放路径地址
    static String dbPath = System.getProperty("user.dir")+ File.separator+"db"+ File.separator;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("报表填报工具");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        //launch();
        // 1、创建sqlite连接
        String dbFilePath = dbPath + "report.db";
        System.out.println("dbFilePath = " + dbFilePath);
        // 需要判断文件是否存在，不存在则优先创建 .db 文件
        File dbFile = new File(dbFilePath);

        // 如果文件不存在，则创建文件
        if(!dbFile.exists()){
            dbFile.createNewFile();
        }

        // 建立连接
        SqliteHelper sqliteHelper = new SqliteHelper(dbFilePath);

        String createUser = "create table if not exists user(id integer primary key autoincrement,username varchar(20),password varchar(20))";
        // 执行sql
        sqliteHelper.executeUpdate(createUser);

        launch();


    }
}
