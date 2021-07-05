package unit.test

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder


/*Mengurutkan running test*/
@TestMethodOrder(value = MethodOrderer.OrderAnnotation::class)
class SortRunningTest {

    /*Mengurutkan running test*/
    @Test
    @Order(2)
    fun sampleSecond(){

    }

    /*Mengurutkan running test*/
    @Test
    @Order(3)
    fun sampleThird(){

    }

    /*Mengurutkan running test*/
    @Test
    @Order(1)
    fun sampleFirst(){

    }
}