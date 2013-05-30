package edu.ecnu.bioinfo.views;

import java.io.IOException;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class ConsoleFactory implements IConsoleFactory {
		

		// TODO Auto-generated method stub
		static MessageConsole console = new MessageConsole("Transfer Infomation",null);

	    public   void  openConsole(){
	         try {
				showConsole();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } 

	    public static void showConsole() throws IOException{
	          if (console   !=   null ) {
	             IConsoleManager manager  =  ConsolePlugin.getDefault()
	                     .getConsoleManager();
	             IConsole[] existing  =  manager.getConsoles();
	             boolean  exists  =   false ;
	            //如果manager中返回的任何一个console为该console，则将标记为设为true
	             for  ( int  i  =   0 ; i  <  existing.length; i ++ ) {
	                  if  (console   ==  existing[i])
	                     exists  =   true ;
	             } 
	            //如果manager中不存在该console则创建该console，并注册到manager中
	             if  ( ! exists)  {
	                 manager.addConsoles( new  IConsole[]  { console  } );
	             } 
	             manager.showConsoleView(console );

	             
	             //System.setOut(new  PrintStream(stream));
	         } 
	     } 

	      public   static   void closeConsole(){
	         IConsoleManager manager  =  ConsolePlugin.getDefault().getConsoleManager();
	          if  (console   !=   null ){
	             manager.removeConsoles( new  IConsole[]  { console  } );
	         } 
	     } 
	    //使用getConsole的静态方法得到实例，而非够着函数，但其实是通过getConsole方法调用构造函数
	      public static MessageConsole getConsole(){
	          return  console ;
	     }

}
