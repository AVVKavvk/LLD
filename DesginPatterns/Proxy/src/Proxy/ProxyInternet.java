package Proxy;

public class ProxyInternet implements Internet{
    private Internet internet = new RealInternet();
    @Override
    public void connectTo(String serverHost) {
        if(serverHost.contains("banned.com")){
            System.out.println("Access Denied to " + serverHost);
            return;
        }
        internet.connectTo(serverHost);
    }
}
