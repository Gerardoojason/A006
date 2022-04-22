package id.ac.umn.app.a006

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import id.ac.umn.app.a006.databinding.ActivityProfileBinding
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.etUsernameregister

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
//    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        auth = FirebaseAuth.getInstance()
//
//        val user = auth.currentUser
//        if (user!= null) {
//            etUsernameregister.setText(user.displayName)
//        }
        binding.btnUpdate.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"Profile sudah terupdate",Toast.LENGTH_SHORT).show()


        }

        binding.btnLogout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            Intent(this@ProfileActivity,LoginActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }

        }


    }
}