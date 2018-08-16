package components.dtos.users;

import java.util.List;
import components.dtos.CommentDTO;
import components.dtos.business.LocationDTO;
import components.dtos.ranking.RankingDTO;
import components.dtos.recommendation.DishRecommendationDTO;
import components.dtos.recommendation.MenuRecommendationDTO;
import components.dtos.recommendation.RestaurantRecommendationDTO;
import components.dtos.vote.DishVoteDTO;
import components.dtos.vote.MenuVoteDTO;
import components.dtos.vote.RestaurantVoteDTO;


public class ClientDTO extends UserDTO{

	
	private LocationDTO locationDTO;
	private RankingDTO rankingDTO;
	private List<ClientDTO> friendsDTO;
	private List<DishVoteDTO> dishVotesDTO;
	private List<MenuVoteDTO> menuVotesDTO;
	private List<RestaurantVoteDTO> restaurantVotesDTO;
	private List<CommentDTO> commentsDTO;
	private List<DishRecommendationDTO> dishRecommendationsDTO;
	private List<MenuRecommendationDTO> menuRecommendationsDTO;
	private List<RestaurantRecommendationDTO> restaurantRecommendationsDTO;
	
	
	public LocationDTO getLocationDTO() {return locationDTO;}
	public void setLocationDTO(LocationDTO locationDTO) {this.locationDTO = locationDTO;}
	
	public RankingDTO getRankingDTO() {return rankingDTO;}
	public void setRankingDTO(RankingDTO rankingDTO) {this.rankingDTO = rankingDTO;}
	
	public List<ClientDTO> getFriendsDTO() {return friendsDTO;}
	public void setFriendsDTO(List<ClientDTO> friendsDTO) {this.friendsDTO = friendsDTO;}
	
	public List<DishVoteDTO> getDishVotesDTO() {return dishVotesDTO;}
	public void setDishVotesDTO(List<DishVoteDTO> dishVotesDTO) {this.dishVotesDTO = dishVotesDTO;}
	
	public List<MenuVoteDTO> getMenuVotesDTO() {return menuVotesDTO;}
	public void setMenuVotesDTO(List<MenuVoteDTO> menuVotesDTO) {this.menuVotesDTO = menuVotesDTO;}
	
	public List<RestaurantVoteDTO> getRestaurantVotesDTO() {return restaurantVotesDTO;}
	public void setRestaurantVotesDTO(List<RestaurantVoteDTO> restaurantVotesDTO) {this.restaurantVotesDTO = restaurantVotesDTO;}
	
	public List<CommentDTO> getCommentsDTO() {return commentsDTO;}
	public void setCommentsDTO(List<CommentDTO> commentsDTO) {this.commentsDTO = commentsDTO;}
	
	public List<DishRecommendationDTO> getDishRecommendationsDTO() {return dishRecommendationsDTO;}
	public void setDishRecommendationsDTO(List<DishRecommendationDTO> dishRecommendationsDTO) {this.dishRecommendationsDTO = dishRecommendationsDTO;}
	
	public List<MenuRecommendationDTO> getMenuRecommendationsDTO() {return menuRecommendationsDTO;}
	public void setMenuRecommendationsDTO(List<MenuRecommendationDTO> menuRecommendationsDTO) {this.menuRecommendationsDTO = menuRecommendationsDTO;}
	
	public List<RestaurantRecommendationDTO> getRestaurantRecommendationsDTO() {return restaurantRecommendationsDTO;}
	public void setRestaurantRecommendationsDTO(List<RestaurantRecommendationDTO> restaurantRecommendationsDTO) {this.restaurantRecommendationsDTO = restaurantRecommendationsDTO;}
}
