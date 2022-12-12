package softwaredesign;

import gpxparser.GPXParser;

import java.io.File;
import java.util.ArrayList;

public class GPXinfo {
    ArrayList<Double> lonList;
    ArrayList<Double> elevationList;
    ArrayList<Double> latList;

    public GPXinfo(File file) {
        GPXParser gpxParser = new GPXParser(file.getPath());
        lonList = gpxParser.getLon();
        elevationList = gpxParser.getElevation();
        latList = gpxParser.getLat();
    }

    public ArrayList<Double> getLatitude(){
        return latList;
    }

    public ArrayList<Double> getLongutide(){
        return lonList;
    }

    public ArrayList<Double> getElevation(){
        return elevationList;
    }
}
