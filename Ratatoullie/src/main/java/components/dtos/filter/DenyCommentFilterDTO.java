package components.dtos.filter;

public class DenyCommentFilterDTO extends CommentFilterDTO {

	public DenyCommentFilterDTO() {

		super();

		name = "Deny Comments";
	}
	
	@Override
	public String getName() {
		return name;

	}

}
