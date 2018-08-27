package components.dtos.filter;

public class CompositeCommentFilterDTO extends CommentFilterDTO {

	@Override
	public String getName() {
		name = "Mixed Comments";
		return name;
	}

}
