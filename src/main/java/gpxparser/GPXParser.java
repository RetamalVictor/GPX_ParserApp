package gpxparser;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GPXParser {
    ArrayList<ArrayList<Double>> trackList = new ArrayList<>();
    String file;
    String tagName = "trkpt";
    DocumentBuilder builder;

    public GPXParser(String file) {
        this.file = file;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        ArrayList<ArrayList<Double>> newtrackList = new ArrayList<>();
        String tagName = "trkpt";
        try {
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            this.builder = builder;
            newtrackList = parseGPX(file,tagName, builder);
            this.trackList = newtrackList;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ArrayList<Double>> parseGPX(String file,String tagName, DocumentBuilder builder){
        ArrayList<ArrayList<Double>> newTrackList = new ArrayList<>();
        ArrayList<Double> latList;
        ArrayList<Double> lonList;
        ArrayList<Double> elevationList;
        latList = parseLat(file,tagName,builder);
        lonList = parseLon(file,tagName,builder);
        elevationList = parseElevation(file, tagName, builder);

        newTrackList.add(latList);
        newTrackList.add(lonList);
        newTrackList.add(elevationList);

        return newTrackList;
    }

    public ArrayList<Double> parseLat(String file, String tagName, DocumentBuilder builder){
        ArrayList<Double> newLatList = new ArrayList<>();
        try {
            Document doc = builder.parse(file);
            NodeList trkList = doc.getElementsByTagName(tagName);
            for (int i = 0; i < trkList.getLength(); i++) {
                Node trk = trkList.item(i);
                if (trk.getNodeType() == Node.ELEMENT_NODE) {
                    Element track = (Element) trk;
                    Double lat = Double.valueOf(track.getAttribute("lat"));
                    newLatList.add(lat);
                }
            }
        }catch (SAXException | IOException e){
            e.printStackTrace();
        }
        return newLatList;
    }

    public ArrayList<Double> parseLon(String file, String tagName, DocumentBuilder builder){
        ArrayList<Double> newLonList = new ArrayList<>();
        try {
            Document doc = builder.parse(file);
            NodeList trkList = doc.getElementsByTagName(tagName);
            for (int i = 0; i < trkList.getLength(); i++) {
                Node trk = trkList.item(i);
                if (trk.getNodeType() == Node.ELEMENT_NODE) {
                    Element track = (Element) trk;
                    Double lon = Double.valueOf(track.getAttribute("lon"));
                    newLonList.add(lon);
                }
            }
        }catch (SAXException | IOException e){
            e.printStackTrace();
        }
        return newLonList;
    }

    public ArrayList<Double> parseElevation(String file, String tagName, DocumentBuilder builder){
        ArrayList<Double> newElevationList = new ArrayList<>();
        try {
            Document doc = builder.parse(file);
            NodeList trkList = doc.getElementsByTagName(tagName);
            for (int i = 0; i < trkList.getLength(); i++) {
                Node trk = trkList.item(i);
                if (trk.getNodeType() == Node.ELEMENT_NODE) {
                    Element track = (Element) trk;
                    if (track.hasChildNodes()){
                        NodeList elevationList = track.getChildNodes();
                        Node elevationNode = elevationList.item(1);
                        Element elevationTag = (Element) elevationNode;
                        Double elevationNumber = Double.valueOf(elevationTag.getTextContent());
                        newElevationList.add(elevationNumber);
                    }
                }
            }
        }catch (SAXException | IOException e){
            e.printStackTrace();
        }
        return newElevationList;
    }

    public ArrayList<Double> getLat(){
        return parseLat(this.file, this.tagName, this.builder);
    }

    public ArrayList<Double> getLon(){
        return parseLon(this.file, this.tagName, this.builder);
    }

    public ArrayList<Double> getElevation(){
        return parseElevation(this.file, this.tagName, this.builder);
    }

}
