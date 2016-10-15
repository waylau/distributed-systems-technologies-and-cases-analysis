package com.waylau.rest;

//import org.glassfish.grizzly.http.server.HttpServer;
//import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
//import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
//import org.glassfish.jersey.simple.SimpleContainerFactory;

import java.io.IOException;
import java.net.URI;

import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

/**
 * 主应用
 *
 */
public class App {
	// HTTP server 所要监听的 uri
	public static final String BASE_URI = "http://192.168.11.125:8081/";

	/**
	 * Main 方法.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// 若使用 Jdk Http Server请去掉下面的注释
		// JdkHttpServerFactory.createHttpServer(URI.create(BASE_URI), new
		// RestApplication());

		// 若使用 Grizzly Http Server请去掉下面的注释
		// GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), new
		// RestApplication());

		// 若使用 Simple Http Server请去掉下面的注释
		// SimpleContainerFactory.create(URI.create(BASE_URI), new
		// RestApplication());
		// 若使用 Jetty Http Server请去掉下面的注释
		JettyHttpContainerFactory.createServer(URI.create(BASE_URI),
				new RestApplication());
	}
}
