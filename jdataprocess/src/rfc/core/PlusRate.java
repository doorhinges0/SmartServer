package rfc.core;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import rfc.common.Const;
import rfc.common.ResourceUtils;
import rfc.entity.PlusRateEntity;

import java.io.File;
import java.util.*;

/**
 * Created by Administrator on 2017/8/12.
 */
public class PlusRate {

    private   String  m_PlusRateFile;
    private   List<PlusRateEntity> Domestic_PlusRate;
    private   List<PlusRateEntity> SB_PlusRate;
    private   List<PlusRateEntity> Bet_PlusRate;
    private  int  Domestic_Num;
    private  int  SB_Num;
    private  int  Bet_Num;

    public PlusRate(String caRateFile){
        m_PlusRateFile = caRateFile;
        Domestic_Num = 0;
        SB_Num = 0;
        Bet_Num = 0;
    }

    public int GetRecord(){
        PlusRateEntity pre = new PlusRateEntity();
        List<PlusRateEntity> preList = new ArrayList<PlusRateEntity>();
        int			iNum = 0;

        String	SB_Values = null ;
        String	Bet_Values = null ;
        File file = null;
        try {
            file = ResourceUtils.getFile(m_PlusRateFile);

            if (!file.exists()){
                System.out.println("Award文件不存在: "+ m_PlusRateFile);
                return -1;
            }

            LineIterator it = FileUtils.lineIterator(file, "GBK");
            while (it.hasNext()){
                String line = it.nextLine();
                if (line.startsWith("#") || line.startsWith("Company"))
                    continue;

                String[] words = line.split(" ");
                pre.caCompany = words[0];
                pre.caType = words[1];
                pre.dAward = Double.valueOf(words[2]);
                pre.dPlusRate = Double.valueOf(words[3]);

                if ((!pre.caCompany.isEmpty()) && (!pre.caType.isEmpty())){
                    preList.add(pre);
                    iNum++;
                    if (iNum >= 100) {
                        //  超出数组上限, 退出
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //  排序: order by caCompany, caType, dAward asc
        Collections.sort(preList,  new  Comparator() {
            public   int  compare(Object  o1, Object o2) {
                PlusRateEntity e1=(PlusRateEntity)o1;
                PlusRateEntity e2=(PlusRateEntity)o2;

                if (e1.caCompany.equals(e2.caCompany)){
                    if (e1.caType.equals(e2.caType)){
                        return (int)(e1.dAward - e2.dAward);
                    }
                    else
                        return e1.caType.compareTo(e2.caType);
                }
                else
                    return e1.caCompany.compareTo(e2.caCompany);
            }
        });

        for (PlusRateEntity plusRateEntity :preList) {
            Domestic_PlusRate.add(plusRateEntity);
            Domestic_Num++;
        }
        for (PlusRateEntity plusRateEntity :preList) {
            SB_PlusRate.add(plusRateEntity);
            SB_Num++;
        }
        for (PlusRateEntity plusRateEntity :preList) {
            Bet_PlusRate.add(plusRateEntity);
            Bet_Num++;
        }

        return 0;
    }

    public void FindRecord(String caCompany, String caType, double dAward, PlusRateEntity ptPlusRate){

        PlusRateEntity temp = null;
        boolean caFindId = false;
        int		iNum = 0;

        if (Const.DOMESTIC.equals(caCompany)){
            if (Domestic_Num == 0)
                return;
            for (PlusRateEntity pre :Domestic_PlusRate) {
                if (caCompany.equals(pre.caCompany) && caType.equals(pre.caType)){
                    double	dActualAward = 0;
                    dActualAward = pre.dAward * (1 + pre.dPlusRate);
                    if (dAward < dActualAward) {
                        break;
                    }
                    else {
                        temp = pre;
                        caFindId = true;
                    }
                }
            }
        }
        else if (Const.SB.equals(caCompany)){
            if (SB_Num == 0)
                return;
            for (PlusRateEntity pre :SB_PlusRate) {
                if (caCompany.equals(pre.caCompany) && caType.equals(pre.caType)){
                    double	dActualAward = 0;
                    dActualAward = pre.dAward * (1 + pre.dPlusRate);
                    if (dAward < dActualAward) {
                        break;
                    }
                    else {
                        temp = pre;
                        caFindId = true;
                    }
                }
            }
        }
        else if (Const.BET.equals(caCompany)){
            if (Bet_Num == 0)
                return;
            for (PlusRateEntity pre :Bet_PlusRate) {
                if (caCompany.equals(pre.caCompany) && caType.equals(pre.caType)){
                    double	dActualAward = 0;
                    dActualAward = pre.dAward * (1 + pre.dPlusRate);
                    if (dAward < dActualAward) {
                        break;
                    }
                    else {
                        temp = pre;
                        caFindId = true;
                    }
                }
            }
        }
        if (caFindId)
            ptPlusRate= temp;
    }

    public void FindMaxAward(String caCompany, String caType, PlusRateEntity ptPlusRate) {

        PlusRateEntity temp = null;
        boolean caFindId = false;
        int		iNum = 0;

        if (Const.DOMESTIC.equals(caCompany)){
            if (Domestic_Num == 0)
                return;
            for (PlusRateEntity pre :Domestic_PlusRate) {
                if (caCompany.equals(pre.caCompany) && caType.equals(pre.caType)){
                    temp = pre;
                    caFindId = true;
                }
            }
        }
        else if (Const.SB.equals(caCompany)){
            if (SB_Num == 0)
                return;
            for (PlusRateEntity pre :SB_PlusRate) {
                if (caCompany.equals(pre.caCompany) && caType.equals(pre.caType)){
                    temp = pre;
                    caFindId = true;
                }
            }
        }
        else if (Const.BET.equals(caCompany)){
            if (Bet_Num == 0)
                return;
            for (PlusRateEntity pre :Bet_PlusRate) {
                if (caCompany.equals(pre.caCompany) && caType.equals(pre.caType)){
                    temp = pre;
                    caFindId = true;
                }
            }
        }
        if (caFindId)
            ptPlusRate= temp;
    }

    public void Output(){
        for (PlusRateEntity pre :Domestic_PlusRate) {
            System.out.println(pre.caCompany+","+pre.caType+","+pre.dAward+","+pre.dPlusRate);
        }
        for (PlusRateEntity pre :SB_PlusRate) {
            System.out.println(pre.caCompany+","+pre.caType+","+pre.dAward+","+pre.dPlusRate);
        }
        for (PlusRateEntity pre :Bet_PlusRate) {
            System.out.println(pre.caCompany+","+pre.caType+","+pre.dAward+","+pre.dPlusRate);
        }
    }

}
