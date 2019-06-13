package com.zoom.kiki.outofline;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataParser {

    private HashMap<String, String> getSingleNearbyPlace(JSONObject googlePlaceJSON){
        HashMap<String, String> googlePlaceMap = new HashMap<>();
        String namePlace = "-NA-";
        String vicinity = "-NA-";
        String latitude = "";
        String longitude = "";
        String reference = "";

        try {

            if(!googlePlaceJSON.isNull("name")){
                namePlace = googlePlaceJSON.getString("name");
            }

            if(!googlePlaceJSON.isNull("vicinity")){
                namePlace = googlePlaceJSON.getString("vicinity");
            }

            latitude = googlePlaceJSON.getJSONObject("geometric").getJSONObject("location").getString("lat");
            longitude = googlePlaceJSON.getJSONObject("geometric").getJSONObject("location").getString("long");
            reference = googlePlaceJSON.getString("reference");

            googlePlaceMap.put("place_name", namePlace);
            googlePlaceMap.put("vicinity", vicinity);
            googlePlaceMap.put("lat", latitude);
            googlePlaceMap.put("long", longitude);
            googlePlaceMap.put("reference", reference);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return googlePlaceMap;
    }

    private List<HashMap<String, String>> getAllNearbyPlaces(JSONArray jsonArray){

        int counter = jsonArray.length();

        List<HashMap<String, String>> nearbyPlacesList = new ArrayList<>();

        HashMap<String, String> nearbyPlaceMap = null;

        for(int i = 0; i < counter; i++){
            try {
                nearbyPlaceMap = getSingleNearbyPlace( (JSONObject) jsonArray.get(i) );
                nearbyPlacesList.add(nearbyPlaceMap);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return nearbyPlacesList;
    }

    public List<HashMap<String, String>> parse(String JSONdata){

        JSONArray jsonArray = null;
        JSONObject jsonObject;


        try {

            jsonObject = new JSONObject(JSONdata);
            jsonArray = jsonObject.getJSONArray("results");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return getAllNearbyPlaces(jsonArray);
    }
}
