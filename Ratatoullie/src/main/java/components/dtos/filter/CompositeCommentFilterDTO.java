package components.dtos.filter;

import java.util.ArrayList;


public class CompositeCommentFilterDTO extends CommentFilterDTO {


	private ArrayList<CommentFilterDTO> configurationFilters;

	public ArrayList<CommentFilterDTO> getConfigurationFilters() {
		return configurationFilters;
	}

	public void setConfigurationFilters(ArrayList<CommentFilterDTO> configurationFilters) {
		this.configurationFilters = configurationFilters;}

	public CompositeCommentFilterDTO() {
		name = "Mixed Comments";
	}
	
	@Override
	public String getName() {
		return name;

	}
	
	

}
