package LocalDate_and_Time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Optional;

public class UserSubscriptionCalculator
{
    public static void main(String[] args) {
        User user = new User(101,"Vamsi",LocalDate.of(2025,6,19),6);

        Optional<User> optionalUser = Optional.ofNullable(user);

        optionalUser.ifPresent(u -> {
            System.out.println("User id :" + u.getId());
            System.out.println("User name :" + u.getName());
            System.out.println("User Plan start date :" + u.getPlanTakenDate());
            System.out.println("Duration of subscription :" +u.getDurationMonths() + "Months" );

            // ExpiryDate
            LocalDate expiryDate = u.getPlanTakenDate().plusMonths(u.getDurationMonths());

            System.out.println("Expiry Date :" + expiryDate);

            // Today date
            LocalDate today = LocalDate.now();
            System.out.println("Today date :"+today);

            if(today.isBefore(expiryDate) || today.isEqual(expiryDate))
            {
                System.out.println("SUBSCRIPTION STATUS  : ACTIVE ");

                //Calculate the remaining Period
                Period remaining = Period.between(today,expiryDate);
                System.out.println("Remaining Months :" + remaining.getMonths() + "Remaining Days :" + remaining.getDays());
            }
            else
            {
                System.out.println("SUBSCRIPTION STATUS : EXPIRED");
            }
        });


        LocalDateTime start = LocalDateTime.of(2026,9,1,9,0);
        LocalDateTime end = LocalDateTime.of(2026,9,1,17,30);

        Duration duration = Duration.between(start,end);
        System.out.println("Subscription processing time :" + duration.toHours() +"Hours , "+ (duration.toMinutes() % 60)+ "Minutes");
    }
}
