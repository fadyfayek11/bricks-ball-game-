/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fainalpl2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Fady Fayek
 */
public class Brecks {
    public int map[][];
    public int breakwidth;
    public int breakhight;

    public Brecks(int row,int col) {
        map=new int[row][col];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j]=1;                
            }
        }
        breakwidth=540/col;
        breakhight=200/row;
    }
    public void draw(Graphics2D g)
    {
     for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j]>0) {
                    g.setColor(Color.white);
                    g.fillRect(j*breakwidth+80,i*breakhight+50,breakwidth,breakhight);
                    g.setStroke(new BasicStroke(8));
                    g.setColor(Color.black);
                    g.drawRect(j*breakwidth+80,i*breakhight+50,breakwidth,breakhight);

                }
              
            }
        }   
    }
    public void breakval(int val,int row,int col)
    {
        map[row][col]=val;
    }
    
}
