package principal;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class cerebro {

	public static void main(String[] args) throws JRException {
		// TODO Auto-generated method stub
		List<Data> milista = new ArrayList<Data>();
		for (int i = 0; i < 5; i++) {
			Data datos = new Data();
			if (i < 2) {
				datos.setCosa("Prueba");
				milista.add(datos);
			} else {
				datos.setCosa("lolazo");
				milista.add(datos);
			}
		}
		cerebro c = new cerebro();
		c.relatorio(milista);
	}

	public void relatorio(List<Data> lista) throws JRException {
		InputStream arq = cerebro.class.getResourceAsStream("/secundario/report1.jrxml");

		JasperReport report = JasperCompileManager.compileReport(arq);

		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));

		JasperViewer.viewReport(print, false);
	}

}
