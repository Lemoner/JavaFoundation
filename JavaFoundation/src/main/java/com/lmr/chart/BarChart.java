package com.lmr.chart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.awt.Paint;
import java.text.Collator;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.ui.TextAnchor;

public class BarChart {

	JFrame jf;

	JPanel jp;

	public BarChart() {
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
		
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
		defaultcategorydataset.addValue(20, "", "第一步");
		defaultcategorydataset.addValue(50, "", "第二步");
		defaultcategorydataset.addValue(60, "", "第三步");
		defaultcategorydataset.addValue(40, "", "第四步");
		defaultcategorydataset.addValue(40, "", "第五步");
		defaultcategorydataset.addValue(50, "", "第六步");
		defaultcategorydataset.addValue(10, "", "第七步");
        
        JFreeChart chart = ChartFactory.createBarChart("Bar Chart Demo 9", "fda", "Value", defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(new Color(255, 255, 255));
        chart.setBorderVisible(false);//边界线条是否可见
        chart.setAntiAlias(false);//设置字体抗锯齿
        
		// 设置标注无边框
		chart.getLegend().setFrame(new BlockBorder(Color.WHITE));
		// 标注位于右侧
		chart.getLegend().setPosition(RectangleEdge.RIGHT);
        
        Font xfont = new Font("微软雅黑",Font.PLAIN,12) ;// X轴  
        Font yfont = new Font("微软雅黑",Font.PLAIN,12) ;// Y轴  
        Font kfont = new Font("微软雅黑",Font.PLAIN,12) ;// 底部  
        Font titleFont = new Font("微软雅黑", Font.PLAIN , 13) ; // 图片标题  
        
        CategoryPlot categoryplot = (CategoryPlot)chart.getPlot();
        categoryplot.setBackgroundPaint(Color.WHITE);
        categoryplot.setOutlineVisible(false);
		categoryplot.setRangeGridlinesVisible(true);//数据轴网格是否可见
		categoryplot.setRangeGridlineStroke(new BasicStroke(1));
		categoryplot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);

		// 图片标题
		TextTitle title=new TextTitle(chart.getTitle().getText());
		title.setFont(titleFont);
//		title.setPaint(new Color(115, 110, 102));
		title.setPaint(new Color(0, 0, 0));
		chart.setTitle(title);

		// 底部
		// chart.getLegend().setItemFont(kfont);
		
		// X 轴,分类轴
		CategoryAxis domainAxis = categoryplot.getDomainAxis();
		domainAxis.setLabelFont(xfont);// 轴标题
		domainAxis.setLabelPaint(new Color(0, 0, 0));
		domainAxis.setTickLabelFont(xfont);// 轴数值
		domainAxis.setTickLabelPaint(new Color(0, 0, 0)); // 字体颜色
		// domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		// // 横轴上的label斜显示
//		domainAxis.setTickMarkPaint(Color.RED);
//		domainAxis.setTickMarksVisible(true);
		
//		NumberAxis numAxis = (NumberAxis) plot.getRangeAxis();//x轴设置
//		numAxis.setTickUnit(new NumberTickUnit(100));//每100个刻度显示一个刻度值
		
		// Y 轴,数据轴
		ValueAxis rangeAxis = categoryplot.getRangeAxis();
		rangeAxis.setLabelFont(yfont);
		rangeAxis.setLabelPaint(new Color(0, 0, 0)); // 字体颜色
		rangeAxis.setTickLabelFont(yfont);
		rangeAxis.setTickLabelPaint(new Color(0, 0, 0)); // 字体颜色
//		rangeAxis.setPositiveArrowVisible(true);
//		rangeAxis.setAutoRange(true);//自动设置数据轴数据范围
//		rangeAxis.setAutoRangeMinimumSize(500);//自动设置数据轴数据范围时数据范围的最小跨度
//		rangeAxis.setAutoTickUnitSelection(false);//数据轴的数据标签是否自动确定
        
		BarRenderer barrenderer = (BarRenderer)categoryplot.getRenderer();
        barrenderer.setBaseItemLabelsVisible(true);
        barrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        barrenderer.setBaseItemLabelFont(new Font("微软雅黑", Font.BOLD, 13));
        barrenderer.setBaseItemLabelPaint(Color.RED);
        
        barrenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("{0}, {1}) = {2} per 100,000", new DecimalFormat("0")));
        barrenderer.setDrawBarOutline(false);
//        barrenderer.setBaseOutlinePaint(Color.BLACK);
//        barrenderer.setBaseOutlineStroke(new BasicStroke(0.5F));
		
        Paint apaint[] = {new Color(76,129,189)};
        CustomBarRenderer custombarrenderer = new CustomBarRenderer(apaint);
        custombarrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        custombarrenderer.setBaseItemLabelFont(new Font("微软雅黑", Font.PLAIN, 13));
        custombarrenderer.setBaseItemLabelPaint(Color.BLACK);
//        custombarrenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("{0}, {1}) = {2} per 100,000", new DecimalFormat("0")));
        custombarrenderer.setBaseItemLabelsVisible(true);
        categoryplot.setRenderer(custombarrenderer);
        
//        Paint apaint[] = {
////              new Color(196, 215, 216), new Color(78, 137, 139), new Color(138, 177, 178), new Color(19, 97, 100)
//          	Color.blue,Color.gray,Color.yellow
//          };
//        CustomBarRenderer customrenderer = new CustomBarRenderer(apaint);
//          customrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
//          customrenderer.setBaseItemLabelsVisible(true);
////          ItemLabelPosition itemlabelposition = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, 0.0D);
////          customrenderer.setBasePositiveItemLabelPosition(itemlabelposition);
//          categoryplot.setRenderer(customrenderer);
        
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
        
		apaint[0] = new Color(124, 181, 236);
		apaint[1] = new Color(144, 237, 125);
		apaint[2] = new Color(186, 186, 186);
		apaint[3] = new Color(128, 133, 233);
		apaint[4] = new Color(67, 67, 72);
        
        return apaint;
    }

	private void initChart1() {
		// TODO Auto-generated method stub
		
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
		defaultcategorydataset.addValue(20, "", "第一步");
		defaultcategorydataset.addValue(50, "", "第二步");
		defaultcategorydataset.addValue(60, "", "第三步");
		defaultcategorydataset.addValue(40, "", "第四步");
		defaultcategorydataset.addValue(40, "", "第五步");
		defaultcategorydataset.addValue(50, "", "第六步");
		defaultcategorydataset.addValue(10, "", "第七步");
        
        JFreeChart chart = ChartFactory.createBarChart("Bar Chart Demo 9", null, "Value", defaultcategorydataset, PlotOrientation.VERTICAL, false, true, false);
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
        
		ChartPanel chartpanel = new ChartPanel(chart);
		
		jp.setLayout(new GridLayout());
		jp.add(chartpanel);
        
	}
	
	public static void main(String[] args) {
		BarChart bc=new BarChart();
	}
	
}
