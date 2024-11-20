package kz.kuzmin.glavnaya.glavnaya.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Someitem {

    public Someitem(){
        System.out.println("asd");
        this.name = "asd";
        this.amount = 24;
    }
    private String name;
    private int amount;


    public String GetData(){
        return this.name +" - "+ this.amount;
    }


}
