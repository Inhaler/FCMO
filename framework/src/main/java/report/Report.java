package report;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.DefaultFontMapper;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import config.DataSetter;
import context.PreObjects;
import helpers.GraphHelper;
import helpers.XMLHelper;
import static helpers.XMLHelper.preObjects;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import org.jfree.chart.JFreeChart;


public class Report {
	private static String FILE = System.getProperty("user.dir")+ DataSetter.configuration.getReportRepository();
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
			Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.NORMAL, BaseColor.RED);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
			Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.BOLD);

	private static final String KEY1 = "Despacho";
	private static final String KEY2 = "Farmacia";
	private static final String KEY3 = "Administrador";
	private static final String KEY4 = "Medico";
	private static final String KEY5 = "Socio";

	public static String getTime() {
		Calendar calendar = Calendar.getInstance();
		String hours = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
		String minutes = String.valueOf(calendar.get(Calendar.MINUTE));
		String seconds = String.valueOf(calendar.get(Calendar.SECOND));

		return hours + minutes + seconds;
	}

	public static void generatePdfReport() {
		HashMap<String, Integer> listaPasa = new HashMap<>(); 
		HashMap<String, Integer> listaFalla = new HashMap<>(); 

		resumenEstadoPruebas(listaPasa, listaFalla);

		try {
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			addMetaData(document);
			addTitlePage(document);
			addResumenTest(document,listaPasa,listaFalla);
			writeChartToPDF(GraphHelper.generateGraficoEstadoCasos(listaPasa,listaFalla), 500, 300, 30, 335,document, writer);
			writeChartToPDF(GraphHelper.generateGraficoBugsPorModulo(listaFalla), 500, 300, 30, 20, document, writer);
			document.newPage();
			addTestContent(document);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void addResumenTest(Document document, HashMap<String, Integer> listaPasa, HashMap<String, Integer> listaFalla) throws DocumentException {
		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 1);
		Paragraph first = new Paragraph("Resumen del estado de los casos de prueba por modulo", subFont);
		addEmptyLine(preface, 1);
		first.setAlignment(Element.ALIGN_CENTER);
		document.add(first);
		PdfPTable table = new PdfPTable(3);
		PdfPCell c1 = new PdfPCell(new Phrase("Modulo"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		c1 = new PdfPCell(new Phrase("Pasa"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		c1 = new PdfPCell(new Phrase("Falla"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);
		document.add(preface);
		document.add(buildTableEstados(table,listaPasa,listaFalla));
	}

	public static PdfPTable buildTableEstados(PdfPTable table, HashMap<String, Integer> listaPasa,HashMap<String, Integer> listaFalla ) {
		
		for (String key : listaPasa.keySet()) {
			table.addCell(key);
			table.addCell(listaPasa.get(key).toString());
			table.addCell(listaFalla.get(key).toString());
		}

		return table;
	}

	private static void addMetaData(Document document) {
		document.addTitle(ReportConfiguration.titleAddAutor);
		document.addSubject(ReportConfiguration.titleAddSubject);
		document.addKeywords(ReportConfiguration.titleAddKeyWords);
		document.addAuthor(ReportConfiguration.titleAddAutor);
		document.addCreator(ReportConfiguration.titleAddCreator);
	}
	
	private static String fechaES () {
		SimpleDateFormat formateador = new SimpleDateFormat(
				"dd/MM/yyyy - HH:mm:ss", new Locale("es_ES"));
		Date fechaDate = new Date();
		String fecha = formateador.format(fechaDate);
		return fecha;
	}

	private static void addTitlePage(Document document) throws DocumentException {
		Paragraph preface = new Paragraph();
		float width = document.getPageSize().getWidth();
		float height = document.getPageSize().getHeight();
		Rectangle rect = new Rectangle(width - 15, height - 10);
		rect.setLeft(15);
		rect.setBottom(15);
		rect.setBorder(Rectangle.BOX);
		rect.setBorderColor(BaseColor.BLACK);
		rect.setBorderWidth(2);
		document.add(rect);
		// We add one empty line
		addEmptyLine(preface, 1);
		// Lets write a big header
		preface.add(new Paragraph(ReportConfiguration.titleTitle, catFont));
		addEmptyLine(preface, 1);
		// Will create: Report generated by: _name, _date
		preface.add(new Paragraph(
				ReportConfiguration.titleReportBy + ReportConfiguration.titleAddAutor + ", " + fechaES(), smallBold));
		addEmptyLine(preface, 1);
		preface.add(new Paragraph(ReportConfiguration.titleIntroDetails));
		addEmptyLine(preface, 1);
		preface.add(new Paragraph(ReportConfiguration.titleSecondTitle, subFont));
		addEmptyLine(preface, 1);
		preface.add(new Paragraph(ReportConfiguration.titleSecondDetails));
		addEmptyLine(preface, 1);
		preface.add(new Paragraph(ReportConfiguration.titleThirdTitle, subFont));
		preface.add(new Paragraph(ReportConfiguration.titleThirdDetails));
		document.add(preface);
		// Start a new page
		document.newPage();
	}

	public static void resumenEstadoPruebas(HashMap<String, Integer> listaPasa,HashMap<String, Integer> listaFalla) {

		listaPasa.put(KEY1, 0); 
		listaPasa.put(KEY2, 0); 
		listaPasa.put(KEY3, 0); 
		listaPasa.put(KEY4, 0); 
		listaPasa.put(KEY5, 0);

		listaFalla.put(KEY1, 0); 
		listaFalla.put(KEY2, 0); 
		listaFalla.put(KEY3, 0); 
		listaFalla.put(KEY4, 0); 
		listaFalla.put(KEY5, 0);

		for (int i = 0; i < XMLHelper.preObjects.size(); i++) {

			String estado = preObjects.get(i).obj.getEstado();

			if (estado.equals("Pasa")) {
				Integer count = listaPasa.get(preObjects.get(i).obj.getModulo());
				if (count == null) {
					listaPasa.put(preObjects.get(i).obj.getModulo(), 1);
				} else {
					listaPasa.put(preObjects.get(i).obj.getModulo(), count + 1);
				};

			} else {
				Integer count = listaFalla.get(preObjects.get(i).obj.getModulo());
				if (count == null) {
					listaFalla.put(preObjects.get(i).obj.getModulo(), 1);
				} else {
					listaFalla.put(preObjects.get(i).obj.getModulo(), count + 1);
				};
			}
		}

		// Imprimimos el Map con un Iterador
		System.out.println(Arrays.asList(listaFalla));
		System.out.println(Arrays.asList(listaPasa));

	}

	public static void addTestContent(Document document) throws DocumentException, MalformedURLException, IOException {
		for (int i = 0; i < XMLHelper.preObjects.size(); i++) {
			float width = document.getPageSize().getWidth();
			float height = document.getPageSize().getHeight();
			Rectangle rect = new Rectangle(width - 15, height - 10);
			rect.setLeft(15);
			rect.setBottom(15);
			rect.setBorder(Rectangle.BOX);
			rect.setBorderColor(BaseColor.BLACK);
			rect.setBorderWidth(2);
			document.add(rect);

			Paragraph preface = new Paragraph();
			Paragraph first = new Paragraph(ReportConfiguration.testContentTitle + " " + preObjects.get(i).obj.getNombreDeLaPrueba(), catFont);
			//first.setAlignment(Element.ALIGN_CENTER);
			document.add(first);

			//preface.add(new Paragraph("", smallBold));
			//preface.add(new Paragraph(preObjects.get(i).obj.getNombreDeLaPrueba(), catFont));// Will create: Report generated by: _name, _date
			preface.add(new Paragraph(
					ReportConfiguration.testContentExecuteBy + ReportConfiguration.titleAddAutor + ", " + fechaES(), smallBold));
			addEmptyLine(preface, 1);
			preface.add(new Paragraph(ReportConfiguration.testContentTestDescription, smallBold));
			preface.add(new Paragraph(preObjects.get(i).obj.getDescripcion()));
			addEmptyLine(preface, 1);
			preface.add(new Paragraph(ReportConfiguration.testContentObjetiveDescription +  " " + preObjects.get(i).obj.getTipoDePrueba(), smallBold));
			addEmptyLine(preface, 1);
			preface.add(new Paragraph("Duración: " + preObjects.get(i).obj.getTiempoFinal() + " Seg", smallBold));
			addEmptyLine(preface, 1);
			if (preObjects.get(i).obj.getEstado().equals("Falla")) {
				preface.add(new Paragraph("Estado: " + preObjects.get(i).obj.getEstado(), redFont));
			} else {
				preface.add(new Paragraph("Estado: " + preObjects.get(i).obj.getEstado(), smallBold));
			}
			addEmptyLine(preface, 2);
			PdfPTable table = new PdfPTable(2);
			PdfPCell c1 = new PdfPCell(new Phrase("Nombre del paso"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			c1 = new PdfPCell(new Phrase("Estado"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			table.setHeaderRows(1);
			document.add(preface);
			document.add(buildTable(table, preObjects.get(i).obj.getNombreDeLaPrueba(), preObjects.get(i)));
			
			if (preObjects.get(i).obj.getEstado().equals("Falla")) {
				Paragraph preface2 = new Paragraph();
				addEmptyLine(preface2, 1);
				preface2.add(new Paragraph(preObjects.get(i).obj.getImgFalla(), smallBold));
				document.add(preface2);
				
				// Creating an ImageData object 
				String imageFile = preObjects.get(i).obj.getImgFalla(); 
			    Image image = Image.getInstance(imageFile);
			    image.scalePercent(39f);
			    document.add(image);
				
			}
			
			
		}

	}

	public static PdfPTable buildTable(PdfPTable table, String ide, PreObjects pre) {
		HashMap<String, String> hash = pre.obj.getPasos();
		Map<String, String> treeMap = new TreeMap<String, String>(hash);
		for (String key : treeMap.keySet()) {
			table.addCell(key);
			table.addCell(pre.obj.getPasos().get(key));
		}

		return table;
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	public static void writeChartToPDF(JFreeChart chart, int width, int height, int x, int y, Document document, PdfWriter writer) throws DocumentException {
		
		float w = document.getPageSize().getWidth();
		float h = document.getPageSize().getHeight();
		Rectangle rect = new Rectangle(w - 15, h - 10);
		rect.setLeft(15);
		rect.setBottom(15);
		rect.setBorder(Rectangle.BOX);
		rect.setBorderColor(BaseColor.BLACK);
		rect.setBorderWidth(2);
		document.add(rect);
		
		PdfContentByte contentByte = writer.getDirectContent();
		PdfTemplate template = contentByte.createTemplate(width, height);
		Graphics2D graphics2d = template.createGraphics(width, height,
				new DefaultFontMapper());
		Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width,
				height);
		chart.draw(graphics2d, rectangle2d);
		graphics2d.dispose();
		contentByte.addTemplate(template, x, y);
	}

}
