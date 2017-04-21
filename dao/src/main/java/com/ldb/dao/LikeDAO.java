package com.ldb.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by ldb on 2017/4/15.
 */
public interface LikeDAO {

    Long getLikeCount();

    int addLike(@Param("userIP")String userIP);

    Long getTodayLike(@Param("today") String today);
}
