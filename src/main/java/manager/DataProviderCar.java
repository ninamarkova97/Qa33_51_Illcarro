package manager;

import models.Car;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderCar {
    @DataProvider
    public Iterator<Object[]> dataAddNewCarSuccess() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Opel")
                .model("Astra")
                .year("2025")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNumber("678-900-788")
                .price(50)
                .about("Nice car")
                .build()});
        list.add(new Object[]{Car.builder()
                .location("Haifa, Israel")
                .manufacture("Toyota")
                .model("Camry")
                .year("2013")
                .fuel("Hybrid")
                .seats(4)
                .carClass("S")
                .carRegNumber("45-930-79")
                .price(25)
                .about(" car")
                .build()});
        return list.iterator();
    }
}
