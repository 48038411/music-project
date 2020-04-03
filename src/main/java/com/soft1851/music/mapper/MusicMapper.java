package com.soft1851.music.mapper;

import com.soft1851.music.entity.Music;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MusicMapper {
    /**
     * 查询所有音乐
     * @return
     */
    List<Music> selectAll();
    /**
     * 批量插入
     * @param musics
     * @return int
     */
    int batchInsert(@Param("musics")List<Music> musics);
}
