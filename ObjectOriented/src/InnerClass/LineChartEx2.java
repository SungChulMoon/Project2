
package InnerClass;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * 5일 간의 예상날씨를 Json타입에서 String과 Double 타입으로 변경후 그래프를 그리는 클래스
 * 
 * @author Moon light
 * @see JPanel
 */

public class LineChartEx2 extends JPanel {
	static String defaultDate = "";
	static HashMap<String, ArrayList<NowWeatherObject>> map = new HashMap<>();
	static ArrayList<ArrayList<NowWeatherObject>> todaymax = new ArrayList<>();
	static ArrayList<Double> time = new ArrayList<>();
	// ArrayList<String> weatherarr = new ArrayList<>();
	static ArrayList<Integer> x = new ArrayList<>();
	static ArrayList<Integer> maxarrinchart = new ArrayList<>();
	static ArrayList<Integer> minarrinchart = new ArrayList<>();
	static ArrayList<ArrayList<Double>> maxarr = new ArrayList<>();
	static ArrayList<ArrayList<Double>> minarr = new ArrayList<>();
	static XYSeries series1;
	static XYSeries series2;
	public LineChartEx2() {

		initUI();
		map.clear();
		todaymax.clear();
		time.clear();
		x.clear();
		maxarrinchart.clear();
		minarrinchart.clear();
		maxarr.clear();
		minarr.clear();
	
	}

	private void initUI() {

		XYDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 15));
		chartPanel.setBackground(Color.white);
		add(chartPanel);
	

	}

	private XYDataset createDataset() {
		getForcastWeather();
		series1 = new XYSeries("Max");
		series2 = new XYSeries("Min");

		for (int i = 0; i < todaymax.size(); i++) {
			time.add(Double.parseDouble(todaymax.get(i).get(0).getArray0().split("-")[2]));
			// weatherarr.add(todaymax.get(i).get(2).getWeather());
			x.add(i + 1);
		maxarrinchart.add(Integer.parseInt(abto(getMax(maxarr.get(i)))));
			minarrinchart.add(Integer.parseInt(abto(getMin(minarr.get(i)))));
			System.out.println("max" + abto(getMax(maxarr.get(i))));
			System.out.println("min" + abto(getMin(minarr.get(i))));
			series1.add(time.get(i), maxarrinchart.get(i));
			series2.add(time.get(i), minarrinchart.get(i));
		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
	
		return dataset;
		
	}

	private JFreeChart createChart(final XYDataset dataset) {

		JFreeChart chart = ChartFactory.createXYLineChart("Forecast(Max,Min) Chart", "Days", "Temp(Max,Min)", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		renderer.setSeriesPaint(1, Color.BLUE);
		renderer.setSeriesStroke(1, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(false);
		plot.setDomainGridlinesVisible(false);

		chart.getLegend().setFrame(BlockBorder.NONE);

		return chart;
	}

	public static void getForcastWeather() {
		String forestr;
		Location sl = new Location();
		try {
			forestr = sl.getResult2();

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(forestr);
			JSONObject order = (JSONObject) obj;
			JSONArray listarr = (JSONArray) order.get("list");

			// JSONArray listarr = new JSONArray(list);

			for (ArrayList<NowWeatherObject> temp : todaymax) {
				temp.clear();
			}

			for (int i = 0; i < listarr.size(); i++) {
				JSONObject getjson = (JSONObject) listarr.get(i);
				JSONObject main = (JSONObject) getjson.get("main");
				String dt_txt = (String) getjson.get("dt_txt");
				System.out.println(dt_txt);
				String[] array = dt_txt.split(" ");
				String temp = String.valueOf(main.get("temp"));
				Object weat = getjson.get("weather");
				JSONArray weatarr = (JSONArray) weat;
				JSONObject getweat = (JSONObject) weatarr.get(0);
				String inmain = (String) getweat.get("main");
				System.out.println(inmain);
				String max = String.valueOf(main.get("temp_max"));
				String min = String.valueOf(main.get("temp_min"));

				NowWeatherObject vo = new NowWeatherObject(inmain, temp, array[0], Double.valueOf(max), Double.valueOf(min));

				if (!defaultDate.equals(array[0])) {
					ArrayList<NowWeatherObject> tempList = new ArrayList<>();
					map.put(array[0], tempList);
					todaymax.add(tempList);
					defaultDate = array[0];
				}

				map.get(array[0]).add(vo); // templist에 추가해주는 것이다.
			}

			// 시작

			for (int i = 0; i < todaymax.size(); i++) {
				maxarr.add(new ArrayList<Double>());
				minarr.add(new ArrayList<Double>());
				for (int j = 0; j < todaymax.get(i).size(); j++) {
					maxarr.get(i).add(todaymax.get(i).get(j).getMax());
					minarr.get(i).add(todaymax.get(i).get(j).getMin());
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getMax(ArrayList<Double> list) {
		double max = 0.0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > max) {
				max = list.get(i);
			}
		}
		return String.valueOf(max);
	}

	public String getMin(ArrayList<Double> list) {
		double min = 1000.0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < min) {
				min = list.get(i);
			}
		}
		return String.valueOf(min);
	}

	public String abto(String num) {
		double toint = Double.parseDouble(num);
		int change = (int) (toint - 273.15);
		return String.valueOf(change);

	}
}