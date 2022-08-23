//package com.musalasoft.droneservice.Service;
//
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.musalasoft.droneservice.Models.Drones;
//import com.musalasoft.droneservice.Models.MedicationLoaderWrapper;
//import com.musalasoft.droneservice.Repo.IDroneRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//@Service
//public class DroneServiceImpl implements IDroneService{
//
//@Autowired
//    private IDroneRepo droneRepo;
//    @Override
//    public Drones SaveDrone(Drones drones) {
//        return droneRepo.save(drones);
//    }
//
//    @Override
//    public List<Drones> getAvailableDrones() {
//        ArrayList<Drones> _droneList = new ArrayList<>();
//        Iterator<Drones> d = droneRepo.findAll().iterator();
//
//        while (d.hasNext()) {
//            _droneList.add(d.next());
//        }
//        return _droneList;
//    }
//
//    @Override
//    public Drones LoadMedicationToDrone(MedicationLoaderWrapper loadMedicine) {
//
//
//
////        ObjectMapper mapper = new ObjectMapper();
////        String www = "www.sample.pl";
////        try {
////            MedicationLoaderWrapper weather = mapper.readValue(loadMedicine.toString(), MedicationLoaderWrapper.class);
////        } catch (JsonProcessingException e) {
////            throw new RuntimeException(e);
////        }
//
//
//        MedicationLoaderWrapper  myjson = new com.fasterxml.jackson.databind.ObjectMapper().readValue(loadMedicine.toString(), MedicationLoaderWrapper.class);
//
//
////        try {
////         JSONArray the_json_array = myjson.getJSONArray("medications");
////
////            int size = myjson.length();
////            ArrayList<JSONObject> arrays = new ArrayList<JSONObject>();
////            for (int i = 0; i < size; i++) {
////                JSONObject another_json_object = the_json_array.getJSONObject(i);
////                arrays.add(another_json_object);
////            }
////
////            //Finally
////            JSONObject[] jsons = new JSONObject[arrays.size()];
////            arrays.toArray(jsons);
////
////        } catch (JSONException e) {
////            throw new RuntimeException(e);
////        }
////
////
////
////
////
//
//        return null;
//    }
//
//
//}
