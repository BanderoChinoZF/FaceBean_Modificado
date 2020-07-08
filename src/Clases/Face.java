/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.*;
import javax.swing.*;
 
public class Face extends JComponent {
    private int mMouthWidth = 90;
    private boolean mSmile = true;
     
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Face (Cara)
        int w = getWidth();
        int h = getHeight();
        int pad = 12;
        int cw = w - pad * 2;
        int ch = h - pad * 2;
        g2.setColor(Color.GRAY);
        g2.fillArc(pad, pad, cw, ch, 0, 360);
        g2.setColor(getForeground());
        g2.drawArc(pad, pad, cw, ch, 0, 360);
        
        // Mouth (Boca)
        int sw = cw / 2;
        int sh = ch / 2;
        if (mSmile == true)
            g2.drawArc(w / 2 - sw / 2, h / 2 - sh / 2, sw, sh, 270 - mMouthWidth / 2, mMouthWidth);
        else
            g2.drawArc(w / 2 - sw / 2, h / 2 + sh / 3, sw, sh, 90 - mMouthWidth / 2, mMouthWidth);
        
        // Eyes (Ojos)
        int er = 15;
        g2.setColor(Color.BLUE);
        g2.fillArc(w / 2 - cw * 1 / 8 - er / 2, h / 2 - ch / 4 - er, er, er, 0, 360);
        g2.fillArc(w / 2 + cw * 1 / 8 - er / 2, h / 2 - ch / 4 - er, er, er, 0, 360);
        
        // Eyebrows (Cejas)
        g2.setColor(Color.BLACK);
        g2.drawLine(140, 88, 170, 88);
        g2.drawLine(235, 88, 265, 88);
        
    }
     
    public int getMouthWidth() {
        return mMouthWidth;
    }
     
    public void setMouthWidth(int mw) {
        mMouthWidth = mw;
        repaint();
    }
     
    public void smile() {
        mSmile = true;
        repaint();
    }
     
    public void frown() {
        mSmile = false;
        repaint();
    }
}