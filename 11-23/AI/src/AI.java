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
class MainCanvas extends Canvas implements Runnable
{   
	Thread thread;
	Image heroImg[][]=new Image[4][3];
	Image currentImg,bossImg;
	int heroX=120,heroY=120,bossX=0,bossY=0,i,j,flag=1;
	public MainCanvas(){
	try
	{
		/*
		i的含义
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
		bossImg=Image.createImage("/zuzu000.png");

		thread=new Thread(this);
		thread.start();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	}
	/*
	在多线程里写一个死循环，不停的比较boss和hero的坐标
	*/
	public void run(){
		while(true){
			try
			{
				Thread.sleep(200);//FPS：屏幕刷新率
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if(bossX<heroX){
				bossX++;
			}
			else{
				bossX--;
			}

			if(bossY<heroY){
				bossY++;
			}else{
				bossY--;
			}
			repaint();
		}
	}
	public void paint(Graphics g){
		g.setColor(255,255,255);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
		g.drawImage(bossImg,bossX,bossY,0);
	}
	public void changeImg(int direction){
		if(flag==1)
			 {
				currentImg=heroImg[direction][1];
				 flag++;
			 }
			 else if (flag==2)
			 {
                 currentImg=heroImg[direction][2];
				 flag--;
			 }
			repaint();
		}
    public void keyPressed(int keyCode)
	{
	     int action=getGameAction(keyCode);
		 if(action==DOWN)
			 {
				changeImg(1);
				heroY=heroY+3;
			 }
		 if(action==LEFT)
			 {
				changeImg(2);
				heroX=heroX-3;
			 }
		 if(action==UP)
			 {			 
				changeImg(0);
				heroY=heroY-3;
			 }
		 if(action==RIGHT)
			 {
				changeImg(3);
				heroX=heroX+3;
			 }
		    repaint();
	}
}