package components.dtos.filter;

public class ComensalCommentFilterDTO extends CommentFilterDTO {

	public ComensalCommentFilterDTO() {
		name = "Comensal Comments";
	}
	
	@Override
	public String getName() {
		return name;
	}

}
