package rfc.core;

import rfc.entity.HandicapDataEntity;
import rfc.entity.HandicapEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/7/29.
 */
public class Handicap {

    private List<HandicapEntity> All_Handicap;
    private  int  m_HandicapNum;

    public int GetRecord(){

        for (HandicapEntity he: HandicapDataEntity.globalHandicap) {
            if (!he.caHandicap.isEmpty()) {
                All_Handicap.add(he);
                m_HandicapNum++;
            }
        }
        return 0;
    }

    public int Findrecord(String caHandicap, HandicapEntity ptHandicap){

        boolean caFindId = false;

        if (m_HandicapNum ==0)
            return -10010;
        for (HandicapEntity he :All_Handicap) {
            if (caHandicap.equals(ptHandicap.caHandicap)){
                ptHandicap =he;
                caFindId = true;
                break;
            }
        }
        if (caFindId)
            return -10020;
        return 0;
    }

    public void Output(){
        for (HandicapEntity he :All_Handicap) {
            System.out.println(he.caHandicap+","+he.iHandicap);
        }
    }

}
