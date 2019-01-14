package mgbeans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.CD;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

@ManagedBean
@SessionScoped
public class Listing {

    private List<CD> cdList;
    private String error;
    private String path;
    

    public Listing() {

        error = "";

        SAXBuilder saxBuilder = new SAXBuilder();
        
        // find cd_catalog.xml in project's web/resources/sourceXMLFile
        File file = new File("C:\\webshop\\cd_catalog.xml");  
        Document document;
    

        cdList = new ArrayList<>();

        try {

            document = saxBuilder.build(file);
            Element root = document.getRootElement();
            List<Element> elementList = root.getChildren();

            for (Element e : elementList) {
                String title = e.getChildText("TITLE");

                CD cd = new CD(
                        e.getChildText("TITLE"),
                        e.getChildText("ARTIST"),
                        e.getChildText("COUNTRY"),
                        e.getChildText("COMPANY"),
                        Double.parseDouble(e.getChildText("PRICE")),
                        Integer.parseInt(e.getChildText("YEAR"))
                );
                cdList.add(cd);
            }
        } catch (JDOMException ex) {
            error += ex;
        } catch (IOException ex) {
            error += ex;
        }
        
        
    }

    public List<CD> getCdList() {
        return cdList;
    }

    public void setCdList(List<CD> cdList) {
        this.cdList = cdList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
}
