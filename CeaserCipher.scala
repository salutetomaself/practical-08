object CaesarCipher {

  // Encryption function: Shifts each character by the given shift amount
  def encrypt(text: String, shift: Int): String = {
    text.map { char =>
      if (char.isLetter) {
        val offset = if (char.isUpper) 'A' else 'a'
        ((char + shift - offset) % 26 + offset).toChar
      } else {
        char
      }
    }
  }

  // Decryption function: Shifts each character back by the given shift amount
  def decrypt(text: String, shift: Int): String = {
    encrypt(text, 26 - (shift % 26))
  }

  // Cipher function: Takes either encryption or decryption and applies it
  def cipher(text: String, shift: Int, operation: (String, Int) => String): String = {
    operation(text, shift)
  }

  def main(args: Array[String]): Unit = {
    val plaintext = "Hello, World!"
    val shift = 3

    // Encrypt the plaintext
    val encryptedText = cipher(plaintext, shift, encrypt)
    println(s"Encrypted: $encryptedText")

    // Decrypt the ciphertext
    val decryptedText = cipher(encryptedText, shift, decrypt)
    println(s"Decrypted: $decryptedText")
  }
}
