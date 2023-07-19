package me.nukeghost.effects.rider.active;

public class RActiveMultiplier {
    public static Double getMultiplier(double min, double max) {
        return (Math.random()*(max-min+1)+min);
    }
}
