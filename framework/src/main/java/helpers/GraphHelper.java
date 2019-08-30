package helpers;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.HashMap;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class GraphHelper {
	 private static final String KEY1 = "Despacho";
	 private static final String KEY2 = "Farmacia";
	 private static final String KEY3 = "Administrador";
	 private static final String KEY4 = "Medico";
	 private static final String KEY5 = "Socio";
	
	public static JFreeChart generateGraficoBugsPorModulo(HashMap<String, Integer> listaFalla) {
		DefaultPieDataset dataSet = new DefaultPieDataset();
		dataSet.setValue(KEY1, listaFalla.get(KEY1));
		dataSet.setValue(KEY2, listaFalla.get(KEY2));
		dataSet.setValue(KEY3, listaFalla.get(KEY3));
		dataSet.setValue(KEY4, listaFalla.get(KEY4));
		dataSet.setValue(KEY5, listaFalla.get(KEY5));
		
		JFreeChart chart = ChartFactory.createPieChart(
				"Porcentaje de Falla por Modulo", dataSet, true, true, false);
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setSectionPaint(KEY1, Color.green);
		plot.setSectionPaint(KEY2, Color.red);
		plot.setSectionPaint(KEY3, Color.blue);
		plot.setSectionPaint(KEY4, Color.orange);
		plot.setSectionPaint(KEY5, Color.yellow);
		//plot.setExplodePercent(KEY1, 0.10);
		plot.setSimpleLabels(true);

		PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
				"{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
		plot.setLabelGenerator(gen);
		       
		return chart;
	}
	
	
	public static JFreeChart generateGraficoEstadoCasos(HashMap<String, Integer> listaPasa,HashMap<String, Integer> listaFalla) {
			
		String title = "Cantidad de Casos de Prueba Pasa/Falla";

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(listaFalla.get(KEY1), "Falla", KEY1);
		dataset.addValue(listaFalla.get(KEY2), "Falla", KEY2);
		dataset.addValue(listaFalla.get(KEY3), "Falla", KEY3);
		dataset.addValue(listaFalla.get(KEY4), "Falla", KEY4);
		dataset.addValue(listaFalla.get(KEY5), "Falla", KEY5);

		dataset.addValue(listaPasa.get(KEY1), "Pasa", KEY1);
		dataset.addValue(listaPasa.get(KEY2), "Pasa", KEY2);
		dataset.addValue(listaPasa.get(KEY3), "Pasa", KEY3);
		dataset.addValue(listaPasa.get(KEY4), "Pasa", KEY4);
		dataset.addValue(listaPasa.get(KEY5), "Pasa", KEY5);

		/* create chart */
		JFreeChart chart = ChartFactory.createBarChart(title, "Modulos", "Casos de Prueba", dataset);

		/* Get instance of CategoryPlot */
		CategoryPlot plot = chart.getCategoryPlot();

		/* Change Bar colors */
		BarRenderer renderer = (BarRenderer) plot.getRenderer();

		renderer.setSeriesPaint(0, Color.red);
		renderer.setSeriesPaint(1, Color.green);
		renderer.setSeriesPaint(2, Color.blue);
		
		return chart;
		
	}

}
