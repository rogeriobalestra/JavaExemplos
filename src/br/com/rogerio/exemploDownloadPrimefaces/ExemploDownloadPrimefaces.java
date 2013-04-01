package br.com.rogerio.exemploDownloadPrimefaces;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

//CLASSE EXEMPLO DE DOWNLOAD PARA JSF


public class ExemploDownloadPrimefaces implements Serializable {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	
	//Construtor
	public ExemploDownloadPrimefaces() throws FileNotFoundException {        

        InputStream stream = new FileInputStream("C:/temp/arquivo_teste.pdf");
        file = new DefaultStreamedContent(stream, "application/pdf", "arquivo_teste.pdf");
		
	}

    public StreamedContent getFile() {
        return file;
    } 
    
    
    
    /*
        //ESSE CODIGO ABAIXO VAI NA PAGINA DO JSF (xhtml)

		<p:commandLink id="downloadLink" value="Download" ajax="false" >
    		<p:fileDownload value="#{suporteInsereProjetoController.file}" />
		</p:commandLink>	
      
      	OBS: no (h:form) usar:
      	<h:form enctype="multipart/form-data"> 
      
     
     */
    
    
    
}