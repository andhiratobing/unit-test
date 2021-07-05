package unit.test

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.*
import kotlin.math.min

class ConditionalTest {


    /*Test berdasarkan kondisi enabled OS*/
    @Test
    @EnabledOnOs(value = [OS.LINUX])
    fun canRunOS(){
        //Code
    }

    /*Test berdasarkan kondisi disable OS*/
    @Test
    @DisabledOnOs(value = [OS.WINDOWS])
    fun cannotRunOS(){
        //Code
    }

    /*Test berdasarkan kondisi enabled JRE*/
    @Test
    @EnabledOnJre(value = [JRE.JAVA_8])
    fun canRunJRE(){
        //Code
    }

    /*Test berdasarkan kondisi disable JRE*/
    @Test
    @DisabledOnJre(value = [JRE.JAVA_11])
    fun cannotRunJRE(){
        //Code
    }


    /*Test berdasarkan kondisi enabled range JRE*/
    @Test
    @EnabledForJreRange (min = JRE.JAVA_8, max = JRE.JAVA_11)
    fun canRunRangeJRE(){
        //Code
    }

    /*Test berdasarkan kondisi disable range JRE*/
    @Test
    @DisabledForJreRange (min = JRE.JAVA_11, max = JRE.JAVA_13)
    fun cannotRunRangeJRE(){
        //Code
    }

    /*Check your computer system*/
    @Test
    fun printSystemProperties(){
        System.getProperties().forEach { key, value ->
            println("$key = $value",)
        }
    }

    /*Test enabled system properties with one value*/
    @Test
    @EnabledIfSystemProperty(named = "java.vendor", matches = "Amazon.com Inc.")
    fun enabledOnSystemProperty(){
        //Code
    }

    /*Test disabled system properties with one value*/
    @Test
    @DisabledIfSystemProperty(named = "java.vendor", matches = "Amazon.com Inc.")
    fun disabledOnSystemProperty(){
        //Code
    }

    /*Test enabled system properties with many value*/
    @Test
    @EnabledIfSystemProperties(value =
    [
        //Lebih dari 1 kondisi
        EnabledIfSystemProperty(named = "java.vendor", matches = "Amazon.com Inc."),
        EnabledIfSystemProperty(named = "os.name", matches = "Windows"),
        EnabledIfSystemProperty(named = "java.vm.specification.vendor", matches = "Oracle Corporation")
    ])
    fun enabledOnSystemProperties(){
        //Code
    }


    /*Test disabled system properties with many value*/
    @Test
    @DisabledIfSystemProperties(value =
    [
        //Lebih dari 1 kondisi
        DisabledIfSystemProperty(named = "java.vendor", matches = "Amazon.com Inc."),
        DisabledIfSystemProperty(named = "os.name", matches = "Windows"),
        DisabledIfSystemProperty(named = "java.vm.specification.vendor", matches = "Oracle Corporation")
    ])
    fun disabledOnSystemProperties(){
        //Code
    }


    /*Test enabled environment variable with one value*/
    @Test
    @EnabledIfEnvironmentVariable(named = "PROFILE",matches = "DEV" )
    fun enabledOnEnvironmentVariable(){
        //Code
    }

    /*Test disabled environment variable with one value*/
    @Test
    @DisabledIfEnvironmentVariable(named = "PROFILE",matches = "DEV" )
    fun disabledOnEnvironmentVariable(){
        //Code
    }

    /*Test enabled environment variable with many value*/
    @Test
    @EnabledIfEnvironmentVariables(value =
    [
        EnabledIfEnvironmentVariable(named = "PROFILE",matches = "DEV"),
        EnabledIfEnvironmentVariable(named = "NAME_PROFILE",matches = "Andhi Ratobing")
    ])
    fun enabledOnEnvironmentVariables(){
        //Code
    }

    /*Test disabled environment variable with many value*/
    @Test
    @DisabledIfEnvironmentVariables(value =
    [
        DisabledIfEnvironmentVariable(named = "PROFILE",matches = "DEV"),
        DisabledIfEnvironmentVariable(named = "NAME_PROFILE",matches = "Andhi Ratobing")
    ])
    fun disabledOnEnvironmentVariables(){
        //Code
    }

}