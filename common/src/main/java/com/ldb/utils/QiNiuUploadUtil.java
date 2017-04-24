package com.ldb.utils;

import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ldb on 2017/4/24.
 */
public class QiNiuUploadUtil {
    static String ACCESS_KEY = "tn86cySoW7wAY2dj8T1OBCwR4UeUPAi5MXPU-4vS"; //这两个登录七牛 账号里面可以找到
    static String SECRET_KEY = "IODztoTbbgmXxiO26CxM_8o4wpLX42Q8DYu9Wj2l";
    //要上传的空间
    static String bucketname = "blog"; //填写新建的那个存储空间对象的名称

    //普通上传
    public static boolean upload(InputStream in, String key) throws IOException {
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        //创建上传对象
        UploadManager uploadManager = new UploadManager(new Configuration());
        //获取上传策略
        String token = auth.uploadToken(bucketname);
        //调用put方法上传
        Response res = uploadManager.put(in, key, token,null,null);
        return res.isOK();
    }


}
