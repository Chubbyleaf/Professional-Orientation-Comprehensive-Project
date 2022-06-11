package com.example.cloudprovidermaker.sys.controller;

import com.example.cloudprovidermaker.Config.QiNiuUtils;
import com.example.cloudprovidermaker.sys.service.AudioPrivateService;
import com.example.cloudprovidermaker.sys.service.WareHouseService;
import com.example.cloudprovidermaker.sys.vo.AudioGetAll;
import com.example.cloudprovidermaker.sys.vo.TxtGetAll;
import com.example.cloudprovidermaker.sys.vo.TxtUploader;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/audio")
public class AudioPrivateController {

    @Autowired
    AudioPrivateService audioPrivateService;


    // 获取所有简谱信息
    @GetMapping("/find/all/txt")
    public List<TxtGetAll> findalltxt(String userId) {
        return audioPrivateService.getalltxt(userId);
    }

    // 上传txt或MP4视频文件到七牛云，数据库中存放的是url
    @RequestMapping("loader")
    public ResponseEntity<TxtUploader> upload(@RequestParam("file") MultipartFile[] file1, @RequestParam("user") String user, @RequestParam("warehouse_id") Integer warehouse_id) throws IOException {
        MultipartFile file = file1[0];
        TxtUploader upload = new TxtUploader();
        String user_id = user;
        if (file.isEmpty()) {
            upload.setMessage( "上传失败，请选择文件" );
            upload.setResult( false );
            return new ResponseEntity<> ( upload, HttpStatus.OK );
        }
        String fileName = file.getOriginalFilename();
        String url = "";
        if (fileName.contains(".txt")) {
            try {
                InputStream fileInputStream = file.getInputStream();
                url = QiNiuUtils.upLoad(fileInputStream, fileName);
            } catch (IOException e) {
                e.printStackTrace();
                upload.setMessage( "上传失败" );
                upload.setResult( false );
                return new ResponseEntity<> ( upload, HttpStatus.OK );
            }
            audioPrivateService.newTxt(fileName,user_id,url,warehouse_id);
        }
        else if(fileName.contains(".mp4")){
            try {
                InputStream fileInputStream = file.getInputStream();
                url = QiNiuUtils.upLoad(fileInputStream, fileName);
            } catch (IOException e) {
                e.printStackTrace();
                upload.setMessage( "上传失败" );
                upload.setResult( false );
                return new ResponseEntity<> ( upload, HttpStatus.OK );
            }
            audioPrivateService.newMp4(fileName,user_id,url,warehouse_id);
        }
        else if(fileName.contains(".mp3")){
            InputStream fileInputStream = file.getInputStream();
            FFmpegFrameGrabber frameGrabber1 = new FFmpegFrameGrabber(fileInputStream);

            Frame frame = null;
            //帧录制器
            FFmpegFrameRecorder recorder = null;
            String path="D:\\2021-2022\\专综\\music\\backEnd\\";
            String p="";
            try{
                frameGrabber1.start();
                recorder = new FFmpegFrameRecorder(fileName,frameGrabber1.getAudioChannels());
                recorder.setFormat("mp3");
                recorder.setSampleRate(frameGrabber1.getSampleRate());
                recorder.setTimestamp(frameGrabber1.getTimestamp());
                recorder.setAudioQuality(0);
                recorder.start();
                while (true){
                    frame=frameGrabber1.grab();
                    if(frame==null){
                        System.out.println("视频处理完成");
                        File file11=new File(fileName);
                        p=path+file11.getName();
                        break;
                    }
                    if(frame.samples!=null){
                        recorder.recordSamples(frame.sampleRate,frame.audioChannels,frame.samples);
                    }
                }
                recorder.stop();
                recorder.release();
                frameGrabber1.stop();
            }catch (Exception e){
                e.printStackTrace();
            }
            File file3=new File(p);
            try {
                InputStream fileInputStream1 = new FileInputStream(file3);
                url = QiNiuUtils.upLoad(fileInputStream1, fileName);
            } catch (IOException e) {
                e.printStackTrace();
                upload.setMessage( "上传失败" );
                upload.setResult( false );
                return new ResponseEntity<> ( upload, HttpStatus.OK );
            }
            audioPrivateService.newMp3(fileName,user_id,url,warehouse_id);

        }
        upload.setMessage( "上传成功" );
        upload.setResult( true );
        return new ResponseEntity<> ( upload, HttpStatus.OK );

    }

    // 获取私人仓库中所有音乐mp3信息
    @GetMapping("/find/all/upload/mp3")
    public List<AudioGetAll> findallMp3(String userId) {
        return audioPrivateService.getallMp3(userId);
    }

    // 获取私人仓库中所有音乐pinaomp3信息
    @GetMapping("/find/all/upload/pmp3")
    public List<AudioGetAll> findallpMp3(String userId) {
        return audioPrivateService.getallpMp3(userId);
    }

    //根据id获取服务器上的音乐MP3
    @GetMapping("/find/mp3/byid")
    public AudioGetAll findMp3Byid(String bgm_value) {
        return audioPrivateService.findMp3Byid(bgm_value);
    }
}
