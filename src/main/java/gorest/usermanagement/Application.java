package gorest.usermanagement;

import gorest.usermanagement.models.User;
import gorest.usermanagement.repositories.GoRestRepo;
import okhttp3.Headers;
import retrofit2.Response;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class Application {

    private GoRestRepo GRC;
    private static final Logger LOGGER = Logger.getLogger(Application.class.getName());

    public Application(){
         GRC = new GoRestRepo();
    }
    public static void main(String[] args) {

        // Retrieve page 3 of the list of all users.
        System.out.println("1 : Page 3 list of users");
        Application app = new Application();
        List<User> users = app.getUserDetails();

        // 3 Sort the retrieved user list by name.
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        User lastuser = users.get(users.size() - 1);
        LOGGER.info("4. Last user after sorting :" + lastuser.name);

        //5. Update that user's name to a new value and use the correct http method to save it.
         User updateUser = app.updateUser(lastuser, "Test User");

        // 6. Delete that updated user
        boolean isDeleted = app.deleteUser(updateUser);

        // 7. Attempt to retrieve a nonexistent user . Log the resulting http response code.

         app.getUserById(updateUser.id);

    }

    public List<User> getUserDetails()
    {


        Response<List<User>> response = GRC.getUsers(0);


        if(response.isSuccessful()) {
            List<User> userList = response.body();
            userList.forEach(user -> System.out.println(user.toString()));
            Headers headerList = response.headers();

            // 2 Using a logger, log the total number of pages from the previous request.

            LOGGER.info("2 : Total Pages in response : "  + headerList.get("x-pagination-pages"));

          return userList;

        } else {
            System.out.println(response.errorBody());
            return  null;
        }
    }

    public User getUserById(int id)
    {

        Response<User> response = GRC.getUserById(id);

        if(response.isSuccessful()) {

            User user = response.body();
            System.out.println(user.toString());

            return user;

        } else {
            LOGGER.info("User Not Found ! \n Request failed with response code : "  + response.code());

            return  null;
        }

    }
    public User updateUser(User user, String name)
    {
        User newuser = user;

        newuser.name = name;

        Response<User> response = GRC.updateUserById(user.id, newuser);

        if(response.isSuccessful()) {
            User updatedUser = response.body();
             System.out.println(updatedUser.toString());


            // Update that user's name to a new value and use the correct http method to save it.

            LOGGER.info("5 New updated user : "  + updatedUser.name);

            return updatedUser;

        } else {

            System.out.println("error" + response.errorBody());
            return  null;
        }


    }

    public boolean deleteUser(User user)
    {

        Response<User> response = GRC.deleteUserById(user.id);

        if(response.isSuccessful()) {

            // Update that user's name to a new value and use the correct http method to save it.

            LOGGER.info("6 User with user id : "  + user.id + " was deleted.");

            return true;

        } else {

            System.out.println("error" + response.errorBody());
            return  false;
        }

    }
}