import threadjava.ThreadJava;

void main() {
    CompletableFuture<Void> future = CompletableFuture.runAsync(() -> System.out.println("hola"));
    future.whenComplete((result, exception) -> {
        if (exception != null) {
            System.out.println(exception.getMessage());
        } else {
            System.out.println("adios dentro del where");
            System.out.println(result);
        }
    });
    System.out.println("adios");
}