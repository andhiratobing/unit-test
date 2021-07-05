package unit.test

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll

class BeforeAfterAll {

    /*Membuat function static atau object function*/
    companion object{
        @BeforeAll
        @JvmStatic
        fun beforeAll(){
            println("Sebelum semua dieksekusi")
        }

        @AfterAll
        @JvmStatic
        fun afterAll(){
            println("Setelah semua dieksekusi")
        }
    }
}