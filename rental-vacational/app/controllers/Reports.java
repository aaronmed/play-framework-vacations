package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import play.mvc.Controller;

public class Reports extends Controller {

	public void generateReport(String user, String name) {
		File file;
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/db_vacations?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
					"root", "");
			ClassLoader cl = getClass().getClassLoader();
			file = new File(cl.getResource("/views/reports/" + name + ".jrxml").getFile());
			System.out.println(file.getAbsolutePath());
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			
			
			Map<String, Object> parameter = new HashMap<>();
			parameter.put("user", user);

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);

			//System.out.println(file.getParent());
			JasperExportManager.exportReportToHtmlFile(jasperPrint, file.getParent() + "/" + name + user +".html");
			//JasperExportManager.exportReportToPdfFile(jasperPrint, file.getParent() + "/report.pdf");

			System.out.print("File exported!");
			System.out.println("Report generated in path: " + file.getParent());
			conn.close();

//		} catch (FileNotFoundException e) {
//			System.out.println("Error. Report not generated.");
//			e.printStackTrace();
		} catch (JRException e) {
			System.out.println("Error. Report not generated.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error. Report not generated.");
			e.printStackTrace();
		}
		renderTemplate("reports/"+ name + user +".html");
	}
}