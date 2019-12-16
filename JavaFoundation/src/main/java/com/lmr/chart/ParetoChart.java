package com.lmr.chart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Paint;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import com.lmr.chart.BarChart.CustomBarRenderer;

public class ParetoChart {
	
	JFrame jf;

	JPanel jp;

	public ParetoChart() {
		// TODO Auto-generated constructor stub
		
		jf = new JFrame();
		jp = new JPanel();
		
		jp.setBackground(new Color(255, 255, 255));
		
		initJPanel();
		
		jf.add(jp);

		jf.setVisible(true);

		jf.setSize(500, 500);
		
	}

	private void initJPanel() {
		// TODO Auto-generated method stub
		
		DefaultKeyedValues defaultkeyedvalues = new DefaultKeyedValues();
		defaultkeyedvalues.addValue("One", new Integer(20));
		defaultkeyedvalues.addValue("Two", new Integer(50));
		defaultkeyedvalues.addValue("Three", new Integer(60));
		defaultkeyedvalues.addValue("Four", new Integer(40));
		defaultkeyedvalues.addValue("Five", new Integer(40));
		defaultkeyedvalues.addValue("Six", new Integer(50));
		defaultkeyedvalues.addValue("Seven", new Integer(10));
//		defaultkeyedvalues.sortByValues(SortOrder.DESCENDING);
		
		CategoryDataset categorydataset1 = DatasetUtilities.createCategoryDataset("First", defaultkeyedvalues);
        CategoryDataset categorydataset2 = DatasetUtilities.createCategoryDataset("Second", defaultkeyedvalues);
		
        JFreeChart chart = ChartFactory.createBarChart("Bar Chart Demo 9", null, "Value", categorydataset1, PlotOrientation.VERTICAL, false, true, false);
        chart.setBackgroundPaint(new Color(255, 255, 255));
        
        Font xfont = new Font("微软雅黑",Font.PLAIN,12) ;// X轴  
        Font yfont = new Font("微软雅黑",Font.PLAIN,12) ;// Y轴  
        Font kfont = new Font("微软雅黑",Font.PLAIN,12) ;// 底部  
        Font titleFont = new Font("微软雅黑", Font.PLAIN , 13) ; // 图片标题  
		CategoryPlot plot = chart.getCategoryPlot();// 图形的绘制结构对象

		// 图片标题
		TextTitle title=new TextTitle(chart.getTitle().getText());
		title.setFont(titleFont);
		title.setPaint(new Color(115, 110, 102));
		chart.setTitle(title);

		// 底部
		// chart.getLegend().setItemFont(kfont);

		// X 轴
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setLabelFont(xfont);// 轴标题
		domainAxis.setLabelPaint(new Color(115, 110, 102));
		domainAxis.setTickLabelFont(xfont);// 轴数值
		domainAxis.setTickLabelPaint(new Color(115, 110, 102)); // 字体颜色
		// domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		// // 横轴上的label斜显示

		// Y 轴
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setLabelFont(yfont);
		rangeAxis.setLabelPaint(new Color(115, 110, 102)); // 字体颜色
		rangeAxis.setTickLabelFont(yfont);
		rangeAxis.setTickLabelPaint(new Color(115, 110, 102)); // 字体颜色
        
        CategoryPlot categoryplot = (CategoryPlot)chart.getPlot();
        categoryplot.setBackgroundPaint(Color.WHITE);
		categoryplot.setRangeGridlinesVisible(false);
        
        Paint apaint[] = createPaint();
        CustomBarRenderer custombarrenderer = new CustomBarRenderer(apaint);
        categoryplot.setRenderer(custombarrenderer);
        
        
        LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
		lineandshaperenderer.setBaseShapesVisible(true);
		lineandshaperenderer.setDrawOutlines(true);
		lineandshaperenderer.setUseFillPaint(true);
		lineandshaperenderer.setPaint(new Color(128, 133, 233));
		lineandshaperenderer.setBaseFillPaint(Color.white);
		lineandshaperenderer.setSeriesStroke(0, new BasicStroke(2F));
		lineandshaperenderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
		lineandshaperenderer.setSeriesShape(0, new java.awt.geom.Ellipse2D.Double(-5D, -5D, 10D, 10D));

        
        NumberAxis numberaxis1 = new NumberAxis("ms");
        numberaxis1.setNumberFormatOverride(NumberFormat.getIntegerInstance());
        
        categoryplot.setRangeAxis(1, numberaxis1);
        categoryplot.setDataset(1, categorydataset2);
        categoryplot.setRenderer(1, lineandshaperenderer);
        categoryplot.mapDatasetToRangeAxis(1, 1);
        categoryplot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        
		ChartPanel chartpanel = new ChartPanel(chart);
		
		jp.setLayout(new GridLayout());
		jp.add(chartpanel);
        
        
	}
	
	static class CustomBarRenderer extends BarRenderer
    {

        private Paint colors[];

        public Paint getItemPaint(int i, int j)
        {
            return colors[j % colors.length];
        }

        public CustomBarRenderer(Paint apaint[])
        {
            colors = apaint;
        }
    }
	
	private static Paint[] createPaint()
    {
        Paint apaint[] = new Paint[5];
        
//		apaint[0] = new Color(124, 181, 236);
//		apaint[1] = new Color(144, 237, 125);
//		apaint[2] = new Color(186, 186, 186);
//		apaint[3] = new Color(128, 133, 233);
//		apaint[4] = new Color(67, 67, 72);
        
        apaint[0]= new Color(124, 181, 236);
        
        return apaint;
    }
	
	public static void main(String[] args) {
		ParetoChart pc=new ParetoChart();
	}
	
}
