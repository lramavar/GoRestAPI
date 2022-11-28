package gorest.usermanagement.interceptors;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OAuthInterceptor implements Interceptor {

    private String token;

    public OAuthInterceptor(String token) {
        this.token = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest  = chain.request().newBuilder()
                .addHeader("Authorization", token)
                .build();

        return chain.proceed(newRequest);
    }
}
