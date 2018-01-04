package timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Timer;
import java.util.TimerTask;
import server.TCPServer;

/**
 *
 * @author Marc Le Goc
 * @date 2015/10/23
 *
 * Timer in Java is a utility class which is used to schedule tasks for both one
 * time and repeated execution. Timer is similar to alarm facility many people
 * use in mobile phone. Just like you can have one time alarm or repeated alarm,
 * You can use java.util.Timer to schedule one time task or repeated task. Two
 * classes java.util.Timer and java.util.TimerTask is used to schedule jobs in
 * Java and forms Timer API. TimerTask is actual task which is executed by
 * Timer. Similar to Thread in Java, TimerTask also implements Runnable
 * interface and overrides run method to specify task details.
 *
 * Timer class in Java maintains a background Thread (this could be either
 * daemon thread or user thread, based on how you created your Timer object),
 * also called as timer's task execution thread. For each Timer there would be
 * corresponding task processing Thread which run scheduled task at specified
 * time. If your Timer thread is not daemon then it will stop your application
 * from exits until it completes all schedule task. Its recommended that
 * TimerTask should not be very long otherwise it can keep this thread busy and
 * not allow other scheduled task to get completed. This can delay execution of
 * other scheduled task, which may queue up and execute in quick succession once
 * offending task completed.
 *
 * Difference between Timer and TimerTask in Java :
 *
 * 1) Timer in Java schedules and execute TimerTask which is an implementation
 * of Runnable interface and overrides run method to defined actual task
 * performed by that TimerTask.
 *
 * 2) Both Timer and TimerTask provides cancel() method. Timer's cancel() method
 * cancels whole timer while TimerTask's one cancels only a particular task. I
 * think this is the wroth noting difference between Timer and TimerTask in
 * Java.
 *
 * Canceling Timer in Java :
 *
 * Calling cancel() method of java.util.Timer class would result in following:
 *
 * 1) Timer will not cancel any currently executing task.
 *
 * 2) Timer will discard other scheduled task and will not execute them.
 *
 * 3) Once currently executing task will be finished, timer thread will
 * terminate gracefully.
 *
 * 4) Calling Timer.cancel() more than one time will not affect. second call
 * will be ignored.
 *
 * In addition to cancelling Timer, You can also cancel individual TimerTask by
 * using cancel() method of TimerTask itself.
 *
 * Important points on Timer and TimerTask :
 *
 * 1.One Thread will be created corresponding ot each Timer in Java, which could
 * be either daemon or user thread.
 *
 * 2.You can schedule multiple TimerTask with one Timer.
 *
 * 3.You can schedule task for either one time execution or recurring execution.
 *
 * 4.TimerTask.cancel() cancels only that particular task, while Timer.cancel()
 * cancel all task scheduled in Timer.
 *
 * 5.Timer in Java will throw IllegalStateException if you try to schedule task
 * on a Timer which has been cancelled or whose Task execution Thread has been
 * terminated.
 *
 *
 * This example implements a Reminder utility using Timer in Java.
 *
 * Read more:
 * http://javarevisited.blogspot.com/2013/02/what-is-timer-and-timertask-in-java-example-tutorial.html#ixzz3p1rb0YBi
 *
 *
 */
public final class BasicTimer {

    private Timer timer;
    private final int delay; //Milliseconds
//    private final TimeOver timeOver = new TimeOver();
    private boolean aTimeOver = false;
    private TCPServer aTCPServer;

    //Inner class
    private final class TimeOverTask extends TimerTask {

	//TimeOverTask Constructor
        public TimeOverTask() {
            aTimeOver = false;
        }

        //TimerTask implementation
        @Override
        public void run() {
            aTimeOver = true;
//            aBasicTimer.cancel();
            System.out.println("run() of TimeOverTask: Time is over !");
            aTCPServer.timeOver = true;
        }
    }

    //Basic Timer Constructor
    public BasicTimer(int milliSeconds, TCPServer aTCPServer) {
        this.delay = milliSeconds;
        this.aTCPServer = aTCPServer;
        System.out.println("BasicTimer(aTimerTask, " + milliSeconds + "): the timer has been created with a delay= " + delay + ".");
    }

    public void start() {
//        this.timeOver.setFalse();
        this.aTimeOver = false;
        this.timer = new Timer();
        this.timer.schedule(new TimeOverTask(), delay); //delay in milliseconds
        System.out.println("BasicTimer is started.");
    }

    public void stop() {
        if (this.timer == null) {
            System.out.println("BasicTimer.stop(): the time must be started before being stoped!");
            return;
        }
//        this.timeOver.setFalse();
        this.aTimeOver = false;
        this.timer.cancel();
        System.out.println("BasicTimer is cancelled.");
    }

    public boolean isTimeOver() {
        return this.aTimeOver;
//        return this.timeOver.getValue();
    }

}
