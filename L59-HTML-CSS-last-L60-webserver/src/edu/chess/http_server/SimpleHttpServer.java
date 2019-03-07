package edu.chess.http_server;

import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by yar 09.2009 Upgrade by IlyaBeetle 01.2018
 * 
 * @author yar, IlyaBeetle
 * @version 0.1
 */
public class SimpleHttpServer {

	private ServerSocket ss = null;

	// Constructor
	public SimpleHttpServer() {
		try {
			this.ss = new ServerSocket(8080);
		} catch (IOException e) {
			System.err.println("[РћС€РёР±РєР° СЃРѕР·РґР°РЅРёСЏ РїРѕСЂС‚Р° СЃРµСЂРІРµСЂР°]");
			System.err.println("\n\n");
			e.printStackTrace();
			System.err.println("\n\n");
		}
	}

	// Launcher magic
	public void launch() {
		long timeStartServer = System.currentTimeMillis();
		while (true) {
			try {
				System.out.println("Принимаю клиента");
				Socket s = ss.accept();
				System.out.println("Принял клиента");

				new Thread(new SocketProcessor(s)).start();

				if (timeOutHttpServer(timeStartServer)) {
					ss.close();
					System.exit(1);
				}
			} catch (Throwable e) {
				System.err.println("\n\n");
				e.printStackTrace();
				System.err.println("\n\n");
			}
		}
	}

	/**
	 * 
	 * @param timer
	 * @return
	 */
	boolean timeOutHttpServer(long timeStartServer) {
		long timeNow = System.currentTimeMillis();
		if (timeNow > (timeStartServer + 6000000)) {
			return true;
		}
		return false;
	}


	private static class SocketProcessor implements Runnable {

		private Socket s;
		private InputStream is;
		private OutputStream os;

		private SocketProcessor(Socket s) throws Throwable {
			this.s = s;
			this.is = s.getInputStream();
			this.os = s.getOutputStream();
		}

		public void run() {
			/* Console */
			System.out.println("Начало обслуживани нового клиента");
			try {
				// *************************************************************
				String[] request = readInputHeaders();

				String requestResourceName = ResourceURLParserUtils.whatIsRequestResource(request[0]);

				// РїСЂРё РїСѓСЃС‚РѕРј Р·Р°РїСЂРѕСЃРµ РІСЃРµРіРґР° РІРѕР·РІСЂР°С‰Р°С‚СЊ РіР»Р°РІРЅСѓСЋ.
				if (requestResourceName == "") {
					requestResourceName = "index.html";
				}

				String fileType = ResourceURLParserUtils.whatIsTypeResource(requestResourceName);

				
				ResourceToBytesFromFile resourceContent = new ResourceToBytesFromFile();
				byte[] respondeBody = resourceContent.getResource(requestResourceName);
				writeResponse(new ResourceToBytesFromFile().getResource(requestResourceName), fileType);
				// *************************************************************
			} catch (Throwable e) {
				System.err.println("[РџСЂРѕР±Р»РµРјР° РІ РїРѕС‚РѕРєРµ http СЃРµСЂРІРµСЂР°]");
				System.err.println("\n\n");
				e.printStackTrace();
				System.out.println("\n\n");
			} finally {
				try {
					s.close();
				} catch (Throwable t) {
					System.err.println("[РџСЂРѕР±Р»РµРјР° c Р·Р°РєСЂС‹С‚РёРµРј СЃРѕРєРµС‚Р° http СЃРµСЂРІРµСЂР°]");
					System.err.println("\n\n");
					t.printStackTrace();
					System.err.println("\n\n");
				}
			}
			/* Console */System.out.println("[РћР±СЂР°Р±РѕС‚РєР° РєР»РёРµРЅС‚Р° Р·Р°РІРµСЂС€РµРЅР°]" + "\n\n\n");
		}

