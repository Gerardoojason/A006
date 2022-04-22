package id.ac.umn.app.a006

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import id.ac.umn.app.a006.databinding.ActivityRegisterBinding
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
//
//        val username = binding.etUsernameregister

        binding.txtlogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignup.setOnClickListener {
            val name = binding.etUsernameregister.text.toString()
            val email = binding.etEmailregister.text.toString()
            val pass = binding.etPasswordregister.text.toString()
            val confirmPass = binding.etKonfirmasipassword.text.toString()




            if (name.isNotEmpty()&& email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent= Intent(this, MainActivity::class.java)
                            intent.putExtra("Name",name)

                                startActivity(intent)

                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()


                        }
                    }
                } else {
                    Toast.makeText(this, "Password tidak sama", Toast.LENGTH_SHORT).show()

                }
            } else {
                Toast.makeText(this, "Data Tidak Lengkap", Toast.LENGTH_SHORT).show()


            }
        }
    }


}

