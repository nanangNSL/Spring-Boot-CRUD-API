# Panduan Instalasi - Quotes API (Java Spring Boot)

Ini adalah panduan instalasi untuk proyek \"Quotes API\" yang menggunakan Java Spring Boot. Ikuti langkah-langkah di bawah ini untuk menginstal dan menjalankan Quotes API di lingkungan pengembangan Anda.

## Persyaratan Sistem

Sebelum memulai, pastikan sistem Anda memenuhi persyaratan berikut:

- Java Development Kit (JDK) 11 atau yang lebih baru
- Apache Maven
- Git (opsional)

## Langkah 1: Mengunduh Proyek

Anda dapat mengunduh proyek ini dengan menjalankan perintah berikut di terminal atau menggunakan Git:

<pre><code>git clone https://github.com/nanangNSL/quotes-api.git</code></pre>

## Langkah 2: Mengkompilasi dan Mengeksekusi Proyek

Setelah Anda berhasil mengunduh proyek, masuk ke direktori proyek dan jalankan perintah berikut untuk mengkompilasi dan mengeksekusi proyek:

<pre><code>cd quotes-api
mvn spring-boot:run</code></pre>

Proyek Quotes API akan dikompilasi dan dijalankan pada localhost dan port 8080.

## Catatan Tambahan

- Pastikan Anda telah menginstal JDK 11 atau yang lebih baru dan Apache Maven dengan benar pada sistem Anda.
- Anda dapat menyesuaikan konfigurasi seperti port yang digunakan dalam file `application.properties` jika diperlukan.
- Jika ingin menjalankan tes unit, Anda dapat menggunakan perintah `mvn test`.
- Pastikan Postgres berjalan jika menggunakan penyimpanan database postgres

Selamat menggunakan Quotes API dengan Java Spring Boot! Jika Anda memiliki pertanyaan atau masalah, jangan ragu untuk menghubungi pengembang."
