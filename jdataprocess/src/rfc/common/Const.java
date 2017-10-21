package rfc.common;

/**
 * Created by Administrator on 2017/5/21.
 */
public class Const {

    //  directory
    public static final String  HOME_DIR = "d:";
    public static final String  DATA_DIR  =  "data";
    public static final String  BACKUP_DIR  =  "data_history";
    public static final String  MAIL_DIR  =  "data_mail";
    public static final String  PARAMETER_DIR  =  "data_parameter";

//  file_name
    public static final String  INDEX_FILE  =  "source_file.txt";
    public static final String  PARAMETER_FILE  =  "Parameter.txt";
    public static final String  AWARDRATE_FILE  =  "AwardRate.txt";
    public static final String  REBATERATE_FILE  =  "RebateRate.txt";
    public static final String  AVERAGE_RATE_FILE  =  "Aver_Rate.txt";
    public static final String  DOUBLE_EUROPE_FILE  =  "Double_Europe.txt";
    public static final String  DOUBLE_ASIA_FILE  =  "Double_Asia.txt";
    public static final String  SINGLE_EUROPE_FILE  =  "Single_Europe.txt";
    public static final String  SINGLE_ASIA_FILE  =  "Single_Asia.txt";
    public static final String  INCOME_FILENAME  =  "Income";
    // EXCEPTION_FILE 全局已经定义了，改成 EXCEPTIONS_FILE
    public static final String  EXCEPTIONS_FILE  =  "Exception.txt";
    public static final String  FILE_EXIST_FILE  =  "file_exist.txt";
    public static final String  MAIL_DATA_FILE  =  "mail_data.txt";
    public static final String  LOGINFO_FILE  =  "LogInfo.txt";
    public static final String  LOGERROR_FILE  =  "LogError.txt";
    public static final String  EXCEPTION_FILE  =  "Exception.txt";

//  match_type
    public static final String  SINGLE_TYPE  =  "single";
    public static final String  DOUBLE_TYPE   = "double";

//  ratio_type
    public static final String  ASIA_TYPE  =  "Asia";
    public static final String  EUROPE_TYPE   = "Europe";

//  company
    public static final String  DOMESTIC   = "domestic";
    public static final String  SB   = "SB";
    public static final String  BET  =  "Bet365";

//  rebate
    public static final String  TWORESULT  =  "WL";
    public static final String  THREERESULT  =  "WDL";
    public static final String  ALL_REBATER  =  "a";
    public static final String  NO_REBATER  =  "n";
    public static final String  WIN_STATUS   = "w";
    public static final String  LOSE_STATUS  =  "l";
    public static final String  EFFECYIVE_STATUS1  =  "e1";
    public static final String  EFFECYIVE_STATUS2  =  "e2";
    public static final Double EFFECTIVE_RATIO = 1.8;

//  profit_type
    public static final String  DOUBLE_ASIA_TYPE =   "Double_Asia";
    public static final String  DOUBLE_EUROPE_TYPE  =  "Double_Europe";
    public static final String  SINGLE_ASIA_TYPE  =  "Single_Asia";
    public static final String  SINGLE_EUROPE_TYPE  =  "Single_Europe";

//  length
    public static final Integer LEN_COMPANY =  10;
    public static final Integer LEN_TYPE  =  10;
    public static final Integer LEN_SEQ  =  10;
    public static final Integer LEN_TIME   = 20;
    public static final Integer LEN_HANDICAP  =  40;
    public static final Integer LEN_CHAR1  =  1;
    public static final Integer LEN_CHAR2  =  2;
    public static final Integer LEN_DIR  =  50;
    public static final Integer LEN_FILE  =  100;
    public static final Integer LEN_PROFIT_TYPE  =  20;

//  min_award
    public static final Integer MIN_AWARD  =  1000;

//  aver_ratio
    public static final Double AVER_RATIO = 0.9;

//  min_incomerate
    public static final Integer MIN_INCOMERATE   = 0;

//  parameter_item
    public static final String  SENDMAIL   = "SendMail";
    public static final String  CHECKTIME   = "CheckTime";
    public static final String  EFFECTIVERATIO  =  "EffectiveRatio";
    public static final String  MININCOMERATE  =  "MinIncomeRate";

//  MixData最大数量
    public static final Integer MIXDATANUMBER  =  1000;

//  SleepPeriod(单位为1毫秒)
    public static final Integer SHORTSLEEP  =  3000;
    public static final Integer LONGSLEEP = 30000;



}
