package fr.youness.MSAProject.controllers;


import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.youness.MSAProject.dao.RevenuDao;
import fr.youness.MSAProject.models.Revenu;
import fr.youness.MSAProject.services.IRevenuService;
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

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@WebMvcTest(value=RevenuController.class)
public class RevenuControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    IRevenuService revenuService;

    String URI = "/revenusapi/revenu";
    Revenu mockedRevenu = new Revenu(1L, "Sal1", 100, "Janv-19");

    @Test
    public void addRevenuTest() throws Exception {

        String mockedRevenuJson = this.mapToJson(mockedRevenu);

        Mockito.when(revenuService.updateAndSaveRevenu(Mockito.any(Revenu.class))).thenReturn(true);

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
    public void addRevenuWithfailure() throws Exception {
        String mockedRevenuJson = this.mapToJson(mockedRevenu);

        Mockito.when(revenuService.updateAndSaveRevenu(Mockito.any(Revenu.class))).thenReturn(false);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(mockedRevenuJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();

        assertThat(outputInJson).isEqualTo("Error to add new revenu");
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatus());
    }

    @Test
    public void getRevenuByIdTest() throws Exception {
        Mockito.when(revenuService.getRevenuById(1L)).thenReturn(mockedRevenu);

        URI = "/revenusapi/revenu/1";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson = this.mapToJson(mockedRevenu);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }

    @Test
    public void getRevenuByIdForbiden() throws Exception {
        Mockito.when(revenuService.getRevenuById(Mockito.any(Long.class))).thenReturn(mockedRevenu);

        URI = "/revenusapi/revenu/0";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

//        String expectedJson = this.mapToJson(mockedRevenu);
        MockHttpServletResponse response = result.getResponse();
        String outputInJson = response.getContentAsString();
        assertThat(outputInJson).isEqualTo("Private key");
        Assert.assertEquals(HttpStatus.FORBIDDEN.value(), response.getStatus());
    }

    @Test
    public void updateRevenuTest() throws Exception {
        String mockedRevenuJson = this.mapToJson(mockedRevenu);
        Mockito.when(revenuService.updateAndSaveRevenu(Mockito.any(Revenu.class))).thenReturn(true);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(URI)
                .accept(MediaType.APPLICATION_JSON).content(mockedRevenuJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();

        assertThat(outputInJson).isEqualTo("");
        Assert.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    @Test
    public void deleteRevenuTest() throws Exception {
        String mockedRevenuJson = this.mapToJson(mockedRevenu);
        Mockito.when(revenuService.deleteRevenu(Mockito.any(Long.class))).thenReturn(true);

        URI = "/revenusapi/revenu/1";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(URI).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();

        assertThat(outputInJson).isEqualTo("");
        Assert.assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
    }


    @Test
    public void deleteRevenuTestWithException() throws Exception {
        String mockedRevenuJson = this.mapToJson(mockedRevenu);
        Mockito.when(revenuService.deleteRevenu(Mockito.any(Long.class))).thenReturn(false);

        URI = "/revenusapi/revenu/1";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(URI).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();

//        assertThat(outputInJson).isEqualTo("Revenu introuvable (id=11)");
        Assert.assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
    }

    @Test
    public void getRevenuByMoisTest() throws Exception {
        List list = new ArrayList();
        list.add(mockedRevenu);
        Mockito.when(revenuService.getRevenuByMois(Mockito.any(String.class))).thenReturn(list);

        URI = "/revenusapi/revenus/mois/janv-18";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String expectedJson = this.mapToJson(list);
        String outputInJson = response.getContentAsString();

        assertThat(outputInJson).isEqualTo(expectedJson);
        Assert.assertEquals(HttpStatus.FOUND.value(), response.getStatus());
    }

    @Test
    public void getRevenuByMoisTestNotFound() throws Exception {
        List list = new ArrayList();
        Mockito.when(revenuService.getRevenuByMois(Mockito.any(String.class))).thenReturn(list);

        URI = "/revenusapi/revenus/mois/janv-19";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        //String expectedJson = this.mapToJson(list);
        String outputInJson = result.getResponse().getContentAsString();

        assertThat(outputInJson).isEqualTo("No element founded");
        Assert.assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
    }

    /**
     * Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
     */
    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}
