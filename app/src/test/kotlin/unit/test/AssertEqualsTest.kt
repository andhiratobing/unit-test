package unit.test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.opentest4j.TestAbortedException
import org.junit.jupiter.api.Assumptions.*
import org.junit.jupiter.api.condition.DisabledOnOs
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS
import unit.test.generator.SimpleDisplayNameGenerator

/*Mengubah nama tes otomatis menggunakan @DisplayNameGeneration*/
@DisplayNameGeneration(SimpleDisplayNameGenerator::class)
class AssertEqualsTest {

    private val calculator = Calculator()

    @Test
    @DisplayName ("Test for sum success")
    fun testSumSuccess(){
        val result = calculator.sum(20,5)
        assertEquals(25, result, "Hasilnya harusnya 25")
    }

    @Test
    @DisplayName("Test for divide success")
    fun testDivideSuccess(){
        val result = calculator.divide(10,2)
        assertEquals(5, result)
    }

    @Test
    /*Pembagian dengan nilai 0 tidak boleh (IllegalArgumentException)*/
    @DisplayName("Test for divide by zero")
    fun testDivideByZeroFailed(){
        //Assertions Exceptions
        assertThrows<IllegalArgumentException> {
            calculator.divide(10, 0)
        }
    }











}