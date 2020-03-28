package com.example.mobile_uts.Models;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int jml1, jml2;
    private List<Fight> fights;

    public Account() {
    }
    public Account(int jml1, int jml2, List<Fight> fights) {
        this.jml1 = jml1;
        this.jml2 = jml2;
        this.fights = new ArrayList<>();
    }

    public void addFight(Fight fight){
        if (fight.getType() == Fight.Type.MALE){
            //jml1 ++;
        }else if (fight.getType() == Fight.Type.FEMALE){
            //jml2++;
        }
        this.fights.add(fight);
    }
    public void updateFight(int index){
        Fight fight = fights.get(index);
        this.jml1 = 0;
        this.jml2 = 0;
        if (fight.getType() == Fight.Type.MALE){
            //jml1 ++;
        }else if (fight.getType() == Fight.Type.FEMALE){
            //jml2++;
        }
    }
    public void removeFight(int index){
        Fight fight = fights.get(index);
        if (fight.getType() == Fight.Type.MALE){
            //jml1--;
        }else if (fight.getType() == Fight.Type.FEMALE){
            //jml2--;
        }
        this.fights.remove(fight);
    }
}
