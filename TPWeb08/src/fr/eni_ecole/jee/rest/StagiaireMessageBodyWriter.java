package fr.eni_ecole.jee.rest;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import fr.eni_ecole.jee.bean.Stagiaire;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Provider
@Produces("text/html")
public class StagiaireMessageBodyWriter implements MessageBodyWriter<List<Stagiaire>> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType,
                               Annotation[] annotations, MediaType mediaType) {
    	
    	System.out.println(genericType.getTypeName());
        return type == ArrayList.class;
    }

     @Override
    public void writeTo(List<Stagiaire> lst, Class<?> type, Type genericType, Annotation[] annotations,
                        MediaType mediaType, MultivaluedMap<String, Object> httpHeaders,
                        OutputStream out) throws IOException, WebApplicationException {

        Writer writer = new PrintWriter(out);
        writer.write("<html>");
        writer.write("<body>");
        writer.write("<h2>JAX-RS Message Body Writer Example</h2>");
        writer.write("<p>Id: " + lst.get(0).getNom() + "</p>");
        writer.write("<p>Name: " + lst.get(0).getPrenom()+ "</p>");
        writer.write("</body>");
        writer.write("</html>");

        writer.flush();
        writer.close();
    }

	@Override
	public long getSize(List<Stagiaire> arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4) {
		// TODO Auto-generated method stub
		return 0;
	}


}