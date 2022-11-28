package gorest.usermanagement.clients;

import gorest.usermanagement.models.User;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface GoRestClient {
    @GET("/public/v2/users")
    Call<List<User>> listUsers(@Query("page") int number);

    @GET("/public/v2/users/{id}")
    Call<User> getUser(@Path("id") int id);

    @PATCH("/public/v2/users/{id}")
    Call<User> updateUser(@Path("id") int id, @Body User user);

    @DELETE("/public/v2/users/{id}")
    Call<User> deleteUser(@Path("id") int id);
}
