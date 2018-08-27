package components.dtos.filter;

public class VisitorCommentFilterDTO extends CommentFilterDTO {

	public VisitorCommentFilterDTO() {
		name = "Visitor Comments";
	}
	
	@Override
	public String getName() {
		return name;
	}

}
