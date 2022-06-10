package id.ac.umn.app.a006

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import com.google.firebase.auth.FirebaseAuth
import id.ac.umn.app.a006.databinding.ActivityLoginBinding

import kotlinx.android.synthetic.main.activity_main.*


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContent{
//            Column (
//                modifier =  Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//            ){
//                SimpleComposable()
////                OutLineTextFieldSample()
//                TextFieldWithIcons()
//                TextFieldAlamat()
//                TextFieldNomorHandphone()
////                ButtonWithRoundCornerShape()
//            }
//        }
//
//    }
//    @Composable
//    fun SimpleComposable() {
//        Text(
//            text = "Edit Profile",
//            style = TextStyle(color = Color.LightGray)
//
//
//        )
//    }
////    }
//
//
//    @Composable
//    fun SimpleTextField() {
//        var text by remember { mutableStateOf(TextFieldValue("")) }
//        TextField(
//            value = text,
//            onValueChange = { newText ->
//                text = newText
//            }
//        )
//    }
//
//    @Composable
//    fun OutLineTextFieldSample() {
//        var text by remember { mutableStateOf(TextFieldValue("")) }
//        OutlinedTextField(
//            value = text,
//            label = { Text(text = "Enter Your Name") },
//            onValueChange = {
//                text = it
//            }
//        )
//    }
//
//    @Composable
//    fun TextFieldWithIcons() {
//        var text by remember { mutableStateOf(TextFieldValue("")) }
//        return OutlinedTextField(
//            value = text,
//            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "emailIcon") },
//            //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
//            onValueChange = {
//                text = it
//            },
//            label = { Text(text = "name") },
//            placeholder = { Text(text = "Enter your name") },
//        )
//    }
//    @Composable
//    fun TextFieldAlamat() {
//        var text by remember { mutableStateOf(TextFieldValue("")) }
//        return OutlinedTextField(
//            value = text,
//            leadingIcon = { Icon(imageVector = Icons.Default.Home, contentDescription = "emailIcon") },
//            //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
//            onValueChange = {
//                text = it
//            },
//            label = { Text(text = "Alamat") },
//            placeholder = { Text(text = "Masukan Alamat") },
//        )
//    }
//    @Composable
//    fun TextFieldNomorHandphone() {
//        var text by remember { mutableStateOf(TextFieldValue("")) }
//        return OutlinedTextField(
//            value = text,
//            leadingIcon = { Icon(imageVector = Icons.Default.Phone, contentDescription = "emailIcon") },
//            //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
//            onValueChange = {
//                text = it
//            },
//            label = { Text(text = "Nomor Handphone") },
//            placeholder = { Text(text = "Masukan Nomor Handphone") },
//        )



        firebaseAuth = FirebaseAuth.getInstance()
        binding.txtsignup.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.emailEdit.text.toString()
            val pass = binding.passwordEdit.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            } else {
                Toast.makeText(this, "Data Tidak Lengkap ", Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun onStart() {
        super.onStart()

        if(firebaseAuth.currentUser != null){
//            val name = intent.getStringExtra("Name")
//            usernamewelcome.text = "Welcome : "+name

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}