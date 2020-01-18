/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fainalpl2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Fady Fayek
 */
public class ThreatsClass extends JPanel  implements KeyListener,ActionListener{

    private boolean play=false;
	private int score=0;
	private int totalbreakes=21;
	private Timer time;
	private int delay=8;
	private int playerx=310;
	
	private int ballposX=350;
	private int ballposY=350;
	
	private int ballXdir=-1;
	private int ballYdir=-2;
	
        private Brecks brecks;
	public ThreatsClass() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		this.time=new Timer(delay,this);
                 brecks=new Brecks(6,9);
                 time.start();
		
	}
	public void paint(Graphics g)
	{
		//backgroung
		g.setColor(Color.black);
		g.fillRect(1,1,692,592);
		//border
		g.setColor(Color.YELLOW);
		g.fillRect(0,0,3,592);
		g.fillRect(0,0,692,3);
	
		g.fillRect(691,0,3,592);
                //score
                g.setColor(Color.CYAN);
                g.setFont(new Font("sarif",Font.ITALIC,28));
                g.drawString(""+score, 590, 30);
               
                
		
		//paddle
		g.setColor(Color.green);
		g.fillRect(playerx,550,100,8);
		//ball
		g.setColor(Color.yellow);
		g.fillOval(ballposX,ballposY,20,20);
                //map
                 brecks.draw((Graphics2D)g);
		      if (ballposY>550) {
                                        play=false;
                                        ballXdir=0;
                                        ballYdir=0;
                                        playerx=350;
                                        
                                        g.setColor(Color.red);
                                        g.setFont(new Font("sarif",Font.ITALIC,28));
                                        g.drawString("GAME OVER your scaor is : "+score,100,300);


                                        g.setFont(new Font("sarif",Font.ITALIC,18));
                                        g.drawString("press enter to restart",180,350);

            
        }
		 g.dispose();
		
	}
	  
	@Override
	public void actionPerformed(ActionEvent e) {
		time.start();
		if(play)
		{
			if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerx,550,100,8)))
			{
				ballYdir =-ballYdir;
			}
                        A:for (int i = 0; i < brecks.map.length; i++) {
                              for (int j = 0; j <brecks.map[0].length; j++) {
                                  if(brecks.map[i][j]>0)
                                  {
                                      int brickx=j*brecks.breakwidth+80;
                                      int bricky=i*brecks.breakhight+50;
                                      int breakw=brecks.breakwidth;
                                      int brealh=brecks.breakhight;
                                      
                                      Rectangle rectangle=new Rectangle(brickx,bricky,breakw,brealh);
                                      Rectangle ballrec=new  Rectangle(ballposX,ballposY,20,20);
                                      Rectangle brick=rectangle;
                                      if(ballrec.intersects(brick))
                                      {
                                          brecks.breakval(0,i, j);
                                          totalbreakes--;
                                          score+=5;
                                          if (ballposX+19 <= brick.x||ballposX+1>=brick.x+brick.width) {
                                              ballXdir=-ballXdir;
                                          }
                                          else
                                          {
                                              ballYdir=-ballYdir;
                                          }
                                          break A;
                                      }
                                  }
                              }
                
            }
			ballposX += ballXdir;
			ballposY += ballYdir;
			if(ballposX<0) {
				ballXdir = -ballXdir;
			}
			if(ballposY<0) {
				ballYdir = -ballYdir;
			}
			if(ballposX > 670)  {
				ballXdir=-ballXdir;
			}
		}
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if(playerx>=590)
			{
				playerx=580;
			}
			else
			{
				moveRight();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(playerx<10)
			{
				playerx=10;
			}
			else
			{
				moveLeft();
			}
		}
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    if(!play)
                    {
                        play=true;
                        playerx=310;
	
                         ballposX=120;
                         ballposY=350;
                         ballXdir=-1;
                         ballYdir=-2;
                         score=0;
                         totalbreakes=21;
                         brecks=new Brecks(6,9);
                         repaint();
                    }
                }
		
	}
	
	public void moveRight()
	{
		play=true;
		playerx+=20;
	}
	public void moveLeft()
	{
		play=true;
		playerx-=20;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}


   /* BufferedReader wep;

    public ThreatsClass(String adress) throws MalformedURLException, IOException {
        URL e=new URL(adress);
        wep=new BufferedReader(new InputStreamReader(e.openStream()));
    }
    public void print() 
    {
        String r;
        try {
            r = wep.readLine();
              while (r!=null) {
            System.out.println(r);
            r=wep.readLine();
           
        }
               wep.close();
        
        } catch (IOException ex) {
            System.out.println(ex);
        }
      
    }*/
   /* private ServerSocket sreverSocket;
    private Socket socket;
    private OutputStream os;
    private PrintWriter printWriter;
    static final int Port_number=3000;

    public ThreatsClass() {
        try {
            sreverSocket=new ServerSocket(Port_number);
        } catch (IOException ex) {
            Logger.getLogger(ThreatsClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void run() throws IOException {
        socket=sreverSocket.accept();
        printWriter=new PrintWriter(socket.getOutputStream(),true);
        System.out.println("massage for client");
        printWriter.close();
        socket.close();
    }*/
    
    
 
