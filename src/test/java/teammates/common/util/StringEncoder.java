package teammates.common.util;

import org.testng.annotations.Test;

import teammates.test.BaseTestCase;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;



class StringEncoderTest extends BaseTestCase{

	@Test
	void testKeyGenerated() throws Exception {
		StringEncoder aes = new StringEncoder();
		SecretKey key = null;

		aes.init();
		key = aes.key;

		assertTrue(key instanceof SecretKeySpec);
	}

	@Test
	void testEncoder() throws Exception {
		StringEncoder aes = new StringEncoder();
		String str = "Testes de Software - 2022";

		byte[] strInBytes = str.getBytes();

		assertEquals("VGVzdGVzIGRlIFNvZnR3YXJlIC0gMjAyMg==", aes.encode(strInBytes));
	}

	@Test
	void testEncrypter() throws Exception {
		StringEncoder aes = new StringEncoder();
		String str = "Testes de Software - 2022";
		String str2 = "abcd";

		aes.init();

		assertEquals(56, aes.encrypt(str).length());
		assertEquals(28, aes.encrypt(str2).length());
	}

	@Test
	void testDecoder() throws Exception {
		StringEncoder aes = new StringEncoder();
		String str = "Testes de Software - 2022";

		byte[] strInBytes = str.getBytes();

		String encodedString = aes.encode(strInBytes);

		assertEquals("Testes de Software - 2022", new String(aes.decode(encodedString)));
	}

	@Test
	void testDecrypter() throws Exception {
		StringEncoder aes = new StringEncoder();
		String str = "Testes de Software - 2022";

		aes.init();
		String encryptedString = aes.encrypt(str);

		assertEquals("Testes de Software - 2022", aes.decrypt(encryptedString));
	}

}