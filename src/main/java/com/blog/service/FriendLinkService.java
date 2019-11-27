package com.blog.service;

import com.blog.model.FriendLink;
import com.blog.model.Result;
import net.sf.json.JSONArray;

/**
 * @author: zhenweijin
 * @Date: 2019/11/16 17:08
 * Describe:
 */
public interface FriendLinkService {

    Result addFriendLink(FriendLink friendLink);

    JSONArray getAllFriendLink();

    Result updateFriendLink(FriendLink friendLink, int id);

    Result deleteFriendLink(int id);

    Result getFriendLink();
}
