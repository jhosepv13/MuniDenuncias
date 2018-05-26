package moviles.proyectos.munidenuncias.Services;

import java.util.List;

import moviles.proyectos.munidenuncias.Models.Denuncia;
import moviles.proyectos.munidenuncias.Models.ResponseMessage;
import moviles.proyectos.munidenuncias.Models.Usuario;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Alumno on 11/05/2018.
 */

public interface ApiService {

    String API_BASE_URL = "https://munidenuncias-jhosepv13.c9users.io";

    @GET("api/v1/denuncias")
    Call<List<Denuncia>> getDenuncias();

    @FormUrlEncoded
    @POST("/api/v1/denuncias")
    Call<ResponseMessage> createDenuncia(@Field("titulo") String titulo,
                                         @Field("usuarios_id") String usuarios_id,
                                         @Field("contenido") String contenido);
    @Multipart
    @POST("/api/v1/denuncias")
    Call<ResponseMessage> createDenunciaWithImage(
            @Part("titulo") RequestBody titulo,
            @Part("usuarios_id") RequestBody usuarios_id,
            @Part("contenido") RequestBody contenido,
            @Part MultipartBody.Part imagen
    );

    @FormUrlEncoded
    @POST("api/v1/login")
    Call<Usuario> login(@Field("username")String usuario,
                        @Field("password") String clave);
    }

