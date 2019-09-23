/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import entities.Car;
import entities.Store;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author hoain
 */
public class RunTest {

    public static void main(String[] args) {
        // get All Store
        StoreModel storeModel = new StoreModel();
        List<Store> store = new ArrayList<>();
        store = storeModel.getAllStore();
        for (Store s : store) {
            System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getAddress() + "\t" + s.getDescription());
        }

        // insert Store
//        Store s = new Store(1, "hehe", "ha noi", "lala");
//        storeModel.insertStore(s);

        // update Store
//        Store s = new Store(2, "hehehe", "ha noi", "lala");
//        storeModel.updateStore(s);

        // delete Store
//        storeModel.deleteStore(1);

        // cacs model con lai test tuong tu
        CarModel carModel = new CarModel();
        List<Car> car = new ArrayList<>();
        car = carModel.getAllCar();
        for (Car s : car) {
            System.out.println(s.getId() + "\t" + s.getName()+ "\t" + s.getSeatNum()+ "\t" + s.getPrice());
        }
    }
}
