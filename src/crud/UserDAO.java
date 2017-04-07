package crud;

import java.util.List;

public interface UserDAO {
	public boolean addUser( User student );
    public void deleteUser( int studentId );
    public void updateUser( User student );
    public List<User> getAllUsers();
    public User getStudentById( int studentId );

}
