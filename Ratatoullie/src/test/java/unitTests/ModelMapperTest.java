package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import components.dtos.CategoryDTO;
import model.business.Category;

class ModelMapperTest {

	private ModelMapper modelMapper = new ModelMapper();
	
	@Test
	void convertEntityToDTO() {
		Category category = new Category();
		category.setOid(Long.valueOf(1));
		category.setName("A name for the category");
		
		CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
		assertEquals(category.getName(),categoryDTO.getName());
		assertEquals(category.getOid(), categoryDTO.getOid());
	}
	
	@Test
	void convertDTOtoEntity() {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setOid(Long.valueOf(1));
		categoryDTO.setName("A name for the category");
		
		Category category = modelMapper.map(categoryDTO, Category.class);
		assertEquals(category.getName(),categoryDTO.getName());
		assertEquals(category.getOid(), categoryDTO.getOid());
	}


}
