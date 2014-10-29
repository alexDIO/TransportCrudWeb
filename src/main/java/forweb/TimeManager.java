package forweb;

import java.util.Date;

/**
 * Created by olomakovskyi on 10/27/2014.
 */
public class TimeManager {
    private final Date startDate;

    public TimeManager(){
        this.startDate = new Date();
    }

    public String getDuration(){
        Date currentDate = new Date();
        long diff = currentDate.getTime() - startDate.getTime();
        long diffMilliSeconds = diff % 1000;
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;

        StringBuilder builder = new StringBuilder();
        if (diffHours > 0){
            builder.append(diffHours);
            builder.append(" hours ");
        }
        if (diffMinutes > 0){
            builder.append(diffMinutes);
            builder.append(" minutes ");
        }
        if (diffSeconds > 0){
            builder.append(diffSeconds);
            builder.append(" seconds ");
        }
        builder.append(diffMilliSeconds);
        builder.append(" milliseconds. ");
        return builder.toString();
    }
}
