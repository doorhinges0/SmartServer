package com.fuck.mobile.util;

/**
 * Created by ASPRCK on 2016/8/15.
 */
public class AnnualRateToStr {
    static String AnnualRateToStr(long annualRate){
        return annualRate/100+"."+annualRate%100+"%";
    }
    public static void main(String args[]) {
        System.out.print(AnnualRateToStr(8787));
    }
}
