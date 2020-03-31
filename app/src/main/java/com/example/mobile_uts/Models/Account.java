package com.example.mobile_uts.Models;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int jml1, jml2;
    private List<Fight> fights;

    public Account() {
        this.jml1 = 0;
        this.jml2 = 0;
        this.fights = new ArrayList<>();
    }

    public int getJml1() {
        return jml1;
    }

    public int getJml2() {
        return jml2;
    }

    public List<Fight> getFights(){
        return fights;
    }
    public void addFight(Fight fight){
        if (fight.getType() == Fight.Type.MALE){
            jml1 += fight.getJml1();
        }else if (fight.getType() == Fight.Type.FEMALE){
            jml2 += fight.getJml2();
        }
        this.fights.add(fight);
    }
    public void updateFight(int index){
        Fight fight = fights.get(index);
        this.jml1 = 0;
        this.jml2 = 0;
        for (Fight f : this.fights){
            if (fight.getType() == Fight.Type.MALE){
                jml1 += fight.getJml1();
            }else if (fight.getType() == Fight.Type.FEMALE) {
                jml2 += fight.getJml2();
            }
        }
    }
    public void removeFight(int index){
        Fight fight = fights.get(index);
        if (fight.getType() == Fight.Type.MALE){
            jml1 -= fight.getJml1();
        }else if (fight.getType() == Fight.Type.FEMALE){
            jml2 -= fight.getJml2();
        }
        this.fights.remove(fight);
    }
}
