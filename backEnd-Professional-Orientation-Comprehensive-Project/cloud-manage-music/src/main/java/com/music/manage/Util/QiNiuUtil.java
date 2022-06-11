package com.music.manage.Util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Region;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class QiNiuUtil {
    private static String accessKey = "hEJx9HNSNBi0n0Dg3EpewP1ISvgorJHE3Nc7NA08";
    private static final String secretKey = "YmO9LpUg6qdZCibt68SX-LEBHhxqd16gaZwRjgGN";
    private static final String bucket = "yjx-file";
    private static final String key=null;
    private static final String domain="rcqhtityo.bkt.clouddn.com";




//    private static String accessKey = "NmOjNOnazgdOF79nFqhDVDNYcY1resjQV1X5f06E";
//    private static final String secretKey = "XTWEpwtk2OlqUG_DHrnAZF5lFQ6Xpk0XNiFm953D";
//    private static final String bucket = "labmanagement";

    /**
     * 通过文件路径上传本地文件
     * @param localFilePath 本地文件完整路径
     * @return
     */
    public static String upload(String localFilePath) {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg= new Configuration(Region.huadongZheJiang2());
        UploadManager uploadManager = new UploadManager(cfg);
        //验证七牛云身份是否认证通过
        Auth auth = Auth.create(accessKey, secretKey);
        //...生成上传凭证，然后准备上传
        String upToken= auth.uploadToken(bucket);
        try {
            //用put方法上传
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return putRet.hash;
        } catch (QiniuException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     *直接上传文件
     * @param file 上传的文件
     * @return
     */
    public static String uploadFile(MultipartFile file) {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg= new Configuration(Region.huadongZheJiang2());
        UploadManager uploadManager = new UploadManager(cfg);
        //把文件转化为字节数组
        InputStream is = null;
        ByteArrayOutputStream bos = null;

        try {
            is = file.getInputStream();
            bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = is.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            byte[] uploadBytes = bos.toByteArray();

            //验证七牛云身份是否认证通过
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken= auth.uploadToken(bucket);
            //默认上传接口回复对象
            DefaultPutRet putRet;
            //进行上传操作，传入文件的字节数组，文件名，上传空间，得到回复对象
            Response response = uploadManager.put(uploadBytes, key, upToken);
            putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return putRet.hash;
        } catch (QiniuException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 删除bucket中的文件名称
     *
     * @param fileName 文件名称
     * @return
     */
    public static boolean delete(String fileName) {
        try {
            Configuration cfg= new Configuration(Region.huadongZheJiang2());
            Auth auth = Auth.create(accessKey, secretKey);
            BucketManager bucketManager = new BucketManager(auth, cfg);
            bucketManager.delete(bucket, fileName);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}