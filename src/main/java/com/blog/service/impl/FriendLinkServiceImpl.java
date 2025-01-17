package com.blog.service.impl;

import com.blog.mapper.FriendLinkMapper;
import com.blog.model.FriendLink;
import com.blog.model.Result;
import com.blog.service.FriendLinkService;
import com.blog.utils.ResultUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: bingo
 * @Date: 2019/11/16 17:09
 * Describe:
 */
@Service
public class FriendLinkServiceImpl implements FriendLinkService {

    @Autowired
    FriendLinkMapper friendLinkMapper;

    @Override
    public Result addFriendLink(FriendLink friendLink) {
        int id = friendLinkMapper.findIsExistByBlogger(friendLink.getBlogger());
        try {
            if(id == 0){
                friendLinkMapper.addFriendLink(friendLink);
                return ResultUtil.success(200, friendLink.getId(), "添加友链成功!");
            } else {
                return ResultUtil.success(201, id, "该友链已存在!");
            }
        } catch (Exception e){
            return ResultUtil.error(500, "更新友链失败!");
        }
    }

    @Override
    public JSONArray getAllFriendLink() {
        List<FriendLink> links = friendLinkMapper.getAllFriendLink();
        return JSONArray.fromObject(links);
    }

    @Override
    public Result updateFriendLink(FriendLink friendLink, int id) {
        try {
            friendLinkMapper.updateFriendLink(friendLink, id);
            return ResultUtil.success(202, id, "更新友链成功!");
        } catch (Exception e){
            return ResultUtil.error(500, "更新友链失败!");
        }
    }

    @Override
    public Result deleteFriendLink(int id) {
        try {
            friendLinkMapper.deleteFriendLinkById(id);
            return ResultUtil.success("删除友链成功!");
        } catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500, "删除友链失败!");
        }
    }

    @Override
    public Result getFriendLink() {
        List<FriendLink> links = friendLinkMapper.getAllFriendLink();
        return ResultUtil.success(links, "success");
    }
}
