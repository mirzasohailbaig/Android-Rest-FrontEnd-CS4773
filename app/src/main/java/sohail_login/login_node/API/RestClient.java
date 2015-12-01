package sohail_login.login_node.API;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import java.io.IOException;
import retrofit.Retrofit;
import retrofit.GsonConverterFactory;
/**
 * Created by Sohail Baig
 */
public class RestClient {

    private static ApiInterface apiInterface;

    public static ApiInterface getClient() {
        if (apiInterface == null) {

            OkHttpClient okClient = new OkHttpClient();
            okClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());
                    return response;
                }
            });

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(Constants.Nodejs)
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface = client.create(ApiInterface.class);
        }
        return apiInterface;
    }



}
