package edu.ecnu.bioinfo.commoncontrol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.ui.console.MessageConsoleStream;

public class OutputStream2ConsoleThread extends Thread {
	InputStream is;
    MessageConsoleStream consoleStream;
    public OutputStream2ConsoleThread(InputStream is, MessageConsoleStream consoleStream){
    	this.is = is;
    	this.consoleStream = consoleStream;
    }
	
	 public void run()
     {
         try
         {
             BufferedReader br = new BufferedReader(new InputStreamReader(is));
             String line;
             while ( (line = br.readLine()) != null)
            	 consoleStream.write(line + "\n"); 
         } catch (IOException ioe){
             ioe.printStackTrace();  
         }
     }

}
