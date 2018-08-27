package components.dtos.filter;

public class DenyCommentFilterDTO extends CommentFilterDTO {

	@Override
	public String getName() {
		name = "Deny Comments";
		return name;
	}

}
