package br.com.orginalapp.crud;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.orginalapp.crud.entity.Pessoa;

@SpringBootTest
@AutoConfigureMockMvc
public class PessoaRepositoryIntegrationTest {

	@Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
   
    
    @Test
    void testPessoaPost() throws Exception {
    
    	Pessoa pessoa = new Pessoa("Samantha","samanthamaksoud@gmail.com");
    	
    	mockMvc.perform(post("/api/pessoas")
    	        .contentType("application/json")
    	        .content(objectMapper.writeValueAsString(pessoa)))
    	        .andExpect(status().isOk());
    }
	
}
