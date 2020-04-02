package com.soft1851.music.mapper;

import com.soft1851.music.entity.Music;

import java.util.List;

public interface MusicMapper {
    /**
     * 查询所有音乐
     * @return
     */
    List<Music> selectAll();
}
