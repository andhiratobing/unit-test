package unit.test

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class DisabledTest {

    @Test
    /*Jika ingin menonaktifkan unit tes tambahkan anotasi @Disabled*/
    @Disabled("Sedang dikerjakan")
    fun testComingSoon(){
        // Belum selesai membuat unit tes
    }

}