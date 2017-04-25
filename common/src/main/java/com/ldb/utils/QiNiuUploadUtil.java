package com.ldb.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ldb on 2017/4/24.
 */
@Component
public class QiNiuUploadUtil {

    private static String BUCKET_NAME ; //要上传的空间
    private static String ACCESS_KEY ; //这两个登录七牛 账号里面可以找到
    private static String SECRET_KEY ;
    //由于Spring无法直接注入静态参数，故用set方法
    @Value("${SECRET_KEY}")
    private void setSECRET_KEY(String SECRET_KEY) {
        this.SECRET_KEY = SECRET_KEY;
    }

    @Value("${ACCESS_KEY}")
    private void setACCESS_KEY(String ACCESS_KEY) {
        this.ACCESS_KEY = ACCESS_KEY;
    }

    @Value("${BUCKET_NAME}")
    private void setBUCKET_NAME(String BUCKET_NAME){
        this.BUCKET_NAME=BUCKET_NAME;
    }

    //普通上传
    public static boolean upload(InputStream in, String key) {
        //调用put方法上传
        Response res = null;
        try {
            //密钥配置
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            //创建上传对象
            UploadManager uploadManager = new UploadManager(new Configuration());
            //获取上传策略
            String token = auth.uploadToken(BUCKET_NAME);
            res = uploadManager.put(in, key, token,null,null);
        } catch (QiniuException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return res.isOK();
    }

    public static boolean upload(byte[] data, String key){
        //调用put方法上传
        Response res = null;
        try {
            //密钥配置
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            //创建上传对象
            UploadManager uploadManager = new UploadManager(new Configuration());
            //获取上传策略
            String token = auth.uploadToken(BUCKET_NAME);
            res = uploadManager.put(data, key, token);
        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return res.isOK();
    }




}
