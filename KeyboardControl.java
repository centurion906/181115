import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyboardControl extends JFrame {
    Container cp;
    private JLabel jib = new JLabel();
    private Timer t1 ;
    private ImageIcon icon = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\untitled2\\src\\125.png");
    private ImageIcon icon2 = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\untitled2\\src\\127.png");
    private int dirFlag = 0,objx,objy,targetX,targetY;
    private boolean a = false;
    Frame2 frm13;
    public KeyboardControl(Frame2 frm14){
        frm13 = frm14;
        ex();
    }private void ex(){
        this.setBounds(100,100,1000,800);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frm13.setVisible(true);
            }
        });
        cp = getContentPane();
        cp.setLayout(null);

        jib.setBounds(100,600,150,150);

        jib.setIcon(icon);
        Image img = icon.getImage();
        Image img2 = img.getScaledInstance(150,150,50);
        icon.setImage(img2);

        jib.setIcon(icon2);
        Image img5 = icon2.getImage();
        Image img6 = img5.getScaledInstance(150,150,50);
        icon2.setImage(img6);

        cp.add(jib);

        t1 = new Timer(20, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (dirFlag){
                    case 1:
                        if (objy-2>0){
                            objy-=2;
                            break;}
                    case 2:
                        if (objy+2<310){
                            objy+=2;
                            break;}
                    case 3 :
                        if (objx-2>0){
                            objx-=2;
                            break;}
                    case 4:
                        if (objx+2<626){
                            objx+=2;
                            break; }
                }
                jib.setLocation(objx,objy);
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case 37:
                        jib.setIcon(icon);
                        dirFlag = 3;
                        break;
                    case 39:
                        jib.setIcon(icon2);
                        dirFlag = 4;
                        break;
                    case 40:
                        dirFlag = 2;
                        break;
                    case 38:
                        dirFlag = 1;
                        break;
                    case 32:
                        t1.start();
                        break;
                }
            }
        });
//        jib.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                a = true;
//                objx = e.getX();
//                objy = e.getY();
//                System.out.println("objx: "+objx+"obky: "+objy);
//            }
//        });
//        this.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                if (SwingUtilities.isRightMouseButton(e)){
//                    targetX = e.getX();
//                    targetY = e.getY();
//                    System.out.println("objx: "+objx+"obky: "+objy);
//                    if (a){
//                        jib.setLocation(targetX,targetY);
//                    }
//                    a = false;
//                }
//            }
//        });
    }
}
