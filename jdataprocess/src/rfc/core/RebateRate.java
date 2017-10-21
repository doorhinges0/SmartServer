package rfc.core;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import rfc.common.Const;
import rfc.common.ResourceUtils;
import rfc.entity.RebateRateEntity;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2017/10/21.
 */
public class RebateRate {

    private String m_RebateRateFile;
    private List<RebateRateEntity> Domestic_RebateRate;
    private List<RebateRateEntity> SB_RebateRate;
    private List<RebateRateEntity>  Bet_RebateRate;
    private int  Domestic_Num;
    private int  SB_Num;
    private int  Bet_Num;

    public RebateRate(String caRateFile){
        m_RebateRateFile = caRateFile;
        Domestic_Num = 0;
        SB_Num = 0;
        Bet_Num = 0;
    }

    public int GetRecord(){
        RebateRateEntity pre = new RebateRateEntity();
        List<RebateRateEntity> preList = new ArrayList<RebateRateEntity>();
        int			iNum = 0;

        String	SB_Values = null ;
        String	Bet_Values = null ;
        File file = null;
        try {
            file = ResourceUtils.getFile(m_RebateRateFile);

            if (!file.exists()){
                System.out.println("RebateRate文件不存在: "+ m_RebateRateFile);
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
                pre.dDepRate = Double.valueOf(words[2]);
                pre.caRebateType = words[3];
                pre.dRebate = Double.valueOf(words[4]);

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

        //  排序: order by caCompany, caType asc
        Collections.sort(preList,  new  Comparator() {
            public   int  compare(Object  o1, Object o2) {
                RebateRateEntity e1=(RebateRateEntity)o1;
                RebateRateEntity e2=(RebateRateEntity)o2;

                if (e1.caCompany.equals(e2.caCompany)){
                    return e1.caType.compareTo(e2.caType);
                }
                else
                    return e1.caCompany.compareTo(e2.caCompany);
            }
        });

        for (RebateRateEntity plusRateEntity :preList) {
            Domestic_RebateRate.add(plusRateEntity);
            Domestic_Num++;
        }
        for (RebateRateEntity plusRateEntity :preList) {
            SB_RebateRate.add(plusRateEntity);
            SB_Num++;
        }
        for (RebateRateEntity plusRateEntity :preList) {
            Bet_RebateRate.add(plusRateEntity);
            Bet_Num++;
        }

        return 0;
    }



    public void FindRecord(String caCompany, String caType, RebateRateEntity ptRebateRate){
        RebateRateEntity temp = null;
        boolean caFindId = false;
        int		iNum = 0;

        if (Const.DOMESTIC.equals(caCompany)){
            if (Domestic_Num == 0)
                return;
            for (RebateRateEntity pre :Domestic_RebateRate) {
                if (caCompany.equals(pre.caCompany) && caType.equals(pre.caType)){
                    temp = pre;
                    caFindId = true;
                }
            }
        }
        else if (Const.SB.equals(caCompany)){
            if (SB_Num == 0)
                return;
            for (RebateRateEntity pre :SB_RebateRate) {
                if (caCompany.equals(pre.caCompany) && caType.equals(pre.caType)){
                    temp = pre;
                    caFindId = true;
                }
            }
        }
        else if (Const.BET.equals(caCompany)){
            if (Bet_Num == 0)
                return;
            for (RebateRateEntity pre :Bet_RebateRate) {
                if (caCompany.equals(pre.caCompany) && caType.equals(pre.caType)){
                    temp = pre;
                    caFindId = true;
                }
            }
        }
        if (caFindId)
            ptRebateRate= temp;
    }

    public void Output(){
        for (RebateRateEntity pre :Domestic_RebateRate) {
            System.out.println(pre.caCompany+","+pre.caType+","+pre.dDepRate+","+pre.caRebateType+","+pre.dRebate);
        }
        for (RebateRateEntity pre :SB_RebateRate) {
            System.out.println(pre.caCompany+","+pre.caType+","+pre.dDepRate+","+pre.caRebateType+","+pre.dRebate);
        }
        for (RebateRateEntity pre :Bet_RebateRate) {
            System.out.println(pre.caCompany+","+pre.caType+","+pre.dDepRate+","+pre.caRebateType+","+pre.dRebate);
        }
    }

}
