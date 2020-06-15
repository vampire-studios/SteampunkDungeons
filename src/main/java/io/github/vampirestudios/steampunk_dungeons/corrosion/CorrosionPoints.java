package io.github.vampirestudios.steampunk_dungeons.corrosion;
import net.minecraft.item.Item;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ScheduledTick;

/**
 A utility for the corrosion system. The system might require more work on it, but in theory, it could work.
 */
public class CorrosionPoints {
    static ScheduledTick<Integer> getTick;
    static Tickable tickable;
    public static int NONE = 0;
    public static int HALF = 50;
    public static int FULL = 100;
    public static BlockPos pos;
    public static ScheduledTick<Integer> getTickNumber = registerTick(new ScheduledTick<Integer>(pos, 72000));
    public static ScheduledTick<Integer> tickNumber(ScheduledTick<Integer> getTickNumber) {
            getTickNumber = CorrosionPoints.getTickNumber;
            return tickNumber(getTickNumber);
    }
    public static ScheduledTick everyHour() {
       CorrosionPoints.tickNumber(getTickNumber);
       return everyHour();

    }
    public static CorrosionPoints getCorrosionInZero() {
        everyHour(); {
            registerCorrosionIntForOverflowed(0);
        }
        return  getCorrosionInZero();
    }
    public static CorrosionPoints getCorrosionInHalf() {
        everyHour(); {
            registerCorrosionIntForHalf(0);

        }
        return getCorrosionInHalf();
    }
    public static CorrosionPoints getCorrosionInFull() {
        everyHour(); {
            registerCorrosionIntForFull(0);
        }
        return getCorrosionInFull();
    }
    public static ScheduledTick<Integer> registerTick(ScheduledTick<Integer> tick) {
        registerTick(tick);
        return tick;

    }
    public static CorrosionPoints registerCorrosionIntForHalf(Integer startCorrosionPoints) {
        registerCorrosionIntForHalf(startCorrosionPoints + HALF);
        return registerCorrosionIntForHalf(startCorrosionPoints + HALF);
    }
    public static Integer registerCorrosionIntForFull(Integer startCorrosionPoints) {
        registerCorrosionIntForFull(startCorrosionPoints + FULL);
        return registerCorrosionIntForFull(startCorrosionPoints + FULL);
    }
    public static Integer registerCorrosionIntForOverflowed(Integer startCorrosionPoints) {
        registerCorrosionIntForOverflowed(startCorrosionPoints + NONE);
        return registerCorrosionIntForOverflowed(startCorrosionPoints + NONE);
    }
    public static CorrosionPoints withCorrosionForNone(Integer corrosion) {
        return getCorrosionInHalf();
    }
    public static CorrosionPoints withCorrosionForHalf(Integer corrosion) {
       return getCorrosionInFull();
    }
    public static CorrosionPoints withCorrosionForFull(Integer corrosion) {
     return getCorrosionInZero();
    }
}
