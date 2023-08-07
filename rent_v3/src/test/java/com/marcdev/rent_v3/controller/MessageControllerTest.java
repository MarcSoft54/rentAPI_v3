package com.marcdev.rent_v3.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.marcdev.rent_v3.modelDTO.MessageDto;
import com.marcdev.rent_v3.services.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MessageController.class)
class MessageControllerTest {


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


    MessageDto messageDto = new MessageDto(
            "same prayer",
            Timestamp.valueOf(LocalDateTime.now())
    );
    @Test
    void createMessage() throws Exception{
        mvc.perform(post("/api/setMessage?messageDto"+messageDto+"&id=1"));
    }

    @Test
    void getMesasges() throws Exception{
        mvc.perform(get("/api/getMessage?id=1"))
                .andExpect(status().isOk());
    }
}