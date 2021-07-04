# Latihan unit test menggunakan JUnit 5

## Dokumentasi lengkap JUnit 5 [Link dokumentasi](https://junit.org/junit5/docs/current/user-guide/)

## Membuat unit tes pada Kotlin
   Pembuatan unit test dibuat tidak seperti dengan membuat program biasa/ dibuat pada packages **main**, akan tetapi pembuatan unit tes dibuat pada packages
   yang telah disediakan yaitu packages **test**, pembuatan unit test ditandai dengan adanya anotasi **@Test**
   

## Cara mengubah nama Test manual
  - Menambahkan anotasi **@DisplayName("Description")** di atas function Test
  
## Mengubah nama Test otomatis
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

## Cara menonaktifkan Unit Test pada function yang dibuat
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

## Menandai Unit Test sebelum & setelah semua function dieksekusi (_Static Function/Object Function)
   Pembuatan Unit Test ini ada syaratnya yaitu:
   Langkah:
   1. Membuat object function
      ```
      ```
   - Jika sebelum dijalankan maka:
     Tambahkan anotasi **@BeforeAll**
   - Jika setelah dijalankan maka:
     Tambahkan anotasi **@AfterAll**  

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
  

   
  
