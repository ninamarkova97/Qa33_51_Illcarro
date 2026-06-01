
import manager.DataProviderCar;
import manager.DataProviderUser;
import models.Car;
import models.User;
import org.openqa.selenium.devtools.v133.domstorage.model.DomStorageItemAdded;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase {

    @BeforeClass
    public void preCondition(){
      //  if(!app.getHelperUser().isLogged()){
       //     app.getHelperUser().login(new User().setEmail("lolik@gmail.com").setPassword("Lolik123!"));

    }


    @Test (dataProvider = "dataAddNewCarSuccess", dataProviderClass = DataProviderCar.class)
    public void addNewCarSuccess(Car car) {
        int i = new Random().nextInt(1000)+1000;
//        Car car = Car.builder()
//                .location("Tel Aviv, Israel")
//                .manufacture("Opel")
//                .model("Astra")
//                .year("2025")
//                .fuel("Petrol")
//                .seats(4)
//                .carClass("C")
//                .carRegNumber("678-900-"+i)
//                .price(50)
//                .about("Nice car")
//                .build();
       //  logger.info("location: Tel-Aviv,Israel, manufacture: Opel, model: Astra," +
              //   "year: 2025, fuel:Petrol, seats: 4, carClass: 'C', carRegNumber: 678-900-"+
           //      i+"price:50, about: 'Nice car'");
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("D:\\QA33_51_GitHub\\Qa33_51_Illcarro\\Bugatti_Veyron_16.4_–_Frontansicht_(1),_5._April_2012,_Düsseldorf 2.jpg");
       app.getHelperCar().getScreen("src/test/screenshots/screen-"+i+".png");

        app.getHelperCar().submitCarForm();

    }
}

