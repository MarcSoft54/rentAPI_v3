package com.marcdev.rent_v3.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.marcdev.rent_v3.modelDTO.SubscribeDto;
import com.marcdev.rent_v3.services.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@ExtendWith(SpringExtension.class)
@WebMvcTest(SubscribeController.class)
class SubscribeControllerTest {

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

    @Test
    void createSub() throws Exception{
        mvc.perform(post("/api/setSub?id=1&b=1"))
                .andExpect(status().isOk());
    }

    @Test
    void delSub() throws Exception{
        mvc.perform(delete("/api/delSub?id=1"))
                .andExpect(status().isOk());
    }

    @Test
    void getSub() throws Exception{
        mvc.perform(get("/api/getSub"))
                .andExpect(status().isOk());
    }
}