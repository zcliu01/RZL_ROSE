package com.zrt.commons.utils;


import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.util.Arrays;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
  
import net.sourceforge.pinyin4j.PinyinHelper;  
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;  
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;  
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;  
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;  
  
/** 
 * ����תƴ�����ܴ�������� 
 *  
 *
 *  
 */  
  
public class ChineseToHanYuPYUtils {  
  
    private static Map<String, List<String>> pinyinMap = new HashMap<String, List<String>>();  
    private static long count = 0;  
  /**
    public static void main(String[] args) {  
  
        String str = "周爱娟";  
//      String str = "�������";  
          
    //    initPinyin("/duoyinzi_dic.txt");  
          
        String py = convertChineseToPinyin(str);  
        System.out.println(str+" = "+py);  
  
    }  **/
      
    /** 
     * ��ĳ���ַ���������ĸ ��д 
     * @param str 
     * @return 
     */  
    public static String convertInitialToUpperCase(String str){  
        if(str==null){  
            return null;  
        }  
        StringBuffer sb = new StringBuffer();  
        char[] arr = str.toCharArray();  
        for(int i=0;i<arr.length;i++){  
            char ch = arr[i];  
            if(i==0){  
                sb.append(String.valueOf(ch).toUpperCase());  
            }else{  
                sb.append(ch);  
            }  
        }  
          
        return sb.toString();  
    }  
  
