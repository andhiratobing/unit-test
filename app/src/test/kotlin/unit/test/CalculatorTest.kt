package unit.test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

class CalculatorTest {

    val calculator = Calculator()

    @Test
    fun testSumSuccess(){
        val result = calculator.sum(20,5)
        assertEquals(25, result)
    }
}