package kz.kuzmin.glavnaya.glavnaya.DB;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DBConnector {

    private ArrayList<String> names;
    public DBConnector(){
        names = new ArrayList<>();
        names.add("KEK");
        names.add("LEL");
        names.add("NUN");
        System.out.println("qwe");
    }

    public List<String> getallname(){
        return names;
    }
}
