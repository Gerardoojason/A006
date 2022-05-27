package id.ac.umn.app.a006

import junit.framework.TestCase
import org.junit.Test
import com.google.common.truth.Truth.assertThat
class registerverifikasiTest{
    @Test
    fun `password dan konfirmasi password berbeda`() {
        val result  = registerverifikasi.validpassword(
            "Jakarta1",
            "Jakarta2"
        )
        assertThat(result).isFalse()
    }
    @Test
    fun `password tidak memiliki 8 karakter `(){
        val result = registerverifikasi.validpassword(
            "Jak1",
            "Jak1"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password tidak memiliki minimal 1 huruf besar`(){
        val result = registerverifikasi.validpassword(
            "jakarta1",
            "jakarta1"
        )
        assertThat(result).isFalse()
    }
}