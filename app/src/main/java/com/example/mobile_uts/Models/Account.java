package com.example.mobile_uts.Models;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String name;
    private List<Fight> fights;

    public Account(List<Fight> fights) {
        this.fights = new ArrayList<>();
    }
    public Account(String name){
        this.name = name;
        this.fights = new ArrayList<>();
    }

    public List<Fight> getFights(){
        return fights;
    }
    public void addFight(Fight fight){
        this.fights.add(fight);
    }
    public void updateFight(int index, Fight fight){
        this.fights.set(index, fight);
    }
    public void removeFight(int index){
        this.fights.remove(index);
    }
}
