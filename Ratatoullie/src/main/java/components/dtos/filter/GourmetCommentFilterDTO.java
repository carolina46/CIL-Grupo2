package components.dtos.filter;

public class GourmetCommentFilterDTO extends CommentFilterDTO {

	public GourmetCommentFilterDTO() {

		super();
		name = "Gourmet Comments";
	}
	
	@Override
	public String getName() {
		return name;
	}

}
