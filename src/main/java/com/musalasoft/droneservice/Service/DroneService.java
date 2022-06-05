package com.musalasoft.droneservice.Service;
import com.musalasoft.droneservice.Models.Drones;
import com.musalasoft.droneservice.Models.Medication;
import com.musalasoft.droneservice.Repo.DroneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component
public class DroneService {

    @Autowired
    DroneRepo _drone;

    public List<Drones> getAvailableDrones() {


        ArrayList<Drones> _droneList = new ArrayList<>();
        try {
            Iterator<Drones> d = _drone.findAll().iterator();
            //Check for the Drones that are in the Idle State and Add them for Loading
            while (d.hasNext() && d.next().getState() == "IDLE") {
                _droneList.add(d.next());
            }

            return _droneList;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Drones RegisterDrone(Drones _drone) {

        return new Drones();

    }

    ////Check For the Medication Items that have been Loaded into the Drone and return them
    public List<Medication> CheckMedicationItemsInDrone(Drones _drone) {

        return new ArrayList<Medication>();
    }

    //Check the Drone and get the battery level
    public String CheckDroneBatteryLevel(@PathVariable String DroneId) {

        return null;
    }

    //Load the Drone with medication items
    public String LoadDroneWithMedication( Medication _Medication,@PathVariable Integer DroneId) {

        //get the Particular Drone to be loaded and check the Battery
        //if the Battery is less than or Equal to 25%, Throw and exception
        //The Exception will be "Sorry you cannot load this Drone now because the Battery is Less than 25%,
        //Kindly charge it up before loading. Thank you".

        if(_drone.findById(DroneId).get().getBattery_Capacity() <= 25) {

            return "Sorry you cannot load this Drone now because the Battery is Less than 25%, Kindly charge it up before loading. Thank you";
        }

        if(CheckTheWeightAlreadyLoaded(DroneId)  > 250) {

            return "Sorry you cannot load this Drone now because it has reached the Carrying Capacity.Thank you";
        }
        //Check if the Weight Is More than the Drone can Carry

        return  _drone.findById(DroneId).get().toString();

    }

    private Integer CheckTheWeightAlreadyLoaded(Integer droneId) {

        return 100;
    }


}
