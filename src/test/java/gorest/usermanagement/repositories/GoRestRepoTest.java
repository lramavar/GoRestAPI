package gorest.usermanagement.repositories;

import gorest.usermanagement.clients.GoRestClient;
import gorest.usermanagement.models.User;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Assertions;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import retrofit2.Call;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GoRestRepoTest {
    @Mock
    public GoRestClient GRC;

    // @Mock
    //public Call<List<User>> callbackUsers;

    @InjectMocks
    public GoRestRepo testGRR;


    List<User> mockUsers = new ArrayList<User>();
    User U1 = new User();

    User updatedU1 = new User();
    User U2 = new User();

    @BeforeEach
    public void setUp() throws Exception {

        U1.id = 1000;
        U1.name = "Mock User1";
        U1.email = "test@test.com";
        U1.gender = "female";
        U1.status = "Active";

        updatedU1.id = 1000;
        updatedU1.name = "Updated Mock User1";
        updatedU1.email = "test@test.com";
        updatedU1.gender = "female";
        updatedU1.status = "Active";


        U2.id = 2000;
        U2.name = "Mock User2";
        U2.email = "test@test.com";
        U2.gender = "female";
        U2.status = "Active";

        mockUsers.add(U1);
        mockUsers.add(U2);




    }

    @Test
    public void testGetUsers() throws Exception {

        Call<List<User>> callbackUsers = Mockito.mock(Call.class);
        Response res = Response.success(mockUsers);
        when(callbackUsers.execute()).thenReturn(res);
        when(GRC.listUsers(anyInt())).thenReturn(callbackUsers);

        Response<List<User>> response = testGRR.getUsers(3);
        List<User> users = response.body();
        Assertions.assertEquals(2,users.size());

    }

    @Test
    public void testGetUserById() throws Exception {

        Call<User> callbackUser = Mockito.mock(Call.class);
        Response res = Response.success(U1);
        when(callbackUser.execute()).thenReturn(res);
        when(GRC.getUser(anyInt())).thenReturn(callbackUser);

        Response<User> response = testGRR.getUserById(1000);
        User mockuser = response.body();
        Assertions.assertEquals("Mock User1",mockuser.name);

    }

    @Test
    public void testUpdateUserById() throws Exception {

        Call<User> callbackUser = Mockito.mock(Call.class);
        Response res = Response.success(updatedU1);
        when(callbackUser.execute()).thenReturn(res);
        when(GRC.updateUser(anyInt(), any(User.class))).thenReturn(callbackUser);

        Response<User> response = testGRR.updateUserById(U1.id, updatedU1);
        User mockuser = response.body();
        Assertions.assertEquals("Updated Mock User1",mockuser.name);

    }

    @Test
    public void testDeleteUserById() throws Exception {

        Call<User> callbackUser = Mockito.mock(Call.class);
        Response res = Response.success(204, U1);

        when(callbackUser.execute()).thenReturn(res);
        when(GRC.deleteUser(anyInt())).thenReturn(callbackUser);

        Response<User> response = testGRR.deleteUserById(U1.id);

        Assertions.assertEquals(204,response.code());


    }
}
