package com.lmr.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
class ThreadClass extends JTextField implements Runnable {
    //--- flag �����߳�״̬ ---
    private boolean flag = true;
    public boolean isFlag() {
        return flag;
    }
 
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
     
    //--- ͨ���ۼƼ���ģ���߳�����---
    int times = 0;
 
    //--- �����ı�����Ҫ����ʾ�߳�״̬ ---
    public ThreadClass(String s) {
        super(s);
        setBackground(Color.ORANGE);//---�ٻ�
        setEditable(false);
        setHorizontalAlignment(JTextField.CENTER);
    }
 
     
    @Override
    public void run() {
        process();
    }
 
    private synchronized void process() {
        while (true) {//����ѭ��
 
            if (flag == true) {
                this.setText("This is the " + (times++)
                        + "th times running \n");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
//                notify();//--- ������һ�߳� --- ����������ʵû�������ȴ��̣߳�����ɲ��� ---
            } else {
                this.setText(" When times = " + times + "\n The thread is paused!");
                try {
                    wait();//--- ����ȴ�
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }
 
}
 
public class test1 extends JFrame {
    ThreadClass a = new ThreadClass("�밴��ʼ��ť��");
    Thread startThread = null;
    public test1(String s) {
        super(s);
        final Container c = getContentPane();
        c.setLayout(new BorderLayout());
 
        JPanel jp = new JPanel(new FlowLayout());
        JButton button_start = new JButton("��ʼ");
        JButton button_pause = new JButton("��ͣ");
        JButton button_resume = new JButton("�ָ�");
 
        jp.add(button_start);
        jp.add(button_pause);
        jp.add(button_resume);
 
        //--- ��ʼ��ťִֻ��һ�� ---
        button_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (null == startThread) {
                    startThread =  new Thread(a);
                    startThread.start();
                }
            }
        });
         
        //--- ��ͣ��ť �����º����û�а��������Ͳ��ı��־ ---
        button_pause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (a.isFlag() != false) {
                    a.setFlag(false);
                }
            }
        });
 
        //--- �ָ���ť�������ؼ�����Ҫ����notify()���̼߳���ִ�У�---
        button_resume.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                if (a.isFlag() == false) {
                     
                    a.setFlag(true);
                    synchronized (a) {//--- ���������ͬ������޷�ʵ�ֻ��� ---
                        a.notify();//--- �������ִ�����a���������ͷ��� ����process() ������� notify()�ɲ���---
                    }
                }
            }
        });
        c.add(jp,BorderLayout.NORTH);
        c.add(a, BorderLayout.CENTER);
    }
     
    //--- ��� ---
    public static void main(String[] args) {
        test1 tc = new test1("test");
        tc.setSize(400, 200);
        tc.setVisible(true);
        tc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}