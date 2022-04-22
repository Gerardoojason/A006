package id.ac.umn.app.a006

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import id.ac.umn.app.a006.databinding.ActivityProfileBinding
import id.ac.umn.app.a006.databinding.ActivityServiceBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_profile.ivProfile
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.etUsernameregister
import kotlinx.android.synthetic.main.fragment_user.*
import java.io.ByteArrayOutputStream

class ProfileActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_CAMERA = 100
    }

    private lateinit var imageUri: Uri
    private lateinit var binding: ActivityProfileBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonStart.setOnClickListener(View.OnClickListener {
            MyService.startService(this, "Foreground Service is running...")
        })
        binding.buttonStop.setOnClickListener(View.OnClickListener {
            MyService.stopService(this)
        })




        binding.btnUpdate.setOnClickListener {

//            val image = when{
//                ::imageUri.isInitialized -> imageUri
//                user?.photoUrl = null -> Uri.parse("https://picsum.photos/seed/picsum/200/300")
//                else -> user.photoUrl
//            }
            val name = usernamewelcome.text.toString().trim()
            if (name.isEmpty()){
                usernamewelcome.error = "Isi"
                usernamewelcome.requestFocus()
                return@setOnClickListener
            }
//            UserProfileChangeRequest.Builder()
//                .setDisplayName(name)
//                .setPhotoUri(image)
//                .build().also {
//                    user?.updateProfile(it)?.
//                }
            Toast.makeText(this,"Profile sudah terupdate",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }

        binding.btnLogout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            Intent(this@ProfileActivity,LoginActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }

        }
//        auth = FirebaseAuth.getInstance()
//
//        val user =  auth.currentUser
//        if (user!= null) {
//            if (user.photoUrl !=null){
//                Picasso.get().load(user.photoUrl).into(ivProfile)
//            }else{
//                Picasso.get().load("https://picsum.photos/seed/picsum/200/300").into(ivProfile)
//            }
//            usernamewelcome.setText(user.displayName)
//
//
//        }
            ivProfile.setOnClickListener {
            intentCamera()
        }


    }
//    override fun onCreatedView(view: View, savedInstanceState: Bundle?) {
//        super.onCreatedView(view, savedInstanceState)
//        ivProfile.setOnClickListener {
//            intentCamera()
//        }
//    }
    private fun intentCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { intent ->
            packageManager?.let {
                intent.resolveActivity(it).also {
                    startActivityForResult(intent, UserFragment.REQUEST_CAMERA)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == UserFragment.REQUEST_CAMERA && resultCode == RESULT_OK) {
            val imgBitmap = data?.extras?.get("data") as Bitmap
        }
    }

    private fun uploadImage(imgBitmap: Bitmap) {
        val baos = ByteArrayOutputStream()
        val ref =
            FirebaseStorage.getInstance().reference.child("img/${FirebaseAuth.getInstance().currentUser?.uid}")

        imgBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val image = baos.toByteArray()
        ref.putBytes(image)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    ref.downloadUrl.addOnCompleteListener {
                        it.result?.let {
                            imageUri = it
                            ivProfile.setImageBitmap(imgBitmap)

                        }
                    }
                }
            }
    }



}