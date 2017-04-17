package com.ldb.service;

/**
 * Created by ldb on 2017/4/15.
 */
public interface LikeService {

    int getLikeCount();

    int addLike(String userIP);
}
