package components.dtos.filter;

public class CompositeCommentFilterDTO extends CommentFilterDTO {

	public CompositeCommentFilterDTO() {
		name = "Mixed Comments";
	}
	
	@Override
	public String getName() {
		return name;
	}

}
