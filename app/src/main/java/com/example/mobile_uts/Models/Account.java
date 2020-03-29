package com.example.mobile_uts.Models;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int jml1, jml2;
    private List<Fight> fights;

    public Account() {
        this.jml1 = jml1;
        this.jml2 = jml2;
        this.fights = new ArrayList<>();
    }

    public int getJml1() {
        return jml1;
    }

    public void setJml1(int jml1) {
        this.jml1 = jml1;
    }

    public int getJml2() {
        return jml2;
    }

    public void setJml2(int jml2) {
        this.jml2 = jml2;
    }

    public List<Fight> getFights(){
        return fights;
    }
    public void addFight(Fight fight){
        if (fight.getType() == Fight.Type.MALE){
            jml1 += fight.getJml1();
        }else if (fight.getType() == Fight.Type.FEMALE){
            jml1 += fight.getJml1();
        }
        this.fights.add(fight);
    }
    public void updateFight(int index){
        Fight fight = fights.get(index);
        this.jml1 = 0;
        this.jml2 = 0;
        if (fight.getType() == Fight.Type.MALE){
            jml1 += fight.getJml1();
        }else if (fight.getType() == Fight.Type.FEMALE){
            jml2 += fight.getJml2();
        }
    }
    public void removeFight(int index){
        Fight fight = fights.get(index);
        if (fight.getType() == Fight.Type.MALE){
            jml1 -= fight.getJml1();
        }else if (fight.getType() == Fight.Type.FEMALE){
            jml1 -= fight.getJml1();
        }
        this.fights.remove(fight);
    }
}
