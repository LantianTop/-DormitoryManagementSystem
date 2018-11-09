package whb.controller;

import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import whb.service.StudentDaoService;
import whb.service.impl.StudentDaoSerciceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class PieChart3DAction extends ActionSupport implements SessionAware{
	private JFreeChart chart;
	private Map session;

	public void setSession(Map session) {
		this.session = session;
	}

	public JFreeChart getChart() {
		if (session.get("admin") != null) {
			chart = ChartFactory.createPieChart3D("各省份男女比例", getDataset(),
					true, false, false);
			chart.setTitle(new TextTitle("各省份男女人数比例分布", new Font("黑体",
					Font.ITALIC, 22)));
			LegendTitle legend = chart.getLegend();
			legend.setItemFont(new Font("宋体", Font.ITALIC, 14));
			PiePlot3D plot = (PiePlot3D) chart.getPlot();
			plot.setLabelFont(new Font("隶书", Font.ITALIC, 18));
			plot.setBackgroundAlpha(0.9f);
			plot.setForegroundAlpha(0.50f);
			String unitStyle = "{0}={1}({2})";
			plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
					unitStyle, NumberFormat.getNumberInstance(),
					new DecimalFormat("0.00%")));
			plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator(
					unitStyle, NumberFormat.getNumberInstance(),
					new DecimalFormat("0.00%")));
			return chart;
		}
		return null;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	private DefaultPieDataset getDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		StudentDaoService service = new StudentDaoSerciceImpl();
		Map<String, Integer> map = service.getPersonNumByProvince();
		Set<Entry<String, Integer>> set = map.entrySet();
		for (Entry<String, Integer> entry : set) {
			dataset.setValue(entry.getKey(), entry.getValue());
		}
		return dataset;
	}
}