package components.dtos;

public class NotificationDTO {
	
	private Long oid;
	private boolean readed;
	private CommentDTO commentDTO;
	
	public Long getOid() {return oid;}
	public void setOid(Long oid) {this.oid = oid;}
	
	public boolean isReaded() {return readed;}
	public void setReaded(boolean readed) {this.readed = readed;}
	
	public CommentDTO getCommentDTO() {return commentDTO;}
	public void setCommentDTO(CommentDTO commentDTO) {this.commentDTO = commentDTO;}
	
}
