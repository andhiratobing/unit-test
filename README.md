# Latihan unit test menggunakan JUnit 5

## Dokumentasi lengkap JUnit 5 [Link dokumentasi](https://junit.org/junit5/docs/current/user-guide/)

## Cara menggunakan JUnit 5
   Langkah:
   - Ubah setting gradle
     ```
     dependencies {
         testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
     }
     ```
     Tambahkan konfigurasi dibawah dependecies
     ```
     tasks.named<Test>("test"){
         useJUnitPlatform()
     }
     ```
     ```
     tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class).all {
         kotlinOptions {
            jvmTarget = "1.8"
         }
     }
     ```
     Kemudian reload/sync gradle

## Penamaan class atau function unit test
   Dalam membuat unit tes sebaiknya class unit test dibuat sama seperti nama class yang akan di test, tujuannya supaya tidak kebingungan mencari unit test jika      program/fitur aplikasi yang dibuat sudah banyak
   
## Membuat Unit Test pada Kotlin
   Pembuatan unit test dibuat tidak seperti dengan membuat program biasa/ dibuat pada packages **main**, akan tetapi pembuatan unit tes dibuat pada packages
   yang telah disediakan yaitu packages **test**, pembuatan unit test ditandai dengan adanya anotasi
   ```
   @Test
   ```
   
## Mengubah nama Unit Test manual
  - Menambahkan anotasi di atas function test
    ```
    @DisplayName("Description")
    ```
  
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
  2. Menambahkan anotasi di atas function Test
     ```
     @DisplayNameGeneration("Description") 
     ```

## Menonaktifkan Unit Test pada function yang dibuat
 - Menambahkan anotasi **@Disable("Description")** di atas function Test
   ```
   @Disabled("Sedang dikerjakan")
   @Test
   fun testComingSoon(){
     //Code
   }
   ```
    
## Menandai Unit Test sebelum & setelah setiap function dieksekusi
- Jika sebelum dijalankan maka:
  - Tambahkan anotasi
    ```
    @BeforeEach
    ```