    /** 
     * ����תƴ�� ���ƥ������ 
     * @param chinese 
     * @return 
     */  
    public static String convertChineseToPinyin(String chinese) {  
  
        StringBuffer pinyin = new StringBuffer();  
  
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();  
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
  
        char[] arr = chinese.toCharArray();  
  
        for (int i = 0; i < arr.length; i++) {  
  
            char ch = arr[i];  
  
            if (ch > 128) { // ��ASCII��  
                // ȡ�õ�ǰ���ֵ�����ȫƴ  
                try {  
  
                    String[] results = PinyinHelper.toHanyuPinyinStringArray(  
                            ch, defaultFormat);  
  
                    if (results == null) {  //������  
  
                        return "";  
                    } else {  
  
                        int len = results.length;  
  
                        if (len == 1) { // ���Ƕ�����  
  
//                          pinyin.append(results[0]);  
                            String py = results[0];       
                            if(py.contains("u:")){  //���� u:  
                                py = py.replace("u:", "v");  
                                System.out.println("filter u:"+py);  
                            }  
                            pinyin.append(convertInitialToUpperCase(py));  
                              
                        }else if(results[0].equals(results[1])){    //�Ƕ����� �ж������ȡ��һ��  
                              
//                          pinyin.append(results[0]);  
                            pinyin.append(convertInitialToUpperCase(results[0]));  
                              
                        }else { // ������  
                              
                            System.out.println("�����֣�"+ch);  
                              
                            int length = chinese.length();  
                              
                            boolean flag = false;  
                              
                            String s = null;  
                              
                            List<String> keyList =null;  
                              
                            for (int x = 0; x < len; x++) {  
                                  
                                String py = results[x];  
                                  
                                if(py.contains("u:")){  //���� u:  
                                    py = py.replace("u:", "v");  
                                    System.out.println("filter u:"+py);  
                                }  
  
                                keyList = pinyinMap.get(py);  
                                  
                                if (i + 3 <= length) {   //����ƥ��2������  ������   
                                    s = chinese.substring(i, i + 3);  
                                    if (keyList != null && (keyList.contains(s))) {  
//                                  if (value != null && value.contains(s)) {  
  
                                        System.out.println("last 2 > " + py);  
//                                      pinyin.append(results[x]);  
                                        pinyin.append(convertInitialToUpperCase(py));  
                                        flag = true;  
                                        break;  
                                    }  
                                }  
                                  
                                if (i + 2 <= length) {   //����ƥ�� 1������  ����  
                                    s = chinese.substring(i, i + 2);  
                                    if (keyList != null && (keyList.contains(s))) {  
  
                                        System.out.println("last 1 > " + py);  
//                                      pinyin.append(results[x]);  
                                        pinyin.append(convertInitialToUpperCase(py));  
                                        flag = true;  
                                        break;  
                                    }  
                                }  
                                  
                                if ((i - 2 >= 0) && (i+1<=length)) {  // ǰ��ƥ��2������ ���̴�  
                                    s = chinese.substring(i - 2, i+1);  
                                    if (keyList != null && (keyList.contains(s))) {  
                                          
                                        System.out.println("before 2 < " + py);  
//                                      pinyin.append(results[x]);  
                                        pinyin.append(convertInitialToUpperCase(py));  
                                        flag = true;  
                                        break;  
                                    }  
                                }  
                                  
                                if ((i - 1 >= 0) && (i+1<=length)) {  // ǰ��ƥ��1������   �̴�  
                                    s = chinese.substring(i - 1, i+1);  
                                    if (keyList != null && (keyList.contains(s))) {  
                                          
                                        System.out.println("before 1 < " + py);  
//                                      pinyin.append(results[x]);  
                                        pinyin.append(convertInitialToUpperCase(py));  
                                        flag = true;  
                                        break;  
                                    }  
                                }  
                                  
                                if ((i - 1 >= 0) && (i+2<=length)) {  //ǰ��1��������1��      �̴���  
                                    s = chinese.substring(i - 1, i+2);  
                                    if (keyList != null && (keyList.contains(s))) {  
                                          
                                        System.out.println("before last 1 <> " + py);  
//                                      pinyin.append(results[x]);  
                                        pinyin.append(convertInitialToUpperCase(py));  
                                        flag = true;  
                                        break;  
                                    }  
                                }  
                            }  
                              
                            if (!flag) {    //��û���ҵ���ƥ��Ĭ�ϵ� ����  ��   
                                  
                                s = String.valueOf(ch);  
                                  
                                for (int x = 0; x < len; x++) {  
                                      
                                    String py = results[x];  
                                      
                                    if(py.contains("u:")){  //���� u:  
                                        py = py.replace("u:", "v");  
                                        System.out.println("filter u:");  
                                    }  
                                      
                                    keyList = pinyinMap.get(py);  
                                      
                                    if (keyList != null && (keyList.contains(s))) {  
                                          
                                        System.out.println("default = " + py);  
//                                      pinyin.append(results[x]);  //�������Ҫƴ������ĸ��д ��ֱ�ӷ��ؼ���  
                                        pinyin.append(convertInitialToUpperCase(py));//ƴ������ĸ ��д  
                                        break;  
                                    }  
                                }  
                            }  
                        }  
                    }  
  
                } catch (BadHanyuPinyinOutputFormatCombination e) {  
                    e.printStackTrace();  
                }  
            } else {  
                pinyin.append(arr[i]);  
            }  
        }  
        return pinyin.toString();  
    }  
  
    /** 
     * ��ʼ�� ���еĶ����ִ��� 
     *  
     * @param fileName 
     */  
    public static void initPinyin(String fileName) {  
        // ��ȡ�����ֵ�ȫ��ƴ����;  
        InputStream file = PinyinHelper.class.getResourceAsStream(fileName);  
  
        BufferedReader br = new BufferedReader(new InputStreamReader(file));  
  
        String s = null;  
        try {  
            while ((s = br.readLine()) != null) {  
  
                if (s != null) {  
                    String[] arr = s.split("#");  
                    String pinyin = arr[0];  
                    String chinese = arr[1];  
  
                    if(chinese!=null){  
                        String[] strs = chinese.split(" ");  
                        List<String> list = Arrays.asList(strs);  
                        pinyinMap.put(pinyin, list);  
                    }  
                }  
            }  
  
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally{  
            try {  
                br.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}  