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
	Image heroImg[][]=new Image[4][3];
	Image currentImg;
	int x=120,y=120,i,j,l=0,k=1;
	public MainCanvas(){
	try
	{
		/*
		iµÄº¬Òå
		0:up
		1:down
		2:left
		3:right
		*/
		for(i=0;i<heroImg.length;i++)
			for(j=0;j<heroImg[i].length;j++){
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
		currentImg=heroImg[1][0];
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	}
	public void paint(Graphics g){
		g.setColor(255,255,255);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
    public void keyPressed(int keyCode)
	{
	     int action=getGameAction(keyCode);
		 if(action==DOWN)
			 {
			 if (k==1)
			 {
				 currentImg=heroImg[1][1];
				 y=y+3;
				 k++;
			 }
			 else if (k==2)
			 {
                 currentImg=heroImg[1][2];
				 y=y+3;
				 k=1;
			 }
			 }
		 if(action==LEFT)
			 {
			if (k==1)
			 {
				 currentImg=heroImg[2][1];
				 x=x-3;
				 k++;
			 }
			 else if (k==2)
			 {
                 currentImg=heroImg[2][2];
				 x=x-3;
				 k=1;
			 }
			 }
		 if(action==UP)
			 {			 
			if (k==1){
				 currentImg=heroImg[0][1];
				 y=y-3;
				 k++;
				 }
			 else if (k==2){
                 currentImg=heroImg[0][2];
				 y=y-3;
				 k=1;
				}
			 }
		 if(action==RIGHT)
			 {
			 if (k==1)
			 {
				 currentImg=heroImg[3][1];
				 x=x+3;
				 k++;
			 }
			 else if (k==2)
			 {
                 currentImg=heroImg[3][2];
				 x=x+3;
				 k=1;
			 }
			 }
		    repaint();
	}
}