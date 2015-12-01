package sohail_login.login_node.API;

import retrofit.Call;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Sohail on 11/30/15.
 */
public interface ApiInterface {


    //Create Account
    @POST("/account/create/{bank-id}")
    Call<CreateAccount> CREATE_ACCOUNT_CALL(@Path("bank-id") String bankid, @Query("ssn") String ssn,
                                            @Query("name") String Name, @Query("email") String Email);
    //Change Password
    @POST("/account/password/{email}")
    Call<ChangePassword> CHANGE_PASSWORD_CALL(@Path("email") String email, @Query("old-password") String oldPassword,
                                            @Query("new-password") String NewPassword);
    //Change Email
    @POST("/account/email/{old-email}")
    Call<ChangeEmail> CHANGE_EMAIL_CALL(@Path("old-email") String OldEmail, @Query("password") String Password,
                                            @Query("new-Email") String NewEmail);
    //Initiate Account Deletion
    @POST("/account/delete/initiate/{email}")
    Call<InitDeletion> INIT_DELETION_CALL(@Path("email") String Email, @Query("password") String Password);

    //Confirm Account Deletion
    @POST("/account/delete/confirm/{email}")
    Call<ConfirmDeletion> CONFIRM_DELETION_CALL(@Path("email") String Email, @Query("password") String Password,@Query("token") String Token );
}
