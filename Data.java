package brainwave;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.*;
import neurosky.*;


/**
 *
 * @author Md. Mirajul Islam
 */

public class Data extends PApplet{
    ThinkGearSocket neurosocket;
    int attention=10;
    int meditation=10;
    PFont font;
    static int count=0;
    PrintWriter writer = null;

    public static String filename = "device.txt" ;
    public static Boolean forcestop = false ;
    public static Boolean filechange = false ;
    
   
    @Override
    public void settings() 
    {
        size(600, 600);
    }
    @Override
    public void setup()
    {

        count=1;
        neurosocket = new ThinkGearSocket(this);
        try {
            //writer = new PrintWriter(new FileWriter("f:/waveLevels.txt"));
            writer = new PrintWriter(filename, "UTF-8");
            neurosocket.start();
        } 
        catch (FileNotFoundException | ConnectException e){
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        smooth();
        font = createFont("Verdana",12);
        textFont(font);
    }
   
   
    @Override
    public void draw()
    {
        fill(0, 0,0, 255);
        noStroke();
        rect(0,0,120,80);
        fill(0, 0,0, 10);
        noStroke();
        rect(0,0,width,height);
        fill(0, 116, 168);
        stroke(0, 116, 168);
        text("Attention: "+attention, 10, 30);
        noFill();
        ellipse(width/2,height/2,attention*3,attention*3);
        fill(209, 24, 117, 100);
        noFill();
        text("Meditation: "+meditation, 10, 50);
        stroke(209, 24, 117, 100);
        noFill();
        ellipse(width/2,height/2,meditation*3,meditation*3);
    }
   
    public void poorSignalEvent(int sig) 
    {
        
        
        if(sig!=200)
        {
            count++;
            writer.println("SignalEvent "+sig);
        }
          
        System.out.println("SignalEvent "+sig);
        
//        if(count>1000 || flag){
//            writer.close();
//            stop();
//        } 
    }

    public void attentionEvent(int attentionLevel) throws FileNotFoundException 
    {
        if(filechange) 
        {
            filechange = false ;
            writer.close();
            try {
                writer = new PrintWriter(filename, "UTF-8");

            } catch(Exception ex) {
                System.out.println("Neorosky Stopped unexpectedly");
            }
            
        }
        
        writer.println("count:"+count);
        writer.println("Attention Level: " + attentionLevel);
        System.out.println("Attention Level: " + attentionLevel);
        System.out.println("COunt: "+ count);
        attention = attentionLevel;

    }

     
    void meditationEvent(int meditationLevel) 
    {
      writer.println("Meditation Level: " + meditationLevel);
      meditation = meditationLevel;
    }

    void blinkEvent(int blinkStrength) {
    }

    public void eegEvent(int delta, int theta, int low_alpha, int high_alpha, int low_beta, int high_beta, int low_gamma, int mid_gamma) 
    {
        
        writer.println("delta Level: " + delta);
        writer.println("theta Level: " + theta);
        writer.println("low_alpha Level: " + low_alpha);
        writer.println("high_alpha Level: " + high_alpha);
        writer.println("low_beta Level: " + low_beta);
        writer.println("high_beta Level: " + high_beta);
        writer.println("low_gamma Level: " + low_gamma);
        writer.println("mid_gamma Level: " + mid_gamma);
        writer.println();
        writer.println();
        writer.flush();
        //println("blinkStrength: " + blinkStrength);
    }
    
    

    void rawEvent(int[] raw) 
    {
      //println("rawEvent Level: " + raw);
    }
    
    
    void meditationEvent(){}
    
    void blinkEvent(){}
    
    void rawEvent(){}
    

    @Override
    public void stop() 
    {
        
        neurosocket.stop();
        super.stop();
        
        
    }
    
    
    
    
}