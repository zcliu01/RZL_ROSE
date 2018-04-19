package com.zrt.commons.ad;

import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import com.zrt.commons.AppLoginException;
 
/**
 * 使用java连接AD域,验证账号密码是否正确
 * @author Herman.Xiong
 * @date 2014-12-23 下午02:07:26
 * @version V3.0
 * @since jdk 1.6,tomcat 6.0
 */
public class AdUtils {
     
    /**
     * 使用java连接AD域
     * @author Herman.Xiong
     * @date 2014-12-23 下午02:24:04
     * @return void  
     * @throws 异常说明
     * @param host 连接AD域服务器的ip
     * @param post AD域服务器的端口
     * @param username 用户名
     * @param password 密码
     * @throws AppLoginException 
     */
    public static void connect(String host,String post,String username,String password) throws AppLoginException {
        DirContext ctx=null;
        username = username+"@zritc.com";
//        String base ="DC=zritc,DC=com";
//        String dn = "CN=" + username + "," + "OU=zritc," + base; 
//        System.out.println("dn:"+dn);
        Hashtable<String,String> HashEnv = new Hashtable<String,String>();
        HashEnv.put(Context.SECURITY_AUTHENTICATION, "simple"); // LDAP访问安全级别(none,simple,strong)
        HashEnv.put(Context.SECURITY_PRINCIPAL, username); //AD的用户名
        HashEnv.put(Context.SECURITY_CREDENTIALS, password); //AD的密码
        HashEnv.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory"); // LDAP工厂类
//        HashEnv.put("com.sun.jndi.ldap.connect.timeout", "3000");//连接超时设置为3秒
        System.out.println("ldap://" + host + ":" + post);
        HashEnv.put(Context.PROVIDER_URL, "ldap://" + host + ":" + post);// 默认端口389
        try {
            ctx = new InitialDirContext(HashEnv);// 初始化上下文
            System.out.println("身份验证成功!");
        } catch (AuthenticationException e) {
            System.out.println("用户名或密码错误!");
            e.printStackTrace();
            throw new AppLoginException("用户名或密码不正确!");
        } catch (javax.naming.CommunicationException e) {
            System.out.println("AD域连接失败!");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("身份验证未知异常!");
            e.printStackTrace();
        } finally{
            if(null!=ctx){
                try {
                    ctx.close();
                    ctx=null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
     
   /* public static void main(String[] args) {
        AdUtils.connect("192.168.11.1", "389", "004043", "123@zrt");
    }*/
}
