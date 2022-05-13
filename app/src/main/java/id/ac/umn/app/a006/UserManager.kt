package id.ac.umn.app.a006

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
import java.util.concurrent.Flow


//class UserManager(val dataStore: DataStore<Preferences>) {
//
//
//    //Create some keys
//    companion object {
//        val USER_NAME_KEY = stringPreferencesKey("USER_NAME")
//        val USER_USERNAME_KEY = stringPreferencesKey("USER_USERNAME")
//        val USER_ALAMAT_KEY = stringPreferencesKey("USER_ALAMAT")
//        val USER_TANGGAL_KEY = stringPreferencesKey("USER_TANGGAL")
//    }
//
//    //Store user data
//    suspend fun storeUser(nama: String, username: String, alamat: String, tanggal: String) {
//        dataStore.edit {
//            it[USER_NAME_KEY] = nama
//            it[USER_USERNAME_KEY] = username
//            it[USER_ALAMAT_KEY] = alamat
//            it[USER_TANGGAL_KEY] = tanggal
//
//        }
//    }
//
//    //Create an age flow
//    val userAgeFlow = dataStore.data.map {
//        it[USER_NAME_KEY]
//    }
//
//    //Create a fname flow
//    val userFirstNameFlow = dataStore.data.map {
//        it[USER_USERNAME_KEY]
//    }
//
//    //Create a lname flow
//    val userLastNameFlow = dataStore.data.map {
//        it[USER_ALAMAT_KEY]
//    }
//
//    //Create a gender flow
//    val userGenderFlow  = dataStore.data.map {
//        it[USER_TANGGAL_KEY]
//    }
//
//}
class UserManager(val dataStore: DataStore<Preferences>) {

    //Create some keys
    companion object {
        val USER_ALAMAT_KEY = stringPreferencesKey("USER_ALAMAT")
        val USER_NAME_KEY = stringPreferencesKey("USER_NAME")
        val USER_USERNAME_KEY = stringPreferencesKey("USER_USERNAME")
        val USER_GENDER_KEY = booleanPreferencesKey("USER_GENDER")
        val USER_TANGGAL_KEY = stringPreferencesKey("USER_TANGGAL")
    }

    //Store user data
    suspend fun storeUser(alamat: String, name: String, username: String, isMale: Boolean, tanggal :String) {
        dataStore.edit {
            it[USER_ALAMAT_KEY] = alamat
            it[USER_NAME_KEY] = name
            it[USER_USERNAME_KEY] = username
            it[USER_GENDER_KEY] = isMale
            it[USER_TANGGAL_KEY] = tanggal

        }
    }


    val userAlamatFlow= dataStore.data.map {
        it[USER_ALAMAT_KEY]
    }


    val userNameFlow = dataStore.data.map {
        it[USER_NAME_KEY]
    }


    val userUsernameFlow= dataStore.data.map {
        it[USER_USERNAME_KEY]
    }


    val userGenderFlow = dataStore.data.map {
        it[USER_GENDER_KEY]
    }
    val userTanggalFlow = dataStore.data.map {
        it[USER_TANGGAL_KEY]
    }

}