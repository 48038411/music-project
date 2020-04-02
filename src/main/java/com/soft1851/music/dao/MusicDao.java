package com.soft1851.music.dao;

import com.soft1851.music.entity.Music;

import java.util.List;

/**
 * @ClassName MusicDao
 * @Description TODO
 * @Author wangqingyuan
 * @Date 2020/4/2 &11:49
 * @Version 1.0
 **/
public interface MusicDao {
    /**
     * 批量插入
     * @param musics
     * @return int[]
     */
    int[] batchInsert(List<Music> musics);
}