- Jika setelah dijalankan maka:
  - Tambahkan anotasi
    ```
    @AfterEach
    ```
    
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
     - Tambahkan anotasi
       ```
       @BeforeAll
       ```
   - Jika setelah dijalankan maka:
     - Tambahkan anotasi
       ```
       @AfterAll
       ```

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
     ![Screenshot from 2021-07-05 01-08-53](https://user-images.githubusercontent.com/43465830/124395349-dca50080-dd2d-11eb-84c4-a61dbfda597e.png)
   - Klik edit configurations
     ![Screenshot from 2021-07-05 01-09-12](https://user-images.githubusercontent.com/43465830/124395611-4376e980-dd2f-11eb-9c29-f004a1bb046e.png)
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
       @Test
       fun testAssumptions(){
           //Jika benar
           assumeTrue("DEV" == System.getenv()["PROFILE"])

           //Jika salah
           println("Test not aborted")
       }
      ```
## Test berdasarkan kondisi
   Melakukan tes berdasarkan kondisi dapat dilakukan dengan **Assumptions**, contohnya mengetest JRE, OS, Environment Varaibles dan lain-lain.
   Namun ada cara yang lebih mudah yaitu dengan mengunakan:
   - Conditional OS
     Langkah:
     - Jika test boleh berjalan pada OS yang ditentukan, maka:
       - Tambahkan anotasi
         ```
         @EnabledOnOs
         ```
     - Jika test tidak boleh berjalan pada OS yang ditentukan, maka:
       - Tambahkan anotasi
         ```
         @DisabledOnOs
         ```
   
   - Conditional JRE (versi java yang digunakan)
     Langkah:
     1. **Secara manual**
      - Jika test boleh berjalan pada JRE yang ditentukan, maka:
        - Tambahkan anotasi
          ```
          @EnabledOnJre
          ```
      - Jika test tidak boleh berjalan pada JRE yang ditentukan, maka:
        - Tambahkan anotasi
          ```
          @EnabledOnJre
          ```
     2. **Secara otomatis**(menggunakan range)
      - Jika test boleh berjalan pada JRE yang ditentukan, maka:
        - Tambahkan anotasi
          ```
          @EnabledOnJreRange
          ```
      - Jika test tidak boleh berjalan pada JRE yang ditentukan, maka:
        - Tambahkan anotasi
          ```
          @DisabledOnJreRange
          ```
   
   - Conditional System Property
     Langkah:
     1. Jika berjalan hanya satu kondisi 
      - Jika test boleh berjalan hanya satu kondisi system property yang ditentukan, maka:
        - Tambahkan anotasi
          ```
          @EnabledIfSystemProperty
          ```
      - Jika test boleh tidak boleh berjalan hanya satu kondisisystem proerty yang ditentukan, maka:
        - Tambahkan anotasi
          ```
          @DisabledIfSystemProperty
          ```
     2. Jika berjalan lebih dari satu kondisi
      - Jika test boleh berjalan lebih dari satu kondisi system property lebih dari satu kondisi, maka:
        - Tambahkan anotasi
          ```
          @EnabledIfSystemProperties
           ```
      - Jika tes tidak boleh berjalan lebih dari satu kondisi system property lebih dari satu kondisi, maka:
        - Tambahkan anotasi
          ```
          @DisabledIfSystemProperties
          ```
   - Conditioanal Environment Variable
     Langkah:
     1. Jika berjalan hanya satu kondisi 
      - Jika test boleh berjalan hanya satu kondisi environment variable yang ditentukan, maka:
        - Tambahkan anotasi
          ```
          @EnabledIfEnvironmentVariable
          ```
      - Jika test boleh tidak boleh berjalan hanya satu kondisi environment variable yang ditentukan, maka:
        - Tambahkan anotasi
          ```
          @DisabledIfEnvironmentVariable
          ```
     2. Jika berjalan lebih dari satu kondisi
      - Jika test boleh berjalan lebih dari satu kondisi environment variable  lebih dari satu kondisi, maka:
        - Tambahkan anotasi
          ```
          @EnabledIfEnvironmentVariables(
          ```
      - Jika tes tidak boleh berjalan lebih dari satu kondisi environment variable lebih dari satu kondisi, maka:
        - Tambahkan anotasi
          ```
          @DisabledIfEnvironmentVariables
          ```
        
  

   
## Melihat report/laporan **Unit Test** melalui browser
   Langkah:
   1. Open package **build**
   2. Klik **report**
   3. Klik tests 
   4. Klik test
   5. Klik kanan index.html
   6. Open In Browser
   7. Selesai


## Kata kunci
  - **assertEquals** digunakan untuk masukan ekspetasi dan aktual fungsi/method yang akan di tes (Assert that expected and actual are equal)
  - **assertThrows** digunakan untuk mengecek Throws(Misalkan _IllegalArgumentException_)
  - **@Disable** digunakan untuk menonaktifkan unit test (misalkan dalam keadaan sedang diperbaiki ketika ada bug) 
  - **@BeforeEach** digunakan untuk menandai setiap function yang akan dieksekusi sebelum unit test dijalankan
  - **@AfterEach** digunakan untuk menandai setiap function yang akan dieksekusi setelah unit test dijalankan
  - **@BeforeAll** digunakan untuk menandai semua function yang akan dieksekusi sebelum unit test dijalankan, namun hanya static function(object function di           Kotlin) yang bisa menggunakan 
  - **@AfterAll** digunakan untuk menandai semua function yang akan dieksekusi setelah unit test dijalankan, namun hanya static function(object function di           Kotlin)     yang bisa menggunakan
  - **JvmStatic** digunakan untuk memberitahu compiler **_Kotlin_** supaya digenerate ke-static-nya _Java  
  - **TestAbortedException** digunakan untuk membatalkan secara manual Unit Test
  - **Assumptions** digunakan untuk membatalkan secara otomatis Unit Test
  - **@EnabledOnOs** digunakan untuk penanda bahwa unit test **_boleh_** berjalan di OS yang tertentu
  - **@DisabledOnOs** digunakan untuk penanda bahwa unit test **_tidak boleh_** berjalan di OS yang tertentu
  - **@EnabledOnJre** digunakan untuk penanda bahwa unit test **_boleh_** berjalan di JRE(_versi java_) yang ditentukan
  - **@DisabledOnJre** digunakan untuk penanda bahwa unit test **_tidak boleh_** berjalan di JRE(_versi java_) yang ditentukan
  - **@EnabledOnJreRange** digunakan untuk penanda bahwa unit test **_boleh_** berjalan di **range** JRE(_versi java_) yang ditentukan
  - **@DisabledOnJreRange** digunakan untuk penanda bahwa unit test **_tidak boleh_** berjalan di **range** JRE(_versi java_) yang ditentukan
  - **@EnabledIfSystemProperty** digunakan untuk penanda bahwa unit test **_boleh_** berjalan pada satu kondisi **SystemProperty** yang ditentukan
  - **@DisabledIfSystemProperty** digunakan untuk penanda bahwa unit test **_tidak boleh_** berjalan pada satu kondisi **SystemProperty** yang ditentukan
  - **@EnabledIfSystemProperties** digunakan untuk penanda bahwa unit test **_boleh_** berjalan pada lebih dari satu kondisi **SystemProperty** yang ditentukan
  - **@DisabledIfSystemProperties** digunakan untuk penanda bahwa unit test **_tidak boleh_** berjalan pada lebih dari satu kondisi **SystemProperty** yang           ditentukan
  - **@@EnabledIfEnvironmentVariable** digunakan untuk penanda bahwa unit test **_boleh_** berjalan pada satu kondisi **EnvironmentVariable** yang                     ditentukan
  - **@DisabledIfEnvironmentVariable** digunakan untuk penanda bahwa unit test **_tidak boleh_** berjalan pada satu kondisi **EnvironmentVariable**         yang       ditentukan
  - **@@EnabledIfEnvironmentVariables** digunakan untuk penanda bahwa unit test **_boleh_** berjalan pada lebih dari satu kondisi **EnvironmentVariable** yang         ditentukan
  - **@DisabledIfEnvironmentVariables** digunakan untuk penanda bahwa unit test **_tidak boleh_** berjalan pada lebih dari satu kondisi **EnvironmentVariable**       yang ditentukan 

   
  
