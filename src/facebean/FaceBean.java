/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebean;

import javax.swing.JFrame;
import Clases.Face;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;


/**
 *
 * @author luisa
 */
public class FaceBean extends JFrame implements ActionListener,ChangeListener {
    
    //Variables
    JPanel panel_cara;
    JSlider slide_sonrisa;
    JLabel lbl_slider;
    JCheckBox chk_sonrisa;
    
    //Componente Face :v
    Face f = new Face();
    
    
    public FaceBean()
    {
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Componente Face Bean Modificado");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        //this.add(f);
        initComponents();
        
        //
        
    }
    
    public void initComponents()
    {
        panel_cara = new JPanel();
        //panel_cara.setBackground(Color.red);
        panel_cara.setBounds(20, 20, 400, 400);
        //para que un setBouds funciones necesitas un layout null
        panel_cara.setLayout(null);
        this.add(panel_cara);
        
        //----------------------------------------------------------------------
        //PINCHE LINEA CULERA ALV :v, ME LLEVA LA VRGA
        //PUTO SI ME VUELVO A EQUIVOCAR
        f.setBounds(0,0, panel_cara.getHeight(),panel_cara.getWidth());
        panel_cara.add(f);
        
        
        chk_sonrisa = new JCheckBox();
        //chk_sonrisa.setBackground(Color.red);
        chk_sonrisa.setBounds(440, 220, 100, 30);
        chk_sonrisa.setText("Sonriente");
        chk_sonrisa.setSelected(true);
        chk_sonrisa.addActionListener(this);
        this.add(chk_sonrisa);
        
        lbl_slider = new JLabel();
        lbl_slider.setText("<- --------------- Fijar el ancho de la boca +++++++++++++++ ->");
        lbl_slider.setBackground(Color.red);
        lbl_slider.setBounds(120, 450, 350, 30);
        this.add(lbl_slider);
        
        slide_sonrisa = new JSlider();
        slide_sonrisa.setBounds(120, 500, 350, 50);
        slide_sonrisa.setMajorTickSpacing(5);
        slide_sonrisa.setMaximum(100);
        slide_sonrisa.setMinimum(20);
        slide_sonrisa.setPaintLabels(true);
        slide_sonrisa.setPaintTicks(true);
        slide_sonrisa.setPaintTrack(true);
        slide_sonrisa.addChangeListener(this);
        this.add(slide_sonrisa);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //----------------------------------------------------------------------
        if(e.getSource() == chk_sonrisa)
        {
            if(chk_sonrisa.isSelected())
            {
                f.smile();
            }else
            {
                f.frown();
            }
            
        }
        
    }

    @Override
    public void stateChanged(ChangeEvent e) 
    {
        if(e.getSource() == slide_sonrisa)
        {
            //System.out.println(slide_sonrisa.getValue());
            
            f.setMouthWidth(slide_sonrisa.getValue());
            
        }
        
    }
    
}
