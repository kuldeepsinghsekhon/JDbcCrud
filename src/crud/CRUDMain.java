package crud;

import java.util.Scanner;

public class CRUDMain {
	Scanner sc = new Scanner(System.in);
	UserDAOImp userDaoImp = new UserDAOImp();

	public int getMenu() {
		System.out.println(
				"\n==============================" + "\nPlease Enter  A Choice" + "\n==============================");
		System.out.println(" 1. Insert User ");
		System.out.println(" 2. Update User ");
		System.out.println(" 3. Delete User ");
		System.out.println(" 4. List All User ");
		System.out.println(" 0. Exit ");
		return sc.nextInt();

	}

	public void insertUser() {
		User user = new User();
		System.out.println("Enter user Email");
		user.setEmail(sc.next());
		System.out.println("Enter user name");
		user.setName(sc.next());
		System.out.println("Enter user Password");
		user.setPassord(sc.next());
		userDaoImp.addUser(user);

	}

	public void updateUser() {
		System.out.println("Enter user ID of user");
		int userId = sc.nextInt();
		User user = userDaoImp.getStudentById(userId);
		System.out.println("Enter user Email");
		user.setEmail(sc.next());
		System.out.println("Enter user name");
		user.setName(sc.next());
		System.out.println("Enter user Password");
		user.setPassord(sc.next());
		userDaoImp.updateUser(user);
	}

	public void deleteUser() {
		System.out.println("Enter user ID of user");
		int userId = sc.nextInt();
		userDaoImp.deleteUser(userId);
	}

	public void showAllUsers() {
		String s = "| %-6s| %-27s | %-27s | %-27s |";
		System.out.println(
				"===================================================================================================");
		System.out.println(String.format(s, "USERID", "EMAIL", "NAME", "PASSWORD"));
		System.out.println(
				"===================================================================================================");
		for (User user : userDaoImp.getAllUsers()) {
			System.out.println(String.format(s, user.getId(), user.getEmail(), user.getName(), user.getPassord()));

		}
		System.out.println(
				"===================================================================================================");
	}

	public void process() {
		int choice = getMenu();
		switch (choice) {
		case 1:
			insertUser();
			break;
		case 2:
			updateUser();
			break;
		case 3:
			deleteUser();
			break;
		case 4:
			showAllUsers();
			break;
		case 0:
			System.exit(0);
			break;
		default:
			System.out.println("ERROR choice not recognised");

		}
		process();
	}

	public static void main(String[] args) {
		CRUDMain crud = new CRUDMain();
		crud.process();
	}

}
