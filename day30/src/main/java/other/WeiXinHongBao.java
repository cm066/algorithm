package other;

import java.math.BigDecimal;
import java.util.concurrent.Executors;

/**
 * @author cm
 * @create 2022/3/13-3:18 下午
 */
public class WeiXinHongBao {
    public static void main(String[] args) {

        fenHOngBao(13.14,7);
    }
    public static void fenHOngBao(double money,int n){
        BigDecimal a = new BigDecimal("0.01");
        double minMoney = a.multiply(new BigDecimal(n)).doubleValue();
        BigDecimal totalMoney = new BigDecimal(String.valueOf(money));
        if(minMoney > totalMoney.doubleValue()){
            //总的钱都小于了0.01*n（总人数）说明这个红包金额是不对的
        }
        if(minMoney == totalMoney.doubleValue()){
            for(int i = 0;i < n; i++){
                //所有人平分,因为只够平分
                System.out.println(0.01);
            }
        }
        double total = 0;
        double[] scales = randomScale(n);

        BigDecimal sends = new BigDecimal(0);
        for(int i =0;i < scales.length -1;i++){
            a = totalMoney.multiply(new BigDecimal(scales[i])).setScale(2,BigDecimal.ROUND_HALF_EVEN);
            System.out.println(a);
            sends = sends.add(a);
        }
        System.out.println(totalMoney.subtract(sends));
    }
    //这里是获取每个红包的概率
    public static double[] randomScale(int n){
        double total = 0;
        double[] scales = new double[n];
        for(int i =0; i < n;i++){
            int rint = (int)(Math.random()*100)+1;
            scales[i] = rint;
            total += rint;
        }
        for(int i =0 ;i < n; i++){
            scales[i] = scales[i] / total;
        }
        return scales;
    }
}
