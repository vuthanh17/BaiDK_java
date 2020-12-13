/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2.dk;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.io.*;
import java.io.IOException;
import static java.lang.System.console;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Ophis
 */
public class Bai2DK extends JFrame{
    private int WIDTH_FRAME;
    private int HEIGHT_FRAME;
    private JButton btnThem;
    private static JButton btnLuu;
    private JLabel lbSBD;
    private JLabel lbName;
    private JLabel lbDiem1;
    private JLabel lbDiem2;
    private JLabel lbDiem3;
    private JTextField tfSBD;
    private JTextField tfName;
    private JTextField tfDiem1;
    private JTextField tfDiem2;
    private JTextField tfDiem3;
    private static ArrayList<ThiSinh> listTS = new ArrayList<>();
    
    /**
     * @param args the command line arguments
     */
    
    public static void ghiFile(String fileName, ArrayList<ThiSinh> ts) throws IOException{
        File f = new File(fileName);
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ts);
        oos.close();
        fos.close();
    }
    
    public Bai2DK(){
        this.WIDTH_FRAME = 480;
        this.HEIGHT_FRAME = 320;
    }
    public Bai2DK (int w, int h) throws HeadlessException{
        WIDTH_FRAME = w;
        HEIGHT_FRAME = h;
    }
    public void start(String title ){
        this.setSize(this.WIDTH_FRAME, this.HEIGHT_FRAME);//dat kich thuong
        this.setLocationRelativeTo(null);//cua so ra giua man hinh
        this.setTitle(title);//dat tieu de cho cua so
//        this.getContentPane().setBackground(Color.);
        this.setLayout(null);//them cac doi tuong vao ung dung
        addComps();
        addEvents();
        this.setVisible(true);//them cac su kien
    }
    
    private void addComps(){
        lbSBD = new JLabel("SBD: ");
        lbSBD.setBounds(20, 20, 50, 30);
        this.add(lbSBD);
        
        lbName = new JLabel("Họ tên thí sinh: ");
        lbName.setBounds(120, 20, 100, 30);
        this.add(lbName);
        
        lbDiem1 = new JLabel("Điểm 1:");
        lbDiem1.setBounds(20, 60, 50, 30);
        this.add(lbDiem1);
        
        lbDiem2 = new JLabel("Điểm 2:");
        lbDiem2.setBounds(160, 60, 50, 30);
        this.add(lbDiem2);
        
        lbDiem3 = new JLabel("Điểm 3:");
        lbDiem3.setBounds(300, 60, 50, 30);
        this.add(lbDiem3);
        
        tfSBD = new JTextField();
        tfSBD.setBounds(50, 20, 45, 25);
        this.add(tfSBD);
        
        tfName = new JTextField();
        tfName.setBounds(210, 20, 200, 25);
        this.add(tfName);
        
        tfDiem1 = new JTextField();
        tfDiem1.setBounds(65, 60, 40, 25);
        this.add(tfDiem1);
        
        tfDiem2 = new JTextField();
        tfDiem2.setBounds(205, 60, 40, 25);
        this.add(tfDiem2);
        
        tfDiem3 = new JTextField();
        tfDiem3.setBounds(345, 60, 40, 25);
        this.add(tfDiem3);
        
        btnLuu = new JButton("Lưu");
        btnLuu.setBounds(250, 110, 100, 50);
        btnLuu.setForeground(Color.RED);
        this.add(btnLuu);
        
        btnThem = new JButton("Thêm");
        btnThem.setBounds(100, 110, 100, 50);
        btnThem.setForeground(Color.RED);
        this.add(btnThem);
    }
    private void addEvents() {
        
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ThiSinh ts = new ThiSinh(Integer.parseInt(tfSBD.getText()), tfName.getText(), Float.parseFloat(tfDiem1.getText()), Float.parseFloat(tfDiem2.getText()), Float.parseFloat(tfDiem3.getText()));
                    System.out.println(ts.toString()) ;
                    listTS.add(ts);
                }
                catch (NumberFormatException er){
                    JOptionPane.showMessageDialog(getContentPane(), "Điểm phải là số");
                }
            }
        });
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ghiFile("thisinh.dat", listTS);
                    JOptionPane.showMessageDialog(getContentPane(), "Lưu thành công");
                } catch (IOException ex) {
                    Logger.getLogger(Bai2DK.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(getContentPane(), "Không lưu được");
                }
            }
        });
    }
    public static void main(String[] args){
        Bai2DK app = new Bai2DK(460,250);
        app.start("Thi sinh");
    }
}
