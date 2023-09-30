public class ComboLockApp {
    public static void main(String[] args) {
        ComboLock lock = new ComboLock(15, 29, 14);

        System.out.println(lock.toString());

        lock.turnRight(15);
        System.out.println(lock.toString());

        lock.turnLeft(26);
        System.out.println(lock.toString());

        lock.turnRight(25);
        System.out.println(lock.toString());

        if (lock.open())
        {
            System.out.println("Opened.");
        }

        else
        {
            System.out.println("Unable to open.");
        }
    }
}
