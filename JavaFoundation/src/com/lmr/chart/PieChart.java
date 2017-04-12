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
		
		DefaultPieDataset defaultpiedataset=new DefaultPieDataset(); //建立一个默认的饼图
		
		defaultpiedataset.setValue("One", new Integer(16));
        defaultpiedataset.setValue("Two", new Integer(12));
        defaultpiedataset.setValue("Three", new Integer(13));
        defaultpiedataset.setValue("Four", new Integer(10));
        defaultpiedataset.setValue("Five", new Integer(15));
        defaultpiedataset.setValue("Six", new Integer(8));
        defaultpiedataset.setValue("Seven", new Integer(9));
        defaultpiedataset.setValue("Eight", new Integer(10));
        
        JFreeChart chart=ChartFactory.createPieChart3D("测试报告数据图",defaultpiedataset,true,false,false); 
        //可以查具体的API文档,第一个参数是标题，第二个参数是一个数据集，第三个参数表示是否显示Legend，第四个参数表示是否显示提示，第五个参数表示图中是否存在URL
        chart.setBackgroundPaint(Color.white);
        
        
//        ChartFrame chartFrame=new ChartFrame("某公司人员组织数据图",chart); 
//        //chart要放在Java容器组件中，ChartFrame继承自java的Jframe类。该第一个参数的数据是放在窗口左上角的，不是正中间的标题。
//        chartFrame.pack(); //以合适的大小展现图形
//        chartFrame.setVisible(true);//图形是否可见
		
        PiePlot mPiePlot = (PiePlot)chart.getPlot();
        
        mPiePlot.setLabelFont(new Font("微软雅黑", Font.PLAIN, 15));//设置饼图标签字体
        mPiePlot.setCircular(true); 
//        mPiePlot.setCircular(false); // 指定显示的饼图上圆形(false)还椭圆形(true) 默认为true 
        mPiePlot.setBackgroundImageAlpha(0.3f); // 指定图片的透明度(0.0-1.0)  
//        mPiePlot.setStartAngle(180f);//饼图的初始角度(饼图的左右旋转角度)
        
        mPiePlot.setForegroundAlpha(1f);//数据区的前景透明度（0.0～1.0）
//        mPiePlot.setOutlinePaint(Color.WHITE);//数据区的边界线条颜色
        mPiePlot.setBackgroundAlpha(1f);
        mPiePlot.setOutlineVisible(false);
//        mPiePlot.setLabelGap(1D);
//        mPiePlot.setInteriorGap(0.050000000000000003D);
        mPiePlot.setSimpleLabels(false);
        mPiePlot.setLabelLinkStyle(PieLabelLinkStyle.CUBIC_CURVE);//设置连线风格
        
        mPiePlot.setSectionPaint("One", colors[0]);//指定分类饼的颜色
//        mPiePlot.setSectionOutlinePaint("One", colors[0]);//指定分类饼的边框颜色
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
        mPiePlot.setLabelBackgroundPaint(Color.WHITE);//分类标签的底色
        mPiePlot.setLabelOutlinePaint(Color.white);//分类标签边框颜色
        mPiePlot.setLabelShadowPaint(Color.white);//分类标签阴影颜色
//        mPiePlot.setLabelLinkMargin(0.6f);
//        mPiePlot.setLabelLinksVisible(false);//分类标签连接线是否显示
        
        mPiePlot.setShadowPaint(Color.white);
//        mPiePlot.setShadowPaint(Color.BLACK);//饼图的阴影颜色,X,Y偏移量(只在平面饼图有用)
//        mPiePlot.setShadowXOffset(30f);
//        mPiePlot.setShadowYOffset(30f);
        
//        mPiePlot.setDepthFactor(0.1f);//3D饼图的Z轴高度（0.0～1.0）
        
        
//        mPiePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{1},{2}", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));  
        // 底部图例显示百分比:自定义方式， {0} 表示选项， {1} 表示数值， {2} 表示所占比例   
//        mPiePlot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{1}个({2})"));  
        
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
