package br.com.rogerio.exemplo_data;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringForDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		try {
			
			/**  EXEMPLO FORMATAR STRING PARA DATE E VICE VERSA */
			
			
			String dataStr = "05/11/2012";
			
			SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
			java.sql.Date data = new java.sql.Date(df1.parse(dataStr).getTime());
			System.out.println(data);
			
			SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
			String dataFormataStr = df2.format(data);
			System.out.println(dataFormataStr);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		

	}

}
