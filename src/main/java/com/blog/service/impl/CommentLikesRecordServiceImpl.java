package com.blog.service.impl;

import com.blog.mapper.CommentLikesMapper;
import com.blog.model.CommentLikesRecord;
import com.blog.service.CommentLikesRecordService;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: blanche
 * @Date: 2019/11/12 13:47
 * Describe:
 */
@Service
public class CommentLikesRecordServiceImpl implements CommentLikesRecordService {

    @Autowired
    CommentLikesMapper commentLikesMapper;
    @Autowired
    UserService userService;

    @Override
    public boolean isLiked(long articleId, long pId, String username) {
        return commentLikesMapper.isLiked(articleId, pId, userService.findIdByUsername(username)) != null;
    }

    @Override
    public void insertCommentLikesRecord(CommentLikesRecord commentLikesRecord) {
        commentLikesMapper.insertCommentLikesRecord(commentLikesRecord);
    }

    @Override
    public void deleteCommentLikesRecordByArticleId(long articleId) {
        commentLikesMapper.deleteCommentLikesRecordByArticleId(articleId);
    }
}
