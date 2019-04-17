package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.Img;
import com.soft1721.jianyue.api.mapper.ImgMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2019/4/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ImgServiceImplTest {
    @Resource
    private ImgMapper imgMapper;

    @Test
    public void insertImg() {
        Img img = new Img();
        img.setaId(1);
        img.setImgs("https://cdn2.jianshu.io/assets/web/misc-logo-805143ddec2e594416e891df316a73a7.png");
        imgMapper.insertImg(img);
    }
}