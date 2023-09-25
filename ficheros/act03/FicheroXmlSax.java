package ficheros.act03;

import java.io.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class FicheroXmlSax {
    public static void main(String[] args) throws FileNotFoundException, IOException, SAXException{
        XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
        GestionContenido gestor = new GestionContenido();
        procesadorXML.setContentHandler(gestor);
        InputSource archivoXML = new InputSource("./ficheros/act03/alumnos.xml");
        procesadorXML.parse(archivoXML);
    }
}