		/**
		 * Р­С‚РѕРґ РјРµС‚РѕРґ С‡РёС‚Р°РµС‚ РёР· РїРѕС‚РѕРєР° Р·Р°РіРѕР»РѕРІРѕРє Р·Р°РїСЂРѕСЃР°.
		 * 
		 * @return - РІРѕР·РІСЂР°С‰Р°РµС‚ РјР°СЃРёРІ СЃС‚СЂРѕРє СЃРѕРґРµСЂР¶Р°С€РёР№ Р·Р°РіРѕР»РѕРІРє Р·Р°РїСЂРѕСЃР°.
		 */
		private String[] readInputHeaders() {
			/* Console */System.out.println("[Р§С‚РµРЅРёРµ Р·Р°РїСЂРѕСЃР° СЃРµСЂРІРµСЂСѓ]");

			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String[] arrayHeader = new String[100];// РЎ Р·Р°РїР°СЃРѕРј =)
			int counter = 0;
			while (true) {
				try {
					arrayHeader[counter] = br.readLine();
					System.out.println("\t{" + arrayHeader[counter] + "}");
					if (arrayHeader[counter] == null || arrayHeader[counter].trim().length() == 0) {
						break;
					}
					counter++;
				} catch (IOException e) {
					System.err.println("[РџСЂРѕР±Р»РµРјР° С‡С‚РµРЅРёСЏ РІС…РѕРґСЏС€РµРіРѕ РїРѕС‚РѕРєР°]");
					System.err.println("\n\n");
					e.printStackTrace();
					System.err.println("\n\n");
				}

			}

			/* Console */System.out.println("[РЎРµСЂРІРµСЂ HTTP РїСЂРѕС‡РёС‚Р°Р» Р·Р°РіРѕР»РѕРІРѕРє]");
			return arrayHeader;
		}

		/**
		 * Р­С‚РѕС‚ РјРµС‚РѕРґ С„РѕСЂРјРёСЂСѓРµС‚ РѕС‚РІРµС‚ РєР»РёРµРЅС‚Сѓ, РІ РІРёРґРµ С€РѕР»РѕРІС‹ РѕС‚РІРµС‚Р° Рё Р·Р°РїСЂР°С€РёРІР°РµРјРѕРіРѕ
		 * СЂРµСЃСѓСЂСЃР°.
		 * 
		 * @param resourse
		 *            - РјР°СЃРёРІ Р±Р°Р№С‚ Р·Р°РїСЂРѕС€РµРЅРѕРіРѕ СЂРµСЃСѓСЂСЃР°.
		 * @param mimeType
		 *            - С‚РёРї РїРµСЂРµРґРѕРІР°РµРјРѕРіРѕ СЂРµСЃСѓСЂСЃР°.
		 * @throws Throwable
		 *             - РїСЂРё РѕС€РёР±РєРµ Р·Р°РїРёСЃРё РІ РїРѕС‚РѕРє.
		 */
		private void writeResponse(byte[] resourse, String mimeType) throws Throwable {
			/* Console */System.out.println("[РЎРѕР·РґР°РЅРёРµ РѕС‚РІРµС‚Р° СЃРµСЂРІРµСЂР°]");
			
			String response = "";
			response += "HTTP/1.1 200 OK\r\n";
			response += "Server: YarServer/+IlyaBeetle\r\n";
			response += "Content-Type: " + mimeType + "\r\n";
			response += "Content-Length: " + resourse.length + "\r\n";
			response += "Connection: close\r\n\r\n";

			System.out.println("\t{" + "HTTP/1.1 200 OK" + "}");
			System.out.println("\t{" + "Server: Simple HTTP Server v0.1" + "}");
			System.out.println("\t{" + "Content-Type: " + mimeType + "}");
			System.out.println("\t{" + "Content-Length: " + resourse.length + "}");
			System.out.println("\t{" + "Connection: close" + "}");
			System.out.println("\t{}");

			os.write(response.getBytes(/*РЅСѓР¶РЅР° РђРЎРљР�-СЃРѕРІРј. РєРѕРґРёСЂРѕРІРєР°*/));
			os.write(resourse);
			os.flush();
		}

	}
}



























