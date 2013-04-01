package br.com.rogerio.exemploUploadPrimefaces;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

public class ExemploUploadPrimefaces {



	/** CONSTRUTOR */
	public ExemploUploadPrimefaces(){
		
		
	}
	


	/** RECEBE O EVENTO QUE PEGA O ARQUIVO PARA UPLOAD */
	public void handleFileUpload(FileUploadEvent event) throws FileNotFoundException, IOException {
		
	    FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
	    FacesContext.getCurrentInstance().addMessage(null, msg);
	
	    byte[] conteudo = event.getFile().getContents();
	    String caminho = "C:\\temp\\" + event.getFile().getFileName();
	    FileOutputStream fos = new FileOutputStream(caminho);
	    fos.write(conteudo);   
	    fos.close();
	 }	


	
	/*
		//################ ADIOCIONAR ESSE CODIGO NO (.xhtm) pagina .jsf
		 
		<!-- UPLOAD ARQUIVO -->
	    <p:fileUpload fileUploadListener="#{fileUploadController.handleFileUpload}"
	            mode="advanced" 
	            update="messages"
	            sizeLimit="8000000" 
	            allowTypes="/(\.|\/)(gif|jpe?g|pdf|txt)$/"/>
	
	    <p:growl id="messages" showDetail="true"/>
	 */
	
	
	
	/* 

		//############## ADICIONAR ESSE CODIGO NO web.xml
		 
		<filter>
			<filter-name>PrimeFaces FileUpload Filter</filter-name>
			<filter-class>
				org.primefaces.webapp.filter.FileUploadFilter
			</filter-class>
		</filter>
		<filter-mapping>
			<filter-name>PrimeFaces FileUpload Filter</filter-name>
			<servlet-name>Faces Servlet</servlet-name>
		</filter-mapping>


 */	
	
	
	
	
}


