package com.dtsjy.mdboss.common.utils.ftp;

import java.net.InetAddress;

public class Sequence {
    private static Sequence me;

    // ȡIP�����һλ�������ڼ�Ⱥ��IP�����һλ�ǲ���ͬ�ģ���ȡ����SEQҲ����ͬ
    private static final int IP;
    static {
        int ipadd;
        try {
            String hostadd = InetAddress.getLocalHost().getHostAddress();
            ipadd = Integer.parseInt(hostadd.substring(hostadd.length() - 1));
        }
        catch (Exception e) {
            ipadd = 0;
        }
        IP = ipadd;
    }

    /**
     * �����кŵĻ���������������10��N�η���һ������ֻ��ȡ�������һ�����к�
     */
    private static final int base = 10;
    private static long millis, old;

    private Sequence()
        throws Exception {
    }

    /**
     * ȡ��һ������λ����ʵ��
     */
    public static synchronized Sequence getInstance()
        throws Exception {
        if (me == null) {
            me = new Sequence();
        }
        return me;
    }

    /**
     * ȡ�����кţ����к���ʱ����أ��ǵ�ǰ�ĺ���������һ�����ظ������
     * @return ���к�
     */
    public static synchronized long getSequence()
        throws Exception {
        long result = System.currentTimeMillis();
        if (result == millis) {
            old++;
            if (old >= (millis + 1) * base) {
                throw new Exception("�Ѵﵽ�������ڵ�������к�");
            }
            result = old;
        }
        else {
            millis = result;
            result *= base;
            old = result;
        }
        return result * 10 + IP;
    }
 
}