package practice_8.mediator;

public class ChatRoom implements Mediator {
    @Override
    public void notify(String name, String event) {
        // Обработка событий, переданных от отправителя.
        System.out.println("[" + name + "]: " + event);
    }
}
