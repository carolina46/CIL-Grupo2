package components.dtos.filter;

public class VisitorCommentFilterDTO extends CommentFilterDTO {

	@Override
	public String getName() {
		name = "Visitor Comments";
		return name;
	}

}
