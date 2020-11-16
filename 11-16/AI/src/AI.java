import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image currentImg,downImg,leftImg,upImg,rightImg;
	int x=120,y=120;
	public MainCanvas(){
	try
	{
		
		currentImg=Image.createImage("/sayo10.png");
        dowmImg=Image.createImage("/sayo10.png");
		leftImg=Image.createImage("/sayo12.png");
		upImg=Image.createImage("/sayo14.png");
		rightImg=Image.createImage("/sayo16.png");
		
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
    public void keyPressed(int keyCode)
	{
	     int action=getGameAction(keyCode);
		 if(action==DOWN)
			 {
			 currentImg=dowmImg;
			 y=y-5;
			 }
		 if(action==LEFT)
			 {
			 currentImg=leftImg;
			 x=x-5;
			 }
		 if(action==UP)
			 {
	   		 currentImg=upImg;
			 y=y+5;
			 }
		 if(action==RIGHT)
			 {
			 currentImg=rightImg;
			 x=x+5;
			 }
			 repaint();
	}
}