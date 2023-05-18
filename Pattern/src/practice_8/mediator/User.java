package practice_8.mediator;

public class User extends Colleague {
    private String name;

    public User(String name, Mediator mediator) {
        super(mediator);
        this.name = name;
    }

    @Override
    public void send(String event) {
        mediator.notify(name, event);
    }



}