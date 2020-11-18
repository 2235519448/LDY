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
	Image currentImg,downImg1,downImg2,downImg3,leftImg1,leftImg2,leftImg3,upImg1,upImg2,upImg3,rightImg1,rightImg2,rightImg3;
	int x=120,y=120,i=0,j=0;
	public MainCanvas(){
	try
	{
		
		currentImg=downImg1=Image.createImage("/sayo10.png");
		downImg2=Image.createImage("/sayo00.png");
		downImg3=Image.createImage("/sayo20.png");
		upImg1=Image.createImage("/sayo14.png");
		upImg2=Image.createImage("/sayo04.png");
		upImg3=Image.createImage("/sayo24.png");
		leftImg1=Image.createImage("/sayo12.png");
		leftImg2=Image.createImage("/sayo02.png");
		leftImg3=Image.createImage("/sayo22.png");
		rightImg1=Image.createImage("/sayo16.png");
		rightImg2=Image.createImage("/sayo06.png");
		rightImg3=Image.createImage("/sayo26.png");
		
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
		 if (j!=action)
		 {
			 i=1;
		 }
		 if(action==DOWN)
			 {
			 if (i==1)
			 {
				 currentImg=downImg2;
				 y=y+3;
			 }

			 else if (i==2)
			 {
                 currentImg=downImg3;
				 y=y+3;
			 }
			 else if(i==3)
			 {
                 currentImg=downImg2;
				 y=y+3;
			 }
			 }
		 if(action==LEFT)
			 {
			 if (i==1)
			 {
				 currentImg=leftImg1;
				 x=x-3;
			 }

			 else if (i==2)
			 {
                 currentImg=leftImg2;
				 x=x-3;
			 }
			 else if(i==3)
			 {
                 currentImg=leftImg3;
				 x=x-3;
			 }
			 }
		 if(action==UP)
			 {			 
			 if (i==1)
			 {
				 currentImg=upImg1;
				 y=y-3;
			 }

			 else if (i==2)
			 {
                 currentImg=upImg2;
				 y=y-3;
			 }
			 else if(i==3)
			 {
                 currentImg=upImg3;
				 y=y-3;
			 }
			 }
		 if(action==RIGHT)
			 {
			 if (i==1)
			 {
				 currentImg=rightImg1;
				 x=x+3;
			 }

			 else if (i==2)
			 {
                 currentImg=rightImg2;
				 x=x+3;
			 }
			 else if(i==3)
			 {
                 currentImg=rightImg3;
				 x=x+3;
			 }
			 }
		     j=action;
		     if(i==1)
			    i=2;
		     else if(i==2)
			   i=3;
		     else if(i==3)
			   i=2;
		    repaint();
	}
}