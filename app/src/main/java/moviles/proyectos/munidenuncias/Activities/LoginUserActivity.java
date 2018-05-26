package moviles.proyectos.munidenuncias.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import moviles.proyectos.munidenuncias.Models.Login;
import moviles.proyectos.munidenuncias.Models.Usuario;
import moviles.proyectos.munidenuncias.R;
import moviles.proyectos.munidenuncias.Services.ApiService;
import moviles.proyectos.munidenuncias.Services.ApiServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUserActivity extends AppCompatActivity {

    public static final int SIGN_IN_CODE = 777;
    private EditText user;
    private EditText pass;
    private final static String TAG = LoginUserActivity.class.getSimpleName();
    public static Usuario usuario1 = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        user = findViewById(R.id.username_input);
        pass = findViewById(R.id.password_input);

    }

    public void callLogin(View view) {

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        final String usuario = user.getText().toString();
        String clave = pass.getText().toString();

        final Login login = new Login(usuario, clave);
        Call<Usuario> call;
        call = service.login(login.getUsername(), login.getPassword());

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                try {
                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);
                    Toast.makeText(LoginUserActivity.this,"HTTP status code: " + statusCode, Toast.LENGTH_LONG).show();

                    if( response.isSuccessful()) {
                        usuario1 = response.body();
                        Intent intent = new Intent(LoginUserActivity.this,MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(LoginUserActivity.this, response.errorBody().string(), Toast.LENGTH_LONG).show();
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }
                }catch(Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(LoginUserActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(LoginUserActivity.this,"error de conexion", Toast.LENGTH_LONG).show();
            }
        });

    }
}
