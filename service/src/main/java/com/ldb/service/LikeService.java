package com.ldb.service;

/**
 * Created by ldb on 2017/4/15.
 */
public interface LikeService {

    Long getLikeCount();

    int addLike(String userIP);

    Long getTodayLike();
}
