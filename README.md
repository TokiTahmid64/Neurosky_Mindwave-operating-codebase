# Neurosky Mindwave Operating Codebase


![rsz_52cda964ce395f401b8b456b](https://user-images.githubusercontent.com/44304799/137598472-6d0b6a23-f55b-4ef1-a47b-dc3755b97d34.jpg)

1. Download the JavaFX jdk and the jar files from the following link:
   https://drive.google.com/drive/folders/1zvwzsNCNKtnBiCB4RGov4ztvU1YoWKp-?usp=sharing
   
2. Open a new JavaFX project in your IDE
3. Keep the files named "main2.java" and "data.java" there
4. In the project configuration, add the downloaded jar files and javaFX jdk as library
   ![image](https://user-images.githubusercontent.com/44304799/137598649-276422cb-921e-4435-b6d7-4b2f692c3130.png)
   ![image](https://user-images.githubusercontent.com/44304799/137598667-9b173239-951e-4ac2-bb66-d23d099659df.png)
5. In "Edit configuratio's" VM option copy this part:
   ```
   --module-path I:\Documents\javafx-sdk-11.0.2\lib --add-modules javafx.controls,javafx.fxml,javafx.media
   
   ```
   "I:\Documents\javafx-sdk-11.0.2\lib" in this part place the location of your downloaded javafx jdk libarary
7. From this link https://drive.google.com/drive/folders/1zvwzsNCNKtnBiCB4RGov4ztvU1YoWKp-?usp=sharing download the thinkgear connector. Extract it and run the setup file just once. It will automatically set up the thinkgear application in background.
8. Turn on the device and connect to bluetooth of your PC
9. The device is now ready to be operated. Let's look at some important points of the code:

# Understanding the Code

1. In this project, you will be shown 5 videos and during playing, your eeg data will be recorder. So you first need to put the videos in the proper place. Please download the videos from https://drive.google.com/drive/folders/1zvwzsNCNKtnBiCB4RGov4ztvU1YoWKp-?usp=sharing here, and put the 5 videos directly in the folder "Where you have put the java files" eg. where you have created your javafX project. Don't put them in any folder. Directly put the 5 videos where your java files are present.
2. Create a new folder in your pc where you want to keep the saved data
3. In this part of main2.java, place the location of created folder:

    ```
       public static void copyFiles(String name)
        {
          long time = System.currentTimeMillis();



          String folderName="E:\\2-1\\reserach\\alim sir\\brain\\SAVE_DATA\\"+name+"-"+Long.toString(time);
          System.out.println(folderName);
          new File(folderName).mkdirs();

        }  
        
    ```     

4. Edit "each of the" video containing functions with your created folder name:

   ```
       public void page5video(Stage stage) throws Exception {


        Data.count=0;

        Data.filename="E:\\2-1\\reserach\\alim sir\\brain\\SAVE_DATA\\Smoking.txt"; // Edit this parts folder path. Don't remove the Smoking.txt part

        System.out.println("head set running");
   ```
   
   
5.  Run the code
6.  After the data recording, it will be saved in a new folder in your created folder with the name you will provide at the start of the program running


# Convering to CSV
1. In the csv_convert.java file, put the location of your saved raw file:
   ![image](https://user-images.githubusercontent.com/44304799/137599632-0eec02f8-49e1-4eb4-a0c9-9f20c92d9280.png)
2. Here put the location where you want to save the converted file:
    ![image](https://user-images.githubusercontent.com/44304799/137599649-37e33fa0-8291-4969-a387-64839f36c8d9.png)

   
   
   
   
   
   
   
   
   
   
   
   
   
