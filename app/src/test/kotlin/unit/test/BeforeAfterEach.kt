package unit.test

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

class BeforeAfterEach {

    /*Menandai setiap function yang akan dieksekusi sebelum unit test dijalankan*/
    @BeforeEach
    fun beforeEach(){
        println("Sebelum dieksekusi")
    }

    /*Menandai setiap function yang akan dieksekusi setelah unit test dijalankan*/
    @AfterEach
    fun afterEach(){
        println("Setelah dieksekusi")
    }

}