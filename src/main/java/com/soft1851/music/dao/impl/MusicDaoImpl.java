package com.soft1851.music.dao.impl;


import com.soft1851.music.dao.MusicDao;
import com.soft1851.music.entity.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName MusicDaoImpl
 * @Description TODO
 * @Author wangqingyuan
 * @Date 2020/4/2 &11:49
 * @Version 1.0
 **/
@Repository
public class MusicDaoImpl implements MusicDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int[] batchInsert(List<Music> musics) {
        final List<Music> musicList = musics;
        String sql = "INSERT INTO music (id,name,author,src,img,count,type,update_time)" +
                "VALUES(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Music music = musicList.get(i);
                preparedStatement.setInt(1,music.getId());
                preparedStatement.setString(2,music.getName());
                preparedStatement.setString(3,music.getAuthor());
                preparedStatement.setString(4,music.getSrc());
                preparedStatement.setString(5,music.getImg());
                preparedStatement.setInt(6,music.getCount());
                preparedStatement.setString(7,music.getType());
                preparedStatement.setString(8,music.getUpdate_time());
            }
            @Override
            public int getBatchSize() {
                return musicList.size();
            }
        });
    }
}
