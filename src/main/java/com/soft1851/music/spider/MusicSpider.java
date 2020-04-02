package com.soft1851.music.spider;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.music.entity.Music;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MusicSpider
 * @Description TODO
 * @Author wangqingyuan
 * @Date 2020/4/2 &10:51
 * @Version 1.0
 **/
public class MusicSpider {
    private static final Integer SUCCESS = 200;

    public static List<Music> getMusics(){
        List<Music> musics = new ArrayList<>();
        //目标地址
        String url = "https://www.bilibili.com/audio/music-service-c/web/song/of-menu?sid=10624&pn=1&ps=100";
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建get对象
        HttpGet get = new HttpGet(url);
        //创建context对象
        HttpClientContext context = HttpClientContext.create();
        //创建response对象
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get,context);
        } catch (IOException e){
            e.printStackTrace();
        }
        //如果请求成功，则获取网页源码
        if(response.getStatusLine().getStatusCode() == SUCCESS){
            HttpEntity entity = response.getEntity();
            String res = null;
            try {
                res = EntityUtils.toString(entity,"UTF-8");
            } catch (IOException e){
                e.printStackTrace();
            }

            JSONObject jsonObject = JSONObject.parseObject(res);

//            System.out.println(jsonObject);

            JSONArray list = jsonObject.getJSONObject("data").getJSONArray("data");
            System.out.println(list);
            list.forEach(o ->{
                JSONObject json = JSONObject.parseObject(o.toString());
                Music music = Music.builder()
                        .musicId(json.getInteger("id"))
                        .musicName(json.getString("title"))
                        .musicAuthor((json.getString("author")))
                        .musicSrc(json.getString("cid")) //歌曲链接
                        .musicImg(json.getString("cover"))
                        .musicCount(json.getInteger("play"))//播放次数
                        .musicType(json.getString("duration"))//歌曲类别
                        .musicTimestamp(json.getString("passtime"))//上架时间
                        .build();
                musics.add(music);
            });
        } else {
            System.out.println("请求失败");
        }
        try {
            response.close();
            httpClient.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return musics;
    }

    public static void main(String[] args) {

        System.out.println(getMusics());
    }
}
