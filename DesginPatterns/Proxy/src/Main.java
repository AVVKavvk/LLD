import Proxy.Internet;
import Proxy.ProxyInternet;

void main() {
    Internet internet = new ProxyInternet();
    internet.connectTo("google.com");
    internet.connectTo("banned.com");
}