package com.example.mobile_uts.Models;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int jml1, jml2;
    private String name;
    private List<Fight> fights;

    public Account(int jml1, int jml2, List<Fight> fights) {
        this.jml1 = jml1;
        this.jml2 = jml2;
        this.fights = new ArrayList<>();
    }
    public Account(String name){
        this.name = name;
        this.fights = new ArrayList<>();
        this.jml1 = 0;
        this.jml2 = 0;
    }
    public int getJml1() {
        return jml1;
    }

    public void setJml1(int jml1) {
        this.jml1 = jml1;
    }

    public void setJml2(int jml2) {
        this.jml2 = jml2;
    }

    public int getJml2() {
        return jml2;
    }

    public List<Fight> getFights(){
        return fights;
    }
    public void addFight(Fight fight){
        if (fight.getType() == Fight.Type.MALE){
//            jml1 += fight.getJml1();
        }else if (fight.getType() == Fight.Type.FEMALE){
//            jml2 += fight.getJml2();
        }
        this.fights.add(fight);
    }
    public void updateFight(int index, Fight fight){
//        Fight fight = fights.get(index);
//        this.jml1 = 0;
//        this.jml2 = 0;
//        for (Fight f : this.fights){
//            if (fight.getType() == Fight.Type.MALE){
//                jml1 += fight.getJml1();
//            }else if (fight.getType() == Fight.Type.FEMALE) {
//                jml2 += fight.getJml2();
//            }
//        }
        this.fights.set(index, fight);
    }
    public void removeFight(int index){
        Fight fight = fights.get(index);
//        if (fight.getType() == Fight.Type.MALE){
//            jml1 -= fight.getJml1();
//        }else if (fight.getType() == Fight.Type.FEMALE){
//            jml2 -= fight.getJml2();
//        }
        this.fights.remove(fight);
    }
}
