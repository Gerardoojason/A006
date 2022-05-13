package id.ac.umn.app.a006

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import id.ac.umn.app.a006.databinding.ActivityEditBinding
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EditActivity : AppCompatActivity() {



    private lateinit var binding: ActivityEditBinding


    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_prefs")
    lateinit var userManager: UserManager

    var alamat = ""
    var name = ""
    var username = ""
    var gender = ""
    var tanggal = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Get reference to our userManager class
        userManager = UserManager(dataStore)

        buttonSave()

        observeData()

    }


    private fun observeData() {


        userManager.userAlamatFlow.asLiveData().observe(this, {
            if (it != null) {
                alamat = it
                tv_alamat.text = it.toString()
            }


        })


        userManager.userNameFlow.asLiveData().observe(this, {
            if (it != null) {
                name = it
                tv_name.text = it
            }


        })


        userManager.userUsernameFlow.asLiveData().observe(this, {
            if (it != null) {
                username = it
                tv_username.text = it
            }


        })


        userManager.userGenderFlow.asLiveData().observe(this, {
            if (it != null) {
                gender = if (it) "Male" else "Female"
                tv_gender.text = gender
            }
        })
        userManager.userTanggalFlow.asLiveData().observe(this, {
            if (it != null) {
                tanggal = it
                tv_tanggal.text = it
            }


        })
    }

    private fun buttonSave() {


        //Gets the user input and saves it
        binding.btnSaveProfile.setOnClickListener {
            name =  "Nama : " +et_name.text.toString()

            username = "Username : " + et_username.text.toString()
            alamat ="Alamat : " + et_alamat.text.toString()
            val isMale = switch_gender.isChecked
            tanggal = "Tanggal : " + et_tgl.text.toString()

            //Stores the values
            GlobalScope.launch {
                userManager.storeUser(alamat, name, username, isMale,tanggal)
            }
        }


    }
}