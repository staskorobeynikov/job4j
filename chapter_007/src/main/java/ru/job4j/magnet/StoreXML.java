package ru.job4j.magnet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class StoreXML {
    private final File target;
    private final Logger logger = LogManager.getLogger(StoreXML.class.getName());

    public StoreXML(File target) {
        this.target = target;
    }

    public void save(List<Entry> list) {
        Entries entries = new Entries(list);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(entries, target);
        } catch (Exception exc) {
            logger.error(exc.getMessage(), exc);
        }
    }
}
