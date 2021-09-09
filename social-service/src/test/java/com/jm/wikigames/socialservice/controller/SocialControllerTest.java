package com.jm.wikigames.socialservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jm.wikigames.socialservice.model.Social;
import com.jm.wikigames.socialservice.service.SocialService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SocialController.class)
class SocialControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SocialService socialService;

    private MvcResult mvcResult;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetSocialByIdWithIncrementTrue() throws Exception {

        Social social = new Social(2L, 1L);

        when(socialService.incrementSocialCount(1L, true)).thenReturn(social);

        String URL = "/1";

        mvcResult = mockMvc.perform(get(URL, 1)
                .param("increment", String.valueOf(true)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count").value(2L))
                .andExpect(jsonPath("$.gameItemId").value(1L))
                .andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedJsonResponse = objectMapper.writeValueAsString(social);

        assertThat(actualJsonResponse).isEqualToNormalizingWhitespace(expectedJsonResponse);


    }

    @Test
    void testGetSocialByIdWithIncrementFalse() throws Exception {

        Social social = new Social(2L, 1L);

        when(socialService.incrementSocialCount(1L, false)).thenReturn(social);

        String URL = "/1";

        mvcResult = mockMvc.perform(get(URL, 1)
                        .param("increment", String.valueOf(false)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count").value(2L))
                .andExpect(jsonPath("$.gameItemId").value(1L))
                .andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedJsonResponse = objectMapper.writeValueAsString(social);

        assertThat(actualJsonResponse).isEqualToNormalizingWhitespace(expectedJsonResponse);


    }
}