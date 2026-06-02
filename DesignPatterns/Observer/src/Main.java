import Observer.Channel;

void main() {
    Channel channel = new Channel();
    channel.subscribe("Vipin");
    channel.subscribe("Avvk");

    channel.uploadVideoNotification("LLD");
}