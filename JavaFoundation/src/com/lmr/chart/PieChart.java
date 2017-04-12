package com.lmr.chart;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart {
	
	JFrame jf;

	JPanel jp;
	
	Color colors[]={ 
			new Color(68,113,165),
			new Color(168,69,66),
			new Color(135,163,77),
			new Color(112,87,141),
			new Color(64,150,173),
			new Color(217,130,60),
			new Color(145,167,205),
			new Color(207,145,144)
	};;

	public PieChart() {
		// TODO Auto-generated constructor stub
		
		jf = new JFrame();
		jp = new JPanel();
		
		jp.setBackground(new Color(255, 255, 255));
		
//		initChart1();
		
		initChart2();
		
		jf.add(jp);

		jf.setVisible(true);

		jf.setSize(500, 500);
		
	}

	private void initChart2() {
		// TODO Auto-generated method stub
		
		DefaultPieDataset defaultpiedataset=new DefaultPieDataset(); //����һ��Ĭ�ϵı�ͼ
		
		defaultpiedataset.setValue("One", new Integer(16));
        defaultpiedataset.setValue("Two", new Integer(12));
        defaultpiedataset.setValue("Three", new Integer(13));
        defaultpiedataset.setValue("Four", new Integer(10));
        defaultpiedataset.setValue("Five", new Integer(15));
        defaultpiedataset.setValue("Six", new Integer(8));
        defaultpiedataset.setValue("Seven", new Integer(9));
        defaultpiedataset.setValue("Eight", new Integer(10));
        
        JFreeChart chart=ChartFactory.createPieChart3D("���Ա�������ͼ",defaultpiedataset,true,false,false); 
        //���Բ�����API�ĵ�,��һ�������Ǳ��⣬�ڶ���������һ�����ݼ���������������ʾ�Ƿ���ʾLegend�����ĸ�������ʾ�Ƿ���ʾ��ʾ�������������ʾͼ���Ƿ����URL
        chart.setBackgroundPaint(Color.white);
        
        
//        ChartFrame chartFrame=new ChartFrame("ĳ��˾��Ա��֯����ͼ",chart); 
//        //chartҪ����Java��������У�ChartFrame�̳���java��Jframe�ࡣ�õ�һ�������������Ƿ��ڴ������Ͻǵģ��������м�ı��⡣
//        chartFrame.pack(); //�Ժ��ʵĴ�Сչ��ͼ��
//        chartFrame.setVisible(true);//ͼ���Ƿ�ɼ�
		
        PiePlot mPiePlot = (PiePlot)chart.getPlot();
        
        mPiePlot.setLabelFont(new Font("΢���ź�", Font.PLAIN, 15));//���ñ�ͼ��ǩ����
        mPiePlot.setCircular(true); 
//        mPiePlot.setCircular(false); // ָ����ʾ�ı�ͼ��Բ��(false)����Բ��(true) Ĭ��Ϊtrue 
        mPiePlot.setBackgroundImageAlpha(0.3f); // ָ��ͼƬ��͸����(0.0-1.0)  
//        mPiePlot.setStartAngle(180f);//��ͼ�ĳ�ʼ�Ƕ�(��ͼ��������ת�Ƕ�)
        
        mPiePlot.setForegroundAlpha(1f);//��������ǰ��͸���ȣ�0.0��1.0��
//        mPiePlot.setOutlinePaint(Color.WHITE);//�������ı߽�������ɫ
        mPiePlot.setBackgroundAlpha(1f);
        mPiePlot.setOutlineVisible(false);
//        mPiePlot.setLabelGap(1D);
//        mPiePlot.setInteriorGap(0.050000000000000003D);
        mPiePlot.setSimpleLabels(false);
        mPiePlot.setLabelLinkStyle(PieLabelLinkStyle.CUBIC_CURVE);//�������߷��
        
        mPiePlot.setSectionPaint("One", colors[0]);//ָ�����������ɫ
//        mPiePlot.setSectionOutlinePaint("One", colors[0]);//ָ��������ı߿���ɫ
        mPiePlot.setSectionPaint("Two", colors[1]);
//        mPiePlot.setSectionOutlinePaint("Two", colors[1]);
        mPiePlot.setSectionPaint("Three", colors[2]);
//        mPiePlot.setSectionOutlinePaint("Three", colors[2]);
        mPiePlot.setSectionPaint("Four", colors[3]);
//        mPiePlot.setSectionOutlinePaint("Four", colors[3]);
        mPiePlot.setSectionPaint("Five", colors[4]);
//        mPiePlot.setSectionOutlinePaint("Five", colors[4]);
        mPiePlot.setSectionPaint("Six", colors[5]);
//        mPiePlot.setSectionOutlinePaint("Six", colors[5]);
        mPiePlot.setSectionPaint("Seven", colors[6]);
//        mPiePlot.setSectionOutlinePaint("Seven", colors[6]);
        mPiePlot.setSectionPaint("Eight", colors[7]);
//        mPiePlot.setSectionOutlinePaint("Eight", colors[7]);
        
        StandardPieSectionLabelGenerator standardPieSectionLabelGenerator=new StandardPieSectionLabelGenerator("{1},{2}", NumberFormat.getNumberInstance(), new DecimalFormat("0%"));
        mPiePlot.setLabelGenerator(standardPieSectionLabelGenerator);
        mPiePlot.setLabelBackgroundPaint(Color.WHITE);//�����ǩ�ĵ�ɫ
        mPiePlot.setLabelOutlinePaint(Color.white);//�����ǩ�߿���ɫ
        mPiePlot.setLabelShadowPaint(Color.white);//�����ǩ��Ӱ��ɫ
//        mPiePlot.setLabelLinkMargin(0.6f);
//        mPiePlot.setLabelLinksVisible(false);//�����ǩ�������Ƿ���ʾ
        
        mPiePlot.setShadowPaint(Color.white);
//        mPiePlot.setShadowPaint(Color.BLACK);//��ͼ����Ӱ��ɫ,X,Yƫ����(ֻ��ƽ���ͼ����)
//        mPiePlot.setShadowXOffset(30f);
//        mPiePlot.setShadowYOffset(30f);
        
//        mPiePlot.setDepthFactor(0.1f);//3D��ͼ��Z��߶ȣ�0.0��1.0��
        
        
//        mPiePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{1},{2}", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));  
        // �ײ�ͼ����ʾ�ٷֱ�:�Զ��巽ʽ�� {0} ��ʾѡ� {1} ��ʾ��ֵ�� {2} ��ʾ��ռ����   
//        mPiePlot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{1}��({2})"));  
        
        ChartPanel chartpanel = new ChartPanel(chart);
		
		jp.setLayout(new GridLayout());
		jp.add(chartpanel);
		
	}

	private void initChart1() {
		// TODO Auto-generated method stub
		
		DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
        defaultpiedataset.setValue("One", new Integer(20));
        defaultpiedataset.setValue("Two", new Integer(10));
        defaultpiedataset.setValue("Three", new Integer(23));
        defaultpiedataset.setValue("Four", new Integer(15));
        defaultpiedataset.setValue("Five", new Integer(9));
        defaultpiedataset.setValue("Six", new Integer(17));
        defaultpiedataset.setValue("Seven", new Integer(21));
        defaultpiedataset.setValue("Eight", new Integer(16));
        
        JFreeChart chart = ChartFactory.createPieChart("Pie Chart Demo 1", defaultpiedataset, true, true, false);
        TextTitle texttitle = chart.getTitle();
        texttitle.setToolTipText("A title tooltip!");
        PiePlot pieplot = (PiePlot)chart.getPlot();
        pieplot.setLabelFont(new Font("SansSerif", 0, 12));
        pieplot.setNoDataMessage("No data available");
        pieplot.setCircular(false);
        pieplot.setLabelGap(0.02D);
        
        ChartPanel chartpanel = new ChartPanel(chart);
		
		jp.setLayout(new GridLayout());
		jp.add(chartpanel);
		
	}

	public static void main(String[] args) {
		PieChart pc=new PieChart();
	}
	
}
