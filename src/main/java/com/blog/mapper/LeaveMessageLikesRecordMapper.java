package com.blog.mapper;

import com.blog.model.LeaveMessageLikesRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author: yujunrui
 * @Date: 2019/11/16 15:33
 * Describe: 留言点赞sql
 */
@Mapper
@Repository
public interface LeaveMessageLikesRecordMapper {

    @Select("select likeDate from leave_message_likes_record where pageName=#{pageName} and pId=#{pId} and likerId=#{likerId}")
    LeaveMessageLikesRecord isLiked(@Param("pageName") String pageName, @Param("pId") int pId, @Param("likerId") int likerId);

    @Insert("insert into leave_message_likes_record(pageName,pId,likerId,likeDate) " +
            "values(#{pageName},#{pId},#{likerId},#{likeDate})")
    void insertLeaveMessageLikesRecord(LeaveMessageLikesRecord leaveMessageLikesRecord);
}
