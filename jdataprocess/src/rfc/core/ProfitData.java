package rfc.core;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import rfc.common.ResourceUtils;
import rfc.entity.* ;

import java.io.File;
import java.lang.Exception;

/**
 * Created by Administrator on 2017/10/21.
 */
public class ProfitData {

    private MixDataEntity m_ptDoubleMix;
    private MixDataEntity 	m_ptSingleMix;
    private ProfitEntity  m_ptProfit;
    private int		m_DoubleMixNum;
    private int		m_SingleMixNum;
    private int		m_ProfitNum;
    private double 	m_dDoubleAverRatio;
    private double 	    m_dMinIncomeRate;
    private PlusRebateRate   m_tDoubleRate;
    private PlusRebateRate   	m_tSingleRate;
    private DirFile             m_ptDirFile;
    private ParameterEntity 	m_pCParameter;
    private HandicapEntity		m_pCHandicap;
    private PlusRateEntity		m_pCPlusRate ;
    private RebateRateEntity	m_pCRebateRate;


    public ProfitData(DirFile ptDirFile, ParameterEntity pParameter, HandicapEntity pCHandicap, PlusRateEntity  pCPlusRate , RebateRateEntity pCRebateRate){

        m_ptDirFile = ptDirFile;
        m_pCHandicap = pCHandicap;
        m_pCParameter = pParameter;
        m_pCPlusRate = pCPlusRate;
        m_pCRebateRate = pCRebateRate;
        m_DoubleMixNum = 0;
        m_SingleMixNum = 0;
        m_ProfitNum = 0;
        m_dDoubleAverRatio = 1;
        m_dMinIncomeRate = 0;
    }

    public int GetFileLineNumber(String caFileName, int iLineNumber){

        File file = null;
        int lineNumber = 0;

        try {
            file = ResourceUtils.getFile(caFileName);

            if (!file.exists()){
                System.out.println("GetFileLineNumber文件不存在: "+ caFileName);
                return -1;
            }

            LineIterator it = FileUtils.lineIterator(file, "GBK");
            while (it.hasNext()){
                lineNumber++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        iLineNumber = lineNumber;
        return 0;
    }

    public int GetDataFileName(){

        return 0;
    }
    
    public int GetDomesticData( String caString, DomesticDataEntity ptDomestic, String caTd_id, int iCharNum){

        return 0;
    }

    public int GetAbroadData( String caString, AbroadDataEntity ptAbroad, String caTd_id, int iCharNum){

        return 0;
    }

    public int GetOtherField(InitDataEntity ptData){

        return 0;
    }
    
    public int CheckData(InitDataEntity  ptData){

        return 0;
    }

    public int GetInitData(String caBuffer,  InitDataEntity  ptData){

        return 0;
    }

    public void  CheckTimeValid(DomesticDataEntity  ptData, String caValidTime, String caValidId){

    }

    public void  GetParameterRate(){

    }

    public void  GetEffectiveRebate(PlusRebateRate  ptRate, String caResultType, EffeRebateRateEntity  ptEffeRebateRate){

    }

    public int   GetOneFileData(String caDataFile, String caFileType){

        return 0;
    }

    public int   GetAverRatio(){

        return 0;
    }

    public int   GetSourceData(){

        return 0;
    }

    public void  GetBestRatioData( InitDataEntity  ptInitData, BestRatioEntity  ptBestRatio, PlusRebateRate  ptPlusRebate){

    }

    public void  CalActualProfit(ProfitEntity  ptProfit, PlusRebateRate  ptPlusRebateRate){

    }

    public void  CalTwoRatioProfit(ProfitEntity  ptProfit, PlusRebateRate  ptPlusRebateRate){

    }

    public void  CalThreeRatioProfit(ProfitEntity  ptProfit, PlusRebateRate  ptPlusRebateRate){

    }

    public void  MixLeftAsiaHandicap(ProfitEntity  ptProfit, PlusRebateRate  ptPlusRebateRate, int iHandicap, int  iProfitNum){

    }

    public void  MixRightAsiaHandicap(ProfitEntity  ptProfit, PlusRebateRate  ptPlusRebateRate, int iHandicap, int  iProfitNum){

    }

    public void  MixHandicapProfit(DomesticDataEntity  ptData, BestRatioEntity  ptRatio, PlusRebateRate  ptPlusRebateRate, ProfitEntity  ptProfit, int  iProfitNum){

    }

    public void  CommonProfit(MixDataEntity  ptMixData, PlusRebateRate  ptPlusRebateRate, ProfitEntity  ptProfit, int  iProfitNum){

    }

    public void  ProfitNegtive050(MixDataEntity  ptMixData, PlusRebateRate  ptPlusRebateRate, ProfitEntity  ptProfit, int  iProfitNum){

    }

    public void  ProfitPositive050(MixDataEntity  ptMixData, PlusRebateRate  ptPlusRebateRate, ProfitEntity  ptProfit, int  iProfitNum){

    }

    public void  ProfitHandicapDiffValue100(DomesticDataEntity  ptData, BestRatioEntity  ptRatio, PlusRebateRate  ptPlusRebateRate, ProfitEntity  ptProfit, int  iProfitNum){

    }

    public void  ProfitEqualHandicap(DomesticDataEntity  ptData, BestRatioEntity  ptRatio, PlusRebateRate  ptPlusRebateRate, ProfitEntity  ptProfit, int  iProfitNum){

    }

    public void  ProfitNegtiveOther(DomesticDataEntity  ptData, BestRatioEntity  ptRatio, PlusRebateRate  ptPlusRebateRate, ProfitEntity  ptProfit, int  iProfitNum){

    }

    public void  ProfitPositiveOther(DomesticDataEntity  ptData, BestRatioEntity  ptRatio, PlusRebateRate  ptPlusRebateRate, ProfitEntity  ptProfit, int  iProfitNum){

    }

    public void  CalEuropeRatioProfit(MixDataEntity  ptMixData, PlusRebateRate  ptPlusRebateRate, ProfitEntity  ptProfit, int  iProfitNum){

    }

    public void  CalAsiaHandicapProfit(MixDataEntity  ptMixData, PlusRebateRate  ptPlusRebateRate, ProfitEntity  ptProfit, int  iProfitNum){

    }

    public void  SortProfitByPercentDesc(ProfitEntity  ptProfit, int iNum, int  iIncomeNum){

    }

    public int   PrintfEuropeProfit(String caOutputFile, ProfitEntity  ptProfit, int iNum){

        return 0;
    }

    public int   PrintfAsiaProfit(String caOutputFile, ProfitEntity  ptProfit, int iNum){

        return 0;
    }

    public int   ProcessMixData(MixDataEntity  ptMixData, int iMixNum, PlusRebateRate  ptPlusRebateRate){

        return 0;
    }

    public int   ProcessIncomeData(){

        return 0;
    }

    public int   Run(){

        return 0;
    }


}
