package acquisition.run;

import acquisition.context.Context;
import acquisition.output.OutPut;
import acquisition.timer.AcquisitionTimerTask;


import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Copyrights @ 2011,Tianyuan DIC Information Co.,Ltd. All rights reserved.<br>
 *
 * @author 张伟
 * @description 采集程序入口
 * @date 2014-05-30 10:08
 */
public class Run {
    public static void main(String[] args) {
        Context context = Context.getContext();
        Timer timer = new Timer();
        long timerInterval = Long.parseLong(context.getConfig("program.interval", "60")) * 1000 * 60;
        AcquisitionTimerTask timerTask = new AcquisitionTimerTask();
        timerTask.setContext(context);
        timer.scheduleAtFixedRate(timerTask, 0, timerInterval);
//        System.out.println("aa");

    }
}
