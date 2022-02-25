package com.example.mycart;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mycart.databinding.ActivityProductDetailBinding;
import com.example.mycart.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ProductDetailActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityProductDetailBinding binding;
    private ImageButton logout;
    private Button plus,minus;
    private TextView score;
    int c=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Product product =  (Product) getIntent().getExtras().getSerializable("PRODUCT");

        binding.title.setText(product.getTitle());
        binding.desc.setText(product.getDescription());
        Glide.with(this)
                .load(product.getImage())
                .into(binding.image);

        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento = new Intent(ProductDetailActivity.this,SignupActivity.class);
                startActivity(intento);

            }
        });

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        score = findViewById(R.id.score);


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++c;
                score.setText(c);

            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                --c;
                score.setText(c);

            }
        });

    }


}
