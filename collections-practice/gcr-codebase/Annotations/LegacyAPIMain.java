package Annotations;

class LegacyAPI {

    @Deprecated
    void oldFeature() {
        System.out.println("This is the old feature (Deprecated)");
    }

    void newFeature() {
        System.out.println("This is the new and improved feature");
    }
}

public class LegacyAPIMain {
    public static void main(String[] args) {

        LegacyAPI api = new LegacyAPI();

        api.oldFeature();   //  Deprecated method
        api.newFeature();   // Recommended method
    }
}

