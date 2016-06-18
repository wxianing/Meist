package com.hzwl.videoview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;

import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;
import com.hzwl.videoview.model.AppBean;
import com.hzwl.videoview.model.ResultInfo;
import com.hzwl.videoview.model.VideoBean;
import com.hzwl.videoview.model.VideoInfo;
import com.hzwl.videoview.task.HttpTask;
import com.hzwl.videoview.utils.Constant;
import com.hzwl.videoview.utils.FileUtils;
import com.hzwl.videoview.utils.HttpRequestCallBack;
import com.hzwl.videoview.utils.HttpRequestListener;
import com.hzwl.videoview.utils.HttpRequestUtils;
import com.hzwl.videoview.utils.MediaFileUtils;
import com.hzwl.videoview.view.FullScreenVideoView;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity implements MediaPlayer.OnCompletionListener {

    private FullScreenVideoView mVideoView;
    private MediaController mediaController;
    private List<File> files;
    private int position = 0;
    private ImageView imageView;
    public static List<VideoInfo> allVideoList = new ArrayList<VideoInfo>();
    private CallBack mCallBack;
    private List<AppBean.DataBean.DataListBean> mDatas = null;//服务器的视屏集合
    private Gson gson;
    private List<String> fileNames = new ArrayList<>();
    private String name;
    private File mFile;
    private int progressStatus = 0;
    private ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new HttpTask().detectionNewAppVersion(this, true, true);//检查版本更新
        initView();
        initData();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x111) {
                bar.setProgress(progressStatus);
            }
        }
    };

    private void initView() {
        mCallBack = new CallBack();
        files = new ArrayList<>();

        gson = new Gson();
        mVideoView = (FullScreenVideoView) findViewById(R.id.videoView);
        imageView = (ImageView) findViewById(R.id.imageView);

        bar = (ProgressBar) findViewById(R.id.bar);

        mediaController = new MediaController(this);

        mFile = new File(Constant.FILE_DIR);

        MediaFileUtils.getVideoFile(allVideoList, mFile);// 扫描SD卡得到视频文件集合

        mVideoView.setOnCompletionListener(this);
    }

    private void initData() {
        HashMap params = new HashMap();
        params.put("Keyword", "");
        HttpRequestUtils.send(Constant.DOWNLOAD_VIDEO_URL, params, new HttpRequestListener() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                Log.e("jsonObject>>>>>>", jsonObject.toString());
                AppBean appBean = gson.fromJson(jsonObject.toString(), AppBean.class);
                if (appBean != null) {
                    mDatas = appBean.getData().getDataList();
                    deleteFiles(mDatas);
                    downloads(mDatas);
                }
            }
        });
        selectShow(position, allVideoList);
    }

    private void deleteFiles(List<AppBean.DataBean.DataListBean> mDatas) {
        for (int i = 0; i < mDatas.size(); i++) {
            fileNames.add(mDatas.get(i).getVideoName() + FileUtils.getFileType(mDatas.get(i).getFilePath()));
        }
        for (int i = 0; i < allVideoList.size(); i++) {
            if (!fileNames.contains(allVideoList.get(i).getDisplayName())) {
                FileUtils.delFile(allVideoList.get(i).getDisplayName());
            }
        }
    }

    private void downloads(List<AppBean.DataBean.DataListBean> mDatas) {
        if (mDatas != null && mDatas.size() > 0) {
            for (int i = 0; i < mDatas.size(); i++) {
                Log.e("data", mDatas.get(i).getVideoName());
                name = mDatas.get(i).getFilePath();
                FileUtils.getFileType(name);
                String type = FileUtils.getFileType(name);
                String fileName = mDatas.get(i).getVideoName() + type;
                if (!FileUtils.isFileExist(fileName)) {
                    //下载新视频
                    HttpRequestUtils.create(MainActivity.this).download(mDatas.get(position).getFilePath(), fileName, 0, mCallBack);
                }
            }
        }
    }

    /**
     * 选择视频还是
     *
     * @param position
     */
    private void selectShow(final int position, List<VideoInfo> allVideoList) {
        if (allVideoList != null && allVideoList.size() > 0) {
            if (MediaFileUtils.isVideoFileType(allVideoList.get(position).getPath())) {
                startPlayer(allVideoList.get(position).getPath());
            } else {
                mVideoView.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
                Bitmap bitmap = BitmapFactory.decodeFile(files.get(position).getPath());
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    /**
     * 播放
     *
     * @param path
     */
    private void startPlayer(String path) {
        mediaController.hide();
        if (path != null && !path.equals("")) {
            //VideoView与MediaController进行关联
            mVideoView.setVideoPath(path);
            mVideoView.setMediaController(mediaController);
            mediaController.setMediaPlayer(mVideoView);
            //让VideiView获取焦点
            mVideoView.requestFocus();
            mVideoView.start();
        }
    }

    /**
     * 播放完毕
     *
     * @param mp
     */
    @Override
    public void onCompletion(MediaPlayer mp) {
        //播放完成回调
        if (++position < allVideoList.size()) {
            selectShow(position, allVideoList);
        } else {
            position = 0;
            selectShow(position, allVideoList);
        }
    }

    private class CallBack extends HttpRequestCallBack<File> {
        @Override
        public void onSuccess(File file, int requestCode) {
            Log.e("file", "下载完成");
            Log.e("filePath", file.getPath());
            //第一次安装时候下载完成调用这个
            if (allVideoList.size() == 0) {
                MediaFileUtils.getVideoFile(allVideoList, mFile);// 扫描SD卡得到视频文件集合
                selectShow(0, allVideoList);
            }
        }

        @Override
        public void onLoading(long total, final long current, boolean isUploading, int requestCode) {
            super.onLoading(total, current, isUploading, requestCode);
            bar.setMax((int) total);
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    progressStatus = (int) current;
                    Message m = new Message();
                    m.what = 1;
                    handler.sendMessage(m);
                }
            }.start();
        }
    }
}
