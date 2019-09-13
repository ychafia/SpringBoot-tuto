package fr.youness.MSAProject;

import fr.youness.MSAProject.dao.RevenuDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MsaProjectApplicationTests {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	RevenuDao revenuDao;

	@Test
	public void contextLoads() throws Exception {
		Mockito.when(revenuDao.findAll()).thenReturn(Collections.emptyList());

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/revenusapi/revenus").accept(MediaType.APPLICATION_JSON)).andReturn();

		System.out.println("#########################");
		System.out.println(mvcResult.getResponse());
		System.out.println("#########################");

		Mockito.verify(revenuDao).findAll();
	}

}
