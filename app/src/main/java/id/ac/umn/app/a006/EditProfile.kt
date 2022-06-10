//package id.ac.umn.app.a006
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Button
//import androidx.compose.material.Icon
//import androidx.compose.material.OutlinedTextField
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material.icons.filled.Phone
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.BlendMode.Companion.Color
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.unit.dp
//
//class EditProfile : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_edit_profile)
//    }
////}
////        setContent {
////            Column(
////                modifier = Modifier.fillMaxSize(),
////                verticalArrangement = Arrangement.Center,
////                horizontalAlignment = Alignment.CenterHorizontally,
////            ) {
////                SimpleComposable()
////
////                TextFieldWithIcons()
////                TextFieldAlamat()
////                TextFieldNomorHandphone()
////                ButtonWithRoundCornerShape()
////
////            }
////        }
////
////    }
////
////    @Composable
////    fun SimpleComposable() {
////        Text(
////            text = "Edit Profile",
////            style = TextStyle(color = androidx.compose.ui.graphics.Color.LightGray)
////
////
////        )
////    }
//////    }
////
////
////    @Composable
////    fun TextFieldWithIcons() {
////        var text by remember { mutableStateOf(TextFieldValue("")) }
////        return OutlinedTextField(
////            value = text,
////            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "emailIcon") },
////            //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
////            onValueChange = {
////                text = it
////            },
////            label = { Text(text = "name") },
////            placeholder = { Text(text = "Enter your name") },
////        )
////    }
////
////    @Composable
////    fun TextFieldAlamat() {
////        var text by remember { mutableStateOf(TextFieldValue("")) }
////        return OutlinedTextField(
////            value = text,
////            leadingIcon = {
////                Icon(
////                    imageVector = Icons.Default.Home,
////                    contentDescription = "emailIcon"
////                )
////            },
////            //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
////            onValueChange = {
////                text = it
////            },
////            label = { Text(text = "Alamat") },
////            placeholder = { Text(text = "Masukan Alamat") },
////        )
////    }
////
////    @Composable
////    fun TextFieldNomorHandphone() {
////        var text by remember { mutableStateOf(TextFieldValue("")) }
////        return OutlinedTextField(
////            value = text,
////            leadingIcon = {
////                Icon(
////                    imageVector = Icons.Default.Phone,
////                    contentDescription = "emailIcon"
////                )
////            },
////            //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
////            onValueChange = {
////                text = it
////            },
////            label = { Text(text = "Nomor Handphone") },
////            placeholder = { Text(text = "Masukan Nomor Handphone") },
////        )
////
////    }
////
////    @Composable
////    fun ButtonWithRoundCornerShape() {
////        Button(onClick = {
//////                         val navigate = Intent(this@EditProfile, MainActivity::class.java)
//////            startActivity(navigate)
////        }, shape = RoundedCornerShape(20.dp)) {
//////            context.startActivity(Intent(context, MainActivity::class.java))
////            Text(text = "Submit")
////        }
////    }
////}
