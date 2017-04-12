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
		defaultcategorydataset.addValue(20, "", "��һ��");
		defaultcategorydataset.addValue(50, "", "�ڶ���");
		defaultcategorydataset.addValue(60, "", "������");
		defaultcategorydataset.addValue(40, "", "���Ĳ�");
		defaultcategorydataset.addValue(40, "", "���岽");
		defaultcategorydataset.addValue(50, "", "������");
		defaultcategorydataset.addValue(10, "", "���߲�");
        
        JFreeChart chart = ChartFactory.createBarChart("Bar Chart Demo 9", "fda", "Value", defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(new Color(255, 255, 255));
        chart.setBorderVisible(false);//�߽������Ƿ�ɼ�
        chart.setAntiAlias(false);//�������忹���
        
		// ���ñ�ע�ޱ߿�
		chart.getLegend().setFrame(new BlockBorder(Color.WHITE));
		// ��עλ���Ҳ�
		chart.getLegend().setPosition(RectangleEdge.RIGHT);
        
        Font xfont = new Font("΢���ź�",Font.PLAIN,12) ;// X��  
        Font yfont = new Font("΢���ź�",Font.PLAIN,12) ;// Y��  
        Font kfont = new Font("΢���ź�",Font.PLAIN,12) ;// �ײ�  
        Font titleFont = new Font("΢���ź�", Font.PLAIN , 13) ; // ͼƬ����  
        
        CategoryPlot categoryplot = (CategoryPlot)chart.getPlot();
        categoryplot.setBackgroundPaint(Color.WHITE);
        categoryplot.setOutlineVisible(false);
		categoryplot.setRangeGridlinesVisible(true);//�����������Ƿ�ɼ�
		categoryplot.setRangeGridlineStroke(new BasicStroke(1));
		categoryplot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);

		// ͼƬ����
		TextTitle title=new TextTitle(chart.getTitle().getText());
		title.setFont(titleFont);
//		title.setPaint(new Color(115, 110, 102));
		title.setPaint(new Color(0, 0, 0));
		chart.setTitle(title);

		// �ײ�
		// chart.getLegend().setItemFont(kfont);
		
		// X ��,������
		CategoryAxis domainAxis = categoryplot.getDomainAxis();
		domainAxis.setLabelFont(xfont);// �����
		domainAxis.setLabelPaint(new Color(0, 0, 0));
		domainAxis.setTickLabelFont(xfont);// ����ֵ
		domainAxis.setTickLabelPaint(new Color(0, 0, 0)); // ������ɫ
		// domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		// // �����ϵ�labelб��ʾ
//		domainAxis.setTickMarkPaint(Color.RED);
//		domainAxis.setTickMarksVisible(true);
		
//		NumberAxis numAxis = (NumberAxis) plot.getRangeAxis();//x������
//		numAxis.setTickUnit(new NumberTickUnit(100));//ÿ100���̶���ʾһ���̶�ֵ
		
		// Y ��,������
		ValueAxis rangeAxis = categoryplot.getRangeAxis();
		rangeAxis.setLabelFont(yfont);
		rangeAxis.setLabelPaint(new Color(0, 0, 0)); // ������ɫ
		rangeAxis.setTickLabelFont(yfont);
		rangeAxis.setTickLabelPaint(new Color(0, 0, 0)); // ������ɫ
//		rangeAxis.setPositiveArrowVisible(true);
//		rangeAxis.setAutoRange(true);//�Զ��������������ݷ�Χ
//		rangeAxis.setAutoRangeMinimumSize(500);//�Զ��������������ݷ�Χʱ���ݷ�Χ����С���
//		rangeAxis.setAutoTickUnitSelection(false);//����������ݱ�ǩ�Ƿ��Զ�ȷ��
        
		BarRenderer barrenderer = (BarRenderer)categoryplot.getRenderer();
        barrenderer.setBaseItemLabelsVisible(true);
        barrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        barrenderer.setBaseItemLabelFont(new Font("΢���ź�", Font.BOLD, 13));
        barrenderer.setBaseItemLabelPaint(Color.RED);
        
        barrenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("{0}, {1}) = {2} per 100,000", new DecimalFormat("0")));
        barrenderer.setDrawBarOutline(false);
//        barrenderer.setBaseOutlinePaint(Color.BLACK);
//        barrenderer.setBaseOutlineStroke(new BasicStroke(0.5F));
		
        Paint apaint[] = {new Color(76,129,189)};
        CustomBarRenderer custombarrenderer = new CustomBarRenderer(apaint);
        custombarrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        custombarrenderer.setBaseItemLabelFont(new Font("΢���ź�", Font.PLAIN, 13));
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
		defaultcategorydataset.addValue(20, "", "��һ��");
		defaultcategorydataset.addValue(50, "", "�ڶ���");
		defaultcategorydataset.addValue(60, "", "������");
		defaultcategorydataset.addValue(40, "", "���Ĳ�");
		defaultcategorydataset.addValue(40, "", "���岽");
		defaultcategorydataset.addValue(50, "", "������");
		defaultcategorydataset.addValue(10, "", "���߲�");
        
        JFreeChart chart = ChartFactory.createBarChart("Bar Chart Demo 9", null, "Value", defaultcategorydataset, PlotOrientation.VERTICAL, false, true, false);
        chart.setBackgroundPaint(new Color(255, 255, 255));
        
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
		domainAxis.setLabelPaint(new Color(115, 110, 102));
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
