package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();


        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> loginSuccess() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"lolik@mail.com", "Lolik123!"});
      //list.add(new Object[]{"ninamarkova97@gmail.com", "Y4QHVU8QHv3a@uT"});


        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginSuccess1() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"lolik@mail.com", "Lolik123!"});
        // list.add(new Object[]{"ninamarkova97@gmail.com", "Y4QHVU8QHv3a@uT"});


        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> loginModelSuccess() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"lolik@mail.com", "Lolik123!"});
       list.add(new Object[]{"ninamarkova97@gmail.com", "Y4QHVU8QHv3a@uT"});


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> wrongEmail() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"lolikmail.com", "Lolik123!"});
        list.add(new Object[]{"ninamarkova97gmail.com", "Y4QHVU8QHv3a@uT"});


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> wrongPassword() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"lolik@mail.com", "Lolik12"});
        list.add(new Object[]{"ninamarkova97@gmail.com", "YQHVU"});


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginUnregisteredUser() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"mrt@gmail.com", "Mert123456!"});
        list.add(new Object[]{"m5@gmail.com", "Haifa17775!"});


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataRegistrationSuccess() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setName("Sona").setLastName("Mert").setEmail(("mert5889@gmail.com")).setPassword("Mert123456!")});
        list.add(new Object[]{new User().setName("Sonik").setLastName("Mertik").setEmail("mert145857@gmail.com").setPassword("Mert177756!")});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataRegistrationEmptyName() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setName("").setLastName("Mert").setEmail("mert@gmail.com").setPassword("Mert123456!")});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataRegistrationEmptyLastName() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setName("Sona").setLastName("").setEmail("mert@gmail.com").setPassword("Mert123456!")});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataWrongEmailRegistration() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setName("Sona").setLastName("Mert").setEmail("mertgmail.com").setPassword("Mert123456!")});


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataRegistrationEmptyEmail() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setName("Sona").setLastName("Mert").setEmail("").setPassword("Mert123456!")});

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> dataRegistrationWrongEmail() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{ new User().setName("Lisa").setLastName("Snow").setEmail("snowgmail.com").setPassword("Snow123456$")});

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]>dataRegistrationEmptyPassword() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{ new User().setName("Sona").setLastName("Mert").setEmail("mert@gmail.com").setPassword("")});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>dataWrongPasswordRegistration() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{ new User().setName("Sona").setLastName("Mert").setEmail("mert@gmail.com").setPassword("Mert1!")});

        return list.iterator();
    }
}
