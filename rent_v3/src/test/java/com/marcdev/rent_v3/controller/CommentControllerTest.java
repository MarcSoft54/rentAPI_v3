package com.marcdev.rent_v3.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.marcdev.rent_v3.modelDTO.CommentDto;
import com.marcdev.rent_v3.services.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CommentController.class)
class CommentControllerTest {

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

    CommentDto cm = new CommentDto(
            "marc william"
    );
    @Test
    void createComment() throws Exception {
        mvc.perform(post("/api/setComment?commentDto="+cm+"&id=1"))
                .andExpect(status().isOk());
    }

    @Test
    void getComment() throws Exception {
        mvc.perform(get("/api/getComment"))
                .andExpect(status().isOk());
    }
}