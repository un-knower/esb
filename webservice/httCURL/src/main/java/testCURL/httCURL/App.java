package testCURL.httCURL;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Hello world!
 *
 */
public class App 
{
	private static String url = "https://userinfo.youkeshu.com/api/get_token";
	private static String charset = "utf-8";

	public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, ParseException, IOException {
		SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
			public boolean isTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
				return true;
			}
		}).build();

		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
		String param = "{\"username\":\"chenguitao\",\"password\":\"cYKSgt12\"}";
		HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
		HttpPost request = new HttpPost(url);
		request.addHeader("Content-Type", "application/json");
		request.setEntity(new StringEntity(param));
		HttpResponse response = httpClient.execute(request);
		System.out.println("状态：" + response.getStatusLine().getStatusCode());
		System.out.println("data：" + EntityUtils.toString(response.getEntity(), charset));
	}
}
