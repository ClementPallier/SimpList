package fr.mtp.epsi.save;

import android.os.Environment;
import android.util.Log;
import android.util.Xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import fr.mtp.epsi.entities.Note;
import fr.mtp.epsi.entities.TypeListe;

/**
 * Created by pallier04 on 22/05/2014.
 */
public class Cache{

    private final static File xml = new File(Environment.getExternalStorageDirectory()+"/cache.xml");
    private XmlSerializer serializer = Xml.newSerializer();

    public Cache(){
        this.create();
    }

    private void create(){
        try{
            if(!this.xml.exists()){
                this.xml.createNewFile();
                FileOutputStream outputStream = new FileOutputStream(this.xml);

                serializer.setOutput(outputStream, "UTF-8");
                serializer.startDocument(null, Boolean.valueOf(true));
                serializer.endDocument();
                serializer.flush();

                outputStream.close();
            }
        } catch(FileNotFoundException e){
            Log.e("FileNotFoundException", "can't create FileOutputStream");
        } catch(IOException e){
            System.out.println(e.getStackTrace());
            Log.e("IOException", "exception in createNewFile() method");
        }

    }

    public boolean write(TypeListe typeListe){
        boolean result = false;

        try{
            FileOutputStream outputStream = new FileOutputStream(xml);
            serializer.startTag(null, "categorie");
                serializer.attribute(null, "id",String.valueOf(typeListe.getId()));
                serializer.attribute(null, "name",typeListe.getTitre());
                for(Note n : typeListe.ListeDeNote){
                    serializer.startTag(null, "note");
                    serializer.attribute(null, "id", String.valueOf(n.getId()));
                    serializer.attribute(null, "name",n.getTitre());
                    serializer.attribute(null, "content",n.getContenu());
                    serializer.endTag(null, "note");
                }
            serializer.endTag(null, " categorie ");
            serializer.flush();

            outputStream.close();
        }catch (IOException e){

        }
        return result;
    }

    public void read(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            Document dom = builder.parse(new FileInputStream(xml));
            Element root = dom.getDocumentElement();

            NodeList items = root.getElementsByTagName("categorie");
            Node item = items.item(0);
            String id = item.getAttributes().getNamedItem("id").getNodeValue();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
