package unit.test

import org.junit.jupiter.api.Test
import org.opentest4j.TestAbortedException

class CancelManualTest {

    /*Membatalkan unit test secara manual*/
    @Test
    fun testAborted(){
        val profile = System.getenv()["PROFILE"]
        if ("DEV" !=profile){
            throw TestAbortedException()
        }else {
            println("Test not aborted")
        }
    }
}