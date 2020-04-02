package com.soft1851.music.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-02 10:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Music {
    private int musicId;
    private String musicName;
    private String musicAuthor;
    private String musicSrc;
    private String musicImg;
    private int musicCount;
    private String musicType;
    private String musicTimestamp;
}