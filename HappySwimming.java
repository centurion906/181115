import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class HappySwimming extends JFrame {
    Container cp;
    private ArrayList<Fish>fishArrayList = new ArrayList<Fish>();
    private ArrayList<Thread>threads = new ArrayList<>();
    Frame2 frm15;
    public HappySwimming(Frame2 frm16){
        frm15 = frm16;
        ex();
    }private void ex(){
        cp = this.getContentPane();
        cp.setLayout(null);
        this.setBounds(100,100,960,600);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frm15.setVisible(true);
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                if (e.getKeyCode() == 32){
                    fishArrayList.add(new Fish());
                    cp.add(fishArrayList.get(fishArrayList.size()-1));
                    System.out.println(fishArrayList.get(fishArrayList.size()-1));
                    threads.add(new Thread(fishArrayList.get(fishArrayList.size()-1)));
                    threads.get(threads.size()-1).start();
                }
                System.out.println(fishArrayList.size());

            }
        });
    }
}
class Fish extends JLabel implements Runnable{
    private Timer t1;
    private Random rnd = new Random(System.currentTimeMillis());
    private int dirFlag,x ,y = 0;
    private ImageIcon icon = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\untitled1\\src\\125.png");
    public Fish(){
        Image img = icon.getImage();
        Image img2 = img.getScaledInstance(150,150,50);
        icon.setImage(img2);
    }
    @Override
    public void run(){
        dirFlag = rnd.nextInt(4);
        x = rnd.nextInt(960);
        y = rnd.nextInt(600);
        //setBounds
        t1 = new Timer((rnd.nextInt(10) + 1) * 100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("dirFlag = " + dirFlag);
                switch (dirFlag){
                    case 0:
                        if (y-5>0){
                            y-=5;
                        }else {
                            dirFlag = 0;
                        }break;
                    case 1:
                        if (y+5<960){
                            y+=5;
                        }else {
                            dirFlag = 0;
                        }break;
                    case 2:
                        if (x-5>0){
                            x-=5;
                        }else {
                            dirFlag = 0;
                        }break;
                    case 3:
                        if (x+5<600){
                            x+=5;
                        }else {
                            dirFlag = 0;
                        }break;
                }
                Fish.this.setLocation(x,y);
            }
        });
        t1.start();
    }
}
