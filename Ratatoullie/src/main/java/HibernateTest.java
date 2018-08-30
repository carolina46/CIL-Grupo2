import components.services.implementations.UserServiceImpl;
import model.users.Administrator;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Administrator a = new Administrator("Superadmin", "admin", "admin");
		System.out.println(a);
		
		UserServiceImpl us = new UserServiceImpl();
		System.out.println(us);
		//if(us.getUserByUser("admin")==null) { //admin not created, proceeds to creation
			Long oid = us.saveUser(a);
			System.out.print("Usuario Administrador creado");
		//}
	}

}
