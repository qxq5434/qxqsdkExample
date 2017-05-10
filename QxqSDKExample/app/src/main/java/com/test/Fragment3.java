package com.test;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.view.View;

import com.qxq.base.QxqBaseFragment;
import com.qxq.http.OnHttpCallBackListener;
import com.qxq.http.QxqHttpUtil;
import com.qxq.utils.QxqDialogUtil;
import com.qxq.utils.QxqLogUtil;
import com.qxq.utils.QxqUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/1/3.
 */
public class Fragment3 extends QxqBaseFragment {

    FileOutputStream stream = null;

    @Override
    protected int setContentView() {
        return R.layout.fragment3;
    }

    @Override
    protected void initData() {

    }
    private int i = 0;

    @Override
    public void initLayout(View view) {
        view.findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QxqHttpUtil.getInstance().get("",
                        new OnHttpCallBackListener() {
                            @Override
                            public void onComplete(String json) {
                                QxqLogUtil.getInstance().i("TAG","json..."+json);
                            }

                            @Override
                            public void onError(String error) {
                                QxqLogUtil.getInstance().i("TAG","error..."+error);
                            }
                        });
            }
        });

        view.findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QxqHttpUtil.getInstance().post("", new HashMap<String, String>(), new OnHttpCallBackListener() {
                    @Override
                    public void onComplete(String json) {
                        QxqLogUtil.getInstance().i("TAG","json..."+json);
                    }

                    @Override
                    public void onError(String error) {
                        QxqLogUtil.getInstance().i("TAG","error..."+error);
                    }
                });
            }
        });

        view.findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                QxqHttpUtil.getInstance().postToJson("your url", "your json", new OnHttpCallBackListener() {
                    @Override
                    public void onComplete(String json) {
                        QxqLogUtil.getInstance().i("TAG","json..."+json);
                    }

                    @Override
                    public void onError(String error) {
                        QxqLogUtil.getInstance().i("TAG","error..."+error);
                    }
                });
            }
        });


//        view.findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    String pathName="/sdcard/test/";
//                    String fileName="首页.txt";
//                    File path = new File(pathName);
//                    File file = new File(pathName + fileName);
//                    if( !path.exists()) {
//                        path.mkdir();
//                    }
//                    if( !file.exists()) {
//                        file.createNewFile();
//                    }
//                    stream = new FileOutputStream(file);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                new Timer().schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//                        // TODO Auto-generated method stub
//                        if(i< 87){
//                            i++;
//                            String url = "http://if.ruyubook.com/Product/Recommend/List.aspx?UN=91%E5%8D%95%E6%9C%BA%E6%B8%B8%E6%88%8F&ClassId=58&pagesize=10&pageindex="+i;
//                            get(url);
//                        }else{
//                            this.cancel();
//                        }
//                    }
//                }, 0, 1000);
//
//            }
//        });
//
//
//
//        view.findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    String pathName="/sdcard/test/";
//                    String fileName="男生小说.txt";
//                    File path = new File(pathName);
//                    File file = new File(pathName + fileName);
//                    if( !path.exists()) {
//                        path.mkdir();
//                    }
//                    if( !file.exists()) {
//                        file.createNewFile();
//                    }
//                    stream = new FileOutputStream(file);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                new Timer().schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//                        // TODO Auto-generated method stub
//                        if(i< 3){
//                            i++;
//                            String url = "http://if.ruyubook.com/Product/Recommend/List.aspx?UN=91%E5%8D%95%E6%9C%BA%E6%B8%B8%E6%88%8F&ClassId=55&pagesize=10&pageindex="+i;
//                            get(url);
//                        }else{
//                            this.cancel();
//                        }
//                    }
//                }, 0, 1000);
//
//
//            }
//        });
//
//        view.findViewById(R.id.btn6).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    String pathName="/sdcard/test/";
//                    String fileName="女生小说.txt";
//                    File path = new File(pathName);
//                    File file = new File(pathName + fileName);
//                    if( !path.exists()) {
//                        path.mkdir();
//                    }
//                    if( !file.exists()) {
//                        file.createNewFile();
//                    }
//                    stream = new FileOutputStream(file);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//
//                new Timer().schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//                        // TODO Auto-generated method stub
//                        if(i< 21){
//                            i++;
//                            String url = "http://if.ruyubook.com/Product/Recommend/List.aspx?UN=91%E5%8D%95%E6%9C%BA%E6%B8%B8%E6%88%8F&ClassId=52&pagesize=10&pageindex="+i;
//                            get(url);
//                        }else{
//                            this.cancel();
//                        }
//                    }
//                }, 0, 1000);
//
//            }
//        });
//
//        view.findViewById(R.id.btn7).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    String pathName="/sdcard/test/";
//                    String fileName="悬疑灵异.txt";
//                    File path = new File(pathName);
//                    File file = new File(pathName + fileName);
//                    if( !path.exists()) {
//                        path.mkdir();
//                    }
//                    if( !file.exists()) {
//                        file.createNewFile();
//                    }
//                    stream = new FileOutputStream(file);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                new Timer().schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//                        // TODO Auto-generated method stub
//                        if(i< 3){
//                            i++;
//                            String url = "http://if.ruyubook.com/Product/Recommend/List.aspx?UN=91%E5%8D%95%E6%9C%BA%E6%B8%B8%E6%88%8F&ClassId=53&pagesize=10&pageindex="+i;
//                            get(url);
//                        }else{
//                            this.cancel();
//                        }
//                    }
//                }, 0, 1000);
//
//            }
//        });
    }

    private void get(String url){

        QxqHttpUtil.getInstance().get(url,
                new OnHttpCallBackListener() {
                    @Override
                    public void onComplete(String json) {
                        QxqLogUtil.getInstance().i("TAG","json..."+json);
                        try {
                            JSONObject jsonObject1 = new JSONObject(json).getJSONObject("list");
                            JSONArray array = jsonObject1.getJSONArray("item");
                            for(int i = 0 ; i < array.length(); i ++){
                                JSONObject jsonObject = array.getJSONObject(i);
                                String title = jsonObject.getString("title");
                                String author = jsonObject.getString("author");
                                String tags = jsonObject.getString("tags");
                                String rec_description = jsonObject.getString("rec_description");
                                String small_cover = jsonObject.getString("small_cover");

                                String data = "标题:"+title+"\r\n作者:"+author+"\r\n标签:"+tags+"\r\n描述:"+rec_description+"\r\n图片:"+small_cover+"\r\n\r\n\r\n";
                                byte[] buffer = data.getBytes();

                                // 开始写入数据到这个文件。
                                stream.write(buffer, 0, buffer.length);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(String error) {
                        QxqLogUtil.getInstance().i("TAG","error..."+error);
                    }
                });
    }


    @Override
    public void initListener(View view) {

    }

    @Override
    public void onClick(View view) {

    }

}
