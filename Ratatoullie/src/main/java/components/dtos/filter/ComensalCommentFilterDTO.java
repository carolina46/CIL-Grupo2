package components.dtos.filter;

public class ComensalCommentFilterDTO extends CommentFilterDTO {

	public ComensalCommentFilterDTO() {

		super();
		

		name = "Comensal Comments";
	}
	
	@Override
	public String getName() {
		return name;

	}

}
