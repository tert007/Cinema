package dao.databaseimpl;

import dao.DaoException;
import entity.user.User;
import dao.UserDao;
import entity.user.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 23.02.2016.
 */
public class UserDatabaseDao extends Connector implements UserDao {

    private static final String tableName = "user";

    private static final String columnId = "id";
    private static final String columnType = "user_type_id";
    private static final String columnLogin = "login";
    private static final String columnPassword = "password";
    private static final String columnEmail = "email";
    private static final String columnBonus = "bonus_count";

    private static String[] columnNames = {
        columnId,
        columnType,
        columnLogin,
        columnPassword,
        columnEmail,
        columnBonus
    };

    private static UserDatabaseDao instance = new UserDatabaseDao();

    private UserDatabaseDao() {
        super();
    }

    public static UserDatabaseDao getInstance(){
        return instance;
    }


    @Override
    public User findUserById(int id) throws DaoException {
        ResultSet resultSet = null;
        try {

            resultSet = databaseController.select(UserDatabaseDao.tableName, columnNames, UserDatabaseDao.columnId + "=" + id);
            if(resultSet.next()) {
                return createUserFromResultSet(resultSet);
            }
            else return null;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<User> getUsersCollection() throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = databaseController.select(UserDatabaseDao.tableName, columnNames,null);
            return createUsersCollectionFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean addUser(User user) throws DaoException {
        try {
            return databaseController.insert(UserDatabaseDao.tableName, columnNames,user.getValues());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean updateUser(int id, User newUser) throws DaoException {
        try {
            return databaseController.update(UserDatabaseDao.tableName, columnNames,newUser.getValues(), columnId +
            "=" + id);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }


    @Override
    public boolean removeUser(int id) throws DaoException {
        try {
            return databaseController.remove(UserDatabaseDao.tableName, columnId + "=" + id);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }


    private List<User> createUsersCollectionFromResultSet(ResultSet resultSet) throws  DaoException{
        List<User> result = new ArrayList<User>();
        try {
            while (resultSet.next()) {
                result.add(this.createUserFromResultSet(resultSet));
            }
            return result;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private User createUserFromResultSet(ResultSet resultSet) throws  DaoException{
        User user = new User();
        try {
            user.setId(resultSet.getInt(columnId));

            int userTypeId = resultSet.getInt(columnType);
            UserType userType = UserTypeDatabaseDao.getInstance().findUserTypeById(userTypeId);

            user.setUserType(userType);
            user.setLogin(resultSet.getString(columnLogin));
            user.setPassword(resultSet.getString(columnPassword));
            user.setEmail(resultSet.getString(columnEmail));
            user.setBonusCount(resultSet.getInt(columnBonus));
            return user;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
