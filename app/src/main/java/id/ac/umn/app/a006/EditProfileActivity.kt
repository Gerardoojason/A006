package id.ac.umn.app.a006

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField

import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*


import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_edit_profile2)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {



            }
        }
}

    }


//
//        @Composable
//        fun SimpleComposable() {
//            Text(
//                text = "Edit Profile",
//                style = TextStyle(color = Color.LightGray)
//
//
//            )
//        }

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
//}
//    @Composable
//    fun TextFieldAlamat() {
//        var text by remember { mutableStateOf(TextFieldValue("")) }
//        return OutlinedTextField(
//            value = text,
//            leadingIcon = {
//                Icon(
//                    imageVector = Icons.Default.Home,
//                    contentDescription = "emailIcon"
//                )
//            },
//            //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
//            onValueChange = {
//                text = it
//            },
//            label = { Text(text = "Alamat") },
//            placeholder = { Text(text = "Masukan Alamat") },
//        )
//    }
//
//    @Composable
//    fun TextFieldNomorHandphone() {
//        var text by remember { mutableStateOf(TextFieldValue("")) }
//        return OutlinedTextField(
//            value = text,
//            leadingIcon = {
//                Icon(
//                    imageVector = Icons.Default.Phone,
//                    contentDescription = "emailIcon"
//                )
//            },
//            //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
//            onValueChange = {
//                text = it
//            },
//            label = { Text(text = "Nomor Handphone") },
//            placeholder = { Text(text = "Masukan Nomor Handphone") },
//        )
//
//    }
//
//    @Composable
//    fun ButtonWithRoundCornerShape() {
//        Button(onClick = {
////                         val navigate = Intent(this@EditProfile, MainActivity::class.java)
////            startActivity(navigate)
//        }, shape = RoundedCornerShape(20.dp)) {
////            context.startActivity(Intent(context, MainActivity::class.java))
//            Text(text = "Submit")
//        }
//    }

