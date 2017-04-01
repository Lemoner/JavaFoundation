package com.lmr.chart;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChartOne {
	
	JFrame jf;

	JPanel jp;

	public LineChartOne() {
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
		
	}

	private void initChart1() {
		// TODO Auto-generated method stub
		
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();

		defaultcategorydataset.addValue(20, "", "��һ��");
		defaultcategorydataset.addValue(50, "", "�ڶ���");
		defaultcategorydataset.addValue(60, "", "������");
		defaultcategorydataset.addValue(40, "", "���Ĳ�");
		defaultcategorydataset.addValue(40, "", "���岽");
		defaultcategorydataset.addValue(50, "", "������");
		defaultcategorydataset.addValue(10, "", "���߲�");
		
		JFreeChart chart = ChartFactory.createLineChart("�������ʱ����ͼ", null, "��ʱ (ms)", defaultcategorydataset, PlotOrientation.VERTICAL, false, true, false);
        chart.setBackgroundPaint(Color.white);
        

        Font xfont = new Font("΢���ź�",Font.PLAIN,12) ;// X��  
        Font yfont = new Font("΢���ź�",Font.PLAIN,12) ;// Y��  
        Font kfont = new Font("΢���ź�",Font.PLAIN,12) ;// �ײ�  
        Font titleFont = new Font("΢���ź�", Font.PLAIN , 13) ; // ͼƬ����  
		CategoryPlot plot = chart.getCategoryPlot();// ͼ�εĻ��ƽṹ����

		// ͼƬ����
		TextTitle title=new TextTitle(chart.getTitle().getText());
		title.setFont(titleFont);
		title.setPaint(new Color(115, 110, 102));
		chart.setTitle(title);

		// �ײ�
		// chart.getLegend().setItemFont(kfont);

		// X ��
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setLabelFont(xfont);// �����
		domainAxis.setTickLabelFont(xfont);// ����ֵ
		domainAxis.setTickLabelPaint(new Color(115, 110, 102)); // ������ɫ
		// domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		// // �����ϵ�labelб��ʾ

		// Y ��
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setLabelFont(yfont);
		rangeAxis.setLabelPaint(new Color(115, 110, 102)); // ������ɫ
		rangeAxis.setTickLabelFont(yfont);
		rangeAxis.setTickLabelPaint(new Color(115, 110, 102)); // ������ɫ

		CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
		// categoryplot.setBackgroundPaint(Color.lightGray);
		categoryplot.setBackgroundPaint(Color.WHITE);
		categoryplot.setRangeGridlinesVisible(false);
		
		NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		
		LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot.getRenderer();
		lineandshaperenderer.setBaseShapesVisible(true);
		lineandshaperenderer.setDrawOutlines(true);
		lineandshaperenderer.setUseFillPaint(true);
		lineandshaperenderer.setBaseFillPaint(Color.white);
		lineandshaperenderer.setSeriesStroke(0, new BasicStroke(2F));
		lineandshaperenderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
		lineandshaperenderer.setSeriesShape(0, new java.awt.geom.Ellipse2D.Double(-5D, -5D, 10D, 10D));

		ChartPanel chartpanel = new ChartPanel(chart);
		
		jp.setLayout(new GridLayout());
		jp.add(chartpanel);
		
	}

	public static void main(String[] args) {
		LineChartOne l=new LineChartOne();
	}
	
	
	
}
