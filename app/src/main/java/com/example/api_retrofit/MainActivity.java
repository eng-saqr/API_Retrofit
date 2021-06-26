package com.example.api_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit ;
    Button button ;
    EditText editText ;
    TextView textView ;
    Call<Post> call ;
    API_InterFace api_interFace ;
    int number ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.number);
        textView = findViewById(R.id.title);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Integer.parseInt(editText.getText().toString());
                if(number >=1 && number <= 100) {
                    retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build();
                    api_interFace = retrofit.create(API_InterFace.class);
                    call = api_interFace.getpost(number);
                    call.enqueue(new Callback<Post>() {
                        @Override
                        public void onResponse(Call<Post> call, Response<Post> response) {
                            textView.setText(response.body().getTitle());
                        }

                        @Override
                        public void onFailure(Call<Post> call, Throwable t) {
                            textView.setText(t.getMessage());
                        }
                    });
                    editText.setText("");
                }
                else {
                    editText.setError("false number! \n you shou;d enter number from 1 to 100");
                }
            }
        });


    }
}