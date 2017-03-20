package exam;

/**
 * Created by Liuqi
 * Date: 2017/3/20.
 */
public class Repleace {
   /* public String doRepleace(String str) {
        str.toCharArray()
        return str.replace(" ", "20%");
    }*/
   public String replaceSpace(StringBuffer str) {
       char[] chars=str.toString().toCharArray();
       StringBuffer sb=new StringBuffer();
       for(int i=0;i<chars.length;i++){
           if(chars[i] == ' '){
               sb.append("20%");

           }else{
               sb.append(chars[i]);
           }
       }
       return sb.toString();
   }
}
