package LambdaExpressions;

@FunctionalInterface
interface LightAction {
    void active();
}

public class SmartHomeLighting {

    public static void main(String[] args) {

        LightAction motionTrigger = () ->
                System.out.println("Light turn on at full brightness due to motion.");

        LightAction nightMode = () ->
                System.out.println("Light set to dim mode at night.");

        LightAction voiceCommands = () ->
                System.out.println("Lights changed to warm ambience by voice command.");

        activateLight(motionTrigger);
        activateLight(nightMode);
        activateLight(voiceCommands);
    }

    static void activateLight(LightAction action) {
        action.active();
    }
}
