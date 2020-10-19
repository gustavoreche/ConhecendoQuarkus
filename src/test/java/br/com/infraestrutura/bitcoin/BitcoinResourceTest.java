package br.com.infraestrutura.bitcoin;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
class BitcoinResourceTest {

	@Test
	void lista_statusCode_retornoOk() {
		RestAssured
			.given()
			.get("bitcoinss")
			.then()
			.statusCode(HttpStatus.SC_OK);
	}
	
	@Test
	void lista_retornoPreenchido_retornoOk() {
		RestAssured
			.given()
			.get("bitcoinss")
			.then()
			.body("data", Matchers.notNullValue())
			.and()
			.body("data", Matchers.not(Matchers.empty()));
	}

}
