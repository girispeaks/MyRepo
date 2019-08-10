package net.webservicex;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GlobalWeather glbw=new GlobalWeather();
		GlobalWeatherSoap glbwsoap=glbw.getGlobalWeatherSoap();
		System.out.println(glbwsoap.getCitiesByCountry("India"));		
	}
}
