package com.soft1721.jianyue.api.controller;

import com.soft1721.jianyue.api.entity.Comment;
import com.soft1721.jianyue.api.entity.Follow;
import com.soft1721.jianyue.api.entity.vo.ArticleVO;
import com.soft1721.jianyue.api.entity.vo.CommentVO;
import com.soft1721.jianyue.api.service.ArticleService;
import com.soft1721.jianyue.api.service.CommentService;
import com.soft1721.jianyue.api.service.FollowService;
import com.soft1721.jianyue.api.util.MsgConst;
import com.soft1721.jianyue.api.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/10.
 */
@RestController
@RequestMapping(value = "/api/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    @PostMapping("/add")
    public ResponseResult addComment(@RequestParam("aId") int aId, @RequestParam("uId") int uId, @RequestParam("content") String content) {
        Comment comment = new Comment();
        comment.setaId(aId);
        comment.setuId(uId);
        comment.setContent(content);
        comment.setCommentTime(new Date());
        commentService.addComment(comment);
        return ResponseResult.success();
    }
}
