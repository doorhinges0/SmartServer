package rfc.entity;

/**
 * Created by Administrator on 2017/6/24.
 */
public class InitDataEntity {
    public String 			td_id;
    public String 			tsb_id;
    public String 			tbet_id;
    public DomesticDataEntity[]	 td = new DomesticDataEntity[2];
    public AbroadDataEntity	tsb;
    public AbroadDataEntity	tbet;

}
