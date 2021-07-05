package unit.test

import org.junit.jupiter.api.Assumptions
import org.junit.jupiter.api.Test

class CancelAutomaticTest {

    /*Membatalkan unit test secara otomatis*/
    @Test
    fun testAssumptions(){
        //Jika benar
        Assumptions.assumeTrue("DEV" == System.getenv()["PROFILE"])

        //Jika salah
        println("Test not aborted")
    }

}