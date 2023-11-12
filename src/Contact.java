import java.util.Objects;

public record Contact(String name,
                      String email) {
    public Contact {
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        if (!email.isEmpty()) {
            if (!email.endsWith("@gmail.com")) {
                throw new IllegalArgumentException("It is not an email");
            }
        } else {
            email = "testEmail@gmail.com";
        }
    }

    public void sayHello() {
        System.out.println("Hello, " + name);
    }
}
