package com.kong.task;/**
 * Created by xuebi on 2019/8/23.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @ClassName TimedTask
 * @Description TODO
 * @Author xuebi
 * @Date 2019/8/23 14:41
 * @Version 1.0
 */
@Component
public class TimedTask {

    private final String prefix= "0 0 0";

//    @Scheduled(cron = "${random.int(500)} * * * * ?")
    @Scheduled(cron = "0/${random.int[1,10]} * * * * ?")
    public void taskTask(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStr = format.format(date);
        System.out.println("当前时间为"+dateStr);
    }

//    public static void main(String[] args) {
//        BigDecimal financingInterestRate = new BigDecimal(3.87);
//        BigDecimal financingDeadline = new BigDecimal(9);
//        BigDecimal billAmount = new BigDecimal(2222);
//        BigDecimal discountInterest = financingInterestRate.multiply(financingDeadline).multiply(billAmount).divide(new BigDecimal("36000"), 2, BigDecimal.ROUND_HALF_UP);
//        System.out.println(discountInterest);
//    }

}
