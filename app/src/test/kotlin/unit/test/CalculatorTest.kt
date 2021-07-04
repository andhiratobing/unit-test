package unit.test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.opentest4j.TestAbortedException
import org.junit.jupiter.api.Assumptions.*
import unit.test.generator.SimpleDisplayNameGenerator

/*Mengubah nama tes otomatis menggunakan @DisplayNameGeneration*/
@DisplayNameGeneration(SimpleDisplayNameGenerator::class)
class CalculatorTest {

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

    @Test
    /*Jika ingin menonaktifkan unit tes tambahkan anotasi @Disabled*/
    @Disabled("Sedang dikerjakan")
    fun testComingSoon(){
        // Belum selesai membuat unit tes
    }

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

    /*Membatalkan unit test secara otomatis*/
    @Test
    fun testAssumptions(){
        //Jika benar
        assumeTrue("DEV" == System.getenv()["PROFILE"])

        //Jika salah
        println("Test not aborted")
    }



}