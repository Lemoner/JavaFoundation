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
    //--- flag 控制线程状态 ---
    private boolean flag = true;
    public boolean isFlag() {
        return flag;
    }
 
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
     
    //--- 通过累计计数模拟线程运行---
    int times = 0;
 
    //--- 设置文本框主要是显示线程状态 ---
    public ThreadClass(String s) {
        super(s);
        setBackground(Color.ORANGE);//---橘黄
        setEditable(false);
        setHorizontalAlignment(JTextField.CENTER);
    }
 
     
    @Override
    public void run() {
        process();
    }
 
    private synchronized void process() {
        while (true) {//无限循环
 
            if (flag == true) {
                this.setText("This is the " + (times++)
                        + "th times running \n");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
//                notify();//--- 唤醒另一线程 --- ，本代码其实没有其他等待线程，这个可不用 ---
            } else {
                this.setText(" When times = " + times + "\n The thread is paused!");
                try {
                    wait();//--- 进入等待
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }
 
}
 
public class test1 extends JFrame {
    ThreadClass a = new ThreadClass("请按开始按钮！");
    Thread startThread = null;
    public test1(String s) {
        super(s);
        final Container c = getContentPane();
        c.setLayout(new BorderLayout());
 
        JPanel jp = new JPanel(new FlowLayout());
        JButton button_start = new JButton("开始");
        JButton button_pause = new JButton("暂停");
        JButton button_resume = new JButton("恢复");
 
        jp.add(button_start);
        jp.add(button_pause);
        jp.add(button_resume);
 
        //--- 开始按钮只执行一次 ---
        button_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (null == startThread) {
                    startThread =  new Thread(a);
                    startThread.start();
                }
            }
        });
         
        //--- 暂停按钮 ，按下后如果没有按继续，就不改变标志 ---
        button_pause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (a.isFlag() != false) {
                    a.setFlag(false);
                }
            }
        });
 
        //--- 恢复按钮，这个最关键，主要是用notify()让线程继续执行，---
        button_resume.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                if (a.isFlag() == false) {
                     
                    a.setFlag(true);
                    synchronized (a) {//--- 如果不放在同步快里，无法实现唤醒 ---
                        a.notify();//--- 这个代码执行完后，a对象锁就释放了 所以process() 方法里德 notify()可不用---
                    }
                }
            }
        });
        c.add(jp,BorderLayout.NORTH);
        c.add(a, BorderLayout.CENTER);
    }
     
    //--- 入口 ---
    public static void main(String[] args) {
        test1 tc = new test1("test");
        tc.setSize(400, 200);
        tc.setVisible(true);
        tc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}