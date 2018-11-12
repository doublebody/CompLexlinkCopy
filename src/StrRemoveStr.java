public class StrRemoveStr {
    public static void main(String[] args) {
        String s1 = "doummmisisisblebody";
        String s2= "mis";
        strRemoveStr(s1,s2);
        StringBuffer stringBuffer = new StringBuffer(s1);

    }

    public static String strRemoveStr(String str ,String subStr) {
        StringBuffer bufferStr = new StringBuffer(str);
        int i = 0;
        int flag = str.length() -1;
        while (i != flag) {
            if (i < 0) {
                i = 0;
            }
            if(bufferStr.substring(i, i+subStr.length()).equals(subStr)) {
                flag = flag - subStr.length();
                bufferStr.delete(i, i+ subStr.length());
                bufferStr.append(subStr);
                i--;
            } else {
                i++;
            }
            System.out.println(bufferStr);
        }
        System.out.println(bufferStr.substring(0,flag+1));
        return bufferStr.substring(0,flag+1);

    }
}
