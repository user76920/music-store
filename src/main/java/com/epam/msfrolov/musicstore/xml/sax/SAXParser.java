package com.epam.msfrolov.musicstore.xml.sax;

import com.epam.msfrolov.musicstore.xml.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class SAXParser<T> implements Parser<T> {

    XMLReader reader;
    SAXHandler<T> handler;
    private T result;

    public SAXParser(Class<T> clazz) {
        handler = new SAXHandler<>(clazz);
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    //todo Exception
    @Override
    public void buildSet(String fileName) {
        try {
            reader.parse(fileName);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        result = handler.getResult();
    }

    @Override
    public T getInstance() {
        return result;
    }

}