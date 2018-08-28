package components.dtos.filter;

public class VisitorCommentFilterDTO extends CommentFilterDTO {

	public VisitorCommentFilterDTO() {

		super();

		name = "Visitor Comments";
	}
	
	@Override
	public String getName() {
		return name;

	}

}
