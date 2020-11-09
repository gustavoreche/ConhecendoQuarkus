package br.com.aplicacao;

import static io.quarkus.runtime.Quarkus.run;

import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class ServerLaunch {

	public static void main(String[] args) {
		run(args);
	}

}