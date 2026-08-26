interface PaymentProcessor {
    void processPayment(double amount);
}

// UPI implementation
class UPIProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of ₹" + amount);
    }
}

// Credit Card implementation
class CreditCardProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card payment of ₹" + amount);
    }
}

// PayPal implementation
class PayPalProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of ₹" + amount);
    }
}

// Management class
public class PaymentProcessorDemo {































    public static void main(String[] args) {

        PaymentProcessor payment;

        payment = new UPIProcessor();
        payment.processPayment(1000);

        payment = new CreditCardProcessor();
        payment.processPayment(2500);

        payment = new PayPalProcessor();
        payment.processPayment(5000);
    }
}