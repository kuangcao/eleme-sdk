package com.jiabangou.eleme.pcsdk.api;

import com.jiabangou.eleme.pcsdk.PCServiceTest;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by freeway on 2016/12/11.
 */
public class CommentServiceTest extends PCServiceTest {

    @Test
    public void testGetsByShopId() {
        System.out.println(elemeClient.getCommentService().getsByShopId(1809202L, 0, 20));
    }
}
