/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brainwave;

/**
 *
 * @author Nahiyan
 */


import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Text;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.FontWeight;

import static java.lang.System.exit;

public class Main2 extends Application {
    static FileWriter wr;
    static String x;

    public static void copyFiles(String name)
    {
        long time = System.currentTimeMillis();



        String folderName="E:\\2-1\\reserach\\alim sir\\brain\\SAVE_DATA\\"+name+"-"+Long.toString(time);
        System.out.println(folderName);
        new File(folderName).mkdirs();





        InputStream inStream = null;
        OutputStream outStream = null;

        File folder = new File("E:\\2-1\\reserach\\alim sir\\brain\\SAVE_DATA\\");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++)
        {
            try{

                File afile =new File("E:\\2-1\\reserach\\alim sir\\brain\\SAVE_DATA\\"+listOfFiles[i].getName());
                File bfile =new File(folderName+"/"+listOfFiles[i].getName());

                inStream = new FileInputStream(afile);
                outStream = new FileOutputStream(bfile);

                byte[] buffer = new byte[1024];


                int length;
                //copy the file content in bytes
                while ((length = inStream.read(buffer)) > 0){

                    outStream.write(buffer, 0, length);

                }

                inStream.close();
                outStream.close();

//                delete the original file
                afile.delete();

                System.out.println("File is copied successful!");

            }catch(IOException e){
                e.printStackTrace();
            }

        }



    }



    public void page5video(Stage stage) throws Exception {


        Data.count=0;

        Data.filename="E:\\2-1\\reserach\\alim sir\\brain\\SAVE_DATA\\Smoking.txt";

        System.out.println("head set running");



        //goes to user Directory
        URL fileurl=Main.class.getResource("5.mp4");



        //Converts media to string URL
        Media media = new Media(fileurl.toString());

        javafx.scene.media.MediaPlayer player = new   javafx.scene.media.MediaPlayer(media);
        MediaView viewer = new MediaView(player);

        //change width and height to fit video
        DoubleProperty width = viewer.fitWidthProperty();
        DoubleProperty height = viewer.fitHeightProperty();
        width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));
        viewer.setPreserveRatio(true);


        StackPane root = new StackPane();
        root.getChildren().add(viewer);

        //set the Scene
        Scene scenes = new Scene(root);
        stage.setScene(scenes);
        stage.setTitle("Brain wave analysis");
        stage.setFullScreen(true);
        stage.show();



        player.play();
        player.setOnEndOfMedia(new Runnable() {
            public void run()
            {


                Data.filechange = true ;
                try {
                    //  wr.close();
                    copyFiles(x);
                    exit(0);
                    //thanksPage(stage);
                    //Code to run
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
//        page2(stage);

    }

    public void page5(Stage primaryStage) throws Exception{

        System.out.println("Page5 started");

        Button button = new Button();
        button.setText("Proceed");
        button.setFont(new Font(20));
        button.setLayoutX(400);
        button.setLayoutY(400);
        button.setPrefSize(100,50);
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    page5video(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        Pane root = new Pane();



        BackgroundImage myBI= new BackgroundImage(new Image("page5.png",900,600,true,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        root.setBackground(new Background(myBI));
        root.getChildren().add(button);

        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();

    }

    public void page4video(Stage stage) throws Exception {

        //  wr.append("Started Video 4: "+ getTime()+"\n");
        Data.count=0;

        Data.filename="E:\\2-1\\reserach\\alim sir\\brain\\SAVE_DATA\\Sad.txt";
        // Data.filechange = true ;
        //   Data.count=0;
        System.out.println("head set running");

        //goes to user Directory
        URL fileurl=Main.class.getResource("4.mp4");
        //File f = new File(String.valueOf(fileurl));


        //Converts media to string URL
        Media media = new Media(fileurl.toString());
//        Media media = new Media("I:/cg fight/L 4 T 2/0. Thesis Alim sir/Thesis interface/videos/smoking.mp4");
        javafx.scene.media.MediaPlayer player = new   javafx.scene.media.MediaPlayer(media);
        MediaView viewer = new MediaView(player);

        //change width and height to fit video
        DoubleProperty width = viewer.fitWidthProperty();
        DoubleProperty height = viewer.fitHeightProperty();
        width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));
        viewer.setPreserveRatio(true);


        StackPane root = new StackPane();
        root.getChildren().add(viewer);

        //set the Scene
        Scene scenes = new Scene(root);
        stage.setScene(scenes);
        stage.setTitle("Brain wave analysis");
        stage.setFullScreen(true);
        stage.show();



        player.play();
        player.setOnEndOfMedia(new Runnable() {
            public void run()
            {
                Data.filechange = true ;
                try {
                    page5(stage);
                    //Code to run
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });



    }




    public void page4(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //   wr.append("Started Page 4: "+ getTime()+"\n");

//        Scene scene1 = new Scene(root, 900, 600);

        Button button = new Button();
        button.setText("Proceed");
        button.setFont(new Font(20));
        button.setLayoutX(400);
        button.setLayoutY(400);
        button.setPrefSize(100,50);
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    System.out.println("page 4 works");
                    page4video(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        Pane root = new Pane();



        BackgroundImage myBI= new BackgroundImage(new Image("page4.png",900,600,true,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        root.setBackground(new Background(myBI));
        root.getChildren().add(button);

        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();

    }





    public void page3video(Stage stage) throws Exception{

        Data.count=0;

        Data.filename="E:\\2-1\\reserach\\alim sir\\brain\\SAVE_DATA\\Meditation.txt";

        System.out.println("head set running");


        //goes to user Directory
        URL fileurl=Main.class.getResource("3.mp4");
        //File f = new File(String.valueOf(fileurl));


        //Converts media to string URL
        Media media = new Media(fileurl.toString());
//        Media media = new Media("I:/cg fight/L 4 T 2/0. Thesis Alim sir/Thesis interface/videos/smoking.mp4");
        javafx.scene.media.MediaPlayer player = new   javafx.scene.media.MediaPlayer(media);
        MediaView viewer = new MediaView(player);

        //change width and height to fit video
        DoubleProperty width = viewer.fitWidthProperty();
        DoubleProperty height = viewer.fitHeightProperty();
        width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));
        viewer.setPreserveRatio(true);


        StackPane root = new StackPane();
        root.getChildren().add(viewer);

        //set the Scene
        Scene scenes = new Scene(root);
        stage.setScene(scenes);
        stage.setTitle("Brain wave analysis");
        stage.setFullScreen(true);
        stage.show();



        player.play();
        player.setOnEndOfMedia(new Runnable() {
            public void run()
            {

                Data.filechange = true ;


                try {
                    page4(stage);
                    //Code to run
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });




    }

    public void page3(Stage primaryStage) throws Exception{


        Button button = new Button();
        button.setText("Proceed");
        button.setFont(new Font(20));
        button.setLayoutX(400);
        button.setLayoutY(400);
        button.setPrefSize(100,50);
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    System.out.println("page 3 button workds");
                    page3video(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        Pane root = new Pane();



        BackgroundImage myBI= new BackgroundImage(new Image("page3.png",900,600,true,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        root.setBackground(new Background(myBI));
        root.getChildren().add(button);

        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();

    }


    public void page2video(Stage stage) throws Exception {


        Data.count=0;
        URL file_name=Main.class.getResource("data/person1/Neural.txt");

        Data.filename="E:\\2-1\\reserach\\alim sir\\brain\\SAVE_DATA\\Neural.txt";
        //  Data.filechange=true ;
        // Data.count=0;
        System.out.println("head set running");


        //goes to user Directory
        URL fileurl=Main.class.getResource("2.mp4");
        //File f = new File(String.valueOf(fileurl));


        //Converts media to string URL
        Media media = new Media(fileurl.toString());
//        Media media = new Media("I:/cg fight/L 4 T 2/0. Thesis Alim sir/Thesis interface/videos/smoking.mp4");
        javafx.scene.media.MediaPlayer player = new   javafx.scene.media.MediaPlayer(media);
        MediaView viewer = new MediaView(player);

        //change width and height to fit video
        DoubleProperty width = viewer.fitWidthProperty();
        DoubleProperty height = viewer.fitHeightProperty();
        width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));
        viewer.setPreserveRatio(true);


        StackPane root = new StackPane();
        root.getChildren().add(viewer);

        //set the Scene
        Scene scenes = new Scene(root);
        stage.setScene(scenes);
        stage.setTitle("Brain wave analysis");
        stage.setFullScreen(true);
        stage.show();



        player.play();
        player.setOnEndOfMedia(new Runnable() {
            public void run()
            {

                Data.filechange = true ;


                try {
                    page3(stage);
                    //Code to run
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
//        page2(stage);

    }


    public void page2(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Brain wave analysis");
//        Scene scene1 = new Scene(root, 900, 600);

        Button button = new Button();
        button.setText("Proceed");
        button.setFont(new Font(20));
        button.setLayoutX(400);
        button.setLayoutY(400);
        button.setPrefSize(100,50);
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    page2video(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        Pane root = new Pane();



        BackgroundImage myBI= new BackgroundImage(new Image("page2.png",900,600,true,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        root.setBackground(new Background(myBI));
        root.getChildren().add(button);

        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();

    }

    public void page1video(Stage stage) throws Exception {

        Data.count=0;

        Data.filename="E:\\2-1\\reserach\\alim sir\\brain\\SAVE_DATA\\happy.txt";
        //  Data.filechange=true ;
        //  Data.count=0;
        System.out.println("head set running");


        //goes to user Directory
        URL fileurl=Main.class.getResource("1.mp4");
        //File f = new File(String.valueOf(fileurl));


        //Converts media to string URL
        Media media = new Media(fileurl.toString());
        System.out.println("paise");
//        Media media = new Media("I:/cg fight/L 4 T 2/0. Thesis Alim sir/Thesis interface/videos/smoking.mp4");
        javafx.scene.media.MediaPlayer player = new   javafx.scene.media.MediaPlayer(media);
        MediaView viewer = new MediaView(player);

        //change width and height to fit video
        DoubleProperty width = viewer.fitWidthProperty();
        DoubleProperty height = viewer.fitHeightProperty();
        width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));
        viewer.setPreserveRatio(true);


        StackPane root = new StackPane();
        root.getChildren().add(viewer);

        //set the Scene
        Scene scenes = new Scene(root);
        stage.setScene(scenes);
        stage.setTitle("Brain wave analysis");
        stage.setFullScreen(true);
        stage.show();



        player.play();
        player.setOnEndOfMedia(new Runnable() {
            public void run()
            {

                Data.filechange = true ;


                try {
                    page2(stage);
                    //Code to run
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
//        page2(stage);

    }


    public void page1(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Brain wave analysis");

        Button button = new Button();
        button.setText("Proceed");
        button.setFont(new Font(20));
        button.setLayoutX(400);
        button.setLayoutY(400);
        button.setPrefSize(100,50);
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    page1video(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        Pane root = new Pane();



        BackgroundImage myBI= new BackgroundImage(new Image("page1.png",900,600,true,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        root.setBackground(new Background(myBI));
        root.getChildren().add(button);

        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();

    }

    public static String getTime()
    {
        Date date=new Date();
        String fmt= "dd/MM/yyyy hh.mm.ss aa";
        DateFormat df=new SimpleDateFormat(fmt);
        String fmtdDate=df.format(date);
        return fmtdDate;
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {


//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        TextField tf=new TextField();
        tf.setFont(new Font(20));
        Label lf=new Label();
        lf.setFont(new Font(20));
        lf.setText("Your Name: ");

        primaryStage.setTitle("Brain wave analysis");
//        Scene scene1 = new Scene(root, 900, 600);

        Button button_start = new Button();
        button_start.setText("START");
        button_start.setFont(new Font(20));
        button_start.setLayoutX(400);
        button_start.setLayoutY(400);
        button_start.setPrefSize(100,50);
        button_start.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {
                try {

                    x=tf.getText();
                    System.out.println("olamain");

                    page1(primaryStage);


                } catch (Exception e) {
                    System.out.println("welcome page start button");
                }
            }
        });


        Pane root = new Pane();



        BackgroundImage myBI= new BackgroundImage(new Image("welcomePage.jpg",900,600,true,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        HBox hb=new HBox();
        hb.getChildren().addAll(lf,tf);
        hb.setLayoutX(250);
        hb.setLayoutY(300);
        root.getChildren().add(hb);
        //root.setBackground(new Background(myBI));
        root.getChildren().add(button_start);


        //root.getChildren().add(button_start);

        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();

    }


    public Main2() throws Exception
    {

        Data.main("brainwave.Data");

    }


    public static void main(String[] args) throws IOException
    {


        launch(args);
        copyFiles(x);
    }
}

