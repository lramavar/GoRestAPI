package gorest.usermanagement.repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gorest.usermanagement.clients.GoRestClient;
import gorest.usermanagement.interceptors.OAuthInterceptor;
import gorest.usermanagement.models.User;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class GoRestRepo  {

    static final String BASE_URL = "https://gorest.co.in";
    public Gson gson;
    public Retrofit retrofit;

    public GoRestClient GRC;

     public GoRestRepo() {
          String token = "Bearer " + "4b9f93d630ba3b42684b77fff5612c81a80632712b51a596ebb39c5d13c8c8ed";

          OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new OAuthInterceptor(token)).build();

          gson = new GsonBuilder()
                  .setLenient()
                  .create();

          retrofit = new Retrofit.Builder()
                  .baseUrl(BASE_URL)
                  .client(client)
                  .addConverterFactory(GsonConverterFactory.create(gson))
                  .build();


          GRC = retrofit.create(GoRestClient.class);
     }


    public Response<List<User>> getUsers(int number) {

        Call<List<User>> call = GRC.listUsers(number);
        try {
            Response<List<User>> res = call.execute();
            return res;
        } catch (Exception ex) {
            return null;
        }
    }

    public Response<User> getUserById(int userid)
    {
        Call<User> call = GRC.getUser(userid);
        try{
            Response<User> res = call.execute();
            return res;

        }
        catch(Exception ex)
        {
            return null;
        }
    }

    public Response<User> updateUserById(int userid , User user)
    {
        Call<User> call = GRC.updateUser(userid, user);
        try{
            Response<User> res = call.execute();
            return res;

        }
        catch(Exception ex)
        {
            return null;
        }
    }

    public Response<User> deleteUserById(int userid)
    {
        Call<User> call = GRC.deleteUser(userid);
        try{
            Response<User> res = call.execute();
            return res;

        }
        catch(Exception ex)
        {
            return null;
        }
    }




}
