package fr.youness.MSAProject.controllers;


import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.youness.MSAProject.dao.RevenuDao;
import fr.youness.MSAProject.models.Revenu;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(value=RevenuController.class)
public class RevenuControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    RevenuDao revenuDao;

    String URI = "/revenusapi/revenu";
    Revenu mockedRevenu = new Revenu(1L, "Sal1", 100, "Janv-19");

    @Test
    public void addRevenuTest() throws Exception {

        String mockedRevenuJson = this.mapToJson(mockedRevenu);

        Mockito.when(revenuDao.save(Mockito.any(Revenu.class))).thenReturn(mockedRevenu);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(mockedRevenuJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();

        assertThat(outputInJson).isEqualTo("");
        Assert.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    @Test
    public void getRevenuByIdTest() throws Exception {
//        Mockito.when(revenuDao.findAllById(1L).thenReturn(mockedRevenu);
//
//        URI = "/revenusapi/revenu/1";
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        String expectedJson = this.mapToJson(mockedRevenu);
//        String outputInJson = result.getResponse().getContentAsString();
//        assertThat(outputInJson).isEqualTo(expectedJson);

    }


    /**
     * Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
     */
    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}
