package com.marcdev.rent_v3.controller;

import com.marcdev.rent_v3.modelDTO.RankingDto;
import com.marcdev.rent_v3.services.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RankingController.class)
class RankingControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    ArticleService articleService;
    @MockBean
    UserService userService;
    @MockBean
    RankingService rankingService;
    @MockBean
    SubscribeService subscribeService;
    @MockBean
    MessageService messageService;
    @MockBean
    CommentService commentService;

    RankingDto ranking = new RankingDto(
      1L,
      0L
    );
    @Test
    void createLikeAndDislike() throws Exception{
        mvc.perform(post("/api/setLikeAndDislike?id=1&rankingDto="+ranking))
                .andExpect(status().isOk());
    }

    @Test
    void delLikeAndDislike() throws Exception{
        mvc.perform(delete("/api/delLikeAndDislike?id=1"))
                .andExpect(status().isOk());
    }

    @Test
    void getLikes()throws Exception {
        mvc.perform(get("/api/getLike?id=1"))
                .andExpect(status().isOk());
    }

    @Test
    void getDislike() throws Exception{
        mvc.perform(get("/api/getDislike?id=1"))
                .andExpect(status().isOk());
    }
}