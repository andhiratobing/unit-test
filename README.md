# Latihan unit test menggunakan JUnit 5

## Dokumentasi lengkap JUnit 5 [Link dokumentasi](https://junit.org/junit5/docs/current/user-guide/)

## Membuat Unit Test pada Kotlin
   Pembuatan unit test dibuat tidak seperti dengan membuat program biasa/ dibuat pada packages **main**, akan tetapi pembuatan unit tes dibuat pada packages
   yang telah disediakan yaitu packages **test**, pembuatan unit test ditandai dengan adanya anotasi **@Test**
   

## Mengubah nama Unit Test manual
  - Menambahkan anotasi **@DisplayName("Description")** di atas function Test
  
## Mengubah nama Unit Test otomatis
  - Langkah: 
  1. Membuat class generator
     Contoh:
     ```
     class SimpleDisplayNameGenerator: DisplayNameGenerator {
       
        override fun generateDisplayNameForClass(testClass: Class<*>): String {
          return "Test ${testClass.simpleName}"
        }

        override fun generateDisplayNameForNestedClass(nestedClass: Class<*>): String {
          return "Test ${nestedClass.simpleName}"
        }

        override fun generateDisplayNameForMethod(testClass: Class<*>, testMethod: Method): String {
          return "Test ${testClass.simpleName}, ${testMethod.name}"
        }
      }
     ```
  2. Menambahkan anotasi **@DisplayNameGeneration("Description")** di atas function Test

## Menonaktifkan Unit Test pada function yang dibuat
 - Menambahkan anotasi **@Disable** di atas function Test
    ```
    @Disabled("Sedang dikerjakan")
    @Test
    fun testComingSoon(){
        // Belum selesai membuat unit tes
    }
    ```
    
## Menandai Unit Test sebelum & setelah setiap function dieksekusi
- Jika sebelum dijalankan maka:
  Tambahkan anotasi **@BeforeEach**
- Jika setelah dijalankan maka:
  Tambahkan anotasi **@AfterEach**

## Menandai Unit Test sebelum & setelah semua function dieksekusi (_Static Function/Object Function_)
   Pembuatan Unit Test ini ada syaratnya yaitu:
   Langkah:
   1. Membuat object function
      ```
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
      ```
   - Jika sebelum dijalankan maka:
     Tambahkan anotasi **@BeforeAll**
   - Jika setelah dijalankan maka:
     Tambahkan anotasi **@AfterAll**  

## Membatalkan Unit Test manual
   Cara membatalkan manual dapat dilakukan dengan menggunakan exception **TestAbortedException()**
   Contoh program test:
   ```
    @Test
    fun testAborted(){
        val profile = System.getenv()["PROFILE"]
        if ("DEV" !=profile){
            throw TestAbortedException()
        }else {
            println("Test not aborted")
        }
    }
  
   ```
   getenv() adalah environment, cara melihat,mengubah,menghapus environment yaitu
   - Klik tombol panah bawah
   - ![Screenshot from 2021-07-05 01-08-53](https://user-images.githubusercontent.com/43465830/124395349-dca50080-dd2d-11eb-84c4-a61dbfda597e.png)
   - Klik edit configurations
   - ![Screenshot from 2021-07-05 01-09-12](https://user-images.githubusercontent.com/43465830/124395611-4376e980-dd2f-11eb-9c29-f004a1bb046e.png)
   - Tuliskan environment variables
      - Contoh value environment varibales
        ```
        PROFILE=DEV
        ```
   - ![Screenshot from 2021-07-05 01-09-27](https://user-images.githubusercontent.com/43465830/124395622-4a9df780-dd2f-11eb-98c1-a20f44bbed49.png)
     



   
## Membatalkan Unit Test otomatis
   Cara membatalkan otomatis dapat dilakukan dengan menggunakan **Assumptions** (_cara kerjanya mirip Assertion_)
   Langkah:
   1. Import _import org.junit.jupiter.api.Assumptions.*_
   Contoh program test:
   ```
   ```

   
## Melihat report/laporan **Unit Test** melalui browser
- Open package **build**
   1. Klik **report**
   2. Klik tests 
   3. Klik test
   4. Klik kanan index.html
   5. Open In Browser
   6. Selesai


## Kata kunci
  - **assertEquals**digunakan untuk masukan ekspetasi dan aktual fungsi/method yang akan di tes (Assert that expected and actual are equal)
  - **assertThrows**digunakan untuk mengecek Throws(Misalkan _IllegalArgumentException_)
  - **@Disable**digunakan untuk menonaktifkan unit test (misalkan dalam keadaan sedang diperbaiki ketika ada bug) 
  - **@BeforeEach**digunakan untuk menandai setiap function yang akan dieksekusi sebelum unit test dijalankan
  - **@AfterEach**digunakan untuk menandai setiap function yang akan dieksekusi setelah unit test dijalankan
  - **@BeforeAll**digunakan untuk menandai semua function yang akan dieksekusi sebelum unit test dijalankan, namun hanya static function(object function di           Kotlin) yang bisa menggunakan 
  - **@AfterAll**digunakan untuk menandai semua function yang akan dieksekusi setelah unit test dijalankan, namun hanya static function(object function di Kotlin)     yang bisa menggunakan
  - **JvmStatic** digunakan untuk memberitahu compiler _Kotlin_ supaya digenerate ke-static-nya _Java  
  - **TestAbortedException**digunakan untuk membatalkan secara manual Unit Test
  - **Assumptions**digunakan untuk membatalkan secara otomatis Unit Test
  

   
  
