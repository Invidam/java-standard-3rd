
import java.lang.Math; // importing java.lang package

public class Convertion {

    static String calcDemical(double dem, int target) {
        int cnt = 0;
        String str = "";
        System.out.println(dem);
        while(!(dem == 1.0 || dem == 0.0) && cnt++ < 50) {
            dem *= target;
            int rest = (int)dem;
            str = str +  rest;
            dem -= (double)rest;
            System.out.printf("=>%f\t", dem);
            System.out.printf("---%d\n", rest);

        }
        if(str.isEmpty()) str = "0";
        System.out.println("DEM: ");
        System.out.println(str);
        System.out.println("===");
        return str;

    }
    static String reverseString(String str) {
        char []arr = str.toCharArray();
        String reverseStr = "";
        for(int i=0;i<arr.length;++i) {
            reverseStr += arr[str.length() - i -1];
        }
        return reverseStr;
    }
    static String calcInteger(int numInt, int target) {
        String str = "";
        System.out.println(numInt);
        while(numInt > 0) {
            int rest = numInt % target;
            str = str + rest;
            numInt /=target;
            System.out.printf("=>%d\t", numInt);
            System.out.printf("---%d\n", rest);
        }
        if(str.isEmpty()) str = "0";
        str = reverseString(str);
        System.out.println("INT: ");
        System.out.println(str);
        return str;

    }
    static String demToTarget(double num, int target) {
        int numInt = (int)num;
        double dem = num - (double)numInt;
        String numResult = calcInteger(numInt, target);
        String demResult =calcDemical(dem,target);
        String binResult = numResult + "." + demResult;
        System.out.printf("----------------\n%f and %d \n %s\n\n-----------------\n", num,target,binResult);
        return binResult;
    }
    static int getSQRT(int num) {

        return (int)(Math.log(num) / Math.log(2));

    }
    static String byteToOther(String str,int base) {
        String otherResult = "";
        for(int i=0;i<str.length();i +=base) {
            String subStr = str.substring(i,i+base);
            int sum = 0;
            for(int j=0;j<subStr.length();++j) sum += (subStr.charAt(j) - '0') * Math.pow(2,base -j -1);
            System.out.println(sum);
            if(base >= 4 && sum >= 10) {
                otherResult += (char)('A'  + (sum - 10));
            }
            else otherResult += sum;
        }
        return otherResult;
    }
    static void binToTarget(String str, int target) {

        int base = getSQRT(target);
        String targetResult = "";
        String[] splitedNum = str.split("\\.");

        if(splitedNum.length < 1) return;

        String numStr = splitedNum[0];
        while(numStr.length() % base != 0) {
            numStr = "0" + numStr;
        }
        String demStr = splitedNum[1];
        while(demStr.length() % base != 0) {
            demStr =   demStr + "0";
        }
        System.out.printf("\n%s , %s\n",numStr,demStr);
        numStr = byteToOther(numStr,base);
        demStr = byteToOther(demStr,base);
        targetResult = numStr + "." + demStr;
        System.out.printf("----------------\n%s and %d \n %s\n\n-----------------\n", str,target,targetResult);
    }
    static void demToBinOctHex(double num) {
        String binResult = demToTarget(num,2);
        binToTarget(binResult,8);
        binToTarget(binResult,16);
    }
    public static void main(String[] args) {
        demToBinOctHex(892);
        demToBinOctHex(783.8125);
        demToBinOctHex(48.3515625);
        demToBinOctHex(0.0078125);

//        String str = "1234.5678.3123";
//        String[] arr = str.split("\\.");
//        for(int i=0;i<arr.length;++i) System.out.println(arr[i]);
    }
}


